package com.furballwear.apps.pugrz.activities;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;

import android.content.Intent;
import android.os.AsyncTask;

import android.support.v4.app.DialogFragment;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;


import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.adapters.EventPostAdapter;

import com.furballwear.apps.pugrz.api.DbApi;

import com.furballwear.apps.pugrz.model.RecordRequest;
import com.furballwear.apps.pugrz.model.RecordResponse;
import com.furballwear.apps.pugrz.model.RecordsResponse;

import com.furballwear.apps.pugrz.utils.IAppConstants;


import com.furballwear.apps.pugrz.utils.PrefUtil;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.Calendar;


public class EventPost extends BaseActivity {

    ImageButton btnDatePicker, btnTimePicker;
    private ProgressDialog progressDialog;
    private EditText gTitle, gShortdes;
       EventPostAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
        progressDialog = new ProgressDialog(EventPost.this);
        progressDialog.setMessage(getString((R.string.loading_message)));




        gTitle = (EditText) findViewById(R.id.etgtitle);
        gShortdes = (EditText) findViewById(R.id.etgshortdes);
        btnDatePicker = (ImageButton) findViewById(R.id.btnDatePicker);
        btnTimePicker = (ImageButton) findViewById(R.id.btnTimePicker);
        final Spinner spinnergt = (Spinner) findViewById(R.id.gametype);
        final Spinner spinnergs = (Spinner) findViewById(R.id.gamestyle);

        Button createeventbtn = (Button) findViewById(R.id.createevent);
        createeventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameItem0 = gTitle.getText().toString();
                String gameItem1 = gShortdes.getText().toString();
                String gameItem2 = spinnergs.getSelectedItem().toString();
                String gameItem3 = spinnergt.getSelectedItem().toString();
                String gameItem4 = String.valueOf(((TextView) findViewById(R.id.textViewlocation)).getText());
                String gameItem5 = String.valueOf(((TextView) findViewById(R.id.textViewtime)).getText());
                String gameItem6 = String.valueOf(((TextView) findViewById(R.id.textViewdate)).getText());


                if(gameItem0.length()==0){
                    Toast.makeText(EventPost.this, getText(R.string.task_blank), Toast.LENGTH_SHORT).show();
                }
                else {

                    CreateRecordTask addGameItem = new CreateRecordTask();

                    addGameItem.execute(gameItem0, gameItem1, gameItem2, gameItem3, gameItem4, gameItem5, gameItem6);

                }
            }


        });


      //  progressDialog = new ProgressDialog(EventPost.this);
    }

    public void picklocation(View v) throws GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {

        int PLACE_PICKER_REQUEST = 1;
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        Context context = getApplicationContext();
        startActivityForResult(builder.build(context), PLACE_PICKER_REQUEST);


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int PLACE_PICKER_REQUEST = 1;
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);

                String toastMsg = String.format("%s", place.getLatLng());


                TextView textViewloc = (TextView) findViewById(R.id.textViewlocation);
                textViewloc.setText(toastMsg);

            }
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            String myear = String.valueOf(year);
            String mmonth = String.valueOf(month +1);
            String mday = String.valueOf(day);

            String mydate = (myear + "-" + mmonth + "-" + mday);
            //  Toast.makeText(getActivity(),mydate,Toast.LENGTH_LONG).show();
            TextView textdate = (TextView) getActivity().findViewById(R.id.textViewdate);
            textdate.setText(mydate);
        }
    }


    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));

        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            final String hour = (String.valueOf(hourOfDay));
            final String minut = (String.valueOf(minute));
            String texttime = (hour + ":" + minut);
            //  Toast.makeText(getActivity(),texttime,Toast.LENGTH_LONG).show();
            TextView textviewtime = (TextView) getActivity().findViewById(R.id.textViewtime);
            textviewtime.setText(texttime);

        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    protected void log(String message) {
        System.out.println("log: " + message);
    }


    class CreateRecordTask extends AsyncTask<String, Void, RecordResponse>{
        private String errorMsg;

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected RecordResponse doInBackground(String... params) {
            String gameItem0 = params[0];
            String gameItem1 = params[1];
            String gameItem2 = params[2];
            String gameItem3 = params[3];
            String gameItem4 = params[4];
            String gameItem5 = params[5];
            String gameItem6 = params[6];
            RecordRequest record = new RecordRequest();
            record.setName(gameItem0);
            record.setShortdes(gameItem1);
            record.setGametype(gameItem3);
            record.setGamestyle(gameItem2);
            record.setGamedate(gameItem6);
            record.setGametime(gameItem5);
            record.setGlocation(gameItem4);
            DbApi dbApi = new DbApi();
            dbApi.setBasePath(dsp_url);
            dbApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_TODOANGULAR);
            dbApi.addHeader("X-DreamFactory-Session-Token", session_id);
            try {
				/* You cant pass an id in this method just yet hmmm*/
                RecordResponse resultRecord = dbApi.createRecord(IAppConstants.TABLE_TODO, "123", record, null, null, null,null);

                resultRecord.setName(gameItem0);
                resultRecord.setShortdes(gameItem1);
                resultRecord.setGametype(gameItem3);
                resultRecord.setGamestyle(gameItem2);
                resultRecord.setGamedate(gameItem6);
                resultRecord.setGametime(gameItem5);
                resultRecord.setGlocation(gameItem4);
                log(resultRecord.toString());
                return resultRecord;
            } catch (Exception e) {
                e.printStackTrace();
                errorMsg = e.getMessage();
            }
            return null;


        }
        @Override
        protected void onPostExecute(RecordResponse record) {
            progressDialog.cancel();

            if(record != null){
              //  adapter.addTask(record);
             //   adapter.notifyDataSetChanged();
                finish();
            }else {
                Toast.makeText(EventPost.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        }



    }
}





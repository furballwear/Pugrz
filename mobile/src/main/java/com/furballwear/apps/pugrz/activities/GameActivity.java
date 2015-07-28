package com.furballwear.apps.pugrz.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.furballwear.apps.pugrz.adapters.GameAdapter;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.api.DbApi;
import com.furballwear.apps.pugrz.model.RecordRequest;
import com.furballwear.apps.pugrz.model.RecordResponse;
import com.furballwear.apps.pugrz.model.RecordsResponse;
import com.furballwear.apps.pugrz.utils.PrefUtil;

public class GameActivity extends AppCompatActivity {
	private Button buttonAdd,buttonLogout;
	private EditText editTextAddTask;
	private ListView list_view;
	private ProgressDialog progressDialog;
	private GameAdapter adapter = null;
	protected String dsp_url;
	protected String session_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		dsp_url = PrefUtil.getString(this, IAppConstants.DSP_URL);
		dsp_url += IAppConstants.DSP_URL_SUFIX;
		session_id = PrefUtil.getString(this, IAppConstants.SESSION_ID);
		progressDialog = new ProgressDialog(GameActivity.this);
		progressDialog.setMessage(getString((R.string.loading_message)));
		list_view = (ListView) findViewById(R.id.list_view_strik_text);
		editTextAddTask = (EditText) findViewById(R.id.editText_add_task);
		buttonAdd = (Button) findViewById(R.id.btnButton);
		buttonLogout = (Button)findViewById(R.id.btnLogout);
		buttonAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String task = editTextAddTask.getText().toString();
				if(task.length()==0){
					Toast.makeText(GameActivity.this, getText(R.string.task_blank), Toast.LENGTH_SHORT).show();
				}
				else {
					CreateRecordTask addToDoItem = new CreateRecordTask();
					addToDoItem.execute(task);
				}
			}
		});

		GetRecordsTask listItem = new GetRecordsTask();
		listItem.execute();
	}
	protected void log(String message) {
		System.out.println("log: " + message);
	}

	class GetRecordsTask extends AsyncTask<Void, RecordsResponse, RecordsResponse>{
		private String errorMsg;

		@Override
		protected void onPreExecute() {
			progressDialog.show();
		}

		@Override
		protected RecordsResponse doInBackground(Void... params) {
			DbApi dbApi = new DbApi();
			dbApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_PUGRZ);
			dbApi.addHeader("X-DreamFactory-Session-Token", session_id);
			dbApi.setBasePath(dsp_url);
			try {
				RecordsResponse records = dbApi.getRecords(IAppConstants.TABLE_TODO,null,null,-1,-1,null,null,false,false,null,null,true,null);
				log(records.toString());
				return records;
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg = e.getMessage();
			}
			return null;
		}
		@Override
		protected void onPostExecute(RecordsResponse records) {
			if(progressDialog != null && progressDialog.isShowing()){
				progressDialog.cancel();
			}
			if(records != null){ // success
				adapter = new GameAdapter(GameActivity.this, records.getRecord());
				list_view.setAdapter(adapter);
			}else{ // some error show dialog
				Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();

			}
		}
	}

	class CreateRecordTask extends AsyncTask<String, Void, RecordResponse>{
		private String errorMsg;

		@Override
		protected void onPreExecute() {
			progressDialog.show();
		}

		@Override
		protected RecordResponse doInBackground(String... params) {
			String todoItem = params[1];
			RecordRequest record = new RecordRequest();
			record.setTittle(todoItem);

			DbApi dbApi = new DbApi();
			dbApi.setBasePath(dsp_url);
			dbApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_PUGRZ);
			dbApi.addHeader("X-DreamFactory-Session-Token", session_id);
			try {
				/* You cant pass an id in this method just yet hmmm*/ 
				RecordResponse resultRecord = dbApi.createRecord(IAppConstants.TABLE_TODO, "123", record, null, null, null,null);
				resultRecord.setTittle(todoItem);
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
				adapter.addTask(record);
				adapter.notifyDataSetChanged();
				editTextAddTask.setText("");
			}else {				
				Toast.makeText(GameActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
			}
		}
	}
}


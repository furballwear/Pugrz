package com.furballwear.apps.pugrz.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.furballwear.apps.pugrz.api.UserApi;
import com.furballwear.apps.pugrz.client.ApiException;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.model.Register;
import com.furballwear.apps.pugrz.model.Success;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountCreate extends BaseActivity {
private  EditText editTextEmail,editTextfname,editTextlname,editTextdname,editTextPassword,editTextPassword2;
private Button btnSubmitCreateLogin;
    private static int SESSION_ID;
    private ProgressDialog progressDialog;
    private String dspUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/roman_sd.ttf");
        setContentView(R.layout.activity_account_create);
        progressDialog = new ProgressDialog(AccountCreate.this);
        progressDialog.setMessage(getText(R.string.loading_message));

        dspUrl = "http://www.primetruckinginc.com:8080";

      editTextEmail = (EditText) findViewById(R.id.etemail);
        editTextEmail.setTypeface(typeface);
        editTextPassword = (EditText) findViewById(R.id.etpassword);
        editTextPassword.setTypeface(typeface);
        editTextfname = (EditText) findViewById(R.id.etfirstname);
        editTextfname.setTypeface(typeface);
        editTextlname = (EditText) findViewById(R.id.etlastname);
        editTextlname.setTypeface(typeface);
        editTextdname = (EditText) findViewById(R.id.etdisplayname);
        editTextdname.setTypeface(typeface);
        editTextPassword2 = (EditText) findViewById(R.id.etpassword2);


        btnSubmitCreateLogin = (Button) findViewById(R.id.button_submit_create);
        btnSubmitCreateLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEntries().equals(true)) {

                    AccountTask accountTask = new AccountTask();
                    accountTask.execute();
                }

            }
        });
    }


    public Boolean isValidEntries(){
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();
        String First_name = editTextfname.getText().toString();
        String Last_name = editTextlname.getText().toString();
        String Display_name = editTextdname.getText().toString();
        String Password2 = editTextPassword2.getText().toString();

        if(Email.length()==0){
            Toast.makeText(AccountCreate.this, getText(R.string.id_null), Toast.LENGTH_LONG).show();
            return false;
        }else if(Password.length()==0){
            Toast.makeText(AccountCreate.this,getText(R.string.pw_null),Toast.LENGTH_LONG).show();
            return false;
        }else if(Password2.length()==0){
            Toast.makeText(AccountCreate.this,getText(R.string.pw_null),Toast.LENGTH_LONG).show();
            return false;
        }else if(First_name.length()==0){
            Toast.makeText(AccountCreate.this,getText(R.string.id_fname),Toast.LENGTH_LONG).show();
            return false;
        }else if(Last_name.length()==0){
            Toast.makeText(AccountCreate.this,getText(R.string.id_lname),Toast.LENGTH_LONG).show();
            return false;
        }else if(Display_name.length()==0){
            Toast.makeText(AccountCreate.this,getText(R.string.id_null),Toast.LENGTH_LONG).show();
            return false;
        }else if(Password.compareTo(Password2) != 0) {

            Toast.makeText(AccountCreate.this,getText(R.string.pw_null2),Toast.LENGTH_LONG).show();
            return false;
        } else {

            return true;
        }
    }

    class AccountTask extends AsyncTask<Void, Void, String>{
        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                pugrzreg();
                PrefUtil.putString(getApplicationContext(), IAppConstants.DSP_URL, dspUrl);
                PrefUtil.putString(getApplicationContext(), IAppConstants.SESSION_ID, session_id);


            } catch (Exception e) {
                return e.getMessage();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String errorMessage) {
            PrefUtil.putString(getApplicationContext(), IAppConstants.EMAIL, editTextEmail.getText().toString());

            progressDialog.cancel();
            Toast.makeText(AccountCreate.this,"Account Created" ,Toast.LENGTH_LONG).show();
            if (errorMessage !=null){
                String errorMsg = "";
                try {
                    JSONObject jObj = new JSONObject(errorMsg);
                    JSONArray jArray = jObj.getJSONArray("error");
                    JSONObject obj = jArray.getJSONObject(0);
                    errorMsg = obj.getString("message");
                } catch (JSONException e) {
                    errorMsg = null;
                }
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AccountCreate.this);
                alertDialog.setTitle("Message...").setMessage(errorMsg).setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                   public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
            else {
              //  Intent in= new Intent(AccountCreate.this,LoginActivity.class);
             //   startActivity(in);
               finish();
            }
        }

    }

    /**
     * This is a df user Api example. It explains how to use user api by using sdk model classes
     *
     */
    private String pugrzreg() throws ApiException {



        // create path and map variables
        UserApi userApi = new UserApi();
        userApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_PUGRZ);
        userApi.setBasePath(dspUrl + IAppConstants.DSP_URL_SUFIX);
        Register register = new Register();
        register.setEmail(editTextEmail.getText().toString());
        register.setFirst_name(editTextfname.getText().toString());
        register.setLast_name(editTextlname.getText().toString());
        register.setDisplay_name(editTextdname.getText().toString());
        register.setNew_password(editTextPassword.getText().toString());
        register.setCode("");
        Success success = userApi.register(true,register);
        return session_id;

            }







}


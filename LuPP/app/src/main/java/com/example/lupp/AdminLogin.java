package com.example.lupp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;

public class AdminLogin extends AppCompatActivity {

    private EditText etusername, etpassword;
    private Button btnlogin;
    private TextView tvreg;
    private ParseContent parseContent;
    private final int LoginTask = 1;
    private PreferenceHelper preferenceHelper;
    Button adlogin;

    //MENU
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent2 = new Intent(AdminLogin.this, MainActivity.class);
                startActivity(intent2);
                return true;

            case R.id.admin:
                Intent intent1 = new Intent(AdminLogin.this, AdminLogin.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        parseContent = new ParseContent(this);
        preferenceHelper = new PreferenceHelper(this);

        etusername = (EditText) findViewById(R.id.adname);
        etpassword = (EditText) findViewById(R.id.adpassword);
        btnlogin = (Button) findViewById(R.id.loginbtn);

       /// tvreg = (TextView) findViewById(R.id.tvreg);





        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    login();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void login() throws IOException, JSONException {

        if (!Utils.isNetworkAvailable(AdminLogin.this)) {
            Toast.makeText(AdminLogin.this, "Internet is required!", Toast.LENGTH_SHORT).show();
            return;
        }
        Utils.showSimpleProgressDialog(AdminLogin.this);
        final HashMap<String, String> map = new HashMap<>();
        map.put(Constants.Params.USERNAME, etusername.getText().toString());
        map.put(Constants.Params.PASSWORD, etpassword.getText().toString());
        new AsyncTask<Void, Void, String>(){
            protected String doInBackground(Void[] params) {
                String response="";
                try {
                    HttpRequest req = new HttpRequest(Constants.ServiceType.ADMINLOGIN);
                    response = req.prepare(HttpRequest.Method.POST).withData(map).sendAndReadString();
                } catch (Exception e) {
                    response=e.getMessage();
                }
                return response;
            }
            protected void onPostExecute(String result) {
                //do something with response
                Log.d("newwwss", result);
                onTaskCompleted(result,LoginTask);
            }
        }.execute();
    }

    private void onTaskCompleted(String response,int task) {
        Log.d("responsejson", response.toString());
        Utils.removeSimpleProgressDialog();  //will remove progress dialog
        switch (task) {
            case LoginTask:
                if (parseContent.isSuccess(response)) {
                    parseContent.saveInfo(response);
                    Toast.makeText(AdminLogin.this, "Admin Login Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminLogin.this, UploadPdf.class);
                    ////intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    this.finish();
                } else {
                    Toast.makeText(AdminLogin.this, parseContent.getErrorMessage(response), Toast.LENGTH_SHORT).show();
                }
        }

    }
}


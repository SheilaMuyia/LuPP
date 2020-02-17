package com.example.lupp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.annotation.StringDef;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Courses2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    public static final String PDF_FETCH_URL = "http://192.168.43.247:80/AndroidUpload/getPdfs.php";
    //Image request code
    private int PICK_PDF_REQUEST = 1;
    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;
    //Uri to store the image uri
    private Uri filePath;
    //ListView to show the fetched Pdfs from the server
    ListView listView;
    //button to fetch the intiate the fetching of pdfs.
    Button buttonFetch;
    Button bict2;
    //Progress bar to check the progress of obtaining pdfs
    ProgressDialog progressDialog;
    //an array to hold the different pdf objects
    ArrayList<Pdf> pdfList= new ArrayList<Pdf>();
    //pdf adapter
    PdfAdapter pdfAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses2);

        //initializing ListView
        listView = (ListView) findViewById(R.id.listView);

        //initializing buttonFetch
        buttonFetch = (Button) findViewById(R.id.compsci);
        bict2 = (Button) findViewById(R.id.bict);
        //initializing progressDialog

        progressDialog = new ProgressDialog(this);

        //Setting clicklistener

        buttonFetch.setOnClickListener(this);
        bict2.setOnClickListener(this);///this crefers to implement onclick in current class



        //setting listView on item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Pdf pdf = (Pdf) parent.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(pdf.getUrl()));
                startActivity(intent);

            }
        });


    }



    /*
     * This is the method responsible for pdf upload
     * We need the full pdf path and the name for the pdf in this method
     * */






    //method to show file chooser


    //handling the ima chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

        }
    }


    //Requesting permission


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onClick(View v) {
        if(v==buttonFetch){
            getPdfs();
        }
        if (v == bict2){
            getbict2();
        }

    }
    //onebict fetchpdfs
    private void getbict2() {


        progressDialog.setMessage("Loading PastPapers... Please Wait");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, PDF_FETCH_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            Toast.makeText(Courses2.this,obj.getString("message"), Toast.LENGTH_SHORT).show();

                            JSONArray jsonArray = obj.getJSONArray("twobict");

                            for(int i=0;i<jsonArray.length();i++){

                                //Declaring a json object corresponding to every pdf object in our json Array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //Declaring a Pdf object to add it to the ArrayList  pdfList
                                Pdf pdf  = new Pdf();
                                String pdfName = jsonObject.getString("PdfName");
                                String pdfUrl = jsonObject.getString("PdfURL");
                                String year = jsonObject.getString("year");
                                String unitname = jsonObject.getString("unitname");
                                String unitcode = jsonObject.getString("unitcode");
                                String lecturer =  jsonObject.getString("lecturer");
                                pdf.setName(pdfName);
                                pdf.setUrl(pdfUrl);
                                pdf.setYear(year);
                                pdf.setUnitname(unitname);
                                pdf.setUnitcode(unitcode);
                                pdf.setLecturer(lecturer);
                                pdfList.add(pdf);


                            }

                            pdfAdapter=new PdfAdapter(Courses2.this,R.layout.listlayout, pdfList);

                            listView.setAdapter(pdfAdapter);

                            pdfAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        RequestQueue request = Volley.newRequestQueue(this);
        request.add(stringRequest);

    }

    //onecompsci fetchpdf
    private void getPdfs() {

        progressDialog.setMessage("Loading PastPapers... Please Wait");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, PDF_FETCH_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            Toast.makeText(Courses2.this,obj.getString("message"), Toast.LENGTH_SHORT).show();

                            JSONArray jsonArray = obj.getJSONArray("twocompsci");

                            for(int i=0;i<jsonArray.length();i++){

                                //Declaring a json object corresponding to every pdf object in our json Array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //Declaring a Pdf object to add it to the ArrayList  pdfList
                                Pdf pdf  = new Pdf();
                                String pdfName = jsonObject.getString("PdfName");
                                String pdfUrl = jsonObject.getString("PdfURL");
                                String year = jsonObject.getString("year");
                                String unitname = jsonObject.getString("unitname");
                                String unitcode = jsonObject.getString("unitcode");
                                String lecturer =  jsonObject.getString("lecturer");
                                pdf.setName(pdfName);
                                pdf.setUrl(pdfUrl);
                                pdf.setYear(year);
                                pdf.setUnitname(unitname);
                                pdf.setUnitcode(unitcode);
                                pdf.setLecturer(lecturer);
                                pdfList.add(pdf);


                            }

                            pdfAdapter=new PdfAdapter(Courses2.this,R.layout.listlayout, pdfList);

                            listView.setAdapter(pdfAdapter);

                            pdfAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        RequestQueue request = Volley.newRequestQueue(this);
        request.add(stringRequest);

    }

}


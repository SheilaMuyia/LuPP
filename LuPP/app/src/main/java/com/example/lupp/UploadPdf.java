package com.example.lupp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;
import java.util.UUID;

public class UploadPdf extends AppCompatActivity {

    Button SelectButton, UploadButton;


    EditText Year, Unitcode,Unitname, Coursename, Lecturer;

    Uri uri;

    public static final String PDF_UPLOAD_HTTP_URL = "http://192.168.43.252:80/AndroidUpload/file_upload.php";

    public int PDF_REQ_CODE = 1;

    String PdfNameHolder, PdfPathHolder, PdfID;
    String YearNameHolder;/// YearPathHolder, YearID;
    String UnitcodeHolder; ///UnitCoursePathHolder, UnitCourseID;
    String UnitNameHolder; ///UnitNamePathHolder, UNitNameID;
    String LecturerNameHolder;///LecturerPathHolder, LecturerID;

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
                Intent intent2 = new Intent(UploadPdf.this, MainActivity.class);
                startActivity(intent2);
                return true;

            case R.id.admin:
                Intent intent1 = new Intent(UploadPdf.this, AdminLogin.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdf);

        AllowRunTimePermission();

        SelectButton = (Button) findViewById(R.id.button);
        UploadButton = (Button) findViewById(R.id.button2);

        Year = (EditText)findViewById(R.id.year);
        Unitcode = (EditText)findViewById(R.id.unitcode);
        Unitname  = (EditText)findViewById(R.id.unitname);
        Coursename = (EditText)findViewById(R.id.editText);
        Lecturer = (EditText)findViewById(R.id.lecturer);


        SelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // PDF selection code start from here .

                Intent intent = new Intent();

                intent.setType("application/pdf");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PDF_REQ_CODE);

            }
        });

        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PdfUploadFunction();

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PDF_REQ_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();

            SelectButton.setText("Document is Selected");
        }
    }

    public void PdfUploadFunction() {

        PdfNameHolder = Coursename.getText().toString().trim();
        YearNameHolder = Year.getText().toString().trim();
        UnitNameHolder = Unitname.getText().toString().trim();
        UnitcodeHolder = Unitcode.getText().toString().trim();
        LecturerNameHolder = Lecturer.getText().toString().trim();



        PdfPathHolder = FilePath.getPath(this, uri);

        if (PdfPathHolder == null) {

            Toast.makeText(this, "Please move your PDF file to internal storage & try again.", Toast.LENGTH_LONG).show();

        } else {

            try {

                PdfID = UUID.randomUUID().toString();

                new MultipartUploadRequest(this, PdfID, PDF_UPLOAD_HTTP_URL)
                        .addFileToUpload(PdfPathHolder, "pdf")
                        .addParameter("name", PdfNameHolder)
                        .addParameter("year",YearNameHolder)
                        .addParameter("unitname", UnitNameHolder)
                        .addParameter("unitcode", UnitcodeHolder)
                        .addParameter("lecturer",LecturerNameHolder)
                        .setNotificationConfig(new UploadNotificationConfig())
                        .setMaxRetries(5)
                        .startUpload();

            } catch (Exception exception) {

                Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void AllowRunTimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(UploadPdf.this, Manifest.permission.READ_EXTERNAL_STORAGE))
        {

            Toast.makeText(UploadPdf.this,"READ_EXTERNAL_STORAGE permission Access Dialog", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(UploadPdf.this,new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] Result) {

        switch (RC) {

            case 1:

                if (Result.length > 0 && Result[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(UploadPdf.this,"Permission Granted", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(UploadPdf.this,"Permission Canceled", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}

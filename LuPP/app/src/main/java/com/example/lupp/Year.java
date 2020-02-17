package com.example.lupp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Year extends AppCompatActivity {
    private PreferenceHelper preferenceHelper;

    //menu
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
                Intent intent2 = new Intent(Year.this, MainActivity.class);
                startActivity(intent2);
                return true;

            case R.id.admin:
                Intent intent1 = new Intent(Year.this, AdminLogin.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        Button year1 = (Button) findViewById(R.id.yr1);
        Button year2 = (Button) findViewById(R.id.yr2);
        Button year3 = (Button) findViewById(R.id.yr3);
        Button year4 = (Button) findViewById(R.id.yr4);
      Button  btnlogout = (Button) findViewById(R.id.btn);
        preferenceHelper = new PreferenceHelper(this);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceHelper.putIsLogin(false);
                Intent intent = new Intent(Year.this,MainActivity.class);
                /// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Year.this.finish();
            }
        });
        year1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Year.this, Courses.class);
                startActivity(intent);
            }
        });

        year2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Year.this, Courses2.class);
                startActivity(intent);
            }
        });

        year3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Year.this, Courses3.class);
                startActivity(intent);
            }
        });

        year4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Year.this, Courses4.class);
                startActivity(intent);
            }
        });
    }
}

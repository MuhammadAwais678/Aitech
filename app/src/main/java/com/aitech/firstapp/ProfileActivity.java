package com.aitech.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameChange = findViewById(R.id.nameChange);
        Bundle b = getIntent().getExtras();


        nameChange.setText(b.getString("Name"));
        //Toast.makeText(this,b.getString("Name"),Toast.LENGTH_LONG).show();
        FancyToast.makeText(this,b.getString("Name").toString(),FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();

    }
}
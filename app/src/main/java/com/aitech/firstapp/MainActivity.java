package com.aitech.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button onClick;
    private TextView txtEmail,txtName;
    private EditText edtEmail,edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClick = findViewById(R.id.click);
        txtEmail = findViewById(R.id.txtEmail);
        txtName = findViewById(R.id.txtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtName = findViewById(R.id.edtName);


        onClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEmail.setText(edtEmail.getText());
                 txtName.setText(edtName.getText());
                //Toast.makeText(MainActivity.this,"Succesfully",Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                i.putExtra("Name",edtName.getText().toString());
                startActivity(i);
                finish();
                edtEmail.setText("");
                edtName.setText("");
            }
        });

    }
}
package com.aitech.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancytoastlib.FancyToast;

public class GameActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnreset;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findIds();

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDialog();
            }
        });

    }

    private void findIds(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnreset = findViewById(R.id.btnreset);
    }

    public void check(View view){
        Button bronc = (Button) view;
        if(bronc.getText().toString().equals("")){
            count++;
            if(flag==0){
                bronc.setText("X");
                flag = 1;
            }else{
                bronc.setText("O");
                flag = 0;
            }

            if(count>4){
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //Conditions

                if(b1.equals(b2)&&b2.equals(b3)&&!b1.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b1,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b4.equals(b5)&&b5.equals(b6)&&!b4.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b4,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b7.equals(b8)&&b8.equals(b9)&&!b7.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b7,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b1.equals(b4)&&b4.equals(b7)&&!b1.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b1,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b2.equals(b5)&&b5.equals(b8)&&!b2.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b2,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b3.equals(b6)&&b6.equals(b9)&&!b3.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b3,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b1.equals(b5)&&b5.equals(b9)&&!b1.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b1,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(b3.equals(b5)&&b5.equals(b7)&&!b3.equals("")){
                    FancyToast.makeText(this,"Winner is: "+b3,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }else if(count == 9){
                    FancyToast.makeText(this,"Game is Drawn!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newGame();
                        }
                    },3000);
                }
            }
        }
    }

    public void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        count = 0;

    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setMessage("Do you want to reset this game?");
        builder.setTitle("Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes",(DialogInterface.OnClickListener)(dialog,which)->{
            newGame();
            FancyToast.makeText(GameActivity.this,"The Game is Reset",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
        });

        builder.setNegativeButton("No",(DialogInterface.OnClickListener)(dialog,which)->{
            dialog.cancel();
            FancyToast.makeText(GameActivity.this,"Cancel operation",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
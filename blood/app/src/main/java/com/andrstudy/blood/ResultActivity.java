package com.andrstudy.blood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView TextViewTile = findViewById(R.id.TextViewTitle);

        Button resultOK = (Button) findViewById(R.id.buttonOK);
        resultOK.setOnClickListener(this);
        Button resultNG = (Button) findViewById(R.id.buttonNG);
        resultNG.setOnClickListener(this);

        setResult(MainActivity.RESULT_NG);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        if (message != null) {
            TextViewTile.setText(message);
        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonOK){
            Log.i("Result", "OK");
            Intent data = new Intent();
            data.putExtra("result", "만족");
            setResult(MainActivity.RESULT_OK, data);
            finish();
        }else if(v.getId() == R.id.buttonNG){
            Intent data = new Intent();
            data.putExtra("result", "불만족");
            setResult(MainActivity.RESULT_OK, data);
            finish();
        }

    }
}

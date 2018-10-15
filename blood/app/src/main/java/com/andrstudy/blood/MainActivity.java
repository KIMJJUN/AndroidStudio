package com.andrstudy.blood;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQ_NUM = 1;
    public static final int RESULT_OK = 11;
    public static final int RESULT_NG = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resultA = (Button) findViewById(R.id.buttonA);
        resultA.setOnClickListener(this);
        Button resultB = (Button) findViewById(R.id.buttonB);
        resultB.setOnClickListener(this);
        Button resultO = (Button) findViewById(R.id.buttonO);
        resultO.setOnClickListener(this);
        Button resultAB = (Button) findViewById(R.id.buttonAB);
        resultAB.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQ_NUM){
            if(resultCode == RESULT_OK){
                if(data != null) {
                    String result = data.getStringExtra("result");
                    if(result != null) Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    else Toast.makeText(this, "null result", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(this, "null data", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(this, "Result NG", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonA) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "A형");
            startActivityForResult(intent,REQ_NUM);
        } else if (v.getId() == R.id.buttonB) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "B형");
            startActivityForResult(intent,REQ_NUM);
        } else if (v.getId() == R.id.buttonO) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "O형");
            startActivityForResult(intent,REQ_NUM);

        } else if (v.getId() == R.id.buttonAB) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "AB형");
            startActivityForResult(intent,REQ_NUM);
        }
    }
}

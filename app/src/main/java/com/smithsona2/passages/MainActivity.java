package com.smithsona2.passages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonView1;
    private Button mButtonView2;
    private Button mButtonView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonView1 = findViewById(R.id.button1);
        mButtonView2 = findViewById(R.id.button2);
        mButtonView3 = findViewById(R.id.button3);

        mButtonView1.setOnClickListener(view -> {
            Intent intent = new Intent(this, ReaderActivity.class);
            intent.putExtra("passage", 1);
            startActivity(intent);
        });
        mButtonView2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ReaderActivity.class);
            intent.putExtra("passage", 2);
            startActivity(intent);
        });
        mButtonView3.setOnClickListener(view -> {
            Intent intent = new Intent(this, ReaderActivity.class);
            intent.putExtra("passage", 3);
            startActivity(intent);
        });

    }
}
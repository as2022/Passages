package com.smithsona2.passages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.textView);
        int resource;

        switch (intent.getIntExtra("passage", -1)){
            case 1:
                resource = R.raw.gettysburg_address;
                break;
            case 2:
                resource = R.raw.jfk_inaugural_address;
                break;
            case 3:
                resource = R.raw.tragedy_of_darth_plageuis_the_wise;
                break;
            default:
                Toast.makeText(this, "Passage Not Found", Toast.LENGTH_LONG);
                resource = -1;
                finish();
        }
        InputStream inputStream = getResources().openRawResource(resource);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String passageToDisplay = "";
        try {
            while((line = br.readLine()) != null) { // <--------- place readLine() inside loop
                passageToDisplay += (line + "\n"); // <---------- add each line to entireFile
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        textView.setText(passageToDisplay);
    }
}
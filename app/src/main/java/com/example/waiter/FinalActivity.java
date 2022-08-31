package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView text = (TextView) findViewById(R.id.textPrice);
        text.setText("585.0"+ Html.fromHtml(" &#x20bd"));
    }
}
package com.example.customlistviewsearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        getSupportActionBar().hide();
        TextView shapes=findViewById(R.id.shapeName);
        ImageView shapeImage=findViewById(R.id.shapeImage);
        Intent getData= getIntent();
        String text= getData.getStringExtra("shapeName");
        int resource=getData.getIntExtra("imageResource",0);
        shapes.setText(text);
        shapeImage.setImageResource(resource);

    }
}
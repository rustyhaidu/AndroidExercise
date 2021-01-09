package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    String url = "https://miro.medium.com/max/512/1*FnIRsTtFtaFGdhInO4e83g.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.loadImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get()
                        .load(url)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(imageView);
            }
        });


    }
}
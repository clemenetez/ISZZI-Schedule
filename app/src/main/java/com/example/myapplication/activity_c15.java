package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class activity_c15 extends AppCompatActivity {

    ImageView image1,image2,image3,image4,image5,image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c15);
        image2 = findViewById(R.id.image_sh2);
        image1=findViewById(R.id.image_sh1);
        image3 = findViewById(R.id.image_sh3);
        image4=findViewById(R.id.image_sh4);
        image5 = findViewById(R.id.image_sh5);
        image6=findViewById(R.id.image_sh6);
        String url1 = "https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule150.jpg.jpg?alt=media&token=48e0b54a-94b3-46c9-ab35-994804ca4ef4";
        String url2 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule151.jpg.jpg?alt=media&token=2e7337f8-7629-44ea-adc5-35600e899404";
        String url3 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule152.jpg.jpg?alt=media&token=d12ddd7f-0971-48f4-a6b6-ba1e2454ad74";
        String url4 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule153.jpg.jpg?alt=media&token=599a465b-a923-4b01-8d56-8928b5578670";
        String url5 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule154.jpg.jpg?alt=media&token=29d63ca4-f4a5-4236-824a-a3d4ef64f557";
        String url6 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule155.jpg.jpg?alt=media&token=72a1e57c-b9dd-4cdf-82c7-f0af6a134577";
        Glide.with(getApplicationContext()).load(url1).into(image1);
        Glide.with(getApplicationContext()).load(url2).into(image2);
        Glide.with(getApplicationContext()).load(url3).into(image3);
        Glide.with(getApplicationContext()).load(url4).into(image4);
        Glide.with(getApplicationContext()).load(url5).into(image5);
        Glide.with(getApplicationContext()).load(url6).into(image6);













    }
    protected void onDestroy() {
        // Очистка кеша Glide
        Glide.get(this).clearMemory();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Очистка кеша Glide в фоновом потоке для избежания ANR
                Glide.get(getApplicationContext()).clearDiskCache();
            }
        }).start();

        // Другие действия очистки кеша (если необходимо)

        super.onDestroy();
    }


}
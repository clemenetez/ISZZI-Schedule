package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class activity_c34 extends AppCompatActivity {

    ImageView image1,image2,image3,image4,image5,image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c34);
        image2 = findViewById(R.id.image_sh2);
        image1=findViewById(R.id.image_sh1);
        image3 = findViewById(R.id.image_sh3);
        image4=findViewById(R.id.image_sh4);
        image5 = findViewById(R.id.image_sh5);
        image6=findViewById(R.id.image_sh6);
        String url1 = "https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule340.jpg.jpg?alt=media&token=c96b3c32-25f7-4249-8dbd-5c1ff2b7e396";
        String url2 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule341.jpg.jpg?alt=media&token=dfbba433-b4b8-47bb-b7ac-491158a67f8a";
        String url3 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule342.jpg.jpg?alt=media&token=a23cf50c-1e4b-499e-bd17-49fa51e3b720";
        String url4 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule343.jpg.jpg?alt=media&token=6abb8e11-b87b-48a0-b293-c0e4bae665b5";
        String url5 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule344.jpg.jpg?alt=media&token=490483a7-c032-4f77-9d01-196c23fe9250";
        String url6 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule345.jpg.jpg?alt=media&token=8d1a6001-1ae6-4434-b56a-689f6ab7597a";
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
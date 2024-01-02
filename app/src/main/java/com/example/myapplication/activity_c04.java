package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class activity_c04 extends AppCompatActivity {

    ImageView image1,image2,image3,image4,image5,image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c04);
        image2 = findViewById(R.id.image_sh2);
        image1=findViewById(R.id.image_sh1);
        image3 = findViewById(R.id.image_sh3);
        image4=findViewById(R.id.image_sh4);
        image5 = findViewById(R.id.image_sh5);
        image6=findViewById(R.id.image_sh6);
        String url1 = "https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule040.jpg.jpg?alt=media&token=20071c20-e628-4311-b50c-4a0f51651070";
        String url2 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule041.jpg.jpg?alt=media&token=43cec9e0-1294-44a7-97cf-54a4e4b774b0";
        String url3 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule042.jpg.jpg?alt=media&token=19b809fc-2e8e-4ab7-89d2-e0f0efad5a42";
        String url4 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule043.jpg.jpg?alt=media&token=164c905d-8b7b-47e1-b0b5-161566ad566a";
        String url5 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule044.jpg.jpg?alt=media&token=cd295f66-b7dd-436a-b464-80b38ab3912c";
        String url6 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule045.jpg.jpg?alt=media&token=a3ed1c95-b9e5-4333-9157-47946cdc72c1";
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
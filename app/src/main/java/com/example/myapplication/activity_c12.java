package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class activity_c12 extends AppCompatActivity {

    ImageView image1,image2,image3,image4,image5,image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c12);
        image2 = findViewById(R.id.image_sh2);
        image1=findViewById(R.id.image_sh1);
        image3 = findViewById(R.id.image_sh3);
        image4=findViewById(R.id.image_sh4);
        image5 = findViewById(R.id.image_sh5);
        image6=findViewById(R.id.image_sh6);
        String url1 = "https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule120.jpg.jpg?alt=media&token=24b74492-ef73-4593-9340-1a66172932f9";
        String url2 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule121.jpg.jpg?alt=media&token=b4d1abb8-98e0-42ee-aba1-b6293c0ac258";
        String url3 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule122.jpg.jpg?alt=media&token=9abacdda-a573-414d-9e41-894267998bf9";
        String url4 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule123.jpg.jpg?alt=media&token=fbc9aa3d-4e8a-4d06-b110-da6a6ac3693a";
        String url5 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule124.jpg.jpg?alt=media&token=3f6ed513-dca8-4dfc-abe2-8ef361994e2a";
        String url6 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule125.jpg.jpg?alt=media&token=114ab53a-e5fe-47e9-ba8a-817a4658cc18";
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
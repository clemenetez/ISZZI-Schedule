package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class activity_c02 extends AppCompatActivity {

    ImageView image1,image2,image3,image4,image5,image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c02);
        image2 = findViewById(R.id.image_sh2);
        image1=findViewById(R.id.image_sh1);
        image3 = findViewById(R.id.image_sh3);
        image4=findViewById(R.id.image_sh4);
        image5 = findViewById(R.id.image_sh5);
        image6=findViewById(R.id.image_sh6);
        String url1 = "https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule020.jpg.jpg?alt=media&token=f069e757-4757-4941-b21c-296423ca00bf";
        String url2 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule021.jpg.jpg?alt=media&token=c5ab3e80-ed90-422d-9454-42f86235e67b";
        String url3 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule022.jpg.jpg?alt=media&token=c836a730-666f-4fb4-ad5b-f6de20bb02ac";
        String url4 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule023.jpg.jpg?alt=media&token=bbdcd22b-338f-48aa-81f7-3751c26ef6f9";
        String url5 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule024.jpg.jpg?alt=media&token=e9330b28-d9c9-4fb7-adfc-33572797a4c0";
        String url6 ="https://firebasestorage.googleapis.com/v0/b/isszi-schedule.appspot.com/o/schedule%2Fschedule025.jpg.jpg?alt=media&token=9cbf4f5a-2fe5-4cc6-aa4c-039a993fccc8";
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
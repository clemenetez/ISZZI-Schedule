package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText groupNumber;
    ImageButton imageButton;
    Button  buttonDone,buttonLoad,buttonUnload;
    private static final String FILE_NAME = "group_file.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageButton=findViewById(R.id.imageButton);
        groupNumber = findViewById(R.id.numbergroup);
        buttonLoad=findViewById(R.id.buttonLo);
        buttonDone = findViewById(R.id.buttonDone);
        buttonUnload=findViewById(R.id.buttonUn);

        String savedGroup = readFromFile();
        switch (savedGroup) {
            case "25":
                goToC25();
                break;
            case "24":
                goToC24();
                break;
            case "23":
                goToC23();
                break;
            case "22":
                goToC22();
                break;
            case "ilushkadrokdrok7":
                goToSecret();
                break;
            case "21":
                goToC21();
                break;
            case "31":
                goToC31();
                break;
            case "32":
                goToC32();
                break;
            case "33":
                goToC33();
                break;
            case "34":
                goToC34();
                break;
            case "35":
                goToC35();
                break;
            case "11":
                goToC11();
                break;
            case "12":
                goToC12();
                break;
            case "13":
                goToC13();
                break;
            case "14":
                goToC14();
                break;
            case "15":
                goToC15();
                break;

            case "01":
                goToC01();
                break;
            case "02":
                goToC02();
                break;
            case "03":
                goToC03();
                break;
            case "04":
                goToC04();
                break;
            case "05":
                goToC05();
                break;
            case "91":
                goToC91();
                break;
            case "92":
                goToC92();
                break;
            case "93":
                goToC93();
                break;

        }


        groupNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    // Викликайте функції або виконуйте дії, які вам потрібно
                    if (isNetworkAvailable()) {
                        String groupText = groupNumber.getText().toString();
                        switch (groupText) {
                            case "25":
                                goToC25();
                                break;
                            case "24":
                                goToC24();
                                break;
                            case "23":
                                goToC23();
                                break;
                            case "22":
                                goToC22();
                                break;
                            case "ilushkadrokdrok7":
                                goToSecret();
                                break;
                            case "21":
                                goToC21();
                                break;
                            case "31":
                                goToC31();
                                break;
                            case "32":
                                goToC32();
                                break;
                            case "33":
                                goToC33();
                                break;
                            case "34":
                                goToC34();
                                break;
                            case "35":
                                goToC35();
                                break;
                            case "11":
                                goToC11();
                                break;
                            case "12":
                                goToC12();
                                break;
                            case "13":
                                goToC13();
                                break;
                            case "14":
                                goToC14();
                                break;
                            case "15":
                                goToC15();
                                break;

                            case "01":
                                goToC01();
                                break;
                            case "02":
                                goToC02();
                                break;
                            case "03":
                                goToC03();
                                break;
                            case "04":
                                goToC04();
                                break;
                            case "05":
                                goToC05();
                                break;
                            case "91":
                                goToC91();
                                break;
                            case "92":
                                goToC92();
                                break;
                            case "93":
                                goToC93();
                                break;

                            default:
                                // Виводимо снекбар, який повідомить про правильність введення номера групи
                                Snackbar.make(findViewById(android.R.id.content), "Неправильний номер групи", Snackbar.LENGTH_SHORT).show();
                                break;
                        }
                    } else {
                        showNoInternetSnackbar();
                    }
                    return true; // Повернення true позначає, що подія була оброблена
                }
                return false; // Повернення false, якщо подія не була оброблена
            }
        });
buttonLoad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String groupText = groupNumber.getText().toString();
        writeToFile(groupText);
    }
});
        buttonUnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFile();
                Snackbar.make(findViewById(android.R.id.content), "Номер групи стерто", Snackbar.LENGTH_SHORT).show();
            }
        });
        groupNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupNumber.setText("");
            }
        });


        groupNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    groupNumber.setText("");
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInfo();
            }
        });

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()) {
                    String groupText = groupNumber.getText().toString();
                    switch (groupText) {
                        case "25":
                            goToC25();
                            break;
                        case "24":
                            goToC24();
                            break;
                        case "23":
                            goToC23();
                            break;
                        case "22":
                            goToC22();
                            break;
                        case "ilushkadrokdrok7":
                            goToSecret();
                            break;
                        case "21":
                            goToC21();
                            break;
                        case "31":
                            goToC31();
                            break;
                        case "32":
                            goToC32();
                            break;
                        case "33":
                            goToC33();
                            break;
                        case "34":
                            goToC34();
                            break;
                        case "35":
                            goToC35();
                            break;
                        case "11":
                            goToC11();
                            break;
                        case "12":
                            goToC12();
                            break;
                        case "13":
                            goToC13();
                            break;
                        case "14":
                            goToC14();
                            break;
                        case "15":
                            goToC15();
                            break;

                        case "01":
                            goToC01();
                            break;
                        case "02":
                            goToC02();
                            break;
                        case "03":
                            goToC03();
                            break;
                        case "04":
                            goToC04();
                            break;
                        case "05":
                            goToC05();
                            break;
                        case "91":
                            goToC91();
                            break;
                        case "92":
                            goToC92();
                            break;
                        case "93":
                            goToC93();
                            break;

                        default:
                            // Виводимо снекбар, який повідомить про правильність введення номера групи
                            Snackbar.make(findViewById(android.R.id.content), "Неправильний номер групи", Snackbar.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    showNoInternetSnackbar();
                }
            }
        });


    }

    private void showNoInternetSnackbar() {
        Snackbar.make(findViewById(android.R.id.content),
                "Немає з'єднання з інтернетом ", Snackbar.LENGTH_SHORT).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }


public void goToSecret(){
        Intent intentSecret = new Intent(this, activity_secret.class);
        startActivity(intentSecret);
}
    public void goToC25() {
        Intent intent25 = new Intent(this, activity_c25.class);
        startActivity(intent25);
    }
    public void goToC24(){
        Intent intent24 = new Intent(this, activity_c24.class);
        startActivity(intent24);
    }
    public void goToC23(){
        Intent intent23 = new Intent(this, activity_c23.class);
        startActivity(intent23);
    }
    public void goToC22(){
        Intent intent22 = new Intent(this, activity_c22.class);
        startActivity(intent22);
    }
    public void goToC21(){
        Intent intent21 = new Intent(this, activity_c21.class);
        startActivity(intent21);
    }
    public void goToC31(){
        Intent intent31 = new Intent(this, activity_c31.class);
        startActivity(intent31);
    }

    public void goToC32(){
        Intent intent32 = new Intent(this, activity_c32.class);
        startActivity(intent32);
    }

    public void goToC33(){
        Intent intent33 = new Intent(this, activity_c33.class);
        startActivity(intent33);
    }

    public void goToC34(){
        Intent intent34 = new Intent(this, activity_c34.class);
        startActivity(intent34);
    }

    public void goToC35(){
        Intent intent35 = new Intent(this, activity_c35.class);
        startActivity(intent35);
    }
    public void goToC11(){
        Intent intent11 = new Intent(this, activity_c11.class);
        startActivity(intent11);
    }
    public void goToC12(){
        Intent intent12 = new Intent(this, activity_c12.class);
        startActivity(intent12);
    }
    public void goToC13(){
        Intent intent13 = new Intent(this, activity_c13.class);
        startActivity(intent13);
    }

    public void goToC14(){
        Intent intent14 = new Intent(this, activity_c14.class);
        startActivity(intent14);
    }

    public void goToC15(){
        Intent intent15 = new Intent(this, activity_c15.class);
        startActivity(intent15);
    }

    public void goToC01(){
        Intent intent01 = new Intent(this, activity_c01.class);
        startActivity(intent01);
    }

    public void goToC02(){
        Intent intent02 = new Intent(this, activity_c02.class);
        startActivity(intent02);
    }
public void goToInfo(){
        Intent IntentInfo= new Intent(this, activity_quest.class);
        startActivity(IntentInfo);
}
    public void goToC03(){
        Intent intent03 = new Intent(this, activity_c03.class);
        startActivity(intent03);
    }
    public void goToC04(){
        Intent intent04 = new Intent(this, activity_c04.class);
        startActivity(intent04);
    }

    public void goToC05(){
        Intent intent05 = new Intent(this, activity_c05.class);
        startActivity(intent05);
    }
    public void goToC91(){
        Intent intent91 = new Intent(this, activity_c91.class);
        startActivity(intent91);
    }
    public void goToC92(){
        Intent intent92 = new Intent(this, activity_c92.class);
        startActivity(intent92);
    }
    public void goToC93(){
        Intent intent93 = new Intent(this, activity_c93.class);
        startActivity(intent93);
    }


    private void writeToFile(String data) {
        // Додайте перевірку на введення лише допустимих значень
        if (isValidInput(data)) {
            try {
                FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                osw.write(data);
                osw.close();
                Snackbar.make(findViewById(android.R.id.content), "Номер групи успішно записаний", Snackbar.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Неправильне значення для запису номеру вашої групи", Snackbar.LENGTH_SHORT).show();
        }
    }

    private boolean isValidInput(String input) {
        // Додайте код для перевірки, чи введене значення є допустимим
        String[] validValues = {"01", "02", "03", "04", "05", "11", "12", "13", "14", "15", "21", "22", "23", "24", "25", "31", "32", "33", "34", "35", "91", "92", "93"};
        return Arrays.asList(validValues).contains(input);
    }

    private String readFromFile() {
        String result = "";
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    private void clearFile() {
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
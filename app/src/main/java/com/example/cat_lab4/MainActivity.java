package com.example.cat_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    TextView catDedscription;
    View colorBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catDedscription = findViewById(R.id.catDescr);
        colorBox = findViewById(R.id.colorBox);

        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.age = 7;
        murzik.color = Color.YELLOW;

        String output = "";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(murzik);

        Cat murzik2 = new Cat();
        murzik2 = gson.fromJson(json, Cat.class);

        output = "Кот: " + murzik2.name +", " + murzik2.age + " лет, цвет:" ;
        catDedscription.setText(output);
        colorBox.setBackgroundColor(murzik2.color);

    }
}
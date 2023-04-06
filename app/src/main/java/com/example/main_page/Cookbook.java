package com.example.main_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Cookbook extends AppCompatActivity {

    private Button vegan;
    private Button christmas;
    private Button healthy;
    private Button italian;
    private Button meat;
    private Button quick;
    private Button sweet;
    private Button vegetarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook);

        vegan = (Button) findViewById(R.id.buttonvegan);
        vegan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { openVegan();  }
        });

        christmas = (Button) findViewById(R.id.button_christmas);
        christmas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openChristmas();
            }
    });

        healthy = (Button) findViewById(R.id.button_healthy);
        healthy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openHealthy();
            }
        });

        italian = (Button) findViewById(R.id.button_italian);
        italian.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openItalian();
            }
        });

        meat = (Button) findViewById(R.id.button_meat_lovers);
        meat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMeat();
            }
        });

        quick = (Button) findViewById(R.id.button_quick);
        quick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openQuick();
            }
        });

        sweet = (Button) findViewById(R.id.button_sweet);
        sweet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openSweet();
            }
        });

        vegetarian = (Button) findViewById(R.id.button_vegetarian);
        vegetarian.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openVegetarian();
            }
        });

    }

    private void openVegetarian(){
        Intent vegetarian = new Intent(this,Vegetarian.class);
        startActivity(vegetarian);
    }

    private void openSweet(){
        Intent sweet = new Intent(this, Sweet.class);
        startActivity(sweet);
    }

    private void openQuick(){
        Intent quick = new Intent(this, Quick.class);
        startActivity(quick);
    }

    private void openMeat(){
        Intent meat = new Intent(this, Meatlovers.class);
        startActivity(meat);
    }

    private void openItalian(){
        Intent italian = new Intent(this, Italian.class);
        startActivity(italian);
    }

    private void openHealthy() {
        Intent healthy = new Intent(this, Healthy.class);
        startActivity(healthy);
    }

    private void openChristmas() {
        Intent christmas = new Intent(this, Christmas.class);
        startActivity(christmas);}

        private void openVegan () {
            Intent gotovegan = new Intent(this, Vegan.class);
            startActivity(gotovegan);
        }

    }

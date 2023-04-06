package com.example.main_page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonpantry;
    private Button buttonlist;
    private Button buttoncook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonpantry = (Button) findViewById(R.id.button_pantry);
        buttonpantry.setOnClickListener(new View.OnClickListener() {

            @Override
           public void onClick(View v) {
                openPantry();
            }
        });

        buttonlist = (Button) findViewById(R.id.button_list);
        buttonlist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openList();
            }
        });

        buttoncook = (Button) findViewById(R.id.button_cook);
        buttoncook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openCook();
            }
        });

    }


    public void openPantry() {
        Intent gotopantry = new Intent(this, Pantry.class);
        startActivity(gotopantry);
    }

    public void openList() {
        Intent gotolist= new Intent(this, ShoppingList1.class);
        startActivity(gotolist);
    }

    public void openCook() {
        Intent gotocook= new Intent(this, Cookbook.class);
        startActivity(gotocook);
    }

}
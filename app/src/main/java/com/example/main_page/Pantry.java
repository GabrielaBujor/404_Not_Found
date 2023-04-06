package com.example.main_page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

public class Pantry extends AppCompatActivity {
    private ListView LV;
    private Button Btn;
    private Button button_save;
    private EditText text;
    private static ArrayList<String> food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);
        LV = findViewById(R.id.idLVfood);
        Btn = findViewById(R.id.idBtnAdd);
        button_save = findViewById(R.id.Btnsave);
        text = findViewById(R.id.idEdtItemName);

        loadData();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, food);

        LV.setAdapter(adapter);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = text.getText().toString();

                if (!item.isEmpty()) {

                    food.add(item);

                    adapter.notifyDataSetChanged();

                    saveStringToPreferences(String.valueOf(text.getText()));
                }

            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        LV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;

                new AlertDialog.Builder(Pantry.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setMessage("Do you want to delete this entry?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                food.remove(itemToDelete);
                                adapter.notifyDataSetChanged();

                                HashSet<String> set = new HashSet(Pantry.food);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

                return true;
            }

        });
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(food);
        editor.putString("food", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("food", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        food = gson.fromJson(json, type);

        if(food == null){
            food = new ArrayList<>();
        }

    }

    public void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String previousText = preferences.getString("label", null);
        if(!TextUtils.isEmpty(previousText)){
            food.add(text.getText().toString());
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, food);
            adapter.notifyDataSetChanged();
        }
    }

    private void saveStringToPreferences(String str) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("label", str);
        editor.apply();
    }
}
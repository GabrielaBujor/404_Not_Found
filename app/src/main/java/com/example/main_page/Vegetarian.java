package com.example.main_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Vegetarian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian);
        WebView webview = (WebView) findViewById(R.id.webview2);
        webview.loadUrl("file:///android_asset/Vegetarian.html");
    }
}
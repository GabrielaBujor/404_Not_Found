package com.example.main_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Vegan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);
        WebView webview = (WebView) findViewById(R.id.webview2);
        webview.loadUrl("file:///android_asset/Vegan.html");
    }
}
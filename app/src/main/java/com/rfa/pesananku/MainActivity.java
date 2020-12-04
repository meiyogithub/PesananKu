package com.rfa.pesananku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuCafe(View view) {
        Intent keMenu = new Intent(MainActivity.this, MenuCafe.class);
        startActivity(keMenu);
    }

    public void keOrderList(View view) {
        Intent keOrderList = new Intent(MainActivity.this, ListOrder.class);
        startActivity(keOrderList);
    }
}
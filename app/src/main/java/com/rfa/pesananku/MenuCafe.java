package com.rfa.pesananku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCafe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cafe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void keMakanan(View view) {
        Intent moveMakanan = new Intent(MenuCafe.this,Makanan.class);
        startActivity(moveMakanan);
    }

    public void keMinuman(View view) {
        Intent moveMinuman= new Intent(MenuCafe.this,Minuman.class);
        startActivity(moveMinuman);
    }

    public void keDessert(View view) {
        Intent moveDessert = new Intent(MenuCafe.this,Dessert.class);
        startActivity(moveDessert);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
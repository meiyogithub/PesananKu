package com.rfa.pesananku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatPesanan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    EditText ned1, ned2, ned3, ned4, ned5;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pesanan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dbHelper = new DataHelper(this);
        ned1 = (EditText) findViewById(R.id.et_nomorMeja);
        ned2 = (EditText) findViewById(R.id.et_tgl);
        ned3 = (EditText) findViewById(R.id.et_namaMenu);
        ned4 = (EditText) findViewById(R.id.et_jam);
        ned5 = (EditText) findViewById(R.id.et_harga);
        btn1 = (Button) findViewById(R.id.button);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pesanan WHERE tgl = '" +
                getIntent().getStringExtra("nama") + "'" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ned1.setText(cursor.getString(0).toString());
            ned2.setText(cursor.getString(1).toString());
            ned3.setText(cursor.getString(2).toString());
            ned2.setText(cursor.getString(3).toString());
            ned3.setText(cursor.getString(4).toString());
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pesanan (nomorMeja, tgl, menu, jam, harga) values('" +
                        ned1.getText().toString() + "','" +
                        ned2.getText().toString() + "','" +
                        ned3.getText().toString() + "','" +
                        ned4.getText().toString() + "','" +
                        ned5.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil" ,
                        Toast.LENGTH_LONG).show();
                ListOrder.lo.RefreshList();
                finish();

                Intent keList = new Intent(BuatPesanan.this,ListOrder.class);
                startActivity(keList);

            }
        } );
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
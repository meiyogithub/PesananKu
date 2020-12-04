package com.rfa.pesananku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbpesanan.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pesanan(nomorMeja integer primary key, tgl date, menu text, jam integer, harga integer)");
        db.execSQL("INSERT INTO pesanan (nomorMeja, tgl, menu, jam, harga) VALUES (1, '2020-12-4', 'Chesse Cake', 19.00, 40000)");
        db.execSQL("INSERT INTO pesanan (nomorMeja, tgl, menu, jam, harga) VALUES (2, '2020-12-5', 'Nasi Goreng', 15.00, 50000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE pesanan");
        onCreate(db);
    }
}
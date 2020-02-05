package com.shayan.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;


public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="users";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="product_users";
    public static final String ID="id";
    public static final String USERNAME="username";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String PHONE="phone";



String tableQuery="CREATE TABLE "+TABLE_NAME + "("+ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
        USERNAME+" TEXT,"+EMAIL+" TEXT,"+PASSWORD+" TEXT,"+PHONE+" INTEGER)";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(tableQuery);
    }
    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert(TABLE_NAME,null,contentValues);


    }
    public boolean readUser(String username, String password){
        String readStatement="SELECT COUNT(*) FROM"+TABLE_NAME+" WHERE "+USERNAME+"="+username+" AND "+
                PASSWORD+"="+ password;
        SQLiteStatement sqLiteStatement=getReadableDatabase().compileStatement(readStatement);
        long l=sqLiteStatement.simpleQueryForLong();
        if (l==1){
            return true;
        }
        else {
            return false;
        }



    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

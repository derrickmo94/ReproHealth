package com.example.hericxon.reprohealth.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by HERICXON on 06-Jun-18.
 */

public class UserDb  extends SQLiteOpenHelper {

    private final static int    DB_VERSION = 10;
    public static final String DATABASE_NAME = "myApp.db";

    public UserDb(Context context) {
        super(context, DATABASE_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "create table logins (userId integer autoincrement," +
                "username text not null, useremail text primary key not null, userphone text not null," +
                "userpassword text primary key not null, photo blob)";
        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        try{
            System.out.println("UPGRADE DB oldVersion="+oldVersion+" - newVersion="+newVersion);
            database.execSQL("DROP TABLE IF EXISTS logins");
            onCreate(database);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public long insertUser (String UserName, String UserEmail, String UserPhone, String UserPassword,Bitmap Photo){
        SQLiteDatabase database = this.getWritableDatabase();
        byte[] PhotoData = bitmapAsByteArray(Photo);
        ContentValues values = new ContentValues();
        values.put("username",UserName);
        values.put("useremail", UserEmail);
        values.put("userphone", UserPhone);
        values.put("userpassword",UserPassword);
        values.put("photo", (byte[]) null);
        long resultid = database.insert("logins", null, values);
        database.close();
        return resultid;
    }

    public int updateLogins (String UserName, String UserEmail, String UserPhone, String UserPassword){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username",UserName);
        values.put("useremail", UserEmail);
        values.put("userphone", UserPhone);
        values.put("userpassword",UserPassword);
        //database.insert("logins", null, values);
        int count = database.update("logins", values, "useremail = ?", new String[] {String.valueOf(UserEmail)});
        database.close();
        return count;
    }

    public int updatePhoto(Bitmap Photo,String loggedinEmail){
        SQLiteDatabase database = this.getWritableDatabase();
        byte[] PhotoData = bitmapAsByteArray(Photo);
        ContentValues values = new ContentValues();
        values.put("photo",PhotoData);
        int count = database.update("logins", values, "useremail = ?", new String[] {String.valueOf(loggedinEmail)});
        database.close();
        return count;
    }

    public Cursor getUser (String UserPassword, String UserEmail){
        String query = "Select * from logins where userpassword ='"+UserPassword+"'and useremail= '"+UserEmail+"'";
        SQLiteDatabase database = this.getReadableDatabase();

        return database.rawQuery(query, null);
    }

    public  static byte[] bitmapAsByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        return stream.toByteArray();
    }
}
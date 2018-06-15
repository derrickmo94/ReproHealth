package com.example.hericxon.reprohealth.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * Created by HERICXON on 06-Jun-18.
 */

public class UserDb  extends SQLiteOpenHelper {
private static final String TAG ="USER DB CLASS";
    private final static int    DB_VERSION = 10;
    public static final String DATABASE_NAME = "myApp.db";

    public UserDb(Context context) {
        super(context, DATABASE_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "create table logins (userId integer auto increment," +
                "username text not null, useremail text primary key not null, userphone text not null," +
                "userpassword text not null, photo blob)";
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

    public boolean userExists(String existingEmail){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor=null;
        String query ="select useremail from logins where useremail ='"+existingEmail+"'";
        cursor =database.rawQuery(query,null);
        boolean exists;
        if(cursor.getCount()>0){
            exists =true;
        }else {
            exists = false;
        }
        return exists;
    }

    public long insertUser (String UserName, String UserEmail, String UserPhone, String UserPassword){
        long resultid = 0;
        try {
            SQLiteDatabase database = this.getWritableDatabase();

            // byte[] PhotoData = bitmapAsByteArray(Photo);
            ContentValues values = new ContentValues();
            values.put("username", UserName);
            values.put("useremail", UserEmail);
            values.put("userphone", UserPhone);
            values.put("userpassword", UserPassword);
            // values.put("photo", (byte[]) null);
           resultid = database.insert("logins", null, values);
            database.close();

        }catch (Exception e){
            Log.e(TAG,"Error of type: " +e.getMessage());
        }finally {
            return resultid;
        }

    }

    public int updateLogins (String UserName, String UserEmail, String UserPhone, String UserPassword,String LoggedEmail){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username",UserName);
        values.put("useremail", UserEmail);
        values.put("userphone", UserPhone);
        values.put("userpassword",UserPassword);
        //database.insert("logins", null, values);
        int count = database.update("logins", values, "useremail = ?", new String[] {String.valueOf(LoggedEmail)});
        database.close();
        return count;
    }

    public int updatePhoto(Bitmap Photo,String LoggedEmail){
        SQLiteDatabase database = this.getWritableDatabase();
        byte[] PhotoData = bitmapAsByteArray(Photo);
        ContentValues values = new ContentValues();
        values.put("photo",PhotoData);
        int count = database.update("logins", values, "useremail = ?", new String[] {String.valueOf(LoggedEmail)});
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
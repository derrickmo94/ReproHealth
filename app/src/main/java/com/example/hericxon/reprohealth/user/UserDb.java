package com.example.hericxon.reprohealth.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        String query = "create table logins (userId Integer primary key autoincrement," +
                "username text, useraddress text,useremail text, userphone text, userpassword text)";
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

    public boolean insertUser (String UserName, String UserAddress,String UserEmail, String UserPhone, String UserPassword ){
        boolean valid;
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",UserName);
        values.put("useraddress", UserAddress);
        values.put("useremail", UserEmail);
        values.put("userphone", UserPhone);
        values.put("userpassword",UserPassword);
        long results = database.insert("logins", null, values);
        if(results != -1 ){
            valid =   true;
            database.close();
        }else{
            valid =false;
        }
        return valid;
    }

    public int updateLogins (String UserName, String UserAddress,String UserEmail, String UserPhone, String UserPassword){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",UserName);
        values.put("useraddress", UserAddress);
        values.put("useremail", UserEmail);
        values.put("userphone", UserPhone);
        values.put("userpassword",UserPassword);
        database.insert("logins", null, values);
        return database.update("logins", values, "useremail = ?", new String[] {String.valueOf(UserEmail)});
    }

    public Cursor getUser (String UserPassword, String UserEmail){
        //boolean valid =true;
        String query = "Select * from logins where userpassword ='"+UserPassword+"'and username= '"+UserEmail+"'";
        //UserCredentials myUser = new UserCredentials(0,username,"");
        SQLiteDatabase database = this.getReadableDatabase();

       /* if(cursor.getCount()<=0){
            database.close();
            valid = false;
        } else{
            database.close();
            valid= true;
        }*/
        return database.rawQuery(query, null);
    }
}
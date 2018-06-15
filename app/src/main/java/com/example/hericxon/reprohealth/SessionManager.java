package com.example.hericxon.reprohealth;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.TextView;

import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.user.LoginActivity;

/**
 * Created by HERICXON on 12-Jun-18.
 */

public class SessionManager {
    public SharedPreferences sharedpref;
    public SharedPreferences.Editor editor;

    private static final String USER_PREFERENCES ="userPref";
    public static final String USER_NAME = "userName";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_PASS ="userPass";
    public static final  String USER_PHONE ="userPhone";
    public static final String IS_LOGIN = "isLoggedin";
    Context context;

    public SessionManager(Context context){
        this.context = context;
        sharedpref = context.getSharedPreferences(USER_PREFERENCES,context.MODE_PRIVATE);
        editor =sharedpref.edit();

    }

    public void slogin(String name, String email, String phone, String pass){

        editor.putBoolean(IS_LOGIN, true);
        editor.putString(USER_NAME,name);
        editor.putString(USER_EMAIL,email);
        editor.putString(USER_PHONE,phone);
        editor.putString(USER_PASS,pass);
        editor.commit();
    }

    public boolean isLoggedIn(){

        return sharedpref.getBoolean(IS_LOGIN,false);
    }

    public void scheckLogin() {

        if (!this.isLoggedIn()) {
        Intent login = new Intent(context, LoginActivity.class);
        login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(login);
        }/*else{
            Intent back = new Intent(context,current);
            back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(back);
        }*/

    }


    public void sgetUser(TextView name,TextView email,TextView phone,TextView pass){

        name.setText(sharedpref.getString(USER_NAME,"anonomus"));
        email.setText(sharedpref.getString(USER_EMAIL,"anonomus"));
        phone.setText(sharedpref.getString(USER_PHONE,"anonomus"));
        pass.setText(sharedpref.getString(USER_PASS,"*********"));
    }

    public void sgetNavData(/*TextView name,TextView email*/NavigationView navigationView){
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.validuser_name_id);
        TextView navUseremail = headerView.findViewById(R.id.validuser_email_id);

        navUsername.setText(sharedpref.getString(USER_NAME,"anonomus"));
        navUseremail.setText(sharedpref.getString(USER_EMAIL,"anonomus"));
    }

    public void slogOut(){
        editor.clear();
        editor.commit();
        Intent login = new Intent(context,LoginActivity.class);
        login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(login);
    }
}


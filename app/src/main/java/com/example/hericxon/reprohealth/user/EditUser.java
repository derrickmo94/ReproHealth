package com.example.hericxon.reprohealth.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.SessionManager;


public class EditUser extends AppCompatActivity {
SessionManager logged_user;

    private static final String TAG = " EditUser";
    Button save_edit;
    UserDb userdb;
    TextView nameText_edit, mobileText_edit, emailText_edit, passwordText_edit, reEnterPasswordText_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        logged_user = new SessionManager(getApplicationContext());

        //inflating the user save_edit activity
        save_edit = findViewById(R.id.user_save_edit);
        nameText_edit = findViewById(R.id.input_name_edit);
        emailText_edit = findViewById(R.id.input_email_edit);
        mobileText_edit = findViewById(R.id.input_mobile_edit);
        passwordText_edit = findViewById(R.id.input_password_edit);
        reEnterPasswordText_edit =findViewById(R.id.input_reEnterPassword_edit);

        // save button click event handler
        save_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.onbackpressed_incoming,R.anim.onbackpressed_outgoing);
    }

    //
    public void edit() {
        userdb = new UserDb(this);
        Log.d(TAG, "Edit");

        if (!validate()) {
            save_edit.setEnabled(true);
        }else {
            save_edit.setEnabled(false);
             String name = nameText_edit.getText().toString().trim();
            String email = emailText_edit.getText().toString().trim();
            String mobile = mobileText_edit.getText().toString().trim();
            String password = passwordText_edit.getText().toString().trim();

            SharedPreferences loggedPref;
            loggedPref =getSharedPreferences("userPref",Context.MODE_PRIVATE);
            String loggedEmail = loggedPref.getString("userEmail","anonomus");


            if (loggedEmail.equals("anonomus")) {
                Toast.makeText(this, "Unable to update user profile, not logged in", Toast.LENGTH_LONG).show();
            } else {
                userdb = new UserDb(this);
                final int results = userdb.updateLogins(name, email, mobile, password, loggedEmail);

                if (results > -1) {
                    Toast.makeText(this, "sucessfully updated user profile data", Toast.LENGTH_LONG).show();
                    final Cursor validuser = userdb.getUser(password, email);
                    if((validuser.getCount()) > 0){
                        String namedb =validuser.getString(validuser.getColumnIndex("username"));
                        String emaildb = validuser.getString(validuser.getColumnIndex("useremail"));
                        String phonedb = validuser.getString(validuser.getColumnIndex("userphone"));
                        String passworddb = validuser.getString(validuser.getColumnIndex("userpassword"));

                        logged_user.editor.clear();

                        logged_user.editor.putString("userName",namedb);
                        logged_user.editor.putString("userEmail",emaildb);
                        logged_user.editor.putString("userPhone",phonedb);
                        logged_user.editor.putString("userPass",passworddb);
                        logged_user.editor.putBoolean("isLoggedin",true);
                        logged_user.editor.commit();
                    }else{
                        Log.i(TAG,"failed to commit to shared preferences");
                    }

                } else {
                    Toast.makeText(this, "Unable to upadte user profile", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    public boolean validate() {
        boolean valid = true;

        String email = emailText_edit.getText().toString();
        String password = passwordText_edit.getText().toString();
        String mobile = mobileText_edit.getText().toString();
        String reEnterPassword = reEnterPasswordText_edit.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText_edit.setError("enter a valid email address");
            valid = false;
        } else {
            emailText_edit.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText_edit.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText_edit.setError(null);
        }
        if (mobile.isEmpty() || mobile.length()!=10) {
            mobileText_edit.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            mobileText_edit.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText_edit.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText_edit.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            reEnterPasswordText_edit.setError("Password Do not match");
            valid = false;
        } else {
            reEnterPasswordText_edit.setError(null);
        }

        return valid;
    }
}

package com.example.hericxon.reprohealth.user;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hericxon.reprohealth.R;


public class EditUser extends AppCompatActivity {

    SharedPreferences sharedpref;
    public static final String USER_EMAIL = "userEmail";

    private static final String TAG = "edits";
    Button save;
    UserDb userdb;
    TextView nameText, mobileText, emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        save = findViewById(R.id.user_save_data_button);

        nameText = findViewById(R.id.text_view_user_name);
        emailText = findViewById(R.id.textview_user_email);
        mobileText = findViewById(R.id.textview_user_phone);
        passwordText = findViewById(R.id.textview_user_pass);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit();

            }
        });
    }

    public void edit() {
        userdb = new UserDb(this);
        Log.d(TAG, "Edit");

        if (!validate()) {
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(EditUser.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        final String name = nameText.getText().toString().trim();
        final String email = emailText.getText().toString().trim();
        final String mobile = mobileText.getText().toString().trim();
        final String password = passwordText.getText().toString().trim();
        //String reEnterPassword = reEnterPasswordText.getText().toString();
        sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        //name.setText(sharedpref.getString(USER_EMAIL,null));


        // TODO: Implement your own signup logic here.
        userdb = new UserDb(this);
        final long results = userdb.updateLogins(name,email,mobile,password);
    }


    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;

    }
}

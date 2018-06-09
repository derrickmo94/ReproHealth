package com.example.hericxon.reprohealth.user;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hericxon.reprohealth.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    UserDb userdb;
    //SQLiteDatabase df;
    Button signupButton;
    EditText nameText,addressText,emailText,passwordText,mobileText,reEnterPasswordText;
    TextView loginLink;

    /*@BindView(R.id.input_name)
    @BindView(R.id.input_address)
    @BindView(R.id.input_email)
    @BindView(R.id.input_mobile)
    @BindView(R.id.input_password)
    @BindView(R.id.input_reEnterPassword)
    @BindView(R.id.email_sign_in_button) Button signupButton;
    @BindView(R.id.link_login) */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

       signupButton = findViewById(R.id.email_sign_in_button);
       nameText = findViewById(R.id.input_name);
       addressText = findViewById(R.id.input_address);
       emailText = findViewById(R.id.input_email);
       mobileText = findViewById(R.id.input_mobile);
       passwordText = findViewById(R.id.input_password);
       reEnterPasswordText = findViewById(R.id.input_reEnterPassword);
       loginLink = findViewById(R.id.link_login);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = nameText.getText().toString();
        String address = addressText.getText().toString();
        String email = emailText.getText().toString();
        String mobile = mobileText.getText().toString();
        String password = passwordText.getText().toString();
        String reEnterPassword = reEnterPasswordText.getText().toString();

        // TODO: Implement your own signup logic here.
        userdb = new UserDb(this);
       final boolean results = userdb.insertUser(name,address,email,mobile,password);


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                           // onSignupSuccess();

                           // progressDialog.dismiss();

                            //onSignupFailed();

                        if(results == true){
                            onSignupSuccess();
                            progressDialog.dismiss();

                        }else{
                            onSignupFailed();
                            progressDialog.dismiss();
                        }

                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Toast.makeText(this,"Sucessfully signed up",Toast.LENGTH_SHORT).show();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name =nameText.getText().toString();
        String address =addressText.getText().toString();
        String email =emailText.getText().toString();
        String mobile =mobileText.getText().toString();
        String password =passwordText.getText().toString();
        String reEnterPassword =reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
           nameText.setError("at least 3 characters");
            valid = false;
        } else {
           nameText.setError(null);
        }

        if (address.isEmpty()) {
           addressText.setError("Enter Valid Address");
            valid = false;
        } else {
           addressText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
           emailText.setError("enter a valid email address");
            valid = false;
        } else {
           emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=10) {
           mobileText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
           mobileText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
           passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
           passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
           reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
           reEnterPasswordText.setError(null);
        }

        return valid;
    }
}
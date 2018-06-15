package com.example.hericxon.reprohealth.user;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.SessionManager;
import com.example.hericxon.reprohealth.home.MainMenu;

import butterknife.BindView;
import butterknife.ButterKnife;


    public class LoginActivity extends AppCompatActivity {

        private static final String TAG = "LoginActivity";
        private static final int REQUEST_SIGNUP = 1;
        UserDb userdb;
        SessionManager logged_user;

        @BindView(R.id.input_email) EditText _emailText;
        @BindView(R.id.input_password) EditText _passwordText;
        @BindView(R.id.btn_login) Button _loginButton;
        @BindView(R.id.link_signup) TextView _signupLink;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ButterKnife.bind(this);

            logged_user = new SessionManager(LoginActivity.this);

            _loginButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    login();
                }
            });

            _signupLink.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Start the Signup activity
                    Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                    startActivityForResult(intent, REQUEST_SIGNUP);
                    finish();
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                }
            });
        }


        public void login() {
            Log.d(TAG, "Login");

            if (!validate()) {
                onLoginFailed();
                return;
            } else {

                _loginButton.setEnabled(false);

                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();

                String email = _emailText.getText().toString();
                String password = _passwordText.getText().toString();

                // TODO: Implement your own authentication logic here.
                userdb = new UserDb(this);
                final Cursor validuser = userdb.getUser(password, email);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed
                                if (validuser.getCount() <= 0) {
                                    onLoginFailed();
                                    progressDialog.dismiss();

                                } else {
                                    onLoginSuccess();
                                    if(validuser.moveToFirst()){

                                    }
                                    String name =validuser.getString(validuser.getColumnIndex("username"));
                                    String email = validuser.getString(validuser.getColumnIndex("useremail"));
                                    String phone = validuser.getString(validuser.getColumnIndex("userphone"));
                                    String password = validuser.getString(validuser.getColumnIndex("userpassword"));

                                    logged_user.slogin(name,email,phone,password);

                                    progressDialog.dismiss();

                                    Intent login = new Intent(LoginActivity.this, MainMenu.class);
                                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(login);
                                    overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);

                                }
                            }
                        }, 3000
                );
            }
        }


            @Override
            protected void onActivityResult (int requestCode, int resultCode, Intent data){
                if (requestCode == REQUEST_SIGNUP && resultCode == RESULT_OK && data !=null) {
                        // TODO: Implement successful signup logic here
                            // By default we just finish the Activity and log them in automatically

                    _passwordText.setText(data.getStringExtra("email"));
                    _emailText.setText(data.getStringExtra("pass"));
                    _loginButton.performClick();
                     this.finish();
                    }
                }


            @Override
            public void onBackPressed () {
                // Disable going back to the MainActivity
                moveTaskToBack(true);
            }

        public void onLoginSuccess() {
            _loginButton.setEnabled(true);
            finish();
        }

        public void onLoginFailed() {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

            _loginButton.setEnabled(true);
        }

        public boolean validate() {
            boolean valid = true;

            String email = _emailText.getText().toString();
            String password = _passwordText.getText().toString();

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _emailText.setError("enter a valid email address");
                valid = false;
            } else {
                _emailText.setError(null);
            }

            if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                _passwordText.setError("between 4 and 10 alphanumeric characters");
                valid = false;
            } else {
                _passwordText.setError(null);
            }

            return valid;

        }
    }
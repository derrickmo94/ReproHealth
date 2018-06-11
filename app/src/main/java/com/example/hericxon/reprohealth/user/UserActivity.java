package com.example.hericxon.reprohealth.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hericxon.reprohealth.MythsAndFactsActivity;
import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.Relationships.RelationshipActivity;
import com.example.hericxon.reprohealth.familyPlanning.FamilyPlanningActivity;
import com.example.hericxon.reprohealth.healthCenters.ReproductiveCentersActivity;
import com.example.hericxon.reprohealth.hivAidsandStds.HivAidsStdsActivity;
import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.knowYoureBody.YourBodyActivity;
import com.example.hericxon.reprohealth.AboutActivity;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int CAMERA_REQUEST =1888;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;

    SharedPreferences sharedpref;
    public static final String USER_NAME = "userName";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_PHONE = "userPhone";
    public static final String USER_PASS = "userPass";


    TextView name,email,phone,password;
    FloatingActionButton edit,take_photo;
    ImageView user_photo;

    UserDb userdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user_photo = findViewById(R.id.user_photo);
        name = findViewById(R.id.text_view_user_name);
        email = findViewById(R.id.textview_user_email);
        phone = findViewById(R.id.textview_user_phone);
        password = findViewById(R.id.textview_user_pass);
        edit = findViewById(R.id.edit);
        take_photo =findViewById(R.id.take_photo);


        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        name.setText(sharedpref.getString(USER_NAME,null));
        email.setText(sharedpref.getString(USER_EMAIL,null));
        phone.setText(sharedpref.getString(USER_PHONE,null));
        password.setText(sharedpref.getString(USER_PASS,null));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent();
                edit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(edit);
            }
        });
        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                camera_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(camera_intent,CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            user_photo.setImageBitmap(photo);

            sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
            String useremail = email.getText().toString();
            userdb = new UserDb(this);
            userdb.updatePhoto(photo,useremail);
            Toast.makeText(this,"Sucessfully updated profile photo",Toast.LENGTH_SHORT).show();
            //View view =findViewById(R.id.drawer_layout_user);
            //showSnackbar(view,"Sucessfully updated profile photo",Snackbar.LENGTH_SHORT);
        }else
        {
            Toast.makeText(this,"error updating profile photo",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home:
                Intent home = new Intent(this,MainMenu.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                break;
            case R.id.nav_profile:
                Intent profile =new Intent(this,UserActivity.class);
                profile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profile);
                break;
            case R.id.nav_body:
                Intent body = new Intent(this,YourBodyActivity.class);
                body.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(body);
                break;
            case R.id.nav_relationship:
                Intent relationship = new Intent(this,RelationshipActivity.class);
                relationship.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(relationship);
                break;
            case R.id.nav_familyplanning:
                Intent familypanning = new Intent(this,FamilyPlanningActivity.class);
                familypanning.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(familypanning);
                break;
            case R.id.nav_HIV_STDs:
                Intent diseases = new Intent(this,HivAidsStdsActivity.class);
                diseases.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(diseases);
                break;
            case R.id.nav_reproductive_health:
                Intent centers = new Intent(this,ReproductiveCentersActivity.class);
                centers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(centers);
                break;
            case R.id.nav_myths:
                Intent stories =new Intent(this,MythsAndFactsActivity.class);
                stories.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(stories);
                break;
            case R.id.nav_about:
                Intent about = new Intent(this,AboutActivity.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                break;
        }

        drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

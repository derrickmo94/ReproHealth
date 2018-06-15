package com.example.hericxon.reprohealth.user;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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

import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.relationships.RelationshipActivity;
import com.example.hericxon.reprohealth.SearchActivity;
import com.example.hericxon.reprohealth.SessionManager;
import com.example.hericxon.reprohealth.familyplanning.FamilyPlanningActivity;
import com.example.hericxon.reprohealth.healthcenters.ReproductiveCentersActivity;
import com.example.hericxon.reprohealth.hivaidsandstds.HivAidsStdsActivity;
import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.knowyourebody.YourBodyActivity;
import com.example.hericxon.reprohealth.AboutActivity;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int CAMERA_REQUEST =1;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    private Uri mURI;
    private  String mPhotoPath;

    /*SharedPreferences sharedpref;*/
    SessionManager logged_user;

    TextView name,email,phone,password;
    FloatingActionButton edit_user,take_photo;
    ImageView user_photo;

    UserDb userdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        toolbar = findViewById(R.id.toolbar);
        user_photo = findViewById(R.id.user_photo);
        name = findViewById(R.id.text_view_user_name);
        email = findViewById(R.id.textview_user_email);
        phone = findViewById(R.id.textview_user_phone);
        password = findViewById(R.id.textview_user_pass);
        edit_user = findViewById(R.id.user_edit_btn);
        take_photo =findViewById(R.id.take_photo);
        drawer = findViewById(R.id.drawer_layout_user);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        logged_user =new SessionManager(getApplicationContext());
        logged_user.scheckLogin();
        logged_user.sgetUser(name,email,phone,password);
        logged_user.sgetNavData(navigationView);

        //handles the toggle button click events
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       //handles the navigation drawer selected item event
        navigationView.setNavigationItemSelectedListener(this);



        //handles the save_edit click event
        edit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent(UserActivity.this,EditUser.class);
                edit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(edit);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
            }
        });

        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //camera_intent.putExtra("crop","true");
               /* File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                mURI =Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"usepic.jpg"));
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,mURI);*/
                if(camera_intent.resolveActivity(getPackageManager())!=null){
                    //camera_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivityForResult(camera_intent,CAMERA_REQUEST);
                    overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                }else{
                    Toast.makeText(UserActivity.this,"No camera application installed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            user_photo.setImageBitmap(photo);
            Toast.makeText(this, "photo uploaded", Toast.LENGTH_LONG).show();
        }
            else{
                Toast.makeText(this,"photo upload failed",Toast.LENGTH_LONG).show();
               }

            //Bitmap  UserPhoto = ((BitmapDrawable) user_photo.getDrawable()).getBitmap();

            //sharedpref = PreferenceManager.getDefaultSharedPreferences(this);


            /*sharedpref = getSharedPreferences("userPref", Context.MODE_PRIVATE);
            String loggeduser = sharedpref.getString(USER_EMAIL, "anonomus");

            if ((loggeduser.equals("anonomus"))) {
                Toast.makeText(this, "error updating profile photo, not logged in photo", Toast.LENGTH_SHORT).show();
            } else {
                userdb = new UserDb(this);
                long result = userdb.updatePhoto(photo, loggeduser);
                if (result > 0) {

                    Toast.makeText(this, "Sucessfully updated profile photo", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "error updating profile photo", Toast.LENGTH_SHORT).show();
                }
            }*/
        }


    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout_user);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.onbackpressed_incoming,R.anim.onbackpressed_outgoing);
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
        if (id == R.id.action_logout) {
            SessionManager logged_user = new SessionManager(getApplicationContext());
            logged_user.slogOut();
            overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
            return true;
        }else if(id == R.id.action_search){
            Intent search = new Intent(this, SearchActivity.class);
            search.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(search);
            overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
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
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_profile:
                Intent profile =new Intent(this,UserActivity.class);
                profile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profile);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_body:
                Intent body = new Intent(this,YourBodyActivity.class);
                body.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(body);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_relationship:
                Intent relationship = new Intent(this,RelationshipActivity.class);
                relationship.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(relationship);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_familyplanning:
                Intent familypanning = new Intent(this,FamilyPlanningActivity.class);
                familypanning.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(familypanning);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_HIV_STDs:
                Intent diseases = new Intent(this,HivAidsStdsActivity.class);
                diseases.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(diseases);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_reproductive_health:
                Intent centers = new Intent(this,ReproductiveCentersActivity.class);
                centers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(centers);
                break;
            case R.id.nav_about:
                Intent about = new Intent(this,AboutActivity.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
        }

        drawer =  findViewById(R.id.drawer_layout_user);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.example.hericxon.reprohealth.knowYoureBody;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hericxon.reprohealth.MythsAndFactsActivity;
import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.AboutActivity;
import com.example.hericxon.reprohealth.familyPlanning.FamilyPlanningActivity;
import com.example.hericxon.reprohealth.hivAidsandStds.HivAidsStdsActivity;
import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.Relationships.RelationshipActivity;
import com.example.hericxon.reprohealth.healthCenters.ReproductiveCentersActivity;
import com.example.hericxon.reprohealth.user.UserActivity;

public class YourBodyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    Button sex_and_gender_btn,gender_btn,emotions_btn,sexuality_btn,fertility_btn;
    ImageButton male_imgbtn,female_imgbtn;
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_body);
        toolbar = findViewById(R.id.toolbar);

        sex_and_gender_btn=findViewById(R.id.sex_btn);
        gender_btn = findViewById(R.id.gender_btn);
        emotions_btn = findViewById(R.id.emotions_btn);
        sexuality_btn = findViewById(R.id.sex_and_sexuality_btn);
        fertility_btn = findViewById(R.id.fertilty_and_pregnancy_btn);

        male_imgbtn = findViewById(R.id.imagebutton_male);
        female_imgbtn = findViewById(R.id.imagebutton_female);

        setSupportActionBar(toolbar);

        //click listener to handle  sex and gender button click event
        male_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent male = new Intent(YourBodyActivity.this,Male.class);
                male.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(male);

            }
        });

        //click listener to handle gender identity button click event
        female_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent female;
                female = new Intent(YourBodyActivity.this,Female.class);
                female.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(female);
            }
        });

        //click listener to handle gender identity button click event
        gender_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gender_identity;
                gender_identity = new Intent(YourBodyActivity.this,GenderIdentity.class);
                gender_identity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(gender_identity);
            }
        });

        // click listener to handle  sex and gender button click event
        sex_and_gender_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gendersex;
                gendersex = new Intent(YourBodyActivity.this,SexVsGender.class);
                gendersex.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(gendersex);
            }
        });

        //click listener to handle  emotions button click event
        emotions_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emotions;
                emotions = new Intent(YourBodyActivity.this,Emotions.class);
                emotions.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(emotions);
            }
        });

        sexuality_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sexuality;
                sexuality = new Intent(YourBodyActivity.this,Sexuality.class);
               sexuality.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sexuality);
            }
        });

        fertility_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fertility;
                fertility = new Intent(YourBodyActivity.this,Fertility.class);
               fertility.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(fertility);
            }
        });


        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem  item) {
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
                Intent familyplanning = new Intent(this,FamilyPlanningActivity.class);
                familyplanning.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(familyplanning);
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

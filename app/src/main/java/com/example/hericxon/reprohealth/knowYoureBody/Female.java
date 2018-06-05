package com.example.hericxon.reprohealth.knowYoureBody;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hericxon.reprohealth.AboutActivity;
import com.example.hericxon.reprohealth.MythsAndFactsActivity;
import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.familyPlanning.FamilyPlanningActivity;
import com.example.hericxon.reprohealth.hivAidsandStds.HivAidsStdsActivity;
import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.Relationships.RelationshipActivity;
import com.example.hericxon.reprohealth.healthCenters.ReproductiveCentersActivity;
import com.example.hericxon.reprohealth.user.UserActivity;

public class Female extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Button btnpuberty,btnmenstruaion,btnovuaion,btnfemaleorgans,btnfemalehormones,
            btnmenstruationhygiene,btnmenstruationconcerns, btnmenstruationmyths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);
        toolbar = findViewById(R.id.toolbar);

        btnpuberty = findViewById(R.id.female_puberty_btn);
        btnmenstruaion = findViewById(R.id.menstruation_btn);
        btnovuaion = findViewById(R.id.ovulation_btn);
        btnfemaleorgans = findViewById(R.id.female_organs_btn);
        btnfemalehormones = findViewById(R.id.female_hormones_btn);
        btnmenstruationhygiene = findViewById(R.id.menstruation_hygiene_btn);
        btnmenstruationconcerns = findViewById(R.id.menstruation_concerns_btn);
        btnmenstruationmyths = findViewById(R.id.menstruation_myths_btn);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //onclick listeners  to handle click events for the puberty button
        btnpuberty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent femalepuberty = new Intent(Female.this,FemalePuberty.class);
                femalepuberty.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(femalepuberty);
            }
        });

        //onclick listeners  to handle click events for the puberty male organs button
        btnfemaleorgans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent femaleorgans = new Intent(Female.this,FemaleOrgans.class);
                startActivity(femaleorgans);
                femaleorgans.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the semens button
        btnovuaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ovulation = new Intent(Female.this,Ovulation.class);
                startActivity(ovulation);
                ovulation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the sperm button
        btnmenstruaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menstruation = new Intent(Female.this,Menstruation.class);
                startActivity(menstruation);
                menstruation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the male hormones button
        btnfemalehormones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent femalehormones = new Intent(Female.this,FemaleHormones.class);
                startActivity(femalehormones);
                femalehormones.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the male hormones button
        btnmenstruationhygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menstruationhygiene = new Intent(
                        Female.this,MenstruationHygiene.class);
                startActivity(menstruationhygiene);
               menstruationhygiene.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the male hormones button
        btnmenstruationconcerns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menstruationconcerns = new Intent(
                        Female.this,MenstruationConcerns.class);
                startActivity(menstruationconcerns);
                menstruationconcerns.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the male hormones button
        btnmenstruationmyths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menstruationmyths = new Intent(
                        Female.this,MenstruationMyths.class);
                startActivity(menstruationmyths);
                menstruationmyths.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
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

        return toggle.onOptionsItemSelected(item)|| super.onOptionsItemSelected(item);
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
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

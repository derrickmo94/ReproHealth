package com.example.hericxon.reprohealth.knowyourebody;

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
import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.SearchActivity;
import com.example.hericxon.reprohealth.SessionManager;
import com.example.hericxon.reprohealth.familyplanning.FamilyPlanningActivity;
import com.example.hericxon.reprohealth.hivaidsandstds.HivAidsStdsActivity;
import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.relationships.RelationshipActivity;
import com.example.hericxon.reprohealth.healthcenters.ReproductiveCentersActivity;
import com.example.hericxon.reprohealth.user.UserActivity;

public class Female extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Button btnpuberty,btnmenstruaion,btnovuaion,btnfemaleorgans,btnfemalehormones,
            btnmenstruationhygiene,btnmenstruationconcerns, btnmenstruationmyths;
    SessionManager logged_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        btnpuberty = findViewById(R.id.female_puberty_btn);
        btnmenstruaion = findViewById(R.id.menstruation_btn);
        btnovuaion = findViewById(R.id.ovulation_btn);
        btnfemaleorgans = findViewById(R.id.female_organs_btn);
        btnfemalehormones = findViewById(R.id.female_hormones_btn);
        btnmenstruationhygiene = findViewById(R.id.menstruation_hygiene_btn);
        btnmenstruationconcerns = findViewById(R.id.menstruation_concerns_btn);
        btnmenstruationmyths = findViewById(R.id.menstruation_myths_btn);
        setSupportActionBar(toolbar);

        logged_user =new SessionManager(getApplicationContext());
        logged_user.sgetNavData(navigationView);

        toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //onclick listeners  to handle click events for the puberty button
        btnpuberty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent femalepuberty = new Intent(Female.this,FemalePuberty.class);
                femalepuberty.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(femalepuberty);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
            }
        });

        //onclick listeners  to handle click events for the puberty male organs button
        btnfemaleorgans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent femaleorgans = new Intent(Female.this,FemaleOrgans.class);
                startActivity(femaleorgans);
                femaleorgans.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
            }
        });

        //onclick listeners  to handle click events for the semens button
        btnovuaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ovulation = new Intent(Female.this,Ovulation.class);
                startActivity(ovulation);
                ovulation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
            }
        });

        //onclick listeners  to handle click events for the sperm button
        btnmenstruaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menstruation = new Intent(Female.this,Menstruation.class);
                startActivity(menstruation);
                menstruation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
            }
        });

        //onclick listeners  to handle click events for the male hormones button
        btnfemalehormones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent femalehormones = new Intent(Female.this,FemaleHormones.class);
                startActivity(femalehormones);
                femalehormones.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
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
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
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
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
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
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
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
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
            case R.id.nav_about:
                Intent about = new Intent(this,AboutActivity.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                overridePendingTransition(R.anim.incomimg_activity,R.anim.outgoing_activity);
                break;
        }
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.example.hericxon.reprohealth.knowYoureBody;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
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

public class Male extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    Button btnpuberty,btnsemen,btnsperms,btnmaleorgans,btnmalehormones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);
        toolbar = findViewById(R.id.toolbar);

        btnpuberty = findViewById(R.id.puberty_btn);
        btnsemen = findViewById(R.id.semens_btn);
        btnsperms = findViewById(R.id.sperms_btn);
        btnmaleorgans = findViewById(R.id.male_organs_btn);
        btnmalehormones = findViewById(R.id.male_hormones_btn);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //onclick listeners  to handle click events for the puberty button
        btnpuberty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent puberty = new Intent(Male.this,Puberty.class);
                puberty.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(puberty);
            }
        });

        //onclick listeners  to handle click events for the puberty male organs button
        btnmaleorgans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maleorgans = new Intent(Male.this,MaleOrgans.class);
                startActivity(maleorgans);
                maleorgans.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the semens button
        btnsemen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent semens = new Intent(Male.this,Semens.class);
                startActivity(semens);
                semens.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the sperm button
        btnsperms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sperms = new Intent(Male.this,Sperms.class);
                startActivity(sperms);
                sperms.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        //onclick listeners  to handle click events for the male hormones button
        btnmalehormones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent malehormones = new Intent(Male.this,MaleHormones.class);
                startActivity(malehormones);
                malehormones.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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


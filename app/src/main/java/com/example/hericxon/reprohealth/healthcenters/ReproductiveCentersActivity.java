package com.example.hericxon.reprohealth.healthcenters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hericxon.reprohealth.R;
import com.example.hericxon.reprohealth.relationships.RelationshipActivity;
import com.example.hericxon.reprohealth.SearchActivity;
import com.example.hericxon.reprohealth.SessionManager;
import com.example.hericxon.reprohealth.familyplanning.FamilyPlanningActivity;
import com.example.hericxon.reprohealth.hivaidsandstds.HivAidsStdsActivity;
import com.example.hericxon.reprohealth.home.MainMenu;
import com.example.hericxon.reprohealth.knowyourebody.YourBodyActivity;
import com.example.hericxon.reprohealth.AboutActivity;
import com.example.hericxon.reprohealth.user.UserActivity;

public class ReproductiveCentersActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    SessionManager logged_user;
    Button btnCenter1,btnCenter2,btnCenter3,btnCenter4,btnCenter5,btnCenter6,btnCenter7,btnCenter8,
            btnCenter9,btnCenter10,btnCenter11,btnCenter12,btnCenter13,btnCenter14,btnCenter15,
            btnCenter16,btnCenter17,btnCenter18,btnCenter19,btnCenter20,btnCenter21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductive_centers);
        toolbar=findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        btnCenter1 = findViewById(R.id.btn_center1);
        btnCenter2 = findViewById(R.id.btn_center2);
        btnCenter3 = findViewById(R.id.btn_center3);
       /* btnCenter4 = findViewById(R.id.btn_center4);
        btnCenter5 = findViewById(R.id.btn_center5);
        btnCenter6 = findViewById(R.id.btn_center6);*/
        btnCenter7 = findViewById(R.id.btn_center7);
        btnCenter8 = findViewById(R.id.btn_center8);
        btnCenter9 = findViewById(R.id.btn_center9);
        btnCenter10 = findViewById(R.id.btn_center10);
        btnCenter11 = findViewById(R.id.btn_center11);
        btnCenter12 = findViewById(R.id.btn_center12);
        btnCenter13 = findViewById(R.id.btn_center13);
        btnCenter14 = findViewById(R.id.btn_center14);
        btnCenter15 = findViewById(R.id.btn_center15);
        btnCenter16 = findViewById(R.id.btn_center16);
        btnCenter17 = findViewById(R.id.btn_center17);
        btnCenter18 = findViewById(R.id.btn_center18);
        btnCenter19 = findViewById(R.id.btn_center19);
        btnCenter20 = findViewById(R.id.btn_center20);
        btnCenter21 = findViewById(R.id.btn_center21);

        btnCenter1.setOnClickListener(this);
        btnCenter2.setOnClickListener(this);
        btnCenter3.setOnClickListener(this);
       /* btnCenter4.setOnClickListener(this);
        btnCenter5.setOnClickListener(this);
        btnCenter6.setOnClickListener(this);*/
        btnCenter7.setOnClickListener(this);
        btnCenter8.setOnClickListener(this);
        btnCenter9.setOnClickListener(this);
        btnCenter10.setOnClickListener(this);
        btnCenter11.setOnClickListener(this);
        btnCenter12.setOnClickListener(this);
        btnCenter13.setOnClickListener(this);
        btnCenter14.setOnClickListener(this);
        btnCenter15.setOnClickListener(this);
        btnCenter16.setOnClickListener(this);
        btnCenter17.setOnClickListener(this);
        btnCenter18.setOnClickListener(this);
        btnCenter19.setOnClickListener(this);
        btnCenter20.setOnClickListener(this);
        btnCenter21.setOnClickListener(this);


        setSupportActionBar(toolbar);

        logged_user =new SessionManager(getApplicationContext());
        logged_user.sgetNavData(navigationView);

        toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            return true;
        }else if(id == R.id.action_search){
            Intent search = new Intent(this, SearchActivity.class);
            search.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(search);
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
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
                break;
            case R.id.nav_profile:
                Intent profile =new Intent(this,UserActivity.class);
                profile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profile);
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
                break;
            case R.id.nav_body:
                Intent body = new Intent(this,YourBodyActivity.class);
                body.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(body);
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
                break;
            case R.id.nav_relationship:
                Intent relationship = new Intent(this,RelationshipActivity.class);
                relationship.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(relationship);
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
                break;
            case R.id.nav_familyplanning:
                Intent familypanning = new Intent(this,FamilyPlanningActivity.class);
                familypanning.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(familypanning);
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
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
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
                break;
            case R.id.nav_about:
                Intent about = new Intent(this,AboutActivity.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                overridePendingTransition(R.anim.incomimg_activity, R.anim.outgoing_activity);
                break;

        }

       drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        int id = v.getId();


        switch (id){
            case R.id.btn_center1:
                Uri gmmCenterOneUri = Uri.parse("google.navigation:q=0.3360,32.5805(Reproductive+Health+Uganda)");
                Intent centerOnemapIntent = new Intent(Intent.ACTION_VIEW,gmmCenterOneUri);
                centerOnemapIntent.setPackage("com.google.android.apps.maps");
                if (centerOnemapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(centerOnemapIntent);
                }
                break;
            case R.id.btn_center2:
                Uri gmmCenter2Uri = Uri.parse("google.navigation:q=0.3506,32.5990(Womens+Hospital+International+and+Fertility+Center)");
                Intent center2mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter2Uri);
                center2mapIntent.setPackage("com.google.android.apps.maps");
                if (center2mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center2mapIntent);
                }
                break;
            case R.id.btn_center3:
                Uri gmmCenter3Uri = Uri.parse("google.navigation:q=0.3042,32.6141");
                Intent center3mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter3Uri);
                center3mapIntent.setPackage("com.google.android.apps.maps");
                if (center3mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center3mapIntent);
                }
                break;
            case R.id.btn_center7:
                Uri gmmCenter7Uri = Uri.parse("google.navigation:q=3.030330,30.907304");
                Intent center7mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter7Uri);
                center7mapIntent.setPackage("com.google.android.apps.maps");
                if (center7mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center7mapIntent);
                }
                break;
            case R.id.btn_center8:
                Uri gmmCenter8Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center8mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter8Uri);
                center8mapIntent.setPackage("com.google.android.apps.maps");
                if (center8mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center8mapIntent);
                }
                break;
            case R.id.btn_center9:
                Uri gmmCenter9Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center9mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter9Uri);
                center9mapIntent.setPackage("com.google.android.apps.maps");
                if (center9mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center9mapIntent);
                }

                break;
            case R.id.btn_center10:
                Uri gmmCenter10Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center10mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter10Uri);
                center10mapIntent.setPackage("com.google.android.apps.maps");
                if (center10mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center10mapIntent);
                }
                break;
            case R.id.btn_center11:
                Uri gmmCenter11Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center11mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter11Uri);
                center11mapIntent.setPackage("com.google.android.apps.maps");
                if (center11mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center11mapIntent);
                }
                break;
            case R.id.btn_center12:
                Uri gmmCenter12Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center12mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter12Uri);
                center12mapIntent.setPackage("com.google.android.apps.maps");
                if (center12mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center12mapIntent);
                }
                break;
            case R.id.btn_center13:
                Uri gmmCenter13Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center13mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter13Uri);
                center13mapIntent.setPackage("com.google.android.apps.maps");
                if (center13mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center13mapIntent);
                }
                break;
            case R.id.btn_center14:
                Uri gmmCenter14Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center14mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter14Uri);
                center14mapIntent.setPackage("com.google.android.apps.maps");
                if (center14mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center14mapIntent);
                }
                break;
            case R.id.btn_center15:
                Uri gmmCenter15Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center15mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter15Uri);
                center15mapIntent.setPackage("com.google.android.apps.maps");
                if (center15mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center15mapIntent);
                }
                break;
            case R.id.btn_center16:
                Uri gmmCenter16Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center16mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter16Uri);
                center16mapIntent.setPackage("com.google.android.apps.maps");
                if (center16mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center16mapIntent);
                }
                break;
            case R.id.btn_center17:
                Uri gmmCenter17Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center17mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter17Uri);
                center17mapIntent.setPackage("com.google.android.apps.maps");
                if (center17mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center17mapIntent);
                }
                break;
            case R.id.btn_center18:
                Uri gmmCenter18Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center18mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter18Uri);
                center18mapIntent.setPackage("com.google.android.apps.maps");
                if (center18mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center18mapIntent);
                }
                break;
            case R.id.btn_center19:
                Uri gmmCenter19Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center19mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter19Uri);
                center19mapIntent.setPackage("com.google.android.apps.maps");
                if (center19mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center19mapIntent);
                }
                break;
            case R.id.btn_center20:
                Uri gmmCenter20Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center20mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter20Uri);
                center20mapIntent.setPackage("com.google.android.apps.maps");
                if (center20mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center20mapIntent);
                }
                break;
            case R.id.btn_center21:
                Uri gmmCenter21Uri = Uri.parse("google.navigation:q= Plot+49A+Municipal Close,Arua");
                Intent center21mapIntent = new Intent(Intent.ACTION_VIEW, gmmCenter21Uri);
                center21mapIntent.setPackage("com.google.android.apps.maps");
                if (center21mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(center21mapIntent);
                }
                break;
        }

    }
}

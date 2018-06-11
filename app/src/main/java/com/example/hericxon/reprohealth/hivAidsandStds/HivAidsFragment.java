package com.example.hericxon.reprohealth.hivAidsandStds;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hericxon.reprohealth.R;

/**
 * created by derrick
 */
public class HivAidsFragment extends Fragment {
    Button hivbtn, hiv_transmissionbtn, hiv_riskbtn, hiv_symptomsbtn, hiv_preventionbtn,
            hiv_treatmentbtn, hiv_managementbtn, hiv_mythbtn, hiv_immune_attackbtn;

    public HivAidsFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_hiv_aids, container, false);
        // Inflate the layout for this fragment

        hivbtn= view.findViewById(R.id.hiv_btn);
        hiv_transmissionbtn = view.findViewById(R.id.hiv_transimission_btn);
        hiv_riskbtn = view.findViewById(R.id.hiv_risks_btn);
        hiv_symptomsbtn = view.findViewById(R.id.hiv_symptoms_btn);
        hiv_preventionbtn = view.findViewById(R.id.hiv_prevention_btn);
        hiv_treatmentbtn = view.findViewById(R.id.hiv_treatment_btn);
        hiv_managementbtn = view.findViewById(R.id.hiv_management_btn);
        hiv_mythbtn = view.findViewById(R.id.hiv_myths_btn);
        hiv_immune_attackbtn = view.findViewById(R.id.hiv_immune_attack_btn);

        hivbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hiv;
                hiv = new Intent(view.getContext(),HivAids.class);
                hiv.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(hiv);
            }
        });

        hiv_transmissionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transmission;
                transmission = new Intent(view.getContext(),HivTransmission.class);
                transmission.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(transmission);
            }
        });

        hiv_riskbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent risks;
                risks = new Intent(view.getContext(),HivRisks.class);
                risks.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(risks);
            }
        });

        hiv_symptomsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent symptoms;
                symptoms = new Intent(view.getContext(),HivSymptoms.class);
                symptoms.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(symptoms);
            }
        });

        hiv_preventionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prevention;
                prevention = new Intent(view.getContext(),HivPrevention.class);
                prevention.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(prevention);
            }
        });


        hiv_treatmentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent treatment;
                treatment = new Intent(view.getContext(),HivTreatable.class);
                treatment.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(treatment);
            }
        });

        hiv_managementbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent management;
                management = new Intent(view.getContext(),HivManagement.class);
                management.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(management);
            }
        });

        hiv_mythbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myth;
                myth = new Intent(view.getContext(),HivMyth.class);
                myth.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myth);
            }
        });

        hiv_immune_attackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent immune_attack;
                immune_attack = new Intent(view.getContext(),HivImmuneAttack.class);
                immune_attack.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(immune_attack);
            }
        });

        return view;
    }
}

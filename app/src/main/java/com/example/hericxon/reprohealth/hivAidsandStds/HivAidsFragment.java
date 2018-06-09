package com.example.hericxon.reprohealth.hivAidsandStds;


import android.content.Context;
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
            hiv_treatmentbtn, hiv_managementbtn, hiv_mythbtn, hiv_immune_attachbtn;

    public HivAidsFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hiv_aids, container, false);
    }

}

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
 * A simple {@link Fragment} subclass.
 */
public class StdsFragment extends Fragment {

    Button stibtn,stimythbtn,stitypesbtn;

    public StdsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_stds, container, false);

        stibtn = view.findViewById(R.id.sti_btn);
        stitypesbtn = view.findViewById(R.id.sti_types_btn);
        stimythbtn = view.findViewById(R.id.sti_myth_btn);


        stibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sti;
                sti = new Intent(view.getContext(),StiStd.class);
                sti.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sti);
            }
        });

        stitypesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sti_types;
                sti_types = new Intent(view.getContext(),StiStdTypes.class);
                sti_types.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sti_types);
            }
        });

        stimythbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sti_myth;
                sti_myth = new Intent(view.getContext(),StiStdMyth.class);
                sti_myth.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sti_myth);
            }
        });

        return view;
    }

}

package com.example.hericxon.reprohealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.HashMap;

public class SearchActivity extends AppCompatActivity {
    private ListView lv;
    EditText inputSearch;
    ArrayAdapter<String> adapter;
    ArrayAdapter<HashMap<String,String>> searchList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String searchTerms[] ={
                "What is a relationship",
                "What is HIV",
                "What are sexually transmitted diseases",
                "What is sex vs gender",
                "What is gender equality",
                "What is puberty in male",
                "What are female reproductive organs",
                "Understanding youre emotions"};

        lv = findViewById(R.id.list_view);
        inputSearch = findViewById(R.id.inputsearch);
        adapter = new ArrayAdapter<String>(this,R.layout.search_list_item,R.id.searchTermDisplay,searchTerms);

        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchActivity.this.adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.onbackpressed_incoming,R.anim.onbackpressed_outgoing);
    }
}

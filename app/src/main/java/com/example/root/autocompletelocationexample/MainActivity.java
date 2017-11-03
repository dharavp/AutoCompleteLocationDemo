package com.example.root.autocompletelocationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private GooglePlaceAutocompleteAdapter dataAdapter;
    private ListView listView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataAdapter = new GooglePlaceAutocompleteAdapter(MainActivity.this,
                R.layout.adapter_google_places_autocomplete);

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(dataAdapter);

        listView.setTextFilterEnabled(true);

        editText=(EditText)findViewById(R.id.edEnterLocation);
        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                dataAdapter.getFilter().filter(s.toString());
            }
        });
    }
}

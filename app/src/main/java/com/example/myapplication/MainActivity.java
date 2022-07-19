package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList();
        arrayList.add("선택");
        arrayList.add("2022년");
        arrayList.add("2023년");
        final String[] select_item = {""};

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        tv_result = (TextView)findViewById(R.id.tv_result);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_result.setText(adapterView.getItemAtPosition(i).toString());
                select_item[0] = String.valueOf(arrayList.get(i));
                if(select_item[0].equals("선택")){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    fragment0 fragment0 = new fragment0();
                    transaction.replace(R.id.frame, fragment0);
                    transaction.commit();
                }
                else if(select_item[0].equals("2022년")){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    fragment1 fragment1 = new fragment1();
                    transaction.replace(R.id.frame, fragment1);
                    transaction.commit();
                }
                else if(select_item[0].equals("2023년")){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    fragment2 fragment2 = new fragment2();
                    transaction.replace(R.id.frame, fragment2);
                    transaction.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
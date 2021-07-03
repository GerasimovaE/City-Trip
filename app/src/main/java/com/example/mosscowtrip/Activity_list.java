package com.example.mosscowtrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Activity_list extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private List<String> listCity;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        listCity = new ArrayList<>(2);
        listCity.add("Москва");
        listCity.add("Санкт-Петербург");

        adapter = new ArrayAdapter<>(this, R.layout.city, listCity);
        ListView listView = (ListView) findViewById(R.id.list_city);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data;
                data = listCity.get(position);
                if (data.equals("Москва")) {
                    Intent intent = new Intent(getApplicationContext(), Activity_two.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String data = (String)parent.getItemAtPosition(position);
        Toast.makeText(Activity_list.this, "OnItemLongClickListener\n" + data, Toast.LENGTH_SHORT).show();
        return true;
    }
}

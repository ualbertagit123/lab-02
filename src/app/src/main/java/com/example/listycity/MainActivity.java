package com.example.listycity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    private boolean addCity = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        Button addButton = findViewById(R.id.add_button);
        Button removeButton = findViewById(R.id.remove_button);
        Button confirmButton = findViewById(R.id.confirm_button);
        EditText cityInput = findViewById(R.id.city_input);

        Group inputGroup = findViewById(R.id.input_group);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addCity = true;
                inputGroup.setVisibility(View.VISIBLE);
                cityInput.requestFocus();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addCity = false;
                inputGroup.setVisibility(View.VISIBLE);
                cityInput.requestFocus();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = cityInput.getText().toString();
                if (input.isEmpty()) {}

                if (addCity) {
                    dataList.add(input);
                }
                else {
                    if (dataList.contains(input)) {
                        dataList.remove(input);
                    }
                    else {}
                }

                cityInput.setText("");
                inputGroup.setVisibility(View.GONE);
            }
        });
    }
}
package com.moringaschool.health_care;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HealthActivity extends  AppCompatActivity{

        @BindView(R.id.locationTextView)
        TextView mLocationTextView;
        @BindView(R.id.listView)
        ListView mListView;
        @BindView(R.id.spinner)
        Spinner mSpinner;
        private String[] restaurants = new String[] {"KEMPISKY VILLA ROSA", "Mother's Bistro",
                "Life of Pie", "Screen Door", "MAMA ROCCO", "Sweet Basil",
                "Slappy Cakes", "Equinox", "OLE SEREN", "Andina",
                "Lardo", "Portland City Grill", "SAFARI PARK",
                "WHITE KITCHEN", "Subway"};
        private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_health);
            ButterKnife.bind(this);
            MyHealthArrayAdapter adapter = new MyHealthArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String restaurant = ((TextView)view).getText().toString();
                    Log.v("HealthActivity", "In the onItemClickListener!");
                    Toast.makeText(HealthActivity.this, restaurant, Toast.LENGTH_LONG).show();
                }
            });

            Intent intent = getIntent();
            String location = intent.getStringExtra("location");
            mLocationTextView.setText("Health care around you: " + location);
            Log.d("HealthActivity", "In the onCreate method!");
        }

    }


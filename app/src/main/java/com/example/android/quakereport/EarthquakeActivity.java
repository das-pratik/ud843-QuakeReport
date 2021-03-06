/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        //ArrayList<Earthquake> earthquakes = new ArrayList<>();

        /*
        earthquakes.add(new Earthquake("San Francisco", "Jan 01, 1999", "4.5"));
        earthquakes.add(new Earthquake("London", "Feb 02, 2000", "5.5"));
        earthquakes.add(new Earthquake("Tokyo",  "Mar 03, 2001", "5"));
        earthquakes.add(new Earthquake("Mexico City", "Apr 04, 2002", "4.8"));
        earthquakes.add(new Earthquake("Moscow", "May 05, 2003", "5.4"));
        earthquakes.add(new Earthquake("Rio de Janeiro", "June 06, 2004", "6.5"));
        earthquakes.add(new Earthquake("Paris", "July 07, 2005", "4.5"));
        */

        //Get list of earthquake locations from QueryUtils JSON parse
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        //Debug message
        //Log.d("EarthquakeActivity", "the 4th element is location:" + earthquakes.get(3).getLocation() +
        //        " ,date:" + earthquakes.get(3).getDate() + " ,magnitude:" + earthquakes.get(3).getMag());


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeArrayAdapter adapter = new EarthquakeArrayAdapter(
                this, android.R.layout.simple_list_item_1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}

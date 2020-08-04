package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeArrayAdapter(Activity context, int simple_list_item_1, ArrayList<Earthquake> earthquake){
        super(context, 0, earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Earthquake currentEarthquake = getItem(position);



        //Split the location text into two parts using 'OF' CharacterSeq
        String location = currentEarthquake.getLocation();
        String firstSubLocation = "";
        String secondSubLocation = "";

        if (location.toLowerCase().contains("of")){
            firstSubLocation = location.substring(0, location.toLowerCase().indexOf("of") + 2);
            secondSubLocation = location.substring(location.toLowerCase().indexOf("of") + 3, location.length());
        } else {
            firstSubLocation ="";
            secondSubLocation = location;
        }

        // Find the FirstTextView in the list_item.xml layout with the ID location_view
        TextView firstLocationView = (TextView) listItemView.findViewById(R.id.first_location_view);

        // Get the location name from the current Earthquake object and
        // set this location name on the locationView
        firstLocationView.setText(firstSubLocation);


        // Find the SecondTextView in the list_item.xml layout with the ID location_view
        TextView secondLocationView = (TextView) listItemView.findViewById(R.id.second_location_view);

        // Get the location name from the current Earthquake object and
        // set this location name on the locationView
        secondLocationView.setText(secondSubLocation);

        // Find the TextView in the list_item.xml layout with the ID date_view
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_view);
        // Get the date from the current Earthquake object and
        // set this date on the dateView
        dateView.setText(currentEarthquake.getDate());

        // Find the TextView in the list_item.xml layout with the ID time_view
        TextView timeView = (TextView) listItemView.findViewById(R.id.time_view);
        // Get the date from the current Earthquake object and
        // set this date on the dateView
        timeView.setText(currentEarthquake.getTime());


        // Find the TextView in the list_item.xml layout with the ID magnitude_view
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude_view);
        // Get the magnitude value from the current earthquake object and set formatted magnitude value on the TextView
        magnitudeView.setText(formatMagnitude(currentEarthquake.getMag()));

        // Get background color of magnitudeView
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Return the whole list item layout (containing 2 TextViews and 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }

    private String formatMagnitude(long longMagnitude){
        DecimalFormat formattedMagnitude = new DecimalFormat("0.00");
        return formattedMagnitude.format(longMagnitude);
    }

    private int getMagnitudeColor(long magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}

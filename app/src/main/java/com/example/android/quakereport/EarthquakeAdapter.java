package com.example.android.quakereport;

import android.content.Context;
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

import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by pjsevilla on 15/01/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View earthquakeView = convertView;
        if (earthquakeView == null) {
            earthquakeView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magView = (TextView) earthquakeView.findViewById(R.id.earthquake_magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        magView.setText(formatter.format(currentEarthquake.getMagnitude()));

        int backgroundColorId;
        if (currentEarthquake.getMagnitude() > 10) {
            backgroundColorId = R.color.magnitude10plus;
        } else if (currentEarthquake.getMagnitude() > 9) {
            backgroundColorId = R.color.magnitude9;
        } else if (currentEarthquake.getMagnitude() > 8) {
            backgroundColorId = R.color.magnitude8;
        } else if (currentEarthquake.getMagnitude() > 7) {
            backgroundColorId = R.color.magnitude7;
        } else if (currentEarthquake.getMagnitude() > 6) {
            backgroundColorId = R.color.magnitude6;
        } else if (currentEarthquake.getMagnitude() > 5) {
            backgroundColorId = R.color.magnitude5;
        } else if (currentEarthquake.getMagnitude() > 4) {
            backgroundColorId = R.color.magnitude4;
        } else if (currentEarthquake.getMagnitude() > 3) {
            backgroundColorId = R.color.magnitude3;
        } else if (currentEarthquake.getMagnitude() > 2) {
            backgroundColorId = R.color.magnitude2;
        } else {
            backgroundColorId = R.color.magnitude1;
        }
        int magnitudeColor = ContextCompat.getColor(getContext(), backgroundColorId);
        GradientDrawable magnitudeCircle = (GradientDrawable) magView.getBackground();
        magnitudeCircle.setColor(magnitudeColor);

        String primaryPlace = currentEarthquake.getPlace();
        String offsetPlace = "Near the";

        if (primaryPlace.contains(" of "))
        {
            String[] parts = primaryPlace.split(" of ");
            offsetPlace = parts[0] + " of";
            primaryPlace = parts[1];
        }

        TextView offsetPlaceView = (TextView) earthquakeView.findViewById(R.id.earthquake_offsetplace);
        offsetPlaceView.setText(offsetPlace);

        TextView primaryPlaceView = (TextView) earthquakeView.findViewById(R.id.earthquake_primaryplace);
        primaryPlaceView.setText(primaryPlace);

        Timestamp timestamp = new Timestamp(currentEarthquake.getTimestamp());
        Date dateObject = new Date(timestamp.getTime());

        TextView dateView = (TextView) earthquakeView.findViewById(R.id.earthquake_date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        dateView.setText(dateFormat.format(dateObject));

        TextView timeView = (TextView) earthquakeView.findViewById(R.id.earthquake_time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        timeView.setText(timeFormat.format(dateObject));

        return earthquakeView;
    }
}

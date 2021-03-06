package com.example.mahafarhy.popular_movies_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.mahafarhy.popular_movies_app.R;
import com.example.mahafarhy.popular_movies_app.model.Trailer;
import java.util.ArrayList;


public class TrailerArrayAdapter extends ArrayAdapter<Trailer> {
    static int resource = R.layout.row_trailer;
    ArrayList<Trailer> trailers;
    Activity activity;

    public TrailerArrayAdapter(Activity activity, ArrayList<Trailer> trailers) {
        super(activity, resource, trailers);
        this.trailers = trailers;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);
        TextView trailerNameTV = (TextView) rowView.findViewById(R.id.trailerName);
        if(trailers.get(position) != null) {
            trailerNameTV.setText(trailers.get(position).getName());
        }
        return rowView;
    }



    @Override
    public int getCount() {
        if(trailers != null){
             return trailers.size() < 3 ? trailers.size(): 3;
        }
        return 0;
    }
}

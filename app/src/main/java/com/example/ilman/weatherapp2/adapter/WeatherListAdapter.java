package com.example.ilman.weatherapp2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilman.weatherapp2.R;
import com.example.ilman.weatherapp2.holder.WeatherListHolder;
import com.example.ilman.weatherapp2.model.WeatherList;

import java.util.ArrayList;

/**
 * Created by ilman on 26/11/2017.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListHolder> {

    private ArrayList<WeatherList> mWeatherlist;

    public WeatherListAdapter(ArrayList<WeatherList> mWeatherlist) {
        this.mWeatherlist = mWeatherlist;
    }

    @Override
    public WeatherListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_weather,parent,false);
        return new WeatherListHolder(card);
    }

    @Override
    public void onBindViewHolder(WeatherListHolder holder, int position) {
        WeatherList weatherList= mWeatherlist.get(position);
        holder.updateUI(weatherList);
    }

    @Override
    public int getItemCount() {
        return mWeatherlist.size();
    }
}

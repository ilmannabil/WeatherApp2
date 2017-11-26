package com.example.ilman.weatherapp2.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilman.weatherapp2.R;
import com.example.ilman.weatherapp2.model.WeatherList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ilman on 26/11/2017.
 */

public class WeatherListHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.maxTempList) TextView maxTempList;
    @BindView(R.id.minTempList) TextView minTempList;
    @BindView(R.id.statusList) TextView statusList;
    @BindView(R.id.timeList) TextView timeList;
    @BindView(R.id.iconMiniList)
    ImageView iconMiniList;

    public WeatherListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void updateUI(WeatherList weatherList){
        maxTempList.setText(String.valueOf(weatherList.getTempMax()));
        minTempList.setText(String.valueOf(weatherList.getTempMin()));
        statusList.setText(weatherList.getStatus());
        timeList.setText(weatherList.getTime());

        if (weatherList.getStatus().equals("Rain")){
            iconMiniList.setImageResource(R.drawable.rain_large);
        }else if (weatherList.getStatus().equals("Clouds")){
            iconMiniList.setImageResource(R.drawable.coldly_large);
        }else{
            iconMiniList.setImageResource(R.drawable.sun_large);
        }

    }

}

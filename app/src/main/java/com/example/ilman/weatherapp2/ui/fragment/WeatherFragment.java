package com.example.ilman.weatherapp2.ui.fragment;


import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ilman.weatherapp2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    String API_URL="http://api.openweathermap.org/data/2.5/forecast/?lat=-6.1877386&lon=106.7400824&units=metric&APPID=9ed2257682b1d9a2eb66c15047e1bfdd";

    @BindView(R.id.tvTime) TextView tvTime;
    @BindView(R.id.tvCity) TextView tvCity;
    @BindView(R.id.tvDayDate) TextView tvDayDate;
    @BindView(R.id.tvMaxTemp) TextView tvMaxTemp;
    @BindView(R.id.tvMinTemp) TextView tvMinTemp;
    @BindView(R.id.tvStatus) TextView tvStatus;
    @BindView(R.id.imgCuaca) ImageView imgCuaca;


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this,view);

        //TODO code

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(JSONObject response) {
//                Log.d("SUKSES RESPONSE",String.valueOf(response));

                try {
                    JSONObject cityObject = response.getJSONObject("city");
                    String country = cityObject.getString("country");
                    String city = cityObject.getString("name");

                    JSONArray listArray= response.getJSONArray("list");
                    JSONObject firstObject= listArray.getJSONObject(0);

                    JSONObject mainObject= firstObject.getJSONObject("main");
                    Double tempMax= mainObject.getDouble("temp_max");
                    Double tempMin= mainObject.getDouble("temp_min");

                    JSONArray weatherArray= firstObject.getJSONArray("weather");
                    JSONObject weatherFirstObject= weatherArray.getJSONObject(0);
                    String status= weatherFirstObject.getString("main");

                    String date= firstObject.getString("dt_txt");


                    tvCity.setText(city+", "+country);
                    tvMaxTemp.setText(String.valueOf(tempMax));
                    tvMinTemp.setText(String.valueOf(tempMin));
                    tvStatus.setText(status);

                    if (status.equals("Rain")){
                        imgCuaca.setImageResource(R.drawable.rain_large);
                    }else if (status.equals("Clouds")){
                        imgCuaca.setImageResource(R.drawable.coldly_large);
                    }else{
                        imgCuaca.setImageResource(R.drawable.sun_large);
                    }


                    SimpleDateFormat formatDefault = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    SimpleDateFormat formatTimeCustom = new SimpleDateFormat("hh.mm");
                    SimpleDateFormat formatDateCustom = new SimpleDateFormat("EEEE, dd MMM");

                    String time=date;
                    String datecustom=date;
                    try {
                        Date timesFormat = formatDefault.parse(time);
                        time=formatTimeCustom.format(timesFormat);

                        Date dateFormat= formatDefault.parse(date);
                        datecustom=formatDateCustom.format(dateFormat);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tvTime.setText(time);
                    tvDayDate.setText(datecustom);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR RESPONSE", "VolleyError");
            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);



        return view;
    }

}

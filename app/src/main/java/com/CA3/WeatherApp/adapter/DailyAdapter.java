package com.CA3.WeatherApp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.CA3.WeatherApp.R;
import com.CA3.WeatherApp.network.ResponseDaily;

import java.util.List;

/**
 * Created by Luciana Alves - 18350
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder>{
    private Context context;
    private ItemClickListener listener;
    private List<ResponseDaily> ListDaily;

    public DailyAdapter(Context context) {
        this.context = context;
    }
    public DailyAdapter(Context context, ItemClickListener listener, List<ResponseDaily> listDaily) {
        this.context = context;
        this.listener = listener;
        this.ListDaily = listDaily;

        Log.d("DATA","DailyAdapter");
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup group, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        Log.d("DATA_DAILY", "onCreateViewHolder");
        return new ViewHolder(inflater.inflate(R.layout.item_daily_weather, group, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponseDaily       daily       = getListDaily().get(position);
        Log.d("DATA_DAILY", daily.toString());
        holder.day.setText(daily.getDay());

        setWeather(daily.getWeatherNumber(), holder.iconWeather);
        holder.temperature.setText(daily.getTemperature()+"");
        setTemperatureColor(daily.getTemperatureClass(), holder.iconTemperature);
        holder.wind.setText(daily.getWindSpeed()+"");
        holder.iconWind.setRotation(Float.valueOf(daily.getWindDirection()));
        setWarningColor(daily.getWarnings().getLevel(),holder.iconWarning);

    }
    public void addItems(List<ResponseDaily> items) {
        setListDaily(items);
        notifyDataSetChanged();
    }
    private void setTemperatureColor(String str, View view) {
        if (str.equals("orange")) {
            view.setBackgroundColor(-16711936);
            view.setBackground(context.getResources().getDrawable(R.drawable.orange_circle));
        } else if (str.equals("red")) {
            view.setBackground(context.getResources().getDrawable(R.drawable.red_circle));
        } else if (str.equals("yellow")) {
            view.setBackground(context.getResources().getDrawable(R.drawable.yellow_circle));
        } else if (str.equals("green")) {
            view.setBackgroundColor(-16711936);
            //view.setBackground(context.getResources().getDrawable(R.drawable.grey_rounded_box));
        }
    }

    /* access modifiers changed from: private */
    public void setWarningColor(String str, AppCompatImageView appCompatImageView) {
        if (str.equals("Orange")) {
            appCompatImageView.setImageResource(R.drawable.warningorange);
        } else if (str.equals("Red")) {
            appCompatImageView.setImageResource(R.drawable.warningred);
        } else if (str.equals("Yellow")) {
            appCompatImageView.setImageResource(R.drawable.warningyellow);
        } else if (str.equals("Green")) {
            appCompatImageView.setImageResource(R.drawable.warninggreen);
        }
    }

    public void setWeather(String str, AppCompatImageView appCompatImageView){
        str = "y"+str;
        Log.d("DATA_WEATHER", str);
        int id = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        appCompatImageView.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return getListDaily().size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView day;
        private TextView wind;
        private TextView temperature;
        private AppCompatImageView iconTemperature;
        private AppCompatImageView iconWeather;
        private AppCompatImageView iconWarning;
        private AppCompatImageView iconWind;



        ViewHolder(@NonNull View item) {
            super(item);
            day  = (item.findViewById(R.id.day0TextView));
            iconWeather = (item.findViewById(R.id.day0IconImageView));
            iconWarning = (item.findViewById(R.id.day0WarningImageView));
            temperature = (item.findViewById(R.id.day0TemperatureTextView));
            iconTemperature = (item.findViewById(R.id.day0TemperatureImageView));
            wind = (item.findViewById(R.id.day0WindTextView));
            iconWind = (item.findViewById(R.id.day0WindImageView));
        }

        @Override
        public void onClick(View view) {
            if (getListener() != null) {
                getListener().onItemClick(view, getAdapterPosition());
            } else {
                Log.e(getClass().getSimpleName(), "Listener not set!");
            }
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ItemClickListener getListener() {
        return listener;
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public List<ResponseDaily> getListDaily() {
        return ListDaily;
    }

    public void setListDaily(List<ResponseDaily> listDaily) {
        ListDaily = listDaily;
    }
}

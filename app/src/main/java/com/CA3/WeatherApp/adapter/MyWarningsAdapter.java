package com.CA3.WeatherApp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.CA3.WeatherApp.R;
import com.CA3.WeatherApp.database.DataSingleton;
import com.CA3.WeatherApp.database.MyWarning;
import com.CA3.WeatherApp.view.EditWarningActivity;

public class MyWarningsAdapter extends Adapter<MyWarningsAdapter.ViewHolder> {
    Activity activity;

    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        TextView locationTextView;
        LinearLayout theLayout;
        TextView typeTextView;
        ImageView warningLevelImageView;

        public ViewHolder(View view) {
            super(view);
            this.theLayout = (LinearLayout) view.findViewById(R.id.theLayout);
            this.locationTextView = (TextView) view.findViewById(R.id.locationTextView);
            this.typeTextView = (TextView) view.findViewById(R.id.typeTextView);
            this.warningLevelImageView = (ImageView) view.findViewById(R.id.warningLevelImageView);
        }
    }

    public MyWarningsAdapter(Activity activity) {
            this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_warning, viewGroup, false));
    }


    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        MyWarning myWarning = DataSingleton.getInstance().getMyWarningList().get(position);

        viewHolder.theLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyWarningsAdapter.this.activity, EditWarningActivity.class);
                intent.putExtra("MY_WARNING_ITEM", position);
                MyWarningsAdapter.this.activity.startActivity(intent);
            }
        });
        viewHolder.locationTextView.setText(myWarning.getArea());
        viewHolder.typeTextView.setText(myWarning.getType());

        if (myWarning.getLevel().contains("Orange")) {
            viewHolder.warningLevelImageView.setImageResource(R.drawable.warningorange);
        } else if (myWarning.getLevel().contains("Yellow")) {
            viewHolder.warningLevelImageView.setImageResource(R.drawable.warningyellow);
        } else if (myWarning.getLevel().contains("Red")) {
            viewHolder.warningLevelImageView.setImageResource(R.drawable.warningred);
        }
    }

    public int getItemCount() {
        return DataSingleton.getInstance().getMyWarningList().size();
    }
}

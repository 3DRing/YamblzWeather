package com.ringov.yamblzweather.presentation.ui.main.forecast;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ringov.yamblzweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastItemVH extends RecyclerView.ViewHolder {

    @BindView(R.id.im_condition)
    ImageView conditionImageView;
    @BindView(R.id.tv_date)
    TextView dateTextView;
    @BindView(R.id.tv_temp_max)
    TextView tempMaxTextView;
    @BindView(R.id.tv_temp_min)
    TextView tempMinTextView;

    public ForecastItemVH(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

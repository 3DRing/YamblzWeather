package com.ringov.yamblzweather.presentation.ui.details;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ringov.yamblzweather.R;
import com.ringov.yamblzweather.presentation.base.BaseMvvmFragment;
import com.ringov.yamblzweather.presentation.entity.UIWeatherDetail;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailsFragment extends BaseMvvmFragment<DetailsViewModel> {

    public static final String TAG = "DetailsFragment";

    private static final String ARG_TIME = "ARG_TIME";

    public static DetailsFragment newInstance(long time) {
        if (time == -1)
            throw new IllegalArgumentException("Trying to create instance with wrong arguments");

        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_TIME, time);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    protected Class<DetailsViewModel> getViewModelClass() {
        return DetailsViewModel.class;
    }

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.tv_error)
    TextView errorTextView;
    @BindView(R.id.im_condition)
    ImageView conditionImageView;

    @Override
    protected void onViewModelAttach() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass());
        long time = getArguments().getLong(ARG_TIME);
        viewModel.showWeatherFor(time);
    }

    @Override
    protected void attachInputListeners() {
        viewModel.observe(this, this::showLoading, this::showError, this::showWeatherDetails);
    }


    private void showLoading(boolean loading) {
        if (loading)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    private void showError(Throwable error) {
        errorTextView.setText(error.getMessage());
        errorTextView.setVisibility(View.VISIBLE);
    }

    private void showWeatherDetails(UIWeatherDetail weather) {
        Glide.with(getContext())
                .load(weather.getCondition().getConditionImage())
                .into(conditionImageView);
    }
}

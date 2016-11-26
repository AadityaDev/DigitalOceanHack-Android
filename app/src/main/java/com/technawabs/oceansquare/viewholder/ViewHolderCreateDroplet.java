package com.technawabs.oceansquare.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.uicomponents.animation.RippleRelativeView;

public class ViewHolderCreateDroplet extends RecyclerView.ViewHolder {

    private RelativeLayout submitButton;
    private Spinner regionSpinner;
    private Spinner sizeSpinner;
    private Spinner osSpinner;

    public ViewHolderCreateDroplet(@NonNull View itemView) {
        super(itemView);
        regionSpinner = (Spinner) itemView.findViewById(R.id.region_spinner);
        sizeSpinner = (Spinner) itemView.findViewById(R.id.size_spinner);
        osSpinner = (Spinner) itemView.findViewById(R.id.os_spinner);
        submitButton = (RippleRelativeView) itemView.findViewById(R.id.create_droplet);
    }

    public RelativeLayout getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(RippleRelativeView submitButton) {
        this.submitButton = submitButton;
    }

    public Spinner getRegionSpinner() {
        return regionSpinner;
    }

    public void setRegionSpinner(Spinner regionSpinner) {
        this.regionSpinner = regionSpinner;
    }

    public Spinner getSizeSpinner() {
        return sizeSpinner;
    }

    public void setSizeSpinner(Spinner sizeSpinner) {
        this.sizeSpinner = sizeSpinner;
    }

    public Spinner getOsSpinner() {
        return osSpinner;
    }

    public void setOsSpinner(Spinner osSpinner) {
        this.osSpinner = osSpinner;
    }
}

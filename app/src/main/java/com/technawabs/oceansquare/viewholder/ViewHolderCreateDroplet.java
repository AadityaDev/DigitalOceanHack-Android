package com.technawabs.oceansquare.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.uicomponents.animation.RippleRelativeView;

public class ViewHolderCreateDroplet extends RecyclerView.ViewHolder implements AdapterView.OnItemSelectedListener {

    private RelativeLayout submitButton;
    private EditText name;
    private Spinner regionSpinner;
    private Spinner sizeSpinner;
    private Spinner osSpinner;

    public ViewHolderCreateDroplet(@NonNull Context context, @NonNull View itemView) {
        super(itemView);
        name=(EditText)itemView.findViewById(R.id.droplet_name);
        regionSpinner = (Spinner) itemView.findViewById(R.id.region_spinner);
        sizeSpinner = (Spinner) itemView.findViewById(R.id.size_spinner);
        osSpinner = (Spinner) itemView.findViewById(R.id.os_spinner);
        submitButton = (RelativeLayout) itemView.findViewById(R.id.create_droplet);
    }

    public RelativeLayout getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(RippleRelativeView submitButton) {
        this.submitButton = submitButton;
    }

    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

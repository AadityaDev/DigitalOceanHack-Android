package com.technawabs.oceansquare.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.technawabs.oceansquare.R;


public class ViewHolderReceive extends RecyclerView.ViewHolder {

    private TextView receivedMessage;
    private ImageView imageReceiver;


    public ViewHolderReceive(View itemView) {
        super(itemView);
        receivedMessage = (TextView) itemView.findViewById(R.id.messageReceiver);
        imageReceiver = (ImageView) itemView.findViewById(R.id.imageReceiver);
    }

    public TextView getReceivedMessage() {
        return receivedMessage;
    }

    public void setReceivedMessage(TextView receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    public ImageView getImageReceiver() {
        return imageReceiver;
    }

    public void setImageReceiver(ImageView imageReceiver) {
        this.imageReceiver = imageReceiver;
    }
}

package com.technawabs.oceansquare.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.technawabs.oceansquare.R;


public class ViewHolderSend extends RecyclerView.ViewHolder {

    private TextView msgSent;
    private ImageView imageSender;

    public ViewHolderSend(View itemView) {
        super(itemView);
        msgSent = (TextView) itemView.findViewById(R.id.messageSender);
        imageSender = (ImageView) itemView.findViewById(R.id.imageSender);
    }

    public TextView getMsgSent() {
        return msgSent;
    }

    public void setMsgSent(TextView msgSent) {
        this.msgSent = msgSent;
    }

    public ImageView getImageSender() {
        return imageSender;
    }

    public void setImageSender(ImageView imageSender) {
        this.imageSender = imageSender;
    }
}

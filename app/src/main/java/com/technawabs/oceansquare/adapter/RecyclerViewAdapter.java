package com.technawabs.oceansquare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.model.ReceiverMessage;
import com.technawabs.oceansquare.model.SenderMessage;
import com.technawabs.oceansquare.viewholder.ViewHolderReceive;
import com.technawabs.oceansquare.viewholder.ViewHolderSend;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int sender = 0, receiver = 1;
    private List<Object> items;
    String myCurrentPhoto;
    Context mContext;

    public RecyclerViewAdapter(List<Object> currentItems, Context context, String myCurrentPhoto) {
        this.items = currentItems;
        this.mContext = context;
        this.myCurrentPhoto = myCurrentPhoto;
    }

    //Returns the view type of the item at position for the purposes of view recycling.
    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SenderMessage) {
            return 0;
        } else if (items.get(position) instanceof ReceiverMessage) {
            return 1;
        }
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0:
                View v1 = inflater.inflate(R.layout.activity_send, parent, false);
                viewHolder = new ViewHolderSend(v1);
                break;
            case 1:
                View v2 = inflater.inflate(R.layout.activity_receive, parent, false);
                viewHolder = new ViewHolderReceive(v2);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case 0:
                ViewHolderSend vh1 = (ViewHolderSend) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            case 1:
                ViewHolderReceive vh2 = (ViewHolderReceive) viewHolder;
                configureViewHolder2(vh2, position);
                break;
            default:
                break;
        }

    }


    private void configureViewHolder1(ViewHolderSend vh, int position) {

        SenderMessage senderMessage = (SenderMessage) items.get(position);
        if (senderMessage != null) {
            vh.getMsgSent().setText(senderMessage.getSenderMessage());
            Glide.with(mContext)
                    .load(senderMessage.getSenderImage())
                    .centerCrop()
                    .placeholder(R.drawable.fashion)
                    .crossFade()
                    .into(vh.getImageSender());
        }
    }

    private void configureViewHolder2(ViewHolderReceive vh, int position) {
        ReceiverMessage receiverMessage = (ReceiverMessage) items.get(position);
        if (receiverMessage != null) {
            vh.getReceivedMessage().setText(receiverMessage.getReceiverMessage());
            vh.getImageReceiver().setImageResource(R.drawable.logo);
        }

    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }
}

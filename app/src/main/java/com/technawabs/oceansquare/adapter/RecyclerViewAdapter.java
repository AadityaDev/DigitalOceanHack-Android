package com.technawabs.oceansquare.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.constant.API;
import com.technawabs.oceansquare.model.ReceiverMessage;
import com.technawabs.oceansquare.model.SenderMessage;
import com.technawabs.oceansquare.pojo.CreateDroplet;
import com.technawabs.oceansquare.uicomponents.SingleChoiceAdapter;
import com.technawabs.oceansquare.viewholder.ViewHolderCreateDroplet;
import com.technawabs.oceansquare.viewholder.ViewHolderReceive;
import com.technawabs.oceansquare.viewholder.ViewHolderSend;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String TAG = this.getClass().getSimpleName();
    int sender = 0, receiver = 1, createDroplet = 2, deleteDroplet = 3;
    private List<Object> items;
    private String myCurrentPhoto;
    private Context mContext;

    public RecyclerViewAdapter(List<Object> currentItems, Context context, String myCurrentPhoto) {
        this.items = currentItems;
        this.mContext = context;
        this.myCurrentPhoto = myCurrentPhoto;
    }

    //Returns the view type of the item at position for the purposes of view recycling.
    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SenderMessage) {
            return sender;
        } else if (items.get(position) instanceof ReceiverMessage) {
            return receiver;
        } else if (items.get(position) instanceof CreateDroplet) {
            return createDroplet;
        }
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case 0:
                view = inflater.inflate(R.layout.activity_send, parent, false);
                viewHolder = new ViewHolderSend(view);
                break;
            case 1:
                view = inflater.inflate(R.layout.activity_receive, parent, false);
                viewHolder = new ViewHolderReceive(view);
                break;
            case 2:
                view = inflater.inflate(R.layout.droplet_create_option, parent, false);
                viewHolder = new ViewHolderCreateDroplet(mContext, view);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case 0:
                ViewHolderSend vh1 = (ViewHolderSend) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            case 1:
                ViewHolderReceive vh2 = (ViewHolderReceive) viewHolder;
                configureViewHolder2(vh2, position);
                break;
            case 2:
                ViewHolderCreateDroplet viewHolderCreateDroplet = (ViewHolderCreateDroplet) viewHolder;
                configureViewCreateDroplet(viewHolderCreateDroplet, position);
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

    private void configureViewCreateDroplet(@NonNull final ViewHolderCreateDroplet viewHolder, final int position) {
        final CreateDroplet createDroplet = (CreateDroplet) items.get(position);
        if (createDroplet != null) {

            SingleChoiceAdapter regionAdapter = new SingleChoiceAdapter(mContext, createDroplet.getRegion().toArray(new String[createDroplet.getRegion().size() - 1]));
            SingleChoiceAdapter sizeAdapter = new SingleChoiceAdapter(mContext, createDroplet.getSize().toArray(new String[createDroplet.getSize().size() - 1]));
            SingleChoiceAdapter osAdapter = new SingleChoiceAdapter(mContext, createDroplet.getImages().toArray(new String[createDroplet.getImages().size() - 1]));

            viewHolder.getOsSpinner().setAdapter(regionAdapter);
            viewHolder.getRegionSpinner().setAdapter(sizeAdapter);
            viewHolder.getSizeSpinner().setAdapter(osAdapter);
            viewHolder.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CreateDroplet postDroplet = new CreateDroplet();
                    if ((viewHolder.getName().getText() != null) && (viewHolder.getName().getText().toString() != null) && (!viewHolder.getName().getText().toString().isEmpty())) {
                        postDroplet.setName(viewHolder.getName().toString());
                        List<String> osLisr = new ArrayList<String>();
                        osLisr.add(viewHolder.getOsSpinner().getSelectedItem().toString());
                        postDroplet.setImages(osLisr);
                        List<String> images = new ArrayList<String>();
                        images.add(viewHolder.getSizeSpinner().getSelectedItem().toString());
                        postDroplet.setSize(images);
                        List<String> regions = new ArrayList<String>();
                        regions.add(viewHolder.getRegionSpinner().getSelectedItem().toString());
                        postDroplet.setRegion(regions);

                        Gson gson = new Gson();
                        StringRequest strReq = new StringRequest(Request.Method.GET, API.POST_QUERY + gson.toJson(createDroplet), new Response.Listener<String>() {

                            @Override
                            public void onResponse(@NonNull String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    Log.d(TAG, jsonObject.toString());
                                    CreateDroplet createDroplet = new CreateDroplet();
                                    Gson gson = new Gson();
                                } catch (Exception e) {
                                    Log.d(TAG, e.getMessage() != null ? e.getMessage() : "JSON Exception");
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.d(TAG, "Error: " + error.getMessage());
                            }
                        });
                        Volley.newRequestQueue(mContext).add(strReq);

                    } else {
                        Toast.makeText(mContext, "Please enter a name", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}

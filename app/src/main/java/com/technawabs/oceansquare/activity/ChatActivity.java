package com.technawabs.oceansquare.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.adapter.RecyclerViewAdapter;
import com.technawabs.oceansquare.constant.API;
import com.technawabs.oceansquare.model.ReceiverMessage;
import com.technawabs.oceansquare.model.SenderMessage;
import com.technawabs.oceansquare.pojo.CreateDroplet;

import org.json.JSONObject;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    ArrayList<Object> arrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String myPhoto = "R.drawable.williams";

        recyclerView = (RecyclerView) findViewById(R.id.messageRecyclerView);
        arrayList = new ArrayList<>();

        arrayList.add(new SenderMessage("Hello I am Aditya", "R.drawable.williams"));
        arrayList.add(new ReceiverMessage("Hello I am Digital Ocean"));

        recyclerViewAdapter = new RecyclerViewAdapter(arrayList, this, myPhoto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

        ImageView imageView = (ImageView) findViewById(R.id.messagebutton);
        final EditText editText = (EditText) findViewById(R.id.messagebox);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new SenderMessage(editText.getText().toString(), myPhoto));
                recyclerViewAdapter.notifyDataSetChanged();
                getReplyFromBot(editText.getText().toString());

            }
        });
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void getReplyFromBot(@NonNull String senderMessage) {
        String temp = API.SEARCH_QUERY;
        String requestUrl = temp + "create droplet";

        StringRequest strReq = new StringRequest(Request.Method.GET,
                requestUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    Log.d(TAG, response.toString());
                    Toast.makeText(ChatActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    JSONObject jsonObject = new JSONObject(response);

                    CreateDroplet createDroplet = new CreateDroplet();
                    Gson gson = new Gson();
                    createDroplet = gson.fromJson(jsonObject.toString(), CreateDroplet.class);
                    arrayList.add(createDroplet);
                    recyclerViewAdapter.notifyDataSetChanged();

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


        Volley.newRequestQueue(this).add(strReq);
    }


}

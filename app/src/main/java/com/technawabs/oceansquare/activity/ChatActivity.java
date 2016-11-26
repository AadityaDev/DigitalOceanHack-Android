package com.technawabs.oceansquare.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.adapter.RecyclerViewAdapter;
import com.technawabs.oceansquare.model.ReceiverMessage;
import com.technawabs.oceansquare.model.SenderMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {


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
                editText.setText("");
                recyclerView.smoothScrollToPosition(arrayList.size() - 1);
            }
        });
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void getReplyFromBot(String senderMessage) {

        String temp = "http://api.program-o.com/v2/chatbot/?bot_id=10&say=" + senderMessage + "&convo_id=exampleusage_1209932&format=json";
        temp = temp.replaceAll(" ", "%20");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, temp
                , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    String responseMessage = response.getString("botsay");
                    arrayList.add(new ReceiverMessage(responseMessage));
                    recyclerViewAdapter.notifyDataSetChanged();
                    recyclerView.smoothScrollToPosition(arrayList.size() - 1);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

                // hide the progress dialog
            }
        });


        Volley.newRequestQueue(this).add(jsonObjReq);
    }


}

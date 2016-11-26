package com.technawabs.oceansquare.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.technawabs.oceansquare.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private String loginUrl;
    private WebView browser;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a toolbar to replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int currentId = view.getId();

        switch (currentId) {
            case R.id.loginBtn:
                sendRequest();
                break;
        }
    }

    public void sendRequest() {
        startActivity(new Intent(MainActivity.this, BrowserActivity.class));
    }

}

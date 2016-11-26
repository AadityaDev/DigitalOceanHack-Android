package com.technawabs.oceansquare.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.constant.API;
import com.technawabs.oceansquare.request.SingeltonRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    String loginUrl;
    WebView browser;

    final Context myApp = this;

    @JavascriptInterface
    public void processHTML(String html) throws JSONException {
        if (html == null)
            return;
        else {

            Document doc = Jsoup.parse(html);
            Element link = doc.select("pre").first();
            String finaltext = link.text();
            JSONObject jsonObject = new JSONObject(finaltext);
            Toast.makeText(MainActivity.this, jsonObject.getString("access_token"), Toast.LENGTH_SHORT).show();





        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a toolbar to replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new MyBrowser());

        loginUrl = "https://cloud.digitalocean.com/v1/oauth/authorize?client_id=bc9ddc5faa820489de13ac23f998fe79d55a9e880b5faaa0353321630539822d&redirect_uri=http://104.131.39.100:8083/callback&response_type=code";
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.addJavascriptInterface(this, "HTMLOUT");
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                browser.loadUrl("javascript:window.HTMLOUT.processHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");

            }

        });


        browser.loadUrl(loginUrl);


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


    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

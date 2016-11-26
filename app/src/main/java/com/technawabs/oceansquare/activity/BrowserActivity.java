package com.technawabs.oceansquare.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.technawabs.oceansquare.R;
import com.technawabs.oceansquare.constant.API;
import com.technawabs.oceansquare.constant.Constant;
import com.technawabs.oceansquare.prefrences.UserStore;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class BrowserActivity extends AppCompatActivity {

    private WebView browser;

    @JavascriptInterface
    public void processHTML(String html) throws JSONException {
        if (html == null)
            return;
        else {
            Document doc = Jsoup.parse(html);
            Element link = doc.select("pre").first();
            String finaltext = link.text();
            JSONObject jsonObject = new JSONObject(finaltext);
            JSONObject infoDetails = jsonObject.getJSONObject("info");

            Toast.makeText(BrowserActivity.this, jsonObject.getString(Constant.AUTH_TOKEN), Toast.LENGTH_SHORT).show();
            Toast.makeText(BrowserActivity.this, infoDetails.getString(Constant.NAME), Toast.LENGTH_SHORT).show();

            UserStore userStore = new UserStore(this);
            userStore.saveToken(jsonObject.getString(Constant.AUTH_TOKEN));
            userStore.saveName(infoDetails.getString(Constant.NAME));
            userStore.saveEmail(infoDetails.getString(Constant.EMAIL));
            Intent intent = new Intent(BrowserActivity.this, ChatActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new MyBrowser());
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
        browser.loadUrl(API.loginUrl);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

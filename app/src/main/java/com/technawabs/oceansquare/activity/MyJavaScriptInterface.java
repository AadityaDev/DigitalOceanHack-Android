package com.technawabs.oceansquare.activity;

import android.text.Html;
import android.util.Log;
import android.widget.Toast;

class MyJavaScriptInterface {
    @SuppressWarnings("unused")
    public void processHTML(final String html) {
        Log.i("processed html", html);

        Thread OauthFetcher = new Thread(new Runnable() {

            @Override
            public void run() {

                String oAuthDetails = null;
                oAuthDetails = Html.fromHtml(html).toString();
                Log.d("oAuthDetails", oAuthDetails);


            }
        });
        OauthFetcher.start();
    }
}
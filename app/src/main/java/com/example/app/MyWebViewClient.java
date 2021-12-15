package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class MyWebViewClient extends WebViewClient {

    private final String hostname;

    public MyWebViewClient(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // Log.i("MyWebViewClient", url + "---" + this.hostname);
        if (url.startsWith("file:") || url.contains(this.hostname)) {
            // Returning false means that you are going to load this url in the webView itself
            return false;
        }
        // Returning true means that you need to handle what to do with the url
        // e.g. open web page in a Browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}

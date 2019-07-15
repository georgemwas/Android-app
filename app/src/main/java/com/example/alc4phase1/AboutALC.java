package com.example.alc4phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutALC extends AppCompatActivity {
WebView webview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new myApp());

       WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webview.setWebViewClient(new myApp());
        webview.loadUrl("https://andela.com/alc/");
    }

    private class myApp extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
//            super.onReceivedSslError(view, handler, error);

            handler.proceed();
            error.getCertificate();
        }

    }

}

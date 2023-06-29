package com.su.jharkhanddarshan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;

public class news_desc extends AppCompatActivity {

    ImageView news_image;
    TextView news_headline, news_article;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_desc);

        DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();

        news_image      = findViewById(R.id.news_desc_image);
        news_headline   = findViewById(R.id.news_desc_headline);
        news_article    = findViewById(R.id.news_desc_text);
//        webView = (WebView) findViewById(R.id.webview);
//
//
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.getSettings().setJavaScriptEnabled(true);

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("News Portal");
        pd.setMessage("Loading...!");

//        webView.setWebViewClient(new WebViewClient() {
//                                     @Override
//                                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                                         super.onPageStarted(view, url, favicon);
//                                         pd.show();
//                                     }
//
//                                     @Override
//                                     public void onPageFinished(WebView view, String url) {
//                                         super.onPageFinished(view, url);
//                                         pd.dismiss();
//                                     }
//                                 }
//        );

        String linkdata = getIntent().getStringExtra("linkvalue");
        String headline = getIntent().getStringExtra("headline");
        String  headimage = getIntent().getStringExtra("headimage");
//        webView.loadUrl(linkdata);
        news_article.setText(linkdata);
        news_headline.setText(headline);
        Glide.with(news_image.getContext()).load(headimage).into(news_image);

    }
}
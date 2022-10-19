package com.sgtech.learncppbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.WebView;

import com.vungle.warren.InitCallback;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

import java.util.Objects;

public class IntroductionActivity extends AppCompatActivity {
    WebView webView;
    String url = "https://www.w3schools.com/cpp/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        webView = findViewById(R.id.webview);
        String title = getIntent().getStringExtra("title");
        String load = getIntent().getStringExtra("String");
        getSupportActionBar().setTitle(title);
        webView.loadUrl(url + load);
        Vungle.init("633af9342b028cfda77c7e28", getApplicationContext(), new InitCallback() {
            @Override
            public void onSuccess() {
                new Handler().postDelayed(() -> loadAd(), 4000);
            }

            @Override
            public void onError(VungleException exception) {
            }

            @Override
            public void onAutoCacheAdAvailable(String placementId) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        try {
            showAd();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    public void loadAd() {
        Vungle.loadAd("REWARDEDAD-2189236", new LoadAdCallback() {
            @Override
            public void onAdLoad(String placementId) {

            }

            @Override
            public void onError(String placementId, VungleException exception) {

            }
        });
    }

    public void showAd() {
        if (Vungle.canPlayAd("REWARDEDAD-2189236")) {
            Vungle.playAd("REWARDEDAD-2189236", null, new PlayAdCallback() {
                @Override
                public void creativeId(String creativeId) {

                }

                @Override
                public void onAdStart(String placementId) {

                }

                @Override
                public void onAdEnd(String placementId, boolean completed, boolean isCTAClicked) {

                }

                @Override
                public void onAdEnd(String placementId) {

                }

                @Override
                public void onAdClick(String placementId) {

                }

                @Override
                public void onAdRewarded(String placementId) {

                }

                @Override
                public void onAdLeftApplication(String placementId) {

                }

                @Override
                public void onError(String placementId, VungleException exception) {

                }

                @Override
                public void onAdViewed(String placementId) {

                }
            });
        }
    }


}
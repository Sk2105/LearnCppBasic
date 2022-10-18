package com.sgtech.learncppbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

import java.util.Objects;

public class IntroductionActivity extends AppCompatActivity {
    WebView webView;
    String url = "https://www.w3schools.com/cpp/";
    RewardedInterstitialAd ad;
    AdRequest adRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        webView = findViewById(R.id.webview);
        adRequest = new AdRequest.Builder().build();
        String title = getIntent().getStringExtra("title");
        String load = getIntent().getStringExtra("String");
        getSupportActionBar().setTitle(title);
        webView.loadUrl(url + load);
        new Handler().postDelayed(this::loadAd, 4000);
    }


    @Override
    public void onBackPressed() {
        try {
            if (ad != null) {
                ad.show(IntroductionActivity.this, rewardItem -> {

                });
            }
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
        RewardedInterstitialAd.load(this, "ca-app-pub-3397903282571414/3199206611",
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        ad = null;

                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);
                        ad = rewardedInterstitialAd;
                        ad.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                onAdLoaded(ad);
                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }
                        });
                    }
                });
    }


}
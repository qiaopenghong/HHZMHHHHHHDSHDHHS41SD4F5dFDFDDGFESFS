package com.hhzmy.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity{
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }
    private void initView(){
        webview = (WebView) findViewById(R.id.webView);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);  //支持js
        settings.setSupportZoom(true); //支持缩放
        settings.setBuiltInZoomControls(true); //设置支持缩放
        String jump = getIntent().getStringExtra("jump");
        String qiandao = getIntent().getStringExtra("qiandao");
        String zhuyong = getIntent().getStringExtra("zhuyong");
        String zunying = getIntent().getStringExtra("zunying");
        String haiwai = getIntent().getStringExtra("haiwai");
        String bighui = getIntent().getStringExtra("bighui");
        String lianghui = getIntent().getStringExtra("lianghui");
        String bie = getIntent().getStringExtra("bie");
        String more = getIntent().getStringExtra("more");
        String hl_one = getIntent().getStringExtra("hl_one");
        String hl_two = getIntent().getStringExtra("hl_two");
        String hl_three= getIntent().getStringExtra("hl_three");
        String hl_four = getIntent().getStringExtra("hl_four");
        String hl_five = getIntent().getStringExtra("hl_five");

        if(jump!=null){
            webview.loadUrl(jump);
        }else if(qiandao!=null){
            webview.loadUrl(qiandao);
        }else if(zhuyong!=null){
            webview.loadUrl(zhuyong);
        }else if(zunying!=null){
            webview.loadUrl(zunying);
        }else if(haiwai!=null){
            webview.loadUrl(haiwai);
        }else if(bighui!=null){
            webview.loadUrl(bighui);
        }else if(lianghui!=null){
            webview.loadUrl(lianghui);
        }else if(bie!=null){
            webview.loadUrl(bie);
        }else if(more!=null){
            webview.loadUrl(more);
        }else if(hl_one!=null){
            webview.loadUrl(hl_one);
        }else if(hl_two!=null){
            webview.loadUrl(hl_two);
        }else if(hl_three!=null){
            webview.loadUrl(hl_three);
        }else if(hl_four!=null){
            webview.loadUrl(hl_four);
        }else if(hl_five!=null){
            webview.loadUrl(hl_five);
        }

    }

}

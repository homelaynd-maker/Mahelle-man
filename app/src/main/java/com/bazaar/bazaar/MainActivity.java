package com.bazaar.bazaar;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.content.Intent;
import android.net.Uri;
import android.view.Window;

public class MainActivity extends Activity {
    private WebView web;
    private ValueCallback<Uri[]> uploadCallback;
    private static final int FILE_CHOOSER = 1001;
    @Override public void onCreate(Bundle b) {
        super.onCreate(b); requestWindowFeature(Window.FEATURE_NO_TITLE);
        web = new WebView(this);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setDatabaseEnabled(true);
        s.setAllowFileAccess(true); s.setAllowContentAccess(true); s.setMediaPlaybackRequiresUserGesture(false);
        s.setSupportZoom(false); s.setBuiltInZoomControls(false); s.setDisplayZoomControls(false);
        web.setWebChromeClient(new WebChromeClient() {
            @Override public boolean onShowFileChooser(WebView v, ValueCallback<Uri[]> cb, FileChooserParams p) {
                if (uploadCallback != null) uploadCallback.onReceiveValue(null); uploadCallback = cb;
                try { startActivityForResult(p.createIntent(), FILE_CHOOSER); } catch (Exception e) { uploadCallback=null; return false; }
                return true;
            }
        });
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("file:///android_asset/index.html"); setContentView(web);
    }
    @Override protected void onActivityResult(int req,int res,Intent data){ super.onActivityResult(req,res,data); if(req==FILE_CHOOSER && uploadCallback!=null){ Uri[] r=null; if(res==RESULT_OK && data!=null){ if(data.getData()!=null) r=new Uri[]{data.getData()}; else if(data.getClipData()!=null){ int n=data.getClipData().getItemCount(); r=new Uri[n]; for(int i=0;i<n;i++) r[i]=data.getClipData().getItemAt(i).getUri(); }} uploadCallback.onReceiveValue(r); uploadCallback=null; }}
    @Override public void onBackPressed(){ if(web.canGoBack()) web.goBack(); else super.onBackPressed(); }
}

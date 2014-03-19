package org.itri.html5webview;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

public class TestHTML5WebView extends Activity {
	
	HTML5WebView mWebView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView = new HTML5WebView(this);
        
        if (savedInstanceState != null) {
        	mWebView.restoreState(savedInstanceState);
        } else {
//        	mWebView.loadUrl("http://3g.163.com/ntes/special/0034073A/wechat_article.html?docid=9N3IMHLJ0001121M&from=singlemessage&isappinstalled=1");
        	mWebView.loadUrl("http://freebsd.csie.nctu.edu.tw/~freedom/html5/");
        	//mWebView.loadUrl("file:///data/bbench/index.html");
        }
        
        setContentView(mWebView.getLayout());
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	mWebView.saveState(outState);
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	mWebView.stopLoading();
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.inCustomView()) {
            	mWebView.hideCustomView();
            	return true;
            }
    	}
    	return super.onKeyDown(keyCode, event);
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
         super.onConfigurationChanged(newConfig);
    }
}
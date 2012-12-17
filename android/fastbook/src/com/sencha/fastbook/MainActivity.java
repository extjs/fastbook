package com.sencha.fastbook;

import android.os.Bundle;
import android.webkit.*;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	class NimbleKitClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        if(url.startsWith("http:") || url.startsWith("https:")) {
	            view.loadUrl(url);
	        }
	        return true;
	    }
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView webView = (WebView)findViewById(R.id.webView1);
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new NimbleKitClient());
		webView.getSettings().setPluginsEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        webView.getSettings().setDomStorageEnabled(true);
	    webView.getSettings().setDatabaseEnabled(true);
	    webView.loadUrl("http://fb.html5isready.com");
	    webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    	webView.requestFocus(View.FOCUS_DOWN);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

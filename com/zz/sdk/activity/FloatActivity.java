package com.zz.sdk.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.zz.sdk.FloatSoundCallback;
import com.zz.sdk.b;
import com.zz.sdk.e.al;
import com.zz.sdk.i.bj;
import com.zz.sdk.i.bp;
import java.io.File;

public class FloatActivity extends Activity implements b {
  private static final int g = 0;
  
  private static final int h = 1;
  
  private FloatSoundCallback a;
  
  private ValueCallback b;
  
  private ValueCallback c;
  
  private boolean d = false;
  
  private Intent e;
  
  private String f = "zzsdkshare";
  
  @SuppressLint({"NewApi"})
  public void a() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    builder.setOnCancelListener(new c(this));
    builder.setTitle("选择");
    d d = new d(this);
    builder.setItems((CharSequence[])new String[] { "相册", "拍照" }, d);
    builder.show();
  }
  
  public void a(ValueCallback paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams) {
    this.c = paramValueCallback;
    this.d = true;
    a();
  }
  
  public void a(ValueCallback paramValueCallback, String paramString) {
    this.b = paramValueCallback;
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 != -1) {
      if (this.b != null) {
        this.b.onReceiveValue(null);
        this.b = null;
      } 
      if (this.c != null) {
        this.c.onReceiveValue(null);
        this.c = null;
      } 
    } 
    switch (paramInt1) {
      default:
        return;
      case 0:
      case 1:
        break;
    } 
    try {
      if (this.b != null || this.c != null) {
        String str = bj.a((Context)this, this.e, paramIntent);
        if (!TextUtils.isEmpty(str)) {
          File file = new File();
          this(str);
          if (file.exists()) {
            file = new File();
            this(str);
            Uri uri = Uri.fromFile(file);
            if (this.d && this.c != null) {
              this.c.onReceiveValue(new Uri[] { uri });
              this.c = null;
            } 
            if (this.b != null) {
              this.b.onReceiveValue(uri);
              this.b = null;
            } 
            if (this.c != null) {
              this.c.onReceiveValue(new Uri[] { uri });
              this.c = null;
            } 
          } 
        } 
        bp.b("sourcePath empty or not exists.");
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      if (this.b != null) {
        this.b.onReceiveValue(null);
        this.b = null;
      } 
      if (this.c != null) {
        this.c.onReceiveValue(null);
        this.c = null;
      } 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.a = (FloatSoundCallback)BaseActivity.a().get("com.zz.sdk.float.callback");
    Intent intent = getIntent();
    setContentView((View)new al((Context)this, intent.getIntExtra("num", 1), intent.getStringExtra("url"), this));
  }
  
  protected void onResume() {
    super.onResume();
    if (this.a != null)
      this.a.onStartFloat(); 
  }
  
  protected void onStop() {
    super.onStop();
    if (this.a != null)
      this.a.onExitFloat(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\activity\FloatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
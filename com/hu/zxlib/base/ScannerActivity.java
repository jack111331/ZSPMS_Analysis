package com.hu.zxlib.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.zxing.Result;
import com.hu.zxlib.a.a;
import com.hu.zxlib.b.e;
import com.hu.zxlib.c.e;
import com.hu.zxlib.c.g;
import com.hu.zxlib.common.b;
import com.hu.zxlib.view.ViewfinderView;
import java.io.IOException;

public class ScannerActivity extends Activity implements SurfaceHolder.Callback, View.OnClickListener {
  private static final String b = "ScannerActivity";
  
  public a a;
  
  private SurfaceView c;
  
  private ViewfinderView d;
  
  private ImageView e;
  
  private LinearLayout f;
  
  private LinearLayout g;
  
  private boolean h;
  
  private e i;
  
  private a j;
  
  private e k;
  
  private b l;
  
  private SurfaceHolder m;
  
  private void a(SurfaceHolder paramSurfaceHolder) {
    if (paramSurfaceHolder != null) {
      if (this.k.a())
        return; 
      try {
        this.k.a(paramSurfaceHolder);
        if (this.l == null) {
          b b1 = new b();
          this(this, this.k);
          this.l = b1;
        } 
      } catch (IOException iOException) {
        Log.w(b, iOException);
        f();
      } catch (RuntimeException runtimeException) {
        Log.w(b, "Unexpected error initializing camera", runtimeException);
      } 
      return;
    } 
    throw new IllegalStateException("No SurfaceHolder provided");
  }
  
  private void a(View paramView, boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    paramView.setVisibility(b1);
  }
  
  private void e() {
    this.c = (SurfaceView)findViewById(b.g((Context)this, "zx_preview_view"));
    this.c.setOnClickListener(this);
    this.d = (ViewfinderView)findViewById(b.g((Context)this, "zx_viewfinder_view"));
    this.d.setZxingConfig(this.a);
    this.e = (ImageView)findViewById(b.g((Context)this, "zx_backIv"));
    this.e.setOnClickListener(this);
    this.f = (LinearLayout)findViewById(b.g((Context)this, "zx_albumLayout"));
    this.f.setOnClickListener(this);
    this.g = (LinearLayout)findViewById(b.g((Context)this, "zx_bottomLayout"));
    a((View)this.g, this.a.f());
    a((View)this.f, this.a.g());
  }
  
  private void f() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    builder.setTitle("扫一扫");
    builder.setMessage(getString(b.d((Context)this, "zx_msg_camera_framework_bug")));
    builder.setPositiveButton(b.d((Context)this, "zx_button_ok"), new d(this));
    builder.setOnCancelListener(new d(this));
    builder.show();
  }
  
  public ViewfinderView a() {
    return this.d;
  }
  
  public void a(Result paramResult) {
    this.i.a();
    this.j.b();
    Intent intent = getIntent();
    intent.putExtra("codedContent", paramResult.getText());
    setResult(-1, intent);
    finish();
  }
  
  public Handler b() {
    return this.l;
  }
  
  public e c() {
    return this.k;
  }
  
  public void d() {
    this.d.a();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10 && paramInt2 == -1)
      (new e(g.a((Context)this, paramIntent.getData()), new p(this))).run(); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == b.g((Context)this, "zx_albumLayout")) {
      Intent intent = new Intent();
      intent.setAction("android.intent.action.PICK");
      intent.setType("image/*");
      startActivityForResult(intent, 10);
    } else if (i == b.g((Context)this, "zx_backIv")) {
      finish();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Window window = getWindow();
    window.addFlags(128);
    if (Build.VERSION.SDK_INT >= 21)
      window.setStatusBarColor(-16777216); 
    try {
      this.a = (a)getIntent().getExtras().get("zxingConfig");
    } catch (Exception exception) {
      Log.i("config", exception.toString());
    } 
    if (this.a == null)
      this.a = new a(); 
    setContentView(b.h((Context)this, "zx_activity_capture"));
    e();
    this.h = false;
    this.i = new e(this);
    this.j = new a(this);
    this.j.a(this.a.d());
    this.j.b(this.a.e());
  }
  
  protected void onDestroy() {
    this.i.d();
    super.onDestroy();
  }
  
  protected void onPause() {
    if (this.l != null) {
      this.l.a();
      this.l = null;
    } 
    this.i.b();
    this.j.close();
    this.k.b();
    if (!this.h)
      this.m.removeCallback(this); 
    super.onPause();
  }
  
  protected void onResume() {
    super.onResume();
    this.k = new e((Context)getApplication(), this.a);
    this.d.setCameraManager(this.k);
    this.l = null;
    this.m = this.c.getHolder();
    if (this.h) {
      a(this.m);
    } else {
      this.m.addCallback(this);
    } 
    this.j.a();
    this.i.c();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    if (!this.h) {
      this.h = true;
      a(paramSurfaceHolder);
    } 
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    this.h = false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\ScannerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
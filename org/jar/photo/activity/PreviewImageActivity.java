package org.jar.photo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jar.bloc.R;
import org.jar.bloc.usercenter.d.s;
import org.jar.bloc.utils.ResUtils;
import org.jar.photo.bean.b;
import org.jar.photo.d.b;
import org.jar.photo.zoom.ImageViewTouch;
import org.jar.photo.zoom.ImageViewTouchBase;
import org.jar.support.v4.view.PagerAdapter;
import org.jar.support.v4.view.ViewPager;

public class PreviewImageActivity extends Activity implements View.OnClickListener {
  private ViewPager a;
  
  private View b;
  
  private TextView c;
  
  private boolean d = true;
  
  private View e;
  
  private LinearLayout f;
  
  private ImageView g;
  
  private TextView h;
  
  private List<b> i;
  
  private List<b> j;
  
  private int k;
  
  private void a() {
    List<b> list;
    List<? extends b> list1;
    this.i = new ArrayList<b>();
    this.j = org.jar.photo.b.a.a().c();
    if (getIntent().getBooleanExtra("preview", false)) {
      list = this.i;
      list1 = org.jar.photo.b.a.a().c();
    } else {
      list = this.i;
      list1 = org.jar.photo.b.a.a().b();
    } 
    list.addAll(list1);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3) {
    try {
      Intent intent = new Intent();
      this((Context)paramActivity, PreviewImageActivity.class);
      intent.putExtra("position", paramInt1);
      intent.putExtra("maxCount", paramInt2);
      paramActivity.startActivityForResult(intent, paramInt3);
      paramActivity.overridePendingTransition(ResUtils.id((Context)paramActivity, R.anim.bloc_photo_scale_small_to_large), 0);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  private void b() {
    boolean bool;
    this.f = (LinearLayout)findViewById(ResUtils.id((Context)this, R.id.ll_photo_operation));
    this.g = (ImageView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_back));
    this.g.setOnClickListener(this);
    s.a((View)this.g, 0, 0, 0, 100);
    findViewById(ResUtils.id((Context)this, R.id.tv_photo_scan)).setOnClickListener(this);
    this.b = findViewById(ResUtils.id((Context)this, R.id.rl_check));
    this.b.setOnClickListener(this);
    this.c = (TextView)findViewById(ResUtils.id((Context)this, R.id.ctv_check));
    TextView textView = this.c;
    if (((b)this.i.get(getIntent().getIntExtra("position", 0))).d > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    textView.setEnabled(bool);
    this.e = findViewById(ResUtils.id((Context)this, R.id.ll_photo_bottom_operation));
    this.e.setOnClickListener(this);
    this.h = (TextView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_ok));
    this.h.setText(String.format(getResources().getString(ResUtils.id((Context)this, R.string.photo_ok)), new Object[] { Integer.valueOf(this.j.size()), Integer.valueOf(this.k) }));
    this.h.setOnClickListener(this);
    this.a = (ViewPager)findViewById(ResUtils.id((Context)this, R.id.vp_preview));
  }
  
  public static void b(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3) {
    try {
      Intent intent = new Intent();
      this((Context)paramActivity, PreviewImageActivity.class);
      intent.putExtra("preview", true);
      intent.putExtra("position", paramInt1);
      intent.putExtra("maxCount", paramInt2);
      paramActivity.startActivityForResult(intent, paramInt3);
      paramActivity.overridePendingTransition(ResUtils.id((Context)paramActivity, R.anim.bloc_photo_scale_small_to_large), 0);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  private void c() {
    int i = this.j.size();
    byte b = 0;
    while (b < i) {
      b b1 = this.j.get(b);
      b1.d = ++b;
    } 
  }
  
  private void d() {
    this.a = (ViewPager)findViewById(ResUtils.id((Context)this, R.id.vp_preview));
    a a = new a(this, this.i);
    this.a.setAdapter(a);
    this.a.setPageMargin(5);
    this.a.setCurrentItem(getIntent().getIntExtra("position", 0));
    this.a.addOnPageChangeListener(new a(this));
  }
  
  private void e() {
    b b = this.i.get(this.a.getCurrentItem());
    if (this.j.contains(b)) {
      this.j.remove(b);
      c();
      this.c.setEnabled(false);
    } else {
      if (this.j.size() >= this.k) {
        Toast.makeText((Context)this, getResources().getString(ResUtils.id((Context)this, R.string.publish_select_photo_max), new Object[] { Integer.valueOf(this.k) }), 0).show();
        return;
      } 
      this.j.add(b);
      b.d = this.j.size();
      this.c.setEnabled(true);
    } 
    this.h.setText(String.format(getResources().getString(ResUtils.id((Context)this, R.string.photo_ok)), new Object[] { Integer.valueOf(this.j.size()), Integer.valueOf(this.k) }));
  }
  
  private void f() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setDuration(500L);
    this.d = true;
    this.f.startAnimation((Animation)alphaAnimation);
    this.f.setVisibility(0);
    this.e.startAnimation((Animation)alphaAnimation);
    this.e.setVisibility(0);
  }
  
  private void g() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setDuration(500L);
    this.d = false;
    this.f.startAnimation((Animation)alphaAnimation);
    this.f.setVisibility(8);
    this.e.startAnimation((Animation)alphaAnimation);
    this.e.setVisibility(8);
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    org.jar.photo.b.a.a().d();
    overridePendingTransition(0, ResUtils.id((Context)this, R.anim.bloc_photo_scale_large_to_small));
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == ResUtils.id((Context)this, R.id.rl_check)) {
      e();
    } else {
      if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_back) || paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_scan)) {
        onBackPressed();
        return;
      } 
      if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_ok)) {
        if (getIntent().getBooleanExtra("preview", false)) {
          Intent intent = getIntent();
          ArrayList arrayList = new ArrayList();
          arrayList.addAll(org.jar.photo.b.a.a().c());
          intent.putExtra("list", arrayList);
          setResult(-1, intent);
        } else {
          setResult(-1);
        } 
        finish();
      } 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(ResUtils.id((Context)this, R.layout.bloc_photo_preview_image_activity));
    this.k = getIntent().getIntExtra("maxCount", 9);
    a();
    b();
    d();
    getWindow().addFlags(1024);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (getIntent().getBooleanExtra("preview", false)) {
      org.jar.photo.b.a.a().f();
      org.jar.photo.b.a.a().e();
    } 
  }
  
  class a extends PagerAdapter {
    private List<b> b;
    
    public a(PreviewImageActivity this$0, List<b> param1List) {
      this.b = param1List;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return this.b.size();
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      View view = LayoutInflater.from((Context)this.a).inflate(ResUtils.id((Context)this.a, R.layout.bloc_photo_preview_image_item), param1ViewGroup, false);
      ImageViewTouch imageViewTouch = (ImageViewTouch)view.findViewById(ResUtils.id((Context)this.a, R.id.iv_image_item));
      imageViewTouch.setDisplayType(ImageViewTouchBase.a.b);
      imageViewTouch.setSingleTapListener(new b(this));
      Uri uri = Uri.fromFile(new File(((b)this.b.get(param1Int)).a));
      Point point = org.jar.photo.d.a.a(this.a, uri);
      b.a((Context)this.a, point.x, point.y, (ImageView)imageViewTouch, uri);
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      boolean bool;
      if (param1View == param1Object) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\PreviewImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
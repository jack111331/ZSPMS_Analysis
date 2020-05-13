package org.jar.photo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import org.jar.bloc.R;
import org.jar.bloc.usercenter.d.s;
import org.jar.bloc.utils.ResUtils;
import org.jar.photo.a.d;
import org.jar.photo.b.a;
import org.jar.photo.c.a;
import org.jar.photo.d.b;
import org.jar.support.v7.widget.DefaultItemAnimator;
import org.jar.support.v7.widget.RecyclerView;
import org.jar.support.v7.widget.StaggeredGridLayoutManager;

public class ImageSelectActivity extends Activity implements Handler.Callback, View.OnClickListener, Observer, a {
  private final int a = 10;
  
  private final int b = 11;
  
  private d c;
  
  private Handler d;
  
  private TextView e;
  
  private TextView f;
  
  private boolean g;
  
  private String h;
  
  private int i;
  
  private void a() {
    b.a((Context)this, getIntent().getStringExtra("data"), this.d, 11);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) {
    try {
      Intent intent = new Intent();
      this((Context)paramActivity, ImageSelectActivity.class);
      intent.putExtra("folder_name", paramString1);
      intent.putExtra("data", paramString2);
      intent.putExtra("single", paramBoolean);
      intent.putExtra("maxCount", paramInt1);
      paramActivity.startActivityForResult(intent, paramInt2);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  private void b() {
    RecyclerView recyclerView = (RecyclerView)findViewById(ResUtils.id((Context)this, R.id.lv_photo_folder));
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)new StaggeredGridLayoutManager(5, 1));
    recyclerView.setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
    recyclerView.setHasFixedSize(true);
    this.c = new d((Context)this, a.a().b(), this.g, this.i);
    this.c.a(this);
    recyclerView.setAdapter((RecyclerView.Adapter)this.c);
    ImageView imageView = (ImageView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_back));
    imageView.setOnClickListener(this);
    s.a((View)imageView, 0, 0, 0, 100);
    this.e = (TextView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_ok));
    this.e.setText(String.format(getResources().getString(ResUtils.id((Context)this, R.string.photo_ok)), new Object[] { Integer.valueOf(this.c.a().size()), Integer.valueOf(this.i) }));
    ((TextView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_scan))).setText(this.h);
    findViewById(ResUtils.id((Context)this, R.id.tv_photo_scan)).setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f = (TextView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_cancle));
    this.f.setOnClickListener(this);
  }
  
  public void a(View paramView, int paramInt) {
    if (this.g) {
      setResult(-1);
      finish();
      return;
    } 
    if (paramInt >= 0)
      PreviewImageActivity.a(this, paramInt, this.i, 10); 
    this.e.setText(getResources().getString(ResUtils.id((Context)this, R.string.photo_ok), new Object[] { Integer.valueOf(this.c.a().size()), Integer.valueOf(this.i) }));
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 11) {
      a.a().a((Collection)paramMessage.obj);
      this.c.notifyDataSetChanged();
    } 
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 10) {
      setResult(-1);
      finish();
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_scan)) {
      onBackPressed();
      return;
    } 
    if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_ok)) {
      setResult(-1);
    } else {
      if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_back)) {
        onBackPressed();
        return;
      } 
      if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_cancle)) {
        Intent intent = new Intent();
        intent.putExtra("code", 1);
        setResult(-1, intent);
      } else {
        return;
      } 
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(ResUtils.id((Context)this, R.layout.bloc_photo_gridview_main));
    this.h = getIntent().getStringExtra("folder_name");
    this.i = getIntent().getIntExtra("maxCount", 9);
    a.a().addObserver(this);
    this.d = new Handler(this);
    this.g = getIntent().getBooleanExtra("single", false);
    b();
    a();
    if (this.g)
      findViewById(ResUtils.id((Context)this, R.id.ll_photo_operation)).setVisibility(8); 
  }
  
  protected void onDestroy() {
    a.a().deleteObserver(this);
    super.onDestroy();
  }
  
  public void update(Observable paramObservable, Object paramObject) {
    this.c.notifyDataSetChanged();
    this.e.setText(getResources().getString(ResUtils.id((Context)this, R.string.photo_ok), new Object[] { Integer.valueOf(this.c.a().size()), Integer.valueOf(this.i) }));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\ImageSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
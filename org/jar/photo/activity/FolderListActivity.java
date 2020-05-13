package org.jar.photo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.jar.bloc.R;
import org.jar.bloc.usercenter.d.s;
import org.jar.bloc.utils.ResUtils;
import org.jar.bloc.widget.decorator.RecycleViewDivider;
import org.jar.photo.a.b;
import org.jar.photo.b.a;
import org.jar.photo.bean.b;
import org.jar.photo.c.a;
import org.jar.photo.d.b;
import org.jar.support.v7.widget.DefaultItemAnimator;
import org.jar.support.v7.widget.LinearLayoutManager;
import org.jar.support.v7.widget.RecyclerView;

public class FolderListActivity extends Activity implements Handler.Callback, View.OnClickListener, a {
  public static int b = 9;
  
  ArrayList<b> a;
  
  private b c;
  
  private Handler d;
  
  private final int e = 10;
  
  private final int f = 22;
  
  private RecyclerView g;
  
  private boolean h = false;
  
  private void a() {
    ImageView imageView = (ImageView)findViewById(ResUtils.id((Context)this, R.id.tv_photo_back));
    imageView.setOnClickListener(this);
    s.a((View)imageView, 0, 0, 0, 100);
    findViewById(ResUtils.id((Context)this, R.id.tv_photo_scan)).setOnClickListener(this);
    this.g = (RecyclerView)findViewById(ResUtils.id((Context)this, R.id.lv_photo_folder));
    this.g.setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
    this.g.addItemDecoration((RecyclerView.ItemDecoration)new RecycleViewDivider((Context)this, 0, 2, Color.parseColor("#eeeeee")));
    this.g.setHasFixedSize(true);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
    this.g.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
  }
  
  public void a(View paramView, int paramInt) {
    File file = new File(((b)this.a.get(paramInt)).a);
    ImageSelectActivity.a(this, ((b)this.a.get(paramInt)).c, file.getParentFile().getAbsolutePath(), this.h, b, 22);
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 10) {
      this.a.clear();
      this.a.addAll((Collection<? extends b>)paramMessage.obj);
      this.c.notifyDataSetChanged();
    } 
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 22) {
      if (paramIntent != null && paramIntent.getIntExtra("code", 0) == 1) {
        finish();
        return;
      } 
      paramIntent = getIntent();
      ArrayList arrayList = new ArrayList();
      arrayList.addAll(a.a().c());
      paramIntent.putExtra("list", arrayList);
      setResult(-1, paramIntent);
      finish();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_back) || paramView.getId() == ResUtils.id((Context)this, R.id.tv_photo_scan))
      onBackPressed(); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.d = new Handler(this);
    this.a = new ArrayList<b>();
    b = getIntent().getIntExtra("max_num", 9);
    this.h = getIntent().getBooleanExtra("single", false);
    setContentView(ResUtils.id((Context)this, R.layout.bloc_photo_folder_main));
    a();
    b.a(this, this.d, 10);
    a.a().b((ArrayList)getIntent().getSerializableExtra("list"));
    this.c = new b((Context)this, this.a);
    this.g.setAdapter((RecyclerView.Adapter)this.c);
    this.c.a(this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    a.a().f();
    a.a().e();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\FolderListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
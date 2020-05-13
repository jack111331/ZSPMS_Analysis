package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.i.bx;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import java.io.File;
import java.util.Map;

public class hl extends w implements View.OnClickListener {
  public static final String a = "account";
  
  public static final String n = "password";
  
  protected static final int o = 0;
  
  protected static final int p = 1;
  
  protected static final int q = 2;
  
  private t A;
  
  private Handler B = new hn(this);
  
  private cq r;
  
  private String s;
  
  private String t;
  
  private TextView u;
  
  private TextView x;
  
  private ho y;
  
  private boolean z;
  
  public hl(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void G() {
    if (this.y != null)
      this.y.show(); 
  }
  
  private void H() {
    if (this.y != null && this.y.isShowing())
      this.y.cancel(); 
  }
  
  private File a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 'mounted'
    //   4: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   7: invokevirtual equals : (Ljava/lang/Object;)Z
    //   10: ifne -> 17
    //   13: aload_3
    //   14: astore_1
    //   15: aload_1
    //   16: areturn
    //   17: new java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: astore #4
    //   27: aload #4
    //   29: invokevirtual isFile : ()Z
    //   32: ifeq -> 45
    //   35: aload_3
    //   36: astore_1
    //   37: aload #4
    //   39: invokevirtual delete : ()Z
    //   42: ifeq -> 15
    //   45: aload #4
    //   47: invokevirtual exists : ()Z
    //   50: ifeq -> 61
    //   53: aload #4
    //   55: invokevirtual isFile : ()Z
    //   58: ifeq -> 71
    //   61: aload_3
    //   62: astore_1
    //   63: aload #4
    //   65: invokevirtual mkdirs : ()Z
    //   68: ifeq -> 15
    //   71: aload_2
    //   72: ifnonnull -> 87
    //   75: ldc 'cache_'
    //   77: aconst_null
    //   78: aload #4
    //   80: invokestatic createTempFile : (Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   83: astore_1
    //   84: goto -> 15
    //   87: new java/io/File
    //   90: dup
    //   91: aload #4
    //   93: aload_2
    //   94: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   97: astore_1
    //   98: goto -> 15
  }
  
  private void a(Context paramContext) {
    if (!bx.b(paramContext)) {
      Message message = Message.obtain();
      message.what = 2;
      this.B.sendMessage(message);
      return;
    } 
    (new Thread(new hm(this))).start();
  }
  
  private void b(Context paramContext) {
    cq cq1 = cq.a((Context)this.b);
    int i = cq1.d();
    int j = cq1.e();
    if (i == 3 && j == 3)
      this.z = true; 
    if (cq1.o() == 1 || cq1.o() == 2)
      this.z = true; 
    if (this.z) {
      String str = cq.a((Context)this.b).a();
      if (str != null && str.length() > 0) {
        j = 1;
      } else {
        j = 0;
      } 
      if (cv.h() == null) {
        i = 0;
      } else {
        i = cv.h().j().c();
      } 
      if (i == 0) {
        i = 0;
      } else {
        i = 1;
      } 
      if (j != 0 || i == 0) {
        bv.a((Activity)paramContext, ha.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        return;
      } 
      bv.a((Activity)paramContext, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
      return;
    } 
    bs.b(paramContext);
  }
  
  public String F() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/Date
    //   5: astore_1
    //   6: aload_1
    //   7: invokestatic currentTimeMillis : ()J
    //   10: invokespecial <init> : (J)V
    //   13: new java/text/SimpleDateFormat
    //   16: astore_2
    //   17: aload_2
    //   18: ldc 'yyyyMMddHHmmssSSS'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   28: astore_2
    //   29: new java/lang/StringBuilder
    //   32: astore_1
    //   33: aload_1
    //   34: invokespecial <init> : ()V
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w '.png'
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual toString : ()Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   2	52	56	finally
  }
  
  void a() {
    setTitle(2131165407);
    findViewById(2131296477).setOnClickListener(this);
    findViewById(2131296478).setOnClickListener(this);
    this.u = (TextView)findViewById(2131296475);
    this.x = (TextView)findViewById(2131296476);
    c(false);
    d(true);
    this.A = t.a((Context)this.b);
    this.r = cq.a((Context)this.b);
    this.u.setText(this.s);
    this.x.setText(this.t);
    this.y = new ho(this, (Context)this.b);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.s = (String)a("account", (Object)null);
    this.t = (String)a("password", (Object)null);
  }
  
  int c() {
    return 2130903087;
  }
  
  protected void i() {
    b((Context)this.b);
  }
  
  protected int j() {
    return 2130903139;
  }
  
  protected void l() {
    t.a((Context)this.b).b("Save_platform", "Save_enter", 1);
  }
  
  public void onBackPressed() {
    i();
  }
  
  public void onClick(View paramView) {
    boolean bool = false;
    if (this.r.p() == 1)
      bool = true; 
    switch (a(paramView)) {
      default:
        return;
      case 2131296477:
        t.a((Context)this.b).b("Save_platform", "Save_bind_click", 1);
        bv.a(this.b, gu.class, bv.a().a("key_show_back", Boolean.valueOf(true)).a("KEY_NEED_ALIAS", Boolean.valueOf(bool)).a("action", "upgradeAccount"));
      case 2131296478:
        break;
    } 
    t.a((Context)this.b).b("Save_platform", "Save_save_click", 1);
    G();
    a((Context)this.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
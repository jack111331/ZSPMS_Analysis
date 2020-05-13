package com.zz.sdk.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.zz.a.a.c.t;
import com.zz.a.a.c.v;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ah;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cg;
import com.zz.sdk.lib.widget.c;
import com.zz.sdk.lib.widget.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class x extends k {
  static final boolean p = false;
  
  private static final int q = 20;
  
  private static final String t = "thumbs";
  
  private g A = new ab(this);
  
  private c r;
  
  private Handler s;
  
  private int u;
  
  private af v;
  
  private v w;
  
  private int x;
  
  private int y;
  
  private List z = new ArrayList();
  
  public x(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private void a(a parama) {
    ah ah;
    if (parama.c() && parama instanceof ah) {
      ah = (ah)parama;
      int i = ah.o;
      for (byte b = 0; b < i; b++)
        this.z.add(ah.p[b]); 
      this.v.a(this.z);
      if (i < this.y)
        this.x = this.z.size(); 
    } else if (ah.e()) {
      a(ah.f());
    } else {
      a(cg.al);
    } 
    this.r.a();
    this.r.d();
    this.r.setRefreshTime((new Date()).toLocaleString());
  }
  
  private void b(int paramInt) {
    bf bf = getHost();
    if (bf != null) {
      Object object = this.v.getItem(paramInt);
      if (object instanceof com.zz.sdk.b.q) {
        object = object;
        ParamChain paramChain = getEnv();
        paramChain.add("global.exchangeLayout.info", object);
        paramChain.add("global.exchangeLayout.id", Integer.valueOf(paramInt));
        bf.a(getClass().getClassLoader(), t.class.getName(), paramChain);
      } 
    } 
  }
  
  private void y() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getCurrentTask : ()Landroid/os/AsyncTask;
    //   6: ifnull -> 17
    //   9: ldc 'task is running'
    //   11: invokestatic a : (Ljava/lang/Object;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: new com/zz/sdk/e/aa
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: invokespecial <init> : (Lcom/zz/sdk/e/x;)V
    //   26: aload_0
    //   27: aload_0
    //   28: invokevirtual getConnectionUtil : ()Lcom/zz/sdk/i/t;
    //   31: aload_1
    //   32: aload_0
    //   33: aload_0
    //   34: getfield x : I
    //   37: aload_0
    //   38: getfield y : I
    //   41: invokestatic a : (Lcom/zz/sdk/i/t;Lcom/zz/sdk/e/g;Ljava/lang/Object;II)Landroid/os/AsyncTask;
    //   44: invokevirtual setCurrentTask : (Landroid/os/AsyncTask;)V
    //   47: goto -> 14
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	50	finally
    //   17	47	50	finally
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    super.a(paramContext, paramParamChain);
    this.x = 0;
    this.y = 20;
    this.u = cc.v.a();
    t t = new t(this.f, "thumbs");
    t.a(0.25F);
    this.w = new v(this.f, this.u);
    this.w.a(ca.aV.b(this.f));
    this.w.a(getEnv().getRoot(), t);
  }
  
  protected void b(Context paramContext) {
    d(paramContext);
    this.s = new Handler();
    c c1 = new c(paramContext);
    c1.setOnRefreshEventListener(this.A);
    c1.setPullRefreshEnable(false);
    c1.setPullLoadEnable(true);
    c1.c();
    c1.setDivider(null);
    c1.setDividerHeight(16);
    getSubjectContainer().addView((View)c1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.r = c1;
    c1.setOnItemClickListener(new y(this));
    c1.setOnScrollListener(new z(this));
    this.v = new af(this, paramContext, cg.Y.a(), this.z);
    c1.setAdapter((ListAdapter)this.v);
    setTileTypeText(cg.bx.a());
  }
  
  public boolean j() {
    return super.j();
  }
  
  public boolean k() {
    boolean bool = super.k();
    if (this.w != null) {
      this.w.c(false);
      this.w.b(true);
      this.w.h();
    } 
    return bool;
  }
  
  public boolean l() {
    boolean bool = super.l();
    if (this.w != null)
      this.w.b(false); 
    if (this.v != null)
      this.v.notifyDataSetChanged(); 
    return bool;
  }
  
  public boolean n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial n : ()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 37
    //   11: aload_0
    //   12: getfield w : Lcom/zz/a/a/c/v;
    //   15: ifnull -> 25
    //   18: aload_0
    //   19: getfield w : Lcom/zz/a/a/c/v;
    //   22: invokevirtual i : ()V
    //   25: aload_0
    //   26: getfield z : Ljava/util/List;
    //   29: ifnull -> 37
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield z : Ljava/util/List;
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_1
    //   40: ireturn
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	41	finally
    //   11	25	41	finally
    //   25	37	41	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
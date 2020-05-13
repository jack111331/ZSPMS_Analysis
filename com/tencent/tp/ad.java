package com.tencent.tp;

import android.content.Context;
import android.os.AsyncTask;

class ad extends AsyncTask {
  private static boolean f;
  
  private Context a;
  
  private boolean b;
  
  private boolean c;
  
  private boolean d;
  
  private boolean e;
  
  public ad(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    this.a = paramContext;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
  }
  
  protected Void a(Void... paramVarArgs) {
    try {
      ab ab = new ab();
      this(this.b, this.c, this.d);
      ab.a(this.a.getApplicationContext());
      if (this.c)
        p.b(this.a.getApplicationContext()); 
      if (!f && this.c) {
        f = true;
        ab.a(this.a.getApplicationContext(), this.d);
      } 
      if (this.e)
        l.a().a(this.a); 
    } catch (Exception exception) {}
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
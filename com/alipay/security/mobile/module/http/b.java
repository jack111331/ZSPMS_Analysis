package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

public final class b implements a {
  private static b d = null;
  
  private static DataReportResult e;
  
  private w a = null;
  
  private BugTrackMessageService b = null;
  
  private DataReportService c = null;
  
  private b(Context paramContext, String paramString) {
    aa aa = new aa();
    aa.a(paramString);
    this.a = (w)new h(paramContext);
    this.b = (BugTrackMessageService)this.a.a(BugTrackMessageService.class, aa);
    this.c = (DataReportService)this.a.a(DataReportService.class, aa);
  }
  
  public static b a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/security/mobile/module/http/b
    //   2: monitorenter
    //   3: getstatic com/alipay/security/mobile/module/http/b.d : Lcom/alipay/security/mobile/module/http/b;
    //   6: ifnonnull -> 23
    //   9: new com/alipay/security/mobile/module/http/b
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   19: aload_2
    //   20: putstatic com/alipay/security/mobile/module/http/b.d : Lcom/alipay/security/mobile/module/http/b;
    //   23: getstatic com/alipay/security/mobile/module/http/b.d : Lcom/alipay/security/mobile/module/http/b;
    //   26: astore_0
    //   27: ldc com/alipay/security/mobile/module/http/b
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/alipay/security/mobile/module/http/b
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	32	finally
    //   23	27	32	finally
  }
  
  public final DataReportResult a(DataReportRequest paramDataReportRequest) {
    if (this.c != null) {
      e = null;
      (new Thread(new c(this, paramDataReportRequest))).start();
      for (int i = 300000; e == null && i >= 0; i -= 50)
        Thread.sleep(50L); 
    } 
    return e;
  }
  
  public final boolean a(String paramString) {
    boolean bool = false;
    if (!a.a(paramString)) {
      if (this.b != null) {
        Throwable throwable = null;
        try {
          paramString = this.b.logCollect(a.f(paramString));
          if (!a.a(paramString))
            return ((Boolean)(new JSONObject(paramString)).get("success")).booleanValue(); 
        } catch (Throwable throwable1) {
          throwable1 = throwable;
          if (!a.a((String)throwable1))
            return ((Boolean)(new JSONObject((String)throwable1)).get("success")).booleanValue(); 
        } 
      } 
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\http\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
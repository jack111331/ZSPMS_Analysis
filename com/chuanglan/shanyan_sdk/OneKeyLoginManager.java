package com.chuanglan.shanyan_sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener;
import com.chuanglan.shanyan_sdk.listener.InitListener;
import com.chuanglan.shanyan_sdk.listener.OnClickPrivacyListener;
import com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener;
import com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener;
import com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig;
import com.chuanglan.shanyan_sdk.tool.a;
import com.chuanglan.shanyan_sdk.tool.e;
import com.chuanglan.shanyan_sdk.tool.g;
import com.chuanglan.shanyan_sdk.tool.h;
import com.chuanglan.shanyan_sdk.tool.i;
import com.chuanglan.shanyan_sdk.tool.j;
import com.chuanglan.shanyan_sdk.tool.k;
import com.chuanglan.shanyan_sdk.tool.l;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity;
import com.chuanglan.shanyan_sdk.view.a;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.utils.rglistener.CustomInterface;
import com.sdk.base.module.manager.SDKManager;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OneKeyLoginManager {
  private static OneKeyLoginManager a = null;
  
  private Context b;
  
  private AuthnHelper c;
  
  private OneKeyLoginListener d;
  
  private OpenLoginAuthListener e;
  
  private InitListener f;
  
  private GetPhoneInfoListener g;
  
  private ExecutorService h;
  
  private ShanYanUIConfig i = null;
  
  private ArrayList<a> j = null;
  
  private boolean k;
  
  private void a() {
    g.a().a(new g.a(this) {
          private long b;
          
          private String c;
          
          public void a(int param1Int) {
            b.v = 1;
          }
          
          public void a(int param1Int1, int param1Int2, String param1String1, String param1String2, String param1String3, String param1String4) {
            b.v = 0;
            boolean bool = true;
            switch (param1Int2) {
              default:
                this.b = SystemClock.uptimeMillis() - b.E;
                OneKeyLoginManager.b(this.a, param1Int1, param1String1);
                this.c = b.D + "";
                e.a().a(param1Int1, param1Int2, "1", "0", param1String1, this.c, this.b, this.b, param1String3, param1String4, true, bool);
                L.d("ProcessLogger", "InitFailEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1String3 + "innerDesc==" + param1String4);
                return;
              case 3:
                this.a.ShanyanAuthListenerGetPhoneCode(param1Int1, param1String1);
                this.c = b.I + "";
                this.b = SystemClock.uptimeMillis() - b.J;
                bool = false;
                e.a().a(param1Int1, param1Int2, "1", "0", param1String1, this.c, this.b, this.b, param1String3, param1String4, true, bool);
                L.d("ProcessLogger", "InitFailEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1String3 + "innerDesc==" + param1String4);
                return;
              case 2:
                break;
            } 
            OneKeyLoginManager.a(this.a, param1Int1, param1String1);
            this.c = b.F + "";
            this.b = SystemClock.uptimeMillis() - b.G;
            e.a().a(param1Int1, param1Int2, "1", "0", param1String1, this.c, this.b, this.b, param1String3, param1String4, true, bool);
            L.d("ProcessLogger", "InitFailEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1String3 + "innerDesc==" + param1String4);
          }
          
          public void a(int param1Int1, int param1Int2, String param1String1, String param1String2, boolean param1Boolean) {
            b.v = 2;
            switch (param1Int2) {
              default:
                OneKeyLoginManager.b(this.a, param1Int1, param1String1);
                this.c = b.D + "";
                this.b = SystemClock.uptimeMillis() - b.E;
                e.a().a(param1Int1, param1Int2, "1", "1", param1String1, this.c, this.b, this.b, param1Int1 + "", param1String2, true, param1Boolean);
                L.d("ProcessLogger", "InitSuccessEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1Int1 + "innerDesc=" + param1String2);
                return;
              case 3:
                this.b = SystemClock.uptimeMillis() - b.J;
                this.c = b.I + "";
                h.a().b(OneKeyLoginManager.a(this.a), OneKeyLoginManager.b(this.a));
                e.a().a(param1Int1, param1Int2, "1", "1", param1String1, this.c, this.b, this.b, param1Int1 + "", param1String2, true, param1Boolean);
                L.d("ProcessLogger", "InitSuccessEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1Int1 + "innerDesc=" + param1String2);
                return;
              case 2:
                break;
            } 
            this.b = SystemClock.uptimeMillis() - b.G;
            this.c = b.F + "";
            k.a().a(param1Int2);
            e.a().a(param1Int1, param1Int2, "1", "1", param1String1, this.c, this.b, this.b, param1Int1 + "", param1String2, true, param1Boolean);
            L.d("ProcessLogger", "InitSuccessEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1Int1 + "innerDesc=" + param1String2);
          }
        });
  }
  
  private void a(int paramInt, a parama) {
    boolean bool;
    String str;
    if (parama.b) {
      bool = true;
    } else {
      bool = false;
    } 
    if (parama.a) {
      str = "cmcc" + paramInt + "umcskd_authority_finish";
    } else {
      str = "umcskd" + paramInt + "_authority";
    } 
    this.c.addAuthRegistViewConfig(str, (new AuthRegisterViewConfig.Builder()).setView(parama.c).setRootViewId(bool).setCustomInterface(new CustomInterface(this, parama) {
            public void onClick(Context param1Context) {
              if (this.a.d != null)
                this.a.d.onClick(param1Context, this.a.c); 
            }
          }).build());
  }
  
  private void a(int paramInt, String paramString) {
    if (this.f != null)
      a(new Runnable(this, paramInt, paramString) {
            public void run() {
              if (OneKeyLoginManager.e(this.c) != null)
                OneKeyLoginManager.e(this.c).getInitStatus(this.a, this.b); 
            }
          }); 
  }
  
  private void a(Runnable paramRunnable) {
    Handler handler = new Handler(Looper.getMainLooper());
    if (Looper.getMainLooper() == Looper.myLooper()) {
      paramRunnable.run();
      return;
    } 
    handler.post(paramRunnable);
  }
  
  private void b() {
    k.a().a(new k.a(this) {
          private long b;
          
          private long c;
          
          public void a() {
            b.w = true;
          }
          
          public void a(int param1Int1, String param1String1, int param1Int2, String param1String2, String param1String3, long param1Long, boolean param1Boolean) {
            b.w = false;
            b.y = false;
            OneKeyLoginManager.c(this.a);
            if (param1Int2 == 2) {
              OneKeyLoginManager.a(this.a, param1Int1, param1String1);
              this.c = b.F;
              this.b = param1Long;
            } 
            if (b.z || param1Int2 == 3 || param1Int2 == 4) {
              if (b.q) {
                param1Int2 = 4;
                OneKeyLoginManager.c(this.a, param1Int1, param1String1);
                this.c = b.N;
                this.b = SystemClock.uptimeMillis() - b.M;
                param1Long = SystemClock.uptimeMillis() - b.O;
              } else {
                param1Int2 = 3;
                this.a.ShanyanAuthListenerGetPhoneCode(param1Int1, param1String1);
                this.c = b.I;
                this.b = SystemClock.uptimeMillis() - b.J;
                param1Long = this.b;
              } 
              b.z = false;
            } 
            e.a().a(param1Int1, param1Int2, "2", "0", param1String1, this.c + "", param1Long, this.b, param1String2, param1String3, false, param1Boolean);
            L.d("ProcessLogger", "PreInitialFailEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1String2 + "innerDesc==" + param1String3);
          }
          
          public void a(int param1Int1, String param1String1, String param1String2, String param1String3, int param1Int2, long param1Long, boolean param1Boolean, String param1String4) {
            b.w = false;
            b.y = true;
            SPTool.put(OneKeyLoginManager.d(this.a), "SIMSerial", AppSysMgr.getSIMSerial(OneKeyLoginManager.d(this.a)));
            SPTool.put(OneKeyLoginManager.d(this.a), "SIMOperator", AppSysMgr.getOperatorType(OneKeyLoginManager.d(this.a)));
            if (b.z || param1Int2 == 3) {
              b.z = false;
              h.a().b(OneKeyLoginManager.a(this.a), OneKeyLoginManager.b(this.a));
              this.c = b.I;
              this.b = SystemClock.uptimeMillis() - b.J;
            } 
            if (param1Int2 == 4) {
              param1String2 = (String)SPTool.get(OneKeyLoginManager.d(this.a), "ctcc_accessCode", "");
              j.a().a(param1String2, OneKeyLoginManager.b(this.a));
              this.c = b.L;
              this.b = SystemClock.uptimeMillis() - b.M;
            } 
            if (param1Int2 == 2) {
              OneKeyLoginManager.a(this.a, param1Int1, param1String1);
              this.c = b.F;
              this.b = SystemClock.uptimeMillis() - b.G;
            } 
            e.a().a(param1Int1, param1Int2, "2", "1", param1String1, this.c + "", param1Long, this.b, param1Int1 + "", param1String4, false, param1Boolean);
            L.d("ProcessLogger", "PreInitialSuccessEnd===code=" + param1Int1 + "processName==" + param1Int2 + "result==" + param1String1 + "innerCode==" + param1Int1 + "innerDesc==" + param1String4);
          }
        });
  }
  
  private void b(int paramInt, String paramString) {
    if (this.g != null)
      a(new Runnable(this, paramInt, paramString) {
            public void run() {
              if (OneKeyLoginManager.f(this.c) != null)
                OneKeyLoginManager.f(this.c).getPhoneInfoStatus(this.a, this.b); 
            }
          }); 
  }
  
  private void c() {
    h.a().a(new h.a(this) {
          private long b;
          
          private String c;
          
          public void a() {
            this.c = System.currentTimeMillis() + "";
          }
          
          public void a(int param1Int1, String param1String1, int param1Int2, String param1String2, String param1String3, long param1Long) {
            byte b;
            if (param1Int1 == 1031) {
              param1Int2 = 3;
              b = 3;
              this.b = param1Long;
              this.a.ShanyanAuthListenerGetPhoneCode(param1Int1, param1String1);
            } else {
              if (b.q) {
                byte b1;
                switch (param1Int1) {
                  default:
                    if (!AppSysMgr.getOperatorType(OneKeyLoginManager.d(this.a)).equals("CTCC"))
                      param1Long = SystemClock.uptimeMillis() - b.O; 
                    param1Int2 = 4;
                    this.b = SystemClock.uptimeMillis() - b.M;
                    b1 = 4;
                    OneKeyLoginManager.c(this.a, param1Int1, param1String1);
                  case 1023:
                    param1Int2 = 2;
                    if (!AppSysMgr.getOperatorType(OneKeyLoginManager.d(this.a)).equals("CTCC"))
                      param1Long = SystemClock.uptimeMillis() - b.O; 
                    this.c = b.N + "";
                    this.b = SystemClock.uptimeMillis() - b.M;
                    b1 = 4;
                    OneKeyLoginManager.c(this.a, param1Int1, param1String1);
                  case 1011:
                    break;
                } 
                param1Int2 = 0;
                param1Long = 0L;
                this.c = b.L + "";
              } else {
                if (param1Int1 != 1023) {
                  param1Int2 = 3;
                } else {
                  param1Int2 = 2;
                } 
                this.c = b.I + "";
                byte b1 = 3;
                this.a.ShanyanAuthListenerGetPhoneCode(param1Int1, param1String1);
                this.b = SystemClock.uptimeMillis() - b.J;
                L.d("ProcessLogger", "LoginFailEnd===code=" + param1Int1 + "processName==" + b1 + "result==" + param1String1 + "innerCode==" + param1String2 + "innerDesc==" + param1String3);
                e.a().a(param1Int1, b1, param1Int2 + "", "0", param1String1, this.c, param1Long, this.b, param1String2, param1String3, false, false);
              } 
              this.b = SystemClock.uptimeMillis() - b.M;
              b = 4;
              OneKeyLoginManager.c(this.a, param1Int1, param1String1);
            } 
            L.d("ProcessLogger", "LoginFailEnd===code=" + param1Int1 + "processName==" + b + "result==" + param1String1 + "innerCode==" + param1String2 + "innerDesc==" + param1String3);
            e.a().a(param1Int1, b, param1Int2 + "", "0", param1String1, this.c, param1Long, this.b, param1String2, param1String3, false, false);
          }
          
          public void a(int param1Int, String param1String1, String param1String2, long param1Long) {
            String str;
            byte b;
            if (b.q) {
              if (param1Int != 1022) {
                OneKeyLoginManager.c(this.a, param1Int, param1String1);
                param1String2 = "4";
                str = "一键登录成功";
              } else {
                param1String2 = "2";
                str = param1String1;
              } 
              this.b = SystemClock.uptimeMillis() - b.M;
              this.c = b.L + "";
              b = 4;
            } else {
              if (param1Int == 1022) {
                param1String2 = "2";
              } else {
                this.a.ShanyanAuthListenerGetPhoneCode(param1Int, param1String1);
                param1String2 = "3";
              } 
              b = 3;
              this.c = b.I + "";
              this.b = SystemClock.uptimeMillis() - b.J;
              str = param1String1;
            } 
            e.a().a(param1Int, b, param1String2, "1", str, this.c, param1Long, this.b, param1Int + "", str, false, false);
            L.d("ProcessLogger", "LoginSuccessEnd===code=" + param1Int + "processName==" + b + "result==" + param1String1 + "innerCode==");
          }
        });
  }
  
  private void c(int paramInt, String paramString) {
    if (this.d != null)
      a(new Runnable(this, paramInt, paramString) {
            public void run() {
              if (OneKeyLoginManager.g(this.c) != null)
                OneKeyLoginManager.g(this.c).getOneKeyLoginStatus(this.a, this.b); 
            }
          }); 
  }
  
  private void d() {
    Runnable runnable = new Runnable(this) {
        public void run() {
          b.F = System.currentTimeMillis();
          b.G = SystemClock.uptimeMillis();
          try {
            switch (b.v) {
              default:
                return;
              case 2:
                b.x = false;
                k.a().a(2);
              case 0:
                if (((Integer)SPTool.get(OneKeyLoginManager.d(this.a), "accOff", Integer.valueOf(0))).intValue() == 1)
                  k.a().a(1032, "用户被禁用", 2, "1032", "check_error", SystemClock.uptimeMillis() - b.G, true); 
                b.x = true;
                g.a().a(OneKeyLoginManager.a(this.a), 2);
              case 1:
                break;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            k.a().a(1014, "getPhoneInfoMethod()" + exception.toString(), 2, "1014", exception.getClass().getName(), SystemClock.uptimeMillis() - b.G, false);
          } 
          b.x = true;
        }
      };
    if (this.h != null) {
      this.h.execute(runnable);
      return;
    } 
    k.a().a(1014, "getPhoneInfoMethod()未初始化", 2, "1014", "未初始化", SystemClock.uptimeMillis() - b.G, false);
  }
  
  private void e() {
    long l = ((Long)SPTool.get(this.b, "preFailFlag", Long.valueOf(3L))).longValue();
    SPTool.put(this.b, "timeend", Long.valueOf(l * 1000L + System.currentTimeMillis()));
  }
  
  public static OneKeyLoginManager getInstance() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/OneKeyLoginManager.a : Lcom/chuanglan/shanyan_sdk/OneKeyLoginManager;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/OneKeyLoginManager
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/OneKeyLoginManager.a : Lcom/chuanglan/shanyan_sdk/OneKeyLoginManager;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/OneKeyLoginManager
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/OneKeyLoginManager.a : Lcom/chuanglan/shanyan_sdk/OneKeyLoginManager;
    //   27: ldc com/chuanglan/shanyan_sdk/OneKeyLoginManager
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/OneKeyLoginManager.a : Lcom/chuanglan/shanyan_sdk/OneKeyLoginManager;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/OneKeyLoginManager
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void ShanyanAuthListenerGetPhoneCode(int paramInt, String paramString) {
    if (this.e != null)
      a(new Runnable(this, paramInt, paramString) {
            public void run() {
              if (OneKeyLoginManager.h(this.c) != null)
                OneKeyLoginManager.h(this.c).getOpenLoginAuthStatus(this.a, this.b); 
            }
          }); 
  }
  
  public void finishAuthActivity() {
    h.a = false;
    if (this.c != null)
      this.c.quitAuthActivity(); 
    h.a().b();
    a.a(this.b).b();
    if (ShanYanOneKeyActivity.a != null && ShanYanOneKeyActivity.a.get() != null)
      ((ShanYanOneKeyActivity)ShanYanOneKeyActivity.a.get()).finish(); 
  }
  
  public void getPhoneInfo(GetPhoneInfoListener paramGetPhoneInfoListener) {
    this.g = paramGetPhoneInfoListener;
    d();
  }
  
  public boolean getPreIntStatus() {
    return b.y;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, InitListener paramInitListener) {
    try {
      this.b = paramContext;
      this.f = paramInitListener;
      b.u = true;
      SPTool.put(paramContext, "uuid", "");
      b.v = 0;
      this.c = AuthnHelper.getInstance(paramContext);
      if (this.h == null)
        this.h = Executors.newSingleThreadExecutor(); 
      g.a().a(paramContext, paramString1, paramString2);
      k.a().a(paramContext, this.c);
      h.a().a(paramContext, this.c);
      j.a().a(paramContext);
      e.a().a(paramContext, paramString1, paramString2);
      i.a().a(paramContext);
      b();
      c();
      a();
      g.a().a(this.h, 1);
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "init()Exception == " + exception.toString());
    } 
  }
  
  public void openLoginAuth(boolean paramBoolean, OpenLoginAuthListener paramOpenLoginAuthListener, OneKeyLoginListener paramOneKeyLoginListener) {
    this.k = paramBoolean;
    this.e = paramOpenLoginAuthListener;
    this.d = paramOneKeyLoginListener;
    h.a().a(this.h, paramBoolean);
  }
  
  public void setAuthThemeConfig() {
    if (this.i != null) {
      AuthnHelper.getInstance(this.b).setAuthThemeConfig(this.i.getCmUIConfigBuilder().build());
      l.a(this.b).a(this.i);
      if (this.j == null)
        this.j = new ArrayList<a>(); 
      if (this.i.getCustomViews() != null) {
        this.j.clear();
        this.j.addAll(this.i.getCustomViews());
        for (byte b = 0; b < this.j.size(); b++)
          a(b, this.j.get(b)); 
        this.j.clear();
      } 
      a.a(this.b).a();
      return;
    } 
    ShanYanUIConfig shanYanUIConfig = (new ShanYanUIConfig.Builder()).build();
    AuthnHelper.getInstance(this.b).setAuthThemeConfig(shanYanUIConfig.getCmUIConfigBuilder().build());
    l.a(this.b).a(shanYanUIConfig);
    a.a(this.b).a();
  }
  
  public void setAuthThemeConfig(ShanYanUIConfig paramShanYanUIConfig) {
    this.i = paramShanYanUIConfig;
  }
  
  public void setDebug(boolean paramBoolean) {
    b.h = paramBoolean;
    SDKManager.setDebug(paramBoolean);
    AuthnHelper.setDebugMode(paramBoolean);
  }
  
  public void setOnClickPrivacyListener(OnClickPrivacyListener paramOnClickPrivacyListener) {
    b.R = paramOnClickPrivacyListener;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\OneKeyLoginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
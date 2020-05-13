package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

@Keep
public class b {
  @Keep
  private static boolean h;
  
  @Keep
  private String a = null;
  
  @Keep
  private b b = null;
  
  @Keep
  private Object c = null;
  
  @Keep
  private Map<String, String> d = new HashMap<String, String>();
  
  @Keep
  private Map<String, String> e = new HashMap<String, String>();
  
  @Keep
  private Map<String, String> f = new HashMap<String, String>();
  
  @Keep
  private String g = "GET";
  
  @Keep
  private b(Context paramContext) {}
  
  @Keep
  public static native b a(@NonNull Context paramContext);
  
  @Keep
  private native void a(HttpURLConnection paramHttpURLConnection);
  
  @Keep
  private native c b();
  
  @Keep
  private static native void b(@NonNull String paramString);
  
  @Keep
  private native c c();
  
  @Keep
  private native String d();
  
  @Keep
  public native b a();
  
  @Keep
  public native b a(b paramb);
  
  @Keep
  public native b a(Object paramObject);
  
  @Keep
  public native b a(@NonNull String paramString);
  
  @Keep
  public native b a(@NonNull String paramString1, @NonNull String paramString2);
  
  @Keep
  public native b a(Map<String, String> paramMap);
  
  @Keep
  class a extends AsyncTask<Void, Void, c> {
    @Keep
    b a = this.b;
    
    @Keep
    a(b this$0) {}
    
    @Keep
    protected native b.c a(Void... param1VarArgs);
    
    @Keep
    protected native void a(b.c param1c);
  }
  
  @Keep
  public static interface b {
    @Keep
    void a(Exception param1Exception, int param1Int, String param1String);
  }
  
  @Keep
  private class c {
    @Keep
    private String a;
    
    @Keep
    private int b;
    
    @Keep
    private Exception c;
    
    @Keep
    public c(b this$0, String param1String, Exception param1Exception, int param1Int) {
      this.a = param1String;
      this.c = param1Exception;
      this.b = param1Int;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
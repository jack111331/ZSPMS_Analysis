package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.a.f;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private static Map<String, e> a = Collections.synchronizedMap(new HashMap<String, e>());
  
  private static String b = null;
  
  private Context c = null;
  
  private String d = null;
  
  private JSONObject e = null;
  
  private long f = 0L;
  
  private int g = 0;
  
  private boolean h = true;
  
  private e(Context paramContext, String paramString) {
    this.c = paramContext.getApplicationContext();
    this.d = paramString;
    a();
    b();
  }
  
  public static e a(Context paramContext, String paramString) {
    synchronized (a) {
      f.a("openSDK_LOG.OpenConfig", "getInstance begin");
      if (paramString != null)
        b = paramString; 
      String str = paramString;
      if (paramString == null)
        if (b != null) {
          str = b;
        } else {
          str = "0";
        }  
      e e2 = a.get(str);
      e e1 = e2;
      if (e2 == null) {
        e1 = new e();
        this(paramContext, str);
        a.put(str, e1);
      } 
      f.a("openSDK_LOG.OpenConfig", "getInstance end");
      return e1;
    } 
  }
  
  private void a() {
    String str = c("com.tencent.open.config.json");
    try {
      JSONObject jSONObject = new JSONObject();
      this(str);
      this.e = jSONObject;
    } catch (JSONException jSONException) {
      this.e = new JSONObject();
    } 
  }
  
  private void a(String paramString1, String paramString2) {
    String str = paramString1;
    try {
      String str1;
      if (this.d != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        str1 = stringBuilder.append(paramString1).append(".").append(this.d).toString();
      } 
      FileOutputStream fileOutputStream = this.c.openFileOutput(str1, 0);
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter();
      this(fileOutputStream, Charset.forName("UTF-8"));
      outputStreamWriter.write(paramString2);
      outputStreamWriter.flush();
      outputStreamWriter.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }
  
  private void a(JSONObject paramJSONObject) {
    d("cgi back, do update");
    this.e = paramJSONObject;
    a("com.tencent.open.config.json", paramJSONObject.toString());
    this.f = SystemClock.elapsedRealtime();
  }
  
  private void b() {
    if (this.g != 0) {
      d("update thread is running, return");
      return;
    } 
    this.g = 1;
    Bundle bundle = new Bundle();
    bundle.putString("appid", this.d);
    bundle.putString("appid_for_getting_config", this.d);
    bundle.putString("status_os", Build.VERSION.RELEASE);
    bundle.putString("status_machine", Build.MODEL);
    bundle.putString("status_version", Build.VERSION.SDK);
    bundle.putString("sdkv", "3.3.0.lite");
    bundle.putString("sdkp", "a");
    (new Thread(this, bundle) {
        public void run() {
          try {
            JSONObject jSONObject = i.d((HttpUtils.openUrl2(e.a(this.b), "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a)).a);
            e.a(this.b, jSONObject);
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          e.a(this.b, 0);
        }
      }).start();
  }
  
  private String c(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/lang/String;
    //   4: ifnull -> 115
    //   7: new java/lang/StringBuilder
    //   10: astore_2
    //   11: aload_2
    //   12: invokespecial <init> : ()V
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc '.'
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield d : Ljava/lang/String;
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_0
    //   37: getfield c : Landroid/content/Context;
    //   40: aload_2
    //   41: invokevirtual openFileInput : (Ljava/lang/String;)Ljava/io/FileInputStream;
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: new java/io/BufferedReader
    //   50: dup
    //   51: new java/io/InputStreamReader
    //   54: dup
    //   55: aload_1
    //   56: ldc 'UTF-8'
    //   58: invokestatic forName : (Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   61: invokespecial <init> : (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   64: invokespecial <init> : (Ljava/io/Reader;)V
    //   67: astore_3
    //   68: new java/lang/StringBuffer
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore_2
    //   76: aload_3
    //   77: invokevirtual readLine : ()Ljava/lang/String;
    //   80: astore #4
    //   82: aload #4
    //   84: ifnull -> 147
    //   87: aload_2
    //   88: aload #4
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   93: pop
    //   94: goto -> 76
    //   97: astore_2
    //   98: aload_2
    //   99: invokevirtual printStackTrace : ()V
    //   102: aload_1
    //   103: invokevirtual close : ()V
    //   106: aload_3
    //   107: invokevirtual close : ()V
    //   110: ldc ''
    //   112: astore_1
    //   113: aload_1
    //   114: areturn
    //   115: aload_1
    //   116: astore_2
    //   117: goto -> 36
    //   120: astore_2
    //   121: aload_0
    //   122: getfield c : Landroid/content/Context;
    //   125: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   128: aload_1
    //   129: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   132: astore_1
    //   133: goto -> 47
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual printStackTrace : ()V
    //   141: ldc ''
    //   143: astore_1
    //   144: goto -> 113
    //   147: aload_2
    //   148: invokevirtual toString : ()Ljava/lang/String;
    //   151: astore_2
    //   152: aload_1
    //   153: invokevirtual close : ()V
    //   156: aload_3
    //   157: invokevirtual close : ()V
    //   160: aload_2
    //   161: astore_1
    //   162: goto -> 113
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual printStackTrace : ()V
    //   170: aload_2
    //   171: astore_1
    //   172: goto -> 113
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual printStackTrace : ()V
    //   180: ldc ''
    //   182: astore_1
    //   183: goto -> 113
    //   186: astore_2
    //   187: aload_1
    //   188: invokevirtual close : ()V
    //   191: aload_3
    //   192: invokevirtual close : ()V
    //   195: aload_2
    //   196: athrow
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual printStackTrace : ()V
    //   202: goto -> 195
    // Exception table:
    //   from	to	target	type
    //   0	36	120	java/io/FileNotFoundException
    //   36	45	120	java/io/FileNotFoundException
    //   76	82	97	java/io/IOException
    //   76	82	186	finally
    //   87	94	97	java/io/IOException
    //   87	94	186	finally
    //   98	102	186	finally
    //   102	110	175	java/io/IOException
    //   121	133	136	java/io/IOException
    //   147	152	97	java/io/IOException
    //   147	152	186	finally
    //   152	160	165	java/io/IOException
    //   187	195	197	java/io/IOException
  }
  
  private void c() {
    int i = this.e.optInt("Common_frequency");
    int j = i;
    if (i == 0)
      j = 1; 
    long l = (j * 3600000);
    if (SystemClock.elapsedRealtime() - this.f >= l)
      b(); 
  }
  
  private void d(String paramString) {
    if (this.h)
      f.a("openSDK_LOG.OpenConfig", paramString + "; appid: " + this.d); 
  }
  
  public int a(String paramString) {
    d("get " + paramString);
    c();
    return this.e.optInt(paramString);
  }
  
  public boolean b(String paramString) {
    boolean bool = false;
    d("get " + paramString);
    c();
    Object object = this.e.opt(paramString);
    if (object != null) {
      if (object instanceof Integer)
        return !object.equals(Integer.valueOf(0)); 
      if (object instanceof Boolean)
        bool = ((Boolean)object).booleanValue(); 
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
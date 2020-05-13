package com.sdk.base.framework.d;

import android.content.Context;
import com.sdk.base.framework.a.c;
import com.sdk.base.framework.a.d;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.b.b;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

public class a<T> {
  public static int a;
  
  private static final String e = a.class.getName();
  
  private static final boolean f = c.h;
  
  public Context b;
  
  public String c;
  
  public String d;
  
  private PInfo g;
  
  private AInfo h;
  
  private SInfo i;
  
  private ArrayList<KInfo> j;
  
  private com.sdk.base.framework.b.a<T> k;
  
  private b l;
  
  static {
    a = 3;
  }
  
  public a() {}
  
  public a(Context paramContext, com.sdk.base.framework.b.a<T> parama, b paramb) {
    this.b = paramContext;
    this.k = parama;
    this.l = paramb;
  }
  
  private String a(DataInfo paramDataInfo, String paramString) {
    try {
      if (this.h == null)
        this.h = com.sdk.base.framework.c.a.a(this.b); 
      if (this.i == null)
        this.i = com.sdk.base.framework.c.a.a(); 
      if (this.j == null)
        this.j = com.sdk.base.framework.c.a.b(this.b); 
      arrayList = new ArrayList();
      this();
      for (KInfo kInfo : this.j) {
        MobileKInfo mobileKInfo = new MobileKInfo();
        this();
        mobileKInfo.setCn(kInfo.getCn());
        mobileKInfo.setIc(kInfo.getIc());
        mobileKInfo.setIe(kInfo.getIe());
        mobileKInfo.setIs(kInfo.getIs());
        mobileKInfo.setM(kInfo.getM());
        mobileKInfo.setIdfd(kInfo.isIdfd());
        arrayList.add(mobileKInfo);
      } 
    } catch (Exception exception) {
      b.c(e, exception.toString(), Boolean.valueOf(f));
      exception = null;
      return com.sdk.base.framework.utils.i.a.a((String)exception, com.sdk.base.framework.utils.a.a.b(this.b, c.a), paramString);
    } 
    if (this.g == null)
      this.g = com.sdk.base.framework.c.a.c(this.b); 
    StringBuilder stringBuilder = new StringBuilder();
    this();
    ArrayList<MobileKInfo> arrayList;
    String str = stringBuilder.append("{app:").append(this.h).append(",sdk:").append(this.i).append(",device:").append(this.g).append(",sim:").append(arrayList).append(",data:").append(exception).append("}").toString();
    return com.sdk.base.framework.utils.i.a.a(str, com.sdk.base.framework.utils.a.a.b(this.b, c.a), paramString);
  }
  
  public c<T> a(String paramString1, String paramString2, DataInfo paramDataInfo, b<T> paramb, int paramInt, d.a parama) {
    return a(paramString1, paramString2, paramDataInfo, null, paramb, paramInt, parama);
  }
  
  public c<T> a(String paramString1, String paramString2, DataInfo paramDataInfo, ArrayList<File> paramArrayList, b<T> paramb, int paramInt, d.a parama) {
    // Byte code:
    //   0: aload_3
    //   1: astore #8
    //   3: aload_3
    //   4: ifnonnull -> 17
    //   7: new com/sdk/base/framework/bean/DataInfo
    //   10: astore #8
    //   12: aload #8
    //   14: invokespecial <init> : ()V
    //   17: new java/util/TreeMap
    //   20: astore_3
    //   21: aload_3
    //   22: invokespecial <init> : ()V
    //   25: aload_0
    //   26: getfield b : Landroid/content/Context;
    //   29: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   32: astore #9
    //   34: bipush #16
    //   36: invokestatic a : (I)Ljava/lang/String;
    //   39: astore #10
    //   41: aload_0
    //   42: getfield b : Landroid/content/Context;
    //   45: getstatic com/sdk/base/module/config/BaseConfig.apk : Ljava/lang/String;
    //   48: invokestatic getApiKey : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore #11
    //   53: aload #11
    //   55: invokestatic a : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   58: invokevirtual booleanValue : ()Z
    //   61: ifeq -> 92
    //   64: aload_0
    //   65: iconst_1
    //   66: ldc 100007
    //   68: ldc 'apiKey不能为空！'
    //   70: invokevirtual a : (IILjava/lang/String;)V
    //   73: getstatic com/sdk/base/framework/d/a.e : Ljava/lang/String;
    //   76: ldc 'apiKey为空'
    //   78: getstatic com/sdk/base/framework/d/a.f : Z
    //   81: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   84: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   87: pop
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: areturn
    //   92: aload_0
    //   93: getfield b : Landroid/content/Context;
    //   96: ldc 'public_key'
    //   98: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore #12
    //   103: aload #12
    //   105: invokestatic a : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   108: invokevirtual booleanValue : ()Z
    //   111: ifeq -> 143
    //   114: aload_0
    //   115: iconst_1
    //   116: ldc 100012
    //   118: ldc '公钥不能为空！'
    //   120: invokevirtual a : (IILjava/lang/String;)V
    //   123: getstatic com/sdk/base/framework/d/a.e : Ljava/lang/String;
    //   126: ldc '公钥不能为空'
    //   128: getstatic com/sdk/base/framework/d/a.f : Z
    //   131: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   134: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   137: pop
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -> 90
    //   143: aload_0
    //   144: aload #8
    //   146: aload #10
    //   148: invokespecial a : (Lcom/sdk/base/framework/bean/DataInfo;Ljava/lang/String;)Ljava/lang/String;
    //   151: astore #8
    //   153: new java/lang/StringBuilder
    //   156: astore #13
    //   158: aload #13
    //   160: invokespecial <init> : ()V
    //   163: aload #12
    //   165: aload #13
    //   167: aload #9
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload #10
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   183: astore #12
    //   185: aload_3
    //   186: ldc_w 'apiKey'
    //   189: aload #11
    //   191: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: aload_3
    //   196: ldc_w 'params'
    //   199: aload #8
    //   201: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: aload_3
    //   206: ldc_w 'paramsKey'
    //   209: aload #12
    //   211: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: aload #11
    //   217: aload_2
    //   218: aload_3
    //   219: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/util/TreeMap;)Ljava/lang/String;
    //   222: astore #8
    //   224: new java/util/HashMap
    //   227: astore #11
    //   229: aload #11
    //   231: bipush #16
    //   233: invokespecial <init> : (I)V
    //   236: aload #8
    //   238: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   241: invokevirtual booleanValue : ()Z
    //   244: ifeq -> 280
    //   247: aload_3
    //   248: ldc_w 'sign'
    //   251: aload #8
    //   253: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload #11
    //   259: ldc_w 'sign'
    //   262: aload #8
    //   264: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: aload #11
    //   270: ldc_w 'api-protocol'
    //   273: ldc_w '1.1'
    //   276: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: new com/sdk/base/framework/a/e
    //   283: astore #8
    //   285: aload #8
    //   287: invokespecial <init> : ()V
    //   290: aload #8
    //   292: aload #7
    //   294: invokevirtual toString : ()Ljava/lang/String;
    //   297: invokevirtual a : (Ljava/lang/String;)V
    //   300: new java/lang/StringBuilder
    //   303: astore #7
    //   305: aload #7
    //   307: invokespecial <init> : ()V
    //   310: aload #8
    //   312: aload #7
    //   314: aload_1
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_2
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokevirtual b : (Ljava/lang/String;)V
    //   328: aload #8
    //   330: aload #5
    //   332: invokevirtual a : (Lcom/sdk/base/framework/b/b;)V
    //   335: aload #8
    //   337: iload #6
    //   339: invokevirtual a : (I)V
    //   342: aload #8
    //   344: aload_3
    //   345: invokevirtual a : (Ljava/util/TreeMap;)V
    //   348: aload #8
    //   350: aload #4
    //   352: invokevirtual a : (Ljava/util/ArrayList;)V
    //   355: aload #8
    //   357: aload #11
    //   359: invokevirtual a : (Ljava/util/HashMap;)V
    //   362: aload #8
    //   364: aload_0
    //   365: getfield l : Lcom/sdk/base/framework/c/b;
    //   368: invokevirtual a : (Lcom/sdk/base/framework/c/b;)V
    //   371: new com/sdk/base/framework/a/d
    //   374: astore_2
    //   375: aload_2
    //   376: aload_0
    //   377: getfield b : Landroid/content/Context;
    //   380: aload #8
    //   382: invokespecial <init> : (Landroid/content/Context;Lcom/sdk/base/framework/a/e;)V
    //   385: new com/sdk/base/framework/a/c
    //   388: dup
    //   389: aload_2
    //   390: invokespecial <init> : (Lcom/sdk/base/framework/a/d;)V
    //   393: astore_1
    //   394: aload_1
    //   395: iconst_1
    //   396: anewarray java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload_2
    //   402: aastore
    //   403: invokevirtual d : ([Ljava/lang/Object;)Lcom/sdk/base/framework/a/c/c;
    //   406: pop
    //   407: goto -> 90
    //   410: astore_2
    //   411: aload_0
    //   412: iconst_1
    //   413: ldc_w 100001
    //   416: ldc_w '网络访问出错！'
    //   419: invokevirtual a : (IILjava/lang/String;)V
    //   422: getstatic com/sdk/base/framework/d/a.e : Ljava/lang/String;
    //   425: aload_2
    //   426: invokevirtual toString : ()Ljava/lang/String;
    //   429: getstatic com/sdk/base/framework/d/a.f : Z
    //   432: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   435: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   438: pop
    //   439: goto -> 90
    //   442: astore_3
    //   443: aload_0
    //   444: iconst_1
    //   445: ldc_w 100016
    //   448: ldc_w '公钥出错！'
    //   451: invokevirtual a : (IILjava/lang/String;)V
    //   454: getstatic com/sdk/base/framework/d/a.e : Ljava/lang/String;
    //   457: astore_1
    //   458: new java/lang/StringBuilder
    //   461: astore_2
    //   462: aload_2
    //   463: invokespecial <init> : ()V
    //   466: aload_1
    //   467: aload_2
    //   468: ldc_w '公钥出错：'
    //   471: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_3
    //   475: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   478: invokevirtual toString : ()Ljava/lang/String;
    //   481: getstatic com/sdk/base/framework/d/a.f : Z
    //   484: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   487: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   490: pop
    //   491: aconst_null
    //   492: astore_1
    //   493: goto -> 90
    //   496: astore_2
    //   497: aconst_null
    //   498: astore_1
    //   499: goto -> 411
    // Exception table:
    //   from	to	target	type
    //   7	17	496	java/lang/Exception
    //   17	88	496	java/lang/Exception
    //   92	138	496	java/lang/Exception
    //   143	153	496	java/lang/Exception
    //   153	185	442	java/lang/Exception
    //   185	280	496	java/lang/Exception
    //   280	394	496	java/lang/Exception
    //   394	407	410	java/lang/Exception
    //   443	491	496	java/lang/Exception
  }
  
  public b<T> a() {
    return (b)new b<String>(this) {
        public void a(int param1Int, Object param1Object) {
          this.a.a(param1Int, 100001, param1Object + "");
          com.sdk.base.framework.utils.g.a.a(this.a.b);
        }
        
        public void a(f<String> param1f, String param1String) {
          String str;
          if (param1f == null) {
            str = "";
          } else {
            str = (String)str.b();
          } 
          int i = 1;
          int j = 100000;
          if ("".equals(str)) {
            this.a.a(1, 100004, "返回数据为空！");
            return;
          } 
          int k = i;
          int m = j;
          try {
            JSONObject jSONObject = new JSONObject();
            k = i;
            m = j;
            this(str);
            k = i;
            m = j;
            i = jSONObject.optInt("code");
            k = i;
            m = j;
            String str2 = jSONObject.optString("msg");
            k = i;
            m = j;
            j = jSONObject.optInt("status");
            k = i;
            m = j;
            str = jSONObject.optString("obj");
            k = i;
            m = j;
            String str1 = jSONObject.optString("seq");
            this.a.a(i, str2, j, str, str1);
            com.sdk.base.framework.utils.g.a.a(this.a.b);
          } catch (Throwable throwable) {
            param1String = throwable.getMessage();
            this.a.a(k, m, param1String);
            b.c(a.b(), throwable.toString(), Boolean.valueOf(a.c()));
          } 
        }
      };
  }
  
  public void a(int paramInt1, int paramInt2, String paramString) {
    if (this.k != null) {
      this.k.a(paramInt1, paramInt2, paramString);
      this.k = null;
    } 
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, T paramT, String paramString2) {
    if (this.k != null) {
      this.k.a(paramInt1, paramString1, paramInt2, paramT, paramString2);
      this.k = null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
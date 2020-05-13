package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {
  private static c a;
  
  private static final Object e = new Object();
  
  private static final String j;
  
  private com.ta.utdid2.b.a.c a;
  
  private d a = null;
  
  private com.ta.utdid2.b.a.c b;
  
  private Pattern b;
  
  private String g = null;
  
  private String h = "xx_utdid_key";
  
  private String i = "xx_utdid_domain";
  
  private Context mContext = null;
  
  static {
    a = null;
    j = ".UTSystemConfig" + File.separator + "Global";
  }
  
  private c(Context paramContext) {
    this.a = null;
    this.b = null;
    this.b = Pattern.compile("[^0-9a-zA-Z=/+]+");
    this.mContext = paramContext;
    this.b = (Pattern)new com.ta.utdid2.b.a.c(paramContext, j, "Alvin2", false, true);
    this.a = (d)new com.ta.utdid2.b.a.c(paramContext, ".DataStorage", "ContextData", false, true);
    this.a = new d();
    this.h = String.format("K_%d", new Object[] { Integer.valueOf(f.hashCode(this.h)) });
    this.i = String.format("D_%d", new Object[] { Integer.valueOf(f.hashCode(this.i)) });
  }
  
  public static c a(Context paramContext) {
    if (paramContext != null && a == null)
      synchronized (e) {
        if (a == null) {
          c c1 = new c();
          this(paramContext);
          a = (d)c1;
          c1.c();
        } 
        return (c)a;
      }  
    return (c)a;
  }
  
  private boolean a(String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      String str = paramString;
      if (paramString.endsWith("\n"))
        str = paramString.substring(0, paramString.length() - 1); 
      bool2 = bool1;
      if (24 == str.length()) {
        bool2 = bool1;
        if (!this.b.matcher(str).find())
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    Mac mac = Mac.getInstance("HmacSHA1");
    mac.init(new SecretKeySpec(e.a(new byte[] { 
              69, 114, 116, -33, 125, -54, -31, 86, -11, 11, 
              -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 
              113, 116, -16, -103, 49, -30, 9, -39, 33, -80, 
              -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 
              106, 85, -38, -93 }, ), mac.getAlgorithm()));
    return b.encodeToString(mac.doFinal(paramArrayOfbyte), 2);
  }
  
  private byte[] b() {
    int k;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (new Random()).nextInt();
    byte[] arrayOfByte1 = com.ta.utdid2.a.a.c.getBytes(i);
    byte[] arrayOfByte2 = com.ta.utdid2.a.a.c.getBytes(j);
    byteArrayOutputStream.write(arrayOfByte1, 0, 4);
    byteArrayOutputStream.write(arrayOfByte2, 0, 4);
    byteArrayOutputStream.write(3);
    byteArrayOutputStream.write(0);
    try {
      String str = d.getImei(this.mContext);
    } catch (Exception exception) {
      k = (new Random()).nextInt();
    } 
    byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(f.hashCode(k)), 0, 4);
    byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(f.hashCode(b(byteArrayOutputStream.toByteArray()))));
    return byteArrayOutputStream.toByteArray();
  }
  
  private String c() {
    if (this.b != null) {
      String str = this.b.getString("UTDID2");
      if (!f.isEmpty(str) && this.a.c(str) != null)
        return str; 
    } 
    return null;
  }
  
  private void c() {
    boolean bool = true;
    if (this.b != null) {
      if (f.isEmpty(this.b.getString("UTDID2"))) {
        String str = this.b.getString("UTDID");
        if (!f.isEmpty(str))
          d(str); 
      } 
      boolean bool1 = false;
      if (!f.isEmpty(this.b.getString("DID"))) {
        this.b.remove("DID");
        bool1 = true;
      } 
      if (!f.isEmpty(this.b.getString("EI"))) {
        this.b.remove("EI");
        bool1 = true;
      } 
      if (!f.isEmpty(this.b.getString("SI"))) {
        this.b.remove("SI");
        bool1 = bool;
      } 
      if (bool1)
        this.b.commit(); 
    } 
  }
  
  private void d(String paramString) {
    if (a(paramString)) {
      String str = paramString;
      if (paramString.endsWith("\n"))
        str = paramString.substring(0, paramString.length() - 1); 
      if (str.length() == 24 && this.b != null) {
        this.b.putString("UTDID2", str);
        this.b.commit();
      } 
    } 
  }
  
  private void e(String paramString) {
    if (paramString != null && this.a != null && !paramString.equals(this.a.getString(this.h))) {
      this.a.putString(this.h, paramString);
      this.a.commit();
    } 
  }
  
  private boolean e() {
    return (this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0);
  }
  
  private void f(String paramString) {
    if (e() && a(paramString)) {
      String str = paramString;
      if (paramString.endsWith("\n"))
        str = paramString.substring(0, paramString.length() - 1); 
      if (24 == str.length()) {
        paramString = null;
        try {
          String str1 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
          paramString = str1;
        } catch (Exception exception) {}
        if (!a(paramString))
          try {
            Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
          } catch (Exception exception) {} 
      } 
    } 
  }
  
  private void g(String paramString) {
    String str = null;
    try {
      String str1 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
      str = str1;
    } catch (Exception exception) {}
    if (!paramString.equals(str))
      try {
        Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", paramString);
      } catch (Exception exception) {} 
  }
  
  private void h(String paramString) {
    if (e() && paramString != null)
      g(paramString); 
  }
  
  public String d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: invokevirtual e : ()Ljava/lang/String;
    //   7: putfield g : Ljava/lang/String;
    //   10: aload_0
    //   11: getfield g : Ljava/lang/String;
    //   14: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   17: ifne -> 29
    //   20: aload_0
    //   21: getfield g : Ljava/lang/String;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: invokespecial b : ()[B
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull -> 91
    //   38: aload_0
    //   39: aload_1
    //   40: iconst_2
    //   41: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   44: putfield g : Ljava/lang/String;
    //   47: aload_0
    //   48: aload_0
    //   49: getfield g : Ljava/lang/String;
    //   52: invokespecial d : (Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield a : Lcom/ta/utdid2/device/d;
    //   59: aload_1
    //   60: invokevirtual c : ([B)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull -> 78
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial h : (Ljava/lang/String;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial e : (Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield g : Ljava/lang/String;
    //   82: astore_1
    //   83: goto -> 25
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual printStackTrace : ()V
    //   91: aconst_null
    //   92: astore_1
    //   93: goto -> 25
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	96	finally
    //   29	34	86	java/lang/Exception
    //   29	34	96	finally
    //   38	64	86	java/lang/Exception
    //   38	64	96	finally
    //   68	78	86	java/lang/Exception
    //   68	78	96	finally
    //   78	83	86	java/lang/Exception
    //   78	83	96	finally
    //   87	91	96	finally
  }
  
  public String e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w ''
    //   5: astore_1
    //   6: aload_0
    //   7: getfield mContext : Landroid/content/Context;
    //   10: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   13: ldc_w 'mqBRboGZkQPcAkyk'
    //   16: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial a : (Ljava/lang/String;)Z
    //   27: istore_3
    //   28: iload_3
    //   29: ifeq -> 36
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: new com/ta/utdid2/device/e
    //   39: astore #4
    //   41: aload #4
    //   43: invokespecial <init> : ()V
    //   46: iconst_0
    //   47: istore #5
    //   49: aload_0
    //   50: getfield mContext : Landroid/content/Context;
    //   53: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   56: ldc_w 'dxCRMxhQkdGePGnp'
    //   59: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   67: ifne -> 210
    //   70: aload #4
    //   72: aload_1
    //   73: invokevirtual e : (Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_2
    //   77: aload_0
    //   78: aload_2
    //   79: invokespecial a : (Ljava/lang/String;)Z
    //   82: ifeq -> 106
    //   85: aload_0
    //   86: aload_2
    //   87: invokespecial f : (Ljava/lang/String;)V
    //   90: aload_2
    //   91: astore_1
    //   92: goto -> 32
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -> 63
    //   106: aload #4
    //   108: aload_1
    //   109: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_2
    //   113: aload_0
    //   114: aload_2
    //   115: invokespecial a : (Ljava/lang/String;)Z
    //   118: ifeq -> 207
    //   121: aload_0
    //   122: getfield a : Lcom/ta/utdid2/device/d;
    //   125: aload_2
    //   126: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   134: ifne -> 207
    //   137: aload_0
    //   138: aload_2
    //   139: invokespecial h : (Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield mContext : Landroid/content/Context;
    //   146: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   149: ldc_w 'dxCRMxhQkdGePGnp'
    //   152: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_2
    //   157: astore_1
    //   158: aload_0
    //   159: getfield a : Lcom/ta/utdid2/device/d;
    //   162: aload_1
    //   163: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   166: astore_2
    //   167: aload_0
    //   168: aload_2
    //   169: invokespecial a : (Ljava/lang/String;)Z
    //   172: ifeq -> 213
    //   175: aload_0
    //   176: aload_2
    //   177: putfield g : Ljava/lang/String;
    //   180: aload_0
    //   181: aload_2
    //   182: invokespecial d : (Ljava/lang/String;)V
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial e : (Ljava/lang/String;)V
    //   190: aload_0
    //   191: aload_0
    //   192: getfield g : Ljava/lang/String;
    //   195: invokespecial f : (Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield g : Ljava/lang/String;
    //   202: astore_1
    //   203: goto -> 32
    //   206: astore_2
    //   207: goto -> 158
    //   210: iconst_1
    //   211: istore #5
    //   213: aload_0
    //   214: invokespecial c : ()Ljava/lang/String;
    //   217: astore_1
    //   218: aload_0
    //   219: aload_1
    //   220: invokespecial a : (Ljava/lang/String;)Z
    //   223: ifeq -> 263
    //   226: aload_0
    //   227: getfield a : Lcom/ta/utdid2/device/d;
    //   230: aload_1
    //   231: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_2
    //   235: iload #5
    //   237: ifeq -> 245
    //   240: aload_0
    //   241: aload_2
    //   242: invokespecial h : (Ljava/lang/String;)V
    //   245: aload_0
    //   246: aload_1
    //   247: invokespecial f : (Ljava/lang/String;)V
    //   250: aload_0
    //   251: aload_2
    //   252: invokespecial e : (Ljava/lang/String;)V
    //   255: aload_0
    //   256: aload_1
    //   257: putfield g : Ljava/lang/String;
    //   260: goto -> 32
    //   263: aload_0
    //   264: getfield a : Lcom/ta/utdid2/b/a/c;
    //   267: aload_0
    //   268: getfield h : Ljava/lang/String;
    //   271: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   274: astore #6
    //   276: aload #6
    //   278: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   281: ifne -> 367
    //   284: aload #4
    //   286: aload #6
    //   288: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   291: astore_2
    //   292: aload_2
    //   293: astore_1
    //   294: aload_0
    //   295: aload_2
    //   296: invokespecial a : (Ljava/lang/String;)Z
    //   299: ifne -> 312
    //   302: aload_0
    //   303: getfield a : Lcom/ta/utdid2/device/d;
    //   306: aload #6
    //   308: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   311: astore_1
    //   312: aload_0
    //   313: aload_1
    //   314: invokespecial a : (Ljava/lang/String;)Z
    //   317: ifeq -> 367
    //   320: aload_0
    //   321: getfield a : Lcom/ta/utdid2/device/d;
    //   324: aload_1
    //   325: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   328: astore_2
    //   329: aload_1
    //   330: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   333: ifne -> 367
    //   336: aload_0
    //   337: aload_1
    //   338: putfield g : Ljava/lang/String;
    //   341: iload #5
    //   343: ifeq -> 351
    //   346: aload_0
    //   347: aload_2
    //   348: invokespecial h : (Ljava/lang/String;)V
    //   351: aload_0
    //   352: aload_0
    //   353: getfield g : Ljava/lang/String;
    //   356: invokespecial d : (Ljava/lang/String;)V
    //   359: aload_0
    //   360: getfield g : Ljava/lang/String;
    //   363: astore_1
    //   364: goto -> 32
    //   367: aconst_null
    //   368: astore_1
    //   369: goto -> 32
    //   372: astore_2
    //   373: goto -> 22
    // Exception table:
    //   from	to	target	type
    //   6	20	372	java/lang/Exception
    //   6	20	95	finally
    //   22	28	95	finally
    //   36	46	95	finally
    //   49	63	100	java/lang/Exception
    //   49	63	95	finally
    //   63	90	95	finally
    //   106	142	95	finally
    //   142	156	206	java/lang/Exception
    //   142	156	95	finally
    //   158	167	95	finally
    //   167	203	95	finally
    //   213	235	95	finally
    //   240	245	95	finally
    //   245	260	95	finally
    //   263	292	95	finally
    //   294	312	95	finally
    //   312	341	95	finally
    //   346	351	95	finally
    //   351	364	95	finally
  }
  
  public String getValue() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Ljava/lang/String;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield g : Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual d : ()Ljava/lang/String;
    //   22: astore_1
    //   23: goto -> 14
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	26	finally
    //   18	23	26	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\device\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
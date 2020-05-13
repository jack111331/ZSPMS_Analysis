package com.zz.a.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import com.zz.sdk.i.cg;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class v extends w {
  private static final String e = "ImageFetcher";
  
  private static final int f = 10485760;
  
  private static final String g = "http";
  
  private static final int h = 8192;
  
  private static final int m = 0;
  
  private l i;
  
  private File j;
  
  private boolean k = true;
  
  private final Object l = new Object();
  
  public v(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  public v(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private Bitmap a(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield l : Ljava/lang/Object;
    //   11: astore #4
    //   13: aload #4
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield k : Z
    //   20: istore #5
    //   22: iload #5
    //   24: ifeq -> 42
    //   27: aload_0
    //   28: getfield l : Ljava/lang/Object;
    //   31: invokevirtual wait : ()V
    //   34: goto -> 16
    //   37: astore #6
    //   39: goto -> 16
    //   42: aload_0
    //   43: getfield i : Lcom/zz/a/a/c/l;
    //   46: astore #6
    //   48: aload #6
    //   50: ifnull -> 455
    //   53: aload_0
    //   54: getfield i : Lcom/zz/a/a/c/l;
    //   57: aload_3
    //   58: invokevirtual a : (Ljava/lang/String;)Lcom/zz/a/a/c/q;
    //   61: astore #7
    //   63: aload #7
    //   65: astore #6
    //   67: aload #7
    //   69: ifnonnull -> 116
    //   72: aload_0
    //   73: getfield i : Lcom/zz/a/a/c/l;
    //   76: aload_3
    //   77: invokevirtual b : (Ljava/lang/String;)Lcom/zz/a/a/c/n;
    //   80: astore #6
    //   82: aload #6
    //   84: ifnull -> 106
    //   87: aload_0
    //   88: aload_1
    //   89: aload #6
    //   91: iconst_0
    //   92: invokevirtual c : (I)Ljava/io/OutputStream;
    //   95: invokevirtual a : (Ljava/lang/String;Ljava/io/OutputStream;)Z
    //   98: ifeq -> 211
    //   101: aload #6
    //   103: invokevirtual a : ()V
    //   106: aload_0
    //   107: getfield i : Lcom/zz/a/a/c/l;
    //   110: aload_3
    //   111: invokevirtual a : (Ljava/lang/String;)Lcom/zz/a/a/c/q;
    //   114: astore #6
    //   116: aload #6
    //   118: ifnull -> 447
    //   121: aload #6
    //   123: iconst_0
    //   124: invokevirtual a : (I)Ljava/io/InputStream;
    //   127: checkcast java/io/FileInputStream
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual getFD : ()Ljava/io/FileDescriptor;
    //   135: astore #7
    //   137: aload_1
    //   138: astore_3
    //   139: aload #7
    //   141: astore_1
    //   142: aload_3
    //   143: astore #6
    //   145: aload #7
    //   147: ifnonnull -> 170
    //   150: aload #7
    //   152: astore_1
    //   153: aload_3
    //   154: astore #6
    //   156: aload_3
    //   157: ifnull -> 170
    //   160: aload_3
    //   161: invokevirtual close : ()V
    //   164: aload_3
    //   165: astore #6
    //   167: aload #7
    //   169: astore_1
    //   170: aload #4
    //   172: monitorexit
    //   173: aload_2
    //   174: astore #7
    //   176: aload_1
    //   177: ifnull -> 198
    //   180: aload_1
    //   181: aload_0
    //   182: getfield a : I
    //   185: aload_0
    //   186: getfield b : I
    //   189: aload_0
    //   190: invokevirtual f : ()Lcom/zz/a/a/c/r;
    //   193: invokestatic a : (Ljava/io/FileDescriptor;IILcom/zz/a/a/c/r;)Landroid/graphics/Bitmap;
    //   196: astore #7
    //   198: aload #6
    //   200: ifnull -> 208
    //   203: aload #6
    //   205: invokevirtual close : ()V
    //   208: aload #7
    //   210: areturn
    //   211: aload #6
    //   213: invokevirtual b : ()V
    //   216: goto -> 106
    //   219: astore #7
    //   221: aconst_null
    //   222: astore #6
    //   224: aload #6
    //   226: astore_1
    //   227: new java/lang/StringBuilder
    //   230: astore_3
    //   231: aload #6
    //   233: astore_1
    //   234: aload_3
    //   235: invokespecial <init> : ()V
    //   238: aload #6
    //   240: astore_1
    //   241: ldc 'ImageFetcher'
    //   243: aload_3
    //   244: ldc 'processBitmap - '
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload #7
    //   251: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual toString : ()Ljava/lang/String;
    //   257: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   260: pop
    //   261: aload #6
    //   263: astore #7
    //   265: iconst_0
    //   266: ifne -> 438
    //   269: aload #6
    //   271: astore #7
    //   273: aload #6
    //   275: ifnull -> 438
    //   278: aload #6
    //   280: invokevirtual close : ()V
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -> 170
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_1
    //   291: goto -> 170
    //   294: astore #7
    //   296: aconst_null
    //   297: astore #6
    //   299: aload #6
    //   301: astore_1
    //   302: new java/lang/StringBuilder
    //   305: astore_3
    //   306: aload #6
    //   308: astore_1
    //   309: aload_3
    //   310: invokespecial <init> : ()V
    //   313: aload #6
    //   315: astore_1
    //   316: ldc 'ImageFetcher'
    //   318: aload_3
    //   319: ldc 'processBitmap - '
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload #7
    //   326: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual toString : ()Ljava/lang/String;
    //   332: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   335: pop
    //   336: aload #6
    //   338: astore #7
    //   340: iconst_0
    //   341: ifne -> 438
    //   344: aload #6
    //   346: astore #7
    //   348: aload #6
    //   350: ifnull -> 438
    //   353: aload #6
    //   355: invokevirtual close : ()V
    //   358: aconst_null
    //   359: astore_1
    //   360: goto -> 170
    //   363: astore_1
    //   364: aconst_null
    //   365: astore_1
    //   366: goto -> 170
    //   369: astore #6
    //   371: aconst_null
    //   372: astore_1
    //   373: iconst_0
    //   374: ifne -> 385
    //   377: aload_1
    //   378: ifnull -> 385
    //   381: aload_1
    //   382: invokevirtual close : ()V
    //   385: aload #6
    //   387: athrow
    //   388: astore_1
    //   389: aload #4
    //   391: monitorexit
    //   392: aload_1
    //   393: athrow
    //   394: astore_1
    //   395: aload #7
    //   397: astore_1
    //   398: aload_3
    //   399: astore #6
    //   401: goto -> 170
    //   404: astore_1
    //   405: goto -> 385
    //   408: astore_1
    //   409: goto -> 208
    //   412: astore #6
    //   414: goto -> 373
    //   417: astore #6
    //   419: goto -> 373
    //   422: astore #7
    //   424: aload_1
    //   425: astore #6
    //   427: goto -> 299
    //   430: astore #7
    //   432: aload_1
    //   433: astore #6
    //   435: goto -> 224
    //   438: aconst_null
    //   439: astore_1
    //   440: aload #7
    //   442: astore #6
    //   444: goto -> 170
    //   447: aconst_null
    //   448: astore_3
    //   449: aconst_null
    //   450: astore #7
    //   452: goto -> 139
    //   455: aconst_null
    //   456: astore #6
    //   458: aconst_null
    //   459: astore_1
    //   460: goto -> 170
    // Exception table:
    //   from	to	target	type
    //   16	22	388	finally
    //   27	34	37	java/lang/InterruptedException
    //   27	34	388	finally
    //   42	48	388	finally
    //   53	63	219	java/io/IOException
    //   53	63	294	java/lang/IllegalStateException
    //   53	63	369	finally
    //   72	82	219	java/io/IOException
    //   72	82	294	java/lang/IllegalStateException
    //   72	82	369	finally
    //   87	106	219	java/io/IOException
    //   87	106	294	java/lang/IllegalStateException
    //   87	106	369	finally
    //   106	116	219	java/io/IOException
    //   106	116	294	java/lang/IllegalStateException
    //   106	116	369	finally
    //   121	131	219	java/io/IOException
    //   121	131	294	java/lang/IllegalStateException
    //   121	131	369	finally
    //   131	137	430	java/io/IOException
    //   131	137	422	java/lang/IllegalStateException
    //   131	137	412	finally
    //   160	164	394	java/io/IOException
    //   160	164	388	finally
    //   170	173	388	finally
    //   203	208	408	java/io/IOException
    //   211	216	219	java/io/IOException
    //   211	216	294	java/lang/IllegalStateException
    //   211	216	369	finally
    //   227	231	417	finally
    //   234	238	417	finally
    //   241	261	417	finally
    //   278	283	288	java/io/IOException
    //   278	283	388	finally
    //   302	306	417	finally
    //   309	313	417	finally
    //   316	336	417	finally
    //   353	358	363	java/io/IOException
    //   353	358	388	finally
    //   381	385	404	java/io/IOException
    //   381	385	388	finally
    //   385	388	388	finally
    //   389	392	388	finally
  }
  
  private void a(Context paramContext) {
    b(paramContext);
    this.j = r.a(paramContext, "http");
  }
  
  private void b(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
      Toast.makeText(paramContext, cg.bI.a(), 1).show();
      Log.e("ImageFetcher", "checkConnection - no connection found");
    } 
  }
  
  public static void e() {
    if (Build.VERSION.SDK_INT < 8)
      System.setProperty("http.keepAlive", "false"); 
  }
  
  private void j() {
    if (!this.j.exists())
      this.j.mkdirs(); 
    synchronized (this.l) {
      long l1 = r.a(this.j);
      if (l1 > 10485760L)
        try {
          this.i = l.a(this.j, 1, 1, 10485760L);
        } catch (IOException iOException) {} 
      this.k = false;
      this.l.notifyAll();
      return;
    } 
  }
  
  protected Bitmap a(Object paramObject) {
    return a(String.valueOf(paramObject));
  }
  
  protected void a() {
    super.a();
    j();
  }
  
  public boolean a(String paramString, OutputStream paramOutputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: invokestatic e : ()V
    //   8: new java/net/URL
    //   11: astore #5
    //   13: aload #5
    //   15: aload_1
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload #5
    //   21: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   24: checkcast java/net/HttpURLConnection
    //   27: astore_1
    //   28: new java/io/BufferedInputStream
    //   31: astore #5
    //   33: aload #5
    //   35: aload_1
    //   36: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   39: sipush #8192
    //   42: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   45: new java/io/BufferedOutputStream
    //   48: astore #6
    //   50: aload #6
    //   52: aload_2
    //   53: sipush #8192
    //   56: invokespecial <init> : (Ljava/io/OutputStream;I)V
    //   59: aload #5
    //   61: invokevirtual read : ()I
    //   64: istore #7
    //   66: iload #7
    //   68: iconst_m1
    //   69: if_icmpeq -> 164
    //   72: aload #6
    //   74: iload #7
    //   76: invokevirtual write : (I)V
    //   79: goto -> 59
    //   82: astore #4
    //   84: aload_1
    //   85: astore_2
    //   86: aload #4
    //   88: astore_1
    //   89: aload #5
    //   91: astore #4
    //   93: aload_2
    //   94: astore #5
    //   96: aload #4
    //   98: astore_2
    //   99: new java/lang/StringBuilder
    //   102: astore #4
    //   104: aload #4
    //   106: invokespecial <init> : ()V
    //   109: ldc 'ImageFetcher'
    //   111: aload #4
    //   113: ldc_w 'Error in downloadBitmap - '
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: aload #5
    //   132: ifnull -> 140
    //   135: aload #5
    //   137: invokevirtual disconnect : ()V
    //   140: aload #6
    //   142: ifnull -> 150
    //   145: aload #6
    //   147: invokevirtual close : ()V
    //   150: aload_2
    //   151: ifnull -> 158
    //   154: aload_2
    //   155: invokevirtual close : ()V
    //   158: iconst_0
    //   159: istore #8
    //   161: iload #8
    //   163: ireturn
    //   164: aload_1
    //   165: ifnull -> 172
    //   168: aload_1
    //   169: invokevirtual disconnect : ()V
    //   172: aload #6
    //   174: ifnull -> 182
    //   177: aload #6
    //   179: invokevirtual close : ()V
    //   182: aload #5
    //   184: ifnull -> 192
    //   187: aload #5
    //   189: invokevirtual close : ()V
    //   192: iconst_1
    //   193: istore #8
    //   195: goto -> 161
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_2
    //   201: aconst_null
    //   202: astore #5
    //   204: aload_3
    //   205: astore #6
    //   207: aload #5
    //   209: ifnull -> 217
    //   212: aload #5
    //   214: invokevirtual disconnect : ()V
    //   217: aload #6
    //   219: ifnull -> 227
    //   222: aload #6
    //   224: invokevirtual close : ()V
    //   227: aload_2
    //   228: ifnull -> 235
    //   231: aload_2
    //   232: invokevirtual close : ()V
    //   235: aload_1
    //   236: athrow
    //   237: astore_2
    //   238: goto -> 235
    //   241: astore_2
    //   242: aload_1
    //   243: astore #5
    //   245: aload_2
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_2
    //   249: aload_3
    //   250: astore #6
    //   252: goto -> 207
    //   255: astore #6
    //   257: aload #5
    //   259: astore_2
    //   260: aload_1
    //   261: astore #5
    //   263: aload #6
    //   265: astore_1
    //   266: aload_3
    //   267: astore #6
    //   269: goto -> 207
    //   272: astore_2
    //   273: aload_1
    //   274: astore #4
    //   276: aload_2
    //   277: astore_1
    //   278: aload #5
    //   280: astore_2
    //   281: aload #4
    //   283: astore #5
    //   285: goto -> 207
    //   288: astore_1
    //   289: goto -> 207
    //   292: astore_1
    //   293: goto -> 158
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_2
    //   299: aconst_null
    //   300: astore #5
    //   302: aload #4
    //   304: astore #6
    //   306: goto -> 99
    //   309: astore_2
    //   310: aload_1
    //   311: astore #5
    //   313: aload_2
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_2
    //   317: aload #4
    //   319: astore #6
    //   321: goto -> 99
    //   324: astore #6
    //   326: aload #5
    //   328: astore_2
    //   329: aload_1
    //   330: astore #5
    //   332: aload #6
    //   334: astore_1
    //   335: aload #4
    //   337: astore #6
    //   339: goto -> 99
    //   342: astore_1
    //   343: goto -> 192
    // Exception table:
    //   from	to	target	type
    //   8	28	296	java/io/IOException
    //   8	28	198	finally
    //   28	45	309	java/io/IOException
    //   28	45	241	finally
    //   45	59	324	java/io/IOException
    //   45	59	255	finally
    //   59	66	82	java/io/IOException
    //   59	66	272	finally
    //   72	79	82	java/io/IOException
    //   72	79	272	finally
    //   99	130	288	finally
    //   145	150	292	java/io/IOException
    //   154	158	292	java/io/IOException
    //   177	182	342	java/io/IOException
    //   187	192	342	java/io/IOException
    //   222	227	237	java/io/IOException
    //   231	235	237	java/io/IOException
  }
  
  protected void b() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial b : ()V
    //   4: aload_0
    //   5: getfield l : Ljava/lang/Object;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield i : Lcom/zz/a/a/c/l;
    //   15: ifnull -> 51
    //   18: aload_0
    //   19: getfield i : Lcom/zz/a/a/c/l;
    //   22: invokevirtual d : ()Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifne -> 51
    //   30: aload_0
    //   31: getfield i : Lcom/zz/a/a/c/l;
    //   34: invokevirtual f : ()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield i : Lcom/zz/a/a/c/l;
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield k : Z
    //   47: aload_0
    //   48: invokespecial j : ()V
    //   51: aload_1
    //   52: monitorexit
    //   53: return
    //   54: astore_3
    //   55: new java/lang/StringBuilder
    //   58: astore #4
    //   60: aload #4
    //   62: invokespecial <init> : ()V
    //   65: ldc 'ImageFetcher'
    //   67: aload #4
    //   69: ldc_w 'clearCacheInternal - '
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: goto -> 37
    //   89: astore_3
    //   90: aload_1
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   11	26	89	finally
    //   30	37	54	java/io/IOException
    //   30	37	89	finally
    //   37	51	89	finally
    //   51	53	89	finally
    //   55	86	89	finally
    //   90	92	89	finally
  }
  
  protected void c() {
    super.c();
    synchronized (this.l) {
      l l1 = this.i;
      if (l1 != null)
        try {
          this.i.e();
        } catch (IOException iOException) {} 
      return;
    } 
  }
  
  protected void d() {
    super.d();
    synchronized (this.l) {
      l l1 = this.i;
      if (l1 != null)
        try {
          if (!this.i.d()) {
            this.i.close();
            this.i = null;
          } 
        } catch (IOException iOException) {} 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
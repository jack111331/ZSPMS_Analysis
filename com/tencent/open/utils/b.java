package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.a.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class b {
  private static String c;
  
  private String a;
  
  private c b;
  
  private long d;
  
  private Handler e;
  
  private Runnable f = new Runnable(this) {
      public void run() {
        f.a("AsynLoadImg", "saveFileRunnable:");
        String str1 = i.f(b.b(this.a));
        String str2 = "share_qq_" + str1 + ".jpg";
        String str3 = b.a() + str2;
        File file = new File(str3);
        Message message = b.c(this.a).obtainMessage();
        if (file.exists()) {
          message.arg1 = 0;
          message.obj = str3;
          f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.d(this.a)));
        } else {
          boolean bool;
          Bitmap bitmap = b.a(b.b(this.a));
          if (bitmap != null) {
            bool = this.a.a(bitmap, str2);
          } else {
            f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
            bool = false;
          } 
          if (bool) {
            message.arg1 = 0;
            message.obj = str3;
          } else {
            message.arg1 = 1;
          } 
          f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.d(this.a)));
        } 
        b.c(this.a).sendMessage(message);
      }
    };
  
  public b(Activity paramActivity) {
    this.e = new Handler(this, paramActivity.getMainLooper()) {
        public void handleMessage(Message param1Message) {
          f.a("AsynLoadImg", "handleMessage:" + param1Message.arg1);
          if (param1Message.arg1 == 0) {
            b.a(this.a).a(param1Message.arg1, (String)param1Message.obj);
            return;
          } 
          b.a(this.a).a(param1Message.arg1, (String)null);
        }
      };
  }
  
  public static Bitmap a(String paramString) {
    f.a("AsynLoadImg", "getbitmap:" + paramString);
    try {
      URL uRL = new URL();
      this(paramString);
      HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
      httpURLConnection.setDoInput(true);
      httpURLConnection.connect();
      InputStream inputStream = httpURLConnection.getInputStream();
      Bitmap bitmap2 = BitmapFactory.decodeStream(inputStream);
      inputStream.close();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      f.a("AsynLoadImg", stringBuilder.append("image download finished.").append(paramString).toString());
      Bitmap bitmap1 = bitmap2;
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
      f.a("AsynLoadImg", "getbitmap bmp fail---");
      outOfMemoryError = null;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      f.a("AsynLoadImg", "getbitmap bmp fail---");
      iOException = null;
    } 
    return (Bitmap)iOException;
  }
  
  public void a(String paramString, c paramc) {
    f.a("AsynLoadImg", "--save---");
    if (paramString == null || paramString.equals("")) {
      paramc.a(1, (String)null);
      return;
    } 
    if (!i.b()) {
      paramc.a(2, (String)null);
      return;
    } 
    c = Environment.getExternalStorageDirectory() + "/tmp/";
    this.d = System.currentTimeMillis();
    this.a = paramString;
    this.b = paramc;
    (new Thread(this.f)).start();
  }
  
  public boolean a(Bitmap paramBitmap, String paramString) {
    // Byte code:
    //   0: getstatic com/tencent/open/utils/b.c : Ljava/lang/String;
    //   3: astore_3
    //   4: aconst_null
    //   5: astore #4
    //   7: aconst_null
    //   8: astore #5
    //   10: aload #4
    //   12: astore #6
    //   14: new java/io/File
    //   17: astore #7
    //   19: aload #4
    //   21: astore #6
    //   23: aload #7
    //   25: aload_3
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: aload #4
    //   31: astore #6
    //   33: aload #7
    //   35: invokevirtual exists : ()Z
    //   38: ifne -> 51
    //   41: aload #4
    //   43: astore #6
    //   45: aload #7
    //   47: invokevirtual mkdir : ()Z
    //   50: pop
    //   51: aload #4
    //   53: astore #6
    //   55: new java/lang/StringBuilder
    //   58: astore #7
    //   60: aload #4
    //   62: astore #6
    //   64: aload #7
    //   66: invokespecial <init> : ()V
    //   69: aload #4
    //   71: astore #6
    //   73: aload #7
    //   75: aload_3
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: astore_3
    //   87: aload #4
    //   89: astore #6
    //   91: new java/lang/StringBuilder
    //   94: astore #7
    //   96: aload #4
    //   98: astore #6
    //   100: aload #7
    //   102: invokespecial <init> : ()V
    //   105: aload #4
    //   107: astore #6
    //   109: ldc 'AsynLoadImg'
    //   111: aload #7
    //   113: ldc 'saveFile:'
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_2
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual toString : ()Ljava/lang/String;
    //   125: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload #4
    //   130: astore #6
    //   132: new java/io/File
    //   135: astore #7
    //   137: aload #4
    //   139: astore #6
    //   141: aload #7
    //   143: aload_3
    //   144: invokespecial <init> : (Ljava/lang/String;)V
    //   147: aload #4
    //   149: astore #6
    //   151: new java/io/BufferedOutputStream
    //   154: astore_2
    //   155: aload #4
    //   157: astore #6
    //   159: new java/io/FileOutputStream
    //   162: astore_3
    //   163: aload #4
    //   165: astore #6
    //   167: aload_3
    //   168: aload #7
    //   170: invokespecial <init> : (Ljava/io/File;)V
    //   173: aload #4
    //   175: astore #6
    //   177: aload_2
    //   178: aload_3
    //   179: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   182: aload_1
    //   183: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
    //   186: bipush #80
    //   188: aload_2
    //   189: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   192: pop
    //   193: aload_2
    //   194: invokevirtual flush : ()V
    //   197: aload_2
    //   198: ifnull -> 205
    //   201: aload_2
    //   202: invokevirtual close : ()V
    //   205: iconst_1
    //   206: istore #8
    //   208: iload #8
    //   210: ireturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual printStackTrace : ()V
    //   216: goto -> 205
    //   219: astore_2
    //   220: aload #5
    //   222: astore_1
    //   223: aload_1
    //   224: astore #6
    //   226: aload_2
    //   227: invokevirtual printStackTrace : ()V
    //   230: aload_1
    //   231: astore #6
    //   233: ldc 'AsynLoadImg'
    //   235: ldc 'saveFile bmp fail---'
    //   237: aload_2
    //   238: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: iconst_0
    //   242: istore #9
    //   244: iload #9
    //   246: istore #8
    //   248: aload_1
    //   249: ifnull -> 208
    //   252: aload_1
    //   253: invokevirtual close : ()V
    //   256: iload #9
    //   258: istore #8
    //   260: goto -> 208
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual printStackTrace : ()V
    //   268: iload #9
    //   270: istore #8
    //   272: goto -> 208
    //   275: astore_1
    //   276: aload #6
    //   278: astore_2
    //   279: aload_2
    //   280: ifnull -> 287
    //   283: aload_2
    //   284: invokevirtual close : ()V
    //   287: aload_1
    //   288: athrow
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual printStackTrace : ()V
    //   294: goto -> 287
    //   297: astore_1
    //   298: goto -> 279
    //   301: astore_1
    //   302: aload_2
    //   303: astore #6
    //   305: aload_1
    //   306: astore_2
    //   307: aload #6
    //   309: astore_1
    //   310: goto -> 223
    // Exception table:
    //   from	to	target	type
    //   14	19	219	java/io/IOException
    //   14	19	275	finally
    //   23	29	219	java/io/IOException
    //   23	29	275	finally
    //   33	41	219	java/io/IOException
    //   33	41	275	finally
    //   45	51	219	java/io/IOException
    //   45	51	275	finally
    //   55	60	219	java/io/IOException
    //   55	60	275	finally
    //   64	69	219	java/io/IOException
    //   64	69	275	finally
    //   73	87	219	java/io/IOException
    //   73	87	275	finally
    //   91	96	219	java/io/IOException
    //   91	96	275	finally
    //   100	105	219	java/io/IOException
    //   100	105	275	finally
    //   109	128	219	java/io/IOException
    //   109	128	275	finally
    //   132	137	219	java/io/IOException
    //   132	137	275	finally
    //   141	147	219	java/io/IOException
    //   141	147	275	finally
    //   151	155	219	java/io/IOException
    //   151	155	275	finally
    //   159	163	219	java/io/IOException
    //   159	163	275	finally
    //   167	173	219	java/io/IOException
    //   167	173	275	finally
    //   177	182	219	java/io/IOException
    //   177	182	275	finally
    //   182	197	301	java/io/IOException
    //   182	197	297	finally
    //   201	205	211	java/io/IOException
    //   226	230	275	finally
    //   233	241	275	finally
    //   252	256	263	java/io/IOException
    //   283	287	289	java/io/IOException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
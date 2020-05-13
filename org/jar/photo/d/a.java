package org.jar.photo.d;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class a {
  public static Point a(Activity paramActivity, Uri paramUri) {
    Point point = a(paramActivity.getContentResolver(), paramUri);
    int i = point.x;
    int j = point.y;
    if (j == 0)
      return new Point(1600, 1600); 
    DisplayMetrics displayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    float f1 = displayMetrics.widthPixels;
    float f2 = displayMetrics.heightPixels;
    float f3 = i;
    float f4 = f1 / f3;
    f1 = j;
    f2 /= f1;
    return (f4 > f2) ? new Point((int)(f3 * f4), (int)(f1 * f2)) : new Point((int)(f3 * f4), (int)(f1 * f2));
  }
  
  public static Point a(ContentResolver paramContentResolver, Uri paramUri) {
    FileNotFoundException fileNotFoundException = null;
    IOException iOException1 = null;
    IOException iOException2 = iOException1;
    try {
      BitmapFactory.Options options = new BitmapFactory.Options();
      iOException2 = iOException1;
      this();
      iOException2 = iOException1;
      options.inJustDecodeBounds = true;
      iOException2 = iOException1;
      InputStream inputStream = paramContentResolver.openInputStream(paramUri);
    } catch (FileNotFoundException fileNotFoundException1) {
    
    } finally {
      if (iOException2 != null)
        try {
          iOException2.close();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        }  
    } 
    ContentResolver contentResolver = paramContentResolver;
    Point point = new Point(0, 0);
    if (paramContentResolver != null)
      try {
        paramContentResolver.close();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return point;
  }
  
  public static String a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 19
    //   4: aload_0
    //   5: invokevirtual length : ()I
    //   8: ifle -> 19
    //   11: aload_0
    //   12: invokestatic b : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   15: astore_1
    //   16: goto -> 21
    //   19: aconst_null
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new java/io/ByteArrayOutputStream
    //   30: astore_2
    //   31: aload_2
    //   32: invokespecial <init> : ()V
    //   35: aload_2
    //   36: astore_3
    //   37: aload_2
    //   38: astore #4
    //   40: aload_1
    //   41: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
    //   44: bipush #100
    //   46: aload_2
    //   47: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   50: pop
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: astore #4
    //   56: aload_2
    //   57: invokevirtual flush : ()V
    //   60: aload_2
    //   61: astore_3
    //   62: aload_2
    //   63: astore #4
    //   65: aload_2
    //   66: invokevirtual close : ()V
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: astore #4
    //   74: aload_2
    //   75: invokevirtual toByteArray : ()[B
    //   78: astore #5
    //   80: aload_2
    //   81: astore_0
    //   82: aload #5
    //   84: astore #6
    //   86: aload_2
    //   87: astore_3
    //   88: aload_2
    //   89: astore #4
    //   91: aload #5
    //   93: arraylength
    //   94: ldc 153600
    //   96: if_icmple -> 195
    //   99: aload_2
    //   100: astore_3
    //   101: aload_2
    //   102: astore #4
    //   104: ldc 153600
    //   106: i2f
    //   107: aload #5
    //   109: arraylength
    //   110: i2f
    //   111: fdiv
    //   112: ldc 100.0
    //   114: fmul
    //   115: f2i
    //   116: istore #7
    //   118: iload #7
    //   120: istore #8
    //   122: iload #7
    //   124: ifge -> 130
    //   127: iconst_0
    //   128: istore #8
    //   130: aload_2
    //   131: astore_3
    //   132: aload_2
    //   133: astore #4
    //   135: new java/io/ByteArrayOutputStream
    //   138: astore_0
    //   139: aload_2
    //   140: astore_3
    //   141: aload_2
    //   142: astore #4
    //   144: aload_0
    //   145: invokespecial <init> : ()V
    //   148: aload_1
    //   149: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
    //   152: iload #8
    //   154: aload_0
    //   155: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   158: pop
    //   159: aload_0
    //   160: invokevirtual flush : ()V
    //   163: aload_0
    //   164: invokevirtual close : ()V
    //   167: aload_0
    //   168: invokevirtual toByteArray : ()[B
    //   171: astore #6
    //   173: goto -> 195
    //   176: astore_3
    //   177: aload_0
    //   178: astore #4
    //   180: aload_3
    //   181: astore_0
    //   182: aload #4
    //   184: astore_3
    //   185: goto -> 240
    //   188: astore_3
    //   189: aload_0
    //   190: astore #4
    //   192: goto -> 270
    //   195: aload_0
    //   196: astore_3
    //   197: aload_0
    //   198: astore #4
    //   200: aload #6
    //   202: iconst_0
    //   203: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   206: astore_2
    //   207: aload_0
    //   208: invokevirtual flush : ()V
    //   211: aload_0
    //   212: invokevirtual close : ()V
    //   215: aload_1
    //   216: ifnull -> 231
    //   219: aload_1
    //   220: invokevirtual recycle : ()V
    //   223: goto -> 231
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual printStackTrace : ()V
    //   231: aload_2
    //   232: areturn
    //   233: astore_0
    //   234: goto -> 240
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual flush : ()V
    //   244: aload_3
    //   245: invokevirtual close : ()V
    //   248: aload_1
    //   249: ifnull -> 264
    //   252: aload_1
    //   253: invokevirtual recycle : ()V
    //   256: goto -> 264
    //   259: astore_3
    //   260: aload_3
    //   261: invokevirtual printStackTrace : ()V
    //   264: aload_0
    //   265: athrow
    //   266: astore_0
    //   267: aconst_null
    //   268: astore #4
    //   270: aload #4
    //   272: invokevirtual flush : ()V
    //   275: aload #4
    //   277: invokevirtual close : ()V
    //   280: aload_1
    //   281: ifnull -> 296
    //   284: aload_1
    //   285: invokevirtual recycle : ()V
    //   288: goto -> 296
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual printStackTrace : ()V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_0
    //   299: goto -> 270
    // Exception table:
    //   from	to	target	type
    //   27	35	266	java/lang/Exception
    //   27	35	237	finally
    //   40	51	298	java/lang/Exception
    //   40	51	233	finally
    //   56	60	298	java/lang/Exception
    //   56	60	233	finally
    //   65	69	298	java/lang/Exception
    //   65	69	233	finally
    //   74	80	298	java/lang/Exception
    //   74	80	233	finally
    //   91	99	298	java/lang/Exception
    //   91	99	233	finally
    //   104	118	298	java/lang/Exception
    //   104	118	233	finally
    //   135	139	298	java/lang/Exception
    //   135	139	233	finally
    //   144	148	298	java/lang/Exception
    //   144	148	233	finally
    //   148	173	188	java/lang/Exception
    //   148	173	176	finally
    //   200	207	298	java/lang/Exception
    //   200	207	233	finally
    //   207	215	226	java/io/IOException
    //   219	223	226	java/io/IOException
    //   240	248	259	java/io/IOException
    //   252	256	259	java/io/IOException
    //   270	280	291	java/io/IOException
    //   284	288	291	java/io/IOException
  }
  
  public static Bitmap b(String paramString) {
    try {
      return BitmapFactory.decodeFile(paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
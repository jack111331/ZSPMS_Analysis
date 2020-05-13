package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.c;
import com.tencent.open.utils.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class a {
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8) {
      paramInt1 = 1;
      while (true) {
        paramInt2 = paramInt1;
        if (paramInt1 < i) {
          paramInt1 <<= 1;
          continue;
        } 
        break;
      } 
    } else {
      paramInt2 = (i + 7) / 8 * 8;
    } 
    return paramInt2;
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt) {
    Matrix matrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i <= j)
      i = j; 
    float f = paramInt / i;
    matrix.postScale(f, f);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
  }
  
  public static final Bitmap a(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: new android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: putfield inJustDecodeBounds : Z
    //   24: aload_0
    //   25: aload_2
    //   26: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: pop
    //   30: aload_2
    //   31: getfield outWidth : I
    //   34: istore_3
    //   35: aload_2
    //   36: getfield outHeight : I
    //   39: istore #4
    //   41: aload_2
    //   42: getfield mCancel : Z
    //   45: ifne -> 64
    //   48: aload_2
    //   49: getfield outWidth : I
    //   52: iconst_m1
    //   53: if_icmpeq -> 64
    //   56: aload_2
    //   57: getfield outHeight : I
    //   60: iconst_m1
    //   61: if_icmpne -> 79
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -> 9
    //   69: astore #5
    //   71: aload #5
    //   73: invokevirtual printStackTrace : ()V
    //   76: goto -> 30
    //   79: iload_3
    //   80: iload #4
    //   82: if_icmple -> 135
    //   85: iload_3
    //   86: istore #4
    //   88: aload_2
    //   89: getstatic android/graphics/Bitmap$Config.RGB_565 : Landroid/graphics/Bitmap$Config;
    //   92: putfield inPreferredConfig : Landroid/graphics/Bitmap$Config;
    //   95: iload #4
    //   97: iload_1
    //   98: if_icmple -> 113
    //   101: aload_2
    //   102: aload_2
    //   103: iconst_m1
    //   104: iload_1
    //   105: iload_1
    //   106: imul
    //   107: invokestatic a : (Landroid/graphics/BitmapFactory$Options;II)I
    //   110: putfield inSampleSize : I
    //   113: aload_2
    //   114: iconst_0
    //   115: putfield inJustDecodeBounds : Z
    //   118: aload_0
    //   119: aload_2
    //   120: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   123: astore #5
    //   125: aload #5
    //   127: ifnonnull -> 149
    //   130: aconst_null
    //   131: astore_0
    //   132: goto -> 9
    //   135: goto -> 88
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual printStackTrace : ()V
    //   143: aconst_null
    //   144: astore #5
    //   146: goto -> 125
    //   149: aload_2
    //   150: getfield outWidth : I
    //   153: istore #4
    //   155: aload_2
    //   156: getfield outHeight : I
    //   159: istore_3
    //   160: iload #4
    //   162: iload_3
    //   163: if_icmple -> 185
    //   166: aload #5
    //   168: astore_0
    //   169: iload #4
    //   171: iload_1
    //   172: if_icmple -> 9
    //   175: aload #5
    //   177: iload_1
    //   178: invokestatic a : (Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   181: astore_0
    //   182: goto -> 9
    //   185: iload_3
    //   186: istore #4
    //   188: goto -> 166
    // Exception table:
    //   from	to	target	type
    //   24	30	69	java/lang/OutOfMemoryError
    //   118	125	138	java/lang/OutOfMemoryError
  }
  
  protected static final String a(Bitmap paramBitmap, String paramString1, String paramString2) {
    File file = new File(paramString1);
    if (!file.exists())
      file.mkdirs(); 
    paramString1 = paramString1 + paramString2;
    file = new File(paramString1);
    if (file.exists())
      file.delete(); 
    if (paramBitmap != null)
      try {
        FileOutputStream fileOutputStream = new FileOutputStream();
        this(file);
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        paramBitmap.recycle();
        return paramString1;
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  public static final void a(Context paramContext, String paramString, c paramc) {
    f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
    if (TextUtils.isEmpty(paramString)) {
      paramc.a(1, null);
      return;
    } 
    if (!i.b()) {
      paramc.a(2, null);
      return;
    } 
    (new Thread(new Runnable(paramString, new Handler(paramContext.getMainLooper(), paramc) {
            public void handleMessage(Message param1Message) {
              String str;
              switch (param1Message.what) {
                default:
                  super.handleMessage(param1Message);
                  return;
                case 101:
                  str = (String)param1Message.obj;
                  this.a.a(0, str);
                  return;
                case 102:
                  break;
              } 
              int i = ((Message)str).arg1;
              this.a.a(i, null);
            }
          }) {
          public void run() {
            Bitmap bitmap = a.a(this.a, 140);
            if (bitmap != null) {
              String str1 = Environment.getExternalStorageDirectory() + "/tmp/";
              String str2 = i.f(this.a);
              str2 = "share2qq_temp" + str2 + ".jpg";
              if (!a.a(this.a, 140, 140)) {
                f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                str1 = this.a;
              } else {
                f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                str1 = a.a(bitmap, str1, str2);
              } 
              f.b("openSDK_LOG.AsynScaleCompressImage", "-->destFilePath: " + str1);
              if (str1 != null) {
                Message message1 = this.b.obtainMessage(101);
                message1.obj = str1;
                this.b.sendMessage(message1);
                return;
              } 
            } 
            Message message = this.b.obtainMessage(102);
            message.arg1 = 3;
            this.b.sendMessage(message);
          }
        })).start();
  }
  
  public static final void a(Context paramContext, ArrayList<String> paramArrayList, c paramc) {
    f.b("openSDK_LOG.AsynScaleCompressImage", "batchScaleCompressImage");
    if (paramArrayList == null) {
      paramc.a(1, null);
      return;
    } 
    (new Thread(new Runnable(paramArrayList, new Handler(paramContext.getMainLooper(), paramc) {
            public void handleMessage(Message param1Message) {
              switch (param1Message.what) {
                default:
                  super.handleMessage(param1Message);
                  return;
                case 101:
                  break;
              } 
              ArrayList arrayList = param1Message.getData().getStringArrayList("images");
              this.a.a(0, arrayList);
            }
          }) {
          public void run() {
            for (byte b = 0; b < this.a.size(); b++) {
              String str = this.a.get(b);
              if (!i.g(str) && i.h(str)) {
                Bitmap bitmap = a.a(str, 10000);
                if (bitmap != null) {
                  String str1 = Environment.getExternalStorageDirectory() + "/tmp/";
                  String str2 = i.f(str);
                  str2 = "share2qzone_temp" + str2 + ".jpg";
                  if (!a.a(str, 640, 10000)) {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                  } else {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                    str = a.a(bitmap, str1, str2);
                  } 
                  if (str != null)
                    this.a.set(b, str); 
                } 
              } 
            } 
            Message message = this.b.obtainMessage(101);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", this.a);
            message.setData(bundle);
            this.b.sendMessage(message);
          }
        })).start();
  }
  
  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int i;
    int j;
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    if (paramInt2 == -1) {
      i = 1;
    } else {
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
    } 
    if (paramInt1 == -1) {
      j = 128;
    } else {
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
    } 
    if (j >= i) {
      if (paramInt2 == -1 && paramInt1 == -1)
        return 1; 
      if (paramInt1 != -1)
        i = j; 
    } 
    return i;
  }
  
  private static final boolean b(String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 11
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: ireturn
    //   11: new android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore #4
    //   20: aload #4
    //   22: iconst_1
    //   23: putfield inJustDecodeBounds : Z
    //   26: aload_0
    //   27: aload #4
    //   29: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload #4
    //   35: getfield outWidth : I
    //   38: istore #5
    //   40: aload #4
    //   42: getfield outHeight : I
    //   45: istore #6
    //   47: aload #4
    //   49: getfield mCancel : Z
    //   52: ifne -> 73
    //   55: aload #4
    //   57: getfield outWidth : I
    //   60: iconst_m1
    //   61: if_icmpeq -> 73
    //   64: aload #4
    //   66: getfield outHeight : I
    //   69: iconst_m1
    //   70: if_icmpne -> 86
    //   73: iconst_0
    //   74: istore_3
    //   75: goto -> 9
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual printStackTrace : ()V
    //   83: goto -> 33
    //   86: iload #5
    //   88: iload #6
    //   90: if_icmple -> 164
    //   93: iload #5
    //   95: istore #7
    //   97: iload #5
    //   99: iload #6
    //   101: if_icmpge -> 171
    //   104: ldc 'openSDK_LOG.AsynScaleCompressImage'
    //   106: new java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial <init> : ()V
    //   113: ldc 'longSide='
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload #7
    //   120: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   123: ldc 'shortSide='
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload #5
    //   130: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   133: invokevirtual toString : ()Ljava/lang/String;
    //   136: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload #4
    //   141: getstatic android/graphics/Bitmap$Config.RGB_565 : Landroid/graphics/Bitmap$Config;
    //   144: putfield inPreferredConfig : Landroid/graphics/Bitmap$Config;
    //   147: iload #7
    //   149: iload_2
    //   150: if_icmpgt -> 159
    //   153: iload #5
    //   155: iload_1
    //   156: if_icmple -> 178
    //   159: iconst_1
    //   160: istore_3
    //   161: goto -> 9
    //   164: iload #6
    //   166: istore #7
    //   168: goto -> 97
    //   171: iload #6
    //   173: istore #5
    //   175: goto -> 104
    //   178: iconst_0
    //   179: istore_3
    //   180: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   26	33	78	java/lang/OutOfMemoryError
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\share\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
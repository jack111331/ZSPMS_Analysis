package com.zz.sdk.i;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bj {
  private static final String a = "ImageUtil";
  
  private static String b = "zzsdk" + File.separator + "share";
  
  public static Intent a() {
    Intent intent = new Intent("android.intent.action.GET_CONTENT");
    intent.setType("image/*");
    return Intent.createChooser(intent, null);
  }
  
  public static String a(Context paramContext, Intent paramIntent1, Intent paramIntent2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_2
    //   6: ifnull -> 124
    //   9: aload_3
    //   10: astore #5
    //   12: aload_2
    //   13: invokevirtual getData : ()Landroid/net/Uri;
    //   16: astore #4
    //   18: aload #4
    //   20: ifnull -> 375
    //   23: aload_3
    //   24: astore #5
    //   26: aload_0
    //   27: aload #4
    //   29: invokestatic a : (Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_0
    //   34: astore #4
    //   36: aload_0
    //   37: invokestatic d : (Ljava/lang/String;)Z
    //   40: istore #6
    //   42: iload #6
    //   44: ifeq -> 92
    //   47: ldc 'ImageUtil'
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: ldc 'retrievePath('
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc ','
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: ldc ') ret: '
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   89: pop
    //   90: aload_0
    //   91: areturn
    //   92: aload_0
    //   93: astore #4
    //   95: ldc 'ImageUtil'
    //   97: ldc 'retrievePath failed from dataIntent:%s, extras:%s'
    //   99: iconst_2
    //   100: anewarray java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_2
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_2
    //   110: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   113: aastore
    //   114: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: aload_0
    //   122: astore #4
    //   124: aload_1
    //   125: ifnull -> 368
    //   128: aload #4
    //   130: astore #5
    //   132: aload_1
    //   133: ldc 'output'
    //   135: invokevirtual getParcelableExtra : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   138: checkcast android/net/Uri
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull -> 362
    //   146: aload #4
    //   148: astore #5
    //   150: aload_0
    //   151: invokevirtual getScheme : ()Ljava/lang/String;
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull -> 362
    //   159: aload #4
    //   161: astore #5
    //   163: aload_3
    //   164: ldc 'file'
    //   166: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   169: ifeq -> 362
    //   172: aload #4
    //   174: astore #5
    //   176: aload_0
    //   177: invokevirtual getPath : ()Ljava/lang/String;
    //   180: astore_0
    //   181: aload_0
    //   182: astore #5
    //   184: aload_0
    //   185: astore #4
    //   187: aload_0
    //   188: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   191: ifne -> 257
    //   194: aload_0
    //   195: astore #4
    //   197: new java/io/File
    //   200: astore_3
    //   201: aload_0
    //   202: astore #4
    //   204: aload_3
    //   205: aload_0
    //   206: invokespecial <init> : (Ljava/lang/String;)V
    //   209: aload_0
    //   210: astore #4
    //   212: aload_3
    //   213: invokevirtual exists : ()Z
    //   216: ifeq -> 232
    //   219: aload_0
    //   220: astore #5
    //   222: aload_0
    //   223: astore #4
    //   225: aload_3
    //   226: invokevirtual isFile : ()Z
    //   229: ifne -> 257
    //   232: aload_0
    //   233: astore #4
    //   235: ldc 'ImageUtil'
    //   237: ldc 'retrievePath file not found from sourceIntent path:%s'
    //   239: iconst_1
    //   240: anewarray java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_0
    //   246: aastore
    //   247: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   250: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   253: pop
    //   254: aload_0
    //   255: astore #5
    //   257: ldc 'ImageUtil'
    //   259: new java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial <init> : ()V
    //   266: ldc 'retrievePath('
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: ldc ','
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   284: ldc ') ret: '
    //   286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload #5
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual toString : ()Ljava/lang/String;
    //   297: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   300: pop
    //   301: aload #5
    //   303: astore_0
    //   304: goto -> 90
    //   307: astore_0
    //   308: aload #5
    //   310: astore #4
    //   312: ldc 'ImageUtil'
    //   314: new java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial <init> : ()V
    //   321: ldc 'retrievePath('
    //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: ldc ','
    //   332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_2
    //   336: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: ldc ') ret: '
    //   341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload #4
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual toString : ()Ljava/lang/String;
    //   352: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   355: pop
    //   356: aload_0
    //   357: athrow
    //   358: astore_0
    //   359: goto -> 312
    //   362: aload #4
    //   364: astore_0
    //   365: goto -> 181
    //   368: aload #4
    //   370: astore #5
    //   372: goto -> 257
    //   375: aconst_null
    //   376: astore_0
    //   377: goto -> 33
    // Exception table:
    //   from	to	target	type
    //   12	18	307	finally
    //   26	33	307	finally
    //   36	42	358	finally
    //   95	121	358	finally
    //   132	142	307	finally
    //   150	155	307	finally
    //   163	172	307	finally
    //   176	181	307	finally
    //   187	194	358	finally
    //   197	201	358	finally
    //   204	209	358	finally
    //   212	219	358	finally
    //   225	232	358	finally
    //   235	254	358	finally
  }
  
  @SuppressLint({"NewApi"})
  public static String a(Context paramContext, Uri paramUri) {
    String[] arrayOfString;
    Uri uri;
    boolean bool;
    String str1 = null;
    String str2 = null;
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && DocumentsContract.isDocumentUri(paramContext, paramUri)) {
      String str3;
      String str4;
      if (a(paramUri)) {
        arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
        if ("primary".equalsIgnoreCase(arrayOfString[0]))
          str2 = String.format("%s/%s", new Object[] { Environment.getExternalStorageDirectory().getPath(), arrayOfString[1] }); 
        return str2;
      } 
      if (b(paramUri)) {
        str3 = DocumentsContract.getDocumentId(paramUri);
        return a((Context)arrayOfString, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(str3).longValue()), null, null);
      } 
      if (c((Uri)str3)) {
        String[] arrayOfString1 = DocumentsContract.getDocumentId((Uri)str3).split(":");
        String str = arrayOfString1[0];
        if ("image".equals(str)) {
          uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if ("video".equals(str)) {
          uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
          str3 = str1;
          if ("audio".equals(str))
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI; 
        } 
        str4 = a((Context)arrayOfString, uri, "_id=?", new String[] { arrayOfString1[1] });
      } 
      return str4;
    } 
    if ("content".equalsIgnoreCase(uri.getScheme()))
      return d(uri) ? uri.getLastPathSegment() : a((Context)arrayOfString, uri, null, null); 
    if ("file".equalsIgnoreCase(uri.getScheme()))
      str2 = uri.getPath(); 
    return str2;
  }
  
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_0
    //   4: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc '_data'
    //   16: aastore
    //   17: aload_2
    //   18: aload_3
    //   19: aconst_null
    //   20: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull -> 68
    //   28: aload_2
    //   29: invokeinterface moveToFirst : ()Z
    //   34: ifeq -> 68
    //   37: aload_2
    //   38: aload_2
    //   39: ldc '_data'
    //   41: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   46: invokeinterface getString : (I)Ljava/lang/String;
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: ifnull -> 66
    //   58: aload_2
    //   59: invokeinterface close : ()V
    //   64: aload_1
    //   65: astore_0
    //   66: aload_0
    //   67: areturn
    //   68: aload_2
    //   69: ifnull -> 78
    //   72: aload_2
    //   73: invokeinterface close : ()V
    //   78: aconst_null
    //   79: astore_0
    //   80: goto -> 66
    //   83: astore_1
    //   84: aload #4
    //   86: astore_0
    //   87: aload_0
    //   88: ifnull -> 97
    //   91: aload_0
    //   92: invokeinterface close : ()V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_2
    //   101: astore_0
    //   102: goto -> 87
    // Exception table:
    //   from	to	target	type
    //   3	24	83	finally
    //   28	52	99	finally
  }
  
  public static boolean a(Uri paramUri) {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  private static boolean a(String paramString) {
    File file = new File(b, paramString);
    file.isFile();
    return file.exists();
  }
  
  public static Intent b() {
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    intent.putExtra("output", (Parcelable)c(c()));
    return intent;
  }
  
  private static File b(String paramString) {
    File file = new File(Environment.getExternalStorageDirectory(), paramString);
    if (Environment.getExternalStorageState().equals("mounted")) {
      bp.b("createSDDir:" + file.getAbsolutePath());
      bp.b("createSDDir:" + file.mkdirs());
    } 
    return file;
  }
  
  public static boolean b(Uri paramUri) {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  private static Uri c(String paramString) {
    return Uri.fromFile(new File(paramString));
  }
  
  private static String c() {
    null = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    String str = "upload-" + null + ".jpg";
    if (!a(str))
      try {
        File file1 = b(b);
        File file2 = new File();
        this(file1, str);
        if (file2.exists())
          file2.delete(); 
        return file2.getAbsolutePath();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  public static boolean c(Uri paramUri) {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean d(Uri paramUri) {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  private static boolean d(String paramString) {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString) && (new File(paramString)).exists())
      bool = true; 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
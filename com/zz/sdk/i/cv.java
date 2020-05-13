package com.zz.sdk.i;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebStorage;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import com.zz.sdk.b.a.r;
import com.zz.sdk.b.v;
import com.zz.sdk.b.w;
import com.zz.sdk.floatdlg.c.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class cv {
  private static final Pattern A;
  
  private static long B = 0L;
  
  public static r a;
  
  private static String b = null;
  
  private static String c = null;
  
  private static String d = null;
  
  private static String e = null;
  
  private static String f = null;
  
  private static String g = null;
  
  private static String h = null;
  
  private static String i = null;
  
  private static String j = null;
  
  private static String k = null;
  
  private static String l = null;
  
  private static String m = null;
  
  private static String n = null;
  
  private static String o = null;
  
  private static String p = null;
  
  private static final NumberFormat q = new DecimalFormat("#.##");
  
  private static int r = 0;
  
  private static String s;
  
  private static boolean t = false;
  
  private static Map u = new HashMap<Object, Object>();
  
  private static Activity v = null;
  
  private static Handler w = new Handler(Looper.getMainLooper());
  
  private static a x;
  
  private static long y = 0L;
  
  private static final String z = "www.daw.so";
  
  static {
    A = Pattern.compile("\\d+");
  }
  
  public static int a(Context paramContext) {
    int i = 40;
    try {
      Class<?> clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();
      int j = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
      j = paramContext.getResources().getDimensionPixelSize(j);
      i = j;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return i;
  }
  
  public static int a(String paramString, int paramInt) {
    try {
      int i = Integer.parseInt(paramString);
      paramInt = i;
    } catch (Exception exception) {}
    return paramInt;
  }
  
  public static Pair a(Context paramContext, String paramString) {
    null = w.a(paramContext).a(paramString);
    return (null != null) ? new Pair(null.b, null.c) : null;
  }
  
  public static String a() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.o : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/zz/sdk/i/cv
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/zz/sdk/i/cv
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String a(double paramDouble) {
    return q.format(paramDouble);
  }
  
  public static String a(long paramLong) {
    String str;
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy-MM-dd");
      Date date = new Date();
      this();
      str = simpleDateFormat.format(date);
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "1970-01-01";
    } 
    if (paramLong > 0L) {
      long l1 = System.currentTimeMillis() - paramLong;
      long l2 = l1 / 31536000000L;
      long l3 = l1 / 2592000000L;
      long l4 = l1 / 86400000L;
      long l5 = l1 / 3600000L;
      long l6 = l1 / 60000L;
      l1 /= 1000L;
      if (l2 > 0L) {
        String str1;
        try {
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
          this("yyyy-MM-dd");
          Date date = new Date();
          this(paramLong);
          String str2 = simpleDateFormat.format(date);
          str1 = str2;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return str1;
      } 
      if (l3 > 0L) {
        String str1;
        try {
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
          this("yyyy-MM-dd");
          Date date = new Date();
          this(paramLong);
          String str2 = simpleDateFormat.format(date);
          str1 = str2;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return str1;
      } 
      if (l4 > 0L) {
        String str1;
        try {
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
          this("MM-dd");
          Date date = new Date();
          this(paramLong);
          String str2 = simpleDateFormat.format(date);
          str1 = str2;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return str1;
      } 
      if (l5 > 0L)
        return l5 + "小时前"; 
      if (l6 > 0L)
        return l6 + "分钟前"; 
      if (l1 > 0L)
        return "1分钟前"; 
      str = "1分钟前";
    } 
    return str;
  }
  
  public static String a(Service paramService, String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_2
    //   5: new android/content/ComponentName
    //   8: astore_3
    //   9: aload_3
    //   10: aload_0
    //   11: aload_0
    //   12: invokevirtual getClass : ()Ljava/lang/Class;
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   18: aload_0
    //   19: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   22: aload_3
    //   23: sipush #128
    //   26: invokevirtual getServiceInfo : (Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    //   29: astore_3
    //   30: aload_2
    //   31: astore_0
    //   32: aload_3
    //   33: ifnull -> 75
    //   36: aload_2
    //   37: astore_0
    //   38: aload_3
    //   39: getfield metaData : Landroid/os/Bundle;
    //   42: ifnull -> 75
    //   45: new java/lang/StringBuilder
    //   48: astore_0
    //   49: aload_0
    //   50: invokespecial <init> : ()V
    //   53: aload_0
    //   54: aload_3
    //   55: getfield metaData : Landroid/os/Bundle;
    //   58: aload_1
    //   59: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   62: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc_w ''
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual toString : ()Ljava/lang/String;
    //   74: astore_0
    //   75: ldc com/zz/sdk/i/cv
    //   77: monitorexit
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: new java/lang/StringBuilder
    //   84: astore_3
    //   85: aload_3
    //   86: invokespecial <init> : ()V
    //   89: aload_3
    //   90: ldc_w 'read '
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w ' error!'
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual toString : ()Ljava/lang/String;
    //   109: invokestatic a : (Ljava/lang/Object;)V
    //   112: aload_0
    //   113: invokevirtual printStackTrace : ()V
    //   116: aload_2
    //   117: astore_0
    //   118: goto -> 75
    //   121: astore_0
    //   122: ldc com/zz/sdk/i/cv
    //   124: monitorexit
    //   125: aload_0
    //   126: athrow
    // Exception table:
    //   from	to	target	type
    //   5	30	80	java/lang/Exception
    //   5	30	121	finally
    //   38	75	80	java/lang/Exception
    //   38	75	121	finally
    //   81	116	121	finally
  }
  
  public static String a(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      byte[] arrayOfByte = Base64.encodeBase64(MessageDigest.getInstance("MD5").digest(paramString.getBytes("utf-8")));
      String str = new String();
      this(arrayOfByte, "utf-8");
      paramString = str;
    } catch (Exception exception) {
      bp.a("md5 encode exception");
    } 
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2) {
    return "<font color=\"" + paramString1 + "\">" + paramString2 + "</font>";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    if (a != null)
      paramString3 = a.a(paramString1, paramString2, paramString3); 
    return paramString3;
  }
  
  public static void a(int paramInt) {
    r = paramInt;
    s = null;
  }
  
  public static void a(Activity paramActivity) {
    v = paramActivity;
  }
  
  public static void a(Context paramContext, View paramView) {
    try {
      InputMethodManager inputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (inputMethodManager.isActive())
        while (true) {
          View view = paramView;
          if (paramView instanceof ViewGroup) {
            view = ((ViewGroup)paramView).getFocusedChild();
            if (view == null) {
              view = paramView;
            } else {
              boolean bool = view instanceof android.widget.EditText;
              if (bool) {
                if (view != null)
                  inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0); 
                return;
              } 
              continue;
            } 
          } 
          if (view != null)
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0); 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: ldc_w 'writeAccount2SDcard'
    //   6: invokestatic a : (Ljava/lang/Object;)V
    //   9: aload_0
    //   10: invokestatic b : (Landroid/content/Context;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifne -> 25
    //   18: aload_0
    //   19: checkcast android/app/Activity
    //   22: invokestatic b : (Landroid/app/Activity;)V
    //   25: aload_1
    //   26: ifnull -> 33
    //   29: aload_2
    //   30: ifnonnull -> 54
    //   33: ldc com/zz/sdk/i/cv
    //   35: monitorexit
    //   36: return
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: invokestatic a : (Ljava/lang/Object;)V
    //   45: goto -> 33
    //   48: astore_0
    //   49: ldc com/zz/sdk/i/cv
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: new java/lang/StringBuilder
    //   57: astore_0
    //   58: aload_0
    //   59: invokespecial <init> : ()V
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w '||'
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_1
    //   84: new java/io/File
    //   87: astore_2
    //   88: aload_2
    //   89: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   92: ldc_w '/zzsdk/data/code/zz'
    //   95: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   98: aload_2
    //   99: invokevirtual isFile : ()Z
    //   102: ifeq -> 110
    //   105: aload_2
    //   106: invokevirtual delete : ()Z
    //   109: pop
    //   110: aload_2
    //   111: invokevirtual exists : ()Z
    //   114: ifeq -> 124
    //   117: aload_2
    //   118: invokevirtual isFile : ()Z
    //   121: ifeq -> 140
    //   124: aload_2
    //   125: invokevirtual mkdirs : ()Z
    //   128: ifne -> 140
    //   131: ldc_w 'writeAccount2SDcard create dir failed.'
    //   134: invokestatic a : (Ljava/lang/Object;)V
    //   137: goto -> 33
    //   140: new java/io/File
    //   143: astore_0
    //   144: aload_0
    //   145: aload_2
    //   146: ldc_w 'ZM.DAT.'
    //   149: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokevirtual exists : ()Z
    //   156: ifeq -> 164
    //   159: aload_0
    //   160: invokevirtual delete : ()Z
    //   163: pop
    //   164: new java/io/FileOutputStream
    //   167: astore_2
    //   168: aload_2
    //   169: aload_0
    //   170: invokespecial <init> : (Ljava/io/File;)V
    //   173: aload_2
    //   174: aload_1
    //   175: invokevirtual getBytes : ()[B
    //   178: invokevirtual write : ([B)V
    //   181: aload_2
    //   182: invokevirtual close : ()V
    //   185: goto -> 33
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual printStackTrace : ()V
    //   193: goto -> 33
    // Exception table:
    //   from	to	target	type
    //   3	14	48	finally
    //   18	25	37	java/lang/Exception
    //   18	25	48	finally
    //   38	45	48	finally
    //   54	110	48	finally
    //   110	124	48	finally
    //   124	137	48	finally
    //   140	164	48	finally
    //   164	185	188	java/lang/Exception
    //   164	185	48	finally
    //   189	193	48	finally
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    Toast.makeText(paramContext, paramString, bool).show();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ((View)paramView.getParent()).post(new cw(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(r paramr) {
    a = paramr;
  }
  
  public static void a(Runnable paramRunnable) {
    try {
      if (n()) {
        paramRunnable.run();
        return;
      } 
      if (i() != null) {
        i().runOnUiThread(paramRunnable);
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    if (w != null)
      w.post((Runnable)exception); 
  }
  
  public static void a(String paramString, Object paramObject) {
    u.put(paramString, paramObject);
  }
  
  public static boolean a(TextView paramTextView, String paramString) {
    boolean bool = false;
    String str = paramTextView.getText().toString();
    if (!str.equals(str.trim())) {
      a(paramTextView.getContext(), paramString, false);
      bool = true;
    } 
    return bool;
  }
  
  public static int b(Context paramContext) {
    boolean bool;
    try {
      Display display = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics displayMetrics = new DisplayMetrics();
      this();
      display.getMetrics(displayMetrics);
      bool = displayMetrics.heightPixels;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  public static String b() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.p : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/zz/sdk/i/cv
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/zz/sdk/i/cv
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      String str = bs.a(paramString);
      paramString = str;
    } catch (Exception exception) {
      exception.printStackTrace();
      bp.a("md5 encode exception");
    } 
    return paramString;
  }
  
  public static void b(Context paramContext, String paramString) {
    String str;
    if (paramString != null) {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("PROJECTID", 0);
      str = sharedPreferences.getString("projectId", null);
      if (str == null) {
        sharedPreferences.edit().putString("projectId", paramString).commit();
        h = paramString;
        return;
      } 
    } else {
      return;
    } 
    h = str;
  }
  
  public static boolean b(int paramInt) {
    long l = System.currentTimeMillis();
    if (l - B < paramInt)
      return true; 
    B = l;
    return false;
  }
  
  public static int c(Context paramContext) {
    boolean bool;
    try {
      Display display = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics displayMetrics = new DisplayMetrics();
      this();
      display.getMetrics(displayMetrics);
      bool = displayMetrics.widthPixels;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  public static String c() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.d : Ljava/lang/String;
    //   6: ifnonnull -> 15
    //   9: ldc_w ''
    //   12: putstatic com/zz/sdk/i/cv.d : Ljava/lang/String;
    //   15: getstatic com/zz/sdk/i/cv.d : Ljava/lang/String;
    //   18: astore_0
    //   19: ldc com/zz/sdk/i/cv
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: ldc com/zz/sdk/i/cv
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	24	finally
    //   15	19	24	finally
  }
  
  public static String c(String paramString) {
    try {
      byte[] arrayOfByte1 = paramString.getBytes("utf-8");
      byte[] arrayOfByte2 = "www.daw.so".getBytes();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      for (byte b = 0; b < arrayOfByte1.length; b++) {
        byte b1 = arrayOfByte1[b];
        byte b2 = arrayOfByte2[b % arrayOfByte2.length];
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder.append(stringBuilder1.append("%").append((b1 & 0xFF) + (b2 & 0xFF)).toString());
      } 
      String str = stringBuilder.toString();
      paramString = str;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return paramString;
  }
  
  public static boolean c(Context paramContext, String paramString) {
    try {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0)
        return true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  public static String d() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.g : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/zz/sdk/i/cv
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/zz/sdk/i/cv
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String d(Context paramContext) {
    return bx.e(paramContext) ? ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId() : "";
  }
  
  public static String d(String paramString) {
    String str2 = paramString;
    if (paramString != null) {
      if (paramString.length() == 0)
        return paramString; 
    } else {
      return str2;
    } 
    Matcher matcher = A.matcher(paramString);
    ArrayList<Integer> arrayList = new ArrayList();
    while (matcher.find()) {
      String str;
      try {
        arrayList.add(Integer.valueOf(matcher.group()));
        continue;
      } catch (Exception exception) {
        exception.printStackTrace();
        str = paramString;
      } 
      return str;
    } 
    String str1 = paramString;
    if (arrayList.size() > 0)
      try {
        byte[] arrayOfByte2 = new byte[arrayList.size()];
        byte[] arrayOfByte1 = "www.daw.so".getBytes();
        for (byte b = 0; b < arrayOfByte2.length; b++)
          arrayOfByte2[b] = (byte)(byte)(((Integer)arrayList.get(b)).intValue() - (arrayOfByte1[b % arrayOfByte1.length] & 0xFF)); 
        String str = new String(arrayOfByte2, "utf-8");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        str1 = paramString;
      }  
    return str1;
  }
  
  public static boolean d(Context paramContext, String paramString) {
    boolean bool;
    try {
      Intent intent = new Intent();
      this();
      intent.setAction("android.intent.action.VIEW");
      intent.addCategory("android.intent.category.BROWSABLE");
      intent.addFlags(268435456);
      intent.setData(Uri.parse(paramString));
      paramContext.startActivity(intent);
      bool = true;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  public static Pair e(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc com/zz/sdk/i/cv
    //   6: monitorenter
    //   7: ldc_w 'getAccountFromSDcard'
    //   10: invokestatic a : (Ljava/lang/Object;)V
    //   13: aload_0
    //   14: invokestatic a : (Landroid/content/Context;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifne -> 29
    //   22: aload_0
    //   23: checkcast android/app/Activity
    //   26: invokestatic a : (Landroid/app/Activity;)V
    //   29: new java/io/File
    //   32: astore #4
    //   34: aload #4
    //   36: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   39: ldc_w '/zzsdk/data/code/zz'
    //   42: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   45: aload_1
    //   46: astore_0
    //   47: aload #4
    //   49: invokevirtual exists : ()Z
    //   52: ifeq -> 239
    //   55: new java/io/File
    //   58: astore #5
    //   60: aload #5
    //   62: aload #4
    //   64: ldc_w 'ZM.DAT.'
    //   67: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   70: aload #5
    //   72: invokevirtual exists : ()Z
    //   75: istore_3
    //   76: aload_1
    //   77: astore_0
    //   78: iload_3
    //   79: ifeq -> 239
    //   82: new java/io/FileInputStream
    //   85: astore #6
    //   87: aload #6
    //   89: aload #5
    //   91: invokespecial <init> : (Ljava/io/File;)V
    //   94: aload #6
    //   96: astore_0
    //   97: aload #5
    //   99: invokevirtual length : ()J
    //   102: l2i
    //   103: istore #7
    //   105: aload_2
    //   106: astore #4
    //   108: iload #7
    //   110: ifle -> 223
    //   113: aload_2
    //   114: astore #4
    //   116: iload #7
    //   118: sipush #10000
    //   121: if_icmpge -> 223
    //   124: aload #6
    //   126: astore_0
    //   127: iload #7
    //   129: newarray byte
    //   131: astore #4
    //   133: aload #6
    //   135: astore_0
    //   136: aload #6
    //   138: aload #4
    //   140: invokevirtual read : ([B)I
    //   143: pop
    //   144: aload #6
    //   146: astore_0
    //   147: new java/lang/String
    //   150: astore #8
    //   152: aload #6
    //   154: astore_0
    //   155: aload #8
    //   157: aload #4
    //   159: invokespecial <init> : ([B)V
    //   162: aload #6
    //   164: astore_0
    //   165: aload #8
    //   167: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   170: ldc_w '\|\|'
    //   173: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   176: astore #8
    //   178: aload_2
    //   179: astore #4
    //   181: aload #8
    //   183: ifnull -> 223
    //   186: aload_2
    //   187: astore #4
    //   189: aload #6
    //   191: astore_0
    //   192: aload #8
    //   194: arraylength
    //   195: iconst_2
    //   196: if_icmpne -> 223
    //   199: aload #6
    //   201: astore_0
    //   202: new android/util/Pair
    //   205: astore #4
    //   207: aload #6
    //   209: astore_0
    //   210: aload #4
    //   212: aload #8
    //   214: iconst_0
    //   215: aaload
    //   216: aload #8
    //   218: iconst_1
    //   219: aaload
    //   220: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   223: aload #4
    //   225: astore_0
    //   226: aload #6
    //   228: ifnull -> 239
    //   231: aload #6
    //   233: invokevirtual close : ()V
    //   236: aload #4
    //   238: astore_0
    //   239: ldc com/zz/sdk/i/cv
    //   241: monitorexit
    //   242: aload_0
    //   243: areturn
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual toString : ()Ljava/lang/String;
    //   249: invokestatic a : (Ljava/lang/Object;)V
    //   252: aload_1
    //   253: astore_0
    //   254: goto -> 239
    //   257: astore_0
    //   258: ldc com/zz/sdk/i/cv
    //   260: monitorexit
    //   261: aload_0
    //   262: athrow
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual printStackTrace : ()V
    //   268: aload #4
    //   270: astore_0
    //   271: goto -> 239
    //   274: astore_2
    //   275: aconst_null
    //   276: astore #4
    //   278: aload #4
    //   280: astore_0
    //   281: new java/lang/StringBuilder
    //   284: astore #6
    //   286: aload #4
    //   288: astore_0
    //   289: aload #6
    //   291: invokespecial <init> : ()V
    //   294: aload #4
    //   296: astore_0
    //   297: aload #6
    //   299: ldc_w 'open failed:'
    //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload #5
    //   307: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   310: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w ', error:'
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_2
    //   320: invokevirtual getLocalizedMessage : ()Ljava/lang/String;
    //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual toString : ()Ljava/lang/String;
    //   329: invokestatic b : (Ljava/lang/Object;)V
    //   332: aload_1
    //   333: astore_0
    //   334: aload #4
    //   336: ifnull -> 239
    //   339: aload #4
    //   341: invokevirtual close : ()V
    //   344: aload_1
    //   345: astore_0
    //   346: goto -> 239
    //   349: astore_0
    //   350: aload_0
    //   351: invokevirtual printStackTrace : ()V
    //   354: aload_1
    //   355: astore_0
    //   356: goto -> 239
    //   359: astore #4
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: ifnull -> 371
    //   367: aload_0
    //   368: invokevirtual close : ()V
    //   371: aload #4
    //   373: athrow
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual printStackTrace : ()V
    //   379: goto -> 371
    //   382: astore #4
    //   384: goto -> 363
    //   387: astore_2
    //   388: aload #6
    //   390: astore #4
    //   392: goto -> 278
    // Exception table:
    //   from	to	target	type
    //   7	18	257	finally
    //   22	29	244	java/lang/Exception
    //   22	29	257	finally
    //   29	45	257	finally
    //   47	76	257	finally
    //   82	94	274	java/lang/Exception
    //   82	94	359	finally
    //   97	105	387	java/lang/Exception
    //   97	105	382	finally
    //   127	133	387	java/lang/Exception
    //   127	133	382	finally
    //   136	144	387	java/lang/Exception
    //   136	144	382	finally
    //   147	152	387	java/lang/Exception
    //   147	152	382	finally
    //   155	162	387	java/lang/Exception
    //   155	162	382	finally
    //   165	178	387	java/lang/Exception
    //   165	178	382	finally
    //   192	199	387	java/lang/Exception
    //   192	199	382	finally
    //   202	207	387	java/lang/Exception
    //   202	207	382	finally
    //   210	223	387	java/lang/Exception
    //   210	223	382	finally
    //   231	236	263	java/io/IOException
    //   231	236	257	finally
    //   245	252	257	finally
    //   264	268	257	finally
    //   281	286	382	finally
    //   289	294	382	finally
    //   297	332	382	finally
    //   339	344	349	java/io/IOException
    //   339	344	257	finally
    //   350	354	257	finally
    //   367	371	374	java/io/IOException
    //   367	371	257	finally
    //   371	374	257	finally
    //   375	379	257	finally
  }
  
  public static String e() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.m : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/zz/sdk/i/cv
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/zz/sdk/i/cv
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  private static String e(Context paramContext, String paramString) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null && applicationInfo.metaData != null)
        return applicationInfo.metaData.getString(paramString); 
    } catch (Exception exception) {
      bp.a("read " + paramString + " error!");
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static void e(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'PROJECT_ID:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.b : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static String f() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.n : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/zz/sdk/i/cv
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/zz/sdk/i/cv
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String f(Context paramContext) {
    return paramContext.getSharedPreferences("PROJECTID", 0).getString("projectId", null);
  }
  
  public static void f(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'PRODUCT_ID:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.e : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static String g(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 17
    //   7: getstatic com/zz/sdk/i/cv.t : Z
    //   10: ifne -> 17
    //   13: aload_0
    //   14: invokestatic k : (Landroid/content/Context;)V
    //   17: getstatic com/zz/sdk/i/cv.h : Ljava/lang/String;
    //   20: ifnonnull -> 45
    //   23: aload_0
    //   24: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   27: putstatic com/zz/sdk/i/cv.h : Ljava/lang/String;
    //   30: getstatic com/zz/sdk/i/cv.h : Ljava/lang/String;
    //   33: ifnull -> 52
    //   36: getstatic com/zz/sdk/i/cv.h : Ljava/lang/String;
    //   39: astore_0
    //   40: ldc com/zz/sdk/i/cv
    //   42: monitorexit
    //   43: aload_0
    //   44: areturn
    //   45: getstatic com/zz/sdk/i/cv.h : Ljava/lang/String;
    //   48: astore_0
    //   49: goto -> 40
    //   52: getstatic com/zz/sdk/i/cv.b : Ljava/lang/String;
    //   55: ifnonnull -> 68
    //   58: aload_0
    //   59: ldc_w 'PROJECT_ID'
    //   62: invokestatic e : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   65: putstatic com/zz/sdk/i/cv.b : Ljava/lang/String;
    //   68: aload_0
    //   69: getstatic com/zz/sdk/i/cv.b : Ljava/lang/String;
    //   72: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   75: getstatic com/zz/sdk/i/cv.b : Ljava/lang/String;
    //   78: astore_0
    //   79: goto -> 40
    //   82: astore_0
    //   83: ldc com/zz/sdk/i/cv
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   7	17	82	finally
    //   17	40	82	finally
    //   45	49	82	finally
    //   52	68	82	finally
    //   68	79	82	finally
  }
  
  public static Map g() {
    return u;
  }
  
  public static void g(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'JD_APPID:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.i : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static r h() {
    return a;
  }
  
  public static String h(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.e : Ljava/lang/String;
    //   6: ifnonnull -> 19
    //   9: aload_0
    //   10: ldc_w 'PRODUCT_ID'
    //   13: invokestatic e : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   16: putstatic com/zz/sdk/i/cv.e : Ljava/lang/String;
    //   19: getstatic com/zz/sdk/i/cv.e : Ljava/lang/String;
    //   22: astore_0
    //   23: ldc com/zz/sdk/i/cv
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/zz/sdk/i/cv
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static void h(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'SY_APPID:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.o : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static Activity i() {
    return v;
  }
  
  public static String i(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.i : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/zz/sdk/i/cv
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/zz/sdk/i/cv
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void i(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'SY_APPKEY:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.p : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static String j(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/cv.c : Ljava/lang/String;
    //   6: ifnonnull -> 19
    //   9: aload_0
    //   10: ldc_w 'SERVER_ID'
    //   13: invokestatic e : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   16: putstatic com/zz/sdk/i/cv.c : Ljava/lang/String;
    //   19: getstatic com/zz/sdk/i/cv.c : Ljava/lang/String;
    //   22: astore_0
    //   23: ldc com/zz/sdk/i/cv
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/zz/sdk/i/cv
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static void j() {
    try {
      cy cy = new cy();
      this();
      a(cy);
    } catch (Exception exception) {}
  }
  
  public static void j(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'SERVER_ID:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.c : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static void k() {
    try {
      dc dc = new dc();
      this();
      a(dc);
    } catch (Exception exception) {}
  }
  
  public static void k(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   7: ldc_w 'zz_res/project.c'
    //   10: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: new java/io/BufferedReader
    //   17: astore_1
    //   18: new java/io/InputStreamReader
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: invokespecial <init> : (Ljava/io/InputStream;)V
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial <init> : (Ljava/io/Reader;)V
    //   32: aload_1
    //   33: invokevirtual readLine : ()Ljava/lang/String;
    //   36: astore_2
    //   37: new java/lang/StringBuilder
    //   40: astore_1
    //   41: aload_1
    //   42: invokespecial <init> : ()V
    //   45: aload_1
    //   46: ldc_w 'A:'
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: invokestatic a : (Ljava/lang/Object;)V
    //   62: aload_2
    //   63: ldc_w 'z_c'
    //   66: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore_2
    //   70: new java/lang/StringBuilder
    //   73: astore_1
    //   74: aload_1
    //   75: invokespecial <init> : ()V
    //   78: aload_1
    //   79: ldc_w 'B:'
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual toString : ()Ljava/lang/String;
    //   92: invokestatic a : (Ljava/lang/Object;)V
    //   95: aload_2
    //   96: ifnull -> 159
    //   99: new org/json/JSONObject
    //   102: astore_1
    //   103: aload_1
    //   104: aload_2
    //   105: invokespecial <init> : (Ljava/lang/String;)V
    //   108: aload_1
    //   109: ldc_w 'PROJECT_ID'
    //   112: aconst_null
    //   113: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull -> 125
    //   121: aload_2
    //   122: invokestatic e : (Ljava/lang/String;)V
    //   125: aload_1
    //   126: ldc_w 'PRODUCT_ID'
    //   129: aconst_null
    //   130: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull -> 142
    //   138: aload_2
    //   139: invokestatic f : (Ljava/lang/String;)V
    //   142: aload_1
    //   143: ldc_w 'SERVER_ID'
    //   146: aconst_null
    //   147: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull -> 159
    //   155: aload_1
    //   156: invokestatic j : (Ljava/lang/String;)V
    //   159: aload_0
    //   160: invokevirtual close : ()V
    //   163: iconst_1
    //   164: putstatic com/zz/sdk/i/cv.t : Z
    //   167: ldc com/zz/sdk/i/cv
    //   169: monitorexit
    //   170: return
    //   171: astore_0
    //   172: new java/lang/StringBuilder
    //   175: astore_1
    //   176: aload_1
    //   177: invokespecial <init> : ()V
    //   180: ldc_w 'zz_sdk'
    //   183: aload_1
    //   184: ldc_w 'error:'
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: invokevirtual getMessage : ()Ljava/lang/String;
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: goto -> 163
    //   207: astore_0
    //   208: ldc com/zz/sdk/i/cv
    //   210: monitorexit
    //   211: aload_0
    //   212: athrow
    //   213: astore_0
    //   214: new java/lang/StringBuilder
    //   217: astore_1
    //   218: aload_1
    //   219: invokespecial <init> : ()V
    //   222: ldc_w 'zz_sdk'
    //   225: aload_1
    //   226: ldc_w 'error:'
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: invokevirtual getMessage : ()Ljava/lang/String;
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual toString : ()Ljava/lang/String;
    //   242: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   245: pop
    //   246: goto -> 163
    // Exception table:
    //   from	to	target	type
    //   3	95	171	java/io/IOException
    //   3	95	213	java/lang/Exception
    //   3	95	207	finally
    //   99	117	171	java/io/IOException
    //   99	117	213	java/lang/Exception
    //   99	117	207	finally
    //   121	125	171	java/io/IOException
    //   121	125	213	java/lang/Exception
    //   121	125	207	finally
    //   125	134	171	java/io/IOException
    //   125	134	213	java/lang/Exception
    //   125	134	207	finally
    //   138	142	171	java/io/IOException
    //   138	142	213	java/lang/Exception
    //   138	142	207	finally
    //   142	151	171	java/io/IOException
    //   142	151	213	java/lang/Exception
    //   142	151	207	finally
    //   155	159	171	java/io/IOException
    //   155	159	213	java/lang/Exception
    //   155	159	207	finally
    //   159	163	171	java/io/IOException
    //   159	163	213	java/lang/Exception
    //   159	163	207	finally
    //   163	167	207	finally
    //   172	204	207	finally
    //   214	246	207	finally
  }
  
  public static void k(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'SERVER_NAME:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.d : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static void l(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'app:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.g : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static boolean l(Context paramContext) {
    return c(paramContext, "android.permission.SEND_SMS");
  }
  
  public static void m(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'app:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.m : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  public static boolean m(Context paramContext) {
    return c(paramContext, "android.permission.RECEIVE_SMS");
  }
  
  public static String n(Context paramContext) {
    if (f == null)
      f = ba.a(paramContext); 
    return f;
  }
  
  public static void n(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial <init> : ()V
    //   11: aload_1
    //   12: ldc_w 'app:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: invokestatic a : (Ljava/lang/Object;)V
    //   28: aload_0
    //   29: putstatic com/zz/sdk/i/cv.n : Ljava/lang/String;
    //   32: ldc com/zz/sdk/i/cv
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/zz/sdk/i/cv
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	36	finally
  }
  
  private static boolean n() {
    return (Thread.currentThread() == Looper.getMainLooper().getThread());
  }
  
  public static String o(Context paramContext) {
    if (j == null)
      j = ba.c(paramContext); 
    return j;
  }
  
  public static void o(String paramString) {
    r = 0;
    s = paramString;
  }
  
  public static String p(Context paramContext) {
    if (k == null)
      k = ba.b(paramContext); 
    return k;
  }
  
  public static String p(String paramString) {
    return a("#E94E64", paramString);
  }
  
  public static String q(Context paramContext) {
    if (l == null)
      l = ba.d(paramContext); 
    return l;
  }
  
  public static String q(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : paramString.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
  }
  
  public static Drawable r(Context paramContext) {
    return (Drawable)((r != 0) ? paramContext.getResources().getDrawable(r) : ((s != null && s.length() > 0) ? (s.endsWith(".9.png") ? d.c(paramContext, s) : d.b(paramContext, s)) : null));
  }
  
  public static void r(String paramString) {
    try {
      cx cx = new cx();
      this(paramString);
      a(cx);
    } catch (Exception exception) {}
  }
  
  public static String s(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/cv
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   7: astore_1
    //   8: aload_1
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual getPackageName : ()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   18: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   21: invokevirtual getApplicationLabel : (Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   24: invokeinterface toString : ()Ljava/lang/String;
    //   29: astore_0
    //   30: ldc com/zz/sdk/i/cv
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual printStackTrace : ()V
    //   40: ldc_w ''
    //   43: astore_0
    //   44: goto -> 30
    //   47: astore_0
    //   48: ldc com/zz/sdk/i/cv
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	35	java/lang/Exception
    //   3	30	47	finally
    //   36	40	47	finally
  }
  
  public static int t(Context paramContext) {
    boolean bool;
    try {
      bool = (paramContext.getResources().getConfiguration()).orientation;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  public static boolean u(Context paramContext) {
    boolean bool = true;
    if (t(paramContext) != 2) {
      if (t(paramContext) == 1)
        return false; 
      bool = false;
    } 
    return bool;
  }
  
  public static long v(Context paramContext) {
    long l = 0L;
    String str = cm.c(paramContext, "key_sys_config", "");
    try {
      JSONObject jSONObject = new JSONObject();
      this(str);
      long l1 = Long.valueOf(jSONObject.getJSONObject("buoyConf").getString("ablAliveTime")).longValue();
      l = l1 * 24L * 60L * 60L * 1000L;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return l;
  }
  
  public static void w(Context paramContext) {
    CookieSyncManager.createInstance(paramContext);
    CookieManager cookieManager = CookieManager.getInstance();
    if (Build.VERSION.SDK_INT >= 21) {
      cookieManager.removeSessionCookies(null);
      cookieManager.removeAllCookie();
      cookieManager.flush();
    } else {
      cookieManager.removeSessionCookies(null);
      cookieManager.removeAllCookie();
      CookieSyncManager.getInstance().sync();
    } 
    WebStorage.getInstance().deleteAllData();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
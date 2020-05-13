package com.xy.whf.helper;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarHelper {
  private static int a;
  
  private static int b;
  
  private static Integer c;
  
  public static float sVirtualDensity = -1.0F;
  
  public static float sVirtualDensityDpi = -1.0F;
  
  static {
    a = -1;
    b = 0;
  }
  
  @TargetApi(23)
  private static int a(Window paramWindow, int paramInt) {
    return a(paramWindow, a(paramWindow, a(paramWindow, a(paramWindow, a(paramWindow, a(paramWindow, paramInt, 1024), 4), 2), 4096), 1024), 512);
  }
  
  private static int a(Window paramWindow, int paramInt1, int paramInt2) {
    int i = paramInt1;
    if ((paramWindow.getDecorView().getSystemUiVisibility() & paramInt2) == paramInt2)
      i = paramInt1 | paramInt2; 
    return i;
  }
  
  private static void a(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 'com.android.internal.R$dimen'
    //   4: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual newInstance : ()Ljava/lang/Object;
    //   12: astore_3
    //   13: invokestatic isMeizu : ()Z
    //   16: istore #4
    //   18: iload #4
    //   20: ifeq -> 118
    //   23: aload_2
    //   24: ldc 'status_bar_height_large'
    //   26: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   29: astore #5
    //   31: aload #5
    //   33: astore_1
    //   34: aload_3
    //   35: astore #6
    //   37: aload #5
    //   39: ifnonnull -> 52
    //   42: aload_2
    //   43: ldc 'status_bar_height'
    //   45: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   48: astore_1
    //   49: aload_3
    //   50: astore #6
    //   52: aload_1
    //   53: ifnull -> 87
    //   56: aload #6
    //   58: ifnull -> 87
    //   61: aload_1
    //   62: aload #6
    //   64: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: invokestatic parseInt : (Ljava/lang/String;)I
    //   73: istore #7
    //   75: aload_0
    //   76: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   79: iload #7
    //   81: invokevirtual getDimensionPixelSize : (I)I
    //   84: putstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   87: aload_0
    //   88: invokestatic isTablet : (Landroid/content/Context;)Z
    //   91: ifeq -> 149
    //   94: getstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   97: aload_0
    //   98: bipush #25
    //   100: invokestatic a : (Landroid/content/Context;I)I
    //   103: if_icmple -> 149
    //   106: iconst_0
    //   107: putstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   110: return
    //   111: astore #5
    //   113: aload #5
    //   115: invokevirtual printStackTrace : ()V
    //   118: aconst_null
    //   119: astore #5
    //   121: goto -> 31
    //   124: astore #5
    //   126: aconst_null
    //   127: astore_3
    //   128: aload #5
    //   130: invokevirtual printStackTrace : ()V
    //   133: aload_3
    //   134: astore #6
    //   136: goto -> 52
    //   139: astore #5
    //   141: aload #5
    //   143: invokevirtual printStackTrace : ()V
    //   146: goto -> 87
    //   149: getstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   152: ifle -> 167
    //   155: getstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   158: aload_0
    //   159: bipush #50
    //   161: invokestatic a : (Landroid/content/Context;I)I
    //   164: if_icmple -> 110
    //   167: getstatic com/xy/whf/helper/StatusBarHelper.sVirtualDensity : F
    //   170: ldc -1.0
    //   172: fcmpl
    //   173: ifne -> 188
    //   176: aload_0
    //   177: bipush #25
    //   179: invokestatic a : (Landroid/content/Context;I)I
    //   182: putstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   185: goto -> 110
    //   188: ldc 25.0
    //   190: getstatic com/xy/whf/helper/StatusBarHelper.sVirtualDensity : F
    //   193: fmul
    //   194: ldc 0.5
    //   196: fadd
    //   197: f2i
    //   198: putstatic com/xy/whf/helper/StatusBarHelper.a : I
    //   201: goto -> 110
    //   204: astore #5
    //   206: goto -> 128
    //   209: astore #6
    //   211: aload #5
    //   213: astore_1
    //   214: aload #6
    //   216: astore #5
    //   218: goto -> 128
    // Exception table:
    //   from	to	target	type
    //   2	13	124	java/lang/Throwable
    //   13	18	204	java/lang/Throwable
    //   23	31	111	java/lang/Throwable
    //   42	49	209	java/lang/Throwable
    //   61	87	139	java/lang/Throwable
    //   113	118	204	java/lang/Throwable
  }
  
  private static boolean a() {
    return (DeviceHelper.b() || DeviceHelper.c() || DeviceHelper.isMIUIV7() || DeviceHelper.isMIUIV8());
  }
  
  private static boolean a(Activity paramActivity, int paramInt) {
    return (paramInt == 1) ? b(paramActivity.getWindow(), true) : ((paramInt == 2) ? c(paramActivity.getWindow(), true) : ((paramInt == 3) ? a(paramActivity.getWindow(), true) : false));
  }
  
  @TargetApi(23)
  private static boolean a(Window paramWindow, boolean paramBoolean) {
    char c;
    View view = paramWindow.getDecorView();
    if (paramBoolean) {
      c = ' ';
    } else {
      c = 'Ā';
    } 
    view.setSystemUiVisibility(a(paramWindow, c));
    if (DeviceHelper.isMIUIV9())
      b(paramWindow, paramBoolean); 
    return true;
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean) {
    boolean bool = true;
    if (paramWindow != null) {
      Class<?> clazz = paramWindow.getClass();
      try {
        Class<?> clazz1 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = clazz1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(clazz1);
        Method method = clazz.getMethod("setExtraFlags", new Class[] { int.class, int.class });
        if (paramBoolean) {
          method.invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          return bool;
        } 
        method.invoke(paramWindow, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        paramBoolean = bool;
      } catch (Exception exception) {
        paramBoolean = false;
      } 
      return paramBoolean;
    } 
    return false;
  }
  
  private static boolean c(Window paramWindow, boolean paramBoolean) {
    boolean bool = true;
    a(paramWindow, paramBoolean);
    if (paramWindow != null) {
      try {
        WindowManager.LayoutParams layoutParams = paramWindow.getAttributes();
        Field field1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field field2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        field1.setAccessible(true);
        field2.setAccessible(true);
        int i = field1.getInt(null);
        int j = field2.getInt(layoutParams);
        if (paramBoolean) {
          j = i | j;
        } else {
          j = (i ^ 0xFFFFFFFF) & j;
        } 
        field2.setInt(layoutParams, j);
        paramWindow.setAttributes(layoutParams);
        paramBoolean = bool;
      } catch (Exception exception) {
        paramBoolean = false;
      } 
      return paramBoolean;
    } 
    return false;
  }
  
  public static Integer getStatusBarAPITransparentValue(Context paramContext) {
    String str;
    if (c != null)
      return c; 
    String[] arrayOfString = paramContext.getPackageManager().getSystemSharedLibraryNames();
    int i = arrayOfString.length;
    paramContext = null;
    for (byte b = 0; b < i; b++) {
      String str1 = arrayOfString[b];
      if ("touchwiz".equals(str1)) {
        str = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
      } else if (str1.startsWith("com.sonyericsson.navigationbar")) {
        str = "SYSTEM_UI_FLAG_TRANSPARENT";
      } 
    } 
    if (str != null) {
      try {
        Field field = View.class.getField(str);
        if (field != null && field.getType() == int.class)
          c = Integer.valueOf(field.getInt(null)); 
        Integer integer1 = c;
      } catch (Exception exception) {}
      return (Integer)exception;
    } 
    Integer integer = c;
  }
  
  public static int getStatusbarHeight(Context paramContext) {
    if (a == -1)
      a(paramContext); 
    return a;
  }
  
  public static boolean isFullScreen(Activity paramActivity) {
    boolean bool = false;
    try {
      int i = (paramActivity.getWindow().getAttributes()).flags;
      if ((i & 0x400) != 0)
        bool = true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public static boolean setStatusBarDarkMode(Activity paramActivity) {
    boolean bool = false;
    if (paramActivity != null) {
      if (b == 0)
        return true; 
      if (b == 1)
        return b(paramActivity.getWindow(), false); 
      if (b == 2)
        return c(paramActivity.getWindow(), false); 
      if (b == 3)
        return a(paramActivity.getWindow(), false); 
      bool = true;
    } 
    return bool;
  }
  
  public static boolean setStatusBarLightMode(Activity paramActivity) {
    boolean bool1 = false;
    if (paramActivity == null)
      return bool1; 
    boolean bool2 = bool1;
    if (!DeviceHelper.isZTKC2016()) {
      if (b != 0)
        return a(paramActivity, b); 
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 19) {
        if (a() && b(paramActivity.getWindow(), true)) {
          b = 1;
          return true;
        } 
        if (c(paramActivity.getWindow(), true)) {
          b = 2;
          return true;
        } 
        bool2 = bool1;
        if (Build.VERSION.SDK_INT >= 23) {
          a(paramActivity.getWindow(), true);
          b = 3;
          bool2 = true;
        } 
      } 
    } 
    return bool2;
  }
  
  public static boolean supportTransclentStatusBar6() {
    return (!DeviceHelper.isZUKZ1() && !DeviceHelper.isZTKC2016());
  }
  
  public static boolean supportTranslucent() {
    boolean bool1 = false;
    if (Build.VERSION.SDK_INT < 19)
      return bool1; 
    boolean bool2 = bool1;
    if (!Build.BRAND.toLowerCase().contains("essential")) {
      if (DeviceHelper.isMeizu() || DeviceHelper.a())
        return true; 
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 21)
        bool2 = true; 
    } 
    return bool2;
  }
  
  public static void translucent(Activity paramActivity) {
    translucent(paramActivity, 1073741824);
  }
  
  @TargetApi(19)
  public static void translucent(Activity paramActivity, @ColorInt int paramInt) {
    if (supportTranslucent()) {
      if (DeviceHelper.isMeizu() || DeviceHelper.a()) {
        paramActivity.getWindow().setFlags(67108864, 67108864);
        return;
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        Window window = paramActivity.getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        if (Build.VERSION.SDK_INT >= 23 && supportTransclentStatusBar6()) {
          window.clearFlags(67108864);
          window.addFlags(-2147483648);
          window.setStatusBarColor(0);
          return;
        } 
        window.clearFlags(67108864);
        window.addFlags(-2147483648);
        window.setStatusBarColor(paramInt);
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\StatusBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
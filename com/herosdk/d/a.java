package com.herosdk.d;

import android.app.Activity;
import android.util.Log;

public class a {
  private static final String a = "frameLib.AdUtils";
  
  private static volatile a b;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/a.b : Lcom/herosdk/d/a;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/a
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/a.b : Lcom/herosdk/d/a;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/a
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/a.b : Lcom/herosdk/d/a;
    //   27: ldc com/herosdk/d/a
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/a.b : Lcom/herosdk/d/a;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/a
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showBanner", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showBanner...ex");
    } 
  }
  
  public void a(Activity paramActivity, String paramString) {
    try {
      b().getDeclaredMethod("showBanner", new Class[] { Activity.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showBanner...ex");
    } 
  }
  
  public Class<?> b() {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/herosdk/common/PluginUtils;
    //   3: invokevirtual getPluginList : ()Ljava/util/List;
    //   6: astore_1
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_1
    //   11: invokeinterface size : ()I
    //   16: if_icmpge -> 125
    //   19: aload_1
    //   20: iload_2
    //   21: invokeinterface get : (I)Ljava/lang/Object;
    //   26: checkcast java/lang/String
    //   29: astore_3
    //   30: aload_3
    //   31: ldc 'com.hu.plugin.ad'
    //   33: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   36: ifeq -> 105
    //   39: new java/lang/StringBuilder
    //   42: astore_1
    //   43: aload_1
    //   44: invokespecial <init> : ()V
    //   47: aload_1
    //   48: aload_3
    //   49: iconst_0
    //   50: aload_3
    //   51: ldc '.'
    //   53: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   56: invokevirtual substring : (II)Ljava/lang/String;
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc '.AdSdk'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: astore_3
    //   71: new java/lang/StringBuilder
    //   74: astore_1
    //   75: aload_1
    //   76: invokespecial <init> : ()V
    //   79: ldc 'frameLib.AdUtils'
    //   81: aload_1
    //   82: ldc 'getAdClass:'
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload_3
    //   99: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   102: astore_3
    //   103: aload_3
    //   104: areturn
    //   105: iinc #2, 1
    //   108: goto -> 9
    //   111: astore_3
    //   112: ldc 'frameLib.AdUtils'
    //   114: ldc 'getAdClass...ex'
    //   116: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aconst_null
    //   121: astore_3
    //   122: goto -> 103
    //   125: ldc ''
    //   127: astore_3
    //   128: goto -> 71
    // Exception table:
    //   from	to	target	type
    //   0	7	111	java/lang/ClassNotFoundException
    //   9	71	111	java/lang/ClassNotFoundException
    //   71	103	111	java/lang/ClassNotFoundException
  }
  
  public void b(Activity paramActivity) {
    try {
      b().getDeclaredMethod("hideBanner", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "hideBanner...ex");
    } 
  }
  
  public void b(Activity paramActivity, String paramString) {
    try {
      b().getDeclaredMethod("hideBanner", new Class[] { Activity.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "hideBanner...ex");
    } 
  }
  
  public void c(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showInterstialBanner", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showInterstialBanner...ex");
    } 
  }
  
  public void c(Activity paramActivity, String paramString) {
    try {
      b().getDeclaredMethod("showInterstialBanner", new Class[] { Activity.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showInterstialBanner...ex");
    } 
  }
  
  public void d(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showAdSplash", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showAdSplash...ex");
    } 
  }
  
  public void d(Activity paramActivity, String paramString) {
    try {
      b().getDeclaredMethod("showAdSplash", new Class[] { Activity.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showAdSplash...ex");
    } 
  }
  
  public void e(Activity paramActivity) {
    try {
      b().getDeclaredMethod("showAdVideo", new Class[] { Activity.class }).invoke(b(), new Object[] { paramActivity });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showAdVideo...ex");
    } 
  }
  
  public void e(Activity paramActivity, String paramString) {
    try {
      b().getDeclaredMethod("showAdVideo", new Class[] { Activity.class, String.class }).invoke(b(), new Object[] { paramActivity, paramString });
    } catch (Exception exception) {
      Log.d("frameLib.AdUtils", "showAdVideo...ex");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
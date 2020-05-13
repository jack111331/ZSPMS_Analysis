package com.tencent.tp;

import java.lang.reflect.Field;
import java.util.Vector;

public class c {
  static final String a = "EasyJNI";
  
  static ClassLoader b = c.class.getClassLoader();
  
  static Vector c = new Vector(2, 2);
  
  public static Class a(String paramString) {
    if (paramString != null) {
      String str = paramString;
      if (paramString.contains("/"))
        str = paramString.replace('/', '.'); 
      try {
        return (c.isEmpty() != true) ? ((ClassLoader)c.lastElement()).loadClass(str) : b.loadClass(str);
      } catch (ClassNotFoundException classNotFoundException) {}
    } 
    return null;
  }
  
  public static ClassLoader a(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/tencent/tp/c
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 12
    //   7: ldc com/tencent/tp/c
    //   9: monitorexit
    //   10: aconst_null
    //   11: areturn
    //   12: getstatic com/tencent/tp/c.c : Ljava/util/Vector;
    //   15: invokevirtual isEmpty : ()Z
    //   18: iconst_1
    //   19: if_icmpeq -> 35
    //   22: getstatic com/tencent/tp/c.c : Ljava/util/Vector;
    //   25: invokevirtual lastElement : ()Ljava/lang/Object;
    //   28: checkcast java/lang/ClassLoader
    //   31: astore_2
    //   32: goto -> 39
    //   35: getstatic com/tencent/tp/c.b : Ljava/lang/ClassLoader;
    //   38: astore_2
    //   39: invokestatic getPackageInfo : ()Landroid/content/pm/PackageInfo;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull -> 52
    //   47: ldc com/tencent/tp/c
    //   49: monitorexit
    //   50: aconst_null
    //   51: areturn
    //   52: new java/lang/StringBuilder
    //   55: astore_3
    //   56: aload_3
    //   57: invokespecial <init> : ()V
    //   60: aload_3
    //   61: invokestatic getPackageInfo : ()Landroid/content/pm/PackageInfo;
    //   64: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   67: getfield dataDir : Ljava/lang/String;
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: getstatic java/io/File.separatorChar : C
    //   78: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: ldc 'files'
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_3
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: astore_3
    //   94: new java/io/File
    //   97: astore #4
    //   99: aload #4
    //   101: aload_3
    //   102: invokespecial <init> : (Ljava/lang/String;)V
    //   105: aload #4
    //   107: invokevirtual exists : ()Z
    //   110: iconst_1
    //   111: if_icmpeq -> 120
    //   114: aload #4
    //   116: invokevirtual mkdirs : ()Z
    //   119: pop
    //   120: aload #4
    //   122: invokevirtual canWrite : ()Z
    //   125: pop
    //   126: new dalvik/system/DexClassLoader
    //   129: astore #4
    //   131: aload #4
    //   133: aload_0
    //   134: aload_3
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   140: getstatic com/tencent/tp/c.c : Ljava/util/Vector;
    //   143: aload #4
    //   145: invokevirtual add : (Ljava/lang/Object;)Z
    //   148: pop
    //   149: ldc com/tencent/tp/c
    //   151: monitorexit
    //   152: aload #4
    //   154: areturn
    //   155: astore_0
    //   156: ldc com/tencent/tp/c
    //   158: monitorexit
    //   159: aload_0
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   12	32	155	finally
    //   35	39	155	finally
    //   39	43	155	finally
    //   52	120	155	finally
    //   120	149	155	finally
  }
  
  public static Object a(Object paramObject, String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    if (paramObject == null)
      return null; 
    Class clazz = a(paramString1);
    if (clazz != null)
      try {
        return clazz.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      } catch (NoSuchMethodException|IllegalArgumentException|IllegalAccessException|java.lang.reflect.InvocationTargetException noSuchMethodException) {} 
    return null;
  }
  
  public static Object a(String paramString1, Object paramObject, String paramString2) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
    Field field = Class.forName(paramString1).getDeclaredField(paramString2);
    field.setAccessible(true);
    return field.get(paramObject);
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    Class clazz = a(paramString1);
    if (clazz != null)
      try {
        return clazz.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      } catch (NoSuchMethodException|IllegalArgumentException|IllegalAccessException|java.lang.reflect.InvocationTargetException noSuchMethodException) {} 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
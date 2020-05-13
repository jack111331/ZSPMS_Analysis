package com.zz.sdk.i;

import android.content.Context;
import android.content.res.Resources;
import java.lang.reflect.Field;
import java.util.HashMap;

public class ci {
  private static ci a = null;
  
  private static HashMap b = new HashMap<Object, Object>();
  
  private String c;
  
  private Context d;
  
  private HashMap e = new HashMap<Object, Object>();
  
  private HashMap f = new HashMap<Object, Object>();
  
  private ci(Context paramContext, Class paramClass, Class... paramVarArgs) {
    this.d = paramContext;
    this.c = paramContext.getPackageName();
    if (paramVarArgs != null)
      a(paramVarArgs); 
    a(paramClass.getClasses());
  }
  
  public static int a(Context paramContext, int paramInt) {
    return a(paramContext).a(paramInt);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, paramString1, paramString2, paramContext.getPackageName());
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Resources resources = paramContext.getResources();
    String str = paramString3 + "_" + paramString2 + "_" + paramString1;
    Integer integer = (Integer)b.get(str);
    if (integer != null)
      return integer.intValue(); 
    int i = resources.getIdentifier(paramString1, paramString2, paramString3);
    if (i <= 0)
      throw new RuntimeException("获取资源ID失败:(packageName=" + paramString3 + " type=" + paramString2 + " name=" + paramString1); 
    b.put(str, Integer.valueOf(i));
    return i;
  }
  
  public static ci a(Context paramContext) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/ci
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/ci.a : Lcom/zz/sdk/i/ci;
    //   6: ifnonnull -> 92
    //   9: ldc com/zz/sdk/i/ci
    //   11: monitorenter
    //   12: getstatic com/zz/sdk/i/ci.a : Lcom/zz/sdk/i/ci;
    //   15: ifnonnull -> 89
    //   18: new com/zz/sdk/i/ci
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   27: ldc com/zz/sdk/R
    //   29: bipush #9
    //   31: anewarray java/lang/Class
    //   34: dup
    //   35: iconst_0
    //   36: ldc com/zz/sdk/R$id
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc com/zz/sdk/R$string
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc com/zz/sdk/R$drawable
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc com/zz/sdk/R$layout
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc com/zz/sdk/R$color
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc com/zz/sdk/R$style
    //   63: aastore
    //   64: dup
    //   65: bipush #6
    //   67: ldc com/zz/sdk/R$attr
    //   69: aastore
    //   70: dup
    //   71: bipush #7
    //   73: ldc com/zz/sdk/R$styleable
    //   75: aastore
    //   76: dup
    //   77: bipush #8
    //   79: ldc com/zz/sdk/R$dimen
    //   81: aastore
    //   82: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;[Ljava/lang/Class;)V
    //   85: aload_1
    //   86: putstatic com/zz/sdk/i/ci.a : Lcom/zz/sdk/i/ci;
    //   89: ldc com/zz/sdk/i/ci
    //   91: monitorexit
    //   92: getstatic com/zz/sdk/i/ci.a : Lcom/zz/sdk/i/ci;
    //   95: astore_0
    //   96: ldc com/zz/sdk/i/ci
    //   98: monitorexit
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: ldc com/zz/sdk/i/ci
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: ldc com/zz/sdk/i/ci
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	107	finally
    //   12	89	101	finally
    //   89	92	101	finally
    //   92	96	107	finally
    //   102	105	101	finally
    //   105	107	107	finally
  }
  
  private void a(Class... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      Class clazz = paramVarArgs[b];
      String str = clazz.getSimpleName();
      if (str.contains("R$"))
        str = str.substring(2); 
      for (Field field : clazz.getDeclaredFields()) {
        if (field.getType() == int.class) {
          field.setAccessible(true);
          try {
            Integer integer = (Integer)field.get(clazz);
            ck ck = new ck();
            this(str, integer.intValue(), field.getName(), null);
            this.e.put(integer, ck);
          } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
          } 
        } 
      } 
    } 
  }
  
  public int a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/util/HashMap;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast java/lang/Integer
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull -> 87
    //   21: aload_0
    //   22: getfield e : Ljava/util/HashMap;
    //   25: iload_1
    //   26: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   29: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast com/zz/sdk/i/ck
    //   35: astore_2
    //   36: iload_1
    //   37: istore_3
    //   38: aload_2
    //   39: ifnull -> 83
    //   42: aload_0
    //   43: getfield d : Landroid/content/Context;
    //   46: aload_2
    //   47: getfield b : Ljava/lang/String;
    //   50: aload_2
    //   51: getfield a : Ljava/lang/String;
    //   54: aload_0
    //   55: getfield c : Ljava/lang/String;
    //   58: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   61: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   64: astore_2
    //   65: aload_0
    //   66: getfield f : Ljava/util/HashMap;
    //   69: iload_1
    //   70: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   73: aload_2
    //   74: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_2
    //   79: invokevirtual intValue : ()I
    //   82: istore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: iload_3
    //   86: ireturn
    //   87: aload_2
    //   88: invokevirtual intValue : ()I
    //   91: istore_3
    //   92: goto -> 83
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	95	finally
    //   21	36	95	finally
    //   42	83	95	finally
    //   87	92	95	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
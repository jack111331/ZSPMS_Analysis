package com.herosdk.a;

import android.app.Activity;
import android.content.Intent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public final class f {
  private static Map<Activity, Stack<j>> a = new HashMap<Activity, Stack<j>>();
  
  private static boolean b = false;
  
  private static boolean c = true;
  
  public static h<String, Object> a() {
    return new h<String, Object>();
  }
  
  public static j a(Activity paramActivity) {
    try {
      Stack<j> stack = j(paramActivity);
      if (stack == null)
        return null; 
      if (stack.empty())
        return null; 
      j j = stack.peek();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (j)exception;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    try {
      Stack<j> stack = j(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            j j = stack.peek();
            if (j != null) {
              if (j.r()) {
                stack.remove(j);
                continue;
              } 
              j.a(paramInt1, paramInt2, paramIntent);
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Activity paramActivity, Intent paramIntent) {
    try {
      Stack<j> stack = j(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            j j = stack.peek();
            if (j != null) {
              if (j.r()) {
                stack.remove(j);
                continue;
              } 
              j.a(paramIntent);
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Activity paramActivity, j paramj) {
    // Byte code:
    //   0: ldc com/herosdk/a/f
    //   2: monitorenter
    //   3: aload_0
    //   4: iconst_1
    //   5: invokestatic c : (Landroid/app/Activity;Z)Ljava/util/Stack;
    //   8: astore_0
    //   9: aload_0
    //   10: ifnonnull -> 17
    //   13: ldc com/herosdk/a/f
    //   15: monitorexit
    //   16: return
    //   17: aload_1
    //   18: ifnull -> 13
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual contains : (Ljava/lang/Object;)Z
    //   26: ifne -> 13
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   34: pop
    //   35: goto -> 13
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual printStackTrace : ()V
    //   43: goto -> 13
    //   46: astore_0
    //   47: ldc com/herosdk/a/f
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	38	java/lang/Exception
    //   3	9	46	finally
    //   21	35	38	java/lang/Exception
    //   21	35	46	finally
    //   39	43	46	finally
  }
  
  public static void a(Activity paramActivity, Class<? extends a> paramClass, Map<String, Object> paramMap) {
    a(paramActivity, paramClass, paramMap, false);
  }
  
  public static void a(Activity paramActivity, Class<? extends a> paramClass, Map<String, Object> paramMap, boolean paramBoolean) {
    try {
      i(paramActivity);
      a a = paramClass.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { paramActivity });
      a.a(paramMap);
      a.f();
      if (b)
        a.o(); 
      j j = a(paramActivity);
      if (j != null)
        if (paramBoolean) {
          g g = new g();
          this(j);
          a.a(g, 500L);
        } else {
          j.p();
        }  
      a.show();
      a(paramActivity, a);
      a.u();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/herosdk/a/f
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic j : (Landroid/app/Activity;)Ljava/util/Stack;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull -> 21
    //   12: aload_0
    //   13: iload_1
    //   14: invokestatic b : (Landroid/app/Activity;Z)V
    //   17: ldc com/herosdk/a/f
    //   19: monitorexit
    //   20: return
    //   21: aload_2
    //   22: invokevirtual iterator : ()Ljava/util/Iterator;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 85
    //   35: aload_2
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast com/herosdk/a/j
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull -> 62
    //   49: aload_3
    //   50: invokeinterface r : ()Z
    //   55: ifne -> 62
    //   58: aload_3
    //   59: invokestatic a : (Lcom/herosdk/a/j;)V
    //   62: aload_2
    //   63: invokeinterface remove : ()V
    //   68: goto -> 26
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual printStackTrace : ()V
    //   76: goto -> 17
    //   79: astore_0
    //   80: ldc com/herosdk/a/f
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: getstatic com/herosdk/a/f.a : Ljava/util/Map;
    //   88: aload_0
    //   89: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload_0
    //   96: iload_1
    //   97: invokestatic b : (Landroid/app/Activity;Z)V
    //   100: goto -> 17
    // Exception table:
    //   from	to	target	type
    //   3	8	71	java/lang/Exception
    //   3	8	79	finally
    //   12	17	71	java/lang/Exception
    //   12	17	79	finally
    //   21	26	71	java/lang/Exception
    //   21	26	79	finally
    //   26	45	71	java/lang/Exception
    //   26	45	79	finally
    //   49	62	71	java/lang/Exception
    //   49	62	79	finally
    //   62	68	71	java/lang/Exception
    //   62	68	79	finally
    //   72	76	79	finally
    //   85	100	71	java/lang/Exception
    //   85	100	79	finally
  }
  
  public static void a(j paramj) {
    try {
      paramj.s();
      paramj.p();
      paramj.q();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private static void a(Iterator<j> paramIterator, j paramj, Class<? extends j> paramClass) {
    // Byte code:
    //   0: ldc com/herosdk/a/f
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 70
    //   7: aload_1
    //   8: invokeinterface r : ()Z
    //   13: ifne -> 47
    //   16: aload_1
    //   17: invokevirtual getClass : ()Ljava/lang/Class;
    //   20: invokevirtual getName : ()Ljava/lang/String;
    //   23: aload_2
    //   24: invokevirtual getName : ()Ljava/lang/String;
    //   27: invokevirtual equals : (Ljava/lang/Object;)Z
    //   30: ifeq -> 43
    //   33: aload_1
    //   34: invokestatic a : (Lcom/herosdk/a/j;)V
    //   37: aload_0
    //   38: invokeinterface remove : ()V
    //   43: ldc com/herosdk/a/f
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: invokeinterface remove : ()V
    //   53: goto -> 43
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual printStackTrace : ()V
    //   61: goto -> 43
    //   64: astore_0
    //   65: ldc com/herosdk/a/f
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    //   70: aload_0
    //   71: invokeinterface remove : ()V
    //   76: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   7	43	56	java/lang/Exception
    //   7	43	64	finally
    //   47	53	56	java/lang/Exception
    //   47	53	64	finally
    //   57	61	64	finally
    //   70	76	56	java/lang/Exception
    //   70	76	64	finally
  }
  
  public static int b(Activity paramActivity) {
    int i = 0;
    try {
      Stack<j> stack = j(paramActivity);
      if (stack != null) {
        int j = stack.size();
        i = j;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return i;
  }
  
  public static void b(Activity paramActivity, j paramj) {
    // Byte code:
    //   0: ldc com/herosdk/a/f
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic j : (Landroid/app/Activity;)Ljava/util/Stack;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull -> 16
    //   12: ldc com/herosdk/a/f
    //   14: monitorexit
    //   15: return
    //   16: aload_1
    //   17: ifnull -> 12
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual contains : (Ljava/lang/Object;)Z
    //   25: ifeq -> 12
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual remove : (Ljava/lang/Object;)Z
    //   33: pop
    //   34: goto -> 12
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual printStackTrace : ()V
    //   42: goto -> 12
    //   45: astore_0
    //   46: ldc com/herosdk/a/f
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	37	java/lang/Exception
    //   3	8	45	finally
    //   20	34	37	java/lang/Exception
    //   20	34	45	finally
    //   38	42	45	finally
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/herosdk/a/f
    //   2: monitorenter
    //   3: iload_1
    //   4: ifeq -> 24
    //   7: aload_0
    //   8: invokevirtual isFinishing : ()Z
    //   11: ifne -> 24
    //   14: aload_0
    //   15: invokevirtual onBackPressed : ()V
    //   18: aload_0
    //   19: iconst_0
    //   20: iconst_0
    //   21: invokevirtual overridePendingTransition : (II)V
    //   24: ldc com/herosdk/a/f
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual printStackTrace : ()V
    //   33: goto -> 24
    //   36: astore_0
    //   37: ldc com/herosdk/a/f
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   7	24	28	java/lang/Exception
    //   7	24	36	finally
    //   29	33	36	finally
  }
  
  private static Stack<j> c(Activity paramActivity, boolean paramBoolean) {
    Stack stack;
    try {
      Stack<j> stack1 = a.get(paramActivity);
      stack = stack1;
      if (stack1 == null) {
        stack = stack1;
        if (paramBoolean) {
          stack = new Stack();
          this();
          a.put(paramActivity, stack);
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      stack = null;
    } 
    return stack;
  }
  
  public static void c(Activity paramActivity) {
    // Byte code:
    //   0: ldc com/herosdk/a/f
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic com/herosdk/a/f.c : Z
    //   7: invokestatic a : (Landroid/app/Activity;Z)V
    //   10: ldc com/herosdk/a/f
    //   12: monitorexit
    //   13: return
    //   14: astore_0
    //   15: ldc com/herosdk/a/f
    //   17: monitorexit
    //   18: aload_0
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	14	finally
  }
  
  public static void d(Activity paramActivity) {
    try {
      e(paramActivity);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void e(Activity paramActivity) {
    try {
      Stack<j> stack = j(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            j j = stack.pop();
            if (j != null) {
              if (!j.r()) {
                a(j);
                return;
              } 
              continue;
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void f(Activity paramActivity) {
    try {
      b = true;
      Stack<j> stack = j(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            j j = stack.peek();
            if (j != null) {
              if (j.r()) {
                stack.remove(j);
                continue;
              } 
              j.o();
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void g(Activity paramActivity) {
    b = false;
    k(paramActivity);
  }
  
  public static void h(Activity paramActivity) {
    try {
      if (j(paramActivity) != null)
        c(paramActivity); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void i(Activity paramActivity) {
    try {
      Stack<j> stack = j(paramActivity);
      if (stack != null && !stack.empty()) {
        Iterator<j> iterator = stack.iterator();
        while (true) {
          if (iterator.hasNext()) {
            j j = iterator.next();
            if (j != null && j.r())
              iterator.remove(); 
            continue;
          } 
          return;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private static Stack<j> j(Activity paramActivity) {
    return c(paramActivity, false);
  }
  
  private static void k(Activity paramActivity) {
    try {
      Stack<j> stack = j(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            j j = stack.peek();
            if (j != null) {
              if (j.r()) {
                stack.remove(j);
                continue;
              } 
              j.p();
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.zz.sdk.a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import com.zz.sdk.d.b;
import com.zz.sdk.i.bp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public final class bv {
  private static Map a = new HashMap<Object, Object>();
  
  private static boolean b = false;
  
  private static boolean c = true;
  
  public static bx a() {
    return new bx();
  }
  
  public static b a(Activity paramActivity) {
    try {
      bp.a("DialogStack...getCurDialog");
      Stack<b> stack = k(paramActivity);
      if (stack == null)
        return null; 
      if (stack.empty())
        return null; 
      b b = stack.peek();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (b)exception;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    try {
      bp.a("DialogStack...onActivityResult");
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            b b = stack.peek();
            if (b != null) {
              if (b.t()) {
                stack.remove(b);
                continue;
              } 
              b.a(paramInt1, paramInt2, paramIntent);
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
      bp.a("DialogStack...onNewIntent");
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            b b = stack.peek();
            if (b != null) {
              if (b.t()) {
                stack.remove(b);
                continue;
              } 
              b.a(paramIntent);
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Activity paramActivity, Configuration paramConfiguration) {
    try {
      bp.a("DialogStack...onConfigurationChanged");
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            b b = stack.peek();
            if (b != null) {
              if (b.t()) {
                stack.remove(b);
                continue;
              } 
              b.a(paramConfiguration);
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Activity paramActivity, b paramb) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc 'DialogStack...addDialog'
    //   5: invokestatic a : (Ljava/lang/Object;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic c : (Landroid/app/Activity;Z)Ljava/util/Stack;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull -> 22
    //   18: ldc com/zz/sdk/a/bv
    //   20: monitorexit
    //   21: return
    //   22: aload_1
    //   23: ifnull -> 18
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual contains : (Ljava/lang/Object;)Z
    //   31: ifne -> 18
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: goto -> 18
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual printStackTrace : ()V
    //   48: goto -> 18
    //   51: astore_0
    //   52: ldc com/zz/sdk/a/bv
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	43	java/lang/Exception
    //   3	14	51	finally
    //   26	40	43	java/lang/Exception
    //   26	40	51	finally
    //   44	48	51	finally
  }
  
  public static void a(Activity paramActivity, b paramb, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc 'DialogStack...exitAllDialog 3p'
    //   5: invokestatic a : (Ljava/lang/Object;)V
    //   8: aload_0
    //   9: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull -> 21
    //   17: ldc com/zz/sdk/a/bv
    //   19: monitorexit
    //   20: return
    //   21: aload_3
    //   22: invokevirtual iterator : ()Ljava/util/Iterator;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 90
    //   35: aload_3
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast com/zz/sdk/d/b
    //   44: astore #4
    //   46: aload #4
    //   48: aload_1
    //   49: if_acmpeq -> 26
    //   52: aload #4
    //   54: invokeinterface t : ()Z
    //   59: ifne -> 67
    //   62: aload #4
    //   64: invokestatic a : (Lcom/zz/sdk/d/b;)V
    //   67: aload_3
    //   68: invokeinterface remove : ()V
    //   73: goto -> 26
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual printStackTrace : ()V
    //   81: goto -> 17
    //   84: astore_0
    //   85: ldc com/zz/sdk/a/bv
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    //   90: iload_2
    //   91: ifeq -> 17
    //   94: aload_0
    //   95: invokestatic l : (Landroid/app/Activity;)V
    //   98: goto -> 17
    // Exception table:
    //   from	to	target	type
    //   3	13	76	java/lang/Exception
    //   3	13	84	finally
    //   21	26	76	java/lang/Exception
    //   21	26	84	finally
    //   26	46	76	java/lang/Exception
    //   26	46	84	finally
    //   52	67	76	java/lang/Exception
    //   52	67	84	finally
    //   67	73	76	java/lang/Exception
    //   67	73	84	finally
    //   77	81	84	finally
    //   94	98	76	java/lang/Exception
    //   94	98	84	finally
  }
  
  public static void a(Activity paramActivity, Class paramClass) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: invokespecial <init> : ()V
    //   11: aload_2
    //   12: ldc 'DialogStack...exitAllDialog activity:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual toString : ()Ljava/lang/String;
    //   24: invokestatic a : (Ljava/lang/Object;)V
    //   27: ldc 'DialogStack...exitAllDialog saveBaseIDialog'
    //   29: invokestatic a : (Ljava/lang/Object;)V
    //   32: aload_0
    //   33: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull -> 45
    //   41: ldc com/zz/sdk/a/bv
    //   43: monitorexit
    //   44: return
    //   45: aload_2
    //   46: invokevirtual iterator : ()Ljava/util/Iterator;
    //   49: astore_3
    //   50: aload_3
    //   51: invokeinterface hasNext : ()Z
    //   56: ifeq -> 144
    //   59: aload_3
    //   60: invokeinterface next : ()Ljava/lang/Object;
    //   65: checkcast com/zz/sdk/d/b
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull -> 135
    //   73: aload_2
    //   74: invokeinterface t : ()Z
    //   79: ifne -> 126
    //   82: aload_2
    //   83: invokevirtual getClass : ()Ljava/lang/Class;
    //   86: invokevirtual getName : ()Ljava/lang/String;
    //   89: aload_1
    //   90: invokevirtual getName : ()Ljava/lang/String;
    //   93: invokevirtual equals : (Ljava/lang/Object;)Z
    //   96: ifne -> 50
    //   99: aload_2
    //   100: invokestatic a : (Lcom/zz/sdk/d/b;)V
    //   103: aload_3
    //   104: invokeinterface remove : ()V
    //   109: goto -> 50
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual printStackTrace : ()V
    //   117: goto -> 41
    //   120: astore_0
    //   121: ldc com/zz/sdk/a/bv
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    //   126: aload_3
    //   127: invokeinterface remove : ()V
    //   132: goto -> 50
    //   135: aload_3
    //   136: invokeinterface remove : ()V
    //   141: goto -> 50
    //   144: aload_0
    //   145: invokestatic l : (Landroid/app/Activity;)V
    //   148: goto -> 41
    // Exception table:
    //   from	to	target	type
    //   3	37	112	java/lang/Exception
    //   3	37	120	finally
    //   45	50	112	java/lang/Exception
    //   45	50	120	finally
    //   50	69	112	java/lang/Exception
    //   50	69	120	finally
    //   73	109	112	java/lang/Exception
    //   73	109	120	finally
    //   113	117	120	finally
    //   126	132	112	java/lang/Exception
    //   126	132	120	finally
    //   135	141	112	java/lang/Exception
    //   135	141	120	finally
    //   144	148	112	java/lang/Exception
    //   144	148	120	finally
  }
  
  public static void a(Activity paramActivity, Class paramClass, b paramb) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc 'DialogStack...exitDialog 3p'
    //   5: invokestatic a : (Ljava/lang/Object;)V
    //   8: aload_0
    //   9: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull -> 21
    //   17: ldc com/zz/sdk/a/bv
    //   19: monitorexit
    //   20: return
    //   21: aload_3
    //   22: invokevirtual iterator : ()Ljava/util/Iterator;
    //   25: astore #4
    //   27: aload #4
    //   29: invokeinterface hasNext : ()Z
    //   34: ifeq -> 77
    //   37: aload #4
    //   39: invokeinterface next : ()Ljava/lang/Object;
    //   44: checkcast com/zz/sdk/d/b
    //   47: astore_3
    //   48: aload_3
    //   49: aload_2
    //   50: if_acmpeq -> 27
    //   53: aload #4
    //   55: aload_3
    //   56: aload_1
    //   57: invokestatic a : (Ljava/util/Iterator;Lcom/zz/sdk/d/b;Ljava/lang/Class;)V
    //   60: goto -> 27
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual printStackTrace : ()V
    //   68: goto -> 17
    //   71: astore_0
    //   72: ldc com/zz/sdk/a/bv
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: aload_0
    //   78: invokestatic l : (Landroid/app/Activity;)V
    //   81: goto -> 17
    // Exception table:
    //   from	to	target	type
    //   3	13	63	java/lang/Exception
    //   3	13	71	finally
    //   21	27	63	java/lang/Exception
    //   21	27	71	finally
    //   27	48	63	java/lang/Exception
    //   27	48	71	finally
    //   53	60	63	java/lang/Exception
    //   53	60	71	finally
    //   64	68	71	finally
    //   77	81	63	java/lang/Exception
    //   77	81	71	finally
  }
  
  public static void a(Activity paramActivity, Class paramClass, Map paramMap) {
    a(paramActivity, paramClass, paramMap, false);
  }
  
  public static void a(Activity paramActivity, Class<w> paramClass, Map paramMap, boolean paramBoolean) {
    try {
      bp.a("DialogStack...startDialog");
      j(paramActivity);
      w w = paramClass.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { paramActivity });
      w.a(paramMap);
      w.m();
      if (b)
        w.e(); 
      b b = a(paramActivity);
      if (b != null)
        if (paramBoolean) {
          bw bw = new bw();
          this(b);
          w.a(bw, 500L);
        } else {
          b.d();
        }  
      w.show();
      a(paramActivity, w);
      w.f();
    } catch (Exception exception) {
      bp.a("DialogStack startDialog exception " + exception.toString());
    } 
  }
  
  public static void a(Activity paramActivity, Class paramClass, boolean paramBoolean) {
    a(paramActivity, paramClass, (Map)null, paramBoolean);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: invokespecial <init> : ()V
    //   11: aload_2
    //   12: ldc 'DialogStack...exitAllDialog activity:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual toString : ()Ljava/lang/String;
    //   24: invokestatic a : (Ljava/lang/Object;)V
    //   27: new java/lang/StringBuilder
    //   30: astore_2
    //   31: aload_2
    //   32: invokespecial <init> : ()V
    //   35: aload_2
    //   36: ldc 'DialogStack...exitAllDialog isActivityBack:'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_1
    //   42: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: invokestatic a : (Ljava/lang/Object;)V
    //   51: aload_0
    //   52: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnonnull -> 69
    //   60: aload_0
    //   61: iload_1
    //   62: invokestatic b : (Landroid/app/Activity;Z)V
    //   65: ldc com/zz/sdk/a/bv
    //   67: monitorexit
    //   68: return
    //   69: aload_2
    //   70: invokevirtual iterator : ()Ljava/util/Iterator;
    //   73: astore_2
    //   74: aload_2
    //   75: invokeinterface hasNext : ()Z
    //   80: ifeq -> 133
    //   83: aload_2
    //   84: invokeinterface next : ()Ljava/lang/Object;
    //   89: checkcast com/zz/sdk/d/b
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull -> 110
    //   97: aload_3
    //   98: invokeinterface t : ()Z
    //   103: ifne -> 110
    //   106: aload_3
    //   107: invokestatic a : (Lcom/zz/sdk/d/b;)V
    //   110: aload_2
    //   111: invokeinterface remove : ()V
    //   116: goto -> 74
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual printStackTrace : ()V
    //   124: goto -> 65
    //   127: astore_0
    //   128: ldc com/zz/sdk/a/bv
    //   130: monitorexit
    //   131: aload_0
    //   132: athrow
    //   133: getstatic com/zz/sdk/a/bv.a : Ljava/util/Map;
    //   136: aload_0
    //   137: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_0
    //   144: iload_1
    //   145: invokestatic b : (Landroid/app/Activity;Z)V
    //   148: goto -> 65
    // Exception table:
    //   from	to	target	type
    //   3	56	119	java/lang/Exception
    //   3	56	127	finally
    //   60	65	119	java/lang/Exception
    //   60	65	127	finally
    //   69	74	119	java/lang/Exception
    //   69	74	127	finally
    //   74	93	119	java/lang/Exception
    //   74	93	127	finally
    //   97	110	119	java/lang/Exception
    //   97	110	127	finally
    //   110	116	119	java/lang/Exception
    //   110	116	127	finally
    //   120	124	127	finally
    //   133	148	119	java/lang/Exception
    //   133	148	127	finally
  }
  
  public static void a(b paramb) {
    try {
      bp.a("DialogStack...finish");
      paramb.u();
      paramb.d();
      paramb.s();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private static void a(Iterator paramIterator, b paramb, Class paramClass) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc 'DialogStack...removeDialog'
    //   5: invokestatic a : (Ljava/lang/Object;)V
    //   8: aload_1
    //   9: ifnull -> 75
    //   12: aload_1
    //   13: invokeinterface t : ()Z
    //   18: ifne -> 52
    //   21: aload_1
    //   22: invokevirtual getClass : ()Ljava/lang/Class;
    //   25: invokevirtual getName : ()Ljava/lang/String;
    //   28: aload_2
    //   29: invokevirtual getName : ()Ljava/lang/String;
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 48
    //   38: aload_1
    //   39: invokestatic a : (Lcom/zz/sdk/d/b;)V
    //   42: aload_0
    //   43: invokeinterface remove : ()V
    //   48: ldc com/zz/sdk/a/bv
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: invokeinterface remove : ()V
    //   58: goto -> 48
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual printStackTrace : ()V
    //   66: goto -> 48
    //   69: astore_0
    //   70: ldc com/zz/sdk/a/bv
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    //   75: aload_0
    //   76: invokeinterface remove : ()V
    //   81: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   3	8	61	java/lang/Exception
    //   3	8	69	finally
    //   12	48	61	java/lang/Exception
    //   12	48	69	finally
    //   52	58	61	java/lang/Exception
    //   52	58	69	finally
    //   62	66	69	finally
    //   75	81	61	java/lang/Exception
    //   75	81	69	finally
  }
  
  public static void a(boolean paramBoolean) {
    bp.a("DialogStack...setIsActivityBack:" + paramBoolean);
    c = paramBoolean;
  }
  
  public static int b(Activity paramActivity) {
    int i = 0;
    try {
      bp.a("DialogStack...getDialogStackSize");
      Stack stack = k(paramActivity);
      if (stack != null) {
        int j = stack.size();
        i = j;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return i;
  }
  
  public static void b(Activity paramActivity, b paramb) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc 'DialogStack...removeDialog'
    //   5: invokestatic a : (Ljava/lang/Object;)V
    //   8: aload_0
    //   9: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 21
    //   17: ldc com/zz/sdk/a/bv
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: ifnull -> 17
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual contains : (Ljava/lang/Object;)Z
    //   30: ifeq -> 17
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual remove : (Ljava/lang/Object;)Z
    //   38: pop
    //   39: goto -> 17
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual printStackTrace : ()V
    //   47: goto -> 17
    //   50: astore_0
    //   51: ldc com/zz/sdk/a/bv
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	42	java/lang/Exception
    //   3	13	50	finally
    //   25	39	42	java/lang/Exception
    //   25	39	50	finally
    //   43	47	50	finally
  }
  
  public static void b(Activity paramActivity, Class paramClass) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc 'DialogStack...exitDialog 2p'
    //   5: invokestatic a : (Ljava/lang/Object;)V
    //   8: aload_0
    //   9: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull -> 21
    //   17: ldc com/zz/sdk/a/bv
    //   19: monitorexit
    //   20: return
    //   21: aload_2
    //   22: invokevirtual iterator : ()Ljava/util/Iterator;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 66
    //   35: aload_2
    //   36: aload_2
    //   37: invokeinterface next : ()Ljava/lang/Object;
    //   42: checkcast com/zz/sdk/d/b
    //   45: aload_1
    //   46: invokestatic a : (Ljava/util/Iterator;Lcom/zz/sdk/d/b;Ljava/lang/Class;)V
    //   49: goto -> 26
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual printStackTrace : ()V
    //   57: goto -> 17
    //   60: astore_0
    //   61: ldc com/zz/sdk/a/bv
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    //   66: aload_0
    //   67: invokestatic l : (Landroid/app/Activity;)V
    //   70: goto -> 17
    // Exception table:
    //   from	to	target	type
    //   3	13	52	java/lang/Exception
    //   3	13	60	finally
    //   21	26	52	java/lang/Exception
    //   21	26	60	finally
    //   26	49	52	java/lang/Exception
    //   26	49	60	finally
    //   53	57	60	finally
    //   66	70	52	java/lang/Exception
    //   66	70	60	finally
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: invokespecial <init> : ()V
    //   11: aload_2
    //   12: ldc 'DialogStack...backActivity activity:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual toString : ()Ljava/lang/String;
    //   24: invokestatic a : (Ljava/lang/Object;)V
    //   27: new java/lang/StringBuilder
    //   30: astore_2
    //   31: aload_2
    //   32: invokespecial <init> : ()V
    //   35: aload_2
    //   36: ldc 'DialogStack...backActivity isActivityBack:'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_1
    //   42: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: invokestatic a : (Ljava/lang/Object;)V
    //   51: iload_1
    //   52: ifeq -> 78
    //   55: aload_0
    //   56: invokevirtual isFinishing : ()Z
    //   59: ifne -> 78
    //   62: getstatic com/zz/sdk/a/gh.c : Z
    //   65: ifeq -> 78
    //   68: aload_0
    //   69: invokevirtual onBackPressed : ()V
    //   72: aload_0
    //   73: iconst_0
    //   74: iconst_0
    //   75: invokevirtual overridePendingTransition : (II)V
    //   78: ldc com/zz/sdk/a/bv
    //   80: monitorexit
    //   81: return
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual printStackTrace : ()V
    //   87: goto -> 78
    //   90: astore_0
    //   91: ldc com/zz/sdk/a/bv
    //   93: monitorexit
    //   94: aload_0
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   3	51	82	java/lang/Exception
    //   3	51	90	finally
    //   55	78	82	java/lang/Exception
    //   55	78	90	finally
    //   83	87	90	finally
  }
  
  public static boolean b() {
    return c;
  }
  
  private static Stack c(Activity paramActivity, boolean paramBoolean) {
    Stack stack;
    try {
      bp.a("DialogStack...getDialogList");
      Stack stack1 = (Stack)a.get(paramActivity);
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
  
  protected static void c(Activity paramActivity) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc_w 'DialogStack...removeAllDialog'
    //   6: invokestatic a : (Ljava/lang/Object;)V
    //   9: aload_0
    //   10: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull -> 22
    //   18: ldc com/zz/sdk/a/bv
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: invokevirtual clear : ()V
    //   26: goto -> 18
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual printStackTrace : ()V
    //   34: goto -> 18
    //   37: astore_0
    //   38: ldc com/zz/sdk/a/bv
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	29	java/lang/Exception
    //   3	14	37	finally
    //   22	26	29	java/lang/Exception
    //   22	26	37	finally
    //   30	34	37	finally
  }
  
  public static void c(Activity paramActivity, b paramb) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc_w 'DialogStack...exitAllDialog 2p'
    //   6: invokestatic a : (Ljava/lang/Object;)V
    //   9: aload_0
    //   10: aload_1
    //   11: iconst_1
    //   12: invokestatic a : (Landroid/app/Activity;Lcom/zz/sdk/d/b;Z)V
    //   15: ldc com/zz/sdk/a/bv
    //   17: monitorexit
    //   18: return
    //   19: astore_0
    //   20: ldc com/zz/sdk/a/bv
    //   22: monitorexit
    //   23: aload_0
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	19	finally
  }
  
  public static boolean c(Activity paramActivity, Class paramClass) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc_w 'DialogStack...containsDialog'
    //   6: invokestatic a : (Ljava/lang/Object;)V
    //   9: aload_0
    //   10: invokestatic k : (Landroid/app/Activity;)Ljava/util/Stack;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull -> 25
    //   18: iconst_0
    //   19: istore_2
    //   20: ldc com/zz/sdk/a/bv
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: invokevirtual iterator : ()Ljava/util/Iterator;
    //   29: astore_0
    //   30: aload_0
    //   31: invokeinterface hasNext : ()Z
    //   36: ifeq -> 91
    //   39: aload_0
    //   40: invokeinterface next : ()Ljava/lang/Object;
    //   45: checkcast com/zz/sdk/d/b
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull -> 30
    //   53: aload_3
    //   54: invokeinterface t : ()Z
    //   59: ifne -> 30
    //   62: aload_3
    //   63: invokevirtual getClass : ()Ljava/lang/Class;
    //   66: invokevirtual getName : ()Ljava/lang/String;
    //   69: aload_1
    //   70: invokevirtual getName : ()Ljava/lang/String;
    //   73: invokevirtual equals : (Ljava/lang/Object;)Z
    //   76: istore_2
    //   77: iload_2
    //   78: ifeq -> 30
    //   81: iconst_1
    //   82: istore_2
    //   83: goto -> 20
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual printStackTrace : ()V
    //   91: iconst_0
    //   92: istore_2
    //   93: goto -> 20
    //   96: astore_0
    //   97: ldc com/zz/sdk/a/bv
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	86	java/lang/Exception
    //   3	14	96	finally
    //   25	30	86	java/lang/Exception
    //   25	30	96	finally
    //   30	49	86	java/lang/Exception
    //   30	49	96	finally
    //   53	77	86	java/lang/Exception
    //   53	77	96	finally
    //   87	91	96	finally
  }
  
  public static void d(Activity paramActivity) {
    // Byte code:
    //   0: ldc com/zz/sdk/a/bv
    //   2: monitorenter
    //   3: ldc_w 'DialogStack...exitAllDialog'
    //   6: invokestatic a : (Ljava/lang/Object;)V
    //   9: aload_0
    //   10: getstatic com/zz/sdk/a/bv.c : Z
    //   13: invokestatic a : (Landroid/app/Activity;Z)V
    //   16: ldc com/zz/sdk/a/bv
    //   18: monitorexit
    //   19: return
    //   20: astore_0
    //   21: ldc com/zz/sdk/a/bv
    //   23: monitorexit
    //   24: aload_0
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	20	finally
  }
  
  public static void d(Activity paramActivity, Class paramClass) {
    a(paramActivity, paramClass, false);
  }
  
  public static void e(Activity paramActivity) {
    try {
      bp.a("DialogStack...onBack");
      f(paramActivity);
      l(paramActivity);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void f(Activity paramActivity) {
    try {
      bp.a("DialogStack...finishCurDialog");
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            b b = stack.pop();
            if (b != null) {
              if (!b.t()) {
                a(b);
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
  
  public static void g(Activity paramActivity) {
    try {
      bp.a("DialogStack...onResume");
      b = true;
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            b b = stack.peek();
            if (b != null) {
              if (b.t()) {
                stack.remove(b);
                continue;
              } 
              b.e();
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void h(Activity paramActivity) {
    bp.a("DialogStack...onPause");
    b = false;
    m(paramActivity);
  }
  
  public static void i(Activity paramActivity) {
    try {
      bp.a("DialogStack...onDestroy");
      if (k(paramActivity) != null)
        d(paramActivity); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void j(Activity paramActivity) {
    try {
      bp.a("DialogStack...clearFinish");
      Stack stack = k(paramActivity);
      if (stack != null && !stack.empty()) {
        Iterator<b> iterator = stack.iterator();
        while (true) {
          if (iterator.hasNext()) {
            b b = iterator.next();
            if (b != null && b.t())
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
  
  private static Stack k(Activity paramActivity) {
    return c(paramActivity, false);
  }
  
  private static void l(Activity paramActivity) {
    try {
      bp.a("DialogStack...showPrevious");
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (stack.empty()) {
            if (c) {
              bp.a("DialogStack...showPrevious...if activity back");
              paramActivity.onBackPressed();
              paramActivity.overridePendingTransition(0, 0);
              return;
            } 
            bp.a("DialogStack...showPrevious...else do nothing");
            c = true;
            return;
          } 
          b b = stack.peek();
          if (b == null) {
            if (c) {
              bp.a("DialogStack...showPrevious...if activity back");
              paramActivity.onBackPressed();
              paramActivity.overridePendingTransition(0, 0);
              return;
            } 
            bp.a("DialogStack...showPrevious...else do nothing");
            c = true;
            return;
          } 
          if (b.t()) {
            stack.remove(b);
            continue;
          } 
          b.e();
          b.show();
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private static void m(Activity paramActivity) {
    try {
      bp.a("DialogStack...pauseCurDialog");
      Stack<b> stack = k(paramActivity);
      if (stack != null)
        while (true) {
          if (!stack.empty()) {
            b b = stack.peek();
            if (b != null) {
              if (b.t()) {
                stack.remove(b);
                continue;
              } 
              b.d();
            } 
          } 
          return;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
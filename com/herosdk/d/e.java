package com.herosdk.d;

import com.herosdk.bean.d;
import com.herosdk.error.ErrorUtils;
import java.util.List;

public class e {
  private static final String a = "frameLib.cspus";
  
  private static volatile e b;
  
  private static String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private e() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      this.d = stringBuilder.append(x.a().y()).append(o.b("oqQAP2uOT+8NhHwMoT7/dw==", o.b())).append(k.a().d()).append(o.b("dA3C12cQWy0s1pDUpEq1RQ==", o.b())).toString();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static e a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/e.b : Lcom/herosdk/d/e;
    //   3: ifnonnull -> 68
    //   6: ldc com/herosdk/d/e
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/e.b : Lcom/herosdk/d/e;
    //   12: ifnonnull -> 65
    //   15: new com/herosdk/d/e
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/e.b : Lcom/herosdk/d/e;
    //   27: new java/lang/StringBuilder
    //   30: astore_0
    //   31: aload_0
    //   32: invokespecial <init> : ()V
    //   35: aload_0
    //   36: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   39: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: getstatic java/io/File.separator : Ljava/lang/String;
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 'vtLFG4aTIQUi6VkqQrwe1w=='
    //   50: invokestatic b : ()Ljava/lang/String;
    //   53: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: putstatic com/herosdk/d/e.c : Ljava/lang/String;
    //   65: ldc com/herosdk/d/e
    //   67: monitorexit
    //   68: getstatic com/herosdk/d/e.b : Lcom/herosdk/d/e;
    //   71: areturn
    //   72: astore_0
    //   73: ldc ''
    //   75: putstatic com/herosdk/d/e.c : Ljava/lang/String;
    //   78: goto -> 65
    //   81: astore_0
    //   82: ldc com/herosdk/d/e
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	81	finally
    //   27	65	72	java/lang/Exception
    //   27	65	81	finally
    //   65	68	81	finally
    //   73	78	81	finally
    //   82	85	81	finally
  }
  
  public void a(d paramd) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.cspus'
    //   4: ldc 'ssci'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: invokestatic a : ()Lcom/herosdk/d/ba;
    //   13: astore_2
    //   14: new com/herosdk/d/f
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial <init> : (Lcom/herosdk/d/e;Lcom/herosdk/bean/d;)V
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual a : (Ljava/lang/Runnable;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	32	finally
  }
  
  public void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.cspus'
    //   4: ldc 'rsci'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: invokestatic a : ()Lcom/herosdk/d/x;
    //   13: invokevirtual i : ()Lcom/herosdk/bean/RoleInfo;
    //   16: invokevirtual getRoleId : ()Ljava/lang/String;
    //   19: astore_2
    //   20: aload_0
    //   21: invokevirtual c : ()Ljava/util/List;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull -> 106
    //   29: aload_3
    //   30: invokeinterface iterator : ()Ljava/util/Iterator;
    //   35: astore #4
    //   37: aload #4
    //   39: invokeinterface hasNext : ()Z
    //   44: ifeq -> 109
    //   47: aload #4
    //   49: invokeinterface next : ()Ljava/lang/Object;
    //   54: checkcast com/herosdk/bean/d
    //   57: astore #5
    //   59: aload #5
    //   61: invokevirtual a : ()Ljava/lang/String;
    //   64: aload_2
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifeq -> 37
    //   71: aload #5
    //   73: invokevirtual b : ()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual equals : (Ljava/lang/Object;)Z
    //   80: ifeq -> 37
    //   83: ldc 'frameLib.cspus'
    //   85: ldc 'rsci...r'
    //   87: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: aload #4
    //   93: invokeinterface remove : ()V
    //   98: goto -> 37
    //   101: astore_1
    //   102: aload_1
    //   103: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: aload_0
    //   110: aload_3
    //   111: invokevirtual a : (Ljava/util/List;)V
    //   114: goto -> 106
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	117	finally
    //   10	25	101	java/lang/Exception
    //   10	25	117	finally
    //   29	37	101	java/lang/Exception
    //   29	37	117	finally
    //   37	98	101	java/lang/Exception
    //   37	98	117	finally
    //   102	106	117	finally
    //   109	114	101	java/lang/Exception
    //   109	114	117	finally
  }
  
  public void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/herosdk/bean/d
    //   5: astore_3
    //   6: aload_3
    //   7: invokespecial <init> : ()V
    //   10: aload_3
    //   11: invokestatic a : ()Lcom/herosdk/d/x;
    //   14: invokevirtual i : ()Lcom/herosdk/bean/RoleInfo;
    //   17: invokevirtual getRoleId : ()Ljava/lang/String;
    //   20: invokevirtual a : (Ljava/lang/String;)V
    //   23: aload_3
    //   24: aload_1
    //   25: invokevirtual b : (Ljava/lang/String;)V
    //   28: aload_3
    //   29: aload_2
    //   30: invokevirtual c : (Ljava/lang/String;)V
    //   33: aload_3
    //   34: invokestatic a : ()J
    //   37: invokevirtual a : (J)V
    //   40: aload_0
    //   41: aload_3
    //   42: invokevirtual a : (Lcom/herosdk/bean/d;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	45	48	finally
  }
  
  public void a(List<d> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.cspus'
    //   4: ldc 'sscl'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_1
    //   11: ifnull -> 23
    //   14: aload_1
    //   15: invokeinterface size : ()I
    //   20: ifgt -> 47
    //   23: ldc 'frameLib.cspus'
    //   25: ldc 'sscl...return'
    //   27: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: invokestatic a : ()Lcom/herosdk/d/p;
    //   34: getstatic com/herosdk/d/e.c : Ljava/lang/String;
    //   37: aload_0
    //   38: getfield d : Ljava/lang/String;
    //   41: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: new org/json/JSONArray
    //   50: astore_2
    //   51: aload_2
    //   52: invokespecial <init> : ()V
    //   55: iconst_0
    //   56: istore_3
    //   57: iload_3
    //   58: aload_1
    //   59: invokeinterface size : ()I
    //   64: if_icmpge -> 159
    //   67: aload_1
    //   68: iload_3
    //   69: invokeinterface get : (I)Ljava/lang/Object;
    //   74: checkcast com/herosdk/bean/d
    //   77: astore #4
    //   79: new org/json/JSONObject
    //   82: astore #5
    //   84: aload #5
    //   86: invokespecial <init> : ()V
    //   89: aload #4
    //   91: ifnull -> 146
    //   94: aload #5
    //   96: ldc 'roleId'
    //   98: aload #4
    //   100: invokevirtual a : ()Ljava/lang/String;
    //   103: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload #5
    //   109: ldc 'sdkOrderId'
    //   111: aload #4
    //   113: invokevirtual b : ()Ljava/lang/String;
    //   116: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload #5
    //   122: ldc 'cpOrderId'
    //   124: aload #4
    //   126: invokevirtual c : ()Ljava/lang/String;
    //   129: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: pop
    //   133: aload #5
    //   135: ldc 'timestamp'
    //   137: aload #4
    //   139: invokevirtual d : ()J
    //   142: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload_2
    //   147: aload #5
    //   149: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   152: pop
    //   153: iinc #3, 1
    //   156: goto -> 57
    //   159: aload_2
    //   160: invokevirtual toString : ()Ljava/lang/String;
    //   163: astore_1
    //   164: aload_1
    //   165: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   168: ifne -> 44
    //   171: ldc 'frameLib.cspus'
    //   173: ldc 'sscl...d s'
    //   175: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: invokestatic a : ()Lcom/herosdk/d/p;
    //   182: getstatic com/herosdk/d/e.c : Ljava/lang/String;
    //   185: aload_0
    //   186: getfield d : Ljava/lang/String;
    //   189: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   192: invokestatic a : ()Lcom/herosdk/d/p;
    //   195: getstatic com/herosdk/d/e.c : Ljava/lang/String;
    //   198: aload_0
    //   199: getfield d : Ljava/lang/String;
    //   202: aload_1
    //   203: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   206: goto -> 44
    //   209: astore_1
    //   210: aload_1
    //   211: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   214: goto -> 44
    //   217: astore_1
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	209	java/lang/Exception
    //   2	10	217	finally
    //   14	23	209	java/lang/Exception
    //   14	23	217	finally
    //   23	44	209	java/lang/Exception
    //   23	44	217	finally
    //   47	55	209	java/lang/Exception
    //   47	55	217	finally
    //   57	89	209	java/lang/Exception
    //   57	89	217	finally
    //   94	146	209	java/lang/Exception
    //   94	146	217	finally
    //   146	153	209	java/lang/Exception
    //   146	153	217	finally
    //   159	206	209	java/lang/Exception
    //   159	206	217	finally
    //   210	214	217	finally
  }
  
  public String b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/herosdk/d/p;
    //   5: getstatic com/herosdk/d/e.c : Ljava/lang/String;
    //   8: aload_0
    //   9: getfield d : Ljava/lang/String;
    //   12: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
  }
  
  public List<d> c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.cspus'
    //   4: ldc 'gspcl'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: new java/util/ArrayList
    //   13: astore_1
    //   14: aload_1
    //   15: invokespecial <init> : ()V
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual b : ()Ljava/lang/String;
    //   23: putfield e : Ljava/lang/String;
    //   26: aload_0
    //   27: getfield e : Ljava/lang/String;
    //   30: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   33: ifeq -> 50
    //   36: ldc 'frameLib.cspus'
    //   38: ldc 'gspcl...return empty'
    //   40: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   43: pop
    //   44: aload_1
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: areturn
    //   50: new org/json/JSONArray
    //   53: astore_3
    //   54: aload_3
    //   55: aload_0
    //   56: getfield e : Ljava/lang/String;
    //   59: invokespecial <init> : (Ljava/lang/String;)V
    //   62: iconst_0
    //   63: istore #4
    //   65: aload_1
    //   66: astore_2
    //   67: iload #4
    //   69: aload_3
    //   70: invokevirtual length : ()I
    //   73: if_icmpge -> 46
    //   76: aload_3
    //   77: iload #4
    //   79: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   82: astore_2
    //   83: new com/herosdk/bean/d
    //   86: astore #5
    //   88: aload #5
    //   90: invokespecial <init> : ()V
    //   93: aload #5
    //   95: aload_2
    //   96: ldc 'roleId'
    //   98: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   101: invokevirtual a : (Ljava/lang/String;)V
    //   104: aload #5
    //   106: aload_2
    //   107: ldc 'sdkOrderId'
    //   109: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   112: invokevirtual b : (Ljava/lang/String;)V
    //   115: aload #5
    //   117: aload_2
    //   118: ldc 'cpOrderId'
    //   120: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual c : (Ljava/lang/String;)V
    //   126: aload #5
    //   128: aload_2
    //   129: ldc 'timestamp'
    //   131: invokevirtual optLong : (Ljava/lang/String;)J
    //   134: invokevirtual a : (J)V
    //   137: aload_1
    //   138: aload #5
    //   140: invokeinterface add : (Ljava/lang/Object;)Z
    //   145: pop
    //   146: iinc #4, 1
    //   149: goto -> 65
    //   152: astore_2
    //   153: aload_2
    //   154: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   157: aconst_null
    //   158: astore_2
    //   159: goto -> 46
    //   162: astore_2
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	152	java/lang/Exception
    //   2	44	162	finally
    //   50	62	152	java/lang/Exception
    //   50	62	162	finally
    //   67	146	152	java/lang/Exception
    //   67	146	162	finally
    //   153	157	162	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
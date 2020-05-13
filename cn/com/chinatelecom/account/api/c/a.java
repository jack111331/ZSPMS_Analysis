package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.b.b;
import cn.com.chinatelecom.account.api.b.c;
import cn.com.chinatelecom.account.api.b.e;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  private static final String a = a.class.getSimpleName();
  
  private static HashMap<String, String> b = new HashMap<String, String>();
  
  public static long a(Context paramContext) {
    return c.b(paramContext, "key_difference_time", 0L);
  }
  
  public static b a(Context paramContext, HttpURLConnection paramHttpURLConnection, boolean paramBoolean) {
    if (!paramBoolean)
      return null; 
    b b = new b();
    try {
      Map<String, List<String>> map = paramHttpURLConnection.getHeaderFields();
      List<String> list = map.get("p");
      if (list != null && list.size() > 0)
        b.b = a(paramContext, list.get(0)); 
      list = map.get("Set-Cookie");
      if (list != null && list.size() > 0) {
        byte b2 = 0;
        while (true) {
          if (b2 < list.size()) {
            String str = list.get(0);
            if (!TextUtils.isEmpty(str) && str.contains("gw_auth")) {
              b.a = b(str, "gw_auth");
            } else {
              b2++;
              continue;
            } 
          } 
          b b3 = b;
        } 
      } 
      b b1 = b;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return (b)throwable;
  }
  
  public static String a(Context paramContext, e parame, String paramString, Network paramNetwork, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 14
    //   4: aload_1
    //   5: getfield b : Ljava/lang/String;
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifeq -> 19
    //   14: ldc '{"result":"-8001","msg":"请求网络异常"}'
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: aload_1
    //   20: getfield a : I
    //   23: iconst_m1
    //   24: if_icmpne -> 35
    //   27: aload_1
    //   28: getfield b : Ljava/lang/String;
    //   31: astore_0
    //   32: goto -> 17
    //   35: new org/json/JSONObject
    //   38: astore #5
    //   40: aload #5
    //   42: aload_1
    //   43: getfield b : Ljava/lang/String;
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: aload #5
    //   51: ifnull -> 257
    //   54: aload #5
    //   56: ldc 'result'
    //   58: invokevirtual optInt : (Ljava/lang/String;)I
    //   61: istore #6
    //   63: aload #5
    //   65: ldc 'data'
    //   67: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   70: astore #7
    //   72: iload #6
    //   74: ifeq -> 85
    //   77: iload #6
    //   79: sipush #30002
    //   82: if_icmpne -> 306
    //   85: aload #7
    //   87: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   90: ifne -> 306
    //   93: aload #7
    //   95: aload_2
    //   96: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: astore #7
    //   101: aload #7
    //   103: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   106: istore #8
    //   108: iload #8
    //   110: ifne -> 257
    //   113: new org/json/JSONObject
    //   116: astore #9
    //   118: aload #9
    //   120: aload #7
    //   122: invokespecial <init> : (Ljava/lang/String;)V
    //   125: aload #5
    //   127: ldc 'data'
    //   129: aload #9
    //   131: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload #9
    //   137: ldc 'accessCode'
    //   139: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   142: aload_1
    //   143: getfield d : Ljava/lang/String;
    //   146: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   149: iload #6
    //   151: sipush #30002
    //   154: if_icmpne -> 297
    //   157: iload #4
    //   159: ifeq -> 297
    //   162: aload #5
    //   164: ldc 'data'
    //   166: invokevirtual opt : (Ljava/lang/String;)Ljava/lang/Object;
    //   169: checkcast org/json/JSONObject
    //   172: astore #7
    //   174: new java/util/ArrayList
    //   177: astore #5
    //   179: aload #5
    //   181: invokespecial <init> : ()V
    //   184: aload #7
    //   186: ldc 'urls'
    //   188: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   191: astore #7
    //   193: aload #7
    //   195: ifnull -> 265
    //   198: iconst_0
    //   199: istore #6
    //   201: iload #6
    //   203: aload #7
    //   205: invokevirtual length : ()I
    //   208: if_icmpge -> 265
    //   211: aload #5
    //   213: aload #7
    //   215: iload #6
    //   217: invokevirtual getString : (I)Ljava/lang/String;
    //   220: invokeinterface add : (Ljava/lang/Object;)Z
    //   225: pop
    //   226: iinc #6, 1
    //   229: goto -> 201
    //   232: astore #9
    //   234: aload #9
    //   236: invokevirtual printStackTrace : ()V
    //   239: aload #5
    //   241: ldc 'data'
    //   243: aload #7
    //   245: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   248: pop
    //   249: goto -> 149
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual printStackTrace : ()V
    //   257: aload_1
    //   258: getfield b : Ljava/lang/String;
    //   261: astore_0
    //   262: goto -> 17
    //   265: aload #5
    //   267: ifnull -> 280
    //   270: aload #5
    //   272: invokeinterface isEmpty : ()Z
    //   277: ifeq -> 285
    //   280: aconst_null
    //   281: astore_0
    //   282: goto -> 17
    //   285: aload_0
    //   286: aload #5
    //   288: aload_2
    //   289: aload_3
    //   290: invokestatic a : (Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Landroid/net/Network;)Ljava/lang/String;
    //   293: astore_0
    //   294: goto -> 17
    //   297: aload #5
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: astore_0
    //   303: goto -> 17
    //   306: iload #6
    //   308: sipush #-10009
    //   311: if_icmpeq -> 322
    //   314: iload #6
    //   316: sipush #-30001
    //   319: if_icmpne -> 257
    //   322: aload #5
    //   324: ldc 'timeStamp'
    //   326: ldc2_w -1
    //   329: invokevirtual optLong : (Ljava/lang/String;J)J
    //   332: lstore #10
    //   334: lload #10
    //   336: ldc2_w -1
    //   339: lcmp
    //   340: ifne -> 350
    //   343: aload_0
    //   344: invokestatic c : (Landroid/content/Context;)V
    //   347: goto -> 257
    //   350: aload_0
    //   351: lload #10
    //   353: invokestatic a : (Landroid/content/Context;J)V
    //   356: goto -> 257
    // Exception table:
    //   from	to	target	type
    //   35	49	252	java/lang/Exception
    //   54	72	252	java/lang/Exception
    //   85	108	252	java/lang/Exception
    //   113	149	232	org/json/JSONException
    //   113	149	252	java/lang/Exception
    //   162	193	252	java/lang/Exception
    //   201	226	252	java/lang/Exception
    //   234	249	252	java/lang/Exception
    //   270	280	252	java/lang/Exception
    //   285	294	252	java/lang/Exception
    //   297	303	252	java/lang/Exception
    //   322	334	252	java/lang/Exception
    //   343	347	252	java/lang/Exception
    //   350	356	252	java/lang/Exception
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    JSONObject jSONObject;
    int i;
    if (TextUtils.isEmpty(paramString1))
      return "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}"; 
    try {
      jSONObject = new JSONObject();
      this(paramString1);
      i = jSONObject.optInt("result");
      String str = jSONObject.optString("responseData");
      if (i == 0 && !TextUtils.isEmpty(str)) {
        String str1 = f.b(str, paramString2);
        boolean bool = TextUtils.isEmpty(str1);
        paramString2 = paramString1;
        if (!bool)
          try {
            JSONObject jSONObject1 = new JSONObject();
            this(str1);
            jSONObject.put("responseData", jSONObject1);
            String str2 = jSONObject.toString();
          } catch (JSONException jSONException) {} 
        return (String)jSONException;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramString1;
    } 
    paramString2 = paramString1;
    if (i == -30001) {
      long l = jSONObject.optLong("timeStamp", -1L);
      if (l == -1L) {
        c((Context)exception);
        return paramString1;
      } 
      a((Context)exception, l);
      paramString2 = paramString1;
    } 
    return paramString2;
  }
  
  private static String a(Context paramContext, List<String> paramList, String paramString, Network paramNetwork) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload #4
    //   5: aload_1
    //   6: invokeinterface size : ()I
    //   11: if_icmpge -> 120
    //   14: aload_1
    //   15: iload #4
    //   17: invokeinterface get : (I)Ljava/lang/Object;
    //   22: checkcast java/lang/String
    //   25: astore #5
    //   27: aload #5
    //   29: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   32: ifeq -> 41
    //   35: iinc #4, 1
    //   38: goto -> 3
    //   41: getstatic android/os/Build$VERSION.SDK_INT : I
    //   44: bipush #21
    //   46: if_icmpge -> 55
    //   49: aload_0
    //   50: aload #5
    //   52: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   55: aload_0
    //   56: aload_0
    //   57: aload #5
    //   59: aload_3
    //   60: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Landroid/net/Network;)Lcn/com/chinatelecom/account/api/b/e;
    //   63: aload_2
    //   64: aload_3
    //   65: iconst_0
    //   66: invokestatic a : (Landroid/content/Context;Lcn/com/chinatelecom/account/api/b/e;Ljava/lang/String;Landroid/net/Network;Z)Ljava/lang/String;
    //   69: astore #5
    //   71: new org/json/JSONObject
    //   74: astore #6
    //   76: aload #6
    //   78: aload #5
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: aload #6
    //   85: ldc 'result'
    //   87: invokevirtual optInt : (Ljava/lang/String;)I
    //   90: istore #7
    //   92: iload #7
    //   94: ifne -> 35
    //   97: aload #5
    //   99: areturn
    //   100: astore #5
    //   102: aload #5
    //   104: invokevirtual printStackTrace : ()V
    //   107: goto -> 35
    //   110: astore #5
    //   112: aload #5
    //   114: invokevirtual printStackTrace : ()V
    //   117: goto -> 35
    //   120: sipush #-8001
    //   123: ldc '请求网络异常- redirect 30002 '
    //   125: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   128: astore #5
    //   130: goto -> 97
    // Exception table:
    //   from	to	target	type
    //   14	35	110	java/lang/Throwable
    //   41	55	110	java/lang/Throwable
    //   55	71	110	java/lang/Throwable
    //   71	92	100	java/lang/Exception
    //   71	92	110	java/lang/Throwable
    //   102	107	110	java/lang/Throwable
  }
  
  public static String a(String paramString) {
    return (!TextUtils.isEmpty(paramString) && b.containsKey(paramString)) ? b.get(paramString) : "";
  }
  
  private static void a(Context paramContext, int paramInt) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'key_p_a_p'
    //   6: iload_1
    //   7: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)V
    //   10: ldc cn/com/chinatelecom/account/api/c/a
    //   12: monitorexit
    //   13: return
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual printStackTrace : ()V
    //   19: goto -> 10
    //   22: astore_0
    //   23: ldc cn/com/chinatelecom/account/api/c/a
    //   25: monitorexit
    //   26: aload_0
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	14	java/lang/Exception
    //   3	10	22	finally
    //   15	19	22	finally
  }
  
  private static void a(Context paramContext, long paramLong) {
    if (paramLong > 0L)
      c.a(paramContext, "key_difference_time", paramLong - System.currentTimeMillis()); 
  }
  
  public static void a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      b.put(paramString1, paramString2); 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc cn/com/chinatelecom/account/api/c/a
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnonnull -> 16
    //   9: iload_2
    //   10: istore_3
    //   11: ldc cn/com/chinatelecom/account/api/c/a
    //   13: monitorexit
    //   14: iload_3
    //   15: ireturn
    //   16: ldc 'http'
    //   18: aload_1
    //   19: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   22: invokevirtual equals : (Ljava/lang/Object;)Z
    //   25: ifne -> 42
    //   28: iload_2
    //   29: istore_3
    //   30: ldc 'https'
    //   32: aload_1
    //   33: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   36: invokevirtual equals : (Ljava/lang/Object;)Z
    //   39: ifeq -> 11
    //   42: aload_0
    //   43: ldc 'key_p_a_p'
    //   45: iconst_0
    //   46: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)I
    //   49: iconst_1
    //   50: if_icmpne -> 97
    //   53: ldc 'https'
    //   55: astore #4
    //   57: iload_2
    //   58: istore_3
    //   59: aload #4
    //   61: aload_1
    //   62: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifne -> 11
    //   71: aload_1
    //   72: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   75: ldc 'https'
    //   77: invokevirtual equals : (Ljava/lang/Object;)Z
    //   80: ifeq -> 104
    //   83: iconst_1
    //   84: istore #5
    //   86: aload_0
    //   87: iload #5
    //   89: invokestatic a : (Landroid/content/Context;I)V
    //   92: iconst_1
    //   93: istore_3
    //   94: goto -> 11
    //   97: ldc 'http'
    //   99: astore #4
    //   101: goto -> 57
    //   104: iconst_0
    //   105: istore #5
    //   107: goto -> 86
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual printStackTrace : ()V
    //   115: iload_2
    //   116: istore_3
    //   117: goto -> 11
    //   120: astore_0
    //   121: ldc cn/com/chinatelecom/account/api/c/a
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    // Exception table:
    //   from	to	target	type
    //   16	28	110	java/lang/Exception
    //   16	28	120	finally
    //   30	42	110	java/lang/Exception
    //   30	42	120	finally
    //   42	53	110	java/lang/Exception
    //   42	53	120	finally
    //   59	83	110	java/lang/Exception
    //   59	83	120	finally
    //   86	92	110	java/lang/Exception
    //   86	92	120	finally
    //   111	115	120	finally
  }
  
  private static String b(String paramString1, String paramString2) {
    String str1;
    String str2 = "";
    try {
      String[] arrayOfString = paramString1.split(";");
      for (byte b = 0;; b++) {
        paramString1 = str2;
        if (b < arrayOfString.length) {
          if (arrayOfString[b].contains(paramString2))
            return arrayOfString[b].split("=")[1]; 
        } else {
          return paramString1;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = str2;
    } 
    return str1;
  }
  
  public static boolean b(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc cn/com/chinatelecom/account/api/c/a
    //   4: monitorenter
    //   5: aload_0
    //   6: ldc 'key_p_a_p'
    //   8: iconst_0
    //   9: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)I
    //   12: istore_2
    //   13: iload_2
    //   14: iconst_1
    //   15: if_icmpne -> 28
    //   18: ldc cn/com/chinatelecom/account/api/c/a
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual printStackTrace : ()V
    //   28: iconst_1
    //   29: istore_1
    //   30: goto -> 18
    //   33: astore_0
    //   34: ldc cn/com/chinatelecom/account/api/c/a
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   5	13	23	java/lang/Exception
    //   5	13	33	finally
    //   24	28	33	finally
  }
  
  private static void c(Context paramContext) {
    JSONObject jSONObject = null;
    String str = (c.a(paramContext, "https://open.e.189.cn/openapi/special/getTimeStamp.do", "", null, null, false, 0, "reqTimestamp")).b;
    if (!TextUtils.isEmpty(str)) {
      try {
        JSONObject jSONObject1 = new JSONObject();
        this(str);
        jSONObject = jSONObject1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      if (jSONObject != null)
        a(paramContext, jSONObject.optLong("msg", -1L)); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
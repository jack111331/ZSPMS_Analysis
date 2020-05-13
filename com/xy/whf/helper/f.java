package com.xy.whf.helper;

import android.content.Context;
import com.xy.whf.entity.RandomParam;
import java.util.List;
import org.json.JSONObject;

public class f {
  public static JSONObject a(Context paramContext, List<RandomParam> paramList) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_1
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 239
    //   24: aload_3
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast com/xy/whf/entity/RandomParam
    //   33: astore #4
    //   35: aload #4
    //   37: getfield packageClassName : Ljava/lang/String;
    //   40: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   43: astore #5
    //   45: aload #4
    //   47: getfield invokeType : I
    //   50: istore #6
    //   52: iload #6
    //   54: ifeq -> 63
    //   57: iload #6
    //   59: iconst_1
    //   60: if_icmpne -> 187
    //   63: aload #5
    //   65: aload #4
    //   67: getfield methodName : Ljava/lang/String;
    //   70: aload #4
    //   72: invokevirtual getClasss : ()[Ljava/lang/Class;
    //   75: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   78: astore #7
    //   80: aload #4
    //   82: invokevirtual isNeedContext : ()Z
    //   85: ifeq -> 132
    //   88: aload_0
    //   89: astore_1
    //   90: aload #4
    //   92: aload_1
    //   93: invokevirtual getValues : (Landroid/content/Context;)[Ljava/lang/Object;
    //   96: astore_1
    //   97: iload #6
    //   99: ifne -> 137
    //   102: aload #7
    //   104: aconst_null
    //   105: aload_1
    //   106: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   109: astore_1
    //   110: aload_2
    //   111: aload #4
    //   113: getfield key : Ljava/lang/String;
    //   116: aload_1
    //   117: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: goto -> 15
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual printStackTrace : ()V
    //   129: goto -> 15
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -> 90
    //   137: aload #5
    //   139: invokevirtual newInstance : ()Ljava/lang/Object;
    //   142: instanceof android/telephony/TelephonyManager
    //   145: ifeq -> 172
    //   148: aload_0
    //   149: ldc 'android.permission.READ_PHONE_STATE'
    //   151: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   154: ifeq -> 241
    //   157: aload #7
    //   159: aload #5
    //   161: invokevirtual newInstance : ()Ljava/lang/Object;
    //   164: aload_1
    //   165: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   168: astore_1
    //   169: goto -> 110
    //   172: aload #7
    //   174: aload #5
    //   176: invokevirtual newInstance : ()Ljava/lang/Object;
    //   179: aload_1
    //   180: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   183: astore_1
    //   184: goto -> 110
    //   187: iload #6
    //   189: iconst_2
    //   190: if_icmpne -> 211
    //   193: aload #5
    //   195: aload #4
    //   197: getfield fieldName : Ljava/lang/String;
    //   200: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   203: aload_0
    //   204: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   207: astore_1
    //   208: goto -> 110
    //   211: iload #6
    //   213: iconst_3
    //   214: if_icmpne -> 241
    //   217: aload #5
    //   219: aload #4
    //   221: getfield fieldName : Ljava/lang/String;
    //   224: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   227: aload #5
    //   229: invokevirtual newInstance : ()Ljava/lang/Object;
    //   232: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   235: astore_1
    //   236: goto -> 110
    //   239: aload_2
    //   240: areturn
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   35	52	124	java/lang/Exception
    //   63	88	124	java/lang/Exception
    //   90	97	124	java/lang/Exception
    //   102	110	124	java/lang/Exception
    //   110	121	124	java/lang/Exception
    //   137	169	124	java/lang/Exception
    //   172	184	124	java/lang/Exception
    //   193	208	124	java/lang/Exception
    //   217	236	124	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
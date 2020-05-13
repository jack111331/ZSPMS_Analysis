package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;

public final class a {
  public static final class a {
    public static Object a(int param1Int, String param1String) {
      // Byte code:
      //   0: aload_1
      //   1: astore_2
      //   2: iload_0
      //   3: tableswitch default -> 40, 1 -> 51, 2 -> 59, 3 -> 49, 4 -> 67, 5 -> 75, 6 -> 83
      //   40: ldc 'MicroMsg.SDK.PluginProvider.Resolver'
      //   42: ldc 'unknown type'
      //   44: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   47: aconst_null
      //   48: astore_2
      //   49: aload_2
      //   50: areturn
      //   51: aload_1
      //   52: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
      //   55: astore_2
      //   56: goto -> 49
      //   59: aload_1
      //   60: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
      //   63: astore_2
      //   64: goto -> 49
      //   67: aload_1
      //   68: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
      //   71: astore_2
      //   72: goto -> 49
      //   75: aload_1
      //   76: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
      //   79: astore_2
      //   80: goto -> 49
      //   83: aload_1
      //   84: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
      //   87: astore_2
      //   88: goto -> 49
      //   91: astore_1
      //   92: aload_1
      //   93: invokevirtual printStackTrace : ()V
      //   96: goto -> 47
      // Exception table:
      //   from	to	target	type
      //   40	47	91	java/lang/Exception
      //   51	56	91	java/lang/Exception
      //   59	64	91	java/lang/Exception
      //   67	72	91	java/lang/Exception
      //   75	80	91	java/lang/Exception
      //   83	88	91	java/lang/Exception
    }
  }
  
  public static final class b implements BaseColumns {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
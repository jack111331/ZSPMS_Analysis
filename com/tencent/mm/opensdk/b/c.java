package com.tencent.mm.opensdk.b;

import android.net.Uri;
import android.provider.BaseColumns;

public final class c {
  public static final class a {
    public static Object a(int param1Int, String param1String) {
      // Byte code:
      //   0: iload_0
      //   1: tableswitch default -> 40, 1 -> 65, 2 -> 60, 3 -> 58, 4 -> 53, 5 -> 48, 6 -> 43
      //   40: goto -> 70
      //   43: aload_1
      //   44: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
      //   47: areturn
      //   48: aload_1
      //   49: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
      //   52: areturn
      //   53: aload_1
      //   54: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
      //   57: areturn
      //   58: aload_1
      //   59: areturn
      //   60: aload_1
      //   61: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
      //   64: areturn
      //   65: aload_1
      //   66: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
      //   69: areturn
      //   70: ldc 'MicroMsg.SDK.PluginProvider.Resolver'
      //   72: ldc 'unknown type'
      //   74: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   77: pop
      //   78: goto -> 111
      //   81: astore_1
      //   82: new java/lang/StringBuilder
      //   85: dup
      //   86: ldc 'resolveObj exception:'
      //   88: invokespecial <init> : (Ljava/lang/String;)V
      //   91: astore_2
      //   92: aload_2
      //   93: aload_1
      //   94: invokevirtual getMessage : ()Ljava/lang/String;
      //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: ldc 'MicroMsg.SDK.PluginProvider.Resolver'
      //   103: aload_2
      //   104: invokevirtual toString : ()Ljava/lang/String;
      //   107: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   110: pop
      //   111: aconst_null
      //   112: areturn
      // Exception table:
      //   from	to	target	type
      //   43	48	81	java/lang/Exception
      //   48	53	81	java/lang/Exception
      //   53	58	81	java/lang/Exception
      //   60	65	81	java/lang/Exception
      //   65	70	81	java/lang/Exception
      //   70	78	81	java/lang/Exception
    }
  }
  
  public static final class b implements BaseColumns {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
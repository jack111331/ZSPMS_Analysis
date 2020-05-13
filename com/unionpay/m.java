package com.unionpay;

final class m implements ac {
  m(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ad paramad) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: astore_3
    //   4: aload_3
    //   5: aload_1
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: ldc ''
    //   11: astore #4
    //   13: aload_3
    //   14: ldc 'url'
    //   16: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast java/lang/String
    //   22: astore_1
    //   23: aload_3
    //   24: ldc 'title'
    //   26: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast java/lang/String
    //   32: astore_3
    //   33: new android/os/Bundle
    //   36: astore #4
    //   38: aload #4
    //   40: invokespecial <init> : ()V
    //   43: aload #4
    //   45: ldc 'waptype'
    //   47: ldc 'new_page'
    //   49: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload #4
    //   54: ldc 'wapurl'
    //   56: aload_1
    //   57: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload #4
    //   62: ldc 'waptitle'
    //   64: aload_3
    //   65: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   68: new android/content/Intent
    //   71: astore_1
    //   72: aload_1
    //   73: invokespecial <init> : ()V
    //   76: aload_1
    //   77: aload #4
    //   79: invokevirtual putExtras : (Landroid/os/Bundle;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_1
    //   84: aload_0
    //   85: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   88: ldc com/unionpay/UPPayWapActivity
    //   90: invokevirtual setClass : (Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_0
    //   95: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   98: aload_1
    //   99: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   102: aload_2
    //   103: ifnull -> 125
    //   106: aload_0
    //   107: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   110: astore_1
    //   111: aload_2
    //   112: ldc '0'
    //   114: ldc 'success'
    //   116: aconst_null
    //   117: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: invokeinterface a : (Ljava/lang/String;)V
    //   125: return
    //   126: astore_3
    //   127: aload #4
    //   129: astore_1
    //   130: aload_2
    //   131: ifnull -> 156
    //   134: aload_0
    //   135: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   138: astore #4
    //   140: aload_2
    //   141: ldc '1'
    //   143: aload_3
    //   144: invokevirtual getMessage : ()Ljava/lang/String;
    //   147: aconst_null
    //   148: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   151: invokeinterface a : (Ljava/lang/String;)V
    //   156: ldc ''
    //   158: astore_3
    //   159: goto -> 33
    //   162: astore_3
    //   163: aload_2
    //   164: ifnull -> 125
    //   167: aload_0
    //   168: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   171: astore_1
    //   172: aload_2
    //   173: ldc '1'
    //   175: aload_3
    //   176: invokevirtual getMessage : ()Ljava/lang/String;
    //   179: aconst_null
    //   180: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   183: invokeinterface a : (Ljava/lang/String;)V
    //   188: goto -> 125
    //   191: astore_3
    //   192: goto -> 130
    // Exception table:
    //   from	to	target	type
    //   0	9	162	java/lang/Exception
    //   13	23	126	java/lang/Exception
    //   23	33	191	java/lang/Exception
    //   33	102	162	java/lang/Exception
    //   106	125	162	java/lang/Exception
    //   134	156	162	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
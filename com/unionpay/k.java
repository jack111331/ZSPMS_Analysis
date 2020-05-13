package com.unionpay;

final class k implements ac {
  k(UPPayWapActivity paramUPPayWapActivity) {}
  
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
    //   14: ldc 'resultCode'
    //   16: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast java/lang/String
    //   22: astore_1
    //   23: aload_3
    //   24: ldc 'resultData'
    //   26: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast java/lang/String
    //   32: astore_3
    //   33: aload_0
    //   34: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   37: astore #5
    //   39: aload_0
    //   40: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   43: astore #4
    //   45: aload #5
    //   47: aload_1
    //   48: aload_3
    //   49: invokestatic a : (Lcom/unionpay/UPPayWapActivity;Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_2
    //   53: ifnull -> 75
    //   56: aload_0
    //   57: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   60: astore_1
    //   61: aload_2
    //   62: ldc '0'
    //   64: ldc 'success'
    //   66: aconst_null
    //   67: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: invokeinterface a : (Ljava/lang/String;)V
    //   75: return
    //   76: astore_3
    //   77: aload #4
    //   79: astore_1
    //   80: aload_2
    //   81: ifnull -> 106
    //   84: aload_0
    //   85: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   88: astore #4
    //   90: aload_2
    //   91: ldc '1'
    //   93: aload_3
    //   94: invokevirtual getMessage : ()Ljava/lang/String;
    //   97: aconst_null
    //   98: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: invokeinterface a : (Ljava/lang/String;)V
    //   106: ldc ''
    //   108: astore_3
    //   109: goto -> 33
    //   112: astore_3
    //   113: aload_2
    //   114: ifnull -> 75
    //   117: aload_0
    //   118: getfield a : Lcom/unionpay/UPPayWapActivity;
    //   121: astore_1
    //   122: aload_2
    //   123: ldc '1'
    //   125: aload_3
    //   126: invokevirtual getMessage : ()Ljava/lang/String;
    //   129: aconst_null
    //   130: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: invokeinterface a : (Ljava/lang/String;)V
    //   138: goto -> 75
    //   141: astore_3
    //   142: goto -> 80
    // Exception table:
    //   from	to	target	type
    //   0	9	112	java/lang/Exception
    //   13	23	76	java/lang/Exception
    //   23	33	141	java/lang/Exception
    //   33	52	112	java/lang/Exception
    //   56	75	112	java/lang/Exception
    //   84	106	112	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
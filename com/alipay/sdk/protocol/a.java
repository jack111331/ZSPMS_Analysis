package com.alipay.sdk.protocol;

public enum a {
  a("none"),
  b("js://wappay"),
  c("js://update");
  
  private String d;
  
  a(String paramString1) {
    this.d = paramString1;
  }
  
  public static a a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 13
    //   7: getstatic com/alipay/sdk/protocol/a.a : Lcom/alipay/sdk/protocol/a;
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: getstatic com/alipay/sdk/protocol/a.a : Lcom/alipay/sdk/protocol/a;
    //   16: astore_2
    //   17: invokestatic values : ()[Lcom/alipay/sdk/protocol/a;
    //   20: astore_3
    //   21: aload_3
    //   22: arraylength
    //   23: istore #4
    //   25: iconst_0
    //   26: istore #5
    //   28: iload #5
    //   30: iload #4
    //   32: if_icmpge -> 62
    //   35: aload_3
    //   36: iload #5
    //   38: aaload
    //   39: astore #6
    //   41: aload #6
    //   43: astore_1
    //   44: aload_0
    //   45: aload #6
    //   47: getfield d : Ljava/lang/String;
    //   50: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   53: ifne -> 11
    //   56: iinc #5, 1
    //   59: goto -> 28
    //   62: aload_2
    //   63: astore_1
    //   64: goto -> 11
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\protocol\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
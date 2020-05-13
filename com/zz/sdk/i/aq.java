package com.zz.sdk.i;

public enum aq {
  a,
  b,
  c(Integer.valueOf(0)),
  d(Integer.valueOf(1)),
  e(Integer.valueOf(19)),
  f(Integer.valueOf(20)),
  g(Integer.valueOf(21));
  
  private String h;
  
  private int i;
  
  aq(Integer paramInteger) {
    if (paramInteger == null) {
      this.h = null;
      this.i = Integer.MIN_VALUE;
      return;
    } 
    this.i = paramInteger.intValue();
    this.h = paramInteger.toString();
  }
  
  public static aq a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 61
    //   4: aload_0
    //   5: invokevirtual length : ()I
    //   8: ifle -> 61
    //   11: invokestatic values : ()[Lcom/zz/sdk/i/aq;
    //   14: astore_1
    //   15: aload_1
    //   16: arraylength
    //   17: istore_2
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: iload_2
    //   22: if_icmpge -> 68
    //   25: aload_1
    //   26: iload_3
    //   27: aaload
    //   28: astore #4
    //   30: aload #4
    //   32: getfield h : Ljava/lang/String;
    //   35: ifnull -> 55
    //   38: aload #4
    //   40: getfield h : Ljava/lang/String;
    //   43: aload_0
    //   44: invokevirtual equals : (Ljava/lang/Object;)Z
    //   47: ifeq -> 55
    //   50: aload #4
    //   52: astore_0
    //   53: aload_0
    //   54: areturn
    //   55: iinc #3, 1
    //   58: goto -> 20
    //   61: getstatic com/zz/sdk/i/aq.b : Lcom/zz/sdk/i/aq;
    //   64: astore_0
    //   65: goto -> 53
    //   68: getstatic com/zz/sdk/i/aq.a : Lcom/zz/sdk/i/aq;
    //   71: astore_0
    //   72: goto -> 53
  }
  
  public String a() {
    return this.h;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
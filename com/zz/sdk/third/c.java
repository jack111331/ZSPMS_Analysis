package com.zz.sdk.third;

public enum c {
  a(2, "qq", true, f.class, "com.tencent.tauth.Tencent"),
  b(3, "wechat", true, k.class, "com.tencent.mm.sdk.openapi.IWXAPI"),
  c(4, "sina", true, h.class, "com.sina.weibo.sdk.auth.sso.SsoHandler");
  
  private final String d;
  
  private final int e;
  
  private final Class f;
  
  private final String g;
  
  private final boolean h;
  
  c(int paramInt1, String paramString1, boolean paramBoolean, Class paramClass, String paramString2) {
    this.e = paramInt1;
    this.h = paramBoolean;
    this.g = paramString2;
    this.f = paramClass;
    this.d = paramString1;
  }
  
  public static c a(int paramInt) {
    // Byte code:
    //   0: invokestatic values : ()[Lcom/zz/sdk/third/c;
    //   3: astore_1
    //   4: aload_1
    //   5: arraylength
    //   6: istore_2
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: iload_2
    //   11: if_icmpge -> 37
    //   14: aload_1
    //   15: iload_3
    //   16: aaload
    //   17: astore #4
    //   19: aload #4
    //   21: getfield e : I
    //   24: iload_0
    //   25: if_icmpne -> 31
    //   28: aload #4
    //   30: areturn
    //   31: iinc #3, 1
    //   34: goto -> 9
    //   37: aconst_null
    //   38: astore #4
    //   40: goto -> 28
  }
  
  public static c a(Class paramClass) {
    // Byte code:
    //   0: invokestatic values : ()[Lcom/zz/sdk/third/c;
    //   3: astore_1
    //   4: aload_1
    //   5: arraylength
    //   6: istore_2
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: iload_2
    //   11: if_icmpge -> 39
    //   14: aload_1
    //   15: iload_3
    //   16: aaload
    //   17: astore #4
    //   19: aload #4
    //   21: getfield f : Ljava/lang/Class;
    //   24: aload_0
    //   25: if_acmpne -> 33
    //   28: aload #4
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: iinc #3, 1
    //   36: goto -> 9
    //   39: aconst_null
    //   40: astore_0
    //   41: goto -> 31
  }
  
  public static c a(String paramString) {
    // Byte code:
    //   0: invokestatic values : ()[Lcom/zz/sdk/third/c;
    //   3: astore_1
    //   4: aload_1
    //   5: arraylength
    //   6: istore_2
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: iload_2
    //   11: if_icmpge -> 42
    //   14: aload_1
    //   15: iload_3
    //   16: aaload
    //   17: astore #4
    //   19: aload #4
    //   21: getfield d : Ljava/lang/String;
    //   24: aload_0
    //   25: invokevirtual equals : (Ljava/lang/Object;)Z
    //   28: ifeq -> 36
    //   31: aload #4
    //   33: astore_0
    //   34: aload_0
    //   35: areturn
    //   36: iinc #3, 1
    //   39: goto -> 9
    //   42: aconst_null
    //   43: astore_0
    //   44: goto -> 34
  }
  
  public String a() {
    return this.d;
  }
  
  public boolean b() {
    return (c() != null);
  }
  
  public Class c() {
    Class clazz = null;
    if (!this.h)
      return clazz; 
    if (this.g != null && this.g.length() > 0) {
      try {
        Class.forName(this.g);
        clazz = this.f;
      } catch (Exception exception) {}
      return clazz;
    } 
    clazz = this.f;
  }
  
  public int d() {
    return this.e;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
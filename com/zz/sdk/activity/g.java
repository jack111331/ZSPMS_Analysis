package com.zz.sdk.activity;

import com.zz.sdk.ParamChain;
import com.zz.sdk.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class g implements ParamChain {
  static final boolean a = false;
  
  private static final ParamChain b = new g();
  
  private HashMap c;
  
  private HashMap d;
  
  private ParamChain e;
  
  private String f;
  
  private int g;
  
  public g() {
    this(null);
  }
  
  public g(ParamChain paramParamChain) {
    this(paramParamChain, null);
  }
  
  public g(ParamChain paramParamChain, HashMap<?, ?> paramHashMap) {
    boolean bool;
    this.e = paramParamChain;
    if (paramParamChain != null) {
      bool = paramParamChain.getLevel() + 1;
    } else {
      bool = false;
    } 
    this.g = bool;
    if (paramHashMap == null) {
      this.c = new HashMap<Object, Object>(8);
    } else {
      this.c = new HashMap<Object, Object>(paramHashMap);
    } 
    this.d = new HashMap<Object, Object>();
  }
  
  public static ParamChain a() {
    return b;
  }
  
  public static ParamChain a(ParamChain paramParamChain) {
    g g1 = new g();
    Stack<ParamChain> stack = new Stack();
    while (paramParamChain != null) {
      stack.push(paramParamChain);
      paramParamChain = paramParamChain.getParent();
    } 
    while (!stack.isEmpty())
      ((ParamChain)stack.pop()).dumpOwn(g1, true); 
    return g1;
  }
  
  public static ParamChain a(ParamChain paramParamChain, String... paramVarArgs) {
    g g1 = new g();
    if (paramParamChain != null) {
      byte b = 0;
      int i = paramVarArgs.length;
      while (b < i) {
        String str = paramVarArgs[b];
        ParamChain paramChain = paramParamChain.containsKey(str);
        if (paramChain != null) {
          Object object = paramChain.getOwned(str);
          h h = paramChain.containsKeyOwn(str);
          if (str != null && object != null)
            g1.add(str, object, h); 
        } 
        b++;
      } 
    } 
    return g1;
  }
  
  private void a(ParamChain paramParamChain, boolean paramBoolean, HashMap paramHashMap, h paramh) {
    for (Map.Entry entry : paramHashMap.entrySet()) {
      String str = (String)entry.getKey();
      h h1 = paramParamChain.containsKeyOwn(str);
      if (paramBoolean || h1 == null) {
        if (h1 != null)
          paramParamChain.remove(str); 
        paramParamChain.add(str, entry.getValue(), paramh);
      } 
    } 
  }
  
  public boolean add(String paramString, Object paramObject) {
    return add(paramString, paramObject, h.a);
  }
  
  public boolean add(String paramString, Object paramObject, h paramh) {
    boolean bool = true;
    if (paramh == h.b) {
      if (this.d.put(paramString, paramObject) != paramObject)
        bool = false; 
      return bool;
    } 
    if (this.c.put(paramString, paramObject) != paramObject)
      bool = false; 
    return bool;
  }
  
  public void autoRelease() {
    this.d.clear();
  }
  
  public ParamChain containsKey(String paramString) {
    g g1 = this;
    while (true) {
      if (g1.containsKeyOwn(paramString) == null) {
        ParamChain paramChain2 = g1.getParent();
        ParamChain paramChain1 = paramChain2;
        if (paramChain2 == null)
          return null; 
        continue;
      } 
      return g1;
    } 
  }
  
  public h containsKeyOwn(String paramString) {
    return this.c.containsKey(paramString) ? h.a : (this.d.containsKey(paramString) ? h.b : null);
  }
  
  public ParamChain containsKeyReverse(String paramString) {
    // Byte code:
    //   0: new java/util/Stack
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_0
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull -> 30
    //   14: aload_2
    //   15: aload_3
    //   16: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_3
    //   21: invokeinterface getParent : ()Lcom/zz/sdk/ParamChain;
    //   26: astore_3
    //   27: goto -> 10
    //   30: aload_2
    //   31: invokevirtual isEmpty : ()Z
    //   34: ifne -> 59
    //   37: aload_2
    //   38: invokevirtual pop : ()Ljava/lang/Object;
    //   41: checkcast com/zz/sdk/ParamChain
    //   44: astore_3
    //   45: aload_3
    //   46: aload_1
    //   47: invokeinterface containsKeyOwn : (Ljava/lang/String;)Lcom/zz/sdk/h;
    //   52: ifnull -> 30
    //   55: aload_3
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: aconst_null
    //   60: astore_1
    //   61: goto -> 57
  }
  
  public void dumpOwn(ParamChain paramParamChain, boolean paramBoolean) {
    a(paramParamChain, paramBoolean, this.c, h.a);
    a(paramParamChain, paramBoolean, this.d, h.b);
  }
  
  public ParamChain generateUnion() {
    return a(this);
  }
  
  public ParamChain generateUnion(String... paramVarArgs) {
    return a(this, paramVarArgs);
  }
  
  public Object get(Enum paramEnum) {
    return get(paramEnum.toString());
  }
  
  public Object get(String paramString) {
    g g1 = this;
    while (true) {
      Object object2 = g1.getOwned(paramString);
      if (object2 != null)
        return object2; 
      object2 = g1.getParent();
      Object object1 = object2;
      if (object2 == null)
        return null; 
    } 
  }
  
  public Object get(String paramString, Class paramClass) {
    Object object = get(paramString);
    if (object == null || !paramClass.isInstance(object))
      object = null; 
    return object;
  }
  
  public String getAliasName() {
    return this.f;
  }
  
  public int getLevel() {
    return this.g;
  }
  
  public Object getOwned(String paramString) {
    return this.c.containsKey(paramString) ? this.c.get(paramString) : this.d.get(paramString);
  }
  
  public Object getOwned(String paramString, Class paramClass) {
    Object object = getOwned(paramString);
    if (object == null || !paramClass.isInstance(object))
      object = null; 
    return object;
  }
  
  public ParamChain getParent() {
    return this.e;
  }
  
  public ParamChain getParent(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 41
    //   6: aload_0
    //   7: astore_3
    //   8: aload_1
    //   9: aload_3
    //   10: invokeinterface getAliasName : ()Ljava/lang/String;
    //   15: invokevirtual equals : (Ljava/lang/Object;)Z
    //   18: ifeq -> 23
    //   21: aload_3
    //   22: areturn
    //   23: aload_3
    //   24: invokeinterface getParent : ()Lcom/zz/sdk/ParamChain;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_3
    //   32: aload_2
    //   33: ifnonnull -> 8
    //   36: aconst_null
    //   37: astore_3
    //   38: goto -> 21
    //   41: aload_2
    //   42: astore_3
    //   43: aload_1
    //   44: aload_2
    //   45: invokeinterface getAliasName : ()Ljava/lang/String;
    //   50: if_acmpeq -> 21
    //   53: aload_2
    //   54: invokeinterface getParent : ()Lcom/zz/sdk/ParamChain;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: ifnonnull -> 41
    //   66: goto -> 36
  }
  
  public ParamChain getRoot() {
    ParamChain paramChain = this;
    while (paramChain.getParent() != null)
      paramChain = paramChain.getParent(); 
    return paramChain;
  }
  
  public ParamChain grow() {
    return new g(this);
  }
  
  public ParamChain grow(String paramString) {
    g g1 = new g(this);
    g1.setAliasName(paramString);
    return g1;
  }
  
  public ParamChain grow(HashMap paramHashMap) {
    return new g(this, paramHashMap);
  }
  
  public Object remove(String paramString) {
    return this.c.containsKey(paramString) ? this.c.remove(paramString) : this.d.remove(paramString);
  }
  
  public void reset() {
    this.c.clear();
    this.d.clear();
  }
  
  public boolean setAliasName(String paramString) {
    if (this.f != null)
      return false; 
    this.f = paramString;
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\activity\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
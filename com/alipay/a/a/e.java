package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.a;
import org.json.alipay.b;

public final class e {
  static List<i> a;
  
  static {
    ArrayList<i> arrayList = new ArrayList();
    a = arrayList;
    arrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new k());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }
  
  public static final <T> T a(Object paramObject, Type paramType) {
    // Byte code:
    //   0: getstatic com/alipay/a/a/e.a : Ljava/util/List;
    //   3: invokeinterface iterator : ()Ljava/util/Iterator;
    //   8: astore_2
    //   9: aload_2
    //   10: invokeinterface hasNext : ()Z
    //   15: ifeq -> 58
    //   18: aload_2
    //   19: invokeinterface next : ()Ljava/lang/Object;
    //   24: checkcast com/alipay/a/a/i
    //   27: astore_3
    //   28: aload_3
    //   29: aload_1
    //   30: invokestatic a : (Ljava/lang/reflect/Type;)Ljava/lang/Class;
    //   33: invokeinterface a : (Ljava/lang/Class;)Z
    //   38: ifeq -> 9
    //   41: aload_3
    //   42: aload_0
    //   43: aload_1
    //   44: invokeinterface a : (Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull -> 9
    //   54: aload_3
    //   55: astore_0
    //   56: aload_0
    //   57: areturn
    //   58: aconst_null
    //   59: astore_0
    //   60: goto -> 56
  }
  
  public static final Object a(String paramString, Type paramType) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    paramString = paramString.trim();
    return (paramString.startsWith("[") && paramString.endsWith("]")) ? a(new a(paramString), paramType) : ((paramString.startsWith("{") && paramString.endsWith("}")) ? a(new b(paramString), paramType) : a(paramString, paramType));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
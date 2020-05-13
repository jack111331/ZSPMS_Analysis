package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class z {
  private static final ThreadLocal<Object> a = new ThreadLocal();
  
  private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal<Map<String, Object>>();
  
  private byte c = (byte)0;
  
  private AtomicInteger d;
  
  private x e;
  
  public z(x paramx) {
    this.e = paramx;
    this.d = new AtomicInteger();
  }
  
  public final Object a(Method paramMethod, Object[] paramArrayOfObject) {
    boolean bool = true;
    if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i)
      throw new IllegalThreadStateException("can't in main thread call rpc ."); 
    OperationType operationType = paramMethod.<OperationType>getAnnotation(OperationType.class);
    if (paramMethod.getAnnotation(ResetCookie.class) == null)
      bool = false; 
    Type type = paramMethod.getGenericReturnType();
    paramMethod.getAnnotations();
    a.set(null);
    b.set(null);
    if (operationType == null)
      throw new IllegalStateException("OperationType must be set."); 
    String str = operationType.value();
    int i = this.d.incrementAndGet();
    try {
      if (this.c == 0) {
        e e = new e();
        this(i, str, paramArrayOfObject);
        if (b.get() != null)
          e.a(b.get()); 
        byte[] arrayOfByte2 = e.a();
        j j = new j();
        this(this.e.a(), paramMethod, i, str, arrayOfByte2, bool);
        byte[] arrayOfByte1 = (byte[])j.a();
        b.set(null);
        d d = new d();
        this(type, arrayOfByte1);
        Object object = d.a();
        if (type != void.class)
          a.set(object); 
      } 
      return a.get();
    } catch (RpcException rpcException) {
      rpcException.setOperationType(str);
      throw rpcException;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class j extends a {
  private g g;
  
  public j(g paramg, Method paramMethod, int paramInt, String paramString, byte[] paramArrayOfbyte, boolean paramBoolean) {
    super(paramMethod, paramInt, paramString, paramArrayOfbyte, "application/x-www-form-urlencoded", paramBoolean);
    this.g = paramg;
  }
  
  public final Object a() {
    o o = new o(this.g.a());
    o.a(this.b);
    o.a(this.e);
    o.a(this.f);
    o.a("id", String.valueOf(this.d));
    o.a("operationType", this.c);
    o.a("gzip", String.valueOf(this.g.d()));
    o.a((Header)new BasicHeader("uuid", UUID.randomUUID().toString()));
    List<Header> list = this.g.c().b();
    if (list != null && !list.isEmpty()) {
      Iterator<Header> iterator = list.iterator();
      while (iterator.hasNext())
        o.a(iterator.next()); 
    } 
    (new StringBuilder("threadid = ")).append(Thread.currentThread().getId()).append("; ").append(o.toString());
    try {
      RpcException rpcException;
      u u = this.g.b().a(o).get();
      if (u == null) {
        rpcException = new RpcException();
        this(Integer.valueOf(9), "response is null");
        throw rpcException;
      } 
      return rpcException.b();
    } catch (InterruptedException interruptedException) {
      throw new RpcException(Integer.valueOf(13), "", interruptedException);
    } catch (ExecutionException executionException) {
      HttpException httpException;
      Throwable throwable = executionException.getCause();
      if (throwable != null && throwable instanceof HttpException) {
        httpException = (HttpException)throwable;
        int i = httpException.getCode();
        switch (i) {
          default:
            throw new RpcException(Integer.valueOf(i), httpException.getMsg());
          case 3:
            i = 4;
          case 6:
            i = 7;
          case 7:
            i = 8;
          case 5:
            i = 6;
          case 4:
            i = 5;
          case 2:
            i = 3;
          case 1:
            i = 2;
          case 9:
            i = 16;
          case 8:
            break;
        } 
        i = 15;
      } 
      throw new RpcException(Integer.valueOf(9), "", httpException);
    } catch (CancellationException cancellationException) {
      throw new RpcException(Integer.valueOf(13), "", cancellationException);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
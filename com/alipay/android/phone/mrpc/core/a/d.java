package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.e;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.lang.reflect.Type;
import org.json.JSONObject;

public final class d extends a {
  public d(Type paramType, byte[] paramArrayOfbyte) {
    super(paramType, paramArrayOfbyte);
  }
  
  public final Object a() {
    RpcException rpcException;
    try {
      String str = new String();
      this(this.b);
      StringBuilder stringBuilder = new StringBuilder();
      this("threadid = ");
      stringBuilder.append(Thread.currentThread().getId()).append("; rpc response:  ").append(str);
      JSONObject jSONObject = new JSONObject();
      this(str);
      int i = jSONObject.getInt("resultStatus");
      if (i != 1000) {
        str = jSONObject.optString("tips");
        rpcException = new RpcException();
        this(Integer.valueOf(i), str);
        throw rpcException;
      } 
    } catch (Exception exception) {
      if ("response  =" + new String(this.b) + ":" + exception == null) {
        String str = "";
        throw new RpcException(Integer.valueOf(10), str);
      } 
    } 
    return (this.a == String.class) ? rpcException.optString("result") : e.a(rpcException.optString("result"), this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
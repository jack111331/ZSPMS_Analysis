package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.f;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class e extends b {
  private int c;
  
  private Object d;
  
  public e(int paramInt, String paramString, Object paramObject) {
    super(paramString, paramObject);
    this.c = paramInt;
  }
  
  public final void a(Object paramObject) {
    this.d = paramObject;
  }
  
  public final byte[] a() {
    String str;
    try {
      ArrayList<BasicNameValuePair> arrayList = new ArrayList();
      this();
      if (this.d != null) {
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair();
        this("extParam", f.a(this.d));
        arrayList.add(basicNameValuePair);
      } 
      BasicNameValuePair basicNameValuePair1 = new BasicNameValuePair();
      this("operationType", this.a);
      arrayList.add(basicNameValuePair1);
      BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      this("id", stringBuilder.append(this.c).toString());
      arrayList.add(basicNameValuePair2);
      stringBuilder = new StringBuilder();
      this("mParams is:");
      stringBuilder.append(this.b);
      basicNameValuePair2 = new BasicNameValuePair();
      if (this.b == null) {
        String str1 = "[]";
        this("requestData", str1);
        arrayList.add(basicNameValuePair2);
        return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
      } 
      str = f.a(this.b);
      this("requestData", str);
      arrayList.add(basicNameValuePair2);
      return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
    } catch (Exception exception) {
      if ("request  =" + this.b + ":" + exception == null) {
        str = "";
        throw new RpcException(Integer.valueOf(9), str, exception);
      } 
    } 
    throw new RpcException(Integer.valueOf(9), str, exception);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
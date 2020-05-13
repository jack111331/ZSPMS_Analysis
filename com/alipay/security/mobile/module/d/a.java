package com.alipay.security.mobile.module.d;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
  }
  
  public final String toString() {
    StringBuffer stringBuffer = new StringBuffer((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(Calendar.getInstance().getTime()));
    stringBuffer.append("," + this.a);
    stringBuffer.append("," + this.b);
    stringBuffer.append("," + this.c);
    stringBuffer.append("," + this.d);
    if (com.alipay.security.mobile.module.a.a.a(this.e) || this.e.length() < 20) {
      stringBuffer.append("," + this.e);
    } else {
      stringBuffer.append("," + this.e.substring(0, 20));
    } 
    if (com.alipay.security.mobile.module.a.a.a(this.f) || this.f.length() < 20) {
      stringBuffer.append("," + this.f);
    } else {
      stringBuffer.append("," + this.f.substring(0, 20));
    } 
    if (com.alipay.security.mobile.module.a.a.a(this.g) || this.g.length() < 20) {
      stringBuffer.append("," + this.g);
      return stringBuffer.toString();
    } 
    stringBuffer.append("," + this.g.substring(0, 20));
    return stringBuffer.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
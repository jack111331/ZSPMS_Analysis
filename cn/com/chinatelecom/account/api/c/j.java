package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.a.c;

public class j implements g {
  public String a() {
    return Helper.cepahsul();
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4) {
    return Helper.dnepah(paramContext, paramString1, paramString2, paramString3, paramLong, paramString4);
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5) {
    return Helper.cinetw(paramContext, paramString1, paramString2, paramString3, paramString4, paramLong, paramString5);
  }
  
  public String a(String paramString1, String paramString2) {
    String str;
    try {
      byte[] arrayOfByte = Helper.dnepmret(c.a(paramString1), paramString2);
      paramString1 = new String();
      this(arrayOfByte);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public String b() {
    return Helper.cemppmul();
  }
  
  public String b(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4) {
    return Helper.dnepmo(paramContext, paramString1, paramString2, paramString3, paramLong, paramString4);
  }
  
  public String b(String paramString1, String paramString2) {
    String str;
    try {
      byte[] arrayOfByte = Helper.dnenwret(c.a(paramString1), paramString2);
      paramString1 = new String();
      this(arrayOfByte);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public String c() {
    return Helper.cemnetwul();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
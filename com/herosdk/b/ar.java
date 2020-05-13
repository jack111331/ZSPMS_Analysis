package com.herosdk.b;

import android.util.Log;
import com.herosdk.d.q;
import com.herosdk.error.ErrorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ar {
  private int a;
  
  private byte[] b;
  
  private ak c;
  
  ar(as paramas) {
    this.a = paramas.a;
    this.b = paramas.b;
    this.c = paramas.c;
  }
  
  public int a() {
    return this.a;
  }
  
  public boolean b() {
    return (this.a == 200);
  }
  
  public ak c() {
    return this.c;
  }
  
  public String d() {
    String str = "";
    try {
      String str1 = ao.c(q.b(this.b));
      str = str1;
    } catch (Exception exception) {
      Log.e("frameLib", "ass ex:" + "");
      ErrorUtils.printExceptionInfo(exception);
    } 
    return str;
  }
  
  public JSONObject e() {
    return new JSONObject(d());
  }
  
  public JSONArray f() {
    return (d().length() == 0) ? new JSONArray() : new JSONArray(d());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
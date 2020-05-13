package com.sdk.base.framework.bean;

import com.sdk.base.framework.utils.c.a;
import java.util.ArrayList;

public class PInfo {
  private String c;
  
  private ArrayList<String> imei;
  
  private String mac;
  
  private String n;
  
  private String os;
  
  public String getC() {
    return this.c;
  }
  
  public ArrayList<String> getImei() {
    return this.imei;
  }
  
  public String getMac() {
    return this.mac;
  }
  
  public String getN() {
    return this.n;
  }
  
  public String getOs() {
    return this.os;
  }
  
  public void setC(String paramString) {
    this.c = paramString;
  }
  
  public void setImei(ArrayList<String> paramArrayList) {
    this.imei = paramArrayList;
  }
  
  public void setMac(String paramString) {
    this.mac = paramString;
  }
  
  public void setN(String paramString) {
    this.n = paramString;
  }
  
  public void setOs(String paramString) {
    this.os = paramString;
  }
  
  public String toString() {
    return a.a(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\bean\PInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
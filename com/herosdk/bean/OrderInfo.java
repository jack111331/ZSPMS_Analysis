package com.herosdk.bean;

import java.io.Serializable;
import java.util.HashMap;

public class OrderInfo implements Serializable {
  private static final long a = 7271434486649411058L;
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private double g = 0.0D;
  
  private int h;
  
  private double i;
  
  private String j = "";
  
  private String k = "";
  
  private String l = "";
  
  private HashMap<String, String> m;
  
  public double getAmount() {
    return this.g;
  }
  
  public String getCallbackUrl() {
    return this.j;
  }
  
  public int getCount() {
    return this.h;
  }
  
  public String getCpOrderId() {
    return this.e;
  }
  
  public HashMap<String, String> getExtendParams() {
    return this.m;
  }
  
  public String getExtraParams() {
    return this.l;
  }
  
  public String getGoodsDesc() {
    return this.d;
  }
  
  public String getGoodsId() {
    return this.b;
  }
  
  public String getGoodsName() {
    return this.c;
  }
  
  public double getPrice() {
    return this.i;
  }
  
  public String getSdkOrderId() {
    return this.f;
  }
  
  public String getServerMessage() {
    return this.k;
  }
  
  public void setAmount(double paramDouble) {
    this.g = paramDouble;
  }
  
  public void setCallbackUrl(String paramString) {
    this.j = paramString;
  }
  
  public void setCount(int paramInt) {
    this.h = paramInt;
  }
  
  public void setCpOrderId(String paramString) {
    this.e = paramString;
  }
  
  public void setExtendParams(HashMap<String, String> paramHashMap) {
    this.m = paramHashMap;
  }
  
  public void setExtraParams(String paramString) {
    this.l = paramString;
  }
  
  public void setGoodsDesc(String paramString) {
    this.d = paramString;
  }
  
  public void setGoodsId(String paramString) {
    this.b = paramString;
  }
  
  public void setGoodsName(String paramString) {
    this.c = paramString;
  }
  
  public void setPrice(double paramDouble) {
    this.i = paramDouble;
  }
  
  public void setSdkOrderId(String paramString) {
    this.f = paramString;
  }
  
  public void setServerMessage(String paramString) {
    this.k = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\bean\OrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
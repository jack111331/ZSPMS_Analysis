package com.herosdk.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;

public class RoleInfo implements Serializable {
  public static final int a = 1;
  
  public static final int b = 2;
  
  public static final int c = 3;
  
  private static final long d = 8329661595016365524L;
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private String j = "";
  
  private String k = "";
  
  private String l = "";
  
  private long m = 0L;
  
  private long n = 0L;
  
  private int o = 0;
  
  private String p = "";
  
  private String q = "";
  
  private String r = "";
  
  private String s = "";
  
  private String t = "";
  
  private String u = "";
  
  private String v = "";
  
  private String w = "";
  
  private String x = "";
  
  private HashMap<String, String> y;
  
  public long getBalanceLevelOne() {
    return this.m;
  }
  
  public long getBalanceLevelTwo() {
    return this.n;
  }
  
  public HashMap<String, String> getExtendParams() {
    return this.y;
  }
  
  public String getFriendList() {
    return this.x;
  }
  
  public String getPartyId() {
    return this.q;
  }
  
  public String getPartyName() {
    return this.l;
  }
  
  public String getPartyRoleId() {
    return this.t;
  }
  
  public String getPartyRoleName() {
    return this.u;
  }
  
  public String getProfession() {
    return this.w;
  }
  
  public String getProfessionId() {
    return this.v;
  }
  
  public String getRoleBalance() {
    if (TextUtils.isEmpty(this.k) && this.m > 0L)
      this.k = String.valueOf(this.m); 
    return this.k;
  }
  
  public String getRoleCreateTime() {
    return this.p;
  }
  
  public String getRoleGender() {
    return this.r;
  }
  
  public String getRoleId() {
    return this.e;
  }
  
  public String getRoleLevel() {
    return this.i;
  }
  
  public String getRoleName() {
    return this.f;
  }
  
  public String getRolePower() {
    return this.s;
  }
  
  public String getServerId() {
    return this.g;
  }
  
  public String getServerName() {
    return this.h;
  }
  
  public int getSumPay() {
    return this.o;
  }
  
  public String getVipLevel() {
    return this.j;
  }
  
  public void setBalanceLevelOne(long paramLong) {
    this.m = paramLong;
  }
  
  public void setBalanceLevelTwo(long paramLong) {
    this.n = paramLong;
  }
  
  public void setExtendParams(HashMap<String, String> paramHashMap) {
    this.y = paramHashMap;
  }
  
  public void setFriendList(String paramString) {
    this.x = paramString;
  }
  
  public void setPartyId(String paramString) {
    this.q = paramString;
  }
  
  public void setPartyName(String paramString) {
    this.l = paramString;
  }
  
  public void setPartyRoleId(String paramString) {
    this.t = paramString;
  }
  
  public void setPartyRoleName(String paramString) {
    this.u = paramString;
  }
  
  public void setProfession(String paramString) {
    this.w = paramString;
  }
  
  public void setProfessionId(String paramString) {
    this.v = paramString;
  }
  
  public void setRoleBalance(String paramString) {
    this.k = paramString;
  }
  
  public void setRoleCreateTime(String paramString) {
    this.p = paramString;
  }
  
  public void setRoleGender(String paramString) {
    this.r = paramString;
  }
  
  public void setRoleId(String paramString) {
    this.e = paramString;
  }
  
  public void setRoleLevel(String paramString) {
    this.i = paramString;
  }
  
  public void setRoleName(String paramString) {
    this.f = paramString;
  }
  
  public void setRolePower(String paramString) {
    this.s = paramString;
  }
  
  public void setServerId(String paramString) {
    this.g = paramString;
  }
  
  public void setServerName(String paramString) {
    this.h = paramString;
  }
  
  public void setSumPay(int paramInt) {
    this.o = paramInt;
  }
  
  public void setVipLevel(String paramString) {
    this.j = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\bean\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
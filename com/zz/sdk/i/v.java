package com.zz.sdk.i;

import com.zz.sdk.b.t;
import com.zz.sdk.listener.IKickOffListener;

public final class v {
  public static long A = 0L;
  
  public static boolean B = false;
  
  public static IKickOffListener C;
  
  public static String D;
  
  public static final String E = "zzsdk_account_agree_protocol_sp";
  
  public static final String F = "_zzsdk_account_agree_protocol";
  
  private static String G = null;
  
  private static String H = "https://sdk-api.yingxiong.com/";
  
  static final String a = "http://ugc.map.soso.com/rgeoc/?lnglat=%s,%s&reqsrc=wb";
  
  static final String b = "sign";
  
  static final String c = "__e__";
  
  static final String d = "/zzsdk/data/code/zz";
  
  static final String e = "ZM.DAT.";
  
  static final String f = "PROJECT_ID";
  
  static final String g = "PRODUCT_ID";
  
  static final String h = "SERVER_ID";
  
  static final String i = "SERVER_NAME";
  
  public static final String j = "zz_res/";
  
  public static final String k = "market";
  
  public static final String l = "zz_sdk";
  
  public static final String m = "UITN25LMUQC436IM";
  
  public static String n = "https://i.yingxiong.com/sdkImg/index";
  
  public static final String o = "zzsdk_upload_contacts_sp";
  
  public static final String p = "_zzsdk_upload_contacts";
  
  public static boolean q = false;
  
  public static boolean r = false;
  
  public static final String s = "zzsdk_last_upload_contacts_time_sp";
  
  public static final String t = "zzsdk_last_upload_contacts_time";
  
  public static final String u = "zzsdk_is_show_contact_to_friends_sp";
  
  public static final String v = "_zzsdk_is_show_contact_to_friends";
  
  public static final String w = "zzsdk_is_closed_real_name_dialog_sp";
  
  public static final String x = "zzsdk_is_closed_real_name_dialog";
  
  public static boolean y = true;
  
  public static t z;
  
  static {
    A = 1296000000L;
    B = false;
  }
  
  public static boolean a(String[] paramArrayOfString) {
    if (paramArrayOfString.length == 2) {
      H = paramArrayOfString[0];
      G = paramArrayOfString[1];
      return true;
    } 
    H = paramArrayOfString[0];
    G = null;
    return true;
  }
  
  private static String b(av paramav) {
    switch (w.a[paramav.ordinal()]) {
      default:
        return null;
      case 1:
        if (G != null)
          return G; 
        break;
      case 2:
        break;
    } 
    return H;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
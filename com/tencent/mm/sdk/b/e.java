package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class e {
  private static final long[] G = new long[] { 300L, 200L, 300L, 200L };
  
  private static final TimeZone GMT;
  
  private static final long[] H = new long[] { 300L, 50L, 300L, 50L };
  
  private static final char[] I;
  
  private static final String[] J;
  
  static {
    GMT = TimeZone.getTimeZone("GMT");
    I = new char[] { '<', '>', '"', '\'', '&', '\r', '\n', ' ', '\t' };
    J = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  }
  
  public static boolean j(String paramString) {
    return (paramString == null || paramString.length() <= 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
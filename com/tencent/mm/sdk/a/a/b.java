package com.tencent.mm.sdk.a.a;

public final class b {
  public static byte[] a(String paramString1, int paramInt, String paramString2) {
    StringBuffer stringBuffer = new StringBuffer();
    if (paramString1 != null)
      stringBuffer.append(paramString1); 
    stringBuffer.append(paramInt);
    stringBuffer.append(paramString2);
    stringBuffer.append("mMcShCsTr");
    return com.tencent.mm.a.b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
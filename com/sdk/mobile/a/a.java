package com.sdk.mobile.a;

import android.content.Context;
import com.sdk.base.framework.a.c;

public class a {
  public <T> c<T> a(Context paramContext, int paramInt, com.sdk.base.framework.b.a<T> parama) {
    return (new com.sdk.mobile.b.a(paramContext, parama)).a(paramInt);
  }
  
  public <T> c a(Context paramContext, String paramString1, String paramString2, com.sdk.base.framework.b.a<T> parama) {
    com.sdk.mobile.b.a a1 = new com.sdk.mobile.b.a(paramContext, parama);
    return com.sdk.base.framework.utils.k.a.a(paramString2).booleanValue() ? a1.a(paramString1) : a1.a(paramString1, paramString2);
  }
  
  public <T> c<T> b(Context paramContext, int paramInt, com.sdk.base.framework.b.a<T> parama) {
    return (new com.sdk.mobile.b.a(paramContext, parama)).b(paramInt);
  }
  
  public <T> c b(Context paramContext, String paramString1, String paramString2, com.sdk.base.framework.b.a<T> parama) {
    return (new com.sdk.mobile.b.a(paramContext, parama)).b(paramString1, paramString2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
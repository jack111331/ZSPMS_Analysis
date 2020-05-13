package com.qiniu.android.common;

import java.net.URI;

public abstract class Zone {
  public abstract void frozenDomain(String paramString);
  
  public abstract void preQuery(String paramString, QueryHandler paramQueryHandler);
  
  public abstract boolean preQuery(String paramString);
  
  protected String upHost(ZoneInfo paramZoneInfo, boolean paramBoolean, String paramString) {
    String str;
    ZoneInfo zoneInfo;
    /* monitor enter ThisExpression{ObjectType{com/qiniu/android/common/Zone}} */
    if (paramString != null)
      try {
        paramZoneInfo.frozenDomain(URI.create(paramString).getHost());
      } finally {} 
    byte b = 0;
    while (true) {
      int i = paramZoneInfo.upDomainsList.size();
      zoneInfo = null;
      if (b < i) {
        String str1 = paramZoneInfo.upDomainsList.get(b);
        long l = ((Long)paramZoneInfo.upDomainsMap.get(str1)).longValue();
        paramString = str1;
        if (l != 0L) {
          if (l <= System.currentTimeMillis() / 1000L) {
            paramString = str1;
            break;
          } 
          b++;
          continue;
        } 
        break;
      } 
      paramString = null;
      break;
    } 
    if (paramString != null) {
      paramZoneInfo.upDomainsMap.put(paramString, Long.valueOf(0L));
    } else {
      for (String str1 : paramZoneInfo.upDomainsList)
        paramZoneInfo.upDomainsMap.put(str1, Long.valueOf(0L)); 
      if (paramZoneInfo.upDomainsList.size() > 0)
        paramString = paramZoneInfo.upDomainsList.get(0); 
    } 
    paramZoneInfo = zoneInfo;
    if (paramString != null)
      if (paramBoolean) {
        str = String.format("https://%s", new Object[] { paramString });
      } else {
        str = String.format("http://%s", new Object[] { paramString });
      }  
    /* monitor exit ThisExpression{ObjectType{com/qiniu/android/common/Zone}} */
    return str;
  }
  
  public abstract String upHost(String paramString1, boolean paramBoolean, String paramString2);
  
  public static interface QueryHandler {
    void onFailure(int param1Int);
    
    void onSuccess();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\common\Zone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
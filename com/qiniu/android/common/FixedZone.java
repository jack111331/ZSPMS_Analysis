package com.qiniu.android.common;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FixedZone extends Zone {
  public static final Zone zone0 = new FixedZone(new String[] { "upload.qiniup.com", "upload-jjh.qiniup.com", "upload-xs.qiniup.com", "up.qiniup.com", "up-jjh.qiniup.com", "up-xs.qiniup.com", "upload.qbox.me", "up.qbox.me" });
  
  public static final Zone zone1 = new FixedZone(new String[] { "upload-z1.qiniup.com", "up-z1.qiniup.com", "upload-z1.qbox.me", "up-z1.qbox.me" });
  
  public static final Zone zone2 = new FixedZone(new String[] { "upload-z2.qiniup.com", "upload-dg.qiniup.com", "upload-fs.qiniup.com", "up-z2.qiniup.com", "up-dg.qiniup.com", "up-fs.qiniup.com", "upload-z2.qbox.me", "up-z2.qbox.me" });
  
  public static final Zone zoneAs0;
  
  public static final Zone zoneNa0 = new FixedZone(new String[] { "upload-na0.qiniup.com", "up-na0.qiniup.com", "upload-na0.qbox.me", "up-na0.qbox.me" });
  
  private ZoneInfo zoneInfo;
  
  static {
    zoneAs0 = new FixedZone(new String[] { "upload-as0.qiniup.com", "up-as0.qiniup.com", "upload-as0.qbox.me", "up-as0.qbox.me" });
  }
  
  public FixedZone(ZoneInfo paramZoneInfo) {
    this.zoneInfo = paramZoneInfo;
  }
  
  public FixedZone(String[] paramArrayOfString) {
    this.zoneInfo = createZoneInfo(paramArrayOfString);
  }
  
  public static ZoneInfo createZoneInfo(String[] paramArrayOfString) {
    ArrayList<String> arrayList = new ArrayList();
    ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      String str = paramArrayOfString[b];
      arrayList.add(str);
      concurrentHashMap.put(str, Long.valueOf(0L));
    } 
    return new ZoneInfo(0, arrayList, (Map)concurrentHashMap);
  }
  
  public void frozenDomain(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 30
    //   6: aload_1
    //   7: invokestatic create : (Ljava/lang/String;)Ljava/net/URI;
    //   10: invokevirtual getHost : ()Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: getfield zoneInfo : Lcom/qiniu/android/common/ZoneInfo;
    //   18: aload_1
    //   19: invokevirtual frozenDomain : (Ljava/lang/String;)V
    //   22: goto -> 30
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    // Exception table:
    //   from	to	target	type
    //   6	22	25	finally
  }
  
  public void preQuery(String paramString, Zone.QueryHandler paramQueryHandler) {
    paramQueryHandler.onSuccess();
  }
  
  public boolean preQuery(String paramString) {
    return true;
  }
  
  public String upHost(String paramString1, boolean paramBoolean, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield zoneInfo : Lcom/qiniu/android/common/ZoneInfo;
    //   7: iload_2
    //   8: aload_3
    //   9: invokevirtual upHost : (Lcom/qiniu/android/common/ZoneInfo;ZLjava/lang/String;)Ljava/lang/String;
    //   12: astore_3
    //   13: aload_0
    //   14: getfield zoneInfo : Lcom/qiniu/android/common/ZoneInfo;
    //   17: getfield upDomainsMap : Ljava/util/Map;
    //   20: invokeinterface entrySet : ()Ljava/util/Set;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore #4
    //   32: aload #4
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 109
    //   42: aload #4
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast java/util/Map$Entry
    //   52: astore #5
    //   54: new java/lang/StringBuilder
    //   57: astore_1
    //   58: aload_1
    //   59: invokespecial <init> : ()V
    //   62: aload_1
    //   63: aload #5
    //   65: invokeinterface getKey : ()Ljava/lang/Object;
    //   70: checkcast java/lang/String
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: ldc ', '
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload #5
    //   87: invokeinterface getValue : ()Ljava/lang/Object;
    //   92: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 'Qiniu.FixedZone'
    //   98: aload_1
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   105: pop
    //   106: goto -> 32
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: areturn
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	113	finally
    //   32	106	113	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\common\FixedZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
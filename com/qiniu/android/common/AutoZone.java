package com.qiniu.android.common;

import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.UrlSafeBase64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class AutoZone extends Zone {
  public static final AutoZone autoZone = new AutoZone(null);
  
  private Client client = new Client();
  
  private final String ucServer;
  
  private Map<ZoneIndex, ZoneInfo> zones = new ConcurrentHashMap<ZoneIndex, ZoneInfo>();
  
  public AutoZone(DnsManager paramDnsManager) {
    this("https://uc.qbox.me", paramDnsManager);
  }
  
  AutoZone(String paramString, DnsManager paramDnsManager) {
    this.ucServer = paramString;
  }
  
  private void getZoneJsonAsync(ZoneIndex paramZoneIndex, CompletionHandler paramCompletionHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.ucServer);
    stringBuilder.append("/v2/query?ak=");
    stringBuilder.append(paramZoneIndex.accessKey);
    stringBuilder.append("&bucket=");
    stringBuilder.append(paramZoneIndex.bucket);
    String str = stringBuilder.toString();
    this.client.asyncGet(str, null, UpToken.NULL, paramCompletionHandler);
  }
  
  private ResponseInfo getZoneJsonSync(ZoneIndex paramZoneIndex) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.ucServer);
    stringBuilder.append("/v2/query?ak=");
    stringBuilder.append(paramZoneIndex.accessKey);
    stringBuilder.append("&bucket=");
    stringBuilder.append(paramZoneIndex.bucket);
    String str = stringBuilder.toString();
    return this.client.syncGet(str, null);
  }
  
  public void frozenDomain(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 93
    //   6: aload_1
    //   7: invokestatic create : (Ljava/lang/String;)Ljava/net/URI;
    //   10: invokevirtual getHost : ()Ljava/lang/String;
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield zones : Ljava/util/Map;
    //   20: invokeinterface entrySet : ()Ljava/util/Set;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore #4
    //   32: aload_3
    //   33: astore_1
    //   34: aload #4
    //   36: invokeinterface hasNext : ()Z
    //   41: ifeq -> 76
    //   44: aload #4
    //   46: invokeinterface next : ()Ljava/lang/Object;
    //   51: checkcast java/util/Map$Entry
    //   54: invokeinterface getValue : ()Ljava/lang/Object;
    //   59: checkcast com/qiniu/android/common/ZoneInfo
    //   62: astore_1
    //   63: aload_1
    //   64: getfield upDomainsList : Ljava/util/List;
    //   67: aload_2
    //   68: invokeinterface contains : (Ljava/lang/Object;)Z
    //   73: ifeq -> 32
    //   76: aload_1
    //   77: ifnull -> 93
    //   80: aload_1
    //   81: aload_2
    //   82: invokevirtual frozenDomain : (Ljava/lang/String;)V
    //   85: goto -> 93
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    // Exception table:
    //   from	to	target	type
    //   6	14	88	finally
    //   16	32	88	finally
    //   34	76	88	finally
    //   80	85	88	finally
  }
  
  public void preQuery(String paramString, Zone.QueryHandler paramQueryHandler) {
    preQueryIndex(ZoneIndex.getFromToken(paramString), paramQueryHandler);
  }
  
  public boolean preQuery(String paramString) {
    return preQueryIndex(ZoneIndex.getFromToken(paramString));
  }
  
  void preQueryIndex(final ZoneIndex index, final Zone.QueryHandler complete) {
    if (index == null) {
      complete.onFailure(-5);
      return;
    } 
    if ((ZoneInfo)this.zones.get(index) != null) {
      complete.onSuccess();
      return;
    } 
    getZoneJsonAsync(index, new CompletionHandler() {
          public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
            if (param1ResponseInfo.isOK() && param1JSONObject != null)
              try {
                ZoneInfo zoneInfo = ZoneInfo.buildFromJson(param1JSONObject);
                AutoZone.this.zones.put(index, zoneInfo);
                complete.onSuccess();
                return;
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
                complete.onFailure(-1);
                return;
              }  
            complete.onFailure(((ResponseInfo)jSONException).statusCode);
          }
        });
  }
  
  boolean preQueryIndex(ZoneIndex paramZoneIndex) {
    boolean bool = true;
    if (paramZoneIndex != null) {
      if ((ZoneInfo)this.zones.get(paramZoneIndex) == null)
        try {
          ZoneInfo zoneInfo = ZoneInfo.buildFromJson((getZoneJsonSync(paramZoneIndex)).response);
          this.zones.put(paramZoneIndex, zoneInfo);
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
          bool = false;
        }  
      return bool;
    } 
    bool = false;
  }
  
  ZoneInfo queryByToken(String paramString) {
    try {
      String[] arrayOfString = paramString.split(":");
      String str = arrayOfString[0];
      paramString = new String();
      this(UrlSafeBase64.decode(arrayOfString[2]), "utf-8");
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      return zoneInfo(str, jSONObject.getString("scope").split(":")[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public String upHost(String paramString1, boolean paramBoolean, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual queryByToken : (Ljava/lang/String;)Lcom/qiniu/android/common/ZoneInfo;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull -> 24
    //   12: aload_0
    //   13: aload_1
    //   14: iload_2
    //   15: aload_3
    //   16: invokespecial upHost : (Lcom/qiniu/android/common/ZoneInfo;ZLjava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: monitorexit
    //   26: aconst_null
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	28	finally
    //   12	20	28	finally
  }
  
  ZoneInfo zoneInfo(String paramString1, String paramString2) {
    ZoneIndex zoneIndex = new ZoneIndex(paramString1, paramString2);
    return this.zones.get(zoneIndex);
  }
  
  static class ZoneIndex {
    final String accessKey;
    
    final String bucket;
    
    ZoneIndex(String param1String1, String param1String2) {
      this.accessKey = param1String1;
      this.bucket = param1String2;
    }
    
    static ZoneIndex getFromToken(String param1String) {
      String[] arrayOfString = param1String.split(":");
      String str = arrayOfString[0];
      try {
        param1String = new String();
        this(UrlSafeBase64.decode(arrayOfString[2]), "utf-8");
        JSONObject jSONObject = new JSONObject();
        this(param1String);
        return new ZoneIndex(str, jSONObject.getString("scope").split(":")[0]);
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object != this) {
        if (param1Object != null && param1Object instanceof ZoneIndex) {
          param1Object = param1Object;
          if (((ZoneIndex)param1Object).accessKey.equals(this.accessKey) && ((ZoneIndex)param1Object).bucket.equals(this.bucket))
            return true; 
        } 
        return false;
      } 
      return true;
    }
    
    public int hashCode() {
      return this.accessKey.hashCode() * 37 + this.bucket.hashCode();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\common\AutoZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
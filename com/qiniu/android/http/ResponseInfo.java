package com.qiniu.android.http;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.StringUtils;
import java.util.Locale;
import org.json.JSONObject;

public final class ResponseInfo {
  public static final int Cancelled = -2;
  
  public static final int CannotConnectToHost = -1004;
  
  public static final int InvalidArgument = -4;
  
  public static final int InvalidFile = -3;
  
  public static final int InvalidToken = -5;
  
  public static final int NetworkConnectionLost = -1005;
  
  public static final int NetworkError = -1;
  
  public static final int TimedOut = -1001;
  
  public static final int UnknownError = 0;
  
  public static final int UnknownHost = -1003;
  
  public static final int ZeroSizeFile = -6;
  
  public final long duration;
  
  public final String error;
  
  public final String host;
  
  public final String id;
  
  public final String ip;
  
  public final String path;
  
  public final int port;
  
  public final String reqId;
  
  public final JSONObject response;
  
  public final long sent;
  
  public final int statusCode;
  
  public final long timeStamp;
  
  public final long totalSize;
  
  public final UpToken upToken;
  
  public final String xlog;
  
  public final String xvia;
  
  private ResponseInfo(JSONObject paramJSONObject, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, long paramLong1, long paramLong2, String paramString7, UpToken paramUpToken, long paramLong3) {
    this.response = paramJSONObject;
    this.statusCode = paramInt1;
    this.reqId = paramString1;
    this.xlog = paramString2;
    this.xvia = paramString3;
    this.host = paramString4;
    this.path = paramString5;
    this.duration = paramLong1;
    this.error = paramString7;
    this.ip = paramString6;
    this.port = paramInt2;
    this.id = (UserAgent.instance()).id;
    this.timeStamp = System.currentTimeMillis() / 1000L;
    this.sent = paramLong2;
    this.upToken = paramUpToken;
    this.totalSize = paramLong3;
  }
  
  public static ResponseInfo cancelled(UpToken paramUpToken) {
    return create(null, -2, "", "", "", "", "", "", 80, -1L, -1L, "cancelled by user", paramUpToken, 0L);
  }
  
  public static ResponseInfo create(JSONObject paramJSONObject, final int statusCode, final String reqId, String paramString2, String paramString3, final String host, final String path, final String ip, final int port, final long duration, final long sent, String paramString7, UpToken paramUpToken, final long totalSize) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ip);
    stringBuilder.append("");
    ip = stringBuilder.toString().split(":")[0];
    ip = ip.substring(Math.max(0, ip.indexOf("/") + 1));
    ResponseInfo responseInfo = new ResponseInfo(paramJSONObject, statusCode, reqId, paramString2, paramString3, host, path, ip, port, duration, sent, paramString7, paramUpToken, totalSize);
    if (Config.isRecord || paramUpToken != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(responseInfo.timeStamp);
      stringBuilder1.append("");
      UploadInfoCollector.handleHttp(paramUpToken, new UploadInfoCollector.RecordMsg() {
            public String toRecordMsg() {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(statusCode);
              stringBuilder1.append("");
              String str2 = stringBuilder1.toString();
              String str1 = reqId;
              String str3 = host;
              String str4 = ip;
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(port);
              stringBuilder2.append("");
              String str5 = stringBuilder2.toString();
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append(duration);
              stringBuilder3.append("");
              String str7 = stringBuilder3.toString();
              String str6 = _timeStamp;
              StringBuilder stringBuilder4 = new StringBuilder();
              stringBuilder4.append(sent);
              stringBuilder4.append("");
              String str8 = stringBuilder4.toString();
              String str9 = ResponseInfo.getUpType(path);
              StringBuilder stringBuilder5 = new StringBuilder();
              stringBuilder5.append(totalSize);
              stringBuilder5.append("");
              return StringUtils.join(new String[] { str2, str1, str3, str4, str5, str7, str6, str8, str9, stringBuilder5.toString() }, ",");
            }
          });
    } 
    return responseInfo;
  }
  
  public static ResponseInfo fileError(Exception paramException, UpToken paramUpToken) {
    return create(null, -3, "", "", "", "", "", "", 80, 0L, 0L, paramException.getMessage(), paramUpToken, 0L);
  }
  
  private static String getUpType(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 187
    //   4: aload_0
    //   5: ldc '/'
    //   7: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   10: ifne -> 16
    //   13: goto -> 187
    //   16: ldc '/'
    //   18: aload_0
    //   19: invokevirtual equals : (Ljava/lang/Object;)Z
    //   22: ifeq -> 28
    //   25: ldc 'form'
    //   27: areturn
    //   28: iconst_1
    //   29: istore_1
    //   30: aload_0
    //   31: bipush #47
    //   33: iconst_1
    //   34: invokevirtual indexOf : (II)I
    //   37: istore_2
    //   38: iload_2
    //   39: iconst_1
    //   40: if_icmpge -> 46
    //   43: ldc ''
    //   45: areturn
    //   46: aload_0
    //   47: iconst_1
    //   48: iload_2
    //   49: invokevirtual substring : (II)Ljava/lang/String;
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual hashCode : ()I
    //   57: istore_2
    //   58: iload_2
    //   59: ldc -1072430054
    //   61: if_icmpeq -> 125
    //   64: iload_2
    //   65: ldc 111375
    //   67: if_icmpeq -> 111
    //   70: iload_2
    //   71: ldc 3030893
    //   73: if_icmpeq -> 99
    //   76: iload_2
    //   77: ldc 103949059
    //   79: if_icmpeq -> 85
    //   82: goto -> 139
    //   85: aload_0
    //   86: ldc 'mkblk'
    //   88: invokevirtual equals : (Ljava/lang/Object;)Z
    //   91: ifeq -> 139
    //   94: iconst_0
    //   95: istore_1
    //   96: goto -> 141
    //   99: aload_0
    //   100: ldc 'bput'
    //   102: invokevirtual equals : (Ljava/lang/Object;)Z
    //   105: ifeq -> 139
    //   108: goto -> 141
    //   111: aload_0
    //   112: ldc 'put'
    //   114: invokevirtual equals : (Ljava/lang/Object;)Z
    //   117: ifeq -> 139
    //   120: iconst_3
    //   121: istore_1
    //   122: goto -> 141
    //   125: aload_0
    //   126: ldc 'mkfile'
    //   128: invokevirtual equals : (Ljava/lang/Object;)Z
    //   131: ifeq -> 139
    //   134: iconst_2
    //   135: istore_1
    //   136: goto -> 141
    //   139: iconst_m1
    //   140: istore_1
    //   141: iload_1
    //   142: tableswitch default -> 172, 0 -> 184, 1 -> 181, 2 -> 178, 3 -> 175
    //   172: ldc ''
    //   174: areturn
    //   175: ldc 'put'
    //   177: areturn
    //   178: ldc 'mkfile'
    //   180: areturn
    //   181: ldc 'bput'
    //   183: areturn
    //   184: ldc 'mkblk'
    //   186: areturn
    //   187: ldc ''
    //   189: areturn
  }
  
  public static ResponseInfo invalidArgument(String paramString, UpToken paramUpToken) {
    return create(null, -4, "", "", "", "", "", "", 80, 0L, 0L, paramString, paramUpToken, 0L);
  }
  
  public static ResponseInfo invalidToken(String paramString) {
    return create(null, -5, "", "", "", "", "", "", 80, 0L, 0L, paramString, null, 0L);
  }
  
  public static boolean isStatusCodeForBrokenNetwork(int paramInt) {
    return (paramInt == -1 || paramInt == -1003 || paramInt == -1004 || paramInt == -1001 || paramInt == -1005);
  }
  
  public static ResponseInfo networkError(int paramInt, UpToken paramUpToken) {
    return create(null, paramInt, "", "", "", "", "", "", 80, 0L, 0L, "Network error during preQuery", paramUpToken, 0L);
  }
  
  public static ResponseInfo zeroSize(UpToken paramUpToken) {
    return create(null, -6, "", "", "", "", "", "", 80, 0L, 0L, "file or data size is zero", paramUpToken, 0L);
  }
  
  public boolean hasReqId() {
    boolean bool;
    if (this.reqId != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isCancelled() {
    boolean bool;
    if (this.statusCode == -2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isNetworkBroken() {
    return (this.statusCode == -1 || this.statusCode == -1003 || this.statusCode == -1004 || this.statusCode == -1001 || this.statusCode == -1005);
  }
  
  public boolean isNotQiniu() {
    boolean bool;
    if (this.statusCode < 500 && this.statusCode >= 200 && !hasReqId() && this.response == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isOK() {
    boolean bool;
    if (this.statusCode == 200 && this.error == null && (hasReqId() || this.response != null)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isServerError() {
    boolean bool;
    if ((this.statusCode >= 500 && this.statusCode < 600 && this.statusCode != 579) || this.statusCode == 996) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean needRetry() {
    boolean bool;
    if (!isCancelled() && (needSwitchServer() || this.statusCode == 406 || (this.statusCode == 200 && this.error != null) || (isNotQiniu() && !this.upToken.hasReturnUrl()))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean needSwitchServer() {
    return (isNetworkBroken() || isServerError());
  }
  
  public String toString() {
    return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", new Object[] { 
          "7.3.12", this.id, Integer.valueOf(this.statusCode), this.reqId, this.xlog, this.xvia, this.host, this.path, this.ip, Integer.valueOf(this.port), 
          Long.valueOf(this.duration), Long.valueOf(this.timeStamp), Long.valueOf(this.sent), this.error });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\http\ResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
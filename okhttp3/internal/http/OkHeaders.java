package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Platform;

public final class OkHeaders {
  static final String PREFIX = Platform.get().getPrefix();
  
  public static final String RECEIVED_MILLIS;
  
  public static final String RESPONSE_SOURCE;
  
  public static final String SELECTED_PROTOCOL;
  
  public static final String SENT_MILLIS = PREFIX + "-Sent-Millis";
  
  static {
    RECEIVED_MILLIS = PREFIX + "-Received-Millis";
    SELECTED_PROTOCOL = PREFIX + "-Selected-Protocol";
    RESPONSE_SOURCE = PREFIX + "-Response-Source";
  }
  
  public static long contentLength(Headers paramHeaders) {
    return stringToLong(paramHeaders.get("Content-Length"));
  }
  
  public static long contentLength(Request paramRequest) {
    return contentLength(paramRequest.headers());
  }
  
  public static long contentLength(Response paramResponse) {
    return contentLength(paramResponse.headers());
  }
  
  public static boolean hasVaryAll(Headers paramHeaders) {
    return varyFields(paramHeaders).contains("*");
  }
  
  public static boolean hasVaryAll(Response paramResponse) {
    return hasVaryAll(paramResponse.headers());
  }
  
  static boolean isEndToEnd(String paramString) {
    return (!"Connection".equalsIgnoreCase(paramString) && !"Keep-Alive".equalsIgnoreCase(paramString) && !"Proxy-Authenticate".equalsIgnoreCase(paramString) && !"Proxy-Authorization".equalsIgnoreCase(paramString) && !"TE".equalsIgnoreCase(paramString) && !"Trailers".equalsIgnoreCase(paramString) && !"Transfer-Encoding".equalsIgnoreCase(paramString) && !"Upgrade".equalsIgnoreCase(paramString));
  }
  
  public static List<Challenge> parseChallenges(Headers paramHeaders, String paramString) {
    ArrayList<Challenge> arrayList = new ArrayList();
    byte b = 0;
    int i = paramHeaders.size();
    label15: while (b < i) {
      if (!paramString.equalsIgnoreCase(paramHeaders.name(b)))
        continue; 
      String str = paramHeaders.value(b);
      int j = 0;
      while (true) {
        if (j < str.length()) {
          int k = HeaderParser.skipUntil(str, j, " ");
          String str1 = str.substring(j, k).trim();
          j = HeaderParser.skipWhitespace(str, k);
          if (str.regionMatches(true, j, "realm=\"", 0, "realm=\"".length())) {
            j += "realm=\"".length();
            k = HeaderParser.skipUntil(str, j, "\"");
            String str2 = str.substring(j, k);
            j = HeaderParser.skipWhitespace(str, HeaderParser.skipUntil(str, k + 1, ",") + 1);
            arrayList.add(new Challenge(str1, str2));
            continue;
          } 
        } 
        b++;
        continue label15;
      } 
    } 
    return arrayList;
  }
  
  private static long stringToLong(String paramString) {
    long l = -1L;
    if (paramString != null)
      try {
        long l1 = Long.parseLong(paramString);
        l = l1;
      } catch (NumberFormatException numberFormatException) {} 
    return l;
  }
  
  public static Set<String> varyFields(Headers paramHeaders) {
    Set<?> set = Collections.emptySet();
    byte b = 0;
    int i = paramHeaders.size();
    label17: while (b < i) {
      if (!"Vary".equalsIgnoreCase(paramHeaders.name(b)))
        continue; 
      String str = paramHeaders.value(b);
      Set<?> set1 = set;
      if (set.isEmpty())
        set1 = new TreeSet(String.CASE_INSENSITIVE_ORDER); 
      String[] arrayOfString = str.split(",");
      int j = arrayOfString.length;
      byte b1 = 0;
      while (true) {
        set = set1;
        if (b1 < j) {
          set1.add(arrayOfString[b1].trim());
          b1++;
          continue;
        } 
        b++;
        continue label17;
      } 
    } 
    return (Set)set;
  }
  
  private static Set<String> varyFields(Response paramResponse) {
    return varyFields(paramResponse.headers());
  }
  
  public static Headers varyHeaders(Headers paramHeaders1, Headers paramHeaders2) {
    Set<String> set = varyFields(paramHeaders2);
    if (set.isEmpty())
      return (new Headers.Builder()).build(); 
    Headers.Builder builder = new Headers.Builder();
    byte b = 0;
    int i = paramHeaders1.size();
    while (b < i) {
      String str = paramHeaders1.name(b);
      if (set.contains(str))
        builder.add(str, paramHeaders1.value(b)); 
      b++;
    } 
    return builder.build();
  }
  
  public static Headers varyHeaders(Response paramResponse) {
    return varyHeaders(paramResponse.networkResponse().request().headers(), paramResponse.headers());
  }
  
  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic varyFields : (Lokhttp3/Response;)Ljava/util/Set;
    //   4: invokeinterface iterator : ()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 51
    //   19: aload_3
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast java/lang/String
    //   28: astore_0
    //   29: aload_1
    //   30: aload_0
    //   31: invokevirtual values : (Ljava/lang/String;)Ljava/util/List;
    //   34: aload_2
    //   35: aload_0
    //   36: invokevirtual headers : (Ljava/lang/String;)Ljava/util/List;
    //   39: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   42: ifne -> 10
    //   45: iconst_0
    //   46: istore #4
    //   48: iload #4
    //   50: ireturn
    //   51: iconst_1
    //   52: istore #4
    //   54: goto -> 48
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\OkHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
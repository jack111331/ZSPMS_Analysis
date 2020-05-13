package okhttp3;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials {
  public static String basic(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      paramString1 = ByteString.of(stringBuilder2.append(paramString1).append(":").append(paramString2).toString().getBytes("ISO-8859-1")).base64();
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      return stringBuilder1.append("Basic ").append(paramString1).toString();
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
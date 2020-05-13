package okhttp3.internal.framed;

import okhttp3.internal.Util;
import okio.ByteString;

public final class Header {
  public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
  
  public static final ByteString TARGET_AUTHORITY;
  
  public static final ByteString TARGET_HOST;
  
  public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(":method");
  
  public static final ByteString TARGET_PATH = ByteString.encodeUtf8(":path");
  
  public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
  
  public static final ByteString VERSION;
  
  final int hpackSize;
  
  public final ByteString name;
  
  public final ByteString value;
  
  static {
    TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
    TARGET_HOST = ByteString.encodeUtf8(":host");
    VERSION = ByteString.encodeUtf8(":version");
  }
  
  public Header(String paramString1, String paramString2) {
    this(ByteString.encodeUtf8(paramString1), ByteString.encodeUtf8(paramString2));
  }
  
  public Header(ByteString paramByteString, String paramString) {
    this(paramByteString, ByteString.encodeUtf8(paramString));
  }
  
  public Header(ByteString paramByteString1, ByteString paramByteString2) {
    this.name = paramByteString1;
    this.value = paramByteString2;
    this.hpackSize = paramByteString1.size() + 32 + paramByteString2.size();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject instanceof Header) {
      paramObject = paramObject;
      bool2 = bool1;
      if (this.name.equals(((Header)paramObject).name)) {
        bool2 = bool1;
        if (this.value.equals(((Header)paramObject).value))
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    return (this.name.hashCode() + 527) * 31 + this.value.hashCode();
  }
  
  public String toString() {
    return Util.format("%s: %s", new Object[] { this.name.utf8(), this.value.utf8() });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
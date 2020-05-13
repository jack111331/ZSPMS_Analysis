package okio;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashingSource extends ForwardingSource {
  private final MessageDigest messageDigest;
  
  private HashingSource(Source paramSource, String paramString) {
    super(paramSource);
    try {
      this.messageDigest = MessageDigest.getInstance(paramString);
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError();
    } 
  }
  
  public static HashingSource md5(Source paramSource) {
    return new HashingSource(paramSource, "MD5");
  }
  
  public static HashingSource sha1(Source paramSource) {
    return new HashingSource(paramSource, "SHA-1");
  }
  
  public static HashingSource sha256(Source paramSource) {
    return new HashingSource(paramSource, "SHA-256");
  }
  
  public ByteString hash() {
    return ByteString.of(this.messageDigest.digest());
  }
  
  public long read(Buffer paramBuffer, long paramLong) throws IOException {
    long l = super.read(paramBuffer, paramLong);
    if (l != -1L) {
      long l2;
      long l3;
      long l1 = paramBuffer.size - l;
      paramLong = paramBuffer.size;
      Segment segment = paramBuffer.head;
      while (true) {
        l2 = paramLong;
        l3 = l1;
        if (paramLong > paramBuffer.size - l) {
          segment = segment.prev;
          paramLong -= (segment.limit - segment.pos);
          continue;
        } 
        break;
      } 
      while (l2 < paramBuffer.size) {
        int i = (int)(segment.pos + l3 - l2);
        this.messageDigest.update(segment.data, i, segment.limit - i);
        l2 += (segment.limit - segment.pos);
        l3 = l2;
      } 
    } 
    return l;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\HashingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
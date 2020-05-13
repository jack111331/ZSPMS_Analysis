package okio;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashingSink extends ForwardingSink {
  private final MessageDigest messageDigest;
  
  private HashingSink(Sink paramSink, String paramString) {
    super(paramSink);
    try {
      this.messageDigest = MessageDigest.getInstance(paramString);
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError();
    } 
  }
  
  public static HashingSink md5(Sink paramSink) {
    return new HashingSink(paramSink, "MD5");
  }
  
  public static HashingSink sha1(Sink paramSink) {
    return new HashingSink(paramSink, "SHA-1");
  }
  
  public static HashingSink sha256(Sink paramSink) {
    return new HashingSink(paramSink, "SHA-256");
  }
  
  public ByteString hash() {
    return ByteString.of(this.messageDigest.digest());
  }
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    long l = 0L;
    for (Segment segment = paramBuffer.head; l < paramLong; segment = segment.next) {
      int i = (int)Math.min(paramLong - l, (segment.limit - segment.pos));
      this.messageDigest.update(segment.data, segment.pos, i);
      l += i;
    } 
    super.write(paramBuffer, paramLong);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\HashingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
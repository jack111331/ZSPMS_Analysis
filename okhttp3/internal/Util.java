package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

public final class Util {
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  
  public static final TimeZone UTC;
  
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  private static final Pattern VERIFY_AS_IP_ADDRESS;
  
  static {
    UTC = TimeZone.getTimeZone("GMT");
    VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  }
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3) {
    if ((paramLong2 | paramLong3) < 0L || paramLong2 > paramLong1 || paramLong1 - paramLong2 < paramLong3)
      throw new ArrayIndexOutOfBoundsException(); 
  }
  
  public static void closeAll(Closeable paramCloseable1, Closeable paramCloseable2) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokeinterface close : ()V
    //   8: aload_2
    //   9: astore_0
    //   10: aload_1
    //   11: invokeinterface close : ()V
    //   16: aload_0
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull -> 39
    //   22: return
    //   23: astore_0
    //   24: goto -> 10
    //   27: astore_2
    //   28: aload_0
    //   29: astore_1
    //   30: aload_0
    //   31: ifnonnull -> 18
    //   34: aload_2
    //   35: astore_1
    //   36: goto -> 18
    //   39: aload_1
    //   40: instanceof java/io/IOException
    //   43: ifeq -> 51
    //   46: aload_1
    //   47: checkcast java/io/IOException
    //   50: athrow
    //   51: aload_1
    //   52: instanceof java/lang/RuntimeException
    //   55: ifeq -> 63
    //   58: aload_1
    //   59: checkcast java/lang/RuntimeException
    //   62: athrow
    //   63: aload_1
    //   64: instanceof java/lang/Error
    //   67: ifeq -> 75
    //   70: aload_1
    //   71: checkcast java/lang/Error
    //   74: athrow
    //   75: new java/lang/AssertionError
    //   78: dup
    //   79: aload_1
    //   80: invokespecial <init> : (Ljava/lang/Object;)V
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	23	java/lang/Throwable
    //   10	16	27	java/lang/Throwable
  }
  
  public static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket) {
    if (paramServerSocket != null)
      try {
        paramServerSocket.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static void closeQuietly(Socket paramSocket) {
    if (paramSocket != null)
      try {
        paramSocket.close();
      } catch (AssertionError assertionError) {
        if (!isAndroidGetsocknameError(assertionError))
          throw assertionError; 
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static String[] concat(String[] paramArrayOfString, String paramString) {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[arrayOfString.length - 1] = paramString;
    return arrayOfString;
  }
  
  public static boolean contains(String[] paramArrayOfString, String paramString) {
    return Arrays.<String>asList(paramArrayOfString).contains(paramString);
  }
  
  private static boolean containsInvalidHostnameAsciiCodes(String paramString) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: invokevirtual length : ()I
    //   9: if_icmpge -> 58
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual charAt : (I)C
    //   17: istore_3
    //   18: iload_1
    //   19: istore #4
    //   21: iload_3
    //   22: bipush #31
    //   24: if_icmple -> 36
    //   27: iload_3
    //   28: bipush #127
    //   30: if_icmplt -> 39
    //   33: iload_1
    //   34: istore #4
    //   36: iload #4
    //   38: ireturn
    //   39: iload_1
    //   40: istore #4
    //   42: ldc ' #%/:?@[\]'
    //   44: iload_3
    //   45: invokevirtual indexOf : (I)I
    //   48: iconst_m1
    //   49: if_icmpne -> 36
    //   52: iinc #2, 1
    //   55: goto -> 4
    //   58: iconst_0
    //   59: istore #4
    //   61: goto -> 36
  }
  
  public static int delimiterOffset(String paramString, int paramInt1, int paramInt2, char paramChar) {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: if_icmpge -> 22
    //   5: aload_0
    //   6: iload_1
    //   7: invokevirtual charAt : (I)C
    //   10: iload_3
    //   11: if_icmpne -> 16
    //   14: iload_1
    //   15: ireturn
    //   16: iinc #1, 1
    //   19: goto -> 0
    //   22: iload_2
    //   23: istore_1
    //   24: goto -> 14
  }
  
  public static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2) {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: if_icmpge -> 26
    //   5: aload_3
    //   6: aload_0
    //   7: iload_1
    //   8: invokevirtual charAt : (I)C
    //   11: invokevirtual indexOf : (I)I
    //   14: iconst_m1
    //   15: if_icmpeq -> 20
    //   18: iload_1
    //   19: ireturn
    //   20: iinc #1, 1
    //   23: goto -> 0
    //   26: iload_2
    //   27: istore_1
    //   28: goto -> 18
  }
  
  public static boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit) {
    boolean bool;
    try {
      bool = skipAll(paramSource, paramInt, paramTimeUnit);
    } catch (IOException iOException) {
      bool = false;
    } 
    return bool;
  }
  
  public static String domainToAscii(String paramString) {
    try {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty())
        return null; 
      boolean bool = containsInvalidHostnameAsciiCodes(paramString);
      if (bool)
        paramString = null; 
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException = null;
    } 
    return (String)illegalArgumentException;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static String format(String paramString, Object... paramVarArgs) {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static String hostHeader(HttpUrl paramHttpUrl, boolean paramBoolean) {
    String str;
    if (paramHttpUrl.host().contains(":")) {
      str = "[" + paramHttpUrl.host() + "]";
    } else {
      str = paramHttpUrl.host();
    } 
    if (!paramBoolean) {
      String str1 = str;
      return (paramHttpUrl.port() != HttpUrl.defaultPort(paramHttpUrl.scheme())) ? (str + ":" + paramHttpUrl.port()) : str1;
    } 
    return str + ":" + paramHttpUrl.port();
  }
  
  public static <T> List<T> immutableList(List<T> paramList) {
    return Collections.unmodifiableList(new ArrayList<T>(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs) {
    return Collections.unmodifiableList(Arrays.asList((T[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> immutableMap(Map<K, V> paramMap) {
    return Collections.unmodifiableMap(new LinkedHashMap<K, V>(paramMap));
  }
  
  private static <T> List<T> intersect(T[] paramArrayOfT1, T[] paramArrayOfT2) {
    ArrayList<T> arrayList = new ArrayList();
    int i = paramArrayOfT1.length;
    byte b = 0;
    label15: while (b < i) {
      T t = paramArrayOfT1[b];
      int j = paramArrayOfT2.length;
      byte b1 = 0;
      while (true) {
        if (b1 < j) {
          T t1 = paramArrayOfT2[b1];
          if (t.equals(t1)) {
            arrayList.add(t1);
          } else {
            b1++;
            continue;
          } 
        } 
        b++;
        continue label15;
      } 
    } 
    return arrayList;
  }
  
  public static <T> T[] intersect(Class<T> paramClass, T[] paramArrayOfT1, T[] paramArrayOfT2) {
    List<T> list = intersect(paramArrayOfT1, paramArrayOfT2);
    return list.toArray((T[])Array.newInstance(paramClass, list.size()));
  }
  
  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError) {
    return (paramAssertionError.getCause() != null && paramAssertionError.getMessage() != null && paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static String md5Hex(String paramString) {
    try {
      return ByteString.of(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).hex();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    throw new AssertionError(unsupportedEncodingException);
  }
  
  public static ByteString sha1(ByteString paramByteString) {
    try {
      return ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramByteString.toByteArray()));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  public static ByteString sha256(ByteString paramByteString) {
    try {
      return ByteString.of(MessageDigest.getInstance("SHA-256").digest(paramByteString.toByteArray()));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  public static String shaBase64(String paramString) {
    try {
      return ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramString.getBytes("UTF-8"))).base64();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    throw new AssertionError(unsupportedEncodingException);
  }
  
  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit) throws IOException {
    long l2;
    long l1 = System.nanoTime();
    if (paramSource.timeout().hasDeadline()) {
      l2 = paramSource.timeout().deadlineNanoTime() - l1;
    } else {
      l2 = Long.MAX_VALUE;
    } 
    paramSource.timeout().deadlineNanoTime(Math.min(l2, paramTimeUnit.toNanos(paramInt)) + l1);
    try {
      Buffer buffer = new Buffer();
      this();
      while (paramSource.read(buffer, 8192L) != -1L)
        buffer.clear(); 
      return true;
    } catch (InterruptedIOException interruptedIOException) {
      return false;
    } finally {
      paramTimeUnit = null;
    } 
    throw paramTimeUnit;
  }
  
  public static int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: if_icmpge -> 68
    //   5: aload_0
    //   6: iload_1
    //   7: invokevirtual charAt : (I)C
    //   10: lookupswitch default -> 60, 9 -> 62, 10 -> 62, 12 -> 62, 13 -> 62, 32 -> 62
    //   60: iload_1
    //   61: ireturn
    //   62: iinc #1, 1
    //   65: goto -> 0
    //   68: iload_2
    //   69: istore_1
    //   70: goto -> 60
  }
  
  public static int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2) {
    paramInt2--;
    while (true) {
      int i = paramInt1;
      if (paramInt2 >= paramInt1) {
        switch (paramString.charAt(paramInt2)) {
          default:
            return paramInt2 + 1;
          case '\t':
          case '\n':
          case '\f':
          case '\r':
          case ' ':
            break;
        } 
      } else {
        return i;
      } 
      paramInt2--;
    } 
  }
  
  public static ThreadFactory threadFactory(final String name, final boolean daemon) {
    return new ThreadFactory() {
        public Thread newThread(Runnable param1Runnable) {
          param1Runnable = new Thread(param1Runnable, name);
          param1Runnable.setDaemon(daemon);
          return (Thread)param1Runnable;
        }
      };
  }
  
  public static String toHumanReadableAscii(String paramString) {
    String str;
    int i = 0;
    int j = paramString.length();
    while (true) {
      str = paramString;
      if (i < j) {
        int k = paramString.codePointAt(i);
        if (k > 31 && k < 127) {
          i += Character.charCount(k);
          continue;
        } 
        Buffer buffer = new Buffer();
        buffer.writeUtf8(paramString, 0, i);
        while (i < j) {
          int m = paramString.codePointAt(i);
          if (m > 31 && m < 127) {
            k = m;
          } else {
            k = 63;
          } 
          buffer.writeUtf8CodePoint(k);
          i += Character.charCount(m);
        } 
        str = buffer.readUtf8();
      } 
      break;
    } 
    return str;
  }
  
  public static String trimSubstring(String paramString, int paramInt1, int paramInt2) {
    paramInt1 = skipLeadingAsciiWhitespace(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, skipTrailingAsciiWhitespace(paramString, paramInt1, paramInt2));
  }
  
  public static boolean verifyAsIpAddress(String paramString) {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
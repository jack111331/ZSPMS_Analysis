package com.qiniu.android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Etag {
  public static String data(byte[] paramArrayOfbyte) {
    return data(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static String data(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new java/io/ByteArrayInputStream
    //   5: astore #4
    //   7: aload #4
    //   9: aload_0
    //   10: iload_1
    //   11: iload_2
    //   12: invokespecial <init> : ([BII)V
    //   15: iload_2
    //   16: i2l
    //   17: lstore #5
    //   19: aload #4
    //   21: astore_0
    //   22: aload #4
    //   24: lload #5
    //   26: invokestatic stream : (Ljava/io/InputStream;J)Ljava/lang/String;
    //   29: astore_3
    //   30: aload #4
    //   32: invokevirtual close : ()V
    //   35: goto -> 43
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual printStackTrace : ()V
    //   43: aload_3
    //   44: areturn
    //   45: astore_3
    //   46: goto -> 60
    //   49: astore_0
    //   50: aload_3
    //   51: astore #4
    //   53: goto -> 93
    //   56: astore_3
    //   57: aconst_null
    //   58: astore #4
    //   60: aload #4
    //   62: astore_0
    //   63: aload_3
    //   64: invokevirtual printStackTrace : ()V
    //   67: aload #4
    //   69: ifnull -> 85
    //   72: aload #4
    //   74: invokevirtual close : ()V
    //   77: goto -> 85
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual printStackTrace : ()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_3
    //   88: aload_0
    //   89: astore #4
    //   91: aload_3
    //   92: astore_0
    //   93: aload #4
    //   95: ifnull -> 113
    //   98: aload #4
    //   100: invokevirtual close : ()V
    //   103: goto -> 113
    //   106: astore #4
    //   108: aload #4
    //   110: invokevirtual printStackTrace : ()V
    //   113: aload_0
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	56	java/io/IOException
    //   2	15	49	finally
    //   22	30	45	java/io/IOException
    //   22	30	87	finally
    //   30	35	38	java/lang/Exception
    //   63	67	87	finally
    //   72	77	80	java/lang/Exception
    //   98	103	106	java/lang/Exception
  }
  
  public static String file(File paramFile) throws IOException {
    FileInputStream fileInputStream = null;
    try {
      FileInputStream fileInputStream1 = new FileInputStream();
      this(paramFile);
      try {
        return stream(fileInputStream1, paramFile.length());
      } finally {
        paramFile = null;
      } 
    } finally {}
    if (fileInputStream != null)
      try {
        fileInputStream.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    throw paramFile;
  }
  
  public static String file(String paramString) throws IOException {
    return file(new File(paramString));
  }
  
  private static byte[] oneBlock(byte[] paramArrayOfbyte, InputStream paramInputStream, int paramInt) throws IOException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
      int i = paramArrayOfbyte.length;
      while (paramInt != 0) {
        int j;
        if (i > paramInt) {
          j = paramInt;
        } else {
          j = i;
        } 
        paramInputStream.read(paramArrayOfbyte, 0, j);
        messageDigest.update(paramArrayOfbyte, 0, j);
        paramInt -= j;
      } 
      return messageDigest.digest();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      return null;
    } 
  }
  
  private static String resultEncode(byte[][] paramArrayOfbyte) {
    MessageDigest messageDigest1;
    MessageDigest messageDigest2;
    byte b;
    byte[] arrayOfByte1 = paramArrayOfbyte[0];
    int i = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[i + 1];
    if (paramArrayOfbyte.length != 1) {
      try {
        messageDigest2 = MessageDigest.getInstance("sha-1");
        int j = paramArrayOfbyte.length;
        for (b = 0; b < j; b++)
          messageDigest2.update(paramArrayOfbyte[b]); 
        byte[] arrayOfByte = messageDigest2.digest();
        b = -106;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        noSuchAlgorithmException.printStackTrace();
        return null;
      } 
    } else {
      b = 22;
      messageDigest1 = messageDigest2;
    } 
    arrayOfByte2[0] = (byte)b;
    System.arraycopy(messageDigest1, 0, arrayOfByte2, 1, i);
    return UrlSafeBase64.encodeToString(arrayOfByte2);
  }
  
  public static String stream(InputStream paramInputStream, long paramLong) throws IOException {
    if (paramLong == 0L)
      return "Fto5o-5ea0sNMlW_75VgGJCv2AcJ"; 
    byte[] arrayOfByte = new byte[65536];
    byte[][] arrayOfByte1 = new byte[(int)((paramLong + 4194304L - 1L) / 4194304L)][];
    for (byte b = 0; b < arrayOfByte1.length; b++) {
      long l1 = paramLong - b * 4194304L;
      long l2 = l1;
      if (l1 > 4194304L)
        l2 = 4194304L; 
      arrayOfByte1[b] = oneBlock(arrayOfByte, paramInputStream, (int)l2);
    } 
    return resultEncode(arrayOfByte1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\Etag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
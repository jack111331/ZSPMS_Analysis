package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

public final class a {
  private static final j a = new j(101010256L);
  
  private static final k b = new k(38651);
  
  public static String a(File paramFile) throws IOException {
    return a(paramFile, "channelNo");
  }
  
  public static String a(File paramFile, String paramString) throws IOException {
    byte[] arrayOfByte = null;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      this(paramFile, "r");
    } finally {
      paramString = null;
    } 
    if (paramFile != null)
      paramFile.close(); 
    throw paramString;
  }
  
  private static byte[] a(RandomAccessFile paramRandomAccessFile) throws IOException {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual length : ()J
    //   6: ldc2_w 22
    //   9: lsub
    //   10: lstore_2
    //   11: aload_0
    //   12: lload_2
    //   13: invokevirtual seek : (J)V
    //   16: getstatic com/tencent/open/utils/a.a : Lcom/tencent/open/utils/j;
    //   19: invokevirtual a : ()[B
    //   22: astore #4
    //   24: aload_0
    //   25: invokevirtual read : ()I
    //   28: istore #5
    //   30: iload #5
    //   32: iconst_m1
    //   33: if_icmpeq -> 180
    //   36: iload #5
    //   38: aload #4
    //   40: iconst_0
    //   41: baload
    //   42: if_icmpne -> 96
    //   45: aload_0
    //   46: invokevirtual read : ()I
    //   49: aload #4
    //   51: iconst_1
    //   52: baload
    //   53: if_icmpne -> 96
    //   56: aload_0
    //   57: invokevirtual read : ()I
    //   60: aload #4
    //   62: iconst_2
    //   63: baload
    //   64: if_icmpne -> 96
    //   67: aload_0
    //   68: invokevirtual read : ()I
    //   71: aload #4
    //   73: iconst_3
    //   74: baload
    //   75: if_icmpne -> 96
    //   78: iload_1
    //   79: istore #5
    //   81: iload #5
    //   83: ifne -> 114
    //   86: new java/util/zip/ZipException
    //   89: dup
    //   90: ldc 'archive is not a ZIP archive'
    //   92: invokespecial <init> : (Ljava/lang/String;)V
    //   95: athrow
    //   96: lload_2
    //   97: lconst_1
    //   98: lsub
    //   99: lstore_2
    //   100: aload_0
    //   101: lload_2
    //   102: invokevirtual seek : (J)V
    //   105: aload_0
    //   106: invokevirtual read : ()I
    //   109: istore #5
    //   111: goto -> 30
    //   114: aload_0
    //   115: ldc2_w 16
    //   118: lload_2
    //   119: ladd
    //   120: ldc2_w 4
    //   123: ladd
    //   124: invokevirtual seek : (J)V
    //   127: iconst_2
    //   128: newarray byte
    //   130: astore #4
    //   132: aload_0
    //   133: aload #4
    //   135: invokevirtual readFully : ([B)V
    //   138: new com/tencent/open/utils/k
    //   141: dup
    //   142: aload #4
    //   144: invokespecial <init> : ([B)V
    //   147: invokevirtual b : ()I
    //   150: istore #5
    //   152: iload #5
    //   154: ifne -> 161
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_0
    //   160: areturn
    //   161: iload #5
    //   163: newarray byte
    //   165: astore #4
    //   167: aload_0
    //   168: aload #4
    //   170: invokevirtual read : ([B)I
    //   173: pop
    //   174: aload #4
    //   176: astore_0
    //   177: goto -> 159
    //   180: iconst_0
    //   181: istore #5
    //   183: goto -> 81
  }
  
  private static class a {
    Properties a = new Properties();
    
    byte[] b;
    
    private a() {}
    
    void a(byte[] param1ArrayOfbyte) throws IOException {
      if (param1ArrayOfbyte != null) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(param1ArrayOfbyte);
        int i = (a.a().a()).length;
        byte[] arrayOfByte = new byte[i];
        byteBuffer.get(arrayOfByte);
        if (!a.a().equals(new k(arrayOfByte)))
          throw new ProtocolException("unknow protocl [" + Arrays.toString(param1ArrayOfbyte) + "]"); 
        if (param1ArrayOfbyte.length - i > 2) {
          arrayOfByte = new byte[2];
          byteBuffer.get(arrayOfByte);
          int j = (new k(arrayOfByte)).b();
          if (param1ArrayOfbyte.length - i - 2 >= j) {
            arrayOfByte = new byte[j];
            byteBuffer.get(arrayOfByte);
            this.a.load(new ByteArrayInputStream(arrayOfByte));
            j = param1ArrayOfbyte.length - i - j - 2;
            if (j > 0) {
              this.b = new byte[j];
              byteBuffer.get(this.b);
            } 
          } 
        } 
      } 
    }
    
    public String toString() {
      return "ApkExternalInfo [p=" + this.a + ", otherData=" + Arrays.toString(this.b) + "]";
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
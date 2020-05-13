package com.unionpay.mobile.android.pboctransaction.nfc;

import android.nfc.tech.IsoDep;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class b {
  public static final byte[] a = new byte[] { 0 };
  
  protected byte[] b;
  
  protected b(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = paramArrayOfbyte;
    if (paramArrayOfbyte == null)
      arrayOfByte = a; 
    this.b = arrayOfByte;
  }
  
  public byte[] a() {
    return this.b;
  }
  
  public String toString() {
    return c.a(this.b, this.b.length);
  }
  
  public static final class a extends b {
    public static final byte[] c = new byte[0];
    
    public static final byte[] d = new byte[] { 111, 0 };
    
    public a(byte[] param1ArrayOfbyte) {
      // Byte code:
      //   0: aload_1
      //   1: ifnull -> 12
      //   4: aload_1
      //   5: astore_2
      //   6: aload_1
      //   7: arraylength
      //   8: iconst_2
      //   9: if_icmpge -> 16
      //   12: getstatic com/unionpay/mobile/android/pboctransaction/nfc/b$a.d : [B
      //   15: astore_2
      //   16: aload_0
      //   17: aload_2
      //   18: invokespecial <init> : ([B)V
      //   21: return
    }
    
    public final byte[] a() {
      return b() ? Arrays.copyOfRange(this.b, 0, this.b.length - 2) : c;
    }
    
    public final boolean b() {
      byte[] arrayOfByte = this.b;
      int i = arrayOfByte.length;
      byte b1 = arrayOfByte[i - 2];
      return ((short)(arrayOfByte[i - 1] & 0xFF | b1 << 8) == -28672);
    }
  }
  
  public static final class b {
    private final IsoDep a;
    
    public b(IsoDep param1IsoDep) {
      this.a = param1IsoDep;
    }
    
    public static String c(byte[] param1ArrayOfbyte) {
      String str = "";
      for (byte b1 = 0; b1 < param1ArrayOfbyte.length; b1++) {
        String str1 = Integer.toHexString(param1ArrayOfbyte[b1] & 0xFF);
        String str2 = str1;
        if (str1.length() == 1)
          str2 = "0" + str1; 
        str = str + str2.toUpperCase() + " ";
      } 
      return str;
    }
    
    public final b.a a(byte... param1VarArgs) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(param1VarArgs.length + 6);
      byteBuffer.put((byte)0).put((byte)-92).put((byte)4).put((byte)0).put((byte)param1VarArgs.length).put(param1VarArgs).put((byte)0);
      Log.e("PBOC Transceive", c(byteBuffer.array()));
      b.a a = new b.a(b(byteBuffer.array()));
      Log.e("PBOC receive", c(a.a()));
      return a;
    }
    
    public final void a() {
      try {
        this.a.connect();
      } catch (Exception exception) {}
    }
    
    public final byte[] b(byte[] param1ArrayOfbyte) {
      byte[] arrayOfByte;
      try {
        param1ArrayOfbyte = this.a.transceive(param1ArrayOfbyte);
      } catch (Exception exception) {
        arrayOfByte = b.a.d;
      } 
      return arrayOfByte;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\nfc\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
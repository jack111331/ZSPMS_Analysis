package com.herosdk.d;

class c {
  static int a = 32;
  
  static byte[] a(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    int j = a - i % a;
    int k = j;
    if (j == 0)
      k = a; 
    byte b = (byte)(k & 0xFF);
    byte[] arrayOfByte1 = new byte[k];
    for (j = 0; j < k; j++)
      arrayOfByte1[j] = (byte)b; 
    byte[] arrayOfByte2 = new byte[i + k];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte2, 0, i);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, k);
    return arrayOfByte2;
  }
  
  static byte[] b(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: arraylength
    //   3: iconst_1
    //   4: isub
    //   5: baload
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmplt -> 21
    //   12: iload_1
    //   13: istore_2
    //   14: iload_1
    //   15: getstatic com/herosdk/d/c.a : I
    //   18: if_icmple -> 23
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_0
    //   24: astore_3
    //   25: iload_2
    //   26: ifle -> 39
    //   29: aload_0
    //   30: iconst_0
    //   31: aload_0
    //   32: arraylength
    //   33: iload_2
    //   34: isub
    //   35: invokestatic copyOfRange : ([BII)[B
    //   38: astore_3
    //   39: aload_3
    //   40: areturn
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
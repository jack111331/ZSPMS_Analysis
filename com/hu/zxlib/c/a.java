package com.hu.zxlib.c;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

public class a extends LuminanceSource {
  private byte[] a;
  
  public a(Bitmap paramBitmap) {
    super(paramBitmap.getWidth(), paramBitmap.getHeight());
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    this.a = new byte[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, getWidth(), 0, 0, getWidth(), getHeight());
    for (byte b = 0; b < arrayOfInt.length; b++)
      this.a[b] = (byte)(byte)arrayOfInt[b]; 
  }
  
  public byte[] getMatrix() {
    return this.a;
  }
  
  public byte[] getRow(int paramInt, byte[] paramArrayOfbyte) {
    System.arraycopy(this.a, paramInt * getWidth(), paramArrayOfbyte, 0, getWidth());
    return paramArrayOfbyte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;

final class DecodedBitStreamParser {
  private static final char ECI = '￺';
  
  private static final char FS = '\034';
  
  private static final char GS = '\035';
  
  private static final char LATCHA = '￷';
  
  private static final char LATCHB = '￸';
  
  private static final char LOCK = '￹';
  
  private static final char NS = '￻';
  
  private static final char PAD = '￼';
  
  private static final char RS = '\036';
  
  private static final String[] SETS = new String[] { "\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\034\035\036￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\034\035\036￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\034\035\036ÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\034\035\036￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032￺￼￼\033￻\034\035\036\037 ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?" };
  
  private static final char SHIFTA = '￰';
  
  private static final char SHIFTB = '￱';
  
  private static final char SHIFTC = '￲';
  
  private static final char SHIFTD = '￳';
  
  private static final char SHIFTE = '￴';
  
  private static final char THREESHIFTA = '￶';
  
  private static final char TWOSHIFTA = '￵';
  
  static DecoderResult decode(byte[] paramArrayOfbyte, int paramInt) {
    String str1;
    StringBuilder stringBuilder1 = new StringBuilder(144);
    switch (paramInt) {
      default:
        return new DecoderResult(paramArrayOfbyte, stringBuilder1.toString(), null, String.valueOf(paramInt));
      case 5:
        stringBuilder1.append(getMessage(paramArrayOfbyte, 1, 77));
      case 4:
        stringBuilder1.append(getMessage(paramArrayOfbyte, 1, 93));
      case 2:
      case 3:
        break;
    } 
    if (paramInt == 2) {
      int i = getPostCode2(paramArrayOfbyte);
      str1 = (new DecimalFormat("0000000000".substring(0, getPostCode2Length(paramArrayOfbyte)))).format(i);
    } else {
      str1 = getPostCode3(paramArrayOfbyte);
    } 
    DecimalFormat decimalFormat = new DecimalFormat("000");
    String str3 = decimalFormat.format(getCountry(paramArrayOfbyte));
    String str2 = decimalFormat.format(getServiceClass(paramArrayOfbyte));
    stringBuilder1.append(getMessage(paramArrayOfbyte, 10, 84));
    if (stringBuilder1.toString().startsWith("[)>\03601\035")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append('\035');
      stringBuilder.append(str3);
      stringBuilder.append('\035');
      stringBuilder.append(str2);
      stringBuilder.append('\035');
      stringBuilder1.insert(9, stringBuilder.toString());
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append('\035');
    stringBuilder2.append(str3);
    stringBuilder2.append('\035');
    stringBuilder2.append(str2);
    stringBuilder2.append('\035');
    stringBuilder1.insert(0, stringBuilder2.toString());
  }
  
  private static int getBit(int paramInt, byte[] paramArrayOfbyte) {
    return ((1 << 5 - --paramInt % 6 & paramArrayOfbyte[paramInt / 6]) == 0) ? 0 : 1;
  }
  
  private static int getCountry(byte[] paramArrayOfbyte) {
    return getInt(paramArrayOfbyte, new byte[] { 53, 54, 43, 44, 45, 46, 47, 48, 37, 38 });
  }
  
  private static int getInt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte2.length != 0) {
      byte b = 0;
      int i = 0;
      while (b < paramArrayOfbyte2.length) {
        i += getBit(paramArrayOfbyte2[b], paramArrayOfbyte1) << paramArrayOfbyte2.length - b - 1;
        b++;
      } 
      return i;
    } 
    throw new IllegalArgumentException();
  }
  
  private static String getMessage(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramInt1;
    int j = 0;
    byte b = -1;
    int k;
    for (k = 0; i < paramInt1 + paramInt2; k = m) {
      byte b1;
      byte b2;
      byte b3;
      byte b4;
      char c = SETS[j].charAt(paramArrayOfbyte[i]);
      int m = j;
      switch (c) {
        default:
          stringBuilder.append(c);
          m = k;
          break;
        case '￻':
          m = paramArrayOfbyte[++i];
          b1 = paramArrayOfbyte[++i];
          b2 = paramArrayOfbyte[++i];
          b3 = paramArrayOfbyte[++i];
          b4 = paramArrayOfbyte[++i];
          stringBuilder.append((new DecimalFormat("000000000")).format(((m << 24) + (b1 << 18) + (b2 << 12) + (b3 << 6) + b4)));
          m = k;
          break;
        case '￸':
          m = 1;
        case '￷':
          m = 0;
        case '￹':
          b = -1;
          j = m;
          m = k;
          break;
        case '￶':
          b = 3;
          m = j;
          j = 0;
          break;
        case '￵':
          b = 2;
          m = j;
          j = 0;
          break;
        case '￰':
        case '￱':
        case '￲':
        case '￳':
        case '￴':
          k = c - 65520;
          b = 1;
          m = j;
          j = k;
          break;
      } 
      if (b == 0)
        j = m; 
      i++;
      b--;
    } 
    while (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '￼')
      stringBuilder.setLength(stringBuilder.length() - 1); 
    return stringBuilder.toString();
  }
  
  private static int getPostCode2(byte[] paramArrayOfbyte) {
    return getInt(paramArrayOfbyte, new byte[] { 
          33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 
          19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 
          17, 18, 7, 8, 9, 10, 11, 12, 1, 2 });
  }
  
  private static int getPostCode2Length(byte[] paramArrayOfbyte) {
    return getInt(paramArrayOfbyte, new byte[] { 39, 40, 41, 42, 31, 32 });
  }
  
  private static String getPostCode3(byte[] paramArrayOfbyte) {
    return String.valueOf(new char[] { SETS[0].charAt(getInt(paramArrayOfbyte, new byte[] { 39, 40, 41, 42, 31, 32 })), SETS[0].charAt(getInt(paramArrayOfbyte, new byte[] { 33, 34, 35, 36, 25, 26 })), SETS[0].charAt(getInt(paramArrayOfbyte, new byte[] { 27, 28, 29, 30, 19, 20 })), SETS[0].charAt(getInt(paramArrayOfbyte, new byte[] { 21, 22, 23, 24, 13, 14 })), SETS[0].charAt(getInt(paramArrayOfbyte, new byte[] { 15, 16, 17, 18, 7, 8 })), SETS[0].charAt(getInt(paramArrayOfbyte, new byte[] { 9, 10, 11, 12, 1, 2 })) });
  }
  
  private static int getServiceClass(byte[] paramArrayOfbyte) {
    return getInt(paramArrayOfbyte, new byte[] { 55, 56, 57, 58, 59, 60, 49, 50, 51, 52 });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\maxicode\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
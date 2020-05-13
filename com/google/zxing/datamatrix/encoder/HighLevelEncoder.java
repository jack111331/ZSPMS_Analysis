package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

public final class HighLevelEncoder {
  static final int ASCII_ENCODATION = 0;
  
  static final int BASE256_ENCODATION = 5;
  
  static final int C40_ENCODATION = 1;
  
  static final char C40_UNLATCH = 'þ';
  
  static final int EDIFACT_ENCODATION = 4;
  
  static final char LATCH_TO_ANSIX12 = 'î';
  
  static final char LATCH_TO_BASE256 = 'ç';
  
  static final char LATCH_TO_C40 = 'æ';
  
  static final char LATCH_TO_EDIFACT = 'ð';
  
  static final char LATCH_TO_TEXT = 'ï';
  
  private static final char MACRO_05 = 'ì';
  
  private static final String MACRO_05_HEADER = "[)>\03605\035";
  
  private static final char MACRO_06 = 'í';
  
  private static final String MACRO_06_HEADER = "[)>\03606\035";
  
  private static final String MACRO_TRAILER = "\036\004";
  
  private static final char PAD = '';
  
  static final int TEXT_ENCODATION = 2;
  
  static final char UPPER_SHIFT = 'ë';
  
  static final int X12_ENCODATION = 3;
  
  static final char X12_UNLATCH = 'þ';
  
  public static int determineConsecutiveDigitCount(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    int j = 0;
    int k = 0;
    if (paramInt < i) {
      j = paramCharSequence.charAt(paramInt);
      int m = paramInt;
      int n = j;
      paramInt = k;
      while (true) {
        j = paramInt;
        if (isDigit(n)) {
          j = paramInt;
          if (m < i) {
            j = paramInt + 1;
            k = m + 1;
            paramInt = j;
            m = k;
            if (k < i) {
              m = paramCharSequence.charAt(k);
              paramInt = j;
              n = m;
              m = k;
            } 
            continue;
          } 
        } 
        break;
      } 
    } 
    return j;
  }
  
  public static String encodeHighLevel(String paramString) {
    return encodeHighLevel(paramString, SymbolShapeHint.FORCE_NONE, null, null);
  }
  
  public static String encodeHighLevel(String paramString, SymbolShapeHint paramSymbolShapeHint, Dimension paramDimension1, Dimension paramDimension2) {
    int j;
    ASCIIEncoder aSCIIEncoder = new ASCIIEncoder();
    int i = 0;
    C40Encoder c40Encoder = new C40Encoder();
    TextEncoder textEncoder = new TextEncoder();
    X12Encoder x12Encoder = new X12Encoder();
    EdifactEncoder edifactEncoder = new EdifactEncoder();
    Base256Encoder base256Encoder = new Base256Encoder();
    EncoderContext encoderContext = new EncoderContext(paramString);
    encoderContext.setSymbolShape(paramSymbolShapeHint);
    encoderContext.setSizeConstraints(paramDimension1, paramDimension2);
    if (paramString.startsWith("[)>\03605\035") && paramString.endsWith("\036\004")) {
      encoderContext.writeCodeword('ì');
      encoderContext.setSkipAtEnd(2);
      encoderContext.pos += 7;
      j = i;
    } else {
      j = i;
      if (paramString.startsWith("[)>\03606\035")) {
        j = i;
        if (paramString.endsWith("\036\004")) {
          encoderContext.writeCodeword('í');
          encoderContext.setSkipAtEnd(2);
          encoderContext.pos += 7;
          j = i;
        } 
      } 
    } 
    while (encoderContext.hasMoreCharacters()) {
      (new Encoder[6])[0] = aSCIIEncoder;
      (new Encoder[6])[1] = c40Encoder;
      (new Encoder[6])[2] = textEncoder;
      (new Encoder[6])[3] = x12Encoder;
      (new Encoder[6])[4] = edifactEncoder;
      (new Encoder[6])[5] = base256Encoder;
      (new Encoder[6])[j].encode(encoderContext);
      if (encoderContext.getNewEncoding() >= 0) {
        j = encoderContext.getNewEncoding();
        encoderContext.resetEncoderSignal();
      } 
    } 
    int k = encoderContext.getCodewordCount();
    encoderContext.updateSymbolInfo();
    i = encoderContext.getSymbolInfo().getDataCapacity();
    if (k < i && j != 0 && j != 5 && j != 4)
      encoderContext.writeCodeword('þ'); 
    StringBuilder stringBuilder = encoderContext.getCodewords();
    if (stringBuilder.length() < i)
      stringBuilder.append(''); 
    while (stringBuilder.length() < i)
      stringBuilder.append(randomize253State('', stringBuilder.length() + 1)); 
    return encoderContext.getCodewords().toString();
  }
  
  private static int findMinimums(float[] paramArrayOffloat, int[] paramArrayOfint, int paramInt, byte[] paramArrayOfbyte) {
    Arrays.fill(paramArrayOfbyte, (byte)0);
    int i = paramInt;
    paramInt = 0;
    while (paramInt < 6) {
      paramArrayOfint[paramInt] = (int)Math.ceil(paramArrayOffloat[paramInt]);
      int j = paramArrayOfint[paramInt];
      int k = i;
      if (i > j) {
        Arrays.fill(paramArrayOfbyte, (byte)0);
        k = j;
      } 
      if (k == j)
        paramArrayOfbyte[paramInt] = (byte)(byte)(paramArrayOfbyte[paramInt] + 1); 
      paramInt++;
      i = k;
    } 
    return i;
  }
  
  private static int getMinimumCount(byte[] paramArrayOfbyte) {
    byte b = 0;
    int i = 0;
    while (b < 6) {
      i += paramArrayOfbyte[b];
      b++;
    } 
    return i;
  }
  
  static void illegalCharacter(char paramChar) {
    String str1 = Integer.toHexString(paramChar);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("0000".substring(0, 4 - str1.length()));
    stringBuilder2.append(str1);
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder("Illegal character: ");
    stringBuilder1.append(paramChar);
    stringBuilder1.append(" (0x");
    stringBuilder1.append(str2);
    stringBuilder1.append(')');
    throw new IllegalArgumentException(stringBuilder1.toString());
  }
  
  static boolean isDigit(char paramChar) {
    return (paramChar >= '0' && paramChar <= '9');
  }
  
  static boolean isExtendedASCII(char paramChar) {
    return (paramChar >= '' && paramChar <= 'ÿ');
  }
  
  private static boolean isNativeC40(char paramChar) {
    return (paramChar == ' ' || (paramChar >= '0' && paramChar <= '9') || (paramChar >= 'A' && paramChar <= 'Z'));
  }
  
  private static boolean isNativeEDIFACT(char paramChar) {
    return (paramChar >= ' ' && paramChar <= '^');
  }
  
  private static boolean isNativeText(char paramChar) {
    return (paramChar == ' ' || (paramChar >= '0' && paramChar <= '9') || (paramChar >= 'a' && paramChar <= 'z'));
  }
  
  private static boolean isNativeX12(char paramChar) {
    return (isX12TermSep(paramChar) || paramChar == ' ' || (paramChar >= '0' && paramChar <= '9') || (paramChar >= 'A' && paramChar <= 'Z'));
  }
  
  private static boolean isSpecialB256(char paramChar) {
    return false;
  }
  
  private static boolean isX12TermSep(char paramChar) {
    return (paramChar == '\r' || paramChar == '*' || paramChar == '>');
  }
  
  static int lookAheadTest(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    float[] arrayOfFloat;
    if (paramInt1 >= paramCharSequence.length())
      return paramInt2; 
    if (paramInt2 == 0) {
      arrayOfFloat = new float[6];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 1.0F;
      arrayOfFloat[2] = 1.0F;
      arrayOfFloat[3] = 1.0F;
      arrayOfFloat[4] = 1.0F;
      arrayOfFloat[5] = 1.25F;
    } else {
      arrayOfFloat = new float[6];
      arrayOfFloat[0] = 1.0F;
      arrayOfFloat[1] = 2.0F;
      arrayOfFloat[2] = 2.0F;
      arrayOfFloat[3] = 2.0F;
      arrayOfFloat[4] = 2.0F;
      arrayOfFloat[5] = 2.25F;
      arrayOfFloat[paramInt2] = 0.0F;
    } 
    paramInt2 = 0;
    while (true) {
      int[] arrayOfInt;
      int i = paramInt1 + paramInt2;
      if (i == paramCharSequence.length()) {
        byte[] arrayOfByte = new byte[6];
        arrayOfInt = new int[6];
        paramInt2 = findMinimums(arrayOfFloat, arrayOfInt, 2147483647, arrayOfByte);
        paramInt1 = getMinimumCount(arrayOfByte);
        return (arrayOfInt[0] == paramInt2) ? 0 : ((paramInt1 == 1 && arrayOfByte[5] > 0) ? 5 : ((paramInt1 == 1 && arrayOfByte[4] > 0) ? 4 : ((paramInt1 == 1 && arrayOfByte[2] > 0) ? 2 : ((paramInt1 == 1 && arrayOfByte[3] > 0) ? 3 : 1))));
      } 
      char c = arrayOfInt.charAt(i);
      i = paramInt2 + 1;
      if (isDigit(c)) {
        arrayOfFloat[0] = arrayOfFloat[0] + 0.5F;
      } else if (isExtendedASCII(c)) {
        arrayOfFloat[0] = (float)Math.ceil(arrayOfFloat[0]);
        arrayOfFloat[0] = arrayOfFloat[0] + 2.0F;
      } else {
        arrayOfFloat[0] = (float)Math.ceil(arrayOfFloat[0]);
        arrayOfFloat[0] = arrayOfFloat[0] + 1.0F;
      } 
      if (isNativeC40(c)) {
        arrayOfFloat[1] = arrayOfFloat[1] + 0.6666667F;
      } else if (isExtendedASCII(c)) {
        arrayOfFloat[1] = arrayOfFloat[1] + 2.6666667F;
      } else {
        arrayOfFloat[1] = arrayOfFloat[1] + 1.3333334F;
      } 
      if (isNativeText(c)) {
        arrayOfFloat[2] = arrayOfFloat[2] + 0.6666667F;
      } else if (isExtendedASCII(c)) {
        arrayOfFloat[2] = arrayOfFloat[2] + 2.6666667F;
      } else {
        arrayOfFloat[2] = arrayOfFloat[2] + 1.3333334F;
      } 
      if (isNativeX12(c)) {
        arrayOfFloat[3] = arrayOfFloat[3] + 0.6666667F;
      } else if (isExtendedASCII(c)) {
        arrayOfFloat[3] = arrayOfFloat[3] + 4.3333335F;
      } else {
        arrayOfFloat[3] = arrayOfFloat[3] + 3.3333333F;
      } 
      if (isNativeEDIFACT(c)) {
        arrayOfFloat[4] = arrayOfFloat[4] + 0.75F;
      } else if (isExtendedASCII(c)) {
        arrayOfFloat[4] = arrayOfFloat[4] + 4.25F;
      } else {
        arrayOfFloat[4] = arrayOfFloat[4] + 3.25F;
      } 
      if (isSpecialB256(c)) {
        arrayOfFloat[5] = arrayOfFloat[5] + 4.0F;
      } else {
        arrayOfFloat[5] = arrayOfFloat[5] + 1.0F;
      } 
      paramInt2 = i;
      if (i >= 4) {
        int[] arrayOfInt1 = new int[6];
        byte[] arrayOfByte = new byte[6];
        findMinimums(arrayOfFloat, arrayOfInt1, 2147483647, arrayOfByte);
        paramInt2 = getMinimumCount(arrayOfByte);
        if (arrayOfInt1[0] < arrayOfInt1[5] && arrayOfInt1[0] < arrayOfInt1[1] && arrayOfInt1[0] < arrayOfInt1[2] && arrayOfInt1[0] < arrayOfInt1[3] && arrayOfInt1[0] < arrayOfInt1[4])
          return 0; 
        if (arrayOfInt1[5] < arrayOfInt1[0] || arrayOfByte[1] + arrayOfByte[2] + arrayOfByte[3] + arrayOfByte[4] == 0)
          break; 
        if (paramInt2 == 1 && arrayOfByte[4] > 0)
          return 4; 
        if (paramInt2 == 1 && arrayOfByte[2] > 0)
          return 2; 
        if (paramInt2 == 1 && arrayOfByte[3] > 0)
          return 3; 
        paramInt2 = i;
        if (arrayOfInt1[1] + 1 < arrayOfInt1[0]) {
          paramInt2 = i;
          if (arrayOfInt1[1] + 1 < arrayOfInt1[5]) {
            paramInt2 = i;
            if (arrayOfInt1[1] + 1 < arrayOfInt1[4]) {
              paramInt2 = i;
              if (arrayOfInt1[1] + 1 < arrayOfInt1[2]) {
                if (arrayOfInt1[1] < arrayOfInt1[3])
                  return 1; 
                paramInt2 = i;
                if (arrayOfInt1[1] == arrayOfInt1[3]) {
                  paramInt1 = paramInt1 + i + 1;
                  while (paramInt1 < arrayOfInt.length()) {
                    c = arrayOfInt.charAt(paramInt1);
                    if (isX12TermSep(c))
                      return 3; 
                    if (isNativeX12(c))
                      paramInt1++; 
                  } 
                  return 1;
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return 5;
  }
  
  private static char randomize253State(char paramChar, int paramInt) {
    int i = paramChar + paramInt * 149 % 253 + 1;
    if (i > 254)
      i -= 254; 
    return (char)i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
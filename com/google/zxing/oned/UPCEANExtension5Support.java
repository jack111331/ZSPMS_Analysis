package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension5Support {
  private static final int[] CHECK_DIGIT_ENCODINGS = new int[] { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  
  private final int[] decodeMiddleCounters = new int[4];
  
  private final StringBuilder decodeRowStringBuffer = new StringBuilder();
  
  private int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfint[1];
    int k = 0;
    int m;
    for (m = 0; k < 5 && j < i; m = i2) {
      int n = UPCEANReader.decodeDigit(paramBitArray, arrayOfInt, j, UPCEANReader.L_AND_G_PATTERNS);
      paramStringBuilder.append((char)(n % 10 + 48));
      int i1 = arrayOfInt.length;
      int i2;
      for (i2 = 0; i2 < i1; i2++)
        j += arrayOfInt[i2]; 
      i2 = m;
      if (n >= 10)
        i2 = m | 1 << 4 - k; 
      if (k != 4)
        j = paramBitArray.getNextUnset(paramBitArray.getNextSet(j)); 
      k++;
    } 
    if (paramStringBuilder.length() == 5) {
      k = determineCheckDigit(m);
      if (extensionChecksum(paramStringBuilder.toString()) == k)
        return j; 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int determineCheckDigit(int paramInt) throws NotFoundException {
    for (byte b = 0; b < 10; b++) {
      if (paramInt == CHECK_DIGIT_ENCODINGS[b])
        return b; 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int extensionChecksum(CharSequence paramCharSequence) {
    int i = paramCharSequence.length();
    int j = i - 2;
    int k = 0;
    while (j >= 0) {
      k += paramCharSequence.charAt(j) - 48;
      j -= 2;
    } 
    j = k * 3;
    for (k = i - 1; k >= 0; k -= 2)
      j += paramCharSequence.charAt(k) - 48; 
    return j * 3 % 10;
  }
  
  private static String parseExtension5String(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: iconst_0
    //   4: invokevirtual charAt : (I)C
    //   7: istore_2
    //   8: iload_2
    //   9: bipush #48
    //   11: if_icmpeq -> 160
    //   14: iload_2
    //   15: bipush #53
    //   17: if_icmpeq -> 154
    //   20: iload_2
    //   21: bipush #57
    //   23: if_icmpeq -> 32
    //   26: ldc ''
    //   28: astore_3
    //   29: goto -> 163
    //   32: aload_0
    //   33: invokevirtual hashCode : ()I
    //   36: istore_2
    //   37: iload_2
    //   38: ldc 54118329
    //   40: if_icmpeq -> 99
    //   43: iload_2
    //   44: tableswitch default -> 68, 54395376 -> 85, 54395377 -> 71
    //   68: goto -> 111
    //   71: aload_0
    //   72: ldc '99991'
    //   74: invokevirtual equals : (Ljava/lang/Object;)Z
    //   77: ifeq -> 111
    //   80: iconst_1
    //   81: istore_1
    //   82: goto -> 113
    //   85: aload_0
    //   86: ldc '99990'
    //   88: invokevirtual equals : (Ljava/lang/Object;)Z
    //   91: ifeq -> 111
    //   94: iconst_2
    //   95: istore_1
    //   96: goto -> 113
    //   99: aload_0
    //   100: ldc '90000'
    //   102: invokevirtual equals : (Ljava/lang/Object;)Z
    //   105: ifeq -> 111
    //   108: goto -> 113
    //   111: iconst_m1
    //   112: istore_1
    //   113: iload_1
    //   114: tableswitch default -> 140, 0 -> 152, 1 -> 149, 2 -> 146
    //   140: ldc ''
    //   142: astore_3
    //   143: goto -> 163
    //   146: ldc 'Used'
    //   148: areturn
    //   149: ldc '0.00'
    //   151: areturn
    //   152: aconst_null
    //   153: areturn
    //   154: ldc '$'
    //   156: astore_3
    //   157: goto -> 163
    //   160: ldc '£'
    //   162: astore_3
    //   163: aload_0
    //   164: iconst_1
    //   165: invokevirtual substring : (I)Ljava/lang/String;
    //   168: invokestatic parseInt : (Ljava/lang/String;)I
    //   171: istore_2
    //   172: iload_2
    //   173: bipush #100
    //   175: idiv
    //   176: istore_1
    //   177: iload_2
    //   178: bipush #100
    //   180: irem
    //   181: istore_2
    //   182: iload_2
    //   183: bipush #10
    //   185: if_icmpge -> 201
    //   188: ldc '0'
    //   190: iload_2
    //   191: invokestatic valueOf : (I)Ljava/lang/String;
    //   194: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   197: astore_0
    //   198: goto -> 206
    //   201: iload_2
    //   202: invokestatic valueOf : (I)Ljava/lang/String;
    //   205: astore_0
    //   206: new java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial <init> : ()V
    //   213: astore #4
    //   215: aload #4
    //   217: aload_3
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload #4
    //   224: iload_1
    //   225: invokestatic valueOf : (I)Ljava/lang/String;
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #4
    //   234: bipush #46
    //   236: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #4
    //   242: aload_0
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #4
    //   249: invokevirtual toString : ()Ljava/lang/String;
    //   252: areturn
  }
  
  private static Map<ResultMetadataType, Object> parseExtensionString(String paramString) {
    if (paramString.length() != 5)
      return null; 
    paramString = parseExtension5String(paramString);
    if (paramString == null)
      return null; 
    EnumMap<ResultMetadataType, Object> enumMap = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
    enumMap.put(ResultMetadataType.SUGGESTED_PRICE, paramString);
    return enumMap;
  }
  
  Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfint) throws NotFoundException {
    StringBuilder stringBuilder = this.decodeRowStringBuffer;
    stringBuilder.setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfint, stringBuilder);
    String str = stringBuilder.toString();
    Map<ResultMetadataType, Object> map = parseExtensionString(str);
    float f1 = (paramArrayOfint[0] + paramArrayOfint[1]) / 2.0F;
    float f2 = paramInt;
    ResultPoint resultPoint1 = new ResultPoint(f1, f2);
    ResultPoint resultPoint2 = new ResultPoint(i, f2);
    BarcodeFormat barcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;
    Result result = new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
    if (map != null)
      result.putAllMetadata(map); 
    return result;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCEANExtension5Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
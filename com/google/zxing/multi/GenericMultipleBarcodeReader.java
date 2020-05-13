package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
  private static final int MAX_DEPTH = 4;
  
  private static final int MIN_DIMENSION_TO_RECUR = 100;
  
  private final Reader delegate;
  
  public GenericMultipleBarcodeReader(Reader paramReader) {
    this.delegate = paramReader;
  }
  
  private void doDecodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, List<Result> paramList, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: iload #6
    //   2: iconst_4
    //   3: if_icmple -> 7
    //   6: return
    //   7: aload_0
    //   8: getfield delegate : Lcom/google/zxing/Reader;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface decode : (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;)Lcom/google/zxing/Result;
    //   18: astore #7
    //   20: aload_3
    //   21: invokeinterface iterator : ()Ljava/util/Iterator;
    //   26: astore #8
    //   28: aload #8
    //   30: invokeinterface hasNext : ()Z
    //   35: ifeq -> 68
    //   38: aload #8
    //   40: invokeinterface next : ()Ljava/lang/Object;
    //   45: checkcast com/google/zxing/Result
    //   48: invokevirtual getText : ()Ljava/lang/String;
    //   51: aload #7
    //   53: invokevirtual getText : ()Ljava/lang/String;
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifeq -> 28
    //   62: iconst_1
    //   63: istore #9
    //   65: goto -> 71
    //   68: iconst_0
    //   69: istore #9
    //   71: iload #9
    //   73: ifne -> 95
    //   76: aload_3
    //   77: aload #7
    //   79: iload #4
    //   81: iload #5
    //   83: invokestatic translateResultPoints : (Lcom/google/zxing/Result;II)Lcom/google/zxing/Result;
    //   86: invokeinterface add : (Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto -> 95
    //   95: aload #7
    //   97: invokevirtual getResultPoints : ()[Lcom/google/zxing/ResultPoint;
    //   100: astore #8
    //   102: aload #8
    //   104: ifnull -> 477
    //   107: aload #8
    //   109: arraylength
    //   110: ifne -> 116
    //   113: goto -> 477
    //   116: aload_1
    //   117: invokevirtual getWidth : ()I
    //   120: istore #10
    //   122: aload_1
    //   123: invokevirtual getHeight : ()I
    //   126: istore #11
    //   128: iload #10
    //   130: i2f
    //   131: fstore #12
    //   133: iload #11
    //   135: i2f
    //   136: fstore #13
    //   138: aload #8
    //   140: arraylength
    //   141: istore #14
    //   143: fconst_0
    //   144: fstore #15
    //   146: fconst_0
    //   147: fstore #16
    //   149: iconst_0
    //   150: istore #9
    //   152: iload #9
    //   154: iload #14
    //   156: if_icmpge -> 311
    //   159: aload #8
    //   161: iload #9
    //   163: aaload
    //   164: astore #7
    //   166: fload #12
    //   168: fstore #17
    //   170: fload #13
    //   172: fstore #18
    //   174: fload #15
    //   176: fstore #19
    //   178: fload #16
    //   180: fstore #20
    //   182: aload #7
    //   184: ifnull -> 289
    //   187: aload #7
    //   189: invokevirtual getX : ()F
    //   192: fstore #17
    //   194: aload #7
    //   196: invokevirtual getY : ()F
    //   199: fstore #21
    //   201: fload #12
    //   203: fstore #22
    //   205: fload #17
    //   207: fload #12
    //   209: fcmpg
    //   210: ifge -> 217
    //   213: fload #17
    //   215: fstore #22
    //   217: fload #13
    //   219: fstore #12
    //   221: fload #21
    //   223: fload #13
    //   225: fcmpg
    //   226: ifge -> 233
    //   229: fload #21
    //   231: fstore #12
    //   233: fload #15
    //   235: fstore #13
    //   237: fload #17
    //   239: fload #15
    //   241: fcmpl
    //   242: ifle -> 249
    //   245: fload #17
    //   247: fstore #13
    //   249: fload #22
    //   251: fstore #17
    //   253: fload #12
    //   255: fstore #18
    //   257: fload #13
    //   259: fstore #19
    //   261: fload #16
    //   263: fstore #20
    //   265: fload #21
    //   267: fload #16
    //   269: fcmpl
    //   270: ifle -> 289
    //   273: fload #21
    //   275: fstore #20
    //   277: fload #13
    //   279: fstore #19
    //   281: fload #12
    //   283: fstore #18
    //   285: fload #22
    //   287: fstore #17
    //   289: iinc #9, 1
    //   292: fload #17
    //   294: fstore #12
    //   296: fload #18
    //   298: fstore #13
    //   300: fload #19
    //   302: fstore #15
    //   304: fload #20
    //   306: fstore #16
    //   308: goto -> 152
    //   311: fload #12
    //   313: ldc 100.0
    //   315: fcmpl
    //   316: ifle -> 347
    //   319: aload_0
    //   320: aload_1
    //   321: iconst_0
    //   322: iconst_0
    //   323: fload #12
    //   325: f2i
    //   326: iload #11
    //   328: invokevirtual crop : (IIII)Lcom/google/zxing/BinaryBitmap;
    //   331: aload_2
    //   332: aload_3
    //   333: iload #4
    //   335: iload #5
    //   337: iload #6
    //   339: iconst_1
    //   340: iadd
    //   341: invokespecial doDecodeMultiple : (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;III)V
    //   344: goto -> 347
    //   347: fload #13
    //   349: ldc 100.0
    //   351: fcmpl
    //   352: ifle -> 380
    //   355: aload_0
    //   356: aload_1
    //   357: iconst_0
    //   358: iconst_0
    //   359: iload #10
    //   361: fload #13
    //   363: f2i
    //   364: invokevirtual crop : (IIII)Lcom/google/zxing/BinaryBitmap;
    //   367: aload_2
    //   368: aload_3
    //   369: iload #4
    //   371: iload #5
    //   373: iload #6
    //   375: iconst_1
    //   376: iadd
    //   377: invokespecial doDecodeMultiple : (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;III)V
    //   380: fload #15
    //   382: iload #10
    //   384: bipush #100
    //   386: isub
    //   387: i2f
    //   388: fcmpg
    //   389: ifge -> 428
    //   392: fload #15
    //   394: f2i
    //   395: istore #9
    //   397: aload_0
    //   398: aload_1
    //   399: iload #9
    //   401: iconst_0
    //   402: iload #10
    //   404: iload #9
    //   406: isub
    //   407: iload #11
    //   409: invokevirtual crop : (IIII)Lcom/google/zxing/BinaryBitmap;
    //   412: aload_2
    //   413: aload_3
    //   414: iload #4
    //   416: iload #9
    //   418: iadd
    //   419: iload #5
    //   421: iload #6
    //   423: iconst_1
    //   424: iadd
    //   425: invokespecial doDecodeMultiple : (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;III)V
    //   428: fload #16
    //   430: iload #11
    //   432: bipush #100
    //   434: isub
    //   435: i2f
    //   436: fcmpg
    //   437: ifge -> 476
    //   440: fload #16
    //   442: f2i
    //   443: istore #9
    //   445: aload_0
    //   446: aload_1
    //   447: iconst_0
    //   448: iload #9
    //   450: iload #10
    //   452: iload #11
    //   454: iload #9
    //   456: isub
    //   457: invokevirtual crop : (IIII)Lcom/google/zxing/BinaryBitmap;
    //   460: aload_2
    //   461: aload_3
    //   462: iload #4
    //   464: iload #5
    //   466: iload #9
    //   468: iadd
    //   469: iload #6
    //   471: iconst_1
    //   472: iadd
    //   473: invokespecial doDecodeMultiple : (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;III)V
    //   476: return
    //   477: return
    //   478: astore_1
    //   479: return
    // Exception table:
    //   from	to	target	type
    //   7	20	478	com/google/zxing/ReaderException
  }
  
  private static Result translateResultPoints(Result paramResult, int paramInt1, int paramInt2) {
    ResultPoint[] arrayOfResultPoint1 = paramResult.getResultPoints();
    if (arrayOfResultPoint1 == null)
      return paramResult; 
    ResultPoint[] arrayOfResultPoint2 = new ResultPoint[arrayOfResultPoint1.length];
    for (byte b = 0; b < arrayOfResultPoint1.length; b++) {
      ResultPoint resultPoint = arrayOfResultPoint1[b];
      if (resultPoint != null)
        arrayOfResultPoint2[b] = new ResultPoint(resultPoint.getX() + paramInt1, resultPoint.getY() + paramInt2); 
    } 
    Result result = new Result(paramResult.getText(), paramResult.getRawBytes(), paramResult.getNumBits(), arrayOfResultPoint2, paramResult.getBarcodeFormat(), paramResult.getTimestamp());
    result.putAllMetadata(paramResult.getResultMetadata());
    return result;
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    return decodeMultiple(paramBinaryBitmap, null);
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    ArrayList<Result> arrayList = new ArrayList();
    doDecodeMultiple(paramBinaryBitmap, paramMap, arrayList, 0, 0, 0);
    if (!arrayList.isEmpty())
      return arrayList.<Result>toArray(new Result[arrayList.size()]); 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\multi\GenericMultipleBarcodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
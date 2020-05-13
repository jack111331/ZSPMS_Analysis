package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
  private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
  
  private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
  
  private static List<Result> processStructuredAppend(List<Result> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface iterator : ()Ljava/util/Iterator;
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface hasNext : ()Z
    //   13: ifeq -> 44
    //   16: aload_1
    //   17: invokeinterface next : ()Ljava/lang/Object;
    //   22: checkcast com/google/zxing/Result
    //   25: invokevirtual getResultMetadata : ()Ljava/util/Map;
    //   28: getstatic com/google/zxing/ResultMetadataType.STRUCTURED_APPEND_SEQUENCE : Lcom/google/zxing/ResultMetadataType;
    //   31: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   36: ifeq -> 7
    //   39: iconst_1
    //   40: istore_2
    //   41: goto -> 46
    //   44: iconst_0
    //   45: istore_2
    //   46: iload_2
    //   47: ifne -> 52
    //   50: aload_0
    //   51: areturn
    //   52: new java/util/ArrayList
    //   55: dup
    //   56: invokespecial <init> : ()V
    //   59: astore_1
    //   60: new java/util/ArrayList
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore_3
    //   68: aload_0
    //   69: invokeinterface iterator : ()Ljava/util/Iterator;
    //   74: astore_0
    //   75: aload_0
    //   76: invokeinterface hasNext : ()Z
    //   81: ifeq -> 132
    //   84: aload_0
    //   85: invokeinterface next : ()Ljava/lang/Object;
    //   90: checkcast com/google/zxing/Result
    //   93: astore #4
    //   95: aload_1
    //   96: aload #4
    //   98: invokeinterface add : (Ljava/lang/Object;)Z
    //   103: pop
    //   104: aload #4
    //   106: invokevirtual getResultMetadata : ()Ljava/util/Map;
    //   109: getstatic com/google/zxing/ResultMetadataType.STRUCTURED_APPEND_SEQUENCE : Lcom/google/zxing/ResultMetadataType;
    //   112: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   117: ifeq -> 75
    //   120: aload_3
    //   121: aload #4
    //   123: invokeinterface add : (Ljava/lang/Object;)Z
    //   128: pop
    //   129: goto -> 75
    //   132: aload_3
    //   133: new com/google/zxing/multi/qrcode/QRCodeMultiReader$SAComparator
    //   136: dup
    //   137: aconst_null
    //   138: invokespecial <init> : (Lcom/google/zxing/multi/qrcode/QRCodeMultiReader$1;)V
    //   141: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   144: new java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial <init> : ()V
    //   151: astore_0
    //   152: aload_3
    //   153: invokeinterface iterator : ()Ljava/util/Iterator;
    //   158: astore #4
    //   160: iconst_0
    //   161: istore #5
    //   163: iconst_0
    //   164: istore_2
    //   165: aload #4
    //   167: invokeinterface hasNext : ()Z
    //   172: ifeq -> 290
    //   175: aload #4
    //   177: invokeinterface next : ()Ljava/lang/Object;
    //   182: checkcast com/google/zxing/Result
    //   185: astore #6
    //   187: aload_0
    //   188: aload #6
    //   190: invokevirtual getText : ()Ljava/lang/String;
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: iload #5
    //   199: aload #6
    //   201: invokevirtual getRawBytes : ()[B
    //   204: arraylength
    //   205: iadd
    //   206: istore #7
    //   208: iload #7
    //   210: istore #5
    //   212: aload #6
    //   214: invokevirtual getResultMetadata : ()Ljava/util/Map;
    //   217: getstatic com/google/zxing/ResultMetadataType.BYTE_SEGMENTS : Lcom/google/zxing/ResultMetadataType;
    //   220: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   225: ifeq -> 165
    //   228: aload #6
    //   230: invokevirtual getResultMetadata : ()Ljava/util/Map;
    //   233: getstatic com/google/zxing/ResultMetadataType.BYTE_SEGMENTS : Lcom/google/zxing/ResultMetadataType;
    //   236: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   241: checkcast java/lang/Iterable
    //   244: invokeinterface iterator : ()Ljava/util/Iterator;
    //   249: astore #6
    //   251: iload_2
    //   252: istore #8
    //   254: iload #7
    //   256: istore #5
    //   258: iload #8
    //   260: istore_2
    //   261: aload #6
    //   263: invokeinterface hasNext : ()Z
    //   268: ifeq -> 165
    //   271: iload #8
    //   273: aload #6
    //   275: invokeinterface next : ()Ljava/lang/Object;
    //   280: checkcast [B
    //   283: arraylength
    //   284: iadd
    //   285: istore #8
    //   287: goto -> 254
    //   290: iload #5
    //   292: newarray byte
    //   294: astore #6
    //   296: iload_2
    //   297: newarray byte
    //   299: astore #4
    //   301: aload_3
    //   302: invokeinterface iterator : ()Ljava/util/Iterator;
    //   307: astore_3
    //   308: iconst_0
    //   309: istore #7
    //   311: iconst_0
    //   312: istore #5
    //   314: aload_3
    //   315: invokeinterface hasNext : ()Z
    //   320: ifeq -> 465
    //   323: aload_3
    //   324: invokeinterface next : ()Ljava/lang/Object;
    //   329: checkcast com/google/zxing/Result
    //   332: astore #9
    //   334: aload #9
    //   336: invokevirtual getRawBytes : ()[B
    //   339: iconst_0
    //   340: aload #6
    //   342: iload #7
    //   344: aload #9
    //   346: invokevirtual getRawBytes : ()[B
    //   349: arraylength
    //   350: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   353: iload #7
    //   355: aload #9
    //   357: invokevirtual getRawBytes : ()[B
    //   360: arraylength
    //   361: iadd
    //   362: istore #10
    //   364: iload #10
    //   366: istore #7
    //   368: aload #9
    //   370: invokevirtual getResultMetadata : ()Ljava/util/Map;
    //   373: getstatic com/google/zxing/ResultMetadataType.BYTE_SEGMENTS : Lcom/google/zxing/ResultMetadataType;
    //   376: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   381: ifeq -> 314
    //   384: aload #9
    //   386: invokevirtual getResultMetadata : ()Ljava/util/Map;
    //   389: getstatic com/google/zxing/ResultMetadataType.BYTE_SEGMENTS : Lcom/google/zxing/ResultMetadataType;
    //   392: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast java/lang/Iterable
    //   400: invokeinterface iterator : ()Ljava/util/Iterator;
    //   405: astore #9
    //   407: iload #5
    //   409: istore #8
    //   411: iload #10
    //   413: istore #7
    //   415: iload #8
    //   417: istore #5
    //   419: aload #9
    //   421: invokeinterface hasNext : ()Z
    //   426: ifeq -> 314
    //   429: aload #9
    //   431: invokeinterface next : ()Ljava/lang/Object;
    //   436: checkcast [B
    //   439: astore #11
    //   441: aload #11
    //   443: iconst_0
    //   444: aload #4
    //   446: iload #8
    //   448: aload #11
    //   450: arraylength
    //   451: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   454: iload #8
    //   456: aload #11
    //   458: arraylength
    //   459: iadd
    //   460: istore #8
    //   462: goto -> 411
    //   465: new com/google/zxing/Result
    //   468: dup
    //   469: aload_0
    //   470: invokevirtual toString : ()Ljava/lang/String;
    //   473: aload #6
    //   475: getstatic com/google/zxing/multi/qrcode/QRCodeMultiReader.NO_POINTS : [Lcom/google/zxing/ResultPoint;
    //   478: getstatic com/google/zxing/BarcodeFormat.QR_CODE : Lcom/google/zxing/BarcodeFormat;
    //   481: invokespecial <init> : (Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V
    //   484: astore_3
    //   485: iload_2
    //   486: ifle -> 514
    //   489: new java/util/ArrayList
    //   492: dup
    //   493: invokespecial <init> : ()V
    //   496: astore_0
    //   497: aload_0
    //   498: aload #4
    //   500: invokeinterface add : (Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload_3
    //   507: getstatic com/google/zxing/ResultMetadataType.BYTE_SEGMENTS : Lcom/google/zxing/ResultMetadataType;
    //   510: aload_0
    //   511: invokevirtual putMetadata : (Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
    //   514: aload_1
    //   515: aload_3
    //   516: invokeinterface add : (Ljava/lang/Object;)Z
    //   521: pop
    //   522: aload_1
    //   523: areturn
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    return decodeMultiple(paramBinaryBitmap, null);
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    ArrayList<Result> arrayList = new ArrayList();
    DetectorResult[] arrayOfDetectorResult = (new MultiDetector(paramBinaryBitmap.getBlackMatrix())).detectMulti(paramMap);
    int i = arrayOfDetectorResult.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        DetectorResult detectorResult = arrayOfDetectorResult[b];
        try {
          DecoderResult decoderResult = getDecoder().decode(detectorResult.getBits(), paramMap);
          ResultPoint[] arrayOfResultPoint = detectorResult.getPoints();
          if (decoderResult.getOther() instanceof QRCodeDecoderMetaData)
            ((QRCodeDecoderMetaData)decoderResult.getOther()).applyMirroredCorrection(arrayOfResultPoint); 
          Result result = new Result();
          this(decoderResult.getText(), decoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.QR_CODE);
          List list1 = decoderResult.getByteSegments();
          if (list1 != null)
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list1); 
          String str = decoderResult.getECLevel();
          if (str != null)
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str); 
          if (decoderResult.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResult.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResult.getStructuredAppendParity()));
          } 
          arrayList.add(result);
        } catch (ReaderException readerException) {}
        b++;
        continue;
      } 
      if (arrayList.isEmpty())
        return EMPTY_RESULT_ARRAY; 
      List<Result> list = processStructuredAppend(arrayList);
      return list.<Result>toArray(new Result[list.size()]);
    } 
  }
  
  private static final class SAComparator implements Serializable, Comparator<Result> {
    private SAComparator() {}
    
    public int compare(Result param1Result1, Result param1Result2) {
      return Integer.compare(((Integer)param1Result1.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue(), ((Integer)param1Result2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue());
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\multi\qrcode\QRCodeMultiReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
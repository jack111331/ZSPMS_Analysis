package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter {
  private static final char[] ALT_START_END_CHARS;
  
  private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED;
  
  private static final char DEFAULT_GUARD;
  
  private static final char[] START_END_CHARS = new char[] { 'A', 'B', 'C', 'D' };
  
  static {
    ALT_START_END_CHARS = new char[] { 'T', 'N', '*', 'E' };
    CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[] { '/', ':', '+', '.' };
    DEFAULT_GUARD = (char)START_END_CHARS[0];
  }
  
  public boolean[] encode(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual length : ()I
    //   4: iconst_2
    //   5: if_icmpge -> 46
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_2
    //   16: aload_2
    //   17: getstatic com/google/zxing/oned/CodaBarWriter.DEFAULT_GUARD : C
    //   20: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: getstatic com/google/zxing/oned/CodaBarWriter.DEFAULT_GUARD : C
    //   34: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: astore_1
    //   43: goto -> 213
    //   46: aload_1
    //   47: iconst_0
    //   48: invokevirtual charAt : (I)C
    //   51: invokestatic toUpperCase : (C)C
    //   54: istore_3
    //   55: aload_1
    //   56: aload_1
    //   57: invokevirtual length : ()I
    //   60: iconst_1
    //   61: isub
    //   62: invokevirtual charAt : (I)C
    //   65: invokestatic toUpperCase : (C)C
    //   68: istore #4
    //   70: getstatic com/google/zxing/oned/CodaBarWriter.START_END_CHARS : [C
    //   73: iload_3
    //   74: invokestatic arrayContains : ([CC)Z
    //   77: istore #5
    //   79: getstatic com/google/zxing/oned/CodaBarWriter.START_END_CHARS : [C
    //   82: iload #4
    //   84: invokestatic arrayContains : ([CC)Z
    //   87: istore #6
    //   89: getstatic com/google/zxing/oned/CodaBarWriter.ALT_START_END_CHARS : [C
    //   92: iload_3
    //   93: invokestatic arrayContains : ([CC)Z
    //   96: istore #7
    //   98: getstatic com/google/zxing/oned/CodaBarWriter.ALT_START_END_CHARS : [C
    //   101: iload #4
    //   103: invokestatic arrayContains : ([CC)Z
    //   106: istore #8
    //   108: iload #5
    //   110: ifeq -> 138
    //   113: iload #6
    //   115: ifeq -> 121
    //   118: goto -> 213
    //   121: new java/lang/IllegalArgumentException
    //   124: dup
    //   125: ldc 'Invalid start/end guards: '
    //   127: aload_1
    //   128: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   134: invokespecial <init> : (Ljava/lang/String;)V
    //   137: athrow
    //   138: iload #7
    //   140: ifeq -> 168
    //   143: iload #8
    //   145: ifeq -> 151
    //   148: goto -> 213
    //   151: new java/lang/IllegalArgumentException
    //   154: dup
    //   155: ldc 'Invalid start/end guards: '
    //   157: aload_1
    //   158: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   164: invokespecial <init> : (Ljava/lang/String;)V
    //   167: athrow
    //   168: iload #6
    //   170: ifne -> 602
    //   173: iload #8
    //   175: ifne -> 602
    //   178: new java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial <init> : ()V
    //   185: astore_2
    //   186: aload_2
    //   187: getstatic com/google/zxing/oned/CodaBarWriter.DEFAULT_GUARD : C
    //   190: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: aload_1
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: getstatic com/google/zxing/oned/CodaBarWriter.DEFAULT_GUARD : C
    //   204: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_2
    //   209: invokevirtual toString : ()Ljava/lang/String;
    //   212: astore_1
    //   213: iconst_1
    //   214: istore #9
    //   216: bipush #20
    //   218: istore #10
    //   220: iload #9
    //   222: aload_1
    //   223: invokevirtual length : ()I
    //   226: iconst_1
    //   227: isub
    //   228: if_icmpge -> 338
    //   231: aload_1
    //   232: iload #9
    //   234: invokevirtual charAt : (I)C
    //   237: invokestatic isDigit : (C)Z
    //   240: ifne -> 329
    //   243: aload_1
    //   244: iload #9
    //   246: invokevirtual charAt : (I)C
    //   249: bipush #45
    //   251: if_icmpeq -> 329
    //   254: aload_1
    //   255: iload #9
    //   257: invokevirtual charAt : (I)C
    //   260: bipush #36
    //   262: if_icmpne -> 268
    //   265: goto -> 329
    //   268: getstatic com/google/zxing/oned/CodaBarWriter.CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED : [C
    //   271: aload_1
    //   272: iload #9
    //   274: invokevirtual charAt : (I)C
    //   277: invokestatic arrayContains : ([CC)Z
    //   280: ifeq -> 289
    //   283: iinc #10, 10
    //   286: goto -> 332
    //   289: new java/lang/StringBuilder
    //   292: dup
    //   293: ldc 'Cannot encode : ''
    //   295: invokespecial <init> : (Ljava/lang/String;)V
    //   298: astore_2
    //   299: aload_2
    //   300: aload_1
    //   301: iload #9
    //   303: invokevirtual charAt : (I)C
    //   306: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_2
    //   311: bipush #39
    //   313: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: new java/lang/IllegalArgumentException
    //   320: dup
    //   321: aload_2
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokespecial <init> : (Ljava/lang/String;)V
    //   328: athrow
    //   329: iinc #10, 9
    //   332: iinc #9, 1
    //   335: goto -> 220
    //   338: iload #10
    //   340: aload_1
    //   341: invokevirtual length : ()I
    //   344: iconst_1
    //   345: isub
    //   346: iadd
    //   347: newarray boolean
    //   349: astore_2
    //   350: iconst_0
    //   351: istore #11
    //   353: iconst_0
    //   354: istore #9
    //   356: iload #11
    //   358: aload_1
    //   359: invokevirtual length : ()I
    //   362: if_icmpge -> 600
    //   365: aload_1
    //   366: iload #11
    //   368: invokevirtual charAt : (I)C
    //   371: invokestatic toUpperCase : (C)C
    //   374: istore #12
    //   376: iload #11
    //   378: ifeq -> 396
    //   381: iload #12
    //   383: istore #10
    //   385: iload #11
    //   387: aload_1
    //   388: invokevirtual length : ()I
    //   391: iconst_1
    //   392: isub
    //   393: if_icmpne -> 456
    //   396: iload #12
    //   398: bipush #42
    //   400: if_icmpeq -> 452
    //   403: iload #12
    //   405: bipush #69
    //   407: if_icmpeq -> 445
    //   410: iload #12
    //   412: bipush #78
    //   414: if_icmpeq -> 438
    //   417: iload #12
    //   419: bipush #84
    //   421: if_icmpeq -> 431
    //   424: iload #12
    //   426: istore #10
    //   428: goto -> 456
    //   431: bipush #65
    //   433: istore #10
    //   435: goto -> 456
    //   438: bipush #66
    //   440: istore #10
    //   442: goto -> 456
    //   445: bipush #68
    //   447: istore #10
    //   449: goto -> 456
    //   452: bipush #67
    //   454: istore #10
    //   456: iconst_0
    //   457: istore #12
    //   459: iload #12
    //   461: getstatic com/google/zxing/oned/CodaBarReader.ALPHABET : [C
    //   464: arraylength
    //   465: if_icmpge -> 496
    //   468: iload #10
    //   470: getstatic com/google/zxing/oned/CodaBarReader.ALPHABET : [C
    //   473: iload #12
    //   475: caload
    //   476: if_icmpne -> 490
    //   479: getstatic com/google/zxing/oned/CodaBarReader.CHARACTER_ENCODINGS : [I
    //   482: iload #12
    //   484: iaload
    //   485: istore #12
    //   487: goto -> 499
    //   490: iinc #12, 1
    //   493: goto -> 459
    //   496: iconst_0
    //   497: istore #12
    //   499: iload #9
    //   501: istore #10
    //   503: iconst_0
    //   504: istore #9
    //   506: iconst_1
    //   507: istore #7
    //   509: iconst_0
    //   510: istore #13
    //   512: iload #9
    //   514: bipush #7
    //   516: if_icmpge -> 568
    //   519: aload_2
    //   520: iload #10
    //   522: iload #7
    //   524: bastore
    //   525: iinc #10, 1
    //   528: iload #12
    //   530: bipush #6
    //   532: iload #9
    //   534: isub
    //   535: ishr
    //   536: iconst_1
    //   537: iand
    //   538: ifeq -> 556
    //   541: iload #13
    //   543: iconst_1
    //   544: if_icmpne -> 550
    //   547: goto -> 556
    //   550: iinc #13, 1
    //   553: goto -> 512
    //   556: iload #7
    //   558: iconst_1
    //   559: ixor
    //   560: istore #7
    //   562: iinc #9, 1
    //   565: goto -> 509
    //   568: iload #10
    //   570: istore #9
    //   572: iload #11
    //   574: aload_1
    //   575: invokevirtual length : ()I
    //   578: iconst_1
    //   579: isub
    //   580: if_icmpge -> 594
    //   583: aload_2
    //   584: iload #10
    //   586: iconst_0
    //   587: bastore
    //   588: iload #10
    //   590: iconst_1
    //   591: iadd
    //   592: istore #9
    //   594: iinc #11, 1
    //   597: goto -> 356
    //   600: aload_2
    //   601: areturn
    //   602: new java/lang/IllegalArgumentException
    //   605: dup
    //   606: ldc 'Invalid start/end guards: '
    //   608: aload_1
    //   609: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   612: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   615: invokespecial <init> : (Ljava/lang/String;)V
    //   618: athrow
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\CodaBarWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
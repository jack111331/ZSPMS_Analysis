package com.unionpay.mobile.android.resource;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public final class c {
  private static c c = null;
  
  private HashMap<Integer, WeakReference<Drawable.ConstantState>> a = new HashMap<Integer, WeakReference<Drawable.ConstantState>>();
  
  private Context b = null;
  
  private c(Context paramContext) {
    this.b = paramContext;
  }
  
  public static c a(Context paramContext) {
    if (c == null)
      c = new c(paramContext); 
    return c;
  }
  
  public final Drawable a(int paramInt) {
    return a(paramInt, -1, -1);
  }
  
  public final Drawable a(int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: iload_1
    //   1: ifge -> 10
    //   4: aconst_null
    //   5: astore #4
    //   7: aload #4
    //   9: areturn
    //   10: aload_0
    //   11: getfield a : Ljava/util/HashMap;
    //   14: iload_1
    //   15: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   18: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast java/lang/ref/WeakReference
    //   24: astore #4
    //   26: aload #4
    //   28: ifnull -> 68
    //   31: aload #4
    //   33: invokevirtual get : ()Ljava/lang/Object;
    //   36: checkcast android/graphics/drawable/Drawable$ConstantState
    //   39: astore #4
    //   41: aload #4
    //   43: ifnull -> 56
    //   46: aload #4
    //   48: invokevirtual newDrawable : ()Landroid/graphics/drawable/Drawable;
    //   51: astore #4
    //   53: goto -> 7
    //   56: aload_0
    //   57: getfield a : Ljava/util/HashMap;
    //   60: iload_1
    //   61: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   64: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: iload_1
    //   69: sipush #1000
    //   72: idiv
    //   73: sipush #1000
    //   76: imul
    //   77: istore #5
    //   79: iload_1
    //   80: iload #5
    //   82: isub
    //   83: istore #6
    //   85: iload #5
    //   87: lookupswitch default -> 120, 2000 -> 266, 3000 -> 204, 4000 -> 322
    //   120: aconst_null
    //   121: astore #4
    //   123: aload #4
    //   125: astore #7
    //   127: aload #4
    //   129: ifnonnull -> 503
    //   132: ldc com/unionpay/mobile/android/resource/a
    //   134: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   137: ldc 'assets/data.bin'
    //   139: invokevirtual getResourceAsStream : (Ljava/lang/String;)Ljava/io/InputStream;
    //   142: astore #8
    //   144: new java/io/DataInputStream
    //   147: dup
    //   148: aload #8
    //   150: invokespecial <init> : (Ljava/io/InputStream;)V
    //   153: astore #7
    //   155: iload_1
    //   156: sipush #1000
    //   159: isub
    //   160: istore #5
    //   162: iload #5
    //   164: bipush #8
    //   166: imul
    //   167: istore #6
    //   169: iload #6
    //   171: i2l
    //   172: lstore #9
    //   174: aload #7
    //   176: lload #9
    //   178: invokevirtual skip : (J)J
    //   181: lstore #9
    //   183: lload #9
    //   185: iload #6
    //   187: i2l
    //   188: lcmp
    //   189: ifge -> 348
    //   192: iload #6
    //   194: i2l
    //   195: lload #9
    //   197: lsub
    //   198: l2i
    //   199: istore #6
    //   201: goto -> 169
    //   204: getstatic com/unionpay/mobile/android/resource/b.e : [I
    //   207: iload #6
    //   209: iaload
    //   210: istore #5
    //   212: getstatic com/unionpay/mobile/android/resource/b.d : [[I
    //   215: iload #6
    //   217: aaload
    //   218: astore #7
    //   220: getstatic com/unionpay/mobile/android/resource/b.b : [[F
    //   223: iload #6
    //   225: aaload
    //   226: astore #8
    //   228: getstatic com/unionpay/mobile/android/resource/b.c : [[F
    //   231: iload #6
    //   233: aaload
    //   234: astore #4
    //   236: iload #5
    //   238: aload #7
    //   240: aload #8
    //   242: aload #4
    //   244: iconst_0
    //   245: faload
    //   246: aload #4
    //   248: iconst_1
    //   249: faload
    //   250: aload #4
    //   252: iconst_2
    //   253: faload
    //   254: aload #4
    //   256: iconst_3
    //   257: faload
    //   258: invokestatic a : (I[I[FFFFF)Landroid/graphics/drawable/Drawable;
    //   261: astore #4
    //   263: goto -> 123
    //   266: getstatic com/unionpay/mobile/android/resource/b.a : [[I
    //   269: iload #6
    //   271: aaload
    //   272: astore #4
    //   274: aload_0
    //   275: aload #4
    //   277: iconst_0
    //   278: iaload
    //   279: iload_2
    //   280: iload_3
    //   281: invokevirtual a : (III)Landroid/graphics/drawable/Drawable;
    //   284: aload_0
    //   285: aload #4
    //   287: iconst_1
    //   288: iaload
    //   289: iload_2
    //   290: iload_3
    //   291: invokevirtual a : (III)Landroid/graphics/drawable/Drawable;
    //   294: aload_0
    //   295: aload #4
    //   297: iconst_2
    //   298: iaload
    //   299: iload_2
    //   300: iload_3
    //   301: invokevirtual a : (III)Landroid/graphics/drawable/Drawable;
    //   304: aload_0
    //   305: aload #4
    //   307: iconst_3
    //   308: iaload
    //   309: iload_2
    //   310: iload_3
    //   311: invokevirtual a : (III)Landroid/graphics/drawable/Drawable;
    //   314: invokestatic a : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   317: astore #4
    //   319: goto -> 123
    //   322: getstatic com/unionpay/mobile/android/resource/b.f : [I
    //   325: iload #6
    //   327: iaload
    //   328: getstatic com/unionpay/mobile/android/resource/b.g : [I
    //   331: iload #6
    //   333: iaload
    //   334: getstatic com/unionpay/mobile/android/resource/b.h : [F
    //   337: iload #6
    //   339: faload
    //   340: invokestatic a : (IIF)Landroid/graphics/drawable/ShapeDrawable;
    //   343: astore #4
    //   345: goto -> 123
    //   348: aload #7
    //   350: invokevirtual readInt : ()I
    //   353: istore #6
    //   355: aload #7
    //   357: invokevirtual readInt : ()I
    //   360: istore #11
    //   362: iload #6
    //   364: iload #5
    //   366: bipush #8
    //   368: imul
    //   369: bipush #8
    //   371: iadd
    //   372: isub
    //   373: istore #6
    //   375: aload #7
    //   377: iload #6
    //   379: i2l
    //   380: invokevirtual skip : (J)J
    //   383: lstore #9
    //   385: lload #9
    //   387: iload #6
    //   389: i2l
    //   390: lcmp
    //   391: ifge -> 406
    //   394: iload #6
    //   396: i2l
    //   397: lload #9
    //   399: lsub
    //   400: l2i
    //   401: istore #6
    //   403: goto -> 375
    //   406: aload #7
    //   408: iload #11
    //   410: invokevirtual mark : (I)V
    //   413: aload #7
    //   415: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   418: astore #4
    //   420: new android/graphics/Rect
    //   423: astore #12
    //   425: aload #12
    //   427: invokespecial <init> : ()V
    //   430: aload #4
    //   432: invokevirtual getNinePatchChunk : ()[B
    //   435: ifnonnull -> 753
    //   438: iconst_m1
    //   439: iload_3
    //   440: if_icmpeq -> 543
    //   443: iconst_m1
    //   444: iload_2
    //   445: if_icmpeq -> 543
    //   448: aload #4
    //   450: iload_2
    //   451: iload_3
    //   452: iconst_1
    //   453: invokestatic createScaledBitmap : (Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   456: astore #12
    //   458: aload #12
    //   460: aload #4
    //   462: if_acmpeq -> 470
    //   465: aload #4
    //   467: invokevirtual recycle : ()V
    //   470: new android/graphics/drawable/BitmapDrawable
    //   473: astore #4
    //   475: aload #4
    //   477: aload_0
    //   478: getfield b : Landroid/content/Context;
    //   481: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   484: aload #12
    //   486: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   489: aload #7
    //   491: invokevirtual close : ()V
    //   494: aload #8
    //   496: invokevirtual close : ()V
    //   499: aload #4
    //   501: astore #7
    //   503: aload #7
    //   505: astore #4
    //   507: aload #7
    //   509: ifnull -> 7
    //   512: aload_0
    //   513: getfield a : Ljava/util/HashMap;
    //   516: iload_1
    //   517: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   520: new java/lang/ref/WeakReference
    //   523: dup
    //   524: aload #7
    //   526: invokevirtual getConstantState : ()Landroid/graphics/drawable/Drawable$ConstantState;
    //   529: invokespecial <init> : (Ljava/lang/Object;)V
    //   532: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   535: pop
    //   536: aload #7
    //   538: astore #4
    //   540: goto -> 7
    //   543: iconst_m1
    //   544: iload_3
    //   545: if_icmpeq -> 663
    //   548: iconst_m1
    //   549: iload_2
    //   550: if_icmpne -> 663
    //   553: aload #4
    //   555: invokevirtual getWidth : ()I
    //   558: i2f
    //   559: aload #4
    //   561: invokevirtual getHeight : ()I
    //   564: i2f
    //   565: fdiv
    //   566: iload_3
    //   567: i2f
    //   568: fmul
    //   569: f2i
    //   570: istore_2
    //   571: new java/lang/StringBuilder
    //   574: astore #12
    //   576: aload #12
    //   578: ldc 'w='
    //   580: invokespecial <init> : (Ljava/lang/String;)V
    //   583: ldc 'img'
    //   585: aload #12
    //   587: iload_2
    //   588: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   591: ldc ',h='
    //   593: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: iload_3
    //   597: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   600: invokevirtual toString : ()Ljava/lang/String;
    //   603: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   606: pop
    //   607: aload #4
    //   609: iload_2
    //   610: iload_3
    //   611: iconst_1
    //   612: invokestatic createScaledBitmap : (Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   615: astore #12
    //   617: aload #12
    //   619: aload #4
    //   621: if_acmpeq -> 629
    //   624: aload #4
    //   626: invokevirtual recycle : ()V
    //   629: new android/graphics/drawable/BitmapDrawable
    //   632: dup
    //   633: aload_0
    //   634: getfield b : Landroid/content/Context;
    //   637: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   640: aload #12
    //   642: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   645: astore #4
    //   647: goto -> 489
    //   650: astore #4
    //   652: aload #4
    //   654: invokevirtual printStackTrace : ()V
    //   657: aconst_null
    //   658: astore #7
    //   660: goto -> 503
    //   663: iconst_m1
    //   664: iload_2
    //   665: if_icmpeq -> 732
    //   668: iconst_m1
    //   669: iload_3
    //   670: if_icmpne -> 732
    //   673: aload #4
    //   675: iload_2
    //   676: aload #4
    //   678: invokevirtual getHeight : ()I
    //   681: i2f
    //   682: aload #4
    //   684: invokevirtual getWidth : ()I
    //   687: i2f
    //   688: fdiv
    //   689: iload_2
    //   690: i2f
    //   691: fmul
    //   692: f2i
    //   693: iconst_1
    //   694: invokestatic createScaledBitmap : (Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   697: astore #12
    //   699: aload #12
    //   701: aload #4
    //   703: if_acmpeq -> 711
    //   706: aload #4
    //   708: invokevirtual recycle : ()V
    //   711: new android/graphics/drawable/BitmapDrawable
    //   714: dup
    //   715: aload_0
    //   716: getfield b : Landroid/content/Context;
    //   719: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   722: aload #12
    //   724: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   727: astore #4
    //   729: goto -> 489
    //   732: new android/graphics/drawable/BitmapDrawable
    //   735: dup
    //   736: aload_0
    //   737: getfield b : Landroid/content/Context;
    //   740: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   743: aload #4
    //   745: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   748: astore #4
    //   750: goto -> 489
    //   753: new android/graphics/drawable/NinePatchDrawable
    //   756: dup
    //   757: aload_0
    //   758: getfield b : Landroid/content/Context;
    //   761: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   764: aload #4
    //   766: aload #4
    //   768: invokevirtual getNinePatchChunk : ()[B
    //   771: aload #12
    //   773: aconst_null
    //   774: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    //   777: astore #4
    //   779: goto -> 489
    // Exception table:
    //   from	to	target	type
    //   174	183	650	java/io/IOException
    //   348	362	650	java/io/IOException
    //   375	385	650	java/io/IOException
    //   406	438	650	java/io/IOException
    //   448	458	650	java/io/IOException
    //   465	470	650	java/io/IOException
    //   470	489	650	java/io/IOException
    //   489	499	650	java/io/IOException
    //   553	617	650	java/io/IOException
    //   624	629	650	java/io/IOException
    //   629	647	650	java/io/IOException
    //   673	699	650	java/io/IOException
    //   706	711	650	java/io/IOException
    //   711	729	650	java/io/IOException
    //   732	750	650	java/io/IOException
    //   753	779	650	java/io/IOException
  }
  
  public final void a() {
    Iterator<WeakReference<Drawable.ConstantState>> iterator = this.a.values().iterator();
    while (iterator.hasNext()) {
      Drawable.ConstantState constantState = ((WeakReference<Drawable.ConstantState>)iterator.next()).get();
      if (constantState != null) {
        Drawable drawable = constantState.newDrawable();
        if (drawable instanceof BitmapDrawable)
          ((BitmapDrawable)drawable).getBitmap().recycle(); 
      } 
    } 
    this.a.clear();
    c = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\resource\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
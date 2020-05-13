package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;

@RequiresApi(9)
class PaintCompatGingerbread {
  private static final String TOFU_STRING = "󟿽";
  
  private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal<Pair<Rect, Rect>>();
  
  static boolean hasGlyph(@NonNull Paint paramPaint, @NonNull String paramString) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: invokevirtual length : ()I
    //   6: istore_3
    //   7: iload_3
    //   8: iconst_1
    //   9: if_icmpne -> 29
    //   12: aload_1
    //   13: iconst_0
    //   14: invokevirtual charAt : (I)C
    //   17: invokestatic isWhitespace : (C)Z
    //   20: ifeq -> 29
    //   23: iconst_1
    //   24: istore #4
    //   26: iload #4
    //   28: ireturn
    //   29: aload_0
    //   30: ldc '󟿽'
    //   32: invokevirtual measureText : (Ljava/lang/String;)F
    //   35: fstore #5
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual measureText : (Ljava/lang/String;)F
    //   42: fstore #6
    //   44: fload #6
    //   46: fconst_0
    //   47: fcmpl
    //   48: ifeq -> 211
    //   51: aload_1
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual length : ()I
    //   57: invokevirtual codePointCount : (II)I
    //   60: iconst_1
    //   61: if_icmple -> 132
    //   64: fload #6
    //   66: fconst_2
    //   67: fload #5
    //   69: fmul
    //   70: fcmpl
    //   71: ifgt -> 211
    //   74: fconst_0
    //   75: fstore #7
    //   77: iconst_0
    //   78: istore #8
    //   80: iload #8
    //   82: iload_3
    //   83: if_icmpge -> 124
    //   86: aload_1
    //   87: iload #8
    //   89: invokevirtual codePointAt : (I)I
    //   92: invokestatic charCount : (I)I
    //   95: istore #9
    //   97: fload #7
    //   99: aload_0
    //   100: aload_1
    //   101: iload #8
    //   103: iload #8
    //   105: iload #9
    //   107: iadd
    //   108: invokevirtual measureText : (Ljava/lang/String;II)F
    //   111: fadd
    //   112: fstore #7
    //   114: iload #8
    //   116: iload #9
    //   118: iadd
    //   119: istore #8
    //   121: goto -> 80
    //   124: fload #6
    //   126: fload #7
    //   128: fcmpl
    //   129: ifge -> 211
    //   132: iload_2
    //   133: istore #4
    //   135: fload #6
    //   137: fload #5
    //   139: fcmpl
    //   140: ifne -> 26
    //   143: invokestatic obtainEmptyRects : ()Landroid/support/v4/util/Pair;
    //   146: astore #10
    //   148: aload_0
    //   149: ldc '󟿽'
    //   151: iconst_0
    //   152: ldc '󟿽'
    //   154: invokevirtual length : ()I
    //   157: aload #10
    //   159: getfield first : Ljava/lang/Object;
    //   162: checkcast android/graphics/Rect
    //   165: invokevirtual getTextBounds : (Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   168: aload_0
    //   169: aload_1
    //   170: iconst_0
    //   171: iload_3
    //   172: aload #10
    //   174: getfield second : Ljava/lang/Object;
    //   177: checkcast android/graphics/Rect
    //   180: invokevirtual getTextBounds : (Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   183: iload_2
    //   184: istore #4
    //   186: aload #10
    //   188: getfield first : Ljava/lang/Object;
    //   191: checkcast android/graphics/Rect
    //   194: aload #10
    //   196: getfield second : Ljava/lang/Object;
    //   199: invokevirtual equals : (Ljava/lang/Object;)Z
    //   202: ifeq -> 26
    //   205: iconst_0
    //   206: istore #4
    //   208: goto -> 26
    //   211: iconst_0
    //   212: istore #4
    //   214: goto -> 26
  }
  
  private static Pair<Rect, Rect> obtainEmptyRects() {
    Pair<Rect, Rect> pair = sRectThreadLocal.get();
    if (pair == null) {
      pair = new Pair(new Rect(), new Rect());
      sRectThreadLocal.set(pair);
      return pair;
    } 
    ((Rect)pair.first).setEmpty();
    ((Rect)pair.second).setEmpty();
    return pair;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\graphics\PaintCompatGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
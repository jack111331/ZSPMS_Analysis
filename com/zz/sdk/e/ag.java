package com.zz.sdk.e;

import android.widget.ImageView;
import android.widget.TextView;

final class ag {
  int[] a;
  
  ImageView b;
  
  ImageView c;
  
  TextView d;
  
  TextView e;
  
  private ag(af paramaf) {}
  
  public final void a(int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 91
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield a : [I
    //   9: aload_0
    //   10: getfield a : [I
    //   13: ifnull -> 154
    //   16: aload_0
    //   17: getfield a : [I
    //   20: astore_1
    //   21: aload_1
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_3
    //   26: iload_3
    //   27: iload_2
    //   28: if_icmpge -> 154
    //   31: aload_1
    //   32: iload_3
    //   33: iaload
    //   34: istore #4
    //   36: iload #4
    //   38: ldc 16842919
    //   40: if_icmpeq -> 50
    //   43: iload #4
    //   45: ldc 16842913
    //   47: if_icmpne -> 134
    //   50: iconst_1
    //   51: istore_3
    //   52: iload_3
    //   53: ifeq -> 140
    //   56: getstatic com/zz/sdk/i/ce.u : Lcom/zz/sdk/i/ce;
    //   59: astore_1
    //   60: aload_0
    //   61: getfield d : Landroid/widget/TextView;
    //   64: aload_1
    //   65: invokevirtual a : ()I
    //   68: invokevirtual setTextColor : (I)V
    //   71: iload_3
    //   72: ifeq -> 147
    //   75: getstatic com/zz/sdk/i/ce.w : Lcom/zz/sdk/i/ce;
    //   78: astore_1
    //   79: aload_0
    //   80: getfield e : Landroid/widget/TextView;
    //   83: aload_1
    //   84: invokevirtual a : ()I
    //   87: invokevirtual setTextColor : (I)V
    //   90: return
    //   91: aload_0
    //   92: getfield a : [I
    //   95: ifnull -> 109
    //   98: aload_0
    //   99: getfield a : [I
    //   102: aload_1
    //   103: invokestatic equals : ([I[I)Z
    //   106: ifne -> 9
    //   109: aload_1
    //   110: arraylength
    //   111: newarray int
    //   113: astore #5
    //   115: aload_1
    //   116: iconst_0
    //   117: aload #5
    //   119: iconst_0
    //   120: aload_1
    //   121: arraylength
    //   122: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   125: aload_0
    //   126: aload #5
    //   128: putfield a : [I
    //   131: goto -> 9
    //   134: iinc #3, 1
    //   137: goto -> 26
    //   140: getstatic com/zz/sdk/i/ce.t : Lcom/zz/sdk/i/ce;
    //   143: astore_1
    //   144: goto -> 60
    //   147: getstatic com/zz/sdk/i/ce.v : Lcom/zz/sdk/i/ce;
    //   150: astore_1
    //   151: goto -> 79
    //   154: iconst_0
    //   155: istore_3
    //   156: goto -> 52
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
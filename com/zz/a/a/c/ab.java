package com.zz.a.a.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class ab extends BitmapDrawable {
  static final String a = "CountingBitmapDrawable";
  
  private int b = 0;
  
  private int c = 0;
  
  private boolean d;
  
  public ab(Resources paramResources, Bitmap paramBitmap) {
    super(paramResources, paramBitmap);
  }
  
  private void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : I
    //   6: ifgt -> 37
    //   9: aload_0
    //   10: getfield c : I
    //   13: ifgt -> 37
    //   16: aload_0
    //   17: getfield d : Z
    //   20: ifeq -> 37
    //   23: aload_0
    //   24: invokespecial b : ()Z
    //   27: ifeq -> 37
    //   30: aload_0
    //   31: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   34: invokevirtual recycle : ()V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	40	finally
  }
  
  private boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 26
    //   11: aload_1
    //   12: invokevirtual isRecycled : ()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifne -> 26
    //   20: iconst_1
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_2
    //   28: goto -> 22
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	16	31	finally
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 28
    //   6: aload_0
    //   7: aload_0
    //   8: getfield c : I
    //   11: iconst_1
    //   12: iadd
    //   13: putfield c : I
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield d : Z
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: invokespecial a : ()V
    //   27: return
    //   28: aload_0
    //   29: aload_0
    //   30: getfield c : I
    //   33: iconst_1
    //   34: isub
    //   35: putfield c : I
    //   38: goto -> 21
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   6	21	41	finally
    //   21	23	41	finally
    //   28	38	41	finally
    //   42	44	41	finally
  }
  
  public void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 23
    //   6: aload_0
    //   7: aload_0
    //   8: getfield b : I
    //   11: iconst_1
    //   12: iadd
    //   13: putfield b : I
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: invokespecial a : ()V
    //   22: return
    //   23: aload_0
    //   24: aload_0
    //   25: getfield b : I
    //   28: iconst_1
    //   29: isub
    //   30: putfield b : I
    //   33: goto -> 16
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	36	finally
    //   16	18	36	finally
    //   23	33	36	finally
    //   37	39	36	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
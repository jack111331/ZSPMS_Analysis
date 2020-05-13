package com.hu.zxlib.b;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.hu.zxlib.a.a;

public final class e {
  private static final String a = "e";
  
  private static e b;
  
  private final Context c;
  
  private final d d;
  
  private a e;
  
  private Camera f;
  
  private a g;
  
  private Rect h;
  
  private Rect i;
  
  private boolean j;
  
  private boolean k;
  
  private int l = -1;
  
  private int m;
  
  private int n;
  
  private final g o;
  
  public e(Context paramContext, a parama) {
    this.c = paramContext;
    this.d = new d(paramContext);
    this.o = new g(this.d);
    this.e = parama;
  }
  
  public static e g() {
    return b;
  }
  
  public PlanarYUVLuminanceSource a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Rect rect = f();
    if (rect == null)
      return null; 
    if (this.e == null)
      this.e = new a(); 
    return this.e.b() ? new PlanarYUVLuminanceSource(paramArrayOfbyte, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, false) : new PlanarYUVLuminanceSource(paramArrayOfbyte, paramInt1, paramInt2, rect.left, rect.top, rect.width(), rect.height(), false);
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield l : I
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: ifeq -> 143
    //   9: aload_0
    //   10: getfield d : Lcom/hu/zxlib/b/d;
    //   13: invokevirtual b : ()Landroid/graphics/Point;
    //   16: astore_3
    //   17: iload_1
    //   18: istore #4
    //   20: iload_1
    //   21: aload_3
    //   22: getfield x : I
    //   25: if_icmple -> 34
    //   28: aload_3
    //   29: getfield x : I
    //   32: istore #4
    //   34: iload_2
    //   35: istore_1
    //   36: iload_2
    //   37: aload_3
    //   38: getfield y : I
    //   41: if_icmple -> 49
    //   44: aload_3
    //   45: getfield y : I
    //   48: istore_1
    //   49: aload_3
    //   50: getfield x : I
    //   53: iload #4
    //   55: isub
    //   56: iconst_2
    //   57: idiv
    //   58: istore_2
    //   59: aload_3
    //   60: getfield y : I
    //   63: iload_1
    //   64: isub
    //   65: iconst_2
    //   66: idiv
    //   67: istore #5
    //   69: new android/graphics/Rect
    //   72: astore_3
    //   73: aload_3
    //   74: iload_2
    //   75: iload #5
    //   77: iload #4
    //   79: iload_2
    //   80: iadd
    //   81: iload_1
    //   82: iload #5
    //   84: iadd
    //   85: invokespecial <init> : (IIII)V
    //   88: aload_0
    //   89: aload_3
    //   90: putfield h : Landroid/graphics/Rect;
    //   93: getstatic com/hu/zxlib/b/e.a : Ljava/lang/String;
    //   96: astore_3
    //   97: new java/lang/StringBuilder
    //   100: astore #6
    //   102: aload #6
    //   104: invokespecial <init> : ()V
    //   107: aload #6
    //   109: ldc 'Calculated manual framing rect: '
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload #6
    //   117: aload_0
    //   118: getfield h : Landroid/graphics/Rect;
    //   121: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: aload #6
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield i : Landroid/graphics/Rect;
    //   140: goto -> 153
    //   143: aload_0
    //   144: iload_1
    //   145: putfield m : I
    //   148: aload_0
    //   149: iload_2
    //   150: putfield n : I
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: astore_3
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	156	finally
    //   20	34	156	finally
    //   36	49	156	finally
    //   49	140	156	finally
    //   143	153	156	finally
  }
  
  public void a(Handler paramHandler, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/hardware/Camera;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull -> 35
    //   11: aload_0
    //   12: getfield k : Z
    //   15: ifeq -> 35
    //   18: aload_0
    //   19: getfield o : Lcom/hu/zxlib/b/g;
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual a : (Landroid/os/Handler;I)V
    //   27: aload_3
    //   28: aload_0
    //   29: getfield o : Lcom/hu/zxlib/b/g;
    //   32: invokevirtual setOneShotPreviewCallback : (Landroid/hardware/Camera$PreviewCallback;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   11	35	38	finally
  }
  
  public void a(SurfaceHolder paramSurfaceHolder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/hardware/Camera;
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: aload_2
    //   10: ifnonnull -> 57
    //   13: aload_0
    //   14: getfield l : I
    //   17: iflt -> 31
    //   20: aload_0
    //   21: getfield l : I
    //   24: invokestatic a : (I)Landroid/hardware/Camera;
    //   27: astore_3
    //   28: goto -> 35
    //   31: invokestatic a : ()Landroid/hardware/Camera;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull -> 47
    //   39: aload_0
    //   40: aload_3
    //   41: putfield f : Landroid/hardware/Camera;
    //   44: goto -> 57
    //   47: new java/io/IOException
    //   50: astore_1
    //   51: aload_1
    //   52: invokespecial <init> : ()V
    //   55: aload_1
    //   56: athrow
    //   57: aload_3
    //   58: aload_1
    //   59: invokevirtual setPreviewDisplay : (Landroid/view/SurfaceHolder;)V
    //   62: aload_0
    //   63: getfield j : Z
    //   66: ifne -> 118
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield j : Z
    //   74: aload_0
    //   75: getfield d : Lcom/hu/zxlib/b/d;
    //   78: aload_3
    //   79: invokevirtual a : (Landroid/hardware/Camera;)V
    //   82: aload_0
    //   83: getfield m : I
    //   86: ifle -> 118
    //   89: aload_0
    //   90: getfield n : I
    //   93: ifle -> 118
    //   96: aload_0
    //   97: aload_0
    //   98: getfield m : I
    //   101: aload_0
    //   102: getfield n : I
    //   105: invokevirtual a : (II)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield m : I
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield n : I
    //   118: aload_3
    //   119: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnonnull -> 132
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -> 137
    //   132: aload_1
    //   133: invokevirtual flatten : ()Ljava/lang/String;
    //   136: astore_1
    //   137: aload_0
    //   138: getfield d : Lcom/hu/zxlib/b/d;
    //   141: aload_3
    //   142: invokevirtual b : (Landroid/hardware/Camera;)V
    //   145: goto -> 237
    //   148: astore_2
    //   149: getstatic com/hu/zxlib/b/e.a : Ljava/lang/String;
    //   152: ldc 'Camera rejected parameters. Setting only minimal safe-mode parameters'
    //   154: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: getstatic com/hu/zxlib/b/e.a : Ljava/lang/String;
    //   161: astore_2
    //   162: new java/lang/StringBuilder
    //   165: astore #4
    //   167: aload #4
    //   169: invokespecial <init> : ()V
    //   172: aload #4
    //   174: ldc 'Resetting to saved camera params: '
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #4
    //   182: aload_1
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: aload #4
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   196: pop
    //   197: aload_1
    //   198: ifnull -> 237
    //   201: aload_3
    //   202: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   205: astore_2
    //   206: aload_2
    //   207: aload_1
    //   208: invokevirtual unflatten : (Ljava/lang/String;)V
    //   211: aload_3
    //   212: aload_2
    //   213: invokevirtual setParameters : (Landroid/hardware/Camera$Parameters;)V
    //   216: aload_0
    //   217: getfield d : Lcom/hu/zxlib/b/d;
    //   220: aload_3
    //   221: invokevirtual b : (Landroid/hardware/Camera;)V
    //   224: goto -> 237
    //   227: astore_1
    //   228: getstatic com/hu/zxlib/b/e.a : Ljava/lang/String;
    //   231: ldc 'Camera rejected even safe-mode parameters! No configuration'
    //   233: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: aload_0
    //   238: monitorexit
    //   239: return
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	240	finally
    //   13	28	240	finally
    //   31	35	240	finally
    //   39	44	240	finally
    //   47	57	240	finally
    //   57	118	240	finally
    //   118	123	240	finally
    //   132	137	240	finally
    //   137	145	148	java/lang/RuntimeException
    //   137	145	240	finally
    //   149	197	240	finally
    //   201	211	240	finally
    //   211	224	227	java/lang/RuntimeException
    //   211	224	240	finally
    //   228	237	240	finally
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/hardware/Camera;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 16
    //   11: iconst_1
    //   12: istore_2
    //   13: goto -> 18
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/hardware/Camera;
    //   6: ifnull -> 31
    //   9: aload_0
    //   10: getfield f : Landroid/hardware/Camera;
    //   13: invokevirtual release : ()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield f : Landroid/hardware/Camera;
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield h : Landroid/graphics/Rect;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield i : Landroid/graphics/Rect;
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/hardware/Camera;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 44
    //   11: aload_0
    //   12: getfield k : Z
    //   15: ifne -> 44
    //   18: aload_1
    //   19: invokevirtual startPreview : ()V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield k : Z
    //   27: new com/hu/zxlib/b/a
    //   30: astore_1
    //   31: aload_1
    //   32: aload_0
    //   33: getfield f : Landroid/hardware/Camera;
    //   36: invokespecial <init> : (Landroid/hardware/Camera;)V
    //   39: aload_0
    //   40: aload_1
    //   41: putfield g : Lcom/hu/zxlib/b/a;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   11	44	47	finally
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/hu/zxlib/b/a;
    //   6: ifnull -> 21
    //   9: aload_0
    //   10: getfield g : Lcom/hu/zxlib/b/a;
    //   13: invokevirtual b : ()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield g : Lcom/hu/zxlib/b/a;
    //   21: aload_0
    //   22: getfield f : Landroid/hardware/Camera;
    //   25: ifnull -> 56
    //   28: aload_0
    //   29: getfield k : Z
    //   32: ifeq -> 56
    //   35: aload_0
    //   36: getfield f : Landroid/hardware/Camera;
    //   39: invokevirtual stopPreview : ()V
    //   42: aload_0
    //   43: getfield o : Lcom/hu/zxlib/b/g;
    //   46: aconst_null
    //   47: iconst_0
    //   48: invokevirtual a : (Landroid/os/Handler;I)V
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield k : Z
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	59	finally
    //   21	56	59	finally
  }
  
  public Rect e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/graphics/Rect;
    //   6: ifnonnull -> 147
    //   9: aload_0
    //   10: getfield f : Landroid/hardware/Camera;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull -> 22
    //   18: aload_0
    //   19: monitorexit
    //   20: aconst_null
    //   21: areturn
    //   22: aload_0
    //   23: getfield d : Lcom/hu/zxlib/b/d;
    //   26: invokevirtual b : ()Landroid/graphics/Point;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnonnull -> 38
    //   34: aload_0
    //   35: monitorexit
    //   36: aconst_null
    //   37: areturn
    //   38: aload_1
    //   39: getfield x : I
    //   42: istore_2
    //   43: iload_2
    //   44: i2d
    //   45: dstore_3
    //   46: dload_3
    //   47: invokestatic isNaN : (D)Z
    //   50: pop
    //   51: dload_3
    //   52: ldc2_w 0.6
    //   55: dmul
    //   56: d2i
    //   57: istore #5
    //   59: aload_1
    //   60: getfield x : I
    //   63: iload #5
    //   65: isub
    //   66: iconst_2
    //   67: idiv
    //   68: istore #6
    //   70: aload_1
    //   71: getfield y : I
    //   74: iload #5
    //   76: isub
    //   77: iconst_5
    //   78: idiv
    //   79: istore_2
    //   80: new android/graphics/Rect
    //   83: astore_1
    //   84: aload_1
    //   85: iload #6
    //   87: iload_2
    //   88: iload #6
    //   90: iload #5
    //   92: iadd
    //   93: iload #5
    //   95: iload_2
    //   96: iadd
    //   97: invokespecial <init> : (IIII)V
    //   100: aload_0
    //   101: aload_1
    //   102: putfield h : Landroid/graphics/Rect;
    //   105: getstatic com/hu/zxlib/b/e.a : Ljava/lang/String;
    //   108: astore_1
    //   109: new java/lang/StringBuilder
    //   112: astore #7
    //   114: aload #7
    //   116: invokespecial <init> : ()V
    //   119: aload #7
    //   121: ldc 'Calculated framing rect: '
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload #7
    //   129: aload_0
    //   130: getfield h : Landroid/graphics/Rect;
    //   133: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: aload #7
    //   140: invokevirtual toString : ()Ljava/lang/String;
    //   143: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: aload_0
    //   148: getfield h : Landroid/graphics/Rect;
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: areturn
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	156	finally
    //   22	30	156	finally
    //   38	43	156	finally
    //   59	147	156	finally
    //   147	152	156	finally
  }
  
  public Rect f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Landroid/graphics/Rect;
    //   6: ifnonnull -> 142
    //   9: aload_0
    //   10: invokevirtual e : ()Landroid/graphics/Rect;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull -> 22
    //   18: aload_0
    //   19: monitorexit
    //   20: aconst_null
    //   21: areturn
    //   22: new android/graphics/Rect
    //   25: astore_2
    //   26: aload_2
    //   27: aload_1
    //   28: invokespecial <init> : (Landroid/graphics/Rect;)V
    //   31: aload_0
    //   32: getfield d : Lcom/hu/zxlib/b/d;
    //   35: invokevirtual a : ()Landroid/graphics/Point;
    //   38: astore_3
    //   39: aload_0
    //   40: getfield d : Lcom/hu/zxlib/b/d;
    //   43: invokevirtual b : ()Landroid/graphics/Point;
    //   46: astore_1
    //   47: aload_3
    //   48: ifnull -> 138
    //   51: aload_1
    //   52: ifnonnull -> 58
    //   55: goto -> 138
    //   58: aload_2
    //   59: aload_2
    //   60: getfield left : I
    //   63: aload_3
    //   64: getfield y : I
    //   67: imul
    //   68: aload_1
    //   69: getfield x : I
    //   72: idiv
    //   73: putfield left : I
    //   76: aload_2
    //   77: aload_2
    //   78: getfield right : I
    //   81: aload_3
    //   82: getfield y : I
    //   85: imul
    //   86: aload_1
    //   87: getfield x : I
    //   90: idiv
    //   91: putfield right : I
    //   94: aload_2
    //   95: aload_2
    //   96: getfield top : I
    //   99: aload_3
    //   100: getfield x : I
    //   103: imul
    //   104: aload_1
    //   105: getfield y : I
    //   108: idiv
    //   109: putfield top : I
    //   112: aload_2
    //   113: aload_2
    //   114: getfield bottom : I
    //   117: aload_3
    //   118: getfield x : I
    //   121: imul
    //   122: aload_1
    //   123: getfield y : I
    //   126: idiv
    //   127: putfield bottom : I
    //   130: aload_0
    //   131: aload_2
    //   132: putfield i : Landroid/graphics/Rect;
    //   135: goto -> 142
    //   138: aload_0
    //   139: monitorexit
    //   140: aconst_null
    //   141: areturn
    //   142: aload_0
    //   143: getfield i : Landroid/graphics/Rect;
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: areturn
    //   151: astore_2
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_2
    //   155: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	151	finally
    //   22	47	151	finally
    //   58	135	151	finally
    //   142	147	151	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
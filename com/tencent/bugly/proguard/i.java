package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class i {
  private ByteBuffer a;
  
  private String b = "GBK";
  
  public i() {}
  
  public i(byte[] paramArrayOfbyte) {
    this.a = ByteBuffer.wrap(paramArrayOfbyte);
  }
  
  public i(byte[] paramArrayOfbyte, int paramInt) {
    this.a = ByteBuffer.wrap(paramArrayOfbyte);
    this.a.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 12) {
        switch (paramInt) {
          default:
            throw new g("type mismatch.");
          case 5:
            return this.a.getDouble();
          case 4:
            break;
        } 
        paramDouble = this.a.getFloat();
      } else {
        paramDouble = 0.0D;
      } 
    } else if (paramBoolean) {
      throw new g("require field not exist.");
    } 
    return paramDouble;
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 4) {
        if (paramInt == 12) {
          paramFloat = 0.0F;
        } else {
          throw new g("type mismatch.");
        } 
      } else {
        paramFloat = this.a.getFloat();
      } 
    } else if (paramBoolean) {
      throw new g("require field not exist.");
    } 
    return paramFloat;
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer) {
    byte b = paramByteBuffer.get();
    parama.a = (byte)(byte)(b & 0xF);
    parama.b = (b & 0xF0) >> 4;
    if (parama.b == 15) {
      parama.b = paramByteBuffer.get();
      return 2;
    } 
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder;
    if (paramMap2 == null || paramMap2.isEmpty())
      return new HashMap<K, V>(); 
    Map.Entry entry = paramMap2.entrySet().iterator().next();
    paramMap2 = (Map<K, V>)entry.getKey();
    Object object = entry.getValue();
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 8) {
        int j = a(0, 0, true);
        if (j >= 0) {
          for (paramInt = 0; paramInt < j; paramInt++)
            paramMap1.put((K)a(paramMap2, 0, true), (V)a(object, 1, true)); 
        } else {
          stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else if (paramBoolean) {
      throw new g("require field not exist.");
    } 
    return (Map<K, V>)stringBuilder;
  }
  
  private void a() {
    a a = new a();
    do {
      a(a, this.a);
      a(a.a);
    } while (a.a != 11);
  }
  
  private void a(byte paramByte) {
    int j;
    a a;
    StringBuilder stringBuilder;
    int k = 0;
    int m = 0;
    switch (paramByte) {
      default:
        throw new g("invalid type.");
      case 13:
        a = new a();
        a(a, this.a);
        if (a.a == 0) {
          j = a(0, 0, true);
          this.a.position(this.a.position() + j);
          return;
        } 
        stringBuilder = new StringBuilder("skipField with invalid type, type value: ");
        stringBuilder.append(j);
        stringBuilder.append(", ");
        stringBuilder.append(a.a);
        throw new g(stringBuilder.toString());
      case 11:
      case 12:
        return;
      case 10:
        a();
        return;
      case 9:
        k = a(0, 0, true);
        for (j = m; j < k; j++) {
          a a1 = new a();
          a(a1, this.a);
          a(a1.a);
        } 
        return;
      case 8:
        m = a(0, 0, true);
        for (j = k; j < m << 1; j++) {
          a a1 = new a();
          a(a1, this.a);
          a(a1.a);
        } 
        return;
      case 7:
        j = this.a.getInt();
        this.a.position(this.a.position() + j);
        return;
      case 6:
        m = this.a.get();
        j = m;
        if (m < 0)
          j = m + 256; 
        this.a.position(this.a.position() + j);
        return;
      case 5:
        this.a.position(this.a.position() + 8);
        return;
      case 4:
        this.a.position(this.a.position() + 4);
        return;
      case 3:
        this.a.position(this.a.position() + 8);
        return;
      case 2:
        this.a.position(this.a.position() + 4);
        return;
      case 1:
        this.a.position(this.a.position() + 2);
        return;
      case 0:
        break;
    } 
    this.a.position(this.a.position() + 1);
  }
  
  private boolean a(int paramInt) {
    try {
      a a = new a();
      this();
      while (true) {
        int k = a(a, this.a.duplicate());
        if (paramInt <= a.b || a.a == 11)
          break; 
        this.a.position(this.a.position() + k);
        a(a.a);
      } 
      int j = a.b;
      return (paramInt == j);
    } catch (g|java.nio.BufferUnderflowException g) {
      return false;
    } 
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean) {
    if (paramArrayOfT != null && paramArrayOfT.length != 0)
      return b(paramArrayOfT[0], paramInt, paramBoolean); 
    throw new g("unable to get type of key and value.");
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), j);
          for (paramInt = 0; paramInt < j; paramInt++)
            arrayOfObject[paramInt] = a(paramT, 0, true); 
          return (T[])arrayOfObject;
        } 
        StringBuilder stringBuilder = new StringBuilder("size invalid: ");
        stringBuilder.append(j);
        throw new g(stringBuilder.toString());
      } 
      throw new g("type mismatch.");
    } 
    if (!paramBoolean)
      return null; 
    throw new g("require field not exist.");
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          boolean[] arrayOfBoolean = new boolean[j];
          paramInt = 0;
          while (true) {
            boolean[] arrayOfBoolean1 = arrayOfBoolean;
            if (paramInt < j) {
              if (a((byte)0, 0, true) != 0) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              } 
              arrayOfBoolean[paramInt] = paramBoolean;
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (boolean[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  private short[] e(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          short[] arrayOfShort = new short[j];
          paramInt = 0;
          while (true) {
            short[] arrayOfShort1 = arrayOfShort;
            if (paramInt < j) {
              arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (short[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  private int[] f(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          int[] arrayOfInt = new int[j];
          paramInt = 0;
          while (true) {
            int[] arrayOfInt1 = arrayOfInt;
            if (paramInt < j) {
              arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (int[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  private long[] g(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          long[] arrayOfLong = new long[j];
          paramInt = 0;
          while (true) {
            long[] arrayOfLong1 = arrayOfLong;
            if (paramInt < j) {
              arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (long[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  private float[] h(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          float[] arrayOfFloat = new float[j];
          paramInt = 0;
          while (true) {
            float[] arrayOfFloat1 = arrayOfFloat;
            if (paramInt < j) {
              arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (float[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  private double[] i(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          double[] arrayOfDouble = new double[j];
          paramInt = 0;
          while (true) {
            double[] arrayOfDouble1 = arrayOfDouble;
            if (paramInt < j) {
              arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (double[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramByte = a.a;
      if (paramByte != 0) {
        if (paramByte == 12) {
          paramByte = 0;
          byte b = paramByte;
        } else {
          throw new g("type mismatch.");
        } 
      } else {
        paramByte = this.a.get();
        byte b = paramByte;
      } 
    } else {
      if (!paramBoolean)
        return paramByte; 
      throw new g("require field not exist.");
    } 
    return SYNTHETIC_LOCAL_VARIABLE_5;
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (a(paramInt2)) {
      a a = new a();
      a(a, this.a);
      paramInt1 = a.a;
      if (paramInt1 != 12) {
        switch (paramInt1) {
          default:
            throw new g("type mismatch.");
          case 2:
            return this.a.getInt();
          case 1:
            return this.a.getShort();
          case 0:
            break;
        } 
        paramInt1 = this.a.get();
      } else {
        paramInt1 = 0;
      } 
    } else if (paramBoolean) {
      throw new g("require field not exist.");
    } 
    return paramInt1;
  }
  
  public final int a(String paramString) {
    this.b = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 12) {
        switch (paramInt) {
          default:
            throw new g("type mismatch.");
          case 3:
            return this.a.getLong();
          case 2:
            return this.a.getInt();
          case 1:
            return this.a.getShort();
          case 0:
            break;
        } 
        paramLong = this.a.get();
      } else {
        paramLong = 0L;
      } 
    } else if (paramBoolean) {
      throw new g("require field not exist.");
    } 
    return paramLong;
  }
  
  public final k a(k paramk, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      try {
        paramk = (k)paramk.getClass().newInstance();
        a a = new a();
        a(a, this.a);
        if (a.a == 10) {
          paramk.a(this);
          a();
        } else {
          throw new g("type mismatch.");
        } 
      } catch (Exception exception) {
        throw new g(exception.getMessage());
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return paramk;
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof java/lang/Byte
    //   4: istore #4
    //   6: iconst_0
    //   7: istore #5
    //   9: iconst_0
    //   10: istore #6
    //   12: iload #4
    //   14: ifeq -> 28
    //   17: aload_0
    //   18: iconst_0
    //   19: iload_2
    //   20: iload_3
    //   21: invokevirtual a : (BIZ)B
    //   24: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   27: areturn
    //   28: aload_1
    //   29: instanceof java/lang/Boolean
    //   32: ifeq -> 54
    //   35: aload_0
    //   36: iconst_0
    //   37: iload_2
    //   38: iload_3
    //   39: invokevirtual a : (BIZ)B
    //   42: ifeq -> 48
    //   45: iconst_1
    //   46: istore #6
    //   48: iload #6
    //   50: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   53: areturn
    //   54: aload_1
    //   55: instanceof java/lang/Short
    //   58: ifeq -> 72
    //   61: aload_0
    //   62: iconst_0
    //   63: iload_2
    //   64: iload_3
    //   65: invokevirtual a : (SIZ)S
    //   68: invokestatic valueOf : (S)Ljava/lang/Short;
    //   71: areturn
    //   72: aload_1
    //   73: instanceof java/lang/Integer
    //   76: ifeq -> 90
    //   79: aload_0
    //   80: iconst_0
    //   81: iload_2
    //   82: iload_3
    //   83: invokevirtual a : (IIZ)I
    //   86: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   89: areturn
    //   90: aload_1
    //   91: instanceof java/lang/Long
    //   94: ifeq -> 108
    //   97: aload_0
    //   98: lconst_0
    //   99: iload_2
    //   100: iload_3
    //   101: invokevirtual a : (JIZ)J
    //   104: invokestatic valueOf : (J)Ljava/lang/Long;
    //   107: areturn
    //   108: aload_1
    //   109: instanceof java/lang/Float
    //   112: ifeq -> 126
    //   115: aload_0
    //   116: fconst_0
    //   117: iload_2
    //   118: iload_3
    //   119: invokespecial a : (FIZ)F
    //   122: invokestatic valueOf : (F)Ljava/lang/Float;
    //   125: areturn
    //   126: aload_1
    //   127: instanceof java/lang/Double
    //   130: ifeq -> 144
    //   133: aload_0
    //   134: dconst_0
    //   135: iload_2
    //   136: iload_3
    //   137: invokespecial a : (DIZ)D
    //   140: invokestatic valueOf : (D)Ljava/lang/Double;
    //   143: areturn
    //   144: aload_1
    //   145: instanceof java/lang/String
    //   148: ifeq -> 161
    //   151: aload_0
    //   152: iload_2
    //   153: iload_3
    //   154: invokevirtual b : (IZ)Ljava/lang/String;
    //   157: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   160: areturn
    //   161: aload_1
    //   162: instanceof java/util/Map
    //   165: ifeq -> 191
    //   168: aload_1
    //   169: checkcast java/util/Map
    //   172: astore_1
    //   173: aload_0
    //   174: new java/util/HashMap
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: aload_1
    //   182: iload_2
    //   183: iload_3
    //   184: invokespecial a : (Ljava/util/Map;Ljava/util/Map;IZ)Ljava/util/Map;
    //   187: checkcast java/util/HashMap
    //   190: areturn
    //   191: aload_1
    //   192: instanceof java/util/List
    //   195: ifeq -> 283
    //   198: aload_1
    //   199: checkcast java/util/List
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull -> 275
    //   207: aload_1
    //   208: invokeinterface isEmpty : ()Z
    //   213: ifeq -> 219
    //   216: goto -> 275
    //   219: aload_0
    //   220: aload_1
    //   221: iconst_0
    //   222: invokeinterface get : (I)Ljava/lang/Object;
    //   227: iload_2
    //   228: iload_3
    //   229: invokespecial b : (Ljava/lang/Object;IZ)[Ljava/lang/Object;
    //   232: astore_1
    //   233: aload_1
    //   234: ifnonnull -> 239
    //   237: aconst_null
    //   238: areturn
    //   239: new java/util/ArrayList
    //   242: dup
    //   243: invokespecial <init> : ()V
    //   246: astore #7
    //   248: iload #5
    //   250: istore_2
    //   251: iload_2
    //   252: aload_1
    //   253: arraylength
    //   254: if_icmpge -> 272
    //   257: aload #7
    //   259: aload_1
    //   260: iload_2
    //   261: aaload
    //   262: invokevirtual add : (Ljava/lang/Object;)Z
    //   265: pop
    //   266: iinc #2, 1
    //   269: goto -> 251
    //   272: aload #7
    //   274: areturn
    //   275: new java/util/ArrayList
    //   278: dup
    //   279: invokespecial <init> : ()V
    //   282: areturn
    //   283: aload_1
    //   284: instanceof com/tencent/bugly/proguard/k
    //   287: ifeq -> 301
    //   290: aload_0
    //   291: aload_1
    //   292: checkcast com/tencent/bugly/proguard/k
    //   295: iload_2
    //   296: iload_3
    //   297: invokevirtual a : (Lcom/tencent/bugly/proguard/k;IZ)Lcom/tencent/bugly/proguard/k;
    //   300: areturn
    //   301: aload_1
    //   302: invokevirtual getClass : ()Ljava/lang/Class;
    //   305: invokevirtual isArray : ()Z
    //   308: ifeq -> 430
    //   311: aload_1
    //   312: instanceof [B
    //   315: ifne -> 423
    //   318: aload_1
    //   319: instanceof [Ljava/lang/Byte;
    //   322: ifeq -> 328
    //   325: goto -> 423
    //   328: aload_1
    //   329: instanceof [Z
    //   332: ifeq -> 342
    //   335: aload_0
    //   336: iload_2
    //   337: iload_3
    //   338: invokespecial d : (IZ)[Z
    //   341: areturn
    //   342: aload_1
    //   343: instanceof [S
    //   346: ifeq -> 356
    //   349: aload_0
    //   350: iload_2
    //   351: iload_3
    //   352: invokespecial e : (IZ)[S
    //   355: areturn
    //   356: aload_1
    //   357: instanceof [I
    //   360: ifeq -> 370
    //   363: aload_0
    //   364: iload_2
    //   365: iload_3
    //   366: invokespecial f : (IZ)[I
    //   369: areturn
    //   370: aload_1
    //   371: instanceof [J
    //   374: ifeq -> 384
    //   377: aload_0
    //   378: iload_2
    //   379: iload_3
    //   380: invokespecial g : (IZ)[J
    //   383: areturn
    //   384: aload_1
    //   385: instanceof [F
    //   388: ifeq -> 398
    //   391: aload_0
    //   392: iload_2
    //   393: iload_3
    //   394: invokespecial h : (IZ)[F
    //   397: areturn
    //   398: aload_1
    //   399: instanceof [D
    //   402: ifeq -> 412
    //   405: aload_0
    //   406: iload_2
    //   407: iload_3
    //   408: invokespecial i : (IZ)[D
    //   411: areturn
    //   412: aload_0
    //   413: aload_1
    //   414: checkcast [Ljava/lang/Object;
    //   417: iload_2
    //   418: iload_3
    //   419: invokespecial a : ([Ljava/lang/Object;IZ)[Ljava/lang/Object;
    //   422: areturn
    //   423: aload_0
    //   424: iload_2
    //   425: iload_3
    //   426: invokevirtual c : (IZ)[B
    //   429: areturn
    //   430: new com/tencent/bugly/proguard/g
    //   433: dup
    //   434: ldc_w 'read object error: unsupport type.'
    //   437: invokespecial <init> : (Ljava/lang/String;)V
    //   440: athrow
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean) {
    return (HashMap<K, V>)a(new HashMap<K, V>(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramShort = a.a;
      if (paramShort != 12) {
        switch (paramShort) {
          default:
            throw new g("type mismatch.");
          case 1:
            paramShort = this.a.getShort();
            return paramShort;
          case 0:
            break;
        } 
        paramShort = (short)this.a.get();
        short s = paramShort;
      } else {
        paramShort = 0;
        short s = paramShort;
      } 
    } else {
      if (!paramBoolean)
        return paramShort; 
      throw new g("require field not exist.");
    } 
    return SYNTHETIC_LOCAL_VARIABLE_5;
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    if (this.a != null)
      this.a.clear(); 
    this.a = ByteBuffer.wrap(paramArrayOfbyte);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean) {
    return (a((byte)0, paramInt, paramBoolean) != 0);
  }
  
  public final String b(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      StringBuilder stringBuilder;
      a a = new a();
      a(a, this.a);
      switch (a.a) {
        default:
          throw new g("type mismatch.");
        case 7:
          paramInt = this.a.getInt();
          if (paramInt <= 104857600 && paramInt >= 0) {
            byte[] arrayOfByte1 = new byte[paramInt];
            this.a.get(arrayOfByte1);
            try {
              String str = new String();
              this(arrayOfByte1, this.b);
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
              String str = new String(arrayOfByte1);
            } 
          } else {
            stringBuilder = new StringBuilder("String too long: ");
            stringBuilder.append(paramInt);
            throw new g(stringBuilder.toString());
          } 
          return (String)stringBuilder;
        case 6:
          break;
      } 
      byte b = this.a.get();
      paramInt = b;
      if (b < 0)
        paramInt = b + 256; 
      byte[] arrayOfByte = new byte[paramInt];
      this.a.get(arrayOfByte);
      try {
        String str = new String();
        this(arrayOfByte, this.b);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        String str = new String(arrayOfByte);
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (String)SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      byte b = a.a;
      if (b != 9) {
        if (b == 13) {
          byte[] arrayOfByte;
          a a1 = new a();
          a(a1, this.a);
          if (a1.a == 0) {
            int j = a(0, 0, true);
            if (j >= 0) {
              arrayOfByte = new byte[j];
              this.a.get(arrayOfByte);
            } else {
              StringBuilder stringBuilder = new StringBuilder("invalid size, tag: ");
              stringBuilder.append(paramInt);
              stringBuilder.append(", type: ");
              stringBuilder.append(((a)arrayOfByte).a);
              stringBuilder.append(", ");
              stringBuilder.append(a1.a);
              stringBuilder.append(", size: ");
              stringBuilder.append(j);
              throw new g(stringBuilder.toString());
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder("type mismatch, tag: ");
            stringBuilder.append(paramInt);
            stringBuilder.append(", type: ");
            stringBuilder.append(((a)arrayOfByte).a);
            stringBuilder.append(", ");
            stringBuilder.append(a1.a);
            throw new g(stringBuilder.toString());
          } 
        } else {
          throw new g("type mismatch.");
        } 
      } else {
        int j = a(0, 0, true);
        if (j >= 0) {
          byte[] arrayOfByte = new byte[j];
          for (paramInt = 0; paramInt < j; paramInt++)
            arrayOfByte[paramInt] = a(arrayOfByte[0], 0, true); 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (byte[])SYNTHETIC_LOCAL_VARIABLE_3;
  }
  
  public static final class a {
    public byte a;
    
    public int b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V> {
  private static final int BASE_SIZE = 4;
  
  private static final int CACHE_SIZE = 10;
  
  private static final boolean DEBUG = false;
  
  private static final String TAG = "ArrayMap";
  
  static Object[] mBaseCache;
  
  static int mBaseCacheSize;
  
  static Object[] mTwiceBaseCache;
  
  static int mTwiceBaseCacheSize;
  
  Object[] mArray;
  
  int[] mHashes;
  
  int mSize;
  
  public SimpleArrayMap() {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }
  
  public SimpleArrayMap(int paramInt) {
    if (paramInt == 0) {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    } else {
      allocArrays(paramInt);
    } 
    this.mSize = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    this();
    if (paramSimpleArrayMap != null)
      putAll(paramSimpleArrayMap); 
  }
  
  private void allocArrays(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 92
    //   6: ldc android/support/v4/util/ArrayMap
    //   8: monitorenter
    //   9: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   12: ifnull -> 63
    //   15: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield mArray : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   33: aload_0
    //   34: aload_2
    //   35: iconst_1
    //   36: aaload
    //   37: checkcast [I
    //   40: putfield mHashes : [I
    //   43: aload_2
    //   44: iconst_1
    //   45: aconst_null
    //   46: aastore
    //   47: aload_2
    //   48: iconst_0
    //   49: aconst_null
    //   50: aastore
    //   51: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   54: iconst_1
    //   55: isub
    //   56: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   59: ldc android/support/v4/util/ArrayMap
    //   61: monitorexit
    //   62: return
    //   63: ldc android/support/v4/util/ArrayMap
    //   65: monitorexit
    //   66: aload_0
    //   67: iload_1
    //   68: newarray int
    //   70: putfield mHashes : [I
    //   73: aload_0
    //   74: iload_1
    //   75: iconst_1
    //   76: ishl
    //   77: anewarray java/lang/Object
    //   80: putfield mArray : [Ljava/lang/Object;
    //   83: goto -> 62
    //   86: astore_2
    //   87: ldc android/support/v4/util/ArrayMap
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: iload_1
    //   93: iconst_4
    //   94: if_icmpne -> 66
    //   97: ldc android/support/v4/util/ArrayMap
    //   99: monitorenter
    //   100: getstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   103: ifnull -> 162
    //   106: getstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   109: astore_2
    //   110: aload_0
    //   111: aload_2
    //   112: putfield mArray : [Ljava/lang/Object;
    //   115: aload_2
    //   116: iconst_0
    //   117: aaload
    //   118: checkcast [Ljava/lang/Object;
    //   121: putstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   124: aload_0
    //   125: aload_2
    //   126: iconst_1
    //   127: aaload
    //   128: checkcast [I
    //   131: putfield mHashes : [I
    //   134: aload_2
    //   135: iconst_1
    //   136: aconst_null
    //   137: aastore
    //   138: aload_2
    //   139: iconst_0
    //   140: aconst_null
    //   141: aastore
    //   142: getstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   145: iconst_1
    //   146: isub
    //   147: putstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   150: ldc android/support/v4/util/ArrayMap
    //   152: monitorexit
    //   153: goto -> 62
    //   156: astore_2
    //   157: ldc android/support/v4/util/ArrayMap
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: ldc android/support/v4/util/ArrayMap
    //   164: monitorexit
    //   165: goto -> 66
    // Exception table:
    //   from	to	target	type
    //   9	43	86	finally
    //   51	62	86	finally
    //   63	66	86	finally
    //   87	90	86	finally
    //   100	134	156	finally
    //   142	153	156	finally
    //   157	160	156	finally
    //   162	165	156	finally
  }
  
  private static void freeArrays(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 71
    //   7: ldc android/support/v4/util/ArrayMap
    //   9: monitorenter
    //   10: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   13: bipush #10
    //   15: if_icmpge -> 61
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: ishl
    //   31: iconst_1
    //   32: isub
    //   33: istore_2
    //   34: iload_2
    //   35: iconst_2
    //   36: if_icmplt -> 49
    //   39: aload_1
    //   40: iload_2
    //   41: aconst_null
    //   42: aastore
    //   43: iinc #2, -1
    //   46: goto -> 34
    //   49: aload_1
    //   50: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   53: getstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   56: iconst_1
    //   57: iadd
    //   58: putstatic android/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   61: ldc android/support/v4/util/ArrayMap
    //   63: monitorexit
    //   64: return
    //   65: astore_0
    //   66: ldc android/support/v4/util/ArrayMap
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    //   71: aload_0
    //   72: arraylength
    //   73: iconst_4
    //   74: if_icmpne -> 64
    //   77: ldc android/support/v4/util/ArrayMap
    //   79: monitorenter
    //   80: getstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   83: bipush #10
    //   85: if_icmpge -> 131
    //   88: aload_1
    //   89: iconst_0
    //   90: getstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   93: aastore
    //   94: aload_1
    //   95: iconst_1
    //   96: aload_0
    //   97: aastore
    //   98: iload_2
    //   99: iconst_1
    //   100: ishl
    //   101: iconst_1
    //   102: isub
    //   103: istore_2
    //   104: iload_2
    //   105: iconst_2
    //   106: if_icmplt -> 119
    //   109: aload_1
    //   110: iload_2
    //   111: aconst_null
    //   112: aastore
    //   113: iinc #2, -1
    //   116: goto -> 104
    //   119: aload_1
    //   120: putstatic android/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   123: getstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   126: iconst_1
    //   127: iadd
    //   128: putstatic android/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   131: ldc android/support/v4/util/ArrayMap
    //   133: monitorexit
    //   134: goto -> 64
    //   137: astore_0
    //   138: ldc android/support/v4/util/ArrayMap
    //   140: monitorexit
    //   141: aload_0
    //   142: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	65	finally
    //   49	61	65	finally
    //   61	64	65	finally
    //   66	69	65	finally
    //   80	94	137	finally
    //   119	131	137	finally
    //   131	134	137	finally
    //   138	141	137	finally
  }
  
  public void clear() {
    if (this.mSize != 0) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    } 
  }
  
  public boolean containsKey(Object paramObject) {
    return (indexOfKey(paramObject) >= 0);
  }
  
  public boolean containsValue(Object paramObject) {
    return (indexOfValue(paramObject) >= 0);
  }
  
  public void ensureCapacity(int paramInt) {
    if (this.mHashes.length < paramInt) {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize << 1);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    if (this == paramObject)
      return true; 
    if (paramObject instanceof SimpleArrayMap) {
      SimpleArrayMap simpleArrayMap = (SimpleArrayMap)paramObject;
      boolean bool = bool1;
      if (size() == simpleArrayMap.size()) {
        byte b = 0;
        try {
          while (true) {
            if (b < this.mSize) {
              K k = keyAt(b);
              V v = valueAt(b);
              paramObject = simpleArrayMap.get(k);
              if (v == null) {
                bool = bool1;
                if (paramObject == null) {
                  bool = bool1;
                  if (simpleArrayMap.containsKey(k))
                    continue; 
                } 
                return bool;
              } 
              bool = v.equals(paramObject);
              if (!bool)
                return bool1; 
              continue;
            } 
            return true;
            b++;
          } 
        } catch (NullPointerException nullPointerException) {
          bool = bool1;
        } catch (ClassCastException classCastException) {
          bool = bool1;
        } 
      } 
      return bool;
    } 
    boolean bool2 = bool1;
    if (classCastException instanceof Map) {
      Map map = (Map)classCastException;
      bool2 = bool1;
      if (size() == map.size()) {
        byte b = 0;
        try {
          while (true) {
            if (b < this.mSize) {
              K k = keyAt(b);
              classCastException = (ClassCastException)valueAt(b);
              Object object = map.get(k);
              if (classCastException == null) {
                bool2 = bool1;
                if (object == null) {
                  bool2 = bool1;
                  if (map.containsKey(k))
                    continue; 
                } 
                return bool2;
              } 
              bool2 = classCastException.equals(object);
              if (!bool2)
                return bool1; 
              continue;
            } 
            return true;
            b++;
          } 
        } catch (NullPointerException nullPointerException) {
          bool2 = bool1;
        } catch (ClassCastException classCastException1) {
          bool2 = bool1;
        } 
      } 
    } 
    return bool2;
  }
  
  public V get(Object paramObject) {
    int i = indexOfKey(paramObject);
    return (V)((i >= 0) ? this.mArray[(i << 1) + 1] : null);
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int i = this.mSize;
    int j = 0;
    byte b = 0;
    boolean bool = true;
    while (b < i) {
      int m;
      Object object = arrayOfObject[bool];
      int k = arrayOfInt[b];
      if (object == null) {
        m = 0;
      } else {
        m = object.hashCode();
      } 
      bool += true;
      b++;
      j = (m ^ k) + j;
    } 
    return j;
  }
  
  int indexOf(Object paramObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mSize : I
    //   4: istore_3
    //   5: iload_3
    //   6: ifne -> 15
    //   9: iconst_m1
    //   10: istore #4
    //   12: iload #4
    //   14: ireturn
    //   15: aload_0
    //   16: getfield mHashes : [I
    //   19: iload_3
    //   20: iload_2
    //   21: invokestatic binarySearch : ([III)I
    //   24: istore #5
    //   26: iload #5
    //   28: istore #4
    //   30: iload #5
    //   32: iflt -> 12
    //   35: iload #5
    //   37: istore #4
    //   39: aload_1
    //   40: aload_0
    //   41: getfield mArray : [Ljava/lang/Object;
    //   44: iload #5
    //   46: iconst_1
    //   47: ishl
    //   48: aaload
    //   49: invokevirtual equals : (Ljava/lang/Object;)Z
    //   52: ifne -> 12
    //   55: iload #5
    //   57: iconst_1
    //   58: iadd
    //   59: istore #6
    //   61: iload #6
    //   63: iload_3
    //   64: if_icmpge -> 107
    //   67: aload_0
    //   68: getfield mHashes : [I
    //   71: iload #6
    //   73: iaload
    //   74: iload_2
    //   75: if_icmpne -> 107
    //   78: aload_1
    //   79: aload_0
    //   80: getfield mArray : [Ljava/lang/Object;
    //   83: iload #6
    //   85: iconst_1
    //   86: ishl
    //   87: aaload
    //   88: invokevirtual equals : (Ljava/lang/Object;)Z
    //   91: ifeq -> 101
    //   94: iload #6
    //   96: istore #4
    //   98: goto -> 12
    //   101: iinc #6, 1
    //   104: goto -> 61
    //   107: iinc #5, -1
    //   110: iload #5
    //   112: iflt -> 152
    //   115: aload_0
    //   116: getfield mHashes : [I
    //   119: iload #5
    //   121: iaload
    //   122: iload_2
    //   123: if_icmpne -> 152
    //   126: iload #5
    //   128: istore #4
    //   130: aload_1
    //   131: aload_0
    //   132: getfield mArray : [Ljava/lang/Object;
    //   135: iload #5
    //   137: iconst_1
    //   138: ishl
    //   139: aaload
    //   140: invokevirtual equals : (Ljava/lang/Object;)Z
    //   143: ifne -> 12
    //   146: iinc #5, -1
    //   149: goto -> 110
    //   152: iload #6
    //   154: iconst_m1
    //   155: ixor
    //   156: istore #4
    //   158: goto -> 12
  }
  
  public int indexOfKey(Object paramObject) {
    return (paramObject == null) ? indexOfNull() : indexOf(paramObject, paramObject.hashCode());
  }
  
  int indexOfNull() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mSize : I
    //   4: istore_1
    //   5: iload_1
    //   6: ifne -> 13
    //   9: iconst_m1
    //   10: istore_2
    //   11: iload_2
    //   12: ireturn
    //   13: aload_0
    //   14: getfield mHashes : [I
    //   17: iload_1
    //   18: iconst_0
    //   19: invokestatic binarySearch : ([III)I
    //   22: istore_3
    //   23: iload_3
    //   24: istore_2
    //   25: iload_3
    //   26: iflt -> 11
    //   29: iload_3
    //   30: istore_2
    //   31: aload_0
    //   32: getfield mArray : [Ljava/lang/Object;
    //   35: iload_3
    //   36: iconst_1
    //   37: ishl
    //   38: aaload
    //   39: ifnull -> 11
    //   42: iload_3
    //   43: iconst_1
    //   44: iadd
    //   45: istore #4
    //   47: iload #4
    //   49: iload_1
    //   50: if_icmpge -> 87
    //   53: aload_0
    //   54: getfield mHashes : [I
    //   57: iload #4
    //   59: iaload
    //   60: ifne -> 87
    //   63: aload_0
    //   64: getfield mArray : [Ljava/lang/Object;
    //   67: iload #4
    //   69: iconst_1
    //   70: ishl
    //   71: aaload
    //   72: ifnonnull -> 81
    //   75: iload #4
    //   77: istore_2
    //   78: goto -> 11
    //   81: iinc #4, 1
    //   84: goto -> 47
    //   87: iinc #3, -1
    //   90: iload_3
    //   91: iflt -> 122
    //   94: aload_0
    //   95: getfield mHashes : [I
    //   98: iload_3
    //   99: iaload
    //   100: ifne -> 122
    //   103: iload_3
    //   104: istore_2
    //   105: aload_0
    //   106: getfield mArray : [Ljava/lang/Object;
    //   109: iload_3
    //   110: iconst_1
    //   111: ishl
    //   112: aaload
    //   113: ifnull -> 11
    //   116: iinc #3, -1
    //   119: goto -> 90
    //   122: iload #4
    //   124: iconst_m1
    //   125: ixor
    //   126: istore_2
    //   127: goto -> 11
  }
  
  int indexOfValue(Object paramObject) {
    int i = 1;
    byte b = 1;
    int j = this.mSize * 2;
    Object[] arrayOfObject = this.mArray;
    if (paramObject == null) {
      for (i = b; i < j; i += 2) {
        if (arrayOfObject[i] == null) {
          i >>= 1;
          return i;
        } 
      } 
    } else {
      while (i < j) {
        if (paramObject.equals(arrayOfObject[i])) {
          i >>= 1;
          return i;
        } 
        i += 2;
      } 
    } 
    for (i = -1; i < j; i += 2) {
      if (arrayOfObject[i] == null) {
        i >>= 1;
        return i;
      } 
    } 
  }
  
  public boolean isEmpty() {
    return (this.mSize <= 0);
  }
  
  public K keyAt(int paramInt) {
    return (K)this.mArray[paramInt << 1];
  }
  
  public V put(K paramK, V paramV) {
    int i;
    int j;
    byte b = 4;
    if (paramK == null) {
      i = indexOfNull();
      j = 0;
    } else {
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    } 
    if (i >= 0) {
      i = (i << 1) + 1;
      paramK = (K)this.mArray[i];
      this.mArray[i] = paramV;
      return (V)paramK;
    } 
    int k = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length) {
      if (this.mSize >= 8) {
        i = this.mSize + (this.mSize >> 1);
      } else {
        i = b;
        if (this.mSize >= 4)
          i = 8; 
      } 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
    if (k < this.mSize) {
      System.arraycopy(this.mHashes, k, this.mHashes, k + 1, this.mSize - k);
      System.arraycopy(this.mArray, k << 1, this.mArray, k + 1 << 1, this.mSize - k << 1);
    } 
    this.mHashes[k] = j;
    this.mArray[k << 1] = paramK;
    this.mArray[(k << 1) + 1] = paramV;
    this.mSize++;
    return null;
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    byte b = 0;
    int i = paramSimpleArrayMap.mSize;
    ensureCapacity(this.mSize + i);
    if (this.mSize == 0) {
      if (i > 0) {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, i);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
        this.mSize = i;
      } 
      return;
    } 
    while (true) {
      if (b < i) {
        put(paramSimpleArrayMap.keyAt(b), paramSimpleArrayMap.valueAt(b));
        b++;
        continue;
      } 
      return;
    } 
  }
  
  public V remove(Object paramObject) {
    int i = indexOfKey(paramObject);
    return (i >= 0) ? removeAt(i) : null;
  }
  
  public V removeAt(int paramInt) {
    int i = 8;
    Object object = this.mArray[(paramInt << 1) + 1];
    if (this.mSize <= 1) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
      return (V)object;
    } 
    if (this.mHashes.length > 8 && this.mSize < this.mHashes.length / 3) {
      if (this.mSize > 8)
        i = this.mSize + (this.mSize >> 1); 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      this.mSize--;
      if (paramInt > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt << 1);
      } 
      if (paramInt < this.mSize) {
        System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
      } 
      return (V)object;
    } 
    this.mSize--;
    if (paramInt < this.mSize) {
      System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
    } 
    this.mArray[this.mSize << 1] = null;
    this.mArray[(this.mSize << 1) + 1] = null;
    return (V)object;
  }
  
  public V setValueAt(int paramInt, V paramV) {
    paramInt = (paramInt << 1) + 1;
    Object object = this.mArray[paramInt];
    this.mArray[paramInt] = paramV;
    return (V)object;
  }
  
  public int size() {
    return this.mSize;
  }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
    stringBuilder.append('{');
    for (byte b = 0; b < this.mSize; b++) {
      if (b > 0)
        stringBuilder.append(", "); 
      V v = (V)keyAt(b);
      if (v != this) {
        stringBuilder.append(v);
      } else {
        stringBuilder.append("(this Map)");
      } 
      stringBuilder.append('=');
      v = valueAt(b);
      if (v != this) {
        stringBuilder.append(v);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public V valueAt(int paramInt) {
    return (V)this.mArray[(paramInt << 1) + 1];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v\\util\SimpleArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package org.jar.support.v4.util;

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
    //   3: if_icmpne -> 75
    //   6: ldc org/jar/support/v4/util/ArrayMap
    //   8: monitorenter
    //   9: getstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   12: ifnull -> 63
    //   15: getstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield mArray : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: putstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
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
    //   51: getstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   54: iconst_1
    //   55: isub
    //   56: putstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   59: ldc org/jar/support/v4/util/ArrayMap
    //   61: monitorexit
    //   62: return
    //   63: ldc org/jar/support/v4/util/ArrayMap
    //   65: monitorexit
    //   66: goto -> 149
    //   69: astore_2
    //   70: ldc org/jar/support/v4/util/ArrayMap
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: iload_1
    //   76: iconst_4
    //   77: if_icmpne -> 149
    //   80: ldc org/jar/support/v4/util/ArrayMap
    //   82: monitorenter
    //   83: getstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   86: ifnull -> 137
    //   89: getstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   92: astore_2
    //   93: aload_0
    //   94: aload_2
    //   95: putfield mArray : [Ljava/lang/Object;
    //   98: aload_2
    //   99: iconst_0
    //   100: aaload
    //   101: checkcast [Ljava/lang/Object;
    //   104: putstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   107: aload_0
    //   108: aload_2
    //   109: iconst_1
    //   110: aaload
    //   111: checkcast [I
    //   114: putfield mHashes : [I
    //   117: aload_2
    //   118: iconst_1
    //   119: aconst_null
    //   120: aastore
    //   121: aload_2
    //   122: iconst_0
    //   123: aconst_null
    //   124: aastore
    //   125: getstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   128: iconst_1
    //   129: isub
    //   130: putstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   133: ldc org/jar/support/v4/util/ArrayMap
    //   135: monitorexit
    //   136: return
    //   137: ldc org/jar/support/v4/util/ArrayMap
    //   139: monitorexit
    //   140: goto -> 149
    //   143: astore_2
    //   144: ldc org/jar/support/v4/util/ArrayMap
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: aload_0
    //   150: iload_1
    //   151: newarray int
    //   153: putfield mHashes : [I
    //   156: aload_0
    //   157: iload_1
    //   158: iconst_1
    //   159: ishl
    //   160: anewarray java/lang/Object
    //   163: putfield mArray : [Ljava/lang/Object;
    //   166: return
    // Exception table:
    //   from	to	target	type
    //   9	43	69	finally
    //   51	62	69	finally
    //   63	66	69	finally
    //   70	73	69	finally
    //   83	117	143	finally
    //   125	136	143	finally
    //   137	140	143	finally
    //   144	147	143	finally
  }
  
  private static void freeArrays(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 73
    //   7: ldc org/jar/support/v4/util/ArrayMap
    //   9: monitorenter
    //   10: getstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   13: bipush #10
    //   15: if_icmpge -> 61
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
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
    //   50: putstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCache : [Ljava/lang/Object;
    //   53: getstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   56: iconst_1
    //   57: iadd
    //   58: putstatic org/jar/support/v4/util/SimpleArrayMap.mTwiceBaseCacheSize : I
    //   61: ldc org/jar/support/v4/util/ArrayMap
    //   63: monitorexit
    //   64: goto -> 145
    //   67: astore_0
    //   68: ldc org/jar/support/v4/util/ArrayMap
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    //   73: aload_0
    //   74: arraylength
    //   75: iconst_4
    //   76: if_icmpne -> 145
    //   79: ldc org/jar/support/v4/util/ArrayMap
    //   81: monitorenter
    //   82: getstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   85: bipush #10
    //   87: if_icmpge -> 133
    //   90: aload_1
    //   91: iconst_0
    //   92: getstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   95: aastore
    //   96: aload_1
    //   97: iconst_1
    //   98: aload_0
    //   99: aastore
    //   100: iload_2
    //   101: iconst_1
    //   102: ishl
    //   103: iconst_1
    //   104: isub
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_2
    //   108: if_icmplt -> 121
    //   111: aload_1
    //   112: iload_2
    //   113: aconst_null
    //   114: aastore
    //   115: iinc #2, -1
    //   118: goto -> 106
    //   121: aload_1
    //   122: putstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCache : [Ljava/lang/Object;
    //   125: getstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   128: iconst_1
    //   129: iadd
    //   130: putstatic org/jar/support/v4/util/SimpleArrayMap.mBaseCacheSize : I
    //   133: ldc org/jar/support/v4/util/ArrayMap
    //   135: monitorexit
    //   136: goto -> 145
    //   139: astore_0
    //   140: ldc org/jar/support/v4/util/ArrayMap
    //   142: monitorexit
    //   143: aload_0
    //   144: athrow
    //   145: return
    // Exception table:
    //   from	to	target	type
    //   10	24	67	finally
    //   49	61	67	finally
    //   61	64	67	finally
    //   68	71	67	finally
    //   82	96	139	finally
    //   121	133	139	finally
    //   133	136	139	finally
    //   140	143	139	finally
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
    boolean bool;
    if (indexOfKey(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(Object paramObject) {
    boolean bool;
    if (indexOfValue(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
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
    if (this == paramObject)
      return true; 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      if (size() != map.size())
        return false; 
      byte b = 0;
      try {
        while (b < this.mSize) {
          K k = keyAt(b);
          V v = valueAt(b);
          paramObject = map.get(k);
          if (v == null) {
            if (paramObject != null || !map.containsKey(k))
              return false; 
          } else {
            boolean bool = v.equals(paramObject);
            if (!bool)
              return false; 
          } 
          b++;
        } 
        return true;
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    return false;
  }
  
  public V get(Object paramObject) {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      paramObject = this.mArray[(i << 1) + 1];
    } else {
      paramObject = null;
    } 
    return (V)paramObject;
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int i = this.mSize;
    byte b = 0;
    boolean bool = true;
    int j = 0;
    while (b < i) {
      int m;
      Object object = arrayOfObject[bool];
      int k = arrayOfInt[b];
      if (object == null) {
        m = 0;
      } else {
        m = object.hashCode();
      } 
      j += m ^ k;
      b++;
      bool += true;
    } 
    return j;
  }
  
  int indexOf(Object paramObject, int paramInt) {
    int i = this.mSize;
    if (i == 0)
      return -1; 
    int j = ContainerHelpers.binarySearch(this.mHashes, i, paramInt);
    if (j < 0)
      return j; 
    if (paramObject.equals(this.mArray[j << 1]))
      return j; 
    int k;
    for (k = j + 1; k < i && this.mHashes[k] == paramInt; k++) {
      if (paramObject.equals(this.mArray[k << 1]))
        return k; 
    } 
    for (i = j - 1; i >= 0 && this.mHashes[i] == paramInt; i--) {
      if (paramObject.equals(this.mArray[i << 1]))
        return i; 
    } 
    return k ^ 0xFFFFFFFF;
  }
  
  public int indexOfKey(Object paramObject) {
    int i;
    if (paramObject == null) {
      i = indexOfNull();
    } else {
      i = indexOf(paramObject, paramObject.hashCode());
    } 
    return i;
  }
  
  int indexOfNull() {
    int i = this.mSize;
    if (i == 0)
      return -1; 
    int j = ContainerHelpers.binarySearch(this.mHashes, i, 0);
    if (j < 0)
      return j; 
    if (this.mArray[j << 1] == null)
      return j; 
    int k;
    for (k = j + 1; k < i && this.mHashes[k] == 0; k++) {
      if (this.mArray[k << 1] == null)
        return k; 
    } 
    for (i = j - 1; i >= 0 && this.mHashes[i] == 0; i--) {
      if (this.mArray[i << 1] == null)
        return i; 
    } 
    return k ^ 0xFFFFFFFF;
  }
  
  int indexOfValue(Object paramObject) {
    int i = this.mSize * 2;
    Object[] arrayOfObject = this.mArray;
    if (paramObject == null) {
      for (byte b = 1; b < i; b += 2) {
        if (arrayOfObject[b] == null)
          return b >> 1; 
      } 
    } else {
      for (byte b = 1; b < i; b += 2) {
        if (paramObject.equals(arrayOfObject[b]))
          return b >> 1; 
      } 
    } 
    return -1;
  }
  
  public boolean isEmpty() {
    boolean bool;
    if (this.mSize <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public K keyAt(int paramInt) {
    return (K)this.mArray[paramInt << 1];
  }
  
  public V put(K paramK, V paramV) {
    int j;
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
      int m = this.mSize;
      i = 4;
      if (m >= 8) {
        i = this.mSize;
        i = (this.mSize >> 1) + i;
      } else if (this.mSize >= 4) {
        i = 8;
      } 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject1 = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject1, 0, this.mArray, 0, arrayOfObject1.length);
      } 
      freeArrays(arrayOfInt, arrayOfObject1, this.mSize);
    } 
    if (k < this.mSize) {
      int[] arrayOfInt2 = this.mHashes;
      int[] arrayOfInt1 = this.mHashes;
      i = k + 1;
      System.arraycopy(arrayOfInt2, k, arrayOfInt1, i, this.mSize - k);
      System.arraycopy(this.mArray, k << 1, this.mArray, i << 1, this.mSize - k << 1);
    } 
    this.mHashes[k] = j;
    Object[] arrayOfObject = this.mArray;
    int i = k << 1;
    arrayOfObject[i] = paramK;
    this.mArray[i + 1] = paramV;
    this.mSize++;
    return null;
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    int i = paramSimpleArrayMap.mSize;
    ensureCapacity(this.mSize + i);
    int j = this.mSize;
    byte b = 0;
    if (j == 0) {
      if (i > 0) {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, i);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
        this.mSize = i;
      } 
    } else {
      while (b < i) {
        put(paramSimpleArrayMap.keyAt(b), paramSimpleArrayMap.valueAt(b));
        b++;
      } 
    } 
  }
  
  public V remove(Object paramObject) {
    int i = indexOfKey(paramObject);
    return (i >= 0) ? removeAt(i) : null;
  }
  
  public V removeAt(int paramInt) {
    Object[] arrayOfObject = this.mArray;
    int i = paramInt << 1;
    Object object = arrayOfObject[i + 1];
    if (this.mSize <= 1) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    } else {
      int j = this.mHashes.length;
      int k = 8;
      if (j > 8 && this.mSize < this.mHashes.length / 3) {
        if (this.mSize > 8) {
          k = this.mSize;
          k = (this.mSize >> 1) + k;
        } 
        int[] arrayOfInt = this.mHashes;
        Object[] arrayOfObject1 = this.mArray;
        allocArrays(k);
        this.mSize--;
        if (paramInt > 0) {
          System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
          System.arraycopy(arrayOfObject1, 0, this.mArray, 0, i);
        } 
        if (paramInt < this.mSize) {
          k = paramInt + 1;
          System.arraycopy(arrayOfInt, k, this.mHashes, paramInt, this.mSize - paramInt);
          System.arraycopy(arrayOfObject1, k << 1, this.mArray, i, this.mSize - paramInt << 1);
        } 
      } else {
        this.mSize--;
        if (paramInt < this.mSize) {
          int[] arrayOfInt = this.mHashes;
          k = paramInt + 1;
          System.arraycopy(arrayOfInt, k, this.mHashes, paramInt, this.mSize - paramInt);
          System.arraycopy(this.mArray, k << 1, this.mArray, i, this.mSize - paramInt << 1);
        } 
        this.mArray[this.mSize << 1] = null;
        this.mArray[(this.mSize << 1) + 1] = null;
      } 
    } 
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v\\util\SimpleArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
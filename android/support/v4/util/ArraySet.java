package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
  private static final int BASE_SIZE = 4;
  
  private static final int CACHE_SIZE = 10;
  
  private static final boolean DEBUG = false;
  
  private static final int[] INT = new int[0];
  
  private static final Object[] OBJECT = new Object[0];
  
  private static final String TAG = "ArraySet";
  
  static Object[] sBaseCache;
  
  static int sBaseCacheSize;
  
  static Object[] sTwiceBaseCache;
  
  static int sTwiceBaseCacheSize;
  
  Object[] mArray;
  
  MapCollections<E, E> mCollections;
  
  int[] mHashes;
  
  final boolean mIdentityHashCode;
  
  int mSize;
  
  public ArraySet() {
    this(0, false);
  }
  
  public ArraySet(int paramInt) {
    this(paramInt, false);
  }
  
  public ArraySet(int paramInt, boolean paramBoolean) {
    this.mIdentityHashCode = paramBoolean;
    if (paramInt == 0) {
      this.mHashes = INT;
      this.mArray = OBJECT;
    } else {
      allocArrays(paramInt);
    } 
    this.mSize = 0;
  }
  
  public ArraySet(ArraySet<E> paramArraySet) {
    this();
    if (paramArraySet != null)
      addAll(paramArraySet); 
  }
  
  public ArraySet(Collection<E> paramCollection) {
    this();
    if (paramCollection != null)
      addAll(paramCollection); 
  }
  
  private void allocArrays(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 90
    //   6: ldc android/support/v4/util/ArraySet
    //   8: monitorenter
    //   9: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   12: ifnull -> 63
    //   15: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield mArray : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: putstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
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
    //   51: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   54: iconst_1
    //   55: isub
    //   56: putstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   59: ldc android/support/v4/util/ArraySet
    //   61: monitorexit
    //   62: return
    //   63: ldc android/support/v4/util/ArraySet
    //   65: monitorexit
    //   66: aload_0
    //   67: iload_1
    //   68: newarray int
    //   70: putfield mHashes : [I
    //   73: aload_0
    //   74: iload_1
    //   75: anewarray java/lang/Object
    //   78: putfield mArray : [Ljava/lang/Object;
    //   81: goto -> 62
    //   84: astore_2
    //   85: ldc android/support/v4/util/ArraySet
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: iload_1
    //   91: iconst_4
    //   92: if_icmpne -> 66
    //   95: ldc android/support/v4/util/ArraySet
    //   97: monitorenter
    //   98: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   101: ifnull -> 160
    //   104: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   107: astore_2
    //   108: aload_0
    //   109: aload_2
    //   110: putfield mArray : [Ljava/lang/Object;
    //   113: aload_2
    //   114: iconst_0
    //   115: aaload
    //   116: checkcast [Ljava/lang/Object;
    //   119: putstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   122: aload_0
    //   123: aload_2
    //   124: iconst_1
    //   125: aaload
    //   126: checkcast [I
    //   129: putfield mHashes : [I
    //   132: aload_2
    //   133: iconst_1
    //   134: aconst_null
    //   135: aastore
    //   136: aload_2
    //   137: iconst_0
    //   138: aconst_null
    //   139: aastore
    //   140: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   143: iconst_1
    //   144: isub
    //   145: putstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   148: ldc android/support/v4/util/ArraySet
    //   150: monitorexit
    //   151: goto -> 62
    //   154: astore_2
    //   155: ldc android/support/v4/util/ArraySet
    //   157: monitorexit
    //   158: aload_2
    //   159: athrow
    //   160: ldc android/support/v4/util/ArraySet
    //   162: monitorexit
    //   163: goto -> 66
    // Exception table:
    //   from	to	target	type
    //   9	43	84	finally
    //   51	62	84	finally
    //   63	66	84	finally
    //   85	88	84	finally
    //   98	132	154	finally
    //   140	151	154	finally
    //   155	158	154	finally
    //   160	163	154	finally
  }
  
  private static void freeArrays(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 68
    //   7: ldc android/support/v4/util/ArraySet
    //   9: monitorenter
    //   10: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   13: bipush #10
    //   15: if_icmpge -> 58
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iinc #2, -1
    //   31: iload_2
    //   32: iconst_2
    //   33: if_icmplt -> 46
    //   36: aload_1
    //   37: iload_2
    //   38: aconst_null
    //   39: aastore
    //   40: iinc #2, -1
    //   43: goto -> 31
    //   46: aload_1
    //   47: putstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   50: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   53: iconst_1
    //   54: iadd
    //   55: putstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   58: ldc android/support/v4/util/ArraySet
    //   60: monitorexit
    //   61: return
    //   62: astore_0
    //   63: ldc android/support/v4/util/ArraySet
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: aload_0
    //   69: arraylength
    //   70: iconst_4
    //   71: if_icmpne -> 61
    //   74: ldc android/support/v4/util/ArraySet
    //   76: monitorenter
    //   77: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   80: bipush #10
    //   82: if_icmpge -> 125
    //   85: aload_1
    //   86: iconst_0
    //   87: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   90: aastore
    //   91: aload_1
    //   92: iconst_1
    //   93: aload_0
    //   94: aastore
    //   95: iinc #2, -1
    //   98: iload_2
    //   99: iconst_2
    //   100: if_icmplt -> 113
    //   103: aload_1
    //   104: iload_2
    //   105: aconst_null
    //   106: aastore
    //   107: iinc #2, -1
    //   110: goto -> 98
    //   113: aload_1
    //   114: putstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   117: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   120: iconst_1
    //   121: iadd
    //   122: putstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   125: ldc android/support/v4/util/ArraySet
    //   127: monitorexit
    //   128: goto -> 61
    //   131: astore_0
    //   132: ldc android/support/v4/util/ArraySet
    //   134: monitorexit
    //   135: aload_0
    //   136: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	62	finally
    //   46	58	62	finally
    //   58	61	62	finally
    //   63	66	62	finally
    //   77	91	131	finally
    //   113	125	131	finally
    //   125	128	131	finally
    //   132	135	131	finally
  }
  
  private MapCollections<E, E> getCollection() {
    if (this.mCollections == null)
      this.mCollections = new MapCollections<E, E>() {
          protected void colClear() {
            ArraySet.this.clear();
          }
          
          protected Object colGetEntry(int param1Int1, int param1Int2) {
            return ArraySet.this.mArray[param1Int1];
          }
          
          protected Map<E, E> colGetMap() {
            throw new UnsupportedOperationException("not a map");
          }
          
          protected int colGetSize() {
            return ArraySet.this.mSize;
          }
          
          protected int colIndexOfKey(Object param1Object) {
            return ArraySet.this.indexOf(param1Object);
          }
          
          protected int colIndexOfValue(Object param1Object) {
            return ArraySet.this.indexOf(param1Object);
          }
          
          protected void colPut(E param1E1, E param1E2) {
            ArraySet.this.add(param1E1);
          }
          
          protected void colRemoveAt(int param1Int) {
            ArraySet.this.removeAt(param1Int);
          }
          
          protected E colSetValue(int param1Int, E param1E) {
            throw new UnsupportedOperationException("not a map");
          }
        }; 
    return this.mCollections;
  }
  
  private int indexOf(Object paramObject, int paramInt) {
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
    //   46: aaload
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifne -> 12
    //   53: iload #5
    //   55: iconst_1
    //   56: iadd
    //   57: istore #6
    //   59: iload #6
    //   61: iload_3
    //   62: if_icmpge -> 103
    //   65: aload_0
    //   66: getfield mHashes : [I
    //   69: iload #6
    //   71: iaload
    //   72: iload_2
    //   73: if_icmpne -> 103
    //   76: aload_1
    //   77: aload_0
    //   78: getfield mArray : [Ljava/lang/Object;
    //   81: iload #6
    //   83: aaload
    //   84: invokevirtual equals : (Ljava/lang/Object;)Z
    //   87: ifeq -> 97
    //   90: iload #6
    //   92: istore #4
    //   94: goto -> 12
    //   97: iinc #6, 1
    //   100: goto -> 59
    //   103: iinc #5, -1
    //   106: iload #5
    //   108: iflt -> 146
    //   111: aload_0
    //   112: getfield mHashes : [I
    //   115: iload #5
    //   117: iaload
    //   118: iload_2
    //   119: if_icmpne -> 146
    //   122: iload #5
    //   124: istore #4
    //   126: aload_1
    //   127: aload_0
    //   128: getfield mArray : [Ljava/lang/Object;
    //   131: iload #5
    //   133: aaload
    //   134: invokevirtual equals : (Ljava/lang/Object;)Z
    //   137: ifne -> 12
    //   140: iinc #5, -1
    //   143: goto -> 106
    //   146: iload #6
    //   148: iconst_m1
    //   149: ixor
    //   150: istore #4
    //   152: goto -> 12
  }
  
  private int indexOfNull() {
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
    //   36: aaload
    //   37: ifnull -> 11
    //   40: iload_3
    //   41: iconst_1
    //   42: iadd
    //   43: istore #4
    //   45: iload #4
    //   47: iload_1
    //   48: if_icmpge -> 83
    //   51: aload_0
    //   52: getfield mHashes : [I
    //   55: iload #4
    //   57: iaload
    //   58: ifne -> 83
    //   61: aload_0
    //   62: getfield mArray : [Ljava/lang/Object;
    //   65: iload #4
    //   67: aaload
    //   68: ifnonnull -> 77
    //   71: iload #4
    //   73: istore_2
    //   74: goto -> 11
    //   77: iinc #4, 1
    //   80: goto -> 45
    //   83: iinc #3, -1
    //   86: iload_3
    //   87: iflt -> 116
    //   90: aload_0
    //   91: getfield mHashes : [I
    //   94: iload_3
    //   95: iaload
    //   96: ifne -> 116
    //   99: iload_3
    //   100: istore_2
    //   101: aload_0
    //   102: getfield mArray : [Ljava/lang/Object;
    //   105: iload_3
    //   106: aaload
    //   107: ifnull -> 11
    //   110: iinc #3, -1
    //   113: goto -> 86
    //   116: iload #4
    //   118: iconst_m1
    //   119: ixor
    //   120: istore_2
    //   121: goto -> 11
  }
  
  public boolean add(E paramE) {
    int i;
    int j;
    if (paramE == null) {
      i = indexOfNull();
      j = 0;
    } else {
      int k;
      if (this.mIdentityHashCode) {
        k = System.identityHashCode(paramE);
      } else {
        k = paramE.hashCode();
      } 
      i = indexOf(paramE, k);
      j = k;
    } 
    if (i >= 0)
      return false; 
    i ^= 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length) {
      byte b;
      if (this.mSize >= 8) {
        b = this.mSize + (this.mSize >> 1);
      } else if (this.mSize >= 4) {
        b = 8;
      } else {
        b = 4;
      } 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(b);
      if (this.mHashes.length > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
    if (i < this.mSize) {
      System.arraycopy(this.mHashes, i, this.mHashes, i + 1, this.mSize - i);
      System.arraycopy(this.mArray, i, this.mArray, i + 1, this.mSize - i);
    } 
    this.mHashes[i] = j;
    this.mArray[i] = paramE;
    this.mSize++;
    return true;
  }
  
  public void addAll(ArraySet<? extends E> paramArraySet) {
    byte b = 0;
    int i = paramArraySet.mSize;
    ensureCapacity(this.mSize + i);
    if (this.mSize == 0) {
      if (i > 0) {
        System.arraycopy(paramArraySet.mHashes, 0, this.mHashes, 0, i);
        System.arraycopy(paramArraySet.mArray, 0, this.mArray, 0, i);
        this.mSize = i;
      } 
      return;
    } 
    while (true) {
      if (b < i) {
        add(paramArraySet.valueAt(b));
        b++;
        continue;
      } 
      return;
    } 
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    ensureCapacity(this.mSize + paramCollection.size());
    boolean bool = false;
    Iterator<? extends E> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      bool |= add(iterator.next()); 
    return bool;
  }
  
  public void append(E paramE) {
    int j;
    int i = this.mSize;
    if (paramE == null) {
      j = 0;
    } else if (this.mIdentityHashCode) {
      j = System.identityHashCode(paramE);
    } else {
      j = paramE.hashCode();
    } 
    if (i >= this.mHashes.length)
      throw new IllegalStateException("Array is full"); 
    if (i > 0 && this.mHashes[i - 1] > j) {
      add(paramE);
      return;
    } 
    this.mSize = i + 1;
    this.mHashes[i] = j;
    this.mArray[i] = paramE;
  }
  
  public void clear() {
    if (this.mSize != 0) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
    } 
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) >= 0);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface iterator : ()Ljava/util/Iterator;
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface hasNext : ()Z
    //   13: ifeq -> 33
    //   16: aload_0
    //   17: aload_1
    //   18: invokeinterface next : ()Ljava/lang/Object;
    //   23: invokevirtual contains : (Ljava/lang/Object;)Z
    //   26: ifne -> 7
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_1
    //   34: istore_2
    //   35: goto -> 31
  }
  
  public void ensureCapacity(int paramInt) {
    if (this.mHashes.length < paramInt) {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    if (this == paramObject)
      return true; 
    boolean bool2 = bool1;
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      bool2 = bool1;
      if (size() == paramObject.size()) {
        byte b = 0;
        try {
          while (true) {
            if (b < this.mSize) {
              boolean bool = paramObject.contains(valueAt(b));
              bool2 = bool1;
              if (bool) {
                b++;
                continue;
              } 
              return bool2;
            } 
            return true;
          } 
        } catch (NullPointerException nullPointerException) {
          bool2 = bool1;
        } catch (ClassCastException classCastException) {
          bool2 = bool1;
        } 
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    int i = 0;
    int[] arrayOfInt = this.mHashes;
    int j = this.mSize;
    for (byte b = 0; b < j; b++)
      i += arrayOfInt[b]; 
    return i;
  }
  
  public int indexOf(Object paramObject) {
    if (paramObject == null)
      return indexOfNull(); 
    if (this.mIdentityHashCode) {
      null = System.identityHashCode(paramObject);
    } else {
      null = paramObject.hashCode();
    } 
    return indexOf(paramObject, null);
  }
  
  public boolean isEmpty() {
    return (this.mSize <= 0);
  }
  
  public Iterator<E> iterator() {
    return getCollection().getKeySet().iterator();
  }
  
  public boolean remove(Object paramObject) {
    int i = indexOf(paramObject);
    if (i >= 0) {
      removeAt(i);
      return true;
    } 
    return false;
  }
  
  public boolean removeAll(ArraySet<? extends E> paramArraySet) {
    boolean bool = false;
    int i = paramArraySet.mSize;
    int j = this.mSize;
    for (byte b = 0; b < i; b++)
      remove(paramArraySet.valueAt(b)); 
    if (j != this.mSize)
      bool = true; 
    return bool;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    boolean bool = false;
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      bool |= remove(iterator.next()); 
    return bool;
  }
  
  public E removeAt(int paramInt) {
    int i = 8;
    Object object = this.mArray[paramInt];
    if (this.mSize <= 1) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
      return (E)object;
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
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt);
      } 
      if (paramInt < this.mSize) {
        System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, paramInt + 1, this.mArray, paramInt, this.mSize - paramInt);
      } 
      return (E)object;
    } 
    this.mSize--;
    if (paramInt < this.mSize) {
      System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, paramInt + 1, this.mArray, paramInt, this.mSize - paramInt);
    } 
    this.mArray[this.mSize] = null;
    return (E)object;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    int i = this.mSize;
    boolean bool = false;
    while (--i >= 0) {
      if (!paramCollection.contains(this.mArray[i])) {
        removeAt(i);
        bool = true;
      } 
      i--;
    } 
    return bool;
  }
  
  public int size() {
    return this.mSize;
  }
  
  public Object[] toArray() {
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.mArray, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    if (paramArrayOfT.length < this.mSize)
      paramArrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize); 
    System.arraycopy(this.mArray, 0, paramArrayOfT, 0, this.mSize);
    if (paramArrayOfT.length > this.mSize)
      paramArrayOfT[this.mSize] = null; 
    return paramArrayOfT;
  }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
    stringBuilder.append('{');
    for (byte b = 0; b < this.mSize; b++) {
      if (b > 0)
        stringBuilder.append(", "); 
      E e = valueAt(b);
      if (e != this) {
        stringBuilder.append(e);
      } else {
        stringBuilder.append("(this Set)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public E valueAt(int paramInt) {
    return (E)this.mArray[paramInt];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v\\util\ArraySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public final class StringMap<V> extends AbstractMap<String, V> {
  private static final Map.Entry[] EMPTY_TABLE = (Map.Entry[])new LinkedEntry[2];
  
  private static final int MAXIMUM_CAPACITY = 1073741824;
  
  private static final int MINIMUM_CAPACITY = 4;
  
  private static final int seed = (new Random()).nextInt();
  
  private Set<Map.Entry<String, V>> entrySet;
  
  private LinkedEntry<V> header = new LinkedEntry<V>();
  
  private Set<String> keySet;
  
  private int size;
  
  private LinkedEntry<V>[] table = (LinkedEntry<V>[])EMPTY_TABLE;
  
  private int threshold = -1;
  
  private Collection<V> values;
  
  private void addNewEntry(String paramString, V paramV, int paramInt1, int paramInt2) {
    LinkedEntry<V> linkedEntry2 = this.header;
    LinkedEntry<V> linkedEntry3 = linkedEntry2.prv;
    LinkedEntry<V> linkedEntry1 = new LinkedEntry<V>(paramString, paramV, paramInt1, this.table[paramInt2], linkedEntry2, linkedEntry3);
    LinkedEntry<V>[] arrayOfLinkedEntry = this.table;
    linkedEntry2.prv = linkedEntry1;
    linkedEntry3.nxt = linkedEntry1;
    arrayOfLinkedEntry[paramInt2] = linkedEntry1;
  }
  
  private LinkedEntry<V>[] doubleCapacity() {
    LinkedEntry<V> linkedEntry;
    LinkedEntry<V>[] arrayOfLinkedEntry = this.table;
    int i = arrayOfLinkedEntry.length;
    if (i == 1073741824)
      return arrayOfLinkedEntry; 
    LinkedEntry[] arrayOfLinkedEntry2 = (LinkedEntry[])makeTable(i * 2);
    LinkedEntry[] arrayOfLinkedEntry1 = arrayOfLinkedEntry2;
    if (this.size != 0) {
      byte b = 0;
      while (true) {
        arrayOfLinkedEntry1 = arrayOfLinkedEntry2;
        if (b < i) {
          LinkedEntry<V> linkedEntry1 = arrayOfLinkedEntry[b];
          if (linkedEntry1 != null) {
            int j = linkedEntry1.hash & i;
            LinkedEntry<V> linkedEntry2 = null;
            arrayOfLinkedEntry2[b | j] = linkedEntry1;
            linkedEntry = linkedEntry1.next;
            while (linkedEntry != null) {
              int k = linkedEntry.hash & i;
              LinkedEntry<V> linkedEntry3 = linkedEntry2;
              int m = j;
              if (k != j) {
                if (linkedEntry2 == null) {
                  arrayOfLinkedEntry2[b | k] = linkedEntry;
                } else {
                  linkedEntry2.next = linkedEntry;
                } 
                m = k;
                linkedEntry3 = linkedEntry1;
              } 
              linkedEntry1 = linkedEntry;
              linkedEntry = linkedEntry.next;
              linkedEntry2 = linkedEntry3;
              j = m;
            } 
            if (linkedEntry2 != null)
              linkedEntry2.next = null; 
          } 
          b++;
          continue;
        } 
        return (LinkedEntry<V>[])linkedEntry;
      } 
    } 
    return (LinkedEntry<V>[])linkedEntry;
  }
  
  private LinkedEntry<V> getEntry(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 8
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_2
    //   7: areturn
    //   8: aload_1
    //   9: invokestatic hash : (Ljava/lang/String;)I
    //   12: istore_3
    //   13: aload_0
    //   14: getfield table : [Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   17: astore #4
    //   19: aload #4
    //   21: aload #4
    //   23: arraylength
    //   24: iconst_1
    //   25: isub
    //   26: iload_3
    //   27: iand
    //   28: aaload
    //   29: astore #4
    //   31: aload #4
    //   33: ifnull -> 83
    //   36: aload #4
    //   38: getfield key : Ljava/lang/String;
    //   41: astore #5
    //   43: aload #4
    //   45: astore_2
    //   46: aload #5
    //   48: aload_1
    //   49: if_acmpeq -> 6
    //   52: aload #4
    //   54: getfield hash : I
    //   57: iload_3
    //   58: if_icmpne -> 73
    //   61: aload #4
    //   63: astore_2
    //   64: aload_1
    //   65: aload #5
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifne -> 6
    //   73: aload #4
    //   75: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   78: astore #4
    //   80: goto -> 31
    //   83: aconst_null
    //   84: astore_2
    //   85: goto -> 6
  }
  
  private static int hash(String paramString) {
    int i = seed;
    int j;
    for (j = 0; j < paramString.length(); j++) {
      i += paramString.charAt(j);
      i = i + i << 10;
      i ^= i >>> 6;
    } 
    j = i ^ i >>> 20 ^ i >>> 12;
    return j >>> 7 ^ j ^ j >>> 4;
  }
  
  private LinkedEntry<V>[] makeTable(int paramInt) {
    LinkedEntry[] arrayOfLinkedEntry = new LinkedEntry[paramInt];
    this.table = (LinkedEntry<V>[])arrayOfLinkedEntry;
    this.threshold = (paramInt >> 1) + (paramInt >> 2);
    return (LinkedEntry<V>[])arrayOfLinkedEntry;
  }
  
  private boolean removeMapping(Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 11
    //   4: aload_1
    //   5: instanceof java/lang/String
    //   8: ifne -> 15
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: ireturn
    //   15: aload_1
    //   16: checkcast java/lang/String
    //   19: invokestatic hash : (Ljava/lang/String;)I
    //   22: istore #4
    //   24: aload_0
    //   25: getfield table : [Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   28: astore #5
    //   30: iload #4
    //   32: aload #5
    //   34: arraylength
    //   35: iconst_1
    //   36: isub
    //   37: iand
    //   38: istore #6
    //   40: aload #5
    //   42: iload #6
    //   44: aaload
    //   45: astore #7
    //   47: aconst_null
    //   48: astore #8
    //   50: aload #7
    //   52: ifnull -> 169
    //   55: aload #7
    //   57: getfield hash : I
    //   60: iload #4
    //   62: if_icmpne -> 155
    //   65: aload_1
    //   66: aload #7
    //   68: getfield key : Ljava/lang/String;
    //   71: invokevirtual equals : (Ljava/lang/Object;)Z
    //   74: ifeq -> 155
    //   77: aload_2
    //   78: ifnonnull -> 94
    //   81: aload #7
    //   83: getfield value : Ljava/lang/Object;
    //   86: ifnull -> 106
    //   89: iconst_0
    //   90: istore_3
    //   91: goto -> 13
    //   94: aload_2
    //   95: aload #7
    //   97: getfield value : Ljava/lang/Object;
    //   100: invokevirtual equals : (Ljava/lang/Object;)Z
    //   103: ifeq -> 89
    //   106: aload #8
    //   108: ifnonnull -> 142
    //   111: aload #5
    //   113: iload #6
    //   115: aload #7
    //   117: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   120: aastore
    //   121: aload_0
    //   122: aload_0
    //   123: getfield size : I
    //   126: iconst_1
    //   127: isub
    //   128: putfield size : I
    //   131: aload_0
    //   132: aload #7
    //   134: invokespecial unlink : (Lcom/google/gson/internal/StringMap$LinkedEntry;)V
    //   137: iconst_1
    //   138: istore_3
    //   139: goto -> 13
    //   142: aload #8
    //   144: aload #7
    //   146: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   149: putfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   152: goto -> 121
    //   155: aload #7
    //   157: astore #8
    //   159: aload #7
    //   161: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   164: astore #7
    //   166: goto -> 50
    //   169: iconst_0
    //   170: istore_3
    //   171: goto -> 13
  }
  
  private void unlink(LinkedEntry<V> paramLinkedEntry) {
    paramLinkedEntry.prv.nxt = paramLinkedEntry.nxt;
    paramLinkedEntry.nxt.prv = paramLinkedEntry.prv;
    paramLinkedEntry.prv = null;
    paramLinkedEntry.nxt = null;
  }
  
  public void clear() {
    if (this.size != 0) {
      Arrays.fill((Object[])this.table, (Object)null);
      this.size = 0;
    } 
    LinkedEntry<V> linkedEntry1 = this.header;
    for (LinkedEntry<V> linkedEntry2 = linkedEntry1.nxt; linkedEntry2 != linkedEntry1; linkedEntry2 = linkedEntry) {
      LinkedEntry<V> linkedEntry = linkedEntry2.nxt;
      linkedEntry2.prv = null;
      linkedEntry2.nxt = null;
    } 
    linkedEntry1.prv = linkedEntry1;
    linkedEntry1.nxt = linkedEntry1;
  }
  
  public boolean containsKey(Object paramObject) {
    return (paramObject instanceof String && getEntry((String)paramObject) != null);
  }
  
  public Set<Map.Entry<String, V>> entrySet() {
    Set<Map.Entry<String, V>> set = this.entrySet;
    if (set == null) {
      set = new EntrySet();
      this.entrySet = set;
    } 
    return set;
  }
  
  public V get(Object<V> paramObject) {
    V v;
    Object object1 = null;
    Object object2 = object1;
    if (paramObject instanceof String) {
      paramObject = (Object<V>)getEntry((String)paramObject);
      object2 = object1;
      if (paramObject != null)
        v = ((LinkedEntry)paramObject).value; 
    } 
    return v;
  }
  
  public Set<String> keySet() {
    Set<String> set = this.keySet;
    if (set == null) {
      set = new KeySet();
      this.keySet = set;
    } 
    return set;
  }
  
  public V put(String paramString, V paramV) {
    if (paramString == null)
      throw new NullPointerException("key == null"); 
    int i = hash(paramString);
    LinkedEntry<V>[] arrayOfLinkedEntry = this.table;
    int j = i & arrayOfLinkedEntry.length - 1;
    for (LinkedEntry<V> linkedEntry = arrayOfLinkedEntry[j]; linkedEntry != null; linkedEntry = linkedEntry.next) {
      if (linkedEntry.hash == i && paramString.equals(linkedEntry.key)) {
        null = linkedEntry.value;
        linkedEntry.value = paramV;
        return null;
      } 
    } 
    int k = this.size;
    this.size = k + 1;
    if (k > this.threshold)
      j = i & (doubleCapacity()).length - 1; 
    addNewEntry((String)null, paramV, i, j);
    return null;
  }
  
  public V remove(Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 11
    //   4: aload_1
    //   5: instanceof java/lang/String
    //   8: ifne -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: aload_1
    //   16: checkcast java/lang/String
    //   19: invokestatic hash : (Ljava/lang/String;)I
    //   22: istore_2
    //   23: aload_0
    //   24: getfield table : [Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   27: astore_3
    //   28: iload_2
    //   29: aload_3
    //   30: arraylength
    //   31: iconst_1
    //   32: isub
    //   33: iand
    //   34: istore #4
    //   36: aload_3
    //   37: iload #4
    //   39: aaload
    //   40: astore #5
    //   42: aconst_null
    //   43: astore #6
    //   45: aload #5
    //   47: ifnull -> 137
    //   50: aload #5
    //   52: getfield hash : I
    //   55: iload_2
    //   56: if_icmpne -> 123
    //   59: aload_1
    //   60: aload #5
    //   62: getfield key : Ljava/lang/String;
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifeq -> 123
    //   71: aload #6
    //   73: ifnonnull -> 110
    //   76: aload_3
    //   77: iload #4
    //   79: aload #5
    //   81: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   84: aastore
    //   85: aload_0
    //   86: aload_0
    //   87: getfield size : I
    //   90: iconst_1
    //   91: isub
    //   92: putfield size : I
    //   95: aload_0
    //   96: aload #5
    //   98: invokespecial unlink : (Lcom/google/gson/internal/StringMap$LinkedEntry;)V
    //   101: aload #5
    //   103: getfield value : Ljava/lang/Object;
    //   106: astore_1
    //   107: goto -> 13
    //   110: aload #6
    //   112: aload #5
    //   114: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   117: putfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   120: goto -> 85
    //   123: aload #5
    //   125: astore #6
    //   127: aload #5
    //   129: getfield next : Lcom/google/gson/internal/StringMap$LinkedEntry;
    //   132: astore #5
    //   134: goto -> 45
    //   137: aconst_null
    //   138: astore_1
    //   139: goto -> 13
  }
  
  public int size() {
    return this.size;
  }
  
  public Collection<V> values() {
    Collection<V> collection = this.values;
    if (collection == null) {
      collection = new Values();
      this.values = collection;
    } 
    return collection;
  }
  
  private final class EntrySet extends AbstractSet<Map.Entry<String, V>> {
    private EntrySet() {}
    
    public void clear() {
      StringMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool1 = false;
      if (!(param1Object instanceof Map.Entry))
        return bool1; 
      Map.Entry entry = (Map.Entry)param1Object;
      param1Object = StringMap.this.get(entry.getKey());
      boolean bool2 = bool1;
      if (param1Object != null) {
        bool2 = bool1;
        if (param1Object.equals(entry.getValue()))
          bool2 = true; 
      } 
      return bool2;
    }
    
    public Iterator<Map.Entry<String, V>> iterator() {
      return new StringMap<V>.LinkedHashIterator<Map.Entry<String, V>>() {
          public final Map.Entry<String, V> next() {
            return nextEntry();
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      if (!(param1Object instanceof Map.Entry))
        return false; 
      param1Object = param1Object;
      return StringMap.this.removeMapping(param1Object.getKey(), param1Object.getValue());
    }
    
    public int size() {
      return StringMap.this.size;
    }
  }
  
  class null extends LinkedHashIterator<Map.Entry<String, V>> {
    public final Map.Entry<String, V> next() {
      return nextEntry();
    }
  }
  
  private final class KeySet extends AbstractSet<String> {
    private KeySet() {}
    
    public void clear() {
      StringMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return StringMap.this.containsKey(param1Object);
    }
    
    public Iterator<String> iterator() {
      return new StringMap<V>.LinkedHashIterator<String>() {
          public final String next() {
            return (nextEntry()).key;
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      int i = StringMap.this.size;
      StringMap.this.remove(param1Object);
      return (StringMap.this.size != i);
    }
    
    public int size() {
      return StringMap.this.size;
    }
  }
  
  class null extends LinkedHashIterator<String> {
    public final String next() {
      return (nextEntry()).key;
    }
  }
  
  static class LinkedEntry<V> implements Map.Entry<String, V> {
    final int hash;
    
    final String key;
    
    LinkedEntry<V> next;
    
    LinkedEntry<V> nxt;
    
    LinkedEntry<V> prv;
    
    V value;
    
    LinkedEntry() {
      this(null, null, 0, null, null, null);
      this.prv = this;
      this.nxt = this;
    }
    
    LinkedEntry(String param1String, V param1V, int param1Int, LinkedEntry<V> param1LinkedEntry1, LinkedEntry<V> param1LinkedEntry2, LinkedEntry<V> param1LinkedEntry3) {
      this.key = param1String;
      this.value = param1V;
      this.hash = param1Int;
      this.next = param1LinkedEntry1;
      this.nxt = param1LinkedEntry2;
      this.prv = param1LinkedEntry3;
    }
    
    public final boolean equals(Object param1Object) {
      boolean bool1 = false;
      if (!(param1Object instanceof Map.Entry))
        return bool1; 
      param1Object = param1Object;
      Object object = param1Object.getValue();
      boolean bool2 = bool1;
      if (this.key.equals(param1Object.getKey())) {
        if (this.value == null) {
          bool2 = bool1;
          return (object == null) ? true : bool2;
        } 
        bool2 = bool1;
        if (this.value.equals(object))
          return true; 
      } 
      return bool2;
    }
    
    public final String getKey() {
      return this.key;
    }
    
    public final V getValue() {
      return this.value;
    }
    
    public final int hashCode() {
      int j;
      int i = 0;
      if (this.key == null) {
        j = 0;
      } else {
        j = this.key.hashCode();
      } 
      if (this.value != null)
        i = this.value.hashCode(); 
      return j ^ i;
    }
    
    public final V setValue(V param1V) {
      V v = this.value;
      this.value = param1V;
      return v;
    }
    
    public final String toString() {
      return this.key + "=" + this.value;
    }
  }
  
  private abstract class LinkedHashIterator<T> implements Iterator<T> {
    StringMap.LinkedEntry<V> lastReturned = null;
    
    StringMap.LinkedEntry<V> next = StringMap.this.header.nxt;
    
    private LinkedHashIterator() {}
    
    public final boolean hasNext() {
      return (this.next != StringMap.this.header);
    }
    
    final StringMap.LinkedEntry<V> nextEntry() {
      StringMap.LinkedEntry<V> linkedEntry = this.next;
      if (linkedEntry == StringMap.this.header)
        throw new NoSuchElementException(); 
      this.next = linkedEntry.nxt;
      this.lastReturned = linkedEntry;
      return linkedEntry;
    }
    
    public final void remove() {
      if (this.lastReturned == null)
        throw new IllegalStateException(); 
      StringMap.this.remove(this.lastReturned.key);
      this.lastReturned = null;
    }
  }
  
  private final class Values extends AbstractCollection<V> {
    private Values() {}
    
    public void clear() {
      StringMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return StringMap.this.containsValue(param1Object);
    }
    
    public Iterator<V> iterator() {
      return new StringMap<V>.LinkedHashIterator<V>() {
          public final V next() {
            return (nextEntry()).value;
          }
        };
    }
    
    public int size() {
      return StringMap.this.size;
    }
  }
  
  class null extends LinkedHashIterator<V> {
    public final V next() {
      return (nextEntry()).value;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\internal\StringMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
  static final int DEFAULT_INITIAL_CAPACITY = 16;
  
  static final float DEFAULT_LOAD_FACTOR = 0.75F;
  
  static final int KEY = 16777619;
  
  static final int MAXIMUM_CAPACITY = 1073741824;
  
  static final int M_MASK = -2023358765;
  
  static final int SEED = -2128831035;
  
  private static final long serialVersionUID = 362498820763181265L;
  
  private transient Set<Map.Entry<K, V>> entrySet = null;
  
  volatile transient Set<K> keySet = null;
  
  final float loadFactor;
  
  volatile transient int modCount;
  
  final int random = (new Random()).nextInt(99999);
  
  transient int size;
  
  transient Entry<K, V>[] table;
  
  int threshold;
  
  volatile transient Collection<V> values = null;
  
  public AntiCollisionHashMap() {
    this.loadFactor = 0.75F;
    this.threshold = 12;
    this.table = (Entry<K, V>[])new Entry[16];
    init();
  }
  
  public AntiCollisionHashMap(int paramInt) {
    this(paramInt, 0.75F);
  }
  
  public AntiCollisionHashMap(int paramInt, float paramFloat) {
    if (paramInt >= 0) {
      int i = paramInt;
      if (paramInt > 1073741824)
        i = 1073741824; 
      if (paramFloat > 0.0F && !Float.isNaN(paramFloat)) {
        for (paramInt = 1; paramInt < i; paramInt <<= 1);
        this.loadFactor = paramFloat;
        this.threshold = (int)(paramInt * paramFloat);
        this.table = (Entry<K, V>[])new Entry[paramInt];
        init();
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Illegal load factor: ");
      stringBuilder1.append(paramFloat);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal initial capacity: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public AntiCollisionHashMap(Map<? extends K, ? extends V> paramMap) {
    this(Math.max((int)(paramMap.size() / 0.75F) + 1, 16), 0.75F);
    putAllForCreate(paramMap);
  }
  
  private boolean containsNullValue() {
    Entry<K, V>[] arrayOfEntry = this.table;
    for (byte b = 0; b < arrayOfEntry.length; b++) {
      for (Entry<K, V> entry = arrayOfEntry[b]; entry != null; entry = entry.next) {
        if (entry.value == null)
          return true; 
      } 
    } 
    return false;
  }
  
  private Set<Map.Entry<K, V>> entrySet0() {
    Set<Map.Entry<K, V>> set = this.entrySet;
    if (set == null) {
      set = new EntrySet();
      this.entrySet = set;
    } 
    return set;
  }
  
  private V getForNullKey() {
    for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
      if (entry.key == null)
        return entry.value; 
    } 
    return null;
  }
  
  static int hash(int paramInt) {
    paramInt *= paramInt;
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private int hashString(String paramString) {
    int i = this.random * -2128831035;
    for (byte b = 0; b < paramString.length(); b++)
      i = i * 16777619 ^ paramString.charAt(b); 
    return (i >> 1 ^ i) & 0x8765FED3;
  }
  
  static int indexFor(int paramInt1, int paramInt2) {
    return paramInt1 & paramInt2 - 1;
  }
  
  private void putAllForCreate(Map<? extends K, ? extends V> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      putForCreate((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  private void putForCreate(K paramK, V paramV) {
    int i;
    if (paramK == null) {
      i = 0;
    } else if (paramK instanceof String) {
      i = hash(hashString((String)paramK));
    } else {
      i = hash(paramK.hashCode());
    } 
    int j = indexFor(i, this.table.length);
    for (Entry<K, V> entry = this.table[j]; entry != null; entry = entry.next) {
      if (entry.hash == i) {
        K k = entry.key;
        if (k == paramK || (paramK != null && paramK.equals(k))) {
          entry.value = paramV;
          return;
        } 
      } 
    } 
    createEntry(i, paramK, paramV, j);
  }
  
  private V putForNullKey(V paramV) {
    for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
      if (entry.key == null) {
        V v = entry.value;
        entry.value = paramV;
        entry.recordAccess(this);
        return v;
      } 
    } 
    this.modCount++;
    addEntry(0, null, paramV, 0);
    return null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.table = (Entry<K, V>[])new Entry[paramObjectInputStream.readInt()];
    init();
    int i = paramObjectInputStream.readInt();
    for (byte b = 0; b < i; b++)
      putForCreate((K)paramObjectInputStream.readObject(), (V)paramObjectInputStream.readObject()); 
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    Iterator<Map.Entry> iterator;
    if (this.size > 0) {
      iterator = (Iterator)entrySet0().iterator();
    } else {
      iterator = null;
    } 
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(this.table.length);
    paramObjectOutputStream.writeInt(this.size);
    if (iterator != null)
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        paramObjectOutputStream.writeObject(entry.getKey());
        paramObjectOutputStream.writeObject(entry.getValue());
      }  
  }
  
  void addEntry(int paramInt1, K paramK, V paramV, int paramInt2) {
    Entry<K, V> entry = this.table[paramInt2];
    this.table[paramInt2] = new Entry<K, V>(paramInt1, paramK, paramV, entry);
    paramInt1 = this.size;
    this.size = paramInt1 + 1;
    if (paramInt1 >= this.threshold)
      resize(this.table.length * 2); 
  }
  
  int capacity() {
    return this.table.length;
  }
  
  public void clear() {
    this.modCount++;
    Entry<K, V>[] arrayOfEntry = this.table;
    for (byte b = 0; b < arrayOfEntry.length; b++)
      arrayOfEntry[b] = null; 
    this.size = 0;
  }
  
  public Object clone() {
    try {
      AntiCollisionHashMap antiCollisionHashMap = (AntiCollisionHashMap)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      cloneNotSupportedException = null;
    } 
    ((AntiCollisionHashMap)cloneNotSupportedException).table = (Entry<K, V>[])new Entry[this.table.length];
    ((AntiCollisionHashMap)cloneNotSupportedException).entrySet = null;
    ((AntiCollisionHashMap)cloneNotSupportedException).modCount = 0;
    ((AntiCollisionHashMap)cloneNotSupportedException).size = 0;
    cloneNotSupportedException.init();
    cloneNotSupportedException.putAllForCreate(this);
    return cloneNotSupportedException;
  }
  
  public boolean containsKey(Object paramObject) {
    boolean bool;
    if (getEntry(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(Object paramObject) {
    if (paramObject == null)
      return containsNullValue(); 
    Entry<K, V>[] arrayOfEntry = this.table;
    for (byte b = 0; b < arrayOfEntry.length; b++) {
      for (Entry<K, V> entry = arrayOfEntry[b]; entry != null; entry = entry.next) {
        if (paramObject.equals(entry.value))
          return true; 
      } 
    } 
    return false;
  }
  
  void createEntry(int paramInt1, K paramK, V paramV, int paramInt2) {
    Entry<K, V> entry = this.table[paramInt2];
    this.table[paramInt2] = new Entry<K, V>(paramInt1, paramK, paramV, entry);
    this.size++;
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    return entrySet0();
  }
  
  public V get(Object paramObject) {
    int i;
    if (paramObject == null)
      return getForNullKey(); 
    if (paramObject instanceof String) {
      i = hash(hashString((String)paramObject));
    } else {
      i = hash(paramObject.hashCode());
    } 
    for (Entry<K, V> entry = this.table[indexFor(i, this.table.length)]; entry != null; entry = entry.next) {
      if (entry.hash == i) {
        K k = entry.key;
        if (k == paramObject || paramObject.equals(k))
          return entry.value; 
      } 
    } 
    return null;
  }
  
  final Entry<K, V> getEntry(Object paramObject) {
    int i;
    if (paramObject == null) {
      i = 0;
    } else if (paramObject instanceof String) {
      i = hash(hashString((String)paramObject));
    } else {
      i = hash(paramObject.hashCode());
    } 
    for (Entry<K, V> entry = this.table[indexFor(i, this.table.length)]; entry != null; entry = entry.next) {
      if (entry.hash == i) {
        K k = entry.key;
        if (k == paramObject || (paramObject != null && paramObject.equals(k)))
          return entry; 
      } 
    } 
    return null;
  }
  
  void init() {}
  
  public boolean isEmpty() {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Set<K> keySet() {
    Set<K> set = this.keySet;
    if (set == null) {
      set = new KeySet();
      this.keySet = set;
    } 
    return set;
  }
  
  float loadFactor() {
    return this.loadFactor;
  }
  
  Iterator<Map.Entry<K, V>> newEntryIterator() {
    return new EntryIterator();
  }
  
  Iterator<K> newKeyIterator() {
    return new KeyIterator();
  }
  
  Iterator<V> newValueIterator() {
    return new ValueIterator();
  }
  
  public V put(K paramK, V paramV) {
    V v;
    int i;
    if (paramK == null)
      return putForNullKey(paramV); 
    if (paramK instanceof String) {
      i = hash(hashString((String)paramK));
    } else {
      i = hash(paramK.hashCode());
    } 
    int j = indexFor(i, this.table.length);
    for (Entry<K, V> entry = this.table[j]; entry != null; entry = entry.next) {
      if (entry.hash == i) {
        K k = entry.key;
        if (k == paramK || paramK.equals(k)) {
          v = entry.value;
          entry.value = paramV;
          entry.recordAccess(this);
          return v;
        } 
      } 
    } 
    this.modCount++;
    addEntry(i, (K)v, paramV, j);
    return null;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    int i = paramMap.size();
    if (i == 0)
      return; 
    if (i > this.threshold) {
      int j = (int)(i / this.loadFactor + 1.0F);
      i = j;
      if (j > 1073741824)
        i = 1073741824; 
      for (j = this.table.length; j < i; j <<= 1);
      if (j > this.table.length)
        resize(j); 
    } 
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  public V remove(Object<K, V> paramObject) {
    V v;
    paramObject = (Object<K, V>)removeEntryForKey(paramObject);
    if (paramObject == null) {
      paramObject = null;
    } else {
      v = ((Entry)paramObject).value;
    } 
    return v;
  }
  
  final Entry<K, V> removeEntryForKey(Object paramObject) {
    int i;
    if (paramObject == null) {
      i = 0;
    } else if (paramObject instanceof String) {
      i = hash(hashString((String)paramObject));
    } else {
      i = hash(paramObject.hashCode());
    } 
    int j = indexFor(i, this.table.length);
    Entry<K, V> entry1 = this.table[j];
    Entry<K, V> entry2 = entry1;
    while (entry1 != null) {
      Entry<K, V> entry = entry1.next;
      if (entry1.hash == i) {
        K k = entry1.key;
        if (k == paramObject || (paramObject != null && paramObject.equals(k))) {
          this.modCount++;
          this.size--;
          if (entry2 == entry1) {
            this.table[j] = entry;
          } else {
            entry2.next = entry;
          } 
          entry1.recordRemoval(this);
          return entry1;
        } 
      } 
      entry2 = entry1;
      entry1 = entry;
    } 
    return entry1;
  }
  
  final Entry<K, V> removeMapping(Object<K, V> paramObject) {
    Entry<K, V> entry;
    int i;
    if (!(paramObject instanceof Map.Entry))
      return null; 
    Map.Entry entry1 = (Map.Entry)paramObject;
    paramObject = (Object<K, V>)entry1.getKey();
    if (paramObject == null) {
      i = 0;
    } else if (paramObject instanceof String) {
      i = hash(hashString((String)paramObject));
    } else {
      i = hash(paramObject.hashCode());
    } 
    int j = indexFor(i, this.table.length);
    paramObject = (Object<K, V>)this.table[j];
    Object<K, V> object = paramObject;
    while (paramObject != null) {
      Entry<K, V> entry2 = ((Entry)paramObject).next;
      if (((Entry)paramObject).hash == i && paramObject.equals(entry1)) {
        this.modCount++;
        this.size--;
        if (object == paramObject) {
          this.table[j] = entry2;
        } else {
          ((Entry)object).next = entry2;
        } 
        paramObject.recordRemoval(this);
        return (Entry<K, V>)paramObject;
      } 
      object = paramObject;
      entry = entry2;
    } 
    return entry;
  }
  
  void resize(int paramInt) {
    if (this.table.length == 1073741824) {
      this.threshold = Integer.MAX_VALUE;
      return;
    } 
    Entry[] arrayOfEntry = new Entry[paramInt];
    transfer(arrayOfEntry);
    this.table = (Entry<K, V>[])arrayOfEntry;
    this.threshold = (int)(paramInt * this.loadFactor);
  }
  
  public int size() {
    return this.size;
  }
  
  void transfer(Entry[] paramArrayOfEntry) {
    Entry<K, V>[] arrayOfEntry = this.table;
    int i = paramArrayOfEntry.length;
    for (byte b = 0; b < arrayOfEntry.length; b++) {
      Entry<K, V> entry = arrayOfEntry[b];
      if (entry != null) {
        arrayOfEntry[b] = null;
        while (true) {
          Entry<K, V> entry1 = entry.next;
          int j = indexFor(entry.hash, i);
          entry.next = paramArrayOfEntry[j];
          paramArrayOfEntry[j] = entry;
          if (entry1 == null)
            break; 
          entry = entry1;
        } 
      } 
    } 
  }
  
  public Collection<V> values() {
    Collection<V> collection = this.values;
    if (collection == null) {
      collection = new Values();
      this.values = collection;
    } 
    return collection;
  }
  
  static class Entry<K, V> implements Map.Entry<K, V> {
    final int hash;
    
    final K key;
    
    Entry<K, V> next;
    
    V value;
    
    Entry(int param1Int, K param1K, V param1V, Entry<K, V> param1Entry) {
      this.value = param1V;
      this.next = param1Entry;
      this.key = param1K;
      this.hash = param1Int;
    }
    
    public final boolean equals(Object param1Object) {
      if (!(param1Object instanceof Map.Entry))
        return false; 
      param1Object = param1Object;
      V v = (V)getKey();
      Object object = param1Object.getKey();
      if (v == object || (v != null && v.equals(object))) {
        v = getValue();
        param1Object = param1Object.getValue();
        if (v == param1Object || (v != null && v.equals(param1Object)))
          return true; 
      } 
      return false;
    }
    
    public final K getKey() {
      return this.key;
    }
    
    public final V getValue() {
      return this.value;
    }
    
    public final int hashCode() {
      int j;
      K k = this.key;
      int i = 0;
      if (k == null) {
        j = 0;
      } else {
        j = this.key.hashCode();
      } 
      if (this.value != null)
        i = this.value.hashCode(); 
      return j ^ i;
    }
    
    void recordAccess(AntiCollisionHashMap<K, V> param1AntiCollisionHashMap) {}
    
    void recordRemoval(AntiCollisionHashMap<K, V> param1AntiCollisionHashMap) {}
    
    public final V setValue(V param1V) {
      V v = this.value;
      this.value = param1V;
      return v;
    }
    
    public final String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getKey());
      stringBuilder.append("=");
      stringBuilder.append(getValue());
      return stringBuilder.toString();
    }
  }
  
  private final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    private EntryIterator() {}
    
    public Map.Entry<K, V> next() {
      return nextEntry();
    }
  }
  
  private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
    private EntrySet() {}
    
    public void clear() {
      AntiCollisionHashMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      Map.Entry entry = (Map.Entry)param1Object;
      param1Object = AntiCollisionHashMap.this.getEntry(entry.getKey());
      bool = bool1;
      if (param1Object != null) {
        bool = bool1;
        if (param1Object.equals(entry))
          bool = true; 
      } 
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return AntiCollisionHashMap.this.newEntryIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (AntiCollisionHashMap.this.removeMapping(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      return AntiCollisionHashMap.this.size;
    }
  }
  
  private abstract class HashIterator<E> implements Iterator<E> {
    AntiCollisionHashMap.Entry<K, V> current;
    
    int expectedModCount = AntiCollisionHashMap.this.modCount;
    
    int index;
    
    AntiCollisionHashMap.Entry<K, V> next;
    
    HashIterator() {
      if (AntiCollisionHashMap.this.size > 0) {
        AntiCollisionHashMap.Entry[] arrayOfEntry = AntiCollisionHashMap.this.table;
        while (this.index < arrayOfEntry.length) {
          int i = this.index;
          this.index = i + 1;
          AntiCollisionHashMap.Entry<K, V> entry = arrayOfEntry[i];
          this.next = entry;
          if (entry == null);
        } 
      } 
    }
    
    public final boolean hasNext() {
      boolean bool;
      if (this.next != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    final AntiCollisionHashMap.Entry<K, V> nextEntry() {
      if (AntiCollisionHashMap.this.modCount == this.expectedModCount) {
        AntiCollisionHashMap.Entry<K, V> entry = this.next;
        if (entry != null) {
          AntiCollisionHashMap.Entry<K, V> entry1 = entry.next;
          this.next = entry1;
          if (entry1 == null) {
            AntiCollisionHashMap.Entry[] arrayOfEntry = AntiCollisionHashMap.this.table;
            while (this.index < arrayOfEntry.length) {
              int i = this.index;
              this.index = i + 1;
              entry1 = arrayOfEntry[i];
              this.next = entry1;
              if (entry1 == null);
            } 
          } 
          this.current = entry;
          return entry;
        } 
        throw new NoSuchElementException();
      } 
      throw new ConcurrentModificationException();
    }
    
    public void remove() {
      if (this.current != null) {
        if (AntiCollisionHashMap.this.modCount == this.expectedModCount) {
          K k = this.current.key;
          this.current = null;
          AntiCollisionHashMap.this.removeEntryForKey(k);
          this.expectedModCount = AntiCollisionHashMap.this.modCount;
          return;
        } 
        throw new ConcurrentModificationException();
      } 
      throw new IllegalStateException();
    }
  }
  
  private final class KeyIterator extends HashIterator<K> {
    private KeyIterator() {}
    
    public K next() {
      return (K)nextEntry().getKey();
    }
  }
  
  private final class KeySet extends AbstractSet<K> {
    private KeySet() {}
    
    public void clear() {
      AntiCollisionHashMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return AntiCollisionHashMap.this.containsKey(param1Object);
    }
    
    public Iterator<K> iterator() {
      return AntiCollisionHashMap.this.newKeyIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (AntiCollisionHashMap.this.removeEntryForKey(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      return AntiCollisionHashMap.this.size;
    }
  }
  
  private final class ValueIterator extends HashIterator<V> {
    private ValueIterator() {}
    
    public V next() {
      return (nextEntry()).value;
    }
  }
  
  private final class Values extends AbstractCollection<V> {
    private Values() {}
    
    public void clear() {
      AntiCollisionHashMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return AntiCollisionHashMap.this.containsValue(param1Object);
    }
    
    public Iterator<V> iterator() {
      return AntiCollisionHashMap.this.newValueIterator();
    }
    
    public int size() {
      return AntiCollisionHashMap.this.size;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\AntiCollisionHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
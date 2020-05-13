package com.unionpay.sdk;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

final class ah {
  private static volatile ah a = null;
  
  private final ConcurrentMap b = new ConcurrentHashMap<Object, Object>();
  
  private final ThreadLocal c = new ai(this);
  
  private final ThreadLocal d = new aj(this);
  
  private final Map e = new HashMap<Object, Object>();
  
  public static ah a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/ah.a : Lcom/unionpay/sdk/ah;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/ah
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/ah.a : Lcom/unionpay/sdk/ah;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/ah
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/ah.a : Lcom/unionpay/sdk/ah;
    //   27: ldc com/unionpay/sdk/ah
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/ah.a : Lcom/unionpay/sdk/ah;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/ah
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private Set a(Class paramClass) {
    return (Set)this.b.get(paramClass);
  }
  
  private static Set b(Class<?> paramClass) {
    LinkedList<Class<?>> linkedList = new LinkedList();
    HashSet<Class<?>> hashSet = new HashSet();
    linkedList.add(paramClass);
    while (!linkedList.isEmpty()) {
      paramClass = linkedList.remove(0);
      hashSet.add(paramClass);
      paramClass = paramClass.getSuperclass();
      if (paramClass != null)
        linkedList.add(paramClass); 
    } 
    return hashSet;
  }
  
  private void b() {
    if (((Boolean)this.d.get()).booleanValue())
      return; 
    this.d.set(Boolean.valueOf(true));
    try {
      while (true) {
        a a = ((ConcurrentLinkedQueue<a>)this.c.get()).poll();
        if (a != null) {
          if (a.b.a()) {
            Object object = a.a;
            al al = a.b;
            try {
              al.handleEvent(object);
            } catch (InvocationTargetException invocationTargetException) {
              RuntimeException runtimeException1;
              StringBuilder stringBuilder2 = new StringBuilder();
              this("Could not dispatch event: ");
              object = stringBuilder2.append(object.getClass()).append(" to handler ").append(al).toString();
              Throwable throwable = invocationTargetException.getCause();
              if (throwable != null) {
                runtimeException1 = new RuntimeException();
                stringBuilder2 = new StringBuilder();
                this();
                this(stringBuilder2.append((String)object).append(": ").append(throwable.getMessage()).toString(), throwable);
                throw runtimeException1;
              } 
              RuntimeException runtimeException2 = new RuntimeException();
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              this(stringBuilder1.append((String)object).append(": ").append(runtimeException1.getMessage()).toString(), runtimeException1);
              throw runtimeException2;
            } 
          } 
          continue;
        } 
        this.d.set(Boolean.valueOf(false));
        // Byte code: goto -> 16
      } 
    } finally {
      this.d.set(Boolean.valueOf(false));
    } 
  }
  
  public final void post(Object paramObject) {
    if (paramObject == null)
      throw new NullPointerException("Event to post must not be null."); 
    Class<?> clazz = paramObject.getClass();
    Set set1 = (Set)this.e.get(clazz);
    Set set2 = set1;
    if (set1 == null) {
      set2 = b(clazz);
      this.e.put(clazz, set2);
    } 
    boolean bool = false;
    Iterator<Class<?>> iterator = set2.iterator();
    while (true) {
      if (iterator.hasNext()) {
        set1 = a(iterator.next());
        if (set1 != null && !set1.isEmpty()) {
          for (al al : set1)
            ((ConcurrentLinkedQueue<a>)this.c.get()).offer(new a(paramObject, al)); 
          bool = true;
        } 
        continue;
      } 
      if (!bool && !(paramObject instanceof am))
        post(new am(this, paramObject)); 
      b();
      return;
    } 
  }
  
  public final void register(Object paramObject) {
    if (paramObject != null) {
      Map map = ak.a(paramObject);
      Iterator<Class<?>> iterator = map.keySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Class<?> clazz = iterator.next();
          Set set = (Set)this.b.get(clazz);
          paramObject = set;
          if (set == null) {
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            set = this.b.putIfAbsent(clazz, copyOnWriteArraySet);
            paramObject = set;
            if (set == null)
              paramObject = copyOnWriteArraySet; 
          } 
          if (!paramObject.addAll((Set)map.get(clazz)))
            throw new IllegalArgumentException("Object already registered."); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  public final void unregister(Object paramObject) {
    if (paramObject == null)
      throw new NullPointerException("Object to unregister must not be null."); 
    for (Map.Entry entry : ak.a(paramObject).entrySet()) {
      Set set = a((Class)entry.getKey());
      Collection<?> collection = (Collection)entry.getValue();
      if (set == null || !set.containsAll(collection))
        throw new IllegalArgumentException("Missing event handler for a method. Is " + paramObject.getClass() + " registered?"); 
      for (al al : set) {
        if (collection.contains(al))
          al.b(); 
      } 
      set.removeAll(collection);
    } 
  }
  
  static final class a {
    final Object a;
    
    final al b;
    
    public a(Object param1Object, al param1al) {
      this.a = param1Object;
      this.b = param1al;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
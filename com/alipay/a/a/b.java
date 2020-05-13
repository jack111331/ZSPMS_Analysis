package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.json.alipay.a;

public final class b implements i, j {
  private static Collection<Object> a(Class<?> paramClass, Type paramType) {
    Collection<Object> collection;
    if (paramClass == AbstractCollection.class)
      return new ArrayList(); 
    if (paramClass.isAssignableFrom(HashSet.class))
      return new HashSet(); 
    if (paramClass.isAssignableFrom(LinkedHashSet.class))
      return new LinkedHashSet(); 
    if (paramClass.isAssignableFrom(TreeSet.class))
      return new TreeSet(); 
    if (paramClass.isAssignableFrom(ArrayList.class))
      return new ArrayList(); 
    if (paramClass.isAssignableFrom(EnumSet.class)) {
      if (paramType instanceof ParameterizedType) {
        Type type = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      } else {
        paramClass = Object.class;
      } 
      return (Collection)EnumSet.noneOf(paramClass);
    } 
    try {
      Collection<Object> collection1 = (Collection)paramClass.newInstance();
      collection = collection1;
    } catch (Exception exception) {
      throw new IllegalArgumentException("create instane error, class " + collection.getName());
    } 
    return collection;
  }
  
  public final Object a(Object paramObject) {
    ArrayList<Object> arrayList = new ArrayList();
    paramObject = ((Iterable)paramObject).iterator();
    while (paramObject.hasNext())
      arrayList.add(f.b(paramObject.next())); 
    return arrayList;
  }
  
  public final Object a(Object<Object> paramObject, Type paramType) {
    byte b1 = 0;
    if (!paramObject.getClass().equals(a.class))
      return null; 
    Class<?> clazz = a.a(paramType);
    a a = (a)paramObject;
    paramObject = (Object<Object>)a(clazz, paramType);
    if (paramType instanceof ParameterizedType) {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      while (true) {
        if (b1 < a.a()) {
          paramObject.add(e.a(a.a(b1), paramType));
          b1++;
          continue;
        } 
        return paramObject;
      } 
    } 
    throw new IllegalArgumentException("Does not support the implement for generics.");
  }
  
  public final boolean a(Class<?> paramClass) {
    return Collection.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
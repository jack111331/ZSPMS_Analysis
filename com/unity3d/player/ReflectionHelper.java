package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

final class ReflectionHelper {
  protected static boolean LOG;
  
  protected static final boolean LOGV = false;
  
  private static a[] a = new a[4096];
  
  private static long b = 0L;
  
  private static float a(Class paramClass1, Class paramClass2) {
    if (paramClass1.equals(paramClass2))
      return 1.0F; 
    if (!paramClass1.isPrimitive() && !paramClass2.isPrimitive()) {
      try {
        Class clazz = paramClass1.asSubclass(paramClass2);
        if (clazz != null)
          return 0.5F; 
      } catch (ClassCastException classCastException) {}
      try {
        paramClass1 = paramClass2.asSubclass(paramClass1);
        if (paramClass1 != null)
          return 0.1F; 
      } catch (ClassCastException classCastException) {}
    } 
    return 0.0F;
  }
  
  private static float a(Class paramClass, Class[] paramArrayOfClass1, Class[] paramArrayOfClass2) {
    int i;
    if (paramArrayOfClass2.length == 0)
      return 0.1F; 
    byte b = 0;
    if (paramArrayOfClass1 == null) {
      i = 0;
    } else {
      i = paramArrayOfClass1.length;
    } 
    if (i + 1 != paramArrayOfClass2.length)
      return 0.0F; 
    float f1 = 1.0F;
    float f2 = f1;
    if (paramArrayOfClass1 != null) {
      int j = paramArrayOfClass1.length;
      i = 0;
      while (true) {
        f2 = f1;
        if (b < j) {
          f1 *= a(paramArrayOfClass1[b], paramArrayOfClass2[i]);
          b++;
          i++;
          continue;
        } 
        break;
      } 
    } 
    return f2 * a(paramClass, paramArrayOfClass2[paramArrayOfClass2.length - 1]);
  }
  
  private static Class a(String paramString, int[] paramArrayOfint) {
    while (paramArrayOfint[0] < paramString.length()) {
      int i = paramArrayOfint[0];
      paramArrayOfint[0] = i + 1;
      char c = paramString.charAt(i);
      if (c != '(' && c != ')') {
        if (c == 'L') {
          i = paramString.indexOf(';', paramArrayOfint[0]);
          if (i != -1) {
            paramString = paramString.substring(paramArrayOfint[0], i);
            paramArrayOfint[0] = i + 1;
            paramString = paramString.replace('/', '.');
            try {
              return Class.forName(paramString);
            } catch (ClassNotFoundException classNotFoundException) {}
            return null;
          } 
          break;
        } 
        if (c == 'Z')
          return boolean.class; 
        if (c == 'I')
          return int.class; 
        if (c == 'F')
          return float.class; 
        if (c == 'V')
          return void.class; 
        if (c == 'B')
          return byte.class; 
        if (c == 'C')
          return char.class; 
        if (c == 'S')
          return short.class; 
        if (c == 'J')
          return long.class; 
        if (c == 'D')
          return double.class; 
        if (c == '[')
          return Array.newInstance(a((String)classNotFoundException, paramArrayOfint), 0).getClass(); 
        StringBuilder stringBuilder = new StringBuilder("! parseType; ");
        stringBuilder.append(c);
        stringBuilder.append(" is not known!");
        g.Log(5, stringBuilder.toString());
        break;
      } 
    } 
    return null;
  }
  
  private static void a(a parama, Member paramMember) {
    parama.a = paramMember;
    a[parama.hashCode() & a.length - 1] = parama;
  }
  
  private static boolean a(a parama) {
    a a1 = a[parama.hashCode() & a.length - 1];
    if (!parama.equals(a1))
      return false; 
    parama.a = a1.a;
    return true;
  }
  
  private static Class[] a(String paramString) {
    int[] arrayOfInt = new int[1];
    byte b = 0;
    arrayOfInt[0] = 0;
    ArrayList<Class<?>> arrayList = new ArrayList();
    while (arrayOfInt[0] < paramString.length()) {
      Class<?> clazz = a(paramString, arrayOfInt);
      if (clazz != null)
        arrayList.add(clazz); 
    } 
    Class[] arrayOfClass = new Class[arrayList.size()];
    Iterator<Class<?>> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      arrayOfClass[b] = iterator.next();
      b++;
    } 
    return arrayOfClass;
  }
  
  protected static void endUnityLaunch() {
    b++;
  }
  
  protected static Constructor getConstructorID(Class paramClass, String paramString) {
    Constructor constructor;
    a a1 = new a(paramClass, "", paramString);
    if (a(a1)) {
      constructor = (Constructor)a1.a;
    } else {
      Class[] arrayOfClass = a(paramString);
      float f = 0.0F;
      Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
      int i = arrayOfConstructor.length;
      byte b = 0;
      Constructor constructor1 = null;
      while (true) {
        constructor = constructor1;
        if (b < i) {
          constructor = arrayOfConstructor[b];
          float f1 = a(void.class, constructor.getParameterTypes(), arrayOfClass);
          float f2 = f;
          if (f1 > f)
            if (f1 != 1.0F) {
              constructor1 = constructor;
              f2 = f1;
            } else {
              break;
            }  
          b++;
          f = f2;
          continue;
        } 
        break;
      } 
      a(a1, constructor);
    } 
    if (constructor != null)
      return constructor; 
    StringBuilder stringBuilder = new StringBuilder("<init>");
    stringBuilder.append(paramString);
    stringBuilder.append(" in class ");
    stringBuilder.append(paramClass.getName());
    throw new NoSuchMethodError(stringBuilder.toString());
  }
  
  protected static Field getFieldID(Class paramClass, String paramString1, String paramString2, boolean paramBoolean) {
    Field field;
    Class clazz = paramClass;
    a a1 = new a(clazz, paramString1, paramString2);
    if (a(a1)) {
      field = (Field)a1.a;
    } else {
      Class[] arrayOfClass = a(paramString2);
      float f = 0.0F;
      paramClass = null;
      while (true) {
        Class clazz1 = paramClass;
        if (clazz != null) {
          Field field1;
          Field[] arrayOfField = clazz.getDeclaredFields();
          int i = arrayOfField.length;
          byte b = 0;
          while (b < i) {
            Field field3;
            Field field2 = arrayOfField[b];
            float f1 = f;
            Class clazz2 = paramClass;
            if (paramBoolean == Modifier.isStatic(field2.getModifiers())) {
              f1 = f;
              clazz2 = paramClass;
              if (field2.getName().compareTo(paramString1) == 0) {
                float f2 = a(field2.getType(), (Class[])null, arrayOfClass);
                f1 = f;
                clazz2 = paramClass;
                if (f2 > f)
                  if (f2 != 1.0F) {
                    f1 = f2;
                    field3 = field2;
                  } else {
                    Field field4 = field2;
                    f = f2;
                    break;
                  }  
              } 
            } 
            b++;
            f = f1;
            field1 = field3;
          } 
          field = field1;
          if (f != 1.0F) {
            field = field1;
            if (!clazz.isPrimitive()) {
              field = field1;
              if (!clazz.isInterface()) {
                field = field1;
                if (!clazz.equals(Object.class)) {
                  field = field1;
                  if (!clazz.equals(void.class)) {
                    clazz = clazz.getSuperclass();
                    continue;
                  } 
                } 
              } 
            } 
          } 
        } 
        break;
      } 
      a(a1, field);
    } 
    if (field == null) {
      String str;
      if (paramBoolean) {
        str = "static";
      } else {
        str = "non-static";
      } 
      throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", new Object[] { str, paramString1, paramString2, clazz.getName() }));
    } 
    return field;
  }
  
  protected static Method getMethodID(Class paramClass, String paramString1, String paramString2, boolean paramBoolean) {
    Method method;
    String str;
    a a1 = new a(paramClass, paramString1, paramString2);
    if (a(a1)) {
      method = (Method)a1.a;
    } else {
      Method method1;
      Class[] arrayOfClass = a(paramString2);
      float f = 0.0F;
      Class clazz2 = null;
      Class clazz1 = paramClass;
      paramClass = clazz2;
      while (true) {
        clazz2 = paramClass;
        if (clazz1 != null) {
          Method method2;
          Method[] arrayOfMethod = clazz1.getDeclaredMethods();
          int i = arrayOfMethod.length;
          byte b = 0;
          while (b < i) {
            Method method3;
            Method method4 = arrayOfMethod[b];
            float f1 = f;
            clazz2 = paramClass;
            if (paramBoolean == Modifier.isStatic(method4.getModifiers())) {
              f1 = f;
              clazz2 = paramClass;
              if (method4.getName().compareTo(paramString1) == 0) {
                float f2 = a(method4.getReturnType(), method4.getParameterTypes(), arrayOfClass);
                f1 = f;
                clazz2 = paramClass;
                if (f2 > f)
                  if (f2 != 1.0F) {
                    method3 = method4;
                    f1 = f2;
                  } else {
                    Method method5 = method4;
                    f = f2;
                    break;
                  }  
              } 
            } 
            b++;
            f = f1;
            method2 = method3;
          } 
          method1 = method2;
          if (f != 1.0F) {
            method1 = method2;
            if (!clazz1.isPrimitive()) {
              method1 = method2;
              if (!clazz1.isInterface()) {
                method1 = method2;
                if (!clazz1.equals(Object.class)) {
                  method1 = method2;
                  if (!clazz1.equals(void.class)) {
                    clazz1 = clazz1.getSuperclass();
                    continue;
                  } 
                } 
              } 
            } 
          } 
        } 
        break;
      } 
      a(a1, method1);
      paramClass = clazz1;
      method = method1;
    } 
    if (method == null) {
      if (paramBoolean) {
        str = "static";
      } else {
        str = "non-static";
      } 
      throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", new Object[] { str, paramString1, paramString2, paramClass.getName() }));
    } 
    return (Method)str;
  }
  
  private static native void nativeProxyFinalize(int paramInt);
  
  private static native Object nativeProxyInvoke(int paramInt, String paramString, Object[] paramArrayOfObject);
  
  private static native void nativeProxyLogJNIInvokeException();
  
  protected static Object newProxyInstance(int paramInt, Class paramClass) {
    return newProxyInstance(paramInt, new Class[] { paramClass });
  }
  
  protected static Object newProxyInstance(int paramInt, Class[] paramArrayOfClass) {
    return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), paramArrayOfClass, new InvocationHandler(paramInt, paramArrayOfClass) {
          private long c = ReflectionHelper.a();
          
          private static Object a(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
            Object[] arrayOfObject = param1ArrayOfObject;
            if (param1ArrayOfObject == null)
              try {
                arrayOfObject = new Object[0];
                Class<?> clazz1 = param1Method.getDeclaringClass();
                Constructor<MethodHandles.Lookup> constructor1 = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[] { Class.class, int.class });
                constructor1.setAccessible(true);
                return ((MethodHandles.Lookup)constructor1.newInstance(new Object[] { clazz1, Integer.valueOf(2) })).in(clazz1).unreflectSpecial(param1Method, clazz1).bindTo(param1Object).invokeWithArguments(arrayOfObject);
              } catch (NoClassDefFoundError noClassDefFoundError) {
                g.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                ReflectionHelper.b();
                return null;
              }  
            Class<?> clazz = param1Method.getDeclaringClass();
            Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[] { Class.class, int.class });
            constructor.setAccessible(true);
            return ((MethodHandles.Lookup)constructor.newInstance(new Object[] { clazz, Integer.valueOf(2) })).in(clazz).unreflectSpecial(param1Method, clazz).bindTo(noClassDefFoundError).invokeWithArguments(arrayOfObject);
          }
          
          protected final void finalize() {
            try {
              if (this.c == ReflectionHelper.a())
                ReflectionHelper.a(this.a); 
              return;
            } finally {
              super.finalize();
            } 
          }
          
          public final Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
            if (this.c != ReflectionHelper.a()) {
              g.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
              return null;
            } 
            Object object = ReflectionHelper.a(this.a, param1Method.getName(), param1ArrayOfObject);
            if (object == null) {
              if ((param1Method.getModifiers() & 0x400) == 0)
                return a(param1Object, param1Method, param1ArrayOfObject); 
              ReflectionHelper.b();
            } 
            return object;
          }
        });
  }
  
  private static final class a {
    public volatile Member a;
    
    private final Class b;
    
    private final String c;
    
    private final String d;
    
    private final int e;
    
    a(Class param1Class, String param1String1, String param1String2) {
      this.b = param1Class;
      this.c = param1String1;
      this.d = param1String2;
      this.e = ((this.b.hashCode() + 527) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public final boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof a) {
        param1Object = param1Object;
        if (this.e == ((a)param1Object).e && this.d.equals(((a)param1Object).d) && this.c.equals(((a)param1Object).c) && this.b.equals(((a)param1Object).b))
          return true; 
      } 
      return false;
    }
    
    public final int hashCode() {
      return this.e;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\ReflectionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
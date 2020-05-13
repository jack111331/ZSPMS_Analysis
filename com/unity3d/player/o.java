package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

final class o {
  private HashMap a = new HashMap<Object, Object>();
  
  private Class b = null;
  
  private Object c = null;
  
  public o(Class paramClass, Object paramObject) {
    this.b = paramClass;
    this.c = paramObject;
  }
  
  private void a(String paramString, a parama) {
    try {
      parama.b = this.b.getMethod(paramString, parama.a);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Exception while trying to get method ");
      stringBuilder.append(paramString);
      stringBuilder.append(". ");
      stringBuilder.append(exception.getLocalizedMessage());
      g.Log(6, stringBuilder.toString());
      parama.b = null;
      return;
    } 
  }
  
  public final Object a(String paramString, Object... paramVarArgs) {
    Object object;
    StringBuilder stringBuilder;
    if (!this.a.containsKey(paramString)) {
      stringBuilder = new StringBuilder("No definition for method ");
      stringBuilder.append(paramString);
      paramString = " can be found";
      stringBuilder.append(paramString);
      g.Log(6, stringBuilder.toString());
      return null;
    } 
    a a = (a)this.a.get(paramString);
    if (a.b == null)
      a(paramString, a); 
    if (a.b == null) {
      stringBuilder = new StringBuilder("Unable to create method: ");
      stringBuilder.append(paramString);
      g.Log(6, stringBuilder.toString());
      return null;
    } 
    try {
      Object object1;
      if (stringBuilder.length == 0) {
        object1 = a.b.invoke(this.c, new Object[0]);
        object = object1;
      } else {
        object1 = a.b.invoke(this.c, (Object[])object1);
        object = object1;
      } 
    } catch (Exception exception) {
      stringBuilder = new StringBuilder("Error trying to call delegated method ");
      stringBuilder.append((String)object);
      stringBuilder.append(". ");
      stringBuilder.append(exception.getLocalizedMessage());
      g.Log(6, stringBuilder.toString());
      object = null;
    } 
    return object;
  }
  
  public final void a(String paramString, Class[] paramArrayOfClass) {
    this.a.put(paramString, new a(this, paramArrayOfClass));
  }
  
  final class a {
    public Class[] a;
    
    public Method b;
    
    public a(o this$0, Class[] param1ArrayOfClass) {
      this.a = param1ArrayOfClass;
      this.b = null;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package org.jar.photo.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import org.jar.photo.bean.b;

public class a extends Observable {
  public static Object a = new Object();
  
  private static a b;
  
  private List<b> c = new ArrayList<b>();
  
  private List<b> d = new ArrayList<b>();
  
  public static a a() {
    // Byte code:
    //   0: getstatic org/jar/photo/b/a.b : Lorg/jar/photo/b/a;
    //   3: ifnonnull -> 39
    //   6: ldc org/jar/photo/b/a
    //   8: monitorenter
    //   9: getstatic org/jar/photo/b/a.b : Lorg/jar/photo/b/a;
    //   12: ifnonnull -> 27
    //   15: new org/jar/photo/b/a
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic org/jar/photo/b/a.b : Lorg/jar/photo/b/a;
    //   27: ldc org/jar/photo/b/a
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc org/jar/photo/b/a
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic org/jar/photo/b/a.b : Lorg/jar/photo/b/a;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  public void a(Collection<? extends b> paramCollection) {
    this.c.clear();
    if (paramCollection != null)
      this.c.addAll(paramCollection); 
  }
  
  public List<b> b() {
    return this.c;
  }
  
  public void b(Collection<? extends b> paramCollection) {
    this.d.clear();
    if (paramCollection != null)
      this.d.addAll(paramCollection); 
  }
  
  public List<b> c() {
    return this.d;
  }
  
  public void d() {
    setChanged();
    notifyObservers(a);
  }
  
  public void e() {
    this.c.clear();
  }
  
  public void f() {
    this.d.clear();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
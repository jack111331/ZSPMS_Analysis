package com.sdk.base.framework.a.c;

class a<T> {
  a<T> a;
  
  private boolean b = false;
  
  private e<?> c;
  
  a(T paramT) {
    a(paramT);
  }
  
  public b a() {
    return this.c.a;
  }
  
  public void a(T paramT) {
    if (paramT == null) {
      this.c = null;
      return;
    } 
    if (paramT instanceof e) {
      this.c = (e)paramT;
      this.b = true;
      return;
    } 
    this.c = new e(b.d, paramT);
  }
  
  public T b() {
    return (T)((this.c == null) ? null : (this.b ? this.c : (Object)this.c.b));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
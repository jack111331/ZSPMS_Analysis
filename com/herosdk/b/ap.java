package com.herosdk.b;

import java.io.Serializable;

public class ap implements Serializable, Comparable {
  private static final long c = -8708108746980739212L;
  
  private String a;
  
  private String b;
  
  public ap(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public int compareTo(Object paramObject) {
    paramObject = paramObject;
    int i = this.a.compareTo(((ap)paramObject).a);
    int j = i;
    if (i == 0)
      j = this.b.compareTo(((ap)paramObject).b); 
    return j;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramObject != null) {
      if (this == paramObject)
        return true; 
      if (paramObject instanceof ap) {
        paramObject = paramObject;
        if (this.a.equals(((ap)paramObject).a) && this.b.equals(((ap)paramObject).b))
          return bool1; 
        bool2 = false;
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString() {
    return "HttpPostParam{name='" + this.a + '\'' + ", value='" + this.b + '}';
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
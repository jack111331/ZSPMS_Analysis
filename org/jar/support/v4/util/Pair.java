package org.jar.support.v4.util;

public class Pair<F, S> {
  public final F first;
  
  public final S second;
  
  public Pair(F paramF, S paramS) {
    this.first = paramF;
    this.second = paramS;
  }
  
  public static <A, B> Pair<A, B> create(A paramA, B paramB) {
    return new Pair<A, B>(paramA, paramB);
  }
  
  private static boolean objectsEqual(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Pair;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (objectsEqual(((Pair)paramObject).first, this.first)) {
      bool = bool1;
      if (objectsEqual(((Pair)paramObject).second, this.second))
        bool = true; 
    } 
    return bool;
  }
  
  public int hashCode() {
    int j;
    F f = this.first;
    int i = 0;
    if (f == null) {
      j = 0;
    } else {
      j = this.first.hashCode();
    } 
    if (this.second != null)
      i = this.second.hashCode(); 
    return j ^ i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v\\util\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
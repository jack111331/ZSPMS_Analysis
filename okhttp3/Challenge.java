package okhttp3;

import okhttp3.internal.Util;

public final class Challenge {
  private final String realm;
  
  private final String scheme;
  
  public Challenge(String paramString1, String paramString2) {
    this.scheme = paramString1;
    this.realm = paramString2;
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof Challenge && Util.equal(this.scheme, ((Challenge)paramObject).scheme) && Util.equal(this.realm, ((Challenge)paramObject).realm));
  }
  
  public int hashCode() {
    byte b;
    int i = 0;
    if (this.realm != null) {
      b = this.realm.hashCode();
    } else {
      b = 0;
    } 
    if (this.scheme != null)
      i = this.scheme.hashCode(); 
    return (b + 899) * 31 + i;
  }
  
  public String realm() {
    return this.realm;
  }
  
  public String scheme() {
    return this.scheme;
  }
  
  public String toString() {
    return this.scheme + " realm=\"" + this.realm + "\"";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Challenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec {
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = new CipherSuite[] { 
      CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 
      CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  
  public static final ConnectionSpec CLEARTEXT;
  
  public static final ConnectionSpec COMPATIBLE_TLS;
  
  public static final ConnectionSpec MODERN_TLS = (new Builder(true)).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  
  private final String[] cipherSuites;
  
  private final boolean supportsTlsExtensions;
  
  private final boolean tls;
  
  private final String[] tlsVersions;
  
  static {
    COMPATIBLE_TLS = (new Builder(MODERN_TLS)).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
    CLEARTEXT = (new Builder(false)).build();
  }
  
  private ConnectionSpec(Builder paramBuilder) {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }
  
  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramArrayOfString1 != null) {
      bool2 = bool1;
      if (paramArrayOfString2 != null) {
        bool2 = bool1;
        if (paramArrayOfString1.length != 0) {
          if (paramArrayOfString2.length == 0)
            return bool1; 
        } else {
          return bool2;
        } 
      } else {
        return bool2;
      } 
    } else {
      return bool2;
    } 
    int i = paramArrayOfString1.length;
    byte b = 0;
    while (true) {
      bool2 = bool1;
      if (b < i) {
        if (Util.contains(paramArrayOfString2, paramArrayOfString1[b]))
          return true; 
        b++;
        continue;
      } 
      return bool2;
    } 
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean) {
    String[] arrayOfString1;
    String[] arrayOfString2;
    if (this.cipherSuites != null) {
      arrayOfString1 = (String[])Util.intersect(String.class, (Object[])this.cipherSuites, (Object[])paramSSLSocket.getEnabledCipherSuites());
    } else {
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    } 
    if (this.tlsVersions != null) {
      arrayOfString2 = (String[])Util.intersect(String.class, (Object[])this.tlsVersions, (Object[])paramSSLSocket.getEnabledProtocols());
    } else {
      arrayOfString2 = paramSSLSocket.getEnabledProtocols();
    } 
    String[] arrayOfString3 = arrayOfString1;
    if (paramBoolean) {
      arrayOfString3 = arrayOfString1;
      if (Util.contains(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV"))
        arrayOfString3 = Util.concat(arrayOfString1, "TLS_FALLBACK_SCSV"); 
    } 
    return (new Builder(this)).cipherSuites(arrayOfString3).tlsVersions(arrayOfString2).build();
  }
  
  void apply(SSLSocket paramSSLSocket, boolean paramBoolean) {
    ConnectionSpec connectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (connectionSpec.tlsVersions != null)
      paramSSLSocket.setEnabledProtocols(connectionSpec.tlsVersions); 
    if (connectionSpec.cipherSuites != null)
      paramSSLSocket.setEnabledCipherSuites(connectionSpec.cipherSuites); 
  }
  
  public List<CipherSuite> cipherSuites() {
    if (this.cipherSuites == null)
      return null; 
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[this.cipherSuites.length];
    for (byte b = 0; b < this.cipherSuites.length; b++)
      arrayOfCipherSuite[b] = CipherSuite.forJavaName(this.cipherSuites[b]); 
    return Util.immutableList((Object[])arrayOfCipherSuite);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = false;
    if (!(paramObject instanceof ConnectionSpec))
      return bool; 
    if (paramObject == this)
      return true; 
    paramObject = paramObject;
    null = bool;
    if (this.tls == ((ConnectionSpec)paramObject).tls) {
      if (this.tls) {
        null = bool;
        if (Arrays.equals((Object[])this.cipherSuites, (Object[])((ConnectionSpec)paramObject).cipherSuites)) {
          null = bool;
          if (Arrays.equals((Object[])this.tlsVersions, (Object[])((ConnectionSpec)paramObject).tlsVersions)) {
            null = bool;
            if (this.supportsTlsExtensions == ((ConnectionSpec)paramObject).supportsTlsExtensions)
              return true; 
          } 
        } 
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public int hashCode() {
    int i = 17;
    if (this.tls) {
      int j = Arrays.hashCode((Object[])this.cipherSuites);
      int k = Arrays.hashCode((Object[])this.tlsVersions);
      if (this.supportsTlsExtensions) {
        i = 0;
      } else {
        i = 1;
      } 
      i = ((j + 527) * 31 + k) * 31 + i;
    } 
    return i;
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield tls : Z
    //   6: ifne -> 13
    //   9: iload_2
    //   10: istore_3
    //   11: iload_3
    //   12: ireturn
    //   13: aload_0
    //   14: getfield tlsVersions : [Ljava/lang/String;
    //   17: ifnull -> 36
    //   20: iload_2
    //   21: istore_3
    //   22: aload_0
    //   23: getfield tlsVersions : [Ljava/lang/String;
    //   26: aload_1
    //   27: invokevirtual getEnabledProtocols : ()[Ljava/lang/String;
    //   30: invokestatic nonEmptyIntersection : ([Ljava/lang/String;[Ljava/lang/String;)Z
    //   33: ifeq -> 11
    //   36: aload_0
    //   37: getfield cipherSuites : [Ljava/lang/String;
    //   40: ifnull -> 59
    //   43: iload_2
    //   44: istore_3
    //   45: aload_0
    //   46: getfield cipherSuites : [Ljava/lang/String;
    //   49: aload_1
    //   50: invokevirtual getEnabledCipherSuites : ()[Ljava/lang/String;
    //   53: invokestatic nonEmptyIntersection : ([Ljava/lang/String;[Ljava/lang/String;)Z
    //   56: ifeq -> 11
    //   59: iconst_1
    //   60: istore_3
    //   61: goto -> 11
  }
  
  public boolean isTls() {
    return this.tls;
  }
  
  public boolean supportsTlsExtensions() {
    return this.supportsTlsExtensions;
  }
  
  public List<TlsVersion> tlsVersions() {
    if (this.tlsVersions == null)
      return null; 
    TlsVersion[] arrayOfTlsVersion = new TlsVersion[this.tlsVersions.length];
    for (byte b = 0; b < this.tlsVersions.length; b++)
      arrayOfTlsVersion[b] = TlsVersion.forJavaName(this.tlsVersions[b]); 
    return Util.immutableList((Object[])arrayOfTlsVersion);
  }
  
  public String toString() {
    String str;
    if (!this.tls)
      return "ConnectionSpec()"; 
    if (this.cipherSuites != null) {
      null = cipherSuites().toString();
    } else {
      null = "[all enabled]";
    } 
    if (this.tlsVersions != null) {
      str = tlsVersions().toString();
    } else {
      str = "[all enabled]";
    } 
    return "ConnectionSpec(cipherSuites=" + null + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
  }
  
  public static final class Builder {
    private String[] cipherSuites;
    
    private boolean supportsTlsExtensions;
    
    private boolean tls;
    
    private String[] tlsVersions;
    
    public Builder(ConnectionSpec param1ConnectionSpec) {
      this.tls = param1ConnectionSpec.tls;
      this.cipherSuites = param1ConnectionSpec.cipherSuites;
      this.tlsVersions = param1ConnectionSpec.tlsVersions;
      this.supportsTlsExtensions = param1ConnectionSpec.supportsTlsExtensions;
    }
    
    Builder(boolean param1Boolean) {
      this.tls = param1Boolean;
    }
    
    public Builder allEnabledCipherSuites() {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections"); 
      this.cipherSuites = null;
      return this;
    }
    
    public Builder allEnabledTlsVersions() {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections"); 
      this.tlsVersions = null;
      return this;
    }
    
    public ConnectionSpec build() {
      return new ConnectionSpec(this);
    }
    
    public Builder cipherSuites(String... param1VarArgs) {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections"); 
      if (param1VarArgs.length == 0)
        throw new IllegalArgumentException("At least one cipher suite is required"); 
      this.cipherSuites = (String[])param1VarArgs.clone();
      return this;
    }
    
    public Builder cipherSuites(CipherSuite... param1VarArgs) {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections"); 
      String[] arrayOfString = new String[param1VarArgs.length];
      for (byte b = 0; b < param1VarArgs.length; b++)
        arrayOfString[b] = (param1VarArgs[b]).javaName; 
      return cipherSuites(arrayOfString);
    }
    
    public Builder supportsTlsExtensions(boolean param1Boolean) {
      if (!this.tls)
        throw new IllegalStateException("no TLS extensions for cleartext connections"); 
      this.supportsTlsExtensions = param1Boolean;
      return this;
    }
    
    public Builder tlsVersions(String... param1VarArgs) {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections"); 
      if (param1VarArgs.length == 0)
        throw new IllegalArgumentException("At least one TLS version is required"); 
      this.tlsVersions = (String[])param1VarArgs.clone();
      return this;
    }
    
    public Builder tlsVersions(TlsVersion... param1VarArgs) {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections"); 
      String[] arrayOfString = new String[param1VarArgs.length];
      for (byte b = 0; b < param1VarArgs.length; b++)
        arrayOfString[b] = (param1VarArgs[b]).javaName; 
      return tlsVersions(arrayOfString);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\ConnectionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
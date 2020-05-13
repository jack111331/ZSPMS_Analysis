package okhttp3.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class CertificateChainCleaner {
  public static CertificateChainCleaner get(X509TrustManager paramX509TrustManager) {
    AndroidCertificateChainCleaner androidCertificateChainCleaner;
    BasicCertificateChainCleaner basicCertificateChainCleaner;
    try {
      Class<?> clazz = Class.forName("android.net.http.X509TrustManagerExtensions");
      Object object = clazz.getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager });
      Method method = clazz.getMethod("checkServerTrusted", new Class[] { X509Certificate[].class, String.class, String.class });
      AndroidCertificateChainCleaner androidCertificateChainCleaner1 = new AndroidCertificateChainCleaner();
      this(object, method);
      androidCertificateChainCleaner = androidCertificateChainCleaner1;
    } catch (Exception exception) {
      basicCertificateChainCleaner = new BasicCertificateChainCleaner(TrustRootIndex.get((X509TrustManager)androidCertificateChainCleaner));
    } 
    return basicCertificateChainCleaner;
  }
  
  public static CertificateChainCleaner get(X509Certificate... paramVarArgs) {
    return new BasicCertificateChainCleaner(TrustRootIndex.get(paramVarArgs));
  }
  
  public abstract List<Certificate> clean(List<Certificate> paramList, String paramString) throws SSLPeerUnverifiedException;
  
  static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    private final Method checkServerTrusted;
    
    private final Object x509TrustManagerExtensions;
    
    AndroidCertificateChainCleaner(Object param1Object, Method param1Method) {
      this.x509TrustManagerExtensions = param1Object;
      this.checkServerTrusted = param1Method;
    }
    
    public List<Certificate> clean(List<Certificate> param1List, String param1String) throws SSLPeerUnverifiedException {
      try {
        X509Certificate[] arrayOfX509Certificate = param1List.<X509Certificate>toArray(new X509Certificate[param1List.size()]);
        return (List)this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[] { arrayOfX509Certificate, "RSA", param1String });
      } catch (InvocationTargetException invocationTargetException) {
        SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(invocationTargetException.getMessage());
        sSLPeerUnverifiedException.initCause(invocationTargetException);
        throw sSLPeerUnverifiedException;
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError(illegalAccessException);
      } 
    }
  }
  
  static final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    
    private final TrustRootIndex trustRootIndex;
    
    public BasicCertificateChainCleaner(TrustRootIndex param1TrustRootIndex) {
      this.trustRootIndex = param1TrustRootIndex;
    }
    
    private boolean verifySignature(X509Certificate param1X509Certificate1, X509Certificate param1X509Certificate2) {
      boolean bool = false;
      if (param1X509Certificate1.getIssuerDN().equals(param1X509Certificate2.getSubjectDN()))
        try {
          param1X509Certificate1.verify(param1X509Certificate2.getPublicKey());
          bool = true;
        } catch (GeneralSecurityException generalSecurityException) {} 
      return bool;
    }
    
    public List<Certificate> clean(List<Certificate> param1List, String param1String) throws SSLPeerUnverifiedException {
      ArrayDeque<Certificate> arrayDeque = new ArrayDeque<Certificate>(param1List);
      ArrayList<X509Certificate> arrayList = new ArrayList();
      arrayList.add(arrayDeque.removeFirst());
      boolean bool = false;
      byte b = 0;
      label24: while (b < 9) {
        X509Certificate x509Certificate1 = arrayList.get(arrayList.size() - 1);
        X509Certificate x509Certificate2 = this.trustRootIndex.findByIssuerAndSignature(x509Certificate1);
        if (x509Certificate2 != null) {
          if (arrayList.size() > 1 || !x509Certificate1.equals(x509Certificate2))
            arrayList.add(x509Certificate2); 
          if (!verifySignature(x509Certificate2, x509Certificate2)) {
            bool = true;
            b++;
            continue;
          } 
          return (List)arrayList;
        } 
        Iterator<Certificate> iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
          X509Certificate x509Certificate = (X509Certificate)iterator.next();
          if (verifySignature(x509Certificate1, x509Certificate)) {
            iterator.remove();
            arrayList.add(x509Certificate);
            continue label24;
          } 
        } 
        if (!bool)
          throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate1); 
        return (List)arrayList;
      } 
      throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\tls\CertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
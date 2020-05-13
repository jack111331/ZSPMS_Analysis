package com.cmic.sso.sdk.b.c;

import android.os.Bundle;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class a {
  private static String d = "";
  
  private X509Certificate a;
  
  private SSLContext b;
  
  private Bundle c;
  
  public a(Bundle paramBundle) {
    this.c = paramBundle;
    b();
    try {
      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(null, null);
      keyStore.setCertificateEntry("cert", this.a);
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init(keyStore);
      this.b = SSLContext.getInstance("SSL");
      this.b.init(null, trustManagerFactory.getTrustManagers(), null);
      return;
    } catch (KeyStoreException keyStoreException) {
    
    } catch (KeyManagementException keyManagementException) {
    
    } catch (IOException iOException) {
    
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (CertificateException certificateException) {}
    paramBundle.putBoolean("isNeedToGetCert", true);
    certificateException.printStackTrace();
  }
  
  public static void a(String paramString) {
    d = paramString;
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/security/cert/X509Certificate;
    //   4: ifnonnull -> 51
    //   7: new java/io/ByteArrayInputStream
    //   10: astore_1
    //   11: aload_1
    //   12: getstatic com/cmic/sso/sdk/b/c/a.d : Ljava/lang/String;
    //   15: invokevirtual getBytes : ()[B
    //   18: iconst_0
    //   19: invokestatic decode : ([BI)[B
    //   22: invokespecial <init> : ([B)V
    //   25: aload_1
    //   26: astore_2
    //   27: aload_0
    //   28: ldc 'X.509'
    //   30: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   33: aload_1
    //   34: invokevirtual generateCertificate : (Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   37: checkcast java/security/cert/X509Certificate
    //   40: putfield a : Ljava/security/cert/X509Certificate;
    //   43: aload_1
    //   44: ifnull -> 51
    //   47: aload_1
    //   48: invokevirtual close : ()V
    //   51: return
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual printStackTrace : ()V
    //   57: goto -> 51
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_2
    //   65: aload_0
    //   66: getfield c : Landroid/os/Bundle;
    //   69: ldc 'isNeedToGetCert'
    //   71: iconst_1
    //   72: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   75: aload_1
    //   76: astore_2
    //   77: aload_3
    //   78: invokevirtual printStackTrace : ()V
    //   81: aload_1
    //   82: ifnull -> 51
    //   85: aload_1
    //   86: invokevirtual close : ()V
    //   89: goto -> 51
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual printStackTrace : ()V
    //   97: goto -> 51
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull -> 111
    //   107: aload_2
    //   108: invokevirtual close : ()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_2
    //   114: aload_2
    //   115: invokevirtual printStackTrace : ()V
    //   118: goto -> 111
    //   121: astore_1
    //   122: goto -> 103
    //   125: astore_3
    //   126: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   7	25	60	java/lang/Exception
    //   7	25	100	finally
    //   27	43	125	java/lang/Exception
    //   27	43	121	finally
    //   47	51	52	java/io/IOException
    //   65	75	121	finally
    //   77	81	121	finally
    //   85	89	92	java/io/IOException
    //   107	111	113	java/io/IOException
  }
  
  public SSLContext a() {
    return this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.unionpay.a;

import android.content.Context;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class b implements X509TrustManager {
  private X509TrustManager a = null;
  
  private Context b;
  
  public b(Context paramContext) {
    this.b = paramContext;
    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init((KeyStore)null);
    TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
    if (arrayOfTrustManager.length == 0)
      throw new NoSuchAlgorithmException("no trust manager found"); 
    this.a = (X509TrustManager)arrayOfTrustManager[0];
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljavax/net/ssl/X509TrustManager;
    //   4: aload_1
    //   5: aload_2
    //   6: invokeinterface checkServerTrusted : ([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    //   11: aload_1
    //   12: iconst_0
    //   13: aaload
    //   14: invokevirtual getIssuerX500Principal : ()Ljavax/security/auth/x500/X500Principal;
    //   17: astore_3
    //   18: new java/util/ArrayList
    //   21: astore_2
    //   22: aload_2
    //   23: iconst_0
    //   24: invokespecial <init> : (I)V
    //   27: aload_2
    //   28: ldc '.*O=(GeoTrust Inc\.|VeriSign\\, Inc\.|Symantec Corporation).*'
    //   30: invokeinterface add : (Ljava/lang/Object;)Z
    //   35: pop
    //   36: aload_0
    //   37: getfield b : Landroid/content/Context;
    //   40: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   43: astore #4
    //   45: aload #4
    //   47: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   50: ifne -> 62
    //   53: aload_2
    //   54: aload #4
    //   56: invokeinterface add : (Ljava/lang/Object;)Z
    //   61: pop
    //   62: iconst_0
    //   63: istore #5
    //   65: iload #5
    //   67: aload_2
    //   68: invokeinterface size : ()I
    //   73: if_icmpge -> 233
    //   76: aload_2
    //   77: iload #5
    //   79: invokeinterface get : (I)Ljava/lang/Object;
    //   84: checkcast java/lang/String
    //   87: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   90: aload_3
    //   91: invokevirtual getName : ()Ljava/lang/String;
    //   94: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   97: invokevirtual matches : ()Z
    //   100: ifeq -> 130
    //   103: iconst_1
    //   104: istore #5
    //   106: iload #5
    //   108: ifne -> 136
    //   111: new java/security/cert/CertificateException
    //   114: astore_1
    //   115: aload_1
    //   116: invokespecial <init> : ()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: new java/security/cert/CertificateException
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: athrow
    //   130: iinc #5, 1
    //   133: goto -> 65
    //   136: aload_1
    //   137: iconst_0
    //   138: aaload
    //   139: invokevirtual getSubjectX500Principal : ()Ljavax/security/auth/x500/X500Principal;
    //   142: astore_1
    //   143: new java/util/ArrayList
    //   146: astore_2
    //   147: aload_2
    //   148: iconst_0
    //   149: invokespecial <init> : (I)V
    //   152: aload_2
    //   153: ldc '.*CN=.*(\.95516\.com|\.chinaunionpay\.com|\.unionpay\.com|\.unionpaysecure\.com|\.95516\.net).*'
    //   155: invokeinterface add : (Ljava/lang/Object;)Z
    //   160: pop
    //   161: iconst_0
    //   162: istore #5
    //   164: iload #5
    //   166: aload_2
    //   167: invokeinterface size : ()I
    //   172: if_icmpge -> 227
    //   175: aload_2
    //   176: iload #5
    //   178: invokeinterface get : (I)Ljava/lang/Object;
    //   183: checkcast java/lang/String
    //   186: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   189: aload_1
    //   190: invokevirtual getName : ()Ljava/lang/String;
    //   193: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   196: invokevirtual matches : ()Z
    //   199: ifeq -> 220
    //   202: iconst_1
    //   203: istore #5
    //   205: iload #5
    //   207: ifne -> 226
    //   210: new java/security/cert/CertificateException
    //   213: astore_1
    //   214: aload_1
    //   215: invokespecial <init> : ()V
    //   218: aload_1
    //   219: athrow
    //   220: iinc #5, 1
    //   223: goto -> 164
    //   226: return
    //   227: iconst_0
    //   228: istore #5
    //   230: goto -> 205
    //   233: iconst_0
    //   234: istore #5
    //   236: goto -> 106
    // Exception table:
    //   from	to	target	type
    //   11	62	121	java/lang/Exception
    //   65	103	121	java/lang/Exception
    //   111	121	121	java/lang/Exception
    //   136	161	121	java/lang/Exception
    //   164	202	121	java/lang/Exception
    //   210	220	121	java/lang/Exception
  }
  
  public final X509Certificate[] getAcceptedIssuers() {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
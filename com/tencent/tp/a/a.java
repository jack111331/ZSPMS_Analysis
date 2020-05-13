package com.tencent.tp.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.tencent.tp.TssSdkRuntime;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;

public class a {
  private Context a;
  
  private String b;
  
  private X509Certificate c;
  
  public a(Context paramContext, String paramString) {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private void d() throws Exception {
    if (this.c != null)
      return; 
    e();
  }
  
  private void e() throws Exception {
    if (this.b == null) {
      this.b = TssSdkRuntime.getPackageName();
      if (this.b == null)
        return; 
    } 
    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.b, 64);
    if (packageInfo == null)
      return; 
    Signature[] arrayOfSignature = packageInfo.signatures;
    if (arrayOfSignature == null)
      return; 
    if (arrayOfSignature.length > 0) {
      byte[] arrayOfByte = arrayOfSignature[0].toByteArray();
      this.c = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(arrayOfByte));
    } 
  }
  
  public String a() {
    BigInteger bigInteger2;
    BigInteger bigInteger1 = null;
    try {
      d();
      bigInteger2 = bigInteger1;
      if (this.c != null) {
        PublicKey publicKey = this.c.getPublicKey();
        String str2 = publicKey.getAlgorithm();
        if (str2 != null && str2.indexOf("RSA") != -1) {
          bigInteger2 = ((RSAPublicKey)publicKey).getModulus();
        } else {
          bigInteger2 = bigInteger1;
          if (str2 != null) {
            bigInteger2 = bigInteger1;
            if (str2.indexOf("DSA") != -1) {
              bigInteger2 = ((DSAPublicKey)publicKey).getParams().getP();
            } else {
              return (String)bigInteger2;
            } 
          } else {
            return (String)bigInteger2;
          } 
        } 
        String str1 = bigInteger2.toString();
      } 
    } catch (Throwable throwable) {
      bigInteger2 = bigInteger1;
    } 
    return (String)bigInteger2;
  }
  
  public String b() {
    String str2;
    String str1 = null;
    try {
      d();
      str2 = str1;
      if (this.c != null)
        str2 = this.c.getIssuerDN().toString(); 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
  
  public String c() {
    String str2;
    String str1 = null;
    try {
      d();
      str2 = str1;
      if (this.c != null)
        str2 = this.c.getSubjectDN().toString(); 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
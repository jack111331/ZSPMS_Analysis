package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.g.b;
import com.sdk.base.module.manager.SDKManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public class d<T> {
  public static final String a;
  
  private static final String b = d.class.getSimpleName();
  
  private static boolean c = c.h;
  
  private static final HostnameVerifier d;
  
  private Context e;
  
  private e<T> f;
  
  static {
    a = UUID.randomUUID().toString();
    d = new HostnameVerifier() {
        public boolean verify(String param1String, SSLSession param1SSLSession) {
          return true;
        }
      };
  }
  
  public d(Context paramContext, e<T> parame) {
    this.e = paramContext;
    this.f = parame;
  }
  
  private boolean b(String paramString) {
    return (SDKManager.c() && (paramString.contains("/dro/netm/v1.0/qc") || paramString.contains("/dro/netm/v1.0/gctcbs") || paramString.contains("&ret_url")));
  }
  
  @SuppressLint({"NewApi"})
  private ArrayList<String> c(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    if (com.sdk.base.framework.utils.k.a.b(paramString).booleanValue())
      arrayList.add(paramString); 
    return arrayList;
  }
  
  private SSLSocketFactory e() {
    return HttpsURLConnection.getDefaultSSLSocketFactory();
  }
  
  @SuppressLint({"NewApi"})
  private void f() {
    CookieHandler.setDefault(new CookieManager());
  }
  
  public ByteArrayOutputStream a(e<T> parame) {
    FileInputStream fileInputStream;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    if (parame != null) {
      try {
        String str = parame.b(this.f.e());
        if (parame.d().contains("/dro/log/v1.0/log"))
          str = parame.e().toString(); 
        ArrayList<File> arrayList = parame.b();
        if (arrayList != null && arrayList.size() > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          byteArrayOutputStream.write(stringBuilder.append("--").append(a).append("\r\n").toString().getBytes("utf-8"));
          byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes("utf-8"));
          byteArrayOutputStream.write("\r\n\r\n".getBytes("utf-8"));
          byteArrayOutputStream.write(str.getBytes("utf-8"));
          byteArrayOutputStream.write("\r\n".getBytes("utf-8"));
          for (byte b = 0;; b++) {
            if (b < arrayList.size()) {
              File file = arrayList.get(b);
              if (file != null) {
                fileInputStream = new FileInputStream();
                this(file);
                if (fileInputStream != null) {
                  String str1 = file.getName();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this();
                  byteArrayOutputStream.write(stringBuilder1.append("--").append(a).append("\r\n").toString().getBytes("utf-8"));
                  stringBuilder1 = new StringBuilder();
                  this();
                  byteArrayOutputStream.write(stringBuilder1.append("Content-Disposition: form-data; name=\"").append(str1).append("\"; filename=\"").append(str1).append("\"\r\n").toString().getBytes("utf-8"));
                  byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes("utf-8"));
                  byteArrayOutputStream.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes("utf-8"));
                  byte[] arrayOfByte = new byte[1024];
                  while (true) {
                    int i = fileInputStream.read(arrayOfByte);
                    if (i != -1) {
                      byteArrayOutputStream.write(arrayOfByte, 0, i);
                      continue;
                    } 
                    StringBuilder stringBuilder2 = new StringBuilder();
                    this();
                    byteArrayOutputStream.write(stringBuilder2.append("\r\n--").append(a).append("--\r\n").toString().getBytes("utf-8"));
                    byteArrayOutputStream.flush();
                    fileInputStream.close();
                    break;
                  } 
                } 
              } 
            } else {
              return byteArrayOutputStream;
            } 
          } 
        } 
      } catch (Exception exception) {
        b.c(b, exception.getMessage(), Boolean.valueOf(c));
        return byteArrayOutputStream;
      } 
    } else {
      return byteArrayOutputStream;
    } 
    byteArrayOutputStream.write(fileInputStream.getBytes("utf-8"));
    return byteArrayOutputStream;
  }
  
  public String a() {
    try {
      if (this.f != null) {
        String str1 = this.f.a();
        String str2 = this.f.d();
        if (str1.equals(a.a(a.a))) {
          String str4;
          String str5 = this.f.b(this.f.e());
          str1 = str2;
          if (com.sdk.base.framework.utils.k.a.b(str5).booleanValue()) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            str4 = stringBuilder.append(str2).append("?").append(str5).toString();
          } 
          return str4;
        } 
        String str3 = this.f.g();
        str1 = str2;
        if (com.sdk.base.framework.utils.k.a.b(str3).booleanValue()) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          str1 = stringBuilder.append(str2).append("?unikey=").append(str3).toString();
        } 
        return str1;
      } 
    } catch (Exception exception) {
      b.c(b, exception.getMessage(), Boolean.valueOf(c));
    } 
    return null;
  }
  
  @SuppressLint({"DefaultLocale"})
  public HttpURLConnection a(String paramString) {
    HttpURLConnection httpURLConnection = null;
    b.a.c.a();
    try {
      HttpURLConnection httpURLConnection1;
      URL uRL;
      int i;
      f();
      HttpURLConnection httpURLConnection2 = httpURLConnection;
      if (com.sdk.base.framework.utils.k.a.b(paramString).booleanValue()) {
        uRL = new URL();
        this(paramString);
        i = b.a(this.e, null).a();
        if (b(paramString) && i != b.a.b.a()) {
          int j = AppUtils.getAndroidSDKVersion(this.e);
          if (j < 23) {
            i = d();
            if (j > 21 && i != b.a.b.a()) {
              a a = new a();
              this(this.e, uRL);
              httpURLConnection1 = a.a();
            } else {
              paramString = null;
            } 
          } else {
            a a = new a();
            this(this.e, uRL);
            httpURLConnection1 = a.a();
          } 
          httpURLConnection2 = httpURLConnection1;
          if (httpURLConnection1 == null)
            return httpURLConnection; 
        } else {
          httpURLConnection2 = null;
        } 
      } else {
        return httpURLConnection2;
      } 
      if (httpURLConnection2 == null) {
        httpURLConnection1 = (HttpURLConnection)uRL.openConnection();
      } else {
        int j = b.a.a.a();
        if (i == j) {
          i = 2;
          httpURLConnection1 = httpURLConnection2;
        } else {
          httpURLConnection1 = httpURLConnection2;
        } 
      } 
      String str = uRL.getProtocol();
      if (com.sdk.base.framework.utils.k.a.b(str).booleanValue() && "https".equals(str.toLowerCase(Locale.getDefault()))) {
        httpURLConnection1 = httpURLConnection1;
        httpURLConnection1.setSSLSocketFactory(e());
        httpURLConnection1.setHostnameVerifier(d);
      } 
      httpURLConnection1.setDoOutput(true);
      httpURLConnection1.setConnectTimeout(30000);
      httpURLConnection1.setReadTimeout(30000);
      httpURLConnection1.setInstanceFollowRedirects(true);
      httpURLConnection1.setRequestProperty("user-agent", com.sdk.base.framework.utils.d.a.a(this.e));
      StringBuilder stringBuilder = new StringBuilder();
      this();
      httpURLConnection1.setRequestProperty("netType", stringBuilder.append(i).append("").toString());
      HashMap<String, Object> hashMap = this.f.i();
      if (hashMap != null && hashMap.size() > 0)
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
          String str1 = (String)entry.getKey();
          entry = (Map.Entry<String, Object>)entry.getValue();
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          httpURLConnection1.setRequestProperty(str1, stringBuilder1.append(entry).append("").toString());
        }  
    } catch (Exception exception) {
      b.c(b, exception.toString(), Boolean.valueOf(c));
      throw exception;
    } 
    return (HttpURLConnection)exception;
  }
  
  public HttpURLConnection a(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null) {
      if (this.f != null && this.f.c()) {
        paramHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + a);
      } else {
        paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      } 
      paramHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      paramHttpURLConnection.setRequestProperty("connection", "keep-alive");
      if (this.f != null) {
        if (a.a(a.b).equals(this.f.a())) {
          paramHttpURLConnection.setRequestMethod("POST");
          paramHttpURLConnection.connect();
          ByteArrayOutputStream byteArrayOutputStream = a(this.f);
          OutputStream outputStream = paramHttpURLConnection.getOutputStream();
          new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset());
          outputStream.write(byteArrayOutputStream.toByteArray());
          return paramHttpURLConnection;
        } 
      } else {
        return paramHttpURLConnection;
      } 
    } else {
      return paramHttpURLConnection;
    } 
    paramHttpURLConnection.setRequestMethod("GET");
    paramHttpURLConnection.connect();
    return paramHttpURLConnection;
  }
  
  public e<T> b() {
    return this.f;
  }
  
  public void c() {
    this.f.a(a.a.toString());
  }
  
  public int d() {
    String str = this.f.d();
    if (b(str)) {
      ArrayList<String> arrayList = c(str);
      return b.a(this.e, arrayList).a();
    } 
    return b.a(this.e, null).a();
  }
  
  public enum a {
    a("GET"),
    b("POST"),
    c("PUT"),
    d("HEAD"),
    e("MOVE"),
    f("COPY"),
    g("DELETE"),
    h("OPTIONS"),
    i("TRACE"),
    j("CONNECT");
    
    private final String k;
    
    a(String param1String1) {
      this.k = param1String1;
    }
    
    public String toString() {
      return this.k;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
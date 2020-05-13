package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AndroidDnsServer {
  public static IResolver defaultResolver() {
    return new IResolver() {
        public Record[] resolve(Domain param1Domain, NetworkInfo param1NetworkInfo) throws IOException {
          InetAddress[] arrayOfInetAddress1 = AndroidDnsServer.getByReflection();
          InetAddress[] arrayOfInetAddress2 = arrayOfInetAddress1;
          if (arrayOfInetAddress1 == null)
            arrayOfInetAddress2 = AndroidDnsServer.getByCommand(); 
          if (arrayOfInetAddress2 != null) {
            Record[] arrayOfRecord = (new HijackingDetectWrapper(new Resolver(arrayOfInetAddress2[0]))).resolve(param1Domain, param1NetworkInfo);
            if (param1Domain.hasCname) {
              int i = arrayOfRecord.length;
              byte b = 0;
              while (true) {
                if (b < i) {
                  if (arrayOfRecord[b].isCname()) {
                    b = 1;
                    break;
                  } 
                  b++;
                  continue;
                } 
                b = 0;
                break;
              } 
              if (b == 0)
                throw new DnshijackingException(param1Domain.domain, arrayOfInetAddress2[0].getHostAddress()); 
            } 
            if (param1Domain.maxTtl != 0) {
              int i = arrayOfRecord.length;
              byte b = 0;
              while (b < i) {
                Record record = arrayOfRecord[b];
                if (record.isCname() || record.ttl <= param1Domain.maxTtl) {
                  b++;
                  continue;
                } 
                throw new DnshijackingException(param1Domain.domain, arrayOfInetAddress2[0].getHostAddress(), record.ttl);
              } 
            } 
            return arrayOfRecord;
          } 
          throw new IOException("cant get local dns server");
        }
      };
  }
  
  public static InetAddress[] getByCommand() {
    try {
      InputStream inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
      LineNumberReader lineNumberReader = new LineNumberReader();
      InputStreamReader inputStreamReader = new InputStreamReader();
      this(inputStream);
      this(inputStreamReader);
      ArrayList<InetAddress> arrayList = new ArrayList();
      this(5);
      while (true) {
        String str = lineNumberReader.readLine();
        if (str != null) {
          int i = str.indexOf("]: [");
          if (i == -1)
            continue; 
          String str1 = str.substring(1, i);
          str = str.substring(i + 4, str.length() - 1);
          if (str1.endsWith(".dns") || str1.endsWith(".dns1") || str1.endsWith(".dns2") || str1.endsWith(".dns3") || str1.endsWith(".dns4")) {
            InetAddress inetAddress = InetAddress.getByName(str);
            if (inetAddress == null)
              continue; 
            str = inetAddress.getHostAddress();
            if (str == null || str.length() == 0)
              continue; 
            arrayList.add(inetAddress);
          } 
          continue;
        } 
        return (arrayList.size() > 0) ? arrayList.<InetAddress>toArray(new InetAddress[arrayList.size()]) : null;
      } 
    } catch (IOException iOException) {
      Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", iOException);
    } 
    return null;
  }
  
  public static InetAddress[] getByReflection() {
    try {
      Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ArrayList<InetAddress> arrayList = new ArrayList();
      this(5);
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "net.dns1";
      arrayOfString[1] = "net.dns2";
      arrayOfString[2] = "net.dns3";
      arrayOfString[3] = "net.dns4";
      int i = arrayOfString.length;
      for (byte b = 0; b < i; b++) {
        String str = (String)method.invoke(null, new Object[] { arrayOfString[b] });
        if (str != null && str.length() != 0) {
          InetAddress inetAddress = InetAddress.getByName(str);
          if (inetAddress != null) {
            String str1 = inetAddress.getHostAddress();
            if (str1 != null && str1.length() != 0 && !arrayList.contains(inetAddress))
              arrayList.add(inetAddress); 
          } 
        } 
      } 
      if (arrayList.size() > 0)
        return arrayList.<InetAddress>toArray(new InetAddress[arrayList.size()]); 
    } catch (Exception exception) {
      Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", exception);
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\local\AndroidDnsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.xy.whf.helper;

import com.xy.whf.entity.UrlEntity;
import java.util.HashMap;

public class l {
  public static UrlEntity a(String paramString) {
    UrlEntity urlEntity = new UrlEntity();
    if (paramString != null) {
      paramString = paramString.trim();
      if (!paramString.equals("")) {
        String[] arrayOfString = paramString.split("\\?");
        urlEntity.baseUrl = arrayOfString[0];
        if (arrayOfString.length != 1) {
          String[] arrayOfString1 = arrayOfString[1].split("&");
          urlEntity.params = new HashMap<Object, Object>();
          int i = arrayOfString1.length;
          byte b = 0;
          while (true) {
            if (b < i) {
              arrayOfString = arrayOfString1[b].split("=");
              urlEntity.params.put(arrayOfString[0], arrayOfString[1]);
              b++;
              continue;
            } 
            return urlEntity;
          } 
        } 
      } 
    } 
    return urlEntity;
  }
  
  public static String b(String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore_1
    //   3: aload_1
    //   4: astore_2
    //   5: aload_0
    //   6: invokestatic isNullOrEmpty : (Ljava/lang/Object;)Z
    //   9: ifne -> 75
    //   12: aload_0
    //   13: ldc 'http'
    //   15: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   18: ifne -> 32
    //   21: aload_1
    //   22: astore_2
    //   23: aload_0
    //   24: ldc 'https'
    //   26: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   29: ifeq -> 75
    //   32: aload_0
    //   33: invokestatic create : (Ljava/lang/String;)Ljava/net/URI;
    //   36: invokevirtual getHost : ()Ljava/lang/String;
    //   39: astore_0
    //   40: aload_1
    //   41: astore_2
    //   42: aload_0
    //   43: invokestatic isNullOrEmpty : (Ljava/lang/Object;)Z
    //   46: ifne -> 75
    //   49: aload_1
    //   50: astore_2
    //   51: aload_0
    //   52: ldc '.'
    //   54: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   57: ifeq -> 75
    //   60: aload_0
    //   61: aload_0
    //   62: ldc '.'
    //   64: invokevirtual indexOf : (Ljava/lang/String;)I
    //   67: aload_0
    //   68: invokevirtual length : ()I
    //   71: invokevirtual substring : (II)Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual printStackTrace : ()V
    //   82: aload_1
    //   83: astore_2
    //   84: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   32	40	77	java/lang/Exception
    //   42	49	77	java/lang/Exception
    //   51	75	77	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
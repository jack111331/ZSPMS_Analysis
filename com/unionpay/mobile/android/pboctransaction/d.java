package com.unionpay.mobile.android.pboctransaction;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.utils.k;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d {
  public static String a;
  
  public static String b;
  
  private static Date l = new Date(System.currentTimeMillis());
  
  private static String m = (new SimpleDateFormat("yyyyMMddhhmmss")).format(l);
  
  private static HashMap<String, String> o = new HashMap<String, String>();
  
  private static d s;
  
  c c;
  
  a d;
  
  public boolean e = false;
  
  private String f = "1.4";
  
  private byte g = (byte)0;
  
  private byte h = (byte)0;
  
  private byte i = (byte)1;
  
  private boolean j = true;
  
  private boolean k = true;
  
  private String n = null;
  
  private final String p = "A0000003334355502D4D4F42494C45";
  
  private boolean q = false;
  
  private String r = "";
  
  static {
    a = "A0000003330101010000000000010000";
    b = "A0000003330101020001050001000000";
    s = null;
  }
  
  public d(c paramc, a parama, String paramString) {
    this.f = paramString;
    this.c = paramc;
    this.d = parama;
  }
  
  private static String a(String paramString1, String paramString2) {
    byte b = 1;
    if (paramString1 == null)
      return null; 
    byte[] arrayOfByte = e.a(paramString1);
    int i = 0;
    while (true) {
      if (i < arrayOfByte.length) {
        int j;
        if ((byte)(arrayOfByte[i] & 0x1F) == 31) {
          j = 2;
        } else {
          j = 1;
        } 
        byte[] arrayOfByte1 = new byte[j];
        System.arraycopy(arrayOfByte, i, arrayOfByte1, 0, j);
        if (e.a(arrayOfByte1, j).compareToIgnoreCase(paramString2) == 0) {
          int m = j + i;
          if ((byte)(arrayOfByte[m] & 0x80) != Byte.MIN_VALUE) {
            i = arrayOfByte[m] & 0xFF;
            j = b;
          } else {
            j = (arrayOfByte[m] & Byte.MAX_VALUE) + 1;
            if (j == 2) {
              i = arrayOfByte[m + 1] & 0xFF;
            } else if (j == 3) {
              i = (arrayOfByte[m + 1] & 0xFF) << 8 | arrayOfByte[m + 2] & 0xFF;
            } else if (j == 4) {
              i = (arrayOfByte[m + 1] & 0xFF) << 16 | (arrayOfByte[m + 2] & 0xFF) << 8 | arrayOfByte[m + 3] & 0xFF;
            } else {
              i = 0;
            } 
          } 
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte, m + j, arrayOfByte2, 0, i);
          return e.a(arrayOfByte2, i);
        } 
        if ((arrayOfByte[i] & 0x20) == 32) {
          j += i;
          if (j < arrayOfByte.length && (byte)(arrayOfByte[j] & 0x80) == Byte.MIN_VALUE) {
            i = (arrayOfByte[j] & Byte.MAX_VALUE) + 1;
          } else {
            i = 1;
          } 
          i += j;
          continue;
        } 
        int k = i + j;
        if (k < arrayOfByte.length && (byte)(arrayOfByte[k] & 0x80) == 0) {
          i = arrayOfByte[k] & 0xFF;
          j = 1;
        } else {
          if (k < arrayOfByte.length) {
            j = (arrayOfByte[k] & Byte.MAX_VALUE) + 1;
          } else {
            j = 0;
          } 
          if (j == 2 && k + 1 < arrayOfByte.length) {
            i = arrayOfByte[k + 1] & 0xFF;
          } else if (j == 3 && k + 2 < arrayOfByte.length) {
            i = (arrayOfByte[k + 1] & 0xFF) << 8 | arrayOfByte[k + 2] & 0xFF;
          } else if (j == 4 && k + 2 < arrayOfByte.length) {
            i = (arrayOfByte[k + 1] & 0xFF) << 16 | (arrayOfByte[k + 2] & 0xFF) << 8 | arrayOfByte[k + 3] & 0xFF;
          } else {
            i = 0;
          } 
        } 
        i = i + j + k;
        continue;
      } 
      return null;
    } 
  }
  
  private static String a(String paramString, boolean paramBoolean) {
    StringBuffer stringBuffer = new StringBuffer();
    byte[] arrayOfByte = paramString.toUpperCase().getBytes();
    int i = arrayOfByte.length;
    int j;
    for (j = 0; j < i; j++) {
      stringBuffer.append(String.format("%02X", new Object[] { Byte.valueOf(arrayOfByte[j]) }));
    } 
    j = stringBuffer.length() / 2;
    i = stringBuffer.length() % 2 + j;
    if (!paramBoolean) {
      if (i % 8 != 0) {
        j = 8 - i % 8 + i;
      } else {
        j = i;
      } 
      arrayOfByte = new byte[j];
      System.arraycopy(e.a(stringBuffer.toString()), 0, arrayOfByte, 0, i);
      return e.a(arrayOfByte, j);
    } 
    int k = i + 1;
    j = k;
    if (k % 8 != 0)
      j = k + 8 - k % 8; 
    arrayOfByte = new byte[j];
    System.arraycopy(e.a(stringBuffer.toString()), 0, arrayOfByte, 0, i);
    arrayOfByte[i] = (byte)Byte.MIN_VALUE;
    return e.a(arrayOfByte, j);
  }
  
  private String a(byte[] paramArrayOfbyte) {
    byte b;
    boolean bool = false;
    paramArrayOfbyte[0] = (byte)(byte)(paramArrayOfbyte[0] | this.g);
    byte[] arrayOfByte1 = this.c.a(paramArrayOfbyte, this.g);
    if (arrayOfByte1 != null) {
      b = arrayOfByte1.length;
    } else {
      b = 0;
    } 
    int i = b;
    byte[] arrayOfByte2 = arrayOfByte1;
    if (b >= 2) {
      i = b;
      arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1[b - 2] == 97) {
        byte b1 = arrayOfByte1[b - 1];
        byte b2 = this.g;
        c c1 = this.c;
        i = this.g;
        arrayOfByte2 = c1.a(new byte[] { b2, -64, 0, 0, b1 }, i);
        if (arrayOfByte2 != null) {
          i = arrayOfByte2.length;
        } else {
          i = 0;
        } 
      } 
    } 
    if (i >= 2 && arrayOfByte2[i - 2] == 108) {
      paramArrayOfbyte[paramArrayOfbyte.length - 1] = (byte)arrayOfByte2[i - 1];
      arrayOfByte2 = this.c.a(paramArrayOfbyte, this.g);
      paramArrayOfbyte = arrayOfByte2;
      i = bool;
      if (arrayOfByte2 != null) {
        i = arrayOfByte2.length;
        paramArrayOfbyte = arrayOfByte2;
      } 
    } else {
      paramArrayOfbyte = arrayOfByte2;
    } 
    return (i > 2 && paramArrayOfbyte[i - 2] == -112 && paramArrayOfbyte[i - 1] == 0) ? e.a(paramArrayOfbyte, i - 2) : ((i == 2 && paramArrayOfbyte[i - 2] == -112 && paramArrayOfbyte[i - 1] == 0) ? e.a(paramArrayOfbyte, 2) : null);
  }
  
  private String a(byte[] paramArrayOfbyte, String paramString) {
    paramArrayOfbyte[paramArrayOfbyte.length - 1] = (byte)(byte)(paramString.length() / 2);
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length + paramString.length() / 2];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramArrayOfbyte.length);
    System.arraycopy(e.a(paramString), 0, arrayOfByte, paramArrayOfbyte.length, paramString.length() / 2);
    return a(arrayOfByte);
  }
  
  private static void a(String paramString, StringBuffer paramStringBuffer) {
    String str1 = o.get(paramString);
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = (byte)(byte)(str1.length() / 2);
    String str2 = e.a(arrayOfByte, arrayOfByte.length);
    paramStringBuffer.append(paramString);
    paramStringBuffer.append(str2);
    paramStringBuffer.append(str1);
  }
  
  private String b(String paramString) {
    String str = null;
    if (this.c instanceof com.unionpay.mobile.android.pboctransaction.samsung.f)
      return this.c.a(paramString); 
    this.g = (byte)this.h;
    if (paramString != null) {
      str = e.a(new byte[] { Integer.valueOf(paramString.length() / 2).byteValue() });
      str = a(e.a("00a40400" + str + paramString));
    } 
    return str;
  }
  
  private void b(byte[] paramArrayOfbyte) {
    int i = m.length() / 2 + 1;
    byte[] arrayOfByte1 = new byte[i];
    System.arraycopy(e.a(m), 0, arrayOfByte1, 0, m.length() / 2);
    arrayOfByte1[i - 1] = (byte)Byte.MIN_VALUE;
    paramArrayOfbyte[paramArrayOfbyte.length - 1] = (byte)(byte)arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[paramArrayOfbyte.length + arrayOfByte1.length];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte2, 0, paramArrayOfbyte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramArrayOfbyte.length, arrayOfByte1.length);
    a(arrayOfByte2);
  }
  
  private String c(String paramString) {
    if (paramString == null || "9000".equals(paramString)) {
      StringBuffer stringBuffer1 = new StringBuffer("80A800000b8309");
      for (String str : i("9F7A019F02065F2A02")) {
        for (String str1 : o.keySet()) {
          if (str.compareToIgnoreCase(str1) == 0)
            stringBuffer1.append(o.get(str1)); 
        } 
      } 
      return a(e.a(stringBuffer1.toString()));
    } 
    k.c("uppay", "test for gongshang version 2");
    StringBuffer stringBuffer = new StringBuffer("");
    paramString = a(paramString, "9F38");
    if (TextUtils.isEmpty(paramString)) {
      ByteBuffer byteBuffer1 = ByteBuffer.allocate(7);
      byteBuffer1.put(-128).put((byte)-88).put((byte)0).put((byte)0).put((byte)2).put((byte)-125).put((byte)0);
      return a(byteBuffer1.array());
    } 
    for (String str : i(paramString)) {
      for (String str1 : o.keySet()) {
        if (str.compareToIgnoreCase(str1) == 0)
          stringBuffer.append(o.get(str1)); 
      } 
    } 
    byte[] arrayOfByte = e.a(stringBuffer.toString());
    ByteBuffer byteBuffer = ByteBuffer.allocate(arrayOfByte.length + 7);
    byteBuffer.put(-128).put((byte)-88).put((byte)0).put((byte)0).put((byte)(arrayOfByte.length + 2)).put((byte)-125).put((byte)arrayOfByte.length).put(arrayOfByte);
    return a(byteBuffer.array());
  }
  
  private String d(String paramString) {
    byte b = 0;
    paramString = a(paramString, "80");
    if (paramString == null)
      return null; 
    o.put("82", paramString.substring(0, 4));
    byte[] arrayOfByte = e.a(paramString.substring(4));
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("5A");
    arrayList.add("5F34");
    arrayList.add("9F1F");
    arrayList.add("57");
    arrayList.add("5F24");
    arrayList.add("9F10");
    arrayList.add("8C");
    arrayList.add("8D");
    while (true) {
      try {
        if (b < arrayOfByte.length) {
          byte[] arrayOfByte1 = new byte[5];
          arrayOfByte1[0] = 0;
          arrayOfByte1[1] = -78;
          arrayOfByte1[2] = 0;
          arrayOfByte1[3] = 0;
          arrayOfByte1[4] = 0;
          byte[] arrayOfByte2 = new byte[4];
          System.arraycopy(arrayOfByte, b, arrayOfByte2, 0, 4);
          byte b1 = arrayOfByte2[1];
          while (b1 <= arrayOfByte2[2]) {
            arrayOfByte1[4] = (byte)0;
            arrayOfByte1[3] = (byte)(byte)(arrayOfByte2[0] & 0xFFFFFFF8 | 0x4);
            arrayOfByte1[2] = (byte)b1;
            b1 = (byte)(b1 + 1);
            String str = a(arrayOfByte1);
            if (str != null)
              for (String str1 : arrayList) {
                String str2 = a(str, str1);
                if (str2 != null)
                  o.put(str1, str2); 
              }  
          } 
          b += 4;
          continue;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return o.get("8C");
      } 
      StringBuffer stringBuffer = new StringBuffer();
      this(o.get("5F34"));
      stringBuffer.insert(0, "0");
      o.put("5F34", stringBuffer.toString());
      return o.get("8C");
    } 
  }
  
  private static void d() {
    String str1 = m.substring(2, 8);
    long l = (new Date(System.currentTimeMillis())).getTime();
    String str2 = String.valueOf(l);
    if (str2.length() < 8) {
      str2 = String.format("%08d", new Object[] { Long.valueOf(l) });
    } else {
      str2 = str2.substring(str2.length() - 8, str2.length());
    } 
    o.put("9F26", "");
    o.put("9F27", "80");
    o.put("9F10", "");
    o.put("9F37", str2);
    o.put("9F36", "");
    o.put("95", "0000000800");
    o.put("9A", str1);
    o.put("9C", "45");
    o.put("9F02", "000000000000");
    o.put("5F2A", "0156");
    o.put("82", "");
    o.put("9F1A", "0156");
    o.put("9F03", "000000000000");
    o.put("9F33", "A04000");
    o.put("9F34", "420300");
    o.put("9F35", "34");
    o.put("9F1E", "3030303030303030");
    o.put("84", "");
    o.put("9F09", "0001");
    o.put("9F74", "");
    o.put("9F63", "");
    o.put("9F7A", "01");
    o.put("9F21", m.substring(8));
    o.put("9F4E", "0000000000000000000000000000000000000000");
    o.put("DF31", "0100000000");
    o.put("9F66", "36800000");
    o.put("DF60", "00");
  }
  
  private String e(String paramString) {
    StringBuffer stringBuffer = new StringBuffer("80AE800034");
    for (String str : i(paramString)) {
      for (String paramString : o.keySet()) {
        if (str.compareToIgnoreCase(paramString) == 0)
          stringBuffer.append(o.get(paramString)); 
      } 
    } 
    paramString = a(e.a(stringBuffer.toString()));
    if (paramString != null) {
      o.put("9F27", paramString.substring(4, 6));
      o.put("9F36", paramString.substring(6, 10));
      o.put("9F26", paramString.substring(10, 26));
      o.put("9F10", paramString.substring(26));
    } 
    return paramString;
  }
  
  private boolean e() {
    String str;
    for (str = o.get("5A"); str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f"); str = str.substring(0, str.length() - 1));
    str = f(str);
    if (str == null || str.length() == 0)
      return false; 
    o.put("AN1", str);
    str = f("00000001");
    if (str == null || str.length() == 0)
      return false; 
    o.put("TID", str);
    str = f(o.get("9F02"));
    if (str == null || str.length() == 0)
      return false; 
    o.put("AMT", str);
    str = f("156");
    if (str == null || str.length() == 0)
      return false; 
    o.put("CUR", str);
    str = o.get("57");
    while (true) {
      if (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f") || str.substring(str.length() - 1, str.length()).equalsIgnoreCase("F")) {
        str = str.substring(0, str.length() - 1);
        continue;
      } 
      str = f(str);
      if (str == null || str.length() == 0)
        return false; 
      o.put("TD2", str);
      if (o.get("5F24") != null && ((String)o.get("5F24")).length() == 6) {
        str = f(((String)o.get("5F24")).substring(0, 4));
        if (str == null || str.length() == 0)
          return false; 
        o.put("ED", str);
      } 
      return true;
    } 
  }
  
  private String f() {
    this.g = (byte)this.i;
    String str = a(new byte[] { 0, -80, -126, 0, 10 });
    if (str != null && str.length() != 0)
      o.put("CSN", str); 
    this.g = (byte)this.h;
    return str;
  }
  
  private String f(String paramString) {
    this.g = (byte)this.i;
    paramString = a(paramString, false);
    b(new byte[] { Byte.MIN_VALUE, 26, 19, 1, 0 });
    paramString = a(new byte[] { Byte.MIN_VALUE, -6, 0, 0, 0 }, paramString);
    this.g = (byte)this.h;
    return paramString;
  }
  
  private static Bundle g() {
    Bundle bundle = new Bundle();
    bundle.putString("action_resp_code", "0000");
    return bundle;
  }
  
  private String g(String paramString) {
    byte b = 0;
    this.g = (byte)this.i;
    String str2 = String.format("%02d", new Object[] { Integer.valueOf(paramString.length()) }) + paramString;
    StringBuffer stringBuffer = new StringBuffer(str2);
    while (b < 16 - str2.length()) {
      stringBuffer.append("F");
      b++;
    } 
    b(new byte[] { Byte.MIN_VALUE, 26, 20, 1, 0 });
    String str1 = stringBuffer.toString();
    str1 = a(new byte[] { Byte.MIN_VALUE, -6, 0, 0, 0 }, str1);
    if (str1 != null)
      o.put("PIN", str1); 
    this.g = (byte)this.h;
    return str1;
  }
  
  private String h(String paramString) {
    this.g = (byte)this.i;
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = Byte.MIN_VALUE;
    arrayOfByte[1] = -6;
    arrayOfByte[2] = 1;
    arrayOfByte[3] = 0;
    arrayOfByte[4] = 0;
    paramString = a(paramString, true);
    b(new byte[] { Byte.MIN_VALUE, 26, 21, 1, 8 });
    while (paramString.length() > 448) {
      arrayOfByte[2] = (byte)3;
      a(arrayOfByte, paramString.substring(0, 448).toUpperCase());
      paramString = paramString.substring(448);
    } 
    arrayOfByte[2] = (byte)1;
    if (Build.VERSION.SDK_INT <= 10)
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      }  
    String str = a(arrayOfByte, paramString);
    k.c("uppay", "encryptMac in resp" + str);
    if (str != null)
      o.put("MAC", str.toUpperCase()); 
    this.g = (byte)this.h;
    paramString = str;
    if (str != null)
      paramString = str.toUpperCase(); 
    return paramString;
  }
  
  private static List<String> i(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    if (paramString != null) {
      byte[] arrayOfByte = e.a(paramString);
      int i = 0;
      while (true) {
        if (i < arrayOfByte.length) {
          int j;
          if ((byte)(arrayOfByte[i] & 0x1F) == 31) {
            j = 2;
          } else {
            j = 1;
          } 
          byte[] arrayOfByte1 = new byte[j];
          System.arraycopy(arrayOfByte, i, arrayOfByte1, 0, j);
          arrayList.add(e.a(arrayOfByte1, j));
          j += i;
          if (j < arrayOfByte.length && (byte)(arrayOfByte[j] & 0x80) == Byte.MIN_VALUE) {
            i = (arrayOfByte[j] & Byte.MAX_VALUE) + 1;
          } else {
            i = 1;
          } 
          i += j;
          continue;
        } 
        return arrayList;
      } 
    } 
    return arrayList;
  }
  
  public final Bundle a(int paramInt, String paramString1, HashMap<String, String> paramHashMap, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'uppay'
    //   4: ldc_w 'startUPCardPurchase() +++'
    //   7: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: invokestatic g : ()Landroid/os/Bundle;
    //   14: astore #5
    //   16: aload_0
    //   17: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   20: invokeinterface b : ()V
    //   25: aload_0
    //   26: invokevirtual a : ()Ljava/lang/String;
    //   29: astore #6
    //   31: aload #6
    //   33: ifnull -> 44
    //   36: aload #6
    //   38: invokevirtual length : ()I
    //   41: ifne -> 69
    //   44: aload_0
    //   45: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   48: invokeinterface c : ()V
    //   53: aload #5
    //   55: ldc_w 'action_resp_code'
    //   58: ldc_w '10019'
    //   61: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: aload #5
    //   68: areturn
    //   69: new java/lang/StringBuilder
    //   72: astore #6
    //   74: aload #6
    //   76: ldc_w ' ************T1='
    //   79: invokespecial <init> : (Ljava/lang/String;)V
    //   82: ldc 'uppay'
    //   84: aload #6
    //   86: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   102: ldc_w 'PIN'
    //   105: aload_2
    //   106: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_0
    //   111: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   114: ldc_w 'PIN'
    //   117: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast java/lang/String
    //   123: aload #4
    //   125: invokestatic decPrefData : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull -> 143
    //   136: aload_2
    //   137: invokevirtual length : ()I
    //   140: ifne -> 166
    //   143: aload_0
    //   144: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   147: invokeinterface c : ()V
    //   152: aload #5
    //   154: ldc_w 'action_resp_code'
    //   157: ldc_w '10019'
    //   160: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   163: goto -> 64
    //   166: new java/lang/StringBuilder
    //   169: astore_2
    //   170: aload_2
    //   171: ldc_w ' ************T2='
    //   174: invokespecial <init> : (Ljava/lang/String;)V
    //   177: ldc 'uppay'
    //   179: aload_2
    //   180: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual toString : ()Ljava/lang/String;
    //   189: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: aload_0
    //   194: iload_1
    //   195: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   198: invokevirtual a : (ILjava/lang/String;)Ljava/lang/String;
    //   201: astore_2
    //   202: aload_2
    //   203: ifnull -> 213
    //   206: aload_2
    //   207: invokevirtual length : ()I
    //   210: ifne -> 236
    //   213: aload_0
    //   214: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   217: invokeinterface c : ()V
    //   222: aload #5
    //   224: ldc_w 'action_resp_code'
    //   227: ldc_w '10019'
    //   230: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -> 64
    //   236: aload_0
    //   237: invokespecial f : ()Ljava/lang/String;
    //   240: astore #4
    //   242: aload #4
    //   244: ifnull -> 255
    //   247: aload #4
    //   249: invokevirtual length : ()I
    //   252: ifne -> 278
    //   255: aload_0
    //   256: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   259: invokeinterface c : ()V
    //   264: aload #5
    //   266: ldc_w 'action_resp_code'
    //   269: ldc_w '10019'
    //   272: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   275: goto -> 64
    //   278: aload_2
    //   279: bipush #40
    //   281: bipush #60
    //   283: invokevirtual substring : (II)Ljava/lang/String;
    //   286: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   289: astore #6
    //   291: aload_2
    //   292: bipush #60
    //   294: bipush #100
    //   296: invokevirtual substring : (II)Ljava/lang/String;
    //   299: astore #7
    //   301: aload_2
    //   302: bipush #100
    //   304: sipush #208
    //   307: invokevirtual substring : (II)Ljava/lang/String;
    //   310: astore #8
    //   312: aload_2
    //   313: sipush #216
    //   316: sipush #232
    //   319: invokevirtual substring : (II)Ljava/lang/String;
    //   322: astore #9
    //   324: new org/json/JSONObject
    //   327: astore #4
    //   329: aload #4
    //   331: invokespecial <init> : ()V
    //   334: aload #4
    //   336: ldc_w 'v'
    //   339: aload_0
    //   340: getfield f : Ljava/lang/String;
    //   343: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   346: pop
    //   347: aload #4
    //   349: ldc_w 'cmd'
    //   352: ldc_w 'pay'
    //   355: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   358: pop
    //   359: new org/json/JSONObject
    //   362: astore_2
    //   363: aload_2
    //   364: invokespecial <init> : ()V
    //   367: aload #4
    //   369: ldc_w 'params'
    //   372: aload_2
    //   373: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload_2
    //   378: ldc_w 'pay_type'
    //   381: ldc_w '2'
    //   384: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   387: pop
    //   388: aload_2
    //   389: ldc_w 'pay_mode'
    //   392: ldc_w '1'
    //   395: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload_2
    //   400: ldc_w 'bind'
    //   403: ldc_w 'no'
    //   406: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload_2
    //   411: ldc_w 'carrier_tp'
    //   414: ldc_w '1'
    //   417: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload_2
    //   422: ldc_w 'track2_data'
    //   425: aload #7
    //   427: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   430: pop
    //   431: aload_2
    //   432: ldc_w 'track3_data'
    //   435: aload #8
    //   437: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: aload_2
    //   442: ldc_w 'csn'
    //   445: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   448: ldc_w 'CSN'
    //   451: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   454: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   457: pop
    //   458: aload_2
    //   459: ldc_w 'submit_time'
    //   462: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   465: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   468: pop
    //   469: aload_2
    //   470: ldc_w 'sp_id'
    //   473: ldc_w '8889'
    //   476: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   479: pop
    //   480: aload_2
    //   481: ldc_w 'pin'
    //   484: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   487: ldc_w 'PIN'
    //   490: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   493: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   496: pop
    //   497: aload_2
    //   498: ldc_w 'pan'
    //   501: aload #6
    //   503: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: aload_2
    //   508: ldc_w 'dynamic_key_data'
    //   511: aload #9
    //   513: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   516: pop
    //   517: aload_2
    //   518: ldc_w 'carrier_app_tp'
    //   521: ldc_w '1'
    //   524: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   527: pop
    //   528: aload_3
    //   529: ifnull -> 684
    //   532: aload_3
    //   533: invokevirtual keySet : ()Ljava/util/Set;
    //   536: ifnull -> 684
    //   539: aload_3
    //   540: invokevirtual keySet : ()Ljava/util/Set;
    //   543: invokeinterface size : ()I
    //   548: ifle -> 684
    //   551: aload_3
    //   552: ldc_w 'pan'
    //   555: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   558: pop
    //   559: aload_3
    //   560: ldc_w 'pin'
    //   563: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   566: pop
    //   567: aload_3
    //   568: invokevirtual keySet : ()Ljava/util/Set;
    //   571: invokeinterface iterator : ()Ljava/util/Iterator;
    //   576: astore #7
    //   578: aload #7
    //   580: invokeinterface hasNext : ()Z
    //   585: ifeq -> 684
    //   588: aload #7
    //   590: invokeinterface next : ()Ljava/lang/Object;
    //   595: checkcast java/lang/String
    //   598: astore #6
    //   600: aload_2
    //   601: aload #6
    //   603: aload_3
    //   604: aload #6
    //   606: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   609: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   612: pop
    //   613: goto -> 578
    //   616: astore_2
    //   617: aload_2
    //   618: invokevirtual printStackTrace : ()V
    //   621: ldc ''
    //   623: astore_2
    //   624: new java/lang/StringBuilder
    //   627: astore_3
    //   628: aload_3
    //   629: ldc_w ' ************T3='
    //   632: invokespecial <init> : (Ljava/lang/String;)V
    //   635: ldc 'uppay'
    //   637: aload_3
    //   638: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   641: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual toString : ()Ljava/lang/String;
    //   647: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   650: pop
    //   651: aload #5
    //   653: ldc_w 'action_resp_message'
    //   656: aload_0
    //   657: getfield d : Lcom/unionpay/mobile/android/fully/a;
    //   660: aload_2
    //   661: invokeinterface a : (Ljava/lang/String;)Ljava/lang/String;
    //   666: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   669: aload_0
    //   670: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   673: invokeinterface c : ()V
    //   678: invokestatic d : ()V
    //   681: goto -> 64
    //   684: aload #4
    //   686: invokevirtual toString : ()Ljava/lang/String;
    //   689: astore_2
    //   690: goto -> 624
    //   693: astore_2
    //   694: aload_0
    //   695: monitorexit
    //   696: aload_2
    //   697: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	693	finally
    //   36	44	693	finally
    //   44	64	693	finally
    //   69	132	693	finally
    //   136	143	693	finally
    //   143	163	693	finally
    //   166	202	693	finally
    //   206	213	693	finally
    //   213	233	693	finally
    //   236	242	693	finally
    //   247	255	693	finally
    //   255	275	693	finally
    //   278	324	693	finally
    //   324	528	616	org/json/JSONException
    //   324	528	693	finally
    //   532	578	616	org/json/JSONException
    //   532	578	693	finally
    //   578	613	616	org/json/JSONException
    //   578	613	693	finally
    //   617	621	693	finally
    //   624	681	693	finally
    //   684	690	616	org/json/JSONException
    //   684	690	693	finally
  }
  
  public final Bundle a(AppIdentification paramAppIdentification, String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   6: invokeinterface b : ()V
    //   11: ldc 'uppay'
    //   13: ldc_w 'startPBOCPurchase() +++'
    //   16: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   23: invokevirtual clear : ()V
    //   26: invokestatic d : ()V
    //   29: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   32: ldc_w 'PIN'
    //   35: aload_2
    //   36: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   43: ldc_w '9F02'
    //   46: aload #4
    //   48: ldc_w 'trans_amt'
    //   51: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   61: ldc_w '9F1A'
    //   64: ldc_w '0156'
    //   67: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   74: ldc_w '5F2A'
    //   77: aload #4
    //   79: ldc_w 'trans currcy code'
    //   82: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   92: ldc_w '9C'
    //   95: aload #4
    //   97: ldc_w 'trans_type'
    //   100: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   103: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual a : ()Ljava/lang/String;
    //   111: astore_2
    //   112: aload_2
    //   113: ldc_w 'A000000333'
    //   116: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   119: ifne -> 149
    //   122: aload_0
    //   123: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   126: invokeinterface c : ()V
    //   131: invokestatic g : ()Landroid/os/Bundle;
    //   134: astore_1
    //   135: aload_1
    //   136: ldc_w 'action_resp_code'
    //   139: ldc_w '10019'
    //   142: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: areturn
    //   149: invokestatic g : ()Landroid/os/Bundle;
    //   152: astore_1
    //   153: new java/sql/Date
    //   156: astore #4
    //   158: aload #4
    //   160: invokestatic currentTimeMillis : ()J
    //   163: invokespecial <init> : (J)V
    //   166: aload #4
    //   168: putstatic com/unionpay/mobile/android/pboctransaction/d.l : Ljava/sql/Date;
    //   171: new java/text/SimpleDateFormat
    //   174: astore #4
    //   176: aload #4
    //   178: ldc_w 'yyyyMMddHHmmss'
    //   181: invokespecial <init> : (Ljava/lang/String;)V
    //   184: aload #4
    //   186: getstatic com/unionpay/mobile/android/pboctransaction/d.l : Ljava/sql/Date;
    //   189: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   192: putstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   195: new java/lang/String
    //   198: astore #4
    //   200: aload #4
    //   202: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   205: invokespecial <init> : (Ljava/lang/String;)V
    //   208: aload_0
    //   209: aload #4
    //   211: putfield n : Ljava/lang/String;
    //   214: ldc 'uppay'
    //   216: ldc_w 'selectUPCard'
    //   219: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: aload_0
    //   224: invokevirtual a : ()Ljava/lang/String;
    //   227: astore #4
    //   229: new java/lang/StringBuilder
    //   232: astore #7
    //   234: aload #7
    //   236: ldc_w 'selectUPCard return: '
    //   239: invokespecial <init> : (Ljava/lang/String;)V
    //   242: ldc 'uppay'
    //   244: aload #7
    //   246: aload #4
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aload #4
    //   260: ifnull -> 271
    //   263: aload #4
    //   265: invokevirtual length : ()I
    //   268: ifne -> 306
    //   271: aload_1
    //   272: ldc_w 'action_resp_code'
    //   275: ldc_w '10019'
    //   278: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_1
    //   282: ldc_w 'action_resp_code'
    //   285: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   288: ldc_w '0000'
    //   291: if_acmpeq -> 647
    //   294: aload_0
    //   295: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   298: invokeinterface c : ()V
    //   303: goto -> 145
    //   306: ldc 'uppay'
    //   308: ldc_w 'selectPBOC'
    //   311: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   314: pop
    //   315: aload_0
    //   316: aload_2
    //   317: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   320: astore_2
    //   321: new java/lang/StringBuilder
    //   324: astore #4
    //   326: aload #4
    //   328: ldc_w 'selectPBOC return: '
    //   331: invokespecial <init> : (Ljava/lang/String;)V
    //   334: ldc 'uppay'
    //   336: aload #4
    //   338: aload_2
    //   339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   348: pop
    //   349: aload_2
    //   350: ifnull -> 360
    //   353: aload_2
    //   354: invokevirtual length : ()I
    //   357: ifne -> 378
    //   360: aload_1
    //   361: ldc_w 'action_resp_code'
    //   364: ldc_w '10019'
    //   367: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   370: goto -> 281
    //   373: astore_1
    //   374: aload_0
    //   375: monitorexit
    //   376: aload_1
    //   377: athrow
    //   378: ldc 'uppay'
    //   380: ldc_w 'GPO'
    //   383: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   386: pop
    //   387: aload_0
    //   388: aload_2
    //   389: invokespecial c : (Ljava/lang/String;)Ljava/lang/String;
    //   392: astore #4
    //   394: new java/lang/StringBuilder
    //   397: astore_2
    //   398: aload_2
    //   399: ldc_w 'gpo return: '
    //   402: invokespecial <init> : (Ljava/lang/String;)V
    //   405: ldc 'uppay'
    //   407: aload_2
    //   408: aload #4
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual toString : ()Ljava/lang/String;
    //   416: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   419: pop
    //   420: aload #4
    //   422: ifnull -> 433
    //   425: aload #4
    //   427: invokevirtual length : ()I
    //   430: ifne -> 446
    //   433: aload_1
    //   434: ldc_w 'action_resp_code'
    //   437: ldc_w '10020'
    //   440: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   443: goto -> 281
    //   446: ldc 'uppay'
    //   448: ldc_w 'CDOL1'
    //   451: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   454: pop
    //   455: aload_0
    //   456: aload #4
    //   458: invokespecial d : (Ljava/lang/String;)Ljava/lang/String;
    //   461: astore_2
    //   462: new java/lang/StringBuilder
    //   465: astore #4
    //   467: aload #4
    //   469: ldc_w 'CDOL1 return: '
    //   472: invokespecial <init> : (Ljava/lang/String;)V
    //   475: ldc 'uppay'
    //   477: aload #4
    //   479: aload_2
    //   480: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual toString : ()Ljava/lang/String;
    //   486: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   489: pop
    //   490: aload_2
    //   491: ifnull -> 501
    //   494: aload_2
    //   495: invokevirtual length : ()I
    //   498: ifne -> 514
    //   501: aload_1
    //   502: ldc_w 'action_resp_code'
    //   505: ldc_w '10019'
    //   508: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   511: goto -> 281
    //   514: ldc 'uppay'
    //   516: ldc_w 'GAC1'
    //   519: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   522: pop
    //   523: aload_0
    //   524: aload_2
    //   525: invokespecial e : (Ljava/lang/String;)Ljava/lang/String;
    //   528: astore_2
    //   529: new java/lang/StringBuilder
    //   532: astore #4
    //   534: aload #4
    //   536: ldc_w 'GAC1 return: '
    //   539: invokespecial <init> : (Ljava/lang/String;)V
    //   542: ldc 'uppay'
    //   544: aload #4
    //   546: aload_2
    //   547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual toString : ()Ljava/lang/String;
    //   553: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   556: pop
    //   557: aload_2
    //   558: ifnull -> 568
    //   561: aload_2
    //   562: invokevirtual length : ()I
    //   565: ifne -> 581
    //   568: aload_1
    //   569: ldc_w 'action_resp_code'
    //   572: ldc_w '10019'
    //   575: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   578: goto -> 281
    //   581: ldc 'uppay'
    //   583: ldc_w 'csn'
    //   586: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   589: pop
    //   590: aload_0
    //   591: invokespecial f : ()Ljava/lang/String;
    //   594: astore_2
    //   595: new java/lang/StringBuilder
    //   598: astore #4
    //   600: aload #4
    //   602: ldc_w 'csn return: '
    //   605: invokespecial <init> : (Ljava/lang/String;)V
    //   608: ldc 'uppay'
    //   610: aload #4
    //   612: aload_2
    //   613: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual toString : ()Ljava/lang/String;
    //   619: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   622: pop
    //   623: aload_2
    //   624: ifnull -> 634
    //   627: aload_2
    //   628: invokevirtual length : ()I
    //   631: ifne -> 281
    //   634: aload_1
    //   635: ldc_w 'action_resp_code'
    //   638: ldc_w '10019'
    //   641: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   644: goto -> 281
    //   647: ldc 'uppay'
    //   649: ldc_w 'encryptPIN'
    //   652: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   655: pop
    //   656: aload_0
    //   657: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   660: ldc_w 'PIN'
    //   663: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   666: checkcast java/lang/String
    //   669: aload #6
    //   671: invokestatic decPrefData : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   674: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   677: astore #4
    //   679: new java/lang/StringBuilder
    //   682: astore_2
    //   683: aload_2
    //   684: ldc_w 'encryptPIN return:'
    //   687: invokespecial <init> : (Ljava/lang/String;)V
    //   690: ldc 'uppay'
    //   692: aload_2
    //   693: aload #4
    //   695: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual toString : ()Ljava/lang/String;
    //   701: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   704: pop
    //   705: aload #4
    //   707: ifnull -> 718
    //   710: aload #4
    //   712: invokevirtual length : ()I
    //   715: ifne -> 740
    //   718: aload_0
    //   719: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   722: invokeinterface c : ()V
    //   727: aload_1
    //   728: ldc_w 'action_resp_code'
    //   731: ldc_w '10019'
    //   734: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   737: goto -> 145
    //   740: ldc 'uppay'
    //   742: ldc_w 'encryptData'
    //   745: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   748: pop
    //   749: aload_0
    //   750: invokespecial e : ()Z
    //   753: ifne -> 787
    //   756: ldc 'uppay'
    //   758: ldc_w 'encryptData false'
    //   761: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   764: pop
    //   765: aload_0
    //   766: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   769: invokeinterface c : ()V
    //   774: aload_1
    //   775: ldc_w 'action_resp_code'
    //   778: ldc_w '10019'
    //   781: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   784: goto -> 145
    //   787: ldc 'uppay'
    //   789: ldc_w 'initDCData'
    //   792: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   795: pop
    //   796: new java/lang/StringBuffer
    //   799: astore_2
    //   800: aload_2
    //   801: invokespecial <init> : ()V
    //   804: ldc_w '9F26'
    //   807: aload_2
    //   808: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   811: ldc_w '9F27'
    //   814: aload_2
    //   815: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   818: ldc_w '9F10'
    //   821: aload_2
    //   822: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   825: ldc_w '9F37'
    //   828: aload_2
    //   829: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   832: ldc_w '9F36'
    //   835: aload_2
    //   836: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   839: ldc_w '95'
    //   842: aload_2
    //   843: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   846: ldc_w '9A'
    //   849: aload_2
    //   850: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   853: ldc_w '9C'
    //   856: aload_2
    //   857: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   860: ldc_w '9F02'
    //   863: aload_2
    //   864: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   867: ldc_w '5F2A'
    //   870: aload_2
    //   871: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   874: ldc_w '82'
    //   877: aload_2
    //   878: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   881: ldc_w '9F1A'
    //   884: aload_2
    //   885: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   888: ldc_w '9F03'
    //   891: aload_2
    //   892: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   895: ldc_w '9F33'
    //   898: aload_2
    //   899: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   902: ldc_w '9F34'
    //   905: aload_2
    //   906: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   909: ldc_w '9F35'
    //   912: aload_2
    //   913: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   916: ldc_w '9F1E'
    //   919: aload_2
    //   920: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   923: aload_2
    //   924: invokevirtual toString : ()Ljava/lang/String;
    //   927: astore_2
    //   928: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   931: ldc_w 'DCD'
    //   934: aload_2
    //   935: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   938: pop
    //   939: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   942: ldc_w 'TID'
    //   945: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   948: ifnull -> 1011
    //   951: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   954: ldc_w 'AMT'
    //   957: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   960: ifnull -> 1011
    //   963: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   966: ldc_w 'CUR'
    //   969: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   972: ifnull -> 1011
    //   975: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   978: ldc_w 'AN1'
    //   981: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   984: ifnull -> 1011
    //   987: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   990: ldc_w 'CSN'
    //   993: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   996: ifnull -> 1011
    //   999: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1002: ldc_w '5F34'
    //   1005: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1008: ifnonnull -> 1033
    //   1011: aload_0
    //   1012: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   1015: invokeinterface c : ()V
    //   1020: aload_1
    //   1021: ldc_w 'action_resp_code'
    //   1024: ldc_w '10019'
    //   1027: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1030: goto -> 145
    //   1033: new java/util/ArrayList
    //   1036: astore #4
    //   1038: aload #4
    //   1040: invokespecial <init> : ()V
    //   1043: aload #4
    //   1045: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   1048: invokevirtual add : (Ljava/lang/Object;)Z
    //   1051: pop
    //   1052: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1055: ldc_w 'TID'
    //   1058: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1061: ifnull -> 1079
    //   1064: aload #4
    //   1066: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1069: ldc_w 'TID'
    //   1072: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1075: invokevirtual add : (Ljava/lang/Object;)Z
    //   1078: pop
    //   1079: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1082: ldc_w 'AMT'
    //   1085: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1088: ifnull -> 1106
    //   1091: aload #4
    //   1093: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1096: ldc_w 'AMT'
    //   1099: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1102: invokevirtual add : (Ljava/lang/Object;)Z
    //   1105: pop
    //   1106: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1109: ldc_w 'CUR'
    //   1112: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1115: ifnull -> 1133
    //   1118: aload #4
    //   1120: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1123: ldc_w 'CUR'
    //   1126: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1129: invokevirtual add : (Ljava/lang/Object;)Z
    //   1132: pop
    //   1133: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1136: ldc_w 'AN1'
    //   1139: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1142: ifnull -> 1160
    //   1145: aload #4
    //   1147: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1150: ldc_w 'AN1'
    //   1153: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1156: invokevirtual add : (Ljava/lang/Object;)Z
    //   1159: pop
    //   1160: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1163: ldc_w 'AN1'
    //   1166: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1169: ldc_w '5A'
    //   1172: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: checkcast java/lang/String
    //   1178: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   1181: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1184: pop
    //   1185: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1188: ldc_w 'CSN'
    //   1191: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1194: ifnull -> 1212
    //   1197: aload #4
    //   1199: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1202: ldc_w 'CSN'
    //   1205: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1208: invokevirtual add : (Ljava/lang/Object;)Z
    //   1211: pop
    //   1212: aload_0
    //   1213: getfield q : Z
    //   1216: ifeq -> 1246
    //   1219: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1222: ldc_w 'ED'
    //   1225: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1228: ifnull -> 1246
    //   1231: aload #4
    //   1233: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1236: ldc_w 'ED'
    //   1239: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1242: invokevirtual add : (Ljava/lang/Object;)Z
    //   1245: pop
    //   1246: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1249: ldc_w '5F34'
    //   1252: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1255: ifnull -> 1273
    //   1258: aload #4
    //   1260: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1263: ldc_w '5F34'
    //   1266: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1269: invokevirtual add : (Ljava/lang/Object;)Z
    //   1272: pop
    //   1273: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1276: ldc_w 'DCD'
    //   1279: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1282: ifnull -> 1300
    //   1285: aload #4
    //   1287: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1290: ldc_w 'DCD'
    //   1293: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1296: invokevirtual add : (Ljava/lang/Object;)Z
    //   1299: pop
    //   1300: ldc ''
    //   1302: astore_2
    //   1303: aload #4
    //   1305: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1308: astore #4
    //   1310: aload #4
    //   1312: invokeinterface hasNext : ()Z
    //   1317: ifeq -> 1371
    //   1320: aload #4
    //   1322: invokeinterface next : ()Ljava/lang/Object;
    //   1327: checkcast java/lang/String
    //   1330: astore #6
    //   1332: aload #6
    //   1334: ifnull -> 1921
    //   1337: new java/lang/StringBuilder
    //   1340: astore #7
    //   1342: aload #7
    //   1344: invokespecial <init> : ()V
    //   1347: aload #7
    //   1349: aload_2
    //   1350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload #6
    //   1355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: ldc_w ' '
    //   1361: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: invokevirtual toString : ()Ljava/lang/String;
    //   1367: astore_2
    //   1368: goto -> 1310
    //   1371: aload_2
    //   1372: invokevirtual trim : ()Ljava/lang/String;
    //   1375: astore_2
    //   1376: ldc 'uppay'
    //   1378: ldc_w 'encryptMac'
    //   1381: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   1384: pop
    //   1385: aload_0
    //   1386: aload_2
    //   1387: invokespecial h : (Ljava/lang/String;)Ljava/lang/String;
    //   1390: astore_2
    //   1391: new java/lang/StringBuilder
    //   1394: astore #4
    //   1396: aload #4
    //   1398: ldc_w 'encryptMac result'
    //   1401: invokespecial <init> : (Ljava/lang/String;)V
    //   1404: ldc 'uppay'
    //   1406: aload #4
    //   1408: aload_2
    //   1409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: invokevirtual toString : ()Ljava/lang/String;
    //   1415: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   1418: pop
    //   1419: aload_2
    //   1420: ifnull -> 1430
    //   1423: aload_2
    //   1424: invokevirtual length : ()I
    //   1427: ifne -> 1452
    //   1430: aload_0
    //   1431: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   1434: invokeinterface c : ()V
    //   1439: aload_1
    //   1440: ldc_w 'action_resp_code'
    //   1443: ldc_w '10019'
    //   1446: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1449: goto -> 145
    //   1452: new org/json/JSONObject
    //   1455: astore #6
    //   1457: aload #6
    //   1459: invokespecial <init> : ()V
    //   1462: aload #6
    //   1464: ldc_w 'v'
    //   1467: aload_0
    //   1468: getfield f : Ljava/lang/String;
    //   1471: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1474: pop
    //   1475: aload #6
    //   1477: ldc_w 'cmd'
    //   1480: ldc_w 'pay'
    //   1483: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1486: pop
    //   1487: new org/json/JSONObject
    //   1490: astore #4
    //   1492: aload #4
    //   1494: invokespecial <init> : ()V
    //   1497: aload #6
    //   1499: ldc_w 'params'
    //   1502: aload #4
    //   1504: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1507: pop
    //   1508: aload #4
    //   1510: ldc_w 'pay_type'
    //   1513: ldc_w '2'
    //   1516: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1519: pop
    //   1520: aload #4
    //   1522: ldc_w 'pay_mode'
    //   1525: ldc_w '1'
    //   1528: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1531: pop
    //   1532: aload #4
    //   1534: ldc_w 'bind'
    //   1537: ldc_w 'no'
    //   1540: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1543: pop
    //   1544: aload #4
    //   1546: ldc_w 'carrier_tp'
    //   1549: aload_3
    //   1550: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1553: pop
    //   1554: aload #4
    //   1556: ldc_w 'icc_data'
    //   1559: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1562: ldc_w 'DCD'
    //   1565: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1568: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1571: pop
    //   1572: aload #4
    //   1574: ldc_w 'csn'
    //   1577: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1580: ldc_w 'CSN'
    //   1583: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1586: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1589: pop
    //   1590: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1593: ldc_w '5F34'
    //   1596: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1599: ifnull -> 1870
    //   1602: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1605: ldc_w '5F34'
    //   1608: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1611: checkcast java/lang/String
    //   1614: astore_2
    //   1615: aload #4
    //   1617: ldc_w 'card_seq_id'
    //   1620: aload_2
    //   1621: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1624: pop
    //   1625: aload #4
    //   1627: ldc_w 'submit_time'
    //   1630: getstatic com/unionpay/mobile/android/pboctransaction/d.m : Ljava/lang/String;
    //   1633: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1636: pop
    //   1637: aload #4
    //   1639: ldc_w 'sp_id'
    //   1642: ldc_w '8889'
    //   1645: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1648: pop
    //   1649: aload #4
    //   1651: ldc_w 'pin'
    //   1654: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1657: ldc_w 'PIN'
    //   1660: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1663: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1666: pop
    //   1667: aload #4
    //   1669: ldc_w 'pan'
    //   1672: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1675: ldc_w 'AN1'
    //   1678: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1681: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1684: pop
    //   1685: aload #4
    //   1687: ldc_w 'carrier_app_tp'
    //   1690: ldc_w '2'
    //   1693: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1696: pop
    //   1697: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1700: ldc_w 'ED'
    //   1703: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1706: ifnull -> 1727
    //   1709: aload #4
    //   1711: ldc_w 'expire'
    //   1714: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1717: ldc_w 'ED'
    //   1720: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1723: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1726: pop
    //   1727: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1730: ldc_w 'TD2'
    //   1733: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1736: ifnull -> 1757
    //   1739: aload #4
    //   1741: ldc_w 'track2_data'
    //   1744: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   1747: ldc_w 'TD2'
    //   1750: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1753: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1756: pop
    //   1757: aload #5
    //   1759: ifnull -> 1876
    //   1762: aload #5
    //   1764: invokevirtual keySet : ()Ljava/util/Set;
    //   1767: ifnull -> 1876
    //   1770: aload #5
    //   1772: invokevirtual keySet : ()Ljava/util/Set;
    //   1775: invokeinterface size : ()I
    //   1780: ifle -> 1876
    //   1783: aload #5
    //   1785: ldc_w 'pan'
    //   1788: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1791: pop
    //   1792: aload #5
    //   1794: ldc_w 'pin'
    //   1797: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1800: pop
    //   1801: aload #5
    //   1803: invokevirtual keySet : ()Ljava/util/Set;
    //   1806: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1811: astore_3
    //   1812: aload_3
    //   1813: invokeinterface hasNext : ()Z
    //   1818: ifeq -> 1876
    //   1821: aload_3
    //   1822: invokeinterface next : ()Ljava/lang/Object;
    //   1827: checkcast java/lang/String
    //   1830: astore_2
    //   1831: aload #4
    //   1833: aload_2
    //   1834: aload #5
    //   1836: aload_2
    //   1837: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1840: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1843: pop
    //   1844: goto -> 1812
    //   1847: astore_2
    //   1848: aload_0
    //   1849: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   1852: invokeinterface c : ()V
    //   1857: aload_1
    //   1858: ldc_w 'action_resp_code'
    //   1861: ldc_w '10019'
    //   1864: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1867: goto -> 145
    //   1870: ldc ''
    //   1872: astore_2
    //   1873: goto -> 1615
    //   1876: aload #6
    //   1878: invokevirtual toString : ()Ljava/lang/String;
    //   1881: astore_2
    //   1882: ldc 'uppay'
    //   1884: aload_2
    //   1885: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   1888: pop
    //   1889: aload_1
    //   1890: ldc_w 'action_resp_message'
    //   1893: aload_0
    //   1894: getfield d : Lcom/unionpay/mobile/android/fully/a;
    //   1897: aload_2
    //   1898: invokeinterface a : (Ljava/lang/String;)Ljava/lang/String;
    //   1903: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1906: aload_0
    //   1907: getfield c : Lcom/unionpay/mobile/android/pboctransaction/c;
    //   1910: invokeinterface c : ()V
    //   1915: invokestatic d : ()V
    //   1918: goto -> 145
    //   1921: goto -> 1368
    // Exception table:
    //   from	to	target	type
    //   2	145	373	finally
    //   149	258	373	finally
    //   263	271	373	finally
    //   271	281	373	finally
    //   281	303	373	finally
    //   306	349	373	finally
    //   353	360	373	finally
    //   360	370	373	finally
    //   378	420	373	finally
    //   425	433	373	finally
    //   433	443	373	finally
    //   446	490	373	finally
    //   494	501	373	finally
    //   501	511	373	finally
    //   514	557	373	finally
    //   561	568	373	finally
    //   568	578	373	finally
    //   581	623	373	finally
    //   627	634	373	finally
    //   634	644	373	finally
    //   647	705	373	finally
    //   710	718	373	finally
    //   718	737	373	finally
    //   740	784	373	finally
    //   787	1011	373	finally
    //   1011	1030	373	finally
    //   1033	1079	373	finally
    //   1079	1106	373	finally
    //   1106	1133	373	finally
    //   1133	1160	373	finally
    //   1160	1212	373	finally
    //   1212	1246	373	finally
    //   1246	1273	373	finally
    //   1273	1300	373	finally
    //   1303	1310	373	finally
    //   1310	1332	373	finally
    //   1337	1368	373	finally
    //   1371	1419	373	finally
    //   1423	1430	373	finally
    //   1430	1449	373	finally
    //   1452	1615	1847	org/json/JSONException
    //   1452	1615	373	finally
    //   1615	1727	1847	org/json/JSONException
    //   1615	1727	373	finally
    //   1727	1757	1847	org/json/JSONException
    //   1727	1757	373	finally
    //   1762	1812	1847	org/json/JSONException
    //   1762	1812	373	finally
    //   1812	1844	1847	org/json/JSONException
    //   1812	1844	373	finally
    //   1848	1867	373	finally
    //   1876	1882	1847	org/json/JSONException
    //   1876	1882	373	finally
    //   1882	1918	373	finally
  }
  
  public final String a() {
    if (this.c instanceof com.unionpay.mobile.android.pboctransaction.samsung.f)
      return this.c.a("A0000003334355502D4D4F42494C45"); 
    this.g = (byte)this.i;
    return a(new byte[] { 
          0, -92, 4, 0, 15, -96, 0, 0, 3, 51, 
          67, 85, 80, 45, 77, 79, 66, 73, 76, 69 });
  }
  
  public final String a(int paramInt, String paramString) {
    this.g = (byte)this.i;
    if (Integer.toHexString(paramInt).length() == 1) {
      String str1 = "0" + Integer.toHexString(paramInt);
      return a(e.a("80F802" + str1 + "08" + paramString + "80"));
    } 
    String str = Integer.toHexString(paramInt);
    return a(e.a("80F802" + str + "08" + paramString + "80"));
  }
  
  public final String a(AppIdentification paramAppIdentification) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual a : ()Ljava/lang/String;
    //   8: astore_1
    //   9: invokestatic d : ()V
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: aload_0
    //   19: aconst_null
    //   20: invokespecial c : (Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: ifnull -> 43
    //   30: aload_3
    //   31: invokevirtual length : ()I
    //   34: istore #4
    //   36: iload #4
    //   38: ifne -> 47
    //   41: aload_2
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: areturn
    //   47: aload_0
    //   48: aload_3
    //   49: invokespecial d : (Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull -> 43
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: invokevirtual length : ()I
    //   65: ifeq -> 43
    //   68: getstatic com/unionpay/mobile/android/pboctransaction/d.o : Ljava/util/HashMap;
    //   71: ldc_w '5A'
    //   74: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   77: checkcast java/lang/String
    //   80: astore_1
    //   81: goto -> 43
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   4	24	84	finally
    //   30	36	84	finally
    //   47	53	84	finally
    //   61	81	84	finally
  }
  
  public final String a(String paramString) {
    this.c.d();
    paramString = b(paramString);
    this.c.d();
    return a(paramString, "84");
  }
  
  public final ArrayList<c> b() {
    this.c.d();
    this.c.b();
    ArrayList<c> arrayList = this.c.a(this);
    this.c.c();
    return arrayList;
  }
  
  public final String c() {
    this.g = (byte)this.i;
    return a(e.a("80F2000102"));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
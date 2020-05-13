package com.unionpay.mobile.android.pboctransaction.nfc;

import android.text.TextUtils;
import android.util.Log;
import com.unionpay.mobile.android.pboctransaction.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a {
  protected static final byte[] d = new byte[] { 
      50, 80, 65, 89, 46, 83, 89, 83, 46, 68, 
      68, 70, 48, 49 };
  
  protected String a = "UnionPay Card";
  
  com.unionpay.mobile.android.fully.a b;
  
  b.b c;
  
  public a(com.unionpay.mobile.android.fully.a parama, b.b paramb) {
    this.b = parama;
    this.c = paramb;
  }
  
  private static String a(String paramString1, String paramString2) {
    byte b1 = 1;
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
            j = b1;
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
  
  private static List<String> a(String paramString) {
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
  
  public static void b(String paramString, HashMap<String, String> paramHashMap) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc '82'
    //   11: invokeinterface add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: aload_2
    //   18: ldc '9F36'
    //   20: invokeinterface add : (Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload_2
    //   27: ldc '9F10'
    //   29: invokeinterface add : (Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_2
    //   36: ldc '9F26'
    //   38: invokeinterface add : (Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload_2
    //   45: ldc '5F34'
    //   47: invokeinterface add : (Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_2
    //   54: ldc '57'
    //   56: invokeinterface add : (Ljava/lang/Object;)Z
    //   61: pop
    //   62: aload_2
    //   63: ldc '9F63'
    //   65: invokeinterface add : (Ljava/lang/Object;)Z
    //   70: pop
    //   71: iconst_0
    //   72: istore_3
    //   73: iload_3
    //   74: aload_2
    //   75: invokeinterface size : ()I
    //   80: if_icmpge -> 123
    //   83: aload_2
    //   84: iload_3
    //   85: invokeinterface get : (I)Ljava/lang/Object;
    //   90: checkcast java/lang/String
    //   93: astore #4
    //   95: aload_0
    //   96: aload #4
    //   98: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore #5
    //   103: aload #5
    //   105: ifnull -> 117
    //   108: aload_1
    //   109: aload #4
    //   111: aload #5
    //   113: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: iinc #3, 1
    //   120: goto -> 73
    //   123: new java/lang/StringBuffer
    //   126: astore_0
    //   127: aload_0
    //   128: aload_1
    //   129: ldc '5F34'
    //   131: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast java/lang/String
    //   137: invokespecial <init> : (Ljava/lang/String;)V
    //   140: aload_0
    //   141: iconst_0
    //   142: ldc '0'
    //   144: invokevirtual insert : (ILjava/lang/String;)Ljava/lang/StringBuffer;
    //   147: pop
    //   148: aload_1
    //   149: ldc '5F34'
    //   151: aload_0
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_1
    //   160: ldc '57'
    //   162: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast java/lang/String
    //   168: astore_0
    //   169: aload_0
    //   170: aload_0
    //   171: invokevirtual length : ()I
    //   174: iconst_1
    //   175: isub
    //   176: aload_0
    //   177: invokevirtual length : ()I
    //   180: invokevirtual substring : (II)Ljava/lang/String;
    //   183: ldc 'f'
    //   185: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   188: ifne -> 213
    //   191: aload_0
    //   192: aload_0
    //   193: invokevirtual length : ()I
    //   196: iconst_1
    //   197: isub
    //   198: aload_0
    //   199: invokevirtual length : ()I
    //   202: invokevirtual substring : (II)Ljava/lang/String;
    //   205: ldc 'F'
    //   207: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   210: ifeq -> 228
    //   213: aload_0
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual length : ()I
    //   219: iconst_1
    //   220: isub
    //   221: invokevirtual substring : (II)Ljava/lang/String;
    //   224: astore_0
    //   225: goto -> 169
    //   228: aload_1
    //   229: ldc 'TD2'
    //   231: aload_0
    //   232: invokevirtual toString : ()Ljava/lang/String;
    //   235: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: aload_0
    //   240: ldc 'D'
    //   242: invokevirtual indexOf : (Ljava/lang/String;)I
    //   245: istore_3
    //   246: aload_0
    //   247: iconst_0
    //   248: iload_3
    //   249: invokevirtual substring : (II)Ljava/lang/String;
    //   252: astore_2
    //   253: aload_2
    //   254: ldc 'F'
    //   256: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   259: ifne -> 274
    //   262: aload_2
    //   263: astore #5
    //   265: aload_2
    //   266: ldc 'f'
    //   268: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   271: ifeq -> 287
    //   274: aload_2
    //   275: iconst_0
    //   276: aload_2
    //   277: invokevirtual length : ()I
    //   280: iconst_1
    //   281: isub
    //   282: invokevirtual substring : (II)Ljava/lang/String;
    //   285: astore #5
    //   287: aload_1
    //   288: ldc 'AN1'
    //   290: aload #5
    //   292: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: aload_1
    //   297: ldc 'ED'
    //   299: aload_0
    //   300: iload_3
    //   301: iconst_1
    //   302: iadd
    //   303: iload_3
    //   304: iconst_5
    //   305: iadd
    //   306: invokevirtual substring : (II)Ljava/lang/String;
    //   309: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   312: pop
    //   313: aload_1
    //   314: ldc 'AMT'
    //   316: aload_1
    //   317: ldc '9F02'
    //   319: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   322: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: aload_1
    //   327: ldc '9F10'
    //   329: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   332: ifeq -> 367
    //   335: aload_1
    //   336: ldc '9F10'
    //   338: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   341: checkcast java/lang/String
    //   344: invokestatic a : (Ljava/lang/String;)[B
    //   347: iconst_4
    //   348: baload
    //   349: bipush #48
    //   351: iand
    //   352: i2b
    //   353: bipush #32
    //   355: if_icmpne -> 367
    //   358: aload_1
    //   359: ldc '9F27'
    //   361: ldc '80'
    //   363: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: return
    //   368: astore_0
    //   369: aload_0
    //   370: invokevirtual printStackTrace : ()V
    //   373: goto -> 367
    // Exception table:
    //   from	to	target	type
    //   73	103	368	java/lang/Exception
    //   108	117	368	java/lang/Exception
    //   123	169	368	java/lang/Exception
    //   169	213	368	java/lang/Exception
    //   213	225	368	java/lang/Exception
    //   228	262	368	java/lang/Exception
    //   265	274	368	java/lang/Exception
    //   274	287	368	java/lang/Exception
    //   287	367	368	java/lang/Exception
  }
  
  public final String a() {
    String str = null;
    b.a a1 = this.c.a(d);
    if (a1.b()) {
      String str1 = a(a1.toString(), "4F");
      if (str1.startsWith("A000000333")) {
        b.a a2 = this.c.a(e.a(str1));
        if (a2.b())
          str = a2.toString(); 
        return str;
      } 
      str = "noSupUnionpay";
    } 
    return str;
  }
  
  public final String a(String paramString, HashMap<String, String> paramHashMap) {
    str2 = a(paramString, "9F38");
    StringBuffer stringBuffer = new StringBuffer();
    for (String str2 : a(str2)) {
      for (String str : paramHashMap.keySet()) {
        if (str2.compareToIgnoreCase(str) == 0)
          stringBuffer.append(paramHashMap.get(str)); 
      } 
    } 
    b.b b1 = this.c;
    byte[] arrayOfByte = e.a(stringBuffer.toString());
    ByteBuffer byteBuffer = ByteBuffer.allocate(arrayOfByte.length + 7);
    byteBuffer.put(-128).put((byte)-88).put((byte)0).put((byte)0).put((byte)(arrayOfByte.length + 2)).put((byte)-125).put((byte)arrayOfByte.length).put(arrayOfByte);
    Log.e("PBOC Transceive", b.b.c(byteBuffer.array()));
    b.a a1 = new b.a(b1.b(byteBuffer.array()));
    Log.e("PBOC receive", b.b.c(a1.a()));
    if (!a1.b())
      return null; 
    String str1 = a(a1.toString(), "9F10");
    return (!TextUtils.isEmpty(str1) && (byte)(e.a(str1)[4] & 0x30) != 32) ? null : a1.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\nfc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
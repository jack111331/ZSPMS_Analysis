package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class v implements Runnable {
  private int a = 2;
  
  private int b = 30000;
  
  private final Context c;
  
  private final int d;
  
  private final byte[] e;
  
  private final a f;
  
  private final a g;
  
  private final s h;
  
  private final u i;
  
  private final int j;
  
  private final t k;
  
  private final t l;
  
  private String m = null;
  
  private final String n;
  
  private final Map<String, String> o;
  
  private int p = 0;
  
  private long q = 0L;
  
  private long r = 0L;
  
  private boolean s = true;
  
  private boolean t = false;
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, Map<String, String> paramMap) {
    this.c = paramContext;
    this.f = a.a(paramContext);
    this.e = paramArrayOfbyte;
    this.g = a.a();
    this.h = s.a(paramContext);
    this.i = u.a();
    this.j = paramInt1;
    this.m = paramString1;
    this.n = paramString2;
    this.k = paramt;
    u u1 = this.i;
    this.l = null;
    this.s = paramBoolean1;
    this.d = paramInt2;
    if (paramInt3 > 0)
      this.a = paramInt3; 
    if (paramInt4 > 0)
      this.b = paramInt4; 
    this.t = paramBoolean2;
    this.o = paramMap;
  }
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, boolean paramBoolean2) {
    this(paramContext, paramInt1, paramInt2, paramArrayOfbyte, paramString1, paramString2, paramt, paramBoolean1, 2, 30000, paramBoolean2, null);
  }
  
  private static String a(String paramString) {
    if (z.a(paramString))
      return paramString; 
    try {
      return String.format("%s?aid=%s", new Object[] { paramString, UUID.randomUUID().toString() });
    } catch (Throwable throwable) {
      x.a(throwable);
      return paramString;
    } 
  }
  
  private void a(aq paramaq, boolean paramBoolean, int paramInt1, String paramString, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : I
    //   4: istore #6
    //   6: iload #6
    //   8: sipush #630
    //   11: if_icmpeq -> 55
    //   14: iload #6
    //   16: sipush #640
    //   19: if_icmpeq -> 49
    //   22: iload #6
    //   24: sipush #830
    //   27: if_icmpeq -> 55
    //   30: iload #6
    //   32: sipush #840
    //   35: if_icmpeq -> 49
    //   38: aload_0
    //   39: getfield d : I
    //   42: invokestatic valueOf : (I)Ljava/lang/String;
    //   45: astore_1
    //   46: goto -> 58
    //   49: ldc 'userinfo'
    //   51: astore_1
    //   52: goto -> 58
    //   55: ldc 'crash'
    //   57: astore_1
    //   58: iload_2
    //   59: ifeq -> 79
    //   62: ldc '[Upload] Success: %s'
    //   64: iconst_1
    //   65: anewarray java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   75: pop
    //   76: goto -> 122
    //   79: ldc '[Upload] Failed to upload(%d) %s: %s'
    //   81: iconst_3
    //   82: anewarray java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: iload_3
    //   88: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload_1
    //   95: aastore
    //   96: dup
    //   97: iconst_2
    //   98: aload #4
    //   100: aastore
    //   101: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield s : Z
    //   109: ifeq -> 122
    //   112: aload_0
    //   113: getfield i : Lcom/tencent/bugly/proguard/u;
    //   116: iload #5
    //   118: aconst_null
    //   119: invokevirtual a : (ILcom/tencent/bugly/proguard/aq;)V
    //   122: aload_0
    //   123: getfield q : J
    //   126: aload_0
    //   127: getfield r : J
    //   130: ladd
    //   131: lconst_0
    //   132: lcmp
    //   133: ifle -> 180
    //   136: aload_0
    //   137: getfield i : Lcom/tencent/bugly/proguard/u;
    //   140: aload_0
    //   141: getfield t : Z
    //   144: invokevirtual a : (Z)J
    //   147: lstore #7
    //   149: aload_0
    //   150: getfield q : J
    //   153: lstore #9
    //   155: aload_0
    //   156: getfield r : J
    //   159: lstore #11
    //   161: aload_0
    //   162: getfield i : Lcom/tencent/bugly/proguard/u;
    //   165: lload #7
    //   167: lload #9
    //   169: ladd
    //   170: lload #11
    //   172: ladd
    //   173: aload_0
    //   174: getfield t : Z
    //   177: invokevirtual a : (JZ)V
    //   180: aload_0
    //   181: getfield k : Lcom/tencent/bugly/proguard/t;
    //   184: ifnull -> 216
    //   187: aload_0
    //   188: getfield k : Lcom/tencent/bugly/proguard/t;
    //   191: astore_1
    //   192: aload_0
    //   193: getfield d : I
    //   196: istore_3
    //   197: aload_0
    //   198: getfield q : J
    //   201: lstore #7
    //   203: aload_0
    //   204: getfield r : J
    //   207: lstore #7
    //   209: aload_1
    //   210: iload_2
    //   211: invokeinterface a : (Z)V
    //   216: aload_0
    //   217: getfield l : Lcom/tencent/bugly/proguard/t;
    //   220: ifnull -> 252
    //   223: aload_0
    //   224: getfield l : Lcom/tencent/bugly/proguard/t;
    //   227: astore_1
    //   228: aload_0
    //   229: getfield d : I
    //   232: istore_3
    //   233: aload_0
    //   234: getfield q : J
    //   237: lstore #7
    //   239: aload_0
    //   240: getfield r : J
    //   243: lstore #7
    //   245: aload_1
    //   246: iload_2
    //   247: invokeinterface a : (Z)V
    //   252: return
  }
  
  private static boolean a(aq paramaq, a parama, a parama1) {
    if (paramaq == null) {
      x.d("resp == null!", new Object[0]);
      return false;
    } 
    if (paramaq.a != 0) {
      x.e("resp result error %d", new Object[] { Byte.valueOf(paramaq.a) });
      return false;
    } 
    try {
      if (!z.a(paramaq.d) && !a.b().i().equals(paramaq.d)) {
        p.a().a(a.a, "gateway", paramaq.d.getBytes("UTF-8"), (o)null, true);
        parama.d(paramaq.d);
      } 
      if (!z.a(paramaq.f) && !a.b().j().equals(paramaq.f)) {
        p.a().a(a.a, "device", paramaq.f.getBytes("UTF-8"), (o)null, true);
        parama.e(paramaq.f);
      } 
    } catch (Throwable throwable) {
      x.a(throwable);
    } 
    parama.i = paramaq.e;
    if (paramaq.b == 510) {
      if (paramaq.c == null) {
        x.e("[Upload] Strategy data is null. Response cmd: %d", new Object[] { Integer.valueOf(paramaq.b) });
        return false;
      } 
      as as = a.<as>a(paramaq.c, as.class);
      if (as == null) {
        x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", new Object[] { Integer.valueOf(paramaq.b) });
        return false;
      } 
      parama1.a(as);
    } 
    return true;
  }
  
  public final void a(long paramLong) {
    this.p++;
    this.q += paramLong;
  }
  
  public final void b(long paramLong) {
    this.r += paramLong;
  }
  
  public final void run() {
    boolean bool = false;
    try {
      this.p = 0;
      this.q = 0L;
      this.r = 0L;
      byte[] arrayOfByte1 = this.e;
      if (b.c(this.c) == null) {
        a(null, false, 0, "network is not available", 0);
        return;
      } 
      if (arrayOfByte1 == null || arrayOfByte1.length == 0) {
        a(null, false, 0, "request package is empty!", 0);
        return;
      } 
      x.c("[Upload] Run upload task with cmd: %d", new Object[] { Integer.valueOf(this.d) });
      if (this.c == null || this.f == null || this.g == null || this.h == null) {
        a(null, false, 0, "illegal access error", 0);
        return;
      } 
      StrategyBean strategyBean = this.g.c();
      if (strategyBean == null) {
        a(null, false, 0, "illegal local strategy", 0);
        return;
      } 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      hashMap.put("prodId", this.f.f());
      hashMap.put("bundleId", this.f.c);
      hashMap.put("appVer", this.f.j);
      if (this.o != null)
        hashMap.putAll(this.o); 
      byte[] arrayOfByte2 = arrayOfByte1;
      if (this.s) {
        hashMap.put("cmd", Integer.toString(this.d));
        hashMap.put("platformId", Byte.toString((byte)1));
        this.f.getClass();
        hashMap.put("sdkVer", "3.1.0");
        hashMap.put("strategylastUpdateTime", Long.toString(strategyBean.p));
        if (!this.i.a((Map)hashMap)) {
          a(null, false, 0, "failed to add security info to HTTP headers", 0);
          return;
        } 
        arrayOfByte1 = z.a(arrayOfByte1, 2);
        if (arrayOfByte1 == null) {
          a(null, false, 0, "failed to zip request body", 0);
          return;
        } 
        arrayOfByte1 = this.i.a(arrayOfByte1);
        arrayOfByte2 = arrayOfByte1;
        if (arrayOfByte1 == null) {
          a(null, false, 0, "failed to encrypt request body", 0);
          return;
        } 
      } 
      this.i.a(this.j, System.currentTimeMillis());
      if (this.k != null) {
        t t1 = this.k;
        int m = this.d;
      } 
      if (this.l != null) {
        t t1 = this.l;
        int m = this.d;
      } 
      String str = this.m;
      int j = 0;
      int k = 0;
      int i = -1;
      while (true) {
        int m = j + 1;
        if (j < this.a) {
          String str1 = str;
          if (m > 1) {
            x.d("[Upload] Failed to upload last time, wait and try(%d) again.", new Object[] { Integer.valueOf(m) });
            z.b(this.b);
            str1 = str;
            if (m == this.a) {
              x.d("[Upload] Use the back-up url at the last time: %s", new Object[] { this.n });
              str1 = this.n;
            } 
          } 
          x.c("[Upload] Send %d bytes", new Object[] { Integer.valueOf(arrayOfByte2.length) });
          str = str1;
          if (this.s)
            str = a(str1); 
          x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", new Object[] { str, Integer.valueOf(this.d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          byte[] arrayOfByte = this.h.a(str, arrayOfByte2, this, (Map)hashMap);
          if (arrayOfByte == null) {
            x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), "Failed to upload for no response!" });
          } else {
            Map<String, String> map = this.h.a;
            k = i;
            if (this.s) {
              if (map == null || map.size() == 0) {
                x.d("[Upload] Headers is empty.", new Object[0]);
              } else {
                StringBuilder stringBuilder;
                if (!map.containsKey("status")) {
                  Object[] arrayOfObject = new Object[1];
                  arrayOfObject[0] = "status";
                } else if (!map.containsKey("Bugly-Version")) {
                  Object[] arrayOfObject = new Object[1];
                  arrayOfObject[0] = "Bugly-Version";
                } else {
                  str1 = map.get("Bugly-Version");
                  if (!str1.contains("bugly")) {
                    x.d("[Upload] Bugly version is not valid: %s", new Object[] { str1 });
                  } else {
                    x.c("[Upload] Bugly version from headers is: %s", new Object[] { str1 });
                    k = 1;
                    if (k == 0) {
                      x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
                      x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), "[Upload] Failed to upload for no status header." });
                      if (map != null)
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                          x.c(String.format("[key]: %s, [value]: %s", new Object[] { entry.getKey(), entry.getValue() }), new Object[0]);
                        }  
                      x.c("[Upload] Failed to upload for no status header.", new Object[0]);
                    } else {
                      try {
                        k = Integer.parseInt(map.get("status"));
                        try {
                          x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", new Object[] { Integer.valueOf(k), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
                          if (k != 0) {
                            if (k == 2) {
                              if (this.q + this.r > 0L) {
                                long l1 = this.i.a(this.t);
                                long l2 = this.q;
                                long l3 = this.r;
                                this.i.a(l1 + l2 + l3, this.t);
                              } 
                              this.i.a(k, (aq)null);
                              x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
                              this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.a, this.b, true, this.o);
                              return;
                            } 
                            StringBuilder stringBuilder1 = new StringBuilder();
                            this("status of server is ");
                            stringBuilder1.append(k);
                            a(null, false, 1, stringBuilder1.toString(), k);
                            return;
                          } 
                          continue;
                        } catch (Throwable throwable) {
                          i = k;
                        } 
                      } catch (Throwable throwable) {}
                      stringBuilder = new StringBuilder();
                      this("[Upload] Failed to upload for format of status header is invalid: ");
                      stringBuilder.append(Integer.toString(i));
                      x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), stringBuilder.toString() });
                    } 
                  } 
                  k = 0;
                } 
                x.d("[Upload] Headers does not contain %s", (Object[])stringBuilder);
              } 
            } else {
              byte[] arrayOfByte3;
              x.c("[Upload] Received %d bytes", new Object[] { Integer.valueOf(entry.length) });
              entry1 = entry;
              if (this.s) {
                if (entry.length == 0) {
                  for (Map.Entry<String, String> entry1 : map.entrySet()) {
                    x.c("[Upload] HTTP headers from server: key = %s, value = %s", new Object[] { entry1.getKey(), entry1.getValue() });
                  } 
                  a(null, false, 1, "response data from server is empty", 0);
                  return;
                } 
                arrayOfByte3 = this.i.b((byte[])entry);
                if (arrayOfByte3 == null) {
                  a(null, false, 1, "failed to decrypt response from server", 0);
                  return;
                } 
                byte[] arrayOfByte4 = z.b(arrayOfByte3, 2);
                arrayOfByte3 = arrayOfByte4;
                if (arrayOfByte4 == null) {
                  a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                  return;
                } 
              } 
              aq aq = a.a(arrayOfByte3, this.s);
              if (aq == null) {
                a(null, false, 1, "failed to decode response package", 0);
                return;
              } 
              if (this.s)
                this.i.a(k, aq); 
              k = aq.b;
              if (aq.c == null) {
                i = bool;
              } else {
                i = aq.c.length;
              } 
              x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
              if (!a(aq, this.f, this.g)) {
                a(aq, false, 2, "failed to process response package", 0);
                return;
              } 
              a(aq, true, 2, "successfully uploaded", 0);
              return;
            } 
            k = 0;
          } 
        } else {
          a(null, false, k, "failed after many attempts", 0);
          return;
        } 
        j = m;
        k = 1;
      } 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
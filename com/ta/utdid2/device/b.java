package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.f;
import java.util.zip.Adler32;

public class b {
  private static a a = null;
  
  static final Object d = new Object();
  
  static long a(a parama) {
    if (parama != null) {
      String str = String.format("%s%s%s%s%s", new Object[] { parama.getUtdid(), parama.getDeviceId(), Long.valueOf(parama.a()), parama.getImsi(), parama.getImei() });
      if (!f.isEmpty(str)) {
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
      } 
    } 
    return 0L;
  }
  
  private static a a(Context paramContext) {
    if (paramContext != null)
      synchronized (d) {
        String str = c.a(paramContext).getValue();
        if (!f.isEmpty(str)) {
          if (str.endsWith("\n"))
            str = str.substring(0, str.length() - 1); 
          a a1 = new a();
          this();
          long l = System.currentTimeMillis();
          String str2 = d.getImei(paramContext);
          String str1 = d.getImsi(paramContext);
          a1.b(str2);
          a1.setImei(str2);
          a1.b(l);
          a1.setImsi(str1);
          a1.c(str);
          a1.a(a(a1));
          return a1;
        } 
        return null;
      }  
    return null;
  }
  
  public static a b(Context paramContext) {
    // Byte code:
    //   0: ldc com/ta/utdid2/device/b
    //   2: monitorenter
    //   3: getstatic com/ta/utdid2/device/b.a : Lcom/ta/utdid2/device/a;
    //   6: ifnull -> 18
    //   9: getstatic com/ta/utdid2/device/b.a : Lcom/ta/utdid2/device/a;
    //   12: astore_0
    //   13: ldc com/ta/utdid2/device/b
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ifnull -> 40
    //   22: aload_0
    //   23: invokestatic a : (Landroid/content/Context;)Lcom/ta/utdid2/device/a;
    //   26: astore_0
    //   27: aload_0
    //   28: putstatic com/ta/utdid2/device/b.a : Lcom/ta/utdid2/device/a;
    //   31: goto -> 13
    //   34: astore_0
    //   35: ldc com/ta/utdid2/device/b
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: aconst_null
    //   41: astore_0
    //   42: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   3	13	34	finally
    //   22	31	34	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\device\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
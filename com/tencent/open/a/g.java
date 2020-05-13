package com.tencent.open.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class g implements Iterable<String> {
  private ConcurrentLinkedQueue<String> a = null;
  
  private AtomicInteger b = null;
  
  public g() {
    this.a = new ConcurrentLinkedQueue<String>();
    this.b = new AtomicInteger(0);
  }
  
  public int a() {
    return this.b.get();
  }
  
  public int a(String paramString) {
    int i = paramString.length();
    this.a.add(paramString);
    return this.b.addAndGet(i);
  }
  
  public void a(Writer paramWriter, char[] paramArrayOfchar) throws IOException {
    if (paramWriter != null && paramArrayOfchar != null && paramArrayOfchar.length != 0) {
      int i = paramArrayOfchar.length;
      Iterator<String> iterator = iterator();
      int j = 0;
      int k = i;
      label25: while (iterator.hasNext()) {
        String str = iterator.next();
        int m = str.length();
        int n = 0;
        int i1 = k;
        int i2 = j;
        while (true) {
          j = i2;
          k = i1;
          if (m > 0) {
            if (i1 > m) {
              k = m;
            } else {
              k = i1;
            } 
            str.getChars(n, n + k, paramArrayOfchar, i2);
            i1 -= k;
            i2 += k;
            m -= k;
            n = k + n;
            if (i1 == 0) {
              paramWriter.write(paramArrayOfchar, 0, i);
              i2 = 0;
              i1 = i;
            } 
            continue;
          } 
          continue label25;
        } 
      } 
      if (j > 0)
        paramWriter.write(paramArrayOfchar, 0, j); 
      paramWriter.flush();
    } 
  }
  
  public void b() {
    this.a.clear();
    this.b.set(0);
  }
  
  public Iterator<String> iterator() {
    return this.a.iterator();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
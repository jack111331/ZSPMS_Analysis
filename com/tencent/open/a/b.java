package com.tencent.open.a;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class b {
  private static SimpleDateFormat a = d.d.a("yy.MM.dd.HH");
  
  private String b = "Tracer.File";
  
  private int c = Integer.MAX_VALUE;
  
  private int d = Integer.MAX_VALUE;
  
  private int e = 4096;
  
  private long f = 10000L;
  
  private File g;
  
  private int h = 10;
  
  private String i = ".log";
  
  private long j = Long.MAX_VALUE;
  
  public b(File paramFile, int paramInt1, int paramInt2, int paramInt3, String paramString1, long paramLong1, int paramInt4, String paramString2, long paramLong2) {
    a(paramFile);
    b(paramInt1);
    a(paramInt2);
    c(paramInt3);
    a(paramString1);
    a(paramLong1);
    d(paramInt4);
    b(paramString2);
    b(paramLong2);
  }
  
  private File c(long paramLong) {
    File file = b();
    String str = c(d(paramLong));
    try {
      File file1 = new File();
      this(file, str);
      file = file1;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return file;
  }
  
  private String c(String paramString) {
    return "com.tencent.mobileqq_connectSdk." + paramString + ".log";
  }
  
  private String d(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    return (new SimpleDateFormat("yy.MM.dd.HH")).format(calendar.getTime());
  }
  
  public File a() {
    return c(System.currentTimeMillis());
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public void a(long paramLong) {
    this.f = paramLong;
  }
  
  public void a(File paramFile) {
    this.g = paramFile;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public File b() {
    File file = e();
    file.mkdirs();
    return file;
  }
  
  public void b(int paramInt) {
    this.d = paramInt;
  }
  
  public void b(long paramLong) {
    this.j = paramLong;
  }
  
  public void b(String paramString) {
    this.i = paramString;
  }
  
  public String c() {
    return this.b;
  }
  
  public void c(int paramInt) {
    this.e = paramInt;
  }
  
  public int d() {
    return this.e;
  }
  
  public void d(int paramInt) {
    this.h = paramInt;
  }
  
  public File e() {
    return this.g;
  }
  
  public int f() {
    return this.h;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
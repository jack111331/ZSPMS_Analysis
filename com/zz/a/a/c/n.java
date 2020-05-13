package com.zz.a.a.c;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public final class n {
  private final p b;
  
  private boolean c;
  
  private n(l paraml, p paramp) {
    this.b = paramp;
  }
  
  public InputStream a(int paramInt) {
    synchronized (this.a) {
      if (p.a(this.b) != this) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this();
        throw illegalStateException;
      } 
    } 
    if (!p.d(this.b)) {
      InputStream inputStream = null;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
      return inputStream;
    } 
    FileInputStream fileInputStream = new FileInputStream();
    this(this.b.a(paramInt));
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return fileInputStream;
  }
  
  public void a() {
    if (this.c) {
      l.a(this.a, this, false);
      this.a.c(p.c(this.b));
      return;
    } 
    l.a(this.a, this, true);
  }
  
  public void a(int paramInt, String paramString) {
    Closeable closeable;
    try {
      closeable = new OutputStreamWriter();
      this(c(paramInt), l.g());
    } finally {
      paramString = null;
    } 
    l.a(closeable);
    throw paramString;
  }
  
  public String b(int paramInt) {
    null = a(paramInt);
    return (null != null) ? l.b(null) : null;
  }
  
  public void b() {
    l.a(this.a, this, false);
  }
  
  public OutputStream c(int paramInt) {
    synchronized (this.a) {
      if (p.a(this.b) != this) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this();
        throw illegalStateException;
      } 
    } 
    o o = new o();
    FileOutputStream fileOutputStream = new FileOutputStream();
    this(this.b.b(paramInt));
    this(this, fileOutputStream, null);
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return o;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
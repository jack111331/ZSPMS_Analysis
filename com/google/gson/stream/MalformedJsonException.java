package com.google.gson.stream;

import java.io.IOException;

public final class MalformedJsonException extends IOException {
  private static final long serialVersionUID = 1L;
  
  public MalformedJsonException(String paramString) {
    super(paramString);
  }
  
  public MalformedJsonException(String paramString, Throwable paramThrowable) {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public MalformedJsonException(Throwable paramThrowable) {
    initCause(paramThrowable);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\stream\MalformedJsonException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
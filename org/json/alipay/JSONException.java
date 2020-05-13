package org.json.alipay;

public class JSONException extends Exception {
  private Throwable cause;
  
  public JSONException(String paramString) {
    super(paramString);
  }
  
  public JSONException(Throwable paramThrowable) {
    super(paramThrowable.getMessage());
    this.cause = paramThrowable;
  }
  
  public Throwable getCause() {
    return this.cause;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\json\alipay\JSONException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
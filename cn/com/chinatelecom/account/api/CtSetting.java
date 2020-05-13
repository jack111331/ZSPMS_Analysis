package cn.com.chinatelecom.account.api;

public class CtSetting {
  private static final int DEFAULT_CONN_TIMEOUT = 3000;
  
  private static final int DEFAULT_READ_TIMEOUT = 3000;
  
  private static final int DEFAULT_TOTAL_TIMEOUT = 10000;
  
  private int connTimeout = 0;
  
  private int readTimeout = 0;
  
  private int totalTimeout = 0;
  
  public CtSetting(int paramInt1, int paramInt2, int paramInt3) {
    this.connTimeout = paramInt1;
    this.readTimeout = paramInt2;
    this.totalTimeout = paramInt3;
  }
  
  public static int getConnTimeout(CtSetting paramCtSetting) {
    return (paramCtSetting == null || paramCtSetting.connTimeout <= 0) ? 3000 : paramCtSetting.connTimeout;
  }
  
  public static int getReadTimeout(CtSetting paramCtSetting) {
    return (paramCtSetting == null || paramCtSetting.readTimeout <= 0) ? 3000 : paramCtSetting.readTimeout;
  }
  
  public static int getTotalTimeout(CtSetting paramCtSetting) {
    return (paramCtSetting == null || paramCtSetting.totalTimeout <= 0) ? 10000 : paramCtSetting.totalTimeout;
  }
  
  public void setConnTimeout(int paramInt) {
    this.connTimeout = paramInt;
  }
  
  public void setReadTimeout(int paramInt) {
    this.readTimeout = paramInt;
  }
  
  public void setTotalTimeout(int paramInt) {
    this.totalTimeout = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\CtSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
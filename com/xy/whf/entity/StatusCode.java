package com.xy.whf.entity;

public enum StatusCode {
  FAILED_0,
  FAILED_2400,
  FAILED_2401,
  FAILED_3000,
  FAILED_3002,
  FAILED_3003,
  FAILED_3006,
  FAILED_NEGATIVE_1,
  FAILED_NEGATIVE_2,
  FAILED_NEGATIVE_3,
  FAILED_NEGATIVE_4,
  FAILED_NEGATIVE_5,
  SUCCESS_0(0, "调用成功");
  
  private int code;
  
  private String message;
  
  static {
    FAILED_0 = new StatusCode("FAILED_0", 1, -1111, "请求失败");
    FAILED_3000 = new StatusCode("FAILED_3000", 2, 3000, "签名串不能为空");
    FAILED_3002 = new StatusCode("FAILED_3002", 3, 3002, "应用编号不能为空");
    FAILED_3003 = new StatusCode("FAILED_3003", 4, 3003, "支付参数不能为空");
    FAILED_3006 = new StatusCode("FAILED_3006", 5, 3006, "应用信息不存在");
    FAILED_2400 = new StatusCode("FAILED_2400", 6, 2400, "记录不存在");
    FAILED_2401 = new StatusCode("FAILED_2401", 7, 2401, "预授权失败");
    FAILED_NEGATIVE_1 = new StatusCode("FAILED_NEGATIVE_1", 8, -1, "调用失败，请检查接入流程，网络连接情况等，联系技术支持");
    FAILED_NEGATIVE_2 = new StatusCode("FAILED_NEGATIVE_2", 9, -2, "取消支付");
    FAILED_NEGATIVE_3 = new StatusCode("FAILED_NEGATIVE_3", 10, -3, "支付结果查询错误");
    FAILED_NEGATIVE_4 = new StatusCode("FAILED_NEGATIVE_4", 11, -4, "支付失败，请联系技术支持");
    FAILED_NEGATIVE_5 = new StatusCode("FAILED_NEGATIVE_5", 12, -5, "SDK未初始化");
    $VALUES = new StatusCode[] { 
        SUCCESS_0, FAILED_0, FAILED_3000, FAILED_3002, FAILED_3003, FAILED_3006, FAILED_2400, FAILED_2401, FAILED_NEGATIVE_1, FAILED_NEGATIVE_2, 
        FAILED_NEGATIVE_3, FAILED_NEGATIVE_4, FAILED_NEGATIVE_5 };
  }
  
  StatusCode(int paramInt1, String paramString1) {
    this.code = paramInt1;
    this.message = paramString1;
  }
  
  public int getCode() {
    return this.code;
  }
  
  public String getMessage() {
    return this.message;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\entity\StatusCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
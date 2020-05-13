package com.alibaba.fastjson;

class JSONStreamContext {
  static final int ArrayValue = 1005;
  
  static final int PropertyKey = 1002;
  
  static final int PropertyValue = 1003;
  
  static final int StartArray = 1004;
  
  static final int StartObject = 1001;
  
  protected final JSONStreamContext parent;
  
  protected int state;
  
  public JSONStreamContext(JSONStreamContext paramJSONStreamContext, int paramInt) {
    this.parent = paramJSONStreamContext;
    this.state = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\JSONStreamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

public class ParseContext {
  public final Object fieldName;
  
  public Object object;
  
  public final ParseContext parent;
  
  private transient String path;
  
  public Type type;
  
  public ParseContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2) {
    this.parent = paramParseContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
  }
  
  public String toString() {
    if (this.path == null)
      if (this.parent == null) {
        this.path = "$";
      } else if (this.fieldName instanceof Integer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.parent.toString());
        stringBuilder.append("[");
        stringBuilder.append(this.fieldName);
        stringBuilder.append("]");
        this.path = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.parent.toString());
        stringBuilder.append(".");
        stringBuilder.append(this.fieldName);
        this.path = stringBuilder.toString();
      }  
    return this.path;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\ParseContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
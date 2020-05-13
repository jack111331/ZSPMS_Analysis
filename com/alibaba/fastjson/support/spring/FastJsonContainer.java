package com.alibaba.fastjson.support.spring;

public class FastJsonContainer {
  private PropertyPreFilters filters;
  
  private Object value;
  
  FastJsonContainer(Object paramObject) {
    this.value = paramObject;
  }
  
  public PropertyPreFilters getFilters() {
    return this.filters;
  }
  
  public Object getValue() {
    return this.value;
  }
  
  public void setFilters(PropertyPreFilters paramPropertyPreFilters) {
    this.filters = paramPropertyPreFilters;
  }
  
  public void setValue(Object paramObject) {
    this.value = paramObject;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
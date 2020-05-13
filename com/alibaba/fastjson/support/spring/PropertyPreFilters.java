package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import java.util.ArrayList;
import java.util.List;

public class PropertyPreFilters {
  private List<MySimplePropertyPreFilter> filters = new ArrayList<MySimplePropertyPreFilter>();
  
  public MySimplePropertyPreFilter addFilter() {
    MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter();
    this.filters.add(mySimplePropertyPreFilter);
    return mySimplePropertyPreFilter;
  }
  
  public MySimplePropertyPreFilter addFilter(Class<?> paramClass, String... paramVarArgs) {
    MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(paramClass, paramVarArgs);
    this.filters.add(mySimplePropertyPreFilter);
    return mySimplePropertyPreFilter;
  }
  
  public MySimplePropertyPreFilter addFilter(String... paramVarArgs) {
    MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(paramVarArgs);
    this.filters.add(mySimplePropertyPreFilter);
    return mySimplePropertyPreFilter;
  }
  
  public List<MySimplePropertyPreFilter> getFilters() {
    return this.filters;
  }
  
  public void setFilters(List<MySimplePropertyPreFilter> paramList) {
    this.filters = paramList;
  }
  
  public MySimplePropertyPreFilter[] toFilters() {
    return this.filters.<MySimplePropertyPreFilter>toArray(new MySimplePropertyPreFilter[0]);
  }
  
  public class MySimplePropertyPreFilter extends SimplePropertyPreFilter {
    public MySimplePropertyPreFilter() {
      super(new String[0]);
    }
    
    public MySimplePropertyPreFilter(Class<?> param1Class, String... param1VarArgs) {
      super(param1Class, param1VarArgs);
    }
    
    public MySimplePropertyPreFilter(String... param1VarArgs) {
      super(param1VarArgs);
    }
    
    public MySimplePropertyPreFilter addExcludes(String... param1VarArgs) {
      for (byte b = 0; b < param1VarArgs.length; b++)
        getExcludes().add(param1VarArgs[b]); 
      return this;
    }
    
    public MySimplePropertyPreFilter addIncludes(String... param1VarArgs) {
      for (byte b = 0; b < param1VarArgs.length; b++)
        getIncludes().add(param1VarArgs[b]); 
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\PropertyPreFilters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
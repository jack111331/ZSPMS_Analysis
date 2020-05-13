package org.jar.mvchelper.mvc.data;

public class Data2<VALUE1, VALUE2> {
  private VALUE1 value1;
  
  private VALUE2 value2;
  
  public Data2() {}
  
  public Data2(VALUE1 paramVALUE1, VALUE2 paramVALUE2) {
    this.value1 = paramVALUE1;
    this.value2 = paramVALUE2;
  }
  
  public VALUE1 getValue1() {
    return this.value1;
  }
  
  public VALUE2 getValue2() {
    return this.value2;
  }
  
  public void setValue1(VALUE1 paramVALUE1) {
    this.value1 = paramVALUE1;
  }
  
  public void setValue2(VALUE2 paramVALUE2) {
    this.value2 = paramVALUE2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\data\Data2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
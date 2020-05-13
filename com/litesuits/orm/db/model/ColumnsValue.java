package com.litesuits.orm.db.model;

import com.litesuits.orm.db.assit.Checker;
import java.util.HashMap;
import java.util.Map;

public class ColumnsValue {
  public String[] columns;
  
  private Map<String, Object> map = new HashMap<String, Object>();
  
  public ColumnsValue(Map<String, Object> paramMap) {
    if (!Checker.isEmpty(paramMap)) {
      this.columns = new String[paramMap.size()];
      byte b = 0;
      for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
        this.columns[b] = (String)entry.getKey();
        b++;
      } 
      this.map = paramMap;
    } 
  }
  
  public ColumnsValue(String[] paramArrayOfString) {
    this.columns = paramArrayOfString;
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      String str = paramArrayOfString[b];
      this.map.put(str, null);
    } 
  }
  
  public ColumnsValue(String[] paramArrayOfString, Object[] paramArrayOfObject) {
    this.columns = paramArrayOfString;
    byte b = 0;
    int i = 0;
    if (paramArrayOfObject != null) {
      if (paramArrayOfString.length == paramArrayOfObject.length) {
        int j = paramArrayOfString.length;
        for (b = 0; i < j; b++) {
          String str = paramArrayOfString[i];
          this.map.put(str, paramArrayOfObject[b]);
          i++;
        } 
      } else {
        throw new IllegalArgumentException("length of columns and values must be the same");
      } 
    } else {
      i = paramArrayOfString.length;
      while (b < i) {
        String str = paramArrayOfString[b];
        this.map.put(str, null);
        b++;
      } 
    } 
  }
  
  public boolean checkColumns() {
    if (this.columns != null)
      return true; 
    throw new IllegalArgumentException("columns must not be null");
  }
  
  public Object getValue(String paramString) {
    return this.map.get(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\ColumnsValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
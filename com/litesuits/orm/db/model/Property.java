package com.litesuits.orm.db.model;

import com.litesuits.orm.db.utils.DataUtil;
import java.io.Serializable;
import java.lang.reflect.Field;

public class Property implements Serializable {
  private static final long serialVersionUID = 1542861322620643038L;
  
  public int classType = 0;
  
  public String column;
  
  public Field field;
  
  public Property(String paramString, Field paramField) {
    this.column = paramString;
    this.field = paramField;
    if (this.classType <= 0)
      this.classType = DataUtil.getFieldClassType(paramField); 
  }
  
  public Property(String paramString, Field paramField, int paramInt) {
    this.column = paramString;
    this.field = paramField;
    if (paramInt <= 0)
      this.classType = DataUtil.getFieldClassType(paramField); 
    this.classType = paramInt;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Property{column='");
    stringBuilder.append(this.column);
    stringBuilder.append('\'');
    stringBuilder.append(", field=");
    stringBuilder.append(this.field);
    stringBuilder.append(", classType=");
    stringBuilder.append(this.classType);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
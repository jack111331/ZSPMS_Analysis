package com.litesuits.orm.db.model;

import com.litesuits.orm.db.enums.AssignType;
import java.lang.reflect.Field;

public class Primarykey extends Property {
  private static final long serialVersionUID = 2304252505493855513L;
  
  public AssignType assign;
  
  public Primarykey(Property paramProperty, AssignType paramAssignType) {
    this(paramProperty.column, paramProperty.field, paramProperty.classType, paramAssignType);
  }
  
  public Primarykey(String paramString, Field paramField, int paramInt, AssignType paramAssignType) {
    super(paramString, paramField, paramInt);
    this.assign = paramAssignType;
  }
  
  public boolean isAssignedByMyself() {
    boolean bool;
    if (this.assign == AssignType.BY_MYSELF) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isAssignedBySystem() {
    boolean bool;
    if (this.assign == AssignType.AUTO_INCREMENT) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\Primarykey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
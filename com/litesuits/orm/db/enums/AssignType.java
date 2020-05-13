package com.litesuits.orm.db.enums;

public enum AssignType {
  AUTO_INCREMENT, BY_MYSELF;
  
  static {
    AUTO_INCREMENT = new AssignType("AUTO_INCREMENT", 1);
    $VALUES = new AssignType[] { BY_MYSELF, AUTO_INCREMENT };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\enums\AssignType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
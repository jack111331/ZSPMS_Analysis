package com.litesuits.orm.db.model;

public class RelationKey {
  public String key1;
  
  public String key2;
  
  public boolean isOK() {
    boolean bool;
    if (this.key1 != null && this.key2 != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\RelationKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
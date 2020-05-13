package com.litesuits.orm.db.model;

import com.litesuits.orm.db.annotation.Column;
import java.io.Serializable;

public class SQLiteColumn implements Serializable {
  private static final long serialVersionUID = 8822000632819424751L;
  
  @Column("cid")
  public long cid;
  
  @Column("dflt_value")
  public String dflt_value;
  
  @Column("name")
  public String name;
  
  @Column("notnull")
  public short notnull;
  
  @Column("pk")
  public short pk;
  
  @Column("type")
  public String type;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Column [cid=");
    stringBuilder.append(this.cid);
    stringBuilder.append(", name=");
    stringBuilder.append(this.name);
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", notnull=");
    stringBuilder.append(this.notnull);
    stringBuilder.append(", dflt_value=");
    stringBuilder.append(this.dflt_value);
    stringBuilder.append(", pk=");
    stringBuilder.append(this.pk);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\SQLiteColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
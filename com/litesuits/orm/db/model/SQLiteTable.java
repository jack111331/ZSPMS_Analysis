package com.litesuits.orm.db.model;

import com.litesuits.orm.db.annotation.Column;
import java.io.Serializable;
import java.util.HashMap;

public class SQLiteTable implements Serializable {
  private static final long serialVersionUID = 6706520684759700566L;
  
  public HashMap<String, Integer> columns;
  
  public boolean isTableChecked;
  
  @Column("name")
  public String name;
  
  @Column("rootpage")
  public long rootpage;
  
  @Column("sql")
  public String sql;
  
  @Column("tbl_name")
  public String tbl_name;
  
  @Column("type")
  public String type;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SQLiteTable{type='");
    stringBuilder.append(this.type);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", tbl_name='");
    stringBuilder.append(this.tbl_name);
    stringBuilder.append('\'');
    stringBuilder.append(", rootpage=");
    stringBuilder.append(this.rootpage);
    stringBuilder.append(", sql='");
    stringBuilder.append(this.sql);
    stringBuilder.append('\'');
    stringBuilder.append(", isTableChecked=");
    stringBuilder.append(this.isTableChecked);
    stringBuilder.append(", columns=");
    stringBuilder.append(this.columns);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\SQLiteTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
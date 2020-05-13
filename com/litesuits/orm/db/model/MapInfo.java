package com.litesuits.orm.db.model;

import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.SQLStatement;
import java.util.ArrayList;

public class MapInfo {
  public ArrayList<SQLStatement> delOldRelationSQL;
  
  public ArrayList<SQLStatement> mapNewRelationSQL;
  
  public ArrayList<MapTable> tableList;
  
  public boolean addDelOldRelationSQL(SQLStatement paramSQLStatement) {
    if (this.delOldRelationSQL == null)
      this.delOldRelationSQL = new ArrayList<SQLStatement>(); 
    return this.delOldRelationSQL.add(paramSQLStatement);
  }
  
  public boolean addNewRelationSQL(SQLStatement paramSQLStatement) {
    if (this.mapNewRelationSQL == null)
      this.mapNewRelationSQL = new ArrayList<SQLStatement>(); 
    return this.mapNewRelationSQL.add(paramSQLStatement);
  }
  
  public boolean addNewRelationSQL(ArrayList<SQLStatement> paramArrayList) {
    if (this.mapNewRelationSQL == null)
      this.mapNewRelationSQL = new ArrayList<SQLStatement>(); 
    return this.mapNewRelationSQL.addAll(paramArrayList);
  }
  
  public boolean addTable(MapTable paramMapTable) {
    if (paramMapTable.name == null)
      return false; 
    if (this.tableList == null)
      this.tableList = new ArrayList<MapTable>(); 
    return this.tableList.add(paramMapTable);
  }
  
  public boolean isEmpty() {
    return (Checker.isEmpty(this.tableList) || (Checker.isEmpty(this.mapNewRelationSQL) && Checker.isEmpty(this.delOldRelationSQL)));
  }
  
  public static class MapTable {
    public String column1;
    
    public String column2;
    
    public String name;
    
    public MapTable(String param1String1, String param1String2, String param1String3) {
      this.name = param1String1;
      this.column1 = param1String2;
      this.column2 = param1String3;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\MapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
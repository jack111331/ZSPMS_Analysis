package com.litesuits.orm.db.enums;

public enum Strategy {
  ABORT,
  FAIL,
  IGNORE,
  REPLACE,
  ROLLBACK(" ROLLBACK ");
  
  public String sql;
  
  static {
    ABORT = new Strategy("ABORT", 1, " ABORT ");
    FAIL = new Strategy("FAIL", 2, " FAIL ");
    IGNORE = new Strategy("IGNORE", 3, " IGNORE ");
    REPLACE = new Strategy("REPLACE", 4, " REPLACE ");
    $VALUES = new Strategy[] { ROLLBACK, ABORT, FAIL, IGNORE, REPLACE };
  }
  
  Strategy(String paramString1) {
    this.sql = paramString1;
  }
  
  public String getSql() {
    return this.sql;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\enums\Strategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
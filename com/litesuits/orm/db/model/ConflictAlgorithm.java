package com.litesuits.orm.db.model;

public enum ConflictAlgorithm {
  Abort,
  Fail,
  Ignore,
  None(" "),
  Replace(" "),
  Rollback(" OR ROLLBACK ");
  
  private String algorithm;
  
  static {
    Abort = new ConflictAlgorithm("Abort", 2, " OR ABORT ");
    Fail = new ConflictAlgorithm("Fail", 3, " OR FAIL ");
    Ignore = new ConflictAlgorithm("Ignore", 4, " OR IGNORE ");
    Replace = new ConflictAlgorithm("Replace", 5, " OR REPLACE ");
    $VALUES = new ConflictAlgorithm[] { None, Rollback, Abort, Fail, Ignore, Replace };
  }
  
  ConflictAlgorithm(String paramString1) {
    this.algorithm = paramString1;
  }
  
  public String getAlgorithm() {
    return this.algorithm;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\ConflictAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.litesuits.orm.db.enums;

public enum Relation {
  ManyToMany, ManyToOne, OneToMany, OneToOne;
  
  static {
    ManyToOne = new Relation("ManyToOne", 2);
    OneToOne = new Relation("OneToOne", 3);
    $VALUES = new Relation[] { ManyToMany, OneToMany, ManyToOne, OneToOne };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\enums\Relation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
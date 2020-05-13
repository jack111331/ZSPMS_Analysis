package com.litesuits.orm.db.model;

import com.litesuits.orm.db.enums.Relation;
import java.lang.reflect.Field;

public class MapProperty extends Property {
  public static final String PRIMARYKEY = " PRIMARY KEY ";
  
  private static final long serialVersionUID = 1641409866866426637L;
  
  public Relation relation;
  
  public MapProperty(Property paramProperty, Relation paramRelation) {
    this(paramProperty.column, paramProperty.field, paramRelation);
  }
  
  private MapProperty(String paramString, Field paramField, Relation paramRelation) {
    super(paramString, paramField);
    this.relation = paramRelation;
  }
  
  public boolean isToMany() {
    return (this.relation == Relation.ManyToMany || this.relation == Relation.OneToMany);
  }
  
  public boolean isToOne() {
    return (this.relation == Relation.ManyToOne || this.relation == Relation.OneToOne);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\MapProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
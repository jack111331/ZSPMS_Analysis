package com.litesuits.orm.db.model;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EntityTable implements Serializable {
  private static final long serialVersionUID = 421721084878061123L;
  
  public Class claxx;
  
  public Primarykey key;
  
  public ArrayList<MapProperty> mappingList;
  
  public String name;
  
  public LinkedHashMap<String, Property> pmap;
  
  public void addMapping(MapProperty paramMapProperty) {
    if (this.mappingList == null)
      this.mappingList = new ArrayList<MapProperty>(); 
    this.mappingList.add(paramMapProperty);
  }
  
  public Annotation getAnnotation(Class paramClass) {
    return (Annotation)((this.claxx != null) ? this.claxx.getAnnotation(paramClass) : null);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("EntityTable{claxx=");
    stringBuilder.append(this.claxx);
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", key=");
    stringBuilder.append(this.key);
    stringBuilder.append(", pmap=");
    stringBuilder.append(this.pmap);
    stringBuilder.append(", mappingList=");
    stringBuilder.append(this.mappingList);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\model\EntityTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
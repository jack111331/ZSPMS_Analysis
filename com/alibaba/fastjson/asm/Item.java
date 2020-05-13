package com.alibaba.fastjson.asm;

final class Item {
  int hashCode;
  
  int index;
  
  int intVal;
  
  long longVal;
  
  Item next;
  
  String strVal1;
  
  String strVal2;
  
  String strVal3;
  
  int type;
  
  Item() {}
  
  Item(int paramInt, Item paramItem) {
    this.index = paramInt;
    this.type = paramItem.type;
    this.intVal = paramItem.intVal;
    this.longVal = paramItem.longVal;
    this.strVal1 = paramItem.strVal1;
    this.strVal2 = paramItem.strVal2;
    this.strVal3 = paramItem.strVal3;
    this.hashCode = paramItem.hashCode;
  }
  
  boolean isEqualTo(Item paramItem) {
    int i = this.type;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    null = true;
    switch (i) {
      default:
        if (paramItem.strVal1.equals(this.strVal1) && paramItem.strVal2.equals(this.strVal2) && paramItem.strVal3.equals(this.strVal3))
          return bool3; 
        break;
      case 12:
        if (!paramItem.strVal1.equals(this.strVal1) || !paramItem.strVal2.equals(this.strVal2))
          null = false; 
        return null;
      case 5:
      case 6:
      case 15:
        if (paramItem.longVal == this.longVal) {
          null = bool1;
        } else {
          null = false;
        } 
        return null;
      case 3:
      case 4:
        if (paramItem.intVal == this.intVal) {
          null = bool2;
        } else {
          null = false;
        } 
        return null;
      case 1:
      case 7:
      case 8:
      case 13:
        return paramItem.strVal1.equals(this.strVal1);
    } 
    return false;
  }
  
  void set(int paramInt) {
    this.type = 3;
    this.intVal = paramInt;
    this.hashCode = Integer.MAX_VALUE & this.type + paramInt;
  }
  
  void set(int paramInt, String paramString1, String paramString2, String paramString3) {
    this.type = paramInt;
    this.strVal1 = paramString1;
    this.strVal2 = paramString2;
    this.strVal3 = paramString3;
    switch (paramInt) {
      default:
        this.hashCode = paramInt + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode() & Integer.MAX_VALUE;
        return;
      case 12:
        this.hashCode = paramInt + paramString1.hashCode() * paramString2.hashCode() & Integer.MAX_VALUE;
        return;
      case 1:
      case 7:
      case 8:
      case 13:
        break;
    } 
    this.hashCode = paramInt + paramString1.hashCode() & Integer.MAX_VALUE;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\asm\Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ParameterizedTypeImpl implements ParameterizedType {
  private final Type[] actualTypeArguments;
  
  private final Type ownerType;
  
  private final Type rawType;
  
  public ParameterizedTypeImpl(Type[] paramArrayOfType, Type paramType1, Type paramType2) {
    this.actualTypeArguments = paramArrayOfType;
    this.ownerType = paramType1;
    this.rawType = paramType2;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!Arrays.equals((Object[])this.actualTypeArguments, (Object[])((ParameterizedTypeImpl)paramObject).actualTypeArguments))
      return false; 
    if ((this.ownerType != null) ? !this.ownerType.equals(((ParameterizedTypeImpl)paramObject).ownerType) : (((ParameterizedTypeImpl)paramObject).ownerType != null))
      return false; 
    if (this.rawType != null) {
      bool = this.rawType.equals(((ParameterizedTypeImpl)paramObject).rawType);
    } else if (((ParameterizedTypeImpl)paramObject).rawType != null) {
      bool = false;
    } 
    return bool;
  }
  
  public Type[] getActualTypeArguments() {
    return this.actualTypeArguments;
  }
  
  public Type getOwnerType() {
    return this.ownerType;
  }
  
  public Type getRawType() {
    return this.rawType;
  }
  
  public int hashCode() {
    byte b1;
    byte b2;
    Type[] arrayOfType = this.actualTypeArguments;
    int i = 0;
    if (arrayOfType != null) {
      b1 = Arrays.hashCode((Object[])this.actualTypeArguments);
    } else {
      b1 = 0;
    } 
    if (this.ownerType != null) {
      b2 = this.ownerType.hashCode();
    } else {
      b2 = 0;
    } 
    if (this.rawType != null)
      i = this.rawType.hashCode(); 
    return (b1 * 31 + b2) * 31 + i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\ParameterizedTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
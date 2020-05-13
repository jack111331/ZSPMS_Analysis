package com.zz.sdk;

import java.util.HashMap;

public interface ParamChain {
  boolean add(String paramString, Object paramObject);
  
  boolean add(String paramString, Object paramObject, h paramh);
  
  void autoRelease();
  
  ParamChain containsKey(String paramString);
  
  h containsKeyOwn(String paramString);
  
  ParamChain containsKeyReverse(String paramString);
  
  void dumpOwn(ParamChain paramParamChain, boolean paramBoolean);
  
  ParamChain generateUnion();
  
  ParamChain generateUnion(String... paramVarArgs);
  
  Object get(Enum paramEnum);
  
  Object get(String paramString);
  
  Object get(String paramString, Class paramClass);
  
  String getAliasName();
  
  int getLevel();
  
  Object getOwned(String paramString);
  
  Object getOwned(String paramString, Class paramClass);
  
  ParamChain getParent();
  
  ParamChain getParent(String paramString);
  
  ParamChain getRoot();
  
  ParamChain grow();
  
  ParamChain grow(String paramString);
  
  ParamChain grow(HashMap paramHashMap);
  
  Object remove(String paramString);
  
  void reset();
  
  boolean setAliasName(String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\ParamChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
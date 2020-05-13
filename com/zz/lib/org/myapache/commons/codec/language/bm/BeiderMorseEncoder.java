package com.zz.lib.org.myapache.commons.codec.language.bm;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;

public class BeiderMorseEncoder implements StringEncoder {
  private PhoneticEngine engine = new PhoneticEngine(NameType.GENERIC, RuleType.APPROX, true);
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("BeiderMorseEncoder encode parameter is not of type String"); 
    return encode((String)paramObject);
  }
  
  public String encode(String paramString) throws EncoderException {
    return (paramString == null) ? null : this.engine.encode(paramString);
  }
  
  public NameType getNameType() {
    return this.engine.getNameType();
  }
  
  public RuleType getRuleType() {
    return this.engine.getRuleType();
  }
  
  public boolean isConcat() {
    return this.engine.isConcat();
  }
  
  public void setConcat(boolean paramBoolean) {
    this.engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), paramBoolean);
  }
  
  public void setNameType(NameType paramNameType) {
    this.engine = new PhoneticEngine(paramNameType, this.engine.getRuleType(), this.engine.isConcat());
  }
  
  public void setRuleType(RuleType paramRuleType) {
    this.engine = new PhoneticEngine(this.engine.getNameType(), paramRuleType, this.engine.isConcat());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\bm\BeiderMorseEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
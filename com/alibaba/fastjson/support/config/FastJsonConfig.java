package com.alibaba.fastjson.support.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.nio.charset.Charset;
import java.util.Map;

public class FastJsonConfig {
  private Charset charset = Charset.forName("UTF-8");
  
  private Map<Class<?>, SerializeFilter> classSerializeFilters;
  
  private String dateFormat;
  
  private Feature[] features = new Feature[0];
  
  private ParserConfig parserConfig = new ParserConfig();
  
  private SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
  
  private SerializeFilter[] serializeFilters = new SerializeFilter[0];
  
  private SerializerFeature[] serializerFeatures = new SerializerFeature[0];
  
  protected boolean writeContentLength = true;
  
  public Charset getCharset() {
    return this.charset;
  }
  
  public Map<Class<?>, SerializeFilter> getClassSerializeFilters() {
    return this.classSerializeFilters;
  }
  
  public String getDateFormat() {
    return this.dateFormat;
  }
  
  public Feature[] getFeatures() {
    return this.features;
  }
  
  public ParserConfig getParserConfig() {
    return this.parserConfig;
  }
  
  public SerializeConfig getSerializeConfig() {
    return this.serializeConfig;
  }
  
  public SerializeFilter[] getSerializeFilters() {
    return this.serializeFilters;
  }
  
  public SerializerFeature[] getSerializerFeatures() {
    return this.serializerFeatures;
  }
  
  public boolean isWriteContentLength() {
    return this.writeContentLength;
  }
  
  public void setCharset(Charset paramCharset) {
    this.charset = paramCharset;
  }
  
  public void setClassSerializeFilters(Map<Class<?>, SerializeFilter> paramMap) {
    if (paramMap == null)
      return; 
    for (Map.Entry<Class<?>, SerializeFilter> entry : paramMap.entrySet())
      this.serializeConfig.addFilter((Class)entry.getKey(), (SerializeFilter)entry.getValue()); 
    this.classSerializeFilters = paramMap;
  }
  
  public void setDateFormat(String paramString) {
    this.dateFormat = paramString;
  }
  
  public void setFeatures(Feature... paramVarArgs) {
    this.features = paramVarArgs;
  }
  
  public void setParserConfig(ParserConfig paramParserConfig) {
    this.parserConfig = paramParserConfig;
  }
  
  public void setSerializeConfig(SerializeConfig paramSerializeConfig) {
    this.serializeConfig = paramSerializeConfig;
  }
  
  public void setSerializeFilters(SerializeFilter... paramVarArgs) {
    this.serializeFilters = paramVarArgs;
  }
  
  public void setSerializerFeatures(SerializerFeature... paramVarArgs) {
    this.serializerFeatures = paramVarArgs;
  }
  
  public void setWriteContentLength(boolean paramBoolean) {
    this.writeContentLength = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\config\FastJsonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
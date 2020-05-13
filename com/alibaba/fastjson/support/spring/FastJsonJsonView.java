package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FastJsonJsonView extends AbstractView {
  public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";
  
  @Deprecated
  protected Charset charset = Charset.forName("UTF-8");
  
  @Deprecated
  protected String dateFormat;
  
  private boolean disableCaching = true;
  
  private boolean extractValueFromSingleKeyModel = false;
  
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  @Deprecated
  protected SerializerFeature[] features = new SerializerFeature[0];
  
  @Deprecated
  protected SerializeFilter[] filters = new SerializeFilter[0];
  
  private Set<String> renderedAttributes;
  
  private boolean updateContentLength = true;
  
  public FastJsonJsonView() {
    setContentType("application/json;charset=UTF-8");
    setExposePathVariables(false);
  }
  
  protected Object filterModel(Map<String, Object> paramMap) {
    Set<String> set;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramMap.size());
    if (!CollectionUtils.isEmpty(this.renderedAttributes)) {
      set = this.renderedAttributes;
    } else {
      set = paramMap.keySet();
    } 
    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
      if (!(entry.getValue() instanceof org.springframework.validation.BindingResult) && set.contains(entry.getKey()))
        hashMap.put(entry.getKey(), entry.getValue()); 
    } 
    if (this.extractValueFromSingleKeyModel && hashMap.size() == 1) {
      Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
      if (iterator.hasNext())
        return ((Map.Entry)iterator.next()).getValue(); 
    } 
    return hashMap;
  }
  
  @Deprecated
  public Charset getCharset() {
    return this.fastJsonConfig.getCharset();
  }
  
  @Deprecated
  public String getDateFormat() {
    return this.fastJsonConfig.getDateFormat();
  }
  
  public FastJsonConfig getFastJsonConfig() {
    return this.fastJsonConfig;
  }
  
  @Deprecated
  public SerializerFeature[] getFeatures() {
    return this.fastJsonConfig.getSerializerFeatures();
  }
  
  @Deprecated
  public SerializeFilter[] getFilters() {
    return this.fastJsonConfig.getSerializeFilters();
  }
  
  public boolean isExtractValueFromSingleKeyModel() {
    return this.extractValueFromSingleKeyModel;
  }
  
  protected void prepareResponse(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) {
    setResponseContentType(paramHttpServletRequest, paramHttpServletResponse);
    paramHttpServletResponse.setCharacterEncoding(this.fastJsonConfig.getCharset().name());
    if (this.disableCaching) {
      paramHttpServletResponse.addHeader("Pragma", "no-cache");
      paramHttpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
      paramHttpServletResponse.addDateHeader("Expires", 1L);
    } 
  }
  
  protected void renderMergedOutputModel(Map<String, Object> paramMap, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws Exception {
    Object object = filterModel(paramMap);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), object, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
    if (this.updateContentLength)
      paramHttpServletResponse.setContentLength(i); 
    object = paramHttpServletResponse.getOutputStream();
    byteArrayOutputStream.writeTo((OutputStream)object);
    byteArrayOutputStream.close();
    object.flush();
  }
  
  @Deprecated
  public void setCharset(Charset paramCharset) {
    this.fastJsonConfig.setCharset(paramCharset);
  }
  
  @Deprecated
  public void setDateFormat(String paramString) {
    this.fastJsonConfig.setDateFormat(paramString);
  }
  
  public void setDisableCaching(boolean paramBoolean) {
    this.disableCaching = paramBoolean;
  }
  
  public void setExtractValueFromSingleKeyModel(boolean paramBoolean) {
    this.extractValueFromSingleKeyModel = paramBoolean;
  }
  
  public void setFastJsonConfig(FastJsonConfig paramFastJsonConfig) {
    this.fastJsonConfig = paramFastJsonConfig;
  }
  
  @Deprecated
  public void setFeatures(SerializerFeature... paramVarArgs) {
    this.fastJsonConfig.setSerializerFeatures(paramVarArgs);
  }
  
  @Deprecated
  public void setFilters(SerializeFilter... paramVarArgs) {
    this.fastJsonConfig.setSerializeFilters(paramVarArgs);
  }
  
  public void setRenderedAttributes(Set<String> paramSet) {
    this.renderedAttributes = paramSet;
  }
  
  @Deprecated
  public void setSerializerFeature(SerializerFeature... paramVarArgs) {
    this.fastJsonConfig.setSerializerFeatures(paramVarArgs);
  }
  
  public void setUpdateContentLength(boolean paramBoolean) {
    this.updateContentLength = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonJsonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonpHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {
  private static final byte[] JSONP_FUNCTION_PREFIX_BYTES = "/**/".getBytes(IOUtils.UTF8);
  
  private static final byte[] JSONP_FUNCTION_SUFFIX_BYTES = ");".getBytes(IOUtils.UTF8);
  
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  public FastJsonpHttpMessageConverter4() {
    super(MediaType.ALL);
  }
  
  public FastJsonConfig getFastJsonConfig() {
    return this.fastJsonConfig;
  }
  
  public Object read(Type paramType, Class<?> paramClass, HttpInputMessage paramHttpInputMessage) throws IOException, HttpMessageNotReadableException {
    return JSON.parseObject(paramHttpInputMessage.getBody(), this.fastJsonConfig.getCharset(), paramType, this.fastJsonConfig.getFeatures());
  }
  
  protected Object readInternal(Class<? extends Object> paramClass, HttpInputMessage paramHttpInputMessage) throws IOException, HttpMessageNotReadableException {
    return JSON.parseObject(paramHttpInputMessage.getBody(), this.fastJsonConfig.getCharset(), paramClass, this.fastJsonConfig.getFeatures());
  }
  
  public void setFastJsonConfig(FastJsonConfig paramFastJsonConfig) {
    this.fastJsonConfig = paramFastJsonConfig;
  }
  
  protected boolean supports(Class<?> paramClass) {
    return true;
  }
  
  protected void writeInternal(Object paramObject, Type paramType, HttpOutputMessage paramHttpOutputMessage) throws IOException, HttpMessageNotWritableException {
    Object object;
    HttpHeaders httpHeaders = paramHttpOutputMessage.getHeaders();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = writePrefix(byteArrayOutputStream, paramObject);
    if (paramObject instanceof MappingFastJsonValue) {
      object = ((MappingFastJsonValue)paramObject).getValue();
    } else {
      object = paramObject;
    } 
    int j = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), object, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
    int k = writeSuffix(byteArrayOutputStream, paramObject);
    if (this.fastJsonConfig.isWriteContentLength())
      httpHeaders.setContentLength((i + j + k)); 
    byteArrayOutputStream.writeTo(paramHttpOutputMessage.getBody());
    byteArrayOutputStream.close();
  }
  
  protected int writePrefix(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject) throws IOException {
    if (paramObject instanceof MappingFastJsonValue) {
      paramObject = ((MappingFastJsonValue)paramObject).getJsonpFunction();
    } else {
      paramObject = null;
    } 
    int i = 0;
    if (paramObject != null) {
      paramByteArrayOutputStream.write(JSONP_FUNCTION_PREFIX_BYTES);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)paramObject);
      stringBuilder.append("(");
      paramObject = stringBuilder.toString().getBytes(IOUtils.UTF8);
      paramByteArrayOutputStream.write((byte[])paramObject);
      i = 0 + JSONP_FUNCTION_PREFIX_BYTES.length + paramObject.length;
    } 
    return i;
  }
  
  protected int writeSuffix(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject) throws IOException {
    if (paramObject instanceof MappingFastJsonValue) {
      paramObject = ((MappingFastJsonValue)paramObject).getJsonpFunction();
    } else {
      paramObject = null;
    } 
    int i = 0;
    if (paramObject != null) {
      paramByteArrayOutputStream.write(JSONP_FUNCTION_SUFFIX_BYTES);
      i = 0 + JSONP_FUNCTION_SUFFIX_BYTES.length;
    } 
    return i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonpHttpMessageConverter4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
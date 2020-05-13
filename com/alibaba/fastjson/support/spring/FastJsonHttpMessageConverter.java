package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
  private Charset charset = Charset.forName("UTF-8");
  
  @Deprecated
  protected String dateFormat;
  
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  @Deprecated
  protected SerializerFeature[] features = new SerializerFeature[0];
  
  @Deprecated
  protected SerializeFilter[] filters = new SerializeFilter[0];
  
  public FastJsonHttpMessageConverter() {
    super(MediaType.ALL);
  }
  
  @Deprecated
  public void addSerializeFilter(SerializeFilter paramSerializeFilter) {
    if (paramSerializeFilter == null)
      return; 
    int i = (this.fastJsonConfig.getSerializeFilters()).length;
    SerializeFilter[] arrayOfSerializeFilter = new SerializeFilter[i + 1];
    System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, arrayOfSerializeFilter, 0, i);
    arrayOfSerializeFilter[arrayOfSerializeFilter.length - 1] = paramSerializeFilter;
    this.fastJsonConfig.setSerializeFilters(arrayOfSerializeFilter);
  }
  
  public boolean canRead(Type paramType, Class<?> paramClass, MediaType paramMediaType) {
    return canRead(paramClass, paramMediaType);
  }
  
  public boolean canWrite(Type paramType, Class<?> paramClass, MediaType paramMediaType) {
    return canWrite(paramClass, paramMediaType);
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
  
  public Object read(Type paramType, Class<?> paramClass, HttpInputMessage paramHttpInputMessage) throws IOException, HttpMessageNotReadableException {
    return JSON.parseObject(paramHttpInputMessage.getBody(), this.fastJsonConfig.getCharset(), paramType, this.fastJsonConfig.getFeatures());
  }
  
  protected Object readInternal(Class<? extends Object> paramClass, HttpInputMessage paramHttpInputMessage) throws IOException, HttpMessageNotReadableException {
    return JSON.parseObject(paramHttpInputMessage.getBody(), this.fastJsonConfig.getCharset(), paramClass, this.fastJsonConfig.getFeatures());
  }
  
  @Deprecated
  public void setCharset(Charset paramCharset) {
    this.fastJsonConfig.setCharset(paramCharset);
  }
  
  @Deprecated
  public void setDateFormat(String paramString) {
    this.fastJsonConfig.setDateFormat(paramString);
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
  
  protected boolean supports(Class<?> paramClass) {
    return true;
  }
  
  public void write(Object paramObject, Type paramType, MediaType paramMediaType, HttpOutputMessage paramHttpOutputMessage) throws IOException, HttpMessageNotWritableException {
    // Byte code:
    //   0: aload #4
    //   2: invokeinterface getHeaders : ()Lorg/springframework/http/HttpHeaders;
    //   7: astore #5
    //   9: aload #5
    //   11: invokevirtual getContentType : ()Lorg/springframework/http/MediaType;
    //   14: ifnonnull -> 53
    //   17: aload_3
    //   18: ifnull -> 37
    //   21: aload_3
    //   22: invokevirtual isWildcardType : ()Z
    //   25: ifne -> 37
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: invokevirtual isWildcardSubtype : ()Z
    //   34: ifeq -> 43
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual getDefaultContentType : (Ljava/lang/Object;)Lorg/springframework/http/MediaType;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull -> 53
    //   47: aload #5
    //   49: aload_2
    //   50: invokevirtual setContentType : (Lorg/springframework/http/MediaType;)V
    //   53: aload #5
    //   55: invokevirtual getContentLength : ()J
    //   58: ldc2_w -1
    //   61: lcmp
    //   62: ifne -> 89
    //   65: aload_0
    //   66: aload_1
    //   67: aload #5
    //   69: invokevirtual getContentType : ()Lorg/springframework/http/MediaType;
    //   72: invokevirtual getContentLength : (Ljava/lang/Object;Lorg/springframework/http/MediaType;)Ljava/lang/Long;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull -> 89
    //   80: aload #5
    //   82: aload_2
    //   83: invokevirtual longValue : ()J
    //   86: invokevirtual setContentLength : (J)V
    //   89: aload_0
    //   90: aload_1
    //   91: aload #4
    //   93: invokevirtual writeInternal : (Ljava/lang/Object;Lorg/springframework/http/HttpOutputMessage;)V
    //   96: aload #4
    //   98: invokeinterface getBody : ()Ljava/io/OutputStream;
    //   103: invokevirtual flush : ()V
    //   106: return
  }
  
  protected void writeInternal(Object paramObject, HttpOutputMessage paramHttpOutputMessage) throws IOException, HttpMessageNotWritableException {
    int i;
    HttpHeaders httpHeaders = paramHttpOutputMessage.getHeaders();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    if (paramObject != null && "com.fasterxml.jackson.databind.node.ObjectNode".equals(paramObject.getClass().getName())) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      paramObject = paramObject.toString();
      paramHttpOutputMessage.getBody().write(paramObject.getBytes());
      if (this.fastJsonConfig.isWriteContentLength())
        httpHeaders.setContentLength(paramObject.length()); 
    } else {
      i = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), paramObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
      if (this.fastJsonConfig.isWriteContentLength())
        httpHeaders.setContentLength(i); 
      byteArrayOutputStream.writeTo(paramHttpOutputMessage.getBody());
    } 
    byteArrayOutputStream.close();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonHttpMessageConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
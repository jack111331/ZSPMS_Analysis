package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  public FastJsonHttpMessageConverter4() {
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
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface getHeaders : ()Lorg/springframework/http/HttpHeaders;
    //   6: astore #4
    //   8: new java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #5
    //   17: new java/util/ArrayList
    //   20: dup
    //   21: aload_0
    //   22: getfield fastJsonConfig : Lcom/alibaba/fastjson/support/config/FastJsonConfig;
    //   25: invokevirtual getSerializeFilters : ()[Lcom/alibaba/fastjson/serializer/SerializeFilter;
    //   28: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   31: invokespecial <init> : (Ljava/util/Collection;)V
    //   34: astore #6
    //   36: aload_1
    //   37: astore_2
    //   38: aload_1
    //   39: instanceof com/alibaba/fastjson/support/spring/FastJsonContainer
    //   42: ifeq -> 70
    //   45: aload_1
    //   46: checkcast com/alibaba/fastjson/support/spring/FastJsonContainer
    //   49: astore_1
    //   50: aload #6
    //   52: aload_1
    //   53: invokevirtual getFilters : ()Lcom/alibaba/fastjson/support/spring/PropertyPreFilters;
    //   56: invokevirtual getFilters : ()Ljava/util/List;
    //   59: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   64: pop
    //   65: aload_1
    //   66: invokevirtual getValue : ()Ljava/lang/Object;
    //   69: astore_2
    //   70: aload #6
    //   72: invokeinterface size : ()I
    //   77: anewarray com/alibaba/fastjson/serializer/SerializeFilter
    //   80: astore_1
    //   81: aload #5
    //   83: aload_0
    //   84: getfield fastJsonConfig : Lcom/alibaba/fastjson/support/config/FastJsonConfig;
    //   87: invokevirtual getCharset : ()Ljava/nio/charset/Charset;
    //   90: aload_2
    //   91: aload_0
    //   92: getfield fastJsonConfig : Lcom/alibaba/fastjson/support/config/FastJsonConfig;
    //   95: invokevirtual getSerializeConfig : ()Lcom/alibaba/fastjson/serializer/SerializeConfig;
    //   98: aload #6
    //   100: aload_1
    //   101: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   106: checkcast [Lcom/alibaba/fastjson/serializer/SerializeFilter;
    //   109: aload_0
    //   110: getfield fastJsonConfig : Lcom/alibaba/fastjson/support/config/FastJsonConfig;
    //   113: invokevirtual getDateFormat : ()Ljava/lang/String;
    //   116: getstatic com/alibaba/fastjson/JSON.DEFAULT_GENERATE_FEATURE : I
    //   119: aload_0
    //   120: getfield fastJsonConfig : Lcom/alibaba/fastjson/support/config/FastJsonConfig;
    //   123: invokevirtual getSerializerFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   126: invokestatic writeJSONString : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;Ljava/lang/Object;Lcom/alibaba/fastjson/serializer/SerializeConfig;[Lcom/alibaba/fastjson/serializer/SerializeFilter;Ljava/lang/String;I[Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   129: istore #7
    //   131: aload_0
    //   132: getfield fastJsonConfig : Lcom/alibaba/fastjson/support/config/FastJsonConfig;
    //   135: invokevirtual isWriteContentLength : ()Z
    //   138: ifeq -> 149
    //   141: aload #4
    //   143: iload #7
    //   145: i2l
    //   146: invokevirtual setContentLength : (J)V
    //   149: aload #5
    //   151: aload_3
    //   152: invokeinterface getBody : ()Ljava/io/OutputStream;
    //   157: invokevirtual writeTo : (Ljava/io/OutputStream;)V
    //   160: aload #5
    //   162: invokevirtual close : ()V
    //   165: return
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonHttpMessageConverter4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
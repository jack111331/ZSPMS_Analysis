package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class Retrofit2ConverterFactory extends Converter.Factory {
  private static final Feature[] EMPTY_SERIALIZER_FEATURES;
  
  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
  
  private int featureValues = JSON.DEFAULT_PARSER_FEATURE;
  
  private Feature[] features;
  
  private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
  
  private SerializeConfig serializeConfig;
  
  private SerializerFeature[] serializerFeatures;
  
  static {
    EMPTY_SERIALIZER_FEATURES = new Feature[0];
  }
  
  public ParserConfig getParserConfig() {
    return this.parserConfig;
  }
  
  public int getParserFeatureValues() {
    return this.featureValues;
  }
  
  public Feature[] getParserFeatures() {
    return this.features;
  }
  
  public SerializeConfig getSerializeConfig() {
    return this.serializeConfig;
  }
  
  public SerializerFeature[] getSerializerFeatures() {
    return this.serializerFeatures;
  }
  
  public Converter<?, RequestBody> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit) {
    return new RequestBodyConverter();
  }
  
  public Converter<ResponseBody, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit) {
    return new ResponseBodyConverter(paramType);
  }
  
  public Retrofit2ConverterFactory setParserConfig(ParserConfig paramParserConfig) {
    this.parserConfig = paramParserConfig;
    return this;
  }
  
  public Retrofit2ConverterFactory setParserFeatureValues(int paramInt) {
    this.featureValues = paramInt;
    return this;
  }
  
  public Retrofit2ConverterFactory setParserFeatures(Feature[] paramArrayOfFeature) {
    this.features = paramArrayOfFeature;
    return this;
  }
  
  public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig paramSerializeConfig) {
    this.serializeConfig = paramSerializeConfig;
    return this;
  }
  
  public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] paramArrayOfSerializerFeature) {
    this.serializerFeatures = paramArrayOfSerializerFeature;
    return this;
  }
  
  final class RequestBodyConverter<T> implements Converter<T, RequestBody> {
    public RequestBody convert(T param1T) throws IOException {
      SerializeConfig serializeConfig;
      SerializerFeature[] arrayOfSerializerFeature;
      if (Retrofit2ConverterFactory.this.serializeConfig == null) {
        serializeConfig = SerializeConfig.globalInstance;
      } else {
        serializeConfig = Retrofit2ConverterFactory.this.serializeConfig;
      } 
      if (Retrofit2ConverterFactory.this.serializerFeatures == null) {
        arrayOfSerializerFeature = SerializerFeature.EMPTY;
      } else {
        arrayOfSerializerFeature = Retrofit2ConverterFactory.this.serializerFeatures;
      } 
      byte[] arrayOfByte = JSON.toJSONBytes(param1T, serializeConfig, arrayOfSerializerFeature);
      return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, arrayOfByte);
    }
  }
  
  final class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Type type;
    
    ResponseBodyConverter(Type param1Type) {
      this.type = param1Type;
    }
    
    public T convert(ResponseBody param1ResponseBody) throws IOException {
      try {
        Feature[] arrayOfFeature;
        String str = param1ResponseBody.string();
        Type type = this.type;
        ParserConfig parserConfig = Retrofit2ConverterFactory.this.parserConfig;
        int i = Retrofit2ConverterFactory.this.featureValues;
        if (Retrofit2ConverterFactory.this.features != null) {
          arrayOfFeature = Retrofit2ConverterFactory.this.features;
        } else {
          arrayOfFeature = Retrofit2ConverterFactory.EMPTY_SERIALIZER_FEATURES;
        } 
        return (T)JSON.parseObject(str, type, parserConfig, i, arrayOfFeature);
      } finally {
        param1ResponseBody.close();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\retrofit\Retrofit2ConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
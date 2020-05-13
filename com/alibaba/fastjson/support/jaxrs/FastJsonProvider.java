package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Consumes({"*/*"})
@Produces({"*/*"})
@Provider
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
  @Deprecated
  protected Charset charset = Charset.forName("UTF-8");
  
  private Class<?>[] clazzes = null;
  
  @Deprecated
  protected String dateFormat;
  
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  @Deprecated
  protected SerializerFeature[] features = new SerializerFeature[0];
  
  @Deprecated
  protected SerializeFilter[] filters = new SerializeFilter[0];
  
  private boolean pretty;
  
  public FastJsonProvider() {}
  
  @Deprecated
  public FastJsonProvider(String paramString) {
    this.fastJsonConfig.setCharset(Charset.forName(paramString));
  }
  
  public FastJsonProvider(Class<?>[] paramArrayOfClass) {
    this.clazzes = paramArrayOfClass;
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
  
  public long getSize(Object paramObject, Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType) {
    return -1L;
  }
  
  protected boolean hasMatchingMediaType(MediaType paramMediaType) {
    boolean bool = true;
    if (paramMediaType != null) {
      String str = paramMediaType.getSubtype();
      boolean bool1 = bool;
      if (!"json".equalsIgnoreCase(str)) {
        bool1 = bool;
        if (!str.endsWith("+json")) {
          bool1 = bool;
          if (!"javascript".equals(str)) {
            bool1 = bool;
            if (!"x-javascript".equals(str)) {
              bool1 = bool;
              if (!"x-json".equals(str)) {
                bool1 = bool;
                if (!"x-www-form-urlencoded".equalsIgnoreCase(str))
                  if (str.endsWith("x-www-form-urlencoded")) {
                    bool1 = bool;
                  } else {
                    bool1 = false;
                  }  
              } 
            } 
          } 
        } 
      } 
      return bool1;
    } 
    return true;
  }
  
  public boolean isReadable(Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType) {
    return !hasMatchingMediaType(paramMediaType) ? false : isValidType(paramClass, paramArrayOfAnnotation);
  }
  
  protected boolean isValidType(Class<?> paramClass, Annotation[] paramArrayOfAnnotation) {
    if (paramClass == null)
      return false; 
    if (this.clazzes != null) {
      Class<?>[] arrayOfClass = this.clazzes;
      int i = arrayOfClass.length;
      for (byte b = 0; b < i; b++) {
        if (arrayOfClass[b] == paramClass)
          return true; 
      } 
      return false;
    } 
    return true;
  }
  
  public boolean isWriteable(Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType) {
    return !hasMatchingMediaType(paramMediaType) ? false : isValidType(paramClass, paramArrayOfAnnotation);
  }
  
  public Object readFrom(Class<Object> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType, MultivaluedMap<String, String> paramMultivaluedMap, InputStream paramInputStream) throws IOException, WebApplicationException {
    return JSON.parseObject(paramInputStream, this.fastJsonConfig.getCharset(), paramType, this.fastJsonConfig.getFeatures());
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
  
  public FastJsonProvider setPretty(boolean paramBoolean) {
    this.pretty = paramBoolean;
    return this;
  }
  
  public void writeTo(Object paramObject, Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType, MultivaluedMap<String, Object> paramMultivaluedMap, OutputStream paramOutputStream) throws IOException, WebApplicationException {
    SerializerFeature[] arrayOfSerializerFeature = this.fastJsonConfig.getSerializerFeatures();
    if (this.pretty) {
      if (arrayOfSerializerFeature == null) {
        arrayOfSerializerFeature = new SerializerFeature[1];
        arrayOfSerializerFeature[0] = SerializerFeature.PrettyFormat;
      } else {
        ArrayList<SerializerFeature> arrayList = new ArrayList(Arrays.asList((Object[])arrayOfSerializerFeature));
        arrayList.add(SerializerFeature.PrettyFormat);
        arrayOfSerializerFeature = arrayList.<SerializerFeature>toArray(arrayOfSerializerFeature);
      } 
      this.fastJsonConfig.setSerializerFeatures(arrayOfSerializerFeature);
    } 
    paramMultivaluedMap.add("Content-Length", String.valueOf(JSON.writeJSONString(paramOutputStream, this.fastJsonConfig.getCharset(), paramObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures())));
    paramOutputStream.flush();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\jaxrs\FastJsonProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
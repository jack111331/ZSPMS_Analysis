package com.alibaba.fastjson.support.spring;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class FastJsonpResponseBodyAdvice implements ResponseBodyAdvice<Object> {
  private static final Pattern CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
  
  public static final String[] DEFAULT_JSONP_QUERY_PARAM_NAMES = new String[] { "callback", "jsonp" };
  
  private final String[] jsonpQueryParamNames;
  
  public FastJsonpResponseBodyAdvice() {
    this.jsonpQueryParamNames = DEFAULT_JSONP_QUERY_PARAM_NAMES;
  }
  
  public FastJsonpResponseBodyAdvice(String... paramVarArgs) {
    Assert.isTrue(ObjectUtils.isEmpty((Object[])paramVarArgs) ^ true, "At least one query param name is required");
    this.jsonpQueryParamNames = paramVarArgs;
  }
  
  public Object beforeBodyWrite(Object paramObject, MethodParameter paramMethodParameter, MediaType paramMediaType, Class<? extends HttpMessageConverter<?>> paramClass, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse) {
    paramObject = getOrCreateContainer(paramObject);
    beforeBodyWriteInternal((MappingFastJsonValue)paramObject, paramMediaType, paramMethodParameter, paramServerHttpRequest, paramServerHttpResponse);
    return paramObject;
  }
  
  public void beforeBodyWriteInternal(MappingFastJsonValue paramMappingFastJsonValue, MediaType paramMediaType, MethodParameter paramMethodParameter, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse) {
    HttpServletRequest httpServletRequest = ((ServletServerHttpRequest)paramServerHttpRequest).getServletRequest();
    String[] arrayOfString = this.jsonpQueryParamNames;
    int i = arrayOfString.length;
    byte b = 0;
    while (b < i) {
      String str = httpServletRequest.getParameter(arrayOfString[b]);
      if (str == null || !isValidJsonpQueryParam(str)) {
        b++;
        continue;
      } 
      paramMediaType = getContentType(paramMediaType, paramServerHttpRequest, paramServerHttpResponse);
      paramServerHttpResponse.getHeaders().setContentType(paramMediaType);
      paramMappingFastJsonValue.setJsonpFunction(str);
    } 
  }
  
  protected MediaType getContentType(MediaType paramMediaType, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse) {
    return new MediaType("application", "javascript");
  }
  
  protected MappingFastJsonValue getOrCreateContainer(Object paramObject) {
    if (paramObject instanceof MappingFastJsonValue) {
      paramObject = paramObject;
    } else {
      paramObject = new MappingFastJsonValue(paramObject);
    } 
    return (MappingFastJsonValue)paramObject;
  }
  
  protected boolean isValidJsonpQueryParam(String paramString) {
    return CALLBACK_PARAM_PATTERN.matcher(paramString).matches();
  }
  
  public boolean supports(MethodParameter paramMethodParameter, Class<? extends HttpMessageConverter<?>> paramClass) {
    return FastJsonpHttpMessageConverter4.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonpResponseBodyAdvice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class FastJsonViewResponseBodyAdvice implements ResponseBodyAdvice<Object> {
  private FastJsonContainer getOrCreateContainer(Object paramObject) {
    if (paramObject instanceof FastJsonContainer) {
      paramObject = paramObject;
    } else {
      paramObject = new FastJsonContainer(paramObject);
    } 
    return (FastJsonContainer)paramObject;
  }
  
  public FastJsonContainer beforeBodyWrite(Object paramObject, MethodParameter paramMethodParameter, MediaType paramMediaType, Class<? extends HttpMessageConverter<?>> paramClass, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse) {
    paramObject = getOrCreateContainer(paramObject);
    beforeBodyWriteInternal((FastJsonContainer)paramObject, paramMediaType, paramMethodParameter, paramServerHttpRequest, paramServerHttpResponse);
    return (FastJsonContainer)paramObject;
  }
  
  protected void beforeBodyWriteInternal(FastJsonContainer paramFastJsonContainer, MediaType paramMediaType, MethodParameter paramMethodParameter, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse) {
    FastJsonView fastJsonView = (FastJsonView)paramMethodParameter.getMethodAnnotation(FastJsonView.class);
    FastJsonFilter[] arrayOfFastJsonFilter1 = fastJsonView.include();
    FastJsonFilter[] arrayOfFastJsonFilter2 = fastJsonView.exclude();
    PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
    int i = arrayOfFastJsonFilter1.length;
    byte b;
    for (b = 0; b < i; b++) {
      FastJsonFilter fastJsonFilter = arrayOfFastJsonFilter1[b];
      propertyPreFilters.addFilter(fastJsonFilter.clazz(), fastJsonFilter.props());
    } 
    i = arrayOfFastJsonFilter2.length;
    for (b = 0; b < i; b++) {
      FastJsonFilter fastJsonFilter = arrayOfFastJsonFilter2[b];
      propertyPreFilters.addFilter(fastJsonFilter.clazz(), new String[0]).addExcludes(fastJsonFilter.props());
    } 
    paramFastJsonContainer.setFilters(propertyPreFilters);
  }
  
  public boolean supports(MethodParameter paramMethodParameter, Class<? extends HttpMessageConverter<?>> paramClass) {
    boolean bool;
    if (FastJsonHttpMessageConverter4.class.isAssignableFrom(paramClass) && paramMethodParameter.hasMethodAnnotation(FastJsonView.class)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonViewResponseBodyAdvice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
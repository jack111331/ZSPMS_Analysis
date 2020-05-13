package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface JSONField {
  String[] alternateNames() default {};
  
  boolean deserialize() default true;
  
  Class<?> deserializeUsing() default Void.class;
  
  String format() default "";
  
  boolean jsonDirect() default false;
  
  String label() default "";
  
  String name() default "";
  
  int ordinal() default 0;
  
  Feature[] parseFeatures() default {};
  
  boolean serialize() default true;
  
  Class<?> serializeUsing() default Void.class;
  
  SerializerFeature[] serialzeFeatures() default {};
  
  boolean unwrapped() default false;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\annotation\JSONField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
public @interface RequiresPermission {
  String[] allOf() default {};
  
  String[] anyOf() default {};
  
  boolean conditional() default false;
  
  String value() default "";
  
  @Target({ElementType.FIELD})
  public static @interface Read {
    RequiresPermission value();
  }
  
  @Target({ElementType.FIELD})
  public static @interface Write {
    RequiresPermission value();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\annotation\RequiresPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
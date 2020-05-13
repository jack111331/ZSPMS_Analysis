package org.jar.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
public @interface RestrictTo {
  Scope[] value();
  
  public enum Scope {
    GROUP_ID, LIBRARY, LIBRARY_GROUP, SUBCLASSES, TESTS;
    
    static {
      SUBCLASSES = new Scope("SUBCLASSES", 4);
      $VALUES = new Scope[] { LIBRARY, LIBRARY_GROUP, GROUP_ID, TESTS, SUBCLASSES };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\annotation\RestrictTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
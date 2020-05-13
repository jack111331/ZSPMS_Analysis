package com.litesuits.orm.db.annotation;

import com.litesuits.orm.db.enums.Relation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Mapping {
  Relation value();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\annotation\Mapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
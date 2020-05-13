package com.litesuits.orm.db.annotation;

import com.litesuits.orm.db.enums.Strategy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Conflict {
  Strategy value();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\annotation\Conflict.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
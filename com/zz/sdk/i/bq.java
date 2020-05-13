package com.zz.sdk.i;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

final class bq extends Formatter {
  SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  public String format(LogRecord paramLogRecord) {
    String str = bc.b(paramLogRecord.getMessage(), "zz_sdk");
    return this.a.format(new Date(paramLogRecord.getMillis())) + "-" + paramLogRecord.getLevel() + ":" + str + "\n";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
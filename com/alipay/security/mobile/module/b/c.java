package com.alipay.security.mobile.module.b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class c implements FileFilter {
  c(b paramb) {}
  
  public final boolean accept(File paramFile) {
    return Pattern.matches("cpu[0-9]+", paramFile.getName());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
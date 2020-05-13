package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GeoResultParser extends ResultParser {
  private static final Pattern GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
  
  public GeoParsedResult parse(Result paramResult) {
    String str1 = getMassagedText(paramResult);
    Matcher matcher = GEO_URL_PATTERN.matcher(str1);
    if (!matcher.matches())
      return null; 
    String str2 = matcher.group(4);
    try {
      double d1 = Double.parseDouble(matcher.group(1));
      if (d1 > 90.0D || d1 < -90.0D)
        return null; 
      double d2 = Double.parseDouble(matcher.group(2));
      if (d2 > 180.0D || d2 < -180.0D)
        return null; 
      String str = matcher.group(3);
      double d3 = 0.0D;
      if (str != null) {
        d3 = Double.parseDouble(matcher.group(3));
        if (d3 < 0.0D)
          return null; 
      } 
      return new GeoParsedResult(d1, d2, d3, str2);
    } catch (NumberFormatException numberFormatException) {
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\GeoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
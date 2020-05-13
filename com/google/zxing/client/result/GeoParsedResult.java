package com.google.zxing.client.result;

public final class GeoParsedResult extends ParsedResult {
  private final double altitude;
  
  private final double latitude;
  
  private final double longitude;
  
  private final String query;
  
  GeoParsedResult(double paramDouble1, double paramDouble2, double paramDouble3, String paramString) {
    super(ParsedResultType.GEO);
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.altitude = paramDouble3;
    this.query = paramString;
  }
  
  public double getAltitude() {
    return this.altitude;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(20);
    stringBuilder.append(this.latitude);
    stringBuilder.append(", ");
    stringBuilder.append(this.longitude);
    if (this.altitude > 0.0D) {
      stringBuilder.append(", ");
      stringBuilder.append(this.altitude);
      stringBuilder.append('m');
    } 
    if (this.query != null) {
      stringBuilder.append(" (");
      stringBuilder.append(this.query);
      stringBuilder.append(')');
    } 
    return stringBuilder.toString();
  }
  
  public String getGeoURI() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("geo:");
    stringBuilder.append(this.latitude);
    stringBuilder.append(',');
    stringBuilder.append(this.longitude);
    if (this.altitude > 0.0D) {
      stringBuilder.append(',');
      stringBuilder.append(this.altitude);
    } 
    if (this.query != null) {
      stringBuilder.append('?');
      stringBuilder.append(this.query);
    } 
    return stringBuilder.toString();
  }
  
  public double getLatitude() {
    return this.latitude;
  }
  
  public double getLongitude() {
    return this.longitude;
  }
  
  public String getQuery() {
    return this.query;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\GeoParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
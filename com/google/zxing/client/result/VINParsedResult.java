package com.google.zxing.client.result;

public final class VINParsedResult extends ParsedResult {
  private final String countryCode;
  
  private final int modelYear;
  
  private final char plantCode;
  
  private final String sequentialNumber;
  
  private final String vehicleAttributes;
  
  private final String vehicleDescriptorSection;
  
  private final String vehicleIdentifierSection;
  
  private final String vin;
  
  private final String worldManufacturerID;
  
  public VINParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, char paramChar, String paramString7) {
    super(ParsedResultType.VIN);
    this.vin = paramString1;
    this.worldManufacturerID = paramString2;
    this.vehicleDescriptorSection = paramString3;
    this.vehicleIdentifierSection = paramString4;
    this.countryCode = paramString5;
    this.vehicleAttributes = paramString6;
    this.modelYear = paramInt;
    this.plantCode = (char)paramChar;
    this.sequentialNumber = paramString7;
  }
  
  public String getCountryCode() {
    return this.countryCode;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(50);
    stringBuilder.append(this.worldManufacturerID);
    stringBuilder.append(' ');
    stringBuilder.append(this.vehicleDescriptorSection);
    stringBuilder.append(' ');
    stringBuilder.append(this.vehicleIdentifierSection);
    stringBuilder.append('\n');
    if (this.countryCode != null) {
      stringBuilder.append(this.countryCode);
      stringBuilder.append(' ');
    } 
    stringBuilder.append(this.modelYear);
    stringBuilder.append(' ');
    stringBuilder.append(this.plantCode);
    stringBuilder.append(' ');
    stringBuilder.append(this.sequentialNumber);
    stringBuilder.append('\n');
    return stringBuilder.toString();
  }
  
  public int getModelYear() {
    return this.modelYear;
  }
  
  public char getPlantCode() {
    return this.plantCode;
  }
  
  public String getSequentialNumber() {
    return this.sequentialNumber;
  }
  
  public String getVIN() {
    return this.vin;
  }
  
  public String getVehicleAttributes() {
    return this.vehicleAttributes;
  }
  
  public String getVehicleDescriptorSection() {
    return this.vehicleDescriptorSection;
  }
  
  public String getVehicleIdentifierSection() {
    return this.vehicleIdentifierSection;
  }
  
  public String getWorldManufacturerID() {
    return this.worldManufacturerID;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\VINParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
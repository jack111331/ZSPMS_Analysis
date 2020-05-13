package org.jar.photo.zoom;

public class a implements b {
  public double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    paramDouble1 = paramDouble1 / paramDouble4 - 1.0D;
    return paramDouble3 * (paramDouble1 * paramDouble1 * paramDouble1 + 1.0D) + paramDouble2;
  }
  
  public double b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    paramDouble1 /= paramDouble4 / 2.0D;
    if (paramDouble1 < 1.0D) {
      paramDouble1 = paramDouble3 / 2.0D * paramDouble1 * paramDouble1 * paramDouble1;
      return paramDouble1 + paramDouble2;
    } 
    paramDouble3 /= 2.0D;
    paramDouble1 -= 2.0D;
    paramDouble1 = paramDouble3 * (paramDouble1 * paramDouble1 * paramDouble1 + 2.0D);
    return paramDouble1 + paramDouble2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
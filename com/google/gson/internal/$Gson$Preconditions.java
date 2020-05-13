package com.google.gson.internal;

public final class $Gson$Preconditions {
  public static void checkArgument(boolean paramBoolean) {
    if (!paramBoolean)
      throw new IllegalArgumentException(); 
  }
  
  public static <T> T checkNotNull(T paramT) {
    if (paramT == null)
      throw new NullPointerException(); 
    return paramT;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\internal\$Gson$Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
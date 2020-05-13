package com.google.gson.internal;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

public abstract class JsonReaderInternalAccess {
  public static JsonReaderInternalAccess INSTANCE;
  
  public abstract void promoteNameToValue(JsonReader paramJsonReader) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\internal\JsonReaderInternalAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
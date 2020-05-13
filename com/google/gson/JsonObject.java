package com.google.gson;

import com.google.gson.internal.;
import com.google.gson.internal.StringMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {
  private final StringMap<JsonElement> members = new StringMap();
  
  private JsonElement createJsonElement(Object paramObject) {
    return (JsonElement)((paramObject == null) ? JsonNull.INSTANCE : new JsonPrimitive(paramObject));
  }
  
  public void add(String paramString, JsonElement paramJsonElement) {
    JsonElement jsonElement = paramJsonElement;
    if (paramJsonElement == null)
      jsonElement = JsonNull.INSTANCE; 
    this.members.put((String).Gson.Preconditions.checkNotNull(paramString), jsonElement);
  }
  
  public void addProperty(String paramString, Boolean paramBoolean) {
    add(paramString, createJsonElement(paramBoolean));
  }
  
  public void addProperty(String paramString, Character paramCharacter) {
    add(paramString, createJsonElement(paramCharacter));
  }
  
  public void addProperty(String paramString, Number paramNumber) {
    add(paramString, createJsonElement(paramNumber));
  }
  
  public void addProperty(String paramString1, String paramString2) {
    add(paramString1, createJsonElement(paramString2));
  }
  
  public Set<Map.Entry<String, JsonElement>> entrySet() {
    return this.members.entrySet();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject == this || (paramObject instanceof JsonObject && ((JsonObject)paramObject).members.equals(this.members)));
  }
  
  public JsonElement get(String paramString) {
    if (this.members.containsKey(paramString)) {
      JsonElement jsonElement2 = (JsonElement)this.members.get(paramString);
      JsonElement jsonElement1 = jsonElement2;
      if (jsonElement2 == null)
        jsonElement1 = JsonNull.INSTANCE; 
      return jsonElement1;
    } 
    return null;
  }
  
  public JsonArray getAsJsonArray(String paramString) {
    return (JsonArray)this.members.get(paramString);
  }
  
  public JsonObject getAsJsonObject(String paramString) {
    return (JsonObject)this.members.get(paramString);
  }
  
  public JsonPrimitive getAsJsonPrimitive(String paramString) {
    return (JsonPrimitive)this.members.get(paramString);
  }
  
  public boolean has(String paramString) {
    return this.members.containsKey(paramString);
  }
  
  public int hashCode() {
    return this.members.hashCode();
  }
  
  public JsonElement remove(String paramString) {
    return (JsonElement)this.members.remove(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\JsonObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.StringMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
  public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
        return (param1TypeToken.getRawType() == Object.class) ? new ObjectTypeAdapter(param1Gson) : null;
      }
    };
  
  private final Gson gson;
  
  private ObjectTypeAdapter(Gson paramGson) {
    this.gson = paramGson;
  }
  
  public Object read(JsonReader paramJsonReader) throws IOException {
    ArrayList<Object> arrayList;
    StringMap<String, Object> stringMap;
    JsonToken jsonToken = paramJsonReader.peek();
    switch (jsonToken) {
      default:
        throw new IllegalStateException();
      case BEGIN_ARRAY:
        arrayList = new ArrayList();
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
          arrayList.add(read(paramJsonReader)); 
        paramJsonReader.endArray();
        return arrayList;
      case BEGIN_OBJECT:
        stringMap = new StringMap();
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext())
          stringMap.put(paramJsonReader.nextName(), read(paramJsonReader)); 
        paramJsonReader.endObject();
        return stringMap;
      case STRING:
        return paramJsonReader.nextString();
      case NUMBER:
        return Double.valueOf(paramJsonReader.nextDouble());
      case BOOLEAN:
        return Boolean.valueOf(paramJsonReader.nextBoolean());
      case NULL:
        break;
    } 
    paramJsonReader.nextNull();
    return null;
  }
  
  public void write(JsonWriter paramJsonWriter, Object paramObject) throws IOException {
    if (paramObject == null) {
      paramJsonWriter.nullValue();
      return;
    } 
    TypeAdapter typeAdapter = this.gson.getAdapter(paramObject.getClass());
    if (typeAdapter instanceof ObjectTypeAdapter) {
      paramJsonWriter.beginObject();
      paramJsonWriter.endObject();
      return;
    } 
    typeAdapter.write(paramJsonWriter, paramObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\internal\bind\ObjectTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
  private final boolean complexMapKeySerialization;
  
  private final ConstructorConstructor constructorConstructor;
  
  public MapTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, boolean paramBoolean) {
    this.constructorConstructor = paramConstructorConstructor;
    this.complexMapKeySerialization = paramBoolean;
  }
  
  private TypeAdapter<?> getKeyAdapter(Gson paramGson, Type paramType) {
    return (paramType == boolean.class || paramType == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : paramGson.getAdapter(TypeToken.get(paramType));
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
    Type type = paramTypeToken.getType();
    if (!Map.class.isAssignableFrom(paramTypeToken.getRawType()))
      return null; 
    Type[] arrayOfType = .Gson.Types.getMapKeyAndValueTypes(type, .Gson.Types.getRawType(type));
    TypeAdapter<?> typeAdapter2 = getKeyAdapter(paramGson, arrayOfType[0]);
    TypeAdapter<?> typeAdapter1 = paramGson.getAdapter(TypeToken.get(arrayOfType[1]));
    ObjectConstructor<? extends Map<?, ?>> objectConstructor = this.constructorConstructor.get(paramTypeToken);
    return (TypeAdapter)new Adapter<Object, Object>(paramGson, arrayOfType[0], typeAdapter2, arrayOfType[1], typeAdapter1, objectConstructor);
  }
  
  private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
    private final ObjectConstructor<? extends Map<K, V>> constructor;
    
    private final TypeAdapter<K> keyTypeAdapter;
    
    private final TypeAdapter<V> valueTypeAdapter;
    
    public Adapter(Gson param1Gson, Type param1Type1, TypeAdapter<K> param1TypeAdapter, Type param1Type2, TypeAdapter<V> param1TypeAdapter1, ObjectConstructor<? extends Map<K, V>> param1ObjectConstructor) {
      this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper<K>(param1Gson, param1TypeAdapter, param1Type1);
      this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper<V>(param1Gson, param1TypeAdapter1, param1Type2);
      this.constructor = param1ObjectConstructor;
    }
    
    private String keyToString(JsonElement param1JsonElement) {
      if (param1JsonElement.isJsonPrimitive()) {
        JsonPrimitive jsonPrimitive = param1JsonElement.getAsJsonPrimitive();
        if (jsonPrimitive.isNumber())
          return String.valueOf(jsonPrimitive.getAsNumber()); 
        if (jsonPrimitive.isBoolean())
          return Boolean.toString(jsonPrimitive.getAsBoolean()); 
        if (jsonPrimitive.isString())
          return jsonPrimitive.getAsString(); 
        throw new AssertionError();
      } 
      if (param1JsonElement.isJsonNull())
        return "null"; 
      throw new AssertionError();
    }
    
    public Map<K, V> read(JsonReader param1JsonReader) throws IOException {
      JsonToken jsonToken = param1JsonReader.peek();
      if (jsonToken == JsonToken.NULL) {
        param1JsonReader.nextNull();
        return null;
      } 
      Map<Object, Object> map = (Map)this.constructor.construct();
      if (jsonToken == JsonToken.BEGIN_ARRAY) {
        param1JsonReader.beginArray();
        while (param1JsonReader.hasNext()) {
          param1JsonReader.beginArray();
          Object object = this.keyTypeAdapter.read(param1JsonReader);
          if (map.put(object, this.valueTypeAdapter.read(param1JsonReader)) != null)
            throw new JsonSyntaxException("duplicate key: " + object); 
          param1JsonReader.endArray();
        } 
        param1JsonReader.endArray();
        return (Map)map;
      } 
      param1JsonReader.beginObject();
      while (param1JsonReader.hasNext()) {
        JsonReaderInternalAccess.INSTANCE.promoteNameToValue(param1JsonReader);
        Object object = this.keyTypeAdapter.read(param1JsonReader);
        if (map.put(object, this.valueTypeAdapter.read(param1JsonReader)) != null)
          throw new JsonSyntaxException("duplicate key: " + object); 
      } 
      param1JsonReader.endObject();
      return (Map)map;
    }
    
    public void write(JsonWriter param1JsonWriter, Map<K, V> param1Map) throws IOException {
      if (param1Map == null) {
        param1JsonWriter.nullValue();
        return;
      } 
      if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
        param1JsonWriter.beginObject();
        for (Map.Entry<K, V> entry : param1Map.entrySet()) {
          param1JsonWriter.name(String.valueOf(entry.getKey()));
          this.valueTypeAdapter.write(param1JsonWriter, entry.getValue());
        } 
        param1JsonWriter.endObject();
        return;
      } 
      int i = 0;
      ArrayList<JsonElement> arrayList = new ArrayList(entry.size());
      ArrayList arrayList1 = new ArrayList(entry.size());
      for (Map.Entry<K, V> entry1 : entry.entrySet()) {
        byte b;
        JsonElement jsonElement = this.keyTypeAdapter.toJsonTree(entry1.getKey());
        arrayList.add(jsonElement);
        arrayList1.add(entry1.getValue());
        if (jsonElement.isJsonArray() || jsonElement.isJsonObject()) {
          b = 1;
        } else {
          b = 0;
        } 
        i |= b;
      } 
      if (i != 0) {
        param1JsonWriter.beginArray();
        for (i = 0; i < arrayList.size(); i++) {
          param1JsonWriter.beginArray();
          Streams.write(arrayList.get(i), param1JsonWriter);
          this.valueTypeAdapter.write(param1JsonWriter, arrayList1.get(i));
          param1JsonWriter.endArray();
        } 
        param1JsonWriter.endArray();
        return;
      } 
      param1JsonWriter.beginObject();
      for (i = 0; i < arrayList.size(); i++) {
        param1JsonWriter.name(keyToString(arrayList.get(i)));
        this.valueTypeAdapter.write(param1JsonWriter, arrayList1.get(i));
      } 
      param1JsonWriter.endObject();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\internal\bind\MapTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
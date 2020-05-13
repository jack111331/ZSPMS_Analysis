package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public final class ListSerializer implements ObjectSerializer {
  public static final ListSerializer instance = new ListSerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    boolean bool = paramJSONSerializer.out.isEnabled(SerializerFeature.WriteClassName);
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (bool) {
      paramType = TypeUtils.getCollectionItemType(paramType);
    } else {
      paramType = null;
    } 
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    } 
    List list = (List)paramObject1;
    if (list.size() == 0) {
      serializeWriter.append("[]");
      return;
    } 
    SerialContext serialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      Iterator<Object> iterator;
      if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
        serializeWriter.append('[');
        paramJSONSerializer.incrementIndent();
        iterator = list.iterator();
        for (paramInt = 0; iterator.hasNext(); paramInt++) {
          Object object = iterator.next();
          if (paramInt != 0)
            serializeWriter.append(','); 
          paramJSONSerializer.println();
          if (object != null) {
            if (paramJSONSerializer.containsReference(object)) {
              paramJSONSerializer.writeReference(object);
            } else {
              ObjectSerializer objectSerializer = paramJSONSerializer.getObjectWriter(object.getClass());
              SerialContext serialContext1 = new SerialContext();
              this(serialContext, paramObject1, paramObject2, 0, 0);
              paramJSONSerializer.context = serialContext1;
              objectSerializer.write(paramJSONSerializer, object, Integer.valueOf(paramInt), paramType, 0);
            } 
          } else {
            paramJSONSerializer.out.writeNull();
          } 
        } 
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
        serializeWriter.append(']');
        return;
      } 
      serializeWriter.append('[');
      int i = iterator.size();
      for (byte b = 0; b < i; b++) {
        Integer integer = (Integer)iterator.get(b);
        if (b != 0)
          serializeWriter.append(','); 
        if (integer == null) {
          serializeWriter.append("null");
        } else {
          Class<?> clazz = integer.getClass();
          if (clazz == Integer.class) {
            serializeWriter.writeInt(((Integer)integer).intValue());
          } else if (clazz == Long.class) {
            long l = ((Long)integer).longValue();
            if (bool) {
              serializeWriter.writeLong(l);
              serializeWriter.write(76);
            } else {
              serializeWriter.writeLong(l);
            } 
          } else if ((SerializerFeature.DisableCircularReferenceDetect.mask & paramInt) != 0) {
            paramJSONSerializer.getObjectWriter(integer.getClass()).write(paramJSONSerializer, integer, Integer.valueOf(b), paramType, paramInt);
          } else {
            if (!serializeWriter.disableCircularReferenceDetect) {
              SerialContext serialContext1 = new SerialContext();
              this(serialContext, paramObject1, paramObject2, 0, 0);
              paramJSONSerializer.context = serialContext1;
            } 
            if (paramJSONSerializer.containsReference(integer)) {
              paramJSONSerializer.writeReference(integer);
            } else {
              paramJSONSerializer.getObjectWriter(integer.getClass()).write(paramJSONSerializer, integer, Integer.valueOf(b), paramType, 0);
            } 
          } 
        } 
      } 
      serializeWriter.append(']');
      return;
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
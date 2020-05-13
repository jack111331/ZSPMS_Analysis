package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

public class ObjectArrayCodec implements ObjectDeserializer, ObjectSerializer {
  public static final ObjectArrayCodec instance = new ObjectArrayCodec();
  
  private <T> T toObjectArray(DefaultJSONParser paramDefaultJSONParser, Class<?> paramClass, JSONArray paramJSONArray) {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_3
    //   7: invokevirtual size : ()I
    //   10: istore #4
    //   12: aload_2
    //   13: iload #4
    //   15: invokestatic newInstance : (Ljava/lang/Class;I)Ljava/lang/Object;
    //   18: astore #5
    //   20: iconst_0
    //   21: istore #6
    //   23: iload #6
    //   25: iload #4
    //   27: if_icmpge -> 223
    //   30: aload_3
    //   31: iload #6
    //   33: invokevirtual get : (I)Ljava/lang/Object;
    //   36: astore #7
    //   38: aload #7
    //   40: aload_3
    //   41: if_acmpne -> 56
    //   44: aload #5
    //   46: iload #6
    //   48: aload #5
    //   50: invokestatic set : (Ljava/lang/Object;ILjava/lang/Object;)V
    //   53: goto -> 217
    //   56: aload_2
    //   57: invokevirtual isArray : ()Z
    //   60: ifeq -> 104
    //   63: aload_2
    //   64: aload #7
    //   66: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   69: ifeq -> 79
    //   72: aload #7
    //   74: astore #8
    //   76: goto -> 92
    //   79: aload_0
    //   80: aload_1
    //   81: aload_2
    //   82: aload #7
    //   84: checkcast com/alibaba/fastjson/JSONArray
    //   87: invokespecial toObjectArray : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Class;Lcom/alibaba/fastjson/JSONArray;)Ljava/lang/Object;
    //   90: astore #8
    //   92: aload #5
    //   94: iload #6
    //   96: aload #8
    //   98: invokestatic set : (Ljava/lang/Object;ILjava/lang/Object;)V
    //   101: goto -> 217
    //   104: aload #7
    //   106: instanceof com/alibaba/fastjson/JSONArray
    //   109: ifeq -> 184
    //   112: aload #7
    //   114: checkcast com/alibaba/fastjson/JSONArray
    //   117: astore #8
    //   119: aload #8
    //   121: invokevirtual size : ()I
    //   124: istore #9
    //   126: iconst_0
    //   127: istore #10
    //   129: iconst_0
    //   130: istore #11
    //   132: iload #10
    //   134: iload #9
    //   136: if_icmpge -> 169
    //   139: aload #8
    //   141: iload #10
    //   143: invokevirtual get : (I)Ljava/lang/Object;
    //   146: aload_3
    //   147: if_acmpne -> 163
    //   150: aload #8
    //   152: iload #6
    //   154: aload #5
    //   156: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: iconst_1
    //   161: istore #11
    //   163: iinc #10, 1
    //   166: goto -> 132
    //   169: iload #11
    //   171: ifeq -> 184
    //   174: aload #8
    //   176: invokevirtual toArray : ()[Ljava/lang/Object;
    //   179: astore #8
    //   181: goto -> 187
    //   184: aconst_null
    //   185: astore #8
    //   187: aload #8
    //   189: astore #12
    //   191: aload #8
    //   193: ifnonnull -> 208
    //   196: aload #7
    //   198: aload_2
    //   199: aload_1
    //   200: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   203: invokestatic cast : (Ljava/lang/Object;Ljava/lang/Class;Lcom/alibaba/fastjson/parser/ParserConfig;)Ljava/lang/Object;
    //   206: astore #12
    //   208: aload #5
    //   210: iload #6
    //   212: aload #12
    //   214: invokestatic set : (Ljava/lang/Object;ILjava/lang/Object;)V
    //   217: iinc #6, 1
    //   220: goto -> 23
    //   223: aload_3
    //   224: aload #5
    //   226: invokevirtual setRelatedArray : (Ljava/lang/Object;)V
    //   229: aload_3
    //   230: aload_2
    //   231: invokevirtual setComponentType : (Ljava/lang/reflect/Type;)V
    //   234: aload #5
    //   236: areturn
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type<Object> paramType, Object paramObject) {
    byte[] arrayOfByte;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = jSONLexer.token();
    Type<Object> type1 = null;
    Type<Object> type2 = null;
    if (i == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    if (i == 4 || i == 26) {
      arrayOfByte = jSONLexer.bytesValue();
      jSONLexer.nextToken(16);
      return (T)((arrayOfByte.length == 0 && paramType != byte[].class) ? null : arrayOfByte);
    } 
    if (paramType instanceof GenericArrayType) {
      Type<Object> type = ((GenericArrayType)paramType).getGenericComponentType();
      if (type instanceof TypeVariable) {
        TypeVariable typeVariable = (TypeVariable)type;
        paramType = (arrayOfByte.getContext()).type;
        boolean bool = paramType instanceof ParameterizedType;
        i = 0;
        if (bool) {
          ParameterizedType parameterizedType = (ParameterizedType)paramType;
          paramType = parameterizedType.getRawType();
          if (paramType instanceof Class) {
            TypeVariable[] arrayOfTypeVariable = ((Class)paramType).getTypeParameters();
            paramType = type2;
            while (true) {
              type1 = paramType;
              if (i < arrayOfTypeVariable.length) {
                if (arrayOfTypeVariable[i].getName().equals(typeVariable.getName()))
                  paramType = parameterizedType.getActualTypeArguments()[i]; 
                i++;
                continue;
              } 
              break;
            } 
          } 
          if (type1 instanceof Class) {
            paramType = type1;
            type1 = type;
          } else {
            paramType = Object.class;
            type1 = type;
          } 
        } else {
          paramType = TypeUtils.getClass(typeVariable.getBounds()[0]);
          type1 = type;
        } 
      } else {
        paramType = TypeUtils.getClass(type);
        type1 = type;
      } 
    } else {
      type1 = ((Class)paramType).getComponentType();
      paramType = type1;
    } 
    JSONArray jSONArray = new JSONArray();
    arrayOfByte.parseArray(type1, (Collection)jSONArray, paramObject);
    return toObjectArray((DefaultJSONParser)arrayOfByte, (Class<?>)paramType, jSONArray);
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object<?> paramObject1, Object<?> paramObject2, Type<?> paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    Object[] arrayOfObject = (Object[])paramObject1;
    if (paramObject1 == null) {
      serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    } 
    int i = arrayOfObject.length;
    int j = i - 1;
    if (j == -1) {
      serializeWriter.append("[]");
      return;
    } 
    SerialContext serialContext = paramJSONSerializer.context;
    paramInt = 0;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      serializeWriter.append('[');
      if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
        paramJSONSerializer.incrementIndent();
        paramJSONSerializer.println();
        while (paramInt < i) {
          if (paramInt != 0) {
            serializeWriter.write(44);
            paramJSONSerializer.println();
          } 
          paramJSONSerializer.write(arrayOfObject[paramInt]);
          paramInt++;
        } 
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
        serializeWriter.write(93);
        return;
      } 
      paramObject2 = null;
      paramObject1 = paramObject2;
      for (paramInt = 0; paramInt < j; paramInt++) {
        Object object = arrayOfObject[paramInt];
        if (object == null) {
          serializeWriter.append("null,");
        } else {
          if (paramJSONSerializer.containsReference(object)) {
            paramJSONSerializer.writeReference(object);
          } else {
            paramType = object.getClass();
            if (paramType == paramObject2) {
              paramObject1.write(paramJSONSerializer, object, null, null, 0);
            } else {
              paramObject1 = (Object<?>)paramJSONSerializer.getObjectWriter((Class<?>)paramType);
              paramObject1.write(paramJSONSerializer, object, null, null, 0);
              paramObject2 = (Object<?>)paramType;
            } 
          } 
          serializeWriter.append(',');
        } 
      } 
      paramObject1 = (Object<?>)arrayOfObject[j];
      if (paramObject1 == null) {
        serializeWriter.append("null]");
      } else {
        if (paramJSONSerializer.containsReference(paramObject1)) {
          paramJSONSerializer.writeReference(paramObject1);
        } else {
          paramJSONSerializer.writeWithFieldName(paramObject1, Integer.valueOf(j));
        } 
        serializeWriter.append(']');
      } 
      return;
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ObjectArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
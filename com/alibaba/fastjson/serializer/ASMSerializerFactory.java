package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ASMSerializerFactory implements Opcodes {
  static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
  
  static final String JavaBeanSerializer;
  
  static final String JavaBeanSerializer_desc;
  
  static final String ObjectSerializer = ASMUtils.type(ObjectSerializer.class);
  
  static final String ObjectSerializer_desc;
  
  static final String SerialContext_desc;
  
  static final String SerializeFilterable_desc;
  
  static final String SerializeWriter = ASMUtils.type(SerializeWriter.class);
  
  static final String SerializeWriter_desc;
  
  protected final ASMClassLoader classLoader = new ASMClassLoader();
  
  private final AtomicLong seed = new AtomicLong();
  
  static {
    stringBuilder = new StringBuilder();
    stringBuilder.append("L");
    stringBuilder.append(SerializeWriter);
    stringBuilder.append(";");
    SerializeWriter_desc = stringBuilder.toString();
    JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
    stringBuilder = new StringBuilder();
    stringBuilder.append("L");
    stringBuilder.append(ASMUtils.type(JavaBeanSerializer.class));
    stringBuilder.append(";");
    JavaBeanSerializer_desc = stringBuilder.toString();
    SerialContext_desc = ASMUtils.desc(SerialContext.class);
    SerializeFilterable_desc = ASMUtils.desc(SerializeFilterable.class);
  }
  
  private void _after(MethodVisitor paramMethodVisitor, Context paramContext) {
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    String str = JavaBeanSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(JSONSerializer);
    stringBuilder.append(";Ljava/lang/Object;C)C");
    paramMethodVisitor.visitMethodInsn(182, str, "writeAfter", stringBuilder.toString());
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _apply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Class<byte> clazz = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    } else if (clazz == char.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
    } else if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
    } else if (clazz == BigDecimal.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    } else if (clazz == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    } else if (clazz.isEnum()) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    } else if (List.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } 
    String str = JavaBeanSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(JSONSerializer);
    stringBuilder.append(";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    paramMethodVisitor.visitMethodInsn(182, str, "apply", stringBuilder.toString());
  }
  
  private void _before(MethodVisitor paramMethodVisitor, Context paramContext) {
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    String str = JavaBeanSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(JSONSerializer);
    stringBuilder.append(";Ljava/lang/Object;C)C");
    paramMethodVisitor.visitMethodInsn(182, str, "writeBefore", stringBuilder.toString());
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _decimal(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label2 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label2);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("decimal"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label2);
    Label label3 = new Label();
    Label label4 = new Label();
    Label label1 = new Label();
    paramMethodVisitor.visitLabel(label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    paramMethodVisitor.visitJumpInsn(199, label4);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitLabel(label2);
  }
  
  private void _double(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(57, paramContext.var("double", 2));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _enum(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label2 = new Label();
    Label label1 = new Label();
    Label label3 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label3);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitTypeInsn(192, "java/lang/Enum");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("enum"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    paramMethodVisitor.visitJumpInsn(199, label2);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label2);
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitInsn(3);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
    } 
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitLabel(label3);
  }
  
  private void _filters(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    if (paramFieldInfo.fieldTransient) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
    } 
    _notWriteDefault(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    if (paramContext.writeDirect)
      return; 
    _apply(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
    _processKey(paramMethodVisitor, paramFieldInfo, paramContext);
    _processValue(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
  }
  
  private void _float(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(56, paramContext.var("float"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _get(MethodVisitor paramMethodVisitor, Context paramContext, FieldInfo paramFieldInfo) {
    Class<?> clazz;
    Method method = paramFieldInfo.method;
    if (method != null) {
      char c;
      paramMethodVisitor.visitVarInsn(25, paramContext.var("entity"));
      clazz = method.getDeclaringClass();
      if (clazz.isInterface()) {
        c = '¹';
      } else {
        c = '¶';
      } 
      paramMethodVisitor.visitMethodInsn(c, ASMUtils.type(clazz), method.getName(), ASMUtils.desc(method));
      if (!method.getReturnType().equals(paramFieldInfo.fieldClass))
        paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramFieldInfo.fieldClass)); 
    } else {
      paramMethodVisitor.visitVarInsn(25, clazz.var("entity"));
      Field field = paramFieldInfo.field;
      paramMethodVisitor.visitFieldInsn(180, ASMUtils.type(paramFieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
      if (!field.getType().equals(paramFieldInfo.fieldClass))
        paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramFieldInfo.fieldClass)); 
    } 
  }
  
  private void _getFieldSer(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    String str2 = paramContext.className;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm_ser_");
    paramMethodVisitor.visitFieldInsn(180, str2, stringBuilder2.toString(), ObjectSerializer_desc);
    paramMethodVisitor.visitJumpInsn(199, label);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    str2 = JSONSerializer;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(Ljava/lang/Class;)");
    stringBuilder2.append(ObjectSerializer_desc);
    paramMethodVisitor.visitMethodInsn(182, str2, "getObjectWriter", stringBuilder2.toString());
    str2 = paramContext.className;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm_ser_");
    paramMethodVisitor.visitFieldInsn(181, str2, stringBuilder2.toString(), ObjectSerializer_desc);
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str1 = paramContext.className;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_ser_");
    paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder1.toString(), ObjectSerializer_desc);
  }
  
  private void _getListFieldItemSer(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    String str4 = paramContext.className;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm_list_item_ser_");
    paramMethodVisitor.visitFieldInsn(180, str4, stringBuilder3.toString(), ObjectSerializer_desc);
    paramMethodVisitor.visitJumpInsn(199, label);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass)));
    String str2 = JSONSerializer;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(Ljava/lang/Class;)");
    stringBuilder2.append(ObjectSerializer_desc);
    paramMethodVisitor.visitMethodInsn(182, str2, "getObjectWriter", stringBuilder2.toString());
    String str3 = paramContext.className;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_list_item_ser_");
    paramMethodVisitor.visitFieldInsn(181, str3, stringBuilder1.toString(), ObjectSerializer_desc);
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str1 = paramContext.className;
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_list_item_ser_");
    paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder1.toString(), ObjectSerializer_desc);
  }
  
  private void _if_write_null(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    boolean bool;
    Class<String> clazz = paramFieldInfo.fieldClass;
    Label label1 = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    paramMethodVisitor.visitLabel(label1);
    JSONField jSONField = paramFieldInfo.getAnnotation();
    if (jSONField != null) {
      bool = SerializerFeature.of(jSONField.serialzeFeatures());
    } else {
      bool = false;
    } 
    if ((SerializerFeature.WRITE_MAP_NULL_FEATURES & bool) == 0) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WRITE_MAP_NULL_FEATURES));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(153, label2);
    } 
    paramMethodVisitor.visitLabel(label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    _writeFieldName(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(bool));
    if (clazz == String.class || clazz == Character.class) {
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
    } else if (Number.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
    } else if (clazz == Boolean.class) {
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
    } else if (Collection.class.isAssignableFrom(clazz) || clazz.isArray()) {
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
    } else {
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(0));
    } 
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "(II)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label4);
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitLabel(label4);
  }
  
  private void _int(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, int paramInt, char paramChar) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramInt);
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramInt);
    String str = SerializeWriter;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(CLjava/lang/String;");
    stringBuilder.append(paramChar);
    stringBuilder.append(")V");
    paramMethodVisitor.visitMethodInsn(182, str, "writeFieldValue", stringBuilder.toString());
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _labelApply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.label);
    String str = JavaBeanSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(JSONSerializer);
    stringBuilder.append(";Ljava/lang/String;)Z");
    paramMethodVisitor.visitMethodInsn(182, str, "applyLabel", stringBuilder.toString());
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  private void _list(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    // Byte code:
    //   0: aload_3
    //   1: getfield fieldType : Ljava/lang/reflect/Type;
    //   4: invokestatic getCollectionItemType : (Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;
    //   7: astore #5
    //   9: aload #5
    //   11: instanceof java/lang/Class
    //   14: ifeq -> 26
    //   17: aload #5
    //   19: checkcast java/lang/Class
    //   22: astore_1
    //   23: goto -> 28
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_1
    //   29: ldc java/lang/Object
    //   31: if_acmpeq -> 44
    //   34: aload_1
    //   35: astore #6
    //   37: aload_1
    //   38: ldc_w java/io/Serializable
    //   41: if_acmpne -> 47
    //   44: aconst_null
    //   45: astore #6
    //   47: new com/alibaba/fastjson/asm/Label
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #7
    //   56: new com/alibaba/fastjson/asm/Label
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore_1
    //   64: new com/alibaba/fastjson/asm/Label
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore #8
    //   73: aload_0
    //   74: aload_2
    //   75: aload_3
    //   76: aload #4
    //   78: aload #7
    //   80: invokespecial _nameApply : (Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/util/FieldInfo;Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;Lcom/alibaba/fastjson/asm/Label;)V
    //   83: aload_0
    //   84: aload_2
    //   85: aload #4
    //   87: aload_3
    //   88: invokespecial _get : (Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;Lcom/alibaba/fastjson/util/FieldInfo;)V
    //   91: aload_2
    //   92: sipush #192
    //   95: ldc_w 'java/util/List'
    //   98: invokeinterface visitTypeInsn : (ILjava/lang/String;)V
    //   103: aload_2
    //   104: bipush #58
    //   106: aload #4
    //   108: ldc 'list'
    //   110: invokevirtual var : (Ljava/lang/String;)I
    //   113: invokeinterface visitVarInsn : (II)V
    //   118: aload_0
    //   119: aload_2
    //   120: aload_3
    //   121: aload #4
    //   123: aload #7
    //   125: invokespecial _filters : (Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/util/FieldInfo;Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;Lcom/alibaba/fastjson/asm/Label;)V
    //   128: aload_2
    //   129: bipush #25
    //   131: aload #4
    //   133: ldc 'list'
    //   135: invokevirtual var : (Ljava/lang/String;)I
    //   138: invokeinterface visitVarInsn : (II)V
    //   143: aload_2
    //   144: sipush #199
    //   147: aload_1
    //   148: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   153: aload_0
    //   154: aload_2
    //   155: aload_3
    //   156: aload #4
    //   158: invokespecial _if_write_null : (Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/util/FieldInfo;Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)V
    //   161: aload_2
    //   162: sipush #167
    //   165: aload #8
    //   167: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   172: aload_2
    //   173: aload_1
    //   174: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   179: aload_2
    //   180: bipush #25
    //   182: aload #4
    //   184: ldc_w 'out'
    //   187: invokevirtual var : (Ljava/lang/String;)I
    //   190: invokeinterface visitVarInsn : (II)V
    //   195: aload_2
    //   196: bipush #21
    //   198: aload #4
    //   200: ldc 'seperator'
    //   202: invokevirtual var : (Ljava/lang/String;)I
    //   205: invokeinterface visitVarInsn : (II)V
    //   210: aload_2
    //   211: sipush #182
    //   214: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   217: ldc_w 'write'
    //   220: ldc_w '(I)V'
    //   223: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_0
    //   229: aload_2
    //   230: aload #4
    //   232: invokespecial _writeFieldName : (Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)V
    //   235: aload_2
    //   236: bipush #25
    //   238: aload #4
    //   240: ldc 'list'
    //   242: invokevirtual var : (Ljava/lang/String;)I
    //   245: invokeinterface visitVarInsn : (II)V
    //   250: aload_2
    //   251: sipush #185
    //   254: ldc_w 'java/util/List'
    //   257: ldc_w 'size'
    //   260: ldc_w '()I'
    //   263: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_2
    //   269: bipush #54
    //   271: aload #4
    //   273: ldc_w 'size'
    //   276: invokevirtual var : (Ljava/lang/String;)I
    //   279: invokeinterface visitVarInsn : (II)V
    //   284: new com/alibaba/fastjson/asm/Label
    //   287: dup
    //   288: invokespecial <init> : ()V
    //   291: astore_1
    //   292: new com/alibaba/fastjson/asm/Label
    //   295: dup
    //   296: invokespecial <init> : ()V
    //   299: astore #9
    //   301: aload_2
    //   302: bipush #21
    //   304: aload #4
    //   306: ldc_w 'size'
    //   309: invokevirtual var : (Ljava/lang/String;)I
    //   312: invokeinterface visitVarInsn : (II)V
    //   317: aload_2
    //   318: iconst_3
    //   319: invokeinterface visitInsn : (I)V
    //   324: aload_2
    //   325: sipush #160
    //   328: aload_1
    //   329: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   334: aload_2
    //   335: bipush #25
    //   337: aload #4
    //   339: ldc_w 'out'
    //   342: invokevirtual var : (Ljava/lang/String;)I
    //   345: invokeinterface visitVarInsn : (II)V
    //   350: aload_2
    //   351: ldc_w '[]'
    //   354: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   359: aload_2
    //   360: sipush #182
    //   363: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   366: ldc_w 'write'
    //   369: ldc_w '(Ljava/lang/String;)V'
    //   372: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_2
    //   378: sipush #167
    //   381: aload #9
    //   383: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   388: aload_2
    //   389: aload_1
    //   390: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   395: aload #4
    //   397: invokestatic access$200 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   400: ifne -> 456
    //   403: aload_2
    //   404: bipush #25
    //   406: iconst_1
    //   407: invokeinterface visitVarInsn : (II)V
    //   412: aload_2
    //   413: bipush #25
    //   415: aload #4
    //   417: ldc 'list'
    //   419: invokevirtual var : (Ljava/lang/String;)I
    //   422: invokeinterface visitVarInsn : (II)V
    //   427: aload_2
    //   428: bipush #25
    //   430: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory$Context.fieldName : I
    //   433: invokeinterface visitVarInsn : (II)V
    //   438: aload_2
    //   439: sipush #182
    //   442: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JSONSerializer : Ljava/lang/String;
    //   445: ldc_w 'setContext'
    //   448: ldc_w '(Ljava/lang/Object;Ljava/lang/Object;)V'
    //   451: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload #5
    //   458: ldc java/lang/String
    //   460: if_acmpne -> 523
    //   463: aload #4
    //   465: invokestatic access$000 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   468: ifeq -> 523
    //   471: aload_2
    //   472: bipush #25
    //   474: aload #4
    //   476: ldc_w 'out'
    //   479: invokevirtual var : (Ljava/lang/String;)I
    //   482: invokeinterface visitVarInsn : (II)V
    //   487: aload_2
    //   488: bipush #25
    //   490: aload #4
    //   492: ldc 'list'
    //   494: invokevirtual var : (Ljava/lang/String;)I
    //   497: invokeinterface visitVarInsn : (II)V
    //   502: aload_2
    //   503: sipush #182
    //   506: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   509: ldc_w 'write'
    //   512: ldc_w '(Ljava/util/List;)V'
    //   515: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   520: goto -> 1780
    //   523: aload_2
    //   524: bipush #25
    //   526: aload #4
    //   528: ldc_w 'out'
    //   531: invokevirtual var : (Ljava/lang/String;)I
    //   534: invokeinterface visitVarInsn : (II)V
    //   539: aload_2
    //   540: bipush #16
    //   542: bipush #91
    //   544: invokeinterface visitVarInsn : (II)V
    //   549: aload_2
    //   550: sipush #182
    //   553: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   556: ldc_w 'write'
    //   559: ldc_w '(I)V'
    //   562: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   567: new com/alibaba/fastjson/asm/Label
    //   570: dup
    //   571: invokespecial <init> : ()V
    //   574: astore #10
    //   576: new com/alibaba/fastjson/asm/Label
    //   579: dup
    //   580: invokespecial <init> : ()V
    //   583: astore_1
    //   584: new com/alibaba/fastjson/asm/Label
    //   587: dup
    //   588: invokespecial <init> : ()V
    //   591: astore #11
    //   593: aload_2
    //   594: iconst_3
    //   595: invokeinterface visitInsn : (I)V
    //   600: aload_2
    //   601: bipush #54
    //   603: aload #4
    //   605: ldc_w 'i'
    //   608: invokevirtual var : (Ljava/lang/String;)I
    //   611: invokeinterface visitVarInsn : (II)V
    //   616: aload_2
    //   617: aload #10
    //   619: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   624: aload_2
    //   625: bipush #21
    //   627: aload #4
    //   629: ldc_w 'i'
    //   632: invokevirtual var : (Ljava/lang/String;)I
    //   635: invokeinterface visitVarInsn : (II)V
    //   640: aload_2
    //   641: bipush #21
    //   643: aload #4
    //   645: ldc_w 'size'
    //   648: invokevirtual var : (Ljava/lang/String;)I
    //   651: invokeinterface visitVarInsn : (II)V
    //   656: aload_2
    //   657: sipush #162
    //   660: aload #11
    //   662: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   667: aload_2
    //   668: bipush #21
    //   670: aload #4
    //   672: ldc_w 'i'
    //   675: invokevirtual var : (Ljava/lang/String;)I
    //   678: invokeinterface visitVarInsn : (II)V
    //   683: aload_2
    //   684: sipush #153
    //   687: aload_1
    //   688: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   693: aload_2
    //   694: bipush #25
    //   696: aload #4
    //   698: ldc_w 'out'
    //   701: invokevirtual var : (Ljava/lang/String;)I
    //   704: invokeinterface visitVarInsn : (II)V
    //   709: aload_2
    //   710: bipush #16
    //   712: bipush #44
    //   714: invokeinterface visitVarInsn : (II)V
    //   719: aload_2
    //   720: sipush #182
    //   723: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   726: ldc_w 'write'
    //   729: ldc_w '(I)V'
    //   732: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload_2
    //   738: aload_1
    //   739: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   744: aload_2
    //   745: bipush #25
    //   747: aload #4
    //   749: ldc 'list'
    //   751: invokevirtual var : (Ljava/lang/String;)I
    //   754: invokeinterface visitVarInsn : (II)V
    //   759: aload_2
    //   760: bipush #21
    //   762: aload #4
    //   764: ldc_w 'i'
    //   767: invokevirtual var : (Ljava/lang/String;)I
    //   770: invokeinterface visitVarInsn : (II)V
    //   775: aload_2
    //   776: sipush #185
    //   779: ldc_w 'java/util/List'
    //   782: ldc_w 'get'
    //   785: ldc_w '(I)Ljava/lang/Object;'
    //   788: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload_2
    //   794: bipush #58
    //   796: aload #4
    //   798: ldc_w 'list_item'
    //   801: invokevirtual var : (Ljava/lang/String;)I
    //   804: invokeinterface visitVarInsn : (II)V
    //   809: new com/alibaba/fastjson/asm/Label
    //   812: dup
    //   813: invokespecial <init> : ()V
    //   816: astore #12
    //   818: new com/alibaba/fastjson/asm/Label
    //   821: dup
    //   822: invokespecial <init> : ()V
    //   825: astore_1
    //   826: aload_2
    //   827: bipush #25
    //   829: aload #4
    //   831: ldc_w 'list_item'
    //   834: invokevirtual var : (Ljava/lang/String;)I
    //   837: invokeinterface visitVarInsn : (II)V
    //   842: aload_2
    //   843: sipush #199
    //   846: aload_1
    //   847: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   852: aload_2
    //   853: bipush #25
    //   855: aload #4
    //   857: ldc_w 'out'
    //   860: invokevirtual var : (Ljava/lang/String;)I
    //   863: invokeinterface visitVarInsn : (II)V
    //   868: aload_2
    //   869: sipush #182
    //   872: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   875: ldc_w 'writeNull'
    //   878: ldc_w '()V'
    //   881: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   886: aload_2
    //   887: sipush #167
    //   890: aload #12
    //   892: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   897: aload_2
    //   898: aload_1
    //   899: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   904: new com/alibaba/fastjson/asm/Label
    //   907: dup
    //   908: invokespecial <init> : ()V
    //   911: astore #13
    //   913: new com/alibaba/fastjson/asm/Label
    //   916: dup
    //   917: invokespecial <init> : ()V
    //   920: astore #14
    //   922: aload #6
    //   924: ifnull -> 1519
    //   927: aload #6
    //   929: invokevirtual getModifiers : ()I
    //   932: invokestatic isPublic : (I)Z
    //   935: ifeq -> 1519
    //   938: aload_2
    //   939: bipush #25
    //   941: aload #4
    //   943: ldc_w 'list_item'
    //   946: invokevirtual var : (Ljava/lang/String;)I
    //   949: invokeinterface visitVarInsn : (II)V
    //   954: aload_2
    //   955: sipush #182
    //   958: ldc_w 'java/lang/Object'
    //   961: ldc_w 'getClass'
    //   964: ldc_w '()Ljava/lang/Class;'
    //   967: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   972: aload_2
    //   973: aload #6
    //   975: invokestatic desc : (Ljava/lang/Class;)Ljava/lang/String;
    //   978: invokestatic getType : (Ljava/lang/String;)Lcom/alibaba/fastjson/asm/Type;
    //   981: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   986: aload_2
    //   987: sipush #166
    //   990: aload #14
    //   992: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   997: aload_0
    //   998: aload #4
    //   1000: aload_2
    //   1001: aload_3
    //   1002: aload #6
    //   1004: invokespecial _getListFieldItemSer : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/util/FieldInfo;Ljava/lang/Class;)V
    //   1007: aload_2
    //   1008: bipush #58
    //   1010: aload #4
    //   1012: ldc_w 'list_item_desc'
    //   1015: invokevirtual var : (Ljava/lang/String;)I
    //   1018: invokeinterface visitVarInsn : (II)V
    //   1023: new com/alibaba/fastjson/asm/Label
    //   1026: dup
    //   1027: invokespecial <init> : ()V
    //   1030: astore #15
    //   1032: new com/alibaba/fastjson/asm/Label
    //   1035: dup
    //   1036: invokespecial <init> : ()V
    //   1039: astore #16
    //   1041: aload #4
    //   1043: invokestatic access$000 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   1046: ifeq -> 1323
    //   1049: aload #4
    //   1051: invokestatic access$200 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   1054: ifeq -> 1072
    //   1057: aload #4
    //   1059: invokestatic access$000 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   1062: ifeq -> 1072
    //   1065: ldc_w 'writeDirectNonContext'
    //   1068: astore_1
    //   1069: goto -> 1076
    //   1072: ldc_w 'write'
    //   1075: astore_1
    //   1076: aload_2
    //   1077: bipush #25
    //   1079: aload #4
    //   1081: ldc_w 'list_item_desc'
    //   1084: invokevirtual var : (Ljava/lang/String;)I
    //   1087: invokeinterface visitVarInsn : (II)V
    //   1092: aload_2
    //   1093: sipush #193
    //   1096: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JavaBeanSerializer : Ljava/lang/String;
    //   1099: invokeinterface visitTypeInsn : (ILjava/lang/String;)V
    //   1104: aload_2
    //   1105: sipush #153
    //   1108: aload #15
    //   1110: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   1115: aload_2
    //   1116: bipush #25
    //   1118: aload #4
    //   1120: ldc_w 'list_item_desc'
    //   1123: invokevirtual var : (Ljava/lang/String;)I
    //   1126: invokeinterface visitVarInsn : (II)V
    //   1131: aload_2
    //   1132: sipush #192
    //   1135: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JavaBeanSerializer : Ljava/lang/String;
    //   1138: invokeinterface visitTypeInsn : (ILjava/lang/String;)V
    //   1143: aload_2
    //   1144: bipush #25
    //   1146: iconst_1
    //   1147: invokeinterface visitVarInsn : (II)V
    //   1152: aload_2
    //   1153: bipush #25
    //   1155: aload #4
    //   1157: ldc_w 'list_item'
    //   1160: invokevirtual var : (Ljava/lang/String;)I
    //   1163: invokeinterface visitVarInsn : (II)V
    //   1168: aload #4
    //   1170: invokestatic access$200 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   1173: ifeq -> 1186
    //   1176: aload_2
    //   1177: iconst_1
    //   1178: invokeinterface visitInsn : (I)V
    //   1183: goto -> 1217
    //   1186: aload_2
    //   1187: bipush #21
    //   1189: aload #4
    //   1191: ldc_w 'i'
    //   1194: invokevirtual var : (Ljava/lang/String;)I
    //   1197: invokeinterface visitVarInsn : (II)V
    //   1202: aload_2
    //   1203: sipush #184
    //   1206: ldc 'java/lang/Integer'
    //   1208: ldc 'valueOf'
    //   1210: ldc '(I)Ljava/lang/Integer;'
    //   1212: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1217: aload_2
    //   1218: aload #6
    //   1220: invokestatic desc : (Ljava/lang/Class;)Ljava/lang/String;
    //   1223: invokestatic getType : (Ljava/lang/String;)Lcom/alibaba/fastjson/asm/Type;
    //   1226: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   1231: aload_2
    //   1232: aload_3
    //   1233: getfield serialzeFeatures : I
    //   1236: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1239: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   1244: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JavaBeanSerializer : Ljava/lang/String;
    //   1247: astore #17
    //   1249: new java/lang/StringBuilder
    //   1252: dup
    //   1253: invokespecial <init> : ()V
    //   1256: astore #18
    //   1258: aload #18
    //   1260: ldc '(L'
    //   1262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: pop
    //   1266: aload #18
    //   1268: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JSONSerializer : Ljava/lang/String;
    //   1271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: pop
    //   1275: aload #18
    //   1277: ldc_w ';Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V'
    //   1280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: aload_2
    //   1285: sipush #182
    //   1288: aload #17
    //   1290: aload_1
    //   1291: aload #18
    //   1293: invokevirtual toString : ()Ljava/lang/String;
    //   1296: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1301: aload_2
    //   1302: sipush #167
    //   1305: aload #16
    //   1307: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   1312: aload_2
    //   1313: aload #15
    //   1315: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1320: goto -> 1323
    //   1323: aload_2
    //   1324: bipush #25
    //   1326: aload #4
    //   1328: ldc_w 'list_item_desc'
    //   1331: invokevirtual var : (Ljava/lang/String;)I
    //   1334: invokeinterface visitVarInsn : (II)V
    //   1339: aload_2
    //   1340: bipush #25
    //   1342: iconst_1
    //   1343: invokeinterface visitVarInsn : (II)V
    //   1348: aload_2
    //   1349: bipush #25
    //   1351: aload #4
    //   1353: ldc_w 'list_item'
    //   1356: invokevirtual var : (Ljava/lang/String;)I
    //   1359: invokeinterface visitVarInsn : (II)V
    //   1364: aload #4
    //   1366: invokestatic access$200 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   1369: ifeq -> 1382
    //   1372: aload_2
    //   1373: iconst_1
    //   1374: invokeinterface visitInsn : (I)V
    //   1379: goto -> 1413
    //   1382: aload_2
    //   1383: bipush #21
    //   1385: aload #4
    //   1387: ldc_w 'i'
    //   1390: invokevirtual var : (Ljava/lang/String;)I
    //   1393: invokeinterface visitVarInsn : (II)V
    //   1398: aload_2
    //   1399: sipush #184
    //   1402: ldc 'java/lang/Integer'
    //   1404: ldc 'valueOf'
    //   1406: ldc '(I)Ljava/lang/Integer;'
    //   1408: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1413: aload_2
    //   1414: aload #6
    //   1416: invokestatic desc : (Ljava/lang/Class;)Ljava/lang/String;
    //   1419: invokestatic getType : (Ljava/lang/String;)Lcom/alibaba/fastjson/asm/Type;
    //   1422: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   1427: aload_2
    //   1428: aload_3
    //   1429: getfield serialzeFeatures : I
    //   1432: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1435: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   1440: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.ObjectSerializer : Ljava/lang/String;
    //   1443: astore_1
    //   1444: new java/lang/StringBuilder
    //   1447: dup
    //   1448: invokespecial <init> : ()V
    //   1451: astore #15
    //   1453: aload #15
    //   1455: ldc '(L'
    //   1457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload #15
    //   1463: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JSONSerializer : Ljava/lang/String;
    //   1466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: aload #15
    //   1472: ldc_w ';Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V'
    //   1475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: aload_2
    //   1480: sipush #185
    //   1483: aload_1
    //   1484: ldc_w 'write'
    //   1487: aload #15
    //   1489: invokevirtual toString : ()Ljava/lang/String;
    //   1492: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1497: aload_2
    //   1498: aload #16
    //   1500: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1505: aload_2
    //   1506: sipush #167
    //   1509: aload #13
    //   1511: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   1516: goto -> 1519
    //   1519: aload_2
    //   1520: aload #14
    //   1522: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1527: aload_2
    //   1528: bipush #25
    //   1530: iconst_1
    //   1531: invokeinterface visitVarInsn : (II)V
    //   1536: aload_2
    //   1537: bipush #25
    //   1539: aload #4
    //   1541: ldc_w 'list_item'
    //   1544: invokevirtual var : (Ljava/lang/String;)I
    //   1547: invokeinterface visitVarInsn : (II)V
    //   1552: aload #4
    //   1554: invokestatic access$200 : (Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)Z
    //   1557: ifeq -> 1570
    //   1560: aload_2
    //   1561: iconst_1
    //   1562: invokeinterface visitInsn : (I)V
    //   1567: goto -> 1601
    //   1570: aload_2
    //   1571: bipush #21
    //   1573: aload #4
    //   1575: ldc_w 'i'
    //   1578: invokevirtual var : (Ljava/lang/String;)I
    //   1581: invokeinterface visitVarInsn : (II)V
    //   1586: aload_2
    //   1587: sipush #184
    //   1590: ldc 'java/lang/Integer'
    //   1592: ldc 'valueOf'
    //   1594: ldc '(I)Ljava/lang/Integer;'
    //   1596: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1601: aload #6
    //   1603: ifnull -> 1668
    //   1606: aload #6
    //   1608: invokevirtual getModifiers : ()I
    //   1611: invokestatic isPublic : (I)Z
    //   1614: ifeq -> 1668
    //   1617: aload_2
    //   1618: aload #5
    //   1620: checkcast java/lang/Class
    //   1623: invokestatic desc : (Ljava/lang/Class;)Ljava/lang/String;
    //   1626: invokestatic getType : (Ljava/lang/String;)Lcom/alibaba/fastjson/asm/Type;
    //   1629: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   1634: aload_2
    //   1635: aload_3
    //   1636: getfield serialzeFeatures : I
    //   1639: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1642: invokeinterface visitLdcInsn : (Ljava/lang/Object;)V
    //   1647: aload_2
    //   1648: sipush #182
    //   1651: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JSONSerializer : Ljava/lang/String;
    //   1654: ldc_w 'writeWithFieldName'
    //   1657: ldc_w '(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V'
    //   1660: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1665: goto -> 1686
    //   1668: aload_2
    //   1669: sipush #182
    //   1672: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JSONSerializer : Ljava/lang/String;
    //   1675: ldc_w 'writeWithFieldName'
    //   1678: ldc_w '(Ljava/lang/Object;Ljava/lang/Object;)V'
    //   1681: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1686: aload_2
    //   1687: aload #13
    //   1689: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1694: aload_2
    //   1695: aload #12
    //   1697: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1702: aload_2
    //   1703: aload #4
    //   1705: ldc_w 'i'
    //   1708: invokevirtual var : (Ljava/lang/String;)I
    //   1711: iconst_1
    //   1712: invokeinterface visitIincInsn : (II)V
    //   1717: aload_2
    //   1718: sipush #167
    //   1721: aload #10
    //   1723: invokeinterface visitJumpInsn : (ILcom/alibaba/fastjson/asm/Label;)V
    //   1728: aload_2
    //   1729: aload #11
    //   1731: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1736: aload_2
    //   1737: bipush #25
    //   1739: aload #4
    //   1741: ldc_w 'out'
    //   1744: invokevirtual var : (Ljava/lang/String;)I
    //   1747: invokeinterface visitVarInsn : (II)V
    //   1752: aload_2
    //   1753: bipush #16
    //   1755: bipush #93
    //   1757: invokeinterface visitVarInsn : (II)V
    //   1762: aload_2
    //   1763: sipush #182
    //   1766: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.SerializeWriter : Ljava/lang/String;
    //   1769: ldc_w 'write'
    //   1772: ldc_w '(I)V'
    //   1775: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1780: aload_2
    //   1781: bipush #25
    //   1783: iconst_1
    //   1784: invokeinterface visitVarInsn : (II)V
    //   1789: aload_2
    //   1790: sipush #182
    //   1793: getstatic com/alibaba/fastjson/serializer/ASMSerializerFactory.JSONSerializer : Ljava/lang/String;
    //   1796: ldc_w 'popContext'
    //   1799: ldc_w '()V'
    //   1802: invokeinterface visitMethodInsn : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1807: aload_2
    //   1808: aload #9
    //   1810: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1815: aload_0
    //   1816: aload_2
    //   1817: aload #4
    //   1819: invokespecial _seperator : (Lcom/alibaba/fastjson/asm/MethodVisitor;Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;)V
    //   1822: aload_2
    //   1823: aload #8
    //   1825: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1830: aload_2
    //   1831: aload #7
    //   1833: invokeinterface visitLabel : (Lcom/alibaba/fastjson/asm/Label;)V
    //   1838: return
  }
  
  private void _long(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(55, paramContext.var("long", 2));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _nameApply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    if (!paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      String str = JavaBeanSerializer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(JSONSerializer);
      stringBuilder.append(";Ljava/lang/Object;Ljava/lang/String;)Z");
      paramMethodVisitor.visitMethodInsn(182, str, "applyName", stringBuilder.toString());
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
      _labelApply(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    } 
    if (paramFieldInfo.field == null) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
    } 
  }
  
  private void _notWriteDefault(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    if (paramContext.writeDirect)
      return; 
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("notWriteDefaultValue"));
    paramMethodVisitor.visitJumpInsn(153, label);
    Class<boolean> clazz = paramFieldInfo.fieldClass;
    if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long"));
      paramMethodVisitor.visitInsn(9);
      paramMethodVisitor.visitInsn(148);
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitInsn(11);
      paramMethodVisitor.visitInsn(149);
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double"));
      paramMethodVisitor.visitInsn(14);
      paramMethodVisitor.visitInsn(151);
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } 
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _object(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("object"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _writeObject(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _processKey(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("hasNameFilters"));
    paramMethodVisitor.visitJumpInsn(153, label);
    Class<byte> clazz = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    } else if (clazz == char.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
    } else if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
    } else if (clazz == BigDecimal.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    } else if (clazz == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    } else if (clazz.isEnum()) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    } else if (List.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } 
    String str = JavaBeanSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(JSONSerializer);
    stringBuilder.append(";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
    paramMethodVisitor.visitMethodInsn(182, str, "processKey", stringBuilder.toString());
    paramMethodVisitor.visitVarInsn(58, Context.fieldName);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _processValue(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    Label label = new Label();
    Class<byte> clazz = paramFieldInfo.fieldClass;
    if (clazz.isPrimitive()) {
      Label label1 = new Label();
      paramMethodVisitor.visitVarInsn(21, paramContext.var("checkValue"));
      paramMethodVisitor.visitJumpInsn(154, label1);
      paramMethodVisitor.visitInsn(1);
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(58, Context.processValue);
      paramMethodVisitor.visitJumpInsn(167, label);
      paramMethodVisitor.visitLabel(label1);
    } 
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramContext.getFieldOrinal(paramFieldInfo.name)));
    String str2 = JavaBeanSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(I)");
    stringBuilder.append(ASMUtils.desc(BeanContext.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getBeanContext", stringBuilder.toString());
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == char.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == BigDecimal.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else if (clazz == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else if (clazz.isEnum()) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else if (List.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } 
    String str1 = JavaBeanSerializer;
    stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(JSONSerializer);
    stringBuilder.append(";");
    stringBuilder.append(ASMUtils.desc(BeanContext.class));
    stringBuilder.append("Ljava/lang/Object;Ljava/lang/String;");
    stringBuilder.append("Ljava/lang/Object;");
    stringBuilder.append(")Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(182, str1, "processValue", stringBuilder.toString());
    paramMethodVisitor.visitVarInsn(58, Context.processValue);
    paramMethodVisitor.visitVarInsn(25, Context.original);
    paramMethodVisitor.visitVarInsn(25, Context.processValue);
    paramMethodVisitor.visitJumpInsn(165, label);
    _writeObject(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    paramMethodVisitor.visitJumpInsn(167, paramLabel);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _seperator(MethodVisitor paramMethodVisitor, Context paramContext) {
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _string(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label2 = new Label();
    if (paramFieldInfo.name.equals(paramContext.beanInfo.typeKey)) {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
      paramMethodVisitor.visitJumpInsn(154, label2);
    } 
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label2);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("string"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label2);
    Label label3 = new Label();
    Label label1 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    paramMethodVisitor.visitJumpInsn(199, label3);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label3);
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
    } 
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitLabel(label2);
  }
  
  private void _writeFieldName(MethodVisitor paramMethodVisitor, Context paramContext) {
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitInsn(3);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
    } 
  }
  
  private void _writeObject(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    String str = paramFieldInfo.getFormat();
    Class clazz = paramFieldInfo.fieldClass;
    Label label1 = new Label();
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } else {
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
    } 
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("object"));
    paramMethodVisitor.visitJumpInsn(199, label1);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, paramLabel);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    _writeFieldName(paramMethodVisitor, paramContext);
    label1 = new Label();
    Label label2 = new Label();
    if (Modifier.isPublic(clazz.getModifiers()) && !ParserConfig.isPrimitive2(clazz)) {
      String str1;
      boolean bool1;
      boolean bool2;
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
      paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(clazz)));
      paramMethodVisitor.visitJumpInsn(166, label2);
      _getFieldSer(paramContext, paramMethodVisitor, paramFieldInfo);
      paramMethodVisitor.visitVarInsn(58, paramContext.var("fied_ser"));
      Label label4 = new Label();
      Label label3 = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
      paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
      paramMethodVisitor.visitJumpInsn(153, label4);
      if ((paramFieldInfo.serialzeFeatures & SerializerFeature.DisableCircularReferenceDetect.mask) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if ((paramFieldInfo.serialzeFeatures & SerializerFeature.BeanToArray.mask) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (bool1 || (paramContext.nonContext && paramContext.writeDirect)) {
        if (bool2) {
          str1 = "writeAsArrayNonContext";
        } else {
          str1 = "writeDirectNonContext";
        } 
      } else if (bool2) {
        str1 = "writeAsArray";
      } else {
        str1 = "write";
      } 
      paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
      paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, 0);
      String str3 = paramContext.className;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramFieldInfo.name);
      stringBuilder2.append("_asm_fieldType");
      paramMethodVisitor.visitFieldInsn(180, str3, stringBuilder2.toString(), "Ljava/lang/reflect/Type;");
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
      str3 = JavaBeanSerializer;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("(L");
      stringBuilder2.append(JSONSerializer);
      stringBuilder2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitMethodInsn(182, str3, str1, stringBuilder2.toString());
      paramMethodVisitor.visitJumpInsn(167, label3);
      paramMethodVisitor.visitLabel(label4);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, 0);
      String str2 = paramContext.className;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramFieldInfo.name);
      stringBuilder1.append("_asm_fieldType");
      paramMethodVisitor.visitFieldInsn(180, str2, stringBuilder1.toString(), "Ljava/lang/reflect/Type;");
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
      str2 = ObjectSerializer;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(L");
      stringBuilder1.append(JSONSerializer);
      stringBuilder1.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitMethodInsn(185, str2, "write", stringBuilder1.toString());
      paramMethodVisitor.visitLabel(label3);
      paramMethodVisitor.visitJumpInsn(167, label1);
    } 
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(25, 1);
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } else {
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
    } 
    if (str != null) {
      paramMethodVisitor.visitLdcInsn(str);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      if (paramFieldInfo.fieldType instanceof Class && ((Class)paramFieldInfo.fieldType).isPrimitive()) {
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
      } else {
        if (paramFieldInfo.fieldClass == String.class) {
          paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(String.class)));
        } else {
          paramMethodVisitor.visitVarInsn(25, 0);
          str = paramContext.className;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramFieldInfo.name);
          stringBuilder.append("_asm_fieldType");
          paramMethodVisitor.visitFieldInsn(180, str, stringBuilder.toString(), "Ljava/lang/reflect/Type;");
        } 
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      } 
    } 
    paramMethodVisitor.visitLabel(label1);
    _seperator(paramMethodVisitor, paramContext);
  }
  
  private void generateWriteAsArray(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo[] paramArrayOfFieldInfo, Context paramContext) throws Exception {
    ASMSerializerFactory aSMSerializerFactory = this;
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 91);
    String str = SerializeWriter;
    char c = '¶';
    paramMethodVisitor.visitMethodInsn(182, str, "write", "(I)V");
    int i = paramArrayOfFieldInfo.length;
    if (i == 0) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 93);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      return;
    } 
    for (byte b = 0; b < i; b++) {
      byte b1;
      if (b == i - 1) {
        b1 = 93;
      } else {
        b1 = 44;
      } 
      FieldInfo fieldInfo = paramArrayOfFieldInfo[b];
      Class<byte> clazz = fieldInfo.fieldClass;
      paramMethodVisitor.visitLdcInsn(fieldInfo.name);
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      if (clazz == byte.class || clazz == short.class || clazz == int.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        str = SerializeWriter;
        c = '¶';
        paramMethodVisitor.visitMethodInsn(182, str, "writeInt", "(I)V");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      } else if (clazz == long.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeLong", "(J)V");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(I)V");
      } else if (clazz == float.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitInsn(4);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeFloat", "(FZ)V");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(I)V");
      } else if (clazz == double.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitInsn(4);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeDouble", "(DZ)V");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(I)V");
      } else if (clazz == boolean.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(Z)V");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(I)V");
      } else if (clazz == char.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      } else if (clazz == String.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      } else if (clazz.isEnum()) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeEnum", "(Ljava/lang/Enum;)V");
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(I)V");
      } else {
        Label label;
        if (List.class.isAssignableFrom(clazz)) {
          Type type1;
          Type<byte> type = fieldInfo.fieldType;
          if (type instanceof Class) {
            type1 = Object.class;
          } else {
            type1 = ((ParameterizedType)type).getActualTypeArguments()[0];
          } 
          if (type1 instanceof Class) {
            clazz = (Class<byte>)type1;
            type = clazz;
            if (clazz == Object.class)
              type = null; 
          } else {
            type = null;
          } 
          aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
          paramMethodVisitor.visitTypeInsn(192, "java/util/List");
          paramMethodVisitor.visitVarInsn(58, paramContext.var("list"));
          if (type == String.class && paramContext.writeDirect) {
            paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
            paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
            paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "write", "(Ljava/util/List;)V");
          } else {
            label = new Label();
            Label label1 = new Label();
            paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
            paramMethodVisitor.visitJumpInsn(199, label1);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
            paramMethodVisitor.visitMethodInsn(c, SerializeWriter, "writeNull", "()V");
            paramMethodVisitor.visitJumpInsn(167, label);
            paramMethodVisitor.visitLabel(label1);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
            paramMethodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
            paramMethodVisitor.visitVarInsn(54, paramContext.var("size"));
            paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
            paramMethodVisitor.visitVarInsn(16, 91);
            paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
            label1 = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            paramMethodVisitor.visitInsn(3);
            paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
            paramMethodVisitor.visitLabel(label1);
            paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
            paramMethodVisitor.visitVarInsn(21, paramContext.var("size"));
            paramMethodVisitor.visitJumpInsn(162, label3);
            paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
            paramMethodVisitor.visitJumpInsn(153, label2);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
            paramMethodVisitor.visitVarInsn(16, 44);
            paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
            paramMethodVisitor.visitLabel(label2);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
            paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
            paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item"));
            label2 = new Label();
            Label label4 = new Label();
            paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
            paramMethodVisitor.visitJumpInsn(199, label4);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
            paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "()V");
            paramMethodVisitor.visitJumpInsn(167, label2);
            paramMethodVisitor.visitLabel(label4);
            label4 = new Label();
            Label label5 = new Label();
            if (type != null && Modifier.isPublic(type.getModifiers())) {
              paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
              paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
              paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)type)));
              paramMethodVisitor.visitJumpInsn(166, label5);
              aSMSerializerFactory._getListFieldItemSer(paramContext, paramMethodVisitor, fieldInfo, (Class<?>)type);
              paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_desc"));
              Label label7 = new Label();
              Label label6 = new Label();
              if (paramContext.writeDirect) {
                paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
                paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
                paramMethodVisitor.visitJumpInsn(153, label7);
                paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
                paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
                paramMethodVisitor.visitVarInsn(25, 1);
                paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
                if (paramContext.nonContext) {
                  paramMethodVisitor.visitInsn(1);
                } else {
                  paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
                  paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                } 
                paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)type)));
                paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                String str2 = JavaBeanSerializer;
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("(L");
                stringBuilder1.append(JSONSerializer);
                stringBuilder1.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                paramMethodVisitor.visitMethodInsn(182, str2, "writeAsArrayNonContext", stringBuilder1.toString());
                paramMethodVisitor.visitJumpInsn(167, label6);
                paramMethodVisitor.visitLabel(label7);
              } 
              paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
              paramMethodVisitor.visitVarInsn(25, 1);
              paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
              if (paramContext.nonContext) {
                paramMethodVisitor.visitInsn(1);
              } else {
                paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
                paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
              } 
              paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)type)));
              paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
              String str1 = ObjectSerializer;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("(L");
              stringBuilder.append(JSONSerializer);
              stringBuilder.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
              paramMethodVisitor.visitMethodInsn(185, str1, "write", stringBuilder.toString());
              paramMethodVisitor.visitLabel(label6);
              paramMethodVisitor.visitJumpInsn(167, label4);
            } 
            paramMethodVisitor.visitLabel(label5);
            paramMethodVisitor.visitVarInsn(25, 1);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
            if (paramContext.nonContext) {
              paramMethodVisitor.visitInsn(1);
            } else {
              paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
              paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } 
            if (type != null && Modifier.isPublic(type.getModifiers())) {
              paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)type1)));
              paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
              paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
              paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } 
            paramMethodVisitor.visitLabel(label4);
            paramMethodVisitor.visitLabel(label2);
            paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
            paramMethodVisitor.visitJumpInsn(167, label1);
            paramMethodVisitor.visitLabel(label3);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
            paramMethodVisitor.visitVarInsn(16, 93);
            paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
            paramMethodVisitor.visitLabel(label);
          } 
          paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
          paramMethodVisitor.visitVarInsn(16, b1);
          paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
        } else {
          Label label2 = new Label();
          Label label4 = new Label();
          aSMSerializerFactory = this;
          aSMSerializerFactory._get(paramMethodVisitor, paramContext, fieldInfo);
          paramMethodVisitor.visitInsn(89);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("field_");
          stringBuilder2.append(fieldInfo.fieldClass.getName());
          paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder2.toString()));
          paramMethodVisitor.visitJumpInsn(199, label4);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
          paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "()V");
          paramMethodVisitor.visitJumpInsn(167, label2);
          paramMethodVisitor.visitLabel(label4);
          Label label3 = new Label();
          label4 = new Label();
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append("field_");
          stringBuilder4.append(fieldInfo.fieldClass.getName());
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder4.toString()));
          paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
          paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)label)));
          paramMethodVisitor.visitJumpInsn(166, label4);
          aSMSerializerFactory._getFieldSer(paramContext, paramMethodVisitor, fieldInfo);
          paramMethodVisitor.visitVarInsn(58, paramContext.var("fied_ser"));
          Label label5 = new Label();
          Label label1 = new Label();
          if (paramContext.writeDirect && Modifier.isPublic(label.getModifiers())) {
            paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
            paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
            paramMethodVisitor.visitJumpInsn(153, label5);
            paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
            paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
            paramMethodVisitor.visitVarInsn(25, 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("field_");
            stringBuilder.append(fieldInfo.fieldClass.getName());
            paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
            paramMethodVisitor.visitVarInsn(25, Context.fieldName);
            paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)label)));
            paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            String str2 = JavaBeanSerializer;
            stringBuilder = new StringBuilder();
            stringBuilder.append("(L");
            stringBuilder.append(JSONSerializer);
            stringBuilder.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            paramMethodVisitor.visitMethodInsn(182, str2, "writeAsArrayNonContext", stringBuilder.toString());
            paramMethodVisitor.visitJumpInsn(167, label1);
            paramMethodVisitor.visitLabel(label5);
          } 
          paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
          paramMethodVisitor.visitVarInsn(25, 1);
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("field_");
          stringBuilder3.append(fieldInfo.fieldClass.getName());
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder3.toString()));
          paramMethodVisitor.visitVarInsn(25, Context.fieldName);
          paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)label)));
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
          String str1 = ObjectSerializer;
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append("(L");
          stringBuilder3.append(JSONSerializer);
          stringBuilder3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          paramMethodVisitor.visitMethodInsn(185, str1, "write", stringBuilder3.toString());
          paramMethodVisitor.visitLabel(label1);
          paramMethodVisitor.visitJumpInsn(167, label3);
          paramMethodVisitor.visitLabel(label4);
          str1 = fieldInfo.getFormat();
          paramMethodVisitor.visitVarInsn(25, 1);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("field_");
          stringBuilder1.append(fieldInfo.fieldClass.getName());
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder1.toString()));
          if (str1 != null) {
            paramMethodVisitor.visitLdcInsn(str1);
            paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
          } else {
            paramMethodVisitor.visitVarInsn(25, Context.fieldName);
            if (fieldInfo.fieldType instanceof Class && ((Class)fieldInfo.fieldType).isPrimitive()) {
              paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
              paramMethodVisitor.visitVarInsn(25, 0);
              String str2 = paramContext.className;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(fieldInfo.name);
              stringBuilder.append("_asm_fieldType");
              paramMethodVisitor.visitFieldInsn(180, str2, stringBuilder.toString(), "Ljava/lang/reflect/Type;");
              paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
              paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } 
          } 
          paramMethodVisitor.visitLabel(label3);
          paramMethodVisitor.visitLabel(label2);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
          paramMethodVisitor.visitVarInsn(16, b1);
          paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
        } 
        aSMSerializerFactory = this;
        c = '¶';
      } 
    } 
  }
  
  private void generateWriteMethod(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo[] paramArrayOfFieldInfo, Context paramContext) throws Exception {
    String str;
    Label label3 = new Label();
    int i = paramArrayOfFieldInfo.length;
    if (!paramContext.writeDirect) {
      Label label4 = new Label();
      Label label5 = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(154, label5);
      int j = paramArrayOfFieldInfo.length;
      byte b1 = 0;
      boolean bool = false;
      while (b1 < j) {
        if ((paramArrayOfFieldInfo[b1]).method != null)
          bool = true; 
        b1++;
      } 
      if (bool) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
        paramMethodVisitor.visitJumpInsn(153, label4);
      } else {
        paramMethodVisitor.visitJumpInsn(167, label4);
      } 
      paramMethodVisitor.visitLabel(label5);
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, 3);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(21, 5);
      String str1 = JavaBeanSerializer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(JSONSerializer);
      stringBuilder.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitMethodInsn(183, str1, "write", stringBuilder.toString());
      paramMethodVisitor.visitInsn(177);
      paramMethodVisitor.visitLabel(label4);
    } 
    if (!paramContext.nonContext) {
      Label label = new Label();
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(21, 5);
      String str1 = JavaBeanSerializer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(JSONSerializer);
      stringBuilder.append(";Ljava/lang/Object;I)Z");
      paramMethodVisitor.visitMethodInsn(182, str1, "writeReference", stringBuilder.toString());
      paramMethodVisitor.visitJumpInsn(153, label);
      paramMethodVisitor.visitInsn(177);
      paramMethodVisitor.visitLabel(label);
    } 
    if (paramContext.writeDirect) {
      if (paramContext.nonContext) {
        str = "writeAsArrayNonContext";
      } else {
        str = "writeAsArray";
      } 
    } else {
      str = "writeAsArrayNormal";
    } 
    if ((paramContext.beanInfo.features & SerializerFeature.BeanToArray.mask) == 0) {
      Label label = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.BeanToArray.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(153, label);
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, 3);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(21, 5);
      String str1 = paramContext.className;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(JSONSerializer);
      stringBuilder.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitMethodInsn(182, str1, str, stringBuilder.toString());
      paramMethodVisitor.visitInsn(177);
      paramMethodVisitor.visitLabel(label);
    } else {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, 3);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(21, 5);
      String str1 = paramContext.className;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(JSONSerializer);
      stringBuilder.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitMethodInsn(182, str1, str, stringBuilder.toString());
      paramMethodVisitor.visitInsn(177);
    } 
    if (!paramContext.nonContext) {
      paramMethodVisitor.visitVarInsn(25, 1);
      str = JSONSerializer;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("()");
      stringBuilder2.append(SerialContext_desc);
      paramMethodVisitor.visitMethodInsn(182, str, "getContext", stringBuilder2.toString());
      paramMethodVisitor.visitVarInsn(58, paramContext.var("parent"));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("parent"));
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, 3);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramContext.beanInfo.features));
      String str1 = JSONSerializer;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append(SerialContext_desc);
      stringBuilder1.append("Ljava/lang/Object;Ljava/lang/Object;I)V");
      paramMethodVisitor.visitMethodInsn(182, str1, "setContext", stringBuilder1.toString());
    } 
    if (!paramContext.writeDirect) {
      Label label4 = new Label();
      Label label5 = new Label();
      Label label6 = new Label();
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
      paramMethodVisitor.visitJumpInsn(153, label5);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
      paramMethodVisitor.visitJumpInsn(165, label5);
      paramMethodVisitor.visitLabel(label6);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 123);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      if (paramContext.beanInfo.typeKey != null) {
        paramMethodVisitor.visitLdcInsn(paramContext.beanInfo.typeKey);
      } else {
        paramMethodVisitor.visitInsn(1);
      } 
      paramMethodVisitor.visitVarInsn(25, 2);
      String str1 = JavaBeanSerializer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(JSONSerializer);
      stringBuilder.append(";Ljava/lang/String;Ljava/lang/Object;)V");
      paramMethodVisitor.visitMethodInsn(182, str1, "writeClassName", stringBuilder.toString());
      paramMethodVisitor.visitVarInsn(16, 44);
      paramMethodVisitor.visitJumpInsn(167, label4);
      paramMethodVisitor.visitLabel(label5);
      paramMethodVisitor.visitVarInsn(16, 123);
      paramMethodVisitor.visitLabel(label4);
    } else {
      paramMethodVisitor.visitVarInsn(16, 123);
    } 
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
    if (!paramContext.writeDirect)
      _before(paramMethodVisitor, paramContext); 
    if (!paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isNotWriteDefaultValue", "()Z");
      paramMethodVisitor.visitVarInsn(54, paramContext.var("notWriteDefaultValue"));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 0);
      String str1 = JSONSerializer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(SerializeFilterable_desc);
      stringBuilder.append(")Z");
      paramMethodVisitor.visitMethodInsn(182, str1, "checkValue", stringBuilder.toString());
      paramMethodVisitor.visitVarInsn(54, paramContext.var("checkValue"));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 0);
      str1 = JSONSerializer;
      stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(SerializeFilterable_desc);
      stringBuilder.append(")Z");
      paramMethodVisitor.visitMethodInsn(182, str1, "hasNameFilters", stringBuilder.toString());
      paramMethodVisitor.visitVarInsn(54, paramContext.var("hasNameFilters"));
    } 
    for (byte b = 0; b < i; b++) {
      FieldInfo fieldInfo = paramArrayOfFieldInfo[b];
      Class<byte> clazz = fieldInfo.fieldClass;
      paramMethodVisitor.visitLdcInsn(fieldInfo.name);
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      if (clazz == byte.class || clazz == short.class || clazz == int.class) {
        _int(paramClass, paramMethodVisitor, fieldInfo, paramContext, paramContext.var(clazz.getName()), 'I');
      } else if (clazz == long.class) {
        _long(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == float.class) {
        _float(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == double.class) {
        _double(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == boolean.class) {
        _int(paramClass, paramMethodVisitor, fieldInfo, paramContext, paramContext.var("boolean"), 'Z');
      } else if (clazz == char.class) {
        _int(paramClass, paramMethodVisitor, fieldInfo, paramContext, paramContext.var("char"), 'C');
      } else if (clazz == String.class) {
        _string(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == BigDecimal.class) {
        _decimal(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (List.class.isAssignableFrom(clazz)) {
        _list(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz.isEnum()) {
        _enum(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else {
        _object(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } 
    } 
    if (!paramContext.writeDirect)
      _after(paramMethodVisitor, paramContext); 
    Label label2 = new Label();
    Label label1 = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitIntInsn(16, 123);
    paramMethodVisitor.visitJumpInsn(160, label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 123);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 125);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitLabel(label3);
    if (!paramContext.nonContext) {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("parent"));
      String str1 = JSONSerializer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(SerialContext_desc);
      stringBuilder.append(")V");
      paramMethodVisitor.visitMethodInsn(182, str1, "setContext", stringBuilder.toString());
    } 
  }
  
  public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo paramSerializeBeanInfo) throws Exception {
    Class<?> clazz = paramSerializeBeanInfo.beanType;
    if (!clazz.isPrimitive()) {
      JSONType jSONType = clazz.<JSONType>getAnnotation(JSONType.class);
      for (FieldInfo fieldInfo : paramSerializeBeanInfo.fields) {
        if (fieldInfo.field == null && fieldInfo.method != null && fieldInfo.method.getDeclaringClass().isInterface())
          return new JavaBeanSerializer(clazz); 
      } 
      FieldInfo[] arrayOfFieldInfo = paramSerializeBeanInfo.sortedFields;
      if (paramSerializeBeanInfo.sortedFields == paramSerializeBeanInfo.fields) {
        b = 1;
      } else {
        b = 0;
      } 
      if (arrayOfFieldInfo.length > 256)
        return new JavaBeanSerializer(clazz); 
      int j = arrayOfFieldInfo.length;
      int i;
      for (i = 0; i < j; i++) {
        if (!ASMUtils.checkName(arrayOfFieldInfo[i].getMember().getName()))
          return new JavaBeanSerializer(clazz); 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ASMSerializer_");
      stringBuilder1.append(this.seed.incrementAndGet());
      stringBuilder1.append("_");
      stringBuilder1.append(clazz.getSimpleName());
      String str2 = stringBuilder1.toString();
      String str3 = ASMSerializerFactory.class.getPackage().getName();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3.replace('.', '/'));
      stringBuilder1.append("/");
      stringBuilder1.append(str2);
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(str3);
      stringBuilder3.append(".");
      stringBuilder3.append(str2);
      String str4 = stringBuilder3.toString();
      ClassWriter classWriter = new ClassWriter();
      classWriter.visit(49, 33, str1, JavaBeanSerializer, new String[] { ObjectSerializer });
      i = arrayOfFieldInfo.length;
      for (j = 0; j < i; j++) {
        FieldInfo fieldInfo = arrayOfFieldInfo[j];
        if (!fieldInfo.fieldClass.isPrimitive() && fieldInfo.fieldClass != String.class) {
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm_fieldType");
          (new FieldWriter(classWriter, 1, stringBuilder5.toString(), "Ljava/lang/reflect/Type;")).visitEnd();
          if (List.class.isAssignableFrom(fieldInfo.fieldClass)) {
            stringBuilder5 = new StringBuilder();
            stringBuilder5.append(fieldInfo.name);
            stringBuilder5.append("_asm_list_item_ser_");
            (new FieldWriter(classWriter, 1, stringBuilder5.toString(), ObjectSerializer_desc)).visitEnd();
          } 
          stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm_ser_");
          (new FieldWriter(classWriter, 1, stringBuilder5.toString(), ObjectSerializer_desc)).visitEnd();
        } 
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("(");
      stringBuilder2.append(ASMUtils.desc(SerializeBeanInfo.class));
      stringBuilder2.append(")V");
      MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", stringBuilder2.toString(), null, null);
      methodWriter.visitVarInsn(25, 0);
      methodWriter.visitVarInsn(25, 1);
      String str5 = JavaBeanSerializer;
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("(");
      stringBuilder4.append(ASMUtils.desc(SerializeBeanInfo.class));
      stringBuilder4.append(")V");
      methodWriter.visitMethodInsn(183, str5, "<init>", stringBuilder4.toString());
      for (i = 0; i < arrayOfFieldInfo.length; i++) {
        FieldInfo fieldInfo = arrayOfFieldInfo[i];
        if (!fieldInfo.fieldClass.isPrimitive() && fieldInfo.fieldClass != String.class) {
          methodWriter.visitVarInsn(25, 0);
          if (fieldInfo.method != null) {
            methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.declaringClass)));
            methodWriter.visitLdcInsn(fieldInfo.method.getName());
            methodWriter.visitMethodInsn(184, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
          } else {
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn(Integer.valueOf(i));
            methodWriter.visitMethodInsn(183, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
          } 
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm_fieldType");
          methodWriter.visitFieldInsn(181, str1, stringBuilder5.toString(), "Ljava/lang/reflect/Type;");
        } 
      } 
      methodWriter.visitInsn(177);
      methodWriter.visitMaxs(4, 4);
      methodWriter.visitEnd();
      if (jSONType != null) {
        SerializerFeature[] arrayOfSerializerFeature = jSONType.serialzeFeatures();
        j = arrayOfSerializerFeature.length;
        for (i = 0; i < j; i++) {
          if (arrayOfSerializerFeature[i] == SerializerFeature.DisableCircularReferenceDetect) {
            boolean bool1 = true;
            // Byte code: goto -> 1036
          } 
        } 
      } 
      boolean bool = false;
      for (i = 0; i < 3; i++) {
        String str;
        boolean bool1;
        boolean bool2;
        if (i == 0) {
          str = "write";
          bool1 = bool;
          bool2 = true;
        } else if (i == 1) {
          str = "writeNormal";
          bool1 = bool;
          bool2 = false;
        } else {
          str = "writeDirectNonContext";
          bool2 = true;
          bool1 = true;
        } 
        Context context = new Context(arrayOfFieldInfo, paramSerializeBeanInfo, str1, bool2, bool1);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("(L");
        stringBuilder5.append(JSONSerializer);
        stringBuilder5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        MethodWriter methodWriter1 = new MethodWriter(classWriter, 1, str, stringBuilder5.toString(), null, new String[] { "java/io/IOException" });
        Label label = new Label();
        methodWriter1.visitVarInsn(25, 2);
        methodWriter1.visitJumpInsn(199, label);
        methodWriter1.visitVarInsn(25, 1);
        methodWriter1.visitMethodInsn(182, JSONSerializer, "writeNull", "()V");
        methodWriter1.visitInsn(177);
        methodWriter1.visitLabel(label);
        methodWriter1.visitVarInsn(25, 1);
        methodWriter1.visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
        methodWriter1.visitVarInsn(58, context.var("out"));
        if (!b && !context.writeDirect && (jSONType == null || jSONType.alphabetic())) {
          Label label1 = new Label();
          methodWriter1.visitVarInsn(25, context.var("out"));
          methodWriter1.visitMethodInsn(182, SerializeWriter, "isSortField", "()Z");
          methodWriter1.visitJumpInsn(154, label1);
          methodWriter1.visitVarInsn(25, 0);
          methodWriter1.visitVarInsn(25, 1);
          methodWriter1.visitVarInsn(25, 2);
          methodWriter1.visitVarInsn(25, 3);
          methodWriter1.visitVarInsn(25, 4);
          methodWriter1.visitVarInsn(21, 5);
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append("(L");
          stringBuilder6.append(JSONSerializer);
          stringBuilder6.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          methodWriter1.visitMethodInsn(182, str1, "writeUnsorted", stringBuilder6.toString());
          methodWriter1.visitInsn(177);
          methodWriter1.visitLabel(label1);
        } 
        if (context.writeDirect && !bool1) {
          label = new Label();
          Label label1 = new Label();
          methodWriter1.visitVarInsn(25, 0);
          methodWriter1.visitVarInsn(25, 1);
          String str6 = JavaBeanSerializer;
          StringBuilder stringBuilder8 = new StringBuilder();
          stringBuilder8.append("(L");
          stringBuilder8.append(JSONSerializer);
          stringBuilder8.append(";)Z");
          methodWriter1.visitMethodInsn(182, str6, "writeDirect", stringBuilder8.toString());
          methodWriter1.visitJumpInsn(154, label1);
          methodWriter1.visitVarInsn(25, 0);
          methodWriter1.visitVarInsn(25, 1);
          methodWriter1.visitVarInsn(25, 2);
          methodWriter1.visitVarInsn(25, 3);
          methodWriter1.visitVarInsn(25, 4);
          methodWriter1.visitVarInsn(21, 5);
          StringBuilder stringBuilder7 = new StringBuilder();
          stringBuilder7.append("(L");
          stringBuilder7.append(JSONSerializer);
          stringBuilder7.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          methodWriter1.visitMethodInsn(182, str1, "writeNormal", stringBuilder7.toString());
          methodWriter1.visitInsn(177);
          methodWriter1.visitLabel(label1);
          methodWriter1.visitVarInsn(25, context.var("out"));
          methodWriter1.visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
          methodWriter1.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
          methodWriter1.visitJumpInsn(153, label);
          methodWriter1.visitVarInsn(25, 0);
          methodWriter1.visitVarInsn(25, 1);
          methodWriter1.visitVarInsn(25, 2);
          methodWriter1.visitVarInsn(25, 3);
          methodWriter1.visitVarInsn(25, 4);
          methodWriter1.visitVarInsn(21, 5);
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append("(L");
          stringBuilder6.append(JSONSerializer);
          stringBuilder6.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          methodWriter1.visitMethodInsn(182, str1, "writeDirectNonContext", stringBuilder6.toString());
          methodWriter1.visitInsn(177);
          methodWriter1.visitLabel(label);
        } 
        methodWriter1.visitVarInsn(25, 2);
        methodWriter1.visitTypeInsn(192, ASMUtils.type(clazz));
        methodWriter1.visitVarInsn(58, context.var("entity"));
        generateWriteMethod(clazz, (MethodVisitor)methodWriter1, arrayOfFieldInfo, context);
        methodWriter1.visitInsn(177);
        methodWriter1.visitMaxs(7, context.variantIndex + 2);
        methodWriter1.visitEnd();
      } 
      if (!b) {
        Context context = new Context(arrayOfFieldInfo, paramSerializeBeanInfo, str1, false, bool);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("(L");
        stringBuilder5.append(JSONSerializer);
        stringBuilder5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        MethodWriter methodWriter1 = new MethodWriter(classWriter, 1, "writeUnsorted", stringBuilder5.toString(), null, new String[] { "java/io/IOException" });
        methodWriter1.visitVarInsn(25, 1);
        methodWriter1.visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
        methodWriter1.visitVarInsn(58, context.var("out"));
        methodWriter1.visitVarInsn(25, 2);
        methodWriter1.visitTypeInsn(192, ASMUtils.type(clazz));
        methodWriter1.visitVarInsn(58, context.var("entity"));
        generateWriteMethod(clazz, (MethodVisitor)methodWriter1, (FieldInfo[])SYNTHETIC_LOCAL_VARIABLE_4, context);
        methodWriter1.visitInsn(177);
        methodWriter1.visitMaxs(7, context.variantIndex + 2);
        methodWriter1.visitEnd();
      } 
      for (byte b = 0; b < 3; b++) {
        String str;
        boolean bool1;
        boolean bool2;
        if (b == 0) {
          str = "writeAsArray";
          bool1 = bool;
          bool2 = true;
        } else if (b == 1) {
          str = "writeAsArrayNormal";
          bool1 = bool;
          bool2 = false;
        } else {
          str = "writeAsArrayNonContext";
          bool2 = true;
          bool1 = true;
        } 
        Context context = new Context(arrayOfFieldInfo, paramSerializeBeanInfo, str1, bool2, bool1);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("(L");
        stringBuilder5.append(JSONSerializer);
        stringBuilder5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        MethodWriter methodWriter1 = new MethodWriter(classWriter, 1, str, stringBuilder5.toString(), null, new String[] { "java/io/IOException" });
        methodWriter1.visitVarInsn(25, 1);
        methodWriter1.visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
        methodWriter1.visitVarInsn(58, context.var("out"));
        methodWriter1.visitVarInsn(25, 2);
        methodWriter1.visitTypeInsn(192, ASMUtils.type(clazz));
        methodWriter1.visitVarInsn(58, context.var("entity"));
        generateWriteAsArray(clazz, (MethodVisitor)methodWriter1, arrayOfFieldInfo, context);
        methodWriter1.visitInsn(177);
        methodWriter1.visitMaxs(7, context.variantIndex + 2);
        methodWriter1.visitEnd();
      } 
      byte[] arrayOfByte = classWriter.toByteArray();
      return this.classLoader.defineClassPublic(str4, arrayOfByte, 0, arrayOfByte.length).getConstructor(new Class[] { SerializeBeanInfo.class }).newInstance(new Object[] { paramSerializeBeanInfo });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unsupportd class ");
    stringBuilder.append(clazz.getName());
    throw new JSONException(stringBuilder.toString());
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("L");
    stringBuilder.append(ObjectSerializer);
    stringBuilder.append(";");
    ObjectSerializer_desc = stringBuilder.toString();
  }
  
  static class Context {
    static final int features = 5;
    
    static int fieldName = 6;
    
    static final int obj = 2;
    
    static int original = 7;
    
    static final int paramFieldName = 3;
    
    static final int paramFieldType = 4;
    
    static int processValue = 8;
    
    static final int serializer = 1;
    
    private final SerializeBeanInfo beanInfo;
    
    private final String className;
    
    private final FieldInfo[] getters;
    
    private boolean nonContext;
    
    private int variantIndex = 9;
    
    private Map<String, Integer> variants = new HashMap<String, Integer>();
    
    private final boolean writeDirect;
    
    public Context(FieldInfo[] param1ArrayOfFieldInfo, SerializeBeanInfo param1SerializeBeanInfo, String param1String, boolean param1Boolean1, boolean param1Boolean2) {
      this.getters = param1ArrayOfFieldInfo;
      this.className = param1String;
      this.beanInfo = param1SerializeBeanInfo;
      this.writeDirect = param1Boolean1;
      this.nonContext = param1Boolean2;
    }
    
    public int getFieldOrinal(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: getfield getters : [Lcom/alibaba/fastjson/util/FieldInfo;
      //   4: arraylength
      //   5: istore_2
      //   6: iconst_0
      //   7: istore_3
      //   8: iload_3
      //   9: iload_2
      //   10: if_icmpge -> 38
      //   13: aload_0
      //   14: getfield getters : [Lcom/alibaba/fastjson/util/FieldInfo;
      //   17: iload_3
      //   18: aaload
      //   19: getfield name : Ljava/lang/String;
      //   22: aload_1
      //   23: invokevirtual equals : (Ljava/lang/Object;)Z
      //   26: ifeq -> 32
      //   29: goto -> 40
      //   32: iinc #3, 1
      //   35: goto -> 8
      //   38: iconst_m1
      //   39: istore_3
      //   40: iload_3
      //   41: ireturn
    }
    
    public int var(String param1String) {
      if ((Integer)this.variants.get(param1String) == null) {
        Map<String, Integer> map = this.variants;
        int i = this.variantIndex;
        this.variantIndex = i + 1;
        map.put(param1String, Integer.valueOf(i));
      } 
      return ((Integer)this.variants.get(param1String)).intValue();
    }
    
    public int var(String param1String, int param1Int) {
      if ((Integer)this.variants.get(param1String) == null) {
        this.variants.put(param1String, Integer.valueOf(this.variantIndex));
        this.variantIndex += param1Int;
      } 
      return ((Integer)this.variants.get(param1String)).intValue();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ASMSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
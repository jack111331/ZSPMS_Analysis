package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory implements Opcodes {
  static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
  
  static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
  
  public final ASMClassLoader classLoader;
  
  protected final AtomicLong seed;
  
  public ASMDeserializerFactory(ClassLoader paramClassLoader) {
    ASMClassLoader aSMClassLoader;
    this.seed = new AtomicLong();
    if (paramClassLoader instanceof ASMClassLoader) {
      aSMClassLoader = (ASMClassLoader)paramClassLoader;
    } else {
      aSMClassLoader = new ASMClassLoader((ClassLoader)aSMClassLoader);
    } 
    this.classLoader = aSMClassLoader;
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor) {
    _batchSet(paramContext, paramMethodVisitor, true);
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor, boolean paramBoolean) {
    int i = paramContext.fieldInfoList.length;
    for (byte b = 0; b < i; b++) {
      Label label = new Label();
      if (paramBoolean)
        _isFlag(paramMethodVisitor, paramContext, b, label); 
      _loadAndSet(paramContext, paramMethodVisitor, paramContext.fieldInfoList[b]);
      if (paramBoolean)
        paramMethodVisitor.visitLabel(label); 
    } 
  }
  
  private void _createInstance(ClassWriter paramClassWriter, Context paramContext) {
    if (!Modifier.isPublic(paramContext.beanInfo.defaultConstructor.getModifiers()))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(DefaultJSONParser);
    stringBuilder.append(";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "createInstance", stringBuilder.toString(), null, null);
    methodWriter.visitTypeInsn(187, ASMUtils.type(paramContext.getInstClass()));
    methodWriter.visitInsn(89);
    methodWriter.visitMethodInsn(183, ASMUtils.type(paramContext.getInstClass()), "<init>", "()V");
    methodWriter.visitInsn(176);
    methodWriter.visitMaxs(3, 3);
    methodWriter.visitEnd();
  }
  
  private void _createInstance(Context paramContext, MethodVisitor paramMethodVisitor) {
    Constructor constructor = paramContext.beanInfo.defaultConstructor;
    if (Modifier.isPublic(constructor.getModifiers())) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(paramContext.getInstClass()));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
      paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
    } else {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
      String str = ASMUtils.type(JavaBeanDeserializer.class);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(DefaultJSONParser);
      stringBuilder.append(";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
      paramMethodVisitor.visitMethodInsn(183, str, "createInstance", stringBuilder.toString());
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramContext.getInstClass()));
      paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
    } 
  }
  
  private void _deserObject(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt) {
    _getFieldDeser(paramContext, paramMethodVisitor, paramFieldInfo);
    Label label1 = new Label();
    Label label2 = new Label();
    if ((paramFieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
      paramMethodVisitor.visitJumpInsn(153, label1);
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
      paramMethodVisitor.visitVarInsn(25, 1);
      if (paramFieldInfo.fieldType instanceof Class) {
        paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
      } else {
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
        paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
      } 
      paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.parserFeatures));
      String str1 = ASMUtils.type(JavaBeanDeserializer.class);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(DefaultJSONParser);
      stringBuilder.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
      paramMethodVisitor.visitMethodInsn(182, str1, "deserialze", stringBuilder.toString());
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramFieldInfo.name);
      stringBuilder.append("_asm");
      paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder.toString()));
      paramMethodVisitor.visitJumpInsn(167, label2);
      paramMethodVisitor.visitLabel(label1);
    } 
    paramMethodVisitor.visitVarInsn(25, 1);
    if (paramFieldInfo.fieldType instanceof Class) {
      paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    } else {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
    } 
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    String str = ASMUtils.type(ObjectDeserializer.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(L");
    stringBuilder2.append(DefaultJSONParser);
    stringBuilder2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(185, str, "deserialze", stringBuilder2.toString());
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
    paramMethodVisitor.visitLabel(label2);
  }
  
  private void _deserialize_endCheck(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel) {
    paramMethodVisitor.visitIntInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitJumpInsn(158, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(13));
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _quickNextTokenComma(paramContext, paramMethodVisitor);
  }
  
  private void _deserialze(ClassWriter paramClassWriter, Context paramContext) {
    if (paramContext.fieldInfoList.length == 0)
      return; 
    for (FieldInfo fieldInfo : paramContext.fieldInfoList) {
      Class<char> clazz = fieldInfo.fieldClass;
      Type type = fieldInfo.fieldType;
      if (clazz == char.class)
        return; 
      if (Collection.class.isAssignableFrom(clazz))
        if (type instanceof ParameterizedType) {
          if (!(((ParameterizedType)type).getActualTypeArguments()[0] instanceof Class))
            return; 
        } else {
          return;
        }  
    } 
    JavaBeanInfo javaBeanInfo = paramContext.beanInfo;
    Context.access$202(paramContext, javaBeanInfo.sortedFields);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(L");
    stringBuilder1.append(DefaultJSONParser);
    stringBuilder1.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "deserialze", stringBuilder1.toString(), null, null);
    Label label2 = new Label();
    Label label1 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    defineVarLexer(paramContext, (MethodVisitor)methodWriter);
    Label label5 = new Label();
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    methodWriter.visitLdcInsn(Integer.valueOf(14));
    methodWriter.visitJumpInsn(160, label5);
    if ((javaBeanInfo.parserFeatures & Feature.SupportArrayToBean.mask) == 0) {
      methodWriter.visitVarInsn(25, paramContext.var("lexer"));
      methodWriter.visitVarInsn(21, 4);
      methodWriter.visitLdcInsn(Integer.valueOf(Feature.SupportArrayToBean.mask));
      methodWriter.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(II)Z");
      methodWriter.visitJumpInsn(153, label5);
    } 
    methodWriter.visitVarInsn(25, 0);
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, 2);
    methodWriter.visitVarInsn(25, 3);
    methodWriter.visitInsn(1);
    String str3 = paramContext.className;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("(L");
    stringBuilder4.append(DefaultJSONParser);
    stringBuilder4.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
    methodWriter.visitMethodInsn(183, str3, "deserialzeArrayMapping", stringBuilder4.toString());
    methodWriter.visitInsn(176);
    methodWriter.visitLabel(label5);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(Integer.valueOf(Feature.SortFeidFastMatch.mask));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(I)Z");
    methodWriter.visitJumpInsn(153, label1);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(paramContext.clazz.getName());
    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanType", "(Ljava/lang/String;)I");
    methodWriter.visitLdcInsn(Integer.valueOf(-1));
    methodWriter.visitJumpInsn(159, label1);
    methodWriter.visitVarInsn(25, 1);
    str3 = DefaultJSONParser;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("()");
    stringBuilder3.append(ASMUtils.desc(ParseContext.class));
    methodWriter.visitMethodInsn(182, str3, "getContext", stringBuilder3.toString());
    methodWriter.visitVarInsn(58, paramContext.var("mark_context"));
    methodWriter.visitInsn(3);
    methodWriter.visitVarInsn(54, paramContext.var("matchedCount"));
    _createInstance(paramContext, (MethodVisitor)methodWriter);
    methodWriter.visitVarInsn(25, 1);
    str3 = DefaultJSONParser;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("()");
    stringBuilder3.append(ASMUtils.desc(ParseContext.class));
    methodWriter.visitMethodInsn(182, str3, "getContext", stringBuilder3.toString());
    methodWriter.visitVarInsn(58, paramContext.var("context"));
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, paramContext.var("context"));
    methodWriter.visitVarInsn(25, paramContext.var("instance"));
    methodWriter.visitVarInsn(25, 3);
    str3 = DefaultJSONParser;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("(");
    stringBuilder3.append(ASMUtils.desc(ParseContext.class));
    stringBuilder3.append("Ljava/lang/Object;Ljava/lang/Object;)");
    stringBuilder3.append(ASMUtils.desc(ParseContext.class));
    methodWriter.visitMethodInsn(182, str3, "setContext", stringBuilder3.toString());
    methodWriter.visitVarInsn(58, paramContext.var("childContext"));
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
    methodWriter.visitLdcInsn(Integer.valueOf(4));
    methodWriter.visitJumpInsn(159, label3);
    methodWriter.visitInsn(3);
    methodWriter.visitIntInsn(54, paramContext.var("matchStat"));
    int i = paramContext.fieldInfoList.length;
    int j;
    for (j = 0; j < i; j += 32) {
      methodWriter.visitInsn(3);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_asm_flag_");
      stringBuilder.append(j / 32);
      methodWriter.visitVarInsn(54, paramContext.var(stringBuilder.toString()));
    } 
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(I)Z");
    methodWriter.visitIntInsn(54, paramContext.var("initStringFieldAsEmpty"));
    for (j = 0; j < i; j++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[j];
      Class<boolean> clazz = fieldInfo.fieldClass;
      if (clazz == boolean.class || clazz == byte.class || clazz == short.class || clazz == int.class) {
        methodWriter.visitInsn(3);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder3.toString()));
      } else if (clazz == long.class) {
        methodWriter.visitInsn(9);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm");
        methodWriter.visitVarInsn(55, paramContext.var(stringBuilder3.toString(), 2));
      } else if (clazz == float.class) {
        methodWriter.visitInsn(11);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm");
        methodWriter.visitVarInsn(56, paramContext.var(stringBuilder3.toString()));
      } else if (clazz == double.class) {
        methodWriter.visitInsn(14);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm");
        methodWriter.visitVarInsn(57, paramContext.var(stringBuilder3.toString(), 2));
      } else {
        if (clazz == String.class) {
          Label label7 = new Label();
          Label label6 = new Label();
          methodWriter.visitVarInsn(21, paramContext.var("initStringFieldAsEmpty"));
          methodWriter.visitJumpInsn(153, label6);
          _setFlag((MethodVisitor)methodWriter, paramContext, j);
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitMethodInsn(182, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
          methodWriter.visitJumpInsn(167, label7);
          methodWriter.visitLabel(label6);
          methodWriter.visitInsn(1);
          methodWriter.visitLabel(label7);
        } else {
          methodWriter.visitInsn(1);
        } 
        methodWriter.visitTypeInsn(192, ASMUtils.type(clazz));
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm");
        methodWriter.visitVarInsn(58, paramContext.var(stringBuilder3.toString()));
      } 
    } 
    for (j = 0;; j++) {
      if (j < i) {
        MethodWriter methodWriter1;
        StringBuilder stringBuilder;
        FieldInfo fieldInfo = paramContext.fieldInfoList[j];
        Class<boolean> clazz = fieldInfo.fieldClass;
        Type type = fieldInfo.fieldType;
        Label label6 = new Label();
        if (clazz == boolean.class) {
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitVarInsn(25, 0);
          String str = paramContext.className;
          stringBuilder = new StringBuilder();
          stringBuilder.append(fieldInfo.name);
          stringBuilder.append("_asm_prefix__");
          methodWriter.visitFieldInsn(180, str, stringBuilder.toString(), "[C");
          methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldBoolean", "([C)Z");
          stringBuilder = new StringBuilder();
          stringBuilder.append(fieldInfo.name);
          stringBuilder.append("_asm");
          methodWriter.visitVarInsn(54, paramContext.var(stringBuilder.toString()));
        } else {
          StringBuilder stringBuilder5;
          if (stringBuilder == byte.class) {
            methodWriter.visitVarInsn(25, paramContext.var("lexer"));
            methodWriter.visitVarInsn(25, 0);
            String str = paramContext.className;
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(fieldInfo.name);
            stringBuilder6.append("_asm_prefix__");
            methodWriter.visitFieldInsn(180, str, stringBuilder6.toString(), "[C");
            methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
            stringBuilder5 = new StringBuilder();
            stringBuilder5.append(fieldInfo.name);
            stringBuilder5.append("_asm");
            methodWriter.visitVarInsn(54, paramContext.var(stringBuilder5.toString()));
          } else {
            StringBuilder stringBuilder6;
            if (stringBuilder5 == short.class) {
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitVarInsn(25, 0);
              String str = paramContext.className;
              StringBuilder stringBuilder7 = new StringBuilder();
              stringBuilder7.append(fieldInfo.name);
              stringBuilder7.append("_asm_prefix__");
              methodWriter.visitFieldInsn(180, str, stringBuilder7.toString(), "[C");
              methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
              stringBuilder6 = new StringBuilder();
              stringBuilder6.append(fieldInfo.name);
              stringBuilder6.append("_asm");
              methodWriter.visitVarInsn(54, paramContext.var(stringBuilder6.toString()));
            } else {
              StringBuilder stringBuilder7;
              if (stringBuilder6 == int.class) {
                methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                String str = paramContext.className;
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(fieldInfo.name);
                stringBuilder8.append("_asm_prefix__");
                methodWriter.visitFieldInsn(180, str, stringBuilder8.toString(), "[C");
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(fieldInfo.name);
                stringBuilder7.append("_asm");
                methodWriter.visitVarInsn(54, paramContext.var(stringBuilder7.toString()));
              } else if (stringBuilder7 == long.class) {
                methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                String str = paramContext.className;
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(fieldInfo.name);
                stringBuilder7.append("_asm_prefix__");
                methodWriter.visitFieldInsn(180, str, stringBuilder7.toString(), "[C");
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldLong", "([C)J");
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(fieldInfo.name);
                stringBuilder7.append("_asm");
                methodWriter.visitVarInsn(55, paramContext.var(stringBuilder7.toString(), 2));
              } else {
                StringBuilder stringBuilder8;
                if (stringBuilder7 == float.class) {
                  methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                  methodWriter.visitVarInsn(25, 0);
                  String str = paramContext.className;
                  StringBuilder stringBuilder9 = new StringBuilder();
                  stringBuilder9.append(fieldInfo.name);
                  stringBuilder9.append("_asm_prefix__");
                  methodWriter.visitFieldInsn(180, str, stringBuilder9.toString(), "[C");
                  methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloat", "([C)F");
                  stringBuilder8 = new StringBuilder();
                  stringBuilder8.append(fieldInfo.name);
                  stringBuilder8.append("_asm");
                  methodWriter.visitVarInsn(56, paramContext.var(stringBuilder8.toString()));
                } else {
                  StringBuilder stringBuilder9;
                  if (stringBuilder8 == double.class) {
                    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                    methodWriter.visitVarInsn(25, 0);
                    String str = paramContext.className;
                    StringBuilder stringBuilder10 = new StringBuilder();
                    stringBuilder10.append(fieldInfo.name);
                    stringBuilder10.append("_asm_prefix__");
                    methodWriter.visitFieldInsn(180, str, stringBuilder10.toString(), "[C");
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldDouble", "([C)D");
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm");
                    methodWriter.visitVarInsn(57, paramContext.var(stringBuilder9.toString(), 2));
                  } else if (stringBuilder9 == String.class) {
                    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                    methodWriter.visitVarInsn(25, 0);
                    String str = paramContext.className;
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm_prefix__");
                    methodWriter.visitFieldInsn(180, str, stringBuilder9.toString(), "[C");
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm");
                    methodWriter.visitVarInsn(58, paramContext.var(stringBuilder9.toString()));
                  } else if (stringBuilder9 == int[].class) {
                    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                    methodWriter.visitVarInsn(25, 0);
                    String str = paramContext.className;
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm_prefix__");
                    methodWriter.visitFieldInsn(180, str, stringBuilder9.toString(), "[C");
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldIntArray", "([C)[I");
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm");
                    methodWriter.visitVarInsn(58, paramContext.var(stringBuilder9.toString()));
                  } else if (stringBuilder9 == float[].class) {
                    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                    methodWriter.visitVarInsn(25, 0);
                    String str = paramContext.className;
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm_prefix__");
                    methodWriter.visitFieldInsn(180, str, stringBuilder9.toString(), "[C");
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloatArray", "([C)[F");
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm");
                    methodWriter.visitVarInsn(58, paramContext.var(stringBuilder9.toString()));
                  } else if (stringBuilder9 == float[][].class) {
                    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                    methodWriter.visitVarInsn(25, 0);
                    String str = paramContext.className;
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm_prefix__");
                    methodWriter.visitFieldInsn(180, str, stringBuilder9.toString(), "[C");
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloatArray2", "([C)[[F");
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo.name);
                    stringBuilder9.append("_asm");
                    methodWriter.visitVarInsn(58, paramContext.var(stringBuilder9.toString()));
                  } else {
                    String str;
                    if (stringBuilder9.isEnum()) {
                      methodWriter.visitVarInsn(25, 0);
                      methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                      methodWriter.visitVarInsn(25, 0);
                      String str4 = paramContext.className;
                      StringBuilder stringBuilder10 = new StringBuilder();
                      stringBuilder10.append(fieldInfo.name);
                      stringBuilder10.append("_asm_prefix__");
                      methodWriter.visitFieldInsn(180, str4, stringBuilder10.toString(), "[C");
                      _getFieldDeser(paramContext, (MethodVisitor)methodWriter, fieldInfo);
                      str = ASMUtils.type(JavaBeanDeserializer.class);
                      StringBuilder stringBuilder11 = new StringBuilder();
                      stringBuilder11.append("(L");
                      stringBuilder11.append(JSONLexerBase);
                      stringBuilder11.append(";[C");
                      stringBuilder11.append(ASMUtils.desc(ObjectDeserializer.class));
                      stringBuilder11.append(")Ljava/lang/Enum;");
                      methodWriter.visitMethodInsn(182, str, "scanEnum", stringBuilder11.toString());
                      methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder9));
                      stringBuilder9 = new StringBuilder();
                      stringBuilder9.append(fieldInfo.name);
                      stringBuilder9.append("_asm");
                      methodWriter.visitVarInsn(58, paramContext.var(stringBuilder9.toString()));
                    } else if (Collection.class.isAssignableFrom((Class<?>)stringBuilder9)) {
                      String str4;
                      methodWriter.visitVarInsn(25, paramContext.var("lexer"));
                      methodWriter.visitVarInsn(25, 0);
                      String str5 = paramContext.className;
                      StringBuilder stringBuilder10 = new StringBuilder();
                      stringBuilder10.append(fieldInfo.name);
                      stringBuilder10.append("_asm_prefix__");
                      methodWriter.visitFieldInsn(180, str5, stringBuilder10.toString(), "[C");
                      Class<String> clazz1 = TypeUtils.getCollectionItemClass((Type)str);
                      if (clazz1 == String.class) {
                        methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder9)));
                        str4 = JSONLexerBase;
                        stringBuilder9 = new StringBuilder();
                        stringBuilder9.append("([CLjava/lang/Class;)");
                        stringBuilder9.append(ASMUtils.desc(Collection.class));
                        methodWriter.visitMethodInsn(182, str4, "scanFieldStringArray", stringBuilder9.toString());
                        stringBuilder9 = new StringBuilder();
                        stringBuilder9.append(fieldInfo.name);
                        stringBuilder9.append("_asm");
                        methodWriter.visitVarInsn(58, paramContext.var(stringBuilder9.toString()));
                      } else {
                        _deserialze_list_obj(paramContext, (MethodVisitor)methodWriter, label2, fieldInfo, (Class<?>)stringBuilder9, (Class<?>)str4, j);
                        if (j == i - 1)
                          _deserialize_endCheck(paramContext, (MethodVisitor)methodWriter, label2); 
                        j++;
                      } 
                    } else {
                      methodWriter1 = methodWriter;
                      _deserialze_obj(paramContext, (MethodVisitor)methodWriter1, label2, fieldInfo, (Class<?>)stringBuilder9, j);
                      if (j == i - 1)
                        _deserialize_endCheck(paramContext, (MethodVisitor)methodWriter1, label2); 
                      j++;
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        Label label7 = new Label();
        methodWriter.visitJumpInsn(158, label7);
        _setFlag((MethodVisitor)methodWriter, paramContext, j);
        methodWriter.visitLabel(label7);
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        methodWriter.visitInsn(89);
        methodWriter.visitVarInsn(54, paramContext.var("matchStat"));
        methodWriter.visitLdcInsn(Integer.valueOf(-1));
        methodWriter.visitJumpInsn(159, label2);
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        methodWriter.visitJumpInsn(158, (Label)methodWriter1);
        methodWriter.visitVarInsn(21, paramContext.var("matchedCount"));
        methodWriter.visitInsn(4);
        methodWriter.visitInsn(96);
        methodWriter.visitVarInsn(54, paramContext.var("matchedCount"));
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        methodWriter.visitLdcInsn(Integer.valueOf(4));
        methodWriter.visitJumpInsn(159, label4);
        methodWriter.visitLabel((Label)methodWriter1);
        if (j == i - 1) {
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
          methodWriter.visitLdcInsn(Integer.valueOf(4));
          methodWriter.visitJumpInsn(160, label2);
        } 
      } else {
        break;
      } 
    } 
    methodWriter.visitLabel(label4);
    if (!paramContext.clazz.isInterface() && !Modifier.isAbstract(paramContext.clazz.getModifiers()))
      _batchSet(paramContext, (MethodVisitor)methodWriter); 
    methodWriter.visitLabel(label3);
    _setContext(paramContext, (MethodVisitor)methodWriter);
    methodWriter.visitVarInsn(25, paramContext.var("instance"));
    Method method = paramContext.beanInfo.buildMethod;
    if (method != null) {
      str3 = ASMUtils.type(paramContext.getInstClass());
      String str = method.getName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("()");
      stringBuilder.append(ASMUtils.desc(method.getReturnType()));
      methodWriter.visitMethodInsn(182, str3, str, stringBuilder.toString());
    } 
    methodWriter.visitInsn(176);
    methodWriter.visitLabel(label2);
    _batchSet(paramContext, (MethodVisitor)methodWriter);
    methodWriter.visitVarInsn(25, 0);
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, 2);
    methodWriter.visitVarInsn(25, 3);
    methodWriter.visitVarInsn(25, paramContext.var("instance"));
    methodWriter.visitVarInsn(21, 4);
    int k = i / 32;
    j = k;
    if (i != 0) {
      j = k;
      if (i % 32 != 0)
        j = k + 1; 
    } 
    if (j == 1) {
      methodWriter.visitInsn(4);
    } else {
      methodWriter.visitIntInsn(16, j);
    } 
    methodWriter.visitIntInsn(188, 10);
    for (i = 0; i < j; i++) {
      methodWriter.visitInsn(89);
      if (i == 0) {
        methodWriter.visitInsn(3);
      } else if (i == 1) {
        methodWriter.visitInsn(4);
      } else {
        methodWriter.visitIntInsn(16, i);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_asm_flag_");
      stringBuilder.append(i);
      methodWriter.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
      methodWriter.visitInsn(79);
    } 
    String str2 = ASMUtils.type(JavaBeanDeserializer.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(L");
    stringBuilder2.append(DefaultJSONParser);
    stringBuilder2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;");
    methodWriter.visitMethodInsn(182, str2, "parseRest", stringBuilder2.toString());
    methodWriter.visitTypeInsn(192, ASMUtils.type(paramContext.clazz));
    methodWriter.visitInsn(176);
    methodWriter.visitLabel(label1);
    methodWriter.visitVarInsn(25, 0);
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, 2);
    methodWriter.visitVarInsn(25, 3);
    methodWriter.visitVarInsn(21, 4);
    String str1 = ASMUtils.type(JavaBeanDeserializer.class);
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(L");
    stringBuilder2.append(DefaultJSONParser);
    stringBuilder2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
    methodWriter.visitMethodInsn(183, str1, "deserialze", stringBuilder2.toString());
    methodWriter.visitInsn(176);
    methodWriter.visitMaxs(10, paramContext.variantIndex);
    methodWriter.visitEnd();
  }
  
  private void _deserialzeArrayMapping(ClassWriter paramClassWriter, Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(DefaultJSONParser);
    stringBuilder.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "deserialzeArrayMapping", stringBuilder.toString(), null, null);
    defineVarLexer(paramContext, (MethodVisitor)methodWriter);
    _createInstance(paramContext, (MethodVisitor)methodWriter);
    FieldInfo[] arrayOfFieldInfo = paramContext.beanInfo.sortedFields;
    int i = arrayOfFieldInfo.length;
    for (byte b = 0; b < i; b++) {
      byte b1;
      byte b2;
      StringBuilder stringBuilder1;
      if (b == i - 1) {
        b1 = 1;
      } else {
        b1 = 0;
      } 
      if (b1) {
        b2 = 93;
      } else {
        b2 = 44;
      } 
      FieldInfo fieldInfo = arrayOfFieldInfo[b];
      Class<byte> clazz = fieldInfo.fieldClass;
      Type type = fieldInfo.fieldType;
      if (clazz == byte.class || clazz == short.class || clazz == int.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == long.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(55, paramContext.var(stringBuilder1.toString(), 2));
      } else if (stringBuilder1 == boolean.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == float.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(56, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == double.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(57, paramContext.var(stringBuilder1.toString(), 2));
      } else if (stringBuilder1 == char.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
        methodWriter.visitInsn(3);
        methodWriter.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == String.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b2);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
      } else {
        Label label;
        if (stringBuilder1.isEnum()) {
          Label label5 = new Label();
          Label label6 = new Label();
          label = new Label();
          Label label7 = new Label();
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
          methodWriter.visitInsn(89);
          methodWriter.visitVarInsn(54, paramContext.var("ch"));
          methodWriter.visitLdcInsn(Integer.valueOf(110));
          methodWriter.visitJumpInsn(159, label7);
          methodWriter.visitVarInsn(21, paramContext.var("ch"));
          methodWriter.visitLdcInsn(Integer.valueOf(34));
          methodWriter.visitJumpInsn(160, label5);
          methodWriter.visitLabel(label7);
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder1)));
          methodWriter.visitVarInsn(25, 1);
          String str2 = DefaultJSONParser;
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("()");
          stringBuilder3.append(ASMUtils.desc(SymbolTable.class));
          methodWriter.visitMethodInsn(182, str2, "getSymbolTable", stringBuilder3.toString());
          methodWriter.visitVarInsn(16, b2);
          str2 = JSONLexerBase;
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append("(Ljava/lang/Class;");
          stringBuilder3.append(ASMUtils.desc(SymbolTable.class));
          stringBuilder3.append("C)Ljava/lang/Enum;");
          methodWriter.visitMethodInsn(182, str2, "scanEnum", stringBuilder3.toString());
          methodWriter.visitJumpInsn(167, label);
          methodWriter.visitLabel(label5);
          methodWriter.visitVarInsn(21, paramContext.var("ch"));
          methodWriter.visitLdcInsn(Integer.valueOf(48));
          methodWriter.visitJumpInsn(161, label6);
          methodWriter.visitVarInsn(21, paramContext.var("ch"));
          methodWriter.visitLdcInsn(Integer.valueOf(57));
          methodWriter.visitJumpInsn(163, label6);
          _getFieldDeser(paramContext, (MethodVisitor)methodWriter, fieldInfo);
          methodWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitVarInsn(16, b2);
          methodWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
          methodWriter.visitMethodInsn(182, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
          methodWriter.visitJumpInsn(167, label);
          methodWriter.visitLabel(label6);
          methodWriter.visitVarInsn(25, 0);
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitVarInsn(16, b2);
          String str1 = ASMUtils.type(JavaBeanDeserializer.class);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("(L");
          stringBuilder2.append(JSONLexerBase);
          stringBuilder2.append(";C)Ljava/lang/Enum;");
          methodWriter.visitMethodInsn(182, str1, "scanEnum", stringBuilder2.toString());
          methodWriter.visitLabel(label);
          methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder1));
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(fieldInfo.name);
          stringBuilder1.append("_asm");
          methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
        } else {
          String str;
          StringBuilder stringBuilder2;
          if (Collection.class.isAssignableFrom((Class<?>)stringBuilder1)) {
            Label label5;
            StringBuilder stringBuilder3;
            Class<String> clazz1 = TypeUtils.getCollectionItemClass((Type)label);
            if (clazz1 == String.class) {
              if (stringBuilder1 == List.class || stringBuilder1 == Collections.class || stringBuilder1 == ArrayList.class) {
                methodWriter.visitTypeInsn(187, ASMUtils.type(ArrayList.class));
                methodWriter.visitInsn(89);
                methodWriter.visitMethodInsn(183, ASMUtils.type(ArrayList.class), "<init>", "()V");
              } else {
                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder1)));
                methodWriter.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
              } 
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(fieldInfo.name);
              stringBuilder1.append("_asm");
              methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(fieldInfo.name);
              stringBuilder1.append("_asm");
              methodWriter.visitVarInsn(25, paramContext.var(stringBuilder1.toString()));
              methodWriter.visitVarInsn(16, b2);
              methodWriter.visitMethodInsn(182, JSONLexerBase, "scanStringArray", "(Ljava/util/Collection;C)V");
              label5 = new Label();
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
              methodWriter.visitLdcInsn(Integer.valueOf(5));
              methodWriter.visitJumpInsn(160, label5);
              methodWriter.visitInsn(1);
              stringBuilder3 = new StringBuilder();
              stringBuilder3.append(fieldInfo.name);
              stringBuilder3.append("_asm");
              methodWriter.visitVarInsn(58, paramContext.var(stringBuilder3.toString()));
              methodWriter.visitLabel(label5);
            } else {
              Label label6 = new Label();
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
              methodWriter.visitVarInsn(54, paramContext.var("token"));
              methodWriter.visitVarInsn(21, paramContext.var("token"));
              if (b == 0) {
                b1 = 14;
              } else {
                b1 = 16;
              } 
              methodWriter.visitLdcInsn(Integer.valueOf(b1));
              methodWriter.visitJumpInsn(159, label6);
              methodWriter.visitVarInsn(25, 1);
              methodWriter.visitVarInsn(21, paramContext.var("token"));
              methodWriter.visitMethodInsn(182, DefaultJSONParser, "throwException", "(I)V");
              methodWriter.visitLabel(label6);
              Label label7 = new Label();
              label6 = new Label();
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
              methodWriter.visitVarInsn(16, 91);
              methodWriter.visitJumpInsn(160, label7);
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
              methodWriter.visitInsn(87);
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitLdcInsn(Integer.valueOf(14));
              methodWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
              methodWriter.visitJumpInsn(167, label6);
              methodWriter.visitLabel(label7);
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitLdcInsn(Integer.valueOf(14));
              methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
              methodWriter.visitLabel(label6);
              _newCollection((MethodVisitor)methodWriter, (Class<?>)label5, b, false);
              methodWriter.visitInsn(89);
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append(fieldInfo.name);
              stringBuilder2.append("_asm");
              methodWriter.visitVarInsn(58, paramContext.var(stringBuilder2.toString()));
              _getCollectionFieldItemDeser(paramContext, (MethodVisitor)methodWriter, fieldInfo, (Class<?>)stringBuilder3);
              methodWriter.visitVarInsn(25, 1);
              methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder3)));
              methodWriter.visitVarInsn(25, 3);
              str = ASMUtils.type(JavaBeanDeserializer.class);
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("(Ljava/util/Collection;");
              stringBuilder2.append(ASMUtils.desc(ObjectDeserializer.class));
              stringBuilder2.append("L");
              stringBuilder2.append(DefaultJSONParser);
              stringBuilder2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
              methodWriter.visitMethodInsn(184, str, "parseArray", stringBuilder2.toString());
            } 
          } else if (stringBuilder2.isArray()) {
            methodWriter.visitVarInsn(25, paramContext.var("lexer"));
            methodWriter.visitLdcInsn(Integer.valueOf(14));
            methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
            methodWriter.visitVarInsn(25, 1);
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn(Integer.valueOf(b));
            methodWriter.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodWriter.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder2));
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(((FieldInfo)str).name);
            stringBuilder2.append("_asm");
            methodWriter.visitVarInsn(58, paramContext.var(stringBuilder2.toString()));
          } else {
            Label label5 = new Label();
            label = new Label();
            if (stringBuilder2 == Date.class) {
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
              methodWriter.visitLdcInsn(Integer.valueOf(49));
              methodWriter.visitJumpInsn(160, label5);
              methodWriter.visitTypeInsn(187, ASMUtils.type(Date.class));
              methodWriter.visitInsn(89);
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitVarInsn(16, b2);
              methodWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
              methodWriter.visitMethodInsn(183, ASMUtils.type(Date.class), "<init>", "(J)V");
              StringBuilder stringBuilder4 = new StringBuilder();
              stringBuilder4.append(((FieldInfo)str).name);
              stringBuilder4.append("_asm");
              methodWriter.visitVarInsn(58, paramContext.var(stringBuilder4.toString()));
              methodWriter.visitJumpInsn(167, label);
            } 
            methodWriter.visitLabel(label5);
            _quickNextToken(paramContext, (MethodVisitor)methodWriter, 14);
            _deserObject(paramContext, (MethodVisitor)methodWriter, (FieldInfo)str, (Class<?>)stringBuilder2, b);
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitVarInsn(25, paramContext.var("lexer"));
            if (b1 == 0) {
              methodWriter.visitLdcInsn(Integer.valueOf(16));
            } else {
              methodWriter.visitLdcInsn(Integer.valueOf(15));
            } 
            String str1 = ASMUtils.type(JavaBeanDeserializer.class);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("(");
            stringBuilder3.append(ASMUtils.desc(JSONLexer.class));
            stringBuilder3.append("I)V");
            methodWriter.visitMethodInsn(183, str1, "check", stringBuilder3.toString());
            methodWriter.visitLabel(label);
          } 
        } 
      } 
    } 
    _batchSet(paramContext, (MethodVisitor)methodWriter, false);
    Label label1 = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
    methodWriter.visitInsn(89);
    methodWriter.visitVarInsn(54, paramContext.var("ch"));
    methodWriter.visitVarInsn(16, 44);
    methodWriter.visitJumpInsn(160, label2);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    methodWriter.visitInsn(87);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(Integer.valueOf(16));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    methodWriter.visitJumpInsn(167, label4);
    methodWriter.visitLabel(label2);
    methodWriter.visitVarInsn(21, paramContext.var("ch"));
    methodWriter.visitVarInsn(16, 93);
    methodWriter.visitJumpInsn(160, label3);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    methodWriter.visitInsn(87);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(Integer.valueOf(15));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    methodWriter.visitJumpInsn(167, label4);
    methodWriter.visitLabel(label3);
    methodWriter.visitVarInsn(21, paramContext.var("ch"));
    methodWriter.visitVarInsn(16, 26);
    methodWriter.visitJumpInsn(160, label1);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    methodWriter.visitInsn(87);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(Integer.valueOf(20));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    methodWriter.visitJumpInsn(167, label4);
    methodWriter.visitLabel(label1);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(Integer.valueOf(16));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    methodWriter.visitLabel(label4);
    methodWriter.visitVarInsn(25, paramContext.var("instance"));
    methodWriter.visitInsn(176);
    methodWriter.visitMaxs(5, paramContext.variantIndex);
    methodWriter.visitEnd();
  }
  
  private void _deserialze_list_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass1, Class<?> paramClass2, int paramInt) {
    Label label1 = new Label();
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(153, label1);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    Label label3 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(8));
    paramMethodVisitor.visitJumpInsn(160, label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(16));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label3);
    label3 = new Label();
    Label label4 = new Label();
    Label label6 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(21));
    paramMethodVisitor.visitJumpInsn(160, label4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(14));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    _newCollection(paramMethodVisitor, paramClass1, paramInt, true);
    paramMethodVisitor.visitJumpInsn(167, label3);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(14));
    paramMethodVisitor.visitJumpInsn(159, label6);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(12));
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _newCollection(paramMethodVisitor, paramClass1, paramInt, false);
    StringBuilder stringBuilder6 = new StringBuilder();
    stringBuilder6.append(paramFieldInfo.name);
    stringBuilder6.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder6.toString()));
    _getCollectionFieldItemDeser(paramContext, paramMethodVisitor, paramFieldInfo, paramClass2);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass2)));
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    String str6 = ASMUtils.type(ObjectDeserializer.class);
    stringBuilder6 = new StringBuilder();
    stringBuilder6.append("(L");
    stringBuilder6.append(DefaultJSONParser);
    stringBuilder6.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(185, str6, "deserialze", stringBuilder6.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_value"));
    stringBuilder6 = new StringBuilder();
    stringBuilder6.append(paramFieldInfo.name);
    stringBuilder6.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder6.toString()));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_value"));
    if (paramClass1.isInterface()) {
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
    } else {
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
    } 
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label6);
    _newCollection(paramMethodVisitor, paramClass1, paramInt, false);
    paramMethodVisitor.visitLabel(label3);
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramFieldInfo.name);
    stringBuilder4.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder4.toString()));
    boolean bool = ParserConfig.isPrimitive2(paramFieldInfo.fieldClass);
    _getCollectionFieldItemDeser(paramContext, paramMethodVisitor, paramFieldInfo, paramClass2);
    if (bool) {
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
      paramMethodVisitor.visitVarInsn(54, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    } else {
      paramMethodVisitor.visitInsn(87);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(12));
      paramMethodVisitor.visitVarInsn(54, paramContext.var("fastMatchToken"));
      _quickNextToken(paramContext, paramMethodVisitor, 12);
    } 
    paramMethodVisitor.visitVarInsn(25, 1);
    String str5 = DefaultJSONParser;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("()");
    stringBuilder4.append(ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, str5, "getContext", stringBuilder4.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("listContext"));
    paramMethodVisitor.visitVarInsn(25, 1);
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramFieldInfo.name);
    stringBuilder4.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder4.toString()));
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    String str3 = DefaultJSONParser;
    StringBuilder stringBuilder7 = new StringBuilder();
    stringBuilder7.append("(Ljava/lang/Object;Ljava/lang/Object;)");
    stringBuilder7.append(ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, str3, "setContext", stringBuilder7.toString());
    paramMethodVisitor.visitInsn(87);
    Label label2 = new Label();
    Label label5 = new Label();
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(15));
    paramMethodVisitor.visitJumpInsn(159, label5);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str4 = paramContext.className;
    StringBuilder stringBuilder8 = new StringBuilder();
    stringBuilder8.append(paramFieldInfo.name);
    stringBuilder8.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(180, str4, stringBuilder8.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass2)));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    String str2 = ASMUtils.type(ObjectDeserializer.class);
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append("(L");
    stringBuilder5.append(DefaultJSONParser);
    stringBuilder5.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(185, str2, "deserialze", stringBuilder5.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_value"));
    paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder3.toString()));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_value"));
    if (paramClass1.isInterface()) {
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
    } else {
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
    } 
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, 1);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder2.toString()));
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "checkListResolve", "(Ljava/util/Collection;)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(16));
    paramMethodVisitor.visitJumpInsn(160, label2);
    if (bool) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    } else {
      _quickNextToken(paramContext, paramMethodVisitor, 12);
    } 
    paramMethodVisitor.visitJumpInsn(167, label2);
    paramMethodVisitor.visitLabel(label5);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("listContext"));
    String str1 = DefaultJSONParser;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    stringBuilder1.append(ASMUtils.desc(ParseContext.class));
    stringBuilder1.append(")V");
    paramMethodVisitor.visitMethodInsn(182, str1, "setContext", stringBuilder1.toString());
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(15));
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _quickNextTokenComma(paramContext, paramMethodVisitor);
    paramMethodVisitor.visitLabel(label1);
  }
  
  private void _deserialze_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt) {
    Label label = new Label();
    paramLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(25, 0);
    String str3 = paramContext.className;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramFieldInfo.name);
    stringBuilder4.append("_asm_prefix__");
    paramMethodVisitor.visitFieldInsn(180, str3, stringBuilder4.toString(), "[C");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(154, label);
    paramMethodVisitor.visitInsn(1);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder3.toString()));
    paramMethodVisitor.visitJumpInsn(167, paramLabel);
    paramMethodVisitor.visitLabel(label);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitInsn(4);
    paramMethodVisitor.visitInsn(96);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("matchedCount"));
    _deserObject(paramContext, paramMethodVisitor, paramFieldInfo, paramClass, paramInt);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getResolveStatus", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1));
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    paramMethodVisitor.visitVarInsn(25, 1);
    String str2 = DefaultJSONParser;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getLastResolveTask", stringBuilder2.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 1);
    str2 = DefaultJSONParser;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getContext", stringBuilder2.toString());
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    String str1 = ASMUtils.type(JavaBeanDeserializer.class);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(Ljava/lang/String;)");
    stringBuilder1.append(ASMUtils.desc(FieldDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, str1, "getFieldDeserializer", stringBuilder1.toString());
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(0));
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "setResolveStatus", "(I)V");
    paramMethodVisitor.visitLabel(paramLabel);
  }
  
  private void _getCollectionFieldItemDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    String str3 = paramContext.className;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramFieldInfo.name);
    stringBuilder4.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(180, str3, stringBuilder4.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, label);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    str3 = DefaultJSONParser;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("()");
    stringBuilder4.append(ASMUtils.desc(ParserConfig.class));
    paramMethodVisitor.visitMethodInsn(182, str3, "getConfig", stringBuilder4.toString());
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass)));
    str3 = ASMUtils.type(ParserConfig.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(Ljava/lang/reflect/Type;)");
    stringBuilder2.append(ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, str3, "getDeserializer", stringBuilder2.toString());
    String str2 = paramContext.className;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(181, str2, stringBuilder3.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str1 = paramContext.className;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder1.toString(), ASMUtils.desc(ObjectDeserializer.class));
  }
  
  private void _getFieldDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    String str2 = paramContext.className;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm_deser__");
    paramMethodVisitor.visitFieldInsn(180, str2, stringBuilder3.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, label);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    str2 = DefaultJSONParser;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("()");
    stringBuilder3.append(ASMUtils.desc(ParserConfig.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getConfig", stringBuilder3.toString());
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    String str3 = ASMUtils.type(ParserConfig.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(Ljava/lang/reflect/Type;)");
    stringBuilder2.append(ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, str3, "getDeserializer", stringBuilder2.toString());
    str3 = paramContext.className;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm_deser__");
    paramMethodVisitor.visitFieldInsn(181, str3, stringBuilder2.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str1 = paramContext.className;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_deser__");
    paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder1.toString(), ASMUtils.desc(ObjectDeserializer.class));
  }
  
  private void _init(ClassWriter paramClassWriter, Context paramContext) {
    int i = paramContext.fieldInfoList.length;
    byte b;
    for (b = 0; b < i; b++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[b];
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(fieldInfo.name);
      stringBuilder1.append("_asm_prefix__");
      (new FieldWriter(paramClassWriter, 1, stringBuilder1.toString(), "[C")).visitEnd();
    } 
    i = paramContext.fieldInfoList.length;
    for (b = 0; b < i; b++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[b];
      Class<?> clazz = fieldInfo.fieldClass;
      if (!clazz.isPrimitive())
        if (Collection.class.isAssignableFrom(clazz)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(fieldInfo.name);
          stringBuilder1.append("_asm_list_item_deser__");
          (new FieldWriter(paramClassWriter, 1, stringBuilder1.toString(), ASMUtils.desc(ObjectDeserializer.class))).visitEnd();
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(fieldInfo.name);
          stringBuilder1.append("_asm_deser__");
          (new FieldWriter(paramClassWriter, 1, stringBuilder1.toString(), ASMUtils.desc(ObjectDeserializer.class))).visitEnd();
        }  
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(ASMUtils.desc(ParserConfig.class));
    stringBuilder.append(ASMUtils.desc(JavaBeanInfo.class));
    stringBuilder.append(")V");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "<init>", stringBuilder.toString(), null, null);
    methodWriter.visitVarInsn(25, 0);
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, 2);
    String str = ASMUtils.type(JavaBeanDeserializer.class);
    stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(ASMUtils.desc(ParserConfig.class));
    stringBuilder.append(ASMUtils.desc(JavaBeanInfo.class));
    stringBuilder.append(")V");
    methodWriter.visitMethodInsn(183, str, "<init>", stringBuilder.toString());
    i = paramContext.fieldInfoList.length;
    for (b = 0; b < i; b++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[b];
      methodWriter.visitVarInsn(25, 0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\"");
      stringBuilder1.append(fieldInfo.name);
      stringBuilder1.append("\":");
      methodWriter.visitLdcInsn(stringBuilder1.toString());
      methodWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
      String str1 = paramContext.className;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(fieldInfo.name);
      stringBuilder2.append("_asm_prefix__");
      methodWriter.visitFieldInsn(181, str1, stringBuilder2.toString(), "[C");
    } 
    methodWriter.visitInsn(177);
    methodWriter.visitMaxs(4, 4);
    methodWriter.visitEnd();
  }
  
  private void _isFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, Label paramLabel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_asm_flag_");
    stringBuilder.append(paramInt / 32);
    paramMethodVisitor.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(126);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  private void _loadAndSet(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    StringBuilder stringBuilder;
    Class<boolean> clazz = paramFieldInfo.fieldClass;
    Type type = paramFieldInfo.fieldType;
    if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramFieldInfo.name);
      stringBuilder.append("_asm");
      paramMethodVisitor.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
    } else {
      if (stringBuilder == byte.class || stringBuilder == short.class || stringBuilder == int.class || stringBuilder == char.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      } 
      if (stringBuilder == long.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(22, paramContext.var(stringBuilder.toString(), 2));
        if (paramFieldInfo.method != null) {
          paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramContext.getInstClass()), paramFieldInfo.method.getName(), ASMUtils.desc(paramFieldInfo.method));
          if (!paramFieldInfo.method.getReturnType().equals(void.class))
            paramMethodVisitor.visitInsn(87); 
        } else {
          paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
        } 
      } else if (stringBuilder == float.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(23, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      } else if (stringBuilder == double.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(24, paramContext.var(stringBuilder.toString(), 2));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      } else if (stringBuilder == String.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      } else if (stringBuilder.isEnum()) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      } else if (Collection.class.isAssignableFrom((Class<?>)stringBuilder)) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        if (TypeUtils.getCollectionItemClass(type) == String.class) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramFieldInfo.name);
          stringBuilder1.append("_asm");
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder1.toString()));
          paramMethodVisitor.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder));
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramFieldInfo.name);
          stringBuilder.append("_asm");
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        } 
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      } else {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      } 
    } 
  }
  
  private void _newCollection(MethodVisitor paramMethodVisitor, Class<?> paramClass, int paramInt, boolean paramBoolean) {
    if (paramClass.isAssignableFrom(ArrayList.class) && !paramBoolean) {
      paramMethodVisitor.visitTypeInsn(187, "java/util/ArrayList");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
    } else if (paramClass.isAssignableFrom(LinkedList.class) && !paramBoolean) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedList.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
    } else if (paramClass.isAssignableFrom(HashSet.class)) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
    } else if (paramClass.isAssignableFrom(TreeSet.class)) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(TreeSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
    } else if (paramClass.isAssignableFrom(LinkedHashSet.class)) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedHashSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
    } else if (paramBoolean) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
    } else {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
      paramMethodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
    } 
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
  }
  
  private void _quickNextToken(Context paramContext, MethodVisitor paramMethodVisitor, int paramInt) {
    Label label1 = new Label();
    Label label2 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
    if (paramInt == 12) {
      paramMethodVisitor.visitVarInsn(16, 123);
    } else if (paramInt == 14) {
      paramMethodVisitor.visitVarInsn(16, 91);
    } else {
      throw new IllegalStateException();
    } 
    paramMethodVisitor.visitJumpInsn(160, label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label2);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitLabel(label2);
  }
  
  private void _quickNextTokenComma(Context paramContext, MethodVisitor paramMethodVisitor) {
    Label label1 = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    Label label5 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitJumpInsn(160, label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(16));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label5);
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 125);
    paramMethodVisitor.visitJumpInsn(160, label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(13));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label5);
    paramMethodVisitor.visitLabel(label3);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 93);
    paramMethodVisitor.visitJumpInsn(160, label4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(15));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label5);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 26);
    paramMethodVisitor.visitJumpInsn(160, label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(20));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label5);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "()V");
    paramMethodVisitor.visitLabel(label5);
  }
  
  private void _set(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    Method method = paramFieldInfo.method;
    if (method != null) {
      char c;
      if (method.getDeclaringClass().isInterface()) {
        c = '¹';
      } else {
        c = '¶';
      } 
      paramMethodVisitor.visitMethodInsn(c, ASMUtils.type(paramFieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
      if (!paramFieldInfo.method.getReturnType().equals(void.class))
        paramMethodVisitor.visitInsn(87); 
    } else {
      paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
    } 
  }
  
  private void _setContext(Context paramContext, MethodVisitor paramMethodVisitor) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("context"));
    String str = DefaultJSONParser;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(ASMUtils.desc(ParseContext.class));
    stringBuilder.append(")V");
    paramMethodVisitor.visitMethodInsn(182, str, "setContext", stringBuilder.toString());
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitJumpInsn(198, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _setFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_asm_flag_");
    stringBuilder.append(paramInt / 32);
    String str = stringBuilder.toString();
    paramMethodVisitor.visitVarInsn(21, paramContext.var(str));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(128);
    paramMethodVisitor.visitVarInsn(54, paramContext.var(str));
  }
  
  private Class<?> defineClassPublic(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return this.classLoader.defineClassPublic(paramString, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private void defineVarLexer(Context paramContext, MethodVisitor paramMethodVisitor) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
    paramMethodVisitor.visitTypeInsn(192, JSONLexerBase);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("lexer"));
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo) throws Exception {
    byte[] arrayOfByte;
    Class clazz = paramJavaBeanInfo.clazz;
    if (!clazz.isPrimitive()) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("FastjsonASMDeserializer_");
      stringBuilder2.append(this.seed.incrementAndGet());
      stringBuilder2.append("_");
      stringBuilder2.append(clazz.getSimpleName());
      String str3 = stringBuilder2.toString();
      String str2 = ASMDeserializerFactory.class.getPackage().getName();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2.replace('.', '/'));
      stringBuilder1.append("/");
      stringBuilder1.append(str3);
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(str2);
      stringBuilder3.append(".");
      stringBuilder3.append(str3);
      str2 = stringBuilder3.toString();
      ClassWriter classWriter = new ClassWriter();
      classWriter.visit(49, 33, str1, ASMUtils.type(JavaBeanDeserializer.class), null);
      _init(classWriter, new Context(str1, paramParserConfig, paramJavaBeanInfo, 3));
      _createInstance(classWriter, new Context(str1, paramParserConfig, paramJavaBeanInfo, 3));
      _deserialze(classWriter, new Context(str1, paramParserConfig, paramJavaBeanInfo, 5));
      _deserialzeArrayMapping(classWriter, new Context(str1, paramParserConfig, paramJavaBeanInfo, 4));
      arrayOfByte = classWriter.toByteArray();
      return defineClassPublic(str2, arrayOfByte, 0, arrayOfByte.length).getConstructor(new Class[] { ParserConfig.class, JavaBeanInfo.class }).newInstance(new Object[] { paramParserConfig, paramJavaBeanInfo });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not support type :");
    stringBuilder.append(arrayOfByte.getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static class Context {
    static final int fieldName = 3;
    
    static final int parser = 1;
    
    static final int type = 2;
    
    private final JavaBeanInfo beanInfo;
    
    private final String className;
    
    private final Class<?> clazz;
    
    private FieldInfo[] fieldInfoList;
    
    private int variantIndex = -1;
    
    private final Map<String, Integer> variants = new HashMap<String, Integer>();
    
    public Context(String param1String, ParserConfig param1ParserConfig, JavaBeanInfo param1JavaBeanInfo, int param1Int) {
      this.className = param1String;
      this.clazz = param1JavaBeanInfo.clazz;
      this.variantIndex = param1Int;
      this.beanInfo = param1JavaBeanInfo;
      this.fieldInfoList = param1JavaBeanInfo.fields;
    }
    
    public Class<?> getInstClass() {
      Class<?> clazz1 = this.beanInfo.builderClass;
      Class<?> clazz2 = clazz1;
      if (clazz1 == null)
        clazz2 = this.clazz; 
      return clazz2;
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ASMDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
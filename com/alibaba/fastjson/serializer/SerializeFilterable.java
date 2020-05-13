package com.alibaba.fastjson.serializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SerializeFilterable {
  protected List<AfterFilter> afterFilters = null;
  
  protected List<BeforeFilter> beforeFilters = null;
  
  protected List<ContextValueFilter> contextValueFilters = null;
  
  protected List<LabelFilter> labelFilters = null;
  
  protected List<NameFilter> nameFilters = null;
  
  protected List<PropertyFilter> propertyFilters = null;
  
  protected List<PropertyPreFilter> propertyPreFilters = null;
  
  protected List<ValueFilter> valueFilters = null;
  
  protected boolean writeDirect = true;
  
  public void addFilter(SerializeFilter paramSerializeFilter) {
    if (paramSerializeFilter == null)
      return; 
    if (paramSerializeFilter instanceof PropertyPreFilter)
      getPropertyPreFilters().add((PropertyPreFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof NameFilter)
      getNameFilters().add((NameFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof ValueFilter)
      getValueFilters().add((ValueFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof ContextValueFilter)
      getContextValueFilters().add((ContextValueFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof PropertyFilter)
      getPropertyFilters().add((PropertyFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof BeforeFilter)
      getBeforeFilters().add((BeforeFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof AfterFilter)
      getAfterFilters().add((AfterFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof LabelFilter)
      getLabelFilters().add((LabelFilter)paramSerializeFilter); 
  }
  
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2) {
    if (paramJSONSerializer.propertyFilters != null) {
      Iterator<PropertyFilter> iterator = paramJSONSerializer.propertyFilters.iterator();
      while (iterator.hasNext()) {
        if (!((PropertyFilter)iterator.next()).apply(paramObject1, paramString, paramObject2))
          return false; 
      } 
    } 
    if (this.propertyFilters != null) {
      Iterator<PropertyFilter> iterator = this.propertyFilters.iterator();
      while (iterator.hasNext()) {
        if (!((PropertyFilter)iterator.next()).apply(paramObject1, paramString, paramObject2))
          return false; 
      } 
    } 
    return true;
  }
  
  public boolean applyName(JSONSerializer paramJSONSerializer, Object paramObject, String paramString) {
    if (paramJSONSerializer.propertyPreFilters != null) {
      Iterator<PropertyPreFilter> iterator = paramJSONSerializer.propertyPreFilters.iterator();
      while (iterator.hasNext()) {
        if (!((PropertyPreFilter)iterator.next()).apply(paramJSONSerializer, paramObject, paramString))
          return false; 
      } 
    } 
    if (this.propertyPreFilters != null) {
      Iterator<PropertyPreFilter> iterator = this.propertyPreFilters.iterator();
      while (iterator.hasNext()) {
        if (!((PropertyPreFilter)iterator.next()).apply(paramJSONSerializer, paramObject, paramString))
          return false; 
      } 
    } 
    return true;
  }
  
  public List<AfterFilter> getAfterFilters() {
    if (this.afterFilters == null) {
      this.afterFilters = new ArrayList<AfterFilter>();
      this.writeDirect = false;
    } 
    return this.afterFilters;
  }
  
  public List<BeforeFilter> getBeforeFilters() {
    if (this.beforeFilters == null) {
      this.beforeFilters = new ArrayList<BeforeFilter>();
      this.writeDirect = false;
    } 
    return this.beforeFilters;
  }
  
  public List<ContextValueFilter> getContextValueFilters() {
    if (this.contextValueFilters == null) {
      this.contextValueFilters = new ArrayList<ContextValueFilter>();
      this.writeDirect = false;
    } 
    return this.contextValueFilters;
  }
  
  public List<LabelFilter> getLabelFilters() {
    if (this.labelFilters == null) {
      this.labelFilters = new ArrayList<LabelFilter>();
      this.writeDirect = false;
    } 
    return this.labelFilters;
  }
  
  public List<NameFilter> getNameFilters() {
    if (this.nameFilters == null) {
      this.nameFilters = new ArrayList<NameFilter>();
      this.writeDirect = false;
    } 
    return this.nameFilters;
  }
  
  public List<PropertyFilter> getPropertyFilters() {
    if (this.propertyFilters == null) {
      this.propertyFilters = new ArrayList<PropertyFilter>();
      this.writeDirect = false;
    } 
    return this.propertyFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFilters() {
    if (this.propertyPreFilters == null) {
      this.propertyPreFilters = new ArrayList<PropertyPreFilter>();
      this.writeDirect = false;
    } 
    return this.propertyPreFilters;
  }
  
  public List<ValueFilter> getValueFilters() {
    if (this.valueFilters == null) {
      this.valueFilters = new ArrayList<ValueFilter>();
      this.writeDirect = false;
    } 
    return this.valueFilters;
  }
  
  protected String processKey(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2) {
    String str2 = paramString;
    if (paramJSONSerializer.nameFilters != null) {
      Iterator<NameFilter> iterator = paramJSONSerializer.nameFilters.iterator();
      while (true) {
        str2 = paramString;
        if (iterator.hasNext()) {
          paramString = ((NameFilter)iterator.next()).process(paramObject1, paramString, paramObject2);
          continue;
        } 
        break;
      } 
    } 
    String str1 = str2;
    if (this.nameFilters != null) {
      Iterator<NameFilter> iterator = this.nameFilters.iterator();
      while (true) {
        str1 = str2;
        if (iterator.hasNext()) {
          str2 = ((NameFilter)iterator.next()).process(paramObject1, str2, paramObject2);
          continue;
        } 
        break;
      } 
    } 
    return str1;
  }
  
  protected Object processValue(JSONSerializer paramJSONSerializer, BeanContext paramBeanContext, Object paramObject1, String paramString, Object paramObject2) {
    // Byte code:
    //   0: aload #5
    //   2: astore #6
    //   4: aload #5
    //   6: ifnull -> 149
    //   9: aload_1
    //   10: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   13: getfield writeNonStringValueAsString : Z
    //   16: ifne -> 37
    //   19: aload_2
    //   20: ifnull -> 60
    //   23: aload_2
    //   24: invokevirtual getFeatures : ()I
    //   27: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringValueAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   30: getfield mask : I
    //   33: iand
    //   34: ifeq -> 60
    //   37: aload #5
    //   39: instanceof java/lang/Number
    //   42: istore #7
    //   44: iload #7
    //   46: ifne -> 92
    //   49: aload #5
    //   51: instanceof java/lang/Boolean
    //   54: ifeq -> 60
    //   57: goto -> 92
    //   60: aload #5
    //   62: astore #6
    //   64: aload_2
    //   65: ifnull -> 149
    //   68: aload #5
    //   70: astore #6
    //   72: aload_2
    //   73: invokevirtual isJsonDirect : ()Z
    //   76: ifeq -> 149
    //   79: aload #5
    //   81: checkcast java/lang/String
    //   84: invokestatic parse : (Ljava/lang/String;)Ljava/lang/Object;
    //   87: astore #6
    //   89: goto -> 149
    //   92: aconst_null
    //   93: astore #8
    //   95: aload #8
    //   97: astore #6
    //   99: iload #7
    //   101: ifeq -> 118
    //   104: aload #8
    //   106: astore #6
    //   108: aload_2
    //   109: ifnull -> 118
    //   112: aload_2
    //   113: invokevirtual getFormat : ()Ljava/lang/String;
    //   116: astore #6
    //   118: aload #6
    //   120: ifnull -> 142
    //   123: new java/text/DecimalFormat
    //   126: dup
    //   127: aload #6
    //   129: invokespecial <init> : (Ljava/lang/String;)V
    //   132: aload #5
    //   134: invokevirtual format : (Ljava/lang/Object;)Ljava/lang/String;
    //   137: astore #6
    //   139: goto -> 149
    //   142: aload #5
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: astore #6
    //   149: aload #6
    //   151: astore #8
    //   153: aload_1
    //   154: getfield valueFilters : Ljava/util/List;
    //   157: ifnull -> 210
    //   160: aload_1
    //   161: getfield valueFilters : Ljava/util/List;
    //   164: invokeinterface iterator : ()Ljava/util/Iterator;
    //   169: astore #5
    //   171: aload #6
    //   173: astore #8
    //   175: aload #5
    //   177: invokeinterface hasNext : ()Z
    //   182: ifeq -> 210
    //   185: aload #5
    //   187: invokeinterface next : ()Ljava/lang/Object;
    //   192: checkcast com/alibaba/fastjson/serializer/ValueFilter
    //   195: aload_3
    //   196: aload #4
    //   198: aload #6
    //   200: invokeinterface process : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: astore #6
    //   207: goto -> 171
    //   210: aload_0
    //   211: getfield valueFilters : Ljava/util/List;
    //   214: astore #6
    //   216: aload #8
    //   218: astore #5
    //   220: aload #6
    //   222: ifnull -> 273
    //   225: aload #6
    //   227: invokeinterface iterator : ()Ljava/util/Iterator;
    //   232: astore #6
    //   234: aload #8
    //   236: astore #5
    //   238: aload #6
    //   240: invokeinterface hasNext : ()Z
    //   245: ifeq -> 273
    //   248: aload #6
    //   250: invokeinterface next : ()Ljava/lang/Object;
    //   255: checkcast com/alibaba/fastjson/serializer/ValueFilter
    //   258: aload_3
    //   259: aload #4
    //   261: aload #8
    //   263: invokeinterface process : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   268: astore #8
    //   270: goto -> 234
    //   273: aload #5
    //   275: astore #6
    //   277: aload_1
    //   278: getfield contextValueFilters : Ljava/util/List;
    //   281: ifnull -> 332
    //   284: aload_1
    //   285: getfield contextValueFilters : Ljava/util/List;
    //   288: invokeinterface iterator : ()Ljava/util/Iterator;
    //   293: astore_1
    //   294: aload #5
    //   296: astore #6
    //   298: aload_1
    //   299: invokeinterface hasNext : ()Z
    //   304: ifeq -> 332
    //   307: aload_1
    //   308: invokeinterface next : ()Ljava/lang/Object;
    //   313: checkcast com/alibaba/fastjson/serializer/ContextValueFilter
    //   316: aload_2
    //   317: aload_3
    //   318: aload #4
    //   320: aload #5
    //   322: invokeinterface process : (Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   327: astore #5
    //   329: goto -> 294
    //   332: aload #6
    //   334: astore_1
    //   335: aload_0
    //   336: getfield contextValueFilters : Ljava/util/List;
    //   339: ifnull -> 392
    //   342: aload_0
    //   343: getfield contextValueFilters : Ljava/util/List;
    //   346: invokeinterface iterator : ()Ljava/util/Iterator;
    //   351: astore #5
    //   353: aload #6
    //   355: astore_1
    //   356: aload #5
    //   358: invokeinterface hasNext : ()Z
    //   363: ifeq -> 392
    //   366: aload #5
    //   368: invokeinterface next : ()Ljava/lang/Object;
    //   373: checkcast com/alibaba/fastjson/serializer/ContextValueFilter
    //   376: aload_2
    //   377: aload_3
    //   378: aload #4
    //   380: aload #6
    //   382: invokeinterface process : (Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   387: astore #6
    //   389: goto -> 353
    //   392: aload_1
    //   393: areturn
  }
  
  protected boolean writeDirect(JSONSerializer paramJSONSerializer) {
    boolean bool;
    if (paramJSONSerializer.out.writeDirect && this.writeDirect && paramJSONSerializer.writeDirect) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializeFilterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
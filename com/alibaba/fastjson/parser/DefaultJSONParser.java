package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
  public static final int NONE = 0;
  
  public static final int NeedToResolve = 1;
  
  public static final int TypeNameRedirect = 2;
  
  private static final Set<Class<?>> primitiveClasses = new HashSet<Class<?>>();
  
  private String[] autoTypeAccept = null;
  
  private boolean autoTypeEnable;
  
  protected ParserConfig config;
  
  protected ParseContext context;
  
  private ParseContext[] contextArray;
  
  private int contextArrayIndex = 0;
  
  private DateFormat dateFormat;
  
  private String dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
  
  private List<ExtraProcessor> extraProcessors = null;
  
  private List<ExtraTypeProvider> extraTypeProviders = null;
  
  protected FieldTypeResolver fieldTypeResolver = null;
  
  public final Object input;
  
  protected transient BeanContext lastBeanContext;
  
  public final JSONLexer lexer;
  
  public int resolveStatus = 0;
  
  private List<ResolveTask> resolveTaskList;
  
  public final SymbolTable symbolTable;
  
  static {
    Class[] arrayOfClass = new Class[17];
    Class<boolean> clazz = boolean.class;
    byte b = 0;
    arrayOfClass[0] = clazz;
    arrayOfClass[1] = byte.class;
    arrayOfClass[2] = short.class;
    arrayOfClass[3] = int.class;
    arrayOfClass[4] = long.class;
    arrayOfClass[5] = float.class;
    arrayOfClass[6] = double.class;
    arrayOfClass[7] = Boolean.class;
    arrayOfClass[8] = Byte.class;
    arrayOfClass[9] = Short.class;
    arrayOfClass[10] = Integer.class;
    arrayOfClass[11] = Long.class;
    arrayOfClass[12] = Float.class;
    arrayOfClass[13] = Double.class;
    arrayOfClass[14] = BigInteger.class;
    arrayOfClass[15] = BigDecimal.class;
    arrayOfClass[16] = String.class;
    int i = arrayOfClass.length;
    while (b < i) {
      clazz = arrayOfClass[b];
      primitiveClasses.add(clazz);
      b++;
    } 
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer) {
    this(paramJSONLexer, ParserConfig.getGlobalInstance());
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer, ParserConfig paramParserConfig) {
    this((Object)null, paramJSONLexer, paramParserConfig);
  }
  
  public DefaultJSONParser(Object paramObject, JSONLexer paramJSONLexer, ParserConfig paramParserConfig) {
    this.lexer = paramJSONLexer;
    this.input = paramObject;
    this.config = paramParserConfig;
    this.symbolTable = paramParserConfig.symbolTable;
    char c = paramJSONLexer.getCurrent();
    if (c == '{') {
      paramJSONLexer.next();
      ((JSONLexerBase)paramJSONLexer).token = 12;
    } else if (c == '[') {
      paramJSONLexer.next();
      ((JSONLexerBase)paramJSONLexer).token = 14;
    } else {
      paramJSONLexer.nextToken();
    } 
  }
  
  public DefaultJSONParser(String paramString) {
    this(paramString, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig) {
    this(paramString, new JSONScanner(paramString, JSON.DEFAULT_PARSER_FEATURE), paramParserConfig);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt) {
    this(paramString, new JSONScanner(paramString, paramInt), paramParserConfig);
  }
  
  public DefaultJSONParser(char[] paramArrayOfchar, int paramInt1, ParserConfig paramParserConfig, int paramInt2) {
    this(paramArrayOfchar, new JSONScanner(paramArrayOfchar, paramInt1, paramInt2), paramParserConfig);
  }
  
  private void addContext(ParseContext paramParseContext) {
    int i = this.contextArrayIndex;
    this.contextArrayIndex = i + 1;
    if (this.contextArray == null) {
      this.contextArray = new ParseContext[8];
    } else if (i >= this.contextArray.length) {
      ParseContext[] arrayOfParseContext = new ParseContext[this.contextArray.length * 3 / 2];
      System.arraycopy(this.contextArray, 0, arrayOfParseContext, 0, this.contextArray.length);
      this.contextArray = arrayOfParseContext;
    } 
    this.contextArray[i] = paramParseContext;
  }
  
  public final void accept(int paramInt) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == paramInt) {
      jSONLexer.nextToken();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect ");
    stringBuilder.append(JSONToken.name(paramInt));
    stringBuilder.append(", actual ");
    stringBuilder.append(JSONToken.name(jSONLexer.token()));
    throw new JSONException(stringBuilder.toString());
  }
  
  public final void accept(int paramInt1, int paramInt2) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == paramInt1) {
      jSONLexer.nextToken(paramInt2);
    } else {
      throwException(paramInt1);
    } 
  }
  
  public void acceptType(String paramString) {
    JSONLexer jSONLexer = this.lexer;
    jSONLexer.nextTokenWithColon();
    if (jSONLexer.token() == 4) {
      if (paramString.equals(jSONLexer.stringVal())) {
        jSONLexer.nextToken();
        if (jSONLexer.token() == 16)
          jSONLexer.nextToken(); 
        return;
      } 
      throw new JSONException("type not match error");
    } 
    throw new JSONException("type not match error");
  }
  
  public void addResolveTask(ResolveTask paramResolveTask) {
    if (this.resolveTaskList == null)
      this.resolveTaskList = new ArrayList<ResolveTask>(2); 
    this.resolveTaskList.add(paramResolveTask);
  }
  
  public void checkListResolve(Collection paramCollection) {
    if (this.resolveStatus == 1)
      if (paramCollection instanceof List) {
        int i = paramCollection.size();
        paramCollection = paramCollection;
        ResolveTask resolveTask = getLastResolveTask();
        resolveTask.fieldDeserializer = (FieldDeserializer)new ResolveFieldDeserializer(this, (List)paramCollection, i - 1);
        resolveTask.ownerContext = this.context;
        setResolveStatus(0);
      } else {
        ResolveTask resolveTask = getLastResolveTask();
        resolveTask.fieldDeserializer = (FieldDeserializer)new ResolveFieldDeserializer(paramCollection);
        resolveTask.ownerContext = this.context;
        setResolveStatus(0);
      }  
  }
  
  public void checkMapResolve(Map paramMap, Object paramObject) {
    if (this.resolveStatus == 1) {
      ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(paramMap, paramObject);
      paramObject = getLastResolveTask();
      ((ResolveTask)paramObject).fieldDeserializer = (FieldDeserializer)resolveFieldDeserializer;
      ((ResolveTask)paramObject).ownerContext = this.context;
      setResolveStatus(0);
    } 
  }
  
  public void close() {
    JSONLexer jSONLexer = this.lexer;
    try {
      if (!jSONLexer.isEnabled(Feature.AutoCloseSource) || jSONLexer.token() == 20)
        return; 
      JSONException jSONException = new JSONException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("not close json text, token : ");
      stringBuilder.append(JSONToken.name(jSONLexer.token()));
      this(stringBuilder.toString());
      throw jSONException;
    } finally {
      jSONLexer.close();
    } 
  }
  
  public void config(Feature paramFeature, boolean paramBoolean) {
    this.lexer.config(paramFeature, paramBoolean);
  }
  
  public ParserConfig getConfig() {
    return this.config;
  }
  
  public ParseContext getContext() {
    return this.context;
  }
  
  public String getDateFomartPattern() {
    return this.dateFormatPattern;
  }
  
  public DateFormat getDateFormat() {
    if (this.dateFormat == null) {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
      this.dateFormat.setTimeZone(this.lexer.getTimeZone());
    } 
    return this.dateFormat;
  }
  
  public List<ExtraProcessor> getExtraProcessors() {
    if (this.extraProcessors == null)
      this.extraProcessors = new ArrayList<ExtraProcessor>(2); 
    return this.extraProcessors;
  }
  
  public List<ExtraTypeProvider> getExtraTypeProviders() {
    if (this.extraTypeProviders == null)
      this.extraTypeProviders = new ArrayList<ExtraTypeProvider>(2); 
    return this.extraTypeProviders;
  }
  
  public FieldTypeResolver getFieldTypeResolver() {
    return this.fieldTypeResolver;
  }
  
  public String getInput() {
    return (this.input instanceof char[]) ? new String((char[])this.input) : this.input.toString();
  }
  
  public ResolveTask getLastResolveTask() {
    return this.resolveTaskList.get(this.resolveTaskList.size() - 1);
  }
  
  public JSONLexer getLexer() {
    return this.lexer;
  }
  
  public Object getObject(String paramString) {
    for (byte b = 0; b < this.contextArrayIndex; b++) {
      if (paramString.equals(this.contextArray[b].toString()))
        return (this.contextArray[b]).object; 
    } 
    return null;
  }
  
  public int getResolveStatus() {
    return this.resolveStatus;
  }
  
  public List<ResolveTask> getResolveTaskList() {
    if (this.resolveTaskList == null)
      this.resolveTaskList = new ArrayList<ResolveTask>(2); 
    return this.resolveTaskList;
  }
  
  public SymbolTable getSymbolTable() {
    return this.symbolTable;
  }
  
  public void handleResovleTask(Object paramObject) {
    if (this.resolveTaskList == null)
      return; 
    int i = this.resolveTaskList.size();
    for (byte b = 0; b < i; b++) {
      ResolveTask resolveTask = this.resolveTaskList.get(b);
      String str = resolveTask.referenceValue;
      Object object = null;
      if (resolveTask.ownerContext != null)
        object = resolveTask.ownerContext.object; 
      if (str.startsWith("$")) {
        paramObject = getObject(str);
      } else {
        paramObject = resolveTask.context.object;
      } 
      FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
      if (fieldDeserializer != null) {
        Object object1 = paramObject;
        if (paramObject != null) {
          object1 = paramObject;
          if (paramObject.getClass() == JSONObject.class) {
            object1 = paramObject;
            if (fieldDeserializer.fieldInfo != null) {
              object1 = paramObject;
              if (!Map.class.isAssignableFrom(fieldDeserializer.fieldInfo.fieldClass))
                object1 = JSONPath.eval((this.contextArray[0]).object, str); 
            } 
          } 
        } 
        fieldDeserializer.setValue(object, object1);
      } 
    } 
  }
  
  public boolean isEnabled(Feature paramFeature) {
    return this.lexer.isEnabled(paramFeature);
  }
  
  public Object parse() {
    return parse(null);
  }
  
  public Object parse(PropertyProcessable paramPropertyProcessable, Object paramObject) {
    int i = this.lexer.token();
    byte b = 0;
    if (i != 12) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("syntax error, expect {, actual ");
      stringBuilder1.append(this.lexer.tokenName());
      String str2 = stringBuilder1.toString();
      String str1 = str2;
      if (paramObject instanceof String) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str2);
        stringBuilder3.append(", fieldName ");
        str1 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str1);
        stringBuilder4.append(paramObject);
        str1 = stringBuilder4.toString();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(", ");
      str1 = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(this.lexer.info());
      str1 = stringBuilder2.toString();
      JSONArray jSONArray = new JSONArray();
      parseArray((Collection)jSONArray, paramObject);
      if (jSONArray.size() == 1) {
        paramObject = jSONArray.get(0);
        if (paramObject instanceof JSONObject)
          return paramObject; 
      } 
      throw new JSONException(str1);
    } 
    ParseContext parseContext = this.context;
    try {
      while (true) {
        JSONException jSONException;
        Map map;
        String str1;
        Class<?> clazz;
        this.lexer.skipWhitespace();
        i = this.lexer.getCurrent();
        int j = i;
        if (this.lexer.isEnabled(Feature.AllowArbitraryCommas))
          while (true) {
            j = i;
            if (i == 44) {
              this.lexer.next();
              this.lexer.skipWhitespace();
              i = this.lexer.getCurrent();
              continue;
            } 
            break;
          }  
        if (j == 34) {
          str1 = this.lexer.scanSymbol(this.symbolTable, '"');
          this.lexer.skipWhitespace();
          if (this.lexer.getCurrent() != ':') {
            jSONException = new JSONException();
            paramObject = new StringBuilder();
            super();
            paramObject.append("expect ':' at ");
            paramObject.append(this.lexer.pos());
            this(paramObject.toString());
            throw jSONException;
          } 
        } else {
          if (j == 125) {
            this.lexer.next();
            this.lexer.resetStringPosition();
            this.lexer.nextToken(16);
            return jSONException;
          } 
          if (j == 39) {
            if (this.lexer.isEnabled(Feature.AllowSingleQuotes)) {
              str1 = this.lexer.scanSymbol(this.symbolTable, '\'');
              this.lexer.skipWhitespace();
              if (this.lexer.getCurrent() != ':') {
                paramObject = new JSONException();
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("expect ':' at ");
                stringBuilder.append(this.lexer.pos());
                super(stringBuilder.toString());
                throw paramObject;
              } 
            } else {
              jSONException = new JSONException();
              this("syntax error");
              throw jSONException;
            } 
          } else if (this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
            str1 = this.lexer.scanSymbolUnQuoted(this.symbolTable);
            this.lexer.skipWhitespace();
            char c = this.lexer.getCurrent();
            if (c != ':') {
              paramObject = new JSONException();
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("expect ':' at ");
              stringBuilder.append(this.lexer.pos());
              stringBuilder.append(", actual ");
              stringBuilder.append(c);
              super(stringBuilder.toString());
              throw paramObject;
            } 
          } else {
            jSONException = new JSONException();
            this("syntax error");
            throw jSONException;
          } 
        } 
        this.lexer.next();
        this.lexer.skipWhitespace();
        this.lexer.getCurrent();
        this.lexer.resetStringPosition();
        String str2 = JSON.DEFAULT_TYPE_KEY;
        Object object = null;
        if (str1 == str2 && !this.lexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
          str1 = this.lexer.scanSymbol(this.symbolTable, '"');
          clazz = this.config.checkAutoType(str1, null);
          if (Map.class.isAssignableFrom(clazz)) {
            this.lexer.nextToken(16);
            if (this.lexer.token() == 13) {
              this.lexer.nextToken(16);
              return jSONException;
            } 
          } else {
            ObjectDeserializer objectDeserializer = this.config.getDeserializer(clazz);
            this.lexer.nextToken(16);
            setResolveStatus(2);
            if (parseContext != null && !(paramObject instanceof Integer))
              popContext(); 
            map = (Map)objectDeserializer.deserialze(this, clazz, paramObject);
            return map;
          } 
        } else {
          this.lexer.nextToken();
          if (b)
            setContext(parseContext); 
          Type type = map.getType((String)clazz);
          if (this.lexer.token() == 8) {
            this.lexer.nextToken();
          } else {
            object = parseObject(type, clazz);
          } 
          map.apply((String)clazz, object);
          setContext(parseContext, object, clazz);
          setContext(parseContext);
          i = this.lexer.token();
          if (i != 20) {
            if (i == 15)
              continue; 
            if (i == 13) {
              this.lexer.nextToken();
              return map;
            } 
          } else {
            return map;
          } 
        } 
        b++;
      } 
    } finally {
      setContext(parseContext);
    } 
  }
  
  public Object parse(Object paramObject) {
    JSONLexer jSONLexer = this.lexer;
    int i = jSONLexer.token();
    if (i != 12) {
      if (i != 14) {
        if (i != 26) {
          TreeSet treeSet;
          HashSet hashSet;
          String str;
          switch (i) {
            default:
              switch (i) {
                default:
                  switch (i) {
                    default:
                      paramObject = new StringBuilder();
                      paramObject.append("syntax error, ");
                      paramObject.append(jSONLexer.info());
                      throw new JSONException(paramObject.toString());
                    case 23:
                      jSONLexer.nextToken();
                      return null;
                    case 22:
                      jSONLexer.nextToken();
                      treeSet = new TreeSet();
                      parseArray(treeSet, paramObject);
                      return treeSet;
                    case 21:
                      treeSet.nextToken();
                      hashSet = new HashSet();
                      parseArray(hashSet, paramObject);
                      return hashSet;
                    case 20:
                      break;
                  } 
                  if (hashSet.isBlankInput())
                    return null; 
                  paramObject = new StringBuilder();
                  paramObject.append("unterminated json string, ");
                  paramObject.append(hashSet.info());
                  throw new JSONException(paramObject.toString());
                case 9:
                  hashSet.nextToken(18);
                  if (hashSet.token() == 18) {
                    hashSet.nextToken(10);
                    accept(10);
                    long l = hashSet.integerValue().longValue();
                    accept(2);
                    accept(11);
                    return new Date(l);
                  } 
                  throw new JSONException("syntax error");
                case 8:
                  hashSet.nextToken();
                  return null;
                case 7:
                  hashSet.nextToken();
                  return Boolean.FALSE;
                case 6:
                  break;
              } 
              hashSet.nextToken();
              return Boolean.TRUE;
            case 4:
              str = hashSet.stringVal();
              hashSet.nextToken(16);
              if (hashSet.isEnabled(Feature.AllowISO8601DateFormat)) {
                paramObject = new JSONScanner(str);
                try {
                  if (paramObject.scanISO8601DateIfMatch())
                    return paramObject.getCalendar().getTime(); 
                } finally {
                  paramObject.close();
                } 
              } 
              return str;
            case 3:
              paramObject = hashSet.decimalValue(hashSet.isEnabled(Feature.UseBigDecimal));
              hashSet.nextToken();
              return paramObject;
            case 2:
              break;
          } 
          paramObject = hashSet.integerValue();
          hashSet.nextToken();
          return paramObject;
        } 
        paramObject = jSONLexer.bytesValue();
        jSONLexer.nextToken();
        return paramObject;
      } 
      JSONArray jSONArray = new JSONArray();
      parseArray((Collection)jSONArray, paramObject);
      return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
    } 
    return parseObject((Map)new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), paramObject);
  }
  
  public <T> List<T> parseArray(Class<T> paramClass) {
    ArrayList<T> arrayList = new ArrayList();
    parseArray(paramClass, arrayList);
    return arrayList;
  }
  
  public void parseArray(Class<?> paramClass, Collection paramCollection) {
    parseArray(paramClass, paramCollection);
  }
  
  public void parseArray(Type paramType, Collection paramCollection) {
    parseArray(paramType, paramCollection, null);
  }
  
  public void parseArray(Type paramType, Collection paramCollection, Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: invokeinterface token : ()I
    //   9: istore #4
    //   11: iload #4
    //   13: bipush #21
    //   15: if_icmpeq -> 29
    //   18: iload #4
    //   20: istore #5
    //   22: iload #4
    //   24: bipush #22
    //   26: if_icmpne -> 49
    //   29: aload_0
    //   30: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   33: invokeinterface nextToken : ()V
    //   38: aload_0
    //   39: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   42: invokeinterface token : ()I
    //   47: istore #5
    //   49: iload #5
    //   51: bipush #14
    //   53: if_icmpne -> 435
    //   56: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   59: aload_1
    //   60: if_acmpne -> 81
    //   63: getstatic com/alibaba/fastjson/serializer/IntegerCodec.instance : Lcom/alibaba/fastjson/serializer/IntegerCodec;
    //   66: astore #6
    //   68: aload_0
    //   69: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   72: iconst_2
    //   73: invokeinterface nextToken : (I)V
    //   78: goto -> 131
    //   81: ldc java/lang/String
    //   83: aload_1
    //   84: if_acmpne -> 105
    //   87: getstatic com/alibaba/fastjson/serializer/StringCodec.instance : Lcom/alibaba/fastjson/serializer/StringCodec;
    //   90: astore #6
    //   92: aload_0
    //   93: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   96: iconst_4
    //   97: invokeinterface nextToken : (I)V
    //   102: goto -> 131
    //   105: aload_0
    //   106: getfield config : Lcom/alibaba/fastjson/parser/ParserConfig;
    //   109: aload_1
    //   110: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   113: astore #6
    //   115: aload_0
    //   116: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   119: aload #6
    //   121: invokeinterface getFastMatchToken : ()I
    //   126: invokeinterface nextToken : (I)V
    //   131: aload_0
    //   132: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   135: astore #7
    //   137: aload_0
    //   138: aload_2
    //   139: aload_3
    //   140: invokevirtual setContext : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   143: pop
    //   144: iconst_0
    //   145: istore #5
    //   147: aload_0
    //   148: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   151: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   154: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   159: ifeq -> 188
    //   162: aload_0
    //   163: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   166: invokeinterface token : ()I
    //   171: bipush #16
    //   173: if_icmpne -> 188
    //   176: aload_0
    //   177: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   180: invokeinterface nextToken : ()V
    //   185: goto -> 162
    //   188: aload_0
    //   189: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   192: invokeinterface token : ()I
    //   197: istore #4
    //   199: iload #4
    //   201: bipush #15
    //   203: if_icmpne -> 224
    //   206: aload_0
    //   207: aload #7
    //   209: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   212: aload_0
    //   213: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   216: bipush #16
    //   218: invokeinterface nextToken : (I)V
    //   223: return
    //   224: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   227: astore #8
    //   229: aconst_null
    //   230: astore #9
    //   232: aconst_null
    //   233: astore_3
    //   234: aload #8
    //   236: aload_1
    //   237: if_acmpne -> 259
    //   240: aload_2
    //   241: getstatic com/alibaba/fastjson/serializer/IntegerCodec.instance : Lcom/alibaba/fastjson/serializer/IntegerCodec;
    //   244: aload_0
    //   245: aconst_null
    //   246: aconst_null
    //   247: invokevirtual deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: invokeinterface add : (Ljava/lang/Object;)Z
    //   255: pop
    //   256: goto -> 390
    //   259: ldc java/lang/String
    //   261: aload_1
    //   262: if_acmpne -> 333
    //   265: aload_0
    //   266: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   269: invokeinterface token : ()I
    //   274: iconst_4
    //   275: if_icmpne -> 302
    //   278: aload_0
    //   279: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   282: invokeinterface stringVal : ()Ljava/lang/String;
    //   287: astore_3
    //   288: aload_0
    //   289: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   292: bipush #16
    //   294: invokeinterface nextToken : (I)V
    //   299: goto -> 322
    //   302: aload_0
    //   303: invokevirtual parse : ()Ljava/lang/Object;
    //   306: astore #9
    //   308: aload #9
    //   310: ifnonnull -> 316
    //   313: goto -> 322
    //   316: aload #9
    //   318: invokevirtual toString : ()Ljava/lang/String;
    //   321: astore_3
    //   322: aload_2
    //   323: aload_3
    //   324: invokeinterface add : (Ljava/lang/Object;)Z
    //   329: pop
    //   330: goto -> 390
    //   333: aload_0
    //   334: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   337: invokeinterface token : ()I
    //   342: bipush #8
    //   344: if_icmpne -> 362
    //   347: aload_0
    //   348: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   351: invokeinterface nextToken : ()V
    //   356: aload #9
    //   358: astore_3
    //   359: goto -> 377
    //   362: aload #6
    //   364: aload_0
    //   365: aload_1
    //   366: iload #5
    //   368: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   371: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: astore_3
    //   377: aload_2
    //   378: aload_3
    //   379: invokeinterface add : (Ljava/lang/Object;)Z
    //   384: pop
    //   385: aload_0
    //   386: aload_2
    //   387: invokevirtual checkListResolve : (Ljava/util/Collection;)V
    //   390: aload_0
    //   391: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   394: invokeinterface token : ()I
    //   399: bipush #16
    //   401: if_icmpne -> 420
    //   404: aload_0
    //   405: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   408: aload #6
    //   410: invokeinterface getFastMatchToken : ()I
    //   415: invokeinterface nextToken : (I)V
    //   420: iinc #5, 1
    //   423: goto -> 147
    //   426: astore_1
    //   427: aload_0
    //   428: aload #7
    //   430: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   433: aload_1
    //   434: athrow
    //   435: new java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial <init> : ()V
    //   442: astore_1
    //   443: aload_1
    //   444: ldc_w 'exepct '[', but '
    //   447: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_1
    //   452: iload #5
    //   454: invokestatic name : (I)Ljava/lang/String;
    //   457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload_1
    //   462: ldc_w ', '
    //   465: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_1
    //   470: aload_0
    //   471: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   474: invokeinterface info : ()Ljava/lang/String;
    //   479: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: new com/alibaba/fastjson/JSONException
    //   486: dup
    //   487: aload_1
    //   488: invokevirtual toString : ()Ljava/lang/String;
    //   491: invokespecial <init> : (Ljava/lang/String;)V
    //   494: athrow
    // Exception table:
    //   from	to	target	type
    //   147	162	426	finally
    //   162	185	426	finally
    //   188	199	426	finally
    //   224	229	426	finally
    //   240	256	426	finally
    //   265	299	426	finally
    //   302	308	426	finally
    //   316	322	426	finally
    //   322	330	426	finally
    //   333	356	426	finally
    //   362	377	426	finally
    //   377	390	426	finally
    //   390	420	426	finally
  }
  
  public final void parseArray(Collection paramCollection) {
    parseArray(paramCollection, (Object)null);
  }
  
  public final void parseArray(Collection paramCollection, Object paramObject) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == 21 || jSONLexer.token() == 22)
      jSONLexer.nextToken(); 
    if (jSONLexer.token() == 14) {
      jSONLexer.nextToken(4);
      ParseContext parseContext = this.context;
      setContext(paramCollection, paramObject);
      byte b = 0;
      try {
        while (true) {
          JSONException<Object> jSONException;
          JSONArray jSONArray;
          String str;
          if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas))
            while (jSONLexer.token() == 16)
              jSONLexer.nextToken();  
          int i = jSONLexer.token();
          paramObject = null;
          switch (i) {
            default:
              paramObject = parse();
              break;
            case 23:
              jSONLexer.nextToken(4);
              break;
            case 20:
              jSONException = new JSONException();
              this("unclosed jsonArray");
              throw jSONException;
            case 15:
              jSONLexer.nextToken(16);
              return;
            case 14:
              jSONArray = new JSONArray();
              this();
              parseArray((Collection)jSONArray, Integer.valueOf(b));
              paramObject = jSONArray;
              if (jSONLexer.isEnabled(Feature.UseObjectArray))
                paramObject = jSONArray.toArray(); 
              break;
            case 12:
              paramObject = new JSONObject();
              super(jSONLexer.isEnabled(Feature.OrderedField));
              paramObject = parseObject((Map)paramObject, Integer.valueOf(b));
              break;
            case 8:
              jSONLexer.nextToken(4);
              break;
            case 7:
              paramObject = Boolean.FALSE;
              jSONLexer.nextToken(16);
              break;
            case 6:
              paramObject = Boolean.TRUE;
              jSONLexer.nextToken(16);
              break;
            case 4:
              str = jSONLexer.stringVal();
              jSONLexer.nextToken(16);
              paramObject = str;
              if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner();
                this(str);
                paramObject = str;
                if (jSONScanner.scanISO8601DateIfMatch())
                  paramObject = jSONScanner.getCalendar().getTime(); 
                jSONScanner.close();
              } 
              break;
            case 3:
              if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                paramObject = jSONLexer.decimalValue(true);
              } else {
                paramObject = jSONLexer.decimalValue(false);
              } 
              jSONLexer.nextToken(16);
              break;
            case 2:
              paramObject = jSONLexer.integerValue();
              jSONLexer.nextToken(16);
              break;
          } 
          jSONException.add(paramObject);
          checkListResolve((Collection)jSONException);
          if (jSONLexer.token() == 16)
            jSONLexer.nextToken(4); 
          b++;
        } 
      } finally {
        setContext(parseContext);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect [, actual ");
    stringBuilder.append(JSONToken.name(jSONLexer.token()));
    stringBuilder.append(", pos ");
    stringBuilder.append(jSONLexer.pos());
    throw new JSONException(stringBuilder.toString());
  }
  
  public Object[] parseArray(Type[] paramArrayOfType) {
    if (this.lexer.token() == 8) {
      this.lexer.nextToken(16);
      return null;
    } 
    if (this.lexer.token() == 14) {
      Object[] arrayOfObject = new Object[paramArrayOfType.length];
      if (paramArrayOfType.length == 0) {
        this.lexer.nextToken(15);
        if (this.lexer.token() == 15) {
          this.lexer.nextToken(16);
          return new Object[0];
        } 
        throw new JSONException("syntax error");
      } 
      this.lexer.nextToken(2);
      byte b = 0;
      while (b < paramArrayOfType.length) {
        Object object;
        if (this.lexer.token() == 8) {
          this.lexer.nextToken(16);
          object = null;
        } else {
          Type type = paramArrayOfType[b];
          if (type == int.class || type == Integer.class) {
            if (this.lexer.token() == 2) {
              object = Integer.valueOf(this.lexer.intValue());
              this.lexer.nextToken(16);
            } else {
              object = TypeUtils.cast(parse(), type, this.config);
            } 
          } else if (type == String.class) {
            if (this.lexer.token() == 4) {
              object = this.lexer.stringVal();
              this.lexer.nextToken(16);
            } else {
              object = TypeUtils.cast(parse(), type, this.config);
            } 
          } else {
            boolean bool;
            if (b == paramArrayOfType.length - 1 && type instanceof Class) {
              object = type;
              bool = object.isArray();
              object = object.getComponentType();
            } else {
              object = null;
              bool = false;
            } 
            if (bool && this.lexer.token() != 14) {
              ArrayList<Object> arrayList = new ArrayList();
              object = this.config.getDeserializer((Type)object);
              int i = object.getFastMatchToken();
              if (this.lexer.token() != 15)
                while (true) {
                  arrayList.add(object.deserialze(this, type, null));
                  if (this.lexer.token() == 16) {
                    this.lexer.nextToken(i);
                    continue;
                  } 
                  if (this.lexer.token() == 15)
                    break; 
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("syntax error :");
                  stringBuilder1.append(JSONToken.name(this.lexer.token()));
                  throw new JSONException(stringBuilder1.toString());
                }  
              Object object1 = TypeUtils.cast(arrayList, type, this.config);
            } else {
              object = this.config.getDeserializer(type).deserialze(this, type, null);
            } 
          } 
        } 
        arrayOfObject[b] = object;
        if (this.lexer.token() == 15)
          break; 
        if (this.lexer.token() == 16) {
          if (b == stringBuilder1.length - 1) {
            this.lexer.nextToken(15);
          } else {
            this.lexer.nextToken(2);
          } 
          b++;
          continue;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("syntax error :");
        stringBuilder1.append(JSONToken.name(this.lexer.token()));
        throw new JSONException(stringBuilder1.toString());
      } 
      if (this.lexer.token() == 15) {
        this.lexer.nextToken(16);
        return arrayOfObject;
      } 
      throw new JSONException("syntax error");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error : ");
    stringBuilder.append(this.lexer.tokenName());
    throw new JSONException(stringBuilder.toString());
  }
  
  public Object parseArrayWithType(Type paramType) {
    ParameterizedType parameterizedType;
    if (this.lexer.token() == 8) {
      this.lexer.nextToken();
      return null;
    } 
    Type[] arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
    if (arrayOfType.length == 1) {
      ArrayList arrayList;
      Type type = arrayOfType[0];
      if (type instanceof Class) {
        arrayList = new ArrayList();
        parseArray((Class)type, arrayList);
        return arrayList;
      } 
      if (type instanceof WildcardType) {
        WildcardType wildcardType = (WildcardType)type;
        type = wildcardType.getUpperBounds()[0];
        if (Object.class.equals(type)) {
          if ((wildcardType.getLowerBounds()).length == 0)
            return parse(); 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("not support type : ");
          stringBuilder1.append(arrayList);
          throw new JSONException(stringBuilder1.toString());
        } 
        arrayList = new ArrayList();
        parseArray((Class)stringBuilder1, arrayList);
        return arrayList;
      } 
      if (stringBuilder1 instanceof TypeVariable) {
        Type type1 = (TypeVariable)stringBuilder1;
        Type[] arrayOfType1 = type1.getBounds();
        if (arrayOfType1.length == 1) {
          type1 = arrayOfType1[0];
          if (type1 instanceof Class) {
            arrayList = new ArrayList();
            parseArray((Class)type1, arrayList);
            return arrayList;
          } 
        } else {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("not support : ");
          stringBuilder2.append(type1);
          throw new JSONException(stringBuilder2.toString());
        } 
      } 
      if (stringBuilder1 instanceof ParameterizedType) {
        parameterizedType = (ParameterizedType)stringBuilder1;
        ArrayList arrayList1 = new ArrayList();
        parseArray(parameterizedType, arrayList1);
        return arrayList1;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("TODO : ");
      stringBuilder1.append(parameterizedType);
      throw new JSONException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not support type ");
    stringBuilder.append(parameterizedType);
    throw new JSONException(stringBuilder.toString());
  }
  
  public void parseExtra(Object paramObject, String paramString) {
    this.lexer.nextTokenWithColon();
    List<ExtraTypeProvider> list = this.extraTypeProviders;
    Object object = null;
    Type type = null;
    if (list != null) {
      Iterator<ExtraTypeProvider> iterator = this.extraTypeProviders.iterator();
      for (object = type; iterator.hasNext(); object = ((ExtraTypeProvider)iterator.next()).getExtraType(paramObject, paramString));
    } 
    if (object == null) {
      object = parse();
    } else {
      object = parseObject((Type)object);
    } 
    if (paramObject instanceof ExtraProcessable) {
      ((ExtraProcessable)paramObject).processExtra(paramString, object);
      return;
    } 
    if (this.extraProcessors != null) {
      Iterator<ExtraProcessor> iterator = this.extraProcessors.iterator();
      while (iterator.hasNext())
        ((ExtraProcessor)iterator.next()).processExtra(paramObject, paramString, object); 
    } 
    if (this.resolveStatus == 1)
      this.resolveStatus = 0; 
  }
  
  public Object parseKey() {
    if (this.lexer.token() == 18) {
      String str = this.lexer.stringVal();
      this.lexer.nextToken(16);
      return str;
    } 
    return parse(null);
  }
  
  public JSONObject parseObject() {
    return (JSONObject)parseObject((Map)new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
  }
  
  public <T> T parseObject(Class<T> paramClass) {
    return parseObject(paramClass, (Object)null);
  }
  
  public <T> T parseObject(Type paramType) {
    return parseObject(paramType, (Object)null);
  }
  
  public <T> T parseObject(Type paramType, Object paramObject) {
    String str;
    int i = this.lexer.token();
    if (i == 8) {
      this.lexer.nextToken();
      return null;
    } 
    if (i == 4) {
      byte[] arrayOfByte;
      if (paramType == byte[].class) {
        arrayOfByte = this.lexer.bytesValue();
        this.lexer.nextToken();
        return (T)arrayOfByte;
      } 
      if (arrayOfByte == char[].class) {
        str = this.lexer.stringVal();
        this.lexer.nextToken();
        return (T)str.toCharArray();
      } 
    } 
    ObjectDeserializer objectDeserializer = this.config.getDeserializer((Type)str);
    try {
      return (T)objectDeserializer.deserialze(this, (Type)str, paramObject);
    } catch (JSONException jSONException) {
      throw jSONException;
    } catch (Throwable throwable) {
      throw new JSONException(throwable.getMessage(), throwable);
    } 
  }
  
  public Object parseObject(Map paramMap) {
    return parseObject(paramMap, (Object)null);
  }
  
  public final Object parseObject(Map paramMap, Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore_3
    //   5: aload_3
    //   6: invokeinterface token : ()I
    //   11: bipush #8
    //   13: if_icmpne -> 24
    //   16: aload_3
    //   17: invokeinterface nextToken : ()V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_3
    //   25: invokeinterface token : ()I
    //   30: bipush #13
    //   32: if_icmpne -> 43
    //   35: aload_3
    //   36: invokeinterface nextToken : ()V
    //   41: aload_1
    //   42: areturn
    //   43: aload_3
    //   44: invokeinterface token : ()I
    //   49: bipush #12
    //   51: if_icmpeq -> 126
    //   54: aload_3
    //   55: invokeinterface token : ()I
    //   60: bipush #16
    //   62: if_icmpne -> 68
    //   65: goto -> 126
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore_1
    //   76: aload_1
    //   77: ldc_w 'syntax error, expect {, actual '
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload_3
    //   86: invokeinterface tokenName : ()Ljava/lang/String;
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: ldc_w ', '
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: aload_3
    //   105: invokeinterface info : ()Ljava/lang/String;
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: new com/alibaba/fastjson/JSONException
    //   117: dup
    //   118: aload_1
    //   119: invokevirtual toString : ()Ljava/lang/String;
    //   122: invokespecial <init> : (Ljava/lang/String;)V
    //   125: athrow
    //   126: aload_0
    //   127: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   130: astore #4
    //   132: iconst_0
    //   133: istore #5
    //   135: aload #4
    //   137: astore #6
    //   139: aload_3
    //   140: invokeinterface skipWhitespace : ()V
    //   145: aload #4
    //   147: astore #6
    //   149: aload_3
    //   150: invokeinterface getCurrent : ()C
    //   155: istore #7
    //   157: iload #7
    //   159: istore #8
    //   161: aload #4
    //   163: astore #6
    //   165: aload_3
    //   166: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   169: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   174: ifeq -> 224
    //   177: iload #7
    //   179: istore #8
    //   181: iload #7
    //   183: bipush #44
    //   185: if_icmpne -> 224
    //   188: aload #4
    //   190: astore #6
    //   192: aload_3
    //   193: invokeinterface next : ()C
    //   198: pop
    //   199: aload #4
    //   201: astore #6
    //   203: aload_3
    //   204: invokeinterface skipWhitespace : ()V
    //   209: aload #4
    //   211: astore #6
    //   213: aload_3
    //   214: invokeinterface getCurrent : ()C
    //   219: istore #7
    //   221: goto -> 177
    //   224: iload #8
    //   226: bipush #34
    //   228: if_icmpne -> 376
    //   231: aload #4
    //   233: astore #6
    //   235: aload_3
    //   236: aload_0
    //   237: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   240: bipush #34
    //   242: invokeinterface scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;C)Ljava/lang/String;
    //   247: astore #9
    //   249: aload #4
    //   251: astore #6
    //   253: aload_3
    //   254: invokeinterface skipWhitespace : ()V
    //   259: aload #4
    //   261: astore #6
    //   263: aload_3
    //   264: invokeinterface getCurrent : ()C
    //   269: bipush #58
    //   271: if_icmpne -> 284
    //   274: iconst_0
    //   275: istore #7
    //   277: aload #9
    //   279: astore #10
    //   281: goto -> 1150
    //   284: aload #4
    //   286: astore #6
    //   288: new com/alibaba/fastjson/JSONException
    //   291: astore_1
    //   292: aload #4
    //   294: astore #6
    //   296: new java/lang/StringBuilder
    //   299: astore_2
    //   300: aload #4
    //   302: astore #6
    //   304: aload_2
    //   305: invokespecial <init> : ()V
    //   308: aload #4
    //   310: astore #6
    //   312: aload_2
    //   313: ldc_w 'expect ':' at '
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload #4
    //   322: astore #6
    //   324: aload_2
    //   325: aload_3
    //   326: invokeinterface pos : ()I
    //   331: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload #4
    //   337: astore #6
    //   339: aload_2
    //   340: ldc_w ', name '
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload #4
    //   349: astore #6
    //   351: aload_2
    //   352: aload #9
    //   354: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #4
    //   360: astore #6
    //   362: aload_1
    //   363: aload_2
    //   364: invokevirtual toString : ()Ljava/lang/String;
    //   367: invokespecial <init> : (Ljava/lang/String;)V
    //   370: aload #4
    //   372: astore #6
    //   374: aload_1
    //   375: athrow
    //   376: iload #8
    //   378: bipush #125
    //   380: if_icmpne -> 510
    //   383: aload #4
    //   385: astore #6
    //   387: aload_3
    //   388: invokeinterface next : ()C
    //   393: pop
    //   394: aload #4
    //   396: astore #6
    //   398: aload_3
    //   399: invokeinterface resetStringPosition : ()V
    //   404: aload #4
    //   406: astore #6
    //   408: aload_3
    //   409: invokeinterface nextToken : ()V
    //   414: aload #4
    //   416: astore #9
    //   418: iload #5
    //   420: ifne -> 502
    //   423: aload #4
    //   425: astore #6
    //   427: aload_0
    //   428: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   431: ifnull -> 479
    //   434: aload #4
    //   436: astore #6
    //   438: aload_2
    //   439: aload_0
    //   440: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   443: getfield fieldName : Ljava/lang/Object;
    //   446: if_acmpne -> 479
    //   449: aload #4
    //   451: astore #6
    //   453: aload_1
    //   454: aload_0
    //   455: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   458: getfield object : Ljava/lang/Object;
    //   461: if_acmpne -> 479
    //   464: aload #4
    //   466: astore #6
    //   468: aload_0
    //   469: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   472: astore_2
    //   473: aload_2
    //   474: astore #9
    //   476: goto -> 502
    //   479: aload #4
    //   481: astore #6
    //   483: aload_0
    //   484: aload_1
    //   485: aload_2
    //   486: invokevirtual setContext : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   489: astore_2
    //   490: aload #4
    //   492: astore #9
    //   494: aload #4
    //   496: ifnonnull -> 502
    //   499: goto -> 473
    //   502: aload_0
    //   503: aload #9
    //   505: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   508: aload_1
    //   509: areturn
    //   510: iload #8
    //   512: bipush #39
    //   514: if_icmpne -> 673
    //   517: aload #4
    //   519: astore #6
    //   521: aload_3
    //   522: getstatic com/alibaba/fastjson/parser/Feature.AllowSingleQuotes : Lcom/alibaba/fastjson/parser/Feature;
    //   525: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   530: ifeq -> 648
    //   533: aload #4
    //   535: astore #6
    //   537: aload_3
    //   538: aload_0
    //   539: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   542: bipush #39
    //   544: invokeinterface scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;C)Ljava/lang/String;
    //   549: astore #9
    //   551: aload #4
    //   553: astore #6
    //   555: aload_3
    //   556: invokeinterface skipWhitespace : ()V
    //   561: aload #4
    //   563: astore #6
    //   565: aload_3
    //   566: invokeinterface getCurrent : ()C
    //   571: bipush #58
    //   573: if_icmpne -> 579
    //   576: goto -> 274
    //   579: aload #4
    //   581: astore #6
    //   583: new com/alibaba/fastjson/JSONException
    //   586: astore_2
    //   587: aload #4
    //   589: astore #6
    //   591: new java/lang/StringBuilder
    //   594: astore_1
    //   595: aload #4
    //   597: astore #6
    //   599: aload_1
    //   600: invokespecial <init> : ()V
    //   603: aload #4
    //   605: astore #6
    //   607: aload_1
    //   608: ldc_w 'expect ':' at '
    //   611: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload #4
    //   617: astore #6
    //   619: aload_1
    //   620: aload_3
    //   621: invokeinterface pos : ()I
    //   626: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload #4
    //   632: astore #6
    //   634: aload_2
    //   635: aload_1
    //   636: invokevirtual toString : ()Ljava/lang/String;
    //   639: invokespecial <init> : (Ljava/lang/String;)V
    //   642: aload #4
    //   644: astore #6
    //   646: aload_2
    //   647: athrow
    //   648: aload #4
    //   650: astore #6
    //   652: new com/alibaba/fastjson/JSONException
    //   655: astore_1
    //   656: aload #4
    //   658: astore #6
    //   660: aload_1
    //   661: ldc_w 'syntax error'
    //   664: invokespecial <init> : (Ljava/lang/String;)V
    //   667: aload #4
    //   669: astore #6
    //   671: aload_1
    //   672: athrow
    //   673: iload #8
    //   675: bipush #26
    //   677: if_icmpeq -> 3599
    //   680: iload #8
    //   682: bipush #44
    //   684: if_icmpeq -> 3574
    //   687: iload #8
    //   689: bipush #48
    //   691: if_icmplt -> 701
    //   694: iload #8
    //   696: bipush #57
    //   698: if_icmple -> 708
    //   701: iload #8
    //   703: bipush #45
    //   705: if_icmpne -> 930
    //   708: aload #4
    //   710: astore #6
    //   712: aload_3
    //   713: invokeinterface resetStringPosition : ()V
    //   718: aload #4
    //   720: astore #6
    //   722: aload_3
    //   723: invokeinterface scanNumber : ()V
    //   728: aload #4
    //   730: astore #6
    //   732: aload_3
    //   733: invokeinterface token : ()I
    //   738: iconst_2
    //   739: if_icmpne -> 757
    //   742: aload #4
    //   744: astore #6
    //   746: aload_3
    //   747: invokeinterface integerValue : ()Ljava/lang/Number;
    //   752: astore #9
    //   754: goto -> 773
    //   757: aload #4
    //   759: astore #6
    //   761: aload_3
    //   762: iconst_1
    //   763: invokeinterface decimalValue : (Z)Ljava/lang/Number;
    //   768: astore #9
    //   770: goto -> 754
    //   773: aload #4
    //   775: astore #6
    //   777: aload_3
    //   778: invokeinterface getCurrent : ()C
    //   783: bipush #58
    //   785: if_icmpne -> 791
    //   788: goto -> 274
    //   791: aload #4
    //   793: astore #6
    //   795: new com/alibaba/fastjson/JSONException
    //   798: astore_1
    //   799: aload #4
    //   801: astore #6
    //   803: new java/lang/StringBuilder
    //   806: astore_2
    //   807: aload #4
    //   809: astore #6
    //   811: aload_2
    //   812: invokespecial <init> : ()V
    //   815: aload #4
    //   817: astore #6
    //   819: aload_2
    //   820: ldc_w 'parse number key error'
    //   823: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload #4
    //   829: astore #6
    //   831: aload_2
    //   832: aload_3
    //   833: invokeinterface info : ()Ljava/lang/String;
    //   838: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload #4
    //   844: astore #6
    //   846: aload_1
    //   847: aload_2
    //   848: invokevirtual toString : ()Ljava/lang/String;
    //   851: invokespecial <init> : (Ljava/lang/String;)V
    //   854: aload #4
    //   856: astore #6
    //   858: aload_1
    //   859: athrow
    //   860: astore_1
    //   861: aload #4
    //   863: astore #6
    //   865: new com/alibaba/fastjson/JSONException
    //   868: astore_1
    //   869: aload #4
    //   871: astore #6
    //   873: new java/lang/StringBuilder
    //   876: astore_2
    //   877: aload #4
    //   879: astore #6
    //   881: aload_2
    //   882: invokespecial <init> : ()V
    //   885: aload #4
    //   887: astore #6
    //   889: aload_2
    //   890: ldc_w 'parse number key error'
    //   893: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload #4
    //   899: astore #6
    //   901: aload_2
    //   902: aload_3
    //   903: invokeinterface info : ()Ljava/lang/String;
    //   908: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload #4
    //   914: astore #6
    //   916: aload_1
    //   917: aload_2
    //   918: invokevirtual toString : ()Ljava/lang/String;
    //   921: invokespecial <init> : (Ljava/lang/String;)V
    //   924: aload #4
    //   926: astore #6
    //   928: aload_1
    //   929: athrow
    //   930: iload #8
    //   932: bipush #123
    //   934: if_icmpeq -> 1127
    //   937: iload #8
    //   939: bipush #91
    //   941: if_icmpne -> 947
    //   944: goto -> 1127
    //   947: aload #4
    //   949: astore #6
    //   951: aload_3
    //   952: getstatic com/alibaba/fastjson/parser/Feature.AllowUnQuotedFieldNames : Lcom/alibaba/fastjson/parser/Feature;
    //   955: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   960: ifeq -> 1102
    //   963: aload #4
    //   965: astore #6
    //   967: aload_3
    //   968: aload_0
    //   969: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   972: invokeinterface scanSymbolUnQuoted : (Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   977: astore #9
    //   979: aload #4
    //   981: astore #6
    //   983: aload_3
    //   984: invokeinterface skipWhitespace : ()V
    //   989: aload #4
    //   991: astore #6
    //   993: aload_3
    //   994: invokeinterface getCurrent : ()C
    //   999: istore #11
    //   1001: iload #11
    //   1003: bipush #58
    //   1005: if_icmpne -> 1011
    //   1008: goto -> 274
    //   1011: aload #4
    //   1013: astore #6
    //   1015: new com/alibaba/fastjson/JSONException
    //   1018: astore_1
    //   1019: aload #4
    //   1021: astore #6
    //   1023: new java/lang/StringBuilder
    //   1026: astore_2
    //   1027: aload #4
    //   1029: astore #6
    //   1031: aload_2
    //   1032: invokespecial <init> : ()V
    //   1035: aload #4
    //   1037: astore #6
    //   1039: aload_2
    //   1040: ldc_w 'expect ':' at '
    //   1043: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload #4
    //   1049: astore #6
    //   1051: aload_2
    //   1052: aload_3
    //   1053: invokeinterface pos : ()I
    //   1058: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload #4
    //   1064: astore #6
    //   1066: aload_2
    //   1067: ldc ', actual '
    //   1069: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload #4
    //   1075: astore #6
    //   1077: aload_2
    //   1078: iload #11
    //   1080: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload #4
    //   1086: astore #6
    //   1088: aload_1
    //   1089: aload_2
    //   1090: invokevirtual toString : ()Ljava/lang/String;
    //   1093: invokespecial <init> : (Ljava/lang/String;)V
    //   1096: aload #4
    //   1098: astore #6
    //   1100: aload_1
    //   1101: athrow
    //   1102: aload #4
    //   1104: astore #6
    //   1106: new com/alibaba/fastjson/JSONException
    //   1109: astore_1
    //   1110: aload #4
    //   1112: astore #6
    //   1114: aload_1
    //   1115: ldc_w 'syntax error'
    //   1118: invokespecial <init> : (Ljava/lang/String;)V
    //   1121: aload #4
    //   1123: astore #6
    //   1125: aload_1
    //   1126: athrow
    //   1127: aload #4
    //   1129: astore #6
    //   1131: aload_3
    //   1132: invokeinterface nextToken : ()V
    //   1137: aload #4
    //   1139: astore #6
    //   1141: aload_0
    //   1142: invokevirtual parse : ()Ljava/lang/Object;
    //   1145: astore #10
    //   1147: iconst_1
    //   1148: istore #7
    //   1150: iload #7
    //   1152: ifne -> 1176
    //   1155: aload #4
    //   1157: astore #6
    //   1159: aload_3
    //   1160: invokeinterface next : ()C
    //   1165: pop
    //   1166: aload #4
    //   1168: astore #6
    //   1170: aload_3
    //   1171: invokeinterface skipWhitespace : ()V
    //   1176: aload #4
    //   1178: astore #6
    //   1180: aload_3
    //   1181: invokeinterface getCurrent : ()C
    //   1186: istore #8
    //   1188: aload #4
    //   1190: astore #6
    //   1192: aload_3
    //   1193: invokeinterface resetStringPosition : ()V
    //   1198: aload #4
    //   1200: astore #6
    //   1202: aload #10
    //   1204: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   1207: if_acmpne -> 1600
    //   1210: aload #4
    //   1212: astore #6
    //   1214: aload_3
    //   1215: getstatic com/alibaba/fastjson/parser/Feature.DisableSpecialKeyDetect : Lcom/alibaba/fastjson/parser/Feature;
    //   1218: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   1223: ifne -> 1600
    //   1226: aload #4
    //   1228: astore #6
    //   1230: aload_3
    //   1231: aload_0
    //   1232: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   1235: bipush #34
    //   1237: invokeinterface scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;C)Ljava/lang/String;
    //   1242: astore #10
    //   1244: aload #4
    //   1246: astore #6
    //   1248: aload_0
    //   1249: getfield config : Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1252: aload #10
    //   1254: aconst_null
    //   1255: invokevirtual checkAutoType : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Class;
    //   1258: astore #9
    //   1260: aload #9
    //   1262: ifnonnull -> 1284
    //   1265: aload #4
    //   1267: astore #6
    //   1269: aload_1
    //   1270: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   1273: aload #10
    //   1275: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1280: pop
    //   1281: goto -> 135
    //   1284: aload #4
    //   1286: astore #6
    //   1288: aload_3
    //   1289: bipush #16
    //   1291: invokeinterface nextToken : (I)V
    //   1296: aload #4
    //   1298: astore #6
    //   1300: aload_3
    //   1301: invokeinterface token : ()I
    //   1306: bipush #13
    //   1308: if_icmpne -> 1468
    //   1311: aload #4
    //   1313: astore #6
    //   1315: aload_3
    //   1316: bipush #16
    //   1318: invokeinterface nextToken : (I)V
    //   1323: aload #4
    //   1325: astore #6
    //   1327: aload_0
    //   1328: getfield config : Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1331: aload #9
    //   1333: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   1336: astore_1
    //   1337: aload #4
    //   1339: astore #6
    //   1341: aload_1
    //   1342: instanceof com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   1345: ifeq -> 1366
    //   1348: aload #4
    //   1350: astore #6
    //   1352: aload_1
    //   1353: checkcast com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer
    //   1356: aload_0
    //   1357: aload #9
    //   1359: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   1362: astore_2
    //   1363: goto -> 1368
    //   1366: aconst_null
    //   1367: astore_2
    //   1368: aload_2
    //   1369: astore_1
    //   1370: aload_2
    //   1371: ifnonnull -> 1433
    //   1374: aload #9
    //   1376: ldc_w java/lang/Cloneable
    //   1379: if_acmpne -> 1397
    //   1382: aload #4
    //   1384: astore #6
    //   1386: new java/util/HashMap
    //   1389: dup
    //   1390: invokespecial <init> : ()V
    //   1393: astore_1
    //   1394: goto -> 1433
    //   1397: aload #4
    //   1399: astore #6
    //   1401: ldc_w 'java.util.Collections$EmptyMap'
    //   1404: aload #10
    //   1406: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1409: ifeq -> 1423
    //   1412: aload #4
    //   1414: astore #6
    //   1416: invokestatic emptyMap : ()Ljava/util/Map;
    //   1419: astore_1
    //   1420: goto -> 1433
    //   1423: aload #4
    //   1425: astore #6
    //   1427: aload #9
    //   1429: invokevirtual newInstance : ()Ljava/lang/Object;
    //   1432: astore_1
    //   1433: aload_0
    //   1434: aload #4
    //   1436: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1439: aload_1
    //   1440: areturn
    //   1441: astore_1
    //   1442: aload #4
    //   1444: astore #6
    //   1446: new com/alibaba/fastjson/JSONException
    //   1449: astore_2
    //   1450: aload #4
    //   1452: astore #6
    //   1454: aload_2
    //   1455: ldc_w 'create instance error'
    //   1458: aload_1
    //   1459: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1462: aload #4
    //   1464: astore #6
    //   1466: aload_2
    //   1467: athrow
    //   1468: aload #4
    //   1470: astore #6
    //   1472: aload_0
    //   1473: iconst_2
    //   1474: invokevirtual setResolveStatus : (I)V
    //   1477: aload #4
    //   1479: astore #6
    //   1481: aload_0
    //   1482: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1485: ifnull -> 1524
    //   1488: aload #4
    //   1490: astore #6
    //   1492: aload_2
    //   1493: instanceof java/lang/Integer
    //   1496: ifne -> 1524
    //   1499: aload #4
    //   1501: astore #6
    //   1503: aload_0
    //   1504: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1507: getfield fieldName : Ljava/lang/Object;
    //   1510: instanceof java/lang/Integer
    //   1513: ifne -> 1524
    //   1516: aload #4
    //   1518: astore #6
    //   1520: aload_0
    //   1521: invokevirtual popContext : ()V
    //   1524: aload #4
    //   1526: astore #6
    //   1528: aload_1
    //   1529: invokeinterface size : ()I
    //   1534: ifle -> 1569
    //   1537: aload #4
    //   1539: astore #6
    //   1541: aload_1
    //   1542: aload #9
    //   1544: aload_0
    //   1545: getfield config : Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1548: invokestatic cast : (Ljava/lang/Object;Ljava/lang/Class;Lcom/alibaba/fastjson/parser/ParserConfig;)Ljava/lang/Object;
    //   1551: astore_1
    //   1552: aload #4
    //   1554: astore #6
    //   1556: aload_0
    //   1557: aload_1
    //   1558: invokevirtual parseObject : (Ljava/lang/Object;)V
    //   1561: aload_0
    //   1562: aload #4
    //   1564: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1567: aload_1
    //   1568: areturn
    //   1569: aload #4
    //   1571: astore #6
    //   1573: aload_0
    //   1574: getfield config : Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1577: aload #9
    //   1579: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   1582: aload_0
    //   1583: aload #9
    //   1585: aload_2
    //   1586: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   1591: astore_1
    //   1592: aload_0
    //   1593: aload #4
    //   1595: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1598: aload_1
    //   1599: areturn
    //   1600: aload #10
    //   1602: ldc_w '$ref'
    //   1605: if_acmpne -> 2134
    //   1608: aload #4
    //   1610: ifnull -> 2134
    //   1613: aload #4
    //   1615: astore #6
    //   1617: aload_3
    //   1618: getstatic com/alibaba/fastjson/parser/Feature.DisableSpecialKeyDetect : Lcom/alibaba/fastjson/parser/Feature;
    //   1621: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   1626: ifne -> 2134
    //   1629: aload #4
    //   1631: astore #6
    //   1633: aload_3
    //   1634: iconst_4
    //   1635: invokeinterface nextToken : (I)V
    //   1640: aload #4
    //   1642: astore #6
    //   1644: aload_3
    //   1645: invokeinterface token : ()I
    //   1650: iconst_4
    //   1651: if_icmpne -> 2062
    //   1654: aload #4
    //   1656: astore #6
    //   1658: aload_3
    //   1659: invokeinterface stringVal : ()Ljava/lang/String;
    //   1664: astore_2
    //   1665: aload #4
    //   1667: astore #6
    //   1669: aload_3
    //   1670: bipush #13
    //   1672: invokeinterface nextToken : (I)V
    //   1677: aload #4
    //   1679: astore #6
    //   1681: ldc_w '@'
    //   1684: aload_2
    //   1685: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1688: ifeq -> 1779
    //   1691: aload #4
    //   1693: astore #6
    //   1695: aload_0
    //   1696: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1699: ifnull -> 2000
    //   1702: aload #4
    //   1704: astore #6
    //   1706: aload_0
    //   1707: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1710: astore #9
    //   1712: aload #4
    //   1714: astore #6
    //   1716: aload #9
    //   1718: getfield object : Ljava/lang/Object;
    //   1721: astore_2
    //   1722: aload_2
    //   1723: astore_1
    //   1724: aload #4
    //   1726: astore #6
    //   1728: aload_2
    //   1729: instanceof [Ljava/lang/Object;
    //   1732: ifne -> 2002
    //   1735: aload #4
    //   1737: astore #6
    //   1739: aload_2
    //   1740: instanceof java/util/Collection
    //   1743: ifeq -> 1751
    //   1746: aload_2
    //   1747: astore_1
    //   1748: goto -> 2002
    //   1751: aload #4
    //   1753: astore #6
    //   1755: aload #9
    //   1757: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1760: ifnull -> 2000
    //   1763: aload #4
    //   1765: astore #6
    //   1767: aload #9
    //   1769: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1772: getfield object : Ljava/lang/Object;
    //   1775: astore_1
    //   1776: goto -> 2002
    //   1779: aload #4
    //   1781: astore #6
    //   1783: ldc_w '..'
    //   1786: aload_2
    //   1787: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1790: ifeq -> 1858
    //   1793: aload #4
    //   1795: astore #6
    //   1797: aload #4
    //   1799: getfield object : Ljava/lang/Object;
    //   1802: ifnull -> 1818
    //   1805: aload #4
    //   1807: astore #6
    //   1809: aload #4
    //   1811: getfield object : Ljava/lang/Object;
    //   1814: astore_1
    //   1815: goto -> 2002
    //   1818: aload #4
    //   1820: astore #6
    //   1822: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1825: astore_1
    //   1826: aload #4
    //   1828: astore #6
    //   1830: aload_1
    //   1831: aload #4
    //   1833: aload_2
    //   1834: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1837: aload #4
    //   1839: astore #6
    //   1841: aload_0
    //   1842: aload_1
    //   1843: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1846: aload #4
    //   1848: astore #6
    //   1850: aload_0
    //   1851: iconst_1
    //   1852: invokevirtual setResolveStatus : (I)V
    //   1855: goto -> 2000
    //   1858: aload #4
    //   1860: astore #6
    //   1862: ldc_w '$'
    //   1865: aload_2
    //   1866: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1869: ifeq -> 1963
    //   1872: aload #4
    //   1874: astore_1
    //   1875: aload #4
    //   1877: astore #6
    //   1879: aload_1
    //   1880: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1883: ifnull -> 1898
    //   1886: aload #4
    //   1888: astore #6
    //   1890: aload_1
    //   1891: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1894: astore_1
    //   1895: goto -> 1875
    //   1898: aload #4
    //   1900: astore #6
    //   1902: aload_1
    //   1903: getfield object : Ljava/lang/Object;
    //   1906: ifnull -> 1921
    //   1909: aload #4
    //   1911: astore #6
    //   1913: aload_1
    //   1914: getfield object : Ljava/lang/Object;
    //   1917: astore_1
    //   1918: goto -> 2002
    //   1921: aload #4
    //   1923: astore #6
    //   1925: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1928: astore #9
    //   1930: aload #4
    //   1932: astore #6
    //   1934: aload #9
    //   1936: aload_1
    //   1937: aload_2
    //   1938: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1941: aload #4
    //   1943: astore #6
    //   1945: aload_0
    //   1946: aload #9
    //   1948: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1951: aload #4
    //   1953: astore #6
    //   1955: aload_0
    //   1956: iconst_1
    //   1957: invokevirtual setResolveStatus : (I)V
    //   1960: goto -> 2000
    //   1963: aload #4
    //   1965: astore #6
    //   1967: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1970: astore_1
    //   1971: aload #4
    //   1973: astore #6
    //   1975: aload_1
    //   1976: aload #4
    //   1978: aload_2
    //   1979: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1982: aload #4
    //   1984: astore #6
    //   1986: aload_0
    //   1987: aload_1
    //   1988: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1991: aload #4
    //   1993: astore #6
    //   1995: aload_0
    //   1996: iconst_1
    //   1997: invokevirtual setResolveStatus : (I)V
    //   2000: aconst_null
    //   2001: astore_1
    //   2002: aload #4
    //   2004: astore #6
    //   2006: aload_3
    //   2007: invokeinterface token : ()I
    //   2012: bipush #13
    //   2014: if_icmpne -> 2037
    //   2017: aload #4
    //   2019: astore #6
    //   2021: aload_3
    //   2022: bipush #16
    //   2024: invokeinterface nextToken : (I)V
    //   2029: aload_0
    //   2030: aload #4
    //   2032: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2035: aload_1
    //   2036: areturn
    //   2037: aload #4
    //   2039: astore #6
    //   2041: new com/alibaba/fastjson/JSONException
    //   2044: astore_1
    //   2045: aload #4
    //   2047: astore #6
    //   2049: aload_1
    //   2050: ldc_w 'syntax error'
    //   2053: invokespecial <init> : (Ljava/lang/String;)V
    //   2056: aload #4
    //   2058: astore #6
    //   2060: aload_1
    //   2061: athrow
    //   2062: aload #4
    //   2064: astore #6
    //   2066: new com/alibaba/fastjson/JSONException
    //   2069: astore_2
    //   2070: aload #4
    //   2072: astore #6
    //   2074: new java/lang/StringBuilder
    //   2077: astore_1
    //   2078: aload #4
    //   2080: astore #6
    //   2082: aload_1
    //   2083: invokespecial <init> : ()V
    //   2086: aload #4
    //   2088: astore #6
    //   2090: aload_1
    //   2091: ldc_w 'illegal ref, '
    //   2094: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: pop
    //   2098: aload #4
    //   2100: astore #6
    //   2102: aload_1
    //   2103: aload_3
    //   2104: invokeinterface token : ()I
    //   2109: invokestatic name : (I)Ljava/lang/String;
    //   2112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: pop
    //   2116: aload #4
    //   2118: astore #6
    //   2120: aload_2
    //   2121: aload_1
    //   2122: invokevirtual toString : ()Ljava/lang/String;
    //   2125: invokespecial <init> : (Ljava/lang/String;)V
    //   2128: aload #4
    //   2130: astore #6
    //   2132: aload_2
    //   2133: athrow
    //   2134: iload #5
    //   2136: istore #7
    //   2138: aload #4
    //   2140: astore #9
    //   2142: iload #5
    //   2144: ifne -> 2236
    //   2147: aload #4
    //   2149: astore #6
    //   2151: aload_0
    //   2152: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   2155: ifnull -> 2205
    //   2158: aload #4
    //   2160: astore #6
    //   2162: aload_2
    //   2163: aload_0
    //   2164: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   2167: getfield fieldName : Ljava/lang/Object;
    //   2170: if_acmpne -> 2205
    //   2173: aload #4
    //   2175: astore #6
    //   2177: aload_1
    //   2178: aload_0
    //   2179: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   2182: getfield object : Ljava/lang/Object;
    //   2185: if_acmpne -> 2205
    //   2188: aload #4
    //   2190: astore #6
    //   2192: aload_0
    //   2193: getfield context : Lcom/alibaba/fastjson/parser/ParseContext;
    //   2196: astore #9
    //   2198: iload #5
    //   2200: istore #7
    //   2202: goto -> 2236
    //   2205: aload #4
    //   2207: astore #6
    //   2209: aload_0
    //   2210: aload_1
    //   2211: aload_2
    //   2212: invokevirtual setContext : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2215: astore #9
    //   2217: aload #4
    //   2219: ifnonnull -> 2229
    //   2222: aload #9
    //   2224: astore #4
    //   2226: goto -> 2229
    //   2229: iconst_1
    //   2230: istore #7
    //   2232: aload #4
    //   2234: astore #9
    //   2236: aload #10
    //   2238: astore #4
    //   2240: aload #9
    //   2242: astore #6
    //   2244: aload_1
    //   2245: invokevirtual getClass : ()Ljava/lang/Class;
    //   2248: ldc_w com/alibaba/fastjson/JSONObject
    //   2251: if_acmpne -> 2278
    //   2254: aload #10
    //   2256: ifnonnull -> 2267
    //   2259: ldc_w 'null'
    //   2262: astore #4
    //   2264: goto -> 2278
    //   2267: aload #9
    //   2269: astore #6
    //   2271: aload #10
    //   2273: invokevirtual toString : ()Ljava/lang/String;
    //   2276: astore #4
    //   2278: iload #8
    //   2280: bipush #34
    //   2282: if_icmpne -> 2404
    //   2285: aload #9
    //   2287: astore #6
    //   2289: aload_3
    //   2290: invokeinterface scanString : ()V
    //   2295: aload #9
    //   2297: astore #6
    //   2299: aload_3
    //   2300: invokeinterface stringVal : ()Ljava/lang/String;
    //   2305: astore #12
    //   2307: aload #12
    //   2309: astore #10
    //   2311: aload #9
    //   2313: astore #6
    //   2315: aload_3
    //   2316: getstatic com/alibaba/fastjson/parser/Feature.AllowISO8601DateFormat : Lcom/alibaba/fastjson/parser/Feature;
    //   2319: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   2324: ifeq -> 2386
    //   2327: aload #9
    //   2329: astore #6
    //   2331: new com/alibaba/fastjson/parser/JSONScanner
    //   2334: astore #13
    //   2336: aload #9
    //   2338: astore #6
    //   2340: aload #13
    //   2342: aload #12
    //   2344: invokespecial <init> : (Ljava/lang/String;)V
    //   2347: aload #12
    //   2349: astore #10
    //   2351: aload #9
    //   2353: astore #6
    //   2355: aload #13
    //   2357: invokevirtual scanISO8601DateIfMatch : ()Z
    //   2360: ifeq -> 2377
    //   2363: aload #9
    //   2365: astore #6
    //   2367: aload #13
    //   2369: invokevirtual getCalendar : ()Ljava/util/Calendar;
    //   2372: invokevirtual getTime : ()Ljava/util/Date;
    //   2375: astore #10
    //   2377: aload #9
    //   2379: astore #6
    //   2381: aload #13
    //   2383: invokevirtual close : ()V
    //   2386: aload #9
    //   2388: astore #6
    //   2390: aload_1
    //   2391: aload #4
    //   2393: aload #10
    //   2395: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2400: pop
    //   2401: goto -> 2500
    //   2404: iload #8
    //   2406: bipush #48
    //   2408: if_icmplt -> 2418
    //   2411: iload #8
    //   2413: bipush #57
    //   2415: if_icmple -> 2425
    //   2418: iload #8
    //   2420: bipush #45
    //   2422: if_icmpne -> 2694
    //   2425: aload #9
    //   2427: astore #6
    //   2429: aload_3
    //   2430: invokeinterface scanNumber : ()V
    //   2435: aload #9
    //   2437: astore #6
    //   2439: aload_3
    //   2440: invokeinterface token : ()I
    //   2445: iconst_2
    //   2446: if_icmpne -> 2464
    //   2449: aload #9
    //   2451: astore #6
    //   2453: aload_3
    //   2454: invokeinterface integerValue : ()Ljava/lang/Number;
    //   2459: astore #10
    //   2461: goto -> 2485
    //   2464: aload #9
    //   2466: astore #6
    //   2468: aload_3
    //   2469: aload_3
    //   2470: getstatic com/alibaba/fastjson/parser/Feature.UseBigDecimal : Lcom/alibaba/fastjson/parser/Feature;
    //   2473: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   2478: invokeinterface decimalValue : (Z)Ljava/lang/Number;
    //   2483: astore #10
    //   2485: aload #9
    //   2487: astore #6
    //   2489: aload_1
    //   2490: aload #4
    //   2492: aload #10
    //   2494: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2499: pop
    //   2500: aload #9
    //   2502: astore #6
    //   2504: aload_3
    //   2505: invokeinterface skipWhitespace : ()V
    //   2510: aload #9
    //   2512: astore #6
    //   2514: aload_3
    //   2515: invokeinterface getCurrent : ()C
    //   2520: istore #5
    //   2522: iload #5
    //   2524: bipush #44
    //   2526: if_icmpne -> 2543
    //   2529: aload #9
    //   2531: astore #6
    //   2533: aload_3
    //   2534: invokeinterface next : ()C
    //   2539: pop
    //   2540: goto -> 3471
    //   2543: iload #5
    //   2545: bipush #125
    //   2547: if_icmpne -> 2602
    //   2550: aload #9
    //   2552: astore #6
    //   2554: aload_3
    //   2555: invokeinterface next : ()C
    //   2560: pop
    //   2561: aload #9
    //   2563: astore #6
    //   2565: aload_3
    //   2566: invokeinterface resetStringPosition : ()V
    //   2571: aload #9
    //   2573: astore #6
    //   2575: aload_3
    //   2576: invokeinterface nextToken : ()V
    //   2581: aload #9
    //   2583: astore #6
    //   2585: aload_0
    //   2586: aload #10
    //   2588: aload #4
    //   2590: invokevirtual setContext : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2593: pop
    //   2594: aload_0
    //   2595: aload #9
    //   2597: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2600: aload_1
    //   2601: areturn
    //   2602: aload #9
    //   2604: astore #6
    //   2606: new com/alibaba/fastjson/JSONException
    //   2609: astore_2
    //   2610: aload #9
    //   2612: astore #6
    //   2614: new java/lang/StringBuilder
    //   2617: astore_1
    //   2618: aload #9
    //   2620: astore #6
    //   2622: aload_1
    //   2623: invokespecial <init> : ()V
    //   2626: aload #9
    //   2628: astore #6
    //   2630: aload_1
    //   2631: ldc_w 'syntax error, position at '
    //   2634: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2637: pop
    //   2638: aload #9
    //   2640: astore #6
    //   2642: aload_1
    //   2643: aload_3
    //   2644: invokeinterface pos : ()I
    //   2649: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2652: pop
    //   2653: aload #9
    //   2655: astore #6
    //   2657: aload_1
    //   2658: ldc_w ', name '
    //   2661: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2664: pop
    //   2665: aload #9
    //   2667: astore #6
    //   2669: aload_1
    //   2670: aload #4
    //   2672: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2675: pop
    //   2676: aload #9
    //   2678: astore #6
    //   2680: aload_2
    //   2681: aload_1
    //   2682: invokevirtual toString : ()Ljava/lang/String;
    //   2685: invokespecial <init> : (Ljava/lang/String;)V
    //   2688: aload #9
    //   2690: astore #6
    //   2692: aload_2
    //   2693: athrow
    //   2694: iload #8
    //   2696: bipush #91
    //   2698: if_icmpne -> 2890
    //   2701: aload #9
    //   2703: astore #6
    //   2705: aload_3
    //   2706: invokeinterface nextToken : ()V
    //   2711: aload #9
    //   2713: astore #6
    //   2715: new com/alibaba/fastjson/JSONArray
    //   2718: astore #12
    //   2720: aload #9
    //   2722: astore #6
    //   2724: aload #12
    //   2726: invokespecial <init> : ()V
    //   2729: aload_2
    //   2730: ifnull -> 2742
    //   2733: aload #9
    //   2735: astore #6
    //   2737: aload_2
    //   2738: invokevirtual getClass : ()Ljava/lang/Class;
    //   2741: pop
    //   2742: aload_2
    //   2743: ifnonnull -> 2756
    //   2746: aload #9
    //   2748: astore #6
    //   2750: aload_0
    //   2751: aload #9
    //   2753: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2756: aload #9
    //   2758: astore #6
    //   2760: aload_0
    //   2761: aload #12
    //   2763: aload #4
    //   2765: invokevirtual parseArray : (Ljava/util/Collection;Ljava/lang/Object;)V
    //   2768: aload #12
    //   2770: astore #10
    //   2772: aload #9
    //   2774: astore #6
    //   2776: aload_3
    //   2777: getstatic com/alibaba/fastjson/parser/Feature.UseObjectArray : Lcom/alibaba/fastjson/parser/Feature;
    //   2780: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   2785: ifeq -> 2799
    //   2788: aload #9
    //   2790: astore #6
    //   2792: aload #12
    //   2794: invokevirtual toArray : ()[Ljava/lang/Object;
    //   2797: astore #10
    //   2799: aload #9
    //   2801: astore #6
    //   2803: aload_1
    //   2804: aload #4
    //   2806: aload #10
    //   2808: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2813: pop
    //   2814: aload #9
    //   2816: astore #6
    //   2818: aload_3
    //   2819: invokeinterface token : ()I
    //   2824: bipush #13
    //   2826: if_icmpne -> 2847
    //   2829: aload #9
    //   2831: astore #6
    //   2833: aload_3
    //   2834: invokeinterface nextToken : ()V
    //   2839: aload_0
    //   2840: aload #9
    //   2842: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2845: aload_1
    //   2846: areturn
    //   2847: aload #9
    //   2849: astore #6
    //   2851: aload_3
    //   2852: invokeinterface token : ()I
    //   2857: bipush #16
    //   2859: if_icmpne -> 2865
    //   2862: goto -> 2540
    //   2865: aload #9
    //   2867: astore #6
    //   2869: new com/alibaba/fastjson/JSONException
    //   2872: astore_1
    //   2873: aload #9
    //   2875: astore #6
    //   2877: aload_1
    //   2878: ldc_w 'syntax error'
    //   2881: invokespecial <init> : (Ljava/lang/String;)V
    //   2884: aload #9
    //   2886: astore #6
    //   2888: aload_1
    //   2889: athrow
    //   2890: iload #8
    //   2892: bipush #123
    //   2894: if_icmpne -> 3359
    //   2897: aload #9
    //   2899: astore #6
    //   2901: aload_3
    //   2902: invokeinterface nextToken : ()V
    //   2907: aload_2
    //   2908: ifnull -> 2930
    //   2911: aload #9
    //   2913: astore #6
    //   2915: aload_2
    //   2916: invokevirtual getClass : ()Ljava/lang/Class;
    //   2919: ldc java/lang/Integer
    //   2921: if_acmpne -> 2930
    //   2924: iconst_1
    //   2925: istore #5
    //   2927: goto -> 2933
    //   2930: iconst_0
    //   2931: istore #5
    //   2933: aload #9
    //   2935: astore #6
    //   2937: new com/alibaba/fastjson/JSONObject
    //   2940: astore #13
    //   2942: aload #9
    //   2944: astore #6
    //   2946: aload #13
    //   2948: aload_3
    //   2949: getstatic com/alibaba/fastjson/parser/Feature.OrderedField : Lcom/alibaba/fastjson/parser/Feature;
    //   2952: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   2957: invokespecial <init> : (Z)V
    //   2960: iload #5
    //   2962: ifne -> 2984
    //   2965: aload #9
    //   2967: astore #6
    //   2969: aload_0
    //   2970: aload #9
    //   2972: aload #13
    //   2974: aload #4
    //   2976: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2979: astore #12
    //   2981: goto -> 2987
    //   2984: aconst_null
    //   2985: astore #12
    //   2987: aload #9
    //   2989: astore #6
    //   2991: aload_0
    //   2992: getfield fieldTypeResolver : Lcom/alibaba/fastjson/parser/deserializer/FieldTypeResolver;
    //   2995: ifnull -> 3074
    //   2998: aload #4
    //   3000: ifnull -> 3017
    //   3003: aload #9
    //   3005: astore #6
    //   3007: aload #4
    //   3009: invokevirtual toString : ()Ljava/lang/String;
    //   3012: astore #10
    //   3014: goto -> 3020
    //   3017: aconst_null
    //   3018: astore #10
    //   3020: aload #9
    //   3022: astore #6
    //   3024: aload_0
    //   3025: getfield fieldTypeResolver : Lcom/alibaba/fastjson/parser/deserializer/FieldTypeResolver;
    //   3028: aload_1
    //   3029: aload #10
    //   3031: invokeinterface resolve : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Type;
    //   3036: astore #10
    //   3038: aload #10
    //   3040: ifnull -> 3074
    //   3043: aload #9
    //   3045: astore #6
    //   3047: aload_0
    //   3048: getfield config : Lcom/alibaba/fastjson/parser/ParserConfig;
    //   3051: aload #10
    //   3053: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   3056: aload_0
    //   3057: aload #10
    //   3059: aload #4
    //   3061: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   3066: astore #10
    //   3068: iconst_1
    //   3069: istore #8
    //   3071: goto -> 3080
    //   3074: aconst_null
    //   3075: astore #10
    //   3077: iconst_0
    //   3078: istore #8
    //   3080: iload #8
    //   3082: ifne -> 3099
    //   3085: aload #9
    //   3087: astore #6
    //   3089: aload_0
    //   3090: aload #13
    //   3092: aload #4
    //   3094: invokevirtual parseObject : (Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;
    //   3097: astore #10
    //   3099: aload #12
    //   3101: ifnull -> 3121
    //   3104: aload #13
    //   3106: aload #10
    //   3108: if_acmpeq -> 3121
    //   3111: aload #9
    //   3113: astore #6
    //   3115: aload #12
    //   3117: aload_1
    //   3118: putfield object : Ljava/lang/Object;
    //   3121: aload #9
    //   3123: astore #6
    //   3125: aload_0
    //   3126: aload_1
    //   3127: aload #4
    //   3129: invokevirtual toString : ()Ljava/lang/String;
    //   3132: invokevirtual checkMapResolve : (Ljava/util/Map;Ljava/lang/Object;)V
    //   3135: aload #9
    //   3137: astore #6
    //   3139: aload_1
    //   3140: invokevirtual getClass : ()Ljava/lang/Class;
    //   3143: ldc_w com/alibaba/fastjson/JSONObject
    //   3146: if_acmpne -> 3170
    //   3149: aload #9
    //   3151: astore #6
    //   3153: aload_1
    //   3154: aload #4
    //   3156: invokevirtual toString : ()Ljava/lang/String;
    //   3159: aload #10
    //   3161: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3166: pop
    //   3167: goto -> 3185
    //   3170: aload #9
    //   3172: astore #6
    //   3174: aload_1
    //   3175: aload #4
    //   3177: aload #10
    //   3179: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3184: pop
    //   3185: iload #5
    //   3187: ifeq -> 3203
    //   3190: aload #9
    //   3192: astore #6
    //   3194: aload_0
    //   3195: aload #10
    //   3197: aload #4
    //   3199: invokevirtual setContext : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   3202: pop
    //   3203: aload #9
    //   3205: astore #6
    //   3207: aload_3
    //   3208: invokeinterface token : ()I
    //   3213: bipush #13
    //   3215: if_icmpne -> 3246
    //   3218: aload #9
    //   3220: astore #6
    //   3222: aload_3
    //   3223: invokeinterface nextToken : ()V
    //   3228: aload #9
    //   3230: astore #6
    //   3232: aload_0
    //   3233: aload #9
    //   3235: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3238: aload_0
    //   3239: aload #9
    //   3241: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3244: aload_1
    //   3245: areturn
    //   3246: aload #9
    //   3248: astore #6
    //   3250: aload_3
    //   3251: invokeinterface token : ()I
    //   3256: bipush #16
    //   3258: if_icmpne -> 3290
    //   3261: iload #5
    //   3263: ifeq -> 3277
    //   3266: aload #9
    //   3268: astore #6
    //   3270: aload_0
    //   3271: invokevirtual popContext : ()V
    //   3274: goto -> 2540
    //   3277: aload #9
    //   3279: astore #6
    //   3281: aload_0
    //   3282: aload #9
    //   3284: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3287: goto -> 2540
    //   3290: aload #9
    //   3292: astore #6
    //   3294: new com/alibaba/fastjson/JSONException
    //   3297: astore_2
    //   3298: aload #9
    //   3300: astore #6
    //   3302: new java/lang/StringBuilder
    //   3305: astore_1
    //   3306: aload #9
    //   3308: astore #6
    //   3310: aload_1
    //   3311: invokespecial <init> : ()V
    //   3314: aload #9
    //   3316: astore #6
    //   3318: aload_1
    //   3319: ldc_w 'syntax error, '
    //   3322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3325: pop
    //   3326: aload #9
    //   3328: astore #6
    //   3330: aload_1
    //   3331: aload_3
    //   3332: invokeinterface tokenName : ()Ljava/lang/String;
    //   3337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: pop
    //   3341: aload #9
    //   3343: astore #6
    //   3345: aload_2
    //   3346: aload_1
    //   3347: invokevirtual toString : ()Ljava/lang/String;
    //   3350: invokespecial <init> : (Ljava/lang/String;)V
    //   3353: aload #9
    //   3355: astore #6
    //   3357: aload_2
    //   3358: athrow
    //   3359: aload #9
    //   3361: astore #6
    //   3363: aload_3
    //   3364: invokeinterface nextToken : ()V
    //   3369: aload #9
    //   3371: astore #6
    //   3373: aload_0
    //   3374: invokevirtual parse : ()Ljava/lang/Object;
    //   3377: astore #12
    //   3379: aload #4
    //   3381: astore #10
    //   3383: aload #9
    //   3385: astore #6
    //   3387: aload_1
    //   3388: invokevirtual getClass : ()Ljava/lang/Class;
    //   3391: ldc_w com/alibaba/fastjson/JSONObject
    //   3394: if_acmpne -> 3408
    //   3397: aload #9
    //   3399: astore #6
    //   3401: aload #4
    //   3403: invokevirtual toString : ()Ljava/lang/String;
    //   3406: astore #10
    //   3408: aload #9
    //   3410: astore #6
    //   3412: aload_1
    //   3413: aload #10
    //   3415: aload #12
    //   3417: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3422: pop
    //   3423: aload #9
    //   3425: astore #6
    //   3427: aload_3
    //   3428: invokeinterface token : ()I
    //   3433: bipush #13
    //   3435: if_icmpne -> 3456
    //   3438: aload #9
    //   3440: astore #6
    //   3442: aload_3
    //   3443: invokeinterface nextToken : ()V
    //   3448: aload_0
    //   3449: aload #9
    //   3451: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3454: aload_1
    //   3455: areturn
    //   3456: aload #9
    //   3458: astore #6
    //   3460: aload_3
    //   3461: invokeinterface token : ()I
    //   3466: bipush #16
    //   3468: if_icmpne -> 3482
    //   3471: iload #7
    //   3473: istore #5
    //   3475: aload #9
    //   3477: astore #4
    //   3479: goto -> 1281
    //   3482: aload #9
    //   3484: astore #6
    //   3486: new com/alibaba/fastjson/JSONException
    //   3489: astore_1
    //   3490: aload #9
    //   3492: astore #6
    //   3494: new java/lang/StringBuilder
    //   3497: astore_2
    //   3498: aload #9
    //   3500: astore #6
    //   3502: aload_2
    //   3503: invokespecial <init> : ()V
    //   3506: aload #9
    //   3508: astore #6
    //   3510: aload_2
    //   3511: ldc_w 'syntax error, position at '
    //   3514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3517: pop
    //   3518: aload #9
    //   3520: astore #6
    //   3522: aload_2
    //   3523: aload_3
    //   3524: invokeinterface pos : ()I
    //   3529: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3532: pop
    //   3533: aload #9
    //   3535: astore #6
    //   3537: aload_2
    //   3538: ldc_w ', name '
    //   3541: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3544: pop
    //   3545: aload #9
    //   3547: astore #6
    //   3549: aload_2
    //   3550: aload #10
    //   3552: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3555: pop
    //   3556: aload #9
    //   3558: astore #6
    //   3560: aload_1
    //   3561: aload_2
    //   3562: invokevirtual toString : ()Ljava/lang/String;
    //   3565: invokespecial <init> : (Ljava/lang/String;)V
    //   3568: aload #9
    //   3570: astore #6
    //   3572: aload_1
    //   3573: athrow
    //   3574: aload #4
    //   3576: astore #6
    //   3578: new com/alibaba/fastjson/JSONException
    //   3581: astore_1
    //   3582: aload #4
    //   3584: astore #6
    //   3586: aload_1
    //   3587: ldc_w 'syntax error'
    //   3590: invokespecial <init> : (Ljava/lang/String;)V
    //   3593: aload #4
    //   3595: astore #6
    //   3597: aload_1
    //   3598: athrow
    //   3599: aload #4
    //   3601: astore #6
    //   3603: new com/alibaba/fastjson/JSONException
    //   3606: astore_1
    //   3607: aload #4
    //   3609: astore #6
    //   3611: aload_1
    //   3612: ldc_w 'syntax error'
    //   3615: invokespecial <init> : (Ljava/lang/String;)V
    //   3618: aload #4
    //   3620: astore #6
    //   3622: aload_1
    //   3623: athrow
    //   3624: astore_1
    //   3625: aload_0
    //   3626: aload #6
    //   3628: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   3631: aload_1
    //   3632: athrow
    // Exception table:
    //   from	to	target	type
    //   139	145	3624	finally
    //   149	157	3624	finally
    //   165	177	3624	finally
    //   192	199	3624	finally
    //   203	209	3624	finally
    //   213	221	3624	finally
    //   235	249	3624	finally
    //   253	259	3624	finally
    //   263	274	3624	finally
    //   288	292	3624	finally
    //   296	300	3624	finally
    //   304	308	3624	finally
    //   312	320	3624	finally
    //   324	335	3624	finally
    //   339	347	3624	finally
    //   351	358	3624	finally
    //   362	370	3624	finally
    //   374	376	3624	finally
    //   387	394	3624	finally
    //   398	404	3624	finally
    //   408	414	3624	finally
    //   427	434	3624	finally
    //   438	449	3624	finally
    //   453	464	3624	finally
    //   468	473	3624	finally
    //   483	490	3624	finally
    //   521	533	3624	finally
    //   537	551	3624	finally
    //   555	561	3624	finally
    //   565	576	3624	finally
    //   583	587	3624	finally
    //   591	595	3624	finally
    //   599	603	3624	finally
    //   607	615	3624	finally
    //   619	630	3624	finally
    //   634	642	3624	finally
    //   646	648	3624	finally
    //   652	656	3624	finally
    //   660	667	3624	finally
    //   671	673	3624	finally
    //   712	718	3624	finally
    //   722	728	3624	finally
    //   732	742	860	java/lang/NumberFormatException
    //   732	742	3624	finally
    //   746	754	860	java/lang/NumberFormatException
    //   746	754	3624	finally
    //   761	770	860	java/lang/NumberFormatException
    //   761	770	3624	finally
    //   777	788	3624	finally
    //   795	799	3624	finally
    //   803	807	3624	finally
    //   811	815	3624	finally
    //   819	827	3624	finally
    //   831	842	3624	finally
    //   846	854	3624	finally
    //   858	860	3624	finally
    //   865	869	3624	finally
    //   873	877	3624	finally
    //   881	885	3624	finally
    //   889	897	3624	finally
    //   901	912	3624	finally
    //   916	924	3624	finally
    //   928	930	3624	finally
    //   951	963	3624	finally
    //   967	979	3624	finally
    //   983	989	3624	finally
    //   993	1001	3624	finally
    //   1015	1019	3624	finally
    //   1023	1027	3624	finally
    //   1031	1035	3624	finally
    //   1039	1047	3624	finally
    //   1051	1062	3624	finally
    //   1066	1073	3624	finally
    //   1077	1084	3624	finally
    //   1088	1096	3624	finally
    //   1100	1102	3624	finally
    //   1106	1110	3624	finally
    //   1114	1121	3624	finally
    //   1125	1127	3624	finally
    //   1131	1137	3624	finally
    //   1141	1147	3624	finally
    //   1159	1166	3624	finally
    //   1170	1176	3624	finally
    //   1180	1188	3624	finally
    //   1192	1198	3624	finally
    //   1202	1210	3624	finally
    //   1214	1226	3624	finally
    //   1230	1244	3624	finally
    //   1248	1260	3624	finally
    //   1269	1281	3624	finally
    //   1288	1296	3624	finally
    //   1300	1311	3624	finally
    //   1315	1323	3624	finally
    //   1327	1337	1441	java/lang/Exception
    //   1327	1337	3624	finally
    //   1341	1348	1441	java/lang/Exception
    //   1341	1348	3624	finally
    //   1352	1363	1441	java/lang/Exception
    //   1352	1363	3624	finally
    //   1386	1394	1441	java/lang/Exception
    //   1386	1394	3624	finally
    //   1401	1412	1441	java/lang/Exception
    //   1401	1412	3624	finally
    //   1416	1420	1441	java/lang/Exception
    //   1416	1420	3624	finally
    //   1427	1433	1441	java/lang/Exception
    //   1427	1433	3624	finally
    //   1446	1450	3624	finally
    //   1454	1462	3624	finally
    //   1466	1468	3624	finally
    //   1472	1477	3624	finally
    //   1481	1488	3624	finally
    //   1492	1499	3624	finally
    //   1503	1516	3624	finally
    //   1520	1524	3624	finally
    //   1528	1537	3624	finally
    //   1541	1552	3624	finally
    //   1556	1561	3624	finally
    //   1573	1592	3624	finally
    //   1617	1629	3624	finally
    //   1633	1640	3624	finally
    //   1644	1654	3624	finally
    //   1658	1665	3624	finally
    //   1669	1677	3624	finally
    //   1681	1691	3624	finally
    //   1695	1702	3624	finally
    //   1706	1712	3624	finally
    //   1716	1722	3624	finally
    //   1728	1735	3624	finally
    //   1739	1746	3624	finally
    //   1755	1763	3624	finally
    //   1767	1776	3624	finally
    //   1783	1793	3624	finally
    //   1797	1805	3624	finally
    //   1809	1815	3624	finally
    //   1822	1826	3624	finally
    //   1830	1837	3624	finally
    //   1841	1846	3624	finally
    //   1850	1855	3624	finally
    //   1862	1872	3624	finally
    //   1879	1886	3624	finally
    //   1890	1895	3624	finally
    //   1902	1909	3624	finally
    //   1913	1918	3624	finally
    //   1925	1930	3624	finally
    //   1934	1941	3624	finally
    //   1945	1951	3624	finally
    //   1955	1960	3624	finally
    //   1967	1971	3624	finally
    //   1975	1982	3624	finally
    //   1986	1991	3624	finally
    //   1995	2000	3624	finally
    //   2006	2017	3624	finally
    //   2021	2029	3624	finally
    //   2041	2045	3624	finally
    //   2049	2056	3624	finally
    //   2060	2062	3624	finally
    //   2066	2070	3624	finally
    //   2074	2078	3624	finally
    //   2082	2086	3624	finally
    //   2090	2098	3624	finally
    //   2102	2116	3624	finally
    //   2120	2128	3624	finally
    //   2132	2134	3624	finally
    //   2151	2158	3624	finally
    //   2162	2173	3624	finally
    //   2177	2188	3624	finally
    //   2192	2198	3624	finally
    //   2209	2217	3624	finally
    //   2244	2254	3624	finally
    //   2271	2278	3624	finally
    //   2289	2295	3624	finally
    //   2299	2307	3624	finally
    //   2315	2327	3624	finally
    //   2331	2336	3624	finally
    //   2340	2347	3624	finally
    //   2355	2363	3624	finally
    //   2367	2377	3624	finally
    //   2381	2386	3624	finally
    //   2390	2401	3624	finally
    //   2429	2435	3624	finally
    //   2439	2449	3624	finally
    //   2453	2461	3624	finally
    //   2468	2485	3624	finally
    //   2489	2500	3624	finally
    //   2504	2510	3624	finally
    //   2514	2522	3624	finally
    //   2533	2540	3624	finally
    //   2554	2561	3624	finally
    //   2565	2571	3624	finally
    //   2575	2581	3624	finally
    //   2585	2594	3624	finally
    //   2606	2610	3624	finally
    //   2614	2618	3624	finally
    //   2622	2626	3624	finally
    //   2630	2638	3624	finally
    //   2642	2653	3624	finally
    //   2657	2665	3624	finally
    //   2669	2676	3624	finally
    //   2680	2688	3624	finally
    //   2692	2694	3624	finally
    //   2705	2711	3624	finally
    //   2715	2720	3624	finally
    //   2724	2729	3624	finally
    //   2737	2742	3624	finally
    //   2750	2756	3624	finally
    //   2760	2768	3624	finally
    //   2776	2788	3624	finally
    //   2792	2799	3624	finally
    //   2803	2814	3624	finally
    //   2818	2829	3624	finally
    //   2833	2839	3624	finally
    //   2851	2862	3624	finally
    //   2869	2873	3624	finally
    //   2877	2884	3624	finally
    //   2888	2890	3624	finally
    //   2901	2907	3624	finally
    //   2915	2924	3624	finally
    //   2937	2942	3624	finally
    //   2946	2960	3624	finally
    //   2969	2981	3624	finally
    //   2991	2998	3624	finally
    //   3007	3014	3624	finally
    //   3024	3038	3624	finally
    //   3047	3068	3624	finally
    //   3089	3099	3624	finally
    //   3115	3121	3624	finally
    //   3125	3135	3624	finally
    //   3139	3149	3624	finally
    //   3153	3167	3624	finally
    //   3174	3185	3624	finally
    //   3194	3203	3624	finally
    //   3207	3218	3624	finally
    //   3222	3228	3624	finally
    //   3232	3238	3624	finally
    //   3250	3261	3624	finally
    //   3270	3274	3624	finally
    //   3281	3287	3624	finally
    //   3294	3298	3624	finally
    //   3302	3306	3624	finally
    //   3310	3314	3624	finally
    //   3318	3326	3624	finally
    //   3330	3341	3624	finally
    //   3345	3353	3624	finally
    //   3357	3359	3624	finally
    //   3363	3369	3624	finally
    //   3373	3379	3624	finally
    //   3387	3397	3624	finally
    //   3401	3408	3624	finally
    //   3412	3423	3624	finally
    //   3427	3438	3624	finally
    //   3442	3448	3624	finally
    //   3460	3471	3624	finally
    //   3486	3490	3624	finally
    //   3494	3498	3624	finally
    //   3502	3506	3624	finally
    //   3510	3518	3624	finally
    //   3522	3533	3624	finally
    //   3537	3545	3624	finally
    //   3549	3556	3624	finally
    //   3560	3568	3624	finally
    //   3572	3574	3624	finally
    //   3578	3582	3624	finally
    //   3586	3593	3624	finally
    //   3597	3599	3624	finally
    //   3603	3607	3624	finally
    //   3611	3618	3624	finally
    //   3622	3624	3624	finally
  }
  
  public void parseObject(Object paramObject) {
    JavaBeanDeserializer javaBeanDeserializer;
    Class<?> clazz = paramObject.getClass();
    ObjectDeserializer objectDeserializer = this.config.getDeserializer(clazz);
    if (objectDeserializer instanceof JavaBeanDeserializer) {
      javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer;
    } else {
      javaBeanDeserializer = null;
    } 
    if (this.lexer.token() == 12 || this.lexer.token() == 16)
      while (true) {
        FieldDeserializer fieldDeserializer;
        String str = this.lexer.scanSymbol(this.symbolTable);
        if (str == null) {
          if (this.lexer.token() == 13) {
            this.lexer.nextToken(16);
            return;
          } 
          if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas))
            continue; 
        } 
        if (javaBeanDeserializer != null) {
          fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        } else {
          fieldDeserializer = null;
        } 
        if (fieldDeserializer == null) {
          if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
            this.lexer.nextTokenWithColon();
            parse();
            if (this.lexer.token() == 13) {
              this.lexer.nextToken();
              return;
            } 
            continue;
          } 
          paramObject = new StringBuilder();
          paramObject.append("setter not found, class ");
          paramObject.append(clazz.getName());
          paramObject.append(", property ");
          paramObject.append(str);
          throw new JSONException(paramObject.toString());
        } 
        Class<int> clazz1 = fieldDeserializer.fieldInfo.fieldClass;
        Object object = fieldDeserializer.fieldInfo.fieldType;
        if (clazz1 == int.class) {
          this.lexer.nextTokenWithColon(2);
          Object object1 = IntegerCodec.instance.deserialze(this, (Type)object, null);
        } else if (clazz1 == String.class) {
          this.lexer.nextTokenWithColon(4);
          object = StringCodec.deserialze(this);
        } else if (clazz1 == long.class) {
          this.lexer.nextTokenWithColon(2);
          object = LongCodec.instance.deserialze(this, (Type)object, null);
        } else {
          ObjectDeserializer objectDeserializer1 = this.config.getDeserializer(clazz1, (Type)object);
          this.lexer.nextTokenWithColon(objectDeserializer1.getFastMatchToken());
          object = objectDeserializer1.deserialze(this, (Type)object, null);
        } 
        fieldDeserializer.setValue(paramObject, object);
        if (this.lexer.token() != 16 && this.lexer.token() == 13) {
          this.lexer.nextToken(16);
          return;
        } 
      }  
    paramObject = new StringBuilder();
    paramObject.append("syntax error, expect {, actual ");
    paramObject.append(this.lexer.tokenName());
    throw new JSONException(paramObject.toString());
  }
  
  public void popContext() {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect))
      return; 
    this.context = this.context.parent;
    if (this.contextArrayIndex <= 0)
      return; 
    this.contextArrayIndex--;
    this.contextArray[this.contextArrayIndex] = null;
  }
  
  public void setConfig(ParserConfig paramParserConfig) {
    this.config = paramParserConfig;
  }
  
  public ParseContext setContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2) {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect))
      return null; 
    this.context = new ParseContext(paramParseContext, paramObject1, paramObject2);
    addContext(this.context);
    return this.context;
  }
  
  public ParseContext setContext(Object paramObject1, Object paramObject2) {
    return this.lexer.isEnabled(Feature.DisableCircularReferenceDetect) ? null : setContext(this.context, paramObject1, paramObject2);
  }
  
  public void setContext(ParseContext paramParseContext) {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect))
      return; 
    this.context = paramParseContext;
  }
  
  public void setDateFomrat(DateFormat paramDateFormat) {
    this.dateFormat = paramDateFormat;
  }
  
  public void setDateFormat(String paramString) {
    this.dateFormatPattern = paramString;
    this.dateFormat = null;
  }
  
  public void setFieldTypeResolver(FieldTypeResolver paramFieldTypeResolver) {
    this.fieldTypeResolver = paramFieldTypeResolver;
  }
  
  public void setResolveStatus(int paramInt) {
    this.resolveStatus = paramInt;
  }
  
  public void throwException(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect ");
    stringBuilder.append(JSONToken.name(paramInt));
    stringBuilder.append(", actual ");
    stringBuilder.append(JSONToken.name(this.lexer.token()));
    throw new JSONException(stringBuilder.toString());
  }
  
  public static class ResolveTask {
    public final ParseContext context;
    
    public FieldDeserializer fieldDeserializer;
    
    public ParseContext ownerContext;
    
    public final String referenceValue;
    
    public ResolveTask(ParseContext param1ParseContext, String param1String) {
      this.context = param1ParseContext;
      this.referenceValue = param1String;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\DefaultJSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
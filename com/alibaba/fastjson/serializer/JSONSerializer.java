package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

public class JSONSerializer extends SerializeFilterable {
  protected final SerializeConfig config;
  
  protected SerialContext context;
  
  private DateFormat dateFormat;
  
  private String dateFormatPattern;
  
  private String indent = "\t";
  
  private int indentCount = 0;
  
  protected Locale locale = JSON.defaultLocale;
  
  public final SerializeWriter out;
  
  protected IdentityHashMap<Object, SerialContext> references = null;
  
  protected TimeZone timeZone = JSON.defaultTimeZone;
  
  public JSONSerializer() {
    this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeConfig paramSerializeConfig) {
    this(new SerializeWriter(), paramSerializeConfig);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter) {
    this(paramSerializeWriter, SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter, SerializeConfig paramSerializeConfig) {
    this.out = paramSerializeWriter;
    this.config = paramSerializeConfig;
  }
  
  public static void write(SerializeWriter paramSerializeWriter, Object paramObject) {
    (new JSONSerializer(paramSerializeWriter)).write(paramObject);
  }
  
  public static void write(Writer paramWriter, Object paramObject) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter);
      jSONSerializer.write(paramObject);
      serializeWriter.writeTo(paramWriter);
      serializeWriter.close();
      return;
    } catch (IOException iOException) {
      paramObject = new JSONException();
      super(iOException.getMessage(), iOException);
      throw paramObject;
    } finally {}
    serializeWriter.close();
    throw paramWriter;
  }
  
  public boolean checkValue(SerializeFilterable paramSerializeFilterable) {
    boolean bool;
    if ((this.valueFilters != null && this.valueFilters.size() > 0) || (this.contextValueFilters != null && this.contextValueFilters.size() > 0) || (paramSerializeFilterable.valueFilters != null && paramSerializeFilterable.valueFilters.size() > 0) || (paramSerializeFilterable.contextValueFilters != null && paramSerializeFilterable.contextValueFilters.size() > 0) || this.out.writeNonStringValueAsString) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void close() {
    this.out.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    this.out.config(paramSerializerFeature, paramBoolean);
  }
  
  public boolean containsReference(Object paramObject) {
    IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
    boolean bool = false;
    if (identityHashMap == null)
      return false; 
    paramObject = this.references.get(paramObject);
    if (paramObject == null)
      return false; 
    paramObject = ((SerialContext)paramObject).fieldName;
    if (paramObject == null || paramObject instanceof Integer || paramObject instanceof String)
      bool = true; 
    return bool;
  }
  
  public void decrementIdent() {
    this.indentCount--;
  }
  
  public SerialContext getContext() {
    return this.context;
  }
  
  public DateFormat getDateFormat() {
    if (this.dateFormat == null && this.dateFormatPattern != null) {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.locale);
      this.dateFormat.setTimeZone(this.timeZone);
    } 
    return this.dateFormat;
  }
  
  public String getDateFormatPattern() {
    return (this.dateFormat instanceof SimpleDateFormat) ? ((SimpleDateFormat)this.dateFormat).toPattern() : this.dateFormatPattern;
  }
  
  public int getIndentCount() {
    return this.indentCount;
  }
  
  public SerializeConfig getMapping() {
    return this.config;
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass) {
    return this.config.getObjectWriter(paramClass);
  }
  
  public SerializeWriter getWriter() {
    return this.out;
  }
  
  public boolean hasNameFilters(SerializeFilterable paramSerializeFilterable) {
    boolean bool;
    if ((this.nameFilters != null && this.nameFilters.size() > 0) || (paramSerializeFilterable.nameFilters != null && paramSerializeFilterable.nameFilters.size() > 0)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void incrementIndent() {
    this.indentCount++;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature) {
    return this.out.isEnabled(paramSerializerFeature);
  }
  
  public final boolean isWriteClassName(Type paramType, Object paramObject) {
    boolean bool;
    if (this.out.isEnabled(SerializerFeature.WriteClassName) && (paramType != null || !this.out.isEnabled(SerializerFeature.NotWriteRootClassName) || this.context.parent != null)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void popContext() {
    if (this.context != null)
      this.context = this.context.parent; 
  }
  
  public void println() {
    this.out.write(10);
    for (byte b = 0; b < this.indentCount; b++)
      this.out.write(this.indent); 
  }
  
  public void setContext(SerialContext paramSerialContext) {
    this.context = paramSerialContext;
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt) {
    setContext(paramSerialContext, paramObject1, paramObject2, paramInt, 0);
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {
    if (this.out.disableCircularReferenceDetect)
      return; 
    this.context = new SerialContext(paramSerialContext, paramObject1, paramObject2, paramInt1, paramInt2);
    if (this.references == null)
      this.references = new IdentityHashMap<Object, SerialContext>(); 
    this.references.put(paramObject1, this.context);
  }
  
  public void setContext(Object paramObject1, Object paramObject2) {
    setContext(this.context, paramObject1, paramObject2, 0);
  }
  
  public void setDateFormat(String paramString) {
    this.dateFormatPattern = paramString;
    if (this.dateFormat != null)
      this.dateFormat = null; 
  }
  
  public void setDateFormat(DateFormat paramDateFormat) {
    this.dateFormat = paramDateFormat;
    if (this.dateFormatPattern != null)
      this.dateFormatPattern = null; 
  }
  
  public String toString() {
    return this.out.toString();
  }
  
  public final void write(Object paramObject) {
    if (paramObject == null) {
      this.out.writeNull();
      return;
    } 
    ObjectSerializer objectSerializer = getObjectWriter(paramObject.getClass());
    try {
      objectSerializer.write(this, paramObject, null, null, 0);
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } 
  }
  
  public final void write(String paramString) {
    StringCodec.instance.write(this, paramString);
  }
  
  protected final void writeKeyValue(char paramChar, String paramString, Object paramObject) {
    if (paramChar != '\000')
      this.out.write(paramChar); 
    this.out.writeFieldName(paramString);
    write(paramObject);
  }
  
  public void writeNull() {
    this.out.writeNull();
  }
  
  public void writeReference(Object paramObject) {
    SerialContext serialContext1 = this.context;
    if (paramObject == serialContext1.object) {
      this.out.write("{\"$ref\":\"@\"}");
      return;
    } 
    SerialContext serialContext2 = serialContext1.parent;
    SerialContext serialContext3 = serialContext1;
    if (serialContext2 != null) {
      serialContext3 = serialContext1;
      if (paramObject == serialContext2.object) {
        this.out.write("{\"$ref\":\"..\"}");
        return;
      } 
    } 
    while (true) {
      if (serialContext3.parent == null) {
        if (paramObject == serialContext3.object) {
          this.out.write("{\"$ref\":\"$\"}");
        } else {
          this.out.write("{\"$ref\":\"");
          this.out.write(((SerialContext)this.references.get(paramObject)).toString());
          this.out.write("\"}");
        } 
        return;
      } 
      serialContext3 = serialContext3.parent;
    } 
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2) {
    writeWithFieldName(paramObject1, paramObject2, (Type)null, 0);
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2, Type paramType, int paramInt) {
    if (paramObject1 == null)
      try {
        this.out.writeNull();
        return;
      } catch (IOException iOException) {
        throw new JSONException(iOException.getMessage(), iOException);
      }  
    getObjectWriter(iOException.getClass()).write(this, iOException, paramObject2, paramType, paramInt);
  }
  
  public final void writeWithFormat(Object paramObject, String paramString) {
    if (paramObject instanceof Date) {
      DateFormat dateFormat1 = getDateFormat();
      DateFormat dateFormat2 = dateFormat1;
      if (dateFormat1 == null) {
        dateFormat2 = new SimpleDateFormat(paramString, this.locale);
        dateFormat2.setTimeZone(this.timeZone);
      } 
      paramObject = dateFormat2.format((Date)paramObject);
      this.out.writeString((String)paramObject);
      return;
    } 
    if (paramObject instanceof byte[]) {
      GZIPOutputStream gZIPOutputStream;
      byte[] arrayOfByte = (byte[])paramObject;
      if ("gzip".equals(paramString) || "gzip,base64".equals(paramString)) {
        String str = null;
        GZIPOutputStream gZIPOutputStream1 = null;
        paramObject = gZIPOutputStream1;
        paramString = str;
        try {
          ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
          paramObject = gZIPOutputStream1;
          paramString = str;
          this();
          paramObject = gZIPOutputStream1;
          paramString = str;
          if (arrayOfByte.length < 512) {
            paramObject = gZIPOutputStream1;
            paramString = str;
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream();
            paramObject = gZIPOutputStream1;
            paramString = str;
            this(byteArrayOutputStream, arrayOfByte.length);
            gZIPOutputStream1 = gZIPOutputStream2;
          } else {
            paramObject = gZIPOutputStream1;
            paramString = str;
            gZIPOutputStream1 = new GZIPOutputStream(byteArrayOutputStream);
          } 
          paramObject = gZIPOutputStream1;
          gZIPOutputStream = gZIPOutputStream1;
          gZIPOutputStream1.write(arrayOfByte);
          paramObject = gZIPOutputStream1;
          gZIPOutputStream = gZIPOutputStream1;
          gZIPOutputStream1.finish();
          paramObject = gZIPOutputStream1;
          gZIPOutputStream = gZIPOutputStream1;
          this.out.writeByteArray(byteArrayOutputStream.toByteArray());
          IOUtils.close(gZIPOutputStream1);
          return;
        } catch (IOException iOException) {
          paramObject = gZIPOutputStream;
          JSONException jSONException = new JSONException();
          paramObject = gZIPOutputStream;
          this("write gzipBytes error", iOException);
          paramObject = gZIPOutputStream;
          throw jSONException;
        } finally {}
        IOUtils.close((Closeable)paramObject);
        throw gZIPOutputStream;
      } 
      if ("hex".equals(gZIPOutputStream)) {
        this.out.writeHex(arrayOfByte);
      } else {
        this.out.writeByteArray(arrayOfByte);
      } 
      return;
    } 
    write(paramObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\JSONSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
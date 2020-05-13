package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter implements Closeable, Flushable {
  private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
  
  private static final String[] REPLACEMENT_CHARS = new String[128];
  
  private String deferredName;
  
  private boolean htmlSafe;
  
  private String indent;
  
  private boolean lenient;
  
  private final Writer out;
  
  private String separator;
  
  private boolean serializeNulls;
  
  private final List<JsonScope> stack = new ArrayList<JsonScope>();
  
  static {
    for (byte b = 0; b <= 31; b++) {
      REPLACEMENT_CHARS[b] = String.format("\\u%04x", new Object[] { Integer.valueOf(b) });
    } 
    REPLACEMENT_CHARS[34] = "\\\"";
    REPLACEMENT_CHARS[92] = "\\\\";
    REPLACEMENT_CHARS[9] = "\\t";
    REPLACEMENT_CHARS[8] = "\\b";
    REPLACEMENT_CHARS[10] = "\\n";
    REPLACEMENT_CHARS[13] = "\\r";
    REPLACEMENT_CHARS[12] = "\\f";
    HTML_SAFE_REPLACEMENT_CHARS = (String[])REPLACEMENT_CHARS.clone();
    HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
    HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
    HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
    HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
    HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
  }
  
  public JsonWriter(Writer paramWriter) {
    this.stack.add(JsonScope.EMPTY_DOCUMENT);
    this.separator = ":";
    this.serializeNulls = true;
    if (paramWriter == null)
      throw new NullPointerException("out == null"); 
    this.out = paramWriter;
  }
  
  private void beforeName() throws IOException {
    JsonScope jsonScope = peek();
    if (jsonScope == JsonScope.NONEMPTY_OBJECT) {
      this.out.write(44);
    } else if (jsonScope != JsonScope.EMPTY_OBJECT) {
      throw new IllegalStateException("Nesting problem: " + this.stack);
    } 
    newline();
    replaceTop(JsonScope.DANGLING_NAME);
  }
  
  private void beforeValue(boolean paramBoolean) throws IOException {
    switch (peek()) {
      default:
        throw new IllegalStateException("Nesting problem: " + this.stack);
      case NONEMPTY_DOCUMENT:
        if (!this.lenient)
          throw new IllegalStateException("JSON must have only one top-level value."); 
      case EMPTY_DOCUMENT:
        if (!this.lenient && !paramBoolean)
          throw new IllegalStateException("JSON must start with an array or an object."); 
        replaceTop(JsonScope.NONEMPTY_DOCUMENT);
        return;
      case EMPTY_ARRAY:
        replaceTop(JsonScope.NONEMPTY_ARRAY);
        newline();
        return;
      case NONEMPTY_ARRAY:
        this.out.append(',');
        newline();
        return;
      case DANGLING_NAME:
        break;
    } 
    this.out.append(this.separator);
    replaceTop(JsonScope.NONEMPTY_OBJECT);
  }
  
  private JsonWriter close(JsonScope paramJsonScope1, JsonScope paramJsonScope2, String paramString) throws IOException {
    JsonScope jsonScope = peek();
    if (jsonScope != paramJsonScope2 && jsonScope != paramJsonScope1)
      throw new IllegalStateException("Nesting problem: " + this.stack); 
    if (this.deferredName != null)
      throw new IllegalStateException("Dangling name: " + this.deferredName); 
    this.stack.remove(this.stack.size() - 1);
    if (jsonScope == paramJsonScope2)
      newline(); 
    this.out.write(paramString);
    return this;
  }
  
  private void newline() throws IOException {
    if (this.indent != null) {
      this.out.write("\n");
      byte b = 1;
      while (true) {
        if (b < this.stack.size()) {
          this.out.write(this.indent);
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private JsonWriter open(JsonScope paramJsonScope, String paramString) throws IOException {
    beforeValue(true);
    this.stack.add(paramJsonScope);
    this.out.write(paramString);
    return this;
  }
  
  private JsonScope peek() {
    int i = this.stack.size();
    if (i == 0)
      throw new IllegalStateException("JsonWriter is closed."); 
    return this.stack.get(i - 1);
  }
  
  private void replaceTop(JsonScope paramJsonScope) {
    this.stack.set(this.stack.size() - 1, paramJsonScope);
  }
  
  private void string(String paramString) throws IOException {
    String[] arrayOfString;
    Object object;
    if (this.htmlSafe) {
      arrayOfString = HTML_SAFE_REPLACEMENT_CHARS;
    } else {
      arrayOfString = REPLACEMENT_CHARS;
    } 
    this.out.write("\"");
    boolean bool = false;
    int i = paramString.length();
    byte b = 0;
    while (b < i) {
      String str;
      char c = paramString.charAt(b);
      if (c < '') {
        String str1 = arrayOfString[c];
        str = str1;
        if (str1 == null) {
          Object object1 = object;
          continue;
        } 
      } else if (c == ' ') {
        str = "\\u2028";
      } else {
        Object object1 = object;
        if (c == ' ') {
          str = "\\u2029";
        } else {
          continue;
        } 
      } 
      if (object < b)
        this.out.write(paramString, object, b - object); 
      this.out.write(str);
      int j = b + 1;
      continue;
      b++;
      object = SYNTHETIC_LOCAL_VARIABLE_9;
    } 
    if (object < i)
      this.out.write(paramString, object, i - object); 
    this.out.write("\"");
  }
  
  private void writeDeferredName() throws IOException {
    if (this.deferredName != null) {
      beforeName();
      string(this.deferredName);
      this.deferredName = null;
    } 
  }
  
  public JsonWriter beginArray() throws IOException {
    writeDeferredName();
    return open(JsonScope.EMPTY_ARRAY, "[");
  }
  
  public JsonWriter beginObject() throws IOException {
    writeDeferredName();
    return open(JsonScope.EMPTY_OBJECT, "{");
  }
  
  public void close() throws IOException {
    this.out.close();
    int i = this.stack.size();
    if (i > 1 || (i == 1 && this.stack.get(i - 1) != JsonScope.NONEMPTY_DOCUMENT))
      throw new IOException("Incomplete document"); 
    this.stack.clear();
  }
  
  public JsonWriter endArray() throws IOException {
    return close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
  }
  
  public JsonWriter endObject() throws IOException {
    return close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
  }
  
  public void flush() throws IOException {
    if (this.stack.isEmpty())
      throw new IllegalStateException("JsonWriter is closed."); 
    this.out.flush();
  }
  
  public final boolean getSerializeNulls() {
    return this.serializeNulls;
  }
  
  public final boolean isHtmlSafe() {
    return this.htmlSafe;
  }
  
  public boolean isLenient() {
    return this.lenient;
  }
  
  public JsonWriter name(String paramString) throws IOException {
    if (paramString == null)
      throw new NullPointerException("name == null"); 
    if (this.deferredName != null)
      throw new IllegalStateException(); 
    if (this.stack.isEmpty())
      throw new IllegalStateException("JsonWriter is closed."); 
    this.deferredName = paramString;
    return this;
  }
  
  public JsonWriter nullValue() throws IOException {
    if (this.deferredName != null)
      if (this.serializeNulls) {
        writeDeferredName();
      } else {
        this.deferredName = null;
        return this;
      }  
    beforeValue(false);
    this.out.write("null");
    return this;
  }
  
  public final void setHtmlSafe(boolean paramBoolean) {
    this.htmlSafe = paramBoolean;
  }
  
  public final void setIndent(String paramString) {
    if (paramString.length() == 0) {
      this.indent = null;
      this.separator = ":";
      return;
    } 
    this.indent = paramString;
    this.separator = ": ";
  }
  
  public final void setLenient(boolean paramBoolean) {
    this.lenient = paramBoolean;
  }
  
  public final void setSerializeNulls(boolean paramBoolean) {
    this.serializeNulls = paramBoolean;
  }
  
  public JsonWriter value(double paramDouble) throws IOException {
    if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble))
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramDouble); 
    writeDeferredName();
    beforeValue(false);
    this.out.append(Double.toString(paramDouble));
    return this;
  }
  
  public JsonWriter value(long paramLong) throws IOException {
    writeDeferredName();
    beforeValue(false);
    this.out.write(Long.toString(paramLong));
    return this;
  }
  
  public JsonWriter value(Number paramNumber) throws IOException {
    if (paramNumber == null)
      return nullValue(); 
    writeDeferredName();
    String str = paramNumber.toString();
    if (!this.lenient && (str.equals("-Infinity") || str.equals("Infinity") || str.equals("NaN")))
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber); 
    beforeValue(false);
    this.out.append(str);
    return this;
  }
  
  public JsonWriter value(String paramString) throws IOException {
    if (paramString == null)
      return nullValue(); 
    writeDeferredName();
    beforeValue(false);
    string(paramString);
    return this;
  }
  
  public JsonWriter value(boolean paramBoolean) throws IOException {
    writeDeferredName();
    beforeValue(false);
    Writer writer = this.out;
    if (paramBoolean) {
      String str1 = "true";
      writer.write(str1);
      return this;
    } 
    String str = "false";
    writer.write(str);
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\stream\JsonWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
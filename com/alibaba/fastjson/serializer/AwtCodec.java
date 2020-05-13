package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

public class AwtCodec implements ObjectDeserializer, ObjectSerializer {
  public static final AwtCodec instance = new AwtCodec();
  
  private Object parseRef(DefaultJSONParser paramDefaultJSONParser, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.getLexer();
    jSONLexer.nextTokenWithColon(4);
    String str = jSONLexer.stringVal();
    paramDefaultJSONParser.setContext(paramDefaultJSONParser.getContext(), paramObject);
    paramDefaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(paramDefaultJSONParser.getContext(), str));
    paramDefaultJSONParser.popContext();
    paramDefaultJSONParser.setResolveStatus(1);
    jSONLexer.nextToken(13);
    paramDefaultJSONParser.accept(13);
    return null;
  }
  
  public static boolean support(Class<?> paramClass) {
    return (paramClass == Point.class || paramClass == Rectangle.class || paramClass == Font.class || paramClass == Color.class);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
      StringBuilder stringBuilder;
      Point point;
      Font font;
      jSONLexer.nextToken();
      if (paramType == Point.class) {
        point = parsePoint(paramDefaultJSONParser, paramObject);
      } else {
        Rectangle rectangle;
        if (point == Rectangle.class) {
          rectangle = parseRectangle(paramDefaultJSONParser);
        } else {
          Color color;
          if (rectangle == Color.class) {
            color = parseColor(paramDefaultJSONParser);
          } else {
            if (color == Font.class) {
              font = parseFont(paramDefaultJSONParser);
              ParseContext parseContext1 = paramDefaultJSONParser.getContext();
              paramDefaultJSONParser.setContext(font, paramObject);
              paramDefaultJSONParser.setContext(parseContext1);
              return (T)font;
            } 
            stringBuilder = new StringBuilder();
            stringBuilder.append("not support awt class : ");
            stringBuilder.append(font);
            throw new JSONException(stringBuilder.toString());
          } 
        } 
      } 
      ParseContext parseContext = stringBuilder.getContext();
      stringBuilder.setContext(font, paramObject);
      stringBuilder.setContext(parseContext);
      return (T)font;
    } 
    throw new JSONException("syntax error");
  }
  
  public int getFastMatchToken() {
    return 12;
  }
  
  protected Color parseColor(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    int j = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Color(i, bool1, bool2, j);
      } 
      if (jSONLexer.token() == 4) {
        String str = jSONLexer.stringVal();
        jSONLexer.nextTokenWithColon(2);
        if (jSONLexer.token() == 2) {
          StringBuilder stringBuilder;
          boolean bool3;
          boolean bool4;
          int m;
          int k = jSONLexer.intValue();
          jSONLexer.nextToken();
          if (str.equalsIgnoreCase("r")) {
            bool3 = bool1;
            bool4 = bool2;
            m = j;
          } else if (str.equalsIgnoreCase("g")) {
            bool3 = k;
            k = i;
            bool4 = bool2;
            m = j;
          } else if (str.equalsIgnoreCase("b")) {
            bool4 = k;
            k = i;
            bool3 = bool1;
            m = j;
          } else if (str.equalsIgnoreCase("alpha")) {
            m = k;
            bool4 = bool2;
            bool3 = bool1;
            k = i;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("syntax error, ");
            stringBuilder.append(str);
            throw new JSONException(stringBuilder.toString());
          } 
          i = k;
          bool1 = bool3;
          bool2 = bool4;
          j = m;
          if (stringBuilder.token() == 16) {
            stringBuilder.nextToken(4);
            i = k;
            bool1 = bool3;
            bool2 = bool4;
            j = m;
          } 
          continue;
        } 
        throw new JSONException("syntax error");
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  protected Font parseFont(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    boolean bool = false;
    paramDefaultJSONParser = null;
    int i = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Font((String)paramDefaultJSONParser, bool, i);
      } 
      if (jSONLexer.token() == 4) {
        DefaultJSONParser defaultJSONParser;
        boolean bool1;
        int j;
        String str = jSONLexer.stringVal();
        jSONLexer.nextTokenWithColon(2);
        if (str.equalsIgnoreCase("name")) {
          if (jSONLexer.token() == 4) {
            str = jSONLexer.stringVal();
            jSONLexer.nextToken();
            bool1 = bool;
            j = i;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if (str.equalsIgnoreCase("style")) {
          if (jSONLexer.token() == 2) {
            bool1 = jSONLexer.intValue();
            jSONLexer.nextToken();
            defaultJSONParser = paramDefaultJSONParser;
            j = i;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if (defaultJSONParser.equalsIgnoreCase("size")) {
          if (jSONLexer.token() == 2) {
            j = jSONLexer.intValue();
            jSONLexer.nextToken();
            defaultJSONParser = paramDefaultJSONParser;
            bool1 = bool;
          } else {
            throw new JSONException("syntax error");
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("syntax error, ");
          stringBuilder.append((String)defaultJSONParser);
          throw new JSONException(stringBuilder.toString());
        } 
        bool = bool1;
        paramDefaultJSONParser = defaultJSONParser;
        i = j;
        if (jSONLexer.token() == 16) {
          jSONLexer.nextToken(4);
          bool = bool1;
          paramDefaultJSONParser = defaultJSONParser;
          i = j;
        } 
        continue;
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  protected Point parsePoint(DefaultJSONParser paramDefaultJSONParser, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = 0;
    int j = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Point(i, j);
      } 
      if (jSONLexer.token() == 4) {
        int m;
        String str = jSONLexer.stringVal();
        if (JSON.DEFAULT_TYPE_KEY.equals(str)) {
          paramDefaultJSONParser.acceptType("java.awt.Point");
          continue;
        } 
        if ("$ref".equals(str))
          return (Point)parseRef(paramDefaultJSONParser, paramObject); 
        jSONLexer.nextTokenWithColon(2);
        int k = jSONLexer.token();
        if (k == 2) {
          k = jSONLexer.intValue();
          jSONLexer.nextToken();
        } else if (k == 3) {
          k = (int)jSONLexer.floatValue();
          jSONLexer.nextToken();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("syntax error : ");
          stringBuilder.append(jSONLexer.tokenName());
          throw new JSONException(stringBuilder.toString());
        } 
        if (str.equalsIgnoreCase("x")) {
          m = j;
        } else if (str.equalsIgnoreCase("y")) {
          m = k;
          k = i;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("syntax error, ");
          stringBuilder.append(str);
          throw new JSONException(stringBuilder.toString());
        } 
        i = k;
        j = m;
        if (jSONLexer.token() == 16) {
          jSONLexer.nextToken(4);
          i = k;
          j = m;
        } 
        continue;
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  protected Rectangle parseRectangle(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    int j = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Rectangle(i, bool1, bool2, j);
      } 
      if (jSONLexer.token() == 4) {
        StringBuilder stringBuilder;
        boolean bool3;
        boolean bool4;
        int m;
        String str = jSONLexer.stringVal();
        jSONLexer.nextTokenWithColon(2);
        int k = jSONLexer.token();
        if (k == 2) {
          k = jSONLexer.intValue();
          jSONLexer.nextToken();
        } else if (k == 3) {
          k = (int)jSONLexer.floatValue();
          jSONLexer.nextToken();
        } else {
          throw new JSONException("syntax error");
        } 
        if (str.equalsIgnoreCase("x")) {
          bool3 = bool1;
          bool4 = bool2;
          m = j;
        } else if (str.equalsIgnoreCase("y")) {
          bool3 = k;
          k = i;
          bool4 = bool2;
          m = j;
        } else if (str.equalsIgnoreCase("width")) {
          bool4 = k;
          k = i;
          bool3 = bool1;
          m = j;
        } else if (str.equalsIgnoreCase("height")) {
          m = k;
          bool4 = bool2;
          bool3 = bool1;
          k = i;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("syntax error, ");
          stringBuilder.append(str);
          throw new JSONException(stringBuilder.toString());
        } 
        i = k;
        bool1 = bool3;
        bool2 = bool4;
        j = m;
        if (stringBuilder.token() == 16) {
          stringBuilder.nextToken(4);
          i = k;
          bool1 = bool3;
          bool2 = bool4;
          j = m;
        } 
        continue;
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    StringBuilder stringBuilder;
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    if (paramObject1 instanceof Point) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), "x", ((Point)paramObject1).x);
      serializeWriter.writeFieldValue(',', "y", ((Point)paramObject1).y);
    } else if (paramObject1 instanceof Font) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), "name", paramObject1.getName());
      serializeWriter.writeFieldValue(',', "style", paramObject1.getStyle());
      serializeWriter.writeFieldValue(',', "size", paramObject1.getSize());
    } else if (paramObject1 instanceof Rectangle) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), "x", ((Rectangle)paramObject1).x);
      serializeWriter.writeFieldValue(',', "y", ((Rectangle)paramObject1).y);
      serializeWriter.writeFieldValue(',', "width", ((Rectangle)paramObject1).width);
      serializeWriter.writeFieldValue(',', "height", ((Rectangle)paramObject1).height);
    } else if (paramObject1 instanceof Color) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), "r", paramObject1.getRed());
      serializeWriter.writeFieldValue(',', "g", paramObject1.getGreen());
      serializeWriter.writeFieldValue(',', "b", paramObject1.getBlue());
      if (paramObject1.getAlpha() > 0)
        serializeWriter.writeFieldValue(',', "alpha", paramObject1.getAlpha()); 
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("not support awt class : ");
      stringBuilder.append(paramObject1.getClass().getName());
      throw new JSONException(stringBuilder.toString());
    } 
    stringBuilder.write(125);
  }
  
  protected char writeClassName(SerializeWriter paramSerializeWriter, Class<?> paramClass, char paramChar) {
    char c = paramChar;
    if (paramSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
      paramSerializeWriter.write(123);
      paramSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
      paramSerializeWriter.writeString(paramClass.getName());
      paramChar = ',';
      c = paramChar;
    } 
    return c;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\AwtCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
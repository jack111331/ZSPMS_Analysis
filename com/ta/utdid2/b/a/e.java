package com.ta.utdid2.b.a;

import android.util.Xml;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class e {
  public static final Object a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString) {
    int i = paramXmlPullParser.getEventType();
    while (true) {
      if (i == 2)
        return b(paramXmlPullParser, paramArrayOfString); 
      if (i == 3)
        throw new XmlPullParserException("Unexpected end tag at: " + paramXmlPullParser.getName()); 
      if (i == 4)
        throw new XmlPullParserException("Unexpected text: " + paramXmlPullParser.getText()); 
      try {
        int j = paramXmlPullParser.next();
        i = j;
        if (j == 1)
          throw new XmlPullParserException("Unexpected end of document"); 
      } catch (Exception exception) {
        throw new XmlPullParserException("Unexpected call next(): " + paramXmlPullParser.getName());
      } 
    } 
  }
  
  public static final ArrayList a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString) {
    ArrayList<Object> arrayList = new ArrayList();
    int i = paramXmlPullParser.getEventType();
    while (true) {
      if (i == 2) {
        arrayList.add(b(paramXmlPullParser, paramArrayOfString));
      } else if (i == 3) {
        if (paramXmlPullParser.getName().equals(paramString))
          return arrayList; 
        throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
      } 
      int j = paramXmlPullParser.next();
      i = j;
      if (j == 1)
        throw new XmlPullParserException("Document ended before " + paramString + " end tag"); 
    } 
  }
  
  public static final HashMap a(InputStream paramInputStream) {
    XmlPullParser xmlPullParser = Xml.newPullParser();
    xmlPullParser.setInput(paramInputStream, null);
    return (HashMap)a(xmlPullParser, new String[1]);
  }
  
  public static final HashMap a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramXmlPullParser.getEventType();
    while (true) {
      if (i == 2) {
        Object object = b(paramXmlPullParser, paramArrayOfString);
        if (paramArrayOfString[0] != null) {
          hashMap.put(paramArrayOfString[0], object);
        } else {
          throw new XmlPullParserException("Map value without name attribute: " + paramXmlPullParser.getName());
        } 
      } else if (i == 3) {
        if (paramXmlPullParser.getName().equals(paramString))
          return hashMap; 
        throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
      } 
      int j = paramXmlPullParser.next();
      i = j;
      if (j == 1)
        throw new XmlPullParserException("Document ended before " + paramString + " end tag"); 
    } 
  }
  
  public static final void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer) {
    String str;
    if (paramObject == null) {
      paramXmlSerializer.startTag(null, "null");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString); 
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    if (paramObject instanceof String) {
      paramXmlSerializer.startTag(null, "string");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString); 
      paramXmlSerializer.text(paramObject.toString());
      paramXmlSerializer.endTag(null, "string");
      return;
    } 
    if (paramObject instanceof Integer) {
      str = "int";
    } else if (paramObject instanceof Long) {
      str = "long";
    } else if (paramObject instanceof Float) {
      str = "float";
    } else if (paramObject instanceof Double) {
      str = "double";
    } else if (paramObject instanceof Boolean) {
      str = "boolean";
    } else {
      if (paramObject instanceof byte[]) {
        a((byte[])paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof int[]) {
        a((int[])paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof Map) {
        a((Map)paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof List) {
        a((List)paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof CharSequence) {
        paramXmlSerializer.startTag(null, "string");
        if (paramString != null)
          paramXmlSerializer.attribute(null, "name", paramString); 
        paramXmlSerializer.text(paramObject.toString());
        paramXmlSerializer.endTag(null, "string");
        return;
      } 
      throw new RuntimeException("writeValueXml: unable to write value " + paramObject);
    } 
    paramXmlSerializer.startTag(null, str);
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    paramXmlSerializer.attribute(null, "value", paramObject.toString());
    paramXmlSerializer.endTag(null, str);
  }
  
  public static final void a(List paramList, String paramString, XmlSerializer paramXmlSerializer) {
    if (paramList == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    paramXmlSerializer.startTag(null, "list");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    int i = paramList.size();
    for (byte b = 0; b < i; b++)
      a(paramList.get(b), (String)null, paramXmlSerializer); 
    paramXmlSerializer.endTag(null, "list");
  }
  
  public static final void a(Map paramMap, OutputStream paramOutputStream) {
    a a = new a();
    a.setOutput(paramOutputStream, "utf-8");
    a.startDocument(null, Boolean.valueOf(true));
    a.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
    a(paramMap, (String)null, a);
    a.endDocument();
  }
  
  public static final void a(Map paramMap, String paramString, XmlSerializer paramXmlSerializer) {
    if (paramMap == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    paramXmlSerializer.startTag(null, "map");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      a(entry.getValue(), (String)entry.getKey(), paramXmlSerializer);
    } 
    paramXmlSerializer.endTag(null, "map");
  }
  
  public static final void a(byte[] paramArrayOfbyte, String paramString, XmlSerializer paramXmlSerializer) {
    if (paramArrayOfbyte == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    paramXmlSerializer.startTag(null, "byte-array");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    int i = paramArrayOfbyte.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(i));
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (byte b = 0; b < i; b++) {
      byte b1 = paramArrayOfbyte[b];
      int j = b1 >> 4;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      } 
      stringBuilder.append(j);
      j = b1 & 0xFF;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      } 
      stringBuilder.append(j);
    } 
    paramXmlSerializer.text(stringBuilder.toString());
    paramXmlSerializer.endTag(null, "byte-array");
  }
  
  public static final void a(int[] paramArrayOfint, String paramString, XmlSerializer paramXmlSerializer) {
    if (paramArrayOfint == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    paramXmlSerializer.startTag(null, "int-array");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    int i = paramArrayOfint.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(i));
    for (byte b = 0; b < i; b++) {
      paramXmlSerializer.startTag(null, "item");
      paramXmlSerializer.attribute(null, "value", Integer.toString(paramArrayOfint[b]));
      paramXmlSerializer.endTag(null, "item");
    } 
    paramXmlSerializer.endTag(null, "int-array");
  }
  
  public static final int[] a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString) {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: ldc 'num'
    //   4: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9: invokestatic parseInt : (Ljava/lang/String;)I
    //   12: istore_3
    //   13: iload_3
    //   14: newarray int
    //   16: astore_2
    //   17: aload_0
    //   18: invokeinterface getEventType : ()I
    //   23: istore_3
    //   24: iconst_0
    //   25: istore #4
    //   27: iload_3
    //   28: iconst_2
    //   29: if_icmpne -> 195
    //   32: aload_0
    //   33: invokeinterface getName : ()Ljava/lang/String;
    //   38: ldc_w 'item'
    //   41: invokevirtual equals : (Ljava/lang/Object;)Z
    //   44: ifeq -> 165
    //   47: aload_2
    //   48: iload #4
    //   50: aload_0
    //   51: aconst_null
    //   52: ldc 'value'
    //   54: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: invokestatic parseInt : (Ljava/lang/String;)I
    //   62: iastore
    //   63: iload #4
    //   65: istore #5
    //   67: aload_0
    //   68: invokeinterface next : ()I
    //   73: istore #6
    //   75: iload #5
    //   77: istore #4
    //   79: iload #6
    //   81: istore_3
    //   82: iload #6
    //   84: iconst_1
    //   85: if_icmpne -> 27
    //   88: new org/xmlpull/v1/XmlPullParserException
    //   91: dup
    //   92: new java/lang/StringBuilder
    //   95: dup
    //   96: ldc 'Document ended before '
    //   98: invokespecial <init> : (Ljava/lang/String;)V
    //   101: aload_1
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc ' end tag'
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: athrow
    //   117: astore_0
    //   118: new org/xmlpull/v1/XmlPullParserException
    //   121: dup
    //   122: ldc_w 'Need num attribute in byte-array'
    //   125: invokespecial <init> : (Ljava/lang/String;)V
    //   128: athrow
    //   129: astore_0
    //   130: new org/xmlpull/v1/XmlPullParserException
    //   133: dup
    //   134: ldc_w 'Not a number in num attribute in byte-array'
    //   137: invokespecial <init> : (Ljava/lang/String;)V
    //   140: athrow
    //   141: astore_0
    //   142: new org/xmlpull/v1/XmlPullParserException
    //   145: dup
    //   146: ldc_w 'Need value attribute in item'
    //   149: invokespecial <init> : (Ljava/lang/String;)V
    //   152: athrow
    //   153: astore_0
    //   154: new org/xmlpull/v1/XmlPullParserException
    //   157: dup
    //   158: ldc_w 'Not a number in value attribute in item'
    //   161: invokespecial <init> : (Ljava/lang/String;)V
    //   164: athrow
    //   165: new org/xmlpull/v1/XmlPullParserException
    //   168: dup
    //   169: new java/lang/StringBuilder
    //   172: dup
    //   173: ldc_w 'Expected item tag at: '
    //   176: invokespecial <init> : (Ljava/lang/String;)V
    //   179: aload_0
    //   180: invokeinterface getName : ()Ljava/lang/String;
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual toString : ()Ljava/lang/String;
    //   191: invokespecial <init> : (Ljava/lang/String;)V
    //   194: athrow
    //   195: iload #4
    //   197: istore #5
    //   199: iload_3
    //   200: iconst_3
    //   201: if_icmpne -> 67
    //   204: aload_0
    //   205: invokeinterface getName : ()Ljava/lang/String;
    //   210: aload_1
    //   211: invokevirtual equals : (Ljava/lang/Object;)Z
    //   214: ifeq -> 219
    //   217: aload_2
    //   218: areturn
    //   219: aload_0
    //   220: invokeinterface getName : ()Ljava/lang/String;
    //   225: ldc_w 'item'
    //   228: invokevirtual equals : (Ljava/lang/Object;)Z
    //   231: ifeq -> 243
    //   234: iload #4
    //   236: iconst_1
    //   237: iadd
    //   238: istore #5
    //   240: goto -> 67
    //   243: new org/xmlpull/v1/XmlPullParserException
    //   246: dup
    //   247: new java/lang/StringBuilder
    //   250: dup
    //   251: ldc 'Expected '
    //   253: invokespecial <init> : (Ljava/lang/String;)V
    //   256: aload_1
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc ' end tag at: '
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: invokeinterface getName : ()Ljava/lang/String;
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual toString : ()Ljava/lang/String;
    //   277: invokespecial <init> : (Ljava/lang/String;)V
    //   280: athrow
    // Exception table:
    //   from	to	target	type
    //   0	13	117	java/lang/NullPointerException
    //   0	13	129	java/lang/NumberFormatException
    //   47	63	141	java/lang/NullPointerException
    //   47	63	153	java/lang/NumberFormatException
  }
  
  private static Object b(XmlPullParser paramXmlPullParser, String[] paramArrayOfString) {
    ArrayList arrayList;
    String str1 = null;
    String str2 = paramXmlPullParser.getAttributeValue(null, "name");
    String str3 = paramXmlPullParser.getName();
    if (!str3.equals("null")) {
      if (str3.equals("string")) {
        str1 = "";
        while (true) {
          int i = paramXmlPullParser.next();
          if (i != 1) {
            if (i == 3) {
              if (paramXmlPullParser.getName().equals("string")) {
                paramArrayOfString[0] = str2;
                return str1;
              } 
              throw new XmlPullParserException("Unexpected end tag in <string>: " + paramXmlPullParser.getName());
            } 
            if (i == 4) {
              str1 = str1 + paramXmlPullParser.getText();
              continue;
            } 
            if (i == 2)
              throw new XmlPullParserException("Unexpected start tag in <string>: " + paramXmlPullParser.getName()); 
            continue;
          } 
          throw new XmlPullParserException("Unexpected end of document in <string>");
        } 
      } 
      if (str3.equals("int")) {
        Integer integer = Integer.valueOf(Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value")));
      } else if (str3.equals("long")) {
        Long long_ = Long.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else if (str3.equals("float")) {
        Float float_ = Float.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else if (str3.equals("double")) {
        Double double_ = Double.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else if (str3.equals("boolean")) {
        Boolean bool = Boolean.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else {
        if (str3.equals("int-array")) {
          paramXmlPullParser.next();
          int[] arrayOfInt = a(paramXmlPullParser, "int-array", paramArrayOfString);
          paramArrayOfString[0] = str2;
          return arrayOfInt;
        } 
        if (str3.equals("map")) {
          paramXmlPullParser.next();
          HashMap hashMap = a(paramXmlPullParser, "map", paramArrayOfString);
          paramArrayOfString[0] = str2;
          return hashMap;
        } 
        if (str3.equals("list")) {
          paramXmlPullParser.next();
          arrayList = a(paramXmlPullParser, "list", paramArrayOfString);
          paramArrayOfString[0] = str2;
          return arrayList;
        } 
        throw new XmlPullParserException("Unknown tag: " + str3);
      } 
    } 
    while (true) {
      int i = paramXmlPullParser.next();
      if (i != 1) {
        if (i == 3) {
          if (paramXmlPullParser.getName().equals(str3)) {
            paramArrayOfString[0] = str2;
            return arrayList;
          } 
          throw new XmlPullParserException("Unexpected end tag in <" + str3 + ">: " + paramXmlPullParser.getName());
        } 
        if (i == 4)
          throw new XmlPullParserException("Unexpected text in <" + str3 + ">: " + paramXmlPullParser.getName()); 
        if (i == 2)
          throw new XmlPullParserException("Unexpected start tag in <" + str3 + ">: " + paramXmlPullParser.getName()); 
        continue;
      } 
      throw new XmlPullParserException("Unexpected end of document in <" + str3 + ">");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
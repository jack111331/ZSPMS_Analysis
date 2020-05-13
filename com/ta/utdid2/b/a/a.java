package com.ta.utdid2.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

class a implements XmlSerializer {
  private static final String[] a = new String[] { 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, "&quot;", null, null, null, "&amp;", null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      "&lt;", null, "&gt;", null };
  
  private OutputStream a;
  
  private Writer a;
  
  private ByteBuffer a;
  
  private CharsetEncoder a;
  
  private final char[] a = new char[8192];
  
  private boolean b;
  
  private int mPos;
  
  a() {
    this.a = (char[])ByteBuffer.allocate(8192);
  }
  
  private void a() {
    int i = this.a.position();
    if (i > 0) {
      this.a.flip();
      this.a.write(this.a.array(), 0, i);
      this.a.clear();
    } 
  }
  
  private void a(String paramString) {
    int i = 0;
    int j = paramString.length();
    char c = (char)a.length;
    char[] arrayOfChar = a;
    byte b = 0;
    while (b < j) {
      char c1 = paramString.charAt(b);
      int k = i;
      if (c1 < c) {
        char c2 = arrayOfChar[c1];
        k = i;
        if (c2 != null) {
          if (i < b)
            a(paramString, i, b - i); 
          k = b + 1;
          append(c2);
        } 
      } 
      b++;
      i = k;
    } 
    if (i < b)
      a(paramString, i, b - i); 
  }
  
  private void a(String paramString, int paramInt1, int paramInt2) {
    if (paramInt2 > 8192) {
      int i = paramInt1 + paramInt2;
      while (paramInt1 < i) {
        int j = paramInt1 + 8192;
        if (j < i) {
          paramInt2 = 8192;
        } else {
          paramInt2 = i - paramInt1;
        } 
        a(paramString, paramInt1, paramInt2);
        paramInt1 = j;
      } 
    } else {
      int i = this.mPos;
      int j = i;
      if (i + paramInt2 > 8192) {
        flush();
        j = this.mPos;
      } 
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this.a, j);
      this.mPos = j + paramInt2;
    } 
  }
  
  private void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    char c = (char)a.length;
    char[] arrayOfChar = a;
    int i = paramInt1;
    int j = paramInt1;
    while (true) {
      int k = j;
      if (k < paramInt1 + paramInt2) {
        char c1 = paramArrayOfchar[k];
        j = i;
        if (c1 < c) {
          char c2 = arrayOfChar[c1];
          j = i;
          if (c2 != null) {
            if (i < k)
              append(paramArrayOfchar, i, k - i); 
            j = k + 1;
            append(c2);
          } 
        } 
        k++;
        i = j;
        j = k;
        continue;
      } 
      if (i < k)
        append(paramArrayOfchar, i, k - i); 
      return;
    } 
  }
  
  private void append(char paramChar) {
    int i = this.mPos;
    int j = i;
    if (i >= 8191) {
      flush();
      j = this.mPos;
    } 
    this.a[j] = (char)paramChar;
    this.mPos = j + 1;
  }
  
  private void append(String paramString) {
    a(paramString, 0, paramString.length());
  }
  
  private void append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt2 > 8192) {
      int i = paramInt1 + paramInt2;
      while (paramInt1 < i) {
        int j = paramInt1 + 8192;
        if (j < i) {
          paramInt2 = 8192;
        } else {
          paramInt2 = i - paramInt1;
        } 
        append(paramArrayOfchar, paramInt1, paramInt2);
        paramInt1 = j;
      } 
    } else {
      int i = this.mPos;
      int j = i;
      if (i + paramInt2 > 8192) {
        flush();
        j = this.mPos;
      } 
      System.arraycopy(paramArrayOfchar, paramInt1, this.a, j, paramInt2);
      this.mPos = j + paramInt2;
    } 
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3) {
    append(' ');
    if (paramString1 != null) {
      append(paramString1);
      append(':');
    } 
    append(paramString2);
    append("=\"");
    a(paramString3);
    append('"');
    return this;
  }
  
  public void cdsect(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void comment(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void docdecl(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void endDocument() {
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2) {
    if (this.b) {
      append(" />\n");
      this.b = false;
      return this;
    } 
    append("</");
    if (paramString1 != null) {
      append(paramString1);
      append(':');
    } 
    append(paramString2);
    append(">\n");
    this.b = false;
    return this;
  }
  
  public void entityRef(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void flush() {
    if (this.mPos > 0) {
      if (this.a != null) {
        CharBuffer charBuffer = CharBuffer.wrap(this.a, 0, this.mPos);
        CoderResult coderResult = this.a.encode(charBuffer, (ByteBuffer)this.a, true);
        while (true) {
          if (coderResult.isError())
            throw new IOException(coderResult.toString()); 
          if (coderResult.isOverflow()) {
            a();
            coderResult = this.a.encode(charBuffer, (ByteBuffer)this.a, true);
            continue;
          } 
          a();
          this.a.flush();
          this.mPos = 0;
          break;
        } 
        return;
      } 
    } else {
      return;
    } 
    this.a.write(this.a, 0, this.mPos);
    this.a.flush();
    this.mPos = 0;
    break;
  }
  
  public int getDepth() {
    throw new UnsupportedOperationException();
  }
  
  public boolean getFeature(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public String getName() {
    throw new UnsupportedOperationException();
  }
  
  public String getNamespace() {
    throw new UnsupportedOperationException();
  }
  
  public String getPrefix(String paramString, boolean paramBoolean) {
    throw new UnsupportedOperationException();
  }
  
  public Object getProperty(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void ignorableWhitespace(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void processingInstruction(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void setFeature(String paramString, boolean paramBoolean) {
    if (paramString.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))
      return; 
    throw new UnsupportedOperationException();
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString) {
    if (paramOutputStream == null)
      throw new IllegalArgumentException(); 
    try {
      this.a = (char[])Charset.forName(paramString).newEncoder();
      this.a = (char[])paramOutputStream;
      return;
    } catch (IllegalCharsetNameException illegalCharsetNameException) {
      throw (UnsupportedEncodingException)(new UnsupportedEncodingException(paramString)).initCause(illegalCharsetNameException);
    } catch (UnsupportedCharsetException unsupportedCharsetException) {
      throw (UnsupportedEncodingException)(new UnsupportedEncodingException(paramString)).initCause(unsupportedCharsetException);
    } 
  }
  
  public void setOutput(Writer paramWriter) {
    this.a = (char[])paramWriter;
  }
  
  public void setPrefix(String paramString1, String paramString2) {
    throw new UnsupportedOperationException();
  }
  
  public void setProperty(String paramString, Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public void startDocument(String paramString, Boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
    if (paramBoolean.booleanValue()) {
      paramString = "yes";
    } else {
      paramString = "no";
    } 
    append(stringBuilder.append(paramString).append("' ?>\n").toString());
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2) {
    if (this.b)
      append(">\n"); 
    append('<');
    if (paramString1 != null) {
      append(paramString1);
      append(':');
    } 
    append(paramString2);
    this.b = true;
    return this;
  }
  
  public XmlSerializer text(String paramString) {
    if (this.b) {
      append(">");
      this.b = false;
    } 
    a(paramString);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (this.b) {
      append(">");
      this.b = false;
    } 
    a(paramArrayOfchar, paramInt1, paramInt2);
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
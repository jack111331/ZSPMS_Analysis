package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

public final class JSONReaderScanner extends JSONLexerBase {
  private static final ThreadLocal<char[]> BUF_LOCAL = (ThreadLocal)new ThreadLocal<char>();
  
  private char[] buf;
  
  private int bufLength;
  
  private Reader reader;
  
  public JSONReaderScanner(Reader paramReader) {
    this(paramReader, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(Reader paramReader, int paramInt) {
    super(paramInt);
    this.reader = paramReader;
    this.buf = BUF_LOCAL.get();
    if (this.buf != null)
      BUF_LOCAL.set(null); 
    if (this.buf == null)
      this.buf = new char[16384]; 
    try {
      this.bufLength = paramReader.read(this.buf);
      this.bp = -1;
      next();
      if (this.ch == '﻿')
        next(); 
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } 
  }
  
  public JSONReaderScanner(String paramString) {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(String paramString, int paramInt) {
    this(new StringReader(paramString), paramInt);
  }
  
  public JSONReaderScanner(char[] paramArrayOfchar, int paramInt) {
    this(paramArrayOfchar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    this(new CharArrayReader(paramArrayOfchar, 0, paramInt1), paramInt2);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable) {
    return paramSymbolTable.addSymbol(this.buf, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    System.arraycopy(this.buf, paramInt1, paramArrayOfchar, paramInt2, paramInt3);
  }
  
  public byte[] bytesValue() {
    if (this.token != 26)
      return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp); 
    throw new JSONException("TODO");
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfchar) {
    for (byte b = 0; b < paramArrayOfchar.length; b++) {
      if (charAt(this.bp + b) != paramArrayOfchar[b])
        return false; 
    } 
    return true;
  }
  
  public final char charAt(int paramInt) {
    int i = paramInt;
    if (paramInt >= this.bufLength) {
      if (this.bufLength == -1)
        return (paramInt < this.sp) ? this.buf[paramInt] : '\032'; 
      if (this.bp == 0) {
        char[] arrayOfChar = new char[this.buf.length * 3 / 2];
        System.arraycopy(this.buf, this.bp, arrayOfChar, 0, this.bufLength);
        i = arrayOfChar.length;
        int j = this.bufLength;
        try {
          i = this.reader.read(arrayOfChar, this.bufLength, i - j);
          this.bufLength += i;
          this.buf = arrayOfChar;
          i = paramInt;
        } catch (IOException iOException) {
          throw new JSONException(iOException.getMessage(), iOException);
        } 
      } else {
        i = this.bufLength - this.bp;
        if (i > 0)
          System.arraycopy(this.buf, this.bp, this.buf, 0, i); 
        try {
          this.bufLength = this.reader.read(this.buf, i, this.buf.length - i);
          if (this.bufLength != 0) {
            if (this.bufLength == -1)
              return '\032'; 
            this.bufLength += i;
            i = paramInt - this.bp;
            this.np -= this.bp;
            this.bp = 0;
          } else {
            throw new JSONException("illegal state, textLength is zero");
          } 
        } catch (IOException iOException) {
          throw new JSONException(iOException.getMessage(), iOException);
        } 
      } 
    } 
    return this.buf[i];
  }
  
  public void close() {
    super.close();
    if (this.buf.length <= 65536)
      BUF_LOCAL.set(this.buf); 
    this.buf = null;
    IOUtils.close(this.reader);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    System.arraycopy(this.buf, paramInt1, paramArrayOfchar, 0, paramInt2);
  }
  
  public final BigDecimal decimalValue() {
    int i = this.np;
    int j = i;
    if (i == -1)
      j = 0; 
    char c = charAt(this.sp + j - 1);
    int k = this.sp;
    if (c != 'L' && c != 'S' && c != 'B' && c != 'F') {
      i = k;
      if (c == 'D') {
        i = k - 1;
        return new BigDecimal(this.buf, j, i);
      } 
      return new BigDecimal(this.buf, j, i);
    } 
    i = k - 1;
    return new BigDecimal(this.buf, j, i);
  }
  
  public final int indexOf(char paramChar, int paramInt) {
    for (paramInt -= this.bp;; paramInt++) {
      char c = charAt(this.bp + paramInt);
      if (paramChar == c)
        return paramInt + this.bp; 
      if (c == '\032')
        return -1; 
    } 
  }
  
  public final boolean isBlankInput() {
    for (byte b = 0;; b++) {
      char c = this.buf[b];
      if (c == '\032') {
        this.token = 20;
        return true;
      } 
      if (!isWhitespace(c))
        return false; 
    } 
  }
  
  public boolean isEOF() {
    int i = this.bufLength;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i != -1) {
      bool2 = bool1;
      if (this.bp != this.buf.length)
        if (this.ch == '\032' && this.bp + 1 == this.buf.length) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }  
    } 
    return bool2;
  }
  
  public final char next() {
    int i = this.bp + 1;
    this.bp = i;
    int j = i;
    if (i >= this.bufLength) {
      if (this.bufLength == -1)
        return '\032'; 
      if (this.sp > 0) {
        i = this.bufLength - this.sp;
        j = i;
        if (this.ch == '"') {
          j = i;
          if (i > 0)
            j = i - 1; 
        } 
        System.arraycopy(this.buf, j, this.buf, 0, this.sp);
      } 
      this.np = -1;
      i = this.sp;
      this.bp = i;
      try {
        int k = this.bp;
        int m = this.buf.length - k;
        j = m;
        if (m == 0) {
          char[] arrayOfChar = new char[this.buf.length * 2];
          System.arraycopy(this.buf, 0, arrayOfChar, 0, this.buf.length);
          this.buf = arrayOfChar;
          j = this.buf.length - k;
        } 
        this.bufLength = this.reader.read(this.buf, this.bp, j);
        if (this.bufLength != 0) {
          if (this.bufLength == -1) {
            this.ch = (char)'\032';
            return '\032';
          } 
          this.bufLength += this.bp;
          j = i;
        } else {
          throw new JSONException("illegal stat, textLength is zero");
        } 
      } catch (IOException iOException) {
        throw new JSONException(iOException.getMessage(), iOException);
      } 
    } 
    char c = this.buf[j];
    this.ch = c;
    return c;
  }
  
  public final String numberString() {
    int i = this.np;
    int j = i;
    if (i == -1)
      j = 0; 
    char c = charAt(this.sp + j - 1);
    int k = this.sp;
    if (c != 'L' && c != 'S' && c != 'B' && c != 'F') {
      i = k;
      if (c == 'D') {
        i = k - 1;
        return new String(this.buf, j, i);
      } 
      return new String(this.buf, j, i);
    } 
    i = k - 1;
    return new String(this.buf, j, i);
  }
  
  public final String stringVal() {
    if (!this.hasSpecial) {
      int i = this.np + 1;
      if (i >= 0) {
        if (i <= this.buf.length - this.sp)
          return new String(this.buf, i, this.sp); 
        throw new IllegalStateException();
      } 
      throw new IllegalStateException();
    } 
    return new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0)
      return new String(this.buf, paramInt1, paramInt2); 
    throw new StringIndexOutOfBoundsException(paramInt2);
  }
  
  public final char[] sub_chars(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0) {
      if (paramInt1 == 0)
        return this.buf; 
      char[] arrayOfChar = new char[paramInt2];
      System.arraycopy(this.buf, paramInt1, arrayOfChar, 0, paramInt2);
      return arrayOfChar;
    } 
    throw new StringIndexOutOfBoundsException(paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\JSONReaderScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.TimeZone;

public final class JSONScanner extends JSONLexerBase {
  private final int len;
  
  private final String text;
  
  public JSONScanner(String paramString) {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(String paramString, int paramInt) {
    super(paramInt);
    this.text = paramString;
    this.len = this.text.length();
    this.bp = -1;
    next();
    if (this.ch == '﻿')
      next(); 
  }
  
  public JSONScanner(char[] paramArrayOfchar, int paramInt) {
    this(paramArrayOfchar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    this(new String(paramArrayOfchar, 0, paramInt1), paramInt2);
  }
  
  static boolean charArrayCompare(String paramString, int paramInt, char[] paramArrayOfchar) {
    int i = paramArrayOfchar.length;
    if (i + paramInt > paramString.length())
      return false; 
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfchar[b] != paramString.charAt(paramInt + b))
        return false; 
    } 
    return true;
  }
  
  static boolean checkDate(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, int paramInt1, int paramInt2) {
    if (paramChar1 != '1' && paramChar1 != '2')
      return false; 
    if (paramChar2 < '0' || paramChar2 > '9')
      return false; 
    if (paramChar3 < '0' || paramChar3 > '9')
      return false; 
    if (paramChar4 < '0' || paramChar4 > '9')
      return false; 
    if (paramChar5 == '0') {
      if (paramChar6 < '1' || paramChar6 > '9')
        return false; 
    } else if (paramChar5 == '1') {
      if (paramChar6 != '0' && paramChar6 != '1' && paramChar6 != '2')
        return false; 
    } else {
      return false;
    } 
    if (paramInt1 == 48) {
      if (paramInt2 < 49 || paramInt2 > 57)
        return false; 
    } else {
      if (paramInt1 == 49 || paramInt1 == 50)
        return !(paramInt2 < 48 || paramInt2 > 57); 
      if (paramInt1 == 51) {
        if (paramInt2 != 48 && paramInt2 != 49)
          return false; 
      } else {
        return false;
      } 
    } 
    return true;
  }
  
  private boolean checkTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6) {
    if (paramChar1 == '0') {
      if (paramChar2 < '0' || paramChar2 > '9')
        return false; 
    } else if (paramChar1 == '1') {
      if (paramChar2 < '0' || paramChar2 > '9')
        return false; 
    } else if (paramChar1 == '2') {
      if (paramChar2 < '0' || paramChar2 > '4')
        return false; 
    } else {
      return false;
    } 
    if (paramChar3 >= '0' && paramChar3 <= '5') {
      if (paramChar4 < '0' || paramChar4 > '9')
        return false; 
    } else if (paramChar3 == '6') {
      if (paramChar4 != '0')
        return false; 
    } else {
      return false;
    } 
    if (paramChar5 >= '0' && paramChar5 <= '5') {
      if (paramChar6 < '0' || paramChar6 > '9')
        return false; 
    } else {
      return (paramChar5 == '6') ? (!(paramChar6 != '0')) : false;
    } 
    return true;
  }
  
  private void setCalendar(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, char paramChar7, char paramChar8) {
    this.calendar = Calendar.getInstance(this.timeZone, this.locale);
    this.calendar.set(1, (paramChar1 - 48) * 1000 + (paramChar2 - 48) * 100 + (paramChar3 - 48) * 10 + paramChar4 - 48);
    this.calendar.set(2, (paramChar5 - 48) * 10 + paramChar6 - 48 - 1);
    this.calendar.set(5, (paramChar7 - 48) * 10 + paramChar8 - 48);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable) {
    return paramSymbolTable.addSymbol(this.text, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    this.text.getChars(paramInt1, paramInt3 + paramInt1, paramArrayOfchar, paramInt2);
  }
  
  public byte[] bytesValue() {
    if (this.token == 26) {
      int i = this.np;
      int j = this.sp;
      if (j % 2 == 0) {
        byte[] arrayOfByte = new byte[j / 2];
        for (j = 0; j < arrayOfByte.length; j++) {
          String str = this.text;
          int k = j * 2 + i + 1;
          char c1 = str.charAt(k);
          char c2 = this.text.charAt(k + 1);
          byte b = 55;
          if (c1 <= '9') {
            k = 48;
          } else {
            k = 55;
          } 
          if (c2 <= '9')
            b = 48; 
          arrayOfByte[j] = (byte)(byte)(c1 - k << 4 | c2 - b);
        } 
        return arrayOfByte;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("illegal state. ");
      stringBuilder.append(j);
      throw new JSONException(stringBuilder.toString());
    } 
    return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfchar) {
    return charArrayCompare(this.text, this.bp, paramArrayOfchar);
  }
  
  public final char charAt(int paramInt) {
    return (paramInt >= this.len) ? '\032' : this.text.charAt(paramInt);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    this.text.getChars(paramInt1, paramInt2 + paramInt1, paramArrayOfchar, 0);
  }
  
  public final BigDecimal decimalValue() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield np : I
    //   5: aload_0
    //   6: getfield sp : I
    //   9: iadd
    //   10: iconst_1
    //   11: isub
    //   12: invokevirtual charAt : (I)C
    //   15: istore_1
    //   16: aload_0
    //   17: getfield sp : I
    //   20: istore_2
    //   21: iload_1
    //   22: bipush #76
    //   24: if_icmpeq -> 53
    //   27: iload_1
    //   28: bipush #83
    //   30: if_icmpeq -> 53
    //   33: iload_1
    //   34: bipush #66
    //   36: if_icmpeq -> 53
    //   39: iload_1
    //   40: bipush #70
    //   42: if_icmpeq -> 53
    //   45: iload_2
    //   46: istore_3
    //   47: iload_1
    //   48: bipush #68
    //   50: if_icmpne -> 57
    //   53: iload_2
    //   54: iconst_1
    //   55: isub
    //   56: istore_3
    //   57: aload_0
    //   58: getfield np : I
    //   61: istore_2
    //   62: iload_3
    //   63: aload_0
    //   64: getfield sbuf : [C
    //   67: arraylength
    //   68: if_icmpge -> 101
    //   71: aload_0
    //   72: getfield text : Ljava/lang/String;
    //   75: iload_2
    //   76: iload_2
    //   77: iload_3
    //   78: iadd
    //   79: aload_0
    //   80: getfield sbuf : [C
    //   83: iconst_0
    //   84: invokevirtual getChars : (II[CI)V
    //   87: new java/math/BigDecimal
    //   90: dup
    //   91: aload_0
    //   92: getfield sbuf : [C
    //   95: iconst_0
    //   96: iload_3
    //   97: invokespecial <init> : ([CII)V
    //   100: areturn
    //   101: iload_3
    //   102: newarray char
    //   104: astore #4
    //   106: aload_0
    //   107: getfield text : Ljava/lang/String;
    //   110: iload_2
    //   111: iload_3
    //   112: iload_2
    //   113: iadd
    //   114: aload #4
    //   116: iconst_0
    //   117: invokevirtual getChars : (II[CI)V
    //   120: new java/math/BigDecimal
    //   123: dup
    //   124: aload #4
    //   126: invokespecial <init> : ([C)V
    //   129: areturn
  }
  
  public final int indexOf(char paramChar, int paramInt) {
    return this.text.indexOf(paramChar, paramInt);
  }
  
  public String info() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pos ");
    stringBuilder.append(this.bp);
    stringBuilder.append(", json : ");
    if (this.text.length() < 65536) {
      str = this.text;
    } else {
      str = this.text.substring(0, 65536);
    } 
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public boolean isEOF() {
    int i = this.bp;
    int j = this.len;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i != j)
      if (this.ch == '\032' && this.bp + 1 == this.len) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    return bool2;
  }
  
  public Collection<String> newCollectionByType(Class<?> paramClass) {
    if (paramClass.isAssignableFrom(HashSet.class))
      return new HashSet<String>(); 
    if (paramClass.isAssignableFrom(ArrayList.class))
      return new ArrayList<String>(); 
    try {
      return (Collection)paramClass.newInstance();
    } catch (Exception exception) {
      throw new JSONException(exception.getMessage(), exception);
    } 
  }
  
  public final char next() {
    int j;
    int i = this.bp + 1;
    this.bp = i;
    if (i >= this.len) {
      i = 26;
      j = i;
    } else {
      i = this.text.charAt(i);
      j = i;
    } 
    this.ch = j;
    return j;
  }
  
  public final String numberString() {
    char c = charAt(this.np + this.sp - 1);
    int i = this.sp;
    if (c != 'L' && c != 'S' && c != 'B' && c != 'F') {
      int k = i;
      if (c == 'D') {
        k = i - 1;
        return subString(this.np, k);
      } 
      return subString(this.np, k);
    } 
    int j = i - 1;
    return subString(this.np, j);
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfchar) {
    boolean bool;
    int k;
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return false;
    } 
    int i = this.bp + paramArrayOfchar.length;
    int j = i + 1;
    i = charAt(i);
    if (i == 116) {
      i = j + 1;
      if (charAt(j) != 'r') {
        this.matchStat = -1;
        return false;
      } 
      j = i + 1;
      if (charAt(i) != 'u') {
        this.matchStat = -1;
        return false;
      } 
      if (charAt(j) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      this.bp = j + 1;
      j = charAt(this.bp);
      bool = true;
      k = j;
    } else if (i == 102) {
      i = j + 1;
      if (charAt(j) != 'a') {
        this.matchStat = -1;
        return false;
      } 
      j = i + 1;
      if (charAt(i) != 'l') {
        this.matchStat = -1;
        return false;
      } 
      i = j + 1;
      if (charAt(j) != 's') {
        this.matchStat = -1;
        return false;
      } 
      if (charAt(i) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      this.bp = i + 1;
      j = charAt(this.bp);
      bool = false;
      k = j;
    } else {
      this.matchStat = -1;
      return false;
    } 
    while (true) {
      if (k == 44) {
        j = this.bp + 1;
        this.bp = j;
        this.ch = charAt(j);
        this.matchStat = 3;
        this.token = 16;
        continue;
      } 
      if (k == 125) {
        j = this.bp + 1;
        this.bp = j;
        j = charAt(j);
        k = j;
        while (true) {
          if (k == 44) {
            this.token = 16;
            j = this.bp + 1;
            this.bp = j;
            this.ch = charAt(j);
          } else if (k == 93) {
            this.token = 15;
            j = this.bp + 1;
            this.bp = j;
            this.ch = charAt(j);
          } else if (k == 125) {
            this.token = 13;
            j = this.bp + 1;
            this.bp = j;
            this.ch = charAt(j);
          } else if (k == 26) {
            this.token = 20;
          } else {
            if (isWhitespace(k)) {
              j = this.bp + 1;
              this.bp = j;
              j = charAt(j);
              k = j;
              continue;
            } 
            this.matchStat = -1;
            return false;
          } 
          this.matchStat = 4;
          return bool;
        } 
        break;
      } 
      if (isWhitespace(k)) {
        j = this.bp + 1;
        this.bp = j;
        j = charAt(j);
        k = j;
        continue;
      } 
      this.matchStat = -1;
      return false;
    } 
  }
  
  public int scanFieldInt(char[] paramArrayOfchar) {
    boolean bool;
    this.matchStat = 0;
    int i = this.bp;
    char c = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return 0;
    } 
    int j = this.bp + paramArrayOfchar.length;
    int k = j + 1;
    j = charAt(j);
    if (j == 45) {
      int m = k + 1;
      j = charAt(k);
      bool = true;
      k = m;
    } else {
      bool = false;
    } 
    if (j >= 48 && j <= 57) {
      j -= 48;
      int m = k;
      while (true) {
        k = m + 1;
        m = charAt(m);
        if (m >= 48 && m <= 57) {
          j = j * 10 + m - 48;
          m = k;
          continue;
        } 
        break;
      } 
      if (m == 46) {
        this.matchStat = -1;
        return 0;
      } 
      int n = m;
      if (j < 0) {
        this.matchStat = -1;
        return 0;
      } 
      while (n != 44 && n != 125) {
        if (isWhitespace(n)) {
          m = charAt(k);
          k++;
          n = m;
          continue;
        } 
        this.matchStat = -1;
        return 0;
      } 
      this.bp = --k;
      if (n == 44) {
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
        this.matchStat = 3;
        this.token = 16;
        k = j;
        if (bool)
          k = -j; 
        return k;
      } 
      if (n == 125) {
        this.bp = k;
        k = this.bp + 1;
        this.bp = k;
        k = charAt(k);
        n = k;
        while (true) {
          if (n == 44) {
            this.token = 16;
            k = this.bp + 1;
            this.bp = k;
            this.ch = charAt(k);
          } else if (n == 93) {
            this.token = 15;
            k = this.bp + 1;
            this.bp = k;
            this.ch = charAt(k);
          } else if (n == 125) {
            this.token = 13;
            k = this.bp + 1;
            this.bp = k;
            this.ch = charAt(k);
          } else if (n == 26) {
            this.token = 20;
          } else {
            if (isWhitespace(n)) {
              k = this.bp + 1;
              this.bp = k;
              k = charAt(k);
              n = k;
              continue;
            } 
            this.bp = i;
            this.ch = (char)c;
            this.matchStat = -1;
            return 0;
          } 
          this.matchStat = 4;
          break;
        } 
      } 
      k = j;
      if (bool)
        k = -j; 
      return k;
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public long scanFieldLong(char[] paramArrayOfchar) {
    boolean bool = false;
    this.matchStat = 0;
    int i = this.bp;
    char c1 = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return 0L;
    } 
    int j = this.bp + paramArrayOfchar.length;
    int k = j + 1;
    char c2 = charAt(j);
    j = k;
    int m = c2;
    if (c2 == '-') {
      m = charAt(k);
      j = k + 1;
      bool = true;
    } 
    if (m >= 48 && m <= 57) {
      long l = (m - 48);
      m = j;
      while (true) {
        j = m + 1;
        m = charAt(m);
        if (m >= 48 && m <= 57) {
          l = l * 10L + (m - 48);
          m = j;
          continue;
        } 
        break;
      } 
      if (m == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      if (m == 44 || m == 125)
        this.bp = j - 1; 
      int n = m;
      if (l < 0L) {
        this.bp = i;
        this.ch = (char)c1;
        this.matchStat = -1;
        return 0L;
      } 
      while (true) {
        if (n == 44) {
          j = this.bp + 1;
          this.bp = j;
          this.ch = charAt(j);
          this.matchStat = 3;
          this.token = 16;
          long l1 = l;
          if (bool)
            l1 = -l; 
          return l1;
        } 
        if (n == 125) {
          j = this.bp + 1;
          this.bp = j;
          j = charAt(j);
          n = j;
          while (true) {
            if (n == 44) {
              this.token = 16;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            } else if (n == 93) {
              this.token = 15;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            } else if (n == 125) {
              this.token = 13;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            } else if (n == 26) {
              this.token = 20;
            } else {
              if (isWhitespace(n)) {
                j = this.bp + 1;
                this.bp = j;
                j = charAt(j);
                n = j;
                continue;
              } 
              this.bp = i;
              this.ch = (char)c1;
              this.matchStat = -1;
              return 0L;
            } 
            this.matchStat = 4;
            long l1 = l;
            if (bool)
              l1 = -l; 
            return l1;
          } 
          break;
        } 
        if (isWhitespace(n)) {
          this.bp = j;
          m = charAt(j);
          j++;
          n = m;
          continue;
        } 
        this.matchStat = -1;
        return 0L;
      } 
    } 
    this.bp = i;
    this.ch = (char)c1;
    this.matchStat = -1;
    return 0L;
  }
  
  public String scanFieldString(char[] paramArrayOfchar) {
    this.matchStat = 0;
    int i = this.bp;
    char c = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return stringDefaultValue();
    } 
    int j = this.bp + paramArrayOfchar.length;
    int k = j + 1;
    if (charAt(j) != '"') {
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    j = indexOf('"', k);
    if (j != -1) {
      String str1 = subString(k, j - k);
      k = j;
      String str2 = str1;
      if (str1.indexOf('\\') != -1)
        for (k = j;; k = indexOf('"', k + 1)) {
          j = k - 1;
          byte b = 0;
          while (j >= 0 && charAt(j) == '\\') {
            b++;
            j--;
          } 
          if (b % 2 == 0) {
            j = k - this.bp + paramArrayOfchar.length + 1;
            str2 = readString(sub_chars(this.bp + paramArrayOfchar.length + 1, j), j);
            break;
          } 
        }  
      j = charAt(k + 1);
      int m = j;
      while (m != 44 && m != 125) {
        if (isWhitespace(m)) {
          j = charAt(++k + 1);
          m = j;
          continue;
        } 
        this.matchStat = -1;
        return stringDefaultValue();
      } 
      this.bp = k + 1;
      this.ch = m;
      if (m == 44) {
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
        this.matchStat = 3;
        return str2;
      } 
      k = this.bp + 1;
      this.bp = k;
      k = charAt(k);
      if (k == 44) {
        this.token = 16;
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
      } else if (k == 93) {
        this.token = 15;
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
      } else if (k == 125) {
        this.token = 13;
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
      } else {
        if (k == 26) {
          this.token = 20;
          this.matchStat = 4;
          return str2;
        } 
        this.bp = i;
        this.ch = (char)c;
        this.matchStat = -1;
        return stringDefaultValue();
      } 
      this.matchStat = 4;
      return str2;
    } 
    throw new JSONException("unclosed str");
  }
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfchar, Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: getfield text : Ljava/lang/String;
    //   9: aload_0
    //   10: getfield bp : I
    //   13: aload_1
    //   14: invokestatic charArrayCompare : (Ljava/lang/String;I[C)Z
    //   17: ifne -> 28
    //   20: aload_0
    //   21: bipush #-2
    //   23: putfield matchStat : I
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: aload_2
    //   30: invokevirtual newCollectionByType : (Ljava/lang/Class;)Ljava/util/Collection;
    //   33: astore_2
    //   34: aload_0
    //   35: getfield bp : I
    //   38: aload_1
    //   39: arraylength
    //   40: iadd
    //   41: istore_3
    //   42: iload_3
    //   43: iconst_1
    //   44: iadd
    //   45: istore #4
    //   47: aload_0
    //   48: iload_3
    //   49: invokevirtual charAt : (I)C
    //   52: bipush #91
    //   54: if_icmpne -> 413
    //   57: iload #4
    //   59: iconst_1
    //   60: iadd
    //   61: istore_3
    //   62: aload_0
    //   63: iload #4
    //   65: invokevirtual charAt : (I)C
    //   68: istore #4
    //   70: iload #4
    //   72: bipush #34
    //   74: if_icmpne -> 240
    //   77: aload_0
    //   78: bipush #34
    //   80: iload_3
    //   81: invokevirtual indexOf : (CI)I
    //   84: istore #5
    //   86: iload #5
    //   88: iconst_m1
    //   89: if_icmpeq -> 230
    //   92: aload_0
    //   93: iload_3
    //   94: iload #5
    //   96: iload_3
    //   97: isub
    //   98: invokevirtual subString : (II)Ljava/lang/String;
    //   101: astore #6
    //   103: iload #5
    //   105: istore #4
    //   107: aload #6
    //   109: astore_1
    //   110: aload #6
    //   112: bipush #92
    //   114: invokevirtual indexOf : (I)I
    //   117: iconst_m1
    //   118: if_icmpeq -> 203
    //   121: iload #5
    //   123: istore #4
    //   125: iload #4
    //   127: iconst_1
    //   128: isub
    //   129: istore #5
    //   131: iconst_0
    //   132: istore #7
    //   134: iload #5
    //   136: iflt -> 159
    //   139: aload_0
    //   140: iload #5
    //   142: invokevirtual charAt : (I)C
    //   145: bipush #92
    //   147: if_icmpne -> 159
    //   150: iinc #7, 1
    //   153: iinc #5, -1
    //   156: goto -> 134
    //   159: iload #7
    //   161: iconst_2
    //   162: irem
    //   163: ifne -> 188
    //   166: iload #4
    //   168: iload_3
    //   169: isub
    //   170: istore #5
    //   172: aload_0
    //   173: iload_3
    //   174: iload #5
    //   176: invokevirtual sub_chars : (II)[C
    //   179: iload #5
    //   181: invokestatic readString : ([CI)Ljava/lang/String;
    //   184: astore_1
    //   185: goto -> 203
    //   188: aload_0
    //   189: bipush #34
    //   191: iload #4
    //   193: iconst_1
    //   194: iadd
    //   195: invokevirtual indexOf : (CI)I
    //   198: istore #4
    //   200: goto -> 125
    //   203: iload #4
    //   205: iconst_1
    //   206: iadd
    //   207: istore_3
    //   208: iload_3
    //   209: iconst_1
    //   210: iadd
    //   211: istore #4
    //   213: aload_0
    //   214: iload_3
    //   215: invokevirtual charAt : (I)C
    //   218: istore_3
    //   219: aload_2
    //   220: aload_1
    //   221: invokeinterface add : (Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -> 283
    //   230: new com/alibaba/fastjson/JSONException
    //   233: dup
    //   234: ldc 'unclosed str'
    //   236: invokespecial <init> : (Ljava/lang/String;)V
    //   239: athrow
    //   240: iload #4
    //   242: bipush #110
    //   244: if_icmpne -> 373
    //   247: aload_0
    //   248: getfield text : Ljava/lang/String;
    //   251: ldc 'ull'
    //   253: iload_3
    //   254: invokevirtual startsWith : (Ljava/lang/String;I)Z
    //   257: ifeq -> 373
    //   260: iload_3
    //   261: iconst_3
    //   262: iadd
    //   263: istore #4
    //   265: aload_0
    //   266: iload #4
    //   268: invokevirtual charAt : (I)C
    //   271: istore_3
    //   272: aload_2
    //   273: aconst_null
    //   274: invokeinterface add : (Ljava/lang/Object;)Z
    //   279: pop
    //   280: iinc #4, 1
    //   283: iload_3
    //   284: bipush #44
    //   286: if_icmpne -> 309
    //   289: aload_0
    //   290: iload #4
    //   292: invokevirtual charAt : (I)C
    //   295: istore #5
    //   297: iload #4
    //   299: iconst_1
    //   300: iadd
    //   301: istore_3
    //   302: iload #5
    //   304: istore #4
    //   306: goto -> 70
    //   309: iload_3
    //   310: bipush #93
    //   312: if_icmpne -> 366
    //   315: iload #4
    //   317: iconst_1
    //   318: iadd
    //   319: istore_3
    //   320: aload_0
    //   321: iload #4
    //   323: invokevirtual charAt : (I)C
    //   326: istore #4
    //   328: iload #4
    //   330: istore #8
    //   332: iload_3
    //   333: istore #4
    //   335: aload_2
    //   336: astore_1
    //   337: iload #8
    //   339: istore #5
    //   341: iload #8
    //   343: invokestatic isWhitespace : (C)Z
    //   346: ifeq -> 443
    //   349: aload_0
    //   350: iload_3
    //   351: invokevirtual charAt : (I)C
    //   354: istore #4
    //   356: iinc #3, 1
    //   359: iload #4
    //   361: istore #8
    //   363: goto -> 332
    //   366: aload_0
    //   367: iconst_m1
    //   368: putfield matchStat : I
    //   371: aconst_null
    //   372: areturn
    //   373: iload #4
    //   375: bipush #93
    //   377: if_icmpne -> 406
    //   380: aload_2
    //   381: invokeinterface size : ()I
    //   386: ifne -> 406
    //   389: iload_3
    //   390: iconst_1
    //   391: iadd
    //   392: istore #4
    //   394: aload_0
    //   395: iload_3
    //   396: invokevirtual charAt : (I)C
    //   399: istore #5
    //   401: aload_2
    //   402: astore_1
    //   403: goto -> 443
    //   406: aload_0
    //   407: iconst_m1
    //   408: putfield matchStat : I
    //   411: aconst_null
    //   412: areturn
    //   413: aload_0
    //   414: getfield text : Ljava/lang/String;
    //   417: ldc 'ull'
    //   419: iload #4
    //   421: invokevirtual startsWith : (Ljava/lang/String;I)Z
    //   424: ifeq -> 711
    //   427: iinc #4, 3
    //   430: aload_0
    //   431: iload #4
    //   433: invokevirtual charAt : (I)C
    //   436: istore #5
    //   438: iinc #4, 1
    //   441: aconst_null
    //   442: astore_1
    //   443: aload_0
    //   444: iload #4
    //   446: putfield bp : I
    //   449: iload #5
    //   451: bipush #44
    //   453: if_icmpne -> 475
    //   456: aload_0
    //   457: aload_0
    //   458: aload_0
    //   459: getfield bp : I
    //   462: invokevirtual charAt : (I)C
    //   465: putfield ch : C
    //   468: aload_0
    //   469: iconst_3
    //   470: putfield matchStat : I
    //   473: aload_1
    //   474: areturn
    //   475: iload #5
    //   477: bipush #125
    //   479: if_icmpne -> 704
    //   482: aload_0
    //   483: aload_0
    //   484: getfield bp : I
    //   487: invokevirtual charAt : (I)C
    //   490: istore #5
    //   492: iload #5
    //   494: bipush #44
    //   496: if_icmpne -> 532
    //   499: aload_0
    //   500: bipush #16
    //   502: putfield token : I
    //   505: aload_0
    //   506: getfield bp : I
    //   509: iconst_1
    //   510: iadd
    //   511: istore #4
    //   513: aload_0
    //   514: iload #4
    //   516: putfield bp : I
    //   519: aload_0
    //   520: aload_0
    //   521: iload #4
    //   523: invokevirtual charAt : (I)C
    //   526: putfield ch : C
    //   529: goto -> 632
    //   532: iload #5
    //   534: bipush #93
    //   536: if_icmpne -> 572
    //   539: aload_0
    //   540: bipush #15
    //   542: putfield token : I
    //   545: aload_0
    //   546: getfield bp : I
    //   549: iconst_1
    //   550: iadd
    //   551: istore #4
    //   553: aload_0
    //   554: iload #4
    //   556: putfield bp : I
    //   559: aload_0
    //   560: aload_0
    //   561: iload #4
    //   563: invokevirtual charAt : (I)C
    //   566: putfield ch : C
    //   569: goto -> 632
    //   572: iload #5
    //   574: bipush #125
    //   576: if_icmpne -> 612
    //   579: aload_0
    //   580: bipush #13
    //   582: putfield token : I
    //   585: aload_0
    //   586: getfield bp : I
    //   589: iconst_1
    //   590: iadd
    //   591: istore #4
    //   593: aload_0
    //   594: iload #4
    //   596: putfield bp : I
    //   599: aload_0
    //   600: aload_0
    //   601: iload #4
    //   603: invokevirtual charAt : (I)C
    //   606: putfield ch : C
    //   609: goto -> 632
    //   612: iload #5
    //   614: bipush #26
    //   616: if_icmpne -> 639
    //   619: aload_0
    //   620: bipush #20
    //   622: putfield token : I
    //   625: aload_0
    //   626: iload #5
    //   628: i2c
    //   629: putfield ch : C
    //   632: aload_0
    //   633: iconst_4
    //   634: putfield matchStat : I
    //   637: aload_1
    //   638: areturn
    //   639: iconst_0
    //   640: istore_3
    //   641: iload #5
    //   643: istore #8
    //   645: iload #8
    //   647: invokestatic isWhitespace : (C)Z
    //   650: ifeq -> 686
    //   653: iload #4
    //   655: iconst_1
    //   656: iadd
    //   657: istore #7
    //   659: aload_0
    //   660: iload #4
    //   662: invokevirtual charAt : (I)C
    //   665: istore #5
    //   667: aload_0
    //   668: iload #7
    //   670: putfield bp : I
    //   673: iconst_1
    //   674: istore_3
    //   675: iload #7
    //   677: istore #4
    //   679: iload #5
    //   681: istore #8
    //   683: goto -> 645
    //   686: iload_3
    //   687: ifeq -> 697
    //   690: iload #8
    //   692: istore #5
    //   694: goto -> 492
    //   697: aload_0
    //   698: iconst_m1
    //   699: putfield matchStat : I
    //   702: aconst_null
    //   703: areturn
    //   704: aload_0
    //   705: iconst_m1
    //   706: putfield matchStat : I
    //   709: aconst_null
    //   710: areturn
    //   711: aload_0
    //   712: iconst_m1
    //   713: putfield matchStat : I
    //   716: aconst_null
    //   717: areturn
  }
  
  public long scanFieldSymbol(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return 0L;
    } 
    int i = this.bp + paramArrayOfchar.length;
    int j = i + 1;
    if (charAt(i) != '"') {
      this.matchStat = -1;
      return 0L;
    } 
    long l = -2128831035L;
    while (true) {
      i = j + 1;
      j = charAt(j);
      if (j == 34) {
        this.bp = i;
        j = charAt(this.bp);
        this.ch = (char)j;
        int k = j;
        while (true) {
          if (k == 44) {
            j = this.bp + 1;
            this.bp = j;
            this.ch = charAt(j);
            this.matchStat = 3;
            return l;
          } 
          if (k == 125) {
            next();
            skipWhitespace();
            j = getCurrent();
            if (j == 44) {
              this.token = 16;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            } else if (j == 93) {
              this.token = 15;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            } else if (j == 125) {
              this.token = 13;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            } else {
              if (j == 26) {
                this.token = 20;
                this.matchStat = 4;
                return l;
              } 
              this.matchStat = -1;
              return 0L;
            } 
            this.matchStat = 4;
            return l;
          } 
          if (isWhitespace(k)) {
            j = this.bp + 1;
            this.bp = j;
            j = charAt(j);
            k = j;
            continue;
          } 
          this.matchStat = -1;
          return 0L;
        } 
        break;
      } 
      if (i > this.len) {
        this.matchStat = -1;
        return 0L;
      } 
      l = (l ^ j) * 16777619L;
      j = i;
    } 
  }
  
  public boolean scanISO8601DateIfMatch() {
    return scanISO8601DateIfMatch(true);
  }
  
  public boolean scanISO8601DateIfMatch(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield len : I
    //   4: aload_0
    //   5: getfield bp : I
    //   8: isub
    //   9: istore_2
    //   10: iload_1
    //   11: ifne -> 300
    //   14: iload_2
    //   15: bipush #13
    //   17: if_icmple -> 300
    //   20: aload_0
    //   21: aload_0
    //   22: getfield bp : I
    //   25: invokevirtual charAt : (I)C
    //   28: istore_3
    //   29: aload_0
    //   30: aload_0
    //   31: getfield bp : I
    //   34: iconst_1
    //   35: iadd
    //   36: invokevirtual charAt : (I)C
    //   39: istore #4
    //   41: aload_0
    //   42: aload_0
    //   43: getfield bp : I
    //   46: iconst_2
    //   47: iadd
    //   48: invokevirtual charAt : (I)C
    //   51: istore #5
    //   53: aload_0
    //   54: aload_0
    //   55: getfield bp : I
    //   58: iconst_3
    //   59: iadd
    //   60: invokevirtual charAt : (I)C
    //   63: istore #6
    //   65: aload_0
    //   66: aload_0
    //   67: getfield bp : I
    //   70: iconst_4
    //   71: iadd
    //   72: invokevirtual charAt : (I)C
    //   75: istore #7
    //   77: aload_0
    //   78: aload_0
    //   79: getfield bp : I
    //   82: iconst_5
    //   83: iadd
    //   84: invokevirtual charAt : (I)C
    //   87: istore #8
    //   89: aload_0
    //   90: aload_0
    //   91: getfield bp : I
    //   94: iload_2
    //   95: iadd
    //   96: iconst_1
    //   97: isub
    //   98: invokevirtual charAt : (I)C
    //   101: istore #9
    //   103: aload_0
    //   104: aload_0
    //   105: getfield bp : I
    //   108: iload_2
    //   109: iadd
    //   110: iconst_2
    //   111: isub
    //   112: invokevirtual charAt : (I)C
    //   115: istore #10
    //   117: iload_3
    //   118: bipush #47
    //   120: if_icmpne -> 300
    //   123: iload #4
    //   125: bipush #68
    //   127: if_icmpne -> 300
    //   130: iload #5
    //   132: bipush #97
    //   134: if_icmpne -> 300
    //   137: iload #6
    //   139: bipush #116
    //   141: if_icmpne -> 300
    //   144: iload #7
    //   146: bipush #101
    //   148: if_icmpne -> 300
    //   151: iload #8
    //   153: bipush #40
    //   155: if_icmpne -> 300
    //   158: iload #9
    //   160: bipush #47
    //   162: if_icmpne -> 300
    //   165: iload #10
    //   167: bipush #41
    //   169: if_icmpne -> 300
    //   172: bipush #6
    //   174: istore_3
    //   175: iconst_m1
    //   176: istore #5
    //   178: iload_3
    //   179: iload_2
    //   180: if_icmpge -> 239
    //   183: aload_0
    //   184: aload_0
    //   185: getfield bp : I
    //   188: iload_3
    //   189: iadd
    //   190: invokevirtual charAt : (I)C
    //   193: istore #7
    //   195: iload #7
    //   197: bipush #43
    //   199: if_icmpne -> 208
    //   202: iload_3
    //   203: istore #10
    //   205: goto -> 229
    //   208: iload #7
    //   210: bipush #48
    //   212: if_icmplt -> 239
    //   215: iload #5
    //   217: istore #10
    //   219: iload #7
    //   221: bipush #57
    //   223: if_icmple -> 229
    //   226: goto -> 239
    //   229: iinc #3, 1
    //   232: iload #10
    //   234: istore #5
    //   236: goto -> 178
    //   239: iload #5
    //   241: iconst_m1
    //   242: if_icmpne -> 247
    //   245: iconst_0
    //   246: ireturn
    //   247: aload_0
    //   248: getfield bp : I
    //   251: bipush #6
    //   253: iadd
    //   254: istore_3
    //   255: aload_0
    //   256: iload_3
    //   257: iload #5
    //   259: iload_3
    //   260: isub
    //   261: invokevirtual subString : (II)Ljava/lang/String;
    //   264: invokestatic parseLong : (Ljava/lang/String;)J
    //   267: lstore #11
    //   269: aload_0
    //   270: aload_0
    //   271: getfield timeZone : Ljava/util/TimeZone;
    //   274: aload_0
    //   275: getfield locale : Ljava/util/Locale;
    //   278: invokestatic getInstance : (Ljava/util/TimeZone;Ljava/util/Locale;)Ljava/util/Calendar;
    //   281: putfield calendar : Ljava/util/Calendar;
    //   284: aload_0
    //   285: getfield calendar : Ljava/util/Calendar;
    //   288: lload #11
    //   290: invokevirtual setTimeInMillis : (J)V
    //   293: aload_0
    //   294: iconst_5
    //   295: putfield token : I
    //   298: iconst_1
    //   299: ireturn
    //   300: iload_2
    //   301: bipush #8
    //   303: if_icmpeq -> 2148
    //   306: iload_2
    //   307: bipush #14
    //   309: if_icmpeq -> 2148
    //   312: iload_2
    //   313: bipush #17
    //   315: if_icmpne -> 337
    //   318: aload_0
    //   319: aload_0
    //   320: getfield bp : I
    //   323: bipush #6
    //   325: iadd
    //   326: invokevirtual charAt : (I)C
    //   329: bipush #45
    //   331: if_icmpeq -> 337
    //   334: goto -> 2148
    //   337: iload_2
    //   338: bipush #9
    //   340: if_icmpge -> 345
    //   343: iconst_0
    //   344: ireturn
    //   345: aload_0
    //   346: aload_0
    //   347: getfield bp : I
    //   350: invokevirtual charAt : (I)C
    //   353: istore #10
    //   355: aload_0
    //   356: aload_0
    //   357: getfield bp : I
    //   360: iconst_1
    //   361: iadd
    //   362: invokevirtual charAt : (I)C
    //   365: istore #5
    //   367: aload_0
    //   368: aload_0
    //   369: getfield bp : I
    //   372: iconst_2
    //   373: iadd
    //   374: invokevirtual charAt : (I)C
    //   377: istore #7
    //   379: aload_0
    //   380: aload_0
    //   381: getfield bp : I
    //   384: iconst_3
    //   385: iadd
    //   386: invokevirtual charAt : (I)C
    //   389: istore_3
    //   390: aload_0
    //   391: aload_0
    //   392: getfield bp : I
    //   395: iconst_4
    //   396: iadd
    //   397: invokevirtual charAt : (I)C
    //   400: istore #13
    //   402: aload_0
    //   403: aload_0
    //   404: getfield bp : I
    //   407: iconst_5
    //   408: iadd
    //   409: invokevirtual charAt : (I)C
    //   412: istore #9
    //   414: iload #9
    //   416: istore #4
    //   418: aload_0
    //   419: aload_0
    //   420: getfield bp : I
    //   423: bipush #6
    //   425: iadd
    //   426: invokevirtual charAt : (I)C
    //   429: istore #14
    //   431: iload #14
    //   433: istore #15
    //   435: aload_0
    //   436: aload_0
    //   437: getfield bp : I
    //   440: bipush #7
    //   442: iadd
    //   443: invokevirtual charAt : (I)C
    //   446: istore #6
    //   448: iload #6
    //   450: istore #16
    //   452: aload_0
    //   453: aload_0
    //   454: getfield bp : I
    //   457: bipush #8
    //   459: iadd
    //   460: invokevirtual charAt : (I)C
    //   463: istore #8
    //   465: iload #8
    //   467: istore #17
    //   469: aload_0
    //   470: aload_0
    //   471: getfield bp : I
    //   474: bipush #9
    //   476: iadd
    //   477: invokevirtual charAt : (I)C
    //   480: istore #18
    //   482: iload #18
    //   484: istore #19
    //   486: iload #13
    //   488: bipush #45
    //   490: if_icmpne -> 500
    //   493: iload #16
    //   495: bipush #45
    //   497: if_icmpeq -> 514
    //   500: iload #13
    //   502: bipush #47
    //   504: if_icmpne -> 555
    //   507: iload #16
    //   509: bipush #47
    //   511: if_icmpne -> 555
    //   514: bipush #10
    //   516: istore #9
    //   518: iload #4
    //   520: istore #20
    //   522: iload_3
    //   523: istore #21
    //   525: iload #10
    //   527: istore #22
    //   529: iload #5
    //   531: istore #23
    //   533: iload #7
    //   535: istore #24
    //   537: iload #14
    //   539: istore #25
    //   541: iload #8
    //   543: istore #26
    //   545: iload #18
    //   547: istore #27
    //   549: iload #9
    //   551: istore_3
    //   552: goto -> 962
    //   555: iload #13
    //   557: bipush #45
    //   559: if_icmpne -> 690
    //   562: iload #15
    //   564: bipush #45
    //   566: if_icmpne -> 690
    //   569: iload #17
    //   571: bipush #32
    //   573: if_icmpne -> 625
    //   576: bipush #8
    //   578: istore #8
    //   580: bipush #48
    //   582: istore #4
    //   584: bipush #48
    //   586: istore #14
    //   588: iload #14
    //   590: istore #20
    //   592: iload_3
    //   593: istore #21
    //   595: iload #10
    //   597: istore #22
    //   599: iload #5
    //   601: istore #23
    //   603: iload #7
    //   605: istore #24
    //   607: iload #9
    //   609: istore #25
    //   611: iload #4
    //   613: istore #26
    //   615: iload #6
    //   617: istore #27
    //   619: iload #8
    //   621: istore_3
    //   622: goto -> 962
    //   625: bipush #9
    //   627: istore #4
    //   629: iload #9
    //   631: istore #14
    //   633: bipush #48
    //   635: istore #15
    //   637: iload #4
    //   639: istore #9
    //   641: iload #6
    //   643: istore #4
    //   645: iload #14
    //   647: istore #6
    //   649: iload #15
    //   651: istore #14
    //   653: iload #14
    //   655: istore #20
    //   657: iload_3
    //   658: istore #21
    //   660: iload #10
    //   662: istore #22
    //   664: iload #5
    //   666: istore #23
    //   668: iload #7
    //   670: istore #24
    //   672: iload #6
    //   674: istore #25
    //   676: iload #4
    //   678: istore #26
    //   680: iload #8
    //   682: istore #27
    //   684: iload #9
    //   686: istore_3
    //   687: goto -> 962
    //   690: iload #7
    //   692: bipush #46
    //   694: if_icmpne -> 704
    //   697: iload #4
    //   699: bipush #46
    //   701: if_icmpeq -> 718
    //   704: iload #7
    //   706: bipush #45
    //   708: if_icmpne -> 759
    //   711: iload #4
    //   713: bipush #45
    //   715: if_icmpne -> 759
    //   718: bipush #10
    //   720: istore #7
    //   722: iload_3
    //   723: istore #20
    //   725: iload #19
    //   727: istore #21
    //   729: iload #15
    //   731: istore #22
    //   733: iload #16
    //   735: istore #23
    //   737: iload #17
    //   739: istore #24
    //   741: iload #13
    //   743: istore #25
    //   745: iload #10
    //   747: istore #26
    //   749: iload #5
    //   751: istore #27
    //   753: iload #7
    //   755: istore_3
    //   756: goto -> 962
    //   759: iload #13
    //   761: sipush #24180
    //   764: if_icmpeq -> 780
    //   767: iload #13
    //   769: ldc_w 45380
    //   772: if_icmpne -> 778
    //   775: goto -> 780
    //   778: iconst_0
    //   779: ireturn
    //   780: iload #16
    //   782: sipush #26376
    //   785: if_icmpeq -> 874
    //   788: iload #16
    //   790: ldc_w 50900
    //   793: if_icmpne -> 799
    //   796: goto -> 874
    //   799: iload #15
    //   801: sipush #26376
    //   804: if_icmpeq -> 820
    //   807: iload #15
    //   809: ldc_w 50900
    //   812: if_icmpne -> 818
    //   815: goto -> 820
    //   818: iconst_0
    //   819: ireturn
    //   820: iload #17
    //   822: sipush #26085
    //   825: if_icmpeq -> 867
    //   828: iload #17
    //   830: ldc_w 51068
    //   833: if_icmpne -> 839
    //   836: goto -> 867
    //   839: iload #19
    //   841: sipush #26085
    //   844: if_icmpeq -> 860
    //   847: iload #19
    //   849: ldc_w 51068
    //   852: if_icmpne -> 858
    //   855: goto -> 860
    //   858: iconst_0
    //   859: ireturn
    //   860: bipush #10
    //   862: istore #4
    //   864: goto -> 629
    //   867: bipush #10
    //   869: istore #8
    //   871: goto -> 580
    //   874: iload #19
    //   876: sipush #26085
    //   879: if_icmpeq -> 939
    //   882: iload #19
    //   884: ldc_w 51068
    //   887: if_icmpne -> 893
    //   890: goto -> 939
    //   893: aload_0
    //   894: aload_0
    //   895: getfield bp : I
    //   898: bipush #10
    //   900: iadd
    //   901: invokevirtual charAt : (I)C
    //   904: sipush #26085
    //   907: if_icmpeq -> 932
    //   910: aload_0
    //   911: aload_0
    //   912: getfield bp : I
    //   915: bipush #10
    //   917: iadd
    //   918: invokevirtual charAt : (I)C
    //   921: ldc_w 51068
    //   924: if_icmpne -> 930
    //   927: goto -> 932
    //   930: iconst_0
    //   931: ireturn
    //   932: bipush #11
    //   934: istore #9
    //   936: goto -> 518
    //   939: iload #15
    //   941: istore #6
    //   943: bipush #48
    //   945: istore #15
    //   947: bipush #10
    //   949: istore #9
    //   951: iload #4
    //   953: istore #14
    //   955: iload #15
    //   957: istore #4
    //   959: goto -> 653
    //   962: iload #22
    //   964: iload #23
    //   966: iload #24
    //   968: iload #21
    //   970: iload #20
    //   972: iload #25
    //   974: iload #26
    //   976: iload #27
    //   978: invokestatic checkDate : (CCCCCCII)Z
    //   981: ifne -> 986
    //   984: iconst_0
    //   985: ireturn
    //   986: aload_0
    //   987: iload #22
    //   989: iload #23
    //   991: iload #24
    //   993: iload #21
    //   995: iload #20
    //   997: iload #25
    //   999: iload #26
    //   1001: iload #27
    //   1003: invokespecial setCalendar : (CCCCCCCC)V
    //   1006: aload_0
    //   1007: aload_0
    //   1008: getfield bp : I
    //   1011: iload_3
    //   1012: iadd
    //   1013: invokevirtual charAt : (I)C
    //   1016: istore #20
    //   1018: iload #20
    //   1020: bipush #84
    //   1022: if_icmpeq -> 1286
    //   1025: iload #20
    //   1027: bipush #32
    //   1029: if_icmpne -> 1039
    //   1032: iload_1
    //   1033: ifne -> 1039
    //   1036: goto -> 1286
    //   1039: iload #20
    //   1041: bipush #34
    //   1043: if_icmpeq -> 1218
    //   1046: iload #20
    //   1048: bipush #26
    //   1050: if_icmpeq -> 1218
    //   1053: iload #20
    //   1055: sipush #26085
    //   1058: if_icmpeq -> 1218
    //   1061: iload #20
    //   1063: ldc_w 51068
    //   1066: if_icmpne -> 1072
    //   1069: goto -> 1218
    //   1072: iload #20
    //   1074: bipush #43
    //   1076: if_icmpeq -> 1091
    //   1079: iload #20
    //   1081: bipush #45
    //   1083: if_icmpne -> 1089
    //   1086: goto -> 1091
    //   1089: iconst_0
    //   1090: ireturn
    //   1091: aload_0
    //   1092: getfield len : I
    //   1095: iload_3
    //   1096: bipush #6
    //   1098: iadd
    //   1099: if_icmpne -> 1216
    //   1102: aload_0
    //   1103: aload_0
    //   1104: getfield bp : I
    //   1107: iload_3
    //   1108: iadd
    //   1109: iconst_3
    //   1110: iadd
    //   1111: invokevirtual charAt : (I)C
    //   1114: bipush #58
    //   1116: if_icmpne -> 1214
    //   1119: aload_0
    //   1120: aload_0
    //   1121: getfield bp : I
    //   1124: iload_3
    //   1125: iadd
    //   1126: iconst_4
    //   1127: iadd
    //   1128: invokevirtual charAt : (I)C
    //   1131: bipush #48
    //   1133: if_icmpne -> 1214
    //   1136: aload_0
    //   1137: aload_0
    //   1138: getfield bp : I
    //   1141: iload_3
    //   1142: iadd
    //   1143: iconst_5
    //   1144: iadd
    //   1145: invokevirtual charAt : (I)C
    //   1148: bipush #48
    //   1150: if_icmpeq -> 1156
    //   1153: goto -> 1214
    //   1156: aload_0
    //   1157: bipush #48
    //   1159: bipush #48
    //   1161: bipush #48
    //   1163: bipush #48
    //   1165: bipush #48
    //   1167: bipush #48
    //   1169: invokevirtual setTime : (CCCCCC)V
    //   1172: aload_0
    //   1173: getfield calendar : Ljava/util/Calendar;
    //   1176: bipush #14
    //   1178: iconst_0
    //   1179: invokevirtual set : (II)V
    //   1182: aload_0
    //   1183: iload #20
    //   1185: aload_0
    //   1186: aload_0
    //   1187: getfield bp : I
    //   1190: iload_3
    //   1191: iadd
    //   1192: iconst_1
    //   1193: iadd
    //   1194: invokevirtual charAt : (I)C
    //   1197: aload_0
    //   1198: aload_0
    //   1199: getfield bp : I
    //   1202: iload_3
    //   1203: iadd
    //   1204: iconst_2
    //   1205: iadd
    //   1206: invokevirtual charAt : (I)C
    //   1209: invokevirtual setTimeZone : (CCC)V
    //   1212: iconst_1
    //   1213: ireturn
    //   1214: iconst_0
    //   1215: ireturn
    //   1216: iconst_0
    //   1217: ireturn
    //   1218: aload_0
    //   1219: getfield calendar : Ljava/util/Calendar;
    //   1222: bipush #11
    //   1224: iconst_0
    //   1225: invokevirtual set : (II)V
    //   1228: aload_0
    //   1229: getfield calendar : Ljava/util/Calendar;
    //   1232: bipush #12
    //   1234: iconst_0
    //   1235: invokevirtual set : (II)V
    //   1238: aload_0
    //   1239: getfield calendar : Ljava/util/Calendar;
    //   1242: bipush #13
    //   1244: iconst_0
    //   1245: invokevirtual set : (II)V
    //   1248: aload_0
    //   1249: getfield calendar : Ljava/util/Calendar;
    //   1252: bipush #14
    //   1254: iconst_0
    //   1255: invokevirtual set : (II)V
    //   1258: aload_0
    //   1259: getfield bp : I
    //   1262: iload_3
    //   1263: iadd
    //   1264: istore_3
    //   1265: aload_0
    //   1266: iload_3
    //   1267: putfield bp : I
    //   1270: aload_0
    //   1271: aload_0
    //   1272: iload_3
    //   1273: invokevirtual charAt : (I)C
    //   1276: putfield ch : C
    //   1279: aload_0
    //   1280: iconst_5
    //   1281: putfield token : I
    //   1284: iconst_1
    //   1285: ireturn
    //   1286: iload_3
    //   1287: bipush #9
    //   1289: iadd
    //   1290: istore #10
    //   1292: iload_2
    //   1293: iload #10
    //   1295: if_icmpge -> 1300
    //   1298: iconst_0
    //   1299: ireturn
    //   1300: aload_0
    //   1301: aload_0
    //   1302: getfield bp : I
    //   1305: iload_3
    //   1306: iadd
    //   1307: iconst_3
    //   1308: iadd
    //   1309: invokevirtual charAt : (I)C
    //   1312: bipush #58
    //   1314: if_icmpeq -> 1319
    //   1317: iconst_0
    //   1318: ireturn
    //   1319: aload_0
    //   1320: aload_0
    //   1321: getfield bp : I
    //   1324: iload_3
    //   1325: iadd
    //   1326: bipush #6
    //   1328: iadd
    //   1329: invokevirtual charAt : (I)C
    //   1332: bipush #58
    //   1334: if_icmpeq -> 1339
    //   1337: iconst_0
    //   1338: ireturn
    //   1339: aload_0
    //   1340: aload_0
    //   1341: getfield bp : I
    //   1344: iload_3
    //   1345: iadd
    //   1346: iconst_1
    //   1347: iadd
    //   1348: invokevirtual charAt : (I)C
    //   1351: istore #24
    //   1353: aload_0
    //   1354: aload_0
    //   1355: getfield bp : I
    //   1358: iload_3
    //   1359: iadd
    //   1360: iconst_2
    //   1361: iadd
    //   1362: invokevirtual charAt : (I)C
    //   1365: istore #27
    //   1367: aload_0
    //   1368: aload_0
    //   1369: getfield bp : I
    //   1372: iload_3
    //   1373: iadd
    //   1374: iconst_4
    //   1375: iadd
    //   1376: invokevirtual charAt : (I)C
    //   1379: istore #22
    //   1381: aload_0
    //   1382: aload_0
    //   1383: getfield bp : I
    //   1386: iload_3
    //   1387: iadd
    //   1388: iconst_5
    //   1389: iadd
    //   1390: invokevirtual charAt : (I)C
    //   1393: istore #25
    //   1395: aload_0
    //   1396: aload_0
    //   1397: getfield bp : I
    //   1400: iload_3
    //   1401: iadd
    //   1402: bipush #7
    //   1404: iadd
    //   1405: invokevirtual charAt : (I)C
    //   1408: istore #20
    //   1410: aload_0
    //   1411: aload_0
    //   1412: getfield bp : I
    //   1415: iload_3
    //   1416: iadd
    //   1417: bipush #8
    //   1419: iadd
    //   1420: invokevirtual charAt : (I)C
    //   1423: istore #23
    //   1425: aload_0
    //   1426: iload #24
    //   1428: iload #27
    //   1430: iload #22
    //   1432: iload #25
    //   1434: iload #20
    //   1436: iload #23
    //   1438: invokespecial checkTime : (CCCCCC)Z
    //   1441: ifne -> 1446
    //   1444: iconst_0
    //   1445: ireturn
    //   1446: aload_0
    //   1447: iload #24
    //   1449: iload #27
    //   1451: iload #22
    //   1453: iload #25
    //   1455: iload #20
    //   1457: iload #23
    //   1459: invokevirtual setTime : (CCCCCC)V
    //   1462: aload_0
    //   1463: aload_0
    //   1464: getfield bp : I
    //   1467: iload_3
    //   1468: iadd
    //   1469: bipush #9
    //   1471: iadd
    //   1472: invokevirtual charAt : (I)C
    //   1475: istore #5
    //   1477: iload #5
    //   1479: bipush #46
    //   1481: if_icmpne -> 2059
    //   1484: iload_3
    //   1485: bipush #11
    //   1487: iadd
    //   1488: istore #10
    //   1490: iload_2
    //   1491: iload #10
    //   1493: if_icmpge -> 1498
    //   1496: iconst_0
    //   1497: ireturn
    //   1498: aload_0
    //   1499: aload_0
    //   1500: getfield bp : I
    //   1503: iload_3
    //   1504: iadd
    //   1505: bipush #10
    //   1507: iadd
    //   1508: invokevirtual charAt : (I)C
    //   1511: istore #5
    //   1513: iload #5
    //   1515: bipush #48
    //   1517: if_icmplt -> 2057
    //   1520: iload #5
    //   1522: bipush #57
    //   1524: if_icmple -> 1530
    //   1527: goto -> 2057
    //   1530: iinc #5, -48
    //   1533: iload_2
    //   1534: iload #10
    //   1536: if_icmple -> 1587
    //   1539: aload_0
    //   1540: aload_0
    //   1541: getfield bp : I
    //   1544: iload_3
    //   1545: iadd
    //   1546: bipush #11
    //   1548: iadd
    //   1549: invokevirtual charAt : (I)C
    //   1552: istore #10
    //   1554: iload #10
    //   1556: bipush #48
    //   1558: if_icmplt -> 1587
    //   1561: iload #10
    //   1563: bipush #57
    //   1565: if_icmpgt -> 1587
    //   1568: iload #5
    //   1570: bipush #10
    //   1572: imul
    //   1573: iload #10
    //   1575: bipush #48
    //   1577: isub
    //   1578: iadd
    //   1579: istore #5
    //   1581: iconst_2
    //   1582: istore #10
    //   1584: goto -> 1590
    //   1587: iconst_1
    //   1588: istore #10
    //   1590: iload #10
    //   1592: istore #7
    //   1594: iload #5
    //   1596: istore #8
    //   1598: iload #10
    //   1600: iconst_2
    //   1601: if_icmpne -> 1665
    //   1604: aload_0
    //   1605: aload_0
    //   1606: getfield bp : I
    //   1609: iload_3
    //   1610: iadd
    //   1611: bipush #12
    //   1613: iadd
    //   1614: invokevirtual charAt : (I)C
    //   1617: istore #9
    //   1619: iload #10
    //   1621: istore #7
    //   1623: iload #5
    //   1625: istore #8
    //   1627: iload #9
    //   1629: bipush #48
    //   1631: if_icmplt -> 1665
    //   1634: iload #10
    //   1636: istore #7
    //   1638: iload #5
    //   1640: istore #8
    //   1642: iload #9
    //   1644: bipush #57
    //   1646: if_icmpgt -> 1665
    //   1649: iload #5
    //   1651: bipush #10
    //   1653: imul
    //   1654: iload #9
    //   1656: bipush #48
    //   1658: isub
    //   1659: iadd
    //   1660: istore #8
    //   1662: iconst_3
    //   1663: istore #7
    //   1665: aload_0
    //   1666: getfield calendar : Ljava/util/Calendar;
    //   1669: bipush #14
    //   1671: iload #8
    //   1673: invokevirtual set : (II)V
    //   1676: aload_0
    //   1677: aload_0
    //   1678: getfield bp : I
    //   1681: iload_3
    //   1682: iadd
    //   1683: bipush #10
    //   1685: iadd
    //   1686: iload #7
    //   1688: iadd
    //   1689: invokevirtual charAt : (I)C
    //   1692: istore #22
    //   1694: iload #22
    //   1696: bipush #43
    //   1698: if_icmpeq -> 1773
    //   1701: iload #22
    //   1703: bipush #45
    //   1705: if_icmpne -> 1711
    //   1708: goto -> 1773
    //   1711: iload #22
    //   1713: bipush #90
    //   1715: if_icmpne -> 1767
    //   1718: aload_0
    //   1719: getfield calendar : Ljava/util/Calendar;
    //   1722: invokevirtual getTimeZone : ()Ljava/util/TimeZone;
    //   1725: invokevirtual getRawOffset : ()I
    //   1728: ifeq -> 1761
    //   1731: iconst_0
    //   1732: invokestatic getAvailableIDs : (I)[Ljava/lang/String;
    //   1735: astore #28
    //   1737: aload #28
    //   1739: arraylength
    //   1740: ifle -> 1761
    //   1743: aload #28
    //   1745: iconst_0
    //   1746: aaload
    //   1747: invokestatic getTimeZone : (Ljava/lang/String;)Ljava/util/TimeZone;
    //   1750: astore #28
    //   1752: aload_0
    //   1753: getfield calendar : Ljava/util/Calendar;
    //   1756: aload #28
    //   1758: invokevirtual setTimeZone : (Ljava/util/TimeZone;)V
    //   1761: iconst_1
    //   1762: istore #5
    //   1764: goto -> 1982
    //   1767: iconst_0
    //   1768: istore #5
    //   1770: goto -> 1982
    //   1773: aload_0
    //   1774: aload_0
    //   1775: getfield bp : I
    //   1778: iload_3
    //   1779: iadd
    //   1780: bipush #10
    //   1782: iadd
    //   1783: iload #7
    //   1785: iadd
    //   1786: iconst_1
    //   1787: iadd
    //   1788: invokevirtual charAt : (I)C
    //   1791: istore #24
    //   1793: iload #24
    //   1795: bipush #48
    //   1797: if_icmplt -> 2055
    //   1800: iload #24
    //   1802: bipush #49
    //   1804: if_icmple -> 1810
    //   1807: goto -> 2055
    //   1810: aload_0
    //   1811: aload_0
    //   1812: getfield bp : I
    //   1815: iload_3
    //   1816: iadd
    //   1817: bipush #10
    //   1819: iadd
    //   1820: iload #7
    //   1822: iadd
    //   1823: iconst_2
    //   1824: iadd
    //   1825: invokevirtual charAt : (I)C
    //   1828: istore #20
    //   1830: iload #20
    //   1832: bipush #48
    //   1834: if_icmplt -> 2053
    //   1837: iload #20
    //   1839: bipush #57
    //   1841: if_icmple -> 1847
    //   1844: goto -> 2053
    //   1847: aload_0
    //   1848: aload_0
    //   1849: getfield bp : I
    //   1852: iload_3
    //   1853: iadd
    //   1854: bipush #10
    //   1856: iadd
    //   1857: iload #7
    //   1859: iadd
    //   1860: iconst_3
    //   1861: iadd
    //   1862: invokevirtual charAt : (I)C
    //   1865: istore #5
    //   1867: iload #5
    //   1869: bipush #58
    //   1871: if_icmpne -> 1931
    //   1874: aload_0
    //   1875: aload_0
    //   1876: getfield bp : I
    //   1879: iload_3
    //   1880: iadd
    //   1881: bipush #10
    //   1883: iadd
    //   1884: iload #7
    //   1886: iadd
    //   1887: iconst_4
    //   1888: iadd
    //   1889: invokevirtual charAt : (I)C
    //   1892: bipush #48
    //   1894: if_icmpeq -> 1899
    //   1897: iconst_0
    //   1898: ireturn
    //   1899: aload_0
    //   1900: aload_0
    //   1901: getfield bp : I
    //   1904: iload_3
    //   1905: iadd
    //   1906: bipush #10
    //   1908: iadd
    //   1909: iload #7
    //   1911: iadd
    //   1912: iconst_5
    //   1913: iadd
    //   1914: invokevirtual charAt : (I)C
    //   1917: bipush #48
    //   1919: if_icmpeq -> 1924
    //   1922: iconst_0
    //   1923: ireturn
    //   1924: bipush #6
    //   1926: istore #5
    //   1928: goto -> 1972
    //   1931: iload #5
    //   1933: bipush #48
    //   1935: if_icmpne -> 1969
    //   1938: aload_0
    //   1939: aload_0
    //   1940: getfield bp : I
    //   1943: iload_3
    //   1944: iadd
    //   1945: bipush #10
    //   1947: iadd
    //   1948: iload #7
    //   1950: iadd
    //   1951: iconst_4
    //   1952: iadd
    //   1953: invokevirtual charAt : (I)C
    //   1956: bipush #48
    //   1958: if_icmpeq -> 1963
    //   1961: iconst_0
    //   1962: ireturn
    //   1963: iconst_5
    //   1964: istore #5
    //   1966: goto -> 1972
    //   1969: iconst_3
    //   1970: istore #5
    //   1972: aload_0
    //   1973: iload #22
    //   1975: iload #24
    //   1977: iload #20
    //   1979: invokevirtual setTimeZone : (CCC)V
    //   1982: aload_0
    //   1983: getfield bp : I
    //   1986: istore #10
    //   1988: iload_3
    //   1989: bipush #10
    //   1991: iadd
    //   1992: iload #7
    //   1994: iadd
    //   1995: iload #5
    //   1997: iadd
    //   1998: istore_3
    //   1999: aload_0
    //   2000: iload #10
    //   2002: iload_3
    //   2003: iadd
    //   2004: invokevirtual charAt : (I)C
    //   2007: istore #5
    //   2009: iload #5
    //   2011: bipush #26
    //   2013: if_icmpeq -> 2025
    //   2016: iload #5
    //   2018: bipush #34
    //   2020: if_icmpeq -> 2025
    //   2023: iconst_0
    //   2024: ireturn
    //   2025: aload_0
    //   2026: getfield bp : I
    //   2029: iload_3
    //   2030: iadd
    //   2031: istore_3
    //   2032: aload_0
    //   2033: iload_3
    //   2034: putfield bp : I
    //   2037: aload_0
    //   2038: aload_0
    //   2039: iload_3
    //   2040: invokevirtual charAt : (I)C
    //   2043: putfield ch : C
    //   2046: aload_0
    //   2047: iconst_5
    //   2048: putfield token : I
    //   2051: iconst_1
    //   2052: ireturn
    //   2053: iconst_0
    //   2054: ireturn
    //   2055: iconst_0
    //   2056: ireturn
    //   2057: iconst_0
    //   2058: ireturn
    //   2059: aload_0
    //   2060: getfield calendar : Ljava/util/Calendar;
    //   2063: bipush #14
    //   2065: iconst_0
    //   2066: invokevirtual set : (II)V
    //   2069: aload_0
    //   2070: getfield bp : I
    //   2073: iload #10
    //   2075: iadd
    //   2076: istore_3
    //   2077: aload_0
    //   2078: iload_3
    //   2079: putfield bp : I
    //   2082: aload_0
    //   2083: aload_0
    //   2084: iload_3
    //   2085: invokevirtual charAt : (I)C
    //   2088: putfield ch : C
    //   2091: aload_0
    //   2092: iconst_5
    //   2093: putfield token : I
    //   2096: iload #5
    //   2098: bipush #90
    //   2100: if_icmpne -> 2146
    //   2103: aload_0
    //   2104: getfield calendar : Ljava/util/Calendar;
    //   2107: invokevirtual getTimeZone : ()Ljava/util/TimeZone;
    //   2110: invokevirtual getRawOffset : ()I
    //   2113: ifeq -> 2146
    //   2116: iconst_0
    //   2117: invokestatic getAvailableIDs : (I)[Ljava/lang/String;
    //   2120: astore #28
    //   2122: aload #28
    //   2124: arraylength
    //   2125: ifle -> 2146
    //   2128: aload #28
    //   2130: iconst_0
    //   2131: aaload
    //   2132: invokestatic getTimeZone : (Ljava/lang/String;)Ljava/util/TimeZone;
    //   2135: astore #28
    //   2137: aload_0
    //   2138: getfield calendar : Ljava/util/Calendar;
    //   2141: aload #28
    //   2143: invokevirtual setTimeZone : (Ljava/util/TimeZone;)V
    //   2146: iconst_1
    //   2147: ireturn
    //   2148: iconst_0
    //   2149: istore #5
    //   2151: iload_1
    //   2152: ifeq -> 2157
    //   2155: iconst_0
    //   2156: ireturn
    //   2157: aload_0
    //   2158: aload_0
    //   2159: getfield bp : I
    //   2162: invokevirtual charAt : (I)C
    //   2165: istore #20
    //   2167: aload_0
    //   2168: aload_0
    //   2169: getfield bp : I
    //   2172: iconst_1
    //   2173: iadd
    //   2174: invokevirtual charAt : (I)C
    //   2177: istore #27
    //   2179: aload_0
    //   2180: aload_0
    //   2181: getfield bp : I
    //   2184: iconst_2
    //   2185: iadd
    //   2186: invokevirtual charAt : (I)C
    //   2189: istore #24
    //   2191: aload_0
    //   2192: aload_0
    //   2193: getfield bp : I
    //   2196: iconst_3
    //   2197: iadd
    //   2198: invokevirtual charAt : (I)C
    //   2201: istore #25
    //   2203: aload_0
    //   2204: aload_0
    //   2205: getfield bp : I
    //   2208: iconst_4
    //   2209: iadd
    //   2210: invokevirtual charAt : (I)C
    //   2213: istore #23
    //   2215: aload_0
    //   2216: aload_0
    //   2217: getfield bp : I
    //   2220: iconst_5
    //   2221: iadd
    //   2222: invokevirtual charAt : (I)C
    //   2225: istore #22
    //   2227: aload_0
    //   2228: aload_0
    //   2229: getfield bp : I
    //   2232: bipush #6
    //   2234: iadd
    //   2235: invokevirtual charAt : (I)C
    //   2238: istore #21
    //   2240: aload_0
    //   2241: aload_0
    //   2242: getfield bp : I
    //   2245: bipush #7
    //   2247: iadd
    //   2248: invokevirtual charAt : (I)C
    //   2251: istore #26
    //   2253: iload #20
    //   2255: iload #27
    //   2257: iload #24
    //   2259: iload #25
    //   2261: iload #23
    //   2263: iload #22
    //   2265: iload #21
    //   2267: iload #26
    //   2269: invokestatic checkDate : (CCCCCCII)Z
    //   2272: ifne -> 2277
    //   2275: iconst_0
    //   2276: ireturn
    //   2277: aload_0
    //   2278: iload #20
    //   2280: iload #27
    //   2282: iload #24
    //   2284: iload #25
    //   2286: iload #23
    //   2288: iload #22
    //   2290: iload #21
    //   2292: iload #26
    //   2294: invokespecial setCalendar : (CCCCCCCC)V
    //   2297: iload_2
    //   2298: bipush #8
    //   2300: if_icmpeq -> 2580
    //   2303: aload_0
    //   2304: aload_0
    //   2305: getfield bp : I
    //   2308: bipush #8
    //   2310: iadd
    //   2311: invokevirtual charAt : (I)C
    //   2314: istore #25
    //   2316: aload_0
    //   2317: aload_0
    //   2318: getfield bp : I
    //   2321: bipush #9
    //   2323: iadd
    //   2324: invokevirtual charAt : (I)C
    //   2327: istore #20
    //   2329: aload_0
    //   2330: aload_0
    //   2331: getfield bp : I
    //   2334: bipush #10
    //   2336: iadd
    //   2337: invokevirtual charAt : (I)C
    //   2340: istore #27
    //   2342: aload_0
    //   2343: aload_0
    //   2344: getfield bp : I
    //   2347: bipush #11
    //   2349: iadd
    //   2350: invokevirtual charAt : (I)C
    //   2353: istore #22
    //   2355: aload_0
    //   2356: aload_0
    //   2357: getfield bp : I
    //   2360: bipush #12
    //   2362: iadd
    //   2363: invokevirtual charAt : (I)C
    //   2366: istore #24
    //   2368: aload_0
    //   2369: aload_0
    //   2370: getfield bp : I
    //   2373: bipush #13
    //   2375: iadd
    //   2376: invokevirtual charAt : (I)C
    //   2379: istore #23
    //   2381: aload_0
    //   2382: iload #25
    //   2384: iload #20
    //   2386: iload #27
    //   2388: iload #22
    //   2390: iload #24
    //   2392: iload #23
    //   2394: invokespecial checkTime : (CCCCCC)Z
    //   2397: ifne -> 2402
    //   2400: iconst_0
    //   2401: ireturn
    //   2402: iload_2
    //   2403: bipush #17
    //   2405: if_icmpne -> 2527
    //   2408: aload_0
    //   2409: aload_0
    //   2410: getfield bp : I
    //   2413: bipush #14
    //   2415: iadd
    //   2416: invokevirtual charAt : (I)C
    //   2419: istore #5
    //   2421: aload_0
    //   2422: aload_0
    //   2423: getfield bp : I
    //   2426: bipush #15
    //   2428: iadd
    //   2429: invokevirtual charAt : (I)C
    //   2432: istore #10
    //   2434: aload_0
    //   2435: aload_0
    //   2436: getfield bp : I
    //   2439: bipush #16
    //   2441: iadd
    //   2442: invokevirtual charAt : (I)C
    //   2445: istore_3
    //   2446: iload #5
    //   2448: bipush #48
    //   2450: if_icmplt -> 2525
    //   2453: iload #5
    //   2455: bipush #57
    //   2457: if_icmple -> 2463
    //   2460: goto -> 2525
    //   2463: iload #10
    //   2465: bipush #48
    //   2467: if_icmplt -> 2523
    //   2470: iload #10
    //   2472: bipush #57
    //   2474: if_icmple -> 2480
    //   2477: goto -> 2523
    //   2480: iload_3
    //   2481: bipush #48
    //   2483: if_icmplt -> 2521
    //   2486: iload_3
    //   2487: bipush #57
    //   2489: if_icmple -> 2495
    //   2492: goto -> 2521
    //   2495: iload #5
    //   2497: bipush #48
    //   2499: isub
    //   2500: bipush #100
    //   2502: imul
    //   2503: iload #10
    //   2505: bipush #48
    //   2507: isub
    //   2508: bipush #10
    //   2510: imul
    //   2511: iadd
    //   2512: iload_3
    //   2513: bipush #48
    //   2515: isub
    //   2516: iadd
    //   2517: istore_3
    //   2518: goto -> 2529
    //   2521: iconst_0
    //   2522: ireturn
    //   2523: iconst_0
    //   2524: ireturn
    //   2525: iconst_0
    //   2526: ireturn
    //   2527: iconst_0
    //   2528: istore_3
    //   2529: iload #27
    //   2531: bipush #48
    //   2533: isub
    //   2534: bipush #10
    //   2536: imul
    //   2537: iload #22
    //   2539: bipush #48
    //   2541: isub
    //   2542: iadd
    //   2543: istore #10
    //   2545: iload #24
    //   2547: bipush #48
    //   2549: isub
    //   2550: bipush #10
    //   2552: imul
    //   2553: iload #23
    //   2555: bipush #48
    //   2557: isub
    //   2558: iadd
    //   2559: istore #7
    //   2561: iload #25
    //   2563: bipush #48
    //   2565: isub
    //   2566: bipush #10
    //   2568: imul
    //   2569: iload #20
    //   2571: bipush #48
    //   2573: isub
    //   2574: iadd
    //   2575: istore #5
    //   2577: goto -> 2588
    //   2580: iconst_0
    //   2581: istore #10
    //   2583: iconst_0
    //   2584: istore #7
    //   2586: iconst_0
    //   2587: istore_3
    //   2588: aload_0
    //   2589: getfield calendar : Ljava/util/Calendar;
    //   2592: bipush #11
    //   2594: iload #5
    //   2596: invokevirtual set : (II)V
    //   2599: aload_0
    //   2600: getfield calendar : Ljava/util/Calendar;
    //   2603: bipush #12
    //   2605: iload #10
    //   2607: invokevirtual set : (II)V
    //   2610: aload_0
    //   2611: getfield calendar : Ljava/util/Calendar;
    //   2614: bipush #13
    //   2616: iload #7
    //   2618: invokevirtual set : (II)V
    //   2621: aload_0
    //   2622: getfield calendar : Ljava/util/Calendar;
    //   2625: bipush #14
    //   2627: iload_3
    //   2628: invokevirtual set : (II)V
    //   2631: aload_0
    //   2632: iconst_5
    //   2633: putfield token : I
    //   2636: iconst_1
    //   2637: ireturn
  }
  
  public final int scanInt(char paramChar) {
    boolean bool;
    this.matchStat = 0;
    int i = this.bp;
    int j = i + 1;
    char c = charAt(i);
    if (c == '-') {
      bool = true;
    } else {
      bool = false;
    } 
    i = j;
    if (bool) {
      c = charAt(j);
      i = j + 1;
    } 
    if (c >= '0' && c <= '9') {
      int k;
      c -= '0';
      j = i;
      i = c;
      while (true) {
        k = j + 1;
        j = charAt(j);
        if (j >= 48 && j <= 57) {
          i = i * 10 + j - 48;
          j = k;
          continue;
        } 
        break;
      } 
      if (j == 46) {
        this.matchStat = -1;
        return 0;
      } 
      int m = j;
      if (i < 0) {
        this.matchStat = -1;
        return 0;
      } 
      while (true) {
        if (m == paramChar) {
          this.bp = k;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          this.token = 16;
          int i1 = i;
          if (bool)
            i1 = -i; 
          return i1;
        } 
        if (isWhitespace(m)) {
          j = charAt(k);
          k++;
          m = j;
          continue;
        } 
        this.matchStat = -1;
        int n = i;
        if (bool)
          n = -i; 
        return n;
      } 
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public long scanLong(char paramChar) {
    boolean bool = false;
    this.matchStat = 0;
    int i = this.bp;
    int j = i + 1;
    char c = charAt(i);
    if (c == '-')
      bool = true; 
    i = j;
    if (bool) {
      c = charAt(j);
      i = j + 1;
    } 
    if (c >= '0' && c <= '9') {
      long l = (c - 48);
      int k = i;
      while (true) {
        i = k + 1;
        k = charAt(k);
        if (k >= 48 && k <= 57) {
          l = l * 10L + (k - 48);
          k = i;
          continue;
        } 
        break;
      } 
      if (k == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      int m = k;
      if (l < 0L) {
        this.matchStat = -1;
        return 0L;
      } 
      while (true) {
        if (m == paramChar) {
          this.bp = i;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          this.token = 16;
          long l1 = l;
          if (bool)
            l1 = -l; 
          return l1;
        } 
        if (isWhitespace(m)) {
          k = charAt(i);
          i++;
          m = k;
          continue;
        } 
        this.matchStat = -1;
        return l;
      } 
    } 
    this.matchStat = -1;
    return 0L;
  }
  
  protected void setTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6) {
    this.calendar.set(11, (paramChar1 - 48) * 10 + paramChar2 - 48);
    this.calendar.set(12, (paramChar3 - 48) * 10 + paramChar4 - 48);
    this.calendar.set(13, (paramChar5 - 48) * 10 + paramChar6 - 48);
  }
  
  protected void setTimeZone(char paramChar1, char paramChar2, char paramChar3) {
    int j = ((paramChar2 - 48) * 10 + paramChar3 - 48) * 3600 * 1000;
    int i = j;
    if (paramChar1 == '-')
      i = -j; 
    if (this.calendar.getTimeZone().getRawOffset() != i) {
      String[] arrayOfString = TimeZone.getAvailableIDs(i);
      if (arrayOfString.length > 0) {
        TimeZone timeZone = TimeZone.getTimeZone(arrayOfString[0]);
        this.calendar.setTimeZone(timeZone);
      } 
    } 
  }
  
  public final String stringVal() {
    return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2) {
    if (ASMUtils.IS_ANDROID) {
      if (paramInt2 < this.sbuf.length) {
        this.text.getChars(paramInt1, paramInt1 + paramInt2, this.sbuf, 0);
        return new String(this.sbuf, 0, paramInt2);
      } 
      char[] arrayOfChar = new char[paramInt2];
      this.text.getChars(paramInt1, paramInt2 + paramInt1, arrayOfChar, 0);
      return new String(arrayOfChar);
    } 
    return this.text.substring(paramInt1, paramInt2 + paramInt1);
  }
  
  public final char[] sub_chars(int paramInt1, int paramInt2) {
    if (ASMUtils.IS_ANDROID && paramInt2 < this.sbuf.length) {
      this.text.getChars(paramInt1, paramInt2 + paramInt1, this.sbuf, 0);
      return this.sbuf;
    } 
    char[] arrayOfChar = new char[paramInt2];
    this.text.getChars(paramInt1, paramInt2 + paramInt1, arrayOfChar, 0);
    return arrayOfChar;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\JSONScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
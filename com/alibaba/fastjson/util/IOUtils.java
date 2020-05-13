package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

public class IOUtils {
  public static final char[] ASCII_CHARS;
  
  public static final char[] CA;
  
  public static final Properties DEFAULT_PROPERTIES = new Properties();
  
  public static final char[] DIGITS;
  
  static final char[] DigitOnes;
  
  static final char[] DigitTens;
  
  public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
  
  public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
  
  public static final String FASTJSON_PROPERTIES = "fastjson.properties";
  
  public static final int[] IA;
  
  public static final Charset UTF8 = Charset.forName("UTF-8");
  
  static final char[] digits;
  
  public static final boolean[] firstIdentifierFlags;
  
  public static final boolean[] identifierFlags;
  
  public static final char[] replaceChars;
  
  static final int[] sizeTable;
  
  public static final byte[] specicalFlags_doubleQuotes;
  
  public static final boolean[] specicalFlags_doubleQuotesFlags;
  
  public static final byte[] specicalFlags_singleQuotes;
  
  public static final boolean[] specicalFlags_singleQuotesFlags;
  
  static {
    DIGITS = new char[] { 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F' };
    firstIdentifierFlags = new boolean[256];
    char c;
    for (c = Character.MIN_VALUE; c < firstIdentifierFlags.length; c = (char)(c + 1)) {
      if (c >= 'A' && c <= 'Z') {
        firstIdentifierFlags[c] = true;
      } else if (c >= 'a' && c <= 'z') {
        firstIdentifierFlags[c] = true;
      } else if (c == '_') {
        firstIdentifierFlags[c] = true;
      } 
    } 
    identifierFlags = new boolean[256];
    for (c = Character.MIN_VALUE; c < identifierFlags.length; c = (char)(c + 1)) {
      if (c >= 'A' && c <= 'Z') {
        identifierFlags[c] = true;
      } else if (c >= 'a' && c <= 'z') {
        identifierFlags[c] = true;
      } else if (c == '_') {
        identifierFlags[c] = true;
      } else if (c >= '0' && c <= '9') {
        identifierFlags[c] = true;
      } 
    } 
    try {
      loadPropertiesFromFile();
    } catch (Throwable throwable) {}
    specicalFlags_doubleQuotes = new byte[161];
    specicalFlags_singleQuotes = new byte[161];
    specicalFlags_doubleQuotesFlags = new boolean[161];
    specicalFlags_singleQuotesFlags = new boolean[161];
    replaceChars = new char[93];
    specicalFlags_doubleQuotes[0] = (byte)4;
    specicalFlags_doubleQuotes[1] = (byte)4;
    specicalFlags_doubleQuotes[2] = (byte)4;
    specicalFlags_doubleQuotes[3] = (byte)4;
    specicalFlags_doubleQuotes[4] = (byte)4;
    specicalFlags_doubleQuotes[5] = (byte)4;
    specicalFlags_doubleQuotes[6] = (byte)4;
    specicalFlags_doubleQuotes[7] = (byte)4;
    specicalFlags_doubleQuotes[8] = (byte)1;
    specicalFlags_doubleQuotes[9] = (byte)1;
    specicalFlags_doubleQuotes[10] = (byte)1;
    specicalFlags_doubleQuotes[11] = (byte)4;
    specicalFlags_doubleQuotes[12] = (byte)1;
    specicalFlags_doubleQuotes[13] = (byte)1;
    specicalFlags_doubleQuotes[34] = (byte)1;
    specicalFlags_doubleQuotes[92] = (byte)1;
    specicalFlags_singleQuotes[0] = (byte)4;
    specicalFlags_singleQuotes[1] = (byte)4;
    specicalFlags_singleQuotes[2] = (byte)4;
    specicalFlags_singleQuotes[3] = (byte)4;
    specicalFlags_singleQuotes[4] = (byte)4;
    specicalFlags_singleQuotes[5] = (byte)4;
    specicalFlags_singleQuotes[6] = (byte)4;
    specicalFlags_singleQuotes[7] = (byte)4;
    specicalFlags_singleQuotes[8] = (byte)1;
    specicalFlags_singleQuotes[9] = (byte)1;
    specicalFlags_singleQuotes[10] = (byte)1;
    specicalFlags_singleQuotes[11] = (byte)4;
    specicalFlags_singleQuotes[12] = (byte)1;
    specicalFlags_singleQuotes[13] = (byte)1;
    specicalFlags_singleQuotes[92] = (byte)1;
    specicalFlags_singleQuotes[39] = (byte)1;
    for (c = '\016'; c <= '\037'; c++) {
      specicalFlags_doubleQuotes[c] = (byte)4;
      specicalFlags_singleQuotes[c] = (byte)4;
    } 
    for (c = ''; c < ' '; c++) {
      specicalFlags_doubleQuotes[c] = (byte)4;
      specicalFlags_singleQuotes[c] = (byte)4;
    } 
    for (c = Character.MIN_VALUE; c < '¡'; c++) {
      boolean bool;
      boolean[] arrayOfBoolean = specicalFlags_doubleQuotesFlags;
      if (specicalFlags_doubleQuotes[c] != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayOfBoolean[c] = bool;
      arrayOfBoolean = specicalFlags_singleQuotesFlags;
      if (specicalFlags_singleQuotes[c] != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayOfBoolean[c] = bool;
    } 
    replaceChars[0] = (char)'0';
    replaceChars[1] = (char)'1';
    replaceChars[2] = (char)'2';
    replaceChars[3] = (char)'3';
    replaceChars[4] = (char)'4';
    replaceChars[5] = (char)'5';
    replaceChars[6] = (char)'6';
    replaceChars[7] = (char)'7';
    replaceChars[8] = (char)'b';
    replaceChars[9] = (char)'t';
    replaceChars[10] = (char)'n';
    replaceChars[11] = (char)'v';
    replaceChars[12] = (char)'f';
    replaceChars[13] = (char)'r';
    replaceChars[34] = (char)'"';
    replaceChars[39] = (char)'\'';
    replaceChars[47] = (char)'/';
    replaceChars[92] = (char)'\\';
    ASCII_CHARS = new char[] { 
        '0', '0', '0', '1', '0', '2', '0', '3', '0', '4', 
        '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', 
        '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', 
        '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', 
        '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', 
        '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', 
        '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', 
        '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', 
        '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', 
        '2', 'D', '2', 'E', '2', 'F' };
    digits = new char[] { 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
        'u', 'v', 'w', 'x', 'y', 'z' };
    DigitTens = new char[] { 
        '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 
        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', 
        '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', 
        '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', 
        '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', 
        '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', 
        '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', 
        '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', 
        '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', 
        '9', '9', '9', '9', '9', '9', '9', '9', '9', '9' };
    DigitOnes = new char[] { 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    sizeTable = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
    CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    IA = new int[256];
    Arrays.fill(IA, -1);
    int i = CA.length;
    for (c = Character.MIN_VALUE; c < i; c++)
      IA[CA[c]] = c; 
    IA[61] = 0;
  }
  
  public static void close(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (Exception exception) {} 
  }
  
  public static void decode(CharsetDecoder paramCharsetDecoder, ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer) {
    try {
      CoderResult coderResult2 = paramCharsetDecoder.decode(paramByteBuffer, paramCharBuffer, true);
      if (!coderResult2.isUnderflow())
        coderResult2.throwException(); 
      CoderResult coderResult1 = paramCharsetDecoder.flush(paramCharBuffer);
      if (!coderResult1.isUnderflow())
        coderResult1.throwException(); 
      return;
    } catch (CharacterCodingException characterCodingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("utf8 decode error, ");
      stringBuilder.append(characterCodingException.getMessage());
      throw new JSONException(stringBuilder.toString(), characterCodingException);
    } 
  }
  
  public static byte[] decodeBase64(String paramString) {
    int m;
    byte b;
    int i = paramString.length();
    boolean bool = false;
    if (i == 0)
      return new byte[0]; 
    int j = i - 1;
    int k = 0;
    while (true) {
      m = j;
      if (k < j) {
        m = j;
        if (IA[paramString.charAt(k) & 0xFF] < 0) {
          k++;
          continue;
        } 
      } 
      break;
    } 
    while (m > 0 && IA[paramString.charAt(m) & 0xFF] < 0)
      m--; 
    if (paramString.charAt(m) == '=') {
      if (paramString.charAt(m - 1) == '=') {
        j = 2;
      } else {
        j = 1;
      } 
    } else {
      j = 0;
    } 
    int n = m - k + 1;
    if (i > 76) {
      if (paramString.charAt(76) == '\r') {
        i = n / 78;
      } else {
        i = 0;
      } 
      b = i << 1;
    } else {
      b = 0;
    } 
    int i1 = ((n - b) * 6 >> 3) - j;
    byte[] arrayOfByte = new byte[i1];
    int i2 = i1 / 3;
    int i3 = 0;
    i = 0;
    n = k;
    for (k = i3; k < i2 * 3; k = i3 + 1) {
      int[] arrayOfInt = IA;
      int i4 = n + 1;
      i3 = arrayOfInt[paramString.charAt(n)];
      arrayOfInt = IA;
      n = i4 + 1;
      i4 = arrayOfInt[paramString.charAt(i4)];
      arrayOfInt = IA;
      int i5 = n + 1;
      int i6 = arrayOfInt[paramString.charAt(n)];
      arrayOfInt = IA;
      n = i5 + 1;
      i4 = i3 << 18 | i4 << 12 | i6 << 6 | arrayOfInt[paramString.charAt(i5)];
      i5 = k + 1;
      arrayOfByte[k] = (byte)(byte)(i4 >> 16);
      i3 = i5 + 1;
      arrayOfByte[i5] = (byte)(byte)(i4 >> 8);
      arrayOfByte[i3] = (byte)(byte)i4;
      k = i;
      if (b > 0) {
        k = ++i;
        if (i == 19) {
          n += 2;
          i = 0;
          continue;
        } 
      } 
      i = k;
      continue;
    } 
    if (k < i1) {
      b = 0;
      i = bool;
      while (n <= m - j) {
        i |= IA[paramString.charAt(n)] << 18 - b * 6;
        b++;
        n++;
      } 
      j = 16;
      while (k < i1) {
        arrayOfByte[k] = (byte)(byte)(i >> j);
        j -= 8;
        k++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static byte[] decodeBase64(String paramString, int paramInt1, int paramInt2) {
    int k;
    byte b;
    boolean bool = false;
    if (paramInt2 == 0)
      return new byte[0]; 
    int i = paramInt1 + paramInt2 - 1;
    int j = paramInt1;
    while (true) {
      k = i;
      if (j < i) {
        k = i;
        if (IA[paramString.charAt(j)] < 0) {
          j++;
          continue;
        } 
      } 
      break;
    } 
    while (k > 0 && IA[paramString.charAt(k)] < 0)
      k--; 
    if (paramString.charAt(k) == '=') {
      if (paramString.charAt(k - 1) == '=') {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      } 
    } else {
      paramInt1 = 0;
    } 
    i = k - j + 1;
    if (paramInt2 > 76) {
      if (paramString.charAt(76) == '\r') {
        paramInt2 = i / 78;
      } else {
        paramInt2 = 0;
      } 
      b = paramInt2 << 1;
    } else {
      b = 0;
    } 
    int m = ((i - b) * 6 >> 3) - paramInt1;
    byte[] arrayOfByte = new byte[m];
    int n = m / 3;
    i = j;
    paramInt2 = 0;
    j = 0;
    while (paramInt2 < n * 3) {
      int[] arrayOfInt = IA;
      int i1 = i + 1;
      int i2 = arrayOfInt[paramString.charAt(i)];
      arrayOfInt = IA;
      i = i1 + 1;
      int i3 = arrayOfInt[paramString.charAt(i1)];
      arrayOfInt = IA;
      i1 = i + 1;
      int i4 = arrayOfInt[paramString.charAt(i)];
      arrayOfInt = IA;
      i = i1 + 1;
      i3 = i2 << 18 | i3 << 12 | i4 << 6 | arrayOfInt[paramString.charAt(i1)];
      i1 = paramInt2 + 1;
      arrayOfByte[paramInt2] = (byte)(byte)(i3 >> 16);
      i2 = i1 + 1;
      arrayOfByte[i1] = (byte)(byte)(i3 >> 8);
      arrayOfByte[i2] = (byte)(byte)i3;
      paramInt2 = j;
      if (b > 0) {
        paramInt2 = ++j;
        if (j == 19) {
          i += 2;
          paramInt2 = 0;
        } 
      } 
      i2++;
      j = paramInt2;
      paramInt2 = i2;
    } 
    if (paramInt2 < m) {
      b = 0;
      j = bool;
      while (i <= k - paramInt1) {
        j |= IA[paramString.charAt(i)] << 18 - b * 6;
        b++;
        i++;
      } 
      paramInt1 = 16;
      while (paramInt2 < m) {
        arrayOfByte[paramInt2] = (byte)(byte)(j >> paramInt1);
        paramInt1 -= 8;
        paramInt2++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static byte[] decodeBase64(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    int k;
    byte b;
    boolean bool = false;
    if (paramInt2 == 0)
      return new byte[0]; 
    int i = paramInt1 + paramInt2 - 1;
    int j = paramInt1;
    while (true) {
      k = i;
      if (j < i) {
        k = i;
        if (IA[paramArrayOfchar[j]] < 0) {
          j++;
          continue;
        } 
      } 
      break;
    } 
    while (k > 0 && IA[paramArrayOfchar[k]] < 0)
      k--; 
    if (paramArrayOfchar[k] == '=') {
      if (paramArrayOfchar[k - 1] == '=') {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      } 
    } else {
      paramInt1 = 0;
    } 
    i = k - j + 1;
    if (paramInt2 > 76) {
      if (paramArrayOfchar[76] == '\r') {
        paramInt2 = i / 78;
      } else {
        paramInt2 = 0;
      } 
      b = paramInt2 << 1;
    } else {
      b = 0;
    } 
    int m = ((i - b) * 6 >> 3) - paramInt1;
    byte[] arrayOfByte = new byte[m];
    int n = m / 3;
    i = j;
    paramInt2 = 0;
    j = 0;
    while (paramInt2 < n * 3) {
      int[] arrayOfInt = IA;
      int i1 = i + 1;
      int i2 = arrayOfInt[paramArrayOfchar[i]];
      arrayOfInt = IA;
      i = i1 + 1;
      int i3 = arrayOfInt[paramArrayOfchar[i1]];
      arrayOfInt = IA;
      i1 = i + 1;
      int i4 = arrayOfInt[paramArrayOfchar[i]];
      arrayOfInt = IA;
      i = i1 + 1;
      i3 = i2 << 18 | i3 << 12 | i4 << 6 | arrayOfInt[paramArrayOfchar[i1]];
      i1 = paramInt2 + 1;
      arrayOfByte[paramInt2] = (byte)(byte)(i3 >> 16);
      i2 = i1 + 1;
      arrayOfByte[i1] = (byte)(byte)(i3 >> 8);
      arrayOfByte[i2] = (byte)(byte)i3;
      paramInt2 = j;
      if (b > 0) {
        paramInt2 = ++j;
        if (j == 19) {
          i += 2;
          j = 0;
          continue;
        } 
      } 
      j = paramInt2;
      continue;
      paramInt2 = SYNTHETIC_LOCAL_VARIABLE_13 + 1;
    } 
    if (paramInt2 < m) {
      b = 0;
      j = bool;
      while (i <= k - paramInt1) {
        j |= IA[paramArrayOfchar[i]] << 18 - b * 6;
        b++;
        i++;
      } 
      paramInt1 = 16;
      while (paramInt2 < m) {
        arrayOfByte[paramInt2] = (byte)(byte)(j >> paramInt1);
        paramInt1 -= 8;
        paramInt2++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static int decodeUTF8(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    int i = paramInt1 + paramInt2;
    int j = Math.min(paramInt2, paramArrayOfchar.length);
    int k = 0;
    int m = paramInt1;
    while (true) {
      paramInt2 = m;
      paramInt1 = k;
      if (k < j) {
        paramInt2 = m;
        paramInt1 = k;
        if (paramArrayOfbyte[m] >= 0) {
          paramArrayOfchar[k] = (char)(char)paramArrayOfbyte[m];
          k++;
          m++;
          continue;
        } 
      } 
      break;
    } 
    while (paramInt2 < i) {
      k = paramInt2 + 1;
      paramInt2 = paramArrayOfbyte[paramInt2];
      if (paramInt2 >= 0) {
        paramArrayOfchar[paramInt1] = (char)(char)paramInt2;
        paramInt2 = k;
        paramInt1++;
        continue;
      } 
      if (paramInt2 >> 5 == -2 && (paramInt2 & 0x1E) != 0) {
        if (k < i) {
          m = paramArrayOfbyte[k];
          if ((m & 0xC0) != 128)
            return -1; 
          paramArrayOfchar[paramInt1] = (char)(char)(m ^ paramInt2 << 6 ^ 0xF80);
          paramInt2 = k + 1;
          paramInt1++;
          continue;
        } 
        return -1;
      } 
      if (paramInt2 >> 4 == -2) {
        m = k + 1;
        if (m < i) {
          k = paramArrayOfbyte[k];
          j = paramArrayOfbyte[m];
          if ((paramInt2 == -32 && (k & 0xE0) == 128) || (k & 0xC0) != 128 || (j & 0xC0) != 128)
            return -1; 
          k = (char)(k << 6 ^ paramInt2 << 12 ^ 0xFFFE1F80 ^ j);
          if (k >= 55296 && k < 57344) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          } 
          if (paramInt2 != 0)
            return -1; 
          paramArrayOfchar[paramInt1] = (char)k;
          paramInt1++;
          paramInt2 = m + 1;
          continue;
        } 
        return -1;
      } 
      if (paramInt2 >> 3 == -2) {
        if (k + 2 < i) {
          j = k + 1;
          m = paramArrayOfbyte[k];
          k = j + 1;
          byte b = paramArrayOfbyte[j];
          j = paramArrayOfbyte[k];
          paramInt2 = paramInt2 << 18 ^ m << 12 ^ b << 6 ^ 0x381F80 ^ j;
          if ((m & 0xC0) != 128 || (b & 0xC0) != 128 || (j & 0xC0) != 128 || !Character.isSupplementaryCodePoint(paramInt2))
            return -1; 
          m = paramInt1 + 1;
          paramArrayOfchar[paramInt1] = (char)(char)((paramInt2 >>> 10) + 55232);
          paramInt1 = m + 1;
          paramArrayOfchar[m] = (char)(char)((paramInt2 & 0x3FF) + 56320);
          paramInt2 = k + 1;
          continue;
        } 
        return -1;
      } 
      return -1;
    } 
    return paramInt1;
  }
  
  public static int encodeUTF8(char[] paramArrayOfchar, int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    int m;
    int i = paramInt1 + paramInt2;
    int j = Math.min(paramInt2, paramArrayOfbyte.length);
    int k = 0;
    while (true) {
      paramInt2 = k;
      m = paramInt1;
      if (k < j + 0) {
        paramInt2 = k;
        m = paramInt1;
        if (paramArrayOfchar[paramInt1] < '') {
          paramArrayOfbyte[k] = (byte)(byte)paramArrayOfchar[paramInt1];
          k++;
          paramInt1++;
          continue;
        } 
      } 
      break;
    } 
    while (true) {
      if (m < i) {
        paramInt1 = m + 1;
        char c = paramArrayOfchar[m];
        if (c < '') {
          k = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)(byte)c;
          paramInt2 = k;
        } else {
          if (c < 'ࠀ') {
            k = paramInt2 + 1;
            paramArrayOfbyte[paramInt2] = (byte)(byte)(c >> 6 | 0xC0);
            paramInt2 = k + 1;
            paramArrayOfbyte[k] = (byte)(byte)(c & 0x3F | 0x80);
          } else if (c >= '?' && c < '') {
            k = paramInt1 - 1;
            if (Character.isHighSurrogate(c)) {
              if (i - k < 2) {
                k = -1;
              } else {
                char c1 = paramArrayOfchar[k + 1];
                if (Character.isLowSurrogate(c1)) {
                  k = Character.toCodePoint(c, c1);
                } else {
                  throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                } 
              } 
            } else if (!Character.isLowSurrogate(c)) {
              k = c;
            } else {
              throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
            } 
            if (k < 0) {
              k = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)63;
              paramInt2 = k;
            } else {
              m = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)(byte)(k >> 18 | 0xF0);
              paramInt2 = m + 1;
              paramArrayOfbyte[m] = (byte)(byte)(k >> 12 & 0x3F | 0x80);
              m = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)(byte)(0x3F & k >> 6 | 0x80);
              paramArrayOfbyte[m] = (byte)(byte)(k & 0x3F | 0x80);
              paramInt1++;
              paramInt2 = m + 1;
            } 
          } else {
            k = paramInt2 + 1;
            paramArrayOfbyte[paramInt2] = (byte)(byte)(c >> 12 | 0xE0);
            m = k + 1;
            paramArrayOfbyte[k] = (byte)(byte)(0x3F & c >> 6 | 0x80);
            paramInt2 = m + 1;
            paramArrayOfbyte[m] = (byte)(byte)(c & 0x3F | 0x80);
            m = paramInt1;
          } 
          m = paramInt1;
          continue;
        } 
      } else {
        break;
      } 
      m = paramInt1;
    } 
    return paramInt2;
  }
  
  public static boolean firstIdentifier(char paramChar) {
    boolean bool;
    if (paramChar < firstIdentifierFlags.length && firstIdentifierFlags[paramChar]) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static void getChars(byte paramByte, int paramInt, char[] paramArrayOfchar) {
    boolean bool;
    if (paramByte < 0) {
      bool = true;
      paramByte = -paramByte;
    } else {
      bool = false;
    } 
    while (true) {
      int j = 52429 * paramByte >>> 19;
      paramArrayOfchar[--paramInt] = (char)digits[paramByte - (j << 3) + (j << 1)];
      if (j == 0) {
        if (bool)
          paramArrayOfchar[paramInt - 1] = (char)bool; 
        return;
      } 
      int i = j;
    } 
  }
  
  public static void getChars(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    boolean bool;
    int i;
    int j;
    if (paramInt1 < 0) {
      bool = true;
      paramInt1 = -paramInt1;
    } else {
      bool = false;
    } 
    while (true) {
      i = paramInt1;
      j = paramInt2;
      if (paramInt1 >= 65536) {
        i = paramInt1 / 100;
        paramInt1 -= (i << 6) + (i << 5) + (i << 2);
        paramArrayOfchar[--paramInt2] = (char)DigitOnes[paramInt1];
        paramArrayOfchar[--paramInt2] = (char)DigitTens[paramInt1];
        paramInt1 = i;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt1 = 52429 * i >>> 19;
      paramArrayOfchar[--j] = (char)digits[i - (paramInt1 << 3) + (paramInt1 << 1)];
      if (paramInt1 == 0) {
        if (bool)
          paramArrayOfchar[j - 1] = (char)bool; 
        return;
      } 
      i = paramInt1;
    } 
  }
  
  public static void getChars(long paramLong, int paramInt, char[] paramArrayOfchar) {
    boolean bool;
    int j;
    int k;
    if (paramLong < 0L) {
      bool = true;
      paramLong = -paramLong;
    } else {
      bool = false;
    } 
    while (paramLong > 2147483647L) {
      long l = paramLong / 100L;
      int m = (int)(paramLong - (l << 6L) + (l << 5L) + (l << 2L));
      paramArrayOfchar[--paramInt] = (char)DigitOnes[m];
      paramArrayOfchar[--paramInt] = (char)DigitTens[m];
      paramLong = l;
    } 
    int i = (int)paramLong;
    while (true) {
      j = i;
      k = paramInt;
      if (i >= 65536) {
        j = i / 100;
        i -= (j << 6) + (j << 5) + (j << 2);
        paramArrayOfchar[--paramInt] = (char)DigitOnes[i];
        paramArrayOfchar[--paramInt] = (char)DigitTens[i];
        i = j;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt = 52429 * j >>> 19;
      paramArrayOfchar[--k] = (char)digits[j - (paramInt << 3) + (paramInt << 1)];
      if (paramInt == 0) {
        if (bool)
          paramArrayOfchar[k - 1] = (char)bool; 
        return;
      } 
      j = paramInt;
    } 
  }
  
  public static String getStringProperty(String paramString) {
    String str;
    try {
      String str1 = System.getProperty(paramString);
    } catch (SecurityException securityException1) {
      securityException1 = null;
    } 
    SecurityException securityException2 = securityException1;
    if (securityException1 == null)
      str = DEFAULT_PROPERTIES.getProperty(paramString); 
    return str;
  }
  
  public static boolean isIdent(char paramChar) {
    boolean bool;
    if (paramChar < identifierFlags.length && identifierFlags[paramChar]) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static void loadPropertiesFromFile() {
    InputStream inputStream = AccessController.<InputStream>doPrivileged(new PrivilegedAction<InputStream>() {
          public InputStream run() {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            return (classLoader != null) ? classLoader.getResourceAsStream("fastjson.properties") : ClassLoader.getSystemResourceAsStream("fastjson.properties");
          }
        });
    if (inputStream != null)
      try {
        DEFAULT_PROPERTIES.load(inputStream);
        inputStream.close();
      } catch (IOException iOException) {} 
  }
  
  public static String readAll(Reader paramReader) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      char[] arrayOfChar = new char[2048];
      while (true) {
        int i = paramReader.read(arrayOfChar, 0, arrayOfChar.length);
        if (i < 0)
          return stringBuilder.toString(); 
        stringBuilder.append(arrayOfChar, 0, i);
      } 
    } catch (Exception exception) {
      throw new JSONException("read string from reader error", exception);
    } 
  }
  
  public static int stringSize(int paramInt) {
    for (byte b = 0;; b++) {
      if (paramInt <= sizeTable[b])
        return b + 1; 
    } 
  }
  
  public static int stringSize(long paramLong) {
    byte b = 1;
    long l = 10L;
    while (b < 19) {
      if (paramLong < l)
        return b; 
      l *= 10L;
      b++;
    } 
    return 19;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
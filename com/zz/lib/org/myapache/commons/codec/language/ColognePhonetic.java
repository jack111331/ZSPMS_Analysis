package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;
import java.util.Locale;

public class ColognePhonetic implements StringEncoder {
  private static final char[][] PREPROCESS_MAP;
  
  static {
    char[] arrayOfChar1 = { 'Ä', 'A' };
    char[] arrayOfChar2 = { 'Ö', 'O' };
    char[] arrayOfChar3 = { 'ß', 'S' };
    PREPROCESS_MAP = new char[][] { arrayOfChar1, { 'Ü', 'U' }, arrayOfChar2, arrayOfChar3 };
  }
  
  private static boolean arrayContains(char[] paramArrayOfchar, char paramChar) {
    boolean bool = false;
    int i = paramArrayOfchar.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        if (paramArrayOfchar[b] == paramChar)
          return true; 
        b++;
        continue;
      } 
      return bool;
    } 
  }
  
  private String preprocess(String paramString) {
    char[] arrayOfChar = paramString.toUpperCase(Locale.GERMAN).toCharArray();
    byte b = 0;
    label17: while (true) {
      if (b >= arrayOfChar.length)
        return new String(arrayOfChar); 
      if (arrayOfChar[b] > 'Z') {
        char[][] arrayOfChar1 = PREPROCESS_MAP;
        int i = arrayOfChar1.length;
        byte b1 = 0;
        while (true) {
          if (b1 < i) {
            char[] arrayOfChar2 = arrayOfChar1[b1];
            if (arrayOfChar[b] == arrayOfChar2[0]) {
              arrayOfChar[b] = (char)arrayOfChar2[1];
            } else {
              b1++;
              continue;
            } 
          } 
          b++;
          continue label17;
        } 
        break;
      } 
      continue;
    } 
  }
  
  public String colognePhonetic(String paramString) {
    if (paramString == null)
      return null; 
    String str = preprocess(paramString);
    CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(str.length() * 2);
    CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(str.toCharArray());
    int i = 45;
    int j = 47;
    int k = cologneInputBuffer.length();
    for (int m = i;; m = i) {
      int n;
      if (k <= 0)
        return cologneOutputBuffer.toString(); 
      char c = cologneInputBuffer.removeNext();
      i = cologneInputBuffer.length();
      if (i > 0) {
        k = cologneInputBuffer.getNextChar();
        n = k;
      } else {
        k = 45;
        n = k;
      } 
      if (arrayContains(new char[] { 'A', 'E', 'I', 'J', 'O', 'U', 'Y' }, c)) {
        byte b = 48;
        k = i;
        n = b;
      } else if (c == 'H' || c < 'A' || c > 'Z') {
        k = i;
        if (j != 47) {
          k = 45;
          n = k;
          k = i;
        } else {
          continue;
        } 
      } else if (c == 'B' || (c == 'P' && n != 72)) {
        k = 49;
        n = k;
        k = i;
      } else if ((c == 'D' || c == 'T') && !arrayContains(new char[] { 'S', 'C', 'Z' }, n)) {
        k = 50;
        n = k;
        k = i;
      } else if (arrayContains(new char[] { 'W', 'F', 'P', 'V' }, c)) {
        k = 51;
        n = k;
        k = i;
      } else if (arrayContains(new char[] { 'G', 'K', 'Q' }, c)) {
        k = 52;
        n = k;
        k = i;
      } else if (c == 'X' && !arrayContains(new char[] { 'C', 'K', 'Q' }, m)) {
        byte b = 52;
        cologneInputBuffer.addLeft('S');
        k = i + 1;
        n = b;
      } else if (c == 'S' || c == 'Z') {
        k = 56;
        n = k;
        k = i;
      } else if (c == 'C') {
        if (j == 47) {
          if (arrayContains(new char[] { 'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X' }, n)) {
            k = 52;
            n = k;
            k = i;
          } else {
            k = 56;
            n = k;
            k = i;
          } 
        } else if (arrayContains(new char[] { 'S', 'Z' }, m) || !arrayContains(new char[] { 'A', 'H', 'O', 'U', 'K', 'Q', 'X' }, n)) {
          k = 56;
          n = k;
          k = i;
        } else {
          k = 52;
          n = k;
          k = i;
        } 
      } else if (arrayContains(new char[] { 'T', 'D', 'X' }, c)) {
        k = 56;
        n = k;
        k = i;
      } else if (c == 'R') {
        k = 55;
        n = k;
        k = i;
      } else if (c == 'L') {
        k = 53;
        n = k;
        k = i;
      } else if (c == 'M' || c == 'N') {
        k = 54;
        n = k;
        k = i;
      } else {
        k = c;
        n = k;
        k = i;
      } 
      if (n != 45 && ((j != n && (n != 48 || j == 47)) || n < 48 || n > 56))
        cologneOutputBuffer.addRight(n); 
      i = c;
      j = n;
    } 
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + paramObject.getClass().getName() + "."); 
    return encode((String)paramObject);
  }
  
  public String encode(String paramString) {
    return colognePhonetic(paramString);
  }
  
  public boolean isEncodeEqual(String paramString1, String paramString2) {
    return colognePhonetic(paramString1).equals(colognePhonetic(paramString2));
  }
  
  private abstract class CologneBuffer {
    protected final char[] data;
    
    protected int length = 0;
    
    public CologneBuffer(int param1Int) {
      this.data = new char[param1Int];
      this.length = 0;
    }
    
    public CologneBuffer(char[] param1ArrayOfchar) {
      this.data = param1ArrayOfchar;
      this.length = param1ArrayOfchar.length;
    }
    
    protected abstract char[] copyData(int param1Int1, int param1Int2);
    
    public int length() {
      return this.length;
    }
    
    public String toString() {
      return new String(copyData(0, this.length));
    }
  }
  
  private class CologneInputBuffer extends CologneBuffer {
    public CologneInputBuffer(char[] param1ArrayOfchar) {
      super(param1ArrayOfchar);
    }
    
    public void addLeft(char param1Char) {
      this.length++;
      this.data[getNextPos()] = (char)param1Char;
    }
    
    protected char[] copyData(int param1Int1, int param1Int2) {
      char[] arrayOfChar = new char[param1Int2];
      System.arraycopy(this.data, this.data.length - this.length + param1Int1, arrayOfChar, 0, param1Int2);
      return arrayOfChar;
    }
    
    public char getNextChar() {
      return this.data[getNextPos()];
    }
    
    protected int getNextPos() {
      return this.data.length - this.length;
    }
    
    public char removeNext() {
      char c = getNextChar();
      this.length--;
      return c;
    }
  }
  
  private class CologneOutputBuffer extends CologneBuffer {
    public CologneOutputBuffer(int param1Int) {
      super(param1Int);
    }
    
    public void addRight(char param1Char) {
      this.data[this.length] = (char)param1Char;
      this.length++;
    }
    
    protected char[] copyData(int param1Int1, int param1Int2) {
      char[] arrayOfChar = new char[param1Int2];
      System.arraycopy(this.data, param1Int1, arrayOfChar, 0, param1Int2);
      return arrayOfChar;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\ColognePhonetic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
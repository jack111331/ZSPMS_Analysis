package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class DoubleMetaphone implements StringEncoder {
  protected int maxCodeLen;
  
  public DoubleMetaphone() {
    throw new RuntimeException("Stub!");
  }
  
  protected static boolean contains(String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString) {
    throw new RuntimeException("Stub!");
  }
  
  protected char charAt(String paramString, int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  public String doubleMetaphone(String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public String doubleMetaphone(String paramString, boolean paramBoolean) {
    throw new RuntimeException("Stub!");
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    throw new RuntimeException("Stub!");
  }
  
  public String encode(String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public int getMaxCodeLen() {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2) {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2, boolean paramBoolean) {
    throw new RuntimeException("Stub!");
  }
  
  public void setMaxCodeLen(int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  public class DoubleMetaphoneResult {
    public DoubleMetaphoneResult(int param1Int) {
      throw new RuntimeException("Stub!");
    }
    
    public void append(char param1Char) {
      throw new RuntimeException("Stub!");
    }
    
    public void append(char param1Char1, char param1Char2) {
      throw new RuntimeException("Stub!");
    }
    
    public void append(String param1String) {
      throw new RuntimeException("Stub!");
    }
    
    public void append(String param1String1, String param1String2) {
      throw new RuntimeException("Stub!");
    }
    
    public void appendAlternate(char param1Char) {
      throw new RuntimeException("Stub!");
    }
    
    public void appendAlternate(String param1String) {
      throw new RuntimeException("Stub!");
    }
    
    public void appendPrimary(char param1Char) {
      throw new RuntimeException("Stub!");
    }
    
    public void appendPrimary(String param1String) {
      throw new RuntimeException("Stub!");
    }
    
    public String getAlternate() {
      throw new RuntimeException("Stub!");
    }
    
    public String getPrimary() {
      throw new RuntimeException("Stub!");
    }
    
    public boolean isComplete() {
      throw new RuntimeException("Stub!");
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\commons\codec\language\DoubleMetaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
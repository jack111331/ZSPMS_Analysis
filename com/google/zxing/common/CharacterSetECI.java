package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI {
  ASCII,
  Big5,
  Cp1250,
  Cp1251,
  Cp1252,
  Cp1256,
  Cp437(new int[] { 0, 2 }, new String[0]),
  EUC_KR(new int[] { 0, 2 }, new String[0]),
  GB18030(new int[] { 0, 2 }, new String[0]),
  ISO8859_1(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_10(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_11(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_13(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_14(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_15(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_16(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  ISO8859_2(4, new String[] { "ISO-8859-2" }),
  ISO8859_3(5, new String[] { "ISO-8859-3" }),
  ISO8859_4(6, new String[] { "ISO-8859-4" }),
  ISO8859_5(7, new String[] { "ISO-8859-5" }),
  ISO8859_6(8, new String[] { "ISO-8859-6" }),
  ISO8859_7(9, new String[] { "ISO-8859-7" }),
  ISO8859_8(10, new String[] { "ISO-8859-8" }),
  ISO8859_9(11, new String[] { "ISO-8859-9" }),
  SJIS(11, new String[] { "ISO-8859-9" }),
  UTF8(11, new String[] { "ISO-8859-9" }),
  UnicodeBigUnmarked(11, new String[] { "ISO-8859-9" });
  
  private static final Map<String, CharacterSetECI> NAME_TO_ECI;
  
  private static final Map<Integer, CharacterSetECI> VALUE_TO_ECI;
  
  private final String[] otherEncodingNames;
  
  private final int[] values;
  
  static {
    ISO8859_10 = new CharacterSetECI("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    ISO8859_11 = new CharacterSetECI("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    ISO8859_13 = new CharacterSetECI("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    ISO8859_14 = new CharacterSetECI("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    ISO8859_15 = new CharacterSetECI("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    ISO8859_16 = new CharacterSetECI("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    SJIS = new CharacterSetECI("SJIS", 16, 20, new String[] { "Shift_JIS" });
    Cp1250 = new CharacterSetECI("Cp1250", 17, 21, new String[] { "windows-1250" });
    Cp1251 = new CharacterSetECI("Cp1251", 18, 22, new String[] { "windows-1251" });
    Cp1252 = new CharacterSetECI("Cp1252", 19, 23, new String[] { "windows-1252" });
    Cp1256 = new CharacterSetECI("Cp1256", 20, 24, new String[] { "windows-1256" });
    UnicodeBigUnmarked = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    UTF8 = new CharacterSetECI("UTF8", 22, 26, new String[] { "UTF-8" });
    ASCII = new CharacterSetECI("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    Big5 = new CharacterSetECI("Big5", 24, 28);
    GB18030 = new CharacterSetECI("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    EUC_KR = new CharacterSetECI("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    $VALUES = new CharacterSetECI[] { 
        Cp437, ISO8859_1, ISO8859_2, ISO8859_3, ISO8859_4, ISO8859_5, ISO8859_6, ISO8859_7, ISO8859_8, ISO8859_9, 
        ISO8859_10, ISO8859_11, ISO8859_13, ISO8859_14, ISO8859_15, ISO8859_16, SJIS, Cp1250, Cp1251, Cp1252, 
        Cp1256, UnicodeBigUnmarked, UTF8, ASCII, Big5, GB18030, EUC_KR };
    VALUE_TO_ECI = new HashMap<Integer, CharacterSetECI>();
    NAME_TO_ECI = new HashMap<String, CharacterSetECI>();
    for (CharacterSetECI characterSetECI : values()) {
      for (int i : characterSetECI.values)
        VALUE_TO_ECI.put(Integer.valueOf(i), characterSetECI); 
      NAME_TO_ECI.put(characterSetECI.name(), characterSetECI);
      for (String str : characterSetECI.otherEncodingNames)
        NAME_TO_ECI.put(str, characterSetECI); 
    } 
  }
  
  CharacterSetECI(int paramInt1, String... paramVarArgs) {
    this.values = new int[] { paramInt1 };
    this.otherEncodingNames = paramVarArgs;
  }
  
  CharacterSetECI(int[] paramArrayOfint, String... paramVarArgs) {
    this.values = paramArrayOfint;
    this.otherEncodingNames = paramVarArgs;
  }
  
  public static CharacterSetECI getCharacterSetECIByName(String paramString) {
    return NAME_TO_ECI.get(paramString);
  }
  
  public static CharacterSetECI getCharacterSetECIByValue(int paramInt) throws FormatException {
    if (paramInt >= 0 && paramInt < 900)
      return VALUE_TO_ECI.get(Integer.valueOf(paramInt)); 
    throw FormatException.getFormatInstance();
  }
  
  public int getValue() {
    return this.values[0];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\CharacterSetECI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
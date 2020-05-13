package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

final class FieldParser {
  private static final Object[][] FOUR_DIGIT_DATA_LENGTH;
  
  private static final Object[][] THREE_DIGIT_DATA_LENGTH;
  
  private static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
  
  private static final Object[][] TWO_DIGIT_DATA_LENGTH;
  
  private static final Object VARIABLE_LENGTH = new Object();
  
  static {
    Object object1 = VARIABLE_LENGTH;
    Object object2 = VARIABLE_LENGTH;
    Object object3 = VARIABLE_LENGTH;
    Object object4 = VARIABLE_LENGTH;
    Object object5 = VARIABLE_LENGTH;
    Object object6 = VARIABLE_LENGTH;
    Object object7 = VARIABLE_LENGTH;
    Object object8 = VARIABLE_LENGTH;
    Object object9 = VARIABLE_LENGTH;
    Object object10 = VARIABLE_LENGTH;
    Object object11 = VARIABLE_LENGTH;
    Object object12 = VARIABLE_LENGTH;
    Object object13 = VARIABLE_LENGTH;
    Object object14 = VARIABLE_LENGTH;
    Object object15 = VARIABLE_LENGTH;
    TWO_DIGIT_DATA_LENGTH = new Object[][] { 
        { "00", Integer.valueOf(18) }, { "01", Integer.valueOf(14) }, { "02", Integer.valueOf(14) }, { "10", object1, Integer.valueOf(20) }, { "11", Integer.valueOf(6) }, { "12", Integer.valueOf(6) }, { "13", Integer.valueOf(6) }, { "15", Integer.valueOf(6) }, { "17", Integer.valueOf(6) }, { "20", Integer.valueOf(2) }, 
        { "21", object2, Integer.valueOf(20) }, { "22", object3, Integer.valueOf(29) }, { "30", object4, Integer.valueOf(8) }, { "37", object5, Integer.valueOf(8) }, { "90", object6, Integer.valueOf(30) }, { "91", object7, Integer.valueOf(30) }, { "92", object8, Integer.valueOf(30) }, { "93", object9, Integer.valueOf(30) }, { "94", object10, Integer.valueOf(30) }, { "95", object11, Integer.valueOf(30) }, 
        { "96", object12, Integer.valueOf(30) }, { "97", object13, Integer.valueOf(30) }, { "98", object14, Integer.valueOf(30) }, { "99", object15, Integer.valueOf(30) } };
    object8 = VARIABLE_LENGTH;
    object13 = VARIABLE_LENGTH;
    object1 = VARIABLE_LENGTH;
    object3 = VARIABLE_LENGTH;
    object2 = VARIABLE_LENGTH;
    object15 = VARIABLE_LENGTH;
    object14 = VARIABLE_LENGTH;
    object4 = new Object[] { "400", VARIABLE_LENGTH, Integer.valueOf(30) };
    object6 = VARIABLE_LENGTH;
    object12 = new Object[] { "402", Integer.valueOf(17) };
    object10 = VARIABLE_LENGTH;
    object7 = new Object[] { "410", Integer.valueOf(13) };
    object11 = new Object[] { "411", Integer.valueOf(13) };
    object9 = new Object[] { "420", VARIABLE_LENGTH, Integer.valueOf(20) };
    object5 = VARIABLE_LENGTH;
    Object[] arrayOfObject = { "423", VARIABLE_LENGTH, Integer.valueOf(15) };
    THREE_DIGIT_DATA_LENGTH = new Object[][] { 
        { "240", object8, Integer.valueOf(30) }, { "241", object13, Integer.valueOf(30) }, { "242", object1, Integer.valueOf(6) }, { "250", object3, Integer.valueOf(30) }, { "251", object2, Integer.valueOf(30) }, { "253", object15, Integer.valueOf(17) }, { "254", object14, Integer.valueOf(20) }, (Object[])object4, { "401", object6, Integer.valueOf(30) }, (Object[])object12, 
        { "403", object10, Integer.valueOf(30) }, (Object[])object7, (Object[])object11, { "412", Integer.valueOf(13) }, { "413", Integer.valueOf(13) }, { "414", Integer.valueOf(13) }, (Object[])object9, { "421", object5, Integer.valueOf(15) }, { "422", Integer.valueOf(3) }, arrayOfObject, 
        { "424", Integer.valueOf(3) }, { "425", Integer.valueOf(3) }, { "426", Integer.valueOf(3) } };
    object8 = new Object[] { "311", Integer.valueOf(6) };
    object14 = new Object[] { "313", Integer.valueOf(6) };
    object3 = new Object[] { "321", Integer.valueOf(6) };
    object5 = new Object[] { "327", Integer.valueOf(6) };
    object6 = new Object[] { "333", Integer.valueOf(6) };
    object10 = new Object[] { "344", Integer.valueOf(6) };
    object4 = new Object[] { "350", Integer.valueOf(6) };
    object12 = new Object[] { "356", Integer.valueOf(6) };
    object7 = new Object[] { "361", Integer.valueOf(6) };
    object13 = VARIABLE_LENGTH;
    object2 = VARIABLE_LENGTH;
    object15 = VARIABLE_LENGTH;
    object11 = new Object[] { "393", VARIABLE_LENGTH, Integer.valueOf(18) };
    object1 = VARIABLE_LENGTH;
    THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = new Object[][] { 
        { "310", Integer.valueOf(6) }, (Object[])object8, { "312", Integer.valueOf(6) }, (Object[])object14, { "314", Integer.valueOf(6) }, { "315", Integer.valueOf(6) }, { "316", Integer.valueOf(6) }, { "320", Integer.valueOf(6) }, (Object[])object3, { "322", Integer.valueOf(6) }, 
        { "323", Integer.valueOf(6) }, { "324", Integer.valueOf(6) }, { "325", Integer.valueOf(6) }, { "326", Integer.valueOf(6) }, (Object[])object5, { "328", Integer.valueOf(6) }, { "329", Integer.valueOf(6) }, { "330", Integer.valueOf(6) }, { "331", Integer.valueOf(6) }, { "332", Integer.valueOf(6) }, 
        (Object[])object6, { "334", Integer.valueOf(6) }, { "335", Integer.valueOf(6) }, { "336", Integer.valueOf(6) }, { "340", Integer.valueOf(6) }, { "341", Integer.valueOf(6) }, { "342", Integer.valueOf(6) }, { "343", Integer.valueOf(6) }, (Object[])object10, { "345", Integer.valueOf(6) }, 
        { "346", Integer.valueOf(6) }, { "347", Integer.valueOf(6) }, { "348", Integer.valueOf(6) }, { "349", Integer.valueOf(6) }, (Object[])object4, { "351", Integer.valueOf(6) }, { "352", Integer.valueOf(6) }, { "353", Integer.valueOf(6) }, { "354", Integer.valueOf(6) }, { "355", Integer.valueOf(6) }, 
        (Object[])object12, { "357", Integer.valueOf(6) }, { "360", Integer.valueOf(6) }, (Object[])object7, { "362", Integer.valueOf(6) }, { "363", Integer.valueOf(6) }, { "364", Integer.valueOf(6) }, { "365", Integer.valueOf(6) }, { "366", Integer.valueOf(6) }, { "367", Integer.valueOf(6) }, 
        { "368", Integer.valueOf(6) }, { "369", Integer.valueOf(6) }, { "390", object13, Integer.valueOf(15) }, { "391", object2, Integer.valueOf(18) }, { "392", object15, Integer.valueOf(15) }, (Object[])object11, { "703", object1, Integer.valueOf(30) } };
    object1 = new Object[] { "7001", Integer.valueOf(13) };
    object2 = new Object[] { "7002", VARIABLE_LENGTH, Integer.valueOf(30) };
    object8 = new Object[] { "8001", Integer.valueOf(14) };
    object14 = new Object[] { "8002", VARIABLE_LENGTH, Integer.valueOf(20) };
    object15 = VARIABLE_LENGTH;
    object3 = new Object[] { "8004", VARIABLE_LENGTH, Integer.valueOf(30) };
    object5 = new Object[] { "8005", Integer.valueOf(6) };
    object6 = new Object[] { "8007", VARIABLE_LENGTH, Integer.valueOf(30) };
    object13 = VARIABLE_LENGTH;
    object10 = new Object[] { "8020", VARIABLE_LENGTH, Integer.valueOf(25) };
    object4 = new Object[] { "8100", Integer.valueOf(6) };
    object12 = new Object[] { "8110", VARIABLE_LENGTH, Integer.valueOf(70) };
    object7 = new Object[] { "8200", VARIABLE_LENGTH, Integer.valueOf(70) };
    FOUR_DIGIT_DATA_LENGTH = new Object[][] { 
        (Object[])object1, (Object[])object2, { "7003", Integer.valueOf(10) }, (Object[])object8, (Object[])object14, { "8003", object15, Integer.valueOf(30) }, (Object[])object3, (Object[])object5, { "8006", Integer.valueOf(18) }, (Object[])object6, 
        { "8008", object13, Integer.valueOf(12) }, { "8018", Integer.valueOf(18) }, (Object[])object10, (Object[])object4, { "8101", Integer.valueOf(10) }, { "8102", Integer.valueOf(2) }, (Object[])object12, (Object[])object7 };
  }
  
  static String parseFieldsInGeneralPurpose(String paramString) throws NotFoundException {
    if (paramString.isEmpty())
      return null; 
    if (paramString.length() >= 2) {
      String str = paramString.substring(0, 2);
      for (Object[] arrayOfObject : TWO_DIGIT_DATA_LENGTH) {
        if (arrayOfObject[0].equals(str))
          return (arrayOfObject[1] == VARIABLE_LENGTH) ? processVariableAI(2, ((Integer)arrayOfObject[2]).intValue(), paramString) : processFixedAI(2, ((Integer)arrayOfObject[1]).intValue(), paramString); 
      } 
      if (paramString.length() >= 3) {
        String str1 = paramString.substring(0, 3);
        for (Object[] arrayOfObject : THREE_DIGIT_DATA_LENGTH) {
          if (arrayOfObject[0].equals(str1))
            return (arrayOfObject[1] == VARIABLE_LENGTH) ? processVariableAI(3, ((Integer)arrayOfObject[2]).intValue(), paramString) : processFixedAI(3, ((Integer)arrayOfObject[1]).intValue(), paramString); 
        } 
        for (Object[] arrayOfObject : THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH) {
          if (arrayOfObject[0].equals(str1))
            return (arrayOfObject[1] == VARIABLE_LENGTH) ? processVariableAI(4, ((Integer)arrayOfObject[2]).intValue(), paramString) : processFixedAI(4, ((Integer)arrayOfObject[1]).intValue(), paramString); 
        } 
        if (paramString.length() >= 4) {
          String str2 = paramString.substring(0, 4);
          for (Object[] arrayOfObject : FOUR_DIGIT_DATA_LENGTH) {
            if (arrayOfObject[0].equals(str2))
              return (arrayOfObject[1] == VARIABLE_LENGTH) ? processVariableAI(4, ((Integer)arrayOfObject[2]).intValue(), paramString) : processFixedAI(4, ((Integer)arrayOfObject[1]).intValue(), paramString); 
          } 
          throw NotFoundException.getNotFoundInstance();
        } 
        throw NotFoundException.getNotFoundInstance();
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static String processFixedAI(int paramInt1, int paramInt2, String paramString) throws NotFoundException {
    if (paramString.length() >= paramInt1) {
      String str = paramString.substring(0, paramInt1);
      int i = paramString.length();
      paramInt2 += paramInt1;
      if (i >= paramInt2) {
        String str1 = paramString.substring(paramInt1, paramInt2);
        paramString = paramString.substring(paramInt2);
        StringBuilder stringBuilder2 = new StringBuilder("(");
        stringBuilder2.append(str);
        stringBuilder2.append(')');
        stringBuilder2.append(str1);
        str1 = stringBuilder2.toString();
        paramString = parseFieldsInGeneralPurpose(paramString);
        if (paramString == null)
          return str1; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(paramString);
        return stringBuilder1.toString();
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static String processVariableAI(int paramInt1, int paramInt2, String paramString) throws NotFoundException {
    String str1 = paramString.substring(0, paramInt1);
    int i = paramString.length();
    int j = paramInt2 + paramInt1;
    paramInt2 = j;
    if (i < j)
      paramInt2 = paramString.length(); 
    String str2 = paramString.substring(paramInt1, paramInt2);
    paramString = paramString.substring(paramInt2);
    StringBuilder stringBuilder2 = new StringBuilder("(");
    stringBuilder2.append(str1);
    stringBuilder2.append(')');
    stringBuilder2.append(str2);
    str1 = stringBuilder2.toString();
    str2 = parseFieldsInGeneralPurpose(paramString);
    if (str2 == null)
      return str1; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(str2);
    return stringBuilder1.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\FieldParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
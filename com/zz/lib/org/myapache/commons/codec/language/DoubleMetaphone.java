package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;
import java.util.Locale;

public class DoubleMetaphone implements StringEncoder {
  private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER;
  
  private static final String[] L_R_N_M_B_H_F_V_W_SPACE;
  
  private static final String[] L_T_K_S_N_M_B_Z;
  
  private static final String[] SILENT_START = new String[] { "GN", "KN", "PN", "WR", "PS" };
  
  private static final String VOWELS = "AEIOUY";
  
  private int maxCodeLen = 4;
  
  static {
    L_R_N_M_B_H_F_V_W_SPACE = new String[] { "L", "R", "N", "M", "B", "H", "F", "V", "W", " " };
    ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = new String[] { 
        "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", 
        "ER" };
    L_T_K_S_N_M_B_Z = new String[] { "L", "T", "K", "S", "N", "M", "B", "Z" };
  }
  
  private String cleanInput(String paramString) {
    String str1 = null;
    if (paramString == null)
      return str1; 
    String str2 = paramString.trim();
    paramString = str1;
    if (str2.length() != 0)
      paramString = str2.toUpperCase(Locale.ENGLISH); 
    return paramString;
  }
  
  private boolean conditionC0(String paramString, int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: iload_2
    //   4: iconst_4
    //   5: ldc 'CHIA'
    //   7: invokestatic contains : (Ljava/lang/String;IILjava/lang/String;)Z
    //   10: ifeq -> 19
    //   13: iload_3
    //   14: istore #4
    //   16: iload #4
    //   18: ireturn
    //   19: iload_2
    //   20: iconst_1
    //   21: if_icmpgt -> 30
    //   24: iconst_0
    //   25: istore #4
    //   27: goto -> 16
    //   30: aload_0
    //   31: aload_0
    //   32: aload_1
    //   33: iload_2
    //   34: iconst_2
    //   35: isub
    //   36: invokevirtual charAt : (Ljava/lang/String;I)C
    //   39: invokespecial isVowel : (C)Z
    //   42: ifeq -> 51
    //   45: iconst_0
    //   46: istore #4
    //   48: goto -> 16
    //   51: aload_1
    //   52: iload_2
    //   53: iconst_1
    //   54: isub
    //   55: iconst_3
    //   56: ldc 'ACH'
    //   58: invokestatic contains : (Ljava/lang/String;IILjava/lang/String;)Z
    //   61: ifne -> 70
    //   64: iconst_0
    //   65: istore #4
    //   67: goto -> 16
    //   70: aload_0
    //   71: aload_1
    //   72: iload_2
    //   73: iconst_2
    //   74: iadd
    //   75: invokevirtual charAt : (Ljava/lang/String;I)C
    //   78: istore #5
    //   80: iload #5
    //   82: bipush #73
    //   84: if_icmpeq -> 97
    //   87: iload_3
    //   88: istore #4
    //   90: iload #5
    //   92: bipush #69
    //   94: if_icmpne -> 16
    //   97: iload_3
    //   98: istore #4
    //   100: aload_1
    //   101: iload_2
    //   102: iconst_2
    //   103: isub
    //   104: bipush #6
    //   106: ldc 'BACHER'
    //   108: ldc 'MACHER'
    //   110: invokestatic contains : (Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)Z
    //   113: ifne -> 16
    //   116: iconst_0
    //   117: istore #4
    //   119: goto -> 16
  }
  
  private boolean conditionCH0(String paramString, int paramInt) {
    return (paramInt != 0) ? false : ((!contains(paramString, paramInt + 1, 5, "HARAC", "HARIS") && !contains(paramString, paramInt + 1, 3, "HOR", "HYM", "HIA", "HEM")) ? false : (!contains(paramString, 0, 5, "CHORE")));
  }
  
  private boolean conditionCH1(String paramString, int paramInt) {
    return !(!contains(paramString, 0, 4, "VAN ", "VON ") && !contains(paramString, 0, 3, "SCH") && !contains(paramString, paramInt - 2, 6, "ORCHES", "ARCHIT", "ORCHID") && !contains(paramString, paramInt + 2, 1, "T", "S") && ((!contains(paramString, paramInt - 1, 1, "A", "O", "U", "E") && paramInt != 0) || (!contains(paramString, paramInt + 2, 1, L_R_N_M_B_H_F_V_W_SPACE) && paramInt + 1 != paramString.length() - 1)));
  }
  
  private boolean conditionL0(String paramString, int paramInt) {
    return (paramInt == paramString.length() - 3 && contains(paramString, paramInt - 1, 4, "ILLO", "ILLA", "ALLE")) ? true : (((contains(paramString, paramString.length() - 2, 2, "AS", "OS") || contains(paramString, paramString.length() - 1, 1, "A", "O")) && contains(paramString, paramInt - 1, 4, "ALLE")));
  }
  
  private boolean conditionM0(String paramString, int paramInt) {
    boolean bool = true;
    if (charAt(paramString, paramInt + 1) == 'M')
      return bool; 
    if (contains(paramString, paramInt - 1, 3, "UMB")) {
      boolean bool1 = bool;
      if (paramInt + 1 != paramString.length() - 1) {
        bool1 = bool;
        if (!contains(paramString, paramInt + 2, 2, "ER"))
          return false; 
      } 
      return bool1;
    } 
    return false;
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2) {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4) {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5) {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5, paramString6, paramString7 });
  }
  
  protected static boolean contains(String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramInt1 >= 0) {
      bool2 = bool1;
      if (paramInt1 + paramInt2 <= paramString.length()) {
        paramString = paramString.substring(paramInt1, paramInt1 + paramInt2);
        paramInt2 = paramArrayOfString.length;
        for (paramInt1 = 0;; paramInt1++) {
          if (paramInt1 >= paramInt2)
            return bool1; 
          if (paramString.equals(paramArrayOfString[paramInt1]))
            return true; 
        } 
      } 
    } 
    return bool2;
  }
  
  private int handleAEIOUY(DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (paramInt == 0)
      paramDoubleMetaphoneResult.append('A'); 
    return paramInt + 1;
  }
  
  private int handleC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (conditionC0(paramString, paramInt)) {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
      return paramInt;
    } 
    if (paramInt == 0 && contains(paramString, paramInt, 6, "CAESAR")) {
      paramDoubleMetaphoneResult.append('S');
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 2, "CH"))
      return handleCH(paramString, paramDoubleMetaphoneResult, paramInt); 
    if (contains(paramString, paramInt, 2, "CZ") && !contains(paramString, paramInt - 2, 4, "WICZ")) {
      paramDoubleMetaphoneResult.append('S', 'X');
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt + 1, 3, "CIA")) {
      paramDoubleMetaphoneResult.append('X');
      paramInt += 3;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 2, "CC") && (paramInt != 1 || charAt(paramString, 0) != 'M'))
      return handleCC(paramString, paramDoubleMetaphoneResult, paramInt); 
    if (contains(paramString, paramInt, 2, "CK", "CG", "CQ")) {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 2, "CI", "CE", "CY")) {
      if (contains(paramString, paramInt, 3, "CIO", "CIE", "CIA")) {
        paramDoubleMetaphoneResult.append('S', 'X');
      } else {
        paramDoubleMetaphoneResult.append('S');
      } 
      paramInt += 2;
      return paramInt;
    } 
    paramDoubleMetaphoneResult.append('K');
    if (contains(paramString, paramInt + 1, 2, " C", " Q", " G")) {
      paramInt += 3;
      return paramInt;
    } 
    if (contains(paramString, paramInt + 1, 1, "C", "K", "Q") && !contains(paramString, paramInt + 1, 2, "CE", "CI")) {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleCC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (contains(paramString, paramInt + 2, 1, "I", "E", "H") && !contains(paramString, paramInt + 2, 2, "HU")) {
      if ((paramInt == 1 && charAt(paramString, paramInt - 1) == 'A') || contains(paramString, paramInt - 1, 5, "UCCEE", "UCCES")) {
        paramDoubleMetaphoneResult.append("KS");
      } else {
        paramDoubleMetaphoneResult.append('X');
      } 
      paramInt += 3;
      return paramInt;
    } 
    paramDoubleMetaphoneResult.append('K');
    paramInt += 2;
    return paramInt;
  }
  
  private int handleCH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (paramInt > 0 && contains(paramString, paramInt, 4, "CHAE")) {
      paramDoubleMetaphoneResult.append('K', 'X');
      paramInt += 2;
      return paramInt;
    } 
    if (conditionCH0(paramString, paramInt)) {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
      return paramInt;
    } 
    if (conditionCH1(paramString, paramInt)) {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
      return paramInt;
    } 
    if (paramInt > 0) {
      if (contains(paramString, 0, 2, "MC")) {
        paramDoubleMetaphoneResult.append('K');
      } else {
        paramDoubleMetaphoneResult.append('X', 'K');
      } 
    } else {
      paramDoubleMetaphoneResult.append('X');
    } 
    paramInt += 2;
    return paramInt;
  }
  
  private int handleD(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (contains(paramString, paramInt, 2, "DG")) {
      if (contains(paramString, paramInt + 2, 1, "I", "E", "Y")) {
        paramDoubleMetaphoneResult.append('J');
        paramInt += 3;
        return paramInt;
      } 
      paramDoubleMetaphoneResult.append("TK");
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 2, "DT", "DD")) {
      paramDoubleMetaphoneResult.append('T');
      paramInt += 2;
      return paramInt;
    } 
    paramDoubleMetaphoneResult.append('T');
    return ++paramInt;
  }
  
  private int handleG(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
    if (charAt(paramString, paramInt + 1) == 'H')
      return handleGH(paramString, paramDoubleMetaphoneResult, paramInt); 
    if (charAt(paramString, paramInt + 1) == 'N') {
      if (paramInt == 1 && isVowel(charAt(paramString, 0)) && !paramBoolean) {
        paramDoubleMetaphoneResult.append("KN", "N");
      } else if (!contains(paramString, paramInt + 2, 2, "EY") && charAt(paramString, paramInt + 1) != 'Y' && !paramBoolean) {
        paramDoubleMetaphoneResult.append("N", "KN");
      } else {
        paramDoubleMetaphoneResult.append("KN");
      } 
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt + 1, 2, "LI") && !paramBoolean) {
      paramDoubleMetaphoneResult.append("KL", "L");
      paramInt += 2;
      return paramInt;
    } 
    if (paramInt == 0 && (charAt(paramString, paramInt + 1) == 'Y' || contains(paramString, paramInt + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
      paramDoubleMetaphoneResult.append('K', 'J');
      paramInt += 2;
      return paramInt;
    } 
    if ((contains(paramString, paramInt + 1, 2, "ER") || charAt(paramString, paramInt + 1) == 'Y') && !contains(paramString, 0, 6, "DANGER", "RANGER", "MANGER") && !contains(paramString, paramInt - 1, 1, "E", "I") && !contains(paramString, paramInt - 1, 3, "RGY", "OGY")) {
      paramDoubleMetaphoneResult.append('K', 'J');
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt + 1, 1, "E", "I", "Y") || contains(paramString, paramInt - 1, 4, "AGGI", "OGGI")) {
      if (contains(paramString, 0, 4, "VAN ", "VON ") || contains(paramString, 0, 3, "SCH") || contains(paramString, paramInt + 1, 2, "ET")) {
        paramDoubleMetaphoneResult.append('K');
      } else if (contains(paramString, paramInt + 1, 3, "IER")) {
        paramDoubleMetaphoneResult.append('J');
      } else {
        paramDoubleMetaphoneResult.append('J', 'K');
      } 
      paramInt += 2;
      return paramInt;
    } 
    if (charAt(paramString, paramInt + 1) == 'G') {
      paramInt += 2;
      paramDoubleMetaphoneResult.append('K');
      return paramInt;
    } 
    paramInt++;
    paramDoubleMetaphoneResult.append('K');
    return paramInt;
  }
  
  private int handleGH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (paramInt > 0 && !isVowel(charAt(paramString, paramInt - 1))) {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
      return paramInt;
    } 
    if (paramInt == 0) {
      if (charAt(paramString, paramInt + 2) == 'I') {
        paramDoubleMetaphoneResult.append('J');
      } else {
        paramDoubleMetaphoneResult.append('K');
      } 
      paramInt += 2;
      return paramInt;
    } 
    if ((paramInt > 1 && contains(paramString, paramInt - 2, 1, "B", "H", "D")) || (paramInt > 2 && contains(paramString, paramInt - 3, 1, "B", "H", "D")) || (paramInt > 3 && contains(paramString, paramInt - 4, 1, "B", "H"))) {
      paramInt += 2;
      return paramInt;
    } 
    if (paramInt > 2 && charAt(paramString, paramInt - 1) == 'U' && contains(paramString, paramInt - 3, 1, "C", "G", "L", "R", "T")) {
      paramDoubleMetaphoneResult.append('F');
    } else if (paramInt > 0 && charAt(paramString, paramInt - 1) != 'I') {
      paramDoubleMetaphoneResult.append('K');
    } 
    paramInt += 2;
    return paramInt;
  }
  
  private int handleH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if ((paramInt == 0 || isVowel(charAt(paramString, paramInt - 1))) && isVowel(charAt(paramString, paramInt + 1))) {
      paramDoubleMetaphoneResult.append('H');
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleJ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
    if (contains(paramString, paramInt, 4, "JOSE") || contains(paramString, 0, 4, "SAN ")) {
      if ((paramInt == 0 && charAt(paramString, paramInt + 4) == ' ') || paramString.length() == 4 || contains(paramString, 0, 4, "SAN ")) {
        paramDoubleMetaphoneResult.append('H');
      } else {
        paramDoubleMetaphoneResult.append('J', 'H');
      } 
      return ++paramInt;
    } 
    if (paramInt == 0 && !contains(paramString, paramInt, 4, "JOSE")) {
      paramDoubleMetaphoneResult.append('J', 'A');
    } else if (isVowel(charAt(paramString, paramInt - 1)) && !paramBoolean && (charAt(paramString, paramInt + 1) == 'A' || charAt(paramString, paramInt + 1) == 'O')) {
      paramDoubleMetaphoneResult.append('J', 'H');
    } else if (paramInt == paramString.length() - 1) {
      paramDoubleMetaphoneResult.append('J', ' ');
    } else if (!contains(paramString, paramInt + 1, 1, L_T_K_S_N_M_B_Z) && !contains(paramString, paramInt - 1, 1, "S", "K", "L")) {
      paramDoubleMetaphoneResult.append('J');
    } 
    if (charAt(paramString, paramInt + 1) == 'J') {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleL(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (charAt(paramString, paramInt + 1) == 'L') {
      if (conditionL0(paramString, paramInt)) {
        paramDoubleMetaphoneResult.appendPrimary('L');
      } else {
        paramDoubleMetaphoneResult.append('L');
      } 
      paramInt += 2;
      return paramInt;
    } 
    paramInt++;
    paramDoubleMetaphoneResult.append('L');
    return paramInt;
  }
  
  private int handleP(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (charAt(paramString, paramInt + 1) == 'H') {
      paramDoubleMetaphoneResult.append('F');
      paramInt += 2;
      return paramInt;
    } 
    paramDoubleMetaphoneResult.append('P');
    if (contains(paramString, paramInt + 1, 1, "P", "B")) {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleR(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
    if (paramInt == paramString.length() - 1 && !paramBoolean && contains(paramString, paramInt - 2, 2, "IE") && !contains(paramString, paramInt - 4, 2, "ME", "MA")) {
      paramDoubleMetaphoneResult.appendAlternate('R');
    } else {
      paramDoubleMetaphoneResult.append('R');
    } 
    if (charAt(paramString, paramInt + 1) == 'R') {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleS(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
    if (contains(paramString, paramInt - 1, 3, "ISL", "YSL"))
      return ++paramInt; 
    if (paramInt == 0 && contains(paramString, paramInt, 5, "SUGAR")) {
      paramDoubleMetaphoneResult.append('X', 'S');
      return ++paramInt;
    } 
    if (contains(paramString, paramInt, 2, "SH")) {
      if (contains(paramString, paramInt + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
        paramDoubleMetaphoneResult.append('S');
      } else {
        paramDoubleMetaphoneResult.append('X');
      } 
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 3, "SIO", "SIA") || contains(paramString, paramInt, 4, "SIAN")) {
      if (paramBoolean) {
        paramDoubleMetaphoneResult.append('S');
      } else {
        paramDoubleMetaphoneResult.append('S', 'X');
      } 
      paramInt += 3;
      return paramInt;
    } 
    if ((paramInt == 0 && contains(paramString, paramInt + 1, 1, "M", "N", "L", "W")) || contains(paramString, paramInt + 1, 1, "Z")) {
      paramDoubleMetaphoneResult.append('S', 'X');
      if (contains(paramString, paramInt + 1, 1, "Z")) {
        paramInt += 2;
        return paramInt;
      } 
      return ++paramInt;
    } 
    if (contains(paramString, paramInt, 2, "SC"))
      return handleSC(paramString, paramDoubleMetaphoneResult, paramInt); 
    if (paramInt == paramString.length() - 1 && contains(paramString, paramInt - 2, 2, "AI", "OI")) {
      paramDoubleMetaphoneResult.appendAlternate('S');
    } else {
      paramDoubleMetaphoneResult.append('S');
    } 
    if (contains(paramString, paramInt + 1, 1, "S", "Z")) {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleSC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (charAt(paramString, paramInt + 2) == 'H') {
      if (contains(paramString, paramInt + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
        if (contains(paramString, paramInt + 3, 2, "ER", "EN")) {
          paramDoubleMetaphoneResult.append("X", "SK");
          return paramInt + 3;
        } 
        paramDoubleMetaphoneResult.append("SK");
        return paramInt + 3;
      } 
      if (paramInt == 0 && !isVowel(charAt(paramString, 3)) && charAt(paramString, 3) != 'W') {
        paramDoubleMetaphoneResult.append('X', 'S');
        return paramInt + 3;
      } 
      paramDoubleMetaphoneResult.append('X');
      return paramInt + 3;
    } 
    if (contains(paramString, paramInt + 2, 1, "I", "E", "Y")) {
      paramDoubleMetaphoneResult.append('S');
      return paramInt + 3;
    } 
    paramDoubleMetaphoneResult.append("SK");
    return paramInt + 3;
  }
  
  private int handleT(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (contains(paramString, paramInt, 4, "TION")) {
      paramDoubleMetaphoneResult.append('X');
      paramInt += 3;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 3, "TIA", "TCH")) {
      paramDoubleMetaphoneResult.append('X');
      paramInt += 3;
      return paramInt;
    } 
    if (contains(paramString, paramInt, 2, "TH") || contains(paramString, paramInt, 3, "TTH")) {
      if (contains(paramString, paramInt + 2, 2, "OM", "AM") || contains(paramString, 0, 4, "VAN ", "VON ") || contains(paramString, 0, 3, "SCH")) {
        paramDoubleMetaphoneResult.append('T');
      } else {
        paramDoubleMetaphoneResult.append('0', 'T');
      } 
      paramInt += 2;
      return paramInt;
    } 
    paramDoubleMetaphoneResult.append('T');
    if (contains(paramString, paramInt + 1, 1, "T", "D")) {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleW(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (contains(paramString, paramInt, 2, "WR")) {
      paramDoubleMetaphoneResult.append('R');
      paramInt += 2;
      return paramInt;
    } 
    if (paramInt == 0 && (isVowel(charAt(paramString, paramInt + 1)) || contains(paramString, paramInt, 2, "WH"))) {
      if (isVowel(charAt(paramString, paramInt + 1))) {
        paramDoubleMetaphoneResult.append('A', 'F');
      } else {
        paramDoubleMetaphoneResult.append('A');
      } 
      return ++paramInt;
    } 
    if ((paramInt == paramString.length() - 1 && isVowel(charAt(paramString, paramInt - 1))) || contains(paramString, paramInt - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || contains(paramString, 0, 3, "SCH")) {
      paramDoubleMetaphoneResult.appendAlternate('F');
      return ++paramInt;
    } 
    if (contains(paramString, paramInt, 4, "WICZ", "WITZ")) {
      paramDoubleMetaphoneResult.append("TS", "FX");
      paramInt += 4;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleX(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
    if (paramInt == 0) {
      paramDoubleMetaphoneResult.append('S');
      return ++paramInt;
    } 
    if (paramInt != paramString.length() - 1 || (!contains(paramString, paramInt - 3, 3, "IAU", "EAU") && !contains(paramString, paramInt - 2, 2, "AU", "OU")))
      paramDoubleMetaphoneResult.append("KS"); 
    if (contains(paramString, paramInt + 1, 1, "C", "X")) {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private int handleZ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
    if (charAt(paramString, paramInt + 1) == 'H') {
      paramDoubleMetaphoneResult.append('J');
      paramInt += 2;
      return paramInt;
    } 
    if (contains(paramString, paramInt + 1, 2, "ZO", "ZI", "ZA") || (paramBoolean && paramInt > 0 && charAt(paramString, paramInt - 1) != 'T')) {
      paramDoubleMetaphoneResult.append("S", "TS");
    } else {
      paramDoubleMetaphoneResult.append('S');
    } 
    if (charAt(paramString, paramInt + 1) == 'Z') {
      paramInt += 2;
      return paramInt;
    } 
    return ++paramInt;
  }
  
  private boolean isSilentStart(String paramString) {
    boolean bool = false;
    String[] arrayOfString = SILENT_START;
    int i = arrayOfString.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        if (paramString.startsWith(arrayOfString[b]))
          return true; 
        b++;
        continue;
      } 
      return bool;
    } 
  }
  
  private boolean isSlavoGermanic(String paramString) {
    return !(paramString.indexOf('W') <= -1 && paramString.indexOf('K') <= -1 && paramString.indexOf("CZ") <= -1 && paramString.indexOf("WITZ") <= -1);
  }
  
  private boolean isVowel(char paramChar) {
    return ("AEIOUY".indexOf(paramChar) != -1);
  }
  
  protected char charAt(String paramString, int paramInt) {
    if (paramInt < 0 || paramInt >= paramString.length()) {
      paramInt = 0;
      return paramInt;
    } 
    paramInt = paramString.charAt(paramInt);
    return paramInt;
  }
  
  public String doubleMetaphone(String paramString) {
    return doubleMetaphone(paramString, false);
  }
  
  public String doubleMetaphone(String paramString, boolean paramBoolean) {
    int i;
    paramString = cleanInput(paramString);
    if (paramString == null)
      return null; 
    boolean bool = isSlavoGermanic(paramString);
    if (isSilentStart(paramString)) {
      i = 1;
    } else {
      i = 0;
    } 
    DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
    while (true) {
      if (doubleMetaphoneResult.isComplete() || i > paramString.length() - 1) {
        if (paramBoolean)
          return doubleMetaphoneResult.getAlternate(); 
      } else {
        switch (paramString.charAt(i)) {
          default:
            i++;
            continue;
          case 'A':
          case 'E':
          case 'I':
          case 'O':
          case 'U':
          case 'Y':
            i = handleAEIOUY(doubleMetaphoneResult, i);
            continue;
          case 'B':
            doubleMetaphoneResult.append('P');
            if (charAt(paramString, i + 1) == 'B') {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'Ç':
            doubleMetaphoneResult.append('S');
            i++;
            continue;
          case 'C':
            i = handleC(paramString, doubleMetaphoneResult, i);
            continue;
          case 'D':
            i = handleD(paramString, doubleMetaphoneResult, i);
            continue;
          case 'F':
            doubleMetaphoneResult.append('F');
            if (charAt(paramString, i + 1) == 'F') {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'G':
            i = handleG(paramString, doubleMetaphoneResult, i, bool);
            continue;
          case 'H':
            i = handleH(paramString, doubleMetaphoneResult, i);
            continue;
          case 'J':
            i = handleJ(paramString, doubleMetaphoneResult, i, bool);
            continue;
          case 'K':
            doubleMetaphoneResult.append('K');
            if (charAt(paramString, i + 1) == 'K') {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'L':
            i = handleL(paramString, doubleMetaphoneResult, i);
            continue;
          case 'M':
            doubleMetaphoneResult.append('M');
            if (conditionM0(paramString, i)) {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'N':
            doubleMetaphoneResult.append('N');
            if (charAt(paramString, i + 1) == 'N') {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'Ñ':
            doubleMetaphoneResult.append('N');
            i++;
            continue;
          case 'P':
            i = handleP(paramString, doubleMetaphoneResult, i);
            continue;
          case 'Q':
            doubleMetaphoneResult.append('K');
            if (charAt(paramString, i + 1) == 'Q') {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'R':
            i = handleR(paramString, doubleMetaphoneResult, i, bool);
            continue;
          case 'S':
            i = handleS(paramString, doubleMetaphoneResult, i, bool);
            continue;
          case 'T':
            i = handleT(paramString, doubleMetaphoneResult, i);
            continue;
          case 'V':
            doubleMetaphoneResult.append('F');
            if (charAt(paramString, i + 1) == 'V') {
              i += 2;
              continue;
            } 
            i++;
            continue;
          case 'W':
            i = handleW(paramString, doubleMetaphoneResult, i);
            continue;
          case 'X':
            i = handleX(paramString, doubleMetaphoneResult, i);
            continue;
          case 'Z':
            break;
        } 
        i = handleZ(paramString, doubleMetaphoneResult, i, bool);
        continue;
      } 
      return doubleMetaphoneResult.getPrimary();
    } 
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("DoubleMetaphone encode parameter is not of type String"); 
    return doubleMetaphone((String)paramObject);
  }
  
  public String encode(String paramString) {
    return doubleMetaphone(paramString);
  }
  
  public int getMaxCodeLen() {
    return this.maxCodeLen;
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2) {
    return isDoubleMetaphoneEqual(paramString1, paramString2, false);
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2, boolean paramBoolean) {
    return doubleMetaphone(paramString1, paramBoolean).equals(doubleMetaphone(paramString2, paramBoolean));
  }
  
  public void setMaxCodeLen(int paramInt) {
    this.maxCodeLen = paramInt;
  }
  
  public class DoubleMetaphoneResult {
    private final StringBuffer alternate = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
    
    private final int maxLength;
    
    private final StringBuffer primary = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
    
    public DoubleMetaphoneResult(int param1Int) {
      this.maxLength = param1Int;
    }
    
    public void append(char param1Char) {
      appendPrimary(param1Char);
      appendAlternate(param1Char);
    }
    
    public void append(char param1Char1, char param1Char2) {
      appendPrimary(param1Char1);
      appendAlternate(param1Char2);
    }
    
    public void append(String param1String) {
      appendPrimary(param1String);
      appendAlternate(param1String);
    }
    
    public void append(String param1String1, String param1String2) {
      appendPrimary(param1String1);
      appendAlternate(param1String2);
    }
    
    public void appendAlternate(char param1Char) {
      if (this.alternate.length() < this.maxLength)
        this.alternate.append(param1Char); 
    }
    
    public void appendAlternate(String param1String) {
      int i = this.maxLength - this.alternate.length();
      if (param1String.length() <= i) {
        this.alternate.append(param1String);
        return;
      } 
      this.alternate.append(param1String.substring(0, i));
    }
    
    public void appendPrimary(char param1Char) {
      if (this.primary.length() < this.maxLength)
        this.primary.append(param1Char); 
    }
    
    public void appendPrimary(String param1String) {
      int i = this.maxLength - this.primary.length();
      if (param1String.length() <= i) {
        this.primary.append(param1String);
        return;
      } 
      this.primary.append(param1String.substring(0, i));
    }
    
    public String getAlternate() {
      return this.alternate.toString();
    }
    
    public String getPrimary() {
      return this.primary.toString();
    }
    
    public boolean isComplete() {
      return (this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\DoubleMetaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
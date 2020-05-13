package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.text.TextUtils;

public class PinyinUtils {
  private static final int DISTINGUISH_LEN = 10;
  
  private static final char FIRST_CHINA = '一';
  
  private static final char LAST_CHINA = '龥';
  
  private static final String[] PINYIN = new String[] { 
      "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", 
      "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", 
      "bu", "ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", 
      "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", 
      "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", 
      "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", 
      "de", "deng", "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", 
      "dou", "du", "duan", "dui", "dun", "duo", "e", "ei", "en", "er", 
      "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", 
      "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", 
      "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", 
      "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", 
      "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", 
      "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", 
      "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", 
      "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", 
      "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", 
      "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", 
      "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", 
      "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", 
      "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", 
      "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", 
      "ning", "niu", "none", "nong", "nou", "nu", "nuan", "nuo", "nv", "nve", 
      "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", 
      "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", 
      "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", 
      "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", 
      "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", 
      "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", 
      "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", 
      "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", 
      "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", 
      "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", 
      "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", 
      "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", 
      "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", 
      "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", 
      "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", 
      "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", 
      "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", 
      "zong", "zou", "zu", "zuan", "zui", "zun", "zuo" };
  
  private static final char SPECIAL_HANZI = '〇';
  
  private static final String SPECIAL_HANZI_PINYIN = "LING";
  
  private static volatile boolean isLoad = false;
  
  private static PinyinUtils sInstance;
  
  private static short[] sPinyinIndex;
  
  private boolean distinguish(char[] paramArrayOfchar1, char[] paramArrayOfchar2, String[] paramArrayOfString, int paramInt) {
    String str = new String(paramArrayOfchar1);
    byte b = 0;
    int i = 0;
    while (true) {
      if (b >= paramInt)
        return true; 
      int j = str.indexOf(paramArrayOfString[b].charAt(0), i);
      i = j;
      if (j == -1)
        i = str.indexOf(paramArrayOfchar2[b], j); 
      if (i == -1)
        return false; 
      i++;
      b++;
    } 
  }
  
  public static PinyinUtils getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sInstance : Lcom/sina/weibo/sdk/register/mobile/PinyinUtils;
    //   6: ifnonnull -> 21
    //   9: new com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   12: astore_1
    //   13: aload_1
    //   14: invokespecial <init> : ()V
    //   17: aload_1
    //   18: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sInstance : Lcom/sina/weibo/sdk/register/mobile/PinyinUtils;
    //   21: aload_0
    //   22: invokestatic loadData : (Landroid/content/Context;)V
    //   25: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sInstance : Lcom/sina/weibo/sdk/register/mobile/PinyinUtils;
    //   28: astore_0
    //   29: ldc com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	34	finally
    //   21	29	34	finally
  }
  
  public static PinyinUtils getObject() {
    return sInstance;
  }
  
  private String getPinyin(char paramChar) {
    if (!isLoad)
      return ""; 
    if (paramChar == '〇')
      return "LING"; 
    if (paramChar < '一' || paramChar > '龥')
      return String.valueOf(paramChar); 
    String str1 = PINYIN[sPinyinIndex[paramChar - 19968]];
    String str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  private static void loadData(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   9: ifeq -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   17: ldc_w 'pinyinindex'
    //   20: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_0
    //   24: aload_2
    //   25: astore #4
    //   27: aload_0
    //   28: astore #5
    //   30: new java/io/DataInputStream
    //   33: astore #6
    //   35: aload_2
    //   36: astore #4
    //   38: aload_0
    //   39: astore #5
    //   41: aload #6
    //   43: aload_0
    //   44: invokespecial <init> : (Ljava/io/InputStream;)V
    //   47: aload #6
    //   49: invokevirtual available : ()I
    //   52: iconst_1
    //   53: ishr
    //   54: i2l
    //   55: l2i
    //   56: newarray short
    //   58: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sPinyinIndex : [S
    //   61: iconst_0
    //   62: istore #7
    //   64: iload #7
    //   66: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sPinyinIndex : [S
    //   69: arraylength
    //   70: if_icmplt -> 93
    //   73: iconst_1
    //   74: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   77: aload #6
    //   79: invokevirtual close : ()V
    //   82: aload_0
    //   83: ifnull -> 204
    //   86: aload_0
    //   87: invokevirtual close : ()V
    //   90: goto -> 204
    //   93: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sPinyinIndex : [S
    //   96: iload #7
    //   98: aload #6
    //   100: invokevirtual readShort : ()S
    //   103: sastore
    //   104: iinc #7, 1
    //   107: goto -> 64
    //   110: astore #5
    //   112: goto -> 220
    //   115: astore #5
    //   117: goto -> 142
    //   120: astore #5
    //   122: goto -> 176
    //   125: astore #5
    //   127: aconst_null
    //   128: astore #6
    //   130: aload #6
    //   132: astore_0
    //   133: goto -> 220
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_3
    //   140: astore #6
    //   142: aload #6
    //   144: astore #4
    //   146: aload_0
    //   147: astore #5
    //   149: iconst_0
    //   150: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   153: aload #6
    //   155: ifnull -> 163
    //   158: aload #6
    //   160: invokevirtual close : ()V
    //   163: aload_0
    //   164: ifnull -> 204
    //   167: goto -> 86
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_1
    //   174: astore #6
    //   176: aload #6
    //   178: astore #4
    //   180: aload_0
    //   181: astore #5
    //   183: iconst_0
    //   184: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   187: aload #6
    //   189: ifnull -> 197
    //   192: aload #6
    //   194: invokevirtual close : ()V
    //   197: aload_0
    //   198: ifnull -> 204
    //   201: goto -> 86
    //   204: return
    //   205: astore_0
    //   206: aload #4
    //   208: astore #6
    //   210: aload_0
    //   211: astore #4
    //   213: aload #5
    //   215: astore_0
    //   216: aload #4
    //   218: astore #5
    //   220: aload #6
    //   222: ifnull -> 230
    //   225: aload #6
    //   227: invokevirtual close : ()V
    //   230: aload_0
    //   231: ifnull -> 238
    //   234: aload_0
    //   235: invokevirtual close : ()V
    //   238: aload #5
    //   240: athrow
    //   241: astore #5
    //   243: aload_1
    //   244: astore #6
    //   246: goto -> 176
    //   249: astore #5
    //   251: aload_3
    //   252: astore #6
    //   254: goto -> 142
    //   257: astore_0
    //   258: goto -> 204
    //   261: astore_0
    //   262: goto -> 238
    // Exception table:
    //   from	to	target	type
    //   6	12	170	java/io/IOException
    //   6	12	136	java/lang/Exception
    //   6	12	125	finally
    //   13	24	170	java/io/IOException
    //   13	24	136	java/lang/Exception
    //   13	24	125	finally
    //   30	35	241	java/io/IOException
    //   30	35	249	java/lang/Exception
    //   30	35	205	finally
    //   41	47	241	java/io/IOException
    //   41	47	249	java/lang/Exception
    //   41	47	205	finally
    //   47	61	120	java/io/IOException
    //   47	61	115	java/lang/Exception
    //   47	61	110	finally
    //   64	77	120	java/io/IOException
    //   64	77	115	java/lang/Exception
    //   64	77	110	finally
    //   77	82	257	java/io/IOException
    //   86	90	257	java/io/IOException
    //   93	104	120	java/io/IOException
    //   93	104	115	java/lang/Exception
    //   93	104	110	finally
    //   149	153	205	finally
    //   158	163	257	java/io/IOException
    //   183	187	205	finally
    //   192	197	257	java/io/IOException
    //   225	230	261	java/io/IOException
    //   234	238	261	java/io/IOException
  }
  
  private char[] subCharRangeArray(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    char[] arrayOfChar = new char[paramInt2 - paramInt1 + 1];
    boolean bool = false;
    int i = paramInt1;
    for (paramInt1 = bool;; paramInt1++) {
      if (i > paramInt2)
        return arrayOfChar; 
      arrayOfChar[paramInt1] = (char)paramArrayOfchar[i];
      i++;
    } 
  }
  
  private String[] subStringRangeArray(String[] paramArrayOfString, int paramInt1, int paramInt2) {
    String[] arrayOfString = new String[paramInt2 - paramInt1 + 1];
    for (byte b = 0;; b++) {
      if (paramInt1 > paramInt2)
        return arrayOfString; 
      arrayOfString[b] = paramArrayOfString[paramInt1];
      paramInt1++;
    } 
  }
  
  public int distinguish(char[] paramArrayOfchar1, int paramInt1, char[] paramArrayOfchar2, String[] paramArrayOfString, int paramInt2, int paramInt3) {
    if (paramInt1 == 0 && (paramArrayOfchar1[0] == paramArrayOfchar2[0] || paramArrayOfchar1[0] == paramArrayOfString[0].charAt(0)))
      return (paramArrayOfchar1.length != 1) ? distinguish(paramArrayOfchar1, 1, paramArrayOfchar2, paramArrayOfString, 0, 1) : 0; 
    if (paramArrayOfString[paramInt2].length() > paramInt3 && paramInt1 < paramArrayOfchar1.length && (paramArrayOfchar1[paramInt1] == paramArrayOfchar2[paramInt2] || paramArrayOfchar1[paramInt1] == paramArrayOfString[paramInt2].charAt(paramInt3)))
      return (paramInt1 == paramArrayOfchar1.length - 1) ? (distinguish(paramArrayOfchar1, paramArrayOfchar2, paramArrayOfString, paramInt2) ? paramInt2 : -1) : distinguish(paramArrayOfchar1, paramInt1 + 1, paramArrayOfchar2, paramArrayOfString, paramInt2, paramInt3 + 1); 
    int i = paramArrayOfString.length;
    paramInt3 = paramInt2 + 1;
    if (i > paramInt3 && paramInt1 < paramArrayOfchar1.length && (paramArrayOfchar1[paramInt1] == paramArrayOfchar2[paramInt3] || paramArrayOfchar1[paramInt1] == paramArrayOfString[paramInt3].charAt(0)))
      return (paramInt1 == paramArrayOfchar1.length - 1) ? (distinguish(paramArrayOfchar1, paramArrayOfchar2, paramArrayOfString, paramInt2) ? paramInt3 : -1) : distinguish(paramArrayOfchar1, 1 + paramInt1, paramArrayOfchar2, paramArrayOfString, paramInt3, 1); 
    if (paramArrayOfString.length > paramInt3)
      for (paramInt2 = 1; paramInt2 < paramInt1; paramInt2++) {
        if (distinguish(paramArrayOfchar1, paramInt1 - paramInt2, paramArrayOfchar2, paramArrayOfString, paramInt3, 0) != -1)
          return paramInt3; 
      }  
    return -1;
  }
  
  public MatchedResult getMatchedResult(String paramString1, String paramString2) {
    MatchedResult matchedResult = new MatchedResult();
    matchedResult.start = -1;
    matchedResult.end = -1;
    if (!isLoad)
      return matchedResult; 
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2))
      return matchedResult; 
    String str1 = paramString1.toUpperCase();
    String str2 = paramString2.toUpperCase();
    paramString1 = str1;
    paramString2 = str2;
    if (Math.min(str1.length(), str2.length()) > 10) {
      paramString1 = str1.substring(0, 10);
      paramString2 = str2.substring(0, 10);
    } 
    int i = paramString1.indexOf(paramString2);
    if (i >= 0) {
      matchedResult.start = i;
      matchedResult.end = i + paramString2.length() - 1;
    } 
    char[] arrayOfChar = new char[paramString2.length()];
    for (i = 0;; i++) {
      String[] arrayOfString;
      if (i >= paramString2.length()) {
        char[] arrayOfChar1 = new char[paramString1.length()];
        arrayOfString = new String[paramString1.length()];
        int j = paramString1.length();
        for (i = 0;; i++) {
          if (i >= j) {
            j = arrayOfChar[0];
            for (i = 0;; i++) {
              if (i >= arrayOfString.length)
                return matchedResult; 
              char c1 = arrayOfString[i].charAt(0);
              char c2 = arrayOfChar1[i];
              if (c1 == j || c2 == j) {
                int k = distinguish(arrayOfChar, 0, subCharRangeArray(arrayOfChar1, i, arrayOfChar1.length - 1), subStringRangeArray(arrayOfString, i, arrayOfString.length - 1), 0, 0);
                if (k != -1) {
                  matchedResult.start = i;
                  matchedResult.end = i + k;
                  return matchedResult;
                } 
              } 
            } 
            break;
          } 
          char c = paramString1.charAt(i);
          arrayOfChar1[i] = c;
          String str = getPinyin(c);
          if (!TextUtils.isEmpty(str)) {
            arrayOfString[i] = str.toUpperCase();
          } else {
            arrayOfString[i] = (new StringBuilder(String.valueOf(c))).toString();
          } 
        } 
        break;
      } 
      arrayOfChar[i] = arrayOfString.charAt(i);
    } 
  }
  
  public String getPinyin(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    if (!isLoad)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramString.length();
    for (byte b = 0;; b++) {
      if (b >= i)
        return stringBuilder.toString(); 
      stringBuilder.append(getPinyin(paramString.charAt(b)));
    } 
  }
  
  public static class MatchedResult {
    public int end = -1;
    
    public int start = -1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\PinyinUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
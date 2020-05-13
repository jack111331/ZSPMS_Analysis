package com.zz.lib.org.myapache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Rule {
  public static final String ALL = "ALL";
  
  public static final RPattern ALL_STRINGS_RMATCHER = new RPattern() {
      public boolean isMatch(CharSequence param1CharSequence) {
        return true;
      }
    };
  
  private static final String DOUBLE_QUOTE = "\"";
  
  private static final String HASH_INCLUDE = "#include";
  
  private static final Map<NameType, Map<RuleType, Map<String, List<Rule>>>> RULES = new EnumMap<NameType, Map<RuleType, Map<String, List<Rule>>>>(NameType.class);
  
  private final RPattern lContext;
  
  private final String pattern;
  
  private final PhonemeExpr phoneme;
  
  private final RPattern rContext;
  
  static {
    NameType[] arrayOfNameType = NameType.values();
    int i = arrayOfNameType.length;
    byte b = 0;
    label23: while (true) {
      if (b >= i)
        return; 
      NameType nameType = arrayOfNameType[b];
      EnumMap<RuleType, Object> enumMap = new EnumMap<RuleType, Object>(RuleType.class);
      RuleType[] arrayOfRuleType = RuleType.values();
      int j = arrayOfRuleType.length;
      byte b1 = 0;
      label21: while (true) {
        if (b1 >= j) {
          RULES.put(nameType, (Map)Collections.unmodifiableMap(enumMap));
          b++;
          continue label23;
        } 
        RuleType ruleType = arrayOfRuleType[b1];
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Iterator<String> iterator = Languages.getInstance(nameType).getLanguages().iterator();
        while (true) {
          if (!iterator.hasNext()) {
            if (!ruleType.equals(RuleType.RULES))
              hashMap.put("common", parseRules(createScanner(nameType, ruleType, "common"), createResourceName(nameType, ruleType, "common"))); 
            enumMap.put(ruleType, Collections.unmodifiableMap(hashMap));
            b1++;
            continue label21;
          } 
          String str = iterator.next();
          try {
            hashMap.put(str, parseRules(createScanner(nameType, ruleType, str), createResourceName(nameType, ruleType, str)));
          } catch (IllegalStateException illegalStateException) {
            throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), illegalStateException);
          } 
        } 
        break;
      } 
      break;
    } 
  }
  
  public Rule(String paramString1, String paramString2, String paramString3, PhonemeExpr paramPhonemeExpr) {
    this.pattern = paramString1;
    this.lContext = pattern(String.valueOf(paramString2) + "$");
    this.rContext = pattern("^" + paramString3);
    this.phoneme = paramPhonemeExpr;
  }
  
  private static boolean contains(CharSequence paramCharSequence, char paramChar) {
    for (byte b = 0;; b++) {
      if (b >= paramCharSequence.length())
        return false; 
      if (paramCharSequence.charAt(b) == paramChar)
        return true; 
    } 
  }
  
  private static String createResourceName(NameType paramNameType, RuleType paramRuleType, String paramString) {
    return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", new Object[] { paramNameType.getName(), paramRuleType.getName(), paramString });
  }
  
  private static Scanner createScanner(NameType paramNameType, RuleType paramRuleType, String paramString) {
    String str = createResourceName(paramNameType, paramRuleType, paramString);
    InputStream inputStream = Languages.class.getClassLoader().getResourceAsStream(str);
    if (inputStream == null)
      throw new IllegalArgumentException("Unable to load resource: " + str); 
    return new Scanner(inputStream, "UTF-8");
  }
  
  private static Scanner createScanner(String paramString) {
    String str = String.format("org/apache/commons/codec/language/bm/%s.txt", new Object[] { paramString });
    InputStream inputStream = Languages.class.getClassLoader().getResourceAsStream(str);
    if (inputStream == null)
      throw new IllegalArgumentException("Unable to load resource: " + str); 
    return new Scanner(inputStream, "UTF-8");
  }
  
  private static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    boolean bool = false;
    if (paramCharSequence2.length() > paramCharSequence1.length())
      return bool; 
    int i = paramCharSequence1.length() - 1;
    int j = paramCharSequence2.length() - 1;
    while (true) {
      if (j < 0)
        return true; 
      boolean bool1 = bool;
      if (paramCharSequence1.charAt(i) == paramCharSequence2.charAt(j)) {
        i--;
        j--;
        continue;
      } 
      return bool1;
    } 
  }
  
  public static List<Rule> getInstance(NameType paramNameType, RuleType paramRuleType, Languages.LanguageSet paramLanguageSet) {
    return paramLanguageSet.isSingleton() ? getInstance(paramNameType, paramRuleType, paramLanguageSet.getAny()) : getInstance(paramNameType, paramRuleType, "any");
  }
  
  public static List<Rule> getInstance(NameType paramNameType, RuleType paramRuleType, String paramString) {
    List<Rule> list = (List)((Map)((Map)RULES.get(paramNameType)).get(paramRuleType)).get(paramString);
    if (list == null)
      throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", new Object[] { paramNameType.getName(), paramRuleType.getName(), paramString })); 
    return list;
  }
  
  private static Phoneme parsePhoneme(String paramString) {
    int i = paramString.indexOf("[");
    if (i >= 0) {
      if (!paramString.endsWith("]"))
        throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'"); 
      return new Phoneme(paramString.substring(0, i), Languages.LanguageSet.from(new HashSet<String>(Arrays.asList(paramString.substring(i + 1, paramString.length() - 1).split("[+]")))));
    } 
    return new Phoneme(paramString, Languages.ANY_LANGUAGE);
  }
  
  private static PhonemeExpr parsePhonemeExpr(String paramString) {
    if (paramString.startsWith("(")) {
      if (!paramString.endsWith(")"))
        throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'"); 
      ArrayList<Phoneme> arrayList = new ArrayList();
      String str = paramString.substring(1, paramString.length() - 1);
      String[] arrayOfString = str.split("[|]");
      int i = arrayOfString.length;
      for (byte b = 0;; b++) {
        if (b >= i) {
          if (str.startsWith("|") || str.endsWith("|"))
            arrayList.add(new Phoneme("", Languages.ANY_LANGUAGE)); 
          return new PhonemeList(arrayList);
        } 
        arrayList.add(parsePhoneme(arrayOfString[b]));
      } 
    } 
    return parsePhoneme(paramString);
  }
  
  private static List<Rule> parseRules(Scanner paramScanner, String paramString) {
    ArrayList<Rule> arrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    while (true) {
      if (!paramScanner.hasNextLine())
        return arrayList; 
      int j = i + 1;
      String str1 = paramScanner.nextLine();
      String str2 = str1;
      if (bool) {
        i = j;
        if (str2.endsWith("*/")) {
          bool = false;
          i = j;
        } 
        continue;
      } 
      if (str2.startsWith("/*")) {
        bool = true;
        i = j;
        continue;
      } 
      i = str2.indexOf("//");
      String str3 = str2;
      if (i >= 0)
        str3 = str2.substring(0, i); 
      str2 = str3.trim();
      i = j;
      if (str2.length() != 0) {
        if (str2.startsWith("#include")) {
          str2 = str2.substring("#include".length()).trim();
          if (str2.contains(" ")) {
            System.err.println("Warining: malformed import statement: " + str1);
            i = j;
            continue;
          } 
          arrayList.addAll(parseRules(createScanner(str2), String.valueOf(paramString) + "->" + str2));
          i = j;
          continue;
        } 
        String[] arrayOfString = str2.split("\\s+");
        if (arrayOfString.length != 4) {
          System.err.println("Warning: malformed rule statement split into " + arrayOfString.length + " parts: " + str1);
          i = j;
          continue;
        } 
        try {
          str1 = stripQuotes(arrayOfString[0]);
          str2 = stripQuotes(arrayOfString[1]);
          str3 = stripQuotes(arrayOfString[2]);
          PhonemeExpr phonemeExpr = parsePhonemeExpr(stripQuotes(arrayOfString[3]));
          Rule rule = new Rule() {
              private final String loc;
              
              private final int myLine;
              
              public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Rule");
                stringBuilder.append("{line=").append(this.myLine);
                stringBuilder.append(", loc='").append(this.loc).append('\'');
                stringBuilder.append('}');
                return stringBuilder.toString();
              }
            };
          super(str1, str2, str3, phonemeExpr, j, paramString);
          arrayList.add(rule);
          i = j;
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new IllegalStateException("Problem parsing line " + j, illegalArgumentException);
        } 
      } 
    } 
  }
  
  private static RPattern pattern(String paramString) {
    boolean bool4;
    int i;
    final boolean shouldMatch = false;
    boolean bool2 = paramString.startsWith("^");
    boolean bool3 = paramString.endsWith("$");
    if (bool2) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    if (bool3) {
      i = paramString.length() - 1;
    } else {
      i = paramString.length();
    } 
    final String bContent = paramString.substring(bool4, i);
    if (!str.contains("[")) {
      if (bool2 && bool3)
        return (str.length() == 0) ? new RPattern() {
            public boolean isMatch(CharSequence param1CharSequence) {
              return (param1CharSequence.length() == 0);
            }
          } : new RPattern() {
            public boolean isMatch(CharSequence param1CharSequence) {
              return param1CharSequence.equals(content);
            }
          }; 
      if ((bool2 || bool3) && str.length() == 0)
        return ALL_STRINGS_RMATCHER; 
      if (bool2)
        return new RPattern() {
            public boolean isMatch(CharSequence param1CharSequence) {
              return Rule.startsWith(param1CharSequence, content);
            }
          }; 
      if (bool3)
        return new RPattern() {
            public boolean isMatch(CharSequence param1CharSequence) {
              return Rule.endsWith(param1CharSequence, content);
            }
          }; 
    } else {
      boolean bool5 = str.startsWith("[");
      boolean bool6 = str.endsWith("]");
      if (bool5 && bool6) {
        String str1 = str.substring(1, str.length() - 1);
        if (!str1.contains("[")) {
          bool6 = str1.startsWith("^");
          str = str1;
          if (bool6)
            str = str1.substring(1); 
          if (!bool6)
            bool1 = true; 
          if (bool2 && bool3)
            return new RPattern() {
                public boolean isMatch(CharSequence param1CharSequence) {
                  boolean bool = true;
                  if (param1CharSequence.length() != 1 || Rule.contains(bContent, param1CharSequence.charAt(0)) != shouldMatch)
                    bool = false; 
                  return bool;
                }
              }; 
          if (bool2)
            return new RPattern() {
                public boolean isMatch(CharSequence param1CharSequence) {
                  boolean bool1 = false;
                  boolean bool2 = bool1;
                  if (param1CharSequence.length() > 0) {
                    bool2 = bool1;
                    if (Rule.contains(bContent, param1CharSequence.charAt(0)) == shouldMatch)
                      bool2 = true; 
                  } 
                  return bool2;
                }
              }; 
          if (bool3)
            return new RPattern() {
                public boolean isMatch(CharSequence param1CharSequence) {
                  return (param1CharSequence.length() > 0 && Rule.contains(bContent, param1CharSequence.charAt(param1CharSequence.length() - 1)) == shouldMatch);
                }
              }; 
        } 
      } 
    } 
    return new RPattern(paramString) {
        Pattern pattern;
        
        public boolean isMatch(CharSequence param1CharSequence) {
          return this.pattern.matcher(param1CharSequence).find();
        }
      };
  }
  
  private static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    boolean bool = false;
    if (paramCharSequence2.length() > paramCharSequence1.length())
      return bool; 
    byte b = 0;
    while (true) {
      if (b >= paramCharSequence2.length())
        return true; 
      boolean bool1 = bool;
      if (paramCharSequence1.charAt(b) == paramCharSequence2.charAt(b)) {
        b++;
        continue;
      } 
      return bool1;
    } 
  }
  
  private static String stripQuotes(String paramString) {
    String str = paramString;
    if (paramString.startsWith("\""))
      str = paramString.substring(1); 
    paramString = str;
    if (str.endsWith("\""))
      paramString = str.substring(0, str.length() - 1); 
    return paramString;
  }
  
  public RPattern getLContext() {
    return this.lContext;
  }
  
  public String getPattern() {
    return this.pattern;
  }
  
  public PhonemeExpr getPhoneme() {
    return this.phoneme;
  }
  
  public RPattern getRContext() {
    return this.rContext;
  }
  
  public boolean patternAndContextMatches(CharSequence paramCharSequence, int paramInt) {
    boolean bool1 = false;
    if (paramInt < 0)
      throw new IndexOutOfBoundsException("Can not match pattern at negative indexes"); 
    int i = paramInt + this.pattern.length();
    if (i > paramCharSequence.length())
      return bool1; 
    boolean bool3 = paramCharSequence.subSequence(paramInt, i).equals(this.pattern);
    boolean bool4 = this.rContext.isMatch(paramCharSequence.subSequence(i, paramCharSequence.length()));
    boolean bool5 = this.lContext.isMatch(paramCharSequence.subSequence(0, paramInt));
    boolean bool2 = bool1;
    if (bool3) {
      bool2 = bool1;
      if (bool4) {
        bool2 = bool1;
        if (bool5)
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public static final class Phoneme implements PhonemeExpr {
    public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>() {
        public int compare(Rule.Phoneme param2Phoneme1, Rule.Phoneme param2Phoneme2) {
          byte b = 0;
          while (true) {
            if (b >= param2Phoneme1.phonemeText.length()) {
              if (param2Phoneme1.phonemeText.length() < param2Phoneme2.phonemeText.length())
                return -1; 
            } else {
              if (b >= param2Phoneme2.phonemeText.length())
                return 1; 
              int j = param2Phoneme1.phonemeText.charAt(b) - param2Phoneme2.phonemeText.charAt(b);
              int i = j;
              if (j == 0) {
                b++;
                continue;
              } 
              return i;
            } 
            return 0;
          } 
        }
      };
    
    private final Languages.LanguageSet languages;
    
    private final CharSequence phonemeText;
    
    public Phoneme(CharSequence param1CharSequence, Languages.LanguageSet param1LanguageSet) {
      this.phonemeText = param1CharSequence;
      this.languages = param1LanguageSet;
    }
    
    public Phoneme append(CharSequence param1CharSequence) {
      return new Phoneme(String.valueOf(this.phonemeText.toString()) + param1CharSequence.toString(), this.languages);
    }
    
    public Languages.LanguageSet getLanguages() {
      return this.languages;
    }
    
    public CharSequence getPhonemeText() {
      return this.phonemeText;
    }
    
    public Iterable<Phoneme> getPhonemes() {
      return Collections.singleton(this);
    }
    
    public Phoneme join(Phoneme param1Phoneme) {
      return new Phoneme(String.valueOf(this.phonemeText.toString()) + param1Phoneme.phonemeText.toString(), this.languages.restrictTo(param1Phoneme.languages));
    }
  }
  
  class null implements Comparator<Phoneme> {
    public int compare(Rule.Phoneme param1Phoneme1, Rule.Phoneme param1Phoneme2) {
      byte b = 0;
      while (true) {
        if (b >= param1Phoneme1.phonemeText.length()) {
          if (param1Phoneme1.phonemeText.length() < param1Phoneme2.phonemeText.length())
            return -1; 
        } else {
          if (b >= param1Phoneme2.phonemeText.length())
            return 1; 
          int j = param1Phoneme1.phonemeText.charAt(b) - param1Phoneme2.phonemeText.charAt(b);
          int i = j;
          if (j == 0) {
            b++;
            continue;
          } 
          return i;
        } 
        return 0;
      } 
    }
  }
  
  public static interface PhonemeExpr {
    Iterable<Rule.Phoneme> getPhonemes();
  }
  
  public static final class PhonemeList implements PhonemeExpr {
    private final List<Rule.Phoneme> phonemes;
    
    public PhonemeList(List<Rule.Phoneme> param1List) {
      this.phonemes = param1List;
    }
    
    public List<Rule.Phoneme> getPhonemes() {
      return this.phonemes;
    }
  }
  
  public static interface RPattern {
    boolean isMatch(CharSequence param1CharSequence);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\bm\Rule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
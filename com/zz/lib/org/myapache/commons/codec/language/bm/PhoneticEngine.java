package com.zz.lib.org.myapache.commons.codec.language.bm;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneticEngine {
  private static final Map<NameType, Set<String>> NAME_PREFIXES = new EnumMap<NameType, Set<String>>(NameType.class);
  
  private final boolean concat;
  
  private final Lang lang;
  
  private final NameType nameType;
  
  private final RuleType ruleType;
  
  static {
    NAME_PREFIXES.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "bar", "ben", "da", "de", "van", "von" }))));
    NAME_PREFIXES.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { 
                "al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", 
                "di", "do", "dos", "du", "van", "von" }))));
    NAME_PREFIXES.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { 
                "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", 
                "dos", "du", "van", "von" }))));
  }
  
  public PhoneticEngine(NameType paramNameType, RuleType paramRuleType, boolean paramBoolean) {
    if (paramRuleType == RuleType.RULES)
      throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES); 
    this.nameType = paramNameType;
    this.ruleType = paramRuleType;
    this.concat = paramBoolean;
    this.lang = Lang.instance(paramNameType);
  }
  
  private PhonemeBuilder applyFinalRules(PhonemeBuilder paramPhonemeBuilder, List<Rule> paramList) {
    if (paramList == null)
      throw new NullPointerException("finalRules can not be null"); 
    if (!paramList.isEmpty()) {
      TreeSet<Rule.Phoneme> treeSet = new TreeSet<Rule.Phoneme>(Rule.Phoneme.COMPARATOR);
      Iterator<Rule.Phoneme> iterator = paramPhonemeBuilder.getPhonemes().iterator();
      label20: while (true) {
        if (!iterator.hasNext())
          return new PhonemeBuilder(treeSet, null); 
        Rule.Phoneme phoneme = iterator.next();
        paramPhonemeBuilder = PhonemeBuilder.empty(phoneme.getLanguages());
        CharSequence charSequence = cacheSubSequence(phoneme.getPhonemeText());
        int i;
        for (i = 0;; i = rulesApplication.getI()) {
          if (i >= charSequence.length()) {
            treeSet.addAll(paramPhonemeBuilder.getPhonemes());
            continue label20;
          } 
          RulesApplication rulesApplication = (new RulesApplication(paramList, charSequence, paramPhonemeBuilder, i)).invoke();
          boolean bool = rulesApplication.isFound();
          PhonemeBuilder phonemeBuilder = rulesApplication.getPhonemeBuilder();
          paramPhonemeBuilder = phonemeBuilder;
          if (!bool)
            paramPhonemeBuilder = phonemeBuilder.append(charSequence.subSequence(i, i + 1)); 
        } 
        break;
      } 
    } 
    return paramPhonemeBuilder;
  }
  
  private static CharSequence cacheSubSequence(final CharSequence cached) {
    return new CharSequence() {
        public char charAt(int param1Int) {
          return cached.charAt(param1Int);
        }
        
        public int length() {
          return cached.length();
        }
        
        public CharSequence subSequence(int param1Int1, int param1Int2) {
          if (param1Int1 == param1Int2)
            return ""; 
          CharSequence charSequence2 = cache[param1Int1][param1Int2 - 1];
          CharSequence charSequence1 = charSequence2;
          if (charSequence2 == null) {
            charSequence1 = cached.subSequence(param1Int1, param1Int2);
            cache[param1Int1][param1Int2 - 1] = charSequence1;
          } 
          return charSequence1;
        }
      };
  }
  
  private static String join(Iterable<String> paramIterable, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramIterable.iterator();
    if (iterator.hasNext())
      stringBuilder.append(iterator.next()); 
    while (true) {
      if (!iterator.hasNext())
        return stringBuilder.toString(); 
      stringBuilder.append(paramString).append(iterator.next());
    } 
  }
  
  public String encode(String paramString) {
    return encode(paramString, this.lang.guessLanguages(paramString));
  }
  
  public String encode(String paramString, Languages.LanguageSet paramLanguageSet) {
    // Byte code:
    //   0: aload_0
    //   1: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   4: getstatic com/zz/lib/org/myapache/commons/codec/language/bm/RuleType.RULES : Lcom/zz/lib/org/myapache/commons/codec/language/bm/RuleType;
    //   7: aload_2
    //   8: invokestatic getInstance : (Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;Lcom/zz/lib/org/myapache/commons/codec/language/bm/RuleType;Lcom/zz/lib/org/myapache/commons/codec/language/bm/Languages$LanguageSet;)Ljava/util/List;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   16: aload_0
    //   17: getfield ruleType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/RuleType;
    //   20: ldc_w 'common'
    //   23: invokestatic getInstance : (Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;Lcom/zz/lib/org/myapache/commons/codec/language/bm/RuleType;Ljava/lang/String;)Ljava/util/List;
    //   26: astore #4
    //   28: aload_0
    //   29: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   32: aload_0
    //   33: getfield ruleType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/RuleType;
    //   36: aload_2
    //   37: invokestatic getInstance : (Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;Lcom/zz/lib/org/myapache/commons/codec/language/bm/RuleType;Lcom/zz/lib/org/myapache/commons/codec/language/bm/Languages$LanguageSet;)Ljava/util/List;
    //   40: astore #5
    //   42: aload_1
    //   43: getstatic java/util/Locale.ENGLISH : Ljava/util/Locale;
    //   46: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   49: bipush #45
    //   51: bipush #32
    //   53: invokevirtual replace : (CC)Ljava/lang/String;
    //   56: invokevirtual trim : ()Ljava/lang/String;
    //   59: astore #6
    //   61: aload_0
    //   62: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   65: getstatic com/zz/lib/org/myapache/commons/codec/language/bm/NameType.GENERIC : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   68: if_acmpne -> 197
    //   71: aload #6
    //   73: invokevirtual length : ()I
    //   76: iconst_2
    //   77: if_icmplt -> 165
    //   80: aload #6
    //   82: iconst_0
    //   83: iconst_2
    //   84: invokevirtual substring : (II)Ljava/lang/String;
    //   87: ldc_w 'd''
    //   90: invokevirtual equals : (Ljava/lang/Object;)Z
    //   93: ifeq -> 165
    //   96: aload #6
    //   98: iconst_2
    //   99: invokevirtual substring : (I)Ljava/lang/String;
    //   102: astore_1
    //   103: new java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 'd'
    //   110: invokespecial <init> : (Ljava/lang/String;)V
    //   113: aload_1
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: astore_2
    //   121: new java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w '('
    //   128: invokespecial <init> : (Ljava/lang/String;)V
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual encode : (Ljava/lang/String;)Ljava/lang/String;
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w ')-('
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: aload_2
    //   147: invokevirtual encode : (Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w ')'
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual toString : ()Ljava/lang/String;
    //   162: astore_1
    //   163: aload_1
    //   164: areturn
    //   165: getstatic com/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine.NAME_PREFIXES : Ljava/util/Map;
    //   168: aload_0
    //   169: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   172: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   177: checkcast java/util/Set
    //   180: invokeinterface iterator : ()Ljava/util/Iterator;
    //   185: astore #7
    //   187: aload #7
    //   189: invokeinterface hasNext : ()Z
    //   194: ifne -> 284
    //   197: aload #6
    //   199: ldc_w '\s+'
    //   202: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   205: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   208: astore #8
    //   210: new java/util/ArrayList
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: astore_1
    //   218: invokestatic $SWITCH_TABLE$com$zz$lib$org$myapache$commons$codec$language$bm$NameType : ()[I
    //   221: aload_0
    //   222: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   225: invokevirtual ordinal : ()I
    //   228: iaload
    //   229: tableswitch default -> 256, 1 -> 539, 2 -> 573, 3 -> 399
    //   256: new java/lang/IllegalStateException
    //   259: dup
    //   260: new java/lang/StringBuilder
    //   263: dup
    //   264: ldc_w 'Unreachable case: '
    //   267: invokespecial <init> : (Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   274: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: invokespecial <init> : (Ljava/lang/String;)V
    //   283: athrow
    //   284: aload #7
    //   286: invokeinterface next : ()Ljava/lang/Object;
    //   291: checkcast java/lang/String
    //   294: astore_1
    //   295: aload #6
    //   297: new java/lang/StringBuilder
    //   300: dup
    //   301: aload_1
    //   302: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   305: invokespecial <init> : (Ljava/lang/String;)V
    //   308: ldc_w ' '
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual toString : ()Ljava/lang/String;
    //   317: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   320: ifeq -> 187
    //   323: aload #6
    //   325: aload_1
    //   326: invokevirtual length : ()I
    //   329: iconst_1
    //   330: iadd
    //   331: invokevirtual substring : (I)Ljava/lang/String;
    //   334: astore_2
    //   335: new java/lang/StringBuilder
    //   338: dup
    //   339: aload_1
    //   340: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   343: invokespecial <init> : (Ljava/lang/String;)V
    //   346: aload_2
    //   347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: astore_1
    //   354: new java/lang/StringBuilder
    //   357: dup
    //   358: ldc_w '('
    //   361: invokespecial <init> : (Ljava/lang/String;)V
    //   364: aload_0
    //   365: aload_2
    //   366: invokevirtual encode : (Ljava/lang/String;)Ljava/lang/String;
    //   369: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc_w ')-('
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_0
    //   379: aload_1
    //   380: invokevirtual encode : (Ljava/lang/String;)Ljava/lang/String;
    //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc_w ')'
    //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual toString : ()Ljava/lang/String;
    //   395: astore_1
    //   396: goto -> 163
    //   399: aload #8
    //   401: invokeinterface iterator : ()Ljava/util/Iterator;
    //   406: astore #7
    //   408: aload #7
    //   410: invokeinterface hasNext : ()Z
    //   415: ifne -> 503
    //   418: aload_1
    //   419: getstatic com/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine.NAME_PREFIXES : Ljava/util/Map;
    //   422: aload_0
    //   423: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   426: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   431: checkcast java/util/Collection
    //   434: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   439: pop
    //   440: aload_0
    //   441: getfield concat : Z
    //   444: ifeq -> 585
    //   447: aload_1
    //   448: ldc_w ' '
    //   451: invokestatic join : (Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;
    //   454: astore_1
    //   455: aload_2
    //   456: invokestatic empty : (Lcom/zz/lib/org/myapache/commons/codec/language/bm/Languages$LanguageSet;)Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;
    //   459: astore_2
    //   460: aload_1
    //   461: invokestatic cacheSubSequence : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   464: astore #6
    //   466: iconst_0
    //   467: istore #9
    //   469: aload_2
    //   470: astore_1
    //   471: iload #9
    //   473: aload #6
    //   475: invokeinterface length : ()I
    //   480: if_icmplt -> 678
    //   483: aload_0
    //   484: aload_0
    //   485: aload_1
    //   486: aload #4
    //   488: invokespecial applyFinalRules : (Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;Ljava/util/List;)Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;
    //   491: aload #5
    //   493: invokespecial applyFinalRules : (Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;Ljava/util/List;)Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;
    //   496: invokevirtual makeString : ()Ljava/lang/String;
    //   499: astore_1
    //   500: goto -> 163
    //   503: aload #7
    //   505: invokeinterface next : ()Ljava/lang/Object;
    //   510: checkcast java/lang/String
    //   513: ldc_w '''
    //   516: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   519: astore #6
    //   521: aload_1
    //   522: aload #6
    //   524: aload #6
    //   526: arraylength
    //   527: iconst_1
    //   528: isub
    //   529: aaload
    //   530: invokeinterface add : (Ljava/lang/Object;)Z
    //   535: pop
    //   536: goto -> 408
    //   539: aload_1
    //   540: aload #8
    //   542: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   547: pop
    //   548: aload_1
    //   549: getstatic com/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine.NAME_PREFIXES : Ljava/util/Map;
    //   552: aload_0
    //   553: getfield nameType : Lcom/zz/lib/org/myapache/commons/codec/language/bm/NameType;
    //   556: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   561: checkcast java/util/Collection
    //   564: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   569: pop
    //   570: goto -> 440
    //   573: aload_1
    //   574: aload #8
    //   576: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   581: pop
    //   582: goto -> 440
    //   585: aload_1
    //   586: invokeinterface size : ()I
    //   591: iconst_1
    //   592: if_icmpne -> 614
    //   595: aload #8
    //   597: invokeinterface iterator : ()Ljava/util/Iterator;
    //   602: invokeinterface next : ()Ljava/lang/Object;
    //   607: checkcast java/lang/String
    //   610: astore_1
    //   611: goto -> 455
    //   614: new java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial <init> : ()V
    //   621: astore_2
    //   622: aload_1
    //   623: invokeinterface iterator : ()Ljava/util/Iterator;
    //   628: astore_1
    //   629: aload_1
    //   630: invokeinterface hasNext : ()Z
    //   635: ifne -> 647
    //   638: aload_2
    //   639: iconst_1
    //   640: invokevirtual substring : (I)Ljava/lang/String;
    //   643: astore_1
    //   644: goto -> 163
    //   647: aload_1
    //   648: invokeinterface next : ()Ljava/lang/Object;
    //   653: checkcast java/lang/String
    //   656: astore #5
    //   658: aload_2
    //   659: ldc_w '-'
    //   662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_0
    //   666: aload #5
    //   668: invokevirtual encode : (Ljava/lang/String;)Ljava/lang/String;
    //   671: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: goto -> 629
    //   678: new com/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$RulesApplication
    //   681: dup
    //   682: aload_3
    //   683: aload #6
    //   685: aload_1
    //   686: iload #9
    //   688: invokespecial <init> : (Ljava/util/List;Ljava/lang/CharSequence;Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;I)V
    //   691: invokevirtual invoke : ()Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$RulesApplication;
    //   694: astore_1
    //   695: aload_1
    //   696: invokevirtual getI : ()I
    //   699: istore #9
    //   701: aload_1
    //   702: invokevirtual getPhonemeBuilder : ()Lcom/zz/lib/org/myapache/commons/codec/language/bm/PhoneticEngine$PhonemeBuilder;
    //   705: astore_1
    //   706: goto -> 471
  }
  
  public Lang getLang() {
    return this.lang;
  }
  
  public NameType getNameType() {
    return this.nameType;
  }
  
  public RuleType getRuleType() {
    return this.ruleType;
  }
  
  public boolean isConcat() {
    return this.concat;
  }
  
  static final class PhonemeBuilder {
    private final Set<Rule.Phoneme> phonemes;
    
    private PhonemeBuilder(Set<Rule.Phoneme> param1Set) {
      this.phonemes = param1Set;
    }
    
    public static PhonemeBuilder empty(Languages.LanguageSet param1LanguageSet) {
      return new PhonemeBuilder(Collections.singleton(new Rule.Phoneme("", param1LanguageSet)));
    }
    
    public PhonemeBuilder append(CharSequence param1CharSequence) {
      HashSet<Rule.Phoneme> hashSet = new HashSet();
      Iterator<Rule.Phoneme> iterator = this.phonemes.iterator();
      while (true) {
        if (!iterator.hasNext())
          return new PhonemeBuilder(hashSet); 
        hashSet.add(((Rule.Phoneme)iterator.next()).append(param1CharSequence));
      } 
    }
    
    public PhonemeBuilder apply(Rule.PhonemeExpr param1PhonemeExpr) {
      HashSet<Rule.Phoneme> hashSet = new HashSet();
      Iterator<Rule.Phoneme> iterator = this.phonemes.iterator();
      while (true) {
        if (!iterator.hasNext())
          return new PhonemeBuilder(hashSet); 
        Rule.Phoneme phoneme = iterator.next();
        Iterator<Rule.Phoneme> iterator1 = param1PhonemeExpr.getPhonemes().iterator();
        while (iterator1.hasNext()) {
          Rule.Phoneme phoneme1 = phoneme.join(iterator1.next());
          if (!phoneme1.getLanguages().isEmpty())
            hashSet.add(phoneme1); 
        } 
      } 
    }
    
    public Set<Rule.Phoneme> getPhonemes() {
      return this.phonemes;
    }
    
    public String makeString() {
      StringBuilder stringBuilder = new StringBuilder();
      Iterator<Rule.Phoneme> iterator = this.phonemes.iterator();
      while (true) {
        if (!iterator.hasNext())
          return stringBuilder.toString(); 
        Rule.Phoneme phoneme = iterator.next();
        if (stringBuilder.length() > 0)
          stringBuilder.append("|"); 
        stringBuilder.append(phoneme.getPhonemeText());
      } 
    }
  }
  
  private static final class RulesApplication {
    private final List<Rule> finalRules;
    
    private boolean found;
    
    private int i;
    
    private final CharSequence input;
    
    private PhoneticEngine.PhonemeBuilder phonemeBuilder;
    
    public RulesApplication(List<Rule> param1List, CharSequence param1CharSequence, PhoneticEngine.PhonemeBuilder param1PhonemeBuilder, int param1Int) {
      if (param1List == null)
        throw new NullPointerException("The finalRules argument must not be null"); 
      this.finalRules = param1List;
      this.phonemeBuilder = param1PhonemeBuilder;
      this.input = param1CharSequence;
      this.i = param1Int;
    }
    
    public int getI() {
      return this.i;
    }
    
    public PhoneticEngine.PhonemeBuilder getPhonemeBuilder() {
      return this.phonemeBuilder;
    }
    
    public RulesApplication invoke() {
      this.found = false;
      int i = 0;
      Iterator<Rule> iterator = this.finalRules.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Rule rule = iterator.next();
          int j = rule.getPattern().length();
          i = j;
          if (rule.patternAndContextMatches(this.input, this.i)) {
            this.phonemeBuilder = this.phonemeBuilder.apply(rule.getPhoneme());
            this.found = true;
            i = j;
          } else {
            continue;
          } 
        } 
        if (!this.found)
          i = 1; 
        this.i += i;
        return this;
      } 
    }
    
    public boolean isFound() {
      return this.found;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\bm\PhoneticEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
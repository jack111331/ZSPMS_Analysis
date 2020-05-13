package com.zz.lib.org.myapache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Lang {
  private static final String LANGUAGE_RULES_RN = "org/apache/commons/codec/language/bm/lang.txt";
  
  private static final Map<NameType, Lang> Langs = new EnumMap<NameType, Lang>(NameType.class);
  
  private final Languages languages;
  
  private final List<LangRule> rules;
  
  static {
    NameType[] arrayOfNameType = NameType.values();
    int i = arrayOfNameType.length;
    for (byte b = 0;; b++) {
      if (b >= i)
        return; 
      NameType nameType = arrayOfNameType[b];
      Langs.put(nameType, loadFromResource("org/apache/commons/codec/language/bm/lang.txt", Languages.getInstance(nameType)));
    } 
  }
  
  private Lang(List<LangRule> paramList, Languages paramLanguages) {
    this.rules = Collections.unmodifiableList(paramList);
    this.languages = paramLanguages;
  }
  
  public static Lang instance(NameType paramNameType) {
    return Langs.get(paramNameType);
  }
  
  public static Lang loadFromResource(String paramString, Languages paramLanguages) {
    ArrayList<LangRule> arrayList = new ArrayList();
    InputStream inputStream = Lang.class.getClassLoader().getResourceAsStream(paramString);
    if (inputStream == null)
      throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt"); 
    Scanner scanner = new Scanner(inputStream, "UTF-8");
    boolean bool = false;
    while (true) {
      if (!scanner.hasNextLine())
        return new Lang(arrayList, paramLanguages); 
      String str2 = scanner.nextLine();
      String str1 = str2;
      if (bool) {
        if (str1.endsWith("*/"))
          bool = false; 
        continue;
      } 
      if (str1.startsWith("/*")) {
        bool = true;
        continue;
      } 
      int i = str1.indexOf("//");
      String str3 = str1;
      if (i >= 0)
        str3 = str1.substring(0, i); 
      str1 = str3.trim();
      if (str1.length() != 0) {
        String[] arrayOfString1 = str1.split("\\s+");
        if (arrayOfString1.length != 3) {
          System.err.println("Warning: malformed line '" + str2 + "'");
          continue;
        } 
        Pattern pattern = Pattern.compile(arrayOfString1[0]);
        String[] arrayOfString2 = arrayOfString1[1].split("\\+");
        boolean bool1 = arrayOfString1[2].equals("true");
        arrayList.add(new LangRule(pattern, new HashSet(Arrays.asList((Object[])arrayOfString2)), bool1, null));
      } 
    } 
  }
  
  public String guessLanguage(String paramString) {
    Languages.LanguageSet languageSet = guessLanguages(paramString);
    return languageSet.isSingleton() ? languageSet.getAny() : "any";
  }
  
  public Languages.LanguageSet guessLanguages(String paramString) {
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    HashSet<String> hashSet = new HashSet<String>(this.languages.getLanguages());
    Iterator<LangRule> iterator = this.rules.iterator();
    while (true) {
      Languages.LanguageSet languageSet1;
      Languages.LanguageSet languageSet2;
      if (!iterator.hasNext()) {
        languageSet2 = Languages.LanguageSet.from(hashSet);
        languageSet1 = languageSet2;
        if (languageSet2.equals(Languages.NO_LANGUAGES))
          languageSet1 = Languages.ANY_LANGUAGE; 
        return languageSet1;
      } 
      LangRule langRule = languageSet2.next();
      if (langRule.matches((String)languageSet1)) {
        if (langRule.acceptOnMatch) {
          hashSet.retainAll(langRule.languages);
          continue;
        } 
        hashSet.removeAll(langRule.languages);
      } 
    } 
  }
  
  private static final class LangRule {
    private final boolean acceptOnMatch;
    
    private final Set<String> languages;
    
    private final Pattern pattern;
    
    private LangRule(Pattern param1Pattern, Set<String> param1Set, boolean param1Boolean) {
      this.pattern = param1Pattern;
      this.languages = param1Set;
      this.acceptOnMatch = param1Boolean;
    }
    
    public boolean matches(String param1String) {
      return this.pattern.matcher(param1String).find();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\bm\Lang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
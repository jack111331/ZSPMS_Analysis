package com.zz.lib.org.myapache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Languages {
  public static final String ANY = "any";
  
  public static final LanguageSet ANY_LANGUAGE;
  
  private static final Map<NameType, Languages> LANGUAGES = new EnumMap<NameType, Languages>(NameType.class);
  
  public static final LanguageSet NO_LANGUAGES;
  
  private final Set<String> languages;
  
  static {
    NameType[] arrayOfNameType = NameType.values();
    int i = arrayOfNameType.length;
    for (byte b = 0;; b++) {
      if (b >= i) {
        NO_LANGUAGES = new LanguageSet() {
            public boolean contains(String param1String) {
              return false;
            }
            
            public String getAny() {
              throw new NoSuchElementException("Can't fetch any language from the empty language set.");
            }
            
            public boolean isEmpty() {
              return true;
            }
            
            public boolean isSingleton() {
              return false;
            }
            
            public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
              return this;
            }
            
            public String toString() {
              return "NO_LANGUAGES";
            }
          };
        ANY_LANGUAGE = new LanguageSet() {
            public boolean contains(String param1String) {
              return true;
            }
            
            public String getAny() {
              throw new NoSuchElementException("Can't fetch any language from the any language set.");
            }
            
            public boolean isEmpty() {
              return false;
            }
            
            public boolean isSingleton() {
              return false;
            }
            
            public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
              return param1LanguageSet;
            }
            
            public String toString() {
              return "ANY_LANGUAGE";
            }
          };
        return;
      } 
      NameType nameType = arrayOfNameType[b];
      LANGUAGES.put(nameType, getInstance(langResourceName(nameType)));
    } 
  }
  
  private Languages(Set<String> paramSet) {
    this.languages = paramSet;
  }
  
  public static Languages getInstance(NameType paramNameType) {
    return LANGUAGES.get(paramNameType);
  }
  
  public static Languages getInstance(String paramString) {
    HashSet<? extends String> hashSet = new HashSet();
    InputStream inputStream = Languages.class.getClassLoader().getResourceAsStream(paramString);
    if (inputStream == null)
      throw new IllegalArgumentException("Unable to resolve required resource: " + paramString); 
    Scanner scanner = new Scanner(inputStream, "UTF-8");
    boolean bool = false;
    while (true) {
      if (!scanner.hasNextLine())
        return new Languages(Collections.unmodifiableSet(hashSet)); 
      String str = scanner.nextLine().trim();
      if (bool) {
        if (str.endsWith("*/"))
          bool = false; 
        continue;
      } 
      if (str.startsWith("/*")) {
        bool = true;
        continue;
      } 
      if (str.length() > 0)
        hashSet.add(str); 
    } 
  }
  
  private static String langResourceName(NameType paramNameType) {
    return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", new Object[] { paramNameType.getName() });
  }
  
  public Set<String> getLanguages() {
    return this.languages;
  }
  
  public static abstract class LanguageSet {
    public static LanguageSet from(Set<String> param1Set) {
      return param1Set.isEmpty() ? Languages.NO_LANGUAGES : new Languages.SomeLanguages(param1Set, null);
    }
    
    public abstract boolean contains(String param1String);
    
    public abstract String getAny();
    
    public abstract boolean isEmpty();
    
    public abstract boolean isSingleton();
    
    public abstract LanguageSet restrictTo(LanguageSet param1LanguageSet);
  }
  
  public static final class SomeLanguages extends LanguageSet {
    private final Set<String> languages;
    
    private SomeLanguages(Set<String> param1Set) {
      this.languages = Collections.unmodifiableSet(param1Set);
    }
    
    public boolean contains(String param1String) {
      return this.languages.contains(param1String);
    }
    
    public String getAny() {
      return this.languages.iterator().next();
    }
    
    public Set<String> getLanguages() {
      return this.languages;
    }
    
    public boolean isEmpty() {
      return this.languages.isEmpty();
    }
    
    public boolean isSingleton() {
      boolean bool = true;
      if (this.languages.size() != 1)
        bool = false; 
      return bool;
    }
    
    public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
      if (param1LanguageSet == Languages.NO_LANGUAGES)
        return param1LanguageSet; 
      Languages.LanguageSet languageSet = this;
      if (param1LanguageSet != Languages.ANY_LANGUAGE) {
        param1LanguageSet = param1LanguageSet;
        languageSet = this;
        if (!((SomeLanguages)param1LanguageSet).languages.containsAll(this.languages)) {
          HashSet<String> hashSet = new HashSet<String>(this.languages);
          hashSet.retainAll(((SomeLanguages)param1LanguageSet).languages);
          languageSet = from(hashSet);
        } 
      } 
      return languageSet;
    }
    
    public String toString() {
      return "Languages(" + this.languages.toString() + ")";
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\bm\Languages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
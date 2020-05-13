package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
  private static final int DEFAULT_FLAGS = 2;
  
  private static final BidiFormatter DEFAULT_LTR_INSTANCE;
  
  private static final BidiFormatter DEFAULT_RTL_INSTANCE;
  
  private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  
  private static final int DIR_LTR = -1;
  
  private static final int DIR_RTL = 1;
  
  private static final int DIR_UNKNOWN = 0;
  
  private static final String EMPTY_STRING = "";
  
  private static final int FLAG_STEREO_RESET = 2;
  
  private static final char LRE = '‪';
  
  private static final char LRM = '‎';
  
  private static final String LRM_STRING = Character.toString('‎');
  
  private static final char PDF = '‬';
  
  private static final char RLE = '‫';
  
  private static final char RLM = '‏';
  
  private static final String RLM_STRING = Character.toString('‏');
  
  private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  
  private final int mFlags;
  
  private final boolean mIsRtlContext;
  
  static {
    DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  }
  
  private BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    this.mIsRtlContext = paramBoolean;
    this.mFlags = paramInt;
    this.mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  private static int getEntryDir(CharSequence paramCharSequence) {
    return (new DirectionalityEstimator(paramCharSequence, false)).getEntryDir();
  }
  
  private static int getExitDir(CharSequence paramCharSequence) {
    return (new DirectionalityEstimator(paramCharSequence, false)).getExitDir();
  }
  
  public static BidiFormatter getInstance() {
    return (new Builder()).build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale) {
    return (new Builder(paramLocale)).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean) {
    return (new Builder(paramBoolean)).build();
  }
  
  private static boolean isRtlLocale(Locale paramLocale) {
    boolean bool = true;
    if (TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) != 1)
      bool = false; 
    return bool;
  }
  
  private String markAfter(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    return (!this.mIsRtlContext && (bool || getExitDir(paramCharSequence) == 1)) ? LRM_STRING : ((this.mIsRtlContext && (!bool || getExitDir(paramCharSequence) == -1)) ? RLM_STRING : "");
  }
  
  private String markBefore(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    return (!this.mIsRtlContext && (bool || getEntryDir(paramCharSequence) == 1)) ? LRM_STRING : ((this.mIsRtlContext && (!bool || getEntryDir(paramCharSequence) == -1)) ? RLM_STRING : "");
  }
  
  public boolean getStereoReset() {
    return ((this.mFlags & 0x2) != 0);
  }
  
  public boolean isRtl(CharSequence paramCharSequence) {
    return this.mDefaultTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public boolean isRtl(String paramString) {
    return isRtl(paramString);
  }
  
  public boolean isRtlContext() {
    return this.mIsRtlContext;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence) {
    return unicodeWrap(paramCharSequence, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    return unicodeWrap(paramCharSequence, paramTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean) {
    if (paramCharSequence == null)
      return null; 
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    if (getStereoReset() && paramBoolean) {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      } 
      spannableStringBuilder.append(markBefore(paramCharSequence, paramTextDirectionHeuristicCompat));
    } 
    if (bool != this.mIsRtlContext) {
      char c;
      if (bool) {
        char c1 = '‫';
        c = c1;
      } else {
        char c1 = '‪';
        c = c1;
      } 
      spannableStringBuilder.append(c);
      spannableStringBuilder.append(paramCharSequence);
      spannableStringBuilder.append('‬');
    } else {
      spannableStringBuilder.append(paramCharSequence);
    } 
    if (paramBoolean) {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      } 
      spannableStringBuilder.append(markAfter(paramCharSequence, paramTextDirectionHeuristicCompat));
    } 
    return (CharSequence)spannableStringBuilder;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, boolean paramBoolean) {
    return unicodeWrap(paramCharSequence, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public String unicodeWrap(String paramString) {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean) {
    return (paramString == null) ? null : unicodeWrap(paramString, paramTextDirectionHeuristicCompat, paramBoolean).toString();
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean) {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public static final class Builder {
    private int mFlags;
    
    private boolean mIsRtlContext;
    
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
    
    public Builder() {
      initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
    }
    
    public Builder(Locale param1Locale) {
      initialize(BidiFormatter.isRtlLocale(param1Locale));
    }
    
    public Builder(boolean param1Boolean) {
      initialize(param1Boolean);
    }
    
    private static BidiFormatter getDefaultInstanceFromContext(boolean param1Boolean) {
      return param1Boolean ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
    }
    
    private void initialize(boolean param1Boolean) {
      this.mIsRtlContext = param1Boolean;
      this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
      this.mFlags = 2;
    }
    
    public BidiFormatter build() {
      return (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? getDefaultInstanceFromContext(this.mIsRtlContext) : new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
    }
    
    public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat param1TextDirectionHeuristicCompat) {
      this.mTextDirectionHeuristicCompat = param1TextDirectionHeuristicCompat;
      return this;
    }
    
    public Builder stereoReset(boolean param1Boolean) {
      if (param1Boolean) {
        this.mFlags |= 0x2;
        return this;
      } 
      this.mFlags &= 0xFFFFFFFD;
      return this;
    }
  }
  
  private static class DirectionalityEstimator {
    private static final byte[] DIR_TYPE_CACHE = new byte[1792];
    
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    
    private int charIndex;
    
    private final boolean isHtml;
    
    private char lastChar;
    
    private final int length;
    
    private final CharSequence text;
    
    static {
      for (byte b = 0; b < '܀'; b++)
        DIR_TYPE_CACHE[b] = Character.getDirectionality(b); 
    }
    
    DirectionalityEstimator(CharSequence param1CharSequence, boolean param1Boolean) {
      this.text = param1CharSequence;
      this.isHtml = param1Boolean;
      this.length = param1CharSequence.length();
    }
    
    private static byte getCachedDirectionality(char param1Char) {
      if (param1Char < '܀')
        return DIR_TYPE_CACHE[param1Char]; 
      return Character.getDirectionality(param1Char);
    }
    
    private byte skipEntityBackward() {
      // Byte code:
      //   0: aload_0
      //   1: getfield charIndex : I
      //   4: istore_1
      //   5: aload_0
      //   6: getfield charIndex : I
      //   9: ifle -> 67
      //   12: aload_0
      //   13: getfield text : Ljava/lang/CharSequence;
      //   16: astore_2
      //   17: aload_0
      //   18: getfield charIndex : I
      //   21: iconst_1
      //   22: isub
      //   23: istore_3
      //   24: aload_0
      //   25: iload_3
      //   26: putfield charIndex : I
      //   29: aload_0
      //   30: aload_2
      //   31: iload_3
      //   32: invokeinterface charAt : (I)C
      //   37: putfield lastChar : C
      //   40: aload_0
      //   41: getfield lastChar : C
      //   44: bipush #38
      //   46: if_icmpne -> 58
      //   49: bipush #12
      //   51: istore_3
      //   52: iload_3
      //   53: istore #4
      //   55: iload #4
      //   57: ireturn
      //   58: aload_0
      //   59: getfield lastChar : C
      //   62: bipush #59
      //   64: if_icmpne -> 5
      //   67: aload_0
      //   68: iload_1
      //   69: putfield charIndex : I
      //   72: aload_0
      //   73: bipush #59
      //   75: i2c
      //   76: putfield lastChar : C
      //   79: bipush #13
      //   81: istore_3
      //   82: iload_3
      //   83: istore #4
      //   85: goto -> 55
    }
    
    private byte skipEntityForward() {
      while (this.charIndex < this.length) {
        CharSequence charSequence = this.text;
        int i = this.charIndex;
        this.charIndex = i + 1;
        i = charSequence.charAt(i);
        this.lastChar = (char)i;
        if (i == 59)
          break; 
      } 
      return 12;
    }
    
    private byte skipTagBackward() {
      int i = this.charIndex;
      while (true) {
        if (this.charIndex > 0) {
          CharSequence charSequence = this.text;
          int j = this.charIndex - 1;
          this.charIndex = j;
          this.lastChar = charSequence.charAt(j);
          if (this.lastChar == '<') {
            i = 12;
            return i;
          } 
          if (this.lastChar != '>') {
            if (this.lastChar == '"' || this.lastChar == '\'') {
              j = this.lastChar;
              while (this.charIndex > 0) {
                charSequence = this.text;
                int k = this.charIndex - 1;
                this.charIndex = k;
                k = charSequence.charAt(k);
                this.lastChar = (char)k;
                if (k != j);
              } 
            } 
            continue;
          } 
        } 
        this.charIndex = i;
        this.lastChar = (char)'>';
        i = 13;
        return i;
      } 
    }
    
    private byte skipTagForward() {
      // Byte code:
      //   0: aload_0
      //   1: getfield charIndex : I
      //   4: istore_1
      //   5: aload_0
      //   6: getfield charIndex : I
      //   9: aload_0
      //   10: getfield length : I
      //   13: if_icmpge -> 141
      //   16: aload_0
      //   17: getfield text : Ljava/lang/CharSequence;
      //   20: astore_2
      //   21: aload_0
      //   22: getfield charIndex : I
      //   25: istore_3
      //   26: aload_0
      //   27: iload_3
      //   28: iconst_1
      //   29: iadd
      //   30: putfield charIndex : I
      //   33: aload_0
      //   34: aload_2
      //   35: iload_3
      //   36: invokeinterface charAt : (I)C
      //   41: putfield lastChar : C
      //   44: aload_0
      //   45: getfield lastChar : C
      //   48: bipush #62
      //   50: if_icmpne -> 62
      //   53: bipush #12
      //   55: istore_1
      //   56: iload_1
      //   57: istore #4
      //   59: iload #4
      //   61: ireturn
      //   62: aload_0
      //   63: getfield lastChar : C
      //   66: bipush #34
      //   68: if_icmpeq -> 80
      //   71: aload_0
      //   72: getfield lastChar : C
      //   75: bipush #39
      //   77: if_icmpne -> 5
      //   80: aload_0
      //   81: getfield lastChar : C
      //   84: istore_3
      //   85: aload_0
      //   86: getfield charIndex : I
      //   89: aload_0
      //   90: getfield length : I
      //   93: if_icmpge -> 5
      //   96: aload_0
      //   97: getfield text : Ljava/lang/CharSequence;
      //   100: astore_2
      //   101: aload_0
      //   102: getfield charIndex : I
      //   105: istore #5
      //   107: aload_0
      //   108: iload #5
      //   110: iconst_1
      //   111: iadd
      //   112: putfield charIndex : I
      //   115: aload_2
      //   116: iload #5
      //   118: invokeinterface charAt : (I)C
      //   123: istore #5
      //   125: aload_0
      //   126: iload #5
      //   128: i2c
      //   129: putfield lastChar : C
      //   132: iload #5
      //   134: iload_3
      //   135: if_icmpeq -> 5
      //   138: goto -> 85
      //   141: aload_0
      //   142: iload_1
      //   143: putfield charIndex : I
      //   146: aload_0
      //   147: bipush #60
      //   149: i2c
      //   150: putfield lastChar : C
      //   153: bipush #13
      //   155: istore_1
      //   156: iload_1
      //   157: istore #4
      //   159: goto -> 59
    }
    
    byte dirTypeBackward() {
      this.lastChar = this.text.charAt(this.charIndex - 1);
      if (Character.isLowSurrogate(this.lastChar)) {
        int i = Character.codePointBefore(this.text, this.charIndex);
        this.charIndex -= Character.charCount(i);
        i = Character.getDirectionality(i);
        return i;
      } 
      this.charIndex--;
      byte b = getCachedDirectionality(this.lastChar);
      byte b1 = b;
      if (this.isHtml) {
        if (this.lastChar == '>') {
          b = skipTagBackward();
          return b;
        } 
        b1 = b;
        if (this.lastChar == ';') {
          b = skipEntityBackward();
          b1 = b;
        } 
      } 
      return b1;
    }
    
    byte dirTypeForward() {
      this.lastChar = this.text.charAt(this.charIndex);
      if (Character.isHighSurrogate(this.lastChar)) {
        int i = Character.codePointAt(this.text, this.charIndex);
        this.charIndex += Character.charCount(i);
        i = Character.getDirectionality(i);
        return i;
      } 
      this.charIndex++;
      byte b = getCachedDirectionality(this.lastChar);
      byte b1 = b;
      if (this.isHtml) {
        if (this.lastChar == '<') {
          b = skipTagForward();
          return b;
        } 
        b1 = b;
        if (this.lastChar == '&') {
          b = skipEntityForward();
          b1 = b;
        } 
      } 
      return b1;
    }
    
    int getEntryDir() {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: iconst_0
      //   4: putfield charIndex : I
      //   7: iconst_0
      //   8: istore_2
      //   9: iconst_0
      //   10: istore_3
      //   11: iconst_0
      //   12: istore #4
      //   14: aload_0
      //   15: getfield charIndex : I
      //   18: aload_0
      //   19: getfield length : I
      //   22: if_icmpge -> 183
      //   25: iload #4
      //   27: ifne -> 183
      //   30: aload_0
      //   31: invokevirtual dirTypeForward : ()B
      //   34: tableswitch default -> 124, 0 -> 154, 1 -> 170, 2 -> 170, 3 -> 124, 4 -> 124, 5 -> 124, 6 -> 124, 7 -> 124, 8 -> 124, 9 -> 14, 10 -> 124, 11 -> 124, 12 -> 124, 13 -> 124, 14 -> 130, 15 -> 130, 16 -> 138, 17 -> 138, 18 -> 146
      //   124: iload_2
      //   125: istore #4
      //   127: goto -> 14
      //   130: iinc #2, 1
      //   133: iconst_m1
      //   134: istore_3
      //   135: goto -> 14
      //   138: iinc #2, 1
      //   141: iconst_1
      //   142: istore_3
      //   143: goto -> 14
      //   146: iinc #2, -1
      //   149: iconst_0
      //   150: istore_3
      //   151: goto -> 14
      //   154: iload_2
      //   155: ifne -> 164
      //   158: iconst_m1
      //   159: istore #5
      //   161: iload #5
      //   163: ireturn
      //   164: iload_2
      //   165: istore #4
      //   167: goto -> 14
      //   170: iload_1
      //   171: istore #5
      //   173: iload_2
      //   174: ifeq -> 161
      //   177: iload_2
      //   178: istore #4
      //   180: goto -> 14
      //   183: iload #4
      //   185: ifne -> 194
      //   188: iconst_0
      //   189: istore #5
      //   191: goto -> 161
      //   194: iload_3
      //   195: ifeq -> 204
      //   198: iload_3
      //   199: istore #5
      //   201: goto -> 161
      //   204: aload_0
      //   205: getfield charIndex : I
      //   208: ifle -> 284
      //   211: aload_0
      //   212: invokevirtual dirTypeBackward : ()B
      //   215: tableswitch default -> 248, 14 -> 251, 15 -> 251, 16 -> 263, 17 -> 263, 18 -> 278
      //   248: goto -> 204
      //   251: iload #4
      //   253: iload_2
      //   254: if_icmpeq -> 158
      //   257: iinc #2, -1
      //   260: goto -> 204
      //   263: iload_1
      //   264: istore #5
      //   266: iload #4
      //   268: iload_2
      //   269: if_icmpeq -> 161
      //   272: iinc #2, -1
      //   275: goto -> 204
      //   278: iinc #2, 1
      //   281: goto -> 204
      //   284: iconst_0
      //   285: istore #5
      //   287: goto -> 161
    }
    
    int getExitDir() {
      byte b1 = -1;
      byte b2 = 0;
      this.charIndex = this.length;
      byte b3 = 0;
      byte b4 = 0;
      while (true) {
        byte b = b2;
        if (this.charIndex > 0) {
          switch (dirTypeBackward()) {
            case 9:
              break;
            case 0:
              if (!b3)
                return -1; 
              if (!b4)
                b4 = b3; 
              break;
            case 14:
            case 15:
              b = b1;
              if (b4 != b3) {
                b3--;
                break;
              } 
              return b;
            case 1:
            case 2:
              if (b3 == 0)
                return 1; 
              if (b4 == 0)
                b4 = b3; 
              break;
            case 16:
            case 17:
              if (b4 == b3)
                return 1; 
              b3--;
              break;
            case 18:
              b3++;
              break;
          } 
          continue;
        } 
        return b;
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\text\BidiFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
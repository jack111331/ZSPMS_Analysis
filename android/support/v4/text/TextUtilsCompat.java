package android.support.v4.text;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

public final class TextUtilsCompat {
  static String ARAB_SCRIPT_SUBTAG;
  
  static String HEBR_SCRIPT_SUBTAG;
  
  private static final TextUtilsCompatImpl IMPL;
  
  public static final Locale ROOT = new Locale("", "");
  
  static {
    ARAB_SCRIPT_SUBTAG = "Arab";
    HEBR_SCRIPT_SUBTAG = "Hebr";
  }
  
  public static int getLayoutDirectionFromLocale(@Nullable Locale paramLocale) {
    return IMPL.getLayoutDirectionFromLocale(paramLocale);
  }
  
  @NonNull
  public static String htmlEncode(@NonNull String paramString) {
    return IMPL.htmlEncode(paramString);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 17) {
      IMPL = new TextUtilsCompatJellybeanMr1Impl();
    } else {
      IMPL = new TextUtilsCompatImpl();
    } 
  }
  
  private static class TextUtilsCompatImpl {
    private static int getLayoutDirectionFromFirstChar(@NonNull Locale param1Locale) {
      boolean bool = false;
      switch (Character.getDirectionality(param1Locale.getDisplayName(param1Locale).charAt(0))) {
        default:
          return bool;
        case 1:
        case 2:
          break;
      } 
      bool = true;
    }
    
    public int getLayoutDirectionFromLocale(@Nullable Locale param1Locale) {
      if (param1Locale != null && !param1Locale.equals(TextUtilsCompat.ROOT)) {
        String str = ICUCompat.maximizeAndGetScript(param1Locale);
        if (str == null)
          return getLayoutDirectionFromFirstChar(param1Locale); 
        if (str.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || str.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG))
          return 1; 
      } 
      return 0;
    }
    
    @NonNull
    public String htmlEncode(@NonNull String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      for (byte b = 0;; b++) {
        if (b < param1String.length()) {
          char c = param1String.charAt(b);
          switch (c) {
            default:
              stringBuilder.append(c);
              b++;
              continue;
            case '<':
              stringBuilder.append("&lt;");
              b++;
              continue;
            case '>':
              stringBuilder.append("&gt;");
              b++;
              continue;
            case '&':
              stringBuilder.append("&amp;");
              b++;
              continue;
            case '\'':
              stringBuilder.append("&#39;");
              b++;
              continue;
            case '"':
              break;
          } 
          stringBuilder.append("&quot;");
        } else {
          break;
        } 
      } 
      return stringBuilder.toString();
    }
  }
  
  private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
    public int getLayoutDirectionFromLocale(@Nullable Locale param1Locale) {
      return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(param1Locale);
    }
    
    @NonNull
    public String htmlEncode(@NonNull String param1String) {
      return TextUtilsCompatJellybeanMr1.htmlEncode(param1String);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\text\TextUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
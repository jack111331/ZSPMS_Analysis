package android.support.v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public final class SharedPreferencesCompat {
  public static final class EditorCompat {
    private static EditorCompat sInstance;
    
    private final SharedPreferencesCompat.EditorCompat$Helper mHelper = new SharedPreferencesCompat.EditorCompat$Helper();
    
    public static EditorCompat getInstance() {
      if (sInstance == null)
        sInstance = new EditorCompat(); 
      return sInstance;
    }
    
    public void apply(@NonNull SharedPreferences.Editor param1Editor) {
      this.mHelper.apply(param1Editor);
    }
    
    private static class EditorCompat$Helper {
      public void apply(@NonNull SharedPreferences.Editor param2Editor) {
        try {
          param2Editor.apply();
        } catch (AbstractMethodError abstractMethodError) {
          param2Editor.commit();
        } 
      }
    }
  }
  
  private static class EditorCompat$Helper {
    public void apply(@NonNull SharedPreferences.Editor param1Editor) {
      try {
        param1Editor.apply();
      } catch (AbstractMethodError abstractMethodError) {
        param1Editor.commit();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\SharedPreferencesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
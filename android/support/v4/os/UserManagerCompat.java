package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat {
  public static boolean isUserUnlocked(Context paramContext) {
    return BuildCompat.isAtLeastN() ? UserManagerCompatApi24.isUserUnlocked(paramContext) : true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\os\UserManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
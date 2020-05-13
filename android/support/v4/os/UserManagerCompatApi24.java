package android.support.v4.os;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.UserManager;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;

@TargetApi(24)
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class UserManagerCompatApi24 {
  public static boolean isUserUnlocked(Context paramContext) {
    return ((UserManager)paramContext.getSystemService(UserManager.class)).isUserUnlocked();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\os\UserManagerCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
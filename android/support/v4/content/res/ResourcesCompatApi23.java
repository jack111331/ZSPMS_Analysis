package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class ResourcesCompatApi23 {
  public static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    return paramResources.getColor(paramInt, paramTheme);
  }
  
  public static ColorStateList getColorStateList(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    return paramResources.getColorStateList(paramInt, paramTheme);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\res\ResourcesCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
  public static boolean areSameOptions(Bundle paramBundle1, Bundle paramBundle2) {
    boolean bool = false;
    if (paramBundle1 != paramBundle2)
      if (paramBundle1 == null) {
        boolean bool1 = bool;
        if (paramBundle2.getInt("android.media.browse.extra.PAGE", -1) == -1) {
          if (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1)
            return bool; 
        } else {
          return bool1;
        } 
      } else if (paramBundle2 == null) {
        boolean bool1 = bool;
        if (paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == -1) {
          if (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1)
            return bool; 
        } else {
          return bool1;
        } 
      } else {
        boolean bool1 = bool;
        if (paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) {
          if (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1))
            return bool; 
        } else {
          return bool1;
        } 
      }  
    return true;
  }
  
  public static boolean hasDuplicatedItems(Bundle paramBundle1, Bundle paramBundle2) {
    int i;
    int j;
    int k;
    int m;
    boolean bool = false;
    if (paramBundle1 == null) {
      i = -1;
    } else {
      i = paramBundle1.getInt("android.media.browse.extra.PAGE", -1);
    } 
    if (paramBundle2 == null) {
      j = -1;
    } else {
      j = paramBundle2.getInt("android.media.browse.extra.PAGE", -1);
    } 
    if (paramBundle1 == null) {
      k = -1;
    } else {
      k = paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    } 
    if (paramBundle2 == null) {
      m = -1;
    } else {
      m = paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    } 
    if (i == -1 || k == -1) {
      k = 0;
      i = Integer.MAX_VALUE;
    } else {
      int n = i * k;
      i = k + n - 1;
      k = n;
    } 
    if (j == -1 || m == -1) {
      m = Integer.MAX_VALUE;
      j = 0;
    } else {
      j = m * j;
      m = j + m - 1;
    } 
    if (k > j || j > i) {
      boolean bool1 = bool;
      if (k <= m) {
        if (m > i)
          return bool; 
      } else {
        return bool1;
      } 
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
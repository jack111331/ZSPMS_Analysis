package org.jar.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
  private static final String EXTRA_WAKE_LOCK_ID = "org.jar.support.content.wakelockid";
  
  private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks = new SparseArray();
  
  private static int mNextId = 1;
  
  public static boolean completeWakefulIntent(Intent paramIntent) {
    int i = paramIntent.getIntExtra("org.jar.support.content.wakelockid", 0);
    if (i == 0)
      return false; 
    synchronized (mActiveWakeLocks) {
      PowerManager.WakeLock wakeLock = (PowerManager.WakeLock)mActiveWakeLocks.get(i);
      if (wakeLock != null) {
        wakeLock.release();
        mActiveWakeLocks.remove(i);
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("No active wake lock id #");
      stringBuilder.append(i);
      Log.w("WakefulBroadcastReceiver", stringBuilder.toString());
      return true;
    } 
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent) {
    synchronized (mActiveWakeLocks) {
      int i = mNextId;
      mNextId++;
      if (mNextId <= 0)
        mNextId = 1; 
      paramIntent.putExtra("org.jar.support.content.wakelockid", i);
      ComponentName componentName = paramContext.startService(paramIntent);
      if (componentName == null)
        return null; 
      PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("wake:");
      stringBuilder.append(componentName.flattenToShortString());
      PowerManager.WakeLock wakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
      wakeLock.setReferenceCounted(false);
      wakeLock.acquire(60000L);
      mActiveWakeLocks.put(i, wakeLock);
      return componentName;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
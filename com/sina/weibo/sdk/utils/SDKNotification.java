package com.sina.weibo.sdk.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class SDKNotification {
  private Context mContext;
  
  private Notification mNotification;
  
  private SDKNotification(Context paramContext, Notification paramNotification) {
    this.mContext = paramContext.getApplicationContext();
    this.mNotification = paramNotification;
  }
  
  public void show(int paramInt) {
    if (this.mNotification != null)
      ((NotificationManager)this.mContext.getSystemService("notification")).notify(paramInt, this.mNotification); 
  }
  
  public static class SDKNotificationBuilder {
    private String mNotificationContent;
    
    private PendingIntent mNotificationPendingIntent;
    
    private String mNotificationTitle;
    
    private Uri mSoundUri;
    
    private String mTickerText;
    
    private long[] mVibrate;
    
    public static SDKNotificationBuilder buildUpon() {
      return new SDKNotificationBuilder();
    }
    
    private static int getNotificationIcon(Context param1Context) {
      int i = getResourceId(param1Context, "com_sina_weibo_sdk_weibo_logo", "drawable");
      if (i <= 0)
        i = 17301659; 
      return i;
    }
    
    private static int getResourceId(Context param1Context, String param1String1, String param1String2) {
      String str = param1Context.getApplicationContext().getPackageName();
      PackageManager packageManager = param1Context.getPackageManager();
      try {
        return packageManager.getResourcesForApplication(str).getIdentifier(param1String1, param1String2, str);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        nameNotFoundException.printStackTrace();
        return 0;
      } 
    }
    
    public SDKNotification build(Context param1Context) {
      NotificationCompat.Builder builder = new NotificationCompat.Builder(param1Context);
      builder.setAutoCancel(true);
      builder.setContentIntent(this.mNotificationPendingIntent);
      builder.setTicker(this.mTickerText);
      builder.setSmallIcon(getNotificationIcon(param1Context));
      builder.setWhen(System.currentTimeMillis());
      if (this.mSoundUri != null)
        builder.setSound(this.mSoundUri); 
      if (this.mVibrate != null)
        builder.setVibrate(this.mVibrate); 
      builder.setLargeIcon(((BitmapDrawable)ResourceManager.getDrawable(param1Context, "weibosdk_notification_icon.png")).getBitmap());
      builder.setContentTitle(this.mNotificationTitle);
      builder.setContentText(this.mNotificationContent);
      return new SDKNotification(param1Context, builder.build(), null);
    }
    
    public SDKNotificationBuilder setNotificationContent(String param1String) {
      this.mNotificationContent = param1String;
      return this;
    }
    
    public SDKNotificationBuilder setNotificationPendingIntent(PendingIntent param1PendingIntent) {
      this.mNotificationPendingIntent = param1PendingIntent;
      return this;
    }
    
    public SDKNotificationBuilder setNotificationTitle(String param1String) {
      this.mNotificationTitle = param1String;
      return this;
    }
    
    public SDKNotificationBuilder setSoundUri(Uri param1Uri) {
      this.mSoundUri = param1Uri;
      return this;
    }
    
    public SDKNotificationBuilder setTickerText(String param1String) {
      this.mTickerText = param1String;
      return this;
    }
    
    public SDKNotificationBuilder setVibrate(long[] param1ArrayOflong) {
      this.mVibrate = param1ArrayOflong;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\SDKNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
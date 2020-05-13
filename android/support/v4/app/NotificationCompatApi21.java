package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;
import java.util.ArrayList;

@TargetApi(21)
@RequiresApi(21)
class NotificationCompatApi21 {
  public static final String CATEGORY_ALARM = "alarm";
  
  public static final String CATEGORY_CALL = "call";
  
  public static final String CATEGORY_EMAIL = "email";
  
  public static final String CATEGORY_ERROR = "err";
  
  public static final String CATEGORY_EVENT = "event";
  
  public static final String CATEGORY_MESSAGE = "msg";
  
  public static final String CATEGORY_PROGRESS = "progress";
  
  public static final String CATEGORY_PROMO = "promo";
  
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  
  public static final String CATEGORY_SERVICE = "service";
  
  public static final String CATEGORY_SOCIAL = "social";
  
  public static final String CATEGORY_STATUS = "status";
  
  public static final String CATEGORY_SYSTEM = "sys";
  
  public static final String CATEGORY_TRANSPORT = "transport";
  
  private static final String KEY_AUTHOR = "author";
  
  private static final String KEY_MESSAGES = "messages";
  
  private static final String KEY_ON_READ = "on_read";
  
  private static final String KEY_ON_REPLY = "on_reply";
  
  private static final String KEY_PARTICIPANTS = "participants";
  
  private static final String KEY_REMOTE_INPUT = "remote_input";
  
  private static final String KEY_TEXT = "text";
  
  private static final String KEY_TIMESTAMP = "timestamp";
  
  private static RemoteInput fromCompatRemoteInput(RemoteInputCompatBase.RemoteInput paramRemoteInput) {
    return (new RemoteInput.Builder(paramRemoteInput.getResultKey())).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras()).build();
  }
  
  static Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation) {
    String str;
    byte b = 0;
    NotificationCompatBase.UnreadConversation unreadConversation1 = null;
    NotificationCompatBase.UnreadConversation unreadConversation2 = null;
    if (paramUnreadConversation == null)
      return (Bundle)unreadConversation2; 
    Bundle bundle = new Bundle();
    unreadConversation2 = unreadConversation1;
    if (paramUnreadConversation.getParticipants() != null) {
      unreadConversation2 = unreadConversation1;
      if ((paramUnreadConversation.getParticipants()).length > 1)
        str = paramUnreadConversation.getParticipants()[0]; 
    } 
    Parcelable[] arrayOfParcelable = new Parcelable[(paramUnreadConversation.getMessages()).length];
    while (b < arrayOfParcelable.length) {
      Bundle bundle1 = new Bundle();
      bundle1.putString("text", paramUnreadConversation.getMessages()[b]);
      bundle1.putString("author", str);
      arrayOfParcelable[b] = (Parcelable)bundle1;
      b++;
    } 
    bundle.putParcelableArray("messages", arrayOfParcelable);
    RemoteInputCompatBase.RemoteInput remoteInput = paramUnreadConversation.getRemoteInput();
    if (remoteInput != null)
      bundle.putParcelable("remote_input", (Parcelable)fromCompatRemoteInput(remoteInput)); 
    bundle.putParcelable("on_reply", (Parcelable)paramUnreadConversation.getReplyPendingIntent());
    bundle.putParcelable("on_read", (Parcelable)paramUnreadConversation.getReadPendingIntent());
    bundle.putStringArray("participants", paramUnreadConversation.getParticipants());
    bundle.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
    return bundle;
  }
  
  public static String getCategory(Notification paramNotification) {
    return paramNotification.category;
  }
  
  static NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation$Factory paramUnreadConversation$Factory, RemoteInputCompatBase.RemoteInput$Factory paramRemoteInput$Factory) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore #4
    //   5: aload_0
    //   6: ifnonnull -> 15
    //   9: aload_3
    //   10: astore #5
    //   12: aload #5
    //   14: areturn
    //   15: aload_0
    //   16: ldc 'messages'
    //   18: invokevirtual getParcelableArray : (Ljava/lang/String;)[Landroid/os/Parcelable;
    //   21: astore #5
    //   23: aload #5
    //   25: ifnull -> 214
    //   28: aload #5
    //   30: arraylength
    //   31: anewarray java/lang/String
    //   34: astore #6
    //   36: iconst_0
    //   37: istore #7
    //   39: iload #7
    //   41: aload #6
    //   43: arraylength
    //   44: if_icmpge -> 208
    //   47: aload #5
    //   49: iload #7
    //   51: aaload
    //   52: instanceof android/os/Bundle
    //   55: ifne -> 167
    //   58: iload #4
    //   60: istore #8
    //   62: aload_3
    //   63: astore #5
    //   65: iload #8
    //   67: ifeq -> 12
    //   70: aload_0
    //   71: ldc 'on_read'
    //   73: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   76: checkcast android/app/PendingIntent
    //   79: astore #9
    //   81: aload_0
    //   82: ldc 'on_reply'
    //   84: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   87: checkcast android/app/PendingIntent
    //   90: astore #10
    //   92: aload_0
    //   93: ldc 'remote_input'
    //   95: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   98: checkcast android/app/RemoteInput
    //   101: astore #11
    //   103: aload_0
    //   104: ldc 'participants'
    //   106: invokevirtual getStringArray : (Ljava/lang/String;)[Ljava/lang/String;
    //   109: astore #12
    //   111: aload_3
    //   112: astore #5
    //   114: aload #12
    //   116: ifnull -> 12
    //   119: aload_3
    //   120: astore #5
    //   122: aload #12
    //   124: arraylength
    //   125: iconst_1
    //   126: if_icmpne -> 12
    //   129: aload #11
    //   131: ifnull -> 203
    //   134: aload #11
    //   136: aload_2
    //   137: invokestatic toCompatRemoteInput : (Landroid/app/RemoteInput;Landroid/support/v4/app/RemoteInputCompatBase$RemoteInput$Factory;)Landroid/support/v4/app/RemoteInputCompatBase$RemoteInput;
    //   140: astore_2
    //   141: aload_1
    //   142: aload #6
    //   144: aload_2
    //   145: aload #10
    //   147: aload #9
    //   149: aload #12
    //   151: aload_0
    //   152: ldc 'timestamp'
    //   154: invokevirtual getLong : (Ljava/lang/String;)J
    //   157: invokeinterface build : ([Ljava/lang/String;Landroid/support/v4/app/RemoteInputCompatBase$RemoteInput;Landroid/app/PendingIntent;Landroid/app/PendingIntent;[Ljava/lang/String;J)Landroid/support/v4/app/NotificationCompatBase$UnreadConversation;
    //   162: astore #5
    //   164: goto -> 12
    //   167: aload #6
    //   169: iload #7
    //   171: aload #5
    //   173: iload #7
    //   175: aaload
    //   176: checkcast android/os/Bundle
    //   179: ldc 'text'
    //   181: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   184: aastore
    //   185: iload #4
    //   187: istore #8
    //   189: aload #6
    //   191: iload #7
    //   193: aaload
    //   194: ifnull -> 62
    //   197: iinc #7, 1
    //   200: goto -> 39
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -> 141
    //   208: iconst_1
    //   209: istore #8
    //   211: goto -> 62
    //   214: aconst_null
    //   215: astore #6
    //   217: goto -> 70
  }
  
  private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(RemoteInput paramRemoteInput, RemoteInputCompatBase.RemoteInput$Factory paramRemoteInput$Factory) {
    return paramRemoteInput$Factory.build(paramRemoteInput.getResultKey(), paramRemoteInput.getLabel(), paramRemoteInput.getChoices(), paramRemoteInput.getAllowFreeFormInput(), paramRemoteInput.getExtras());
  }
  
  public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
    private Notification.Builder b;
    
    private RemoteViews mBigContentView;
    
    private RemoteViews mContentView;
    
    private Bundle mExtras;
    
    private RemoteViews mHeadsUpContentView;
    
    public Builder(Context param1Context, Notification param1Notification1, CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, RemoteViews param1RemoteViews1, int param1Int1, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, Bitmap param1Bitmap, int param1Int2, int param1Int3, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, int param1Int4, CharSequence param1CharSequence4, boolean param1Boolean4, String param1String1, ArrayList<String> param1ArrayList, Bundle param1Bundle, int param1Int5, int param1Int6, Notification param1Notification2, String param1String2, boolean param1Boolean5, String param1String3, RemoteViews param1RemoteViews2, RemoteViews param1RemoteViews3, RemoteViews param1RemoteViews4) {
      Notification.Builder builder = (new Notification.Builder(param1Context)).setWhen(param1Notification1.when).setShowWhen(param1Boolean2).setSmallIcon(param1Notification1.icon, param1Notification1.iconLevel).setContent(param1Notification1.contentView).setTicker(param1Notification1.tickerText, param1RemoteViews1).setSound(param1Notification1.sound, param1Notification1.audioStreamType).setVibrate(param1Notification1.vibrate).setLights(param1Notification1.ledARGB, param1Notification1.ledOnMS, param1Notification1.ledOffMS);
      if ((param1Notification1.flags & 0x2) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setOngoing(param1Boolean2);
      if ((param1Notification1.flags & 0x8) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setOnlyAlertOnce(param1Boolean2);
      if ((param1Notification1.flags & 0x10) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      builder = builder.setAutoCancel(param1Boolean2).setDefaults(param1Notification1.defaults).setContentTitle(param1CharSequence1).setContentText(param1CharSequence2).setSubText(param1CharSequence4).setContentInfo(param1CharSequence3).setContentIntent(param1PendingIntent1).setDeleteIntent(param1Notification1.deleteIntent);
      if ((param1Notification1.flags & 0x80) != 0) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      this.b = builder.setFullScreenIntent(param1PendingIntent2, param1Boolean2).setLargeIcon(param1Bitmap).setNumber(param1Int1).setUsesChronometer(param1Boolean3).setPriority(param1Int4).setProgress(param1Int2, param1Int3, param1Boolean1).setLocalOnly(param1Boolean4).setGroup(param1String2).setGroupSummary(param1Boolean5).setSortKey(param1String3).setCategory(param1String1).setColor(param1Int5).setVisibility(param1Int6).setPublicVersion(param1Notification2);
      this.mExtras = new Bundle();
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      for (String str : param1ArrayList)
        this.b.addPerson(str); 
      this.mContentView = param1RemoteViews2;
      this.mBigContentView = param1RemoteViews3;
      this.mHeadsUpContentView = param1RemoteViews4;
    }
    
    public void addAction(NotificationCompatBase.Action param1Action) {
      NotificationCompatApi20.addAction(this.b, param1Action);
    }
    
    public Notification build() {
      this.b.setExtras(this.mExtras);
      Notification notification = this.b.build();
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
      if (this.mHeadsUpContentView != null)
        notification.headsUpContentView = this.mHeadsUpContentView; 
      return notification;
    }
    
    public Notification.Builder getBuilder() {
      return this.b;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\NotificationCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
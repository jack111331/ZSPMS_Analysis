package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
  private static final boolean DEBUG = false;
  
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  
  private static final String TAG = "LocalBroadcastManager";
  
  private static LocalBroadcastManager mInstance;
  
  private static final Object mLock = new Object();
  
  private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<String, ArrayList<ReceiverRecord>>();
  
  private final Context mAppContext;
  
  private final Handler mHandler;
  
  private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<BroadcastRecord>();
  
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
  
  private LocalBroadcastManager(Context paramContext) {
    this.mAppContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper()) {
        public void handleMessage(Message param1Message) {
          switch (param1Message.what) {
            default:
              super.handleMessage(param1Message);
              return;
            case 1:
              break;
          } 
          LocalBroadcastManager.this.executePendingBroadcasts();
        }
      };
  }
  
  private void executePendingBroadcasts() {
    while (true) {
      HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
      BroadcastRecord broadcastRecord;
      synchronized (this.mReceivers) {
        int i = this.mPendingBroadcasts.size();
        if (i <= 0)
          return; 
        BroadcastRecord[] arrayOfBroadcastRecord = new BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        for (i = 0; i < arrayOfBroadcastRecord.length; i++) {
          broadcastRecord = arrayOfBroadcastRecord[i];
          for (byte b = 0; b < broadcastRecord.receivers.size(); b++)
            ((ReceiverRecord)broadcastRecord.receivers.get(b)).receiver.onReceive(this.mAppContext, broadcastRecord.intent); 
        } 
      } 
    } 
  }
  
  public static LocalBroadcastManager getInstance(Context paramContext) {
    synchronized (mLock) {
      if (mInstance == null) {
        LocalBroadcastManager localBroadcastManager = new LocalBroadcastManager();
        this(paramContext.getApplicationContext());
        mInstance = localBroadcastManager;
      } 
      return mInstance;
    } 
  }
  
  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
    synchronized (this.mReceivers) {
      ReceiverRecord receiverRecord = new ReceiverRecord();
      this(paramIntentFilter, paramBroadcastReceiver);
      ArrayList<IntentFilter> arrayList1 = this.mReceivers.get(paramBroadcastReceiver);
      ArrayList<IntentFilter> arrayList2 = arrayList1;
      if (arrayList1 == null) {
        arrayList2 = new ArrayList();
        this(1);
        this.mReceivers.put(paramBroadcastReceiver, arrayList2);
      } 
      arrayList2.add(paramIntentFilter);
      for (byte b = 0; b < paramIntentFilter.countActions(); b++) {
        String str = paramIntentFilter.getAction(b);
        arrayList2 = (ArrayList<IntentFilter>)this.mActions.get(str);
        ArrayList<IntentFilter> arrayList = arrayList2;
        if (arrayList2 == null) {
          arrayList = new ArrayList<IntentFilter>();
          this(1);
          this.mActions.put(str, arrayList);
        } 
        arrayList.add(receiverRecord);
      } 
      return;
    } 
  }
  
  public boolean sendBroadcast(Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mReceivers : Ljava/util/HashMap;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: invokevirtual getAction : ()Ljava/lang/String;
    //   11: astore_3
    //   12: aload_1
    //   13: aload_0
    //   14: getfield mAppContext : Landroid/content/Context;
    //   17: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   20: invokevirtual resolveTypeIfNeeded : (Landroid/content/ContentResolver;)Ljava/lang/String;
    //   23: astore #4
    //   25: aload_1
    //   26: invokevirtual getData : ()Landroid/net/Uri;
    //   29: astore #5
    //   31: aload_1
    //   32: invokevirtual getScheme : ()Ljava/lang/String;
    //   35: astore #6
    //   37: aload_1
    //   38: invokevirtual getCategories : ()Ljava/util/Set;
    //   41: astore #7
    //   43: aload_1
    //   44: invokevirtual getFlags : ()I
    //   47: bipush #8
    //   49: iand
    //   50: ifeq -> 534
    //   53: iconst_1
    //   54: istore #8
    //   56: iload #8
    //   58: ifeq -> 111
    //   61: new java/lang/StringBuilder
    //   64: astore #9
    //   66: aload #9
    //   68: invokespecial <init> : ()V
    //   71: ldc 'LocalBroadcastManager'
    //   73: aload #9
    //   75: ldc 'Resolving type '
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload #4
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc ' scheme '
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload #6
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc ' of intent '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload_0
    //   112: getfield mActions : Ljava/util/HashMap;
    //   115: aload_1
    //   116: invokevirtual getAction : ()Ljava/lang/String;
    //   119: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast java/util/ArrayList
    //   125: astore #10
    //   127: aload #10
    //   129: ifnull -> 523
    //   132: iload #8
    //   134: ifeq -> 168
    //   137: new java/lang/StringBuilder
    //   140: astore #9
    //   142: aload #9
    //   144: invokespecial <init> : ()V
    //   147: ldc 'LocalBroadcastManager'
    //   149: aload #9
    //   151: ldc 'Action list: '
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload #10
    //   158: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aconst_null
    //   169: astore #9
    //   171: iconst_0
    //   172: istore #11
    //   174: iload #11
    //   176: aload #10
    //   178: invokevirtual size : ()I
    //   181: if_icmpge -> 568
    //   184: aload #10
    //   186: iload #11
    //   188: invokevirtual get : (I)Ljava/lang/Object;
    //   191: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
    //   194: astore #12
    //   196: iload #8
    //   198: ifeq -> 235
    //   201: new java/lang/StringBuilder
    //   204: astore #13
    //   206: aload #13
    //   208: invokespecial <init> : ()V
    //   211: ldc 'LocalBroadcastManager'
    //   213: aload #13
    //   215: ldc 'Matching against filter '
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload #12
    //   222: getfield filter : Landroid/content/IntentFilter;
    //   225: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: invokevirtual toString : ()Ljava/lang/String;
    //   231: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   234: pop
    //   235: aload #12
    //   237: getfield broadcasting : Z
    //   240: ifeq -> 262
    //   243: iload #8
    //   245: ifeq -> 435
    //   248: ldc 'LocalBroadcastManager'
    //   250: ldc '  Filter's target already added'
    //   252: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: iinc #11, 1
    //   259: goto -> 174
    //   262: aload #12
    //   264: getfield filter : Landroid/content/IntentFilter;
    //   267: aload_3
    //   268: aload #4
    //   270: aload #6
    //   272: aload #5
    //   274: aload #7
    //   276: ldc 'LocalBroadcastManager'
    //   278: invokevirtual match : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Set;Ljava/lang/String;)I
    //   281: istore #14
    //   283: iload #14
    //   285: iflt -> 364
    //   288: iload #8
    //   290: ifeq -> 327
    //   293: new java/lang/StringBuilder
    //   296: astore #13
    //   298: aload #13
    //   300: invokespecial <init> : ()V
    //   303: ldc 'LocalBroadcastManager'
    //   305: aload #13
    //   307: ldc '  Filter matched!  match=0x'
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: iload #14
    //   314: invokestatic toHexString : (I)Ljava/lang/String;
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual toString : ()Ljava/lang/String;
    //   323: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   326: pop
    //   327: aload #9
    //   329: ifnonnull -> 531
    //   332: new java/util/ArrayList
    //   335: astore #9
    //   337: aload #9
    //   339: invokespecial <init> : ()V
    //   342: aload #9
    //   344: aload #12
    //   346: invokevirtual add : (Ljava/lang/Object;)Z
    //   349: pop
    //   350: aload #12
    //   352: iconst_1
    //   353: putfield broadcasting : Z
    //   356: goto -> 256
    //   359: astore_1
    //   360: aload_2
    //   361: monitorexit
    //   362: aload_1
    //   363: athrow
    //   364: iload #8
    //   366: ifeq -> 435
    //   369: iload #14
    //   371: tableswitch default -> 400, -4 -> 547, -3 -> 540, -2 -> 554, -1 -> 561
    //   400: ldc 'unknown reason'
    //   402: astore #12
    //   404: new java/lang/StringBuilder
    //   407: astore #13
    //   409: aload #13
    //   411: invokespecial <init> : ()V
    //   414: ldc 'LocalBroadcastManager'
    //   416: aload #13
    //   418: ldc '  Filter did not match: '
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload #12
    //   425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual toString : ()Ljava/lang/String;
    //   431: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   434: pop
    //   435: goto -> 256
    //   438: iload #8
    //   440: aload #9
    //   442: invokevirtual size : ()I
    //   445: if_icmpge -> 468
    //   448: aload #9
    //   450: iload #8
    //   452: invokevirtual get : (I)Ljava/lang/Object;
    //   455: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
    //   458: iconst_0
    //   459: putfield broadcasting : Z
    //   462: iinc #8, 1
    //   465: goto -> 438
    //   468: aload_0
    //   469: getfield mPendingBroadcasts : Ljava/util/ArrayList;
    //   472: astore #12
    //   474: new android/support/v4/content/LocalBroadcastManager$BroadcastRecord
    //   477: astore #6
    //   479: aload #6
    //   481: aload_1
    //   482: aload #9
    //   484: invokespecial <init> : (Landroid/content/Intent;Ljava/util/ArrayList;)V
    //   487: aload #12
    //   489: aload #6
    //   491: invokevirtual add : (Ljava/lang/Object;)Z
    //   494: pop
    //   495: aload_0
    //   496: getfield mHandler : Landroid/os/Handler;
    //   499: iconst_1
    //   500: invokevirtual hasMessages : (I)Z
    //   503: ifne -> 515
    //   506: aload_0
    //   507: getfield mHandler : Landroid/os/Handler;
    //   510: iconst_1
    //   511: invokevirtual sendEmptyMessage : (I)Z
    //   514: pop
    //   515: aload_2
    //   516: monitorexit
    //   517: iconst_1
    //   518: istore #15
    //   520: iload #15
    //   522: ireturn
    //   523: aload_2
    //   524: monitorexit
    //   525: iconst_0
    //   526: istore #15
    //   528: goto -> 520
    //   531: goto -> 342
    //   534: iconst_0
    //   535: istore #8
    //   537: goto -> 56
    //   540: ldc 'action'
    //   542: astore #12
    //   544: goto -> 404
    //   547: ldc 'category'
    //   549: astore #12
    //   551: goto -> 404
    //   554: ldc 'data'
    //   556: astore #12
    //   558: goto -> 404
    //   561: ldc 'type'
    //   563: astore #12
    //   565: goto -> 404
    //   568: aload #9
    //   570: ifnull -> 523
    //   573: iconst_0
    //   574: istore #8
    //   576: goto -> 438
    // Exception table:
    //   from	to	target	type
    //   7	53	359	finally
    //   61	111	359	finally
    //   111	127	359	finally
    //   137	168	359	finally
    //   174	196	359	finally
    //   201	235	359	finally
    //   235	243	359	finally
    //   248	256	359	finally
    //   262	283	359	finally
    //   293	327	359	finally
    //   332	342	359	finally
    //   342	356	359	finally
    //   360	362	359	finally
    //   404	435	359	finally
    //   438	462	359	finally
    //   468	515	359	finally
    //   515	517	359	finally
    //   523	525	359	finally
  }
  
  public void sendBroadcastSync(Intent paramIntent) {
    if (sendBroadcast(paramIntent))
      executePendingBroadcasts(); 
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver) {
    synchronized (this.mReceivers) {
      ArrayList<IntentFilter> arrayList = this.mReceivers.remove(paramBroadcastReceiver);
      if (arrayList == null)
        return; 
      for (byte b = 0;; b++) {
        if (b < arrayList.size()) {
          IntentFilter intentFilter = arrayList.get(b);
          for (byte b1 = 0; b1 < intentFilter.countActions(); b1++) {
            String str = intentFilter.getAction(b1);
            ArrayList arrayList1 = this.mActions.get(str);
            if (arrayList1 != null) {
              for (byte b2 = 0; b2 < arrayList1.size(); b2++) {
                if (((ReceiverRecord)arrayList1.get(b2)).receiver == paramBroadcastReceiver) {
                  arrayList1.remove(b2);
                  b2--;
                } 
              } 
              if (arrayList1.size() <= 0)
                this.mActions.remove(str); 
            } 
          } 
        } else {
          return;
        } 
      } 
    } 
  }
  
  private static class BroadcastRecord {
    final Intent intent;
    
    final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
    
    BroadcastRecord(Intent param1Intent, ArrayList<LocalBroadcastManager.ReceiverRecord> param1ArrayList) {
      this.intent = param1Intent;
      this.receivers = param1ArrayList;
    }
  }
  
  private static class ReceiverRecord {
    boolean broadcasting;
    
    final IntentFilter filter;
    
    final BroadcastReceiver receiver;
    
    ReceiverRecord(IntentFilter param1IntentFilter, BroadcastReceiver param1BroadcastReceiver) {
      this.filter = param1IntentFilter;
      this.receiver = param1BroadcastReceiver;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(128);
      stringBuilder.append("Receiver{");
      stringBuilder.append(this.receiver);
      stringBuilder.append(" filter=");
      stringBuilder.append(this.filter);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\LocalBroadcastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
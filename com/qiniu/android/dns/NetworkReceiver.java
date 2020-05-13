package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public final class NetworkReceiver extends BroadcastReceiver {
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  
  private static DnsManager mdnsManager;
  
  public static NetworkInfo createNetInfo(NetworkInfo paramNetworkInfo, Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 8
    //   4: getstatic com/qiniu/android/dns/NetworkInfo.noNetwork : Lcom/qiniu/android/dns/NetworkInfo;
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual getType : ()I
    //   12: istore_2
    //   13: iconst_0
    //   14: istore_3
    //   15: iconst_0
    //   16: istore #4
    //   18: iload_2
    //   19: iconst_1
    //   20: if_icmpne -> 33
    //   23: getstatic com/qiniu/android/dns/NetworkInfo$NetSatus.WIFI : Lcom/qiniu/android/dns/NetworkInfo$NetSatus;
    //   26: astore_1
    //   27: iload_3
    //   28: istore #4
    //   30: goto -> 237
    //   33: getstatic com/qiniu/android/dns/NetworkInfo$NetSatus.MOBILE : Lcom/qiniu/android/dns/NetworkInfo$NetSatus;
    //   36: astore #5
    //   38: aload_1
    //   39: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   42: getstatic com/qiniu/android/dns/NetworkReceiver.PREFERRED_APN_URI : Landroid/net/Uri;
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_1
    //   53: iload #4
    //   55: istore_3
    //   56: aload_1
    //   57: ifnull -> 119
    //   60: aload_1
    //   61: invokeinterface moveToFirst : ()Z
    //   66: pop
    //   67: aload_1
    //   68: aload_1
    //   69: ldc 'user'
    //   71: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   76: invokeinterface getString : (I)Ljava/lang/String;
    //   81: astore #6
    //   83: iload #4
    //   85: istore_3
    //   86: aload #6
    //   88: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   91: ifne -> 119
    //   94: aload #6
    //   96: ldc 'ctwap'
    //   98: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   101: ifne -> 117
    //   104: iload #4
    //   106: istore_3
    //   107: aload #6
    //   109: ldc 'ctnet'
    //   111: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   114: ifeq -> 119
    //   117: iconst_1
    //   118: istore_3
    //   119: aload_1
    //   120: invokeinterface close : ()V
    //   125: aload #5
    //   127: astore_1
    //   128: iload_3
    //   129: istore #4
    //   131: iload_3
    //   132: iconst_1
    //   133: if_icmpeq -> 237
    //   136: aload_0
    //   137: invokevirtual getExtraInfo : ()Ljava/lang/String;
    //   140: astore_0
    //   141: aload #5
    //   143: astore_1
    //   144: iload_3
    //   145: istore #4
    //   147: aload_0
    //   148: ifnull -> 237
    //   151: aload_0
    //   152: invokestatic getDefault : ()Ljava/util/Locale;
    //   155: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   158: astore_0
    //   159: aload_0
    //   160: ldc 'cmwap'
    //   162: invokevirtual equals : (Ljava/lang/Object;)Z
    //   165: ifne -> 231
    //   168: aload_0
    //   169: ldc 'cmnet'
    //   171: invokevirtual equals : (Ljava/lang/Object;)Z
    //   174: ifeq -> 180
    //   177: goto -> 231
    //   180: aload_0
    //   181: ldc '3gnet'
    //   183: invokevirtual equals : (Ljava/lang/Object;)Z
    //   186: ifne -> 222
    //   189: aload_0
    //   190: ldc 'uninet'
    //   192: invokevirtual equals : (Ljava/lang/Object;)Z
    //   195: ifne -> 222
    //   198: aload_0
    //   199: ldc '3gwap'
    //   201: invokevirtual equals : (Ljava/lang/Object;)Z
    //   204: ifne -> 222
    //   207: aload #5
    //   209: astore_1
    //   210: iload_3
    //   211: istore #4
    //   213: aload_0
    //   214: ldc 'uniwap'
    //   216: invokevirtual equals : (Ljava/lang/Object;)Z
    //   219: ifeq -> 237
    //   222: iconst_2
    //   223: istore #4
    //   225: aload #5
    //   227: astore_1
    //   228: goto -> 237
    //   231: iconst_3
    //   232: istore #4
    //   234: aload #5
    //   236: astore_1
    //   237: new com/qiniu/android/dns/NetworkInfo
    //   240: dup
    //   241: aload_1
    //   242: iload #4
    //   244: invokespecial <init> : (Lcom/qiniu/android/dns/NetworkInfo$NetSatus;I)V
    //   247: areturn
  }
  
  public static void setDnsManager(DnsManager paramDnsManager) {
    mdnsManager = paramDnsManager;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (mdnsManager == null)
      return; 
    NetworkInfo networkInfo = createNetInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo(), paramContext);
    mdnsManager.onNetworkChange(networkInfo);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\NetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
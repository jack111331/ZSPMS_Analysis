package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class WeiboAppManager {
  private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
  
  private static final String TAG = "com.sina.weibo.sdk.WeiboAppManager";
  
  private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
  
  private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
  
  private static WeiboAppManager sInstance;
  
  private Context mContext;
  
  private WeiboAppManager(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static WeiboAppManager getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/WeiboAppManager
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/WeiboAppManager.sInstance : Lcom/sina/weibo/sdk/WeiboAppManager;
    //   6: ifnonnull -> 22
    //   9: new com/sina/weibo/sdk/WeiboAppManager
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/sina/weibo/sdk/WeiboAppManager.sInstance : Lcom/sina/weibo/sdk/WeiboAppManager;
    //   22: getstatic com/sina/weibo/sdk/WeiboAppManager.sInstance : Lcom/sina/weibo/sdk/WeiboAppManager;
    //   25: astore_0
    //   26: ldc com/sina/weibo/sdk/WeiboAppManager
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/sina/weibo/sdk/WeiboAppManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  private WeiboInfo queryWeiboInfoByAsset(Context paramContext) {
    Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
    intent.addCategory("android.intent.category.DEFAULT");
    List list = paramContext.getPackageManager().queryIntentServices(intent, 0);
    paramContext = null;
    if (list == null || list.isEmpty())
      return null; 
    Iterator<ResolveInfo> iterator = list.iterator();
    while (true) {
      if (!iterator.hasNext())
        return (WeiboInfo)paramContext; 
      ResolveInfo resolveInfo = iterator.next();
      if (resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName))
        continue; 
      WeiboInfo weiboInfo = parseWeiboInfoByAsset(resolveInfo.serviceInfo.applicationInfo.packageName);
      if (weiboInfo != null && (paramContext == null || paramContext.getSupportApi() < weiboInfo.getSupportApi()))
        WeiboInfo weiboInfo1 = weiboInfo; 
    } 
  }
  
  private WeiboInfo queryWeiboInfoByProvider(Context paramContext) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: aload_2
    //   6: getstatic com/sina/weibo/sdk/WeiboAppManager.WEIBO_NAME_URI : Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull -> 33
    //   21: aload_3
    //   22: ifnull -> 31
    //   25: aload_3
    //   26: invokeinterface close : ()V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: ldc 'support_api'
    //   38: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   43: istore #4
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: ldc 'package'
    //   50: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   55: istore #5
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: invokeinterface moveToFirst : ()Z
    //   65: ifeq -> 177
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: iload #4
    //   73: invokeinterface getString : (I)Ljava/lang/String;
    //   78: astore #6
    //   80: aload_3
    //   81: astore_2
    //   82: aload #6
    //   84: invokestatic parseInt : (Ljava/lang/String;)I
    //   87: istore #4
    //   89: goto -> 104
    //   92: astore #6
    //   94: aload_3
    //   95: astore_2
    //   96: aload #6
    //   98: invokevirtual printStackTrace : ()V
    //   101: iconst_m1
    //   102: istore #4
    //   104: aload_3
    //   105: astore_2
    //   106: aload_3
    //   107: iload #5
    //   109: invokeinterface getString : (I)Ljava/lang/String;
    //   114: astore #6
    //   116: aload_3
    //   117: astore_2
    //   118: aload #6
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 177
    //   126: aload_3
    //   127: astore_2
    //   128: aload_1
    //   129: aload #6
    //   131: invokestatic validateWeiboSign : (Landroid/content/Context;Ljava/lang/String;)Z
    //   134: ifeq -> 177
    //   137: aload_3
    //   138: astore_2
    //   139: new com/sina/weibo/sdk/WeiboAppManager$WeiboInfo
    //   142: astore_1
    //   143: aload_3
    //   144: astore_2
    //   145: aload_1
    //   146: invokespecial <init> : ()V
    //   149: aload_3
    //   150: astore_2
    //   151: aload_1
    //   152: aload #6
    //   154: invokestatic access$0 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;Ljava/lang/String;)V
    //   157: aload_3
    //   158: astore_2
    //   159: aload_1
    //   160: iload #4
    //   162: invokestatic access$1 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;I)V
    //   165: aload_3
    //   166: ifnull -> 175
    //   169: aload_3
    //   170: invokeinterface close : ()V
    //   175: aload_1
    //   176: areturn
    //   177: aload_3
    //   178: ifnull -> 225
    //   181: aload_3
    //   182: astore_1
    //   183: goto -> 219
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: aload_2
    //   190: astore_3
    //   191: goto -> 203
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -> 228
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: astore_2
    //   205: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   208: aload_3
    //   209: invokevirtual getMessage : ()Ljava/lang/String;
    //   212: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_1
    //   216: ifnull -> 225
    //   219: aload_1
    //   220: invokeinterface close : ()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_1
    //   228: aload_2
    //   229: ifnull -> 238
    //   232: aload_2
    //   233: invokeinterface close : ()V
    //   238: aload_1
    //   239: athrow
    // Exception table:
    //   from	to	target	type
    //   5	17	200	java/lang/Exception
    //   5	17	194	finally
    //   35	45	186	java/lang/Exception
    //   35	45	227	finally
    //   47	57	186	java/lang/Exception
    //   47	57	227	finally
    //   59	68	186	java/lang/Exception
    //   59	68	227	finally
    //   70	80	186	java/lang/Exception
    //   70	80	227	finally
    //   82	89	92	java/lang/NumberFormatException
    //   82	89	186	java/lang/Exception
    //   82	89	227	finally
    //   96	101	186	java/lang/Exception
    //   96	101	227	finally
    //   106	116	186	java/lang/Exception
    //   106	116	227	finally
    //   118	126	186	java/lang/Exception
    //   118	126	227	finally
    //   128	137	186	java/lang/Exception
    //   128	137	227	finally
    //   139	143	186	java/lang/Exception
    //   139	143	227	finally
    //   145	149	186	java/lang/Exception
    //   145	149	227	finally
    //   151	157	186	java/lang/Exception
    //   151	157	227	finally
    //   159	165	186	java/lang/Exception
    //   159	165	227	finally
    //   205	215	227	finally
  }
  
  private WeiboInfo queryWeiboInfoInternal(Context paramContext) {
    boolean bool2;
    WeiboInfo weiboInfo2 = queryWeiboInfoByProvider(paramContext);
    WeiboInfo weiboInfo1 = queryWeiboInfoByAsset(paramContext);
    boolean bool1 = false;
    if (weiboInfo2 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (weiboInfo1 != null)
      bool1 = true; 
    return (bool2 && bool1) ? ((weiboInfo2.getSupportApi() >= weiboInfo1.getSupportApi()) ? weiboInfo2 : weiboInfo1) : (bool2 ? weiboInfo2 : (bool1 ? weiboInfo1 : null));
  }
  
  public WeiboInfo getWeiboInfo() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield mContext : Landroid/content/Context;
    //   7: invokespecial queryWeiboInfoInternal : (Landroid/content/Context;)Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: areturn
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public WeiboInfo parseWeiboInfoByAsset(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield mContext : Landroid/content/Context;
    //   13: aload_1
    //   14: iconst_2
    //   15: invokevirtual createPackageContext : (Ljava/lang/String;I)Landroid/content/Context;
    //   18: astore_2
    //   19: sipush #4096
    //   22: newarray byte
    //   24: astore_3
    //   25: aload_2
    //   26: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   29: ldc 'weibo_for_sdk.json'
    //   31: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore #4
    //   36: aload #4
    //   38: astore_2
    //   39: new java/lang/StringBuilder
    //   42: astore #5
    //   44: aload #4
    //   46: astore_2
    //   47: aload #5
    //   49: invokespecial <init> : ()V
    //   52: aload #4
    //   54: astore_2
    //   55: aload #4
    //   57: aload_3
    //   58: iconst_0
    //   59: sipush #4096
    //   62: invokevirtual read : ([BII)I
    //   65: istore #6
    //   67: iload #6
    //   69: iconst_m1
    //   70: if_icmpne -> 223
    //   73: aload #4
    //   75: astore_2
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   84: ifne -> 197
    //   87: aload #4
    //   89: astore_2
    //   90: aload_0
    //   91: getfield mContext : Landroid/content/Context;
    //   94: aload_1
    //   95: invokestatic validateWeiboSign : (Landroid/content/Context;Ljava/lang/String;)Z
    //   98: ifne -> 104
    //   101: goto -> 197
    //   104: aload #4
    //   106: astore_2
    //   107: new org/json/JSONObject
    //   110: astore_3
    //   111: aload #4
    //   113: astore_2
    //   114: aload_3
    //   115: aload #5
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokespecial <init> : (Ljava/lang/String;)V
    //   123: aload #4
    //   125: astore_2
    //   126: aload_3
    //   127: ldc 'support_api'
    //   129: iconst_m1
    //   130: invokevirtual optInt : (Ljava/lang/String;I)I
    //   133: istore #6
    //   135: aload #4
    //   137: astore_2
    //   138: new com/sina/weibo/sdk/WeiboAppManager$WeiboInfo
    //   141: astore #5
    //   143: aload #4
    //   145: astore_2
    //   146: aload #5
    //   148: invokespecial <init> : ()V
    //   151: aload #4
    //   153: astore_2
    //   154: aload #5
    //   156: aload_1
    //   157: invokestatic access$0 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;Ljava/lang/String;)V
    //   160: aload #4
    //   162: astore_2
    //   163: aload #5
    //   165: iload #6
    //   167: invokestatic access$1 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;I)V
    //   170: aload #4
    //   172: ifnull -> 194
    //   175: aload #4
    //   177: invokevirtual close : ()V
    //   180: goto -> 194
    //   183: astore_1
    //   184: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   187: aload_1
    //   188: invokevirtual getMessage : ()Ljava/lang/String;
    //   191: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload #5
    //   196: areturn
    //   197: aload #4
    //   199: ifnull -> 221
    //   202: aload #4
    //   204: invokevirtual close : ()V
    //   207: goto -> 221
    //   210: astore_1
    //   211: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   214: aload_1
    //   215: invokevirtual getMessage : ()Ljava/lang/String;
    //   218: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   221: aconst_null
    //   222: areturn
    //   223: aload #4
    //   225: astore_2
    //   226: new java/lang/String
    //   229: astore #7
    //   231: aload #4
    //   233: astore_2
    //   234: aload #7
    //   236: aload_3
    //   237: iconst_0
    //   238: iload #6
    //   240: invokespecial <init> : ([BII)V
    //   243: aload #4
    //   245: astore_2
    //   246: aload #5
    //   248: aload #7
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: goto -> 52
    //   257: astore_1
    //   258: goto -> 283
    //   261: astore_1
    //   262: goto -> 313
    //   265: astore_1
    //   266: goto -> 343
    //   269: astore_1
    //   270: goto -> 373
    //   273: astore_1
    //   274: aconst_null
    //   275: astore_2
    //   276: goto -> 413
    //   279: astore_1
    //   280: aconst_null
    //   281: astore #4
    //   283: aload #4
    //   285: astore_2
    //   286: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   289: aload_1
    //   290: invokevirtual getMessage : ()Ljava/lang/String;
    //   293: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload #4
    //   298: ifnull -> 410
    //   301: aload #4
    //   303: invokevirtual close : ()V
    //   306: goto -> 410
    //   309: astore_1
    //   310: aconst_null
    //   311: astore #4
    //   313: aload #4
    //   315: astore_2
    //   316: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   319: aload_1
    //   320: invokevirtual getMessage : ()Ljava/lang/String;
    //   323: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload #4
    //   328: ifnull -> 410
    //   331: aload #4
    //   333: invokevirtual close : ()V
    //   336: goto -> 410
    //   339: astore_1
    //   340: aconst_null
    //   341: astore #4
    //   343: aload #4
    //   345: astore_2
    //   346: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   349: aload_1
    //   350: invokevirtual getMessage : ()Ljava/lang/String;
    //   353: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload #4
    //   358: ifnull -> 410
    //   361: aload #4
    //   363: invokevirtual close : ()V
    //   366: goto -> 410
    //   369: astore_1
    //   370: aconst_null
    //   371: astore #4
    //   373: aload #4
    //   375: astore_2
    //   376: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   379: aload_1
    //   380: invokevirtual getMessage : ()Ljava/lang/String;
    //   383: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload #4
    //   388: ifnull -> 410
    //   391: aload #4
    //   393: invokevirtual close : ()V
    //   396: goto -> 410
    //   399: astore_1
    //   400: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   403: aload_1
    //   404: invokevirtual getMessage : ()Ljava/lang/String;
    //   407: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   410: aconst_null
    //   411: areturn
    //   412: astore_1
    //   413: aload_2
    //   414: ifnull -> 435
    //   417: aload_2
    //   418: invokevirtual close : ()V
    //   421: goto -> 435
    //   424: astore_2
    //   425: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   428: aload_2
    //   429: invokevirtual getMessage : ()Ljava/lang/String;
    //   432: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_1
    //   436: athrow
    // Exception table:
    //   from	to	target	type
    //   9	36	369	android/content/pm/PackageManager$NameNotFoundException
    //   9	36	339	java/io/IOException
    //   9	36	309	org/json/JSONException
    //   9	36	279	java/lang/Exception
    //   9	36	273	finally
    //   39	44	269	android/content/pm/PackageManager$NameNotFoundException
    //   39	44	265	java/io/IOException
    //   39	44	261	org/json/JSONException
    //   39	44	257	java/lang/Exception
    //   39	44	412	finally
    //   47	52	269	android/content/pm/PackageManager$NameNotFoundException
    //   47	52	265	java/io/IOException
    //   47	52	261	org/json/JSONException
    //   47	52	257	java/lang/Exception
    //   47	52	412	finally
    //   55	67	269	android/content/pm/PackageManager$NameNotFoundException
    //   55	67	265	java/io/IOException
    //   55	67	261	org/json/JSONException
    //   55	67	257	java/lang/Exception
    //   55	67	412	finally
    //   76	87	269	android/content/pm/PackageManager$NameNotFoundException
    //   76	87	265	java/io/IOException
    //   76	87	261	org/json/JSONException
    //   76	87	257	java/lang/Exception
    //   76	87	412	finally
    //   90	101	269	android/content/pm/PackageManager$NameNotFoundException
    //   90	101	265	java/io/IOException
    //   90	101	261	org/json/JSONException
    //   90	101	257	java/lang/Exception
    //   90	101	412	finally
    //   107	111	269	android/content/pm/PackageManager$NameNotFoundException
    //   107	111	265	java/io/IOException
    //   107	111	261	org/json/JSONException
    //   107	111	257	java/lang/Exception
    //   107	111	412	finally
    //   114	123	269	android/content/pm/PackageManager$NameNotFoundException
    //   114	123	265	java/io/IOException
    //   114	123	261	org/json/JSONException
    //   114	123	257	java/lang/Exception
    //   114	123	412	finally
    //   126	135	269	android/content/pm/PackageManager$NameNotFoundException
    //   126	135	265	java/io/IOException
    //   126	135	261	org/json/JSONException
    //   126	135	257	java/lang/Exception
    //   126	135	412	finally
    //   138	143	269	android/content/pm/PackageManager$NameNotFoundException
    //   138	143	265	java/io/IOException
    //   138	143	261	org/json/JSONException
    //   138	143	257	java/lang/Exception
    //   138	143	412	finally
    //   146	151	269	android/content/pm/PackageManager$NameNotFoundException
    //   146	151	265	java/io/IOException
    //   146	151	261	org/json/JSONException
    //   146	151	257	java/lang/Exception
    //   146	151	412	finally
    //   154	160	269	android/content/pm/PackageManager$NameNotFoundException
    //   154	160	265	java/io/IOException
    //   154	160	261	org/json/JSONException
    //   154	160	257	java/lang/Exception
    //   154	160	412	finally
    //   163	170	269	android/content/pm/PackageManager$NameNotFoundException
    //   163	170	265	java/io/IOException
    //   163	170	261	org/json/JSONException
    //   163	170	257	java/lang/Exception
    //   163	170	412	finally
    //   175	180	183	java/io/IOException
    //   202	207	210	java/io/IOException
    //   226	231	269	android/content/pm/PackageManager$NameNotFoundException
    //   226	231	265	java/io/IOException
    //   226	231	261	org/json/JSONException
    //   226	231	257	java/lang/Exception
    //   226	231	412	finally
    //   234	243	269	android/content/pm/PackageManager$NameNotFoundException
    //   234	243	265	java/io/IOException
    //   234	243	261	org/json/JSONException
    //   234	243	257	java/lang/Exception
    //   234	243	412	finally
    //   246	254	269	android/content/pm/PackageManager$NameNotFoundException
    //   246	254	265	java/io/IOException
    //   246	254	261	org/json/JSONException
    //   246	254	257	java/lang/Exception
    //   246	254	412	finally
    //   286	296	412	finally
    //   301	306	399	java/io/IOException
    //   316	326	412	finally
    //   331	336	399	java/io/IOException
    //   346	356	412	finally
    //   361	366	399	java/io/IOException
    //   376	386	412	finally
    //   391	396	399	java/io/IOException
    //   417	421	424	java/io/IOException
  }
  
  public static class WeiboInfo {
    private String mPackageName;
    
    private int mSupportApi;
    
    private void setPackageName(String param1String) {
      this.mPackageName = param1String;
    }
    
    private void setSupportApi(int param1Int) {
      this.mSupportApi = param1Int;
    }
    
    public String getPackageName() {
      return this.mPackageName;
    }
    
    public int getSupportApi() {
      return this.mSupportApi;
    }
    
    public boolean isLegal() {
      return (!TextUtils.isEmpty(this.mPackageName) && this.mSupportApi > 0);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("WeiboInfo: PackageName = ");
      stringBuilder.append(this.mPackageName);
      stringBuilder.append(", supportApi = ");
      stringBuilder.append(this.mSupportApi);
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\WeiboAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
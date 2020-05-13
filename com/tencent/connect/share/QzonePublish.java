package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

public class QzonePublish extends BaseApi {
  public static final String HULIAN_CALL_BACK = "hulian_call_back";
  
  public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
  
  public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
  
  public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
  
  public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
  
  public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
  
  public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
  
  public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
  
  public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
  
  public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
  
  public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
  
  public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";
  
  public QzonePublish(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.QzonePublish'
    //   2: ldc 'doPublishToQzone() --start'
    //   4: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   7: new java/lang/StringBuffer
    //   10: dup
    //   11: ldc 'mqqapi://qzone/publish?src_type=app&version=1&file_type=news'
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: astore #4
    //   18: aload_2
    //   19: ldc 'imageUrl'
    //   21: invokevirtual getStringArrayList : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore #5
    //   26: aload_2
    //   27: ldc 'summary'
    //   29: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   32: astore #6
    //   34: aload_2
    //   35: ldc 'req_type'
    //   37: iconst_3
    //   38: invokevirtual getInt : (Ljava/lang/String;I)I
    //   41: istore #7
    //   43: aload_2
    //   44: ldc 'appName'
    //   46: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   49: astore #8
    //   51: aload_2
    //   52: ldc 'videoPath'
    //   54: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   57: astore #9
    //   59: aload_2
    //   60: ldc 'videoDuration'
    //   62: invokevirtual getInt : (Ljava/lang/String;)I
    //   65: istore #10
    //   67: aload_2
    //   68: ldc 'videoSize'
    //   70: invokevirtual getLong : (Ljava/lang/String;)J
    //   73: lstore #11
    //   75: ldc ''
    //   77: astore_3
    //   78: aload_2
    //   79: ldc 'extMap'
    //   81: invokevirtual getBundle : (Ljava/lang/String;)Landroid/os/Bundle;
    //   84: astore #13
    //   86: aload #13
    //   88: ifnull -> 984
    //   91: aload #13
    //   93: invokevirtual keySet : ()Ljava/util/Set;
    //   96: astore #14
    //   98: new org/json/JSONObject
    //   101: astore_2
    //   102: aload_2
    //   103: invokespecial <init> : ()V
    //   106: aload #14
    //   108: invokeinterface iterator : ()Ljava/util/Iterator;
    //   113: astore #15
    //   115: aload #15
    //   117: invokeinterface hasNext : ()Z
    //   122: ifeq -> 305
    //   125: aload #15
    //   127: invokeinterface next : ()Ljava/lang/Object;
    //   132: checkcast java/lang/String
    //   135: astore #14
    //   137: aload #13
    //   139: aload #14
    //   141: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   144: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   147: ifne -> 115
    //   150: aload_2
    //   151: aload #14
    //   153: aload #13
    //   155: aload #14
    //   157: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   160: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: goto -> 115
    //   167: astore_2
    //   168: ldc 'openSDK_LOG.QzonePublish'
    //   170: ldc 'publishToQzone()  --error parse extmap'
    //   172: aload_2
    //   173: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_0
    //   177: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   180: invokevirtual getAppId : ()Ljava/lang/String;
    //   183: astore #15
    //   185: aload_0
    //   186: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   189: invokevirtual getOpenId : ()Ljava/lang/String;
    //   192: astore #14
    //   194: ldc 'openSDK_LOG.QzonePublish'
    //   196: new java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial <init> : ()V
    //   203: ldc 'openId:'
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload #14
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   219: ldc ''
    //   221: astore #13
    //   223: aload #13
    //   225: astore_2
    //   226: iconst_3
    //   227: iload #7
    //   229: if_icmpne -> 360
    //   232: aload #13
    //   234: astore_2
    //   235: aload #5
    //   237: ifnull -> 360
    //   240: new java/lang/StringBuffer
    //   243: dup
    //   244: invokespecial <init> : ()V
    //   247: astore_2
    //   248: aload #5
    //   250: invokevirtual size : ()I
    //   253: istore #16
    //   255: iconst_0
    //   256: istore #17
    //   258: iload #17
    //   260: iload #16
    //   262: if_icmpge -> 322
    //   265: aload_2
    //   266: aload #5
    //   268: iload #17
    //   270: invokevirtual get : (I)Ljava/lang/Object;
    //   273: checkcast java/lang/String
    //   276: invokestatic encode : (Ljava/lang/String;)Ljava/lang/String;
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   282: pop
    //   283: iload #17
    //   285: iload #16
    //   287: iconst_1
    //   288: isub
    //   289: if_icmpeq -> 299
    //   292: aload_2
    //   293: ldc ';'
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   298: pop
    //   299: iinc #17, 1
    //   302: goto -> 258
    //   305: aload_2
    //   306: invokevirtual length : ()I
    //   309: ifle -> 984
    //   312: aload_2
    //   313: invokevirtual toString : ()Ljava/lang/String;
    //   316: astore_2
    //   317: aload_2
    //   318: astore_3
    //   319: goto -> 176
    //   322: aload #4
    //   324: new java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial <init> : ()V
    //   331: ldc '&image_url='
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_2
    //   337: invokevirtual toString : ()Ljava/lang/String;
    //   340: invokestatic i : (Ljava/lang/String;)[B
    //   343: iconst_2
    //   344: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   356: pop
    //   357: ldc '7'
    //   359: astore_2
    //   360: iconst_4
    //   361: iload #7
    //   363: if_icmpne -> 474
    //   366: ldc '8'
    //   368: astore_2
    //   369: aload #4
    //   371: new java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial <init> : ()V
    //   378: ldc '&videoPath='
    //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload #9
    //   385: invokestatic i : (Ljava/lang/String;)[B
    //   388: iconst_2
    //   389: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual toString : ()Ljava/lang/String;
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   401: pop
    //   402: aload #4
    //   404: new java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial <init> : ()V
    //   411: ldc '&videoDuration='
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: iload #10
    //   418: invokestatic valueOf : (I)Ljava/lang/String;
    //   421: invokestatic i : (Ljava/lang/String;)[B
    //   424: iconst_2
    //   425: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual toString : ()Ljava/lang/String;
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   437: pop
    //   438: aload #4
    //   440: new java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial <init> : ()V
    //   447: ldc '&videoSize='
    //   449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: lload #11
    //   454: invokestatic valueOf : (J)Ljava/lang/String;
    //   457: invokestatic i : (Ljava/lang/String;)[B
    //   460: iconst_2
    //   461: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   464: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual toString : ()Ljava/lang/String;
    //   470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   473: pop
    //   474: aload #6
    //   476: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   479: ifne -> 515
    //   482: aload #4
    //   484: new java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial <init> : ()V
    //   491: ldc '&description='
    //   493: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload #6
    //   498: invokestatic i : (Ljava/lang/String;)[B
    //   501: iconst_2
    //   502: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   505: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual toString : ()Ljava/lang/String;
    //   511: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   514: pop
    //   515: aload #15
    //   517: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   520: ifne -> 549
    //   523: aload #4
    //   525: new java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial <init> : ()V
    //   532: ldc '&share_id='
    //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload #15
    //   539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual toString : ()Ljava/lang/String;
    //   545: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   548: pop
    //   549: aload #8
    //   551: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   554: ifne -> 590
    //   557: aload #4
    //   559: new java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial <init> : ()V
    //   566: ldc '&app_name='
    //   568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload #8
    //   573: invokestatic i : (Ljava/lang/String;)[B
    //   576: iconst_2
    //   577: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   580: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual toString : ()Ljava/lang/String;
    //   586: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   589: pop
    //   590: aload #14
    //   592: invokestatic e : (Ljava/lang/String;)Z
    //   595: ifne -> 631
    //   598: aload #4
    //   600: new java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial <init> : ()V
    //   607: ldc '&open_id='
    //   609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload #14
    //   614: invokestatic i : (Ljava/lang/String;)[B
    //   617: iconst_2
    //   618: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual toString : ()Ljava/lang/String;
    //   627: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   630: pop
    //   631: aload_3
    //   632: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   635: ifne -> 670
    //   638: aload #4
    //   640: new java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial <init> : ()V
    //   647: ldc '&share_qzone_ext_str='
    //   649: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_3
    //   653: invokestatic i : (Ljava/lang/String;)[B
    //   656: iconst_2
    //   657: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   660: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual toString : ()Ljava/lang/String;
    //   666: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   669: pop
    //   670: aload #4
    //   672: new java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial <init> : ()V
    //   679: ldc '&req_type='
    //   681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: iload #7
    //   686: invokestatic valueOf : (I)Ljava/lang/String;
    //   689: invokestatic i : (Ljava/lang/String;)[B
    //   692: iconst_2
    //   693: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   696: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual toString : ()Ljava/lang/String;
    //   702: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   705: pop
    //   706: ldc 'openSDK_LOG.QzonePublish'
    //   708: new java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial <init> : ()V
    //   715: ldc 'doPublishToQzone, url: '
    //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload #4
    //   722: invokevirtual toString : ()Ljava/lang/String;
    //   725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual toString : ()Ljava/lang/String;
    //   731: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   734: invokestatic a : ()Landroid/content/Context;
    //   737: aload_0
    //   738: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   741: ldc 'requireApi'
    //   743: iconst_1
    //   744: anewarray java/lang/String
    //   747: dup
    //   748: iconst_0
    //   749: ldc 'shareToNativeQQ'
    //   751: aastore
    //   752: invokestatic a : (Landroid/content/Context;Lcom/tencent/connect/auth/QQToken;Ljava/lang/String;[Ljava/lang/String;)V
    //   755: new android/content/Intent
    //   758: dup
    //   759: ldc_w 'android.intent.action.VIEW'
    //   762: invokespecial <init> : (Ljava/lang/String;)V
    //   765: astore_3
    //   766: aload_3
    //   767: aload #4
    //   769: invokevirtual toString : ()Ljava/lang/String;
    //   772: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   775: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   778: pop
    //   779: aload_3
    //   780: ldc_w 'pkg_name'
    //   783: aload_1
    //   784: invokevirtual getPackageName : ()Ljava/lang/String;
    //   787: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   790: pop
    //   791: aload_0
    //   792: aload_3
    //   793: invokevirtual a : (Landroid/content/Intent;)Z
    //   796: ifeq -> 896
    //   799: aload_0
    //   800: aload_1
    //   801: sipush #10104
    //   804: aload_3
    //   805: iconst_0
    //   806: invokevirtual a : (Landroid/app/Activity;ILandroid/content/Intent;Z)V
    //   809: invokestatic a : ()Lcom/tencent/open/b/d;
    //   812: iconst_0
    //   813: ldc_w 'SHARE_CHECK_SDK'
    //   816: ldc_w '1000'
    //   819: aload_0
    //   820: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   823: invokevirtual getAppId : ()Ljava/lang/String;
    //   826: iconst_4
    //   827: invokestatic valueOf : (I)Ljava/lang/String;
    //   830: invokestatic elapsedRealtime : ()J
    //   833: invokestatic valueOf : (J)Ljava/lang/Long;
    //   836: iconst_0
    //   837: iconst_1
    //   838: ldc_w 'hasActivityForIntent success'
    //   841: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   844: invokestatic a : ()Lcom/tencent/open/b/d;
    //   847: aload_0
    //   848: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   851: invokevirtual getOpenId : ()Ljava/lang/String;
    //   854: aload_0
    //   855: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   858: invokevirtual getAppId : ()Ljava/lang/String;
    //   861: ldc_w 'ANDROIDQQ.SHARETOQZ.XX'
    //   864: ldc_w '11'
    //   867: ldc_w '3'
    //   870: ldc_w '1'
    //   873: aload_2
    //   874: ldc_w '0'
    //   877: ldc_w '1'
    //   880: ldc_w '0'
    //   883: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   886: ldc_w 'openSDK_LOG'
    //   889: ldc_w 'doPublishToQzone() --end'
    //   892: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   895: return
    //   896: ldc 'openSDK_LOG.QzonePublish'
    //   898: ldc_w 'doPublishToQzone() target activity not found'
    //   901: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   904: invokestatic a : ()Lcom/tencent/open/b/d;
    //   907: iconst_1
    //   908: ldc_w 'SHARE_CHECK_SDK'
    //   911: ldc_w '1000'
    //   914: aload_0
    //   915: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   918: invokevirtual getAppId : ()Ljava/lang/String;
    //   921: iconst_4
    //   922: invokestatic valueOf : (I)Ljava/lang/String;
    //   925: invokestatic elapsedRealtime : ()J
    //   928: invokestatic valueOf : (J)Ljava/lang/Long;
    //   931: iconst_0
    //   932: iconst_1
    //   933: ldc_w 'hasActivityForIntent fail'
    //   936: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   939: invokestatic a : ()Lcom/tencent/open/b/d;
    //   942: aload_0
    //   943: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   946: invokevirtual getOpenId : ()Ljava/lang/String;
    //   949: aload_0
    //   950: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   953: invokevirtual getAppId : ()Ljava/lang/String;
    //   956: ldc_w 'ANDROIDQQ.SHARETOQZ.XX'
    //   959: ldc_w '11'
    //   962: ldc_w '3'
    //   965: ldc_w '1'
    //   968: aload_2
    //   969: ldc_w '0'
    //   972: ldc_w '1'
    //   975: ldc_w '0'
    //   978: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   981: goto -> 886
    //   984: ldc ''
    //   986: astore_2
    //   987: goto -> 317
    // Exception table:
    //   from	to	target	type
    //   78	86	167	java/lang/Exception
    //   91	115	167	java/lang/Exception
    //   115	164	167	java/lang/Exception
    //   305	317	167	java/lang/Exception
  }
  
  public void publishToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    String str2;
    int i = 0;
    f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
    if (paramBundle == null) {
      paramIUiListener.onError(new UiError(-6, "传入参数不可以为空", null));
      f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "传入参数不可以为空");
      return;
    } 
    if (!i.e((Context)paramActivity)) {
      paramIUiListener.onError(new UiError(-15, "手Q版本过低，请下载安装最新版手Q", null));
      f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
      (new TDialog((Context)paramActivity, "", a(""), null, this.b)).show();
      return;
    } 
    String str1 = i.a((Context)paramActivity);
    if (str1 == null) {
      str2 = paramBundle.getString("appName");
    } else {
      str2 = str1;
      if (str1.length() > 20)
        str2 = str1.substring(0, 20) + "..."; 
    } 
    if (!TextUtils.isEmpty(str2))
      paramBundle.putString("appName", str2); 
    int j = paramBundle.getInt("req_type");
    if (j == 3) {
      ArrayList<String> arrayList = paramBundle.getStringArrayList("imageUrl");
      if (arrayList != null && arrayList.size() > 0) {
        while (i < arrayList.size()) {
          j = i;
          if (!i.h(arrayList.get(i))) {
            arrayList.remove(i);
            j = i - 1;
          } 
          i = j + 1;
        } 
        paramBundle.putStringArrayList("imageUrl", arrayList);
      } 
      b(paramActivity, paramBundle, paramIUiListener);
      f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
      return;
    } 
    if (j == 4) {
      str2 = paramBundle.getString("videoPath");
      if (!i.h(str2)) {
        f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
        paramIUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
        return;
      } 
      MediaPlayer mediaPlayer = new MediaPlayer();
      mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, str2, paramBundle, paramActivity, paramIUiListener) {
            public void onPrepared(MediaPlayer param1MediaPlayer) {
              long l = (new File(this.a)).length();
              int i = param1MediaPlayer.getDuration();
              this.b.putString("videoPath", this.a);
              this.b.putInt("videoDuration", i);
              this.b.putLong("videoSize", l);
              QzonePublish.a(this.e, this.c, this.b, this.d);
              f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
          });
      mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this, paramIUiListener) {
            public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
              f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
              this.a.onError(new UiError(-5, "请选择有效的视频文件", null));
              return false;
            }
          });
      try {
        mediaPlayer.setDataSource(str2);
        mediaPlayer.prepareAsync();
      } catch (Exception exception) {
        f.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
        paramIUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
      } 
      return;
    } 
    paramIUiListener.onError(new UiError(-5, "请选择支持的分享类型", null));
    f.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\share\QzonePublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
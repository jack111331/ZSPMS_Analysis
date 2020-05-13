package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;

public class QzoneShare extends BaseApi {
  public static final String SHARE_TO_QQ_APP_NAME = "appName";
  
  public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
  
  public static final String SHARE_TO_QQ_EXT_INT = "cflag";
  
  public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
  
  public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
  
  public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
  
  public static final String SHARE_TO_QQ_SITE = "site";
  
  public static final String SHARE_TO_QQ_SUMMARY = "summary";
  
  public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
  
  public static final String SHARE_TO_QQ_TITLE = "title";
  
  public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
  
  public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
  
  public static final int SHARE_TO_QZONE_TYPE_APP = 6;
  
  public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
  
  public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
  
  public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
  
  private boolean c = true;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private boolean f = false;
  
  public String mViaShareQzoneType = "";
  
  public QzoneShare(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.QzoneShare'
    //   2: ldc 'doshareToQzone() --start'
    //   4: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   7: new java/lang/StringBuffer
    //   10: dup
    //   11: ldc 'mqqapi://share/to_qzone?src_type=app&version=1&file_type=news'
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: astore #4
    //   18: aload_2
    //   19: ldc 'imageUrl'
    //   21: invokevirtual getStringArrayList : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore #5
    //   26: aload_2
    //   27: ldc 'title'
    //   29: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   32: astore #6
    //   34: aload_2
    //   35: ldc 'summary'
    //   37: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   40: astore #7
    //   42: aload_2
    //   43: ldc 'targetUrl'
    //   45: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   48: astore #8
    //   50: aload_2
    //   51: ldc 'audio_url'
    //   53: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   56: astore #9
    //   58: aload_2
    //   59: ldc 'req_type'
    //   61: iconst_1
    //   62: invokevirtual getInt : (Ljava/lang/String;I)I
    //   65: istore #10
    //   67: aload_2
    //   68: ldc 'appName'
    //   70: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   73: astore #11
    //   75: aload_2
    //   76: ldc 'cflag'
    //   78: iconst_0
    //   79: invokevirtual getInt : (Ljava/lang/String;I)I
    //   82: istore #12
    //   84: aload_2
    //   85: ldc 'share_qq_ext_str'
    //   87: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   90: astore #13
    //   92: ldc ''
    //   94: astore #14
    //   96: aload_2
    //   97: ldc 'extMap'
    //   99: invokevirtual getBundle : (Ljava/lang/String;)Landroid/os/Bundle;
    //   102: astore #15
    //   104: aload #15
    //   106: ifnull -> 1169
    //   109: aload #15
    //   111: invokevirtual keySet : ()Ljava/util/Set;
    //   114: astore #16
    //   116: new org/json/JSONObject
    //   119: astore #17
    //   121: aload #17
    //   123: invokespecial <init> : ()V
    //   126: aload #16
    //   128: invokeinterface iterator : ()Ljava/util/Iterator;
    //   133: astore #18
    //   135: aload #18
    //   137: invokeinterface hasNext : ()Z
    //   142: ifeq -> 307
    //   145: aload #18
    //   147: invokeinterface next : ()Ljava/lang/Object;
    //   152: checkcast java/lang/String
    //   155: astore_2
    //   156: aload #17
    //   158: aload_2
    //   159: aload #15
    //   161: aload_2
    //   162: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   165: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: goto -> 135
    //   172: astore_2
    //   173: ldc 'openSDK_LOG.QzoneShare'
    //   175: ldc 'ShareToQzone()  --error parse extmap'
    //   177: aload_2
    //   178: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload #14
    //   183: astore_2
    //   184: aload_0
    //   185: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   188: invokevirtual getAppId : ()Ljava/lang/String;
    //   191: astore #16
    //   193: aload_0
    //   194: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   197: invokevirtual getOpenId : ()Ljava/lang/String;
    //   200: astore #15
    //   202: ldc 'openSDK_LOG.QzoneShare'
    //   204: new java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial <init> : ()V
    //   211: ldc 'openId:'
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload #15
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual toString : ()Ljava/lang/String;
    //   224: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload #5
    //   229: ifnull -> 372
    //   232: new java/lang/StringBuffer
    //   235: dup
    //   236: invokespecial <init> : ()V
    //   239: astore #14
    //   241: aload #5
    //   243: invokevirtual size : ()I
    //   246: bipush #9
    //   248: if_icmple -> 326
    //   251: bipush #9
    //   253: istore #19
    //   255: iconst_0
    //   256: istore #20
    //   258: iload #20
    //   260: iload #19
    //   262: if_icmpge -> 336
    //   265: aload #14
    //   267: aload #5
    //   269: iload #20
    //   271: invokevirtual get : (I)Ljava/lang/Object;
    //   274: checkcast java/lang/String
    //   277: invokestatic encode : (Ljava/lang/String;)Ljava/lang/String;
    //   280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   283: pop
    //   284: iload #20
    //   286: iload #19
    //   288: iconst_1
    //   289: isub
    //   290: if_icmpeq -> 301
    //   293: aload #14
    //   295: ldc ';'
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: pop
    //   301: iinc #20, 1
    //   304: goto -> 258
    //   307: aload #16
    //   309: invokeinterface size : ()I
    //   314: ifle -> 1169
    //   317: aload #17
    //   319: invokevirtual toString : ()Ljava/lang/String;
    //   322: astore_2
    //   323: goto -> 184
    //   326: aload #5
    //   328: invokevirtual size : ()I
    //   331: istore #19
    //   333: goto -> 255
    //   336: aload #4
    //   338: new java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial <init> : ()V
    //   345: ldc '&image_url='
    //   347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload #14
    //   352: invokevirtual toString : ()Ljava/lang/String;
    //   355: invokestatic i : (Ljava/lang/String;)[B
    //   358: iconst_2
    //   359: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual toString : ()Ljava/lang/String;
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   371: pop
    //   372: aload #6
    //   374: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   377: ifne -> 413
    //   380: aload #4
    //   382: new java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial <init> : ()V
    //   389: ldc '&title='
    //   391: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload #6
    //   396: invokestatic i : (Ljava/lang/String;)[B
    //   399: iconst_2
    //   400: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   403: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual toString : ()Ljava/lang/String;
    //   409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   412: pop
    //   413: aload #7
    //   415: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   418: ifne -> 454
    //   421: aload #4
    //   423: new java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial <init> : ()V
    //   430: ldc '&description='
    //   432: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload #7
    //   437: invokestatic i : (Ljava/lang/String;)[B
    //   440: iconst_2
    //   441: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual toString : ()Ljava/lang/String;
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   453: pop
    //   454: aload #16
    //   456: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   459: ifne -> 488
    //   462: aload #4
    //   464: new java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial <init> : ()V
    //   471: ldc '&share_id='
    //   473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload #16
    //   478: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual toString : ()Ljava/lang/String;
    //   484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   487: pop
    //   488: aload #8
    //   490: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   493: ifne -> 529
    //   496: aload #4
    //   498: new java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial <init> : ()V
    //   505: ldc '&url='
    //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload #8
    //   512: invokestatic i : (Ljava/lang/String;)[B
    //   515: iconst_2
    //   516: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual toString : ()Ljava/lang/String;
    //   525: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   528: pop
    //   529: aload #11
    //   531: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   534: ifne -> 570
    //   537: aload #4
    //   539: new java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial <init> : ()V
    //   546: ldc '&app_name='
    //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload #11
    //   553: invokestatic i : (Ljava/lang/String;)[B
    //   556: iconst_2
    //   557: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual toString : ()Ljava/lang/String;
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   569: pop
    //   570: aload #15
    //   572: invokestatic e : (Ljava/lang/String;)Z
    //   575: ifne -> 611
    //   578: aload #4
    //   580: new java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial <init> : ()V
    //   587: ldc '&open_id='
    //   589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload #15
    //   594: invokestatic i : (Ljava/lang/String;)[B
    //   597: iconst_2
    //   598: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   601: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual toString : ()Ljava/lang/String;
    //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   610: pop
    //   611: aload #9
    //   613: invokestatic e : (Ljava/lang/String;)Z
    //   616: ifne -> 652
    //   619: aload #4
    //   621: new java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial <init> : ()V
    //   628: ldc '&audioUrl='
    //   630: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload #9
    //   635: invokestatic i : (Ljava/lang/String;)[B
    //   638: iconst_2
    //   639: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   642: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual toString : ()Ljava/lang/String;
    //   648: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   651: pop
    //   652: aload #4
    //   654: new java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial <init> : ()V
    //   661: ldc '&req_type='
    //   663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload #10
    //   668: invokestatic valueOf : (I)Ljava/lang/String;
    //   671: invokestatic i : (Ljava/lang/String;)[B
    //   674: iconst_2
    //   675: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual toString : ()Ljava/lang/String;
    //   684: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   687: pop
    //   688: aload #13
    //   690: invokestatic e : (Ljava/lang/String;)Z
    //   693: ifne -> 729
    //   696: aload #4
    //   698: new java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial <init> : ()V
    //   705: ldc '&share_qq_ext_str='
    //   707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload #13
    //   712: invokestatic i : (Ljava/lang/String;)[B
    //   715: iconst_2
    //   716: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual toString : ()Ljava/lang/String;
    //   725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   728: pop
    //   729: aload_2
    //   730: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   733: ifne -> 768
    //   736: aload #4
    //   738: new java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial <init> : ()V
    //   745: ldc '&share_qzone_ext_str='
    //   747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_2
    //   751: invokestatic i : (Ljava/lang/String;)[B
    //   754: iconst_2
    //   755: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   758: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual toString : ()Ljava/lang/String;
    //   764: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   767: pop
    //   768: aload #4
    //   770: new java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial <init> : ()V
    //   777: ldc_w '&cflag='
    //   780: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: iload #12
    //   785: invokestatic valueOf : (I)Ljava/lang/String;
    //   788: invokestatic i : (Ljava/lang/String;)[B
    //   791: iconst_2
    //   792: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   795: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual toString : ()Ljava/lang/String;
    //   801: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   804: pop
    //   805: ldc 'openSDK_LOG.QzoneShare'
    //   807: new java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial <init> : ()V
    //   814: ldc_w 'doshareToQzone, url: '
    //   817: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload #4
    //   822: invokevirtual toString : ()Ljava/lang/String;
    //   825: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual toString : ()Ljava/lang/String;
    //   831: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   834: invokestatic a : ()Landroid/content/Context;
    //   837: aload_0
    //   838: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   841: ldc_w 'requireApi'
    //   844: iconst_1
    //   845: anewarray java/lang/String
    //   848: dup
    //   849: iconst_0
    //   850: ldc_w 'shareToNativeQQ'
    //   853: aastore
    //   854: invokestatic a : (Landroid/content/Context;Lcom/tencent/connect/auth/QQToken;Ljava/lang/String;[Ljava/lang/String;)V
    //   857: new android/content/Intent
    //   860: dup
    //   861: ldc_w 'android.intent.action.VIEW'
    //   864: invokespecial <init> : (Ljava/lang/String;)V
    //   867: astore_2
    //   868: aload_2
    //   869: aload #4
    //   871: invokevirtual toString : ()Ljava/lang/String;
    //   874: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   877: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   880: pop
    //   881: aload_2
    //   882: ldc_w 'pkg_name'
    //   885: aload_1
    //   886: invokevirtual getPackageName : ()Ljava/lang/String;
    //   889: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   892: pop
    //   893: aload_1
    //   894: ldc_w '4.6.0'
    //   897: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)Z
    //   900: ifeq -> 1036
    //   903: aload_0
    //   904: aload_2
    //   905: invokevirtual a : (Landroid/content/Intent;)Z
    //   908: ifeq -> 931
    //   911: invokestatic getInstance : ()Lcom/tencent/connect/common/UIListenerManager;
    //   914: sipush #11104
    //   917: aload_3
    //   918: invokevirtual setListenerWithRequestcode : (ILcom/tencent/tauth/IUiListener;)Ljava/lang/Object;
    //   921: pop
    //   922: aload_0
    //   923: aload_1
    //   924: aload_2
    //   925: sipush #11104
    //   928: invokevirtual a : (Landroid/app/Activity;Landroid/content/Intent;I)V
    //   931: ldc 'openSDK_LOG.QzoneShare'
    //   933: ldc_w 'doShareToQzone() -- QQ Version is < 4.6.0'
    //   936: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   939: aload_0
    //   940: aload_2
    //   941: invokevirtual a : (Landroid/content/Intent;)Z
    //   944: ifeq -> 1086
    //   947: invokestatic a : ()Lcom/tencent/open/b/d;
    //   950: aload_0
    //   951: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   954: invokevirtual getOpenId : ()Ljava/lang/String;
    //   957: aload_0
    //   958: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   961: invokevirtual getAppId : ()Ljava/lang/String;
    //   964: ldc_w 'ANDROIDQQ.SHARETOQZ.XX'
    //   967: ldc_w '11'
    //   970: ldc_w '3'
    //   973: ldc_w '0'
    //   976: aload_0
    //   977: getfield mViaShareQzoneType : Ljava/lang/String;
    //   980: ldc_w '0'
    //   983: ldc_w '1'
    //   986: ldc_w '0'
    //   989: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   992: invokestatic a : ()Lcom/tencent/open/b/d;
    //   995: iconst_0
    //   996: ldc_w 'SHARE_CHECK_SDK'
    //   999: ldc_w '1000'
    //   1002: aload_0
    //   1003: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1006: invokevirtual getAppId : ()Ljava/lang/String;
    //   1009: iconst_4
    //   1010: invokestatic valueOf : (I)Ljava/lang/String;
    //   1013: invokestatic elapsedRealtime : ()J
    //   1016: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1019: iconst_0
    //   1020: iconst_1
    //   1021: ldc ''
    //   1023: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1026: ldc_w 'openSDK_LOG'
    //   1029: ldc_w 'doShareToQzone() --end'
    //   1032: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1035: return
    //   1036: ldc 'openSDK_LOG.QzoneShare'
    //   1038: ldc_w 'doShareToQzone() -- QQ Version is > 4.6.0'
    //   1041: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1044: invokestatic getInstance : ()Lcom/tencent/connect/common/UIListenerManager;
    //   1047: ldc_w 'shareToQzone'
    //   1050: aload_3
    //   1051: invokevirtual setListnerWithAction : (Ljava/lang/String;Lcom/tencent/tauth/IUiListener;)Ljava/lang/Object;
    //   1054: ifnull -> 1065
    //   1057: ldc 'openSDK_LOG.QzoneShare'
    //   1059: ldc_w 'doShareToQzone() -- do listener onCancel()'
    //   1062: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1065: aload_0
    //   1066: aload_2
    //   1067: invokevirtual a : (Landroid/content/Intent;)Z
    //   1070: ifeq -> 939
    //   1073: aload_0
    //   1074: aload_1
    //   1075: sipush #10104
    //   1078: aload_2
    //   1079: iconst_0
    //   1080: invokevirtual a : (Landroid/app/Activity;ILandroid/content/Intent;Z)V
    //   1083: goto -> 939
    //   1086: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1089: aload_0
    //   1090: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1093: invokevirtual getOpenId : ()Ljava/lang/String;
    //   1096: aload_0
    //   1097: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1100: invokevirtual getAppId : ()Ljava/lang/String;
    //   1103: ldc_w 'ANDROIDQQ.SHARETOQZ.XX'
    //   1106: ldc_w '11'
    //   1109: ldc_w '3'
    //   1112: ldc_w '1'
    //   1115: aload_0
    //   1116: getfield mViaShareQzoneType : Ljava/lang/String;
    //   1119: ldc_w '0'
    //   1122: ldc_w '1'
    //   1125: ldc_w '0'
    //   1128: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1131: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1134: iconst_1
    //   1135: ldc_w 'SHARE_CHECK_SDK'
    //   1138: ldc_w '1000'
    //   1141: aload_0
    //   1142: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1145: invokevirtual getAppId : ()Ljava/lang/String;
    //   1148: iconst_4
    //   1149: invokestatic valueOf : (I)Ljava/lang/String;
    //   1152: invokestatic elapsedRealtime : ()J
    //   1155: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1158: iconst_0
    //   1159: iconst_1
    //   1160: ldc_w 'hasActivityForIntent fail'
    //   1163: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1166: goto -> 1026
    //   1169: ldc ''
    //   1171: astore_2
    //   1172: goto -> 323
    // Exception table:
    //   from	to	target	type
    //   96	104	172	java/lang/Exception
    //   109	135	172	java/lang/Exception
    //   135	169	172	java/lang/Exception
    //   307	323	172	java/lang/Exception
  }
  
  public void releaseResource() {}
  
  public void shareToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.QzoneShare'
    //   2: ldc_w 'shareToQzone() -- start'
    //   5: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: ifnonnull -> 75
    //   12: aload_3
    //   13: new com/tencent/tauth/UiError
    //   16: dup
    //   17: bipush #-6
    //   19: ldc_w '传入参数不可以为空'
    //   22: aconst_null
    //   23: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   26: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   31: ldc 'openSDK_LOG.QzoneShare'
    //   33: ldc_w 'shareToQzone() params is null'
    //   36: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: invokestatic a : ()Lcom/tencent/open/b/d;
    //   42: iconst_1
    //   43: ldc_w 'SHARE_CHECK_SDK'
    //   46: ldc_w '1000'
    //   49: aload_0
    //   50: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   53: invokevirtual getAppId : ()Ljava/lang/String;
    //   56: iconst_4
    //   57: invokestatic valueOf : (I)Ljava/lang/String;
    //   60: invokestatic elapsedRealtime : ()J
    //   63: invokestatic valueOf : (J)Ljava/lang/Long;
    //   66: iconst_0
    //   67: iconst_1
    //   68: ldc_w '传入参数不可以为空'
    //   71: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   74: return
    //   75: aload_2
    //   76: ldc 'title'
    //   78: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #4
    //   83: aload_2
    //   84: ldc 'summary'
    //   86: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   89: astore #5
    //   91: aload_2
    //   92: ldc 'targetUrl'
    //   94: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   97: astore #6
    //   99: aload_2
    //   100: ldc 'imageUrl'
    //   102: invokevirtual getStringArrayList : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   105: astore #7
    //   107: aload_1
    //   108: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   111: astore #8
    //   113: aload #8
    //   115: ifnonnull -> 366
    //   118: aload_2
    //   119: ldc 'appName'
    //   121: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   124: astore #9
    //   126: aload_2
    //   127: ldc 'req_type'
    //   129: invokevirtual getInt : (Ljava/lang/String;)I
    //   132: istore #10
    //   134: iload #10
    //   136: tableswitch default -> 176, 1 -> 422, 2 -> 176, 3 -> 176, 4 -> 176, 5 -> 432, 6 -> 412
    //   176: aload_0
    //   177: ldc_w '1'
    //   180: putfield mViaShareQzoneType : Ljava/lang/String;
    //   183: iload #10
    //   185: tableswitch default -> 224, 1 -> 564, 2 -> 224, 3 -> 224, 4 -> 224, 5 -> 599, 6 -> 442
    //   224: aload #4
    //   226: invokestatic e : (Ljava/lang/String;)Z
    //   229: ifeq -> 701
    //   232: aload #5
    //   234: invokestatic e : (Ljava/lang/String;)Z
    //   237: ifeq -> 701
    //   240: aload #7
    //   242: ifnull -> 664
    //   245: aload #7
    //   247: invokevirtual size : ()I
    //   250: ifeq -> 664
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield c : Z
    //   258: aload_0
    //   259: iconst_0
    //   260: putfield d : Z
    //   263: aload_0
    //   264: iconst_1
    //   265: putfield e : Z
    //   268: aload_0
    //   269: iconst_0
    //   270: putfield f : Z
    //   273: aload #4
    //   275: astore #8
    //   277: aload #6
    //   279: astore #4
    //   281: aload #8
    //   283: astore #6
    //   285: invokestatic b : ()Z
    //   288: ifne -> 709
    //   291: aload_1
    //   292: ldc_w '4.5.0'
    //   295: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)Z
    //   298: ifeq -> 709
    //   301: aload_3
    //   302: new com/tencent/tauth/UiError
    //   305: dup
    //   306: bipush #-6
    //   308: ldc_w '分享图片失败，检测不到SD卡!'
    //   311: aconst_null
    //   312: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   315: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   320: ldc 'openSDK_LOG.QzoneShare'
    //   322: ldc_w 'shareToQzone() sdcard is null--end'
    //   325: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   328: invokestatic a : ()Lcom/tencent/open/b/d;
    //   331: iconst_1
    //   332: ldc_w 'SHARE_CHECK_SDK'
    //   335: ldc_w '1000'
    //   338: aload_0
    //   339: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   342: invokevirtual getAppId : ()Ljava/lang/String;
    //   345: iconst_4
    //   346: invokestatic valueOf : (I)Ljava/lang/String;
    //   349: invokestatic elapsedRealtime : ()J
    //   352: invokestatic valueOf : (J)Ljava/lang/Long;
    //   355: iconst_0
    //   356: iconst_1
    //   357: ldc_w '分享图片失败，检测不到SD卡!'
    //   360: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   363: goto -> 74
    //   366: aload #8
    //   368: astore #9
    //   370: aload #8
    //   372: invokevirtual length : ()I
    //   375: bipush #20
    //   377: if_icmple -> 126
    //   380: new java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial <init> : ()V
    //   387: aload #8
    //   389: iconst_0
    //   390: bipush #20
    //   392: invokevirtual substring : (II)Ljava/lang/String;
    //   395: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w '...'
    //   401: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual toString : ()Ljava/lang/String;
    //   407: astore #9
    //   409: goto -> 126
    //   412: aload_0
    //   413: ldc_w '4'
    //   416: putfield mViaShareQzoneType : Ljava/lang/String;
    //   419: goto -> 183
    //   422: aload_0
    //   423: ldc_w '1'
    //   426: putfield mViaShareQzoneType : Ljava/lang/String;
    //   429: goto -> 183
    //   432: aload_0
    //   433: ldc_w '2'
    //   436: putfield mViaShareQzoneType : Ljava/lang/String;
    //   439: goto -> 183
    //   442: aload_1
    //   443: ldc_w '5.0.0'
    //   446: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)Z
    //   449: ifeq -> 517
    //   452: aload_3
    //   453: new com/tencent/tauth/UiError
    //   456: dup
    //   457: bipush #-15
    //   459: ldc_w '手Q版本过低，应用分享只支持手Q5.0及其以上版本'
    //   462: aconst_null
    //   463: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   466: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   471: ldc 'openSDK_LOG.QzoneShare'
    //   473: ldc_w '-->shareToQzone, app share is not support below qq5.0.'
    //   476: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   479: invokestatic a : ()Lcom/tencent/open/b/d;
    //   482: iconst_1
    //   483: ldc_w 'SHARE_CHECK_SDK'
    //   486: ldc_w '1000'
    //   489: aload_0
    //   490: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   493: invokevirtual getAppId : ()Ljava/lang/String;
    //   496: iconst_4
    //   497: invokestatic valueOf : (I)Ljava/lang/String;
    //   500: invokestatic elapsedRealtime : ()J
    //   503: invokestatic valueOf : (J)Ljava/lang/Long;
    //   506: iconst_0
    //   507: iconst_1
    //   508: ldc_w 'shareToQzone, app share is not support below qq5.0.'
    //   511: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   514: goto -> 74
    //   517: ldc_w 'http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1'
    //   520: iconst_2
    //   521: anewarray java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload_0
    //   527: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   530: invokevirtual getAppId : ()Ljava/lang/String;
    //   533: aastore
    //   534: dup
    //   535: iconst_1
    //   536: ldc_w 'mqq'
    //   539: aastore
    //   540: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   543: astore #8
    //   545: aload_2
    //   546: ldc 'targetUrl'
    //   548: aload #8
    //   550: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload #4
    //   555: astore #6
    //   557: aload #8
    //   559: astore #4
    //   561: goto -> 285
    //   564: aload_0
    //   565: iconst_1
    //   566: putfield c : Z
    //   569: aload_0
    //   570: iconst_0
    //   571: putfield d : Z
    //   574: aload_0
    //   575: iconst_1
    //   576: putfield e : Z
    //   579: aload_0
    //   580: iconst_0
    //   581: putfield f : Z
    //   584: aload #4
    //   586: astore #8
    //   588: aload #6
    //   590: astore #4
    //   592: aload #8
    //   594: astore #6
    //   596: goto -> 285
    //   599: aload_3
    //   600: new com/tencent/tauth/UiError
    //   603: dup
    //   604: bipush #-5
    //   606: ldc_w '请选择支持的分享类型'
    //   609: aconst_null
    //   610: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   613: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   618: ldc 'openSDK_LOG.QzoneShare'
    //   620: ldc_w 'shareToQzone() error--end请选择支持的分享类型'
    //   623: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   626: invokestatic a : ()Lcom/tencent/open/b/d;
    //   629: iconst_1
    //   630: ldc_w 'SHARE_CHECK_SDK'
    //   633: ldc_w '1000'
    //   636: aload_0
    //   637: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   640: invokevirtual getAppId : ()Ljava/lang/String;
    //   643: iconst_4
    //   644: invokestatic valueOf : (I)Ljava/lang/String;
    //   647: invokestatic elapsedRealtime : ()J
    //   650: invokestatic valueOf : (J)Ljava/lang/Long;
    //   653: iconst_0
    //   654: iconst_1
    //   655: ldc_w 'shareToQzone() 请选择支持的分享类型'
    //   658: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   661: goto -> 74
    //   664: new java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial <init> : ()V
    //   671: ldc_w '来自'
    //   674: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload #9
    //   679: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc_w '的分享'
    //   685: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual toString : ()Ljava/lang/String;
    //   691: astore #4
    //   693: aload_0
    //   694: iconst_1
    //   695: putfield c : Z
    //   698: goto -> 258
    //   701: aload_0
    //   702: iconst_1
    //   703: putfield c : Z
    //   706: goto -> 258
    //   709: aload_0
    //   710: getfield c : Z
    //   713: ifeq -> 862
    //   716: aload #4
    //   718: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   721: ifeq -> 789
    //   724: aload_3
    //   725: new com/tencent/tauth/UiError
    //   728: dup
    //   729: bipush #-5
    //   731: ldc_w 'targetUrl为必填项，请补充后分享'
    //   734: aconst_null
    //   735: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   738: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   743: ldc 'openSDK_LOG.QzoneShare'
    //   745: ldc_w 'shareToQzone() targetUrl null error--end'
    //   748: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   751: invokestatic a : ()Lcom/tencent/open/b/d;
    //   754: iconst_1
    //   755: ldc_w 'SHARE_CHECK_SDK'
    //   758: ldc_w '1000'
    //   761: aload_0
    //   762: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   765: invokevirtual getAppId : ()Ljava/lang/String;
    //   768: iconst_4
    //   769: invokestatic valueOf : (I)Ljava/lang/String;
    //   772: invokestatic elapsedRealtime : ()J
    //   775: invokestatic valueOf : (J)Ljava/lang/Long;
    //   778: iconst_0
    //   779: iconst_1
    //   780: ldc_w 'targetUrl为必填项，请补充后分享'
    //   783: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   786: goto -> 74
    //   789: aload #4
    //   791: invokestatic g : (Ljava/lang/String;)Z
    //   794: ifne -> 862
    //   797: aload_3
    //   798: new com/tencent/tauth/UiError
    //   801: dup
    //   802: bipush #-5
    //   804: ldc_w 'targetUrl有误'
    //   807: aconst_null
    //   808: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   811: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   816: ldc 'openSDK_LOG.QzoneShare'
    //   818: ldc_w 'shareToQzone() targetUrl error--end'
    //   821: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   824: invokestatic a : ()Lcom/tencent/open/b/d;
    //   827: iconst_1
    //   828: ldc_w 'SHARE_CHECK_SDK'
    //   831: ldc_w '1000'
    //   834: aload_0
    //   835: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   838: invokevirtual getAppId : ()Ljava/lang/String;
    //   841: iconst_4
    //   842: invokestatic valueOf : (I)Ljava/lang/String;
    //   845: invokestatic elapsedRealtime : ()J
    //   848: invokestatic valueOf : (J)Ljava/lang/Long;
    //   851: iconst_0
    //   852: iconst_1
    //   853: ldc_w 'targetUrl有误'
    //   856: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   859: goto -> 74
    //   862: aload_0
    //   863: getfield d : Z
    //   866: ifeq -> 991
    //   869: aload_2
    //   870: ldc 'title'
    //   872: ldc ''
    //   874: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_2
    //   878: ldc 'summary'
    //   880: ldc ''
    //   882: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   885: aload #9
    //   887: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   890: ifne -> 901
    //   893: aload_2
    //   894: ldc 'appName'
    //   896: aload #9
    //   898: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   901: aload #7
    //   903: ifnull -> 919
    //   906: aload #7
    //   908: ifnull -> 1144
    //   911: aload #7
    //   913: invokevirtual size : ()I
    //   916: ifne -> 1144
    //   919: aload_0
    //   920: getfield f : Z
    //   923: ifeq -> 1297
    //   926: aload_3
    //   927: new com/tencent/tauth/UiError
    //   930: dup
    //   931: bipush #-6
    //   933: ldc_w '纯图分享，imageUrl 不能为空'
    //   936: aconst_null
    //   937: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   940: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   945: ldc 'openSDK_LOG.QzoneShare'
    //   947: ldc_w 'shareToQzone() imageUrl is null -- end'
    //   950: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   953: invokestatic a : ()Lcom/tencent/open/b/d;
    //   956: iconst_1
    //   957: ldc_w 'SHARE_CHECK_SDK'
    //   960: ldc_w '1000'
    //   963: aload_0
    //   964: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   967: invokevirtual getAppId : ()Ljava/lang/String;
    //   970: iconst_4
    //   971: invokestatic valueOf : (I)Ljava/lang/String;
    //   974: invokestatic elapsedRealtime : ()J
    //   977: invokestatic valueOf : (J)Ljava/lang/Long;
    //   980: iconst_0
    //   981: iconst_1
    //   982: ldc_w 'shareToQzone() imageUrl is null'
    //   985: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   988: goto -> 74
    //   991: aload_0
    //   992: getfield e : Z
    //   995: ifeq -> 1071
    //   998: aload #6
    //   1000: invokestatic e : (Ljava/lang/String;)Z
    //   1003: ifeq -> 1071
    //   1006: aload_3
    //   1007: new com/tencent/tauth/UiError
    //   1010: dup
    //   1011: bipush #-6
    //   1013: ldc_w 'title不能为空!'
    //   1016: aconst_null
    //   1017: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   1020: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   1025: ldc 'openSDK_LOG.QzoneShare'
    //   1027: ldc_w 'shareToQzone() title is null--end'
    //   1030: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1033: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1036: iconst_1
    //   1037: ldc_w 'SHARE_CHECK_SDK'
    //   1040: ldc_w '1000'
    //   1043: aload_0
    //   1044: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1047: invokevirtual getAppId : ()Ljava/lang/String;
    //   1050: iconst_4
    //   1051: invokestatic valueOf : (I)Ljava/lang/String;
    //   1054: invokestatic elapsedRealtime : ()J
    //   1057: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1060: iconst_0
    //   1061: iconst_1
    //   1062: ldc_w 'shareToQzone() title is null'
    //   1065: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1068: goto -> 74
    //   1071: aload #6
    //   1073: invokestatic e : (Ljava/lang/String;)Z
    //   1076: ifne -> 1106
    //   1079: aload #6
    //   1081: invokevirtual length : ()I
    //   1084: sipush #200
    //   1087: if_icmple -> 1106
    //   1090: aload_2
    //   1091: ldc 'title'
    //   1093: aload #6
    //   1095: sipush #200
    //   1098: aconst_null
    //   1099: aconst_null
    //   1100: invokestatic a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1103: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1106: aload #5
    //   1108: invokestatic e : (Ljava/lang/String;)Z
    //   1111: ifne -> 885
    //   1114: aload #5
    //   1116: invokevirtual length : ()I
    //   1119: sipush #600
    //   1122: if_icmple -> 885
    //   1125: aload_2
    //   1126: ldc 'summary'
    //   1128: aload #5
    //   1130: sipush #600
    //   1133: aconst_null
    //   1134: aconst_null
    //   1135: invokestatic a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1138: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1141: goto -> 885
    //   1144: iconst_0
    //   1145: istore #11
    //   1147: iload #11
    //   1149: aload #7
    //   1151: invokevirtual size : ()I
    //   1154: if_icmpge -> 1216
    //   1157: aload #7
    //   1159: iload #11
    //   1161: invokevirtual get : (I)Ljava/lang/Object;
    //   1164: checkcast java/lang/String
    //   1167: astore #9
    //   1169: iload #11
    //   1171: istore #12
    //   1173: aload #9
    //   1175: invokestatic g : (Ljava/lang/String;)Z
    //   1178: ifne -> 1207
    //   1181: iload #11
    //   1183: istore #12
    //   1185: aload #9
    //   1187: invokestatic h : (Ljava/lang/String;)Z
    //   1190: ifne -> 1207
    //   1193: aload #7
    //   1195: iload #11
    //   1197: invokevirtual remove : (I)Ljava/lang/Object;
    //   1200: pop
    //   1201: iload #11
    //   1203: iconst_1
    //   1204: isub
    //   1205: istore #12
    //   1207: iload #12
    //   1209: iconst_1
    //   1210: iadd
    //   1211: istore #11
    //   1213: goto -> 1147
    //   1216: aload #7
    //   1218: invokevirtual size : ()I
    //   1221: ifne -> 1289
    //   1224: aload_3
    //   1225: new com/tencent/tauth/UiError
    //   1228: dup
    //   1229: bipush #-6
    //   1231: ldc_w '非法的图片地址!'
    //   1234: aconst_null
    //   1235: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   1238: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   1243: ldc 'openSDK_LOG.QzoneShare'
    //   1245: ldc_w 'shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end'
    //   1248: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1251: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1254: iconst_1
    //   1255: ldc_w 'SHARE_CHECK_SDK'
    //   1258: ldc_w '1000'
    //   1261: aload_0
    //   1262: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1265: invokevirtual getAppId : ()Ljava/lang/String;
    //   1268: iconst_4
    //   1269: invokestatic valueOf : (I)Ljava/lang/String;
    //   1272: invokestatic elapsedRealtime : ()J
    //   1275: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1278: iconst_0
    //   1279: iconst_1
    //   1280: ldc_w 'shareToQzone() 非法的图片地址!'
    //   1283: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1286: goto -> 74
    //   1289: aload_2
    //   1290: ldc 'imageUrl'
    //   1292: aload #7
    //   1294: invokevirtual putStringArrayList : (Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1297: aload_1
    //   1298: ldc_w '4.6.0'
    //   1301: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)Z
    //   1304: ifne -> 1343
    //   1307: ldc 'openSDK_LOG.QzoneShare'
    //   1309: ldc_w 'shareToQzone() qqver greater than 4.6.0'
    //   1312: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1315: aload_1
    //   1316: aload #7
    //   1318: new com/tencent/connect/share/QzoneShare$1
    //   1321: dup
    //   1322: aload_0
    //   1323: aload_3
    //   1324: aload_2
    //   1325: aload_1
    //   1326: invokespecial <init> : (Lcom/tencent/connect/share/QzoneShare;Lcom/tencent/tauth/IUiListener;Landroid/os/Bundle;Landroid/app/Activity;)V
    //   1329: invokestatic a : (Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/open/utils/c;)V
    //   1332: ldc 'openSDK_LOG.QzoneShare'
    //   1334: ldc_w 'shareToQzone() --end'
    //   1337: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1340: goto -> 74
    //   1343: aload_1
    //   1344: ldc_w '4.2.0'
    //   1347: invokestatic c : (Landroid/content/Context;Ljava/lang/String;)I
    //   1350: iflt -> 1524
    //   1353: aload_1
    //   1354: ldc_w '4.6.0'
    //   1357: invokestatic c : (Landroid/content/Context;Ljava/lang/String;)I
    //   1360: ifge -> 1524
    //   1363: ldc 'openSDK_LOG.QzoneShare'
    //   1365: ldc_w 'shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare'
    //   1368: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1371: new com/tencent/connect/share/QQShare
    //   1374: dup
    //   1375: aload_1
    //   1376: aload_0
    //   1377: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1380: invokespecial <init> : (Landroid/content/Context;Lcom/tencent/connect/auth/QQToken;)V
    //   1383: astore #9
    //   1385: aload #7
    //   1387: ifnull -> 1496
    //   1390: aload #7
    //   1392: invokevirtual size : ()I
    //   1395: ifle -> 1496
    //   1398: aload #7
    //   1400: iconst_0
    //   1401: invokevirtual get : (I)Ljava/lang/Object;
    //   1404: checkcast java/lang/String
    //   1407: astore #4
    //   1409: iload #10
    //   1411: iconst_5
    //   1412: if_icmpne -> 1488
    //   1415: aload #4
    //   1417: invokestatic h : (Ljava/lang/String;)Z
    //   1420: ifne -> 1488
    //   1423: aload_3
    //   1424: new com/tencent/tauth/UiError
    //   1427: dup
    //   1428: bipush #-6
    //   1430: ldc_w '手Q版本过低，纯图分享不支持网路图片'
    //   1433: aconst_null
    //   1434: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   1437: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   1442: ldc 'openSDK_LOG.QzoneShare'
    //   1444: ldc_w 'shareToQzone()手Q版本过低，纯图分享不支持网路图片'
    //   1447: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1450: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1453: iconst_1
    //   1454: ldc_w 'SHARE_CHECK_SDK'
    //   1457: ldc_w '1000'
    //   1460: aload_0
    //   1461: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1464: invokevirtual getAppId : ()Ljava/lang/String;
    //   1467: iconst_4
    //   1468: invokestatic valueOf : (I)Ljava/lang/String;
    //   1471: invokestatic elapsedRealtime : ()J
    //   1474: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1477: iconst_0
    //   1478: iconst_1
    //   1479: ldc_w 'shareToQzone()手Q版本过低，纯图分享不支持网路图片'
    //   1482: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1485: goto -> 74
    //   1488: aload_2
    //   1489: ldc 'imageLocalUrl'
    //   1491: aload #4
    //   1493: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1496: aload_1
    //   1497: ldc_w '4.5.0'
    //   1500: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)Z
    //   1503: ifne -> 1513
    //   1506: aload_2
    //   1507: ldc 'cflag'
    //   1509: iconst_1
    //   1510: invokevirtual putInt : (Ljava/lang/String;I)V
    //   1513: aload #9
    //   1515: aload_1
    //   1516: aload_2
    //   1517: aload_3
    //   1518: invokevirtual shareToQQ : (Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/tauth/IUiListener;)V
    //   1521: goto -> 1332
    //   1524: ldc 'openSDK_LOG.QzoneShare'
    //   1526: ldc_w 'shareToQzone() qqver below 4.2.0, will show download dialog'
    //   1529: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1532: new com/tencent/open/TDialog
    //   1535: dup
    //   1536: aload_1
    //   1537: ldc ''
    //   1539: aload_0
    //   1540: ldc ''
    //   1542: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   1545: aconst_null
    //   1546: aload_0
    //   1547: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   1550: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Lcom/tencent/connect/auth/QQToken;)V
    //   1553: invokevirtual show : ()V
    //   1556: goto -> 1332
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\share\QzoneShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
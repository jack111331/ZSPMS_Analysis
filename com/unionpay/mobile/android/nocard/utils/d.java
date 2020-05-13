package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import com.unionpay.mobile.android.callback.UPAndroidCallback;
import com.unionpay.mobile.android.model.b;

public final class d {
  private static UPAndroidCallback a = null;
  
  public static void a(Context paramContext, b paramb) {
    // Byte code:
    //   0: ldc 'uppay'
    //   2: ldc 'exit() +++'
    //   4: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: ldc 'uppay'
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: ldc 'reqId='
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload_1
    //   20: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   23: getfield a : I
    //   26: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   29: invokevirtual toString : ()Ljava/lang/String;
    //   32: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: aload_0
    //   37: checkcast com/unionpay/mobile/android/plugin/BaseActivity
    //   40: astore_2
    //   41: aload_1
    //   42: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   45: getfield f : Ljava/lang/String;
    //   48: invokevirtual length : ()I
    //   51: ifle -> 156
    //   54: ldc 'uppay'
    //   56: new java/lang/StringBuilder
    //   59: dup
    //   60: ldc 'result='
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: aload_1
    //   66: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   69: getfield f : Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_1
    //   83: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   86: getfield a : I
    //   89: lookupswitch default -> 156, 0 -> 646, 1 -> 244, 2 -> 646, 3 -> 852, 4 -> 244, 5 -> 646, 1000 -> 244
    //   156: aload_1
    //   157: getfield V : Ljava/lang/String;
    //   160: ifnull -> 231
    //   163: aload_1
    //   164: getfield V : Ljava/lang/String;
    //   167: invokevirtual length : ()I
    //   170: ifle -> 231
    //   173: aload_1
    //   174: getfield W : Ljava/lang/String;
    //   177: ifnull -> 231
    //   180: aload_1
    //   181: getfield W : Ljava/lang/String;
    //   184: invokevirtual length : ()I
    //   187: ifle -> 231
    //   190: aload_1
    //   191: getfield U : Z
    //   194: istore_3
    //   195: aload_1
    //   196: getfield V : Ljava/lang/String;
    //   199: astore #4
    //   201: aload_1
    //   202: getfield W : Ljava/lang/String;
    //   205: astore_1
    //   206: iload_3
    //   207: ifeq -> 231
    //   210: new java/lang/Thread
    //   213: dup
    //   214: new com/unionpay/mobile/android/nocard/utils/e
    //   217: dup
    //   218: aload #4
    //   220: aload_1
    //   221: aload_0
    //   222: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   225: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   228: invokevirtual start : ()V
    //   231: aload_2
    //   232: invokevirtual finish : ()V
    //   235: ldc 'uppay'
    //   237: ldc 'exit() +++'
    //   239: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   242: pop
    //   243: return
    //   244: ldc 'uppay'
    //   246: ldc ' notifyBrowserResult() +++ '
    //   248: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   251: pop
    //   252: aconst_null
    //   253: astore #5
    //   255: aload_1
    //   256: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   259: getfield f : Ljava/lang/String;
    //   262: astore #4
    //   264: aload #4
    //   266: ldc 'fail'
    //   268: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   271: ifeq -> 452
    //   274: ldc '1'
    //   276: astore #4
    //   278: aload #5
    //   280: astore #6
    //   282: aload_1
    //   283: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   286: getfield a : I
    //   289: tableswitch default -> 320, 1 -> 533, 2 -> 324, 3 -> 324, 4 -> 476
    //   320: aload #5
    //   322: astore #6
    //   324: aload_1
    //   325: getfield r : Ljava/lang/String;
    //   328: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   331: ifne -> 156
    //   334: ldc 'exit'
    //   336: aload_1
    //   337: getfield r : Ljava/lang/String;
    //   340: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   343: ifne -> 156
    //   346: new java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial <init> : ()V
    //   353: aload_1
    //   354: getfield r : Ljava/lang/String;
    //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload #4
    //   362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual toString : ()Ljava/lang/String;
    //   368: astore #4
    //   370: ldc 'uppay'
    //   372: new java/lang/StringBuilder
    //   375: dup
    //   376: ldc 'result URL= '
    //   378: invokespecial <init> : (Ljava/lang/String;)V
    //   381: aload #4
    //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   392: pop
    //   393: sipush #1000
    //   396: aload_1
    //   397: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   400: getfield a : I
    //   403: if_icmpne -> 588
    //   406: aload #4
    //   408: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   411: astore #6
    //   413: new android/content/Intent
    //   416: astore #4
    //   418: aload #4
    //   420: ldc 'android.intent.action.VIEW'
    //   422: aload #6
    //   424: invokespecial <init> : (Ljava/lang/String;Landroid/net/Uri;)V
    //   427: aload #4
    //   429: ldc 'android.intent.category.BROWSABLE'
    //   431: invokevirtual addCategory : (Ljava/lang/String;)Landroid/content/Intent;
    //   434: pop
    //   435: aload_2
    //   436: aload #4
    //   438: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   441: ldc 'uppay'
    //   443: ldc ' notifyBrowserResult() --- '
    //   445: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   448: pop
    //   449: goto -> 156
    //   452: aload #4
    //   454: ldc 'cancel'
    //   456: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   459: ifeq -> 469
    //   462: ldc '-1'
    //   464: astore #4
    //   466: goto -> 278
    //   469: ldc '0'
    //   471: astore #4
    //   473: goto -> 278
    //   476: new android/content/Intent
    //   479: dup
    //   480: ldc 'com.UCMobile.PluginApp.ActivityState'
    //   482: invokespecial <init> : (Ljava/lang/String;)V
    //   485: astore #6
    //   487: aload #6
    //   489: ldc 'ActivityState'
    //   491: ldc 'inactive'
    //   493: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   496: pop
    //   497: aload #6
    //   499: ldc 'android.intent.category.DEFAULT'
    //   501: invokevirtual addCategory : (Ljava/lang/String;)Landroid/content/Intent;
    //   504: pop
    //   505: aload_2
    //   506: aload #6
    //   508: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   511: new android/content/Intent
    //   514: dup
    //   515: ldc 'com.unionpay.uppay.resultURL'
    //   517: invokespecial <init> : (Ljava/lang/String;)V
    //   520: astore #6
    //   522: ldc 'uppay'
    //   524: ldc ' uc browser '
    //   526: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   529: pop
    //   530: goto -> 324
    //   533: new android/content/Intent
    //   536: dup
    //   537: aload_1
    //   538: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   541: getfield b : Ljava/lang/String;
    //   544: invokespecial <init> : (Ljava/lang/String;)V
    //   547: astore #6
    //   549: ldc 'uppay'
    //   551: ldc ' other browser '
    //   553: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   556: pop
    //   557: ldc 'uppay'
    //   559: new java/lang/StringBuilder
    //   562: dup
    //   563: ldc ' result Action='
    //   565: invokespecial <init> : (Ljava/lang/String;)V
    //   568: aload_1
    //   569: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   572: getfield b : Ljava/lang/String;
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual toString : ()Ljava/lang/String;
    //   581: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   584: pop
    //   585: goto -> 324
    //   588: aload #6
    //   590: ldc 'ResultURL'
    //   592: aload #4
    //   594: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   597: pop
    //   598: new java/lang/StringBuilder
    //   601: astore #4
    //   603: aload #4
    //   605: invokespecial <init> : ()V
    //   608: ldc 'browser'
    //   610: aload #4
    //   612: aload #6
    //   614: invokevirtual toURI : ()Ljava/lang/String;
    //   617: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual toString : ()Ljava/lang/String;
    //   623: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   626: pop
    //   627: aload_2
    //   628: aload #6
    //   630: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   633: goto -> 441
    //   636: astore #4
    //   638: aload #4
    //   640: invokevirtual printStackTrace : ()V
    //   643: goto -> 441
    //   646: ldc 'uppay'
    //   648: ldc 'notifyAppResult() +++'
    //   650: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   653: pop
    //   654: new android/content/Intent
    //   657: dup
    //   658: invokespecial <init> : ()V
    //   661: astore #4
    //   663: aload #4
    //   665: ldc 'pay_result'
    //   667: aload_1
    //   668: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   671: getfield f : Ljava/lang/String;
    //   674: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   677: pop
    //   678: aload #4
    //   680: ldc 'result_data'
    //   682: aload_1
    //   683: getfield bj : Ljava/lang/String;
    //   686: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   689: pop
    //   690: aload_1
    //   691: getfield V : Ljava/lang/String;
    //   694: ifnull -> 755
    //   697: aload_1
    //   698: getfield V : Ljava/lang/String;
    //   701: invokevirtual length : ()I
    //   704: ifle -> 755
    //   707: aload_1
    //   708: getfield W : Ljava/lang/String;
    //   711: ifnull -> 755
    //   714: aload_1
    //   715: getfield W : Ljava/lang/String;
    //   718: invokevirtual length : ()I
    //   721: ifle -> 755
    //   724: aload_1
    //   725: getfield U : Z
    //   728: ifne -> 755
    //   731: aload #4
    //   733: ldc 'notify_url'
    //   735: aload_1
    //   736: getfield V : Ljava/lang/String;
    //   739: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   742: pop
    //   743: aload #4
    //   745: ldc 'notify_msg'
    //   747: aload_1
    //   748: getfield W : Ljava/lang/String;
    //   751: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   754: pop
    //   755: aload_1
    //   756: getfield n : Ljava/lang/String;
    //   759: ifnull -> 798
    //   762: aload #4
    //   764: ldc 'qn'
    //   766: aload_1
    //   767: getfield n : Ljava/lang/String;
    //   770: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   773: pop
    //   774: aload #4
    //   776: ldc 'sid'
    //   778: aload_1
    //   779: getfield k : Ljava/lang/String;
    //   782: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: aload #4
    //   788: ldc 'secret'
    //   790: aload_1
    //   791: getfield l : Ljava/lang/String;
    //   794: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   797: pop
    //   798: getstatic com/unionpay/mobile/android/nocard/utils/d.a : Lcom/unionpay/mobile/android/callback/UPAndroidCallback;
    //   801: ifnull -> 831
    //   804: getstatic com/unionpay/mobile/android/nocard/utils/d.a : Lcom/unionpay/mobile/android/callback/UPAndroidCallback;
    //   807: aload_1
    //   808: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   811: getfield f : Ljava/lang/String;
    //   814: aload_1
    //   815: getfield n : Ljava/lang/String;
    //   818: aload_1
    //   819: getfield k : Ljava/lang/String;
    //   822: aload_1
    //   823: getfield l : Ljava/lang/String;
    //   826: invokeinterface UPAndroidOK : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload_2
    //   832: checkcast com/unionpay/mobile/android/plugin/BaseActivity
    //   835: iconst_m1
    //   836: aload #4
    //   838: invokevirtual setResult : (ILandroid/content/Intent;)V
    //   841: ldc 'uppay'
    //   843: ldc 'notifyAppResult() ---'
    //   845: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   848: pop
    //   849: goto -> 156
    //   852: ldc 'uppay'
    //   854: ldc 'notifyTencentJarResult() +++'
    //   856: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   859: pop
    //   860: new android/content/Intent
    //   863: dup
    //   864: invokespecial <init> : ()V
    //   867: astore #4
    //   869: aload #4
    //   871: ldc 'pay_result'
    //   873: aload_1
    //   874: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   877: getfield f : Ljava/lang/String;
    //   880: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   883: pop
    //   884: aload #4
    //   886: ldc 'tencentWID'
    //   888: aload_1
    //   889: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   892: getfield h : Ljava/lang/String;
    //   895: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   898: pop
    //   899: aload #4
    //   901: ldc 'tencentUID'
    //   903: aload_1
    //   904: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   907: getfield g : Ljava/lang/String;
    //   910: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload #4
    //   916: ldc 'bankInfo'
    //   918: aload_1
    //   919: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   922: getfield j : Ljava/lang/String;
    //   925: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   928: pop
    //   929: aload #4
    //   931: ldc 'cardType'
    //   933: aload_1
    //   934: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   937: getfield k : Ljava/lang/String;
    //   940: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   943: pop
    //   944: aload #4
    //   946: ldc 'cardNo'
    //   948: aload_1
    //   949: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   952: getfield i : Ljava/lang/String;
    //   955: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   958: pop
    //   959: aload_2
    //   960: iconst_m1
    //   961: aload #4
    //   963: invokevirtual setResult : (ILandroid/content/Intent;)V
    //   966: ldc 'uppay'
    //   968: ldc_w 'notifyTencentJarResult() ---'
    //   971: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   974: pop
    //   975: goto -> 156
    // Exception table:
    //   from	to	target	type
    //   393	441	636	java/lang/Exception
    //   588	633	636	java/lang/Exception
  }
  
  public static void a(UPAndroidCallback paramUPAndroidCallback) {
    a = paramUPAndroidCallback;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocar\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
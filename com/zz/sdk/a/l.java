package com.zz.sdk.a;

import android.view.View;
import android.widget.AdapterView;

class l implements AdapterView.OnItemClickListener {
  l(k paramk) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/zz/sdk/a/k;
    //   4: invokestatic a : (Lcom/zz/sdk/a/k;)Ljava/util/List;
    //   7: iload_3
    //   8: invokeinterface get : (I)Ljava/lang/Object;
    //   13: checkcast com/zz/sdk/b/e
    //   16: astore_1
    //   17: getstatic com/zz/sdk/a/o.a : [I
    //   20: aload_1
    //   21: getfield c : Lcom/zz/sdk/b/a;
    //   24: invokevirtual ordinal : ()I
    //   27: iaload
    //   28: tableswitch default -> 64, 1 -> 65, 2 -> 117, 3 -> 413, 4 -> 642, 5 -> 669
    //   64: return
    //   65: aload_1
    //   66: getfield d : I
    //   69: iconst_2
    //   70: if_icmpne -> 95
    //   73: aload_0
    //   74: getfield a : Lcom/zz/sdk/a/k;
    //   77: getfield b : Landroid/app/Activity;
    //   80: ldc com/zz/sdk/a/ay
    //   82: aload_0
    //   83: getfield a : Lcom/zz/sdk/a/k;
    //   86: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   89: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   92: goto -> 64
    //   95: aload_0
    //   96: getfield a : Lcom/zz/sdk/a/k;
    //   99: getfield b : Landroid/app/Activity;
    //   102: ldc com/zz/sdk/a/kh
    //   104: aload_0
    //   105: getfield a : Lcom/zz/sdk/a/k;
    //   108: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   111: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   114: goto -> 64
    //   117: aload_1
    //   118: getfield d : I
    //   121: iconst_2
    //   122: if_icmpne -> 248
    //   125: aload_0
    //   126: getfield a : Lcom/zz/sdk/a/k;
    //   129: getfield b : Landroid/app/Activity;
    //   132: new java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: ldc 'bind_email'
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield a : Lcom/zz/sdk/a/k;
    //   148: getfield b : Landroid/app/Activity;
    //   151: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/i/cq;
    //   154: getfield a : Lcom/zz/sdk/b/v;
    //   157: getfield o : Ljava/lang/String;
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual toString : ()Ljava/lang/String;
    //   166: ldc ''
    //   168: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   171: pop
    //   172: aload_0
    //   173: getfield a : Lcom/zz/sdk/a/k;
    //   176: getfield b : Landroid/app/Activity;
    //   179: ldc com/zz/sdk/a/cn
    //   181: aload_0
    //   182: getfield a : Lcom/zz/sdk/a/k;
    //   185: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   188: ldc 'key_show_close'
    //   190: iconst_0
    //   191: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   194: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   197: ldc 'key_show_back'
    //   199: iconst_1
    //   200: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   203: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   206: ldc 'key_overlay'
    //   208: iconst_0
    //   209: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   212: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   215: ldc 'bind_state'
    //   217: iconst_1
    //   218: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   221: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   224: ldc 'email'
    //   226: aload_0
    //   227: getfield a : Lcom/zz/sdk/a/k;
    //   230: getfield b : Landroid/app/Activity;
    //   233: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/i/cq;
    //   236: invokevirtual b : ()Ljava/lang/String;
    //   239: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   242: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   245: goto -> 64
    //   248: aload_0
    //   249: getfield a : Lcom/zz/sdk/a/k;
    //   252: getfield b : Landroid/app/Activity;
    //   255: new java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial <init> : ()V
    //   262: ldc 'bind_email'
    //   264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield a : Lcom/zz/sdk/a/k;
    //   271: getfield b : Landroid/app/Activity;
    //   274: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/i/cq;
    //   277: getfield a : Lcom/zz/sdk/b/v;
    //   280: getfield o : Ljava/lang/String;
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual toString : ()Ljava/lang/String;
    //   289: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   292: astore_1
    //   293: aload_1
    //   294: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   297: ifeq -> 349
    //   300: aload_0
    //   301: getfield a : Lcom/zz/sdk/a/k;
    //   304: getfield b : Landroid/app/Activity;
    //   307: ldc com/zz/sdk/a/by
    //   309: aload_0
    //   310: getfield a : Lcom/zz/sdk/a/k;
    //   313: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   316: ldc 'key_show_close'
    //   318: iconst_0
    //   319: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   322: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   325: ldc 'key_show_back'
    //   327: iconst_1
    //   328: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   331: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   334: ldc 'key_overlay'
    //   336: iconst_0
    //   337: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   340: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   343: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   346: goto -> 64
    //   349: aload_0
    //   350: getfield a : Lcom/zz/sdk/a/k;
    //   353: getfield b : Landroid/app/Activity;
    //   356: ldc com/zz/sdk/a/cn
    //   358: aload_0
    //   359: getfield a : Lcom/zz/sdk/a/k;
    //   362: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   365: ldc 'key_show_close'
    //   367: iconst_0
    //   368: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   371: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   374: ldc 'key_show_back'
    //   376: iconst_1
    //   377: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   380: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   383: ldc 'key_overlay'
    //   385: iconst_0
    //   386: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   389: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   392: ldc 'bind_state'
    //   394: iconst_0
    //   395: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   398: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   401: ldc 'email'
    //   403: aload_1
    //   404: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   407: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   410: goto -> 64
    //   413: aload_1
    //   414: getfield d : I
    //   417: iconst_2
    //   418: if_icmpne -> 479
    //   421: aload_0
    //   422: getfield a : Lcom/zz/sdk/a/k;
    //   425: getfield b : Landroid/app/Activity;
    //   428: ldc com/zz/sdk/a/kb
    //   430: aload_0
    //   431: getfield a : Lcom/zz/sdk/a/k;
    //   434: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   437: ldc 'realname'
    //   439: aload_0
    //   440: getfield a : Lcom/zz/sdk/a/k;
    //   443: invokestatic d : (Lcom/zz/sdk/a/k;)Ljava/lang/String;
    //   446: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   449: ldc 'idCard'
    //   451: aload_0
    //   452: getfield a : Lcom/zz/sdk/a/k;
    //   455: invokestatic c : (Lcom/zz/sdk/a/k;)Ljava/lang/String;
    //   458: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   461: ldc 'phone'
    //   463: aload_0
    //   464: getfield a : Lcom/zz/sdk/a/k;
    //   467: invokestatic b : (Lcom/zz/sdk/a/k;)Ljava/lang/String;
    //   470: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   473: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   476: goto -> 64
    //   479: aload_0
    //   480: getfield a : Lcom/zz/sdk/a/k;
    //   483: getfield b : Landroid/app/Activity;
    //   486: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/i/cq;
    //   489: invokevirtual a : ()Ljava/lang/String;
    //   492: astore_1
    //   493: aload_1
    //   494: ifnull -> 787
    //   497: aload_1
    //   498: invokevirtual length : ()I
    //   501: ifle -> 787
    //   504: iconst_1
    //   505: istore_3
    //   506: invokestatic h : ()Lcom/zz/sdk/b/a/r;
    //   509: ifnonnull -> 577
    //   512: iconst_0
    //   513: istore #6
    //   515: iload #6
    //   517: ifne -> 591
    //   520: iconst_0
    //   521: istore #6
    //   523: iload_3
    //   524: ifne -> 532
    //   527: iload #6
    //   529: ifne -> 597
    //   532: aload_0
    //   533: getfield a : Lcom/zz/sdk/a/k;
    //   536: getfield b : Landroid/app/Activity;
    //   539: ldc com/zz/sdk/a/ha
    //   541: invokestatic a : ()Lcom/zz/sdk/a/bx;
    //   544: ldc 'key_show_close'
    //   546: iconst_1
    //   547: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   550: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   553: ldc 'key_show_back'
    //   555: iconst_0
    //   556: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   559: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   562: ldc 'isUserPlatform'
    //   564: iconst_1
    //   565: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   568: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   571: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   574: goto -> 64
    //   577: invokestatic h : ()Lcom/zz/sdk/b/a/r;
    //   580: invokevirtual j : ()Lcom/zz/sdk/b/a/aw;
    //   583: invokevirtual c : ()I
    //   586: istore #6
    //   588: goto -> 515
    //   591: iconst_1
    //   592: istore #6
    //   594: goto -> 523
    //   597: aload_0
    //   598: getfield a : Lcom/zz/sdk/a/k;
    //   601: getfield b : Landroid/app/Activity;
    //   604: ldc com/zz/sdk/a/db
    //   606: invokestatic a : ()Lcom/zz/sdk/a/bx;
    //   609: ldc 'key_show_close'
    //   611: iconst_1
    //   612: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   615: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   618: ldc 'key_show_back'
    //   620: iconst_0
    //   621: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   624: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   627: ldc 'isUserPlatform'
    //   629: iconst_1
    //   630: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   633: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   636: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   639: goto -> 64
    //   642: ldc 'ChangePhone ChangePhoneOldDialog'
    //   644: invokestatic a : (Ljava/lang/Object;)V
    //   647: aload_0
    //   648: getfield a : Lcom/zz/sdk/a/k;
    //   651: getfield b : Landroid/app/Activity;
    //   654: ldc com/zz/sdk/a/an
    //   656: aload_0
    //   657: getfield a : Lcom/zz/sdk/a/k;
    //   660: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   663: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   666: goto -> 64
    //   669: aload_0
    //   670: getfield a : Lcom/zz/sdk/a/k;
    //   673: getfield b : Landroid/app/Activity;
    //   676: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/i/cq;
    //   679: invokevirtual a : ()Ljava/lang/String;
    //   682: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   685: ifeq -> 765
    //   688: aload_0
    //   689: getfield a : Lcom/zz/sdk/a/k;
    //   692: getfield b : Landroid/app/Activity;
    //   695: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/a/bs;
    //   698: aload_0
    //   699: getfield a : Lcom/zz/sdk/a/k;
    //   702: invokestatic e : (Lcom/zz/sdk/a/k;)Lcom/zz/sdk/i/cq;
    //   705: invokevirtual j : ()Ljava/lang/String;
    //   708: putfield e : Ljava/lang/String;
    //   711: aload_0
    //   712: getfield a : Lcom/zz/sdk/a/k;
    //   715: getfield b : Landroid/app/Activity;
    //   718: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/a/bs;
    //   721: aload_0
    //   722: getfield a : Lcom/zz/sdk/a/k;
    //   725: invokestatic e : (Lcom/zz/sdk/a/k;)Lcom/zz/sdk/i/cq;
    //   728: invokevirtual r : ()Ljava/lang/String;
    //   731: putfield f : Ljava/lang/String;
    //   734: aload_0
    //   735: getfield a : Lcom/zz/sdk/a/k;
    //   738: getfield b : Landroid/app/Activity;
    //   741: ldc com/zz/sdk/a/gn
    //   743: aload_0
    //   744: getfield a : Lcom/zz/sdk/a/k;
    //   747: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   750: ldc 'isUserPlatform'
    //   752: iconst_1
    //   753: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   756: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   759: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   762: goto -> 64
    //   765: aload_0
    //   766: getfield a : Lcom/zz/sdk/a/k;
    //   769: getfield b : Landroid/app/Activity;
    //   772: ldc com/zz/sdk/a/ay
    //   774: aload_0
    //   775: getfield a : Lcom/zz/sdk/a/k;
    //   778: invokevirtual z : ()Lcom/zz/sdk/a/bx;
    //   781: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   784: goto -> 64
    //   787: iconst_0
    //   788: istore_3
    //   789: goto -> 506
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
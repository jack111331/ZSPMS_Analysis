package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.f;
import java.io.File;
import java.util.Map;

public class c {
  private SharedPreferences.Editor a;
  
  private SharedPreferences a;
  
  private b.a a;
  
  private b a;
  
  private d a;
  
  private String a;
  
  private String b;
  
  private boolean c;
  
  private boolean d;
  
  private boolean e;
  
  private boolean f;
  
  private Context mContext;
  
  public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: ldc ''
    //   7: putfield a : Ljava/lang/String;
    //   10: aload_0
    //   11: ldc ''
    //   13: putfield b : Ljava/lang/String;
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield c : Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield d : Z
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield e : Z
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield a : Landroid/content/SharedPreferences;
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield a : Lcom/ta/utdid2/b/a/b;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield a : Landroid/content/SharedPreferences$Editor;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield a : Lcom/ta/utdid2/b/a/b$a;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield mContext : Landroid/content/Context;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield a : Lcom/ta/utdid2/b/a/d;
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield f : Z
    //   66: aload_0
    //   67: iload #4
    //   69: putfield c : Z
    //   72: aload_0
    //   73: iload #5
    //   75: putfield f : Z
    //   78: aload_0
    //   79: aload_3
    //   80: putfield a : Ljava/lang/String;
    //   83: aload_0
    //   84: aload_2
    //   85: putfield b : Ljava/lang/String;
    //   88: aload_0
    //   89: aload_1
    //   90: putfield mContext : Landroid/content/Context;
    //   93: lconst_0
    //   94: lstore #6
    //   96: aload_1
    //   97: ifnull -> 124
    //   100: aload_0
    //   101: aload_1
    //   102: aload_3
    //   103: iconst_0
    //   104: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   107: putfield a : Landroid/content/SharedPreferences;
    //   110: aload_0
    //   111: getfield a : Landroid/content/SharedPreferences;
    //   114: ldc 't'
    //   116: lconst_0
    //   117: invokeinterface getLong : (Ljava/lang/String;J)J
    //   122: lstore #6
    //   124: aconst_null
    //   125: astore #8
    //   127: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   130: astore #9
    //   132: aload #9
    //   134: astore #8
    //   136: aload #8
    //   138: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   141: ifne -> 441
    //   144: aload #8
    //   146: ldc 'mounted'
    //   148: invokevirtual equals : (Ljava/lang/Object;)Z
    //   151: ifeq -> 418
    //   154: aload_0
    //   155: iconst_1
    //   156: putfield e : Z
    //   159: aload_0
    //   160: iconst_1
    //   161: putfield d : Z
    //   164: aload_0
    //   165: getfield d : Z
    //   168: ifne -> 178
    //   171: aload_0
    //   172: getfield e : Z
    //   175: ifeq -> 861
    //   178: aload_1
    //   179: ifnull -> 861
    //   182: aload_2
    //   183: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   186: ifne -> 861
    //   189: aload_0
    //   190: aload_0
    //   191: aload_2
    //   192: invokespecial a : (Ljava/lang/String;)Lcom/ta/utdid2/b/a/d;
    //   195: putfield a : Lcom/ta/utdid2/b/a/d;
    //   198: aload_0
    //   199: getfield a : Lcom/ta/utdid2/b/a/d;
    //   202: ifnull -> 861
    //   205: aload_0
    //   206: aload_0
    //   207: getfield a : Lcom/ta/utdid2/b/a/d;
    //   210: aload_3
    //   211: iconst_0
    //   212: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   215: putfield a : Lcom/ta/utdid2/b/a/b;
    //   218: aload_0
    //   219: getfield a : Lcom/ta/utdid2/b/a/b;
    //   222: ldc 't'
    //   224: lconst_0
    //   225: invokeinterface getLong : (Ljava/lang/String;J)J
    //   230: lstore #10
    //   232: iload #5
    //   234: ifne -> 547
    //   237: lload #6
    //   239: lload #10
    //   241: lcmp
    //   242: ifle -> 454
    //   245: aload_0
    //   246: aload_0
    //   247: getfield a : Landroid/content/SharedPreferences;
    //   250: aload_0
    //   251: getfield a : Lcom/ta/utdid2/b/a/b;
    //   254: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   257: aload_0
    //   258: aload_0
    //   259: getfield a : Lcom/ta/utdid2/b/a/d;
    //   262: aload_3
    //   263: iconst_0
    //   264: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   267: putfield a : Lcom/ta/utdid2/b/a/b;
    //   270: lload #10
    //   272: lstore #12
    //   274: lload #6
    //   276: lstore #10
    //   278: lload #12
    //   280: lstore #6
    //   282: lload #10
    //   284: lload #6
    //   286: lcmp
    //   287: ifne -> 304
    //   290: lload #10
    //   292: lconst_0
    //   293: lcmp
    //   294: ifne -> 407
    //   297: lload #6
    //   299: lconst_0
    //   300: lcmp
    //   301: ifne -> 407
    //   304: invokestatic currentTimeMillis : ()J
    //   307: lstore #12
    //   309: aload_0
    //   310: getfield f : Z
    //   313: ifeq -> 337
    //   316: aload_0
    //   317: getfield f : Z
    //   320: ifeq -> 407
    //   323: lload #10
    //   325: lconst_0
    //   326: lcmp
    //   327: ifne -> 407
    //   330: lload #6
    //   332: lconst_0
    //   333: lcmp
    //   334: ifne -> 407
    //   337: aload_0
    //   338: getfield a : Landroid/content/SharedPreferences;
    //   341: ifnull -> 372
    //   344: aload_0
    //   345: getfield a : Landroid/content/SharedPreferences;
    //   348: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   353: astore_1
    //   354: aload_1
    //   355: ldc 't2'
    //   357: lload #12
    //   359: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   364: pop
    //   365: aload_1
    //   366: invokeinterface commit : ()Z
    //   371: pop
    //   372: aload_0
    //   373: getfield a : Lcom/ta/utdid2/b/a/b;
    //   376: ifnull -> 407
    //   379: aload_0
    //   380: getfield a : Lcom/ta/utdid2/b/a/b;
    //   383: invokeinterface a : ()Lcom/ta/utdid2/b/a/b$a;
    //   388: astore_1
    //   389: aload_1
    //   390: ldc 't2'
    //   392: lload #12
    //   394: invokeinterface a : (Ljava/lang/String;J)Lcom/ta/utdid2/b/a/b$a;
    //   399: pop
    //   400: aload_1
    //   401: invokeinterface commit : ()Z
    //   406: pop
    //   407: return
    //   408: astore #9
    //   410: aload #9
    //   412: invokevirtual printStackTrace : ()V
    //   415: goto -> 136
    //   418: aload #8
    //   420: ldc 'mounted_ro'
    //   422: invokevirtual equals : (Ljava/lang/Object;)Z
    //   425: ifeq -> 441
    //   428: aload_0
    //   429: iconst_1
    //   430: putfield d : Z
    //   433: aload_0
    //   434: iconst_0
    //   435: putfield e : Z
    //   438: goto -> 164
    //   441: aload_0
    //   442: iconst_0
    //   443: putfield e : Z
    //   446: aload_0
    //   447: iconst_0
    //   448: putfield d : Z
    //   451: goto -> 164
    //   454: lload #6
    //   456: lload #10
    //   458: lcmp
    //   459: ifge -> 499
    //   462: aload_0
    //   463: aload_0
    //   464: getfield a : Lcom/ta/utdid2/b/a/b;
    //   467: aload_0
    //   468: getfield a : Landroid/content/SharedPreferences;
    //   471: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   474: aload_0
    //   475: aload_1
    //   476: aload_3
    //   477: iconst_0
    //   478: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   481: putfield a : Landroid/content/SharedPreferences;
    //   484: lload #6
    //   486: lstore #12
    //   488: lload #10
    //   490: lstore #6
    //   492: lload #12
    //   494: lstore #10
    //   496: goto -> 282
    //   499: lload #6
    //   501: lload #10
    //   503: lcmp
    //   504: ifne -> 846
    //   507: aload_0
    //   508: aload_0
    //   509: getfield a : Landroid/content/SharedPreferences;
    //   512: aload_0
    //   513: getfield a : Lcom/ta/utdid2/b/a/b;
    //   516: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   519: aload_0
    //   520: aload_0
    //   521: getfield a : Lcom/ta/utdid2/b/a/d;
    //   524: aload_3
    //   525: iconst_0
    //   526: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   529: putfield a : Lcom/ta/utdid2/b/a/b;
    //   532: lload #6
    //   534: lstore #12
    //   536: lload #10
    //   538: lstore #6
    //   540: lload #12
    //   542: lstore #10
    //   544: goto -> 282
    //   547: aload_0
    //   548: getfield a : Landroid/content/SharedPreferences;
    //   551: ldc 't2'
    //   553: lconst_0
    //   554: invokeinterface getLong : (Ljava/lang/String;J)J
    //   559: lstore #12
    //   561: aload_0
    //   562: getfield a : Lcom/ta/utdid2/b/a/b;
    //   565: ldc 't2'
    //   567: lconst_0
    //   568: invokeinterface getLong : (Ljava/lang/String;J)J
    //   573: lstore #6
    //   575: lload #12
    //   577: lload #6
    //   579: lcmp
    //   580: ifge -> 630
    //   583: lload #12
    //   585: lconst_0
    //   586: lcmp
    //   587: ifle -> 630
    //   590: aload_0
    //   591: aload_0
    //   592: getfield a : Landroid/content/SharedPreferences;
    //   595: aload_0
    //   596: getfield a : Lcom/ta/utdid2/b/a/b;
    //   599: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   602: aload_0
    //   603: aload_0
    //   604: getfield a : Lcom/ta/utdid2/b/a/d;
    //   607: aload_3
    //   608: iconst_0
    //   609: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   612: putfield a : Lcom/ta/utdid2/b/a/b;
    //   615: lload #12
    //   617: lstore #10
    //   619: goto -> 282
    //   622: astore_1
    //   623: lload #12
    //   625: lstore #10
    //   627: goto -> 282
    //   630: lload #12
    //   632: lload #6
    //   634: lcmp
    //   635: ifle -> 674
    //   638: lload #6
    //   640: lconst_0
    //   641: lcmp
    //   642: ifle -> 674
    //   645: aload_0
    //   646: aload_0
    //   647: getfield a : Lcom/ta/utdid2/b/a/b;
    //   650: aload_0
    //   651: getfield a : Landroid/content/SharedPreferences;
    //   654: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   657: aload_0
    //   658: aload_1
    //   659: aload_3
    //   660: iconst_0
    //   661: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   664: putfield a : Landroid/content/SharedPreferences;
    //   667: lload #12
    //   669: lstore #10
    //   671: goto -> 282
    //   674: lload #12
    //   676: lconst_0
    //   677: lcmp
    //   678: ifne -> 717
    //   681: lload #6
    //   683: lconst_0
    //   684: lcmp
    //   685: ifle -> 717
    //   688: aload_0
    //   689: aload_0
    //   690: getfield a : Lcom/ta/utdid2/b/a/b;
    //   693: aload_0
    //   694: getfield a : Landroid/content/SharedPreferences;
    //   697: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   700: aload_0
    //   701: aload_1
    //   702: aload_3
    //   703: iconst_0
    //   704: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   707: putfield a : Landroid/content/SharedPreferences;
    //   710: lload #12
    //   712: lstore #10
    //   714: goto -> 282
    //   717: lload #6
    //   719: lconst_0
    //   720: lcmp
    //   721: ifne -> 763
    //   724: lload #12
    //   726: lconst_0
    //   727: lcmp
    //   728: ifle -> 763
    //   731: aload_0
    //   732: aload_0
    //   733: getfield a : Landroid/content/SharedPreferences;
    //   736: aload_0
    //   737: getfield a : Lcom/ta/utdid2/b/a/b;
    //   740: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   743: aload_0
    //   744: aload_0
    //   745: getfield a : Lcom/ta/utdid2/b/a/d;
    //   748: aload_3
    //   749: iconst_0
    //   750: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   753: putfield a : Lcom/ta/utdid2/b/a/b;
    //   756: lload #12
    //   758: lstore #10
    //   760: goto -> 282
    //   763: lload #12
    //   765: lload #6
    //   767: lcmp
    //   768: ifne -> 796
    //   771: aload_0
    //   772: aload_0
    //   773: getfield a : Landroid/content/SharedPreferences;
    //   776: aload_0
    //   777: getfield a : Lcom/ta/utdid2/b/a/b;
    //   780: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   783: aload_0
    //   784: aload_0
    //   785: getfield a : Lcom/ta/utdid2/b/a/d;
    //   788: aload_3
    //   789: iconst_0
    //   790: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   793: putfield a : Lcom/ta/utdid2/b/a/b;
    //   796: lload #12
    //   798: lstore #10
    //   800: goto -> 282
    //   803: astore_1
    //   804: goto -> 407
    //   807: astore_1
    //   808: lload #6
    //   810: lstore #10
    //   812: lconst_0
    //   813: lstore #6
    //   815: goto -> 282
    //   818: astore_1
    //   819: lload #6
    //   821: lstore #12
    //   823: lload #10
    //   825: lstore #6
    //   827: lload #12
    //   829: lstore #10
    //   831: goto -> 282
    //   834: astore_1
    //   835: lload #10
    //   837: lstore #6
    //   839: lload #12
    //   841: lstore #10
    //   843: goto -> 282
    //   846: lload #6
    //   848: lstore #12
    //   850: lload #10
    //   852: lstore #6
    //   854: lload #12
    //   856: lstore #10
    //   858: goto -> 800
    //   861: lload #6
    //   863: lstore #10
    //   865: lconst_0
    //   866: lstore #6
    //   868: goto -> 282
    // Exception table:
    //   from	to	target	type
    //   127	132	408	java/lang/Exception
    //   205	232	807	java/lang/Exception
    //   245	270	818	java/lang/Exception
    //   372	407	803	java/lang/Exception
    //   462	484	818	java/lang/Exception
    //   507	532	818	java/lang/Exception
    //   547	561	818	java/lang/Exception
    //   561	575	834	java/lang/Exception
    //   590	615	622	java/lang/Exception
    //   645	667	622	java/lang/Exception
    //   688	710	622	java/lang/Exception
    //   731	756	622	java/lang/Exception
    //   771	796	622	java/lang/Exception
  }
  
  private d a(String paramString) {
    null = a(paramString);
    if (null != null) {
      this.a = (String)new d(null.getAbsolutePath());
      return (d)this.a;
    } 
    return null;
  }
  
  private File a(String paramString) {
    File file = Environment.getExternalStorageDirectory();
    if (file != null) {
      file = new File(String.format("%s%s%s", new Object[] { file.getAbsolutePath(), File.separator, paramString }));
      File file1 = file;
      if (!file.exists()) {
        file.mkdirs();
        file1 = file;
      } 
      return file1;
    } 
    return null;
  }
  
  private void a(SharedPreferences paramSharedPreferences, b paramb) {
    if (paramSharedPreferences != null && paramb != null) {
      b.a a1 = paramb.a();
      if (a1 != null) {
        a1.b();
        for (Map.Entry entry : paramSharedPreferences.getAll().entrySet()) {
          String str = (String)entry.getKey();
          entry = (Map.Entry)entry.getValue();
          if (entry instanceof String) {
            a1.a(str, (String)entry);
            continue;
          } 
          if (entry instanceof Integer) {
            a1.a(str, ((Integer)entry).intValue());
            continue;
          } 
          if (entry instanceof Long) {
            a1.a(str, ((Long)entry).longValue());
            continue;
          } 
          if (entry instanceof Float) {
            a1.a(str, ((Float)entry).floatValue());
            continue;
          } 
          if (entry instanceof Boolean)
            a1.a(str, ((Boolean)entry).booleanValue()); 
        } 
        a1.commit();
      } 
    } 
  }
  
  private void a(b paramb, SharedPreferences paramSharedPreferences) {
    if (paramb != null && paramSharedPreferences != null) {
      SharedPreferences.Editor editor = paramSharedPreferences.edit();
      if (editor != null) {
        editor.clear();
        for (Map.Entry<String, ?> entry : paramb.getAll().entrySet()) {
          String str = (String)entry.getKey();
          entry = (Map.Entry<String, ?>)entry.getValue();
          if (entry instanceof String) {
            editor.putString(str, (String)entry);
            continue;
          } 
          if (entry instanceof Integer) {
            editor.putInt(str, ((Integer)entry).intValue());
            continue;
          } 
          if (entry instanceof Long) {
            editor.putLong(str, ((Long)entry).longValue());
            continue;
          } 
          if (entry instanceof Float) {
            editor.putFloat(str, ((Float)entry).floatValue());
            continue;
          } 
          if (entry instanceof Boolean)
            editor.putBoolean(str, ((Boolean)entry).booleanValue()); 
        } 
        editor.commit();
      } 
    } 
  }
  
  private void b() {
    if (this.a == null && this.a != null)
      this.a = (String)this.a.edit(); 
    if (this.e && this.a == null && this.a != null)
      this.a = (String)this.a.a(); 
    b();
  }
  
  private boolean b() {
    if (this.a != null) {
      boolean bool1 = this.a.a();
      boolean bool2 = bool1;
      if (!bool1) {
        commit();
        bool2 = bool1;
      } 
      return bool2;
    } 
    return false;
  }
  
  public boolean commit() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: invokestatic currentTimeMillis : ()J
    //   5: lstore_2
    //   6: iload_1
    //   7: istore #4
    //   9: aload_0
    //   10: getfield a : Landroid/content/SharedPreferences$Editor;
    //   13: ifnull -> 61
    //   16: aload_0
    //   17: getfield f : Z
    //   20: ifne -> 43
    //   23: aload_0
    //   24: getfield a : Landroid/content/SharedPreferences;
    //   27: ifnull -> 43
    //   30: aload_0
    //   31: getfield a : Landroid/content/SharedPreferences$Editor;
    //   34: ldc 't'
    //   36: lload_2
    //   37: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   42: pop
    //   43: iload_1
    //   44: istore #4
    //   46: aload_0
    //   47: getfield a : Landroid/content/SharedPreferences$Editor;
    //   50: invokeinterface commit : ()Z
    //   55: ifne -> 61
    //   58: iconst_0
    //   59: istore #4
    //   61: aload_0
    //   62: getfield a : Landroid/content/SharedPreferences;
    //   65: ifnull -> 91
    //   68: aload_0
    //   69: getfield mContext : Landroid/content/Context;
    //   72: ifnull -> 91
    //   75: aload_0
    //   76: aload_0
    //   77: getfield mContext : Landroid/content/Context;
    //   80: aload_0
    //   81: getfield a : Ljava/lang/String;
    //   84: iconst_0
    //   85: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   88: putfield a : Landroid/content/SharedPreferences;
    //   91: aconst_null
    //   92: astore #5
    //   94: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   97: astore #6
    //   99: aload #6
    //   101: astore #5
    //   103: iload #4
    //   105: istore #7
    //   107: aload #5
    //   109: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   112: ifne -> 264
    //   115: iload #4
    //   117: istore_1
    //   118: aload #5
    //   120: ldc 'mounted'
    //   122: invokevirtual equals : (Ljava/lang/Object;)Z
    //   125: ifeq -> 202
    //   128: aload_0
    //   129: getfield a : Lcom/ta/utdid2/b/a/b;
    //   132: ifnonnull -> 292
    //   135: aload_0
    //   136: aload_0
    //   137: getfield b : Ljava/lang/String;
    //   140: invokespecial a : (Ljava/lang/String;)Lcom/ta/utdid2/b/a/d;
    //   143: astore #6
    //   145: iload #4
    //   147: istore_1
    //   148: aload #6
    //   150: ifnull -> 202
    //   153: aload_0
    //   154: aload #6
    //   156: aload_0
    //   157: getfield a : Ljava/lang/String;
    //   160: iconst_0
    //   161: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   164: putfield a : Lcom/ta/utdid2/b/a/b;
    //   167: aload_0
    //   168: getfield f : Z
    //   171: ifne -> 277
    //   174: aload_0
    //   175: aload_0
    //   176: getfield a : Landroid/content/SharedPreferences;
    //   179: aload_0
    //   180: getfield a : Lcom/ta/utdid2/b/a/b;
    //   183: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   186: aload_0
    //   187: aload_0
    //   188: getfield a : Lcom/ta/utdid2/b/a/b;
    //   191: invokeinterface a : ()Lcom/ta/utdid2/b/a/b$a;
    //   196: putfield a : Lcom/ta/utdid2/b/a/b$a;
    //   199: iload #4
    //   201: istore_1
    //   202: aload #5
    //   204: ldc 'mounted'
    //   206: invokevirtual equals : (Ljava/lang/Object;)Z
    //   209: ifne -> 235
    //   212: iload_1
    //   213: istore #7
    //   215: aload #5
    //   217: ldc 'mounted_ro'
    //   219: invokevirtual equals : (Ljava/lang/Object;)Z
    //   222: ifeq -> 264
    //   225: iload_1
    //   226: istore #7
    //   228: aload_0
    //   229: getfield a : Lcom/ta/utdid2/b/a/b;
    //   232: ifnull -> 264
    //   235: iload_1
    //   236: istore #7
    //   238: aload_0
    //   239: getfield a : Lcom/ta/utdid2/b/a/d;
    //   242: ifnull -> 264
    //   245: aload_0
    //   246: aload_0
    //   247: getfield a : Lcom/ta/utdid2/b/a/d;
    //   250: aload_0
    //   251: getfield a : Ljava/lang/String;
    //   254: iconst_0
    //   255: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   258: putfield a : Lcom/ta/utdid2/b/a/b;
    //   261: iload_1
    //   262: istore #7
    //   264: iload #7
    //   266: ireturn
    //   267: astore #6
    //   269: aload #6
    //   271: invokevirtual printStackTrace : ()V
    //   274: goto -> 103
    //   277: aload_0
    //   278: aload_0
    //   279: getfield a : Lcom/ta/utdid2/b/a/b;
    //   282: aload_0
    //   283: getfield a : Landroid/content/SharedPreferences;
    //   286: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   289: goto -> 186
    //   292: iload #4
    //   294: istore_1
    //   295: aload_0
    //   296: getfield a : Lcom/ta/utdid2/b/a/b$a;
    //   299: ifnull -> 202
    //   302: iload #4
    //   304: istore_1
    //   305: aload_0
    //   306: getfield a : Lcom/ta/utdid2/b/a/b$a;
    //   309: invokeinterface commit : ()Z
    //   314: ifne -> 202
    //   317: iconst_0
    //   318: istore_1
    //   319: goto -> 202
    //   322: astore #5
    //   324: iload_1
    //   325: istore #7
    //   327: goto -> 264
    // Exception table:
    //   from	to	target	type
    //   94	99	267	java/lang/Exception
    //   238	261	322	java/lang/Exception
  }
  
  public String getString(String paramString) {
    b();
    if (this.a != null) {
      String str = this.a.getString(paramString, "");
      if (!f.isEmpty(str))
        return str; 
    } 
    return (this.a != null) ? this.a.getString(paramString, "") : "";
  }
  
  public void putString(String paramString1, String paramString2) {
    if (!f.isEmpty(paramString1) && !paramString1.equals("t")) {
      b();
      if (this.a != null)
        this.a.putString(paramString1, paramString2); 
      if (this.a != null)
        this.a.a(paramString1, paramString2); 
    } 
  }
  
  public void remove(String paramString) {
    if (!f.isEmpty(paramString) && !paramString.equals("t")) {
      b();
      if (this.a != null)
        this.a.remove(paramString); 
      if (this.a != null)
        this.a.a(paramString); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
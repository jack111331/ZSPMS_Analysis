package com.ta.utdid2.b.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class d {
  private static final Object b = new Object();
  
  private File a;
  
  private final Object a;
  
  private HashMap<File, a> a = (HashMap<File, a>)new Object();
  
  public d(String paramString) {
    this.a = new HashMap<File, a>();
    if (paramString != null && paramString.length() > 0) {
      this.a = (HashMap<File, a>)new File(paramString);
      return;
    } 
    throw new RuntimeException("Directory can not be empty");
  }
  
  private File a() {
    synchronized (this.a) {
      return (File)this.a;
    } 
  }
  
  private static File a(File paramFile) {
    return new File(paramFile.getPath() + ".bak");
  }
  
  private File a(File paramFile, String paramString) {
    if (paramString.indexOf(File.separatorChar) < 0)
      return new File(paramFile, paramString); 
    throw new IllegalArgumentException("File " + paramString + " contains a path separator");
  }
  
  private File b(String paramString) {
    return a(a(), paramString + ".xml");
  }
  
  public b a(String paramString, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: aconst_null
    //   9: astore #6
    //   11: aconst_null
    //   12: astore #7
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial b : (Ljava/lang/String;)Ljava/io/File;
    //   19: astore #8
    //   21: getstatic com/ta/utdid2/b/a/d.b : Ljava/lang/Object;
    //   24: astore_1
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield a : Ljava/util/HashMap;
    //   31: aload #8
    //   33: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast com/ta/utdid2/b/a/d$a
    //   39: astore #9
    //   41: aload #9
    //   43: ifnull -> 63
    //   46: aload #9
    //   48: invokevirtual c : ()Z
    //   51: ifne -> 63
    //   54: aload_1
    //   55: monitorexit
    //   56: aload #9
    //   58: astore #7
    //   60: aload #7
    //   62: areturn
    //   63: aload_1
    //   64: monitorexit
    //   65: aload #8
    //   67: invokestatic a : (Ljava/io/File;)Ljava/io/File;
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual exists : ()Z
    //   75: ifeq -> 91
    //   78: aload #8
    //   80: invokevirtual delete : ()Z
    //   83: pop
    //   84: aload_1
    //   85: aload #8
    //   87: invokevirtual renameTo : (Ljava/io/File;)Z
    //   90: pop
    //   91: aload #7
    //   93: astore_1
    //   94: aload #8
    //   96: invokevirtual exists : ()Z
    //   99: ifeq -> 165
    //   102: aload #7
    //   104: astore_1
    //   105: aload #8
    //   107: invokevirtual canRead : ()Z
    //   110: ifeq -> 165
    //   113: new java/io/FileInputStream
    //   116: astore #7
    //   118: aload #7
    //   120: aload #8
    //   122: invokespecial <init> : (Ljava/io/File;)V
    //   125: aload #7
    //   127: astore #4
    //   129: aload #5
    //   131: astore_1
    //   132: aload #6
    //   134: astore_3
    //   135: aload #7
    //   137: invokestatic a : (Ljava/io/InputStream;)Ljava/util/HashMap;
    //   140: astore #6
    //   142: aload #7
    //   144: astore #4
    //   146: aload #6
    //   148: astore_1
    //   149: aload #6
    //   151: astore_3
    //   152: aload #7
    //   154: invokevirtual close : ()V
    //   157: aload #7
    //   159: invokevirtual close : ()V
    //   162: aload #6
    //   164: astore_1
    //   165: getstatic com/ta/utdid2/b/a/d.b : Ljava/lang/Object;
    //   168: astore #4
    //   170: aload #4
    //   172: monitorenter
    //   173: aload #9
    //   175: ifnull -> 366
    //   178: aload #9
    //   180: aload_1
    //   181: invokevirtual a : (Ljava/util/Map;)V
    //   184: aload #9
    //   186: astore #7
    //   188: aload #4
    //   190: monitorexit
    //   191: goto -> 60
    //   194: astore_1
    //   195: aload #4
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    //   200: astore #7
    //   202: aload_1
    //   203: monitorexit
    //   204: aload #7
    //   206: athrow
    //   207: astore_1
    //   208: aconst_null
    //   209: astore #7
    //   211: new java/io/FileInputStream
    //   214: astore_1
    //   215: aload_1
    //   216: aload #8
    //   218: invokespecial <init> : (Ljava/io/File;)V
    //   221: aload_1
    //   222: aload_1
    //   223: invokevirtual available : ()I
    //   226: newarray byte
    //   228: invokevirtual read : ([B)I
    //   231: pop
    //   232: aload_1
    //   233: invokevirtual close : ()V
    //   236: aload_1
    //   237: astore #4
    //   239: aload_3
    //   240: astore_1
    //   241: aload #4
    //   243: ifnull -> 165
    //   246: aload #4
    //   248: invokevirtual close : ()V
    //   251: aload_3
    //   252: astore_1
    //   253: goto -> 165
    //   256: astore_1
    //   257: aload_3
    //   258: astore_1
    //   259: goto -> 165
    //   262: astore #7
    //   264: aload_1
    //   265: astore #4
    //   267: goto -> 239
    //   270: astore_1
    //   271: aload #7
    //   273: astore #4
    //   275: aload #7
    //   277: ifnull -> 239
    //   280: aload #7
    //   282: astore #4
    //   284: aload #7
    //   286: invokevirtual close : ()V
    //   289: aload #7
    //   291: astore #4
    //   293: goto -> 239
    //   296: astore_1
    //   297: aload #7
    //   299: astore #4
    //   301: goto -> 239
    //   304: astore_3
    //   305: aload #7
    //   307: astore_1
    //   308: aload_1
    //   309: ifnull -> 316
    //   312: aload_1
    //   313: invokevirtual close : ()V
    //   316: aload_3
    //   317: athrow
    //   318: astore_3
    //   319: aload_1
    //   320: astore #7
    //   322: aload_3
    //   323: astore_1
    //   324: aload #7
    //   326: ifnull -> 334
    //   329: aload #7
    //   331: invokevirtual close : ()V
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: aconst_null
    //   338: astore #7
    //   340: aload #4
    //   342: astore_3
    //   343: aload_3
    //   344: astore_1
    //   345: aload #7
    //   347: ifnull -> 165
    //   350: aload #7
    //   352: invokevirtual close : ()V
    //   355: aload_3
    //   356: astore_1
    //   357: goto -> 165
    //   360: astore_1
    //   361: aload_3
    //   362: astore_1
    //   363: goto -> 165
    //   366: aload_0
    //   367: getfield a : Ljava/util/HashMap;
    //   370: aload #8
    //   372: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   375: checkcast com/ta/utdid2/b/a/d$a
    //   378: astore_3
    //   379: aload_3
    //   380: astore #7
    //   382: aload_3
    //   383: ifnonnull -> 188
    //   386: new com/ta/utdid2/b/a/d$a
    //   389: astore #7
    //   391: aload #7
    //   393: aload #8
    //   395: iload_2
    //   396: aload_1
    //   397: invokespecial <init> : (Ljava/io/File;ILjava/util/Map;)V
    //   400: aload_0
    //   401: getfield a : Ljava/util/HashMap;
    //   404: aload #8
    //   406: aload #7
    //   408: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   411: pop
    //   412: goto -> 188
    //   415: astore_1
    //   416: aload #6
    //   418: astore_1
    //   419: goto -> 165
    //   422: astore #7
    //   424: goto -> 316
    //   427: astore #7
    //   429: goto -> 334
    //   432: astore_1
    //   433: aconst_null
    //   434: astore #7
    //   436: goto -> 324
    //   439: astore_1
    //   440: aload #4
    //   442: astore #7
    //   444: goto -> 324
    //   447: astore_3
    //   448: aload_1
    //   449: astore #7
    //   451: aload_3
    //   452: astore_1
    //   453: goto -> 324
    //   456: astore_3
    //   457: aload_1
    //   458: astore_3
    //   459: goto -> 343
    //   462: astore_3
    //   463: goto -> 308
    //   466: astore #7
    //   468: aload_1
    //   469: astore #7
    //   471: goto -> 271
    //   474: astore_1
    //   475: goto -> 211
    // Exception table:
    //   from	to	target	type
    //   27	41	200	finally
    //   46	56	200	finally
    //   63	65	200	finally
    //   113	125	207	org/xmlpull/v1/XmlPullParserException
    //   113	125	336	java/lang/Exception
    //   113	125	432	finally
    //   135	142	474	org/xmlpull/v1/XmlPullParserException
    //   135	142	456	java/lang/Exception
    //   135	142	439	finally
    //   152	157	474	org/xmlpull/v1/XmlPullParserException
    //   152	157	456	java/lang/Exception
    //   152	157	439	finally
    //   157	162	415	java/lang/Throwable
    //   178	184	194	finally
    //   188	191	194	finally
    //   195	198	194	finally
    //   202	204	200	finally
    //   211	221	270	java/lang/Exception
    //   211	221	304	finally
    //   221	232	466	java/lang/Exception
    //   221	232	462	finally
    //   232	236	262	java/lang/Throwable
    //   232	236	447	finally
    //   246	251	256	java/lang/Throwable
    //   284	289	296	java/lang/Throwable
    //   284	289	439	finally
    //   312	316	422	java/lang/Throwable
    //   312	316	318	finally
    //   316	318	318	finally
    //   329	334	427	java/lang/Throwable
    //   350	355	360	java/lang/Throwable
    //   366	379	194	finally
    //   386	412	194	finally
  }
  
  private static final class a implements b {
    private static final Object c = new Object();
    
    private Map a;
    
    private WeakHashMap<b.b, Object> a;
    
    private final int b;
    
    private final File b;
    
    private final File c;
    
    private boolean g = false;
    
    a(File param1File, int param1Int, Map<Object, Object> param1Map) {
      this.b = param1File;
      this.c = d.b(param1File);
      this.b = param1Int;
      if (param1Map == null)
        param1Map = new HashMap<Object, Object>(); 
      this.a = (WeakHashMap)param1Map;
      this.a = new WeakHashMap<b.b, Object>();
    }
    
    private FileOutputStream a(File param1File) {
      FileOutputStream fileOutputStream;
      try {
        FileOutputStream fileOutputStream1 = new FileOutputStream();
        this(param1File);
        fileOutputStream = fileOutputStream1;
      } catch (FileNotFoundException fileNotFoundException) {}
      return fileOutputStream;
    }
    
    private boolean d() {
      boolean bool2;
      boolean bool1 = false;
      if (this.b.exists())
        if (!this.c.exists()) {
          if (!this.b.renameTo(this.c))
            return bool1; 
        } else {
          this.b.delete();
        }  
      try {
        FileOutputStream fileOutputStream = a(this.b);
        bool2 = bool1;
        if (fileOutputStream != null) {
          e.a(this.a, fileOutputStream);
          fileOutputStream.close();
          this.c.delete();
          bool2 = true;
        } 
      } catch (Exception exception) {
        bool2 = bool1;
      } 
      return bool2;
    }
    
    public final b.a a() {
      return new a(this);
    }
    
    public final void a(Map param1Map) {
      // Byte code:
      //   0: aload_1
      //   1: ifnull -> 13
      //   4: aload_0
      //   5: monitorenter
      //   6: aload_0
      //   7: aload_1
      //   8: putfield a : Ljava/util/Map;
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: astore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_1
      //   18: athrow
      // Exception table:
      //   from	to	target	type
      //   6	13	14	finally
      //   15	17	14	finally
    }
    
    public final void a(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield g : Z
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_2
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_2
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
    
    public final boolean a() {
      return (this.b != null && (new File(this.b.getAbsolutePath())).exists());
    }
    
    public final boolean c() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield g : Z
      //   6: istore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: iload_1
      //   10: ireturn
      //   11: astore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	11	finally
      //   12	14	11	finally
    }
    
    public final Map<String, ?> getAll() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/util/HashMap
      //   5: astore_1
      //   6: aload_1
      //   7: aload_0
      //   8: getfield a : Ljava/util/Map;
      //   11: invokespecial <init> : (Ljava/util/Map;)V
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_1
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	18	finally
      //   19	21	18	finally
    }
    
    public final long getLong(String param1String, long param1Long) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   12: checkcast java/lang/Long
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull -> 25
      //   20: aload_1
      //   21: invokevirtual longValue : ()J
      //   24: lstore_2
      //   25: aload_0
      //   26: monitorexit
      //   27: lload_2
      //   28: lreturn
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	29	finally
      //   20	25	29	finally
      //   25	27	29	finally
      //   30	32	29	finally
    }
    
    public final String getString(String param1String1, String param1String2) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   12: checkcast java/lang/String
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull -> 26
      //   20: aload_1
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: areturn
      //   26: goto -> 22
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	29	finally
      //   22	24	29	finally
      //   30	32	29	finally
    }
    
    public final class a implements b.a {
      private final Map<String, Object> b = new HashMap<String, Object>();
      
      private boolean h = false;
      
      public a(d.a this$0) {}
      
      public final b.a a(String param2String) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: aload_0
        //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   13: pop
        //   14: aload_0
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: astore_1
        //   19: aload_0
        //   20: monitorexit
        //   21: aload_1
        //   22: athrow
        // Exception table:
        //   from	to	target	type
        //   2	16	18	finally
        //   19	21	18	finally
      }
      
      public final b.a a(String param2String, float param2Float) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: fload_2
        //   8: invokestatic valueOf : (F)Ljava/lang/Float;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public final b.a a(String param2String, int param2Int) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: iload_2
        //   8: invokestatic valueOf : (I)Ljava/lang/Integer;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public final b.a a(String param2String, long param2Long) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: lload_2
        //   8: invokestatic valueOf : (J)Ljava/lang/Long;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public final b.a a(String param2String1, String param2String2) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: aload_2
        //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   13: pop
        //   14: aload_0
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: astore_1
        //   19: aload_0
        //   20: monitorexit
        //   21: aload_1
        //   22: athrow
        // Exception table:
        //   from	to	target	type
        //   2	16	18	finally
        //   19	21	18	finally
      }
      
      public final b.a a(String param2String, boolean param2Boolean) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: iload_2
        //   8: invokestatic valueOf : (Z)Ljava/lang/Boolean;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public final b.a b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: iconst_1
        //   4: putfield h : Z
        //   7: aload_0
        //   8: monitorexit
        //   9: aload_0
        //   10: areturn
        //   11: astore_1
        //   12: aload_0
        //   13: monitorexit
        //   14: aload_1
        //   15: athrow
        // Exception table:
        //   from	to	target	type
        //   2	9	11	finally
        //   12	14	11	finally
      }
      
      public final boolean commit() {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: invokestatic a : ()Ljava/lang/Object;
        //   5: astore_2
        //   6: aload_2
        //   7: monitorenter
        //   8: aload_0
        //   9: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   12: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
        //   15: invokevirtual size : ()I
        //   18: ifle -> 23
        //   21: iconst_1
        //   22: istore_1
        //   23: iload_1
        //   24: ifeq -> 333
        //   27: new java/util/ArrayList
        //   30: astore_3
        //   31: aload_3
        //   32: invokespecial <init> : ()V
        //   35: new java/util/HashSet
        //   38: astore #4
        //   40: aload #4
        //   42: aload_0
        //   43: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   46: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
        //   49: invokevirtual keySet : ()Ljava/util/Set;
        //   52: invokespecial <init> : (Ljava/util/Collection;)V
        //   55: aload_0
        //   56: monitorenter
        //   57: aload_0
        //   58: getfield h : Z
        //   61: ifeq -> 81
        //   64: aload_0
        //   65: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   68: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
        //   71: invokeinterface clear : ()V
        //   76: aload_0
        //   77: iconst_0
        //   78: putfield h : Z
        //   81: aload_0
        //   82: getfield b : Ljava/util/Map;
        //   85: invokeinterface entrySet : ()Ljava/util/Set;
        //   90: invokeinterface iterator : ()Ljava/util/Iterator;
        //   95: astore #5
        //   97: aload #5
        //   99: invokeinterface hasNext : ()Z
        //   104: ifeq -> 211
        //   107: aload #5
        //   109: invokeinterface next : ()Ljava/lang/Object;
        //   114: checkcast java/util/Map$Entry
        //   117: astore #6
        //   119: aload #6
        //   121: invokeinterface getKey : ()Ljava/lang/Object;
        //   126: checkcast java/lang/String
        //   129: astore #7
        //   131: aload #6
        //   133: invokeinterface getValue : ()Ljava/lang/Object;
        //   138: astore #6
        //   140: aload #6
        //   142: aload_0
        //   143: if_acmpne -> 191
        //   146: aload_0
        //   147: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   150: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
        //   153: aload #7
        //   155: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
        //   160: pop
        //   161: iload_1
        //   162: ifeq -> 97
        //   165: aload_3
        //   166: aload #7
        //   168: invokeinterface add : (Ljava/lang/Object;)Z
        //   173: pop
        //   174: goto -> 97
        //   177: astore #4
        //   179: aload_0
        //   180: monitorexit
        //   181: aload #4
        //   183: athrow
        //   184: astore #4
        //   186: aload_2
        //   187: monitorexit
        //   188: aload #4
        //   190: athrow
        //   191: aload_0
        //   192: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   195: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
        //   198: aload #7
        //   200: aload #6
        //   202: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   207: pop
        //   208: goto -> 161
        //   211: aload_0
        //   212: getfield b : Ljava/util/Map;
        //   215: invokeinterface clear : ()V
        //   220: aload_0
        //   221: monitorexit
        //   222: aload_0
        //   223: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   226: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Z
        //   229: istore #8
        //   231: iload #8
        //   233: ifeq -> 244
        //   236: aload_0
        //   237: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   240: iconst_1
        //   241: invokevirtual a : (Z)V
        //   244: aload_2
        //   245: monitorexit
        //   246: iload_1
        //   247: ifeq -> 330
        //   250: aload_3
        //   251: invokeinterface size : ()I
        //   256: iconst_1
        //   257: isub
        //   258: istore_1
        //   259: iload_1
        //   260: iflt -> 330
        //   263: aload_3
        //   264: iload_1
        //   265: invokeinterface get : (I)Ljava/lang/Object;
        //   270: checkcast java/lang/String
        //   273: astore #5
        //   275: aload #4
        //   277: invokeinterface iterator : ()Ljava/util/Iterator;
        //   282: astore_2
        //   283: aload_2
        //   284: invokeinterface hasNext : ()Z
        //   289: ifeq -> 324
        //   292: aload_2
        //   293: invokeinterface next : ()Ljava/lang/Object;
        //   298: checkcast com/ta/utdid2/b/a/b$b
        //   301: astore #7
        //   303: aload #7
        //   305: ifnull -> 283
        //   308: aload #7
        //   310: aload_0
        //   311: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   314: aload #5
        //   316: invokeinterface a : (Lcom/ta/utdid2/b/a/b;Ljava/lang/String;)V
        //   321: goto -> 283
        //   324: iinc #1, -1
        //   327: goto -> 259
        //   330: iload #8
        //   332: ireturn
        //   333: aconst_null
        //   334: astore #4
        //   336: aconst_null
        //   337: astore_3
        //   338: goto -> 55
        // Exception table:
        //   from	to	target	type
        //   8	21	184	finally
        //   27	55	184	finally
        //   55	57	184	finally
        //   57	81	177	finally
        //   81	97	177	finally
        //   97	140	177	finally
        //   146	161	177	finally
        //   165	174	177	finally
        //   179	181	177	finally
        //   181	184	184	finally
        //   186	188	184	finally
        //   191	208	177	finally
        //   211	222	177	finally
        //   222	231	184	finally
        //   236	244	184	finally
        //   244	246	184	finally
      }
    }
  }
  
  public final class a implements b.a {
    private final Map<String, Object> b = new HashMap<String, Object>();
    
    private boolean h = false;
    
    public a(d this$0) {}
    
    public final b.a a(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: aload_0
      //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: pop
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_0
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	18	finally
      //   19	21	18	finally
    }
    
    public final b.a a(String param1String, float param1Float) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: fload_2
      //   8: invokestatic valueOf : (F)Ljava/lang/Float;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public final b.a a(String param1String, int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: iload_2
      //   8: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public final b.a a(String param1String, long param1Long) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: lload_2
      //   8: invokestatic valueOf : (J)Ljava/lang/Long;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public final b.a a(String param1String1, String param1String2) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: aload_2
      //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: pop
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_0
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	18	finally
      //   19	21	18	finally
    }
    
    public final b.a a(String param1String, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: iload_2
      //   8: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public final b.a b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield h : Z
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_0
      //   10: areturn
      //   11: astore_1
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_1
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	11	finally
      //   12	14	11	finally
    }
    
    public final boolean commit() {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: invokestatic a : ()Ljava/lang/Object;
      //   5: astore_2
      //   6: aload_2
      //   7: monitorenter
      //   8: aload_0
      //   9: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   12: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
      //   15: invokevirtual size : ()I
      //   18: ifle -> 23
      //   21: iconst_1
      //   22: istore_1
      //   23: iload_1
      //   24: ifeq -> 333
      //   27: new java/util/ArrayList
      //   30: astore_3
      //   31: aload_3
      //   32: invokespecial <init> : ()V
      //   35: new java/util/HashSet
      //   38: astore #4
      //   40: aload #4
      //   42: aload_0
      //   43: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   46: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
      //   49: invokevirtual keySet : ()Ljava/util/Set;
      //   52: invokespecial <init> : (Ljava/util/Collection;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: getfield h : Z
      //   61: ifeq -> 81
      //   64: aload_0
      //   65: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   68: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
      //   71: invokeinterface clear : ()V
      //   76: aload_0
      //   77: iconst_0
      //   78: putfield h : Z
      //   81: aload_0
      //   82: getfield b : Ljava/util/Map;
      //   85: invokeinterface entrySet : ()Ljava/util/Set;
      //   90: invokeinterface iterator : ()Ljava/util/Iterator;
      //   95: astore #5
      //   97: aload #5
      //   99: invokeinterface hasNext : ()Z
      //   104: ifeq -> 211
      //   107: aload #5
      //   109: invokeinterface next : ()Ljava/lang/Object;
      //   114: checkcast java/util/Map$Entry
      //   117: astore #6
      //   119: aload #6
      //   121: invokeinterface getKey : ()Ljava/lang/Object;
      //   126: checkcast java/lang/String
      //   129: astore #7
      //   131: aload #6
      //   133: invokeinterface getValue : ()Ljava/lang/Object;
      //   138: astore #6
      //   140: aload #6
      //   142: aload_0
      //   143: if_acmpne -> 191
      //   146: aload_0
      //   147: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   150: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
      //   153: aload #7
      //   155: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   160: pop
      //   161: iload_1
      //   162: ifeq -> 97
      //   165: aload_3
      //   166: aload #7
      //   168: invokeinterface add : (Ljava/lang/Object;)Z
      //   173: pop
      //   174: goto -> 97
      //   177: astore #4
      //   179: aload_0
      //   180: monitorexit
      //   181: aload #4
      //   183: athrow
      //   184: astore #4
      //   186: aload_2
      //   187: monitorexit
      //   188: aload #4
      //   190: athrow
      //   191: aload_0
      //   192: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   195: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
      //   198: aload #7
      //   200: aload #6
      //   202: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   207: pop
      //   208: goto -> 161
      //   211: aload_0
      //   212: getfield b : Ljava/util/Map;
      //   215: invokeinterface clear : ()V
      //   220: aload_0
      //   221: monitorexit
      //   222: aload_0
      //   223: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   226: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Z
      //   229: istore #8
      //   231: iload #8
      //   233: ifeq -> 244
      //   236: aload_0
      //   237: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   240: iconst_1
      //   241: invokevirtual a : (Z)V
      //   244: aload_2
      //   245: monitorexit
      //   246: iload_1
      //   247: ifeq -> 330
      //   250: aload_3
      //   251: invokeinterface size : ()I
      //   256: iconst_1
      //   257: isub
      //   258: istore_1
      //   259: iload_1
      //   260: iflt -> 330
      //   263: aload_3
      //   264: iload_1
      //   265: invokeinterface get : (I)Ljava/lang/Object;
      //   270: checkcast java/lang/String
      //   273: astore #5
      //   275: aload #4
      //   277: invokeinterface iterator : ()Ljava/util/Iterator;
      //   282: astore_2
      //   283: aload_2
      //   284: invokeinterface hasNext : ()Z
      //   289: ifeq -> 324
      //   292: aload_2
      //   293: invokeinterface next : ()Ljava/lang/Object;
      //   298: checkcast com/ta/utdid2/b/a/b$b
      //   301: astore #7
      //   303: aload #7
      //   305: ifnull -> 283
      //   308: aload #7
      //   310: aload_0
      //   311: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   314: aload #5
      //   316: invokeinterface a : (Lcom/ta/utdid2/b/a/b;Ljava/lang/String;)V
      //   321: goto -> 283
      //   324: iinc #1, -1
      //   327: goto -> 259
      //   330: iload #8
      //   332: ireturn
      //   333: aconst_null
      //   334: astore #4
      //   336: aconst_null
      //   337: astore_3
      //   338: goto -> 55
      // Exception table:
      //   from	to	target	type
      //   8	21	184	finally
      //   27	55	184	finally
      //   55	57	184	finally
      //   57	81	177	finally
      //   81	97	177	finally
      //   97	140	177	finally
      //   146	161	177	finally
      //   165	174	177	finally
      //   179	181	177	finally
      //   181	184	184	finally
      //   186	188	184	finally
      //   191	208	177	finally
      //   211	222	177	finally
      //   222	231	184	finally
      //   236	244	184	finally
      //   244	246	184	finally
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
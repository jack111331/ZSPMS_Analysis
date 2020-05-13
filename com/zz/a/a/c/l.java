package com.zz.a.a.c;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l implements Closeable {
  static final String a = "journal";
  
  static final String b = "journal.tmp";
  
  static final String c = "libcore.io.DiskLruCache";
  
  static final String d = "1";
  
  static final long e = -1L;
  
  private static final String f = "CLEAN";
  
  private static final String g = "DIRTY";
  
  private static final String h = "REMOVE";
  
  private static final String i = "READ";
  
  private static final Charset j = Charset.forName("UTF-8");
  
  private static final int k = 8192;
  
  private final File l;
  
  private final File m;
  
  private final File n;
  
  private final int o;
  
  private final long p;
  
  private final int q;
  
  private long r = 0L;
  
  private Writer s;
  
  private final LinkedHashMap t = new LinkedHashMap<Object, Object>(0, 0.75F, true);
  
  private int u;
  
  private long v = 0L;
  
  private final ExecutorService w = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
  
  private final Callable x = new m(this);
  
  private l(File paramFile, int paramInt1, int paramInt2, long paramLong) {
    this.l = paramFile;
    this.o = paramInt1;
    this.m = new File(paramFile, "journal");
    this.n = new File(paramFile, "journal.tmp");
    this.q = paramInt2;
    this.p = paramLong;
  }
  
  public static l a(File paramFile, int paramInt1, int paramInt2, long paramLong) {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0"); 
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0"); 
    l l2 = new l(paramFile, paramInt1, paramInt2, paramLong);
    if (l2.m.exists())
      try {
        l2.h();
        l2.i();
        BufferedWriter bufferedWriter = new BufferedWriter();
        FileWriter fileWriter = new FileWriter();
        this(l2.m, true);
        this(fileWriter, 8192);
        l2.s = bufferedWriter;
        return l2;
      } catch (IOException iOException) {
        l2.f();
      }  
    paramFile.mkdirs();
    l l1 = new l(paramFile, paramInt1, paramInt2, paramLong);
    l1.j();
    return l1;
  }
  
  private n a(String paramString, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial l : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield t : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/zz/a/a/c/p
    //   22: astore #4
    //   24: lload_2
    //   25: ldc2_w -1
    //   28: lcmp
    //   29: ifeq -> 57
    //   32: aload #4
    //   34: ifnull -> 51
    //   37: aload #4
    //   39: invokestatic e : (Lcom/zz/a/a/c/p;)J
    //   42: lstore #5
    //   44: lload #5
    //   46: lload_2
    //   47: lcmp
    //   48: ifeq -> 57
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aload #4
    //   59: ifnonnull -> 166
    //   62: new com/zz/a/a/c/p
    //   65: astore #4
    //   67: aload #4
    //   69: aload_0
    //   70: aload_1
    //   71: aconst_null
    //   72: invokespecial <init> : (Lcom/zz/a/a/c/l;Ljava/lang/String;Lcom/zz/a/a/c/m;)V
    //   75: aload_0
    //   76: getfield t : Ljava/util/LinkedHashMap;
    //   79: aload_1
    //   80: aload #4
    //   82: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: new com/zz/a/a/c/n
    //   89: astore #7
    //   91: aload #7
    //   93: aload_0
    //   94: aload #4
    //   96: aconst_null
    //   97: invokespecial <init> : (Lcom/zz/a/a/c/l;Lcom/zz/a/a/c/p;Lcom/zz/a/a/c/m;)V
    //   100: aload #4
    //   102: aload #7
    //   104: invokestatic a : (Lcom/zz/a/a/c/p;Lcom/zz/a/a/c/n;)Lcom/zz/a/a/c/n;
    //   107: pop
    //   108: aload_0
    //   109: getfield s : Ljava/io/Writer;
    //   112: astore #4
    //   114: new java/lang/StringBuilder
    //   117: astore #8
    //   119: aload #8
    //   121: invokespecial <init> : ()V
    //   124: aload #4
    //   126: aload #8
    //   128: ldc 'DIRTY '
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: bipush #10
    //   139: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: invokevirtual write : (Ljava/lang/String;)V
    //   148: aload_0
    //   149: getfield s : Ljava/io/Writer;
    //   152: invokevirtual flush : ()V
    //   155: aload #7
    //   157: astore_1
    //   158: goto -> 53
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: aload #4
    //   168: invokestatic a : (Lcom/zz/a/a/c/p;)Lcom/zz/a/a/c/n;
    //   171: astore #7
    //   173: aload #7
    //   175: ifnull -> 183
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -> 53
    //   183: goto -> 86
    // Exception table:
    //   from	to	target	type
    //   2	24	161	finally
    //   37	44	161	finally
    //   62	86	161	finally
    //   86	155	161	finally
    //   166	173	161	finally
  }
  
  public static String a(InputStream paramInputStream) {
    StringBuilder stringBuilder = new StringBuilder(80);
    while (true) {
      int i = paramInputStream.read();
      if (i == -1)
        throw new EOFException(); 
      if (i == 10) {
        i = stringBuilder.length();
        if (i > 0 && stringBuilder.charAt(i - 1) == '\r')
          stringBuilder.setLength(i - 1); 
        return stringBuilder.toString();
      } 
      stringBuilder.append((char)i);
    } 
  }
  
  public static String a(Reader paramReader) {
    try {
      StringWriter stringWriter = new StringWriter();
      this();
      char[] arrayOfChar = new char[1024];
      while (true) {
        int i = paramReader.read(arrayOfChar);
        if (i != -1) {
          stringWriter.write(arrayOfChar, 0, i);
          continue;
        } 
        return stringWriter.toString();
      } 
    } finally {
      paramReader.close();
    } 
  }
  
  private void a(n paramn, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic a : (Lcom/zz/a/a/c/n;)Lcom/zz/a/a/c/p;
    //   8: astore #4
    //   10: aload #4
    //   12: invokestatic a : (Lcom/zz/a/a/c/p;)Lcom/zz/a/a/c/n;
    //   15: aload_1
    //   16: if_acmpeq -> 34
    //   19: new java/lang/IllegalStateException
    //   22: astore_1
    //   23: aload_1
    //   24: invokespecial <init> : ()V
    //   27: aload_1
    //   28: athrow
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    //   34: iload_3
    //   35: istore #5
    //   37: iload_2
    //   38: ifeq -> 126
    //   41: iload_3
    //   42: istore #5
    //   44: aload #4
    //   46: invokestatic d : (Lcom/zz/a/a/c/p;)Z
    //   49: ifne -> 126
    //   52: iconst_0
    //   53: istore #6
    //   55: iload_3
    //   56: istore #5
    //   58: iload #6
    //   60: aload_0
    //   61: getfield q : I
    //   64: if_icmpge -> 126
    //   67: aload #4
    //   69: iload #6
    //   71: invokevirtual b : (I)Ljava/io/File;
    //   74: invokevirtual exists : ()Z
    //   77: ifne -> 120
    //   80: aload_1
    //   81: invokevirtual b : ()V
    //   84: new java/lang/IllegalStateException
    //   87: astore #4
    //   89: new java/lang/StringBuilder
    //   92: astore_1
    //   93: aload_1
    //   94: invokespecial <init> : ()V
    //   97: aload #4
    //   99: aload_1
    //   100: ldc_w 'edit didn't create file '
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload #6
    //   108: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: invokespecial <init> : (Ljava/lang/String;)V
    //   117: aload #4
    //   119: athrow
    //   120: iinc #6, 1
    //   123: goto -> 55
    //   126: iload #5
    //   128: aload_0
    //   129: getfield q : I
    //   132: if_icmpge -> 224
    //   135: aload #4
    //   137: iload #5
    //   139: invokevirtual b : (I)Ljava/io/File;
    //   142: astore_1
    //   143: iload_2
    //   144: ifeq -> 217
    //   147: aload_1
    //   148: invokevirtual exists : ()Z
    //   151: ifeq -> 211
    //   154: aload #4
    //   156: iload #5
    //   158: invokevirtual a : (I)Ljava/io/File;
    //   161: astore #7
    //   163: aload_1
    //   164: aload #7
    //   166: invokevirtual renameTo : (Ljava/io/File;)Z
    //   169: pop
    //   170: aload #4
    //   172: invokestatic b : (Lcom/zz/a/a/c/p;)[J
    //   175: iload #5
    //   177: laload
    //   178: lstore #8
    //   180: aload #7
    //   182: invokevirtual length : ()J
    //   185: lstore #10
    //   187: aload #4
    //   189: invokestatic b : (Lcom/zz/a/a/c/p;)[J
    //   192: iload #5
    //   194: lload #10
    //   196: lastore
    //   197: aload_0
    //   198: aload_0
    //   199: getfield r : J
    //   202: lload #8
    //   204: lsub
    //   205: lload #10
    //   207: ladd
    //   208: putfield r : J
    //   211: iinc #5, 1
    //   214: goto -> 126
    //   217: aload_1
    //   218: invokestatic b : (Ljava/io/File;)V
    //   221: goto -> 211
    //   224: aload_0
    //   225: aload_0
    //   226: getfield u : I
    //   229: iconst_1
    //   230: iadd
    //   231: putfield u : I
    //   234: aload #4
    //   236: aconst_null
    //   237: invokestatic a : (Lcom/zz/a/a/c/p;Lcom/zz/a/a/c/n;)Lcom/zz/a/a/c/n;
    //   240: pop
    //   241: aload #4
    //   243: invokestatic d : (Lcom/zz/a/a/c/p;)Z
    //   246: iload_2
    //   247: ior
    //   248: ifeq -> 371
    //   251: aload #4
    //   253: iconst_1
    //   254: invokestatic a : (Lcom/zz/a/a/c/p;Z)Z
    //   257: pop
    //   258: aload_0
    //   259: getfield s : Ljava/io/Writer;
    //   262: astore_1
    //   263: new java/lang/StringBuilder
    //   266: astore #7
    //   268: aload #7
    //   270: invokespecial <init> : ()V
    //   273: aload_1
    //   274: aload #7
    //   276: ldc_w 'CLEAN '
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload #4
    //   284: invokestatic c : (Lcom/zz/a/a/c/p;)Ljava/lang/String;
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload #4
    //   292: invokevirtual a : ()Ljava/lang/String;
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: bipush #10
    //   300: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   303: invokevirtual toString : ()Ljava/lang/String;
    //   306: invokevirtual write : (Ljava/lang/String;)V
    //   309: iload_2
    //   310: ifeq -> 335
    //   313: aload_0
    //   314: getfield v : J
    //   317: lstore #8
    //   319: aload_0
    //   320: lconst_1
    //   321: lload #8
    //   323: ladd
    //   324: putfield v : J
    //   327: aload #4
    //   329: lload #8
    //   331: invokestatic a : (Lcom/zz/a/a/c/p;J)J
    //   334: pop2
    //   335: aload_0
    //   336: getfield r : J
    //   339: aload_0
    //   340: getfield p : J
    //   343: lcmp
    //   344: ifgt -> 354
    //   347: aload_0
    //   348: invokespecial k : ()Z
    //   351: ifeq -> 368
    //   354: aload_0
    //   355: getfield w : Ljava/util/concurrent/ExecutorService;
    //   358: aload_0
    //   359: getfield x : Ljava/util/concurrent/Callable;
    //   362: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   367: pop
    //   368: aload_0
    //   369: monitorexit
    //   370: return
    //   371: aload_0
    //   372: getfield t : Ljava/util/LinkedHashMap;
    //   375: aload #4
    //   377: invokestatic c : (Lcom/zz/a/a/c/p;)Ljava/lang/String;
    //   380: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_0
    //   385: getfield s : Ljava/io/Writer;
    //   388: astore #7
    //   390: new java/lang/StringBuilder
    //   393: astore_1
    //   394: aload_1
    //   395: invokespecial <init> : ()V
    //   398: aload #7
    //   400: aload_1
    //   401: ldc_w 'REMOVE '
    //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload #4
    //   409: invokestatic c : (Lcom/zz/a/a/c/p;)Ljava/lang/String;
    //   412: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: bipush #10
    //   417: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   420: invokevirtual toString : ()Ljava/lang/String;
    //   423: invokevirtual write : (Ljava/lang/String;)V
    //   426: goto -> 335
    // Exception table:
    //   from	to	target	type
    //   4	29	29	finally
    //   44	52	29	finally
    //   58	120	29	finally
    //   126	143	29	finally
    //   147	211	29	finally
    //   217	221	29	finally
    //   224	309	29	finally
    //   313	335	29	finally
    //   335	354	29	finally
    //   354	368	29	finally
    //   371	426	29	finally
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static void a(File paramFile) {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
      throw new IllegalArgumentException("not a directory: " + paramFile); 
    int i = arrayOfFile.length;
    for (byte b = 0; b < i; b++) {
      paramFile = arrayOfFile[b];
      if (paramFile.isDirectory())
        a(paramFile); 
      if (!paramFile.delete())
        throw new IOException("failed to delete file: " + paramFile); 
    } 
  }
  
  private static Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
    int i = paramArrayOfObject.length;
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException(); 
    if (paramInt1 < 0 || paramInt1 > i)
      throw new ArrayIndexOutOfBoundsException(); 
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), paramInt2);
    System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  private static void b(File paramFile) {
    if (paramFile.exists() && !paramFile.delete())
      throw new IOException(); 
  }
  
  private static String c(InputStream paramInputStream) {
    return a(new InputStreamReader(paramInputStream, j));
  }
  
  private void d(String paramString) {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length < 2)
      throw new IOException("unexpected journal line: " + paramString); 
    String str = arrayOfString[1];
    if (arrayOfString[0].equals("REMOVE") && arrayOfString.length == 2) {
      this.t.remove(str);
      return;
    } 
    p p = (p)this.t.get(str);
    if (p == null) {
      p = new p(this, str, null);
      this.t.put(str, p);
    } 
    if (arrayOfString[0].equals("CLEAN") && arrayOfString.length == this.q + 2) {
      p.a(p, true);
      p.a(p, (n)null);
      p.a(p, (String[])a((Object[])arrayOfString, 2, arrayOfString.length));
      return;
    } 
    if (arrayOfString[0].equals("DIRTY") && arrayOfString.length == 2) {
      p.a(p, new n(this, p, null));
      return;
    } 
    if (!arrayOfString[0].equals("READ") || arrayOfString.length != 2)
      throw new IOException("unexpected journal line: " + paramString); 
  }
  
  private void e(String paramString) {
    if (paramString.contains(" ") || paramString.contains("\n") || paramString.contains("\r"))
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\""); 
  }
  
  private void h() {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.m), 8192);
    try {
      String str1 = a(bufferedInputStream);
      String str2 = a(bufferedInputStream);
      String str3 = a(bufferedInputStream);
      String str4 = a(bufferedInputStream);
      String str5 = a(bufferedInputStream);
    } finally {
      a(bufferedInputStream);
    } 
    try {
      while (true)
        d(a(bufferedInputStream)); 
    } catch (EOFException eOFException) {
      a(bufferedInputStream);
      return;
    } 
  }
  
  private void i() {
    b(this.n);
    Iterator<p> iterator = this.t.values().iterator();
    while (iterator.hasNext()) {
      p p = iterator.next();
      if (p.a(p) == null) {
        for (byte b1 = 0; b1 < this.q; b1++)
          this.r += p.b(p)[b1]; 
        continue;
      } 
      p.a(p, (n)null);
      for (byte b = 0; b < this.q; b++) {
        b(p.a(b));
        b(p.b(b));
      } 
      iterator.remove();
    } 
  }
  
  private void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield s : Ljava/io/Writer;
    //   6: ifnull -> 16
    //   9: aload_0
    //   10: getfield s : Ljava/io/Writer;
    //   13: invokevirtual close : ()V
    //   16: new java/io/BufferedWriter
    //   19: astore_1
    //   20: new java/io/FileWriter
    //   23: astore_2
    //   24: aload_2
    //   25: aload_0
    //   26: getfield n : Ljava/io/File;
    //   29: invokespecial <init> : (Ljava/io/File;)V
    //   32: aload_1
    //   33: aload_2
    //   34: sipush #8192
    //   37: invokespecial <init> : (Ljava/io/Writer;I)V
    //   40: aload_1
    //   41: ldc 'libcore.io.DiskLruCache'
    //   43: invokevirtual write : (Ljava/lang/String;)V
    //   46: aload_1
    //   47: ldc_w '\\n'
    //   50: invokevirtual write : (Ljava/lang/String;)V
    //   53: aload_1
    //   54: ldc '1'
    //   56: invokevirtual write : (Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w '\\n'
    //   63: invokevirtual write : (Ljava/lang/String;)V
    //   66: aload_1
    //   67: aload_0
    //   68: getfield o : I
    //   71: invokestatic toString : (I)Ljava/lang/String;
    //   74: invokevirtual write : (Ljava/lang/String;)V
    //   77: aload_1
    //   78: ldc_w '\\n'
    //   81: invokevirtual write : (Ljava/lang/String;)V
    //   84: aload_1
    //   85: aload_0
    //   86: getfield q : I
    //   89: invokestatic toString : (I)Ljava/lang/String;
    //   92: invokevirtual write : (Ljava/lang/String;)V
    //   95: aload_1
    //   96: ldc_w '\\n'
    //   99: invokevirtual write : (Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc_w '\\n'
    //   106: invokevirtual write : (Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield t : Ljava/util/LinkedHashMap;
    //   113: invokevirtual values : ()Ljava/util/Collection;
    //   116: invokeinterface iterator : ()Ljava/util/Iterator;
    //   121: astore_2
    //   122: aload_2
    //   123: invokeinterface hasNext : ()Z
    //   128: ifeq -> 239
    //   131: aload_2
    //   132: invokeinterface next : ()Ljava/lang/Object;
    //   137: checkcast com/zz/a/a/c/p
    //   140: astore_3
    //   141: aload_3
    //   142: invokestatic a : (Lcom/zz/a/a/c/p;)Lcom/zz/a/a/c/n;
    //   145: ifnull -> 192
    //   148: new java/lang/StringBuilder
    //   151: astore #4
    //   153: aload #4
    //   155: invokespecial <init> : ()V
    //   158: aload_1
    //   159: aload #4
    //   161: ldc 'DIRTY '
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_3
    //   167: invokestatic c : (Lcom/zz/a/a/c/p;)Ljava/lang/String;
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: bipush #10
    //   175: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: invokevirtual write : (Ljava/lang/String;)V
    //   184: goto -> 122
    //   187: astore_1
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    //   192: new java/lang/StringBuilder
    //   195: astore #4
    //   197: aload #4
    //   199: invokespecial <init> : ()V
    //   202: aload_1
    //   203: aload #4
    //   205: ldc_w 'CLEAN '
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_3
    //   212: invokestatic c : (Lcom/zz/a/a/c/p;)Ljava/lang/String;
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual a : ()Ljava/lang/String;
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: bipush #10
    //   227: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   230: invokevirtual toString : ()Ljava/lang/String;
    //   233: invokevirtual write : (Ljava/lang/String;)V
    //   236: goto -> 122
    //   239: aload_1
    //   240: invokevirtual close : ()V
    //   243: aload_0
    //   244: getfield n : Ljava/io/File;
    //   247: aload_0
    //   248: getfield m : Ljava/io/File;
    //   251: invokevirtual renameTo : (Ljava/io/File;)Z
    //   254: pop
    //   255: new java/io/BufferedWriter
    //   258: astore_1
    //   259: new java/io/FileWriter
    //   262: astore_2
    //   263: aload_2
    //   264: aload_0
    //   265: getfield m : Ljava/io/File;
    //   268: iconst_1
    //   269: invokespecial <init> : (Ljava/io/File;Z)V
    //   272: aload_1
    //   273: aload_2
    //   274: sipush #8192
    //   277: invokespecial <init> : (Ljava/io/Writer;I)V
    //   280: aload_0
    //   281: aload_1
    //   282: putfield s : Ljava/io/Writer;
    //   285: aload_0
    //   286: monitorexit
    //   287: return
    // Exception table:
    //   from	to	target	type
    //   2	16	187	finally
    //   16	122	187	finally
    //   122	184	187	finally
    //   192	236	187	finally
    //   239	285	187	finally
  }
  
  private boolean k() {
    return (this.u >= 2000 && this.u >= this.t.size());
  }
  
  private void l() {
    if (this.s == null)
      throw new IllegalStateException("cache is closed"); 
  }
  
  private void m() {
    while (this.r > this.p)
      c((String)((Map.Entry)this.t.entrySet().iterator().next()).getKey()); 
  }
  
  public q a(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial l : ()V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial e : (Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield t : Ljava/util/LinkedHashMap;
    //   17: aload_1
    //   18: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast com/zz/a/a/c/p
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull -> 37
    //   29: aload_2
    //   30: astore #4
    //   32: aload_0
    //   33: monitorexit
    //   34: aload #4
    //   36: areturn
    //   37: aload_2
    //   38: astore #4
    //   40: aload_3
    //   41: invokestatic d : (Lcom/zz/a/a/c/p;)Z
    //   44: ifeq -> 32
    //   47: aload_0
    //   48: getfield q : I
    //   51: anewarray java/io/InputStream
    //   54: astore #4
    //   56: iconst_0
    //   57: istore #5
    //   59: iload #5
    //   61: aload_0
    //   62: getfield q : I
    //   65: if_icmpge -> 92
    //   68: aload #4
    //   70: iload #5
    //   72: new java/io/FileInputStream
    //   75: dup
    //   76: aload_3
    //   77: iload #5
    //   79: invokevirtual a : (I)Ljava/io/File;
    //   82: invokespecial <init> : (Ljava/io/File;)V
    //   85: aastore
    //   86: iinc #5, 1
    //   89: goto -> 59
    //   92: aload_0
    //   93: aload_0
    //   94: getfield u : I
    //   97: iconst_1
    //   98: iadd
    //   99: putfield u : I
    //   102: aload_0
    //   103: getfield s : Ljava/io/Writer;
    //   106: astore #6
    //   108: new java/lang/StringBuilder
    //   111: astore_2
    //   112: aload_2
    //   113: invokespecial <init> : ()V
    //   116: aload #6
    //   118: aload_2
    //   119: ldc_w 'READ '
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: bipush #10
    //   131: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   134: invokevirtual toString : ()Ljava/lang/String;
    //   137: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   140: pop
    //   141: aload_0
    //   142: invokespecial k : ()Z
    //   145: ifeq -> 162
    //   148: aload_0
    //   149: getfield w : Ljava/util/concurrent/ExecutorService;
    //   152: aload_0
    //   153: getfield x : Ljava/util/concurrent/Callable;
    //   156: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   161: pop
    //   162: new com/zz/a/a/c/q
    //   165: dup
    //   166: aload_0
    //   167: aload_1
    //   168: aload_3
    //   169: invokestatic e : (Lcom/zz/a/a/c/p;)J
    //   172: aload #4
    //   174: aconst_null
    //   175: invokespecial <init> : (Lcom/zz/a/a/c/l;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/zz/a/a/c/m;)V
    //   178: astore #4
    //   180: goto -> 32
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    //   188: astore_1
    //   189: aload_2
    //   190: astore #4
    //   192: goto -> 32
    // Exception table:
    //   from	to	target	type
    //   4	25	183	finally
    //   40	56	183	finally
    //   59	86	188	java/io/FileNotFoundException
    //   59	86	183	finally
    //   92	162	183	finally
    //   162	180	183	finally
  }
  
  public File a() {
    return this.l;
  }
  
  public long b() {
    return this.p;
  }
  
  public n b(String paramString) {
    return a(paramString, -1L);
  }
  
  public long c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield r : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean c(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial l : ()V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial e : (Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield t : Ljava/util/LinkedHashMap;
    //   17: aload_1
    //   18: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast com/zz/a/a/c/p
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull -> 40
    //   29: aload_3
    //   30: invokestatic a : (Lcom/zz/a/a/c/p;)Lcom/zz/a/a/c/n;
    //   33: astore #4
    //   35: aload #4
    //   37: ifnull -> 73
    //   40: iconst_0
    //   41: istore #5
    //   43: aload_0
    //   44: monitorexit
    //   45: iload #5
    //   47: ireturn
    //   48: aload_0
    //   49: aload_0
    //   50: getfield r : J
    //   53: aload_3
    //   54: invokestatic b : (Lcom/zz/a/a/c/p;)[J
    //   57: iload_2
    //   58: laload
    //   59: lsub
    //   60: putfield r : J
    //   63: aload_3
    //   64: invokestatic b : (Lcom/zz/a/a/c/p;)[J
    //   67: iload_2
    //   68: lconst_0
    //   69: lastore
    //   70: iinc #2, 1
    //   73: iload_2
    //   74: aload_0
    //   75: getfield q : I
    //   78: if_icmpge -> 134
    //   81: aload_3
    //   82: iload_2
    //   83: invokevirtual a : (I)Ljava/io/File;
    //   86: astore #4
    //   88: aload #4
    //   90: invokevirtual delete : ()Z
    //   93: ifne -> 48
    //   96: new java/io/IOException
    //   99: astore_3
    //   100: new java/lang/StringBuilder
    //   103: astore_1
    //   104: aload_1
    //   105: invokespecial <init> : ()V
    //   108: aload_3
    //   109: aload_1
    //   110: ldc_w 'failed to delete '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload #4
    //   118: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: invokespecial <init> : (Ljava/lang/String;)V
    //   127: aload_3
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aload_0
    //   135: aload_0
    //   136: getfield u : I
    //   139: iconst_1
    //   140: iadd
    //   141: putfield u : I
    //   144: aload_0
    //   145: getfield s : Ljava/io/Writer;
    //   148: astore #4
    //   150: new java/lang/StringBuilder
    //   153: astore_3
    //   154: aload_3
    //   155: invokespecial <init> : ()V
    //   158: aload #4
    //   160: aload_3
    //   161: ldc_w 'REMOVE '
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: bipush #10
    //   173: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   182: pop
    //   183: aload_0
    //   184: getfield t : Ljava/util/LinkedHashMap;
    //   187: aload_1
    //   188: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: aload_0
    //   193: invokespecial k : ()Z
    //   196: ifeq -> 213
    //   199: aload_0
    //   200: getfield w : Ljava/util/concurrent/ExecutorService;
    //   203: aload_0
    //   204: getfield x : Ljava/util/concurrent/Callable;
    //   207: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   212: pop
    //   213: iconst_1
    //   214: istore #5
    //   216: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   4	25	129	finally
    //   29	35	129	finally
    //   48	70	129	finally
    //   73	129	129	finally
    //   134	213	129	finally
  }
  
  public void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield s : Ljava/io/Writer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/util/ArrayList
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: getfield t : Ljava/util/LinkedHashMap;
    //   23: invokevirtual values : ()Ljava/util/Collection;
    //   26: invokespecial <init> : (Ljava/util/Collection;)V
    //   29: aload_1
    //   30: invokevirtual iterator : ()Ljava/util/Iterator;
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface hasNext : ()Z
    //   40: ifeq -> 75
    //   43: aload_2
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast com/zz/a/a/c/p
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic a : (Lcom/zz/a/a/c/p;)Lcom/zz/a/a/c/n;
    //   57: ifnull -> 34
    //   60: aload_1
    //   61: invokestatic a : (Lcom/zz/a/a/c/p;)Lcom/zz/a/a/c/n;
    //   64: invokevirtual b : ()V
    //   67: goto -> 34
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: aload_0
    //   76: invokespecial m : ()V
    //   79: aload_0
    //   80: getfield s : Ljava/io/Writer;
    //   83: invokevirtual close : ()V
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield s : Ljava/io/Writer;
    //   91: goto -> 11
    // Exception table:
    //   from	to	target	type
    //   2	7	70	finally
    //   14	34	70	finally
    //   34	67	70	finally
    //   75	91	70	finally
  }
  
  public boolean d() {
    return (this.s == null);
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial l : ()V
    //   6: aload_0
    //   7: invokespecial m : ()V
    //   10: aload_0
    //   11: getfield s : Ljava/io/Writer;
    //   14: invokevirtual flush : ()V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  public void f() {
    close();
    a(this.l);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
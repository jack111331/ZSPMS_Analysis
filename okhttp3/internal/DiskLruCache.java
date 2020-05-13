package okhttp3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache implements Closeable, Flushable {
  static final long ANY_SEQUENCE_NUMBER = -1L;
  
  private static final String CLEAN = "CLEAN";
  
  private static final String DIRTY = "DIRTY";
  
  static final String JOURNAL_FILE = "journal";
  
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
  
  static final String MAGIC = "libcore.io.DiskLruCache";
  
  private static final Sink NULL_SINK = new Sink() {
      public void close() throws IOException {}
      
      public void flush() throws IOException {}
      
      public Timeout timeout() {
        return Timeout.NONE;
      }
      
      public void write(Buffer param1Buffer, long param1Long) throws IOException {
        param1Buffer.skip(param1Long);
      }
    };
  
  private static final String READ = "READ";
  
  private static final String REMOVE = "REMOVE";
  
  static final String VERSION_1 = "1";
  
  private final int appVersion;
  
  private final Runnable cleanupRunnable = new Runnable() {
      public void run() {
        boolean bool = true;
        synchronized (DiskLruCache.this) {
          if (DiskLruCache.this.initialized)
            bool = false; 
          if (bool | DiskLruCache.this.closed)
            return; 
          try {
            DiskLruCache.this.trimToSize();
          } catch (IOException iOException) {}
          try {
            if (DiskLruCache.this.journalRebuildRequired()) {
              DiskLruCache.this.rebuildJournal();
              DiskLruCache.access$602(DiskLruCache.this, 0);
            } 
          } catch (IOException iOException) {}
          return;
        } 
      }
    };
  
  private boolean closed;
  
  private final File directory;
  
  private final Executor executor;
  
  private final FileSystem fileSystem;
  
  private boolean hasJournalErrors;
  
  private boolean initialized;
  
  private final File journalFile;
  
  private final File journalFileBackup;
  
  private final File journalFileTmp;
  
  private BufferedSink journalWriter;
  
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<String, Entry>(0, 0.75F, true);
  
  private long maxSize;
  
  private boolean mostRecentRebuildFailed;
  
  private boolean mostRecentTrimFailed;
  
  private long nextSequenceNumber = 0L;
  
  private int redundantOpCount;
  
  private long size = 0L;
  
  private final int valueCount;
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor) {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual isClosed : ()Z
    //   6: ifeq -> 26
    //   9: new java/lang/IllegalStateException
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 'cache is closed'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    // Exception table:
    //   from	to	target	type
    //   2	21	21	finally
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic access$2100 : (Lokhttp3/internal/DiskLruCache$Editor;)Lokhttp3/internal/DiskLruCache$Entry;
    //   6: astore_3
    //   7: aload_3
    //   8: invokestatic access$1300 : (Lokhttp3/internal/DiskLruCache$Entry;)Lokhttp3/internal/DiskLruCache$Editor;
    //   11: aload_1
    //   12: if_acmpeq -> 30
    //   15: new java/lang/IllegalStateException
    //   18: astore_1
    //   19: aload_1
    //   20: invokespecial <init> : ()V
    //   23: aload_1
    //   24: athrow
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: iload_2
    //   31: ifeq -> 132
    //   34: aload_3
    //   35: invokestatic access$1200 : (Lokhttp3/internal/DiskLruCache$Entry;)Z
    //   38: ifne -> 132
    //   41: iconst_0
    //   42: istore #4
    //   44: iload #4
    //   46: aload_0
    //   47: getfield valueCount : I
    //   50: if_icmpge -> 132
    //   53: aload_1
    //   54: invokestatic access$2200 : (Lokhttp3/internal/DiskLruCache$Editor;)[Z
    //   57: iload #4
    //   59: baload
    //   60: ifne -> 100
    //   63: aload_1
    //   64: invokevirtual abort : ()V
    //   67: new java/lang/IllegalStateException
    //   70: astore_3
    //   71: new java/lang/StringBuilder
    //   74: astore_1
    //   75: aload_1
    //   76: invokespecial <init> : ()V
    //   79: aload_3
    //   80: aload_1
    //   81: ldc_w 'Newly created entry didn't create value for index '
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload #4
    //   89: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: aload_3
    //   99: athrow
    //   100: aload_0
    //   101: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   104: aload_3
    //   105: invokestatic access$1800 : (Lokhttp3/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   108: iload #4
    //   110: aaload
    //   111: invokeinterface exists : (Ljava/io/File;)Z
    //   116: ifne -> 126
    //   119: aload_1
    //   120: invokevirtual abort : ()V
    //   123: aload_0
    //   124: monitorexit
    //   125: return
    //   126: iinc #4, 1
    //   129: goto -> 44
    //   132: iconst_0
    //   133: istore #4
    //   135: iload #4
    //   137: aload_0
    //   138: getfield valueCount : I
    //   141: if_icmpge -> 254
    //   144: aload_3
    //   145: invokestatic access$1800 : (Lokhttp3/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   148: iload #4
    //   150: aaload
    //   151: astore_1
    //   152: iload_2
    //   153: ifeq -> 241
    //   156: aload_0
    //   157: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   160: aload_1
    //   161: invokeinterface exists : (Ljava/io/File;)Z
    //   166: ifeq -> 235
    //   169: aload_3
    //   170: invokestatic access$1700 : (Lokhttp3/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   173: iload #4
    //   175: aaload
    //   176: astore #5
    //   178: aload_0
    //   179: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   182: aload_1
    //   183: aload #5
    //   185: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   190: aload_3
    //   191: invokestatic access$1600 : (Lokhttp3/internal/DiskLruCache$Entry;)[J
    //   194: iload #4
    //   196: laload
    //   197: lstore #6
    //   199: aload_0
    //   200: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   203: aload #5
    //   205: invokeinterface size : (Ljava/io/File;)J
    //   210: lstore #8
    //   212: aload_3
    //   213: invokestatic access$1600 : (Lokhttp3/internal/DiskLruCache$Entry;)[J
    //   216: iload #4
    //   218: lload #8
    //   220: lastore
    //   221: aload_0
    //   222: aload_0
    //   223: getfield size : J
    //   226: lload #6
    //   228: lsub
    //   229: lload #8
    //   231: ladd
    //   232: putfield size : J
    //   235: iinc #4, 1
    //   238: goto -> 135
    //   241: aload_0
    //   242: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   245: aload_1
    //   246: invokeinterface delete : (Ljava/io/File;)V
    //   251: goto -> 235
    //   254: aload_0
    //   255: aload_0
    //   256: getfield redundantOpCount : I
    //   259: iconst_1
    //   260: iadd
    //   261: putfield redundantOpCount : I
    //   264: aload_3
    //   265: aconst_null
    //   266: invokestatic access$1302 : (Lokhttp3/internal/DiskLruCache$Entry;Lokhttp3/internal/DiskLruCache$Editor;)Lokhttp3/internal/DiskLruCache$Editor;
    //   269: pop
    //   270: aload_3
    //   271: invokestatic access$1200 : (Lokhttp3/internal/DiskLruCache$Entry;)Z
    //   274: iload_2
    //   275: ior
    //   276: ifeq -> 407
    //   279: aload_3
    //   280: iconst_1
    //   281: invokestatic access$1202 : (Lokhttp3/internal/DiskLruCache$Entry;Z)Z
    //   284: pop
    //   285: aload_0
    //   286: getfield journalWriter : Lokio/BufferedSink;
    //   289: ldc 'CLEAN'
    //   291: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   296: bipush #32
    //   298: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   303: pop
    //   304: aload_0
    //   305: getfield journalWriter : Lokio/BufferedSink;
    //   308: aload_3
    //   309: invokestatic access$1900 : (Lokhttp3/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   312: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   317: pop
    //   318: aload_3
    //   319: aload_0
    //   320: getfield journalWriter : Lokio/BufferedSink;
    //   323: invokevirtual writeLengths : (Lokio/BufferedSink;)V
    //   326: aload_0
    //   327: getfield journalWriter : Lokio/BufferedSink;
    //   330: bipush #10
    //   332: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   337: pop
    //   338: iload_2
    //   339: ifeq -> 363
    //   342: aload_0
    //   343: getfield nextSequenceNumber : J
    //   346: lstore #8
    //   348: aload_0
    //   349: lconst_1
    //   350: lload #8
    //   352: ladd
    //   353: putfield nextSequenceNumber : J
    //   356: aload_3
    //   357: lload #8
    //   359: invokestatic access$2002 : (Lokhttp3/internal/DiskLruCache$Entry;J)J
    //   362: pop2
    //   363: aload_0
    //   364: getfield journalWriter : Lokio/BufferedSink;
    //   367: invokeinterface flush : ()V
    //   372: aload_0
    //   373: getfield size : J
    //   376: aload_0
    //   377: getfield maxSize : J
    //   380: lcmp
    //   381: ifgt -> 391
    //   384: aload_0
    //   385: invokespecial journalRebuildRequired : ()Z
    //   388: ifeq -> 123
    //   391: aload_0
    //   392: getfield executor : Ljava/util/concurrent/Executor;
    //   395: aload_0
    //   396: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   399: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   404: goto -> 123
    //   407: aload_0
    //   408: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   411: aload_3
    //   412: invokestatic access$1900 : (Lokhttp3/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   415: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: aload_0
    //   420: getfield journalWriter : Lokio/BufferedSink;
    //   423: ldc 'REMOVE'
    //   425: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   430: bipush #32
    //   432: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   437: pop
    //   438: aload_0
    //   439: getfield journalWriter : Lokio/BufferedSink;
    //   442: aload_3
    //   443: invokestatic access$1900 : (Lokhttp3/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   446: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   451: pop
    //   452: aload_0
    //   453: getfield journalWriter : Lokio/BufferedSink;
    //   456: bipush #10
    //   458: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   463: pop
    //   464: goto -> 363
    // Exception table:
    //   from	to	target	type
    //   2	25	25	finally
    //   34	41	25	finally
    //   44	100	25	finally
    //   100	123	25	finally
    //   135	152	25	finally
    //   156	235	25	finally
    //   241	251	25	finally
    //   254	338	25	finally
    //   342	363	25	finally
    //   363	391	25	finally
    //   391	404	25	finally
    //   407	464	25	finally
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong) {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0"); 
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0"); 
    return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }
  
  private Editor edit(String paramString, long paramLong) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual initialize : ()V
    //   9: aload_0
    //   10: invokespecial checkNotClosed : ()V
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial validateKey : (Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   22: aload_1
    //   23: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast okhttp3/internal/DiskLruCache$Entry
    //   29: astore #5
    //   31: lload_2
    //   32: ldc2_w -1
    //   35: lcmp
    //   36: ifeq -> 71
    //   39: aload #4
    //   41: astore #6
    //   43: aload #5
    //   45: ifnull -> 66
    //   48: aload #5
    //   50: invokestatic access$2000 : (Lokhttp3/internal/DiskLruCache$Entry;)J
    //   53: lstore #7
    //   55: lload #7
    //   57: lload_2
    //   58: lcmp
    //   59: ifeq -> 71
    //   62: aload #4
    //   64: astore #6
    //   66: aload_0
    //   67: monitorexit
    //   68: aload #6
    //   70: areturn
    //   71: aload #5
    //   73: ifnull -> 88
    //   76: aload #4
    //   78: astore #6
    //   80: aload #5
    //   82: invokestatic access$1300 : (Lokhttp3/internal/DiskLruCache$Entry;)Lokhttp3/internal/DiskLruCache$Editor;
    //   85: ifnonnull -> 66
    //   88: aload_0
    //   89: getfield mostRecentTrimFailed : Z
    //   92: ifne -> 102
    //   95: aload_0
    //   96: getfield mostRecentRebuildFailed : Z
    //   99: ifeq -> 127
    //   102: aload_0
    //   103: getfield executor : Ljava/util/concurrent/Executor;
    //   106: aload_0
    //   107: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   110: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   115: aload #4
    //   117: astore #6
    //   119: goto -> 66
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: aload_0
    //   128: getfield journalWriter : Lokio/BufferedSink;
    //   131: ldc 'DIRTY'
    //   133: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   138: bipush #32
    //   140: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   145: aload_1
    //   146: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   151: bipush #10
    //   153: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   158: pop
    //   159: aload_0
    //   160: getfield journalWriter : Lokio/BufferedSink;
    //   163: invokeinterface flush : ()V
    //   168: aload #4
    //   170: astore #6
    //   172: aload_0
    //   173: getfield hasJournalErrors : Z
    //   176: ifne -> 66
    //   179: aload #5
    //   181: astore #6
    //   183: aload #5
    //   185: ifnonnull -> 212
    //   188: new okhttp3/internal/DiskLruCache$Entry
    //   191: astore #6
    //   193: aload #6
    //   195: aload_0
    //   196: aload_1
    //   197: aconst_null
    //   198: invokespecial <init> : (Lokhttp3/internal/DiskLruCache;Ljava/lang/String;Lokhttp3/internal/DiskLruCache$1;)V
    //   201: aload_0
    //   202: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   205: aload_1
    //   206: aload #6
    //   208: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: new okhttp3/internal/DiskLruCache$Editor
    //   215: astore_1
    //   216: aload_1
    //   217: aload_0
    //   218: aload #6
    //   220: aconst_null
    //   221: invokespecial <init> : (Lokhttp3/internal/DiskLruCache;Lokhttp3/internal/DiskLruCache$Entry;Lokhttp3/internal/DiskLruCache$1;)V
    //   224: aload #6
    //   226: aload_1
    //   227: invokestatic access$1302 : (Lokhttp3/internal/DiskLruCache$Entry;Lokhttp3/internal/DiskLruCache$Editor;)Lokhttp3/internal/DiskLruCache$Editor;
    //   230: pop
    //   231: aload_1
    //   232: astore #6
    //   234: goto -> 66
    // Exception table:
    //   from	to	target	type
    //   5	31	122	finally
    //   48	55	122	finally
    //   80	88	122	finally
    //   88	102	122	finally
    //   102	115	122	finally
    //   127	168	122	finally
    //   172	179	122	finally
    //   188	212	122	finally
    //   212	231	122	finally
  }
  
  private boolean journalRebuildRequired() {
    return (this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size());
  }
  
  private BufferedSink newJournalWriter() throws FileNotFoundException {
    return Okio.buffer((Sink)new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
          static {
            boolean bool;
            if (!DiskLruCache.class.desiredAssertionStatus()) {
              bool = true;
            } else {
              bool = false;
            } 
            $assertionsDisabled = bool;
          }
          
          protected void onException(IOException param1IOException) {
            assert Thread.holdsLock(DiskLruCache.this);
            DiskLruCache.access$1002(DiskLruCache.this, true);
          }
        });
  }
  
  private void processJournal() throws IOException {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator<Entry> iterator = this.lruEntries.values().iterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      if (entry.currentEditor == null) {
        for (byte b1 = 0; b1 < this.valueCount; b1++)
          this.size += entry.lengths[b1]; 
        continue;
      } 
      Entry.access$1302(entry, null);
      for (byte b = 0; b < this.valueCount; b++) {
        this.fileSystem.delete(entry.cleanFiles[b]);
        this.fileSystem.delete(entry.dirtyFiles[b]);
      } 
      iterator.remove();
    } 
  }
  
  private void readJournal() throws IOException {
    BufferedSource bufferedSource = Okio.buffer(this.fileSystem.source(this.journalFile));
    try {
      String str1 = bufferedSource.readUtf8LineStrict();
      String str2 = bufferedSource.readUtf8LineStrict();
      String str3 = bufferedSource.readUtf8LineStrict();
      String str4 = bufferedSource.readUtf8LineStrict();
      String str5 = bufferedSource.readUtf8LineStrict();
    } finally {
      Util.closeQuietly((Closeable)bufferedSource);
    } 
    byte b = 0;
    try {
      while (true) {
        readJournalLine(bufferedSource.readUtf8LineStrict());
        b++;
      } 
    } catch (EOFException eOFException) {
      this.redundantOpCount = b - this.lruEntries.size();
      if (!bufferedSource.exhausted()) {
        rebuildJournal();
      } else {
        this.journalWriter = newJournalWriter();
      } 
      Util.closeQuietly((Closeable)bufferedSource);
      return;
    } 
  }
  
  private void readJournalLine(String paramString) throws IOException {
    String[] arrayOfString;
    String str;
    int i = paramString.indexOf(' ');
    if (i == -1)
      throw new IOException("unexpected journal line: " + paramString); 
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    if (k == -1) {
      String str1 = paramString.substring(j);
      str = str1;
      if (i == "REMOVE".length()) {
        str = str1;
        if (paramString.startsWith("REMOVE")) {
          this.lruEntries.remove(str1);
          return;
        } 
      } 
    } else {
      str = paramString.substring(j, k);
    } 
    Entry entry2 = this.lruEntries.get(str);
    Entry entry1 = entry2;
    if (entry2 == null) {
      entry1 = new Entry(str);
      this.lruEntries.put(str, entry1);
    } 
    if (k != -1 && i == "CLEAN".length() && paramString.startsWith("CLEAN")) {
      arrayOfString = paramString.substring(k + 1).split(" ");
      Entry.access$1202(entry1, true);
      Entry.access$1302(entry1, null);
      entry1.setLengths(arrayOfString);
      return;
    } 
    if (k == -1 && i == "DIRTY".length() && arrayOfString.startsWith("DIRTY")) {
      Entry.access$1302(entry1, new Editor(entry1));
      return;
    } 
    if (k != -1 || i != "READ".length() || !arrayOfString.startsWith("READ"))
      throw new IOException("unexpected journal line: " + arrayOfString); 
  }
  
  private void rebuildJournal() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield journalWriter : Lokio/BufferedSink;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield journalWriter : Lokio/BufferedSink;
    //   13: invokeinterface close : ()V
    //   18: aload_0
    //   19: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   22: aload_0
    //   23: getfield journalFileTmp : Ljava/io/File;
    //   26: invokeinterface sink : (Ljava/io/File;)Lokio/Sink;
    //   31: invokestatic buffer : (Lokio/Sink;)Lokio/BufferedSink;
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 'libcore.io.DiskLruCache'
    //   38: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   43: bipush #10
    //   45: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   50: pop
    //   51: aload_1
    //   52: ldc '1'
    //   54: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   59: bipush #10
    //   61: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: getfield appVersion : I
    //   72: i2l
    //   73: invokeinterface writeDecimalLong : (J)Lokio/BufferedSink;
    //   78: bipush #10
    //   80: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   85: pop
    //   86: aload_1
    //   87: aload_0
    //   88: getfield valueCount : I
    //   91: i2l
    //   92: invokeinterface writeDecimalLong : (J)Lokio/BufferedSink;
    //   97: bipush #10
    //   99: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   104: pop
    //   105: aload_1
    //   106: bipush #10
    //   108: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   113: pop
    //   114: aload_0
    //   115: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   118: invokevirtual values : ()Ljava/util/Collection;
    //   121: invokeinterface iterator : ()Ljava/util/Iterator;
    //   126: astore_2
    //   127: aload_2
    //   128: invokeinterface hasNext : ()Z
    //   133: ifeq -> 250
    //   136: aload_2
    //   137: invokeinterface next : ()Ljava/lang/Object;
    //   142: checkcast okhttp3/internal/DiskLruCache$Entry
    //   145: astore_3
    //   146: aload_3
    //   147: invokestatic access$1300 : (Lokhttp3/internal/DiskLruCache$Entry;)Lokhttp3/internal/DiskLruCache$Editor;
    //   150: ifnull -> 206
    //   153: aload_1
    //   154: ldc 'DIRTY'
    //   156: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   161: bipush #32
    //   163: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   168: pop
    //   169: aload_1
    //   170: aload_3
    //   171: invokestatic access$1900 : (Lokhttp3/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   174: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   179: pop
    //   180: aload_1
    //   181: bipush #10
    //   183: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   188: pop
    //   189: goto -> 127
    //   192: astore_2
    //   193: aload_1
    //   194: invokeinterface close : ()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: aload_1
    //   207: ldc 'CLEAN'
    //   209: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   214: bipush #32
    //   216: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   221: pop
    //   222: aload_1
    //   223: aload_3
    //   224: invokestatic access$1900 : (Lokhttp3/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   227: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   232: pop
    //   233: aload_3
    //   234: aload_1
    //   235: invokevirtual writeLengths : (Lokio/BufferedSink;)V
    //   238: aload_1
    //   239: bipush #10
    //   241: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   246: pop
    //   247: goto -> 127
    //   250: aload_1
    //   251: invokeinterface close : ()V
    //   256: aload_0
    //   257: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   260: aload_0
    //   261: getfield journalFile : Ljava/io/File;
    //   264: invokeinterface exists : (Ljava/io/File;)Z
    //   269: ifeq -> 289
    //   272: aload_0
    //   273: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   276: aload_0
    //   277: getfield journalFile : Ljava/io/File;
    //   280: aload_0
    //   281: getfield journalFileBackup : Ljava/io/File;
    //   284: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   289: aload_0
    //   290: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   293: aload_0
    //   294: getfield journalFileTmp : Ljava/io/File;
    //   297: aload_0
    //   298: getfield journalFile : Ljava/io/File;
    //   301: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   306: aload_0
    //   307: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   310: aload_0
    //   311: getfield journalFileBackup : Ljava/io/File;
    //   314: invokeinterface delete : (Ljava/io/File;)V
    //   319: aload_0
    //   320: aload_0
    //   321: invokespecial newJournalWriter : ()Lokio/BufferedSink;
    //   324: putfield journalWriter : Lokio/BufferedSink;
    //   327: aload_0
    //   328: iconst_0
    //   329: putfield hasJournalErrors : Z
    //   332: aload_0
    //   333: iconst_0
    //   334: putfield mostRecentRebuildFailed : Z
    //   337: aload_0
    //   338: monitorexit
    //   339: return
    // Exception table:
    //   from	to	target	type
    //   2	18	201	finally
    //   18	35	201	finally
    //   35	127	192	finally
    //   127	189	192	finally
    //   193	201	201	finally
    //   206	247	192	finally
    //   250	289	201	finally
    //   289	337	201	finally
  }
  
  private boolean removeEntry(Entry paramEntry) throws IOException {
    if (paramEntry.currentEditor != null)
      paramEntry.currentEditor.detach(); 
    for (byte b = 0; b < this.valueCount; b++) {
      this.fileSystem.delete(paramEntry.cleanFiles[b]);
      this.size -= paramEntry.lengths[b];
      paramEntry.lengths[b] = 0L;
    } 
    this.redundantOpCount++;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired())
      this.executor.execute(this.cleanupRunnable); 
    return true;
  }
  
  private void trimToSize() throws IOException {
    while (this.size > this.maxSize)
      removeEntry(this.lruEntries.values().iterator().next()); 
    this.mostRecentTrimFailed = false;
  }
  
  private void validateKey(String paramString) {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\""); 
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: ifeq -> 16
    //   9: aload_0
    //   10: getfield closed : Z
    //   13: ifeq -> 24
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield closed : Z
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   28: invokevirtual values : ()Ljava/util/Collection;
    //   31: aload_0
    //   32: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   35: invokevirtual size : ()I
    //   38: anewarray okhttp3/internal/DiskLruCache$Entry
    //   41: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   46: checkcast [Lokhttp3/internal/DiskLruCache$Entry;
    //   49: astore_1
    //   50: aload_1
    //   51: arraylength
    //   52: istore_2
    //   53: iconst_0
    //   54: istore_3
    //   55: iload_3
    //   56: iload_2
    //   57: if_icmpge -> 87
    //   60: aload_1
    //   61: iload_3
    //   62: aaload
    //   63: astore #4
    //   65: aload #4
    //   67: invokestatic access$1300 : (Lokhttp3/internal/DiskLruCache$Entry;)Lokhttp3/internal/DiskLruCache$Editor;
    //   70: ifnull -> 81
    //   73: aload #4
    //   75: invokestatic access$1300 : (Lokhttp3/internal/DiskLruCache$Entry;)Lokhttp3/internal/DiskLruCache$Editor;
    //   78: invokevirtual abort : ()V
    //   81: iinc #3, 1
    //   84: goto -> 55
    //   87: aload_0
    //   88: invokespecial trimToSize : ()V
    //   91: aload_0
    //   92: getfield journalWriter : Lokio/BufferedSink;
    //   95: invokeinterface close : ()V
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield journalWriter : Lokio/BufferedSink;
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield closed : Z
    //   110: goto -> 21
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	113	finally
    //   16	21	113	finally
    //   24	53	113	finally
    //   65	81	113	finally
    //   87	110	113	finally
  }
  
  public void delete() throws IOException {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  public Editor edit(String paramString) throws IOException {
    return edit(paramString, -1L);
  }
  
  public void evictAll() throws IOException {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual initialize : ()V
    //   8: aload_0
    //   9: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   12: invokevirtual values : ()Ljava/util/Collection;
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: invokevirtual size : ()I
    //   22: anewarray okhttp3/internal/DiskLruCache$Entry
    //   25: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   30: checkcast [Lokhttp3/internal/DiskLruCache$Entry;
    //   33: astore_2
    //   34: aload_2
    //   35: arraylength
    //   36: istore_3
    //   37: iload_1
    //   38: iload_3
    //   39: if_icmpge -> 56
    //   42: aload_0
    //   43: aload_2
    //   44: iload_1
    //   45: aaload
    //   46: invokespecial removeEntry : (Lokhttp3/internal/DiskLruCache$Entry;)Z
    //   49: pop
    //   50: iinc #1, 1
    //   53: goto -> 37
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield mostRecentTrimFailed : Z
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   4	37	64	finally
    //   42	50	64	finally
    //   56	61	64	finally
  }
  
  public void flush() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial checkNotClosed : ()V
    //   18: aload_0
    //   19: invokespecial trimToSize : ()V
    //   22: aload_0
    //   23: getfield journalWriter : Lokio/BufferedSink;
    //   26: invokeinterface flush : ()V
    //   31: goto -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public Snapshot get(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast okhttp3/internal/DiskLruCache$Entry
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull -> 40
    //   31: aload_2
    //   32: invokestatic access$1200 : (Lokhttp3/internal/DiskLruCache$Entry;)Z
    //   35: istore_3
    //   36: iload_3
    //   37: ifne -> 46
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: invokevirtual snapshot : ()Lokhttp3/internal/DiskLruCache$Snapshot;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull -> 60
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -> 42
    //   60: aload_0
    //   61: aload_0
    //   62: getfield redundantOpCount : I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield redundantOpCount : I
    //   70: aload_0
    //   71: getfield journalWriter : Lokio/BufferedSink;
    //   74: ldc 'READ'
    //   76: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   81: bipush #32
    //   83: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   88: aload_1
    //   89: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   94: bipush #10
    //   96: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   101: pop
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: invokespecial journalRebuildRequired : ()Z
    //   108: ifeq -> 42
    //   111: aload_0
    //   112: getfield executor : Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   119: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   124: aload_2
    //   125: astore_1
    //   126: goto -> 42
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	129	finally
    //   31	36	129	finally
    //   46	51	129	finally
    //   60	102	129	finally
    //   104	124	129	finally
  }
  
  public File getDirectory() {
    return this.directory;
  }
  
  public long getMaxSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxSize : J
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
  
  public void initialize() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic okhttp3/internal/DiskLruCache.$assertionsDisabled : Z
    //   5: ifne -> 30
    //   8: aload_0
    //   9: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   12: ifne -> 30
    //   15: new java/lang/AssertionError
    //   18: astore_1
    //   19: aload_1
    //   20: invokespecial <init> : ()V
    //   23: aload_1
    //   24: athrow
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: getfield initialized : Z
    //   34: istore_2
    //   35: iload_2
    //   36: ifeq -> 42
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   46: aload_0
    //   47: getfield journalFileBackup : Ljava/io/File;
    //   50: invokeinterface exists : (Ljava/io/File;)Z
    //   55: ifeq -> 87
    //   58: aload_0
    //   59: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   62: aload_0
    //   63: getfield journalFile : Ljava/io/File;
    //   66: invokeinterface exists : (Ljava/io/File;)Z
    //   71: ifeq -> 199
    //   74: aload_0
    //   75: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   78: aload_0
    //   79: getfield journalFileBackup : Ljava/io/File;
    //   82: invokeinterface delete : (Ljava/io/File;)V
    //   87: aload_0
    //   88: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   91: aload_0
    //   92: getfield journalFile : Ljava/io/File;
    //   95: invokeinterface exists : (Ljava/io/File;)Z
    //   100: istore_2
    //   101: iload_2
    //   102: ifeq -> 187
    //   105: aload_0
    //   106: invokespecial readJournal : ()V
    //   109: aload_0
    //   110: invokespecial processJournal : ()V
    //   113: aload_0
    //   114: iconst_1
    //   115: putfield initialized : Z
    //   118: goto -> 39
    //   121: astore_3
    //   122: invokestatic get : ()Lokhttp3/internal/Platform;
    //   125: astore #4
    //   127: new java/lang/StringBuilder
    //   130: astore_1
    //   131: aload_1
    //   132: invokespecial <init> : ()V
    //   135: aload #4
    //   137: iconst_5
    //   138: aload_1
    //   139: ldc_w 'DiskLruCache '
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield directory : Ljava/io/File;
    //   149: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: ldc_w ' is corrupt: '
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: invokevirtual getMessage : ()Ljava/lang/String;
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w ', removing'
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: aload_3
    //   175: invokevirtual log : (ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: aload_0
    //   179: invokevirtual delete : ()V
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield closed : Z
    //   187: aload_0
    //   188: invokespecial rebuildJournal : ()V
    //   191: aload_0
    //   192: iconst_1
    //   193: putfield initialized : Z
    //   196: goto -> 39
    //   199: aload_0
    //   200: getfield fileSystem : Lokhttp3/internal/io/FileSystem;
    //   203: aload_0
    //   204: getfield journalFileBackup : Ljava/io/File;
    //   207: aload_0
    //   208: getfield journalFile : Ljava/io/File;
    //   211: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   216: goto -> 87
    // Exception table:
    //   from	to	target	type
    //   2	25	25	finally
    //   30	35	25	finally
    //   42	87	25	finally
    //   87	101	25	finally
    //   105	118	121	java/io/IOException
    //   105	118	25	finally
    //   122	187	25	finally
    //   187	196	25	finally
    //   199	216	25	finally
  }
  
  public boolean isClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield closed : Z
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
    //   2	7	11	finally
  }
  
  public boolean remove(String paramString) throws IOException {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual initialize : ()V
    //   8: aload_0
    //   9: invokespecial checkNotClosed : ()V
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial validateKey : (Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   21: aload_1
    //   22: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast okhttp3/internal/DiskLruCache$Entry
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial removeEntry : (Lokhttp3/internal/DiskLruCache$Entry;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: iload_3
    //   46: ifeq -> 33
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield size : J
    //   55: aload_0
    //   56: getfield maxSize : J
    //   59: lcmp
    //   60: ifgt -> 33
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield mostRecentTrimFailed : Z
    //   68: iload_3
    //   69: istore_2
    //   70: goto -> 33
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Exception table:
    //   from	to	target	type
    //   4	29	73	finally
    //   37	43	73	finally
    //   51	68	73	finally
  }
  
  public void setMaxSize(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: putfield maxSize : J
    //   7: aload_0
    //   8: getfield initialized : Z
    //   11: ifeq -> 27
    //   14: aload_0
    //   15: getfield executor : Ljava/util/concurrent/Executor;
    //   18: aload_0
    //   19: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   22: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
  
  public long size() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: getfield size : J
    //   10: lstore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: lload_1
    //   14: lreturn
    //   15: astore_3
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_3
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public Iterator<Snapshot> snapshots() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: new okhttp3/internal/DiskLruCache$3
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lokhttp3/internal/DiskLruCache;)V
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	19	finally
  }
  
  static {
    boolean bool;
    if (!DiskLruCache.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    $assertionsDisabled = bool;
  }
  
  public final class Editor {
    private boolean done;
    
    private final DiskLruCache.Entry entry;
    
    private final boolean[] written;
    
    private Editor(DiskLruCache.Entry param1Entry) {
      boolean[] arrayOfBoolean;
      this.entry = param1Entry;
      if (param1Entry.readable) {
        DiskLruCache.this = null;
      } else {
        arrayOfBoolean = new boolean[DiskLruCache.this.valueCount];
      } 
      this.written = arrayOfBoolean;
    }
    
    public void abort() throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.done) {
          IllegalStateException illegalStateException = new IllegalStateException();
          this();
          throw illegalStateException;
        } 
      } 
      if (this.entry.currentEditor == this)
        DiskLruCache.this.completeEdit(this, false); 
      this.done = true;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_1} */
    }
    
    public void abortUnlessCommitted() {
      synchronized (DiskLruCache.this) {
        if (!this.done) {
          Editor editor = this.entry.currentEditor;
          if (editor == this)
            try {
              DiskLruCache.this.completeEdit(this, false);
            } catch (IOException iOException) {} 
        } 
        return;
      } 
    }
    
    public void commit() throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.done) {
          IllegalStateException illegalStateException = new IllegalStateException();
          this();
          throw illegalStateException;
        } 
      } 
      if (this.entry.currentEditor == this)
        DiskLruCache.this.completeEdit(this, true); 
      this.done = true;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_1} */
    }
    
    void detach() {
      if (this.entry.currentEditor == this) {
        byte b = 0;
        while (true) {
          if (b < DiskLruCache.this.valueCount) {
            try {
              DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[b]);
            } catch (IOException iOException) {}
            b++;
            continue;
          } 
          DiskLruCache.Entry.access$1302(this.entry, null);
          return;
        } 
      } 
    }
    
    public Sink newSink(int param1Int) throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.done) {
          IllegalStateException illegalStateException = new IllegalStateException();
          this();
          throw illegalStateException;
        } 
      } 
      if (this.entry.currentEditor != this) {
        Sink sink = DiskLruCache.NULL_SINK;
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
        return sink;
      } 
      if (!this.entry.readable)
        this.written[param1Int] = true; 
      File file = this.entry.dirtyFiles[param1Int];
      try {
        Sink sink = DiskLruCache.this.fileSystem.sink(file);
        FaultHidingSink faultHidingSink = new FaultHidingSink() {
            protected void onException(IOException param2IOException) {
              synchronized (DiskLruCache.this) {
                DiskLruCache.Editor.this.detach();
                return;
              } 
            }
          };
        super(this, sink);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
      } catch (FileNotFoundException fileNotFoundException) {}
      return (Sink)fileNotFoundException;
    }
    
    public Source newSource(int param1Int) throws IOException {
      Source source;
      null = null;
      synchronized (DiskLruCache.this) {
        if (this.done) {
          null = new IllegalStateException();
          this();
          throw null;
        } 
      } 
      if (!this.entry.readable || this.entry.currentEditor != this) {
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
        return (Source)SYNTHETIC_LOCAL_VARIABLE_2;
      } 
      try {
        Source source1 = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[param1Int]);
        source = source1;
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
      } catch (FileNotFoundException fileNotFoundException) {}
      return source;
    }
  }
  
  class null extends FaultHidingSink {
    null(Sink param1Sink) {
      super(param1Sink);
    }
    
    protected void onException(IOException param1IOException) {
      synchronized (DiskLruCache.this) {
        this.this$1.detach();
        return;
      } 
    }
  }
  
  private final class Entry {
    private final File[] cleanFiles;
    
    private DiskLruCache.Editor currentEditor;
    
    private final File[] dirtyFiles;
    
    private final String key;
    
    private final long[] lengths;
    
    private boolean readable;
    
    private long sequenceNumber;
    
    private Entry(String param1String) {
      this.key = param1String;
      this.lengths = new long[DiskLruCache.this.valueCount];
      this.cleanFiles = new File[DiskLruCache.this.valueCount];
      this.dirtyFiles = new File[DiskLruCache.this.valueCount];
      StringBuilder stringBuilder = (new StringBuilder(param1String)).append('.');
      int i = stringBuilder.length();
      for (byte b = 0; b < DiskLruCache.this.valueCount; b++) {
        stringBuilder.append(b);
        this.cleanFiles[b] = new File(DiskLruCache.this.directory, stringBuilder.toString());
        stringBuilder.append(".tmp");
        this.dirtyFiles[b] = new File(DiskLruCache.this.directory, stringBuilder.toString());
        stringBuilder.setLength(i);
      } 
    }
    
    private IOException invalidLengths(String[] param1ArrayOfString) throws IOException {
      throw new IOException("unexpected journal line: " + Arrays.toString(param1ArrayOfString));
    }
    
    private void setLengths(String[] param1ArrayOfString) throws IOException {
      if (param1ArrayOfString.length != DiskLruCache.this.valueCount)
        throw invalidLengths(param1ArrayOfString); 
      byte b = 0;
      try {
        while (b < param1ArrayOfString.length) {
          this.lengths[b] = Long.parseLong(param1ArrayOfString[b]);
          b++;
        } 
      } catch (NumberFormatException numberFormatException) {
        throw invalidLengths(param1ArrayOfString);
      } 
    }
    
    DiskLruCache.Snapshot snapshot() {
      if (!Thread.holdsLock(DiskLruCache.this))
        throw new AssertionError(); 
      Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
      long[] arrayOfLong = (long[])this.lengths.clone();
      byte b = 0;
      try {
        while (b < DiskLruCache.this.valueCount) {
          arrayOfSource[b] = DiskLruCache.this.fileSystem.source(this.cleanFiles[b]);
          b++;
        } 
        DiskLruCache.Snapshot snapshot = new DiskLruCache.Snapshot(this.key, this.sequenceNumber, arrayOfSource, arrayOfLong);
      } catch (FileNotFoundException fileNotFoundException) {
        b = 0;
      } 
      return (DiskLruCache.Snapshot)fileNotFoundException;
    }
    
    void writeLengths(BufferedSink param1BufferedSink) throws IOException {
      for (long l : this.lengths)
        param1BufferedSink.writeByte(32).writeDecimalLong(l); 
    }
  }
  
  public final class Snapshot implements Closeable {
    private final String key;
    
    private final long[] lengths;
    
    private final long sequenceNumber;
    
    private final Source[] sources;
    
    private Snapshot(String param1String, long param1Long, Source[] param1ArrayOfSource, long[] param1ArrayOflong) {
      this.key = param1String;
      this.sequenceNumber = param1Long;
      this.sources = param1ArrayOfSource;
      this.lengths = param1ArrayOflong;
    }
    
    public void close() {
      Source[] arrayOfSource = this.sources;
      int i = arrayOfSource.length;
      for (byte b = 0; b < i; b++)
        Util.closeQuietly((Closeable)arrayOfSource[b]); 
    }
    
    public DiskLruCache.Editor edit() throws IOException {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(int param1Int) {
      return this.lengths[param1Int];
    }
    
    public Source getSource(int param1Int) {
      return this.sources[param1Int];
    }
    
    public String key() {
      return this.key;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
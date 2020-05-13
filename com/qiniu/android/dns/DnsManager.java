package com.qiniu.android.dns;

import com.qiniu.android.dns.local.Hosts;
import com.qiniu.android.dns.util.LruCache;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class DnsManager {
  private final LruCache<String, Record[]> cache;
  
  private final Hosts hosts = new Hosts();
  
  private volatile int index = 0;
  
  private volatile NetworkInfo info = null;
  
  private final IResolver[] resolvers;
  
  private final IpSorter sorter;
  
  public DnsManager(NetworkInfo paramNetworkInfo, IResolver[] paramArrayOfIResolver) {
    this(paramNetworkInfo, paramArrayOfIResolver, null);
  }
  
  public DnsManager(NetworkInfo paramNetworkInfo, IResolver[] paramArrayOfIResolver, IpSorter paramIpSorter) {
    NetworkInfo networkInfo = paramNetworkInfo;
    if (paramNetworkInfo == null)
      networkInfo = NetworkInfo.normal; 
    this.info = networkInfo;
    this.resolvers = (IResolver[])paramArrayOfIResolver.clone();
    this.cache = new LruCache();
    IpSorter ipSorter = paramIpSorter;
    if (paramIpSorter == null)
      ipSorter = new DummySorter(); 
    this.sorter = ipSorter;
  }
  
  private void clearCache() {
    synchronized (this.cache) {
      this.cache.clear();
      return;
    } 
  }
  
  private String[] queryInternal(Domain paramDomain) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: getfield hostsFirst : Z
    //   4: ifeq -> 31
    //   7: aload_0
    //   8: getfield hosts : Lcom/qiniu/android/dns/local/Hosts;
    //   11: aload_1
    //   12: aload_0
    //   13: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   16: invokevirtual query : (Lcom/qiniu/android/dns/Domain;Lcom/qiniu/android/dns/NetworkInfo;)[Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull -> 31
    //   24: aload_2
    //   25: arraylength
    //   26: ifeq -> 31
    //   29: aload_2
    //   30: areturn
    //   31: aload_0
    //   32: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   35: astore_3
    //   36: aload_3
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   42: getstatic com/qiniu/android/dns/NetworkInfo.normal : Lcom/qiniu/android/dns/NetworkInfo;
    //   45: invokevirtual equals : (Ljava/lang/Object;)Z
    //   48: ifeq -> 88
    //   51: invokestatic isNetworkChanged : ()Z
    //   54: ifeq -> 88
    //   57: aload_0
    //   58: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   61: invokevirtual clear : ()V
    //   64: aload_0
    //   65: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   68: astore_2
    //   69: aload_2
    //   70: monitorenter
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield index : I
    //   76: aload_2
    //   77: monitorexit
    //   78: aconst_null
    //   79: astore_2
    //   80: goto -> 153
    //   83: astore_1
    //   84: aload_2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: aload_0
    //   89: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   92: aload_1
    //   93: getfield domain : Ljava/lang/String;
    //   96: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   99: checkcast [Lcom/qiniu/android/dns/Record;
    //   102: astore #4
    //   104: aload #4
    //   106: astore_2
    //   107: aload #4
    //   109: ifnull -> 153
    //   112: aload #4
    //   114: astore_2
    //   115: aload #4
    //   117: arraylength
    //   118: ifeq -> 153
    //   121: aload #4
    //   123: iconst_0
    //   124: aaload
    //   125: invokevirtual isExpired : ()Z
    //   128: ifne -> 78
    //   131: aload #4
    //   133: arraylength
    //   134: iconst_1
    //   135: if_icmple -> 143
    //   138: aload #4
    //   140: invokestatic rotate : ([Lcom/qiniu/android/dns/Record;)V
    //   143: aload #4
    //   145: invokestatic records2Ip : ([Lcom/qiniu/android/dns/Record;)[Ljava/lang/String;
    //   148: astore_1
    //   149: aload_3
    //   150: monitorexit
    //   151: aload_1
    //   152: areturn
    //   153: aload_3
    //   154: monitorexit
    //   155: aload_0
    //   156: getfield index : I
    //   159: istore #5
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_2
    //   164: astore #4
    //   166: iconst_0
    //   167: istore #6
    //   169: aload_3
    //   170: astore_2
    //   171: aload #4
    //   173: astore #7
    //   175: aload_2
    //   176: astore_3
    //   177: iload #6
    //   179: aload_0
    //   180: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   183: arraylength
    //   184: if_icmpge -> 352
    //   187: aload_0
    //   188: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   191: arraylength
    //   192: istore #8
    //   194: aload_0
    //   195: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   198: astore #9
    //   200: invokestatic getIp : ()Ljava/lang/String;
    //   203: astore #10
    //   205: aload_0
    //   206: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   209: iload #5
    //   211: iload #6
    //   213: iadd
    //   214: iload #8
    //   216: irem
    //   217: aaload
    //   218: aload_1
    //   219: aload_0
    //   220: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   223: invokeinterface resolve : (Lcom/qiniu/android/dns/Domain;Lcom/qiniu/android/dns/NetworkInfo;)[Lcom/qiniu/android/dns/Record;
    //   228: astore_3
    //   229: aload_3
    //   230: astore #4
    //   232: goto -> 240
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual printStackTrace : ()V
    //   240: invokestatic getIp : ()Ljava/lang/String;
    //   243: astore #11
    //   245: aload #4
    //   247: astore #7
    //   249: aload_2
    //   250: astore_3
    //   251: aload_0
    //   252: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   255: aload #9
    //   257: if_acmpne -> 352
    //   260: aload #4
    //   262: ifnull -> 277
    //   265: aload #4
    //   267: astore #7
    //   269: aload_2
    //   270: astore_3
    //   271: aload #4
    //   273: arraylength
    //   274: ifne -> 352
    //   277: aload #4
    //   279: astore #7
    //   281: aload_2
    //   282: astore_3
    //   283: aload #10
    //   285: aload #11
    //   287: invokevirtual equals : (Ljava/lang/Object;)Z
    //   290: ifeq -> 352
    //   293: aload_0
    //   294: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   297: astore_3
    //   298: aload_3
    //   299: monitorenter
    //   300: aload_0
    //   301: getfield index : I
    //   304: iload #5
    //   306: if_icmpne -> 336
    //   309: aload_0
    //   310: aload_0
    //   311: getfield index : I
    //   314: iconst_1
    //   315: iadd
    //   316: putfield index : I
    //   319: aload_0
    //   320: getfield index : I
    //   323: aload_0
    //   324: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   327: arraylength
    //   328: if_icmpne -> 336
    //   331: aload_0
    //   332: iconst_0
    //   333: putfield index : I
    //   336: aload_3
    //   337: monitorexit
    //   338: goto -> 346
    //   341: astore_1
    //   342: aload_3
    //   343: monitorexit
    //   344: aload_1
    //   345: athrow
    //   346: iinc #6, 1
    //   349: goto -> 171
    //   352: aload #7
    //   354: ifnull -> 423
    //   357: aload #7
    //   359: arraylength
    //   360: ifne -> 366
    //   363: goto -> 423
    //   366: aload #7
    //   368: invokestatic trimCname : ([Lcom/qiniu/android/dns/Record;)[Lcom/qiniu/android/dns/Record;
    //   371: astore #4
    //   373: aload #4
    //   375: arraylength
    //   376: ifeq -> 413
    //   379: aload_0
    //   380: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   383: astore_2
    //   384: aload_2
    //   385: monitorenter
    //   386: aload_0
    //   387: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   390: aload_1
    //   391: getfield domain : Ljava/lang/String;
    //   394: aload #4
    //   396: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   399: pop
    //   400: aload_2
    //   401: monitorexit
    //   402: aload #4
    //   404: invokestatic records2Ip : ([Lcom/qiniu/android/dns/Record;)[Ljava/lang/String;
    //   407: areturn
    //   408: astore_1
    //   409: aload_2
    //   410: monitorexit
    //   411: aload_1
    //   412: athrow
    //   413: new java/net/UnknownHostException
    //   416: dup
    //   417: ldc 'no A records'
    //   419: invokespecial <init> : (Ljava/lang/String;)V
    //   422: athrow
    //   423: aload_1
    //   424: getfield hostsFirst : Z
    //   427: ifne -> 454
    //   430: aload_0
    //   431: getfield hosts : Lcom/qiniu/android/dns/local/Hosts;
    //   434: aload_1
    //   435: aload_0
    //   436: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   439: invokevirtual query : (Lcom/qiniu/android/dns/Domain;Lcom/qiniu/android/dns/NetworkInfo;)[Ljava/lang/String;
    //   442: astore_2
    //   443: aload_2
    //   444: ifnull -> 454
    //   447: aload_2
    //   448: arraylength
    //   449: ifeq -> 454
    //   452: aload_2
    //   453: areturn
    //   454: aload_3
    //   455: ifnull -> 460
    //   458: aload_3
    //   459: athrow
    //   460: new java/net/UnknownHostException
    //   463: dup
    //   464: aload_1
    //   465: getfield domain : Ljava/lang/String;
    //   468: invokespecial <init> : (Ljava/lang/String;)V
    //   471: athrow
    //   472: astore_1
    //   473: aload_3
    //   474: monitorexit
    //   475: aload_1
    //   476: athrow
    //   477: astore_3
    //   478: goto -> 346
    // Exception table:
    //   from	to	target	type
    //   38	71	472	finally
    //   71	78	83	finally
    //   84	86	83	finally
    //   86	88	472	finally
    //   88	104	472	finally
    //   115	143	472	finally
    //   143	151	472	finally
    //   153	155	472	finally
    //   205	229	477	com/qiniu/android/dns/http/DomainNotOwn
    //   205	229	235	java/io/IOException
    //   300	336	341	finally
    //   336	338	341	finally
    //   342	344	341	finally
    //   386	402	408	finally
    //   409	411	408	finally
    //   473	475	472	finally
  }
  
  private static String[] records2Ip(Record[] paramArrayOfRecord) {
    if (paramArrayOfRecord == null || paramArrayOfRecord.length == 0)
      return null; 
    ArrayList<String> arrayList = new ArrayList(paramArrayOfRecord.length);
    int i = paramArrayOfRecord.length;
    for (byte b = 0; b < i; b++)
      arrayList.add((paramArrayOfRecord[b]).value); 
    return (arrayList.size() == 0) ? null : arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  private static void rotate(Record[] paramArrayOfRecord) {
    if (paramArrayOfRecord != null && paramArrayOfRecord.length > 1) {
      Record record = paramArrayOfRecord[0];
      System.arraycopy(paramArrayOfRecord, 1, paramArrayOfRecord, 0, paramArrayOfRecord.length - 1);
      paramArrayOfRecord[paramArrayOfRecord.length - 1] = record;
    } 
  }
  
  private static Record[] trimCname(Record[] paramArrayOfRecord) {
    ArrayList<Record> arrayList = new ArrayList(paramArrayOfRecord.length);
    int i = paramArrayOfRecord.length;
    for (byte b = 0; b < i; b++) {
      Record record = paramArrayOfRecord[b];
      if (record != null && record.type == 1)
        arrayList.add(record); 
    } 
    return arrayList.<Record>toArray(new Record[arrayList.size()]);
  }
  
  public static boolean validIP(String paramString) {
    boolean bool = false;
    if (paramString == null || paramString.length() < 7 || paramString.length() > 15)
      return false; 
    if (paramString.contains("-"))
      return false; 
    try {
      int i = paramString.indexOf('.');
      if (i != -1 && Integer.parseInt(paramString.substring(0, i)) > 255)
        return false; 
      int j = paramString.indexOf('.', ++i);
      if (j != -1 && Integer.parseInt(paramString.substring(i, j)) > 255)
        return false; 
      i = j + 1;
      j = paramString.indexOf('.', i);
      if (j != -1 && Integer.parseInt(paramString.substring(i, j)) > 255 && Integer.parseInt(paramString.substring(j + 1, paramString.length() - 1)) > 255) {
        i = paramString.charAt(paramString.length() - 1);
        return (i == 46) ? true : bool;
      } 
      return true;
    } catch (NumberFormatException numberFormatException) {
      return false;
    } 
  }
  
  public void onNetworkChange(NetworkInfo paramNetworkInfo) {
    clearCache();
    null = paramNetworkInfo;
    if (paramNetworkInfo == null)
      null = NetworkInfo.normal; 
    this.info = null;
    synchronized (this.resolvers) {
      this.index = 0;
      return;
    } 
  }
  
  public DnsManager putHosts(String paramString1, String paramString2) {
    this.hosts.put(paramString1, paramString2);
    return this;
  }
  
  public DnsManager putHosts(String paramString1, String paramString2, int paramInt) {
    this.hosts.put(paramString1, new Hosts.Value(paramString2, paramInt));
    return this;
  }
  
  public String[] query(Domain paramDomain) throws IOException {
    if (paramDomain != null) {
      String[] arrayOfString;
      if (paramDomain.domain != null && paramDomain.domain.trim().length() != 0) {
        if (validIP(paramDomain.domain))
          return new String[] { paramDomain.domain }; 
        arrayOfString = queryInternal(paramDomain);
        return (arrayOfString == null || arrayOfString.length <= 1) ? arrayOfString : this.sorter.sort(arrayOfString);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("empty domain ");
      stringBuilder.append(((Domain)arrayOfString).domain);
      throw new IOException(stringBuilder.toString());
    } 
    throw new IOException("null domain");
  }
  
  public String[] query(String paramString) throws IOException {
    return query(new Domain(paramString));
  }
  
  public InetAddress[] queryInetAdress(Domain paramDomain) throws IOException {
    String[] arrayOfString = query(paramDomain);
    InetAddress[] arrayOfInetAddress = new InetAddress[arrayOfString.length];
    for (byte b = 0; b < arrayOfString.length; b++)
      arrayOfInetAddress[b] = InetAddress.getByName(arrayOfString[b]); 
    return arrayOfInetAddress;
  }
  
  private static class DummySorter implements IpSorter {
    private AtomicInteger pos = new AtomicInteger();
    
    private DummySorter() {}
    
    public String[] sort(String[] param1ArrayOfString) {
      return param1ArrayOfString;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\DnsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.criware.filesystem;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Locale;
import java.util.zip.CRC32;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CriFsWebInstaller {
  private static CriFsWebInstallerManager manager;
  
  private boolean can_access_asynctask;
  
  private CRC32 crc_num;
  
  public boolean is_stop_required = false;
  
  private boolean is_timeouted;
  
  private boolean is_waiting_to_start;
  
  private long start_time;
  
  private StatusInfo synced_statusinfo = new StatusInfo();
  
  private WebInstallerTask task;
  
  private AsyncTaskParam task_params;
  
  private long timeout_start_time;
  
  CriFsWebInstaller() {
    if (manager.crc_enabled)
      this.crc_num = new CRC32(); 
    ClearMember();
  }
  
  private void ClearMember() {
    this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_STOP;
    this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
    this.synced_statusinfo.http_status_code = -1;
    this.synced_statusinfo.contents_size = -1L;
    this.synced_statusinfo.received_size = 0L;
    this.start_time = 0L;
    this.timeout_start_time = 0L;
    this.is_waiting_to_start = false;
    this.is_timeouted = false;
    this.can_access_asynctask = false;
    if (manager.crc_enabled && this.crc_num != null)
      this.crc_num.reset(); 
  }
  
  public static CriFsWebInstaller Create() {
    if (manager != null)
      return manager.CreateInstaller(); 
    ErrorEntry(1);
    return null;
  }
  
  private static native boolean ErrorCallback(int paramInt);
  
  public static boolean ErrorEntry(int paramInt) {
    return ErrorCallback(paramInt);
  }
  
  public static void ExecuteMain() {
    if (manager != null)
      manager.ExecuteMain(); 
  }
  
  public static void Finalize() {
    if (manager != null) {
      manager.Manager_Finalize();
      manager = null;
    } else {
      ErrorEntry(1);
    } 
  }
  
  private long GetNow() {
    return (new Date()).getTime();
  }
  
  public static void Initialize(Config paramConfig) {
    if (manager == null) {
      manager = new CriFsWebInstallerManager();
      manager.Manager_Initialize(paramConfig);
    } else {
      ErrorEntry(1);
    } 
  }
  
  private static boolean IsRetryable(Error paramError, long paramLong) {
    boolean bool2;
    boolean bool3;
    Error error = Error.CRIFSWEBINSTALLER_ERROR_CONNECTION;
    boolean bool1 = false;
    if (paramError == error || paramError == Error.CRIFSWEBINSTALLER_ERROR_DNS) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramLong != -1L) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    boolean bool4 = bool1;
    if (bool2) {
      bool4 = bool1;
      if (bool3)
        bool4 = true; 
    } 
    return bool4;
  }
  
  public static void SetRequestHeader(String paramString1, String paramString2) {
    if (manager != null)
      manager.request_headers.set(paramString1, paramString2); 
  }
  
  private void StartTask(AsyncTaskParam paramAsyncTaskParam) {
    try {
      if (Build.VERSION.SDK_INT < 11) {
        Handler handler = new Handler();
        this(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            public void run() {
              CriFsWebInstaller.access$202(CriFsWebInstaller.this, new CriFsWebInstaller.WebInstallerTask());
              CriFsWebInstaller.this.task.execute((Object[])new CriFsWebInstaller.AsyncTaskParam[] { this.val$params });
              CriFsWebInstaller.access$302(CriFsWebInstaller.this, true);
            }
          };
        super(this, paramAsyncTaskParam);
        handler.post(runnable);
      } else {
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 16) {
          Handler handler = new Handler();
          this(Looper.getMainLooper());
          Runnable runnable = new Runnable() {
              public void run() {
                CriFsWebInstaller.access$202(CriFsWebInstaller.this, new CriFsWebInstaller.WebInstallerTask());
                CriFsWebInstaller.this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new CriFsWebInstaller.AsyncTaskParam[] { this.val$params });
                CriFsWebInstaller.access$302(CriFsWebInstaller.this, true);
              }
            };
          super(this, paramAsyncTaskParam);
          handler.post(runnable);
          return;
        } 
        WebInstallerTask webInstallerTask = new WebInstallerTask();
        this(this);
        this.task = webInstallerTask;
        this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new AsyncTaskParam[] { paramAsyncTaskParam });
        this.can_access_asynctask = true;
        return;
      } 
      return;
    } catch (NullPointerException nullPointerException) {
      ErrorEntry(10);
      this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
      this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_MEMORY;
      return;
    } 
  }
  
  public void Copy(String paramString1, String paramString2) {
    if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
      ErrorEntry(2);
      return;
    } 
    ClearMember();
    this.is_stop_required = false;
    this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_BUSY;
    this.task_params = new AsyncTaskParam(paramString1, paramString2, this.synced_statusinfo.contents_size, this.synced_statusinfo.received_size);
    this.timeout_start_time = GetNow() / 1000L;
    StartTask(this.task_params);
  }
  
  public void Destroy() {
    if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
      ErrorEntry(2);
      return;
    } 
    if (manager.installer_list.remove(this)) {
      CriFsWebInstallerManager criFsWebInstallerManager = manager;
      criFsWebInstallerManager.num_installers--;
    } 
  }
  
  public long GetCRC32() {
    return this.crc_num.getValue();
  }
  
  public long GetStatusInfo_contents_size() {
    return this.synced_statusinfo.contents_size;
  }
  
  public int GetStatusInfo_error() {
    return this.synced_statusinfo.error.getValue();
  }
  
  public int GetStatusInfo_http_status_code() {
    return this.synced_statusinfo.http_status_code;
  }
  
  public long GetStatusInfo_received_size() {
    return this.synced_statusinfo.received_size;
  }
  
  public int GetStatusInfo_status() {
    return this.synced_statusinfo.status.getValue();
  }
  
  public int IsCRCEnabled() {
    return manager.crc_enabled ? 1 : 0;
  }
  
  public void Stop() {
    switch (this.synced_statusinfo.status) {
      case CRIFSWEBINSTALLER_STATUS_COMPLETE:
      case CRIFSWEBINSTALLER_STATUS_ERROR:
        ClearMember();
        break;
      case CRIFSWEBINSTALLER_STATUS_BUSY:
        this.is_stop_required = true;
        break;
    } 
  }
  
  public void Update() {
    StringBuilder stringBuilder;
    if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_BUSY || !this.can_access_asynctask)
      return; 
    TaskStatusInfo taskStatusInfo = this.task.GetTaskStatusInfo();
    if (taskStatusInfo == null)
      return; 
    int i = null.$SwitchMap$com$criware$filesystem$CriFsWebInstaller$TaskStatus[taskStatusInfo.status.ordinal()];
    boolean bool = false;
    switch (i) {
      default:
        return;
      case 3:
        this.synced_statusinfo.contents_size = taskStatusInfo.contents_size;
        this.synced_statusinfo.received_size = taskStatusInfo.received_size;
      case 2:
        if (this.is_stop_required) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(this.task_params.param_dst_path);
          stringBuilder.append(".tmp");
          (new File(stringBuilder.toString())).delete();
          ClearMember();
        } else if (this.is_timeouted) {
          this.synced_statusinfo.contents_size = ((TaskStatusInfo)stringBuilder).contents_size;
          this.synced_statusinfo.received_size = ((TaskStatusInfo)stringBuilder).received_size;
          this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
          this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_TIMEOUT;
        } else {
          this.synced_statusinfo.contents_size = ((TaskStatusInfo)stringBuilder).contents_size;
          this.synced_statusinfo.received_size = ((TaskStatusInfo)stringBuilder).received_size;
          long l1 = GetNow() / 1000L;
          if (this.timeout_start_time + manager.inactive_timeout_sec < l1)
            this.is_timeouted = true; 
          if (((TaskStatusInfo)stringBuilder).error == Error.CRIFSWEBINSTALLER_ERROR_NONE) {
            this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_COMPLETE;
            this.synced_statusinfo.http_status_code = ((TaskStatusInfo)stringBuilder).http_status_code;
          } else if (IsRetryable(((TaskStatusInfo)stringBuilder).error, this.synced_statusinfo.contents_size)) {
            if (!this.is_waiting_to_start) {
              this.is_waiting_to_start = true;
              this.start_time = GetNow();
            } else if (GetNow() - this.start_time >= 5000L) {
              this.is_waiting_to_start = false;
              this.task_params.param_contents_size = this.synced_statusinfo.contents_size;
              this.task_params.param_received_size = this.synced_statusinfo.received_size;
              this.can_access_asynctask = false;
              StartTask(this.task_params);
            } 
          } else {
            this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            this.synced_statusinfo.error = ((TaskStatusInfo)stringBuilder).error;
            this.synced_statusinfo.http_status_code = ((TaskStatusInfo)stringBuilder).http_status_code;
          } 
        } 
      case 1:
        break;
    } 
    if (this.is_stop_required)
      this.task.Cancel(); 
    this.synced_statusinfo.contents_size = ((TaskStatusInfo)stringBuilder).contents_size;
    if (((TaskStatusInfo)stringBuilder).received_size > this.synced_statusinfo.received_size)
      bool = true; 
    if (bool) {
      this.synced_statusinfo.received_size = ((TaskStatusInfo)stringBuilder).received_size;
      this.timeout_start_time = GetNow() / 1000L;
    } 
    long l = GetNow() / 1000L;
    if (this.timeout_start_time + manager.inactive_timeout_sec < l) {
      this.is_timeouted = true;
      this.task.cancel(true);
    } 
  }
  
  public class AsyncTaskParam {
    long param_contents_size;
    
    String param_dst_path;
    
    long param_received_size;
    
    String param_src_path;
    
    AsyncTaskParam(String param1String1, String param1String2, long param1Long1, long param1Long2) {
      this.param_src_path = param1String1;
      this.param_dst_path = param1String2;
      this.param_contents_size = param1Long1;
      this.param_received_size = param1Long2;
    }
  }
  
  public static class Config {
    boolean allow_insecure_ssl;
    
    boolean crc_enabled;
    
    int inactive_timeout_sec;
    
    int max_request_fields;
    
    int num_installers;
    
    String proxy_host;
    
    short proxy_port;
    
    String user_agent;
  }
  
  public enum Error {
    CRIFSWEBINSTALLER_ERROR_CONNECTION,
    CRIFSWEBINSTALLER_ERROR_DNS,
    CRIFSWEBINSTALLER_ERROR_HTTP,
    CRIFSWEBINSTALLER_ERROR_INTERNAL,
    CRIFSWEBINSTALLER_ERROR_LOCALFS,
    CRIFSWEBINSTALLER_ERROR_MEMORY,
    CRIFSWEBINSTALLER_ERROR_NONE(0),
    CRIFSWEBINSTALLER_ERROR_SSL(0),
    CRIFSWEBINSTALLER_ERROR_TIMEOUT(1);
    
    private int value;
    
    static {
      CRIFSWEBINSTALLER_ERROR_LOCALFS = new Error("CRIFSWEBINSTALLER_ERROR_LOCALFS", 3, 3);
      CRIFSWEBINSTALLER_ERROR_DNS = new Error("CRIFSWEBINSTALLER_ERROR_DNS", 4, 4);
      CRIFSWEBINSTALLER_ERROR_CONNECTION = new Error("CRIFSWEBINSTALLER_ERROR_CONNECTION", 5, 5);
      CRIFSWEBINSTALLER_ERROR_SSL = new Error("CRIFSWEBINSTALLER_ERROR_SSL", 6, 6);
      CRIFSWEBINSTALLER_ERROR_HTTP = new Error("CRIFSWEBINSTALLER_ERROR_HTTP", 7, 7);
      CRIFSWEBINSTALLER_ERROR_INTERNAL = new Error("CRIFSWEBINSTALLER_ERROR_INTERNAL", 8, 8);
      $VALUES = new Error[] { CRIFSWEBINSTALLER_ERROR_NONE, CRIFSWEBINSTALLER_ERROR_TIMEOUT, CRIFSWEBINSTALLER_ERROR_MEMORY, CRIFSWEBINSTALLER_ERROR_LOCALFS, CRIFSWEBINSTALLER_ERROR_DNS, CRIFSWEBINSTALLER_ERROR_CONNECTION, CRIFSWEBINSTALLER_ERROR_SSL, CRIFSWEBINSTALLER_ERROR_HTTP, CRIFSWEBINSTALLER_ERROR_INTERNAL };
    }
    
    Error(int param1Int1) {
      this.value = param1Int1;
    }
    
    public int getValue() {
      return this.value;
    }
  }
  
  public enum Status {
    CRIFSWEBINSTALLER_STATUS_STOP(0),
    CRIFSWEBINSTALLER_STATUS_BUSY(1),
    CRIFSWEBINSTALLER_STATUS_COMPLETE(1),
    CRIFSWEBINSTALLER_STATUS_ERROR(1);
    
    private int value;
    
    static {
      $VALUES = new Status[] { CRIFSWEBINSTALLER_STATUS_STOP, CRIFSWEBINSTALLER_STATUS_BUSY, CRIFSWEBINSTALLER_STATUS_COMPLETE, CRIFSWEBINSTALLER_STATUS_ERROR };
    }
    
    Status(int param1Int1) {
      this.value = param1Int1;
    }
    
    public int getValue() {
      return this.value;
    }
  }
  
  public class StatusInfo {
    long contents_size;
    
    CriFsWebInstaller.Error error;
    
    int http_status_code;
    
    long received_size;
    
    CriFsWebInstaller.Status status;
  }
  
  public enum TaskStatus {
    BUSY, STOP, STOPPING;
    
    static {
    
    }
  }
  
  public class TaskStatusInfo {
    long contents_size = -1L;
    
    CriFsWebInstaller.Error error = CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_NONE;
    
    int http_status_code = -1;
    
    long received_size = 0L;
    
    CriFsWebInstaller.TaskStatus status = CriFsWebInstaller.TaskStatus.BUSY;
  }
  
  private class WebInstallerTask extends AsyncTask<AsyncTaskParam, Void, Boolean> {
    private HttpURLConnection http_connection = null;
    
    private boolean is_ssl;
    
    private String task_dst_path;
    
    private CriFsWebInstaller.TaskStatusInfo task_internal_info = new CriFsWebInstaller.TaskStatusInfo();
    
    private String task_src_path;
    
    private File tmp_file;
    
    private void SetError(CriFsWebInstaller.Error param1Error, int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   6: if_acmpeq -> 24
      //   9: aload_1
      //   10: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_DNS : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   13: if_acmpne -> 19
      //   16: goto -> 24
      //   19: iconst_0
      //   20: istore_3
      //   21: goto -> 26
      //   24: iconst_1
      //   25: istore_3
      //   26: iload_3
      //   27: ifne -> 48
      //   30: aload_0
      //   31: getfield tmp_file : Ljava/io/File;
      //   34: invokevirtual exists : ()Z
      //   37: ifeq -> 48
      //   40: aload_0
      //   41: getfield tmp_file : Ljava/io/File;
      //   44: invokevirtual delete : ()Z
      //   47: pop
      //   48: aload_0
      //   49: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   52: getstatic com/criware/filesystem/CriFsWebInstaller$TaskStatus.STOP : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   55: putfield status : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   58: aload_0
      //   59: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   62: aload_1
      //   63: putfield error : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   66: aload_0
      //   67: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   70: iload_2
      //   71: putfield http_status_code : I
      //   74: aload_0
      //   75: monitorexit
      //   76: return
      //   77: astore_1
      //   78: aload_0
      //   79: monitorexit
      //   80: aload_1
      //   81: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	77	finally
      //   30	48	77	finally
      //   48	74	77	finally
    }
    
    private boolean task_connect() {
      // Byte code:
      //   0: aload_0
      //   1: getfield http_connection : Ljava/net/HttpURLConnection;
      //   4: invokevirtual connect : ()V
      //   7: aload_0
      //   8: getfield http_connection : Ljava/net/HttpURLConnection;
      //   11: invokevirtual getResponseCode : ()I
      //   14: istore_1
      //   15: iload_1
      //   16: sipush #200
      //   19: if_icmpne -> 34
      //   22: aload_0
      //   23: getfield http_connection : Ljava/net/HttpURLConnection;
      //   26: invokevirtual getContentLength : ()I
      //   29: i2l
      //   30: lstore_2
      //   31: goto -> 58
      //   34: iload_1
      //   35: sipush #206
      //   38: if_icmpne -> 87
      //   41: aload_0
      //   42: getfield http_connection : Ljava/net/HttpURLConnection;
      //   45: invokevirtual getContentLength : ()I
      //   48: i2l
      //   49: aload_0
      //   50: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   53: getfield received_size : J
      //   56: ladd
      //   57: lstore_2
      //   58: aload_0
      //   59: monitorenter
      //   60: aload_0
      //   61: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   64: iload_1
      //   65: putfield http_status_code : I
      //   68: aload_0
      //   69: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   72: lload_2
      //   73: putfield contents_size : J
      //   76: aload_0
      //   77: monitorexit
      //   78: iconst_1
      //   79: ireturn
      //   80: astore #4
      //   82: aload_0
      //   83: monitorexit
      //   84: aload #4
      //   86: athrow
      //   87: iload_1
      //   88: iflt -> 101
      //   91: aload_0
      //   92: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_HTTP : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   95: iload_1
      //   96: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   99: iconst_0
      //   100: ireturn
      //   101: aload_0
      //   102: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   105: iconst_m1
      //   106: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   109: iconst_0
      //   110: ireturn
      //   111: astore #4
      //   113: aload_0
      //   114: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   117: iconst_m1
      //   118: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   121: iconst_5
      //   122: invokestatic ErrorEntry : (I)Z
      //   125: pop
      //   126: aload #4
      //   128: invokevirtual printStackTrace : ()V
      //   131: iconst_0
      //   132: ireturn
      //   133: astore #4
      //   135: aload_0
      //   136: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_SSL : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   139: iconst_m1
      //   140: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   143: iconst_0
      //   144: ireturn
      //   145: astore #4
      //   147: aload_0
      //   148: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_HTTP : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   151: iconst_m1
      //   152: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   155: iconst_0
      //   156: ireturn
      //   157: astore #4
      //   159: aload_0
      //   160: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   163: iconst_m1
      //   164: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   167: iconst_0
      //   168: ireturn
      //   169: astore #4
      //   171: aload_0
      //   172: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   175: iconst_m1
      //   176: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   179: iconst_0
      //   180: ireturn
      //   181: astore #4
      //   183: aload_0
      //   184: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   187: iconst_m1
      //   188: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   191: iconst_0
      //   192: ireturn
      //   193: astore #4
      //   195: aload_0
      //   196: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   199: iconst_m1
      //   200: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   203: iconst_0
      //   204: ireturn
      // Exception table:
      //   from	to	target	type
      //   0	15	193	java/net/UnknownHostException
      //   0	15	181	java/net/SocketException
      //   0	15	169	java/net/SocketTimeoutException
      //   0	15	157	javax/net/ssl/SSLHandshakeException
      //   0	15	145	java/io/FileNotFoundException
      //   0	15	133	javax/net/ssl/SSLException
      //   0	15	111	java/io/IOException
      //   22	31	193	java/net/UnknownHostException
      //   22	31	181	java/net/SocketException
      //   22	31	169	java/net/SocketTimeoutException
      //   22	31	157	javax/net/ssl/SSLHandshakeException
      //   22	31	145	java/io/FileNotFoundException
      //   22	31	133	javax/net/ssl/SSLException
      //   22	31	111	java/io/IOException
      //   41	58	193	java/net/UnknownHostException
      //   41	58	181	java/net/SocketException
      //   41	58	169	java/net/SocketTimeoutException
      //   41	58	157	javax/net/ssl/SSLHandshakeException
      //   41	58	145	java/io/FileNotFoundException
      //   41	58	133	javax/net/ssl/SSLException
      //   41	58	111	java/io/IOException
      //   58	60	193	java/net/UnknownHostException
      //   58	60	181	java/net/SocketException
      //   58	60	169	java/net/SocketTimeoutException
      //   58	60	157	javax/net/ssl/SSLHandshakeException
      //   58	60	145	java/io/FileNotFoundException
      //   58	60	133	javax/net/ssl/SSLException
      //   58	60	111	java/io/IOException
      //   60	78	80	finally
      //   82	84	80	finally
      //   84	87	193	java/net/UnknownHostException
      //   84	87	181	java/net/SocketException
      //   84	87	169	java/net/SocketTimeoutException
      //   84	87	157	javax/net/ssl/SSLHandshakeException
      //   84	87	145	java/io/FileNotFoundException
      //   84	87	133	javax/net/ssl/SSLException
      //   84	87	111	java/io/IOException
      //   91	99	193	java/net/UnknownHostException
      //   91	99	181	java/net/SocketException
      //   91	99	169	java/net/SocketTimeoutException
      //   91	99	157	javax/net/ssl/SSLHandshakeException
      //   91	99	145	java/io/FileNotFoundException
      //   91	99	133	javax/net/ssl/SSLException
      //   91	99	111	java/io/IOException
      //   101	109	193	java/net/UnknownHostException
      //   101	109	181	java/net/SocketException
      //   101	109	169	java/net/SocketTimeoutException
      //   101	109	157	javax/net/ssl/SSLHandshakeException
      //   101	109	145	java/io/FileNotFoundException
      //   101	109	133	javax/net/ssl/SSLException
      //   101	109	111	java/io/IOException
    }
    
    private boolean task_copyfile() {
      // Byte code:
      //   0: aload_0
      //   1: getfield http_connection : Ljava/net/HttpURLConnection;
      //   4: invokevirtual getInputStream : ()Ljava/io/InputStream;
      //   7: astore_1
      //   8: new java/io/FileOutputStream
      //   11: astore_2
      //   12: aload_2
      //   13: aload_0
      //   14: getfield tmp_file : Ljava/io/File;
      //   17: iconst_1
      //   18: invokespecial <init> : (Ljava/io/File;Z)V
      //   21: ldc 65536
      //   23: newarray byte
      //   25: astore_3
      //   26: aload_0
      //   27: invokevirtual isCancelled : ()Z
      //   30: istore #4
      //   32: iload #4
      //   34: ifne -> 176
      //   37: aload_1
      //   38: aload_3
      //   39: invokevirtual read : ([B)I
      //   42: istore #5
      //   44: iload #5
      //   46: iconst_m1
      //   47: if_icmpne -> 53
      //   50: goto -> 176
      //   53: iload #5
      //   55: ifne -> 67
      //   58: ldc2_w 10
      //   61: invokestatic sleep : (J)V
      //   64: goto -> 26
      //   67: invokestatic access$000 : ()Lcom/criware/filesystem/CriFsWebInstallerManager;
      //   70: getfield crc_enabled : Z
      //   73: istore #4
      //   75: iload #4
      //   77: ifeq -> 115
      //   80: aload_0
      //   81: getfield this$0 : Lcom/criware/filesystem/CriFsWebInstaller;
      //   84: invokestatic access$100 : (Lcom/criware/filesystem/CriFsWebInstaller;)Ljava/util/zip/CRC32;
      //   87: aload_3
      //   88: iconst_0
      //   89: iload #5
      //   91: invokevirtual update : ([BII)V
      //   94: goto -> 115
      //   97: astore_3
      //   98: aload_0
      //   99: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_INTERNAL : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   102: iconst_m1
      //   103: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   106: bipush #13
      //   108: invokestatic ErrorEntry : (I)Z
      //   111: pop
      //   112: goto -> 176
      //   115: aload_2
      //   116: aload_3
      //   117: iconst_0
      //   118: iload #5
      //   120: invokevirtual write : ([BII)V
      //   123: aload_0
      //   124: monitorenter
      //   125: aload_0
      //   126: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   129: astore #6
      //   131: aload #6
      //   133: aload #6
      //   135: getfield received_size : J
      //   138: iload #5
      //   140: i2l
      //   141: ladd
      //   142: putfield received_size : J
      //   145: aload_0
      //   146: monitorexit
      //   147: goto -> 26
      //   150: astore_2
      //   151: aload_0
      //   152: monitorexit
      //   153: aload_2
      //   154: athrow
      //   155: astore_3
      //   156: aload_0
      //   157: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_LOCALFS : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   160: iconst_m1
      //   161: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   164: goto -> 176
      //   167: astore_3
      //   168: aload_0
      //   169: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   172: iconst_m1
      //   173: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   176: aload_1
      //   177: invokevirtual close : ()V
      //   180: aload_2
      //   181: invokevirtual close : ()V
      //   184: aload_0
      //   185: getfield http_connection : Ljava/net/HttpURLConnection;
      //   188: invokevirtual disconnect : ()V
      //   191: aload_0
      //   192: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   195: getfield error : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   198: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_NONE : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   201: if_acmpeq -> 234
      //   204: aload_0
      //   205: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   208: getfield error : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   211: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_LOCALFS : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   214: if_acmpne -> 225
      //   217: aload_0
      //   218: getfield tmp_file : Ljava/io/File;
      //   221: invokevirtual delete : ()Z
      //   224: pop
      //   225: aload_0
      //   226: getfield http_connection : Ljava/net/HttpURLConnection;
      //   229: invokevirtual disconnect : ()V
      //   232: iconst_0
      //   233: ireturn
      //   234: aload_0
      //   235: invokevirtual isCancelled : ()Z
      //   238: ifeq -> 258
      //   241: aload_0
      //   242: getfield tmp_file : Ljava/io/File;
      //   245: invokevirtual delete : ()Z
      //   248: pop
      //   249: aload_0
      //   250: getfield http_connection : Ljava/net/HttpURLConnection;
      //   253: invokevirtual disconnect : ()V
      //   256: iconst_0
      //   257: ireturn
      //   258: aload_0
      //   259: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   262: getfield received_size : J
      //   265: aload_0
      //   266: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   269: getfield contents_size : J
      //   272: lcmp
      //   273: ifeq -> 307
      //   276: aload_0
      //   277: getfield tmp_file : Ljava/io/File;
      //   280: invokevirtual delete : ()Z
      //   283: pop
      //   284: aload_0
      //   285: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_INTERNAL : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   288: iconst_m1
      //   289: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   292: bipush #14
      //   294: invokestatic ErrorEntry : (I)Z
      //   297: pop
      //   298: aload_0
      //   299: getfield http_connection : Ljava/net/HttpURLConnection;
      //   302: invokevirtual disconnect : ()V
      //   305: iconst_0
      //   306: ireturn
      //   307: new java/io/File
      //   310: astore_2
      //   311: aload_2
      //   312: aload_0
      //   313: getfield task_dst_path : Ljava/lang/String;
      //   316: invokespecial <init> : (Ljava/lang/String;)V
      //   319: aload_2
      //   320: invokevirtual exists : ()Z
      //   323: ifeq -> 351
      //   326: aload_0
      //   327: getfield tmp_file : Ljava/io/File;
      //   330: invokevirtual delete : ()Z
      //   333: pop
      //   334: aload_0
      //   335: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_LOCALFS : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   338: iconst_m1
      //   339: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   342: aload_0
      //   343: getfield http_connection : Ljava/net/HttpURLConnection;
      //   346: invokevirtual disconnect : ()V
      //   349: iconst_0
      //   350: ireturn
      //   351: aload_0
      //   352: getfield tmp_file : Ljava/io/File;
      //   355: aload_2
      //   356: invokevirtual renameTo : (Ljava/io/File;)Z
      //   359: pop
      //   360: aload_0
      //   361: getfield http_connection : Ljava/net/HttpURLConnection;
      //   364: invokevirtual disconnect : ()V
      //   367: iconst_1
      //   368: ireturn
      //   369: astore_2
      //   370: goto -> 455
      //   373: astore_2
      //   374: aload_0
      //   375: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_INTERNAL : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   378: iconst_m1
      //   379: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   382: bipush #6
      //   384: invokestatic ErrorEntry : (I)Z
      //   387: pop
      //   388: aload_2
      //   389: invokevirtual printStackTrace : ()V
      //   392: aload_0
      //   393: getfield http_connection : Ljava/net/HttpURLConnection;
      //   396: invokevirtual disconnect : ()V
      //   399: iconst_0
      //   400: ireturn
      //   401: astore_2
      //   402: aload_0
      //   403: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_LOCALFS : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   406: iconst_m1
      //   407: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   410: aload_0
      //   411: getfield http_connection : Ljava/net/HttpURLConnection;
      //   414: invokevirtual disconnect : ()V
      //   417: iconst_0
      //   418: ireturn
      //   419: astore_2
      //   420: aload_0
      //   421: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_CONNECTION : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   424: iconst_m1
      //   425: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   428: aload_0
      //   429: getfield http_connection : Ljava/net/HttpURLConnection;
      //   432: invokevirtual disconnect : ()V
      //   435: iconst_0
      //   436: ireturn
      //   437: astore_2
      //   438: aload_0
      //   439: getstatic com/criware/filesystem/CriFsWebInstaller$Error.CRIFSWEBINSTALLER_ERROR_MEMORY : Lcom/criware/filesystem/CriFsWebInstaller$Error;
      //   442: iconst_m1
      //   443: invokespecial SetError : (Lcom/criware/filesystem/CriFsWebInstaller$Error;I)V
      //   446: aload_0
      //   447: getfield http_connection : Ljava/net/HttpURLConnection;
      //   450: invokevirtual disconnect : ()V
      //   453: iconst_0
      //   454: ireturn
      //   455: aload_0
      //   456: getfield http_connection : Ljava/net/HttpURLConnection;
      //   459: invokevirtual disconnect : ()V
      //   462: aload_2
      //   463: athrow
      //   464: astore #6
      //   466: goto -> 26
      //   469: astore_1
      //   470: goto -> 180
      //   473: astore_2
      //   474: goto -> 184
      // Exception table:
      //   from	to	target	type
      //   0	26	437	java/lang/NullPointerException
      //   0	26	419	java/net/SocketTimeoutException
      //   0	26	401	java/io/FileNotFoundException
      //   0	26	373	java/io/IOException
      //   0	26	369	finally
      //   26	32	437	java/lang/NullPointerException
      //   26	32	419	java/net/SocketTimeoutException
      //   26	32	401	java/io/FileNotFoundException
      //   26	32	373	java/io/IOException
      //   26	32	369	finally
      //   37	44	167	java/io/IOException
      //   37	44	437	java/lang/NullPointerException
      //   37	44	419	java/net/SocketTimeoutException
      //   37	44	401	java/io/FileNotFoundException
      //   37	44	369	finally
      //   58	64	464	java/lang/InterruptedException
      //   58	64	437	java/lang/NullPointerException
      //   58	64	419	java/net/SocketTimeoutException
      //   58	64	401	java/io/FileNotFoundException
      //   58	64	373	java/io/IOException
      //   58	64	369	finally
      //   67	75	437	java/lang/NullPointerException
      //   67	75	419	java/net/SocketTimeoutException
      //   67	75	401	java/io/FileNotFoundException
      //   67	75	373	java/io/IOException
      //   67	75	369	finally
      //   80	94	97	java/lang/ArrayIndexOutOfBoundsException
      //   80	94	437	java/lang/NullPointerException
      //   80	94	419	java/net/SocketTimeoutException
      //   80	94	401	java/io/FileNotFoundException
      //   80	94	373	java/io/IOException
      //   80	94	369	finally
      //   98	112	437	java/lang/NullPointerException
      //   98	112	419	java/net/SocketTimeoutException
      //   98	112	401	java/io/FileNotFoundException
      //   98	112	373	java/io/IOException
      //   98	112	369	finally
      //   115	123	155	java/io/IOException
      //   115	123	437	java/lang/NullPointerException
      //   115	123	419	java/net/SocketTimeoutException
      //   115	123	401	java/io/FileNotFoundException
      //   115	123	369	finally
      //   123	125	437	java/lang/NullPointerException
      //   123	125	419	java/net/SocketTimeoutException
      //   123	125	401	java/io/FileNotFoundException
      //   123	125	373	java/io/IOException
      //   123	125	369	finally
      //   125	147	150	finally
      //   151	153	150	finally
      //   153	155	437	java/lang/NullPointerException
      //   153	155	419	java/net/SocketTimeoutException
      //   153	155	401	java/io/FileNotFoundException
      //   153	155	373	java/io/IOException
      //   153	155	369	finally
      //   156	164	437	java/lang/NullPointerException
      //   156	164	419	java/net/SocketTimeoutException
      //   156	164	401	java/io/FileNotFoundException
      //   156	164	373	java/io/IOException
      //   156	164	369	finally
      //   168	176	437	java/lang/NullPointerException
      //   168	176	419	java/net/SocketTimeoutException
      //   168	176	401	java/io/FileNotFoundException
      //   168	176	373	java/io/IOException
      //   168	176	369	finally
      //   176	180	469	java/io/IOException
      //   176	180	437	java/lang/NullPointerException
      //   176	180	419	java/net/SocketTimeoutException
      //   176	180	401	java/io/FileNotFoundException
      //   176	180	369	finally
      //   180	184	473	java/io/IOException
      //   180	184	437	java/lang/NullPointerException
      //   180	184	419	java/net/SocketTimeoutException
      //   180	184	401	java/io/FileNotFoundException
      //   180	184	369	finally
      //   184	225	437	java/lang/NullPointerException
      //   184	225	419	java/net/SocketTimeoutException
      //   184	225	401	java/io/FileNotFoundException
      //   184	225	373	java/io/IOException
      //   184	225	369	finally
      //   234	249	437	java/lang/NullPointerException
      //   234	249	419	java/net/SocketTimeoutException
      //   234	249	401	java/io/FileNotFoundException
      //   234	249	373	java/io/IOException
      //   234	249	369	finally
      //   258	298	437	java/lang/NullPointerException
      //   258	298	419	java/net/SocketTimeoutException
      //   258	298	401	java/io/FileNotFoundException
      //   258	298	373	java/io/IOException
      //   258	298	369	finally
      //   307	342	437	java/lang/NullPointerException
      //   307	342	419	java/net/SocketTimeoutException
      //   307	342	401	java/io/FileNotFoundException
      //   307	342	373	java/io/IOException
      //   307	342	369	finally
      //   351	360	437	java/lang/NullPointerException
      //   351	360	419	java/net/SocketTimeoutException
      //   351	360	401	java/io/FileNotFoundException
      //   351	360	373	java/io/IOException
      //   351	360	369	finally
      //   374	392	369	finally
      //   402	410	369	finally
      //   420	428	369	finally
      //   438	446	369	finally
    }
    
    private boolean task_setup() {
      try {
        SSLSocketFactory sSLSocketFactory;
        byte b;
        if (this.task_src_path.toLowerCase(Locale.ENGLISH).startsWith("https://")) {
          this.is_ssl = true;
        } else if (this.task_src_path.toLowerCase(Locale.ENGLISH).startsWith("http://")) {
          this.is_ssl = false;
        } else {
          SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
          CriFsWebInstaller.ErrorEntry(7);
          return false;
        } 
        URL uRL = new URL();
        this(this.task_src_path);
        File file = new File();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(this.task_dst_path);
        stringBuilder.append(".tmp");
        this(stringBuilder.toString());
        this.tmp_file = file;
        boolean bool = CriFsWebInstaller.manager.allow_insecure_ssl;
        file = null;
        if (bool && this.is_ssl) {
          X509TrustManager[] arrayOfX509TrustManager = new X509TrustManager[1];
          CriFsWebInstallerManager.LooseTrustManager looseTrustManager = new CriFsWebInstallerManager.LooseTrustManager();
          this();
          arrayOfX509TrustManager[0] = looseTrustManager;
        } else {
          stringBuilder = null;
        } 
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21) {
          b = 1;
        } else {
          b = 0;
        } 
        if (b || stringBuilder != null) {
          SSLContext sSLContext = SSLContext.getInstance("TLS");
          sSLContext.init(null, (TrustManager[])stringBuilder, null);
          if (b) {
            sSLSocketFactory = new TLSSocketFactory();
            this(sSLContext.getSocketFactory());
          } else {
            sSLSocketFactory = sSLContext.getSocketFactory();
          } 
        } 
        try {
          if (CriFsWebInstaller.manager.proxy_host != null && CriFsWebInstaller.manager.proxy_port != 0) {
            Proxy proxy = new Proxy();
            Proxy.Type type = Proxy.Type.HTTP;
            InetSocketAddress inetSocketAddress = new InetSocketAddress();
            this(CriFsWebInstaller.manager.proxy_host, CriFsWebInstaller.manager.proxy_port);
            this(type, inetSocketAddress);
            this.http_connection = (HttpURLConnection)uRL.openConnection(proxy);
          } else {
            CriFsWebInstallerManager criFsWebInstallerManager = CriFsWebInstaller.manager;
            String str = System.getProperty("http.proxyHost");
            criFsWebInstallerManager.proxy_host = str;
            if (str != null) {
              str = System.getProperty("http.proxyPort");
              criFsWebInstallerManager = CriFsWebInstaller.manager;
              if (str == null)
                str = "-1"; 
              criFsWebInstallerManager.proxy_port = Short.parseShort(str);
              Proxy proxy = new Proxy();
              Proxy.Type type = Proxy.Type.HTTP;
              InetSocketAddress inetSocketAddress = new InetSocketAddress();
              this(CriFsWebInstaller.manager.proxy_host, CriFsWebInstaller.manager.proxy_port);
              this(type, inetSocketAddress);
              this.http_connection = (HttpURLConnection)uRL.openConnection(proxy);
            } else {
              this.http_connection = (HttpURLConnection)uRL.openConnection();
            } 
          } 
          this.http_connection.setRequestMethod("GET");
          this.http_connection.setInstanceFollowRedirects(false);
          this.http_connection.setDoInput(true);
          this.http_connection.setConnectTimeout(5000);
          this.http_connection.setReadTimeout(5000);
          this.http_connection.setRequestProperty("User-Agent", CriFsWebInstaller.manager.user_agent);
          this.http_connection.setRequestProperty("Accept-Encoding", "identity");
          b = 0;
          try {
            while (b < CriFsWebInstaller.manager.request_headers.length()) {
              this.http_connection.setRequestProperty(CriFsWebInstaller.manager.request_headers.getFieldName(b), CriFsWebInstaller.manager.request_headers.getValue(b));
              b++;
            } 
            if (sSLSocketFactory != null)
              ((HttpsURLConnection)this.http_connection).setSSLSocketFactory(sSLSocketFactory); 
            if (this.task_internal_info.contents_size != -1L) {
              if (!this.tmp_file.exists()) {
                CriFsWebInstaller.ErrorEntry(8);
                SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS, this.task_internal_info.http_status_code);
                return false;
              } 
              if (this.tmp_file.length() != this.task_internal_info.received_size) {
                CriFsWebInstaller.ErrorEntry(9);
                SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                return false;
              } 
              HttpURLConnection httpURLConnection = this.http_connection;
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append("bytes=");
              stringBuilder1.append(this.tmp_file.length());
              stringBuilder1.append("-");
              httpURLConnection.setRequestProperty("Range", stringBuilder1.toString());
            } else if (this.tmp_file.exists()) {
              this.tmp_file.delete();
            } 
            return true;
          } catch (IllegalArgumentException illegalArgumentException) {
            SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
            CriFsWebInstaller.ErrorEntry(12);
            return false;
          } 
        } catch (IllegalArgumentException illegalArgumentException) {
          SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
          CriFsWebInstaller.ErrorEntry(11);
          return false;
        } 
      } catch (NullPointerException nullPointerException) {
        SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_MEMORY, this.task_internal_info.http_status_code);
        nullPointerException.printStackTrace();
        return false;
      } catch (MalformedURLException malformedURLException) {
        SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_DNS, this.task_internal_info.http_status_code);
        malformedURLException.printStackTrace();
        return false;
      } catch (ProtocolException protocolException) {
        SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, this.task_internal_info.http_status_code);
        protocolException.printStackTrace();
        return false;
      } catch (GeneralSecurityException generalSecurityException) {
        SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_SSL, this.task_internal_info.http_status_code);
        generalSecurityException.printStackTrace();
        return false;
      } catch (IOException iOException) {
        SetError(CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
        CriFsWebInstaller.ErrorEntry(4);
        iOException.printStackTrace();
        return false;
      } 
    }
    
    public void Cancel() {
      // Byte code:
      //   0: aload_0
      //   1: iconst_1
      //   2: invokevirtual cancel : (Z)Z
      //   5: pop
      //   6: aload_0
      //   7: monitorenter
      //   8: aload_0
      //   9: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   12: getstatic com/criware/filesystem/CriFsWebInstaller$TaskStatus.STOPPING : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   15: putfield status : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   8	20	21	finally
      //   22	24	21	finally
    }
    
    public CriFsWebInstaller.TaskStatusInfo GetTaskStatusInfo() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   6: astore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_1
      //   10: areturn
      //   11: astore_1
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_1
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	11	finally
    }
    
    protected Boolean doInBackground(CriFsWebInstaller.AsyncTaskParam... param1VarArgs) {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: iconst_0
      //   3: aaload
      //   4: getfield param_src_path : Ljava/lang/String;
      //   7: putfield task_src_path : Ljava/lang/String;
      //   10: aload_0
      //   11: aload_1
      //   12: iconst_0
      //   13: aaload
      //   14: getfield param_dst_path : Ljava/lang/String;
      //   17: putfield task_dst_path : Ljava/lang/String;
      //   20: aload_0
      //   21: monitorenter
      //   22: aload_0
      //   23: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   26: aload_1
      //   27: iconst_0
      //   28: aaload
      //   29: getfield param_contents_size : J
      //   32: putfield contents_size : J
      //   35: aload_0
      //   36: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   39: aload_1
      //   40: iconst_0
      //   41: aaload
      //   42: getfield param_received_size : J
      //   45: putfield received_size : J
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_0
      //   51: invokespecial task_setup : ()Z
      //   54: ifne -> 76
      //   57: aload_0
      //   58: getfield http_connection : Ljava/net/HttpURLConnection;
      //   61: ifnull -> 71
      //   64: aload_0
      //   65: getfield http_connection : Ljava/net/HttpURLConnection;
      //   68: invokevirtual disconnect : ()V
      //   71: iconst_0
      //   72: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   75: areturn
      //   76: aload_0
      //   77: invokevirtual isCancelled : ()Z
      //   80: ifeq -> 103
      //   83: aload_0
      //   84: getfield tmp_file : Ljava/io/File;
      //   87: invokevirtual delete : ()Z
      //   90: pop
      //   91: aload_0
      //   92: getfield http_connection : Ljava/net/HttpURLConnection;
      //   95: invokevirtual disconnect : ()V
      //   98: iconst_0
      //   99: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   102: areturn
      //   103: aload_0
      //   104: invokespecial task_connect : ()Z
      //   107: ifne -> 122
      //   110: aload_0
      //   111: getfield http_connection : Ljava/net/HttpURLConnection;
      //   114: invokevirtual disconnect : ()V
      //   117: iconst_0
      //   118: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   121: areturn
      //   122: aload_0
      //   123: invokespecial task_copyfile : ()Z
      //   126: ifne -> 134
      //   129: iconst_0
      //   130: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   133: areturn
      //   134: aload_0
      //   135: monitorenter
      //   136: aload_0
      //   137: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   140: getstatic com/criware/filesystem/CriFsWebInstaller$TaskStatus.STOP : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   143: putfield status : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   146: aload_0
      //   147: monitorexit
      //   148: iconst_1
      //   149: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   152: areturn
      //   153: astore_1
      //   154: aload_0
      //   155: monitorexit
      //   156: aload_1
      //   157: athrow
      //   158: astore_1
      //   159: aload_0
      //   160: monitorexit
      //   161: aload_1
      //   162: athrow
      // Exception table:
      //   from	to	target	type
      //   22	50	158	finally
      //   136	148	153	finally
      //   154	156	153	finally
      //   159	161	158	finally
    }
    
    protected void onCancelled() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   6: getstatic com/criware/filesystem/CriFsWebInstaller$TaskStatus.STOP : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   9: putfield status : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   12: aload_0
      //   13: monitorexit
      //   14: return
      //   15: astore_1
      //   16: aload_0
      //   17: monitorexit
      //   18: aload_1
      //   19: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	15	finally
      //   16	18	15	finally
    }
    
    protected void onPostExecute(Boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield task_internal_info : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatusInfo;
      //   6: getstatic com/criware/filesystem/CriFsWebInstaller$TaskStatus.STOP : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   9: putfield status : Lcom/criware/filesystem/CriFsWebInstaller$TaskStatus;
      //   12: aload_0
      //   13: monitorexit
      //   14: return
      //   15: astore_1
      //   16: aload_0
      //   17: monitorexit
      //   18: aload_1
      //   19: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	15	finally
      //   16	18	15	finally
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\criware\filesystem\CriFsWebInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
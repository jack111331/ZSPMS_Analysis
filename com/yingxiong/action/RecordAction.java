package com.yingxiong.action;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.aliyun.sls.android.sdk.LOGClient;
import com.aliyun.sls.android.sdk.model.Log;
import com.aliyun.sls.android.sdk.model.LogGroup;
import com.aliyun.sls.android.sdk.utils.IPService;
import com.yingxiong.bean.RecordBean;
import com.yingxiong.common.AppOperator;
import com.yingxiong.common.ConfigSDK;
import com.yingxiong.until.DatabaseManager;
import com.yingxiong.until.MLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RecordAction {
  public static String OAID;
  
  private static final String TAG = "RecordSDK";
  
  @SuppressLint({"StaticFieldLeak"})
  private static volatile RecordAction mInstance;
  
  private String CID;
  
  private String LAC;
  
  private String MCC;
  
  private String MNC;
  
  private String SID;
  
  private String accessKeySecret = " ";
  
  private String accesskeyID = " ";
  
  private String appChannelId = "";
  
  private String appKey;
  
  private String appSecret;
  
  private String channelId = "";
  
  private String channelName = "";
  
  private String client_version;
  
  private Context context;
  
  private String endpoint = "";
  
  @SuppressLint({"HandlerLeak"})
  private Handler handler = new Handler() {
      public void handleMessage(Message param1Message) {
        if (param1Message.what != 1530101) {
          super.handleMessage(param1Message);
          return;
        } 
        RecordAction.access$002(RecordAction.this, (String)param1Message.obj);
      }
    };
  
  private volatile boolean isDbUp;
  
  private boolean isFirstUp = true;
  
  private String logStore = " ";
  
  private OnInitListener onInitListener;
  
  private OnRecordUpdateListener onRecordUpdateListener;
  
  private SharedPreferences pref;
  
  private String project = " ";
  
  private String sdk_version;
  
  private String source_ip = "";
  
  private String talkId;
  
  private Log creatLogWithNomalMsg(Log paramLog) {
    paramLog.PutContent("device_model", ConfigSDK.instance().getPhoneInfo());
    paramLog.PutContent("network_state", String.valueOf(ConfigSDK.instance().getAPNType()));
    paramLog.PutContent("resolution", ConfigSDK.instance().getPhoneDisplay());
    paramLog.PutContent("system_version", ConfigSDK.instance().geSystemVersion());
    paramLog.PutContent("user_agent", ConfigSDK.instance().getUserAgent());
    paramLog.PutContent("android_id", ConfigSDK.instance().getAndroidId());
    paramLog.PutContent("mac", ConfigSDK.instance().getAdresseMAC());
    paramLog.PutContent("ime", ConfigSDK.instance().getIme());
    paramLog.PutContent("ime_md5", ConfigSDK.md5(ConfigSDK.instance().getIme()));
    paramLog.PutContent("server_id", String.valueOf(0));
    paramLog.PutContent("role_id", String.valueOf(0));
    paramLog.PutContent("user_id", String.valueOf(0));
    paramLog.PutContent("role_key", String.valueOf(0));
    paramLog.PutContent("device_key", ConfigSDK.instance().getDeviceKey());
    paramLog.PutContent("oaid", OAID);
    return paramLog;
  }
  
  private void doUploadByOff() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic getInstance : ()Lcom/yingxiong/until/DatabaseManager;
    //   5: ldc com/yingxiong/bean/RecordBean
    //   7: invokevirtual getQueryAll : (Ljava/lang/Class;)Ljava/util/List;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull -> 53
    //   15: aload_1
    //   16: invokeinterface size : ()I
    //   21: ifle -> 53
    //   24: aload_0
    //   25: getfield context : Landroid/content/Context;
    //   28: invokestatic isNetworkAvailable : (Landroid/content/Context;)Z
    //   31: ifeq -> 53
    //   34: ldc com/yingxiong/action/RecordAction
    //   36: monitorenter
    //   37: aload_0
    //   38: invokespecial uploadLogByOff : ()V
    //   41: ldc com/yingxiong/action/RecordAction
    //   43: monitorexit
    //   44: goto -> 53
    //   47: astore_1
    //   48: ldc com/yingxiong/action/RecordAction
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: aload_0
    //   54: getfield context : Landroid/content/Context;
    //   57: invokestatic isNetworkAvailable : (Landroid/content/Context;)Z
    //   60: ifne -> 80
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield isDbUp : Z
    //   68: goto -> 80
    //   71: astore_1
    //   72: goto -> 83
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual printStackTrace : ()V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	75	java/lang/Exception
    //   2	11	71	finally
    //   15	37	75	java/lang/Exception
    //   15	37	71	finally
    //   37	44	47	finally
    //   48	51	47	finally
    //   51	53	75	java/lang/Exception
    //   51	53	71	finally
    //   53	68	75	java/lang/Exception
    //   53	68	71	finally
    //   76	80	71	finally
  }
  
  public static RecordAction getInstance() {
    // Byte code:
    //   0: ldc com/yingxiong/action/RecordAction
    //   2: monitorenter
    //   3: getstatic com/yingxiong/action/RecordAction.mInstance : Lcom/yingxiong/action/RecordAction;
    //   6: ifnonnull -> 42
    //   9: ldc com/yingxiong/action/RecordAction
    //   11: monitorenter
    //   12: getstatic com/yingxiong/action/RecordAction.mInstance : Lcom/yingxiong/action/RecordAction;
    //   15: ifnonnull -> 30
    //   18: new com/yingxiong/action/RecordAction
    //   21: astore_0
    //   22: aload_0
    //   23: invokespecial <init> : ()V
    //   26: aload_0
    //   27: putstatic com/yingxiong/action/RecordAction.mInstance : Lcom/yingxiong/action/RecordAction;
    //   30: ldc com/yingxiong/action/RecordAction
    //   32: monitorexit
    //   33: goto -> 42
    //   36: astore_0
    //   37: ldc com/yingxiong/action/RecordAction
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: getstatic com/yingxiong/action/RecordAction.mInstance : Lcom/yingxiong/action/RecordAction;
    //   45: astore_0
    //   46: ldc com/yingxiong/action/RecordAction
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc com/yingxiong/action/RecordAction
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	51	finally
    //   12	30	36	finally
    //   30	33	36	finally
    //   37	40	36	finally
    //   40	42	51	finally
    //   42	46	51	finally
  }
  
  private void getUploadInfo() {
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      URL uRL = new URL();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append("#");
      stringBuilder2.append(this.appKey);
      stringBuilder2.append(".json");
      this(stringBuilder2.toString());
      URLConnection uRLConnection = uRL.openConnection();
      uRLConnection.connect();
      InputStreamReader inputStreamReader = new InputStreamReader();
      this(uRLConnection.getInputStream());
      BufferedReader bufferedReader = new BufferedReader();
      this(inputStreamReader);
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          stringBuilder1.append(str);
          try {
            JSONObject jSONObject = new JSONObject();
            this(stringBuilder1.toString());
            String str1 = jSONObject.getString("switch_code");
            String str2 = jSONObject.getString("upload_strategy");
            SharedPreferences.Editor editor = this.pref.edit();
            editor.putString("switch_code", str1);
            editor.putString("upload_strategy", str2);
            editor.apply();
            MLog.e("RecordSDK", jSONObject.toString());
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(jSONException);
            stringBuilder.append("");
            MLog.e("RecordSDK", stringBuilder.toString());
          } 
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception);
      stringBuilder.append("");
      MLog.e("RecordSDK", stringBuilder.toString());
    } 
  }
  
  private boolean getUploadState() {
    if (this.context != null) {
      long l = this.pref.getLong("time", 0L);
      List list = DatabaseManager.getInstance().getQueryAll(RecordBean.class);
      if (this.pref.getString("switch_code", "1").equals("1") && isUpTime(l)) {
        if (this.isDbUp || list.size() == 0) {
          SharedPreferences.Editor editor = this.pref.edit();
          editor.putLong("time", (new Date()).getTime() / 1000L);
          editor.apply();
          this.isDbUp = false;
        } 
        return true;
      } 
      return false;
    } 
    return false;
  }
  
  private void initGSMCELL() {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)this.context.getSystemService("phone");
      try {
        String str = telephonyManager.getNetworkOperator();
        if (TextUtils.isEmpty(str))
          return; 
        this.MCC = str.substring(0, 3);
        this.MNC = getSimOperatorInfo();
        if (telephonyManager.getPhoneType() == 2) {
          CdmaCellLocation cdmaCellLocation = (CdmaCellLocation)telephonyManager.getCellLocation();
          this.CID = String.valueOf(cdmaCellLocation.getBaseStationId());
          this.LAC = String.valueOf(cdmaCellLocation.getNetworkId());
          this.SID = String.valueOf(cdmaCellLocation.getSystemId());
        } else {
          GsmCellLocation gsmCellLocation = (GsmCellLocation)telephonyManager.getCellLocation();
          this.CID = String.valueOf(gsmCellLocation.getCid());
          this.LAC = String.valueOf(gsmCellLocation.getLac());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(" MCC = ");
        stringBuilder.append(this.MCC);
        stringBuilder.append("\t MNC = ");
        stringBuilder.append(this.MNC);
        stringBuilder.append("\t LAC = ");
        stringBuilder.append(this.LAC);
        stringBuilder.append("\t CID = ");
        stringBuilder.append(this.CID);
        MLog.e("RecordSDK", stringBuilder.toString());
      } catch (Exception exception) {
        exception.printStackTrace();
        try {
          CdmaCellLocation cdmaCellLocation;
          if (exception.toString().contains("android.telephony.cdma.CdmaCellLocation cannot be cast to android.telephony.gsm.GsmCellLocation")) {
            cdmaCellLocation = (CdmaCellLocation)telephonyManager.getCellLocation();
            this.CID = String.valueOf(cdmaCellLocation.getBaseStationId());
            this.LAC = String.valueOf(cdmaCellLocation.getNetworkId());
            this.SID = String.valueOf(cdmaCellLocation.getSystemId());
          } else {
            GsmCellLocation gsmCellLocation = (GsmCellLocation)cdmaCellLocation.getCellLocation();
            this.CID = String.valueOf(gsmCellLocation.getCid());
            this.LAC = String.valueOf(gsmCellLocation.getLac());
          } 
          return;
        } catch (Exception exception1) {
          exception1.printStackTrace();
          return;
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static boolean isNetworkAvailable(Context paramContext) {
    boolean bool = true;
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (connectivityManager == null)
        return true; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        boolean bool1 = networkInfo.isAvailable();
        if (bool1)
          return bool; 
      } 
      return false;
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception);
      stringBuilder.append("");
      MLog.e("RecordSDK", stringBuilder.toString());
      return true;
    } 
  }
  
  private boolean isUpTime(long paramLong) {
    long l2;
    String str = this.pref.getString("upload_strategy", "0");
    long l1 = (new Date()).getTime() / 1000L;
    int i = str.hashCode();
    boolean bool = true;
    switch (i) {
      default:
        i = -1;
        break;
      case 54:
        if (str.equals("6")) {
          i = 6;
          break;
        } 
      case 53:
        if (str.equals("5")) {
          i = 5;
          break;
        } 
      case 52:
        if (str.equals("4")) {
          i = 4;
          break;
        } 
      case 51:
        if (str.equals("3")) {
          i = 3;
          break;
        } 
      case 50:
        if (str.equals("2")) {
          i = 2;
          break;
        } 
      case 49:
        if (str.equals("1")) {
          i = 1;
          break;
        } 
      case 48:
        if (str.equals("0")) {
          i = 0;
          break;
        } 
    } 
    switch (i) {
      default:
        l2 = 5L;
        break;
      case 6:
        l2 = 86400L;
        break;
      case 5:
        l2 = 43200L;
        break;
      case 4:
        l2 = 3600L;
        break;
      case 3:
        l2 = 1800L;
        break;
      case 2:
        l2 = 300L;
        break;
      case 1:
        l2 = 30L;
        break;
      case 0:
        l2 = 0L;
        break;
    } 
    if (l1 - paramLong < l2)
      bool = false; 
    return bool;
  }
  
  private Log map2Log(Log paramLog, Map<String, String> paramMap) {
    if (paramMap != null)
      try {
        if (!paramMap.isEmpty()) {
          Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
          while (true) {
            boolean bool = iterator.hasNext();
            if (bool) {
              try {
                Map.Entry entry = iterator.next();
                if (entry != null)
                  paramLog.PutContent(entry.getKey().toString(), entry.getValue().toString()); 
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
              continue;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("上传参数：");
            stringBuilder.append(paramMap.toString());
            MLog.e("RecordSDK", stringBuilder.toString());
            break;
          } 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return paramLog;
  }
  
  private void putFirstData() {
    if (this.isFirstUp)
      try {
        RecordBean recordBean = new RecordBean();
        this();
        recordBean.setActionType(0);
        recordBean.setEventId("1000");
        recordBean.setEventName("设备初始化");
        recordBean.setExtra("");
        recordBean.setEvent_uuid(ConfigSDK.instance().getEventUuid());
        uploadLog(recordBean);
        this.isFirstUp = false;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  private void upData(LogGroup paramLogGroup, List<RecordBean> paramList, RecordBean paramRecordBean, boolean paramBoolean) {
    LOGClient lOGClient = new LOGClient(this.endpoint, this.accesskeyID, this.accessKeySecret, this.project);
    try {
      lOGClient.PostLog(paramLogGroup, this.logStore);
      if (!paramBoolean) {
        MLog.e("RecordSDK", "在线上传成功");
        if (this.onRecordUpdateListener != null)
          this.onRecordUpdateListener.onDataUpdateListener(true, 1L); 
      } else {
        MLog.e("RecordSDK", "离线数据上传成功");
        if (this.onRecordUpdateListener != null)
          this.onRecordUpdateListener.onDBUpdateListener(true, paramList.size()); 
      } 
      return;
    } catch (Exception exception) {
      List list;
      exception.printStackTrace();
      if (!paramBoolean) {
        if (paramRecordBean != null) {
          DatabaseManager.getInstance().insert(paramRecordBean);
          if (this.onRecordUpdateListener != null) {
            list = DatabaseManager.getInstance().getQueryAll(RecordBean.class);
            this.onRecordUpdateListener.onDataUpdateListener(false, list.size());
          } 
        } 
        MLog.e("RecordSDK", "在线上传失败");
      } else {
        if (paramList != null && paramList.size() > 0) {
          DatabaseManager.getInstance().insertAll(paramList);
          if (this.onRecordUpdateListener != null)
            this.onRecordUpdateListener.onDBUpdateListener(false, paramList.size()); 
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list);
        stringBuilder.append("");
        MLog.e("RecordSDK", stringBuilder.toString());
        MLog.e("RecordSDK", "离线数据上传失败");
      } 
      return;
    } 
  }
  
  private void uploadLog(RecordBean paramRecordBean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc com/yingxiong/action/RecordAction
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial uploadLogData : (Lcom/yingxiong/bean/RecordBean;)V
    //   10: goto -> 22
    //   13: astore_1
    //   14: goto -> 28
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual printStackTrace : ()V
    //   22: ldc com/yingxiong/action/RecordAction
    //   24: monitorexit
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: ldc com/yingxiong/action/RecordAction
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	5	33	finally
    //   5	10	17	java/lang/Exception
    //   5	10	13	finally
    //   18	22	13	finally
    //   22	25	13	finally
    //   28	31	13	finally
    //   31	33	33	finally
  }
  
  private void uploadLogByOff() {
    String str1 = this.source_ip;
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = " no ip "; 
    final LogGroup logGroup = new LogGroup("sls test", str2);
    final List recordBeanList = DatabaseManager.getInstance().getQueryAll(RecordBean.class);
    if (!getUploadState())
      return; 
    AppOperator.runOnThread(new Runnable() {
          public void run() {
            try {
              RecordAction.access$602(RecordAction.this, true);
              for (RecordBean recordBean : recordBeanList) {
                String str;
                Log log1 = new Log();
                this();
                Log log2 = log1;
                if (recordBean.getActionType() == 0)
                  log2 = RecordAction.this.creatLogWithNomalMsg(log1); 
                log2.PutContent("appkey", recordBean.getAppkey());
                log2.PutContent("user_ip", recordBean.getDeviceidip());
                log2.PutContent("device_id", recordBean.getDeviceid());
                log2.PutContent("deviceid_type", ConfigSDK.DEVICEID_TYPE);
                log2.PutContent("event_time2", recordBean.getTime());
                log2.PutContent("buess_time", String.valueOf(recordBean.getTimestamp()));
                if (!TextUtils.isEmpty(recordBean.getChannelName())) {
                  log2.PutContent("channel_name", recordBean.getChannelName());
                } else {
                  log2.PutContent("channel_name", "默认");
                } 
                if (!TextUtils.isEmpty(recordBean.getChannelId())) {
                  log2.PutContent("channel_id", recordBean.getChannelId());
                } else {
                  log2.PutContent("channel_id", "0");
                } 
                log2.PutContent("event_id", recordBean.getEventId());
                log2.PutContent("event_name", recordBean.getEventName());
                RecordAction.this.map2Log(log2, (Map)JSON.parse(recordBean.getExtra()));
                log2.PutContent("error", recordBean.getError());
                if (ConfigSDK.instance().getDebugMode()) {
                  str = "ANDROID_TEST";
                } else {
                  str = "ANDROID";
                } 
                log2.PutContent("client_os", str);
                log2.PutContent("phone_cid", recordBean.getCID());
                log2.PutContent("phone_mcc", recordBean.getMCC());
                log2.PutContent("phone_mnc", recordBean.getMNC());
                log2.PutContent("phone_lac", recordBean.getLAC());
                log2.PutContent("phone_sid", recordBean.getSID());
                log2.PutContent("client_version", RecordAction.this.client_version);
                log2.PutContent("sdk_version", RecordAction.this.sdk_version);
                log2.PutContent("app_channel_id", RecordAction.this.appChannelId);
                recordBean.setChannelName(RecordAction.this.channelName);
                recordBean.setChannelId(RecordAction.this.channelId);
                if (TextUtils.equals("1999", recordBean.getEventId())) {
                  log2.PutContent("server_id", String.valueOf(0));
                  log2.PutContent("role_id", String.valueOf(0));
                  log2.PutContent("user_id", String.valueOf(0));
                  log2.PutContent("role_key", String.valueOf(0));
                } 
                if (!TextUtils.isEmpty(recordBean.getSessionId())) {
                  log2.PutContent("session_id", recordBean.getSessionId());
                } else {
                  log2.PutContent("session_id", RecordAction.this.talkId);
                } 
                logGroup.PutLog(log2);
              } 
              DatabaseManager.getInstance().deleteList(recordBeanList);
              RecordAction.this.upData(logGroup, recordBeanList, null, true);
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("离线数据条数：");
              stringBuilder.append(recordBeanList.size());
              MLog.e("RecordSDK", stringBuilder.toString());
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        });
  }
  
  private void uploadLogData(final RecordBean recordBean) {
    initGSMCELL();
    String str1 = this.source_ip;
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = " no ip "; 
    final LogGroup logGroup = new LogGroup("sls test", str2);
    Log log1 = new Log();
    Log log2 = log1;
    if (recordBean.getActionType() == 0)
      log2 = creatLogWithNomalMsg(log1); 
    log2.PutContent("session_id", this.talkId);
    log2.PutContent("appkey", this.appKey);
    log2.PutContent("user_ip", this.source_ip);
    log2.PutContent("device_id", ConfigSDK.instance().getDeviceId());
    log2.PutContent("deviceid_type", ConfigSDK.DEVICEID_TYPE);
    long l1 = ConfigSDK.instance().getPhoneTimeForLong();
    log2.PutContent("event_time2", ConfigSDK.instance().getPhoneTime(l1));
    long l2 = l1 / 1000L;
    log2.PutContent("buess_time", String.valueOf(l2));
    if (!TextUtils.isEmpty(this.channelName)) {
      log2.PutContent("channel_name", this.channelName);
    } else {
      log2.PutContent("channel_name", "默认");
    } 
    if (!TextUtils.isEmpty(this.channelId)) {
      log2.PutContent("channel_id", this.channelId);
    } else {
      log2.PutContent("channel_id", "0");
    } 
    try {
      String str;
      if (ConfigSDK.instance().getDebugMode()) {
        str = "ANDROID_TEST";
      } else {
        str = "ANDROID";
      } 
      log2.PutContent("client_os", str);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    log2.PutContent("phone_cid", this.CID);
    log2.PutContent("phone_mcc", this.MCC);
    log2.PutContent("phone_mnc", this.MNC);
    log2.PutContent("phone_lac", this.LAC);
    log2.PutContent("phone_sid", this.SID);
    log2.PutContent("client_version", this.client_version);
    log2.PutContent("sdk_version", this.sdk_version);
    recordBean.setCID(this.CID);
    recordBean.setMCC(this.MCC);
    recordBean.setMNC(this.MNC);
    recordBean.setLAC(this.LAC);
    recordBean.setSID(this.SID);
    recordBean.setSessionId(this.talkId);
    recordBean.setAppkey(this.appKey);
    recordBean.setChannelName(this.channelName);
    recordBean.setChannelId(this.channelId);
    recordBean.setTime(ConfigSDK.instance().getPhoneTime(l1));
    recordBean.setTimestamp(l2);
    recordBean.setDeviceid(ConfigSDK.instance().getDeviceId());
    recordBean.setDeviceidip(this.source_ip);
    log2.PutContent("event_id", recordBean.getEventId());
    log2.PutContent("event_name", recordBean.getEventName());
    if (TextUtils.equals("1999", recordBean.getEventId())) {
      log2.PutContent("server_id", String.valueOf(0));
      log2.PutContent("role_id", String.valueOf(0));
      log2.PutContent("user_id", String.valueOf(0));
      log2.PutContent("role_key", String.valueOf(0));
    } 
    log2.PutContent("app_channel_id", this.appChannelId);
    map2Log(log2, (Map<String, String>)JSON.parse(recordBean.getExtra()));
    log2.PutContent("error", recordBean.getError());
    logGroup.PutLog(log2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sessionId:");
    stringBuilder.append(this.talkId);
    MLog.e("RecordSDK", stringBuilder.toString());
    AppOperator.runOnThread(new Runnable() {
          public void run() {
            try {
              if (RecordAction.this.getUploadState()) {
                RecordAction.this.upData(logGroup, null, recordBean, false);
                MLog.e("RecordSDK", "在线上传成功");
                if (RecordAction.this.onRecordUpdateListener != null)
                  RecordAction.this.onRecordUpdateListener.onDataUpdateListener(true, 1L); 
                return;
              } 
              MLog.e("RecordSDK", "上传失败:开关关闭");
              DatabaseManager.getInstance().insert(recordBean);
              if (RecordAction.this.onRecordUpdateListener != null) {
                List list = DatabaseManager.getInstance().getQueryAll(RecordBean.class);
                RecordAction.this.onRecordUpdateListener.onDataUpdateListener(false, list.size());
              } 
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              MLog.e("RecordSDK", "在线上传失败");
              DatabaseManager.getInstance().insert(recordBean);
              if (RecordAction.this.onRecordUpdateListener != null) {
                List list = DatabaseManager.getInstance().getQueryAll(RecordBean.class);
                RecordAction.this.onRecordUpdateListener.onDataUpdateListener(false, list.size());
              } 
              return;
            } 
          }
        });
  }
  
  public void doInit(Context paramContext, String paramString1, String paramString2, String paramString3) {
    this.context = paramContext;
    try {
      this.appKey = ConfigSDK.instance().getAppKey();
      this.appSecret = ConfigSDK.instance().getAppSecret();
      this.endpoint = ConfigSDK.instance().getEndPoint();
      this.accesskeyID = ConfigSDK.instance().getAccesskeyID();
      this.accessKeySecret = ConfigSDK.instance().getAccessKeySecret();
      this.project = ConfigSDK.instance().getProjectName();
      this.logStore = ConfigSDK.instance().getLogStoreName();
      this.source_ip = "";
      this.channelName = paramString1;
      this.channelId = paramString2;
      this.appChannelId = paramString3;
      this.client_version = ConfigSDK.instance().getAppVersionName();
      this.sdk_version = "1.1.14";
      this.pref = this.context.getSharedPreferences("upload_info", 0);
      this.talkId = ConfigSDK.instance().getTalkId();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("初始化参数成功");
      stringBuilder.append(this.endpoint);
      stringBuilder.append("\nackeyID-");
      stringBuilder.append(this.accesskeyID);
      stringBuilder.append("\nacKeySecret-");
      stringBuilder.append(this.accessKeySecret);
      stringBuilder.append("\npj-");
      stringBuilder.append(this.project);
      stringBuilder.append("\nlog-");
      stringBuilder.append(this.logStore);
      MLog.e("RecordSDK", stringBuilder.toString());
      initGSMCELL();
      if (this.onInitListener != null)
        this.onInitListener.onSuccess(); 
    } catch (Exception exception) {
      exception.printStackTrace();
      if (this.onInitListener != null) {
        OnInitListener onInitListener = this.onInitListener;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("初始化异常");
        stringBuilder1.append(exception);
        onInitListener.onFail(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("初始化异常");
      stringBuilder.append(exception);
      MLog.e("RecordSDK", stringBuilder.toString());
    } 
    try {
      IPService.getInstance().asyncGetIp("https://api.ipify.org?format=text", this.handler);
      DatabaseManager.init(this.context);
      Runnable runnable = new Runnable() {
          public void run() {
            try {
              if (!TextUtils.isEmpty(RecordAction.this.appKey))
                RecordAction.this.getUploadInfo(); 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        };
      super(this);
      AppOperator.runOnThread(runnable);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    putFirstData();
  }
  
  public String getSimOperatorInfo() {
    try {
      String str = ((TelephonyManager)this.context.getSystemService("phone")).getSimOperator();
      if (str == null)
        return "0"; 
      if (str.equals("46000") || str.equals("46002"))
        return "0"; 
      if (str.equals("46001"))
        return "1"; 
      if (str.equals("46003"))
        return "2"; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "0";
  }
  
  public void onPause() {
    doUploadByOff();
  }
  
  public void onResume() {
    doUploadByOff();
  }
  
  public void recordAction(Map<String, String> paramMap) {
    putFirstData();
    try {
      RecordBean recordBean = new RecordBean();
      this();
      recordBean.setExtra(JSON.toJSONString(paramMap));
      recordBean.setError("");
      recordBean.setActionType(2);
      recordBean.setEvent_uuid(ConfigSDK.instance().getEventUuid());
      uploadLog(recordBean);
      doUploadByOff();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void recordActionByJson(String paramString) {
    RecordBean recordBean = null;
    try {
      RecordBean recordBean1 = new RecordBean();
      this();
      try {
        recordBean = (RecordBean)JSON.parseObject(paramString, RecordBean.class);
        recordBean1 = recordBean;
      } catch (Exception exception) {
        MLog.e("RecordSDK", "log格式不是json格式，请检查");
      } 
      putFirstData();
      try {
        recordBean1.setExtra(paramString);
        recordBean1.setEvent_uuid(ConfigSDK.instance().getEventUuid());
        recordBean1.setError("");
        recordBean1.setActionType(2);
        uploadLog(recordBean1);
        doUploadByOff();
      } catch (Exception exception1) {
        exception1.printStackTrace();
      } 
      return;
    } catch (Exception exception1) {
      exception1 = exception;
    } 
    MLog.e("RecordSDK", "log格式不是json格式，请检查");
  }
  
  public void recordErrorAction(String paramString) {
    try {
      RecordBean recordBean = new RecordBean();
      this();
      recordBean.setActionType(2);
      recordBean.setEventId("1999");
      recordBean.setEventName("错误信息上报");
      recordBean.setExtra("");
      recordBean.setError(paramString);
      recordBean.setSessionId(this.talkId);
      recordBean.setAppkey(this.appKey);
      recordBean.setChannelName(this.channelName);
      recordBean.setChannelId(this.channelId);
      recordBean.setCID(this.CID);
      recordBean.setMCC(this.MCC);
      recordBean.setMNC(this.MNC);
      recordBean.setLAC(this.LAC);
      recordBean.setSID(this.SID);
      recordBean.setEvent_uuid(ConfigSDK.instance().getEventUuid());
      long l = ConfigSDK.instance().getPhoneTimeForLong();
      recordBean.setTime(ConfigSDK.instance().getPhoneTime(l));
      recordBean.setTimestamp(l / 1000L);
      recordBean.setDeviceid(ConfigSDK.instance().getDeviceId());
      recordBean.setDeviceidip(this.source_ip);
      DatabaseManager.getInstance().insert(recordBean);
      MLog.e("RecordSDK", "错误log已储存");
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("错误");
      stringBuilder.append(exception);
      MLog.e("RecordSDK", stringBuilder.toString());
    } 
  }
  
  public void setOnInitListener(OnInitListener paramOnInitListener) {
    this.onInitListener = paramOnInitListener;
  }
  
  public void setOnRecordUpdateListener(OnRecordUpdateListener paramOnRecordUpdateListener) {
    this.onRecordUpdateListener = paramOnRecordUpdateListener;
  }
  
  public void updataOaid(String paramString) {
    OAID = paramString;
  }
  
  public static interface OnInitListener {
    void onFail(String param1String);
    
    void onSuccess();
  }
  
  public static interface OnRecordUpdateListener {
    void onDBUpdateListener(boolean param1Boolean, long param1Long);
    
    void onDataUpdateListener(boolean param1Boolean, long param1Long);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\action\RecordAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
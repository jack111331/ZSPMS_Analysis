package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

public class AidTask {
  private static final String AID_FILE_NAME = "weibo_sdk_aid";
  
  private static final int MAX_RETRY_NUM = 3;
  
  private static final String TAG = "AidTask";
  
  private static final int VERSION = 1;
  
  public static final int WHAT_LOAD_AID_ERR = 1002;
  
  public static final int WHAT_LOAD_AID_SUC = 1001;
  
  private static AidTask sInstance;
  
  private AidInfo mAidInfo;
  
  private String mAppKey;
  
  private Context mContext;
  
  private CallbackHandler mHandler;
  
  private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
  
  private AidTask(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
    (new Thread(new Runnable() {
          public void run() {
            for (byte b = 0;; b++) {
              if (b >= 1)
                return; 
              File file = AidTask.this.getAidInfoFile(b);
              try {
                file.delete();
              } catch (Exception exception) {}
            } 
          }
        })).start();
  }
  
  private void cacheAidInfo(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore #4
    //   19: aload_0
    //   20: iconst_1
    //   21: invokespecial getAidInfoFile : (I)Ljava/io/File;
    //   24: astore #5
    //   26: new java/io/FileOutputStream
    //   29: astore #6
    //   31: aload #6
    //   33: aload #5
    //   35: invokespecial <init> : (Ljava/io/File;)V
    //   38: aload #6
    //   40: aload_1
    //   41: invokevirtual getBytes : ()[B
    //   44: invokevirtual write : ([B)V
    //   47: aload #6
    //   49: invokevirtual close : ()V
    //   52: goto -> 91
    //   55: astore_1
    //   56: goto -> 71
    //   59: astore_1
    //   60: aload #6
    //   62: astore_1
    //   63: goto -> 83
    //   66: astore_1
    //   67: aload #4
    //   69: astore #6
    //   71: aload #6
    //   73: ifnull -> 81
    //   76: aload #6
    //   78: invokevirtual close : ()V
    //   81: aload_1
    //   82: athrow
    //   83: aload_1
    //   84: ifnull -> 91
    //   87: aload_1
    //   88: invokevirtual close : ()V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_3
    //   101: astore_1
    //   102: goto -> 83
    //   105: astore_1
    //   106: goto -> 91
    //   109: astore #6
    //   111: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   2	7	94	finally
    //   19	38	99	java/lang/Exception
    //   19	38	66	finally
    //   38	47	59	java/lang/Exception
    //   38	47	55	finally
    //   47	52	105	java/io/IOException
    //   47	52	94	finally
    //   76	81	109	java/io/IOException
    //   76	81	94	finally
    //   81	83	94	finally
    //   87	91	105	java/io/IOException
    //   87	91	94	finally
  }
  
  private static String encryptRsa(String paramString1, String paramString2) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(1, getPublicKey(paramString2));
    byte[] arrayOfByte = paramString1.getBytes("UTF-8");
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      int i = 0;
    } finally {
      paramString1 = null;
    } 
    if (paramString2 != null)
      try {
        paramString2.close();
      } catch (IOException iOException) {} 
    throw paramString1;
  }
  
  private static String genMfpString(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      String str = getOS();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("1", str); 
      str = getImei(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("2", str); 
      str = getMeid(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("3", str); 
      str = getImsi(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("4", str); 
      str = getMac(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("5", str); 
      str = getIccid(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("6", str); 
      str = getSerialNo();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("7", str); 
      str = getAndroidId(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("10", str); 
      str = getCpu();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("13", str); 
      str = getModel();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("14", str); 
      str = getSdSize();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("15", str); 
      str = getResolution(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("16", str); 
      str = getSsid(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("17", str); 
      str = getDeviceName();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("18", str); 
      null = getConnectType(paramContext);
      if (!TextUtils.isEmpty(null))
        jSONObject.put("19", null); 
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      return "";
    } 
  }
  
  private void generateAid(String paramString, final AidResultCallBack callback) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.mAppKey = paramString;
    (new Thread(new Runnable() {
          public void run() {
            AidTask.this.mTaskLock.lock();
            AidTask.AidInfo aidInfo1 = AidTask.this.loadAidInfoFromCache();
            String str1 = null;
            AidTask.AidInfo aidInfo2 = aidInfo1;
            String str2 = str1;
            if (aidInfo1 == null) {
              try {
                str2 = AidTask.this.loadAidFromNet();
                aidInfo2 = AidTask.AidInfo.parseJson(str2);
                try {
                  AidTask.this.cacheAidInfo(str2);
                  AidTask.this.mAidInfo = aidInfo2;
                  str2 = str1;
                } catch (WeiboException null) {}
              } catch (WeiboException weiboException) {
                aidInfo2 = aidInfo1;
              } 
              StringBuilder stringBuilder = new StringBuilder("AidTaskInit WeiboException Msg : ");
              stringBuilder.append(weiboException.getMessage());
              LogUtil.e("AidTask", stringBuilder.toString());
            } 
            AidTask.this.mTaskLock.unlock();
            Message message = Message.obtain();
            if (aidInfo2 != null) {
              message.what = 1001;
              message.obj = aidInfo2;
            } else {
              message.what = 1002;
              message.obj = weiboException;
            } 
            AidTask.this.mHandler.setCallback(callback);
            AidTask.this.mHandler.sendMessage(message);
          }
        })).start();
  }
  
  private File getAidInfoFile(int paramInt) {
    File file = this.mContext.getFilesDir();
    StringBuilder stringBuilder = new StringBuilder("weibo_sdk_aid");
    stringBuilder.append(paramInt);
    return new File(file, stringBuilder.toString());
  }
  
  private static String getAndroidId(Context paramContext) {
    try {
      return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getConnectType(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null) {
        String str1;
        if (networkInfo.getType() == 0) {
          switch (networkInfo.getSubtype()) {
            default:
              return "none";
            case 13:
              return "4G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
              return "3G";
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
              break;
          } 
          str1 = "2G";
        } else {
          if (str1.getType() == 1)
            return "wifi"; 
          str1 = "none";
        } 
        return str1;
      } 
    } catch (Exception exception) {}
    String str = "none";
  }
  
  private static String getCpu() {
    try {
      return Build.CPU_ABI;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getDeviceName() {
    try {
      return Build.BRAND;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getIccid(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getImei(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getImsi(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static AidTask getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/utils/AidTask
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/utils/AidTask.sInstance : Lcom/sina/weibo/sdk/utils/AidTask;
    //   6: ifnonnull -> 22
    //   9: new com/sina/weibo/sdk/utils/AidTask
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/sina/weibo/sdk/utils/AidTask.sInstance : Lcom/sina/weibo/sdk/utils/AidTask;
    //   22: getstatic com/sina/weibo/sdk/utils/AidTask.sInstance : Lcom/sina/weibo/sdk/utils/AidTask;
    //   25: astore_0
    //   26: ldc com/sina/weibo/sdk/utils/AidTask
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/sina/weibo/sdk/utils/AidTask
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  private static String getMac(Context paramContext) {
    try {
      String str;
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager == null)
        return ""; 
      WifiInfo wifiInfo = wifiManager.getConnectionInfo();
      if (wifiInfo != null) {
        str = wifiInfo.getMacAddress();
      } else {
        str = "";
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getMeid(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getMfp(Context paramContext) {
    String str2 = genMfpString(paramContext);
    String str1 = "";
    try {
      String str = new String();
      this(str2.getBytes(), "UTF-8");
      str1 = str;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    StringBuilder stringBuilder = new StringBuilder("genMfpString() utf-8 string : ");
    stringBuilder.append(str1);
    LogUtil.d("AidTask", stringBuilder.toString());
    try {
      str1 = encryptRsa(str1, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
      stringBuilder = new StringBuilder();
      this("encryptRsa() string : ");
      stringBuilder.append(str1);
      LogUtil.d("AidTask", stringBuilder.toString());
      return str1;
    } catch (Exception exception) {
      LogUtil.e("AidTask", exception.getMessage());
      return "";
    } 
  }
  
  private static String getModel() {
    try {
      return Build.MODEL;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getOS() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("Android ");
      stringBuilder.append(Build.VERSION.RELEASE);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static PublicKey getPublicKey(String paramString) throws Exception {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(paramString.getBytes()));
    return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
  }
  
  private static String getResolution(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      this();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      StringBuilder stringBuilder = new StringBuilder();
      this(String.valueOf(String.valueOf(displayMetrics.widthPixels)));
      stringBuilder.append("*");
      stringBuilder.append(String.valueOf(displayMetrics.heightPixels));
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getSdSize() {
    try {
      File file = Environment.getExternalStorageDirectory();
      StatFs statFs = new StatFs();
      this(file.getPath());
      long l = statFs.getBlockSize();
      return Long.toString(statFs.getBlockCount() * l);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getSerialNo() {
    String str = "";
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      String str1 = (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { "ro.serialno", "unknown" });
      str = str1;
    } catch (Exception exception) {}
    return str;
  }
  
  private static String getSsid(Context paramContext) {
    try {
      WifiInfo wifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (wifiInfo != null)
        return wifiInfo.getSSID(); 
    } catch (Exception exception) {}
    return "";
  }
  
  private void initAidInfo(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.mAppKey = paramString;
    (new Thread(new Runnable() {
          public void run() {
            if (!AidTask.this.mTaskLock.tryLock()) {
              LogUtil.e("AidTask", "tryLock : false, return");
              return;
            } 
            AidTask.AidInfo aidInfo = AidTask.this.loadAidInfoFromCache();
            if (aidInfo == null) {
              int i = 1;
              while (true) {
                int j = i + 1;
                try {
                  String str = AidTask.this.loadAidFromNet();
                  aidInfo = AidTask.AidInfo.parseJson(str);
                  AidTask.this.cacheAidInfo(str);
                  AidTask.this.mAidInfo = aidInfo;
                  break;
                } catch (WeiboException weiboException) {
                  StringBuilder stringBuilder = new StringBuilder("AidTaskInit WeiboException Msg : ");
                  stringBuilder.append(weiboException.getMessage());
                  LogUtil.e("AidTask", stringBuilder.toString());
                  i = j;
                  if (j >= 3)
                    break; 
                } 
              } 
            } else {
              AidTask.this.mAidInfo = (AidTask.AidInfo)weiboException;
            } 
            AidTask.this.mTaskLock.unlock();
          }
        })).start();
  }
  
  private String loadAidFromNet() throws WeiboException {
    String str1 = this.mContext.getPackageName();
    String str2 = Utility.getSign(this.mContext, str1);
    String str3 = getMfp(this.mContext);
    WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
    weiboParameters.put("appkey", this.mAppKey);
    weiboParameters.put("mfp", str3);
    weiboParameters.put("packagename", str1);
    weiboParameters.put("key_hash", str2);
    try {
      str1 = NetUtils.internalHttpRequest(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", weiboParameters);
      StringBuilder stringBuilder = new StringBuilder();
      this("loadAidFromNet response : ");
      stringBuilder.append(str1);
      LogUtil.d("AidTask", stringBuilder.toString());
      return str1;
    } catch (WeiboException weiboException) {
      StringBuilder stringBuilder = new StringBuilder("loadAidFromNet WeiboException Msg : ");
      stringBuilder.append(weiboException.getMessage());
      LogUtil.d("AidTask", stringBuilder.toString());
      throw weiboException;
    } 
  }
  
  private AidInfo loadAidInfoFromCache() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: invokespecial getAidInfoFile : (I)Ljava/io/File;
    //   7: astore_1
    //   8: new java/io/FileInputStream
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokespecial <init> : (Ljava/io/File;)V
    //   17: aload_2
    //   18: invokevirtual available : ()I
    //   21: newarray byte
    //   23: astore_1
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual read : ([B)I
    //   29: pop
    //   30: new java/lang/String
    //   33: astore_3
    //   34: aload_3
    //   35: aload_1
    //   36: invokespecial <init> : ([B)V
    //   39: aload_3
    //   40: invokestatic parseJson : (Ljava/lang/String;)Lcom/sina/weibo/sdk/utils/AidTask$AidInfo;
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual close : ()V
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: goto -> 59
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull -> 67
    //   63: aload_2
    //   64: invokevirtual close : ()V
    //   67: aload_1
    //   68: athrow
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull -> 88
    //   76: aload_2
    //   77: invokevirtual close : ()V
    //   80: goto -> 88
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    //   88: aload_0
    //   89: monitorexit
    //   90: aconst_null
    //   91: areturn
    //   92: astore_1
    //   93: goto -> 72
    //   96: astore_2
    //   97: goto -> 48
    //   100: astore_2
    //   101: goto -> 67
    //   104: astore_2
    //   105: goto -> 88
    // Exception table:
    //   from	to	target	type
    //   2	17	69	java/lang/Exception
    //   2	17	56	finally
    //   17	44	92	java/lang/Exception
    //   17	44	52	finally
    //   44	48	96	java/io/IOException
    //   44	48	83	finally
    //   63	67	100	java/io/IOException
    //   63	67	83	finally
    //   67	69	83	finally
    //   76	80	104	java/io/IOException
    //   76	80	83	finally
  }
  
  private static int splite(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (paramInt1 >= paramArrayOfbyte.length) ? -1 : Math.min(paramArrayOfbyte.length - paramInt1, paramInt2);
  }
  
  public void aidTaskInit(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    LogUtil.e("AidTask", "aidTaskInit ");
    initAidInfo(paramString);
  }
  
  public void getAidAsync(String paramString, AidResultCallBack paramAidResultCallBack) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (this.mAidInfo != null && paramAidResultCallBack != null) {
      paramAidResultCallBack.onAidGenSuccessed(this.mAidInfo.cloneAidInfo());
      return;
    } 
    generateAid(paramString, paramAidResultCallBack);
  }
  
  public AidInfo getAidSync(String paramString) throws WeiboException {
    if (TextUtils.isEmpty(paramString))
      return null; 
    LogUtil.e("AidTask", "getAidSync ");
    if (this.mAidInfo == null)
      aidTaskInit(paramString); 
    return this.mAidInfo;
  }
  
  public static final class AidInfo {
    private String mAid;
    
    private String mSubCookie;
    
    public static AidInfo parseJson(String param1String) throws WeiboException {
      AidInfo aidInfo = new AidInfo();
      try {
        JSONObject jSONObject = new JSONObject();
        this(param1String);
        if (!jSONObject.has("error") && !jSONObject.has("error_code")) {
          aidInfo.mAid = jSONObject.optString("aid", "");
          aidInfo.mSubCookie = jSONObject.optString("sub", "");
          return aidInfo;
        } 
        LogUtil.d("AidTask", "loadAidFromNet has error !!!");
        WeiboException weiboException = new WeiboException();
        this("loadAidFromNet has error !!!");
        throw weiboException;
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder("loadAidFromNet JSONException Msg : ");
        stringBuilder.append(jSONException.getMessage());
        LogUtil.d("AidTask", stringBuilder.toString());
        throw new WeiboException("loadAidFromNet has error !!!");
      } 
    }
    
    AidInfo cloneAidInfo() {
      AidInfo aidInfo = new AidInfo();
      aidInfo.mAid = this.mAid;
      aidInfo.mSubCookie = this.mSubCookie;
      return aidInfo;
    }
    
    public String getAid() {
      return this.mAid;
    }
    
    public String getSubCookie() {
      return this.mSubCookie;
    }
  }
  
  public static interface AidResultCallBack {
    void onAidGenFailed(Exception param1Exception);
    
    void onAidGenSuccessed(AidTask.AidInfo param1AidInfo);
  }
  
  private static class CallbackHandler extends Handler {
    private WeakReference<AidTask.AidResultCallBack> callBackReference;
    
    public CallbackHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      AidTask.AidResultCallBack aidResultCallBack = this.callBackReference.get();
      switch (param1Message.what) {
        default:
          return;
        case 1002:
          if (aidResultCallBack != null)
            aidResultCallBack.onAidGenFailed((Exception)param1Message.obj); 
        case 1001:
          break;
      } 
      if (aidResultCallBack != null)
        aidResultCallBack.onAidGenSuccessed(((AidTask.AidInfo)param1Message.obj).cloneAidInfo()); 
    }
    
    public void setCallback(AidTask.AidResultCallBack param1AidResultCallBack) {
      if (this.callBackReference != null) {
        if ((AidTask.AidResultCallBack)this.callBackReference.get() == param1AidResultCallBack)
          return; 
        this.callBackReference = new WeakReference<AidTask.AidResultCallBack>(param1AidResultCallBack);
      } else {
        this.callBackReference = new WeakReference<AidTask.AidResultCallBack>(param1AidResultCallBack);
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\AidTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
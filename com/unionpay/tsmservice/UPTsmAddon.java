package com.unionpay.tsmservice;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.tsmservice.request.ActivateVendorPayRequestParams;
import com.unionpay.tsmservice.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.result.AddCardResult;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.EncryptDataResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetEncryptDataResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.GetSeIdResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OnlinePaymentVerifyResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.result.VendorPayStatusResult;
import com.unionpay.tsmservice.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class UPTsmAddon {
  private static UPTsmAddon a = null;
  
  private static ArrayList<UPTsmConnectionListener> b = null;
  
  private HashMap<String, ITsmCallback> A = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> B = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> C = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> D = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> E = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> F = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> G = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> H = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> I = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> J = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> K = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> L = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> M = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> N = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> O = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> P = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> Q = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> R = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> S = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmActivityCallback> T = new HashMap<String, ITsmActivityCallback>();
  
  private int[] U;
  
  private final Handler.Callback V = new UPTsmAddon$1(this);
  
  private final Handler W = new Handler(Looper.getMainLooper(), this.V);
  
  private Context c = null;
  
  private ServiceConnection d = null;
  
  private ITsmService e = null;
  
  private boolean f = false;
  
  private int g = 1;
  
  private boolean h = false;
  
  private HashMap<String, ITsmCallback> i = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> j = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> k = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> l = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> m = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> n = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> o = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> p = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> q = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> r = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> s = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> t = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> u = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> v = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> w = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> x = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> y = new HashMap<String, ITsmCallback>();
  
  private HashMap<String, ITsmCallback> z = new HashMap<String, ITsmCallback>();
  
  private UPTsmAddon(Context paramContext) {
    this.c = paramContext;
    this.U = new int[42];
    if (!a(paramContext))
      throw new RuntimeException(); 
  }
  
  private static int a(int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    return (new SessionKeyReExchange(a, paramInt, paramRequestParams, paramITsmCallback)).reExchangeKey();
  }
  
  private static int a(int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    return (new SessionKeyReExchange(a, paramInt, paramRequestParams, paramITsmCallback, paramITsmProgressCallback)).reExchangeKey();
  }
  
  private static int a(int paramInt1, SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams, int paramInt2, OnSafetyKeyboardCallback paramOnSafetyKeyboardCallback, Context paramContext) throws RemoteException {
    return (new SessionKeyReExchange(a, paramInt1, paramSafetyKeyboardRequestParams, paramInt2, paramOnSafetyKeyboardCallback, paramContext)).reExchangeKey();
  }
  
  private String a(Bundle paramBundle) {
    String str2 = "";
    Parcel parcel = Parcel.obtain();
    parcel.writeBundle(paramBundle);
    byte[] arrayOfByte = parcel.marshall();
    String str1 = str2;
    if (arrayOfByte != null) {
      str1 = str2;
      if (arrayOfByte.length != 0)
        str1 = b(Base64.encodeToString(arrayOfByte, 0)); 
    } 
    parcel.recycle();
    return str1;
  }
  
  private static HashMap<String, String> a(HashMap<String, String> paramHashMap) {
    if (paramHashMap == null)
      return new HashMap<String, String>(); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : paramHashMap.keySet()) {
      if (str != null) {
        String str1 = paramHashMap.get(str);
        if (str1 != null)
          hashMap.put(new String(str), new String(str1)); 
      } 
    } 
    return (HashMap)hashMap;
  }
  
  private void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   5: ifnull -> 61
    //   8: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   11: invokevirtual size : ()I
    //   14: ifle -> 61
    //   17: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   20: invokevirtual iterator : ()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface hasNext : ()Z
    //   30: ifeq -> 61
    //   33: aload_1
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: checkcast com/unionpay/tsmservice/UPTsmAddon$UPTsmConnectionListener
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull -> 24
    //   47: aload_2
    //   48: invokeinterface onTsmConnected : ()V
    //   53: goto -> 24
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    // Exception table:
    //   from	to	target	type
    //   2	24	56	finally
    //   24	43	56	finally
    //   47	53	56	finally
  }
  
  private static boolean a(Context paramContext) {
    boolean bool;
    try {
      bool = IUPJniInterface.iJE(paramContext);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  private static boolean a(String paramString) {
    boolean bool;
    try {
      bool = IUPJniInterface.cSKV(paramString);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  private String b(String paramString) {
    String str;
    try {
      paramString = IUPJniInterface.eMG(paramString, this.g);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   5: ifnull -> 61
    //   8: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   11: invokevirtual size : ()I
    //   14: ifle -> 61
    //   17: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   20: invokevirtual iterator : ()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface hasNext : ()Z
    //   30: ifeq -> 61
    //   33: aload_1
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: checkcast com/unionpay/tsmservice/UPTsmAddon$UPTsmConnectionListener
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull -> 24
    //   47: aload_2
    //   48: invokeinterface onTsmDisconnected : ()V
    //   53: goto -> 24
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    // Exception table:
    //   from	to	target	type
    //   2	24	56	finally
    //   24	43	56	finally
    //   47	53	56	finally
  }
  
  private String c(String paramString) {
    String str;
    try {
      paramString = IUPJniInterface.dMG(paramString, this.g);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  private boolean c() {
    null = true;
    String str = e("com.unionpay.tsmservice");
    if (str != null && str.compareTo("01.00.11") >= 0) {
      if (str.compareTo("01.00.18") >= 0) {
        this.g = 1;
        this.h = true;
        return null;
      } 
      if (str.compareTo("01.00.12") >= 0 && str.compareTo("01.00.16") <= 0) {
        this.g = 2;
        this.h = false;
        return null;
      } 
      if (str.compareTo("01.00.17") == 0 || str.compareTo("01.00.11") == 0) {
        this.g = 1;
        this.h = false;
        return null;
      } 
      return false;
    } 
    return false;
  }
  
  private boolean d(String paramString) {
    String str = e("com.unionpay.tsmservice");
    return (str != null && str.compareTo(paramString) >= 0);
  }
  
  private String e(String paramString) {
    String str = null;
    PackageManager packageManager = this.c.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      nameNotFoundException = null;
    } 
    if (nameNotFoundException != null)
      str = ((PackageInfo)nameNotFoundException).versionName; 
    return str;
  }
  
  private static String f(String paramString) {
    try {
      JSONObject jSONObject;
      if (TextUtils.isEmpty(paramString)) {
        jSONObject = new JSONObject();
        this();
      } else {
        jSONObject = new JSONObject(paramString);
      } 
      jSONObject.put("jarVersionCode", 28);
      String str = jSONObject.toString();
      paramString = str;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return paramString;
  }
  
  private String g(String paramString) {
    try {
      JSONObject jSONObject;
      if (TextUtils.isEmpty(paramString)) {
        jSONObject = new JSONObject();
        this();
      } else {
        jSONObject = new JSONObject(paramString);
      } 
      jSONObject.put("packageName", this.c.getPackageName());
      String str = jSONObject.toString();
      paramString = str;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return paramString;
  }
  
  public static UPTsmAddon getInstance(Context paramContext) {
    if (paramContext == null)
      return null; 
    if (a == null)
      a = new UPTsmAddon(paramContext.getApplicationContext()); 
    if (b == null)
      b = new ArrayList<UPTsmConnectionListener>(); 
    return a;
  }
  
  public int activateVendorPay(ActivateVendorPayRequestParams paramActivateVendorPayRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ifnonnull -> 18
    //   9: bipush #-3
    //   11: istore #4
    //   13: aload_0
    //   14: monitorexit
    //   15: iload #4
    //   17: ireturn
    //   18: iload_3
    //   19: istore #4
    //   21: aload_0
    //   22: ldc_w '01.00.20'
    //   25: invokespecial d : (Ljava/lang/String;)Z
    //   28: ifeq -> 13
    //   31: iload_3
    //   32: istore #4
    //   34: aload_0
    //   35: invokespecial c : ()Z
    //   38: ifeq -> 13
    //   41: aload_0
    //   42: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   45: ifnull -> 297
    //   48: aload_0
    //   49: getfield c : Landroid/content/Context;
    //   52: invokevirtual getPackageName : ()Ljava/lang/String;
    //   55: invokestatic a : (Ljava/lang/String;)Z
    //   58: ifeq -> 285
    //   61: new com/unionpay/tsmservice/request/ActivateVendorPayRequestParams
    //   64: astore #5
    //   66: aload #5
    //   68: invokespecial <init> : ()V
    //   71: ldc ''
    //   73: astore #6
    //   75: aload_1
    //   76: ifnull -> 85
    //   79: aload_1
    //   80: invokevirtual getReserve : ()Ljava/lang/String;
    //   83: astore #6
    //   85: aload #6
    //   87: astore #7
    //   89: aload_0
    //   90: getfield h : Z
    //   93: ifeq -> 107
    //   96: aload_0
    //   97: aload #6
    //   99: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   102: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   105: astore #7
    //   107: aload #7
    //   109: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   112: ifne -> 126
    //   115: aload #5
    //   117: aload_0
    //   118: aload #7
    //   120: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual setReserve : (Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield O : Ljava/util/HashMap;
    //   130: aload_0
    //   131: getfield U : [I
    //   134: bipush #37
    //   136: iaload
    //   137: invokestatic valueOf : (I)Ljava/lang/String;
    //   140: aload_2
    //   141: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload_0
    //   146: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   149: astore #8
    //   151: new com/unionpay/tsmservice/UPTsmAddon$b
    //   154: astore #7
    //   156: aload_0
    //   157: getfield U : [I
    //   160: astore #6
    //   162: aload #6
    //   164: bipush #37
    //   166: iaload
    //   167: istore #4
    //   169: aload #6
    //   171: bipush #37
    //   173: iload #4
    //   175: iconst_1
    //   176: iadd
    //   177: iastore
    //   178: aload #7
    //   180: aload_0
    //   181: bipush #37
    //   183: iload #4
    //   185: iconst_0
    //   186: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   189: aload #8
    //   191: aload #5
    //   193: aload #7
    //   195: invokeinterface activateVendorPay : (Lcom/unionpay/tsmservice/request/ActivateVendorPayRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   200: istore_3
    //   201: iload_3
    //   202: ifeq -> 244
    //   205: aload_0
    //   206: getfield O : Ljava/util/HashMap;
    //   209: astore #6
    //   211: aload_0
    //   212: getfield U : [I
    //   215: astore #7
    //   217: aload #7
    //   219: bipush #37
    //   221: iaload
    //   222: iconst_1
    //   223: isub
    //   224: istore #4
    //   226: aload #7
    //   228: bipush #37
    //   230: iload #4
    //   232: iastore
    //   233: aload #6
    //   235: iload #4
    //   237: invokestatic valueOf : (I)Ljava/lang/String;
    //   240: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: iload_3
    //   245: istore #4
    //   247: bipush #-2
    //   249: iload_3
    //   250: if_icmpne -> 13
    //   253: bipush #37
    //   255: aload_1
    //   256: aload_2
    //   257: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   260: istore #4
    //   262: goto -> 13
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual printStackTrace : ()V
    //   270: new android/os/RemoteException
    //   273: astore_1
    //   274: aload_1
    //   275: invokespecial <init> : ()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: bipush #37
    //   287: aload_1
    //   288: aload_2
    //   289: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   292: istore #4
    //   294: goto -> 13
    //   297: iconst_m1
    //   298: istore #4
    //   300: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   21	31	280	finally
    //   34	71	280	finally
    //   79	85	280	finally
    //   89	107	280	finally
    //   107	126	280	finally
    //   126	145	280	finally
    //   145	162	265	java/lang/Exception
    //   145	162	280	finally
    //   178	201	265	java/lang/Exception
    //   178	201	280	finally
    //   205	217	280	finally
    //   233	244	280	finally
    //   253	262	280	finally
    //   266	280	280	finally
    //   285	294	280	finally
  }
  
  public int addCardToVendorPay(AddCardToVendorPayRequestParams paramAddCardToVendorPayRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore #4
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_1
    //   7: ifnull -> 23
    //   10: aload_2
    //   11: ifnonnull -> 23
    //   14: bipush #-3
    //   16: istore #5
    //   18: aload_0
    //   19: monitorexit
    //   20: iload #5
    //   22: ireturn
    //   23: iload #4
    //   25: istore #5
    //   27: aload_0
    //   28: ldc_w '01.00.20'
    //   31: invokespecial d : (Ljava/lang/String;)Z
    //   34: ifeq -> 18
    //   37: iload #4
    //   39: istore #5
    //   41: aload_0
    //   42: invokespecial c : ()Z
    //   45: ifeq -> 18
    //   48: aload_0
    //   49: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   52: ifnull -> 344
    //   55: aload_0
    //   56: getfield c : Landroid/content/Context;
    //   59: invokevirtual getPackageName : ()Ljava/lang/String;
    //   62: invokestatic a : (Ljava/lang/String;)Z
    //   65: ifeq -> 332
    //   68: new com/unionpay/tsmservice/request/AddCardToVendorPayRequestParams
    //   71: astore #6
    //   73: aload #6
    //   75: invokespecial <init> : ()V
    //   78: aload_1
    //   79: invokevirtual getParams : ()Landroid/os/Bundle;
    //   82: astore #7
    //   84: aload #7
    //   86: ifnull -> 120
    //   89: new android/os/Bundle
    //   92: astore #8
    //   94: aload #8
    //   96: invokespecial <init> : ()V
    //   99: aload #8
    //   101: ldc_w 'encryptData'
    //   104: aload_0
    //   105: aload #7
    //   107: invokespecial a : (Landroid/os/Bundle;)Ljava/lang/String;
    //   110: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload #6
    //   115: aload #8
    //   117: invokevirtual setParams : (Landroid/os/Bundle;)V
    //   120: aload_1
    //   121: invokevirtual getReserve : ()Ljava/lang/String;
    //   124: astore #8
    //   126: aload #8
    //   128: astore #7
    //   130: aload_0
    //   131: getfield h : Z
    //   134: ifeq -> 148
    //   137: aload_0
    //   138: aload #8
    //   140: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   143: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   146: astore #7
    //   148: aload #7
    //   150: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   153: ifne -> 167
    //   156: aload #6
    //   158: aload_0
    //   159: aload #7
    //   161: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   164: invokevirtual setReserve : (Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield P : Ljava/util/HashMap;
    //   171: aload_0
    //   172: getfield U : [I
    //   175: bipush #38
    //   177: iaload
    //   178: invokestatic valueOf : (I)Ljava/lang/String;
    //   181: aload_2
    //   182: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: aload_0
    //   187: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   190: astore #8
    //   192: new com/unionpay/tsmservice/UPTsmAddon$b
    //   195: astore #7
    //   197: aload_0
    //   198: getfield U : [I
    //   201: astore #9
    //   203: aload #9
    //   205: bipush #38
    //   207: iaload
    //   208: istore #5
    //   210: aload #9
    //   212: bipush #38
    //   214: iload #5
    //   216: iconst_1
    //   217: iadd
    //   218: iastore
    //   219: aload #7
    //   221: aload_0
    //   222: bipush #38
    //   224: iload #5
    //   226: iconst_0
    //   227: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   230: aload #8
    //   232: aload #6
    //   234: aload #7
    //   236: aload_3
    //   237: invokeinterface addCardToVendorPay : (Lcom/unionpay/tsmservice/request/AddCardToVendorPayRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   242: istore #4
    //   244: iload #4
    //   246: ifeq -> 288
    //   249: aload_0
    //   250: getfield P : Ljava/util/HashMap;
    //   253: astore #7
    //   255: aload_0
    //   256: getfield U : [I
    //   259: astore #8
    //   261: aload #8
    //   263: bipush #38
    //   265: iaload
    //   266: iconst_1
    //   267: isub
    //   268: istore #5
    //   270: aload #8
    //   272: bipush #38
    //   274: iload #5
    //   276: iastore
    //   277: aload #7
    //   279: iload #5
    //   281: invokestatic valueOf : (I)Ljava/lang/String;
    //   284: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: iload #4
    //   290: istore #5
    //   292: bipush #-2
    //   294: iload #4
    //   296: if_icmpne -> 18
    //   299: bipush #38
    //   301: aload_1
    //   302: aload_2
    //   303: aload_3
    //   304: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   307: istore #5
    //   309: goto -> 18
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual printStackTrace : ()V
    //   317: new android/os/RemoteException
    //   320: astore_1
    //   321: aload_1
    //   322: invokespecial <init> : ()V
    //   325: aload_1
    //   326: athrow
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    //   332: bipush #38
    //   334: aload_1
    //   335: aload_2
    //   336: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   339: istore #5
    //   341: goto -> 18
    //   344: iconst_m1
    //   345: istore #5
    //   347: goto -> 18
    // Exception table:
    //   from	to	target	type
    //   27	37	327	finally
    //   41	84	327	finally
    //   89	120	327	finally
    //   120	126	327	finally
    //   130	148	327	finally
    //   148	167	327	finally
    //   167	186	327	finally
    //   186	203	312	java/lang/Exception
    //   186	203	327	finally
    //   219	244	312	java/lang/Exception
    //   219	244	327	finally
    //   249	261	327	finally
    //   277	288	327	finally
    //   299	309	327	finally
    //   313	327	327	finally
    //   332	341	327	finally
  }
  
  public void addConnectionListener(UPTsmConnectionListener paramUPTsmConnectionListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 14
    //   6: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   9: aload_1
    //   10: invokevirtual add : (Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   6	14	17	finally
  }
  
  public int appDataUpdate(AppDataUpdateRequestParams paramAppDataUpdateRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 19
    //   10: bipush #-3
    //   12: istore #4
    //   14: aload_0
    //   15: monitorexit
    //   16: iload #4
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial c : ()Z
    //   23: ifne -> 33
    //   26: bipush #-8
    //   28: istore #4
    //   30: goto -> 14
    //   33: aload_0
    //   34: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   37: ifnull -> 303
    //   40: aload_0
    //   41: getfield c : Landroid/content/Context;
    //   44: invokevirtual getPackageName : ()Ljava/lang/String;
    //   47: invokestatic a : (Ljava/lang/String;)Z
    //   50: ifeq -> 290
    //   53: new com/unionpay/tsmservice/request/AppDataUpdateRequestParams
    //   56: astore #5
    //   58: aload #5
    //   60: invokespecial <init> : ()V
    //   63: aload_1
    //   64: invokevirtual getReserve : ()Ljava/lang/String;
    //   67: astore #6
    //   69: aload_1
    //   70: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   73: astore #7
    //   75: aload #6
    //   77: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   80: ifne -> 94
    //   83: aload #5
    //   85: aload_0
    //   86: aload #6
    //   88: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual setReserve : (Ljava/lang/String;)V
    //   94: aload #7
    //   96: ifnull -> 158
    //   99: aload #7
    //   101: invokevirtual getAppAid : ()Ljava/lang/String;
    //   104: astore #6
    //   106: aload #7
    //   108: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   111: astore #7
    //   113: aload #6
    //   115: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   118: ifne -> 158
    //   121: aload #7
    //   123: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   126: ifne -> 158
    //   129: new com/unionpay/tsmservice/AppID
    //   132: astore #8
    //   134: aload #8
    //   136: aload_0
    //   137: aload #6
    //   139: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   142: aload_0
    //   143: aload #7
    //   145: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   148: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload #5
    //   153: aload #8
    //   155: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   158: aload_0
    //   159: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   162: astore #7
    //   164: new com/unionpay/tsmservice/UPTsmAddon$b
    //   167: astore #6
    //   169: aload #6
    //   171: aload_0
    //   172: bipush #18
    //   174: aload_0
    //   175: getfield U : [I
    //   178: bipush #18
    //   180: iaload
    //   181: iconst_0
    //   182: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   185: aload #7
    //   187: aload #5
    //   189: aload #6
    //   191: aload_3
    //   192: invokeinterface appDataUpdate : (Lcom/unionpay/tsmservice/request/AppDataUpdateRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   197: istore #9
    //   199: bipush #-2
    //   201: iload #9
    //   203: if_icmpne -> 239
    //   206: bipush #18
    //   208: aload_1
    //   209: aload_2
    //   210: aload_3
    //   211: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   214: istore #4
    //   216: goto -> 14
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual printStackTrace : ()V
    //   224: new android/os/RemoteException
    //   227: astore_1
    //   228: aload_1
    //   229: invokespecial <init> : ()V
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_1
    //   238: athrow
    //   239: iload #9
    //   241: istore #4
    //   243: iload #9
    //   245: ifne -> 14
    //   248: aload_0
    //   249: getfield q : Ljava/util/HashMap;
    //   252: astore_3
    //   253: aload_0
    //   254: getfield U : [I
    //   257: astore_1
    //   258: aload_1
    //   259: bipush #18
    //   261: iaload
    //   262: istore #4
    //   264: aload_1
    //   265: bipush #18
    //   267: iload #4
    //   269: iconst_1
    //   270: iadd
    //   271: iastore
    //   272: aload_3
    //   273: iload #4
    //   275: invokestatic valueOf : (I)Ljava/lang/String;
    //   278: aload_2
    //   279: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: iload #9
    //   285: istore #4
    //   287: goto -> 14
    //   290: bipush #18
    //   292: aload_1
    //   293: aload_2
    //   294: aload_3
    //   295: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   298: istore #4
    //   300: goto -> 14
    //   303: iconst_m1
    //   304: istore #4
    //   306: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   19	26	234	finally
    //   33	94	234	finally
    //   99	158	234	finally
    //   158	199	219	java/lang/Exception
    //   158	199	234	finally
    //   206	216	234	finally
    //   220	234	234	finally
    //   248	258	234	finally
    //   272	283	234	finally
    //   290	300	234	finally
  }
  
  public int appDelete(AppDeleteRequestParams paramAppDeleteRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 19
    //   10: bipush #-3
    //   12: istore #4
    //   14: aload_0
    //   15: monitorexit
    //   16: iload #4
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial c : ()Z
    //   23: ifne -> 33
    //   26: bipush #-8
    //   28: istore #4
    //   30: goto -> 14
    //   33: aload_0
    //   34: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   37: ifnull -> 850
    //   40: aload_0
    //   41: getfield c : Landroid/content/Context;
    //   44: invokevirtual getPackageName : ()Ljava/lang/String;
    //   47: invokestatic a : (Ljava/lang/String;)Z
    //   50: ifeq -> 837
    //   53: new com/unionpay/tsmservice/request/AppDeleteRequestParams
    //   56: astore #5
    //   58: aload #5
    //   60: invokespecial <init> : ()V
    //   63: aload_1
    //   64: invokevirtual getReserve : ()Ljava/lang/String;
    //   67: astore #6
    //   69: aload_1
    //   70: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   73: astore #7
    //   75: aload #6
    //   77: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   80: ifne -> 94
    //   83: aload #5
    //   85: aload_0
    //   86: aload #6
    //   88: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual setReserve : (Ljava/lang/String;)V
    //   94: aload #7
    //   96: ifnull -> 158
    //   99: aload #7
    //   101: invokevirtual getAppAid : ()Ljava/lang/String;
    //   104: astore #6
    //   106: aload #7
    //   108: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   111: astore #8
    //   113: aload #6
    //   115: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   118: ifne -> 158
    //   121: aload #8
    //   123: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   126: ifne -> 158
    //   129: new com/unionpay/tsmservice/AppID
    //   132: astore #7
    //   134: aload #7
    //   136: aload_0
    //   137: aload #6
    //   139: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   142: aload_0
    //   143: aload #8
    //   145: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   148: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload #5
    //   153: aload #7
    //   155: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   158: aload_1
    //   159: invokevirtual getParams : ()Ljava/util/Map;
    //   162: checkcast java/util/HashMap
    //   165: astore #6
    //   167: aload #6
    //   169: ifnonnull -> 304
    //   172: aload_0
    //   173: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   176: astore #7
    //   178: new com/unionpay/tsmservice/UPTsmAddon$b
    //   181: astore #6
    //   183: aload #6
    //   185: aload_0
    //   186: bipush #17
    //   188: aload_0
    //   189: getfield U : [I
    //   192: bipush #17
    //   194: iaload
    //   195: iconst_0
    //   196: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   199: aload #7
    //   201: aload #5
    //   203: aload #6
    //   205: aload_3
    //   206: invokeinterface appDelete : (Lcom/unionpay/tsmservice/request/AppDeleteRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   211: istore #9
    //   213: bipush #-2
    //   215: iload #9
    //   217: if_icmpne -> 253
    //   220: bipush #17
    //   222: aload_1
    //   223: aload_2
    //   224: aload_3
    //   225: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   228: istore #4
    //   230: goto -> 14
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual printStackTrace : ()V
    //   238: new android/os/RemoteException
    //   241: astore_1
    //   242: aload_1
    //   243: invokespecial <init> : ()V
    //   246: aload_1
    //   247: athrow
    //   248: astore_1
    //   249: aload_0
    //   250: monitorexit
    //   251: aload_1
    //   252: athrow
    //   253: iload #9
    //   255: istore #4
    //   257: iload #9
    //   259: ifne -> 14
    //   262: aload_0
    //   263: getfield D : Ljava/util/HashMap;
    //   266: astore_1
    //   267: aload_0
    //   268: getfield U : [I
    //   271: astore_3
    //   272: aload_3
    //   273: bipush #17
    //   275: iaload
    //   276: istore #4
    //   278: aload_3
    //   279: bipush #17
    //   281: iload #4
    //   283: iconst_1
    //   284: iadd
    //   285: iastore
    //   286: aload_1
    //   287: iload #4
    //   289: invokestatic valueOf : (I)Ljava/lang/String;
    //   292: aload_2
    //   293: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   296: pop
    //   297: iload #9
    //   299: istore #4
    //   301: goto -> 14
    //   304: aload #6
    //   306: invokestatic a : (Ljava/util/HashMap;)Ljava/util/HashMap;
    //   309: astore #10
    //   311: aload #10
    //   313: ldc_w 'cardHolderName'
    //   316: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   319: checkcast java/lang/String
    //   322: astore #11
    //   324: aload #10
    //   326: ldc_w 'idType'
    //   329: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   332: checkcast java/lang/String
    //   335: astore #12
    //   337: aload #10
    //   339: ldc_w 'idNo'
    //   342: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   345: checkcast java/lang/String
    //   348: astore #6
    //   350: aload #10
    //   352: ldc_w 'pan'
    //   355: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   358: checkcast java/lang/String
    //   361: astore #13
    //   363: aload #10
    //   365: ldc_w 'pin'
    //   368: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast java/lang/String
    //   374: astore #14
    //   376: aload #10
    //   378: ldc_w 'expiryDate'
    //   381: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   384: checkcast java/lang/String
    //   387: astore #15
    //   389: aload #10
    //   391: ldc_w 'cvn2'
    //   394: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast java/lang/String
    //   400: astore #7
    //   402: aload #10
    //   404: ldc_w 'msisdn'
    //   407: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   410: checkcast java/lang/String
    //   413: astore #16
    //   415: aload #10
    //   417: ldc_w 'smsAuthCode'
    //   420: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   423: checkcast java/lang/String
    //   426: astore #8
    //   428: aload #10
    //   430: ldc_w 'ecashBalance'
    //   433: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   436: checkcast java/lang/String
    //   439: astore #17
    //   441: aload #10
    //   443: ldc_w 'cardType'
    //   446: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   449: checkcast java/lang/String
    //   452: astore #18
    //   454: aload #11
    //   456: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   459: ifne -> 477
    //   462: aload #10
    //   464: ldc_w 'cardHolderName'
    //   467: aload_0
    //   468: aload #11
    //   470: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   473: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: aload #12
    //   479: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   482: ifne -> 500
    //   485: aload #10
    //   487: ldc_w 'idType'
    //   490: aload_0
    //   491: aload #12
    //   493: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   496: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: aload #6
    //   502: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   505: ifne -> 523
    //   508: aload #10
    //   510: ldc_w 'idNo'
    //   513: aload_0
    //   514: aload #6
    //   516: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   519: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: pop
    //   523: aload #13
    //   525: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   528: ifne -> 546
    //   531: aload #10
    //   533: ldc_w 'pan'
    //   536: aload_0
    //   537: aload #13
    //   539: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   542: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   545: pop
    //   546: aload #14
    //   548: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   551: ifne -> 565
    //   554: aload #10
    //   556: ldc_w 'pin'
    //   559: aload #14
    //   561: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   564: pop
    //   565: aload #15
    //   567: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   570: ifne -> 588
    //   573: aload #10
    //   575: ldc_w 'expiryDate'
    //   578: aload_0
    //   579: aload #15
    //   581: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   584: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   587: pop
    //   588: aload #7
    //   590: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   593: ifne -> 611
    //   596: aload #10
    //   598: ldc_w 'cvn2'
    //   601: aload_0
    //   602: aload #7
    //   604: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   607: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   610: pop
    //   611: aload #16
    //   613: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   616: ifne -> 634
    //   619: aload #10
    //   621: ldc_w 'msisdn'
    //   624: aload_0
    //   625: aload #16
    //   627: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   630: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: pop
    //   634: aload #8
    //   636: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   639: ifne -> 657
    //   642: aload #10
    //   644: ldc_w 'smsAuthCode'
    //   647: aload_0
    //   648: aload #8
    //   650: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   653: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   656: pop
    //   657: aload #17
    //   659: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   662: ifne -> 680
    //   665: aload #10
    //   667: ldc_w 'ecashBalance'
    //   670: aload_0
    //   671: aload #17
    //   673: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   676: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: pop
    //   680: aload #18
    //   682: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   685: ifne -> 703
    //   688: aload #10
    //   690: ldc_w 'cardType'
    //   693: aload_0
    //   694: aload #18
    //   696: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   699: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   702: pop
    //   703: aload #5
    //   705: aload #10
    //   707: invokevirtual setParams : (Ljava/util/HashMap;)V
    //   710: aload_0
    //   711: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   714: astore #7
    //   716: new com/unionpay/tsmservice/UPTsmAddon$b
    //   719: astore #6
    //   721: aload #6
    //   723: aload_0
    //   724: bipush #17
    //   726: aload_0
    //   727: getfield U : [I
    //   730: bipush #17
    //   732: iaload
    //   733: iconst_0
    //   734: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   737: aload #7
    //   739: aload #5
    //   741: aload #6
    //   743: aload_3
    //   744: invokeinterface appDelete : (Lcom/unionpay/tsmservice/request/AppDeleteRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   749: istore #9
    //   751: bipush #-2
    //   753: iload #9
    //   755: if_icmpne -> 786
    //   758: bipush #17
    //   760: aload_1
    //   761: aload_2
    //   762: aload_3
    //   763: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   766: istore #4
    //   768: goto -> 14
    //   771: astore_1
    //   772: aload_1
    //   773: invokevirtual printStackTrace : ()V
    //   776: new android/os/RemoteException
    //   779: astore_1
    //   780: aload_1
    //   781: invokespecial <init> : ()V
    //   784: aload_1
    //   785: athrow
    //   786: iload #9
    //   788: istore #4
    //   790: iload #9
    //   792: ifne -> 14
    //   795: aload_0
    //   796: getfield D : Ljava/util/HashMap;
    //   799: astore_3
    //   800: aload_0
    //   801: getfield U : [I
    //   804: astore_1
    //   805: aload_1
    //   806: bipush #17
    //   808: iaload
    //   809: istore #4
    //   811: aload_1
    //   812: bipush #17
    //   814: iload #4
    //   816: iconst_1
    //   817: iadd
    //   818: iastore
    //   819: aload_3
    //   820: iload #4
    //   822: invokestatic valueOf : (I)Ljava/lang/String;
    //   825: aload_2
    //   826: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   829: pop
    //   830: iload #9
    //   832: istore #4
    //   834: goto -> 14
    //   837: bipush #17
    //   839: aload_1
    //   840: aload_2
    //   841: aload_3
    //   842: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   845: istore #4
    //   847: goto -> 14
    //   850: iconst_m1
    //   851: istore #4
    //   853: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   19	26	248	finally
    //   33	94	248	finally
    //   99	158	248	finally
    //   158	167	248	finally
    //   172	213	233	java/lang/Exception
    //   172	213	248	finally
    //   220	230	248	finally
    //   234	248	248	finally
    //   262	272	248	finally
    //   286	297	248	finally
    //   304	477	248	finally
    //   477	500	248	finally
    //   500	523	248	finally
    //   523	546	248	finally
    //   546	565	248	finally
    //   565	588	248	finally
    //   588	611	248	finally
    //   611	634	248	finally
    //   634	657	248	finally
    //   657	680	248	finally
    //   680	703	248	finally
    //   703	710	248	finally
    //   710	751	771	java/lang/Exception
    //   710	751	248	finally
    //   758	768	248	finally
    //   772	786	248	finally
    //   795	805	248	finally
    //   819	830	248	finally
    //   837	847	248	finally
  }
  
  public int appDownload(AppDownloadRequestParams paramAppDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 19
    //   10: bipush #-3
    //   12: istore #4
    //   14: aload_0
    //   15: monitorexit
    //   16: iload #4
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial c : ()Z
    //   23: ifne -> 33
    //   26: bipush #-8
    //   28: istore #4
    //   30: goto -> 14
    //   33: aload_0
    //   34: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   37: ifnull -> 328
    //   40: aload_0
    //   41: getfield c : Landroid/content/Context;
    //   44: invokevirtual getPackageName : ()Ljava/lang/String;
    //   47: invokestatic a : (Ljava/lang/String;)Z
    //   50: ifeq -> 315
    //   53: new com/unionpay/tsmservice/request/AppDownloadRequestParams
    //   56: astore #5
    //   58: aload #5
    //   60: invokespecial <init> : ()V
    //   63: aload_1
    //   64: invokevirtual getReserve : ()Ljava/lang/String;
    //   67: astore #6
    //   69: aload_1
    //   70: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   73: astore #7
    //   75: aload_1
    //   76: invokevirtual getAppName : ()Ljava/lang/String;
    //   79: astore #8
    //   81: aload #6
    //   83: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   86: ifne -> 100
    //   89: aload #5
    //   91: aload_0
    //   92: aload #6
    //   94: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual setReserve : (Ljava/lang/String;)V
    //   100: aload #7
    //   102: ifnull -> 164
    //   105: aload #7
    //   107: invokevirtual getAppAid : ()Ljava/lang/String;
    //   110: astore #6
    //   112: aload #7
    //   114: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   117: astore #9
    //   119: aload #6
    //   121: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   124: ifne -> 164
    //   127: aload #9
    //   129: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   132: ifne -> 164
    //   135: new com/unionpay/tsmservice/AppID
    //   138: astore #7
    //   140: aload #7
    //   142: aload_0
    //   143: aload #6
    //   145: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   148: aload_0
    //   149: aload #9
    //   151: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   154: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload #5
    //   159: aload #7
    //   161: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   164: aload #8
    //   166: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   169: ifne -> 183
    //   172: aload #5
    //   174: aload_0
    //   175: aload #8
    //   177: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   180: invokevirtual setAppName : (Ljava/lang/String;)V
    //   183: aload_0
    //   184: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   187: astore #8
    //   189: new com/unionpay/tsmservice/UPTsmAddon$b
    //   192: astore #6
    //   194: aload #6
    //   196: aload_0
    //   197: bipush #16
    //   199: aload_0
    //   200: getfield U : [I
    //   203: bipush #16
    //   205: iaload
    //   206: iconst_0
    //   207: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   210: aload #8
    //   212: aload #5
    //   214: aload #6
    //   216: aload_3
    //   217: invokeinterface appDownload : (Lcom/unionpay/tsmservice/request/AppDownloadRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   222: istore #10
    //   224: bipush #-2
    //   226: iload #10
    //   228: if_icmpne -> 264
    //   231: bipush #16
    //   233: aload_1
    //   234: aload_2
    //   235: aload_3
    //   236: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   239: istore #4
    //   241: goto -> 14
    //   244: astore_1
    //   245: aload_1
    //   246: invokevirtual printStackTrace : ()V
    //   249: new android/os/RemoteException
    //   252: astore_1
    //   253: aload_1
    //   254: invokespecial <init> : ()V
    //   257: aload_1
    //   258: athrow
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    //   264: iload #10
    //   266: istore #4
    //   268: iload #10
    //   270: ifne -> 14
    //   273: aload_0
    //   274: getfield C : Ljava/util/HashMap;
    //   277: astore_1
    //   278: aload_0
    //   279: getfield U : [I
    //   282: astore_3
    //   283: aload_3
    //   284: bipush #16
    //   286: iaload
    //   287: istore #4
    //   289: aload_3
    //   290: bipush #16
    //   292: iload #4
    //   294: iconst_1
    //   295: iadd
    //   296: iastore
    //   297: aload_1
    //   298: iload #4
    //   300: invokestatic valueOf : (I)Ljava/lang/String;
    //   303: aload_2
    //   304: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   307: pop
    //   308: iload #10
    //   310: istore #4
    //   312: goto -> 14
    //   315: bipush #16
    //   317: aload_1
    //   318: aload_2
    //   319: aload_3
    //   320: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   323: istore #4
    //   325: goto -> 14
    //   328: iconst_m1
    //   329: istore #4
    //   331: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   19	26	259	finally
    //   33	100	259	finally
    //   105	164	259	finally
    //   164	183	259	finally
    //   183	224	244	java/lang/Exception
    //   183	224	259	finally
    //   231	241	259	finally
    //   245	259	259	finally
    //   273	283	259	finally
    //   297	308	259	finally
    //   315	325	259	finally
  }
  
  public int appDownloadApply(AppDownloadApplyRequestParams paramAppDownloadApplyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 871
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 860
    //   50: new com/unionpay/tsmservice/request/AppDownloadApplyRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #7
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #7
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #6
    //   131: aload #6
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #7
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #6
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_1
    //   156: invokevirtual getParams : ()Ljava/util/Map;
    //   159: checkcast java/util/HashMap
    //   162: astore #5
    //   164: aload #5
    //   166: ifnonnull -> 296
    //   169: aload_0
    //   170: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   173: astore #6
    //   175: new com/unionpay/tsmservice/UPTsmAddon$b
    //   178: astore #5
    //   180: aload #5
    //   182: aload_0
    //   183: bipush #15
    //   185: aload_0
    //   186: getfield U : [I
    //   189: bipush #15
    //   191: iaload
    //   192: iconst_0
    //   193: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   196: aload #6
    //   198: aload #4
    //   200: aload #5
    //   202: invokeinterface appDownloadApply : (Lcom/unionpay/tsmservice/request/AppDownloadApplyRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   207: istore #8
    //   209: bipush #-2
    //   211: iload #8
    //   213: if_icmpne -> 247
    //   216: bipush #15
    //   218: aload_1
    //   219: aload_2
    //   220: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   223: istore_3
    //   224: goto -> 13
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual printStackTrace : ()V
    //   232: new android/os/RemoteException
    //   235: astore_1
    //   236: aload_1
    //   237: invokespecial <init> : ()V
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aload_0
    //   244: monitorexit
    //   245: aload_1
    //   246: athrow
    //   247: iload #8
    //   249: istore_3
    //   250: iload #8
    //   252: ifne -> 13
    //   255: aload_0
    //   256: getfield p : Ljava/util/HashMap;
    //   259: astore_1
    //   260: aload_0
    //   261: getfield U : [I
    //   264: astore #4
    //   266: aload #4
    //   268: bipush #15
    //   270: iaload
    //   271: istore_3
    //   272: aload #4
    //   274: bipush #15
    //   276: iload_3
    //   277: iconst_1
    //   278: iadd
    //   279: iastore
    //   280: aload_1
    //   281: iload_3
    //   282: invokestatic valueOf : (I)Ljava/lang/String;
    //   285: aload_2
    //   286: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: iload #8
    //   292: istore_3
    //   293: goto -> 13
    //   296: aload #5
    //   298: invokestatic a : (Ljava/util/HashMap;)Ljava/util/HashMap;
    //   301: astore #9
    //   303: aload #9
    //   305: ldc_w 'accountLimit'
    //   308: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   311: checkcast java/lang/String
    //   314: astore #10
    //   316: aload #9
    //   318: ldc_w 'accountType'
    //   321: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   324: checkcast java/lang/String
    //   327: astore #11
    //   329: aload #9
    //   331: ldc_w 'cardHolderName'
    //   334: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   337: checkcast java/lang/String
    //   340: astore #12
    //   342: aload #9
    //   344: ldc_w 'idType'
    //   347: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   350: checkcast java/lang/String
    //   353: astore #13
    //   355: aload #9
    //   357: ldc_w 'idNo'
    //   360: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   363: checkcast java/lang/String
    //   366: astore #14
    //   368: aload #9
    //   370: ldc_w 'pan'
    //   373: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   376: checkcast java/lang/String
    //   379: astore #5
    //   381: aload #9
    //   383: ldc_w 'pin'
    //   386: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   389: checkcast java/lang/String
    //   392: astore #6
    //   394: aload #9
    //   396: ldc_w 'expiryDate'
    //   399: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   402: checkcast java/lang/String
    //   405: astore #15
    //   407: aload #9
    //   409: ldc_w 'cvn2'
    //   412: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   415: checkcast java/lang/String
    //   418: astore #7
    //   420: aload #9
    //   422: ldc_w 'msisdn'
    //   425: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast java/lang/String
    //   431: astore #16
    //   433: aload #9
    //   435: ldc_w 'smsAuthCode'
    //   438: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   441: checkcast java/lang/String
    //   444: astore #17
    //   446: aload #9
    //   448: ldc_w 'cardType'
    //   451: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   454: checkcast java/lang/String
    //   457: astore #18
    //   459: aload #10
    //   461: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   464: ifne -> 482
    //   467: aload #9
    //   469: ldc_w 'accountLimit'
    //   472: aload_0
    //   473: aload #10
    //   475: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   478: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   481: pop
    //   482: aload #11
    //   484: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   487: ifne -> 505
    //   490: aload #9
    //   492: ldc_w 'accountType'
    //   495: aload_0
    //   496: aload #11
    //   498: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   501: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload #12
    //   507: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   510: ifne -> 528
    //   513: aload #9
    //   515: ldc_w 'cardHolderName'
    //   518: aload_0
    //   519: aload #12
    //   521: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   524: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: pop
    //   528: aload #13
    //   530: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   533: ifne -> 551
    //   536: aload #9
    //   538: ldc_w 'idType'
    //   541: aload_0
    //   542: aload #13
    //   544: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   547: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   550: pop
    //   551: aload #14
    //   553: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   556: ifne -> 574
    //   559: aload #9
    //   561: ldc_w 'idNo'
    //   564: aload_0
    //   565: aload #14
    //   567: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   570: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: pop
    //   574: aload #5
    //   576: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   579: ifne -> 597
    //   582: aload #9
    //   584: ldc_w 'pan'
    //   587: aload_0
    //   588: aload #5
    //   590: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   593: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   596: pop
    //   597: aload #6
    //   599: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   602: ifne -> 616
    //   605: aload #9
    //   607: ldc_w 'pin'
    //   610: aload #6
    //   612: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   615: pop
    //   616: aload #15
    //   618: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   621: ifne -> 639
    //   624: aload #9
    //   626: ldc_w 'expiryDate'
    //   629: aload_0
    //   630: aload #15
    //   632: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   635: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: pop
    //   639: aload #7
    //   641: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   644: ifne -> 662
    //   647: aload #9
    //   649: ldc_w 'cvn2'
    //   652: aload_0
    //   653: aload #7
    //   655: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   658: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   661: pop
    //   662: aload #16
    //   664: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   667: ifne -> 685
    //   670: aload #9
    //   672: ldc_w 'msisdn'
    //   675: aload_0
    //   676: aload #16
    //   678: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   681: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   684: pop
    //   685: aload #17
    //   687: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   690: ifne -> 708
    //   693: aload #9
    //   695: ldc_w 'smsAuthCode'
    //   698: aload_0
    //   699: aload #17
    //   701: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   704: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   707: pop
    //   708: aload #18
    //   710: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   713: ifne -> 731
    //   716: aload #9
    //   718: ldc_w 'cardType'
    //   721: aload_0
    //   722: aload #18
    //   724: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   727: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   730: pop
    //   731: aload #4
    //   733: aload #9
    //   735: invokevirtual setParams : (Ljava/util/HashMap;)V
    //   738: aload_0
    //   739: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   742: astore #5
    //   744: new com/unionpay/tsmservice/UPTsmAddon$b
    //   747: astore #6
    //   749: aload #6
    //   751: aload_0
    //   752: bipush #15
    //   754: aload_0
    //   755: getfield U : [I
    //   758: bipush #15
    //   760: iaload
    //   761: iconst_0
    //   762: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   765: aload #5
    //   767: aload #4
    //   769: aload #6
    //   771: invokeinterface appDownloadApply : (Lcom/unionpay/tsmservice/request/AppDownloadApplyRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   776: istore #8
    //   778: bipush #-2
    //   780: iload #8
    //   782: if_icmpne -> 811
    //   785: bipush #15
    //   787: aload_1
    //   788: aload_2
    //   789: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   792: istore_3
    //   793: goto -> 13
    //   796: astore_1
    //   797: aload_1
    //   798: invokevirtual printStackTrace : ()V
    //   801: new android/os/RemoteException
    //   804: astore_1
    //   805: aload_1
    //   806: invokespecial <init> : ()V
    //   809: aload_1
    //   810: athrow
    //   811: iload #8
    //   813: istore_3
    //   814: iload #8
    //   816: ifne -> 13
    //   819: aload_0
    //   820: getfield p : Ljava/util/HashMap;
    //   823: astore_1
    //   824: aload_0
    //   825: getfield U : [I
    //   828: astore #4
    //   830: aload #4
    //   832: bipush #15
    //   834: iaload
    //   835: istore_3
    //   836: aload #4
    //   838: bipush #15
    //   840: iload_3
    //   841: iconst_1
    //   842: iadd
    //   843: iastore
    //   844: aload_1
    //   845: iload_3
    //   846: invokestatic valueOf : (I)Ljava/lang/String;
    //   849: aload_2
    //   850: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   853: pop
    //   854: iload #8
    //   856: istore_3
    //   857: goto -> 13
    //   860: bipush #15
    //   862: aload_1
    //   863: aload_2
    //   864: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   867: istore_3
    //   868: goto -> 13
    //   871: iconst_m1
    //   872: istore_3
    //   873: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	242	finally
    //   30	91	242	finally
    //   96	155	242	finally
    //   155	164	242	finally
    //   169	209	227	java/lang/Exception
    //   169	209	242	finally
    //   216	224	242	finally
    //   228	242	242	finally
    //   255	266	242	finally
    //   280	290	242	finally
    //   296	482	242	finally
    //   482	505	242	finally
    //   505	528	242	finally
    //   528	551	242	finally
    //   551	574	242	finally
    //   574	597	242	finally
    //   597	616	242	finally
    //   616	639	242	finally
    //   639	662	242	finally
    //   662	685	242	finally
    //   685	708	242	finally
    //   708	731	242	finally
    //   731	738	242	finally
    //   738	778	796	java/lang/Exception
    //   738	778	242	finally
    //   785	793	242	finally
    //   797	811	242	finally
    //   819	830	242	finally
    //   844	854	242	finally
    //   860	868	242	finally
  }
  
  public int appLock(AppLockRequestParams paramAppLockRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 221
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 210
    //   50: new com/unionpay/tsmservice/request/AppLockRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #6
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #6
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #7
    //   131: aload #7
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #6
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #7
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_0
    //   156: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   159: aload #4
    //   161: aload_2
    //   162: invokeinterface appLock : (Lcom/unionpay/tsmservice/request/AppLockRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   167: istore #8
    //   169: iload #8
    //   171: istore_3
    //   172: bipush #-2
    //   174: iload #8
    //   176: if_icmpne -> 13
    //   179: bipush #26
    //   181: aload_1
    //   182: aload_2
    //   183: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   186: istore_3
    //   187: goto -> 13
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual printStackTrace : ()V
    //   195: new android/os/RemoteException
    //   198: astore_1
    //   199: aload_1
    //   200: invokespecial <init> : ()V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    //   210: bipush #26
    //   212: aload_1
    //   213: aload_2
    //   214: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   217: istore_3
    //   218: goto -> 13
    //   221: iconst_m1
    //   222: istore_3
    //   223: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	205	finally
    //   30	91	205	finally
    //   96	155	205	finally
    //   155	169	190	java/lang/Exception
    //   155	169	205	finally
    //   179	187	205	finally
    //   191	205	205	finally
    //   210	218	205	finally
  }
  
  public int appUnlock(AppUnlockRequestParams paramAppUnlockRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 221
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 210
    //   50: new com/unionpay/tsmservice/request/AppUnlockRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #7
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #7
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #6
    //   131: aload #6
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #7
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #6
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_0
    //   156: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   159: aload #4
    //   161: aload_2
    //   162: invokeinterface appUnlock : (Lcom/unionpay/tsmservice/request/AppUnlockRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   167: istore #8
    //   169: iload #8
    //   171: istore_3
    //   172: bipush #-2
    //   174: iload #8
    //   176: if_icmpne -> 13
    //   179: bipush #27
    //   181: aload_1
    //   182: aload_2
    //   183: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   186: istore_3
    //   187: goto -> 13
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual printStackTrace : ()V
    //   195: new android/os/RemoteException
    //   198: astore_1
    //   199: aload_1
    //   200: invokespecial <init> : ()V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    //   210: bipush #27
    //   212: aload_1
    //   213: aload_2
    //   214: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   217: istore_3
    //   218: goto -> 13
    //   221: iconst_m1
    //   222: istore_3
    //   223: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	205	finally
    //   30	91	205	finally
    //   96	155	205	finally
    //   155	169	190	java/lang/Exception
    //   155	169	205	finally
    //   179	187	205	finally
    //   191	205	205	finally
    //   210	218	205	finally
  }
  
  public boolean bind() {
    boolean bool = true;
    if (this.d == null)
      this.d = new UPTsmAddon$2(this); 
    if (!this.f) {
      Intent intent = new Intent("com.unionpay.tsmservice.UPTsmService");
      intent.setPackage("com.unionpay.tsmservice");
      this.c.startService(intent);
      bool = this.c.bindService(intent, this.d, 1);
    } 
    return bool;
  }
  
  public int cardListStatusChanged(CardListStatusChangedRequestParams paramCardListStatusChangedRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ifnonnull -> 18
    //   9: bipush #-3
    //   11: istore #4
    //   13: aload_0
    //   14: monitorexit
    //   15: iload #4
    //   17: ireturn
    //   18: iload_3
    //   19: istore #4
    //   21: aload_0
    //   22: ldc_w '01.00.14'
    //   25: invokespecial d : (Ljava/lang/String;)Z
    //   28: ifeq -> 13
    //   31: iload_3
    //   32: istore #4
    //   34: aload_0
    //   35: invokespecial c : ()Z
    //   38: ifeq -> 13
    //   41: aload_0
    //   42: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   45: ifnull -> 297
    //   48: aload_0
    //   49: getfield c : Landroid/content/Context;
    //   52: invokevirtual getPackageName : ()Ljava/lang/String;
    //   55: invokestatic a : (Ljava/lang/String;)Z
    //   58: ifeq -> 285
    //   61: new com/unionpay/tsmservice/request/CardListStatusChangedRequestParams
    //   64: astore #5
    //   66: aload #5
    //   68: invokespecial <init> : ()V
    //   71: ldc ''
    //   73: astore #6
    //   75: aload_1
    //   76: ifnull -> 85
    //   79: aload_1
    //   80: invokevirtual getReserve : ()Ljava/lang/String;
    //   83: astore #6
    //   85: aload #6
    //   87: astore #7
    //   89: aload_0
    //   90: getfield h : Z
    //   93: ifeq -> 107
    //   96: aload_0
    //   97: aload #6
    //   99: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   102: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   105: astore #7
    //   107: aload #7
    //   109: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   112: ifne -> 126
    //   115: aload #5
    //   117: aload_0
    //   118: aload #7
    //   120: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual setReserve : (Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield M : Ljava/util/HashMap;
    //   130: aload_0
    //   131: getfield U : [I
    //   134: bipush #35
    //   136: iaload
    //   137: invokestatic valueOf : (I)Ljava/lang/String;
    //   140: aload_2
    //   141: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload_0
    //   146: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   149: astore #8
    //   151: new com/unionpay/tsmservice/UPTsmAddon$b
    //   154: astore #6
    //   156: aload_0
    //   157: getfield U : [I
    //   160: astore #7
    //   162: aload #7
    //   164: bipush #35
    //   166: iaload
    //   167: istore #4
    //   169: aload #7
    //   171: bipush #35
    //   173: iload #4
    //   175: iconst_1
    //   176: iadd
    //   177: iastore
    //   178: aload #6
    //   180: aload_0
    //   181: bipush #35
    //   183: iload #4
    //   185: iconst_0
    //   186: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   189: aload #8
    //   191: aload #5
    //   193: aload #6
    //   195: invokeinterface cardListStatusChanged : (Lcom/unionpay/tsmservice/request/CardListStatusChangedRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   200: istore_3
    //   201: iload_3
    //   202: ifeq -> 244
    //   205: aload_0
    //   206: getfield M : Ljava/util/HashMap;
    //   209: astore #6
    //   211: aload_0
    //   212: getfield U : [I
    //   215: astore #7
    //   217: aload #7
    //   219: bipush #35
    //   221: iaload
    //   222: iconst_1
    //   223: isub
    //   224: istore #4
    //   226: aload #7
    //   228: bipush #35
    //   230: iload #4
    //   232: iastore
    //   233: aload #6
    //   235: iload #4
    //   237: invokestatic valueOf : (I)Ljava/lang/String;
    //   240: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: iload_3
    //   245: istore #4
    //   247: bipush #-2
    //   249: iload_3
    //   250: if_icmpne -> 13
    //   253: bipush #35
    //   255: aload_1
    //   256: aload_2
    //   257: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   260: istore #4
    //   262: goto -> 13
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual printStackTrace : ()V
    //   270: new android/os/RemoteException
    //   273: astore_1
    //   274: aload_1
    //   275: invokespecial <init> : ()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: bipush #35
    //   287: aload_1
    //   288: aload_2
    //   289: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   292: istore #4
    //   294: goto -> 13
    //   297: iconst_m1
    //   298: istore #4
    //   300: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   21	31	280	finally
    //   34	71	280	finally
    //   79	85	280	finally
    //   89	107	280	finally
    //   107	126	280	finally
    //   126	145	280	finally
    //   145	162	265	java/lang/Exception
    //   145	162	280	finally
    //   178	201	265	java/lang/Exception
    //   178	201	280	finally
    //   205	217	280	finally
    //   233	244	280	finally
    //   253	262	280	finally
    //   266	280	280	finally
    //   285	294	280	finally
  }
  
  public int checkSSamsungPay(CheckSSamsungPayRequestParams paramCheckSSamsungPayRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 273
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 262
    //   50: new com/unionpay/tsmservice/request/CheckSSamsungPayRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload #5
    //   68: astore #6
    //   70: aload_0
    //   71: getfield h : Z
    //   74: ifeq -> 88
    //   77: aload_0
    //   78: aload #5
    //   80: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   83: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   86: astore #6
    //   88: aload #6
    //   90: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   93: ifne -> 107
    //   96: aload #4
    //   98: aload_0
    //   99: aload #6
    //   101: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual setReserve : (Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield J : Ljava/util/HashMap;
    //   111: aload_0
    //   112: getfield U : [I
    //   115: bipush #29
    //   117: iaload
    //   118: invokestatic valueOf : (I)Ljava/lang/String;
    //   121: aload_2
    //   122: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload_0
    //   127: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   130: astore #7
    //   132: new com/unionpay/tsmservice/UPTsmAddon$b
    //   135: astore #5
    //   137: aload_0
    //   138: getfield U : [I
    //   141: astore #6
    //   143: aload #6
    //   145: bipush #29
    //   147: iaload
    //   148: istore_3
    //   149: aload #6
    //   151: bipush #29
    //   153: iload_3
    //   154: iconst_1
    //   155: iadd
    //   156: iastore
    //   157: aload #5
    //   159: aload_0
    //   160: bipush #29
    //   162: iload_3
    //   163: iconst_0
    //   164: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   167: aload #7
    //   169: aload #4
    //   171: aload #5
    //   173: invokeinterface checkSSamsungPay : (Lcom/unionpay/tsmservice/request/CheckSSamsungPayRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   178: istore #8
    //   180: iload #8
    //   182: ifeq -> 221
    //   185: aload_0
    //   186: getfield J : Ljava/util/HashMap;
    //   189: astore #6
    //   191: aload_0
    //   192: getfield U : [I
    //   195: astore #5
    //   197: aload #5
    //   199: bipush #29
    //   201: iaload
    //   202: iconst_1
    //   203: isub
    //   204: istore_3
    //   205: aload #5
    //   207: bipush #29
    //   209: iload_3
    //   210: iastore
    //   211: aload #6
    //   213: iload_3
    //   214: invokestatic valueOf : (I)Ljava/lang/String;
    //   217: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: iload #8
    //   223: istore_3
    //   224: bipush #-2
    //   226: iload #8
    //   228: if_icmpne -> 13
    //   231: bipush #29
    //   233: aload_1
    //   234: aload_2
    //   235: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   238: istore_3
    //   239: goto -> 13
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual printStackTrace : ()V
    //   247: new android/os/RemoteException
    //   250: astore_1
    //   251: aload_1
    //   252: invokespecial <init> : ()V
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: aload_0
    //   259: monitorexit
    //   260: aload_1
    //   261: athrow
    //   262: bipush #29
    //   264: aload_1
    //   265: aload_2
    //   266: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   269: istore_3
    //   270: goto -> 13
    //   273: iconst_m1
    //   274: istore_3
    //   275: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	257	finally
    //   30	66	257	finally
    //   70	88	257	finally
    //   88	107	257	finally
    //   107	126	257	finally
    //   126	143	242	java/lang/Exception
    //   126	143	257	finally
    //   157	180	242	java/lang/Exception
    //   157	180	257	finally
    //   185	197	257	finally
    //   211	221	257	finally
    //   231	239	257	finally
    //   243	257	257	finally
    //   262	270	257	finally
  }
  
  public int clearEncryptData(int paramInt) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: sipush #2000
    //   6: if_icmplt -> 16
    //   9: iload_1
    //   10: sipush #2001
    //   13: if_icmple -> 23
    //   16: bipush #-3
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: aload_0
    //   24: invokespecial c : ()Z
    //   27: ifne -> 36
    //   30: bipush #-8
    //   32: istore_2
    //   33: goto -> 19
    //   36: aload_0
    //   37: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   40: ifnull -> 225
    //   43: aload_0
    //   44: getfield c : Landroid/content/Context;
    //   47: invokevirtual getPackageName : ()Ljava/lang/String;
    //   50: invokestatic a : (Ljava/lang/String;)Z
    //   53: ifeq -> 212
    //   56: aload_0
    //   57: ldc_w '01.00.24'
    //   60: invokespecial d : (Ljava/lang/String;)Z
    //   63: ifeq -> 177
    //   66: new com/unionpay/tsmservice/request/ClearEncryptDataRequestParams
    //   69: astore_3
    //   70: aload_3
    //   71: invokespecial <init> : ()V
    //   74: ldc ''
    //   76: astore #4
    //   78: aload_0
    //   79: getfield h : Z
    //   82: ifeq -> 96
    //   85: aload_0
    //   86: ldc ''
    //   88: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   91: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   94: astore #4
    //   96: aload #4
    //   98: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   101: ifne -> 114
    //   104: aload_3
    //   105: aload_0
    //   106: aload #4
    //   108: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   111: invokevirtual setReserve : (Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   118: aload_3
    //   119: iload_1
    //   120: invokeinterface clearKeyboardEncryptData : (Lcom/unionpay/tsmservice/request/ClearEncryptDataRequestParams;I)I
    //   125: istore #5
    //   127: iload #5
    //   129: istore_2
    //   130: bipush #-2
    //   132: iload #5
    //   134: if_icmpne -> 19
    //   137: bipush #33
    //   139: aconst_null
    //   140: iload_1
    //   141: aconst_null
    //   142: aconst_null
    //   143: invokestatic a : (ILcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   146: istore_2
    //   147: goto -> 19
    //   150: astore #4
    //   152: aload #4
    //   154: invokevirtual printStackTrace : ()V
    //   157: new android/os/RemoteException
    //   160: astore #4
    //   162: aload #4
    //   164: invokespecial <init> : ()V
    //   167: aload #4
    //   169: athrow
    //   170: astore #4
    //   172: aload_0
    //   173: monitorexit
    //   174: aload #4
    //   176: athrow
    //   177: aload_0
    //   178: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   181: iload_1
    //   182: invokeinterface clearEncryptData : (I)I
    //   187: istore #5
    //   189: goto -> 127
    //   192: astore #4
    //   194: aload #4
    //   196: invokevirtual printStackTrace : ()V
    //   199: new android/os/RemoteException
    //   202: astore #4
    //   204: aload #4
    //   206: invokespecial <init> : ()V
    //   209: aload #4
    //   211: athrow
    //   212: bipush #33
    //   214: aconst_null
    //   215: iload_1
    //   216: aconst_null
    //   217: aconst_null
    //   218: invokestatic a : (ILcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   221: istore_2
    //   222: goto -> 19
    //   225: iconst_m1
    //   226: istore_2
    //   227: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   23	30	170	finally
    //   36	74	170	finally
    //   78	96	170	finally
    //   96	114	170	finally
    //   114	127	150	java/lang/Exception
    //   114	127	170	finally
    //   137	147	170	finally
    //   152	170	170	finally
    //   177	189	192	java/lang/Exception
    //   177	189	170	finally
    //   194	212	170	finally
    //   212	222	170	finally
  }
  
  public int closeChannel(CloseChannelRequestParams paramCloseChannelRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_1
    //   9: ifnull -> 19
    //   12: aload_2
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getChannel : ()Ljava/lang/String;
    //   28: astore #5
    //   30: iload_3
    //   31: istore #4
    //   33: aload #5
    //   35: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   38: ifne -> 19
    //   41: aload_0
    //   42: invokespecial c : ()Z
    //   45: ifne -> 55
    //   48: bipush #-8
    //   50: istore #4
    //   52: goto -> 19
    //   55: aload_0
    //   56: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   59: ifnull -> 318
    //   62: aload_0
    //   63: getfield c : Landroid/content/Context;
    //   66: invokevirtual getPackageName : ()Ljava/lang/String;
    //   69: invokestatic a : (Ljava/lang/String;)Z
    //   72: ifeq -> 306
    //   75: aload_0
    //   76: aload #5
    //   78: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #5
    //   83: new com/unionpay/tsmservice/request/CloseChannelRequestParams
    //   86: astore #6
    //   88: aload #6
    //   90: invokespecial <init> : ()V
    //   93: aload #6
    //   95: aload #5
    //   97: invokevirtual setChannel : (Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual getReserve : ()Ljava/lang/String;
    //   104: astore #7
    //   106: aload #7
    //   108: astore #5
    //   110: aload_0
    //   111: getfield h : Z
    //   114: ifeq -> 128
    //   117: aload_0
    //   118: aload #7
    //   120: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   126: astore #5
    //   128: aload #5
    //   130: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   133: ifne -> 147
    //   136: aload #6
    //   138: aload_0
    //   139: aload #5
    //   141: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual setReserve : (Ljava/lang/String;)V
    //   147: aload_0
    //   148: getfield F : Ljava/util/HashMap;
    //   151: aload_0
    //   152: getfield U : [I
    //   155: bipush #21
    //   157: iaload
    //   158: invokestatic valueOf : (I)Ljava/lang/String;
    //   161: aload_2
    //   162: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload_0
    //   167: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   170: astore #7
    //   172: new com/unionpay/tsmservice/UPTsmAddon$b
    //   175: astore #8
    //   177: aload_0
    //   178: getfield U : [I
    //   181: astore #5
    //   183: aload #5
    //   185: bipush #21
    //   187: iaload
    //   188: istore #4
    //   190: aload #5
    //   192: bipush #21
    //   194: iload #4
    //   196: iconst_1
    //   197: iadd
    //   198: iastore
    //   199: aload #8
    //   201: aload_0
    //   202: bipush #21
    //   204: iload #4
    //   206: iconst_0
    //   207: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   210: aload #7
    //   212: aload #6
    //   214: aload #8
    //   216: invokeinterface closeChannel : (Lcom/unionpay/tsmservice/request/CloseChannelRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   221: istore_3
    //   222: iload_3
    //   223: ifeq -> 265
    //   226: aload_0
    //   227: getfield F : Ljava/util/HashMap;
    //   230: astore #5
    //   232: aload_0
    //   233: getfield U : [I
    //   236: astore #7
    //   238: aload #7
    //   240: bipush #21
    //   242: iaload
    //   243: iconst_1
    //   244: isub
    //   245: istore #4
    //   247: aload #7
    //   249: bipush #21
    //   251: iload #4
    //   253: iastore
    //   254: aload #5
    //   256: iload #4
    //   258: invokestatic valueOf : (I)Ljava/lang/String;
    //   261: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: iload_3
    //   266: istore #4
    //   268: bipush #-2
    //   270: iload_3
    //   271: if_icmpne -> 19
    //   274: bipush #21
    //   276: aload_1
    //   277: aload_2
    //   278: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   281: istore #4
    //   283: goto -> 19
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual printStackTrace : ()V
    //   291: new android/os/RemoteException
    //   294: astore_1
    //   295: aload_1
    //   296: invokespecial <init> : ()V
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    //   306: bipush #21
    //   308: aload_1
    //   309: aload_2
    //   310: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   313: istore #4
    //   315: goto -> 19
    //   318: iconst_m1
    //   319: istore #4
    //   321: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	30	301	finally
    //   33	48	301	finally
    //   55	106	301	finally
    //   110	128	301	finally
    //   128	147	301	finally
    //   147	166	301	finally
    //   166	183	286	java/lang/Exception
    //   166	183	301	finally
    //   199	222	286	java/lang/Exception
    //   199	222	301	finally
    //   226	238	301	finally
    //   254	265	301	finally
    //   274	283	301	finally
    //   287	301	301	finally
    //   306	315	301	finally
  }
  
  public int eCashTopUp(ECashTopUpRequestParams paramECashTopUpRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 363
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 352
    //   50: new com/unionpay/tsmservice/request/ECashTopUpRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload_1
    //   73: invokevirtual getType : ()Ljava/lang/String;
    //   76: astore #7
    //   78: aload_1
    //   79: invokevirtual getAmount : ()Ljava/lang/String;
    //   82: astore #8
    //   84: aload #5
    //   86: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   89: ifne -> 103
    //   92: aload #4
    //   94: aload_0
    //   95: aload #5
    //   97: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual setReserve : (Ljava/lang/String;)V
    //   103: aload #6
    //   105: ifnull -> 167
    //   108: aload #6
    //   110: invokevirtual getAppAid : ()Ljava/lang/String;
    //   113: astore #5
    //   115: aload #6
    //   117: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   120: astore #9
    //   122: aload #5
    //   124: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   127: ifne -> 167
    //   130: aload #9
    //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   135: ifne -> 167
    //   138: new com/unionpay/tsmservice/AppID
    //   141: astore #6
    //   143: aload #6
    //   145: aload_0
    //   146: aload #5
    //   148: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   151: aload_0
    //   152: aload #9
    //   154: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   157: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload #4
    //   162: aload #6
    //   164: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   167: aload_1
    //   168: invokevirtual getEncrpytPin : ()Ljava/lang/String;
    //   171: astore #5
    //   173: aload #5
    //   175: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   178: ifne -> 188
    //   181: aload #4
    //   183: aload #5
    //   185: invokevirtual setEncrpytPin : (Ljava/lang/String;)V
    //   188: aload #7
    //   190: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   193: ifne -> 207
    //   196: aload #4
    //   198: aload_0
    //   199: aload #7
    //   201: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual setType : (Ljava/lang/String;)V
    //   207: aload #8
    //   209: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   212: ifne -> 226
    //   215: aload #4
    //   217: aload_0
    //   218: aload #8
    //   220: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   223: invokevirtual setAmount : (Ljava/lang/String;)V
    //   226: aload_0
    //   227: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   230: astore #7
    //   232: new com/unionpay/tsmservice/UPTsmAddon$b
    //   235: astore #8
    //   237: aload #8
    //   239: aload_0
    //   240: bipush #19
    //   242: aload_0
    //   243: getfield U : [I
    //   246: bipush #19
    //   248: iaload
    //   249: iconst_0
    //   250: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   253: aload #7
    //   255: aload #4
    //   257: aload #8
    //   259: invokeinterface eCashTopUp : (Lcom/unionpay/tsmservice/request/ECashTopUpRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   264: istore #10
    //   266: bipush #-2
    //   268: iload #10
    //   270: if_icmpne -> 304
    //   273: bipush #19
    //   275: aload_1
    //   276: aload_2
    //   277: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   280: istore_3
    //   281: goto -> 13
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual printStackTrace : ()V
    //   289: new android/os/RemoteException
    //   292: astore_1
    //   293: aload_1
    //   294: invokespecial <init> : ()V
    //   297: aload_1
    //   298: athrow
    //   299: astore_1
    //   300: aload_0
    //   301: monitorexit
    //   302: aload_1
    //   303: athrow
    //   304: iload #10
    //   306: istore_3
    //   307: iload #10
    //   309: ifne -> 13
    //   312: aload_0
    //   313: getfield s : Ljava/util/HashMap;
    //   316: astore #4
    //   318: aload_0
    //   319: getfield U : [I
    //   322: astore_1
    //   323: aload_1
    //   324: bipush #19
    //   326: iaload
    //   327: istore_3
    //   328: aload_1
    //   329: bipush #19
    //   331: iload_3
    //   332: iconst_1
    //   333: iadd
    //   334: iastore
    //   335: aload #4
    //   337: iload_3
    //   338: invokestatic valueOf : (I)Ljava/lang/String;
    //   341: aload_2
    //   342: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   345: pop
    //   346: iload #10
    //   348: istore_3
    //   349: goto -> 13
    //   352: bipush #19
    //   354: aload_1
    //   355: aload_2
    //   356: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   359: istore_3
    //   360: goto -> 13
    //   363: iconst_m1
    //   364: istore_3
    //   365: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	299	finally
    //   30	103	299	finally
    //   108	167	299	finally
    //   167	188	299	finally
    //   188	207	299	finally
    //   207	226	299	finally
    //   226	266	284	java/lang/Exception
    //   226	266	299	finally
    //   273	281	299	finally
    //   285	299	299	finally
    //   312	323	299	finally
    //   335	346	299	finally
    //   352	360	299	finally
  }
  
  public int encryptData(EncryptDataRequestParams paramEncryptDataRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull -> 12
    //   8: aload_2
    //   9: ifnonnull -> 19
    //   12: bipush #-3
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial c : ()Z
    //   23: ifne -> 32
    //   26: bipush #-8
    //   28: istore_3
    //   29: goto -> 15
    //   32: aload_0
    //   33: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   36: ifnull -> 367
    //   39: aload_0
    //   40: getfield c : Landroid/content/Context;
    //   43: invokevirtual getPackageName : ()Ljava/lang/String;
    //   46: invokestatic a : (Ljava/lang/String;)Z
    //   49: ifeq -> 356
    //   52: new com/unionpay/tsmservice/request/EncryptDataRequestParams
    //   55: astore #4
    //   57: aload #4
    //   59: invokespecial <init> : ()V
    //   62: aload_1
    //   63: invokevirtual getReserve : ()Ljava/lang/String;
    //   66: astore #5
    //   68: aload #5
    //   70: astore #6
    //   72: aload_0
    //   73: getfield h : Z
    //   76: ifeq -> 90
    //   79: aload_0
    //   80: aload #5
    //   82: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   85: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   88: astore #6
    //   90: aload #6
    //   92: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   95: ifne -> 109
    //   98: aload #4
    //   100: aload_0
    //   101: aload #6
    //   103: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual setReserve : (Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual getData : ()Ljava/util/List;
    //   113: checkcast java/util/ArrayList
    //   116: astore #5
    //   118: aload #5
    //   120: ifnull -> 201
    //   123: aload #5
    //   125: invokevirtual size : ()I
    //   128: istore #7
    //   130: iload #7
    //   132: ifne -> 141
    //   135: bipush #-3
    //   137: istore_3
    //   138: goto -> 15
    //   141: new java/util/ArrayList
    //   144: astore #6
    //   146: aload #6
    //   148: invokespecial <init> : ()V
    //   151: iload_3
    //   152: iload #7
    //   154: if_icmpge -> 194
    //   157: aload #5
    //   159: iload_3
    //   160: invokevirtual get : (I)Ljava/lang/Object;
    //   163: checkcast java/lang/String
    //   166: astore #8
    //   168: aload #8
    //   170: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   173: ifne -> 188
    //   176: aload #6
    //   178: aload_0
    //   179: aload #8
    //   181: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual add : (Ljava/lang/Object;)Z
    //   187: pop
    //   188: iinc #3, 1
    //   191: goto -> 151
    //   194: aload #4
    //   196: aload #6
    //   198: invokevirtual setData : (Ljava/util/List;)V
    //   201: aload_0
    //   202: getfield B : Ljava/util/HashMap;
    //   205: aload_0
    //   206: getfield U : [I
    //   209: bipush #23
    //   211: iaload
    //   212: invokestatic valueOf : (I)Ljava/lang/String;
    //   215: aload_2
    //   216: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: aload_0
    //   221: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   224: astore #5
    //   226: new com/unionpay/tsmservice/UPTsmAddon$b
    //   229: astore #6
    //   231: aload_0
    //   232: getfield U : [I
    //   235: astore #8
    //   237: aload #8
    //   239: bipush #23
    //   241: iaload
    //   242: istore_3
    //   243: aload #8
    //   245: bipush #23
    //   247: iload_3
    //   248: iconst_1
    //   249: iadd
    //   250: iastore
    //   251: aload #6
    //   253: aload_0
    //   254: bipush #23
    //   256: iload_3
    //   257: iconst_0
    //   258: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   261: aload #5
    //   263: aload #4
    //   265: aload #6
    //   267: invokeinterface encryptData : (Lcom/unionpay/tsmservice/request/EncryptDataRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   272: istore #7
    //   274: iload #7
    //   276: ifeq -> 315
    //   279: aload_0
    //   280: getfield B : Ljava/util/HashMap;
    //   283: astore #5
    //   285: aload_0
    //   286: getfield U : [I
    //   289: astore #6
    //   291: aload #6
    //   293: bipush #23
    //   295: iaload
    //   296: iconst_1
    //   297: isub
    //   298: istore_3
    //   299: aload #6
    //   301: bipush #23
    //   303: iload_3
    //   304: iastore
    //   305: aload #5
    //   307: iload_3
    //   308: invokestatic valueOf : (I)Ljava/lang/String;
    //   311: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   314: pop
    //   315: iload #7
    //   317: istore_3
    //   318: bipush #-2
    //   320: iload #7
    //   322: if_icmpne -> 15
    //   325: bipush #23
    //   327: aload_1
    //   328: aload_2
    //   329: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   332: istore_3
    //   333: goto -> 15
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual printStackTrace : ()V
    //   341: new android/os/RemoteException
    //   344: astore_1
    //   345: aload_1
    //   346: invokespecial <init> : ()V
    //   349: aload_1
    //   350: athrow
    //   351: astore_1
    //   352: aload_0
    //   353: monitorexit
    //   354: aload_1
    //   355: athrow
    //   356: bipush #23
    //   358: aload_1
    //   359: aload_2
    //   360: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   363: istore_3
    //   364: goto -> 15
    //   367: iconst_m1
    //   368: istore_3
    //   369: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   19	26	351	finally
    //   32	68	351	finally
    //   72	90	351	finally
    //   90	109	351	finally
    //   109	118	351	finally
    //   123	130	351	finally
    //   141	151	351	finally
    //   157	188	351	finally
    //   194	201	351	finally
    //   201	220	351	finally
    //   220	237	336	java/lang/Exception
    //   220	237	351	finally
    //   251	274	336	java/lang/Exception
    //   251	274	351	finally
    //   279	291	351	finally
    //   305	315	351	finally
    //   325	333	351	finally
    //   337	351	351	finally
    //   356	364	351	finally
  }
  
  public int exchangeKey(String paramString, String[] paramArrayOfString) throws RemoteException {
    byte b = -3;
    if (TextUtils.isEmpty(paramString))
      return b; 
    int i = b;
    if (paramArrayOfString != null) {
      i = b;
      if (paramArrayOfString.length != 0) {
        if (!c())
          return -8; 
        if (this.e != null) {
          try {
            i = this.e.exchangeKey(paramString, paramArrayOfString);
          } catch (Exception exception) {
            exception.printStackTrace();
            throw new RemoteException();
          } 
          return i;
        } 
        i = -1;
      } 
    } 
    return i;
  }
  
  public int executeCmd(ExecuteCmdRequestParams paramExecuteCmdRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 19
    //   10: bipush #-3
    //   12: istore #4
    //   14: aload_0
    //   15: monitorexit
    //   16: iload #4
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial c : ()Z
    //   23: ifne -> 33
    //   26: bipush #-8
    //   28: istore #4
    //   30: goto -> 14
    //   33: aload_0
    //   34: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   37: ifnull -> 338
    //   40: aload_0
    //   41: getfield c : Landroid/content/Context;
    //   44: invokevirtual getPackageName : ()Ljava/lang/String;
    //   47: invokestatic a : (Ljava/lang/String;)Z
    //   50: ifeq -> 325
    //   53: new com/unionpay/tsmservice/request/ExecuteCmdRequestParams
    //   56: astore #5
    //   58: aload #5
    //   60: invokespecial <init> : ()V
    //   63: aload_1
    //   64: invokevirtual getReserve : ()Ljava/lang/String;
    //   67: astore #6
    //   69: aload_1
    //   70: invokevirtual getSsid : ()Ljava/lang/String;
    //   73: astore #7
    //   75: aload_1
    //   76: invokevirtual getSign : ()Ljava/lang/String;
    //   79: astore #8
    //   81: aload #6
    //   83: astore #9
    //   85: aload_0
    //   86: getfield h : Z
    //   89: ifeq -> 103
    //   92: aload_0
    //   93: aload #6
    //   95: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   98: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   101: astore #9
    //   103: aload #9
    //   105: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   108: ifne -> 122
    //   111: aload #5
    //   113: aload_0
    //   114: aload #9
    //   116: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   119: invokevirtual setReserve : (Ljava/lang/String;)V
    //   122: aload #7
    //   124: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   127: ifne -> 141
    //   130: aload #5
    //   132: aload_0
    //   133: aload #7
    //   135: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   138: invokevirtual setSsid : (Ljava/lang/String;)V
    //   141: aload #8
    //   143: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   146: ifne -> 160
    //   149: aload #5
    //   151: aload_0
    //   152: aload #8
    //   154: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual setSign : (Ljava/lang/String;)V
    //   160: aload_0
    //   161: getfield H : Ljava/util/HashMap;
    //   164: aload_0
    //   165: getfield U : [I
    //   168: bipush #25
    //   170: iaload
    //   171: invokestatic valueOf : (I)Ljava/lang/String;
    //   174: aload_2
    //   175: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: aload_0
    //   180: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   183: astore #9
    //   185: new com/unionpay/tsmservice/UPTsmAddon$b
    //   188: astore #6
    //   190: aload_0
    //   191: getfield U : [I
    //   194: astore #8
    //   196: aload #8
    //   198: bipush #25
    //   200: iaload
    //   201: istore #4
    //   203: aload #8
    //   205: bipush #25
    //   207: iload #4
    //   209: iconst_1
    //   210: iadd
    //   211: iastore
    //   212: aload #6
    //   214: aload_0
    //   215: bipush #25
    //   217: iload #4
    //   219: iconst_0
    //   220: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   223: aload #9
    //   225: aload #5
    //   227: aload #6
    //   229: aload_3
    //   230: invokeinterface executeCmd : (Lcom/unionpay/tsmservice/request/ExecuteCmdRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   235: istore #10
    //   237: iload #10
    //   239: ifeq -> 281
    //   242: aload_0
    //   243: getfield H : Ljava/util/HashMap;
    //   246: astore #9
    //   248: aload_0
    //   249: getfield U : [I
    //   252: astore #6
    //   254: aload #6
    //   256: bipush #25
    //   258: iaload
    //   259: iconst_1
    //   260: isub
    //   261: istore #4
    //   263: aload #6
    //   265: bipush #25
    //   267: iload #4
    //   269: iastore
    //   270: aload #9
    //   272: iload #4
    //   274: invokestatic valueOf : (I)Ljava/lang/String;
    //   277: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: iload #10
    //   283: istore #4
    //   285: bipush #-2
    //   287: iload #10
    //   289: if_icmpne -> 14
    //   292: bipush #25
    //   294: aload_1
    //   295: aload_2
    //   296: aload_3
    //   297: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   300: istore #4
    //   302: goto -> 14
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual printStackTrace : ()V
    //   310: new android/os/RemoteException
    //   313: astore_1
    //   314: aload_1
    //   315: invokespecial <init> : ()V
    //   318: aload_1
    //   319: athrow
    //   320: astore_1
    //   321: aload_0
    //   322: monitorexit
    //   323: aload_1
    //   324: athrow
    //   325: bipush #25
    //   327: aload_1
    //   328: aload_2
    //   329: aload_3
    //   330: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   333: istore #4
    //   335: goto -> 14
    //   338: iconst_m1
    //   339: istore #4
    //   341: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   19	26	320	finally
    //   33	81	320	finally
    //   85	103	320	finally
    //   103	122	320	finally
    //   122	141	320	finally
    //   141	160	320	finally
    //   160	179	320	finally
    //   179	196	305	java/lang/Exception
    //   179	196	320	finally
    //   212	237	305	java/lang/Exception
    //   212	237	320	finally
    //   242	254	320	finally
    //   270	281	320	finally
    //   292	302	320	finally
    //   306	320	320	finally
    //   325	335	320	finally
  }
  
  public int getAccountBalance(GetAccountBalanceRequestParams paramGetAccountBalanceRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 313
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 302
    //   50: new com/unionpay/tsmservice/request/GetAccountBalanceRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #7
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #7
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #6
    //   131: aload #6
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #7
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #6
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_1
    //   156: invokevirtual getEncryptPin : ()Ljava/lang/String;
    //   159: astore #5
    //   161: aload #5
    //   163: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   166: ifne -> 176
    //   169: aload #4
    //   171: aload #5
    //   173: invokevirtual setEncryptPin : (Ljava/lang/String;)V
    //   176: aload_0
    //   177: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   180: astore #5
    //   182: new com/unionpay/tsmservice/UPTsmAddon$b
    //   185: astore #6
    //   187: aload #6
    //   189: aload_0
    //   190: bipush #8
    //   192: aload_0
    //   193: getfield U : [I
    //   196: bipush #8
    //   198: iaload
    //   199: iconst_0
    //   200: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   203: aload #5
    //   205: aload #4
    //   207: aload #6
    //   209: invokeinterface getAccountBalance : (Lcom/unionpay/tsmservice/request/GetAccountBalanceRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   214: istore #8
    //   216: bipush #-2
    //   218: iload #8
    //   220: if_icmpne -> 254
    //   223: bipush #8
    //   225: aload_1
    //   226: aload_2
    //   227: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   230: istore_3
    //   231: goto -> 13
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual printStackTrace : ()V
    //   239: new android/os/RemoteException
    //   242: astore_1
    //   243: aload_1
    //   244: invokespecial <init> : ()V
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: aload_0
    //   251: monitorexit
    //   252: aload_1
    //   253: athrow
    //   254: iload #8
    //   256: istore_3
    //   257: iload #8
    //   259: ifne -> 13
    //   262: aload_0
    //   263: getfield v : Ljava/util/HashMap;
    //   266: astore #4
    //   268: aload_0
    //   269: getfield U : [I
    //   272: astore_1
    //   273: aload_1
    //   274: bipush #8
    //   276: iaload
    //   277: istore_3
    //   278: aload_1
    //   279: bipush #8
    //   281: iload_3
    //   282: iconst_1
    //   283: iadd
    //   284: iastore
    //   285: aload #4
    //   287: iload_3
    //   288: invokestatic valueOf : (I)Ljava/lang/String;
    //   291: aload_2
    //   292: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: iload #8
    //   298: istore_3
    //   299: goto -> 13
    //   302: bipush #8
    //   304: aload_1
    //   305: aload_2
    //   306: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   309: istore_3
    //   310: goto -> 13
    //   313: iconst_m1
    //   314: istore_3
    //   315: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	249	finally
    //   30	91	249	finally
    //   96	155	249	finally
    //   155	176	249	finally
    //   176	216	234	java/lang/Exception
    //   176	216	249	finally
    //   223	231	249	finally
    //   235	249	249	finally
    //   262	273	249	finally
    //   285	296	249	finally
    //   302	310	249	finally
  }
  
  public int getAccountInfo(GetAccountInfoRequestParams paramGetAccountInfoRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 292
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 281
    //   50: new com/unionpay/tsmservice/request/GetAccountInfoRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #6
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #6
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #7
    //   131: aload #7
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #6
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #7
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_0
    //   156: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   159: astore #5
    //   161: new com/unionpay/tsmservice/UPTsmAddon$b
    //   164: astore #6
    //   166: aload #6
    //   168: aload_0
    //   169: bipush #7
    //   171: aload_0
    //   172: getfield U : [I
    //   175: bipush #7
    //   177: iaload
    //   178: iconst_0
    //   179: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   182: aload #5
    //   184: aload #4
    //   186: aload #6
    //   188: invokeinterface getAccountInfo : (Lcom/unionpay/tsmservice/request/GetAccountInfoRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   193: istore #8
    //   195: bipush #-2
    //   197: iload #8
    //   199: if_icmpne -> 233
    //   202: bipush #7
    //   204: aload_1
    //   205: aload_2
    //   206: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   209: istore_3
    //   210: goto -> 13
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual printStackTrace : ()V
    //   218: new android/os/RemoteException
    //   221: astore_1
    //   222: aload_1
    //   223: invokespecial <init> : ()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    //   233: iload #8
    //   235: istore_3
    //   236: iload #8
    //   238: ifne -> 13
    //   241: aload_0
    //   242: getfield u : Ljava/util/HashMap;
    //   245: astore #4
    //   247: aload_0
    //   248: getfield U : [I
    //   251: astore_1
    //   252: aload_1
    //   253: bipush #7
    //   255: iaload
    //   256: istore_3
    //   257: aload_1
    //   258: bipush #7
    //   260: iload_3
    //   261: iconst_1
    //   262: iadd
    //   263: iastore
    //   264: aload #4
    //   266: iload_3
    //   267: invokestatic valueOf : (I)Ljava/lang/String;
    //   270: aload_2
    //   271: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: iload #8
    //   277: istore_3
    //   278: goto -> 13
    //   281: bipush #7
    //   283: aload_1
    //   284: aload_2
    //   285: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   288: istore_3
    //   289: goto -> 13
    //   292: iconst_m1
    //   293: istore_3
    //   294: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	228	finally
    //   30	91	228	finally
    //   96	155	228	finally
    //   155	195	213	java/lang/Exception
    //   155	195	228	finally
    //   202	210	228	finally
    //   214	228	228	finally
    //   241	252	228	finally
    //   264	275	228	finally
    //   281	289	228	finally
  }
  
  public int getAppDetail(GetAppDetailRequestParams paramGetAppDetailRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 311
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 301
    //   50: new com/unionpay/tsmservice/request/GetAppDetailRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload_1
    //   73: invokevirtual getTransType : ()Ljava/lang/String;
    //   76: astore #7
    //   78: aload #5
    //   80: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   83: ifne -> 97
    //   86: aload #4
    //   88: aload_0
    //   89: aload #5
    //   91: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual setReserve : (Ljava/lang/String;)V
    //   97: aload #6
    //   99: ifnull -> 161
    //   102: aload #6
    //   104: invokevirtual getAppAid : ()Ljava/lang/String;
    //   107: astore #5
    //   109: aload #6
    //   111: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   114: astore #6
    //   116: aload #5
    //   118: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   121: ifne -> 161
    //   124: aload #6
    //   126: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   129: ifne -> 161
    //   132: new com/unionpay/tsmservice/AppID
    //   135: astore #8
    //   137: aload #8
    //   139: aload_0
    //   140: aload #5
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: aload_0
    //   146: aload #6
    //   148: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   151: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload #4
    //   156: aload #8
    //   158: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   161: aload #7
    //   163: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   166: ifne -> 180
    //   169: aload #4
    //   171: aload_0
    //   172: aload #7
    //   174: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual setTransType : (Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   184: astore #7
    //   186: new com/unionpay/tsmservice/UPTsmAddon$b
    //   189: astore #5
    //   191: aload #5
    //   193: aload_0
    //   194: iconst_4
    //   195: aload_0
    //   196: getfield U : [I
    //   199: iconst_4
    //   200: iaload
    //   201: iconst_0
    //   202: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   205: aload #7
    //   207: aload #4
    //   209: aload #5
    //   211: invokeinterface getAppDetail : (Lcom/unionpay/tsmservice/request/GetAppDetailRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   216: istore #9
    //   218: bipush #-2
    //   220: iload #9
    //   222: if_icmpne -> 255
    //   225: iconst_4
    //   226: aload_1
    //   227: aload_2
    //   228: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   231: istore_3
    //   232: goto -> 13
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual printStackTrace : ()V
    //   240: new android/os/RemoteException
    //   243: astore_1
    //   244: aload_1
    //   245: invokespecial <init> : ()V
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: iload #9
    //   257: istore_3
    //   258: iload #9
    //   260: ifne -> 13
    //   263: aload_0
    //   264: getfield n : Ljava/util/HashMap;
    //   267: astore #4
    //   269: aload_0
    //   270: getfield U : [I
    //   273: astore_1
    //   274: aload_1
    //   275: iconst_4
    //   276: iaload
    //   277: istore_3
    //   278: aload_1
    //   279: iconst_4
    //   280: iload_3
    //   281: iconst_1
    //   282: iadd
    //   283: iastore
    //   284: aload #4
    //   286: iload_3
    //   287: invokestatic valueOf : (I)Ljava/lang/String;
    //   290: aload_2
    //   291: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: iload #9
    //   297: istore_3
    //   298: goto -> 13
    //   301: iconst_4
    //   302: aload_1
    //   303: aload_2
    //   304: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   307: istore_3
    //   308: goto -> 13
    //   311: iconst_m1
    //   312: istore_3
    //   313: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	250	finally
    //   30	97	250	finally
    //   102	161	250	finally
    //   161	180	250	finally
    //   180	218	235	java/lang/Exception
    //   180	218	250	finally
    //   225	232	250	finally
    //   236	250	250	finally
    //   263	274	250	finally
    //   284	295	250	finally
    //   301	308	250	finally
  }
  
  public int getAppList(GetAppListRequestParams paramGetAppListRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull -> 12
    //   8: aload_2
    //   9: ifnonnull -> 19
    //   12: bipush #-3
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial c : ()Z
    //   23: ifne -> 32
    //   26: bipush #-8
    //   28: istore_3
    //   29: goto -> 15
    //   32: aload_0
    //   33: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   36: ifnull -> 308
    //   39: aload_0
    //   40: getfield c : Landroid/content/Context;
    //   43: invokevirtual getPackageName : ()Ljava/lang/String;
    //   46: invokestatic a : (Ljava/lang/String;)Z
    //   49: ifeq -> 298
    //   52: new com/unionpay/tsmservice/request/GetAppListRequestParams
    //   55: astore #4
    //   57: aload #4
    //   59: invokespecial <init> : ()V
    //   62: aload_1
    //   63: invokevirtual getReserve : ()Ljava/lang/String;
    //   66: astore #5
    //   68: aload_1
    //   69: invokevirtual getKeyword : ()Ljava/lang/String;
    //   72: astore #6
    //   74: aload_1
    //   75: invokevirtual getStatus : ()[Ljava/lang/String;
    //   78: astore #7
    //   80: aload #5
    //   82: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   85: ifne -> 99
    //   88: aload #4
    //   90: aload_0
    //   91: aload #5
    //   93: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   96: invokevirtual setReserve : (Ljava/lang/String;)V
    //   99: aload #6
    //   101: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   104: ifne -> 118
    //   107: aload #4
    //   109: aload_0
    //   110: aload #6
    //   112: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   115: invokevirtual setKeyword : (Ljava/lang/String;)V
    //   118: aload #7
    //   120: ifnull -> 176
    //   123: aload #7
    //   125: arraylength
    //   126: istore #8
    //   128: iload #8
    //   130: anewarray java/lang/String
    //   133: astore #6
    //   135: iload_3
    //   136: iload #8
    //   138: if_icmpge -> 169
    //   141: aload #7
    //   143: iload_3
    //   144: aaload
    //   145: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   148: ifne -> 163
    //   151: aload #6
    //   153: iload_3
    //   154: aload_0
    //   155: aload #7
    //   157: iload_3
    //   158: aaload
    //   159: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   162: aastore
    //   163: iinc #3, 1
    //   166: goto -> 135
    //   169: aload #4
    //   171: aload #6
    //   173: invokevirtual setStatus : ([Ljava/lang/String;)V
    //   176: aload_0
    //   177: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   180: astore #7
    //   182: new com/unionpay/tsmservice/UPTsmAddon$b
    //   185: astore #6
    //   187: aload #6
    //   189: aload_0
    //   190: iconst_2
    //   191: aload_0
    //   192: getfield U : [I
    //   195: iconst_2
    //   196: iaload
    //   197: iconst_0
    //   198: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   201: aload #7
    //   203: aload #4
    //   205: aload #6
    //   207: invokeinterface getAppList : (Lcom/unionpay/tsmservice/request/GetAppListRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   212: istore #8
    //   214: bipush #-2
    //   216: iload #8
    //   218: if_icmpne -> 251
    //   221: iconst_2
    //   222: aload_1
    //   223: aload_2
    //   224: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   227: istore_3
    //   228: goto -> 15
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual printStackTrace : ()V
    //   236: new android/os/RemoteException
    //   239: astore_1
    //   240: aload_1
    //   241: invokespecial <init> : ()V
    //   244: aload_1
    //   245: athrow
    //   246: astore_1
    //   247: aload_0
    //   248: monitorexit
    //   249: aload_1
    //   250: athrow
    //   251: iload #8
    //   253: istore_3
    //   254: iload #8
    //   256: ifne -> 15
    //   259: aload_0
    //   260: getfield l : Ljava/util/HashMap;
    //   263: astore_1
    //   264: aload_0
    //   265: getfield U : [I
    //   268: astore #4
    //   270: aload #4
    //   272: iconst_2
    //   273: iaload
    //   274: istore_3
    //   275: aload #4
    //   277: iconst_2
    //   278: iload_3
    //   279: iconst_1
    //   280: iadd
    //   281: iastore
    //   282: aload_1
    //   283: iload_3
    //   284: invokestatic valueOf : (I)Ljava/lang/String;
    //   287: aload_2
    //   288: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: iload #8
    //   294: istore_3
    //   295: goto -> 15
    //   298: iconst_2
    //   299: aload_1
    //   300: aload_2
    //   301: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   304: istore_3
    //   305: goto -> 15
    //   308: iconst_m1
    //   309: istore_3
    //   310: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   19	26	246	finally
    //   32	99	246	finally
    //   99	118	246	finally
    //   123	135	246	finally
    //   141	163	246	finally
    //   169	176	246	finally
    //   176	214	231	java/lang/Exception
    //   176	214	246	finally
    //   221	228	246	finally
    //   232	246	246	finally
    //   259	270	246	finally
    //   282	292	246	finally
    //   298	305	246	finally
  }
  
  public int getAppStatus(GetAppStatusRequestParams paramGetAppStatusRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 287
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 277
    //   50: new com/unionpay/tsmservice/request/GetAppStatusRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #7
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #7
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #6
    //   131: aload #6
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #7
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #6
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_0
    //   156: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   159: astore #6
    //   161: new com/unionpay/tsmservice/UPTsmAddon$b
    //   164: astore #5
    //   166: aload #5
    //   168: aload_0
    //   169: iconst_5
    //   170: aload_0
    //   171: getfield U : [I
    //   174: iconst_5
    //   175: iaload
    //   176: iconst_0
    //   177: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   180: aload #6
    //   182: aload #4
    //   184: aload #5
    //   186: invokeinterface getAppStatus : (Lcom/unionpay/tsmservice/request/GetAppStatusRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   191: istore #8
    //   193: bipush #-2
    //   195: iload #8
    //   197: if_icmpne -> 230
    //   200: iconst_5
    //   201: aload_1
    //   202: aload_2
    //   203: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   206: istore_3
    //   207: goto -> 13
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual printStackTrace : ()V
    //   215: new android/os/RemoteException
    //   218: astore_1
    //   219: aload_1
    //   220: invokespecial <init> : ()V
    //   223: aload_1
    //   224: athrow
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: iload #8
    //   232: istore_3
    //   233: iload #8
    //   235: ifne -> 13
    //   238: aload_0
    //   239: getfield m : Ljava/util/HashMap;
    //   242: astore_1
    //   243: aload_0
    //   244: getfield U : [I
    //   247: astore #4
    //   249: aload #4
    //   251: iconst_5
    //   252: iaload
    //   253: istore_3
    //   254: aload #4
    //   256: iconst_5
    //   257: iload_3
    //   258: iconst_1
    //   259: iadd
    //   260: iastore
    //   261: aload_1
    //   262: iload_3
    //   263: invokestatic valueOf : (I)Ljava/lang/String;
    //   266: aload_2
    //   267: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: iload #8
    //   273: istore_3
    //   274: goto -> 13
    //   277: iconst_5
    //   278: aload_1
    //   279: aload_2
    //   280: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   283: istore_3
    //   284: goto -> 13
    //   287: iconst_m1
    //   288: istore_3
    //   289: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	225	finally
    //   30	91	225	finally
    //   96	155	225	finally
    //   155	193	210	java/lang/Exception
    //   155	193	225	finally
    //   200	207	225	finally
    //   211	225	225	finally
    //   238	249	225	finally
    //   261	271	225	finally
    //   277	284	225	finally
  }
  
  public int getAssociatedApp(GetAssociatedAppRequestParams paramGetAssociatedAppRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_1
    //   9: ifnull -> 19
    //   12: aload_2
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getEncryptPan : ()Ljava/lang/String;
    //   28: astore #5
    //   30: iload_3
    //   31: istore #4
    //   33: aload #5
    //   35: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   38: ifne -> 19
    //   41: aload_0
    //   42: invokespecial c : ()Z
    //   45: ifne -> 55
    //   48: bipush #-8
    //   50: istore #4
    //   52: goto -> 19
    //   55: aload_0
    //   56: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   59: ifnull -> 276
    //   62: aload_0
    //   63: getfield c : Landroid/content/Context;
    //   66: invokevirtual getPackageName : ()Ljava/lang/String;
    //   69: invokestatic a : (Ljava/lang/String;)Z
    //   72: ifeq -> 265
    //   75: new com/unionpay/tsmservice/request/GetAssociatedAppRequestParams
    //   78: astore #6
    //   80: aload #6
    //   82: invokespecial <init> : ()V
    //   85: aload_1
    //   86: invokevirtual getReserve : ()Ljava/lang/String;
    //   89: astore #7
    //   91: aload #7
    //   93: astore #8
    //   95: aload_0
    //   96: getfield h : Z
    //   99: ifeq -> 113
    //   102: aload_0
    //   103: aload #7
    //   105: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   108: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   111: astore #8
    //   113: aload #8
    //   115: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   118: ifne -> 132
    //   121: aload #6
    //   123: aload_0
    //   124: aload #8
    //   126: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   129: invokevirtual setReserve : (Ljava/lang/String;)V
    //   132: aload #6
    //   134: aload_0
    //   135: aload #5
    //   137: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual setEncryptPan : (Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   147: astore #7
    //   149: new com/unionpay/tsmservice/UPTsmAddon$b
    //   152: astore #8
    //   154: aload #8
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_0
    //   159: getfield U : [I
    //   162: iconst_1
    //   163: iaload
    //   164: iconst_0
    //   165: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   168: aload #7
    //   170: aload #6
    //   172: aload #8
    //   174: invokeinterface getAssociatedApp : (Lcom/unionpay/tsmservice/request/GetAssociatedAppRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   179: istore_3
    //   180: bipush #-2
    //   182: iload_3
    //   183: if_icmpne -> 217
    //   186: iconst_1
    //   187: aload_1
    //   188: aload_2
    //   189: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   192: istore #4
    //   194: goto -> 19
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual printStackTrace : ()V
    //   202: new android/os/RemoteException
    //   205: astore_1
    //   206: aload_1
    //   207: invokespecial <init> : ()V
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: iload_3
    //   218: istore #4
    //   220: iload_3
    //   221: ifne -> 19
    //   224: aload_0
    //   225: getfield j : Ljava/util/HashMap;
    //   228: astore #8
    //   230: aload_0
    //   231: getfield U : [I
    //   234: astore_1
    //   235: aload_1
    //   236: iconst_1
    //   237: iaload
    //   238: istore #4
    //   240: aload_1
    //   241: iconst_1
    //   242: iload #4
    //   244: iconst_1
    //   245: iadd
    //   246: iastore
    //   247: aload #8
    //   249: iload #4
    //   251: invokestatic valueOf : (I)Ljava/lang/String;
    //   254: aload_2
    //   255: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: pop
    //   259: iload_3
    //   260: istore #4
    //   262: goto -> 19
    //   265: iconst_1
    //   266: aload_1
    //   267: aload_2
    //   268: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   271: istore #4
    //   273: goto -> 19
    //   276: iconst_m1
    //   277: istore #4
    //   279: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	30	212	finally
    //   33	48	212	finally
    //   55	91	212	finally
    //   95	113	212	finally
    //   113	132	212	finally
    //   132	143	212	finally
    //   143	180	197	java/lang/Exception
    //   143	180	212	finally
    //   186	194	212	finally
    //   198	212	212	finally
    //   224	235	212	finally
    //   247	259	212	finally
    //   265	273	212	finally
  }
  
  public int getCardInfo(GetCardInfoRequestParams paramGetCardInfoRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_1
    //   9: ifnull -> 19
    //   12: aload_2
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getAppAID : ()[Ljava/lang/String;
    //   28: astore #5
    //   30: aload #5
    //   32: arraylength
    //   33: istore #6
    //   35: iload_3
    //   36: istore #4
    //   38: aload #5
    //   40: ifnull -> 19
    //   43: iload_3
    //   44: istore #4
    //   46: iload #6
    //   48: ifeq -> 19
    //   51: iconst_0
    //   52: istore #7
    //   54: iload #7
    //   56: iload #6
    //   58: if_icmpge -> 75
    //   61: aload #5
    //   63: iload #7
    //   65: aaload
    //   66: ifnonnull -> 75
    //   69: iinc #7, 1
    //   72: goto -> 54
    //   75: iload_3
    //   76: istore #4
    //   78: iload #7
    //   80: iload #6
    //   82: if_icmpeq -> 19
    //   85: aload_0
    //   86: invokespecial c : ()Z
    //   89: ifne -> 99
    //   92: bipush #-8
    //   94: istore #4
    //   96: goto -> 19
    //   99: aload_0
    //   100: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   103: ifnull -> 385
    //   106: aload_0
    //   107: getfield c : Landroid/content/Context;
    //   110: invokevirtual getPackageName : ()Ljava/lang/String;
    //   113: invokestatic a : (Ljava/lang/String;)Z
    //   116: ifeq -> 373
    //   119: iload #6
    //   121: anewarray java/lang/String
    //   124: astore #8
    //   126: iconst_0
    //   127: istore #4
    //   129: iload #4
    //   131: iload #6
    //   133: if_icmpge -> 182
    //   136: aload #5
    //   138: iload #4
    //   140: aaload
    //   141: ifnonnull -> 160
    //   144: aload #8
    //   146: iload #4
    //   148: aload #5
    //   150: iload #4
    //   152: aaload
    //   153: aastore
    //   154: iinc #4, 1
    //   157: goto -> 129
    //   160: aload #8
    //   162: iload #4
    //   164: aload_0
    //   165: aload #5
    //   167: iload #4
    //   169: aaload
    //   170: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   173: aastore
    //   174: goto -> 154
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: new com/unionpay/tsmservice/request/GetCardInfoRequestParams
    //   185: astore #9
    //   187: aload #9
    //   189: invokespecial <init> : ()V
    //   192: aload #9
    //   194: aload #8
    //   196: invokevirtual setAppAID : ([Ljava/lang/String;)V
    //   199: aload_1
    //   200: invokevirtual getReserve : ()Ljava/lang/String;
    //   203: astore #5
    //   205: aload #5
    //   207: astore #8
    //   209: aload_0
    //   210: getfield h : Z
    //   213: ifeq -> 227
    //   216: aload_0
    //   217: aload #5
    //   219: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   222: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   225: astore #8
    //   227: aload #8
    //   229: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   232: ifne -> 246
    //   235: aload #9
    //   237: aload_0
    //   238: aload #8
    //   240: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   243: invokevirtual setReserve : (Ljava/lang/String;)V
    //   246: aload_0
    //   247: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   250: astore #5
    //   252: new com/unionpay/tsmservice/UPTsmAddon$b
    //   255: astore #8
    //   257: aload #8
    //   259: aload_0
    //   260: bipush #6
    //   262: aload_0
    //   263: getfield U : [I
    //   266: bipush #6
    //   268: iaload
    //   269: iconst_0
    //   270: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   273: aload #5
    //   275: aload #9
    //   277: aload #8
    //   279: invokeinterface getCardInfo : (Lcom/unionpay/tsmservice/request/GetCardInfoRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   284: istore #7
    //   286: bipush #-2
    //   288: iload #7
    //   290: if_icmpne -> 320
    //   293: bipush #6
    //   295: aload_1
    //   296: aload_2
    //   297: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   300: istore #4
    //   302: goto -> 19
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual printStackTrace : ()V
    //   310: new android/os/RemoteException
    //   313: astore_1
    //   314: aload_1
    //   315: invokespecial <init> : ()V
    //   318: aload_1
    //   319: athrow
    //   320: iload #7
    //   322: istore #4
    //   324: iload #7
    //   326: ifne -> 19
    //   329: aload_0
    //   330: getfield A : Ljava/util/HashMap;
    //   333: astore #8
    //   335: aload_0
    //   336: getfield U : [I
    //   339: astore_1
    //   340: aload_1
    //   341: bipush #6
    //   343: iaload
    //   344: istore #4
    //   346: aload_1
    //   347: bipush #6
    //   349: iload #4
    //   351: iconst_1
    //   352: iadd
    //   353: iastore
    //   354: aload #8
    //   356: iload #4
    //   358: invokestatic valueOf : (I)Ljava/lang/String;
    //   361: aload_2
    //   362: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: iload #7
    //   368: istore #4
    //   370: goto -> 19
    //   373: bipush #6
    //   375: aload_1
    //   376: aload_2
    //   377: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   380: istore #4
    //   382: goto -> 19
    //   385: iconst_m1
    //   386: istore #4
    //   388: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	35	177	finally
    //   85	92	177	finally
    //   99	126	177	finally
    //   160	174	177	finally
    //   182	205	177	finally
    //   209	227	177	finally
    //   227	246	177	finally
    //   246	286	305	java/lang/Exception
    //   246	286	177	finally
    //   293	302	177	finally
    //   306	320	177	finally
    //   329	340	177	finally
    //   354	366	177	finally
    //   373	382	177	finally
  }
  
  public int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams paramGetCardInfoBySpayRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 353
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 342
    //   50: new com/unionpay/tsmservice/request/GetCardInfoBySpayRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload #5
    //   68: astore #6
    //   70: aload_0
    //   71: getfield h : Z
    //   74: ifeq -> 88
    //   77: aload_0
    //   78: aload #5
    //   80: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   83: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   86: astore #6
    //   88: aload #6
    //   90: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   93: ifne -> 107
    //   96: aload #4
    //   98: aload_0
    //   99: aload #6
    //   101: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual setReserve : (Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokevirtual getAmount : ()Lcom/unionpay/tsmservice/data/Amount;
    //   111: astore #5
    //   113: aload #5
    //   115: ifnull -> 187
    //   118: aload #5
    //   120: invokevirtual getCurrencyType : ()Ljava/lang/String;
    //   123: astore #6
    //   125: aload #5
    //   127: invokevirtual getProductPrice : ()Ljava/lang/String;
    //   130: astore #7
    //   132: new com/unionpay/tsmservice/data/Amount
    //   135: astore #5
    //   137: aload #5
    //   139: invokespecial <init> : ()V
    //   142: aload #6
    //   144: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   147: ifne -> 161
    //   150: aload #5
    //   152: aload_0
    //   153: aload #6
    //   155: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual setCurrencyType : (Ljava/lang/String;)V
    //   161: aload #7
    //   163: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   166: ifne -> 180
    //   169: aload #5
    //   171: aload_0
    //   172: aload #7
    //   174: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual setProductPrice : (Ljava/lang/String;)V
    //   180: aload #4
    //   182: aload #5
    //   184: invokevirtual setAmount : (Lcom/unionpay/tsmservice/data/Amount;)V
    //   187: aload_0
    //   188: getfield I : Ljava/util/HashMap;
    //   191: aload_0
    //   192: getfield U : [I
    //   195: bipush #28
    //   197: iaload
    //   198: invokestatic valueOf : (I)Ljava/lang/String;
    //   201: aload_2
    //   202: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload_0
    //   207: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   210: astore #7
    //   212: new com/unionpay/tsmservice/UPTsmAddon$b
    //   215: astore #5
    //   217: aload_0
    //   218: getfield U : [I
    //   221: astore #6
    //   223: aload #6
    //   225: bipush #28
    //   227: iaload
    //   228: istore_3
    //   229: aload #6
    //   231: bipush #28
    //   233: iload_3
    //   234: iconst_1
    //   235: iadd
    //   236: iastore
    //   237: aload #5
    //   239: aload_0
    //   240: bipush #28
    //   242: iload_3
    //   243: iconst_0
    //   244: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   247: aload #7
    //   249: aload #4
    //   251: aload #5
    //   253: invokeinterface getCardInfoBySamsungPay : (Lcom/unionpay/tsmservice/request/GetCardInfoBySpayRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   258: istore #8
    //   260: iload #8
    //   262: ifeq -> 301
    //   265: aload_0
    //   266: getfield I : Ljava/util/HashMap;
    //   269: astore #5
    //   271: aload_0
    //   272: getfield U : [I
    //   275: astore #6
    //   277: aload #6
    //   279: bipush #28
    //   281: iaload
    //   282: iconst_1
    //   283: isub
    //   284: istore_3
    //   285: aload #6
    //   287: bipush #28
    //   289: iload_3
    //   290: iastore
    //   291: aload #5
    //   293: iload_3
    //   294: invokestatic valueOf : (I)Ljava/lang/String;
    //   297: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   300: pop
    //   301: iload #8
    //   303: istore_3
    //   304: bipush #-2
    //   306: iload #8
    //   308: if_icmpne -> 13
    //   311: bipush #28
    //   313: aload_1
    //   314: aload_2
    //   315: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   318: istore_3
    //   319: goto -> 13
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual printStackTrace : ()V
    //   327: new android/os/RemoteException
    //   330: astore_1
    //   331: aload_1
    //   332: invokespecial <init> : ()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: bipush #28
    //   344: aload_1
    //   345: aload_2
    //   346: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   349: istore_3
    //   350: goto -> 13
    //   353: iconst_m1
    //   354: istore_3
    //   355: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	337	finally
    //   30	66	337	finally
    //   70	88	337	finally
    //   88	107	337	finally
    //   107	113	337	finally
    //   118	161	337	finally
    //   161	180	337	finally
    //   180	187	337	finally
    //   187	206	337	finally
    //   206	223	322	java/lang/Exception
    //   206	223	337	finally
    //   237	260	322	java/lang/Exception
    //   237	260	337	finally
    //   265	277	337	finally
    //   291	301	337	finally
    //   311	319	337	finally
    //   323	337	337	finally
    //   342	350	337	finally
  }
  
  public Context getContext() {
    return this.c;
  }
  
  public int getCryptType() {
    return this.g;
  }
  
  public int getDefaultCard(GetDefaultCardRequestParams paramGetDefaultCardRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 13
    //   6: bipush #-3
    //   8: istore_3
    //   9: aload_0
    //   10: monitorexit
    //   11: iload_3
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial c : ()Z
    //   17: ifne -> 26
    //   20: bipush #-8
    //   22: istore_3
    //   23: goto -> 9
    //   26: aload_0
    //   27: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   30: ifnull -> 222
    //   33: aload_0
    //   34: getfield c : Landroid/content/Context;
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Z
    //   43: ifeq -> 211
    //   46: new com/unionpay/tsmservice/request/GetDefaultCardRequestParams
    //   49: astore #4
    //   51: aload #4
    //   53: invokespecial <init> : ()V
    //   56: aload_1
    //   57: ifnull -> 85
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload #5
    //   68: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   71: ifne -> 85
    //   74: aload #4
    //   76: aload_0
    //   77: aload #5
    //   79: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual setReserve : (Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   89: astore #6
    //   91: new com/unionpay/tsmservice/UPTsmAddon$b
    //   94: astore #5
    //   96: aload #5
    //   98: aload_0
    //   99: bipush #13
    //   101: aload_0
    //   102: getfield U : [I
    //   105: bipush #13
    //   107: iaload
    //   108: iconst_0
    //   109: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   112: aload #6
    //   114: aload #4
    //   116: aload #5
    //   118: invokeinterface getDefaultCard : (Lcom/unionpay/tsmservice/request/GetDefaultCardRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   123: istore #7
    //   125: bipush #-2
    //   127: iload #7
    //   129: if_icmpne -> 163
    //   132: bipush #13
    //   134: aload_1
    //   135: aload_2
    //   136: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   139: istore_3
    //   140: goto -> 9
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual printStackTrace : ()V
    //   148: new android/os/RemoteException
    //   151: astore_1
    //   152: aload_1
    //   153: invokespecial <init> : ()V
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    //   163: iload #7
    //   165: istore_3
    //   166: iload #7
    //   168: ifne -> 9
    //   171: aload_0
    //   172: getfield y : Ljava/util/HashMap;
    //   175: astore #4
    //   177: aload_0
    //   178: getfield U : [I
    //   181: astore_1
    //   182: aload_1
    //   183: bipush #13
    //   185: iaload
    //   186: istore_3
    //   187: aload_1
    //   188: bipush #13
    //   190: iload_3
    //   191: iconst_1
    //   192: iadd
    //   193: iastore
    //   194: aload #4
    //   196: iload_3
    //   197: invokestatic valueOf : (I)Ljava/lang/String;
    //   200: aload_2
    //   201: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: iload #7
    //   207: istore_3
    //   208: goto -> 9
    //   211: bipush #13
    //   213: aload_1
    //   214: aload_2
    //   215: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   218: istore_3
    //   219: goto -> 9
    //   222: iconst_m1
    //   223: istore_3
    //   224: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   13	20	158	finally
    //   26	56	158	finally
    //   60	85	158	finally
    //   85	125	143	java/lang/Exception
    //   85	125	158	finally
    //   132	140	158	finally
    //   144	158	158	finally
    //   171	182	158	finally
    //   194	205	158	finally
    //   211	219	158	finally
  }
  
  public int getEncryptData(GetEncryptDataRequestParams paramGetEncryptDataRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_2
    //   9: ifnull -> 19
    //   12: aload_1
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getType : ()I
    //   28: istore #5
    //   30: aload_1
    //   31: invokevirtual getPan : ()Ljava/lang/String;
    //   34: astore #6
    //   36: iload_3
    //   37: istore #4
    //   39: iload #5
    //   41: sipush #2000
    //   44: if_icmplt -> 19
    //   47: iload_3
    //   48: istore #4
    //   50: iload #5
    //   52: sipush #2001
    //   55: if_icmpgt -> 19
    //   58: iload #5
    //   60: sipush #2000
    //   63: if_icmpne -> 77
    //   66: iload_3
    //   67: istore #4
    //   69: aload #6
    //   71: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   74: ifne -> 19
    //   77: aload_0
    //   78: invokespecial c : ()Z
    //   81: ifne -> 91
    //   84: bipush #-8
    //   86: istore #4
    //   88: goto -> 19
    //   91: aload_0
    //   92: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   95: ifnull -> 365
    //   98: aload_0
    //   99: getfield c : Landroid/content/Context;
    //   102: invokevirtual getPackageName : ()Ljava/lang/String;
    //   105: invokestatic a : (Ljava/lang/String;)Z
    //   108: ifeq -> 353
    //   111: new com/unionpay/tsmservice/request/GetEncryptDataRequestParams
    //   114: astore #7
    //   116: aload #7
    //   118: invokespecial <init> : ()V
    //   121: iload #5
    //   123: sipush #2000
    //   126: if_icmpne -> 140
    //   129: aload #7
    //   131: aload_0
    //   132: aload #6
    //   134: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   137: invokevirtual setPan : (Ljava/lang/String;)V
    //   140: aload #7
    //   142: iload #5
    //   144: invokevirtual setType : (I)V
    //   147: aload_1
    //   148: invokevirtual getReserve : ()Ljava/lang/String;
    //   151: astore #8
    //   153: aload #8
    //   155: astore #6
    //   157: aload_0
    //   158: getfield h : Z
    //   161: ifeq -> 175
    //   164: aload_0
    //   165: aload #8
    //   167: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   170: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   173: astore #6
    //   175: aload #6
    //   177: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   180: ifne -> 194
    //   183: aload #7
    //   185: aload_0
    //   186: aload #6
    //   188: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   191: invokevirtual setReserve : (Ljava/lang/String;)V
    //   194: aload_0
    //   195: getfield L : Ljava/util/HashMap;
    //   198: aload_0
    //   199: getfield U : [I
    //   202: bipush #31
    //   204: iaload
    //   205: invokestatic valueOf : (I)Ljava/lang/String;
    //   208: aload_2
    //   209: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload_0
    //   214: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   217: astore #9
    //   219: new com/unionpay/tsmservice/UPTsmAddon$b
    //   222: astore #6
    //   224: aload_0
    //   225: getfield U : [I
    //   228: astore #8
    //   230: aload #8
    //   232: bipush #31
    //   234: iaload
    //   235: istore #4
    //   237: aload #8
    //   239: bipush #31
    //   241: iload #4
    //   243: iconst_1
    //   244: iadd
    //   245: iastore
    //   246: aload #6
    //   248: aload_0
    //   249: bipush #31
    //   251: iload #4
    //   253: iconst_0
    //   254: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   257: aload #9
    //   259: aload #7
    //   261: aload #6
    //   263: invokeinterface getEncryptData : (Lcom/unionpay/tsmservice/request/GetEncryptDataRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   268: istore_3
    //   269: iload_3
    //   270: ifeq -> 312
    //   273: aload_0
    //   274: getfield L : Ljava/util/HashMap;
    //   277: astore #8
    //   279: aload_0
    //   280: getfield U : [I
    //   283: astore #6
    //   285: aload #6
    //   287: bipush #31
    //   289: iaload
    //   290: iconst_1
    //   291: isub
    //   292: istore #4
    //   294: aload #6
    //   296: bipush #31
    //   298: iload #4
    //   300: iastore
    //   301: aload #8
    //   303: iload #4
    //   305: invokestatic valueOf : (I)Ljava/lang/String;
    //   308: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   311: pop
    //   312: iload_3
    //   313: istore #4
    //   315: bipush #-2
    //   317: iload_3
    //   318: if_icmpne -> 19
    //   321: bipush #31
    //   323: aload_1
    //   324: aload_2
    //   325: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   328: istore #4
    //   330: goto -> 19
    //   333: astore_1
    //   334: aload_1
    //   335: invokevirtual printStackTrace : ()V
    //   338: new android/os/RemoteException
    //   341: astore_1
    //   342: aload_1
    //   343: invokespecial <init> : ()V
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: aload_0
    //   350: monitorexit
    //   351: aload_1
    //   352: athrow
    //   353: bipush #31
    //   355: aload_1
    //   356: aload_2
    //   357: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   360: istore #4
    //   362: goto -> 19
    //   365: iconst_m1
    //   366: istore #4
    //   368: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	36	348	finally
    //   69	77	348	finally
    //   77	84	348	finally
    //   91	121	348	finally
    //   129	140	348	finally
    //   140	153	348	finally
    //   157	175	348	finally
    //   175	194	348	finally
    //   194	213	348	finally
    //   213	230	333	java/lang/Exception
    //   213	230	348	finally
    //   246	269	333	java/lang/Exception
    //   246	269	348	finally
    //   273	285	348	finally
    //   301	312	348	finally
    //   321	330	348	finally
    //   334	348	348	finally
    //   353	362	348	finally
  }
  
  public int getListenerCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   5: ifnull -> 19
    //   8: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   11: invokevirtual size : ()I
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_1
    //   21: goto -> 15
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	24	finally
  }
  
  public int getPubKey(int paramInt, String[] paramArrayOfString) throws RemoteException {
    if (paramArrayOfString == null || paramArrayOfString.length == 0)
      return -3; 
    if (!c())
      return -8; 
    if (this.e != null) {
      try {
        paramInt = this.e.getPubKey(paramInt, paramArrayOfString);
      } catch (Exception exception) {
        exception.printStackTrace();
        throw new RemoteException();
      } 
      return paramInt;
    } 
    return -1;
  }
  
  public int getSEAppList(GetSeAppListRequestParams paramGetSeAppListRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 13
    //   6: bipush #-3
    //   8: istore_3
    //   9: aload_0
    //   10: monitorexit
    //   11: iload_3
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial c : ()Z
    //   17: ifne -> 26
    //   20: bipush #-8
    //   22: istore_3
    //   23: goto -> 9
    //   26: aload_0
    //   27: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   30: ifnull -> 269
    //   33: aload_0
    //   34: getfield c : Landroid/content/Context;
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Z
    //   43: ifeq -> 259
    //   46: new com/unionpay/tsmservice/request/GetSeAppListRequestParams
    //   49: astore #4
    //   51: aload #4
    //   53: invokespecial <init> : ()V
    //   56: ldc ''
    //   58: astore #5
    //   60: aload_1
    //   61: ifnull -> 70
    //   64: aload_1
    //   65: invokevirtual getReserve : ()Ljava/lang/String;
    //   68: astore #5
    //   70: aload #5
    //   72: astore #6
    //   74: aload_0
    //   75: getfield h : Z
    //   78: ifeq -> 92
    //   81: aload_0
    //   82: aload #5
    //   84: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   87: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   90: astore #6
    //   92: aload #6
    //   94: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   97: ifne -> 111
    //   100: aload #4
    //   102: aload_0
    //   103: aload #6
    //   105: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual setReserve : (Ljava/lang/String;)V
    //   111: aload_0
    //   112: getfield k : Ljava/util/HashMap;
    //   115: aload_0
    //   116: getfield U : [I
    //   119: iconst_3
    //   120: iaload
    //   121: invokestatic valueOf : (I)Ljava/lang/String;
    //   124: aload_2
    //   125: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   133: astore #6
    //   135: new com/unionpay/tsmservice/UPTsmAddon$b
    //   138: astore #7
    //   140: aload_0
    //   141: getfield U : [I
    //   144: astore #5
    //   146: aload #5
    //   148: iconst_3
    //   149: iaload
    //   150: istore_3
    //   151: aload #5
    //   153: iconst_3
    //   154: iload_3
    //   155: iconst_1
    //   156: iadd
    //   157: iastore
    //   158: aload #7
    //   160: aload_0
    //   161: iconst_3
    //   162: iload_3
    //   163: iconst_0
    //   164: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   167: aload #6
    //   169: aload #4
    //   171: aload #7
    //   173: invokeinterface getSEAppList : (Lcom/unionpay/tsmservice/request/GetSeAppListRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   178: istore #8
    //   180: iload #8
    //   182: ifeq -> 219
    //   185: aload_0
    //   186: getfield k : Ljava/util/HashMap;
    //   189: astore #5
    //   191: aload_0
    //   192: getfield U : [I
    //   195: astore #6
    //   197: aload #6
    //   199: iconst_3
    //   200: iaload
    //   201: iconst_1
    //   202: isub
    //   203: istore_3
    //   204: aload #6
    //   206: iconst_3
    //   207: iload_3
    //   208: iastore
    //   209: aload #5
    //   211: iload_3
    //   212: invokestatic valueOf : (I)Ljava/lang/String;
    //   215: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: iload #8
    //   221: istore_3
    //   222: bipush #-2
    //   224: iload #8
    //   226: if_icmpne -> 9
    //   229: iconst_3
    //   230: aload_1
    //   231: aload_2
    //   232: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   235: istore_3
    //   236: goto -> 9
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual printStackTrace : ()V
    //   244: new android/os/RemoteException
    //   247: astore_1
    //   248: aload_1
    //   249: invokespecial <init> : ()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_1
    //   258: athrow
    //   259: iconst_3
    //   260: aload_1
    //   261: aload_2
    //   262: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   265: istore_3
    //   266: goto -> 9
    //   269: iconst_m1
    //   270: istore_3
    //   271: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   13	20	254	finally
    //   26	56	254	finally
    //   64	70	254	finally
    //   74	92	254	finally
    //   92	111	254	finally
    //   111	129	254	finally
    //   129	146	239	java/lang/Exception
    //   129	146	254	finally
    //   158	180	239	java/lang/Exception
    //   158	180	254	finally
    //   185	197	254	finally
    //   209	219	254	finally
    //   229	236	254	finally
    //   240	254	254	finally
    //   259	266	254	finally
  }
  
  public int getSMSAuthCode(GetSMSAuthCodeRequestParams paramGetSMSAuthCodeRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 342
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 331
    //   50: new com/unionpay/tsmservice/request/GetSMSAuthCodeRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #7
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #7
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #6
    //   131: aload #6
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #7
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #6
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_1
    //   156: invokevirtual getPan : ()Ljava/lang/String;
    //   159: astore #5
    //   161: aload_1
    //   162: invokevirtual getMsisdn : ()Ljava/lang/String;
    //   165: astore #6
    //   167: aload #5
    //   169: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   172: ifne -> 186
    //   175: aload #4
    //   177: aload_0
    //   178: aload #5
    //   180: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   183: invokevirtual setPan : (Ljava/lang/String;)V
    //   186: aload #6
    //   188: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   191: ifne -> 205
    //   194: aload #4
    //   196: aload_0
    //   197: aload #6
    //   199: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual setMsisdn : (Ljava/lang/String;)V
    //   205: aload_0
    //   206: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   209: astore #5
    //   211: new com/unionpay/tsmservice/UPTsmAddon$b
    //   214: astore #6
    //   216: aload #6
    //   218: aload_0
    //   219: bipush #11
    //   221: aload_0
    //   222: getfield U : [I
    //   225: bipush #11
    //   227: iaload
    //   228: iconst_0
    //   229: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   232: aload #5
    //   234: aload #4
    //   236: aload #6
    //   238: invokeinterface getSMSAuthCode : (Lcom/unionpay/tsmservice/request/GetSMSAuthCodeRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   243: istore #8
    //   245: bipush #-2
    //   247: iload #8
    //   249: if_icmpne -> 283
    //   252: bipush #11
    //   254: aload_1
    //   255: aload_2
    //   256: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   259: istore_3
    //   260: goto -> 13
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual printStackTrace : ()V
    //   268: new android/os/RemoteException
    //   271: astore_1
    //   272: aload_1
    //   273: invokespecial <init> : ()V
    //   276: aload_1
    //   277: athrow
    //   278: astore_1
    //   279: aload_0
    //   280: monitorexit
    //   281: aload_1
    //   282: athrow
    //   283: iload #8
    //   285: istore_3
    //   286: iload #8
    //   288: ifne -> 13
    //   291: aload_0
    //   292: getfield r : Ljava/util/HashMap;
    //   295: astore #4
    //   297: aload_0
    //   298: getfield U : [I
    //   301: astore_1
    //   302: aload_1
    //   303: bipush #11
    //   305: iaload
    //   306: istore_3
    //   307: aload_1
    //   308: bipush #11
    //   310: iload_3
    //   311: iconst_1
    //   312: iadd
    //   313: iastore
    //   314: aload #4
    //   316: iload_3
    //   317: invokestatic valueOf : (I)Ljava/lang/String;
    //   320: aload_2
    //   321: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: pop
    //   325: iload #8
    //   327: istore_3
    //   328: goto -> 13
    //   331: bipush #11
    //   333: aload_1
    //   334: aload_2
    //   335: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   338: istore_3
    //   339: goto -> 13
    //   342: iconst_m1
    //   343: istore_3
    //   344: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	278	finally
    //   30	91	278	finally
    //   96	155	278	finally
    //   155	186	278	finally
    //   186	205	278	finally
    //   205	245	263	java/lang/Exception
    //   205	245	278	finally
    //   252	260	278	finally
    //   264	278	278	finally
    //   291	302	278	finally
    //   314	325	278	finally
    //   331	339	278	finally
  }
  
  public int getSeId(GetSeIdRequestParams paramGetSeIdRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 13
    //   6: bipush #-3
    //   8: istore_3
    //   9: aload_0
    //   10: monitorexit
    //   11: iload_3
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial c : ()Z
    //   17: ifne -> 26
    //   20: bipush #-8
    //   22: istore_3
    //   23: goto -> 9
    //   26: aload_0
    //   27: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   30: ifnull -> 277
    //   33: aload_0
    //   34: getfield c : Landroid/content/Context;
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Z
    //   43: ifeq -> 266
    //   46: new com/unionpay/tsmservice/request/GetSeIdRequestParams
    //   49: astore #4
    //   51: aload #4
    //   53: invokespecial <init> : ()V
    //   56: ldc ''
    //   58: astore #5
    //   60: aload_1
    //   61: ifnull -> 70
    //   64: aload_1
    //   65: invokevirtual getReserve : ()Ljava/lang/String;
    //   68: astore #5
    //   70: aload #5
    //   72: astore #6
    //   74: aload_0
    //   75: getfield h : Z
    //   78: ifeq -> 92
    //   81: aload_0
    //   82: aload #5
    //   84: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   87: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   90: astore #6
    //   92: aload #6
    //   94: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   97: ifne -> 111
    //   100: aload #4
    //   102: aload_0
    //   103: aload #6
    //   105: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual setReserve : (Ljava/lang/String;)V
    //   111: aload_0
    //   112: getfield z : Ljava/util/HashMap;
    //   115: aload_0
    //   116: getfield U : [I
    //   119: bipush #12
    //   121: iaload
    //   122: invokestatic valueOf : (I)Ljava/lang/String;
    //   125: aload_2
    //   126: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: aload_0
    //   131: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   134: astore #6
    //   136: new com/unionpay/tsmservice/UPTsmAddon$b
    //   139: astore #5
    //   141: aload_0
    //   142: getfield U : [I
    //   145: astore #7
    //   147: aload #7
    //   149: bipush #12
    //   151: iaload
    //   152: istore_3
    //   153: aload #7
    //   155: bipush #12
    //   157: iload_3
    //   158: iconst_1
    //   159: iadd
    //   160: iastore
    //   161: aload #5
    //   163: aload_0
    //   164: bipush #12
    //   166: iload_3
    //   167: iconst_0
    //   168: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   171: aload #6
    //   173: aload #4
    //   175: aload #5
    //   177: invokeinterface getSEId : (Lcom/unionpay/tsmservice/request/GetSeIdRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   182: istore #8
    //   184: iload #8
    //   186: ifeq -> 225
    //   189: aload_0
    //   190: getfield z : Ljava/util/HashMap;
    //   193: astore #5
    //   195: aload_0
    //   196: getfield U : [I
    //   199: astore #6
    //   201: aload #6
    //   203: bipush #12
    //   205: iaload
    //   206: iconst_1
    //   207: isub
    //   208: istore_3
    //   209: aload #6
    //   211: bipush #12
    //   213: iload_3
    //   214: iastore
    //   215: aload #5
    //   217: iload_3
    //   218: invokestatic valueOf : (I)Ljava/lang/String;
    //   221: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: iload #8
    //   227: istore_3
    //   228: bipush #-2
    //   230: iload #8
    //   232: if_icmpne -> 9
    //   235: bipush #12
    //   237: aload_1
    //   238: aload_2
    //   239: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   242: istore_3
    //   243: goto -> 9
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual printStackTrace : ()V
    //   251: new android/os/RemoteException
    //   254: astore_1
    //   255: aload_1
    //   256: invokespecial <init> : ()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_0
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    //   266: bipush #12
    //   268: aload_1
    //   269: aload_2
    //   270: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   273: istore_3
    //   274: goto -> 9
    //   277: iconst_m1
    //   278: istore_3
    //   279: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   13	20	261	finally
    //   26	56	261	finally
    //   64	70	261	finally
    //   74	92	261	finally
    //   92	111	261	finally
    //   111	130	261	finally
    //   130	147	246	java/lang/Exception
    //   130	147	261	finally
    //   161	184	246	java/lang/Exception
    //   161	184	261	finally
    //   189	201	261	finally
    //   215	225	261	finally
    //   235	243	261	finally
    //   247	261	261	finally
    //   266	274	261	finally
  }
  
  public int getTransElements(GetTransElementsRequestParams paramGetTransElementsRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 318
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 307
    //   50: new com/unionpay/tsmservice/request/GetTransElementsRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload_1
    //   73: invokevirtual getTransType : ()Ljava/lang/String;
    //   76: astore #7
    //   78: aload #5
    //   80: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   83: ifne -> 97
    //   86: aload #4
    //   88: aload_0
    //   89: aload #5
    //   91: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual setReserve : (Ljava/lang/String;)V
    //   97: aload #6
    //   99: ifnull -> 161
    //   102: aload #6
    //   104: invokevirtual getAppAid : ()Ljava/lang/String;
    //   107: astore #5
    //   109: aload #6
    //   111: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   114: astore #8
    //   116: aload #5
    //   118: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   121: ifne -> 161
    //   124: aload #8
    //   126: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   129: ifne -> 161
    //   132: new com/unionpay/tsmservice/AppID
    //   135: astore #6
    //   137: aload #6
    //   139: aload_0
    //   140: aload #5
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: aload_0
    //   146: aload #8
    //   148: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   151: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload #4
    //   156: aload #6
    //   158: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   161: aload #7
    //   163: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   166: ifne -> 180
    //   169: aload #4
    //   171: aload_0
    //   172: aload #7
    //   174: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual setTransType : (Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   184: astore #5
    //   186: new com/unionpay/tsmservice/UPTsmAddon$b
    //   189: astore #7
    //   191: aload #7
    //   193: aload_0
    //   194: bipush #9
    //   196: aload_0
    //   197: getfield U : [I
    //   200: bipush #9
    //   202: iaload
    //   203: iconst_0
    //   204: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   207: aload #5
    //   209: aload #4
    //   211: aload #7
    //   213: invokeinterface getTransElements : (Lcom/unionpay/tsmservice/request/GetTransElementsRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   218: istore #9
    //   220: bipush #-2
    //   222: iload #9
    //   224: if_icmpne -> 258
    //   227: bipush #9
    //   229: aload_1
    //   230: aload_2
    //   231: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   234: istore_3
    //   235: goto -> 13
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual printStackTrace : ()V
    //   243: new android/os/RemoteException
    //   246: astore_1
    //   247: aload_1
    //   248: invokespecial <init> : ()V
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: aload_0
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    //   258: iload #9
    //   260: istore_3
    //   261: iload #9
    //   263: ifne -> 13
    //   266: aload_0
    //   267: getfield o : Ljava/util/HashMap;
    //   270: astore_1
    //   271: aload_0
    //   272: getfield U : [I
    //   275: astore #4
    //   277: aload #4
    //   279: bipush #9
    //   281: iaload
    //   282: istore_3
    //   283: aload #4
    //   285: bipush #9
    //   287: iload_3
    //   288: iconst_1
    //   289: iadd
    //   290: iastore
    //   291: aload_1
    //   292: iload_3
    //   293: invokestatic valueOf : (I)Ljava/lang/String;
    //   296: aload_2
    //   297: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   300: pop
    //   301: iload #9
    //   303: istore_3
    //   304: goto -> 13
    //   307: bipush #9
    //   309: aload_1
    //   310: aload_2
    //   311: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   314: istore_3
    //   315: goto -> 13
    //   318: iconst_m1
    //   319: istore_3
    //   320: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	253	finally
    //   30	97	253	finally
    //   102	161	253	finally
    //   161	180	253	finally
    //   180	220	238	java/lang/Exception
    //   180	220	253	finally
    //   227	235	253	finally
    //   239	253	253	finally
    //   266	277	253	finally
    //   291	301	253	finally
    //   307	315	253	finally
  }
  
  public int getTransRecord(GetTransRecordRequestParams paramGetTransRecordRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 292
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 281
    //   50: new com/unionpay/tsmservice/request/GetTransRecordRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getAppID : ()Lcom/unionpay/tsmservice/AppID;
    //   70: astore #6
    //   72: aload #5
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifne -> 91
    //   80: aload #4
    //   82: aload_0
    //   83: aload #5
    //   85: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual setReserve : (Ljava/lang/String;)V
    //   91: aload #6
    //   93: ifnull -> 155
    //   96: aload #6
    //   98: invokevirtual getAppAid : ()Ljava/lang/String;
    //   101: astore #5
    //   103: aload #6
    //   105: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   108: astore #7
    //   110: aload #5
    //   112: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   115: ifne -> 155
    //   118: aload #7
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifne -> 155
    //   126: new com/unionpay/tsmservice/AppID
    //   129: astore #6
    //   131: aload #6
    //   133: aload_0
    //   134: aload #5
    //   136: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aload_0
    //   140: aload #7
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload #4
    //   150: aload #6
    //   152: invokevirtual setAppID : (Lcom/unionpay/tsmservice/AppID;)V
    //   155: aload_0
    //   156: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   159: astore #6
    //   161: new com/unionpay/tsmservice/UPTsmAddon$b
    //   164: astore #5
    //   166: aload #5
    //   168: aload_0
    //   169: bipush #10
    //   171: aload_0
    //   172: getfield U : [I
    //   175: bipush #10
    //   177: iaload
    //   178: iconst_0
    //   179: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   182: aload #6
    //   184: aload #4
    //   186: aload #5
    //   188: invokeinterface getTransRecord : (Lcom/unionpay/tsmservice/request/GetTransRecordRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   193: istore #8
    //   195: bipush #-2
    //   197: iload #8
    //   199: if_icmpne -> 233
    //   202: bipush #10
    //   204: aload_1
    //   205: aload_2
    //   206: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   209: istore_3
    //   210: goto -> 13
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual printStackTrace : ()V
    //   218: new android/os/RemoteException
    //   221: astore_1
    //   222: aload_1
    //   223: invokespecial <init> : ()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    //   233: iload #8
    //   235: istore_3
    //   236: iload #8
    //   238: ifne -> 13
    //   241: aload_0
    //   242: getfield t : Ljava/util/HashMap;
    //   245: astore #4
    //   247: aload_0
    //   248: getfield U : [I
    //   251: astore_1
    //   252: aload_1
    //   253: bipush #10
    //   255: iaload
    //   256: istore_3
    //   257: aload_1
    //   258: bipush #10
    //   260: iload_3
    //   261: iconst_1
    //   262: iadd
    //   263: iastore
    //   264: aload #4
    //   266: iload_3
    //   267: invokestatic valueOf : (I)Ljava/lang/String;
    //   270: aload_2
    //   271: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: iload #8
    //   277: istore_3
    //   278: goto -> 13
    //   281: bipush #10
    //   283: aload_1
    //   284: aload_2
    //   285: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   288: istore_3
    //   289: goto -> 13
    //   292: iconst_m1
    //   293: istore_3
    //   294: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	228	finally
    //   30	91	228	finally
    //   96	155	228	finally
    //   155	195	213	java/lang/Exception
    //   155	195	228	finally
    //   202	210	228	finally
    //   214	228	228	finally
    //   241	252	228	finally
    //   264	275	228	finally
    //   281	289	228	finally
  }
  
  public int getVendorPayStatus(GetVendorPayStatusRequestParams paramGetVendorPayStatusRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ifnonnull -> 18
    //   9: bipush #-3
    //   11: istore #4
    //   13: aload_0
    //   14: monitorexit
    //   15: iload #4
    //   17: ireturn
    //   18: iload_3
    //   19: istore #4
    //   21: aload_0
    //   22: ldc_w '01.00.20'
    //   25: invokespecial d : (Ljava/lang/String;)Z
    //   28: ifeq -> 13
    //   31: iload_3
    //   32: istore #4
    //   34: aload_0
    //   35: invokespecial c : ()Z
    //   38: ifeq -> 13
    //   41: aload_0
    //   42: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   45: ifnull -> 297
    //   48: aload_0
    //   49: getfield c : Landroid/content/Context;
    //   52: invokevirtual getPackageName : ()Ljava/lang/String;
    //   55: invokestatic a : (Ljava/lang/String;)Z
    //   58: ifeq -> 285
    //   61: new com/unionpay/tsmservice/request/GetVendorPayStatusRequestParams
    //   64: astore #5
    //   66: aload #5
    //   68: invokespecial <init> : ()V
    //   71: ldc ''
    //   73: astore #6
    //   75: aload_1
    //   76: ifnull -> 85
    //   79: aload_1
    //   80: invokevirtual getReserve : ()Ljava/lang/String;
    //   83: astore #6
    //   85: aload #6
    //   87: astore #7
    //   89: aload_0
    //   90: getfield h : Z
    //   93: ifeq -> 107
    //   96: aload_0
    //   97: aload #6
    //   99: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   102: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   105: astore #7
    //   107: aload #7
    //   109: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   112: ifne -> 126
    //   115: aload #5
    //   117: aload_0
    //   118: aload #7
    //   120: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual setReserve : (Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield N : Ljava/util/HashMap;
    //   130: aload_0
    //   131: getfield U : [I
    //   134: bipush #36
    //   136: iaload
    //   137: invokestatic valueOf : (I)Ljava/lang/String;
    //   140: aload_2
    //   141: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload_0
    //   146: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   149: astore #7
    //   151: new com/unionpay/tsmservice/UPTsmAddon$b
    //   154: astore #8
    //   156: aload_0
    //   157: getfield U : [I
    //   160: astore #6
    //   162: aload #6
    //   164: bipush #36
    //   166: iaload
    //   167: istore #4
    //   169: aload #6
    //   171: bipush #36
    //   173: iload #4
    //   175: iconst_1
    //   176: iadd
    //   177: iastore
    //   178: aload #8
    //   180: aload_0
    //   181: bipush #36
    //   183: iload #4
    //   185: iconst_0
    //   186: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   189: aload #7
    //   191: aload #5
    //   193: aload #8
    //   195: invokeinterface getVendorPayStatus : (Lcom/unionpay/tsmservice/request/GetVendorPayStatusRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   200: istore_3
    //   201: iload_3
    //   202: ifeq -> 244
    //   205: aload_0
    //   206: getfield N : Ljava/util/HashMap;
    //   209: astore #6
    //   211: aload_0
    //   212: getfield U : [I
    //   215: astore #7
    //   217: aload #7
    //   219: bipush #36
    //   221: iaload
    //   222: iconst_1
    //   223: isub
    //   224: istore #4
    //   226: aload #7
    //   228: bipush #36
    //   230: iload #4
    //   232: iastore
    //   233: aload #6
    //   235: iload #4
    //   237: invokestatic valueOf : (I)Ljava/lang/String;
    //   240: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: iload_3
    //   245: istore #4
    //   247: bipush #-2
    //   249: iload_3
    //   250: if_icmpne -> 13
    //   253: bipush #36
    //   255: aload_1
    //   256: aload_2
    //   257: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   260: istore #4
    //   262: goto -> 13
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual printStackTrace : ()V
    //   270: new android/os/RemoteException
    //   273: astore_1
    //   274: aload_1
    //   275: invokespecial <init> : ()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: bipush #36
    //   287: aload_1
    //   288: aload_2
    //   289: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   292: istore #4
    //   294: goto -> 13
    //   297: iconst_m1
    //   298: istore #4
    //   300: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   21	31	280	finally
    //   34	71	280	finally
    //   79	85	280	finally
    //   89	107	280	finally
    //   107	126	280	finally
    //   126	145	280	finally
    //   145	162	265	java/lang/Exception
    //   145	162	280	finally
    //   178	201	265	java/lang/Exception
    //   178	201	280	finally
    //   205	217	280	finally
    //   233	244	280	finally
    //   253	262	280	finally
    //   266	280	280	finally
    //   285	294	280	finally
  }
  
  public int hideAppApply(HideAppApplyRequestParams paramHideAppApplyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_1
    //   9: ifnull -> 19
    //   12: aload_2
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getApplyId : ()Ljava/lang/String;
    //   28: astore #5
    //   30: iload_3
    //   31: istore #4
    //   33: aload #5
    //   35: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   38: ifne -> 19
    //   41: aload_0
    //   42: invokespecial c : ()Z
    //   45: ifne -> 55
    //   48: bipush #-8
    //   50: istore #4
    //   52: goto -> 19
    //   55: aload_0
    //   56: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   59: ifnull -> 264
    //   62: aload_0
    //   63: getfield c : Landroid/content/Context;
    //   66: invokevirtual getPackageName : ()Ljava/lang/String;
    //   69: invokestatic a : (Ljava/lang/String;)Z
    //   72: ifeq -> 252
    //   75: aload_0
    //   76: aload #5
    //   78: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #6
    //   83: new com/unionpay/tsmservice/request/HideAppApplyRequestParams
    //   86: astore #5
    //   88: aload #5
    //   90: invokespecial <init> : ()V
    //   93: aload #5
    //   95: aload #6
    //   97: invokevirtual setApplyId : (Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual getReserve : ()Ljava/lang/String;
    //   104: astore #6
    //   106: aload #6
    //   108: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   111: ifne -> 125
    //   114: aload #5
    //   116: aload_0
    //   117: aload #6
    //   119: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   122: invokevirtual setReserve : (Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   129: astore #6
    //   131: new com/unionpay/tsmservice/UPTsmAddon$b
    //   134: astore #7
    //   136: aload #7
    //   138: aload_0
    //   139: bipush #24
    //   141: aload_0
    //   142: getfield U : [I
    //   145: bipush #24
    //   147: iaload
    //   148: iconst_0
    //   149: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   152: aload #6
    //   154: aload #5
    //   156: aload #7
    //   158: invokeinterface hideAppApply : (Lcom/unionpay/tsmservice/request/HideAppApplyRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   163: istore_3
    //   164: bipush #-2
    //   166: iload_3
    //   167: if_icmpne -> 202
    //   170: bipush #24
    //   172: aload_1
    //   173: aload_2
    //   174: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   177: istore #4
    //   179: goto -> 19
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual printStackTrace : ()V
    //   187: new android/os/RemoteException
    //   190: astore_1
    //   191: aload_1
    //   192: invokespecial <init> : ()V
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    //   202: iload_3
    //   203: istore #4
    //   205: iload_3
    //   206: ifne -> 19
    //   209: aload_0
    //   210: getfield G : Ljava/util/HashMap;
    //   213: astore #5
    //   215: aload_0
    //   216: getfield U : [I
    //   219: astore_1
    //   220: aload_1
    //   221: bipush #24
    //   223: iaload
    //   224: istore #4
    //   226: aload_1
    //   227: bipush #24
    //   229: iload #4
    //   231: iconst_1
    //   232: iadd
    //   233: iastore
    //   234: aload #5
    //   236: iload #4
    //   238: invokestatic valueOf : (I)Ljava/lang/String;
    //   241: aload_2
    //   242: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: iload_3
    //   247: istore #4
    //   249: goto -> 19
    //   252: bipush #24
    //   254: aload_1
    //   255: aload_2
    //   256: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   259: istore #4
    //   261: goto -> 19
    //   264: iconst_m1
    //   265: istore #4
    //   267: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	30	197	finally
    //   33	48	197	finally
    //   55	125	197	finally
    //   125	164	182	java/lang/Exception
    //   125	164	197	finally
    //   170	179	197	finally
    //   183	197	197	finally
    //   209	220	197	finally
    //   234	246	197	finally
    //   252	261	197	finally
  }
  
  public int hideKeyboard() throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial c : ()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 18
    //   11: bipush #-8
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: aload_0
    //   19: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   22: ifnull -> 205
    //   25: aload_0
    //   26: getfield c : Landroid/content/Context;
    //   29: invokevirtual getPackageName : ()Ljava/lang/String;
    //   32: invokestatic a : (Ljava/lang/String;)Z
    //   35: ifeq -> 192
    //   38: aload_0
    //   39: ldc_w '01.00.24'
    //   42: invokespecial d : (Ljava/lang/String;)Z
    //   45: ifeq -> 158
    //   48: new com/unionpay/tsmservice/request/HideSafetyKeyboardRequestParams
    //   51: astore_3
    //   52: aload_3
    //   53: invokespecial <init> : ()V
    //   56: ldc ''
    //   58: astore #4
    //   60: aload_0
    //   61: getfield h : Z
    //   64: ifeq -> 78
    //   67: aload_0
    //   68: ldc ''
    //   70: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   73: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   76: astore #4
    //   78: aload #4
    //   80: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   83: ifne -> 96
    //   86: aload_3
    //   87: aload_0
    //   88: aload #4
    //   90: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   93: invokevirtual setReserve : (Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   100: aload_3
    //   101: invokeinterface hideSafetyKeyboard : (Lcom/unionpay/tsmservice/request/HideSafetyKeyboardRequestParams;)I
    //   106: istore #5
    //   108: iload #5
    //   110: istore_2
    //   111: bipush #-2
    //   113: iload #5
    //   115: if_icmpne -> 14
    //   118: bipush #34
    //   120: aconst_null
    //   121: iconst_0
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokestatic a : (ILcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   127: istore_2
    //   128: goto -> 14
    //   131: astore #4
    //   133: aload #4
    //   135: invokevirtual printStackTrace : ()V
    //   138: new android/os/RemoteException
    //   141: astore #4
    //   143: aload #4
    //   145: invokespecial <init> : ()V
    //   148: aload #4
    //   150: athrow
    //   151: astore #4
    //   153: aload_0
    //   154: monitorexit
    //   155: aload #4
    //   157: athrow
    //   158: aload_0
    //   159: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   162: invokeinterface hideKeyboard : ()I
    //   167: istore #5
    //   169: goto -> 108
    //   172: astore #4
    //   174: aload #4
    //   176: invokevirtual printStackTrace : ()V
    //   179: new android/os/RemoteException
    //   182: astore #4
    //   184: aload #4
    //   186: invokespecial <init> : ()V
    //   189: aload #4
    //   191: athrow
    //   192: bipush #34
    //   194: aconst_null
    //   195: iconst_0
    //   196: aconst_null
    //   197: aconst_null
    //   198: invokestatic a : (ILcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   201: istore_2
    //   202: goto -> 14
    //   205: iconst_m1
    //   206: istore_2
    //   207: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   2	7	151	finally
    //   18	56	151	finally
    //   60	78	151	finally
    //   78	96	151	finally
    //   96	108	131	java/lang/Exception
    //   96	108	151	finally
    //   118	128	151	finally
    //   133	151	151	finally
    //   158	169	172	java/lang/Exception
    //   158	169	151	finally
    //   174	192	151	finally
    //   192	202	151	finally
  }
  
  public int init(InitRequestParams paramInitRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 13
    //   6: bipush #-3
    //   8: istore_3
    //   9: aload_0
    //   10: monitorexit
    //   11: iload_3
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial c : ()Z
    //   17: ifne -> 26
    //   20: bipush #-8
    //   22: istore_3
    //   23: goto -> 9
    //   26: aload_0
    //   27: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   30: ifnull -> 302
    //   33: aload_0
    //   34: getfield c : Landroid/content/Context;
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Z
    //   43: ifeq -> 292
    //   46: new com/unionpay/tsmservice/request/InitRequestParams
    //   49: astore #4
    //   51: aload #4
    //   53: invokespecial <init> : ()V
    //   56: ldc ''
    //   58: astore #5
    //   60: aload_1
    //   61: ifnull -> 103
    //   64: aload_1
    //   65: invokevirtual getReserve : ()Ljava/lang/String;
    //   68: astore #6
    //   70: aload_1
    //   71: invokevirtual getSignature : ()Ljava/lang/String;
    //   74: astore #7
    //   76: aload #6
    //   78: astore #5
    //   80: aload #7
    //   82: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   85: ifne -> 103
    //   88: aload #4
    //   90: aload_0
    //   91: aload #7
    //   93: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   96: invokevirtual setSignature : (Ljava/lang/String;)V
    //   99: aload #6
    //   101: astore #5
    //   103: aload #5
    //   105: astore #6
    //   107: aload_0
    //   108: getfield h : Z
    //   111: ifeq -> 125
    //   114: aload_0
    //   115: aload #5
    //   117: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   120: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   123: astore #6
    //   125: aload #6
    //   127: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   130: ifne -> 144
    //   133: aload #4
    //   135: aload_0
    //   136: aload #6
    //   138: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   141: invokevirtual setReserve : (Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield i : Ljava/util/HashMap;
    //   148: aload_0
    //   149: getfield U : [I
    //   152: iconst_0
    //   153: iaload
    //   154: invokestatic valueOf : (I)Ljava/lang/String;
    //   157: aload_2
    //   158: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: aload_0
    //   163: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   166: astore #5
    //   168: new com/unionpay/tsmservice/UPTsmAddon$b
    //   171: astore #7
    //   173: aload_0
    //   174: getfield U : [I
    //   177: astore #6
    //   179: aload #6
    //   181: iconst_0
    //   182: iaload
    //   183: istore_3
    //   184: aload #6
    //   186: iconst_0
    //   187: iload_3
    //   188: iconst_1
    //   189: iadd
    //   190: iastore
    //   191: aload #7
    //   193: aload_0
    //   194: iconst_0
    //   195: iload_3
    //   196: iconst_0
    //   197: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   200: aload #5
    //   202: aload #4
    //   204: aload #7
    //   206: invokeinterface init : (Lcom/unionpay/tsmservice/request/InitRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   211: istore #8
    //   213: iload #8
    //   215: ifeq -> 252
    //   218: aload_0
    //   219: getfield i : Ljava/util/HashMap;
    //   222: astore #5
    //   224: aload_0
    //   225: getfield U : [I
    //   228: astore #6
    //   230: aload #6
    //   232: iconst_0
    //   233: iaload
    //   234: iconst_1
    //   235: isub
    //   236: istore_3
    //   237: aload #6
    //   239: iconst_0
    //   240: iload_3
    //   241: iastore
    //   242: aload #5
    //   244: iload_3
    //   245: invokestatic valueOf : (I)Ljava/lang/String;
    //   248: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: iload #8
    //   254: istore_3
    //   255: bipush #-2
    //   257: iload #8
    //   259: if_icmpne -> 9
    //   262: iconst_0
    //   263: aload_1
    //   264: aload_2
    //   265: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   268: istore_3
    //   269: goto -> 9
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual printStackTrace : ()V
    //   277: new android/os/RemoteException
    //   280: astore_1
    //   281: aload_1
    //   282: invokespecial <init> : ()V
    //   285: aload_1
    //   286: athrow
    //   287: astore_1
    //   288: aload_0
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    //   292: iconst_0
    //   293: aload_1
    //   294: aload_2
    //   295: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   298: istore_3
    //   299: goto -> 9
    //   302: iconst_m1
    //   303: istore_3
    //   304: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   13	20	287	finally
    //   26	56	287	finally
    //   64	76	287	finally
    //   80	99	287	finally
    //   107	125	287	finally
    //   125	144	287	finally
    //   144	162	287	finally
    //   162	179	272	java/lang/Exception
    //   162	179	287	finally
    //   191	213	272	java/lang/Exception
    //   191	213	287	finally
    //   218	230	287	finally
    //   242	252	287	finally
    //   262	269	287	finally
    //   273	287	287	finally
    //   292	299	287	finally
  }
  
  public boolean isConnected() {
    return this.f;
  }
  
  public int onlinePaymentVerify(OnlinePaymentVerifyRequestParams paramOnlinePaymentVerifyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnull -> 22
    //   9: aload_2
    //   10: ifnonnull -> 22
    //   13: bipush #-3
    //   15: istore #4
    //   17: aload_0
    //   18: monitorexit
    //   19: iload #4
    //   21: ireturn
    //   22: iload_3
    //   23: istore #4
    //   25: aload_0
    //   26: ldc_w '01.00.21'
    //   29: invokespecial d : (Ljava/lang/String;)Z
    //   32: ifeq -> 17
    //   35: iload_3
    //   36: istore #4
    //   38: aload_0
    //   39: invokespecial c : ()Z
    //   42: ifeq -> 17
    //   45: aload_0
    //   46: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   49: ifnull -> 385
    //   52: aload_0
    //   53: getfield c : Landroid/content/Context;
    //   56: invokevirtual getPackageName : ()Ljava/lang/String;
    //   59: invokestatic a : (Ljava/lang/String;)Z
    //   62: ifeq -> 373
    //   65: new com/unionpay/tsmservice/request/OnlinePaymentVerifyRequestParams
    //   68: astore #5
    //   70: aload #5
    //   72: invokespecial <init> : ()V
    //   75: aload_1
    //   76: invokevirtual getResource : ()Landroid/os/Bundle;
    //   79: astore #6
    //   81: aload #6
    //   83: ifnull -> 117
    //   86: new android/os/Bundle
    //   89: astore #7
    //   91: aload #7
    //   93: invokespecial <init> : ()V
    //   96: aload #7
    //   98: ldc_w 'encryptData'
    //   101: aload_0
    //   102: aload #6
    //   104: invokespecial a : (Landroid/os/Bundle;)Ljava/lang/String;
    //   107: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload #5
    //   112: aload #7
    //   114: invokevirtual setResource : (Landroid/os/Bundle;)V
    //   117: aload_1
    //   118: invokevirtual getOrderNumber : ()Ljava/lang/String;
    //   121: astore #6
    //   123: aload_1
    //   124: invokevirtual getAId : ()Ljava/lang/String;
    //   127: astore #7
    //   129: aload #6
    //   131: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   134: ifne -> 148
    //   137: aload #5
    //   139: aload_0
    //   140: aload #6
    //   142: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual setOrderNumber : (Ljava/lang/String;)V
    //   148: aload #7
    //   150: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   153: ifne -> 167
    //   156: aload #5
    //   158: aload_0
    //   159: aload #7
    //   161: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   164: invokevirtual setAId : (Ljava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual getReserve : ()Ljava/lang/String;
    //   171: astore #6
    //   173: aload #6
    //   175: astore #7
    //   177: aload_0
    //   178: getfield h : Z
    //   181: ifeq -> 195
    //   184: aload_0
    //   185: aload #6
    //   187: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   190: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   193: astore #7
    //   195: aload #7
    //   197: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   200: ifne -> 214
    //   203: aload #5
    //   205: aload_0
    //   206: aload #7
    //   208: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   211: invokevirtual setReserve : (Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield Q : Ljava/util/HashMap;
    //   218: aload_0
    //   219: getfield U : [I
    //   222: bipush #39
    //   224: iaload
    //   225: invokestatic valueOf : (I)Ljava/lang/String;
    //   228: aload_2
    //   229: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: aload_0
    //   234: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   237: astore #6
    //   239: new com/unionpay/tsmservice/UPTsmAddon$b
    //   242: astore #7
    //   244: aload_0
    //   245: getfield U : [I
    //   248: astore #8
    //   250: aload #8
    //   252: bipush #39
    //   254: iaload
    //   255: istore #4
    //   257: aload #8
    //   259: bipush #39
    //   261: iload #4
    //   263: iconst_1
    //   264: iadd
    //   265: iastore
    //   266: aload #7
    //   268: aload_0
    //   269: bipush #39
    //   271: iload #4
    //   273: iconst_0
    //   274: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   277: aload #6
    //   279: aload #5
    //   281: aload #7
    //   283: invokeinterface onlinePaymentVerify : (Lcom/unionpay/tsmservice/request/OnlinePaymentVerifyRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   288: istore_3
    //   289: iload_3
    //   290: ifeq -> 332
    //   293: aload_0
    //   294: getfield Q : Ljava/util/HashMap;
    //   297: astore #7
    //   299: aload_0
    //   300: getfield U : [I
    //   303: astore #6
    //   305: aload #6
    //   307: bipush #39
    //   309: iaload
    //   310: iconst_1
    //   311: isub
    //   312: istore #4
    //   314: aload #6
    //   316: bipush #39
    //   318: iload #4
    //   320: iastore
    //   321: aload #7
    //   323: iload #4
    //   325: invokestatic valueOf : (I)Ljava/lang/String;
    //   328: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   331: pop
    //   332: iload_3
    //   333: istore #4
    //   335: bipush #-2
    //   337: iload_3
    //   338: if_icmpne -> 17
    //   341: bipush #39
    //   343: aload_1
    //   344: aload_2
    //   345: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   348: istore #4
    //   350: goto -> 17
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual printStackTrace : ()V
    //   358: new android/os/RemoteException
    //   361: astore_1
    //   362: aload_1
    //   363: invokespecial <init> : ()V
    //   366: aload_1
    //   367: athrow
    //   368: astore_1
    //   369: aload_0
    //   370: monitorexit
    //   371: aload_1
    //   372: athrow
    //   373: bipush #39
    //   375: aload_1
    //   376: aload_2
    //   377: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   380: istore #4
    //   382: goto -> 17
    //   385: iconst_m1
    //   386: istore #4
    //   388: goto -> 17
    // Exception table:
    //   from	to	target	type
    //   25	35	368	finally
    //   38	81	368	finally
    //   86	117	368	finally
    //   117	148	368	finally
    //   148	167	368	finally
    //   167	173	368	finally
    //   177	195	368	finally
    //   195	214	368	finally
    //   214	233	368	finally
    //   233	250	353	java/lang/Exception
    //   233	250	368	finally
    //   266	289	353	java/lang/Exception
    //   266	289	368	finally
    //   293	305	368	finally
    //   321	332	368	finally
    //   341	350	368	finally
    //   354	368	368	finally
    //   373	382	368	finally
  }
  
  public int openChannel(OpenChannelRequestParams paramOpenChannelRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_1
    //   9: ifnull -> 19
    //   12: aload_2
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getAppAID : ()Ljava/lang/String;
    //   28: astore #5
    //   30: iload_3
    //   31: istore #4
    //   33: aload #5
    //   35: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   38: ifne -> 19
    //   41: aload_0
    //   42: invokespecial c : ()Z
    //   45: ifne -> 55
    //   48: bipush #-8
    //   50: istore #4
    //   52: goto -> 19
    //   55: aload_0
    //   56: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   59: ifnull -> 318
    //   62: aload_0
    //   63: getfield c : Landroid/content/Context;
    //   66: invokevirtual getPackageName : ()Ljava/lang/String;
    //   69: invokestatic a : (Ljava/lang/String;)Z
    //   72: ifeq -> 306
    //   75: aload_0
    //   76: aload #5
    //   78: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #5
    //   83: new com/unionpay/tsmservice/request/OpenChannelRequestParams
    //   86: astore #6
    //   88: aload #6
    //   90: invokespecial <init> : ()V
    //   93: aload #6
    //   95: aload #5
    //   97: invokevirtual setAppAID : (Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual getReserve : ()Ljava/lang/String;
    //   104: astore #7
    //   106: aload #7
    //   108: astore #5
    //   110: aload_0
    //   111: getfield h : Z
    //   114: ifeq -> 128
    //   117: aload_0
    //   118: aload #7
    //   120: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   126: astore #5
    //   128: aload #5
    //   130: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   133: ifne -> 147
    //   136: aload #6
    //   138: aload_0
    //   139: aload #5
    //   141: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual setReserve : (Ljava/lang/String;)V
    //   147: aload_0
    //   148: getfield w : Ljava/util/HashMap;
    //   151: aload_0
    //   152: getfield U : [I
    //   155: bipush #20
    //   157: iaload
    //   158: invokestatic valueOf : (I)Ljava/lang/String;
    //   161: aload_2
    //   162: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload_0
    //   167: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   170: astore #5
    //   172: new com/unionpay/tsmservice/UPTsmAddon$b
    //   175: astore #7
    //   177: aload_0
    //   178: getfield U : [I
    //   181: astore #8
    //   183: aload #8
    //   185: bipush #20
    //   187: iaload
    //   188: istore #4
    //   190: aload #8
    //   192: bipush #20
    //   194: iload #4
    //   196: iconst_1
    //   197: iadd
    //   198: iastore
    //   199: aload #7
    //   201: aload_0
    //   202: bipush #20
    //   204: iload #4
    //   206: iconst_0
    //   207: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   210: aload #5
    //   212: aload #6
    //   214: aload #7
    //   216: invokeinterface openChannel : (Lcom/unionpay/tsmservice/request/OpenChannelRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   221: istore_3
    //   222: iload_3
    //   223: ifeq -> 265
    //   226: aload_0
    //   227: getfield w : Ljava/util/HashMap;
    //   230: astore #5
    //   232: aload_0
    //   233: getfield U : [I
    //   236: astore #7
    //   238: aload #7
    //   240: bipush #20
    //   242: iaload
    //   243: iconst_1
    //   244: isub
    //   245: istore #4
    //   247: aload #7
    //   249: bipush #20
    //   251: iload #4
    //   253: iastore
    //   254: aload #5
    //   256: iload #4
    //   258: invokestatic valueOf : (I)Ljava/lang/String;
    //   261: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: iload_3
    //   266: istore #4
    //   268: bipush #-2
    //   270: iload_3
    //   271: if_icmpne -> 19
    //   274: bipush #20
    //   276: aload_1
    //   277: aload_2
    //   278: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   281: istore #4
    //   283: goto -> 19
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual printStackTrace : ()V
    //   291: new android/os/RemoteException
    //   294: astore_1
    //   295: aload_1
    //   296: invokespecial <init> : ()V
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    //   306: bipush #20
    //   308: aload_1
    //   309: aload_2
    //   310: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   313: istore #4
    //   315: goto -> 19
    //   318: iconst_m1
    //   319: istore #4
    //   321: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	30	301	finally
    //   33	48	301	finally
    //   55	106	301	finally
    //   110	128	301	finally
    //   128	147	301	finally
    //   147	166	301	finally
    //   166	183	286	java/lang/Exception
    //   166	183	301	finally
    //   199	222	286	java/lang/Exception
    //   199	222	301	finally
    //   226	238	301	finally
    //   254	265	301	finally
    //   274	283	301	finally
    //   287	301	301	finally
    //   306	315	301	finally
  }
  
  public int preDownload(PreDownloadRequestParams paramPreDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore #4
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_2
    //   7: ifnonnull -> 19
    //   10: bipush #-3
    //   12: istore #5
    //   14: aload_0
    //   15: monitorexit
    //   16: iload #5
    //   18: ireturn
    //   19: iload #4
    //   21: istore #5
    //   23: aload_0
    //   24: ldc_w '01.00.26'
    //   27: invokespecial d : (Ljava/lang/String;)Z
    //   30: ifeq -> 14
    //   33: iload #4
    //   35: istore #5
    //   37: aload_0
    //   38: invokespecial c : ()Z
    //   41: ifeq -> 14
    //   44: aload_0
    //   45: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   48: ifnull -> 357
    //   51: aload_0
    //   52: getfield c : Landroid/content/Context;
    //   55: invokevirtual getPackageName : ()Ljava/lang/String;
    //   58: invokestatic a : (Ljava/lang/String;)Z
    //   61: ifeq -> 344
    //   64: new com/unionpay/tsmservice/request/PreDownloadRequestParams
    //   67: astore #6
    //   69: aload #6
    //   71: invokespecial <init> : ()V
    //   74: ldc ''
    //   76: astore #7
    //   78: aload_1
    //   79: ifnull -> 138
    //   82: aload_1
    //   83: invokevirtual getReserve : ()Ljava/lang/String;
    //   86: astore #8
    //   88: aload_1
    //   89: invokevirtual getParams : ()Landroid/os/Bundle;
    //   92: astore #9
    //   94: aload #8
    //   96: astore #7
    //   98: aload #9
    //   100: ifnull -> 138
    //   103: new android/os/Bundle
    //   106: astore #7
    //   108: aload #7
    //   110: invokespecial <init> : ()V
    //   113: aload #7
    //   115: ldc_w 'encryptData'
    //   118: aload_0
    //   119: aload #9
    //   121: invokespecial a : (Landroid/os/Bundle;)Ljava/lang/String;
    //   124: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload #6
    //   129: aload #7
    //   131: invokevirtual setParams : (Landroid/os/Bundle;)V
    //   134: aload #8
    //   136: astore #7
    //   138: aload #7
    //   140: astore #8
    //   142: aload_0
    //   143: getfield h : Z
    //   146: ifeq -> 160
    //   149: aload_0
    //   150: aload #7
    //   152: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   155: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   158: astore #8
    //   160: aload #8
    //   162: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   165: ifne -> 179
    //   168: aload #6
    //   170: aload_0
    //   171: aload #8
    //   173: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   176: invokevirtual setReserve : (Ljava/lang/String;)V
    //   179: aload_0
    //   180: getfield R : Ljava/util/HashMap;
    //   183: aload_0
    //   184: getfield U : [I
    //   187: bipush #40
    //   189: iaload
    //   190: invokestatic valueOf : (I)Ljava/lang/String;
    //   193: aload_2
    //   194: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: aload_0
    //   199: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   202: astore #8
    //   204: new com/unionpay/tsmservice/UPTsmAddon$b
    //   207: astore #7
    //   209: aload_0
    //   210: getfield U : [I
    //   213: astore #9
    //   215: aload #9
    //   217: bipush #40
    //   219: iaload
    //   220: istore #5
    //   222: aload #9
    //   224: bipush #40
    //   226: iload #5
    //   228: iconst_1
    //   229: iadd
    //   230: iastore
    //   231: aload #7
    //   233: aload_0
    //   234: bipush #40
    //   236: iload #5
    //   238: iconst_0
    //   239: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   242: aload #8
    //   244: aload #6
    //   246: aload #7
    //   248: aload_3
    //   249: invokeinterface preDownload : (Lcom/unionpay/tsmservice/request/PreDownloadRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   254: istore #4
    //   256: iload #4
    //   258: ifeq -> 300
    //   261: aload_0
    //   262: getfield R : Ljava/util/HashMap;
    //   265: astore #7
    //   267: aload_0
    //   268: getfield U : [I
    //   271: astore #8
    //   273: aload #8
    //   275: bipush #40
    //   277: iaload
    //   278: iconst_1
    //   279: isub
    //   280: istore #5
    //   282: aload #8
    //   284: bipush #40
    //   286: iload #5
    //   288: iastore
    //   289: aload #7
    //   291: iload #5
    //   293: invokestatic valueOf : (I)Ljava/lang/String;
    //   296: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   299: pop
    //   300: iload #4
    //   302: istore #5
    //   304: bipush #-2
    //   306: iload #4
    //   308: if_icmpne -> 14
    //   311: bipush #40
    //   313: aload_1
    //   314: aload_2
    //   315: aload_3
    //   316: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   319: istore #5
    //   321: goto -> 14
    //   324: astore_1
    //   325: aload_1
    //   326: invokevirtual printStackTrace : ()V
    //   329: new android/os/RemoteException
    //   332: astore_1
    //   333: aload_1
    //   334: invokespecial <init> : ()V
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: aload_0
    //   341: monitorexit
    //   342: aload_1
    //   343: athrow
    //   344: bipush #40
    //   346: aload_1
    //   347: aload_2
    //   348: aload_3
    //   349: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;Lcom/unionpay/tsmservice/ITsmProgressCallback;)I
    //   352: istore #5
    //   354: goto -> 14
    //   357: iconst_m1
    //   358: istore #5
    //   360: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   23	33	339	finally
    //   37	74	339	finally
    //   82	94	339	finally
    //   103	134	339	finally
    //   142	160	339	finally
    //   160	179	339	finally
    //   179	198	339	finally
    //   198	215	324	java/lang/Exception
    //   198	215	339	finally
    //   231	256	324	java/lang/Exception
    //   231	256	339	finally
    //   261	273	339	finally
    //   289	300	339	finally
    //   311	321	339	finally
    //   325	339	339	finally
    //   344	354	339	finally
  }
  
  public int queryVendorPayStatus(QueryVendorPayStatusRequestParams paramQueryVendorPayStatusRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-8
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ifnonnull -> 18
    //   9: bipush #-3
    //   11: istore #4
    //   13: aload_0
    //   14: monitorexit
    //   15: iload #4
    //   17: ireturn
    //   18: iload_3
    //   19: istore #4
    //   21: aload_0
    //   22: ldc_w '01.00.27'
    //   25: invokespecial d : (Ljava/lang/String;)Z
    //   28: ifeq -> 13
    //   31: iload_3
    //   32: istore #4
    //   34: aload_0
    //   35: invokespecial c : ()Z
    //   38: ifeq -> 13
    //   41: aload_0
    //   42: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   45: ifnull -> 297
    //   48: aload_0
    //   49: getfield c : Landroid/content/Context;
    //   52: invokevirtual getPackageName : ()Ljava/lang/String;
    //   55: invokestatic a : (Ljava/lang/String;)Z
    //   58: ifeq -> 285
    //   61: new com/unionpay/tsmservice/request/QueryVendorPayStatusRequestParams
    //   64: astore #5
    //   66: aload #5
    //   68: invokespecial <init> : ()V
    //   71: ldc ''
    //   73: astore #6
    //   75: aload_1
    //   76: ifnull -> 85
    //   79: aload_1
    //   80: invokevirtual getReserve : ()Ljava/lang/String;
    //   83: astore #6
    //   85: aload #6
    //   87: astore #7
    //   89: aload_0
    //   90: getfield h : Z
    //   93: ifeq -> 107
    //   96: aload_0
    //   97: aload #6
    //   99: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   102: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   105: astore #7
    //   107: aload #7
    //   109: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   112: ifne -> 126
    //   115: aload #5
    //   117: aload_0
    //   118: aload #7
    //   120: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual setReserve : (Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield S : Ljava/util/HashMap;
    //   130: aload_0
    //   131: getfield U : [I
    //   134: bipush #41
    //   136: iaload
    //   137: invokestatic valueOf : (I)Ljava/lang/String;
    //   140: aload_2
    //   141: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload_0
    //   146: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   149: astore #8
    //   151: new com/unionpay/tsmservice/UPTsmAddon$b
    //   154: astore #7
    //   156: aload_0
    //   157: getfield U : [I
    //   160: astore #6
    //   162: aload #6
    //   164: bipush #41
    //   166: iaload
    //   167: istore #4
    //   169: aload #6
    //   171: bipush #41
    //   173: iload #4
    //   175: iconst_1
    //   176: iadd
    //   177: iastore
    //   178: aload #7
    //   180: aload_0
    //   181: bipush #41
    //   183: iload #4
    //   185: iconst_0
    //   186: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   189: aload #8
    //   191: aload #5
    //   193: aload #7
    //   195: invokeinterface queryVendorPayStatus : (Lcom/unionpay/tsmservice/request/QueryVendorPayStatusRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   200: istore_3
    //   201: iload_3
    //   202: ifeq -> 244
    //   205: aload_0
    //   206: getfield S : Ljava/util/HashMap;
    //   209: astore #6
    //   211: aload_0
    //   212: getfield U : [I
    //   215: astore #7
    //   217: aload #7
    //   219: bipush #41
    //   221: iaload
    //   222: iconst_1
    //   223: isub
    //   224: istore #4
    //   226: aload #7
    //   228: bipush #41
    //   230: iload #4
    //   232: iastore
    //   233: aload #6
    //   235: iload #4
    //   237: invokestatic valueOf : (I)Ljava/lang/String;
    //   240: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: iload_3
    //   245: istore #4
    //   247: bipush #-2
    //   249: iload_3
    //   250: if_icmpne -> 13
    //   253: bipush #41
    //   255: aload_1
    //   256: aload_2
    //   257: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   260: istore #4
    //   262: goto -> 13
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual printStackTrace : ()V
    //   270: new android/os/RemoteException
    //   273: astore_1
    //   274: aload_1
    //   275: invokespecial <init> : ()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: bipush #41
    //   287: aload_1
    //   288: aload_2
    //   289: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   292: istore #4
    //   294: goto -> 13
    //   297: iconst_m1
    //   298: istore #4
    //   300: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   21	31	280	finally
    //   34	71	280	finally
    //   79	85	280	finally
    //   89	107	280	finally
    //   107	126	280	finally
    //   126	145	280	finally
    //   145	162	265	java/lang/Exception
    //   145	162	280	finally
    //   178	201	265	java/lang/Exception
    //   178	201	280	finally
    //   205	217	280	finally
    //   233	244	280	finally
    //   253	262	280	finally
    //   266	280	280	finally
    //   285	294	280	finally
  }
  
  public void removeConnectionListener(UPTsmConnectionListener paramUPTsmConnectionListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 14
    //   6: getstatic com/unionpay/tsmservice/UPTsmAddon.b : Ljava/util/ArrayList;
    //   9: aload_1
    //   10: invokevirtual remove : (Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   6	14	17	finally
  }
  
  public int sendApdu(SendApduRequestParams paramSendApduRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_2
    //   7: ifnonnull -> 17
    //   10: bipush #-3
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial c : ()Z
    //   21: ifne -> 30
    //   24: bipush #-8
    //   26: istore_3
    //   27: goto -> 13
    //   30: aload_0
    //   31: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   34: ifnull -> 323
    //   37: aload_0
    //   38: getfield c : Landroid/content/Context;
    //   41: invokevirtual getPackageName : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: ifeq -> 312
    //   50: new com/unionpay/tsmservice/request/SendApduRequestParams
    //   53: astore #4
    //   55: aload #4
    //   57: invokespecial <init> : ()V
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getChannel : ()Ljava/lang/String;
    //   70: astore #6
    //   72: aload_1
    //   73: invokevirtual getHexApdu : ()Ljava/lang/String;
    //   76: astore #7
    //   78: aload #5
    //   80: astore #8
    //   82: aload_0
    //   83: getfield h : Z
    //   86: ifeq -> 100
    //   89: aload_0
    //   90: aload #5
    //   92: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   95: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   98: astore #8
    //   100: aload #8
    //   102: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   105: ifne -> 119
    //   108: aload #4
    //   110: aload_0
    //   111: aload #8
    //   113: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   116: invokevirtual setReserve : (Ljava/lang/String;)V
    //   119: aload #6
    //   121: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   124: ifne -> 138
    //   127: aload #4
    //   129: aload_0
    //   130: aload #6
    //   132: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual setChannel : (Ljava/lang/String;)V
    //   138: aload #7
    //   140: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   143: ifne -> 157
    //   146: aload #4
    //   148: aload_0
    //   149: aload #7
    //   151: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual setHexApdu : (Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield x : Ljava/util/HashMap;
    //   161: aload_0
    //   162: getfield U : [I
    //   165: bipush #22
    //   167: iaload
    //   168: invokestatic valueOf : (I)Ljava/lang/String;
    //   171: aload_2
    //   172: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload_0
    //   177: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   180: astore #8
    //   182: new com/unionpay/tsmservice/UPTsmAddon$b
    //   185: astore #7
    //   187: aload_0
    //   188: getfield U : [I
    //   191: astore #5
    //   193: aload #5
    //   195: bipush #22
    //   197: iaload
    //   198: istore_3
    //   199: aload #5
    //   201: bipush #22
    //   203: iload_3
    //   204: iconst_1
    //   205: iadd
    //   206: iastore
    //   207: aload #7
    //   209: aload_0
    //   210: bipush #22
    //   212: iload_3
    //   213: iconst_0
    //   214: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   217: aload #8
    //   219: aload #4
    //   221: aload #7
    //   223: invokeinterface sendApdu : (Lcom/unionpay/tsmservice/request/SendApduRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   228: istore #9
    //   230: iload #9
    //   232: ifeq -> 271
    //   235: aload_0
    //   236: getfield x : Ljava/util/HashMap;
    //   239: astore #8
    //   241: aload_0
    //   242: getfield U : [I
    //   245: astore #5
    //   247: aload #5
    //   249: bipush #22
    //   251: iaload
    //   252: iconst_1
    //   253: isub
    //   254: istore_3
    //   255: aload #5
    //   257: bipush #22
    //   259: iload_3
    //   260: iastore
    //   261: aload #8
    //   263: iload_3
    //   264: invokestatic valueOf : (I)Ljava/lang/String;
    //   267: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: iload #9
    //   273: istore_3
    //   274: bipush #-2
    //   276: iload #9
    //   278: if_icmpne -> 13
    //   281: bipush #22
    //   283: aload_1
    //   284: aload_2
    //   285: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   288: istore_3
    //   289: goto -> 13
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual printStackTrace : ()V
    //   297: new android/os/RemoteException
    //   300: astore_1
    //   301: aload_1
    //   302: invokespecial <init> : ()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: aload_0
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    //   312: bipush #22
    //   314: aload_1
    //   315: aload_2
    //   316: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   319: istore_3
    //   320: goto -> 13
    //   323: iconst_m1
    //   324: istore_3
    //   325: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   17	24	307	finally
    //   30	78	307	finally
    //   82	100	307	finally
    //   100	119	307	finally
    //   119	138	307	finally
    //   138	157	307	finally
    //   157	176	307	finally
    //   176	193	292	java/lang/Exception
    //   176	193	307	finally
    //   207	230	292	java/lang/Exception
    //   207	230	307	finally
    //   235	247	307	finally
    //   261	271	307	finally
    //   281	289	307	finally
    //   293	307	307	finally
    //   312	320	307	finally
  }
  
  public int setDefaultCard(SetDefaultCardRequestParams paramSetDefaultCardRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: bipush #-3
    //   2: istore_3
    //   3: aload_0
    //   4: monitorenter
    //   5: iload_3
    //   6: istore #4
    //   8: aload_1
    //   9: ifnull -> 19
    //   12: aload_2
    //   13: ifnonnull -> 24
    //   16: iload_3
    //   17: istore #4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload #4
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual getAppAID : ()Ljava/lang/String;
    //   28: astore #5
    //   30: iload_3
    //   31: istore #4
    //   33: aload #5
    //   35: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   38: ifne -> 19
    //   41: aload_0
    //   42: invokespecial c : ()Z
    //   45: ifne -> 55
    //   48: bipush #-8
    //   50: istore #4
    //   52: goto -> 19
    //   55: aload_0
    //   56: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   59: ifnull -> 264
    //   62: aload_0
    //   63: getfield c : Landroid/content/Context;
    //   66: invokevirtual getPackageName : ()Ljava/lang/String;
    //   69: invokestatic a : (Ljava/lang/String;)Z
    //   72: ifeq -> 252
    //   75: aload_0
    //   76: aload #5
    //   78: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #6
    //   83: new com/unionpay/tsmservice/request/SetDefaultCardRequestParams
    //   86: astore #5
    //   88: aload #5
    //   90: invokespecial <init> : ()V
    //   93: aload #5
    //   95: aload #6
    //   97: invokevirtual setAppAID : (Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual getReserve : ()Ljava/lang/String;
    //   104: astore #6
    //   106: aload #6
    //   108: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   111: ifne -> 125
    //   114: aload #5
    //   116: aload_0
    //   117: aload #6
    //   119: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   122: invokevirtual setReserve : (Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   129: astore #7
    //   131: new com/unionpay/tsmservice/UPTsmAddon$b
    //   134: astore #6
    //   136: aload #6
    //   138: aload_0
    //   139: bipush #14
    //   141: aload_0
    //   142: getfield U : [I
    //   145: bipush #14
    //   147: iaload
    //   148: iconst_0
    //   149: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   152: aload #7
    //   154: aload #5
    //   156: aload #6
    //   158: invokeinterface setDefaultCard : (Lcom/unionpay/tsmservice/request/SetDefaultCardRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   163: istore_3
    //   164: bipush #-2
    //   166: iload_3
    //   167: if_icmpne -> 202
    //   170: bipush #14
    //   172: aload_1
    //   173: aload_2
    //   174: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   177: istore #4
    //   179: goto -> 19
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual printStackTrace : ()V
    //   187: new android/os/RemoteException
    //   190: astore_1
    //   191: aload_1
    //   192: invokespecial <init> : ()V
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    //   202: iload_3
    //   203: istore #4
    //   205: iload_3
    //   206: ifne -> 19
    //   209: aload_0
    //   210: getfield E : Ljava/util/HashMap;
    //   213: astore #5
    //   215: aload_0
    //   216: getfield U : [I
    //   219: astore_1
    //   220: aload_1
    //   221: bipush #14
    //   223: iaload
    //   224: istore #4
    //   226: aload_1
    //   227: bipush #14
    //   229: iload #4
    //   231: iconst_1
    //   232: iadd
    //   233: iastore
    //   234: aload #5
    //   236: iload #4
    //   238: invokestatic valueOf : (I)Ljava/lang/String;
    //   241: aload_2
    //   242: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: iload_3
    //   247: istore #4
    //   249: goto -> 19
    //   252: bipush #14
    //   254: aload_1
    //   255: aload_2
    //   256: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   259: istore #4
    //   261: goto -> 19
    //   264: iconst_m1
    //   265: istore #4
    //   267: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   24	30	197	finally
    //   33	48	197	finally
    //   55	125	197	finally
    //   125	164	182	java/lang/Exception
    //   125	164	197	finally
    //   170	179	197	finally
    //   183	197	197	finally
    //   209	220	197	finally
    //   234	246	197	finally
    //   252	261	197	finally
  }
  
  public int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 13
    //   6: bipush #-3
    //   8: istore_2
    //   9: aload_0
    //   10: monitorexit
    //   11: iload_2
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial c : ()Z
    //   17: ifne -> 26
    //   20: bipush #-8
    //   22: istore_2
    //   23: goto -> 9
    //   26: aload_0
    //   27: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   30: ifnull -> 153
    //   33: aload_0
    //   34: getfield c : Landroid/content/Context;
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Z
    //   43: ifeq -> 142
    //   46: aload_1
    //   47: invokevirtual getReserve : ()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: astore #4
    //   54: aload_0
    //   55: getfield h : Z
    //   58: ifeq -> 71
    //   61: aload_0
    //   62: aload_3
    //   63: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   66: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   69: astore #4
    //   71: aload #4
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifne -> 89
    //   79: aload_1
    //   80: aload_0
    //   81: aload #4
    //   83: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   86: invokevirtual setReserve : (Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   93: aload_1
    //   94: invokeinterface setSafetyKeyboardBitmap : (Lcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;)I
    //   99: istore #5
    //   101: iload #5
    //   103: istore_2
    //   104: bipush #-2
    //   106: iload #5
    //   108: if_icmpne -> 9
    //   111: bipush #32
    //   113: aload_1
    //   114: aconst_null
    //   115: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   118: istore_2
    //   119: goto -> 9
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual printStackTrace : ()V
    //   127: new android/os/RemoteException
    //   130: astore_1
    //   131: aload_1
    //   132: invokespecial <init> : ()V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    //   142: bipush #32
    //   144: aload_1
    //   145: aconst_null
    //   146: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   149: istore_2
    //   150: goto -> 9
    //   153: iconst_m1
    //   154: istore_2
    //   155: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   13	20	137	finally
    //   26	51	137	finally
    //   54	71	137	finally
    //   71	89	137	finally
    //   89	101	122	java/lang/Exception
    //   89	101	137	finally
    //   111	119	137	finally
    //   123	137	137	finally
    //   142	150	137	finally
  }
  
  public int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams paramSetSamsungDefWalletRequestParams, ITsmCallback paramITsmCallback) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 13
    //   6: bipush #-3
    //   8: istore_3
    //   9: aload_0
    //   10: monitorexit
    //   11: iload_3
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial c : ()Z
    //   17: ifne -> 26
    //   20: bipush #-8
    //   22: istore_3
    //   23: goto -> 9
    //   26: aload_0
    //   27: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   30: ifnull -> 251
    //   33: aload_0
    //   34: getfield c : Landroid/content/Context;
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Z
    //   43: ifeq -> 240
    //   46: new com/unionpay/tsmservice/request/SetSamsungDefWalletRequestParams
    //   49: astore #4
    //   51: aload #4
    //   53: invokespecial <init> : ()V
    //   56: aload_1
    //   57: ifnull -> 85
    //   60: aload_1
    //   61: invokevirtual getReserve : ()Ljava/lang/String;
    //   64: astore #5
    //   66: aload #5
    //   68: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   71: ifne -> 85
    //   74: aload #4
    //   76: aload_0
    //   77: aload #5
    //   79: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual setReserve : (Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield K : Ljava/util/HashMap;
    //   89: aload_0
    //   90: getfield U : [I
    //   93: bipush #30
    //   95: iaload
    //   96: invokestatic valueOf : (I)Ljava/lang/String;
    //   99: aload_2
    //   100: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_0
    //   105: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   108: astore #6
    //   110: new com/unionpay/tsmservice/UPTsmAddon$b
    //   113: astore #7
    //   115: aload_0
    //   116: getfield U : [I
    //   119: astore #5
    //   121: aload #5
    //   123: bipush #30
    //   125: iaload
    //   126: istore_3
    //   127: aload #5
    //   129: bipush #30
    //   131: iload_3
    //   132: iconst_1
    //   133: iadd
    //   134: iastore
    //   135: aload #7
    //   137: aload_0
    //   138: bipush #30
    //   140: iload_3
    //   141: iconst_0
    //   142: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;IIB)V
    //   145: aload #6
    //   147: aload #4
    //   149: aload #7
    //   151: invokeinterface setSamsungDefaultWallet : (Lcom/unionpay/tsmservice/request/SetSamsungDefWalletRequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   156: istore #8
    //   158: iload #8
    //   160: ifeq -> 199
    //   163: aload_0
    //   164: getfield K : Ljava/util/HashMap;
    //   167: astore #5
    //   169: aload_0
    //   170: getfield U : [I
    //   173: astore #4
    //   175: aload #4
    //   177: bipush #30
    //   179: iaload
    //   180: iconst_1
    //   181: isub
    //   182: istore_3
    //   183: aload #4
    //   185: bipush #30
    //   187: iload_3
    //   188: iastore
    //   189: aload #5
    //   191: iload_3
    //   192: invokestatic valueOf : (I)Ljava/lang/String;
    //   195: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: iload #8
    //   201: istore_3
    //   202: bipush #-2
    //   204: iload #8
    //   206: if_icmpne -> 9
    //   209: bipush #30
    //   211: aload_1
    //   212: aload_2
    //   213: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   216: istore_3
    //   217: goto -> 9
    //   220: astore_1
    //   221: aload_1
    //   222: invokevirtual printStackTrace : ()V
    //   225: new android/os/RemoteException
    //   228: astore_1
    //   229: aload_1
    //   230: invokespecial <init> : ()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload_1
    //   239: athrow
    //   240: bipush #30
    //   242: aload_1
    //   243: aload_2
    //   244: invokestatic a : (ILcom/unionpay/tsmservice/request/RequestParams;Lcom/unionpay/tsmservice/ITsmCallback;)I
    //   247: istore_3
    //   248: goto -> 9
    //   251: iconst_m1
    //   252: istore_3
    //   253: goto -> 9
    // Exception table:
    //   from	to	target	type
    //   13	20	235	finally
    //   26	56	235	finally
    //   60	85	235	finally
    //   85	104	235	finally
    //   104	121	220	java/lang/Exception
    //   104	121	235	finally
    //   135	158	220	java/lang/Exception
    //   135	158	235	finally
    //   163	175	235	finally
    //   189	199	235	finally
    //   209	217	235	finally
    //   221	235	235	finally
    //   240	248	235	finally
  }
  
  public int showSafetyKeyboard(SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams, int paramInt, OnSafetyKeyboardCallback paramOnSafetyKeyboardCallback, Context paramContext) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 20
    //   6: iload_2
    //   7: sipush #2000
    //   10: if_icmplt -> 20
    //   13: iload_2
    //   14: sipush #2001
    //   17: if_icmple -> 29
    //   20: bipush #-3
    //   22: istore #5
    //   24: aload_0
    //   25: monitorexit
    //   26: iload #5
    //   28: ireturn
    //   29: aload_0
    //   30: invokespecial c : ()Z
    //   33: ifne -> 43
    //   36: bipush #-8
    //   38: istore #5
    //   40: goto -> 24
    //   43: aload_0
    //   44: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   47: ifnull -> 260
    //   50: aload_0
    //   51: getfield c : Landroid/content/Context;
    //   54: invokevirtual getPackageName : ()Ljava/lang/String;
    //   57: invokestatic a : (Ljava/lang/String;)Z
    //   60: ifeq -> 244
    //   63: aload_0
    //   64: getfield T : Ljava/util/HashMap;
    //   67: astore #6
    //   69: aload_0
    //   70: getfield c : Landroid/content/Context;
    //   73: invokevirtual getPackageName : ()Ljava/lang/String;
    //   76: astore #7
    //   78: new com/unionpay/tsmservice/a
    //   81: astore #8
    //   83: aload #8
    //   85: aload #4
    //   87: invokespecial <init> : (Landroid/content/Context;)V
    //   90: aload #6
    //   92: aload #7
    //   94: aload #8
    //   96: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: aload_1
    //   101: invokevirtual getReserve : ()Ljava/lang/String;
    //   104: astore #6
    //   106: aload #6
    //   108: astore #7
    //   110: aload_0
    //   111: getfield h : Z
    //   114: ifeq -> 128
    //   117: aload_0
    //   118: aload #6
    //   120: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokespecial g : (Ljava/lang/String;)Ljava/lang/String;
    //   126: astore #7
    //   128: aload #7
    //   130: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   133: ifne -> 146
    //   136: aload_1
    //   137: aload_0
    //   138: aload #7
    //   140: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   143: invokevirtual setReserve : (Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield e : Lcom/unionpay/tsmservice/ITsmService;
    //   150: astore #7
    //   152: new com/unionpay/tsmservice/UPTsmAddon$a
    //   155: astore #6
    //   157: aload #6
    //   159: aload_0
    //   160: invokespecial <init> : (Lcom/unionpay/tsmservice/UPTsmAddon;)V
    //   163: aload #7
    //   165: aload_1
    //   166: iload_2
    //   167: aload_3
    //   168: aload #6
    //   170: invokeinterface showSafetyKeyboard : (Lcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Lcom/unionpay/tsmservice/ITsmActivityCallback;)I
    //   175: istore #9
    //   177: iload #9
    //   179: ifeq -> 197
    //   182: aload_0
    //   183: getfield T : Ljava/util/HashMap;
    //   186: aload_0
    //   187: getfield c : Landroid/content/Context;
    //   190: invokevirtual getPackageName : ()Ljava/lang/String;
    //   193: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: iload #9
    //   199: istore #5
    //   201: bipush #-2
    //   203: iload #9
    //   205: if_icmpne -> 24
    //   208: sipush #1000
    //   211: aload_1
    //   212: iload_2
    //   213: aload_3
    //   214: aload #4
    //   216: invokestatic a : (ILcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   219: istore #5
    //   221: goto -> 24
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual printStackTrace : ()V
    //   229: new android/os/RemoteException
    //   232: astore_1
    //   233: aload_1
    //   234: invokespecial <init> : ()V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    //   244: sipush #1000
    //   247: aload_1
    //   248: iload_2
    //   249: aload_3
    //   250: aload #4
    //   252: invokestatic a : (ILcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   255: istore #5
    //   257: goto -> 24
    //   260: iconst_m1
    //   261: istore #5
    //   263: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   29	36	239	finally
    //   43	106	239	finally
    //   110	128	239	finally
    //   128	146	239	finally
    //   146	177	224	java/lang/Exception
    //   146	177	239	finally
    //   182	197	239	finally
    //   208	221	239	finally
    //   225	239	239	finally
    //   244	257	239	finally
  }
  
  public void unbind() {
    if (this.d != null && this.f) {
      this.c.unbindService(this.d);
      this.f = false;
    } 
  }
  
  static {
    try {
      System.loadLibrary("uptsmaddon");
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
    } 
  }
  
  public static interface UPTsmConnectionListener {
    void onTsmConnected();
    
    void onTsmDisconnected();
  }
  
  public final class a extends ITsmActivityCallback.Stub {
    private int b = 1000;
    
    public a(UPTsmAddon this$0) {}
    
    public final void startActivity(String param1String1, String param1String2, int param1Int, Bundle param1Bundle) throws RemoteException {
      UPTsmAddon.a((ITsmActivityCallback)UPTsmAddon.b(this.a, this.b).get(UPTsmAddon.e(this.a)), param1String1, param1String2, param1Int, param1Bundle);
      UPTsmAddon.b(this.a, this.b).remove(UPTsmAddon.e(this.a));
    }
  }
  
  private final class b extends ITsmCallback.Stub {
    private int b;
    
    private int c;
    
    private b(UPTsmAddon this$0, int param1Int1, int param1Int2) {
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public final void onError(String param1String1, String param1String2) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("errorCode", param1String1);
      bundle.putString("errorDesc", param1String2);
      UPTsmAddon.a((ITsmCallback)UPTsmAddon.a(this.a, this.b).get(String.valueOf(this.c)), bundle);
      UPTsmAddon.a(this.a, this.b).remove(String.valueOf(this.c));
      if (UPTsmAddon.a(this.a, this.b).isEmpty())
        UPTsmAddon.d(this.a)[this.b] = 0; 
    }
    
    public final void onResult(Bundle param1Bundle) throws RemoteException {
      new Bundle();
      int i = this.b;
      Bundle bundle1 = new Bundle();
      Parcel parcel = Parcel.obtain();
      String str1 = param1Bundle.getString("errorCode");
      String str2 = param1Bundle.getString("result");
      bundle1.putString("errorCode", str1);
      if (!TextUtils.isEmpty(str2)) {
        byte[] arrayOfByte = Base64.decode(UPTsmAddon.a(this.a, str2), 0);
        if (arrayOfByte != null && arrayOfByte.length != 0) {
          parcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
          parcel.setDataPosition(0);
        } 
        if (parcel.dataSize() == 0) {
          bundle1.putString("errorCode", "010035");
          Bundle bundle = bundle1;
        } 
      } 
      Bundle bundle2 = param1Bundle;
      switch (i) {
        case 5:
          parcel.recycle();
          UPTsmAddon.a((ITsmCallback)UPTsmAddon.a(this.a, this.b).get(String.valueOf(this.c)), bundle2);
          UPTsmAddon.a(this.a, this.b).remove(String.valueOf(this.c));
          if (UPTsmAddon.a(this.a, this.b).isEmpty())
            UPTsmAddon.d(this.a)[this.b] = 0; 
          return;
        default:
          bundle2 = param1Bundle;
        case 0:
          bundle1.putParcelable("result", parcel.readParcelable(InitResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 3:
          bundle1.putParcelable("result", parcel.readParcelable(GetSeAppListResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 12:
          bundle1.putParcelable("result", parcel.readParcelable(GetSeIdResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 23:
          bundle1.putParcelable("result", parcel.readParcelable(EncryptDataResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 20:
          bundle1.putParcelable("result", parcel.readParcelable(OpenChannelResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 22:
          bundle1.putParcelable("result", parcel.readParcelable(SendApduResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 28:
          bundle1.putParcelable("result", parcel.readParcelable(GetCardInfoBySpayResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 29:
          bundle1.putParcelable("result", parcel.readParcelable(CheckSSamsungPayResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 31:
          bundle1.putParcelable("result", parcel.readParcelable(GetEncryptDataResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 36:
        case 41:
          bundle1.putParcelable("result", parcel.readParcelable(VendorPayStatusResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 38:
          bundle1.putParcelable("result", parcel.readParcelable(AddCardResult.class.getClassLoader()));
          bundle2 = bundle1;
        case 39:
          break;
      } 
      bundle1.putParcelable("result", parcel.readParcelable(OnlinePaymentVerifyResult.class.getClassLoader()));
      bundle2 = bundle1;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\UPTsmAddon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
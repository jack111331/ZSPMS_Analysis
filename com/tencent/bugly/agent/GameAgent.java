package com.tencent.bugly.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class GameAgent {
  private static final String CLASS_COCOS_ACTIVITY = "org.cocos2dx.lib.Cocos2dxActivity";
  
  private static final String CLASS_UNITY_PLAYER = "com.unity3d.player.UnityPlayer";
  
  private static final String CRASH_REPORT_CLASS_SUFFIX = "crashreport.CrashReport";
  
  public static final int GAME_TYPE_COCOS = 1;
  
  public static final int GAME_TYPE_UNITY = 2;
  
  public static final int GAME_TYPE_UNKNOWN = 0;
  
  private static final int LOG_LEVEL_DEBUG = 1;
  
  private static final int LOG_LEVEL_ERROR = 4;
  
  private static final int LOG_LEVEL_INFO = 2;
  
  private static final int LOG_LEVEL_VERBOSE = 0;
  
  private static final int LOG_LEVEL_WARN = 3;
  
  private static final String LOG_TAG = "CrashReport-GameAgent";
  
  private static final String OLD_STRATEGY_CLASS_SUFFIX = "crashreport.CrashReport$UserStrategy";
  
  private static final String STRATEGY_CLASS_SUFFIX = "BuglyStrategy";
  
  private static final int TYPE_COCOS2DX_JS_CRASH = 5;
  
  private static final int TYPE_COCOS2DX_LUA_CRASH = 6;
  
  private static final int TYPE_U3D_CRASH = 4;
  
  private static final String VERSION = "3.2";
  
  private static boolean hasGuessed = false;
  
  private static WeakReference<Activity> sActivity;
  
  private static String sAppChannel;
  
  private static String sAppVersion;
  
  private static WeakReference<Context> sContext;
  
  private static int sGameType = 0;
  
  private static Handler sHandler;
  
  private static boolean sIsDebug = false;
  
  private static String sUserId;
  
  private static String sdkPackageName = "com.tencent.bugly";
  
  private static String convertToCanonicalName(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    if (sdkPackageName == null)
      sdkPackageName = "com.tencent.bugly"; 
    stringBuilder.append(sdkPackageName);
    stringBuilder.append(".");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private static void delayExit(long paramLong) {
    paramLong = Math.max(0L, paramLong);
    if (sHandler != null) {
      sHandler.postDelayed(new Runnable() {
            public void run() {
              GameAgent.exitApplication();
            }
          },  paramLong);
    } else {
      try {
        Thread.sleep(paramLong);
        exitApplication();
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
  }
  
  private static void exitApplication() {
    int i = Process.myPid();
    printLog(3, String.format(Locale.US, "Exit application by kill process[%d]", new Object[] { Integer.valueOf(i) }));
    Process.killProcess(i);
  }
  
  private static Activity getActivity() {
    Activity activity;
    if (sActivity == null || sActivity.get() == null) {
      switch (sGameType) {
        default:
          Log.w("CrashReport-GameAgent", "Game type has not been set.");
          activity = guessActivity();
          break;
        case 2:
          activity = getUnityActivity();
          break;
        case 1:
          activity = getCocosActivity();
          break;
      } 
      if (activity != null)
        sActivity = new WeakReference<Activity>(activity); 
    } 
    if (sActivity != null) {
      activity = sActivity.get();
    } else {
      activity = null;
    } 
    return activity;
  }
  
  private static Context getApplicationContext() {
    Context context;
    if (sContext == null || sContext.get() == null) {
      context = (Context)getActivity();
      if (context != null)
        sContext = new WeakReference<Context>(context.getApplicationContext()); 
    } 
    if (sContext != null) {
      context = sContext.get();
    } else {
      context = null;
    } 
    return context;
  }
  
  public static Activity getCocosActivity() {
    try {
      Object object = Reflection.invokeStaticMethod("org.cocos2dx.lib.Cocos2dxActivity", "getContext", null, new Class[0]);
      if (object != null && object instanceof Activity)
        return (Activity)object; 
    } catch (Exception exception) {
      Log.w("CrashReport-GameAgent", "Failed to get activity of Cocos.");
    } 
    return null;
  }
  
  public static Activity getUnityActivity() {
    try {
      Object object = Reflection.getStaticField("com.unity3d.player.UnityPlayer", "currentActivity", null);
      if (object != null && object instanceof Activity)
        return (Activity)object; 
    } catch (Exception exception) {
      Log.w("CrashReport-GameAgent", "Failed to get activity of Unity.");
    } 
    return null;
  }
  
  public static String getVersion() {
    return "3.2";
  }
  
  private static Activity guessActivity() {
    boolean bool = hasGuessed;
    Activity activity1 = null;
    if (bool)
      return null; 
    hasGuessed = true;
    if (sGameType != 0)
      activity1 = getActivity(); 
    Activity activity2 = activity1;
    if (activity1 == null) {
      sGameType = 1;
      activity2 = getActivity();
    } 
    activity1 = activity2;
    if (activity2 == null) {
      sGameType = 2;
      activity1 = getActivity();
    } 
    if (activity1 == null)
      sGameType = 0; 
    return activity1;
  }
  
  private static void initCrashReport(final String appId, String paramString2, String paramString3, final String userId, long paramLong) {
    final Context context = getApplicationContext();
    if (context == null) {
      printLog(4, "Context is null. bugly initialize terminated.");
      return;
    } 
    if (TextUtils.isEmpty(appId)) {
      printLog(4, "Please input appid when initCrashReport.");
      return;
    } 
    sHandler = new Handler(Looper.getMainLooper());
    runTaskInUiThread(new Runnable() {
          public void run() {
            // Byte code:
            //   0: invokestatic access$400 : ()Z
            //   3: istore_1
            //   4: aload_0
            //   5: getfield val$strategy : Ljava/lang/Object;
            //   8: ifnull -> 135
            //   11: aconst_null
            //   12: astore_2
            //   13: ldc 'crashreport.CrashReport$UserStrategy'
            //   15: invokestatic access$500 : (Ljava/lang/String;)Ljava/lang/String;
            //   18: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
            //   21: astore_3
            //   22: aload_3
            //   23: astore_2
            //   24: goto -> 40
            //   27: astore_3
            //   28: aload_3
            //   29: invokevirtual printStackTrace : ()V
            //   32: goto -> 40
            //   35: astore_3
            //   36: aload_3
            //   37: invokevirtual printStackTrace : ()V
            //   40: aload_2
            //   41: ifnull -> 135
            //   44: ldc 'crashreport.CrashReport'
            //   46: invokestatic access$500 : (Ljava/lang/String;)Ljava/lang/String;
            //   49: astore #4
            //   51: aload_0
            //   52: getfield val$context : Landroid/content/Context;
            //   55: astore #5
            //   57: aload_0
            //   58: getfield val$appId : Ljava/lang/String;
            //   61: astore #6
            //   63: aload_0
            //   64: getfield val$strategy : Ljava/lang/Object;
            //   67: astore #7
            //   69: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
            //   72: astore_3
            //   73: aload #4
            //   75: ldc 'initCrashReport'
            //   77: iconst_4
            //   78: anewarray java/lang/Object
            //   81: dup
            //   82: iconst_0
            //   83: aload #5
            //   85: aastore
            //   86: dup
            //   87: iconst_1
            //   88: aload #6
            //   90: aastore
            //   91: dup
            //   92: iconst_2
            //   93: iload_1
            //   94: invokestatic valueOf : (Z)Ljava/lang/Boolean;
            //   97: aastore
            //   98: dup
            //   99: iconst_3
            //   100: aload #7
            //   102: aastore
            //   103: iconst_4
            //   104: anewarray java/lang/Class
            //   107: dup
            //   108: iconst_0
            //   109: ldc android/content/Context
            //   111: aastore
            //   112: dup
            //   113: iconst_1
            //   114: ldc java/lang/String
            //   116: aastore
            //   117: dup
            //   118: iconst_2
            //   119: aload_3
            //   120: aastore
            //   121: dup
            //   122: iconst_3
            //   123: aload_2
            //   124: aastore
            //   125: invokestatic access$100 : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
            //   128: pop
            //   129: iconst_1
            //   130: istore #8
            //   132: goto -> 138
            //   135: iconst_0
            //   136: istore #8
            //   138: iload #8
            //   140: ifne -> 211
            //   143: ldc 'crashreport.CrashReport'
            //   145: invokestatic access$500 : (Ljava/lang/String;)Ljava/lang/String;
            //   148: astore #5
            //   150: aload_0
            //   151: getfield val$context : Landroid/content/Context;
            //   154: astore_3
            //   155: aload_0
            //   156: getfield val$appId : Ljava/lang/String;
            //   159: astore #6
            //   161: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
            //   164: astore_2
            //   165: aload #5
            //   167: ldc 'initCrashReport'
            //   169: iconst_3
            //   170: anewarray java/lang/Object
            //   173: dup
            //   174: iconst_0
            //   175: aload_3
            //   176: aastore
            //   177: dup
            //   178: iconst_1
            //   179: aload #6
            //   181: aastore
            //   182: dup
            //   183: iconst_2
            //   184: iload_1
            //   185: invokestatic valueOf : (Z)Ljava/lang/Boolean;
            //   188: aastore
            //   189: iconst_3
            //   190: anewarray java/lang/Class
            //   193: dup
            //   194: iconst_0
            //   195: ldc android/content/Context
            //   197: aastore
            //   198: dup
            //   199: iconst_1
            //   200: ldc java/lang/String
            //   202: aastore
            //   203: dup
            //   204: iconst_2
            //   205: aload_2
            //   206: aastore
            //   207: invokestatic access$100 : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
            //   210: pop
            //   211: aload_0
            //   212: getfield val$userId : Ljava/lang/String;
            //   215: invokestatic setUserId : (Ljava/lang/String;)V
            //   218: return
            // Exception table:
            //   from	to	target	type
            //   13	22	35	java/lang/ClassNotFoundException
            //   13	22	27	java/lang/Exception
          }
        });
  }
  
  public static void initCrashReport(String paramString, boolean paramBoolean) {
    setLogEnable(paramBoolean);
    initCrashReport(paramString, sAppChannel, sAppVersion, sUserId, 0L);
  }
  
  private static Object newStrategy(Context paramContext, String paramString1, String paramString2, long paramLong) {
    if (paramContext == null || (TextUtils.isEmpty(paramString1) && TextUtils.isEmpty(paramString2)))
      return null; 
    Object object = Reflection.newInstance(convertToCanonicalName("crashreport.CrashReport$UserStrategy"), new Object[] { paramContext }, new Class[] { Context.class });
    if (object != null)
      try {
        Class<?> clazz = Class.forName(convertToCanonicalName("BuglyStrategy"));
        clazz.getDeclaredMethod("setAppChannel", new Class[] { String.class }).invoke(object, new Object[] { paramString1 });
        clazz.getDeclaredMethod("setAppVersion", new Class[] { String.class }).invoke(object, new Object[] { paramString2 });
        clazz.getDeclaredMethod("setAppReportDelay", new Class[] { long.class }).invoke(object, new Object[] { Long.valueOf(paramLong) });
        return object;
      } catch (NoSuchMethodException noSuchMethodException) {
        noSuchMethodException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException.printStackTrace();
      } catch (InvocationTargetException invocationTargetException) {
        invocationTargetException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return null;
  }
  
  private static void postCocosJsException(final int category, final String type, final String message, final String stack, final boolean autoExit) {
    runTaskInUiThread(new Runnable() {
          public void run() {
            String str1 = GameAgent.convertToCanonicalName("crashreport.inner.InnerApi");
            int i = category;
            String str2 = type;
            String str3 = message;
            String str4 = stack;
            Class<int> clazz = int.class;
            GameAgent.Reflection.invokeStaticMethod(str1, "postCocos2dxCrashAsync", new Object[] { Integer.valueOf(i), str2, str3, str4 }, new Class[] { clazz, String.class, String.class, String.class });
            if (autoExit)
              GameAgent.delayExit(3000L); 
          }
        });
  }
  
  private static void postCocosLuaException(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    // Byte code:
    //   0: aload_3
    //   1: astore #5
    //   3: aload_3
    //   4: astore #6
    //   6: aload_3
    //   7: ldc_w 'stack traceback'
    //   10: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   13: ifeq -> 41
    //   16: aload_3
    //   17: astore #6
    //   19: aload_3
    //   20: aload_3
    //   21: ldc_w '\\n'
    //   24: invokevirtual indexOf : (Ljava/lang/String;)I
    //   27: iconst_1
    //   28: iadd
    //   29: aload_3
    //   30: invokevirtual length : ()I
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: invokevirtual trim : ()Ljava/lang/String;
    //   39: astore #5
    //   41: aload #5
    //   43: astore #6
    //   45: aload #5
    //   47: ldc_w '\\n'
    //   50: invokevirtual indexOf : (Ljava/lang/String;)I
    //   53: istore #7
    //   55: aload #5
    //   57: astore_3
    //   58: iload #7
    //   60: ifle -> 82
    //   63: aload #5
    //   65: astore #6
    //   67: aload #5
    //   69: iload #7
    //   71: iconst_1
    //   72: iadd
    //   73: aload #5
    //   75: invokevirtual length : ()I
    //   78: invokevirtual substring : (II)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_3
    //   83: astore #6
    //   85: aload_3
    //   86: ldc_w '\\n'
    //   89: invokevirtual indexOf : (Ljava/lang/String;)I
    //   92: istore #7
    //   94: iload #7
    //   96: ifle -> 114
    //   99: aload_3
    //   100: astore #6
    //   102: aload_3
    //   103: iconst_0
    //   104: iload #7
    //   106: invokevirtual substring : (II)Ljava/lang/String;
    //   109: astore #8
    //   111: goto -> 117
    //   114: aload_3
    //   115: astore #8
    //   117: aload_3
    //   118: astore #6
    //   120: aload #8
    //   122: ldc_w ']:'
    //   125: invokevirtual indexOf : (Ljava/lang/String;)I
    //   128: istore #7
    //   130: aload_1
    //   131: ifnull -> 150
    //   134: aload_3
    //   135: astore #6
    //   137: aload_1
    //   138: astore #5
    //   140: aload_3
    //   141: astore #9
    //   143: aload_1
    //   144: invokevirtual length : ()I
    //   147: ifne -> 208
    //   150: iload #7
    //   152: iconst_m1
    //   153: if_icmpeq -> 177
    //   156: aload_3
    //   157: astore #6
    //   159: aload #8
    //   161: iconst_0
    //   162: iload #7
    //   164: iconst_1
    //   165: iadd
    //   166: invokevirtual substring : (II)Ljava/lang/String;
    //   169: astore #5
    //   171: aload_3
    //   172: astore #9
    //   174: goto -> 208
    //   177: aload_2
    //   178: astore #5
    //   180: aload_3
    //   181: astore #9
    //   183: goto -> 208
    //   186: astore_3
    //   187: aload_1
    //   188: ifnull -> 218
    //   191: aload_1
    //   192: astore #5
    //   194: aload #6
    //   196: astore #9
    //   198: aload_1
    //   199: invokevirtual length : ()I
    //   202: ifne -> 208
    //   205: goto -> 218
    //   208: aload #5
    //   210: astore_1
    //   211: aload #9
    //   213: astore #6
    //   215: goto -> 223
    //   218: aload_2
    //   219: astore_1
    //   220: goto -> 215
    //   223: new com/tencent/bugly/agent/GameAgent$11
    //   226: dup
    //   227: iload_0
    //   228: aload_1
    //   229: aload_2
    //   230: aload #6
    //   232: iload #4
    //   234: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   237: invokestatic runTaskInUiThread : (Ljava/lang/Runnable;)V
    //   240: return
    // Exception table:
    //   from	to	target	type
    //   6	16	186	java/lang/Throwable
    //   19	41	186	java/lang/Throwable
    //   45	55	186	java/lang/Throwable
    //   67	82	186	java/lang/Throwable
    //   85	94	186	java/lang/Throwable
    //   102	111	186	java/lang/Throwable
    //   120	130	186	java/lang/Throwable
    //   143	150	186	java/lang/Throwable
    //   159	171	186	java/lang/Throwable
  }
  
  public static void postException(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("The category of exception posted is unknown: ");
        stringBuilder.append(String.valueOf(paramInt));
        printLog(4, stringBuilder.toString());
        return;
      case 6:
        postCocosLuaException(paramInt, (String)stringBuilder, paramString2, paramString3, paramBoolean);
        return;
      case 5:
        postCocosJsException(paramInt, (String)stringBuilder, paramString2, paramString3, paramBoolean);
        return;
      case 4:
        break;
    } 
    postUnityException((String)stringBuilder, paramString2, paramString3, paramBoolean);
  }
  
  private static void postUnityException(final String type, final String message, final String stacks, final boolean autoExit) {
    runTaskInUiThread(new Runnable() {
          public void run() {
            GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postU3dCrashAsync", new Object[] { this.val$type, this.val$message, this.val$stacks }, new Class[] { String.class, String.class, String.class });
            if (autoExit)
              GameAgent.delayExit(3000L); 
          }
        });
  }
  
  private static void printLog(int paramInt, String paramString) {
    setLog(paramInt, "CrashReport-GameAgent", paramString);
  }
  
  public static void printLog(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (paramString.startsWith("<Log>")) {
      printLog(2, paramString);
    } else if (paramString.startsWith("<LogDebug>")) {
      printLog(1, paramString);
    } else if (paramString.startsWith("<LogInfo>")) {
      printLog(2, paramString);
    } else if (paramString.startsWith("<LogWarning>")) {
      printLog(3, paramString);
    } else if (paramString.startsWith("<LogAssert>")) {
      printLog(3, paramString);
    } else if (paramString.startsWith("<LogError>")) {
      printLog(4, paramString);
    } else if (paramString.startsWith("<LogException>")) {
      printLog(4, paramString);
    } else {
      printLog(0, paramString);
    } 
  }
  
  public static void putUserData(final String key, final String value) {
    if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value))
      return; 
    runTaskInUiThread(new Runnable() {
          public void run() {
            GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.CrashReport"), "putUserData", new Object[] { GameAgent.access$600(), this.val$key, this.val$value }, new Class[] { Context.class, String.class, String.class });
          }
        });
  }
  
  public static void removeUserData(final String key) {
    if (TextUtils.isEmpty(key))
      return; 
    runTaskInUiThread(new Runnable() {
          public void run() {
            GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.CrashReport"), "removeUserData", new Object[] { GameAgent.access$600(), this.val$key }, new Class[] { Context.class, String.class });
          }
        });
  }
  
  private static void runTaskInUiThread(Runnable paramRunnable) {
    Activity activity = getActivity();
    if (activity != null) {
      activity.runOnUiThread(paramRunnable);
    } else {
      (new Thread(paramRunnable)).start();
    } 
  }
  
  public static void setAppChannel(final String channel) {
    if (TextUtils.isEmpty(channel))
      return; 
    sAppChannel = channel;
    runTaskInUiThread(new Runnable() {
          public void run() {
            GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.CrashReport"), "setAppChannel", new Object[] { GameAgent.access$600(), this.val$channel }, new Class[] { Context.class, String.class });
          }
        });
  }
  
  public static void setAppVersion(final String version) {
    if (TextUtils.isEmpty(version))
      return; 
    sAppVersion = version;
    runTaskInUiThread(new Runnable() {
          public void run() {
            GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.CrashReport"), "setAppVersion", new Object[] { GameAgent.access$600(), this.val$version }, new Class[] { Context.class, String.class });
          }
        });
  }
  
  public static void setGameType(int paramInt) {
    sGameType = paramInt;
  }
  
  public static void setLog(int paramInt, final String tag, final String logData) {
    final String method;
    if (TextUtils.isEmpty(tag))
      return; 
    switch (paramInt) {
      default:
        str = null;
        break;
      case 4:
        str = "e";
        break;
      case 3:
        str = "w";
        break;
      case 2:
        str = "i";
        break;
      case 1:
        str = "d";
        break;
      case 0:
        str = "v";
        break;
    } 
    if (str != null)
      runTaskInUiThread(new Runnable() {
            public void run() {
              GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.BuglyLog"), method, new Object[] { this.val$tag, this.val$logData }, new Class[] { String.class, String.class });
            }
          }); 
  }
  
  public static void setLogEnable(boolean paramBoolean) {
    sIsDebug = paramBoolean;
  }
  
  public static void setSdkConfig(final String key, final String value) {
    if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value))
      return; 
    runTaskInUiThread(new Runnable() {
          public void run() {
            String str = GameAgent.convertToCanonicalName("crashreport.CrashReport");
            Context context = GameAgent.getApplicationContext();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SDK_");
            stringBuilder.append(key);
            GameAgent.Reflection.invokeStaticMethod(str, "putSdkData", new Object[] { context, stringBuilder.toString(), this.val$value }, new Class[] { Context.class, String.class, String.class });
          }
        });
  }
  
  public static void setSdkPackageName(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    sdkPackageName = paramString;
  }
  
  public static void setUserId(final String userId) {
    if (TextUtils.isEmpty(userId))
      return; 
    sUserId = userId;
    runTaskInUiThread(new Runnable() {
          public void run() {
            GameAgent.Reflection.invokeStaticMethod(GameAgent.convertToCanonicalName("crashreport.CrashReport"), "setUserId", new Object[] { GameAgent.access$600(), this.val$userId }, new Class[] { Context.class, String.class });
          }
        });
  }
  
  public static void setUserSceneTag(final int sceneId) {
    runTaskInUiThread(new Runnable() {
          public void run() {
            String str = GameAgent.convertToCanonicalName("crashreport.CrashReport");
            Context context = GameAgent.getApplicationContext();
            int i = sceneId;
            Class<int> clazz = int.class;
            GameAgent.Reflection.invokeStaticMethod(str, "setUserSceneTag", new Object[] { context, Integer.valueOf(i) }, new Class[] { Context.class, clazz });
          }
        });
  }
  
  private static class Reflection {
    private static Object getStaticField(String param1String1, String param1String2, Object param1Object) {
      try {
        Field field = Class.forName(param1String1).getDeclaredField(param1String2);
        field.setAccessible(true);
        return field.get(param1Object);
      } catch (ClassNotFoundException classNotFoundException) {
        classNotFoundException.printStackTrace();
      } catch (NoSuchFieldException noSuchFieldException) {
        noSuchFieldException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } 
      return null;
    }
    
    private static Object invokeStaticMethod(String param1String1, String param1String2, Object[] param1ArrayOfObject, Class<?>... param1VarArgs) {
      try {
        Method method = Class.forName(param1String1).getDeclaredMethod(param1String2, param1VarArgs);
        method.setAccessible(true);
        return method.invoke(null, param1ArrayOfObject);
      } catch (ClassNotFoundException classNotFoundException) {
        classNotFoundException.printStackTrace();
      } catch (NoSuchMethodException noSuchMethodException) {
        noSuchMethodException.printStackTrace();
      } catch (InvocationTargetException invocationTargetException) {
        invocationTargetException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return null;
    }
    
    private static Object newInstance(String param1String, Object[] param1ArrayOfObject, Class<?>... param1VarArgs) {
      try {
        null = Class.forName(param1String);
        return (param1ArrayOfObject == null) ? null.newInstance() : null.getConstructor(param1VarArgs).newInstance(param1ArrayOfObject);
      } catch (ClassNotFoundException classNotFoundException) {
        classNotFoundException.printStackTrace();
      } catch (NoSuchMethodException noSuchMethodException) {
        noSuchMethodException.printStackTrace();
      } catch (InstantiationException instantiationException) {
        instantiationException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } catch (InvocationTargetException invocationTargetException) {
        invocationTargetException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return null;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\agent\GameAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
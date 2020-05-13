package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
  static boolean DEBUG = false;
  
  static final String TAG = "LoaderManager";
  
  boolean mCreatingLoader;
  
  FragmentHostCallback mHost;
  
  final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  
  final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();
  
  boolean mRetaining;
  
  boolean mRetainingStarted;
  
  boolean mStarted;
  
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentHostCallback paramFragmentHostCallback, boolean paramBoolean) {
    this.mWho = paramString;
    this.mHost = paramFragmentHostCallback;
    this.mStarted = paramBoolean;
  }
  
  private LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks) {
    try {
      this.mCreatingLoader = true;
      LoaderInfo loaderInfo = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(loaderInfo);
      return loaderInfo;
    } finally {
      this.mCreatingLoader = false;
    } 
  }
  
  private LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks) {
    LoaderInfo loaderInfo = new LoaderInfo(paramInt, paramBundle, paramLoaderCallbacks);
    loaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return loaderInfo;
  }
  
  public void destroyLoader(int paramInt) {
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    if (DEBUG)
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt); 
    int i = this.mLoaders.indexOfKey(paramInt);
    if (i >= 0) {
      LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      this.mLoaders.removeAt(i);
      loaderInfo.destroy();
    } 
    paramInt = this.mInactiveLoaders.indexOfKey(paramInt);
    if (paramInt >= 0) {
      LoaderInfo loaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(paramInt);
      this.mInactiveLoaders.removeAt(paramInt);
      loaderInfo.destroy();
    } 
    if (this.mHost != null && !hasRunningLoaders())
      this.mHost.mFragmentManager.startPendingDeferredFragments(); 
  }
  
  void doDestroy() {
    if (!this.mRetaining) {
      if (DEBUG)
        Log.v("LoaderManager", "Destroying Active in " + this); 
      for (int j = this.mLoaders.size() - 1; j >= 0; j--)
        ((LoaderInfo)this.mLoaders.valueAt(j)).destroy(); 
      this.mLoaders.clear();
    } 
    if (DEBUG)
      Log.v("LoaderManager", "Destroying Inactive in " + this); 
    for (int i = this.mInactiveLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy(); 
    this.mInactiveLoaders.clear();
    this.mHost = null;
  }
  
  void doReportNextStart() {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true; 
  }
  
  void doReportStart() {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mLoaders.valueAt(i)).reportStart(); 
  }
  
  void doRetain() {
    if (DEBUG)
      Log.v("LoaderManager", "Retaining in " + this); 
    if (!this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
      return;
    } 
    this.mRetaining = true;
    this.mStarted = false;
    int i = this.mLoaders.size() - 1;
    while (true) {
      if (i >= 0) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).retain();
        i--;
        continue;
      } 
      return;
    } 
  }
  
  void doStart() {
    if (DEBUG)
      Log.v("LoaderManager", "Starting in " + this); 
    if (this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
      return;
    } 
    this.mStarted = true;
    int i = this.mLoaders.size() - 1;
    while (true) {
      if (i >= 0) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).start();
        i--;
        continue;
      } 
      return;
    } 
  }
  
  void doStop() {
    if (DEBUG)
      Log.v("LoaderManager", "Stopping in " + this); 
    if (!this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
      return;
    } 
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderInfo)this.mLoaders.valueAt(i)).stop(); 
    this.mStarted = false;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    byte b = 0;
    if (this.mLoaders.size() > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      String str = paramString + "    ";
      for (byte b1 = 0; b1 < this.mLoaders.size(); b1++) {
        LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.valueAt(b1);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(b1));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderInfo.toString());
        loaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
    if (this.mInactiveLoaders.size() > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      String str = paramString + "    ";
      for (byte b1 = b; b1 < this.mInactiveLoaders.size(); b1++) {
        LoaderInfo loaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(b1);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(b1));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderInfo.toString());
        loaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
  }
  
  void finishRetain() {
    if (this.mRetaining) {
      if (DEBUG)
        Log.v("LoaderManager", "Finished Retaining in " + this); 
      this.mRetaining = false;
      for (int i = this.mLoaders.size() - 1; i >= 0; i--)
        ((LoaderInfo)this.mLoaders.valueAt(i)).finishRetain(); 
    } 
  }
  
  public <D> Loader<D> getLoader(int paramInt) {
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    null = (LoaderInfo)this.mLoaders.get(paramInt);
    return (null != null) ? ((null.mPendingLoader != null) ? null.mPendingLoader.mLoader : null.mLoader) : null;
  }
  
  public boolean hasRunningLoaders() {
    int i = this.mLoaders.size();
    int j = 0;
    byte b = 0;
    while (b < i) {
      int k;
      LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.valueAt(b);
      if (loaderInfo.mStarted && !loaderInfo.mDeliveredData) {
        k = 1;
      } else {
        k = 0;
      } 
      b++;
      j = k | j;
    } 
    return j;
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    LoaderInfo loaderInfo1;
    LoaderInfo loaderInfo2;
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    LoaderInfo loaderInfo3 = (LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG)
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle); 
    if (loaderInfo3 == null) {
      loaderInfo2 = createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks);
      loaderInfo1 = loaderInfo2;
      if (DEBUG) {
        Log.v("LoaderManager", "  Created new loader " + loaderInfo2);
        loaderInfo1 = loaderInfo2;
      } 
    } else {
      if (DEBUG)
        Log.v("LoaderManager", "  Re-using existing loader " + loaderInfo3); 
      loaderInfo3.mCallbacks = (LoaderManager.LoaderCallbacks)loaderInfo2;
      loaderInfo1 = loaderInfo3;
    } 
    if (loaderInfo1.mHaveData && this.mStarted)
      loaderInfo1.callOnLoadFinished(loaderInfo1.mLoader, loaderInfo1.mData); 
    return loaderInfo1.mLoader;
  }
  
  void installLoader(LoaderInfo paramLoaderInfo) {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted)
      paramLoaderInfo.start(); 
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    if (this.mCreatingLoader)
      throw new IllegalStateException("Called while creating a loader"); 
    LoaderInfo loaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG)
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle); 
    if (loaderInfo != null) {
      LoaderInfo loaderInfo1 = (LoaderInfo)this.mInactiveLoaders.get(paramInt);
      if (loaderInfo1 != null) {
        if (loaderInfo.mHaveData) {
          if (DEBUG)
            Log.v("LoaderManager", "  Removing last inactive loader: " + loaderInfo); 
          loaderInfo1.mDeliveredData = false;
          loaderInfo1.destroy();
          loaderInfo.mLoader.abandon();
          this.mInactiveLoaders.put(paramInt, loaderInfo);
        } else if (!loaderInfo.cancel()) {
          if (DEBUG)
            Log.v("LoaderManager", "  Current loader is stopped; replacing"); 
          this.mLoaders.put(paramInt, null);
          loaderInfo.destroy();
        } else {
          if (DEBUG)
            Log.v("LoaderManager", "  Current loader is running; configuring pending loader"); 
          if (loaderInfo.mPendingLoader != null) {
            if (DEBUG)
              Log.v("LoaderManager", "  Removing pending loader: " + loaderInfo.mPendingLoader); 
            loaderInfo.mPendingLoader.destroy();
            loaderInfo.mPendingLoader = null;
          } 
          if (DEBUG)
            Log.v("LoaderManager", "  Enqueuing as new pending loader"); 
          loaderInfo.mPendingLoader = createLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks);
          return loaderInfo.mPendingLoader.mLoader;
        } 
      } else {
        if (DEBUG)
          Log.v("LoaderManager", "  Making last loader inactive: " + loaderInfo); 
        loaderInfo.mLoader.abandon();
        this.mInactiveLoaders.put(paramInt, loaderInfo);
      } 
    } 
    return (createAndInstallLoader(paramInt, paramBundle, (LoaderManager.LoaderCallbacks)paramLoaderCallbacks)).mLoader;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("LoaderManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  void updateHostController(FragmentHostCallback paramFragmentHostCallback) {
    this.mHost = paramFragmentHostCallback;
  }
  
  final class LoaderInfo implements Loader.OnLoadCanceledListener<Object>, Loader.OnLoadCompleteListener<Object> {
    final Bundle mArgs;
    
    LoaderManager.LoaderCallbacks<Object> mCallbacks;
    
    Object mData;
    
    boolean mDeliveredData;
    
    boolean mDestroyed;
    
    boolean mHaveData;
    
    final int mId;
    
    boolean mListenerRegistered;
    
    Loader<Object> mLoader;
    
    LoaderInfo mPendingLoader;
    
    boolean mReportNextStart;
    
    boolean mRetaining;
    
    boolean mRetainingStarted;
    
    boolean mStarted;
    
    public LoaderInfo(int param1Int, Bundle param1Bundle, LoaderManager.LoaderCallbacks<Object> param1LoaderCallbacks) {
      this.mId = param1Int;
      this.mArgs = param1Bundle;
      this.mCallbacks = param1LoaderCallbacks;
    }
    
    void callOnLoadFinished(Loader<Object> param1Loader, Object param1Object) {
      if (this.mCallbacks != null) {
        String str;
        if (LoaderManagerImpl.this.mHost != null) {
          str = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
          LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
        } else {
          str = null;
        } 
        try {
          if (LoaderManagerImpl.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            Log.v("LoaderManager", stringBuilder.append("  onLoadFinished in ").append(param1Loader).append(": ").append(param1Loader.dataToString(param1Object)).toString());
          } 
          this.mCallbacks.onLoadFinished(param1Loader, param1Object);
          if (LoaderManagerImpl.this.mHost != null)
            LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str; 
          return;
        } finally {
          if (LoaderManagerImpl.this.mHost != null)
            LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str; 
        } 
      } 
    }
    
    boolean cancel() {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Canceling: " + this); 
      if (this.mStarted && this.mLoader != null && this.mListenerRegistered) {
        boolean bool1 = this.mLoader.cancelLoad();
        boolean bool2 = bool1;
        if (!bool1) {
          onLoadCanceled(this.mLoader);
          bool2 = bool1;
        } 
        return bool2;
      } 
      return false;
    }
    
    void destroy() {
      // Byte code:
      //   0: getstatic android/support/v4/app/LoaderManagerImpl.DEBUG : Z
      //   3: ifeq -> 31
      //   6: ldc 'LoaderManager'
      //   8: new java/lang/StringBuilder
      //   11: dup
      //   12: invokespecial <init> : ()V
      //   15: ldc '  Destroying: '
      //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: aload_0
      //   21: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   24: invokevirtual toString : ()Ljava/lang/String;
      //   27: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
      //   30: pop
      //   31: aload_0
      //   32: iconst_1
      //   33: putfield mDestroyed : Z
      //   36: aload_0
      //   37: getfield mDeliveredData : Z
      //   40: istore_1
      //   41: aload_0
      //   42: iconst_0
      //   43: putfield mDeliveredData : Z
      //   46: aload_0
      //   47: getfield mCallbacks : Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   50: ifnull -> 178
      //   53: aload_0
      //   54: getfield mLoader : Landroid/support/v4/content/Loader;
      //   57: ifnull -> 178
      //   60: aload_0
      //   61: getfield mHaveData : Z
      //   64: ifeq -> 178
      //   67: iload_1
      //   68: ifeq -> 178
      //   71: getstatic android/support/v4/app/LoaderManagerImpl.DEBUG : Z
      //   74: ifeq -> 102
      //   77: ldc 'LoaderManager'
      //   79: new java/lang/StringBuilder
      //   82: dup
      //   83: invokespecial <init> : ()V
      //   86: ldc '  Resetting: '
      //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   91: aload_0
      //   92: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   95: invokevirtual toString : ()Ljava/lang/String;
      //   98: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
      //   101: pop
      //   102: aload_0
      //   103: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   106: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   109: ifnull -> 277
      //   112: aload_0
      //   113: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   116: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   119: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   122: getfield mNoTransactionsBecause : Ljava/lang/String;
      //   125: astore_2
      //   126: aload_0
      //   127: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   130: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   133: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   136: ldc 'onLoaderReset'
      //   138: putfield mNoTransactionsBecause : Ljava/lang/String;
      //   141: aload_0
      //   142: getfield mCallbacks : Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   145: aload_0
      //   146: getfield mLoader : Landroid/support/v4/content/Loader;
      //   149: invokeinterface onLoaderReset : (Landroid/support/v4/content/Loader;)V
      //   154: aload_0
      //   155: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   158: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   161: ifnull -> 178
      //   164: aload_0
      //   165: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   168: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   171: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   174: aload_2
      //   175: putfield mNoTransactionsBecause : Ljava/lang/String;
      //   178: aload_0
      //   179: aconst_null
      //   180: putfield mCallbacks : Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   183: aload_0
      //   184: aconst_null
      //   185: putfield mData : Ljava/lang/Object;
      //   188: aload_0
      //   189: iconst_0
      //   190: putfield mHaveData : Z
      //   193: aload_0
      //   194: getfield mLoader : Landroid/support/v4/content/Loader;
      //   197: ifnull -> 235
      //   200: aload_0
      //   201: getfield mListenerRegistered : Z
      //   204: ifeq -> 228
      //   207: aload_0
      //   208: iconst_0
      //   209: putfield mListenerRegistered : Z
      //   212: aload_0
      //   213: getfield mLoader : Landroid/support/v4/content/Loader;
      //   216: aload_0
      //   217: invokevirtual unregisterListener : (Landroid/support/v4/content/Loader$OnLoadCompleteListener;)V
      //   220: aload_0
      //   221: getfield mLoader : Landroid/support/v4/content/Loader;
      //   224: aload_0
      //   225: invokevirtual unregisterOnLoadCanceledListener : (Landroid/support/v4/content/Loader$OnLoadCanceledListener;)V
      //   228: aload_0
      //   229: getfield mLoader : Landroid/support/v4/content/Loader;
      //   232: invokevirtual reset : ()V
      //   235: aload_0
      //   236: getfield mPendingLoader : Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
      //   239: ifnull -> 249
      //   242: aload_0
      //   243: getfield mPendingLoader : Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
      //   246: invokevirtual destroy : ()V
      //   249: return
      //   250: astore_3
      //   251: aload_0
      //   252: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   255: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   258: ifnull -> 275
      //   261: aload_0
      //   262: getfield this$0 : Landroid/support/v4/app/LoaderManagerImpl;
      //   265: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
      //   268: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
      //   271: aload_2
      //   272: putfield mNoTransactionsBecause : Ljava/lang/String;
      //   275: aload_3
      //   276: athrow
      //   277: aconst_null
      //   278: astore_2
      //   279: goto -> 141
      // Exception table:
      //   from	to	target	type
      //   141	154	250	finally
    }
    
    public void dump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mId=");
      param1PrintWriter.print(this.mId);
      param1PrintWriter.print(" mArgs=");
      param1PrintWriter.println(this.mArgs);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mCallbacks=");
      param1PrintWriter.println(this.mCallbacks);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mLoader=");
      param1PrintWriter.println(this.mLoader);
      if (this.mLoader != null)
        this.mLoader.dump(param1String + "  ", param1FileDescriptor, param1PrintWriter, param1ArrayOfString); 
      if (this.mHaveData || this.mDeliveredData) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.print("mHaveData=");
        param1PrintWriter.print(this.mHaveData);
        param1PrintWriter.print("  mDeliveredData=");
        param1PrintWriter.println(this.mDeliveredData);
        param1PrintWriter.print(param1String);
        param1PrintWriter.print("mData=");
        param1PrintWriter.println(this.mData);
      } 
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mStarted=");
      param1PrintWriter.print(this.mStarted);
      param1PrintWriter.print(" mReportNextStart=");
      param1PrintWriter.print(this.mReportNextStart);
      param1PrintWriter.print(" mDestroyed=");
      param1PrintWriter.println(this.mDestroyed);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mRetaining=");
      param1PrintWriter.print(this.mRetaining);
      param1PrintWriter.print(" mRetainingStarted=");
      param1PrintWriter.print(this.mRetainingStarted);
      param1PrintWriter.print(" mListenerRegistered=");
      param1PrintWriter.println(this.mListenerRegistered);
      if (this.mPendingLoader != null) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.println("Pending Loader ");
        param1PrintWriter.print(this.mPendingLoader);
        param1PrintWriter.println(":");
        this.mPendingLoader.dump(param1String + "  ", param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
      } 
    }
    
    void finishRetain() {
      if (this.mRetaining) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Finished Retaining: " + this); 
        this.mRetaining = false;
        if (this.mStarted != this.mRetainingStarted && !this.mStarted)
          stop(); 
      } 
      if (this.mStarted && this.mHaveData && !this.mReportNextStart)
        callOnLoadFinished(this.mLoader, this.mData); 
    }
    
    public void onLoadCanceled(Loader<Object> param1Loader) {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "onLoadCanceled: " + this); 
      if (this.mDestroyed) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Ignoring load canceled -- destroyed"); 
        return;
      } 
      if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Ignoring load canceled -- not active"); 
        return;
      } 
      LoaderInfo loaderInfo = this.mPendingLoader;
      if (loaderInfo != null) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo); 
        this.mPendingLoader = null;
        LoaderManagerImpl.this.mLoaders.put(this.mId, null);
        destroy();
        LoaderManagerImpl.this.installLoader(loaderInfo);
      } 
    }
    
    public void onLoadComplete(Loader<Object> param1Loader, Object param1Object) {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "onLoadComplete: " + this); 
      if (this.mDestroyed) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Ignoring load complete -- destroyed"); 
        return;
      } 
      if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Ignoring load complete -- not active"); 
        return;
      } 
      LoaderInfo loaderInfo2 = this.mPendingLoader;
      if (loaderInfo2 != null) {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo2); 
        this.mPendingLoader = null;
        LoaderManagerImpl.this.mLoaders.put(this.mId, null);
        destroy();
        LoaderManagerImpl.this.installLoader(loaderInfo2);
        return;
      } 
      if (this.mData != param1Object || !this.mHaveData) {
        this.mData = param1Object;
        this.mHaveData = true;
        if (this.mStarted)
          callOnLoadFinished(param1Loader, param1Object); 
      } 
      LoaderInfo loaderInfo1 = (LoaderInfo)LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
      if (loaderInfo1 != null && loaderInfo1 != this) {
        loaderInfo1.mDeliveredData = false;
        loaderInfo1.destroy();
        LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
      } 
      if (LoaderManagerImpl.this.mHost != null && !LoaderManagerImpl.this.hasRunningLoaders())
        LoaderManagerImpl.this.mHost.mFragmentManager.startPendingDeferredFragments(); 
    }
    
    void reportStart() {
      if (this.mStarted && this.mReportNextStart) {
        this.mReportNextStart = false;
        if (this.mHaveData && !this.mRetaining)
          callOnLoadFinished(this.mLoader, this.mData); 
      } 
    }
    
    void retain() {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Retaining: " + this); 
      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
    }
    
    void start() {
      if (this.mRetaining && this.mRetainingStarted) {
        this.mStarted = true;
        return;
      } 
      if (!this.mStarted) {
        this.mStarted = true;
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Starting: " + this); 
        if (this.mLoader == null && this.mCallbacks != null)
          this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs); 
        if (this.mLoader != null) {
          if (this.mLoader.getClass().isMemberClass() && !Modifier.isStatic(this.mLoader.getClass().getModifiers()))
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader); 
          if (!this.mListenerRegistered) {
            this.mLoader.registerListener(this.mId, this);
            this.mLoader.registerOnLoadCanceledListener(this);
            this.mListenerRegistered = true;
          } 
          this.mLoader.startLoading();
        } 
      } 
    }
    
    void stop() {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Stopping: " + this); 
      this.mStarted = false;
      if (!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
        this.mListenerRegistered = false;
        this.mLoader.unregisterListener(this);
        this.mLoader.unregisterOnLoadCanceledListener(this);
        this.mLoader.stopLoading();
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("LoaderInfo{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" #");
      stringBuilder.append(this.mId);
      stringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
      stringBuilder.append("}}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
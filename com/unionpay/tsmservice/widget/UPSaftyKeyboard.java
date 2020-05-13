package com.unionpay.tsmservice.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.OnSafetyKeyboardCallback;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.NinePatchInfo;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.result.GetEncryptDataResult;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UPSaftyKeyboard {
  private boolean A = false;
  
  private boolean B = true;
  
  private boolean C = false;
  
  private int D = -1;
  
  private int E = -1;
  
  private int F = -1;
  
  private int G = -1;
  
  private int H = -1;
  
  private int I = -16777216;
  
  private Typeface J;
  
  private boolean K = false;
  
  private OnShowListener L;
  
  private OnHideListener M;
  
  private OnEditorListener N;
  
  private OnSafetyKeyboardCallback.Stub O;
  
  private UPTsmAddon.UPTsmConnectionListener P;
  
  private Handler.Callback Q = new UPSaftyKeyboard$1(this);
  
  private final Handler R = new Handler(Looper.getMainLooper(), this.Q);
  
  private Context a = null;
  
  private UPTsmAddon b;
  
  private int c;
  
  private int d;
  
  private String e;
  
  private int f = -1;
  
  private int g = -1;
  
  private int h = -1;
  
  private int i = -1;
  
  private int j = -1;
  
  private int k = -1;
  
  private int l = -1;
  
  private int m = -1;
  
  private int n = -1;
  
  private int o = -1;
  
  private int p = -1;
  
  private int q = -1;
  
  private int r = -1;
  
  private int s = -1;
  
  private int t = -1;
  
  private int u = -1;
  
  private int v = -1;
  
  private int w = 0;
  
  private int x = 0;
  
  private int y = 1;
  
  private boolean z = false;
  
  public UPSaftyKeyboard(Context paramContext, int paramInt) throws RemoteException {
    this(paramContext, paramInt, null);
  }
  
  public UPSaftyKeyboard(Context paramContext, int paramInt, Drawable paramDrawable) throws RemoteException {
    this.a = paramContext;
    this.c = paramInt;
    if (paramInt < 2000 || paramInt > 2001)
      throw new IllegalArgumentException("Type is error"); 
    this.b = UPTsmAddon.getInstance(this.a);
    if (!this.b.isConnected()) {
      this.P = new UPSaftyKeyboard$2(this);
      this.b.addConnectionListener(this.P);
      this.b.bind();
    } else {
      a();
    } 
    if (paramDrawable != null)
      try {
        setKeyboardBackground(paramDrawable);
      } catch (KeyboardDrawableErrorException keyboardDrawableErrorException) {
        keyboardDrawableErrorException.printStackTrace();
      }  
  }
  
  private String a(String paramString) {
    b b = new b(this);
    b.a(b, paramString);
    return b.a(b, TimeUnit.MILLISECONDS);
  }
  
  private void a() {
    if (this.b != null)
      try {
        this.b.clearEncryptData(this.c);
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
  }
  
  private void a(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setDoneForeBitmap(((BitmapDrawable)paramDrawable).getBitmap());
      } else if (i == 1) {
        throw new KeyboardDrawableErrorException();
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  private void a(SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams) throws RemoteException {
    this.b.setSafetyKeyboardBitmap(paramSafetyKeyboardRequestParams);
  }
  
  private void b(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setDelForeBitmap(((BitmapDrawable)paramDrawable).getBitmap());
      } else if (i == 1) {
        throw new KeyboardDrawableErrorException();
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  private static int c(Drawable paramDrawable) {
    byte b = -1;
    if (paramDrawable != null) {
      if (paramDrawable instanceof BitmapDrawable)
        return 0; 
      if (paramDrawable instanceof ColorDrawable)
        return 1; 
      if (paramDrawable instanceof NinePatchDrawable)
        b = 2; 
    } 
    return b;
  }
  
  private static NinePatchInfo d(Drawable paramDrawable) {
    NinePatchDrawable ninePatchDrawable = (NinePatchDrawable)paramDrawable;
    NinePatchInfo ninePatchInfo = new NinePatchInfo();
    Rect rect = new Rect();
    ninePatchDrawable.getPadding(rect);
    ninePatchInfo.setPadding(rect);
    Drawable.ConstantState constantState = ninePatchDrawable.getConstantState();
    try {
      Field field = Class.forName("android.graphics.drawable.NinePatchDrawable$NinePatchState").getDeclaredField("mNinePatch");
      field.setAccessible(true);
      Object object = field.get(constantState);
      object = Class.forName("android.graphics.NinePatch").getDeclaredMethod("getBitmap", new Class[0]).invoke(object, new Object[0]);
      ninePatchInfo.setBitmap((Bitmap)object);
      ninePatchInfo.setChunk(object.getNinePatchChunk());
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return ninePatchInfo;
  }
  
  public boolean clearPwd() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield d : I
    //   9: aload_0
    //   10: getfield b : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   13: aload_0
    //   14: getfield c : I
    //   17: invokevirtual clearEncryptData : (I)I
    //   20: istore_2
    //   21: iload_2
    //   22: ifne -> 27
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual printStackTrace : ()V
    //   36: bipush #-5
    //   38: istore_2
    //   39: goto -> 21
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   4	9	42	finally
    //   9	21	31	android/os/RemoteException
    //   9	21	42	finally
    //   32	36	42	finally
  }
  
  public void enableLightStatusBar(boolean paramBoolean) {
    this.K = paramBoolean;
  }
  
  public int getCurrentPinLength() {
    return this.d;
  }
  
  public String getInput() {
    return a("");
  }
  
  public String getInput(String paramString) {
    return (this.c != 2000) ? "" : a(paramString);
  }
  
  public boolean hide() {
    try {
      int i = this.b.hideKeyboard();
      if (i == 0)
        return true; 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      byte b = -5;
      if (b == 0)
        return true; 
    } 
    return false;
  }
  
  public void setConfirmBtnOutPaddingRight(int paramInt) {
    this.v = paramInt;
  }
  
  public void setConfirmBtnSize(int paramInt1, int paramInt2) {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void setDelKeyDrawable(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    if (paramDrawable != null)
      b(paramDrawable); 
  }
  
  public void setDelKeyDrawable(Drawable paramDrawable1, Drawable paramDrawable2) throws KeyboardDrawableErrorException, RemoteException {
    if (paramDrawable1 != null)
      b(paramDrawable1); 
    if (paramDrawable2 != null) {
      int i = c(paramDrawable2);
      if (i != -1) {
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (i == 0) {
          safetyKeyboardRequestParams.setDelBgBitmap(((BitmapDrawable)paramDrawable2).getBitmap());
          safetyKeyboardRequestParams.setDelBgColor(-1);
        } else if (i == 1) {
          safetyKeyboardRequestParams.setDelBgColor(((ColorDrawable)paramDrawable2).getColor());
        } else if (i == 2) {
          safetyKeyboardRequestParams.setDelKeyBgNinePatch(d(paramDrawable2));
        } 
        a(safetyKeyboardRequestParams);
        return;
      } 
    } else {
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setDoneKeyDrawable(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    if (paramDrawable != null)
      a(paramDrawable); 
  }
  
  public void setDoneKeyDrawable(Drawable paramDrawable1, Drawable paramDrawable2) throws KeyboardDrawableErrorException, RemoteException {
    if (paramDrawable1 != null)
      a(paramDrawable1); 
    if (paramDrawable2 != null) {
      int i = c(paramDrawable2);
      if (i != -1) {
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (i == 0) {
          safetyKeyboardRequestParams.setDoneBgBitmap(((BitmapDrawable)paramDrawable2).getBitmap());
          safetyKeyboardRequestParams.setDoneBgColor(-1);
        } else if (i == 1) {
          safetyKeyboardRequestParams.setDoneBgColor(((ColorDrawable)paramDrawable2).getColor());
        } else if (i == 2) {
          safetyKeyboardRequestParams.setDoneKeyBgNinePatch(d(paramDrawable2));
        } 
        a(safetyKeyboardRequestParams);
        return;
      } 
    } else {
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setDoneKeyEnable(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void setDoneKeyRightMode(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  public void setKeyAreaPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.q = paramInt1;
    this.r = paramInt2;
    this.s = paramInt3;
    this.t = paramInt4;
  }
  
  public void setKeyBoardSize(int paramInt1, int paramInt2) {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void setKeyboardAudio(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public void setKeyboardBackground(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setKeyboardBgBitmap(((BitmapDrawable)paramDrawable).getBitmap());
        safetyKeyboardRequestParams.setKeyboardBgColor(-1);
      } else if (i == 1) {
        safetyKeyboardRequestParams.setKeyboardBgColor(((ColorDrawable)paramDrawable).getColor());
      } else if (i == 2) {
        safetyKeyboardRequestParams.setKeyboardBgNinePatch(d(paramDrawable));
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setKeyboardPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
  }
  
  public void setKeyboardStartPosition(int paramInt1, int paramInt2) {
    this.w = paramInt1;
    this.x = paramInt2;
    this.y = 0;
  }
  
  public void setKeyboardVibrate(boolean paramBoolean) {
    this.C = paramBoolean;
  }
  
  public void setNumKeyBackgroud(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setNumBgBitmap(((BitmapDrawable)paramDrawable).getBitmap());
        safetyKeyboardRequestParams.setNumBgColor(-1);
      } else if (i == 1) {
        safetyKeyboardRequestParams.setNumBgColor(((ColorDrawable)paramDrawable).getColor());
      } else if (i == 2) {
        safetyKeyboardRequestParams.setNumKeyBgNinePatch(d(paramDrawable));
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setNumKeyMargin(int paramInt1, int paramInt2) {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public void setNumberKeyColor(int paramInt) {
    this.I = paramInt;
  }
  
  public void setNumberKeyDrawable(Drawable[] paramArrayOfDrawable) throws KeyboardDrawableErrorException, RemoteException {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: iload_2
    //   3: istore_3
    //   4: aload_1
    //   5: ifnull -> 15
    //   8: aload_1
    //   9: arraylength
    //   10: ifgt -> 85
    //   13: iload_2
    //   14: istore_3
    //   15: iload_3
    //   16: ifne -> 136
    //   19: new com/unionpay/tsmservice/request/SafetyKeyboardRequestParams
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #4
    //   28: new java/util/ArrayList
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #5
    //   37: aload_1
    //   38: arraylength
    //   39: istore #6
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: iload #6
    //   46: if_icmpge -> 122
    //   49: aload_1
    //   50: iload_3
    //   51: aaload
    //   52: astore #7
    //   54: aload #7
    //   56: checkcast android/graphics/drawable/BitmapDrawable
    //   59: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   62: ifnull -> 79
    //   65: aload #5
    //   67: aload #7
    //   69: checkcast android/graphics/drawable/BitmapDrawable
    //   72: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   75: invokevirtual add : (Ljava/lang/Object;)Z
    //   78: pop
    //   79: iinc #3, 1
    //   82: goto -> 43
    //   85: aload_1
    //   86: arraylength
    //   87: istore #8
    //   89: iconst_0
    //   90: istore #6
    //   92: iload #6
    //   94: iload #8
    //   96: if_icmpge -> 117
    //   99: iload_2
    //   100: istore_3
    //   101: aload_1
    //   102: iload #6
    //   104: aaload
    //   105: instanceof android/graphics/drawable/BitmapDrawable
    //   108: ifeq -> 15
    //   111: iinc #6, 1
    //   114: goto -> 92
    //   117: iconst_0
    //   118: istore_3
    //   119: goto -> 15
    //   122: aload #4
    //   124: aload #5
    //   126: invokevirtual setNumForeBitmaps : (Ljava/util/ArrayList;)V
    //   129: aload_0
    //   130: aload #4
    //   132: invokespecial a : (Lcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;)V
    //   135: return
    //   136: new com/unionpay/tsmservice/widget/KeyboardDrawableErrorException
    //   139: dup
    //   140: invokespecial <init> : ()V
    //   143: athrow
  }
  
  public void setNumberKeySize(int paramInt) {
    this.u = paramInt;
  }
  
  public void setOnEditorListener(OnEditorListener paramOnEditorListener) {
    this.N = paramOnEditorListener;
  }
  
  public void setOnHideListener(OnHideListener paramOnHideListener) {
    this.M = paramOnHideListener;
  }
  
  public void setOnShowListener(OnShowListener paramOnShowListener) {
    this.L = paramOnShowListener;
  }
  
  public void setTitleBackground(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setTitleBgBitmap(((BitmapDrawable)paramDrawable).getBitmap());
        safetyKeyboardRequestParams.setTitleBgColor(-1);
      } else if (i == 1) {
        safetyKeyboardRequestParams.setTitleBgColor(((ColorDrawable)paramDrawable).getColor());
      } else if (i == 2) {
        safetyKeyboardRequestParams.setTitleBgNinePatch(d(paramDrawable));
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setTitleColor(int paramInt) {
    this.G = paramInt;
  }
  
  public void setTitleConfirmDrawable(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setTitleDropBitmap(((BitmapDrawable)paramDrawable).getBitmap());
      } else if (i == 1) {
        throw new KeyboardDrawableErrorException();
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setTitleDrawable(Drawable paramDrawable) throws KeyboardDrawableErrorException, RemoteException {
    int i = c(paramDrawable);
    if (i != -1) {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
      if (i == 0) {
        safetyKeyboardRequestParams.setTitleIconBitmap(((BitmapDrawable)paramDrawable).getBitmap());
      } else if (i == 1) {
        throw new KeyboardDrawableErrorException();
      } 
      a(safetyKeyboardRequestParams);
      return;
    } 
    throw new KeyboardDrawableErrorException();
  }
  
  public void setTitleDrawablePadding(int paramInt) {
    this.F = paramInt;
  }
  
  public void setTitleDrawableSize(int paramInt1, int paramInt2) {
    this.D = paramInt1;
    this.E = paramInt2;
  }
  
  public void setTitleFont(Typeface paramTypeface) {
    this.J = paramTypeface;
  }
  
  public void setTitleHeight(int paramInt) {
    this.j = paramInt;
  }
  
  public void setTitleSize(int paramInt) {
    this.H = paramInt;
  }
  
  public void setTitleText(String paramString) {
    this.e = paramString;
  }
  
  public boolean show() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_1
    //   5: istore_2
    //   6: aload_0
    //   7: getfield O : Lcom/unionpay/tsmservice/OnSafetyKeyboardCallback$Stub;
    //   10: ifnonnull -> 379
    //   13: new com/unionpay/tsmservice/widget/UPSaftyKeyboard$a
    //   16: astore_3
    //   17: aload_3
    //   18: aload_0
    //   19: invokespecial <init> : (Lcom/unionpay/tsmservice/widget/UPSaftyKeyboard;)V
    //   22: aload_0
    //   23: aload_3
    //   24: putfield O : Lcom/unionpay/tsmservice/OnSafetyKeyboardCallback$Stub;
    //   27: new com/unionpay/tsmservice/request/SafetyKeyboardRequestParams
    //   30: astore_3
    //   31: aload_3
    //   32: invokespecial <init> : ()V
    //   35: aload_3
    //   36: aload_0
    //   37: getfield e : Ljava/lang/String;
    //   40: invokevirtual setTitle : (Ljava/lang/String;)V
    //   43: aload_3
    //   44: aload_0
    //   45: getfield f : I
    //   48: invokevirtual setKeyboardWidth : (I)V
    //   51: aload_3
    //   52: aload_0
    //   53: getfield g : I
    //   56: invokevirtual setKeyboardHeight : (I)V
    //   59: aload_3
    //   60: aload_0
    //   61: getfield h : I
    //   64: invokevirtual setConfirmBtnWidth : (I)V
    //   67: aload_3
    //   68: aload_0
    //   69: getfield i : I
    //   72: invokevirtual setConfirmBtnHeight : (I)V
    //   75: aload_3
    //   76: aload_0
    //   77: getfield j : I
    //   80: invokevirtual setTitleHeight : (I)V
    //   83: aload_3
    //   84: aload_0
    //   85: getfield k : I
    //   88: invokevirtual setMarginRow : (I)V
    //   91: aload_3
    //   92: aload_0
    //   93: getfield l : I
    //   96: invokevirtual setMarginCol : (I)V
    //   99: aload_3
    //   100: aload_0
    //   101: getfield m : I
    //   104: invokevirtual setOutPaddingLeft : (I)V
    //   107: aload_3
    //   108: aload_0
    //   109: getfield o : I
    //   112: invokevirtual setOutPaddingRight : (I)V
    //   115: aload_3
    //   116: aload_0
    //   117: getfield n : I
    //   120: invokevirtual setOutPaddingTop : (I)V
    //   123: aload_3
    //   124: aload_0
    //   125: getfield p : I
    //   128: invokevirtual setOutPaddingBottom : (I)V
    //   131: aload_3
    //   132: aload_0
    //   133: getfield q : I
    //   136: invokevirtual setInnerPaddingLeft : (I)V
    //   139: aload_3
    //   140: aload_0
    //   141: getfield s : I
    //   144: invokevirtual setInnerPaddingRight : (I)V
    //   147: aload_3
    //   148: aload_0
    //   149: getfield r : I
    //   152: invokevirtual setInnerPaddingTop : (I)V
    //   155: aload_3
    //   156: aload_0
    //   157: getfield t : I
    //   160: invokevirtual setInnerPaddingBottom : (I)V
    //   163: aload_3
    //   164: aload_0
    //   165: getfield u : I
    //   168: invokevirtual setNumSize : (I)V
    //   171: aload_3
    //   172: aload_0
    //   173: getfield v : I
    //   176: invokevirtual setConfirmBtnOutPaddingRight : (I)V
    //   179: aload_3
    //   180: aload_0
    //   181: getfield w : I
    //   184: invokevirtual setStartX : (I)V
    //   187: aload_3
    //   188: aload_0
    //   189: getfield x : I
    //   192: invokevirtual setStartY : (I)V
    //   195: aload_3
    //   196: aload_0
    //   197: getfield y : I
    //   200: invokevirtual setDefaultPosition : (I)V
    //   203: aload_0
    //   204: getfield z : Z
    //   207: iconst_1
    //   208: if_icmpne -> 383
    //   211: iconst_1
    //   212: istore #4
    //   214: aload_3
    //   215: iload #4
    //   217: invokevirtual setIsAudio : (I)V
    //   220: aload_0
    //   221: getfield A : Z
    //   224: iconst_1
    //   225: if_icmpne -> 389
    //   228: iconst_1
    //   229: istore #4
    //   231: aload_3
    //   232: iload #4
    //   234: invokevirtual setDoneRight : (I)V
    //   237: aload_0
    //   238: getfield B : Z
    //   241: iconst_1
    //   242: if_icmpne -> 395
    //   245: iconst_1
    //   246: istore #4
    //   248: aload_3
    //   249: iload #4
    //   251: invokevirtual setEnableOKBtn : (I)V
    //   254: aload_0
    //   255: getfield C : Z
    //   258: iconst_1
    //   259: if_icmpne -> 401
    //   262: iconst_1
    //   263: istore #4
    //   265: aload_3
    //   266: iload #4
    //   268: invokevirtual setIsVibrate : (I)V
    //   271: aload_3
    //   272: aload_0
    //   273: getfield D : I
    //   276: invokevirtual setSecureWidth : (I)V
    //   279: aload_3
    //   280: aload_0
    //   281: getfield E : I
    //   284: invokevirtual setSecureHeight : (I)V
    //   287: aload_3
    //   288: aload_0
    //   289: getfield F : I
    //   292: invokevirtual setTitleDrawablePadding : (I)V
    //   295: aload_3
    //   296: aload_0
    //   297: getfield G : I
    //   300: invokevirtual setTitleColor : (I)V
    //   303: aload_3
    //   304: aload_0
    //   305: getfield H : I
    //   308: invokevirtual setTitleSize : (I)V
    //   311: aload_3
    //   312: aload_0
    //   313: getfield I : I
    //   316: invokevirtual setNumberKeyColor : (I)V
    //   319: aload_0
    //   320: getfield J : Landroid/graphics/Typeface;
    //   323: ifnull -> 337
    //   326: aload_3
    //   327: aload_0
    //   328: getfield J : Landroid/graphics/Typeface;
    //   331: invokevirtual getStyle : ()I
    //   334: invokevirtual setTitleFont : (I)V
    //   337: aload_3
    //   338: aload_0
    //   339: getfield K : Z
    //   342: invokevirtual setEnableLightStatusBar : (Z)V
    //   345: aload_0
    //   346: getfield b : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   349: aload_3
    //   350: aload_0
    //   351: getfield c : I
    //   354: aload_0
    //   355: getfield O : Lcom/unionpay/tsmservice/OnSafetyKeyboardCallback$Stub;
    //   358: aload_0
    //   359: getfield a : Landroid/content/Context;
    //   362: invokevirtual showSafetyKeyboard : (Lcom/unionpay/tsmservice/request/SafetyKeyboardRequestParams;ILcom/unionpay/tsmservice/OnSafetyKeyboardCallback;Landroid/content/Context;)I
    //   365: istore #4
    //   367: iload #4
    //   369: ifeq -> 427
    //   372: aload_0
    //   373: aconst_null
    //   374: putfield O : Lcom/unionpay/tsmservice/OnSafetyKeyboardCallback$Stub;
    //   377: iload_1
    //   378: istore_2
    //   379: aload_0
    //   380: monitorexit
    //   381: iload_2
    //   382: ireturn
    //   383: iconst_0
    //   384: istore #4
    //   386: goto -> 214
    //   389: iconst_0
    //   390: istore #4
    //   392: goto -> 231
    //   395: iconst_0
    //   396: istore #4
    //   398: goto -> 248
    //   401: iconst_0
    //   402: istore #4
    //   404: goto -> 265
    //   407: astore_3
    //   408: aload_3
    //   409: invokevirtual printStackTrace : ()V
    //   412: aload_0
    //   413: aconst_null
    //   414: putfield O : Lcom/unionpay/tsmservice/OnSafetyKeyboardCallback$Stub;
    //   417: iload_1
    //   418: istore_2
    //   419: goto -> 379
    //   422: astore_3
    //   423: aload_0
    //   424: monitorexit
    //   425: aload_3
    //   426: athrow
    //   427: iconst_1
    //   428: istore_2
    //   429: goto -> 379
    // Exception table:
    //   from	to	target	type
    //   6	27	422	finally
    //   27	211	407	android/os/RemoteException
    //   27	211	422	finally
    //   214	228	407	android/os/RemoteException
    //   214	228	422	finally
    //   231	245	407	android/os/RemoteException
    //   231	245	422	finally
    //   248	262	407	android/os/RemoteException
    //   248	262	422	finally
    //   265	337	407	android/os/RemoteException
    //   265	337	422	finally
    //   337	367	407	android/os/RemoteException
    //   337	367	422	finally
    //   372	377	422	finally
    //   408	417	422	finally
  }
  
  public static interface OnEditorListener {
    void onEditorChanged(int param1Int);
  }
  
  public static interface OnHideListener {
    void onHide();
  }
  
  public static interface OnShowListener {
    void onShow();
  }
  
  final class a extends OnSafetyKeyboardCallback.Stub {
    a(UPSaftyKeyboard this$0) {}
    
    public final void onEditorChanged(int param1Int) throws RemoteException {
      Message message = Message.obtain();
      message.what = 2;
      message.arg1 = param1Int;
      UPSaftyKeyboard.f(this.a).sendMessage(message);
    }
    
    public final void onHide() throws RemoteException {
      UPSaftyKeyboard.f(this.a).sendEmptyMessage(1);
    }
    
    public final void onShow() throws RemoteException {
      UPSaftyKeyboard.f(this.a).sendEmptyMessage(0);
    }
  }
  
  final class b extends FutureTask<String> {
    public b(UPSaftyKeyboard this$0) {
      super(new UPSaftyKeyboard$b$1(this$0));
    }
    
    private String a(TimeUnit param1TimeUnit) {
      try {
        return get(2000L, param1TimeUnit);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
        return "";
      } catch (ExecutionException executionException) {
        executionException.printStackTrace();
        return "";
      } catch (TimeoutException timeoutException) {
        timeoutException.printStackTrace();
        return "";
      } finally {
        cancel(true);
      } 
    }
    
    final class a extends ITsmCallback.Stub {
      a(UPSaftyKeyboard.b this$0) {}
      
      public final void onError(String param2String1, String param2String2) throws RemoteException {
        UPSaftyKeyboard.b.b(this.a, "");
      }
      
      public final void onResult(Bundle param2Bundle) throws RemoteException {
        param2Bundle.setClassLoader(GetEncryptDataResult.class.getClassLoader());
        String str = ((GetEncryptDataResult)param2Bundle.get("result")).getData();
        UPSaftyKeyboard.b.a(this.a, str);
      }
    }
  }
  
  final class a extends ITsmCallback.Stub {
    a(UPSaftyKeyboard this$0) {}
    
    public final void onError(String param1String1, String param1String2) throws RemoteException {
      UPSaftyKeyboard.b.b(this.a, "");
    }
    
    public final void onResult(Bundle param1Bundle) throws RemoteException {
      param1Bundle.setClassLoader(GetEncryptDataResult.class.getClassLoader());
      String str = ((GetEncryptDataResult)param1Bundle.get("result")).getData();
      UPSaftyKeyboard.b.a(this.a, str);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\widget\UPSaftyKeyboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
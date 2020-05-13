package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.Timer;

public final class b extends WebView implements Handler.Callback {
  private WebSettings a = null;
  
  private Handler b = null;
  
  private a c = null;
  
  private Timer d = new Timer();
  
  private boolean e = false;
  
  private ArrayList<String> f = null;
  
  public b(Context paramContext, a parama) {
    super(paramContext);
    this.b = new Handler(this);
    this.c = parama;
    setScrollBarStyle(33554432);
    this.a = getSettings();
    this.a.setJavaScriptEnabled(true);
    setWebChromeClient(new c((byte)0));
    setWebViewClient(new d((byte)0));
  }
  
  private final void a() {
    loadData(String.format("<div align=\"center\">%s</div>", new Object[] { "&#x7F51;&#x9875;&#x52A0;&#x8F7D;&#x5931;&#x8D25;&#xFF0C;&#x8BF7;&#x91CD;&#x8BD5;" }), "text/html", "utf-8");
  }
  
  public final void a(String paramString) {
    if (this.f == null)
      this.f = new ArrayList<String>(); 
    if (paramString != null && paramString.length() > 0)
      this.f.add(paramString); 
  }
  
  public final void b(String paramString) {
    Message message = this.b.obtainMessage(0);
    message.obj = paramString;
    this.b.sendMessage(message);
  }
  
  public final boolean handleMessage(Message paramMessage) {
    String str;
    switch (paramMessage.what) {
      default:
        return true;
      case 0:
        if (this.c != null)
          this.c.u(); 
        str = "";
        if (paramMessage.obj != null)
          str = (String)paramMessage.obj; 
        Log.e("uppay", "url = " + str);
        loadUrl(str);
      case 3:
        a();
      case 1:
      case 2:
        if (paramMessage.what == 1)
          this.e = true; 
        if (this.c != null)
          this.c.v(); 
      case 4:
        break;
    } 
    if (this.c != null && this.c instanceof b)
      ((b)this.c).c((String)paramMessage.obj); 
  }
  
  public static interface a {
    void u();
    
    void v();
  }
  
  public static interface b extends a {
    void c(String param1String);
  }
  
  private final class c extends WebChromeClient {
    private c(b this$0) {}
    
    public final void onProgressChanged(WebView param1WebView, int param1Int) {
      if (param1Int == 100)
        b.a(this.a).sendEmptyMessage(1); 
    }
  }
  
  private final class d extends WebViewClient {
    private d(b this$0) {}
    
    public final void onPageFinished(WebView param1WebView, String param1String) {
      super.onPageFinished(param1WebView, param1String);
      b.c(this.a).cancel();
      b.c(this.a).purge();
    }
    
    public final void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
      super.onPageStarted(param1WebView, param1String, param1Bitmap);
      b.a(this.a, new Timer());
      c c = new c(this);
      b.c(this.a).schedule(c, 30000L);
    }
    
    public final void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
      b.d(this.a);
    }
    
    public final boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   4: invokestatic e : (Lcom/unionpay/mobile/android/upviews/b;)Ljava/util/ArrayList;
      //   7: ifnull -> 23
      //   10: aload_0
      //   11: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   14: invokestatic e : (Lcom/unionpay/mobile/android/upviews/b;)Ljava/util/ArrayList;
      //   17: invokevirtual size : ()I
      //   20: ifne -> 60
      //   23: aconst_null
      //   24: astore_3
      //   25: aload_3
      //   26: ifnull -> 146
      //   29: aload_0
      //   30: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   33: invokestatic a : (Lcom/unionpay/mobile/android/upviews/b;)Landroid/os/Handler;
      //   36: iconst_4
      //   37: invokevirtual obtainMessage : (I)Landroid/os/Message;
      //   40: astore_1
      //   41: aload_1
      //   42: aload_2
      //   43: putfield obj : Ljava/lang/Object;
      //   46: aload_0
      //   47: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   50: invokestatic a : (Lcom/unionpay/mobile/android/upviews/b;)Landroid/os/Handler;
      //   53: aload_1
      //   54: invokevirtual sendMessage : (Landroid/os/Message;)Z
      //   57: pop
      //   58: iconst_1
      //   59: ireturn
      //   60: aload_2
      //   61: ifnull -> 154
      //   64: aload_2
      //   65: invokevirtual length : ()I
      //   68: ifle -> 154
      //   71: iconst_0
      //   72: istore #4
      //   74: aload_0
      //   75: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   78: invokestatic e : (Lcom/unionpay/mobile/android/upviews/b;)Ljava/util/ArrayList;
      //   81: ifnull -> 154
      //   84: iload #4
      //   86: aload_0
      //   87: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   90: invokestatic e : (Lcom/unionpay/mobile/android/upviews/b;)Ljava/util/ArrayList;
      //   93: invokevirtual size : ()I
      //   96: if_icmpge -> 154
      //   99: aload_2
      //   100: aload_0
      //   101: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   104: invokestatic e : (Lcom/unionpay/mobile/android/upviews/b;)Ljava/util/ArrayList;
      //   107: iload #4
      //   109: invokevirtual get : (I)Ljava/lang/Object;
      //   112: checkcast java/lang/String
      //   115: invokevirtual startsWith : (Ljava/lang/String;)Z
      //   118: ifeq -> 140
      //   121: aload_0
      //   122: getfield a : Lcom/unionpay/mobile/android/upviews/b;
      //   125: invokestatic e : (Lcom/unionpay/mobile/android/upviews/b;)Ljava/util/ArrayList;
      //   128: iload #4
      //   130: invokevirtual get : (I)Ljava/lang/Object;
      //   133: checkcast java/lang/String
      //   136: astore_3
      //   137: goto -> 25
      //   140: iinc #4, 1
      //   143: goto -> 74
      //   146: aload_1
      //   147: aload_2
      //   148: invokevirtual loadUrl : (Ljava/lang/String;)V
      //   151: goto -> 58
      //   154: aconst_null
      //   155: astore_3
      //   156: goto -> 25
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upviews\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
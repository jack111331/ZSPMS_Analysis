package com.xy.whf.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import com.xy.whf.helper.LangHelper;

public class TipToast {
  public static void showToast(Context paramContext, String paramString) {
    showToast(paramContext, paramString, 2000);
  }
  
  private static void showToast(Context paramContext, String paramString, int paramInt) {
    if (!LangHelper.isNullOrEmpty(paramString))
      try {
        Toast[] arrayOfToast = new Toast[1];
        arrayOfToast[0] = null;
        Handler handler = new Handler();
        this(Looper.getMainLooper());
        Runnable runnable2 = new Runnable() {
            public void run() {
              toast[0] = new Toast(context);
              ToastView toastView = new ToastView(context);
              toastView.getMsgTv().setText(str);
              toast[0].setView((View)toastView);
              toast[0].setGravity(17, 0, 0);
              toast[0].show();
            }
          };
        super(arrayOfToast, paramContext, paramString);
        handler.post(runnable2);
        Runnable runnable1 = new Runnable() {
            public void run() {
              if (!LangHelper.isNullOrEmpty((Object[])toast))
                toast[0].cancel(); 
            }
          };
        super(arrayOfToast);
        handler.postDelayed(runnable1, paramInt);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\widget\TipToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
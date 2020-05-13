package com.xy.whf.pay;

import android.app.Activity;
import android.content.Context;
import com.xy.whf.entity.StatusCode;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.http.HttpHelper;
import com.xy.whf.http.ResponseListener;
import org.json.JSONObject;

public class WhfPay {
  private static WhfPay INSTANCE;
  
  private static boolean isInitialized = false;
  
  private void ext(Context paramContext) {
    try {
      HttpHelper.getInstance(paramContext).appStart();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static WhfPay getInstance() {
    if (INSTANCE == null)
      INSTANCE = new WhfPay(); 
    return INSTANCE;
  }
  
  public void initial(Context paramContext) {
    isInitialized = true;
    ext(paramContext);
  }
  
  public void whfPay(Activity paramActivity, String paramString1, String paramString2, ResultListener paramResultListener) {
    if (isInitialized && paramResultListener != null)
      try {
        if (LangHelper.isNullOrEmpty(paramString2)) {
          paramResultListener.result(StatusCode.FAILED_3003.getCode(), StatusCode.FAILED_3003.getMessage());
          return;
        } 
        HttpHelper httpHelper = HttpHelper.getInstance((Context)paramActivity);
        ResponseListener responseListener = new ResponseListener() {
            public void result(StatusCode param1StatusCode, String param1String) {
              if (param1StatusCode == StatusCode.SUCCESS_0 && !LangHelper.isNullOrEmpty(param1String)) {
                try {
                  JSONObject jSONObject = new JSONObject();
                  this(param1String);
                  String str = jSONObject.getString("goUrl");
                  PayActivity.startPay(this.a, str, this.b, this.c);
                } catch (Exception exception) {
                  exception.printStackTrace();
                } 
                return;
              } 
              this.c.result(StatusCode.FAILED_NEGATIVE_1.getCode(), StatusCode.FAILED_NEGATIVE_1.getMessage());
            }
          };
        super(this, paramActivity, paramString2, paramResultListener);
        httpHelper.whfPay(paramString1, paramString2, responseListener);
      } catch (Exception exception) {
        exception.printStackTrace();
        paramResultListener.result(StatusCode.FAILED_NEGATIVE_1.getCode(), StatusCode.FAILED_NEGATIVE_1.getMessage());
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\pay\WhfPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
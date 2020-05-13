package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.open.a.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UIListenerManager {
  private static UIListenerManager a = null;
  
  private Map<String, ApiTask> b = Collections.synchronizedMap(new HashMap<String, ApiTask>());
  
  private UIListenerManager() {
    if (this.b == null)
      this.b = Collections.synchronizedMap(new HashMap<String, ApiTask>()); 
  }
  
  private IUiListener a(int paramInt, IUiListener paramIUiListener) {
    if (paramInt == 11101) {
      f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
      return paramIUiListener;
    } 
    if (paramInt == 11105) {
      f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
      return paramIUiListener;
    } 
    if (paramInt == 11106)
      f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在"); 
    return paramIUiListener;
  }
  
  public static UIListenerManager getInstance() {
    if (a == null)
      a = new UIListenerManager(); 
    return a;
  }
  
  public IUiListener getListnerWithAction(String paramString) {
    ApiTask apiTask;
    if (paramString == null) {
      f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
      return null;
    } 
    synchronized (this.b) {
      apiTask = this.b.get(paramString);
      this.b.remove(paramString);
      if (apiTask == null)
        return null; 
    } 
    return apiTask.mListener;
  }
  
  public IUiListener getListnerWithRequestCode(int paramInt) {
    String str = g.a(paramInt);
    if (str == null) {
      f.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + paramInt);
      return null;
    } 
    return getListnerWithAction(str);
  }
  
  public void handleDataToListener(Intent paramIntent, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.UIListenerManager", "handleDataToListener");
    if (paramIntent == null) {
      paramIUiListener.onCancel();
      return;
    } 
    String str = paramIntent.getStringExtra("key_action");
    if ("action_login".equals(str)) {
      int i = paramIntent.getIntExtra("key_error_code", 0);
      if (i == 0) {
        str = paramIntent.getStringExtra("key_response");
        if (str != null) {
          try {
            paramIUiListener.onComplete(i.d(str));
          } catch (JSONException jSONException) {
            paramIUiListener.onError(new UiError(-4, "服务器返回数据格式有误!", str));
            f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", (Throwable)jSONException);
          } 
          return;
        } 
        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
        paramIUiListener.onComplete(new JSONObject());
        return;
      } 
      f.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + i + "");
      paramIUiListener.onError(new UiError(i, jSONException.getStringExtra("key_error_msg"), jSONException.getStringExtra("key_error_detail")));
      return;
    } 
    if ("action_share".equals(str)) {
      String str1 = jSONException.getStringExtra("result");
      str = jSONException.getStringExtra("response");
      if ("cancel".equals(str1)) {
        paramIUiListener.onCancel();
        return;
      } 
      if ("error".equals(str1)) {
        paramIUiListener.onError(new UiError(-6, "unknown error", str + ""));
        return;
      } 
      if ("complete".equals(str1))
        try {
          String str2;
          JSONObject jSONObject = new JSONObject();
          if (str == null) {
            str2 = "{\"ret\": 0}";
          } else {
            str2 = str;
          } 
          this(str2);
          paramIUiListener.onComplete(jSONObject);
        } catch (JSONException jSONException1) {
          jSONException1.printStackTrace();
          paramIUiListener.onError(new UiError(-4, "json error", str + ""));
        }  
    } 
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, IUiListener paramIUiListener) {
    boolean bool = false;
    f.c("openSDK_LOG.UIListenerManager", "onActivityResult req=" + paramInt1 + " res=" + paramInt2);
    IUiListener iUiListener = getListnerWithRequestCode(paramInt1);
    if (iUiListener == null) {
      if (paramIUiListener != null) {
        paramIUiListener = a(paramInt1, paramIUiListener);
      } else {
        f.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
        return bool;
      } 
    } else {
      paramIUiListener = iUiListener;
    } 
    if (paramInt2 == -1) {
      if (paramIntent == null) {
        paramIUiListener.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
        return true;
      } 
      String str = paramIntent.getStringExtra("key_action");
      if ("action_login".equals(str)) {
        paramInt1 = paramIntent.getIntExtra("key_error_code", 0);
        if (paramInt1 == 0) {
          str = paramIntent.getStringExtra("key_response");
          if (str != null) {
            try {
              paramIUiListener.onComplete(i.d(str));
              bool = true;
            } catch (JSONException jSONException) {
              paramIUiListener.onError(new UiError(-4, "服务器返回数据格式有误!", str));
              f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", (Throwable)jSONException);
            } 
            return bool;
          } 
          f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
          paramIUiListener.onComplete(new JSONObject());
        } else {
          f.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + paramInt1 + "");
          paramIUiListener.onError(new UiError(paramInt1, jSONException.getStringExtra("key_error_msg"), jSONException.getStringExtra("key_error_detail")));
        } 
      } else if ("action_share".equals(str)) {
        String str1 = jSONException.getStringExtra("result");
        str = jSONException.getStringExtra("response");
        if ("cancel".equals(str1)) {
          paramIUiListener.onCancel();
        } else if ("error".equals(str1)) {
          paramIUiListener.onError(new UiError(-6, "unknown error", str + ""));
        } else if ("complete".equals(str1)) {
          try {
            String str2;
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
              str2 = "{\"ret\": 0}";
            } else {
              str2 = str;
            } 
            this(str2);
            paramIUiListener.onComplete(jSONObject);
          } catch (JSONException jSONException1) {
            jSONException1.printStackTrace();
            paramIUiListener.onError(new UiError(-4, "json error", str + ""));
          } 
        } 
      } else {
        paramInt1 = jSONException1.getIntExtra("key_error_code", 0);
        if (paramInt1 == 0) {
          str = jSONException1.getStringExtra("key_response");
          if (str != null) {
            try {
              paramIUiListener.onComplete(i.d(str));
            } catch (JSONException jSONException2) {
              paramIUiListener.onError(new UiError(-4, "服务器返回数据格式有误!", str));
            } 
          } else {
            paramIUiListener.onComplete(new JSONObject());
          } 
        } else {
          paramIUiListener.onError(new UiError(paramInt1, jSONException2.getStringExtra("key_error_msg"), jSONException2.getStringExtra("key_error_detail")));
        } 
      } 
    } else {
      paramIUiListener.onCancel();
    } 
    bool = true;
  }
  
  public Object setListenerWithRequestcode(int paramInt, IUiListener paramIUiListener) {
    String str = g.a(paramInt);
    if (str == null) {
      f.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + paramInt);
      return null;
    } 
    synchronized (this.b) {
      Map<String, ApiTask> map = this.b;
      ApiTask apiTask2 = new ApiTask();
      this(this, paramInt, paramIUiListener);
      ApiTask apiTask1 = map.put(str, apiTask2);
      if (apiTask1 == null)
        return null; 
    } 
    return ((ApiTask)paramIUiListener).mListener;
  }
  
  public Object setListnerWithAction(String paramString, IUiListener paramIUiListener) {
    int i = g.a(paramString);
    if (i == -1) {
      f.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + paramString);
      return null;
    } 
    synchronized (this.b) {
      Map<String, ApiTask> map = this.b;
      ApiTask apiTask2 = new ApiTask();
      this(this, i, paramIUiListener);
      ApiTask apiTask1 = map.put(paramString, apiTask2);
      if (apiTask1 == null)
        return null; 
    } 
    return ((ApiTask)paramString).mListener;
  }
  
  public class ApiTask {
    public IUiListener mListener;
    
    public int mRequestCode;
    
    public ApiTask(UIListenerManager this$0, int param1Int, IUiListener param1IUiListener) {
      this.mRequestCode = param1Int;
      this.mListener = param1IUiListener;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\common\UIListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
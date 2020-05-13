package com.yingxiong.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.yingxiong.until.MLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventRuleCheck {
  private static final String TAG = "RecordSDK";
  
  private static EventRuleCheck mInstance;
  
  private Map<String, ArrayList<String>> otherValueMap = new HashMap<String, ArrayList<String>>();
  
  private EventRuleCheck() {
    init();
  }
  
  private String commonOtherValueCheck(String paramString, ArrayList<String> paramArrayList) {
    for (byte b = 0; b < paramArrayList.size(); b++) {
      if (!paramString.contains(((String)paramArrayList.get(b)).trim()))
        return paramArrayList.get(b); 
    } 
    return null;
  }
  
  private String commonValueCheck(String paramString) {
    for (byte b = 0; b < EventListUtils.commonList.size(); b++) {
      if (!paramString.contains(((String)EventListUtils.commonList.get(b)).trim()))
        return EventListUtils.commonList.get(b); 
    } 
    return null;
  }
  
  public static EventRuleCheck getInstance() {
    if (mInstance == null && mInstance == null)
      mInstance = new EventRuleCheck(); 
    return mInstance;
  }
  
  private void init() {
    if (this.otherValueMap.isEmpty()) {
      this.otherValueMap.put("20001", EventListUtils.v_open_game_list);
      this.otherValueMap.put("20002", EventListUtils.v_update_game_list);
      this.otherValueMap.put("20003", EventListUtils.v_sdk_login_list);
      this.otherValueMap.put("20004", EventListUtils.v_service_state_list);
      this.otherValueMap.put("20005", EventListUtils.v_wait_state_list);
      this.otherValueMap.put("20006", EventListUtils.v_creat_role_list);
      this.otherValueMap.put("20007", EventListUtils.v_role_login_list);
      this.otherValueMap.put("20008", EventListUtils.v_userInfo_list);
      this.otherValueMap.put("20009", EventListUtils.v_into_game_list);
      this.otherValueMap.put("20010", EventListUtils.v_award_button_click_list);
      this.otherValueMap.put("20011", EventListUtils.v_create_order_list);
      this.otherValueMap.put("20012", EventListUtils.v_user_guide_list);
      this.otherValueMap.put("20020", EventListUtils.v_page_do_list);
      this.otherValueMap.put("20013", EventListUtils.game_first_page_list);
      this.otherValueMap.put("20014", EventListUtils.after_sdklogin_page_list);
    } 
  }
  
  private String otherValueCheck(String paramString) {
    String str = JSON.parseObject(paramString).getString("event_id");
    return TextUtils.isEmpty(str) ? null : ((this.otherValueMap.get(str.trim()) != null) ? commonOtherValueCheck(paramString, this.otherValueMap.get(str.trim())) : null);
  }
  
  public boolean checkString(String paramString) throws Exception {
    StringBuilder stringBuilder1;
    String str = commonValueCheck(paramString);
    if (str == null) {
      String str1 = otherValueCheck(paramString);
      if (str1 != null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("事件参数");
        stringBuilder1.append(str1);
        stringBuilder1.append("未定义，忽略该条上报，请添加\n");
        stringBuilder1.append("错误事件日志：");
        stringBuilder1.append(paramString);
        MLog.e("RecordSDK", stringBuilder1.toString());
        return false;
      } 
      return true;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("公共参数");
    stringBuilder2.append((String)stringBuilder1);
    stringBuilder2.append("未定义，忽略该条上报，请添加\n");
    stringBuilder2.append("错误事件日志：");
    stringBuilder2.append(paramString);
    MLog.e("RecordSDK", stringBuilder2.toString());
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\common\EventRuleCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
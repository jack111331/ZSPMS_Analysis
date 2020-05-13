package com.yingxiong.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventListUtils {
  public static ArrayList<String> after_sdklogin_page_list;
  
  public static List<String> commonList = new ArrayList<String>(Arrays.asList(new String[] { "server_id", "user_id", "role_id", "role_key" }));
  
  public static ArrayList<String> game_first_page_list;
  
  public static ArrayList<String> v_award_button_click_list;
  
  public static ArrayList<String> v_creat_role_list;
  
  public static ArrayList<String> v_create_order_list;
  
  public static ArrayList<String> v_into_game_list;
  
  public static ArrayList<String> v_open_game_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "event_name" }));
  
  public static ArrayList<String> v_page_do_list;
  
  public static ArrayList<String> v_role_login_list;
  
  public static ArrayList<String> v_sdk_login_list;
  
  public static ArrayList<String> v_service_state_list;
  
  public static ArrayList<String> v_update_game_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "update_id", "update_state", "duration_time", "event_name" }));
  
  public static ArrayList<String> v_userInfo_list;
  
  public static ArrayList<String> v_user_guide_list;
  
  public static ArrayList<String> v_wait_state_list;
  
  static {
    v_sdk_login_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "login_state", "event_name" }));
    v_service_state_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "sl_server_id", "service_state", "event_name" }));
    v_wait_state_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "sl_server_id", "waiting_state", "event_name" }));
    v_creat_role_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "creat_role_state", "creat_fail_reason", "event_name" }));
    v_role_login_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "role_login_state", "role_login_reason", "event_name" }));
    v_userInfo_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "role_name", "role_level", "vip_level", "phy_balance", "currency_info", "event_name" }));
    v_into_game_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "duration_time", "event_name" }));
    v_award_button_click_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "taskid", "get_award_state", "event_name" }));
    v_create_order_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "product_id", "product_type", "order_create_time", "game_order_id", "event_name" }));
    v_user_guide_list = new ArrayList<String>(Arrays.asList(new String[] { "guide_id", "guide_num", "event_id", "event_name" }));
    game_first_page_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "event_name" }));
    after_sdklogin_page_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "event_name" }));
    v_page_do_list = new ArrayList<String>(Arrays.asList(new String[] { "event_id", "leave_page_id", "arrive_page_id", "leave_page_name", "arrive_page_name", "operate_way", "event_name" }));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\common\EventListUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
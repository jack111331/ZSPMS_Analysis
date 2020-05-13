package com.herosdk.common;

public enum PluginStatus {
  EXIT_FAILED, EXIT_SUCCESS, INIT_FAILED, INIT_SUCCESS, LOGIN_CANCEL, LOGIN_FAILED, LOGIN_SUCCESS, LOGOUT_FAILED, LOGOUT_SUCCESS, PAY_CANCEL, PAY_FAILED, PAY_SUCCESS;
  
  static {
    INIT_FAILED = new PluginStatus("INIT_FAILED", 1);
    LOGIN_SUCCESS = new PluginStatus("LOGIN_SUCCESS", 2);
    LOGIN_CANCEL = new PluginStatus("LOGIN_CANCEL", 3);
    LOGIN_FAILED = new PluginStatus("LOGIN_FAILED", 4);
    LOGOUT_SUCCESS = new PluginStatus("LOGOUT_SUCCESS", 5);
    LOGOUT_FAILED = new PluginStatus("LOGOUT_FAILED", 6);
    PAY_SUCCESS = new PluginStatus("PAY_SUCCESS", 7);
    PAY_CANCEL = new PluginStatus("PAY_CANCEL", 8);
    PAY_FAILED = new PluginStatus("PAY_FAILED", 9);
    EXIT_SUCCESS = new PluginStatus("EXIT_SUCCESS", 10);
    EXIT_FAILED = new PluginStatus("EXIT_FAILED", 11);
    $VALUES = new PluginStatus[] { 
        INIT_SUCCESS, INIT_FAILED, LOGIN_SUCCESS, LOGIN_CANCEL, LOGIN_FAILED, LOGOUT_SUCCESS, LOGOUT_FAILED, PAY_SUCCESS, PAY_CANCEL, PAY_FAILED, 
        EXIT_SUCCESS, EXIT_FAILED };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\common\PluginStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.unionpay.tsmservice.data;

import android.text.TextUtils;

public class ResultCode {
  public static final String ERROR_DETAIL_ACTIVATE_VENDOR_PAY_FAIL = "0034";
  
  public static final String ERROR_DETAIL_ADD_CARD_APPLY_FAIL = "0026";
  
  public static final String ERROR_DETAIL_ADD_CARD_OTHER_FAIL = "0028";
  
  public static final String ERROR_DETAIL_ADD_CARD_TSM_FAIL = "0027";
  
  public static final String ERROR_DETAIL_CASHLOAD_CANCEL = "0017";
  
  public static final String ERROR_DETAIL_CASHLOAD_FAIL = "0016";
  
  public static final String ERROR_DETAIL_DEFAULT = "0000";
  
  public static final String ERROR_DETAIL_FORCE_UPDATE = "0019";
  
  public static final String ERROR_DETAIL_GETCARDINFO_SPAY_CANCLE = "0020";
  
  public static final String ERROR_DETAIL_GETCARDINFO_SPAY_FAIL = "0018";
  
  public static final String ERROR_DETAIL_ILLEGAL_CHANNEL = "0013";
  
  public static final String ERROR_DETAIL_INITIALIZE_SSAMSUNGPAY_FAIL = "0021";
  
  public static final String ERROR_DETAIL_NETWORK = "0001";
  
  public static final String ERROR_DETAIL_NFC_NOT_ENABLE = "0009";
  
  public static final String ERROR_DETAIL_NOT_SUPPORT = "0004";
  
  public static final String ERROR_DETAIL_NO_AVAILABLE_CHANNEL = "0014";
  
  public static final String ERROR_DETAIL_NO_DEFAULT_CARD = "0022";
  
  public static final String ERROR_DETAIL_NO_PERMISSION = "0003";
  
  public static final String ERROR_DETAIL_ONLINE_PAYMENT_AID_MISMATCH = "0031";
  
  public static final String ERROR_DETAIL_ONLINE_PAYMENT_CANCEL = "0029";
  
  public static final String ERROR_DETAIL_ONLINE_PAYMENT_OTHER_FAIL = "0032";
  
  public static final String ERROR_DETAIL_ONLINE_PAYMENT_TIMEOUT = "0030";
  
  public static final String ERROR_DETAIL_PREDOWNLOAD_FAIL = "0033";
  
  public static final String ERROR_DETAIL_SE_BUSY = "0012";
  
  public static final String ERROR_DETAIL_SE_SERVICE_CONNTECT = "0010";
  
  public static final String ERROR_DETAIL_SIGNATURE_INVALID = "0015";
  
  public static final String ERROR_DETAIL_SKMS_AGENT_ERROR = "0008";
  
  public static final String ERROR_DETAIL_SKMS_AGENT_MUST_UPDATE = "0007";
  
  public static final String ERROR_DETAIL_SKMS_AGENT_NEED_UPDATE = "0006";
  
  public static final String ERROR_DETAIL_SKMS_AGENT_NOT_INSTALL = "0005";
  
  public static final String ERROR_DETAIL_TRANSMIT_APDU = "0011";
  
  public static final String ERROR_DETAIL_UNKNOWN_HOST = "0002";
  
  public static final String ERROR_DETAIL_VENDOR_STATUS_NOT_INSTALL = "0035";
  
  public static final String ERROR_DETAIL_VENDOR_STATUS_NOT_READY = "0023";
  
  public static final String ERROR_DETAIL_VENDOR_STATUS_NOT_SUPPORTED = "0024";
  
  public static final String ERROR_DETAIL_VENDOR_STATUS_OTHER_FAIL = "0025";
  
  public static final String ERROR_DOWNLOAD_FILE = "10004";
  
  public static final String ERROR_INTERFACE_ACTIVATE_VENDOR_PAY = "10041";
  
  public static final String ERROR_INTERFACE_ADD_CARD_TO_VENDOR_PAY = "10038";
  
  public static final String ERROR_INTERFACE_APP_DATA_UPDATE = "10015";
  
  public static final String ERROR_INTERFACE_APP_DELETE = "10014";
  
  public static final String ERROR_INTERFACE_APP_DOWNLOAD = "10013";
  
  public static final String ERROR_INTERFACE_APP_DOWNLOAD_APPLY = "10012";
  
  public static final String ERROR_INTERFACE_APP_LOCK = "10016";
  
  public static final String ERROR_INTERFACE_APP_UNLOCK = "10017";
  
  public static final String ERROR_INTERFACE_CHECK_SSAMSUNGPAY = "10032";
  
  public static final String ERROR_INTERFACE_CLOSE_CHANNEL = "10029";
  
  public static final String ERROR_INTERFACE_ECASH_TOPUP = "10020";
  
  public static final String ERROR_INTERFACE_ENCRYPT_DATA = "10004";
  
  public static final String ERROR_INTERFACE_EXCHANGE_KEY = "10003";
  
  public static final String ERROR_INTERFACE_EXECUTE_CMD = "10030";
  
  public static final String ERROR_INTERFACE_GET_ACCOUNT_BALANCE = "10023";
  
  public static final String ERROR_INTERFACE_GET_ACCOUNT_INFO = "10022";
  
  public static final String ERROR_INTERFACE_GET_APP_DETAIL = "10010";
  
  public static final String ERROR_INTERFACE_GET_APP_LIST = "10008";
  
  public static final String ERROR_INTERFACE_GET_APP_STATUS = "10009";
  
  public static final String ERROR_INTERFACE_GET_ASSOCIATED_APP = "10006";
  
  public static final String ERROR_INTERFACE_GET_CARDINFO_BY_SAMSUNGPAY = "10031";
  
  public static final String ERROR_INTERFACE_GET_CARD_INFO = "10024";
  
  public static final String ERROR_INTERFACE_GET_DEFAULT_CARD = "10026";
  
  public static final String ERROR_INTERFACE_GET_ENCRYPT_DATA = "10036";
  
  public static final String ERROR_INTERFACE_GET_PUBLIC_KEY = "10002";
  
  public static final String ERROR_INTERFACE_GET_SE_APP_LIST = "10007";
  
  public static final String ERROR_INTERFACE_GET_SE_ID = "10005";
  
  public static final String ERROR_INTERFACE_GET_SMS_AUTH_CODE = "10019";
  
  public static final String ERROR_INTERFACE_GET_TRANS_ELEMENTS = "10011";
  
  public static final String ERROR_INTERFACE_GET_TRANS_RECORD = "10021";
  
  public static final String ERROR_INTERFACE_GET_VENDOR_PAY_STATUS = "10037";
  
  public static final String ERROR_INTERFACE_HIDE_APP_APPLY = "10018";
  
  public static final String ERROR_INTERFACE_INIT = "10001";
  
  public static final String ERROR_INTERFACE_ONLINE_PAYMENT_VERIFY = "10039";
  
  public static final String ERROR_INTERFACE_OPEN_CHANNEL = "10027";
  
  public static final String ERROR_INTERFACE_PREDOWNLOAD = "10040";
  
  public static final String ERROR_INTERFACE_QUERY_VENDOR_PAY_STATUS = "10042";
  
  public static final String ERROR_INTERFACE_RESULT_DECRYPT_FAIL = "10035";
  
  public static final String ERROR_INTERFACE_RESULT_ENCRYPT_FAIL = "10034";
  
  public static final String ERROR_INTERFACE_SEND_APDU = "10028";
  
  public static final String ERROR_INTERFACE_SET_DEFAULT_CARD = "10025";
  
  public static final String ERROR_INTERFACE_SET_SAMSUNG_DEFAULT_WALLET = "10033";
  
  public static final String ERROR_LOCAL_BEGIN = "10000";
  
  public static final String ERROR_NETWORK = "10001";
  
  public static final String ERROR_RESPONSE_FORMAT = "10002";
  
  public static final String ERROR_SOURCE_ADDON = "0";
  
  public static final String ERROR_SOURCE_TSM = "1";
  
  public static final String ERROR_STORAGE_NOT_ENOUGHT = "10003";
  
  public static final String SUCCESS = "10000";
  
  public static String getResultCode(String paramString) {
    return !TextUtils.isEmpty(paramString) ? ("0000".equals(paramString) ? "" : ("10001".equals(paramString) ? "00001" : ("10017".equals(paramString) ? "00004" : ("10019".equals(paramString) ? "00005" : ("10022".equals(paramString) ? "00006" : ("10023".equals(paramString) ? "00007" : ("10018".equals(paramString) ? "00008" : ("10024".equals(paramString) ? "00009" : ("10021".equals(paramString) ? "00010" : ("10020".equals(paramString) ? "00011" : ("10028".equals(paramString) ? "00012" : ("10004".equals(paramString) ? "00001" : ("10010".equals(paramString) ? "00001" : ("10016".equals(paramString) ? "00001" : ("10027".equals(paramString) ? "00033" : ("10029".equals(paramString) ? "00023" : ("10030".equals(paramString) ? "00024" : ("10031".equals(paramString) ? "00035" : ("10032".equals(paramString) ? "00025" : ("10033".equals(paramString) ? "00034" : ("10034".equals(paramString) ? "00029" : ("10035".equals(paramString) ? "00030" : ("10036".equals(paramString) ? "00032" : ("10037".equals(paramString) ? "00026" : ("10038".equals(paramString) ? "00027" : ("10039".equals(paramString) ? "00028" : ("1" + paramString))))))))))))))))))))))))))) : "00000";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\ResultCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
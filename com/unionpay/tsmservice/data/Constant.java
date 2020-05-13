package com.unionpay.tsmservice.data;

public class Constant {
  public static final String APK_VERSION_010012 = "01.00.12";
  
  public static final String APK_VERSION_010016 = "01.00.16";
  
  public static final String APK_VERSION_010017 = "01.00.17";
  
  public static final String APK_VERSION_010018 = "01.00.18";
  
  public static final String APPLY_MODE_BIND_CARD = "1";
  
  public static final String APPLY_MODE_DECIDED_BY_BANK = "3";
  
  public static final String APPLY_MODE_DECIDED_BY_USER = "2";
  
  public static final String APPLY_MODE_NEW_CARD = "0";
  
  public static final String APPLY_TYPE_BIND = "1";
  
  public static final String APPLY_TYPE_DECIDED_BY_BANK = "0";
  
  public static final String APPLY_TYPE_NEW = "2";
  
  public static final int APP_CALLER = 1;
  
  public static final String APP_PUBLISH_STATUS_COMMERCIAL = "00";
  
  public static final String APP_PUBLISH_STATUS_OFF_SHELF = "02";
  
  public static final String APP_PUBLISH_STATUS_PRODUCT_VERIFY = "01";
  
  public static final int BOARD_BUTTON_COUNT = 12;
  
  public static final String CARD_TYPE_CREDIT = "CREDIT";
  
  public static final String CARD_TYPE_DEBIT = "DEBIT";
  
  public static final String CASH_LOAD_CANCEL = "cancel";
  
  public static final String CASH_LOAD_FAIL = "fail";
  
  public static final String CASH_LOAD_SUCCESS = "success";
  
  public static final int COLUMNSOFKEYBOARD = 3;
  
  public static final int CONFIRM_BUTTON_ITEM_ID = 10;
  
  public static final String DEFAULT_BALANCE = "000000000000";
  
  public static final String DEFAULT_CVN2 = "000";
  
  public static final String DEFAULT_EXPIRY_DATA = "0000";
  
  public static final String DEFAULT_PAN = "6288888888888888";
  
  public static final int DELETE_BUTTON_ITEM_ID = 20;
  
  public static final int DES3_ECB_EDE = 1;
  
  public static final int DES3_ECB_EDE3 = 2;
  
  public static final int ERROR_CALLER = 0;
  
  public static final int ERROR_GET_CALLER_FAILED = -5;
  
  public static final int ERROR_JAR_TOO_LOW = -9;
  
  public static final int ERROR_NOT_SUPPORT = -6;
  
  public static final String ERROR_NO_DEFAULT_CARD = "6A88";
  
  public static final int ERROR_PARAMS_INVALID = -3;
  
  public static final int ERROR_REPEATED_CALLS = -7;
  
  public static final int ERROR_SESSION_KEY_INVALID = -2;
  
  public static final int ERROR_TSM_NOT_CONNECTED = -1;
  
  public static final int ERROR_TSM_NOT_INIT = -4;
  
  public static final int ERROR_VERSION_INCOMPATIBLE = -8;
  
  public static final String FUNCTION_APP_DELETE = "appDelete";
  
  public static final String FUNCTION_CLOSE_CHANNEL = "closeChannel";
  
  public static final String FUNCTION_GET_ACCOUNT_INFO = "getAccountInfo";
  
  public static final String FUNCTION_GET_CARDINFO_BY_SAMSUNGPAY = "getCardInfoBySamsungPay";
  
  public static final String FUNCTION_SEAPPLIST = "seAppList";
  
  public static final int INTERFACE_ACTIVATE_VENDOR_PAY = 37;
  
  public static final int INTERFACE_ADD_CARD_TO_VENDOR_PAY = 38;
  
  public static final int INTERFACE_APP_DATA_UPDATE = 18;
  
  public static final int INTERFACE_APP_DELETE = 17;
  
  public static final int INTERFACE_APP_DOWNLOAD = 16;
  
  public static final int INTERFACE_APP_DOWNLOAD_APPLY = 15;
  
  public static final int INTERFACE_APP_LOCK = 26;
  
  public static final int INTERFACE_APP_UNLOCK = 27;
  
  public static final int INTERFACE_CARDLIST_STATUS_CHANGED = 35;
  
  public static final int INTERFACE_CHECK_SSAMSUNGPAY = 29;
  
  public static final int INTERFACE_CLEAR_ENCRYPTDATA = 33;
  
  public static final int INTERFACE_CLOSE_CHANNEL = 21;
  
  public static final int INTERFACE_DEFAULT = -1;
  
  public static final int INTERFACE_ECASH_TOPUP = 19;
  
  public static final int INTERFACE_ENCRYPT_DATA = 23;
  
  public static final int INTERFACE_EXECUTE_CMD = 25;
  
  public static final int INTERFACE_GET_ACCOUNT_BALANCE = 8;
  
  public static final int INTERFACE_GET_ACCOUNT_INFO = 7;
  
  public static final int INTERFACE_GET_APP_DETAIL = 4;
  
  public static final int INTERFACE_GET_APP_LIST = 2;
  
  public static final int INTERFACE_GET_APP_STATUS = 5;
  
  public static final int INTERFACE_GET_ASSOCIATED_APP = 1;
  
  public static final int INTERFACE_GET_CARDINFO_BY_SAMSUNGPAY = 28;
  
  public static final int INTERFACE_GET_CARD_INFO = 6;
  
  public static final int INTERFACE_GET_DEFAULT_CARD = 13;
  
  public static final int INTERFACE_GET_ENCRYPT_DATA = 31;
  
  public static final int INTERFACE_GET_SE_APP_LIST = 3;
  
  public static final int INTERFACE_GET_SE_ID = 12;
  
  public static final int INTERFACE_GET_SMS_AUTH_CODE = 11;
  
  public static final int INTERFACE_GET_TRANS_ELEMENTS = 9;
  
  public static final int INTERFACE_GET_TRANS_RECORD = 10;
  
  public static final int INTERFACE_GET_VENDOR_PAY_STATUS = 36;
  
  public static final int INTERFACE_HIDE_APP_APPLY = 24;
  
  public static final int INTERFACE_HIDE_KEYBOARD = 34;
  
  public static final int INTERFACE_INIT = 0;
  
  public static final int INTERFACE_ONLINE_PAYMENT_VERIFY = 39;
  
  public static final int INTERFACE_OPEN_CHANNEL = 20;
  
  public static final int INTERFACE_PREDOWNLOAD = 40;
  
  public static final int INTERFACE_QUERY_VENDOR_PAY_STATUS = 41;
  
  public static final int INTERFACE_SEND_APDU = 22;
  
  public static final int INTERFACE_SET_DEFAULT_CARD = 14;
  
  public static final int INTERFACE_SET_SAFETYKEYBOARD_BITMAP = 32;
  
  public static final int INTERFACE_SET_SAMSUNG_DEFAULT_WALLET = 30;
  
  public static final int INTERFACE_SHOW_SAFTY_KEYBOARD = 1000;
  
  public static final int JAR_VERSION_CHECK_SUCCESS = 0;
  
  public static final int JAR_VERSION_CODE = 28;
  
  public static final String KEY_ACCOUNT_LIMIT = "accountLimit";
  
  public static final String KEY_ACCOUNT_TYPE = "accountType";
  
  public static final String KEY_APPLET_ID = "appletId";
  
  public static final String KEY_APP_AID = "appAid";
  
  public static final String KEY_APP_VERSION = "appVersion";
  
  public static final String KEY_BALANCE = "ecashBalance";
  
  public static final String KEY_BOARD = "_keyboard";
  
  public static final String KEY_CALLBACK = "callback";
  
  public static final String KEY_CARDLIST_STATUS = "_cardListStatus";
  
  public static final String KEY_CARD_HOLDER_NAME = "cardHolderName";
  
  public static final String KEY_CARD_INFO = "cardInfo";
  
  public static final String KEY_CARD_NUMBER = "cardNumber";
  
  public static final String KEY_CARD_STATUS = "cardStatus";
  
  public static final String KEY_CARD_TOKEN = "cardToken";
  
  public static final String KEY_CARD_TYPE = "cardType";
  
  public static final String KEY_CHANNEL = "channel";
  
  public static final String KEY_CURRENCYTYPE_AUD = "AUD";
  
  public static final String KEY_CURRENCYTYPE_CNY = "CNY";
  
  public static final String KEY_CURRENCYTYPE_EUR = "EUR";
  
  public static final String KEY_CURRENCYTYPE_GBP = "GBP";
  
  public static final String KEY_CURRENCYTYPE_INR = "INR";
  
  public static final String KEY_CURRENCYTYPE_JPY = "JPY";
  
  public static final String KEY_CURRENCYTYPE_KRW = "KRW";
  
  public static final String KEY_CURRENCYTYPE_USD = "USD";
  
  public static final String KEY_CVN2 = "cvn2";
  
  public static final String KEY_DEVICE_TYPE = "deviceType";
  
  public static final String KEY_ENCRYPT_DATA = "encryptData";
  
  public static final String KEY_ERROR_CODE = "errorCode";
  
  public static final String KEY_ERROR_DESC = "errorDesc";
  
  public static final String KEY_EXPIRY_DATE = "expiryDate";
  
  public static final String KEY_HOST_HASH = "hostHash";
  
  public static final String KEY_HOST_PACKAGE_NAME = "hostPackageName";
  
  public static final String KEY_ID_NO = "idNo";
  
  public static final String KEY_ID_TYPE = "idType";
  
  public static final String KEY_INFO = "info";
  
  public static final String KEY_ISSUER_ID = "issuerId";
  
  public static final String KEY_JAR_VERSION = "jarVersionCode";
  
  public static final String KEY_LAST4_DPAN = "dpan";
  
  public static final String KEY_LAST4_FPAN = "fpan";
  
  public static final String KEY_MAX_CARD_NUM_REACHED = "maxCardNumReached";
  
  public static final String KEY_METHOD = "method";
  
  public static final String KEY_MPAN = "mpan";
  
  public static final String KEY_ORDER_NUMBER = "orderNumber";
  
  public static final String KEY_PACKAGE_NAME = "packageName";
  
  public static final String KEY_PAN = "pan";
  
  public static final String KEY_PARAMS = "params";
  
  public static final String KEY_PHONE_NUMBER = "msisdn";
  
  public static final String KEY_PIN = "pin";
  
  public static final String KEY_PRE_DOWNLOAD_SUCCESS = "_preDownloadSuccess";
  
  public static final String KEY_QUOTA = "quota";
  
  public static final String KEY_RESULT = "result";
  
  public static final String KEY_SECRET_KEY = "secretKey";
  
  public static final String KEY_SESSION_KEY = "sessionKey";
  
  public static final String KEY_SIGNATURE = "signature";
  
  public static final String KEY_SIGNED_DATA = "signedData";
  
  public static final String KEY_SMS_AUTH_CODE = "smsAuthCode";
  
  public static final String KEY_SRC_PACKAGE_NAME = "srcPackageName";
  
  public static final String KEY_VENDOR_PAY_ALIAS_TYPE = "vendorPayAliasType";
  
  public static final String KEY_VENDOR_PAY_NAME = "vendorPayName";
  
  public static final String KEY_VENDOR_PAY_STATUS = "vendorPayStatus";
  
  public static final String KEY_VERIFY_METHOD = "verifyMethod";
  
  public static final int MAX_CVN2 = 3;
  
  public static final int MAX_PASSWORD = 6;
  
  public static final String MPAN_STATUS = "01";
  
  public static final int NUM_TSM_INTERFACE = 42;
  
  public static final String OP_STATUS = "00";
  
  public static final int PLAIN_TEXT_MAX_LENGTH = 245;
  
  public static final String PREFIX = "passwordKeyBoard_";
  
  public static final String RECHARGE_MODE_BUSINESS_OFFICE = "03";
  
  public static final String RECHARGE_MODE_CONSUMPTION_AND_CASH = "01";
  
  public static final String RECHARGE_MODE_DESIGNATED_ACCOUNT = "00";
  
  public static final String RECHARGE_MODE_DESIGNATED_AND_CACH = "04";
  
  public static final String RECHARGE_MODE_UNSUPPORTED = "02";
  
  public static final String STRING_CONFIRM_BUTTON = "OK";
  
  public static final String STRING_DELETE_BUTTON = "Del";
  
  public static final int SUCCESS_TSM_CONNECTED = 0;
  
  public static final String SUFFIX = ".jar";
  
  public static final String SUPPORTED_MIN_APK_VERSION = "01.00.11";
  
  public static final String TARGET_ACP = "ACP";
  
  public static final int TARGET_PIN_ACP = 3;
  
  public static final int TARGET_PIN_TSM = 2;
  
  public static final String TARGET_TSM = "TSM";
  
  public static final String TOKENIZATION_PROVIDER = "UP";
  
  public static final String TRANS_ELS_CREDIT = "creditAccountInfo";
  
  public static final String TRANS_ELS_DEBIT = "debitAccountInfo";
  
  public static final String TRANS_TYPE_CASH_LOAD = "63";
  
  public static final String TRANS_TYPE_LOAD = "60";
  
  public static final int TSM_UPDATE_DOWNLOADING = 1;
  
  public static final int TSM_UPDATE_FAIL = 3;
  
  public static final int TSM_UPDATE_FINISH = 2;
  
  public static final int TSM_UPDATE_NOT_START = 0;
  
  public static final String TYPE_AUTO_UPDATE = "01";
  
  public static final String TYPE_CASH_LOAD = "1";
  
  public static final int TYPE_CLIENT = 1000;
  
  public static final String TYPE_CREDITCARD = "1";
  
  public static final String TYPE_DEBITCARD = "0";
  
  public static final int TYPE_KB_CVN2 = 2001;
  
  public static final int TYPE_KB_PINBLOCK = 2000;
  
  public static final int TYPE_KEYBOARD = 1001;
  
  public static final String TYPE_LOAD = "0";
  
  public static final int TYPE_PIN_BLOCK = 1;
  
  public static final int TYPE_PIN_UPCARD = 0;
  
  public static final int UPPAY_CALLER = 2;
  
  public static final int VENDOR_PAY_INTERNAL_ERROR = 4;
  
  public static final int VENDOR_PAY_NOT_INSTALL = 3;
  
  public static final int VENDOR_PAY_NOT_READY = 1;
  
  public static final int VENDOR_PAY_NOT_SUPPORT = 2;
  
  public static final int VENDOR_PAY_READY = 0;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\Constant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
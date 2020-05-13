package com.unionpay.tsmservice;

import android.content.Context;
import android.os.RemoteException;
import com.unionpay.tsmservice.request.ActivateVendorPayRequestParams;
import com.unionpay.tsmservice.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.utils.IUPJniInterface;

public class SessionKeyReExchange {
  private UPTsmAddon a;
  
  private int b = -1;
  
  private RequestParams c;
  
  private ITsmCallback d;
  
  private ITsmProgressCallback e;
  
  private int f = 1000;
  
  private OnSafetyKeyboardCallback g;
  
  private Context h;
  
  private int i;
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt, ITsmCallback paramITsmCallback) {
    this(paramUPTsmAddon, paramInt, null, paramITsmCallback);
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback) {
    this(paramUPTsmAddon, paramInt, paramRequestParams, paramITsmCallback, null);
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) {
    this(paramUPTsmAddon, paramInt, paramRequestParams, paramITsmCallback, paramITsmProgressCallback, 1000);
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt1, RequestParams paramRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback, int paramInt2) {
    this.a = paramUPTsmAddon;
    this.b = paramInt1;
    this.c = paramRequestParams;
    this.d = paramITsmCallback;
    this.e = paramITsmProgressCallback;
    this.f = paramInt2;
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt1, SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams, int paramInt2, OnSafetyKeyboardCallback paramOnSafetyKeyboardCallback, Context paramContext) {
    this.a = paramUPTsmAddon;
    this.b = paramInt1;
    this.i = paramInt2;
    this.c = (RequestParams)paramSafetyKeyboardRequestParams;
    this.g = paramOnSafetyKeyboardCallback;
    this.h = paramContext;
  }
  
  public int reExchangeKey() throws RemoteException {
    InitRequestParams initRequestParams;
    GetAssociatedAppRequestParams getAssociatedAppRequestParams;
    AppDownloadApplyRequestParams appDownloadApplyRequestParams;
    AppDeleteRequestParams appDeleteRequestParams;
    GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams;
    GetAppDetailRequestParams getAppDetailRequestParams;
    GetTransElementsRequestParams getTransElementsRequestParams;
    AppDownloadRequestParams appDownloadRequestParams;
    AppDataUpdateRequestParams appDataUpdateRequestParams;
    ECashTopUpRequestParams eCashTopUpRequestParams;
    GetTransRecordRequestParams getTransRecordRequestParams;
    GetAccountInfoRequestParams getAccountInfoRequestParams;
    GetAccountBalanceRequestParams getAccountBalanceRequestParams;
    GetCardInfoRequestParams getCardInfoRequestParams;
    SetDefaultCardRequestParams setDefaultCardRequestParams;
    OpenChannelRequestParams openChannelRequestParams;
    SendApduRequestParams sendApduRequestParams;
    CloseChannelRequestParams closeChannelRequestParams;
    HideAppApplyRequestParams hideAppApplyRequestParams;
    GetSeIdRequestParams getSeIdRequestParams;
    GetDefaultCardRequestParams getDefaultCardRequestParams;
    GetSeAppListRequestParams getSeAppListRequestParams;
    GetAppListRequestParams getAppListRequestParams;
    GetAppStatusRequestParams getAppStatusRequestParams;
    AppLockRequestParams appLockRequestParams;
    AppUnlockRequestParams appUnlockRequestParams;
    EncryptDataRequestParams encryptDataRequestParams;
    ExecuteCmdRequestParams executeCmdRequestParams;
    GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams;
    CheckSSamsungPayRequestParams checkSSamsungPayRequestParams;
    SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams;
    SafetyKeyboardRequestParams safetyKeyboardRequestParams;
    GetEncryptDataRequestParams getEncryptDataRequestParams;
    CardListStatusChangedRequestParams cardListStatusChangedRequestParams;
    GetVendorPayStatusRequestParams getVendorPayStatusRequestParams;
    ActivateVendorPayRequestParams activateVendorPayRequestParams;
    AddCardToVendorPayRequestParams addCardToVendorPayRequestParams;
    OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams;
    PreDownloadRequestParams preDownloadRequestParams;
    int i = 0;
    String[] arrayOfString = new String[1];
    int j = this.a.getPubKey(1000, arrayOfString);
    if (j != 0)
      i = j; 
    String str2 = IUPJniInterface.rER(arrayOfString[0], IUPJniInterface.mSK());
    j = this.a.exchangeKey(str2, arrayOfString);
    if (j != 0)
      i = j; 
    String str1 = IUPJniInterface.dMG(arrayOfString[0], this.a.getCryptType());
    IUPJniInterface.sSK(str1);
    Context context = this.a.getContext();
    if (context != null)
      IUPJniInterface.uSKT(context.getPackageName(), str1); 
    switch (this.b) {
      default:
        return i;
      case 0:
        initRequestParams = (InitRequestParams)this.c;
        i = this.a.init(initRequestParams, this.d);
      case 1:
        getAssociatedAppRequestParams = (GetAssociatedAppRequestParams)this.c;
        i = this.a.getAssociatedApp(getAssociatedAppRequestParams, this.d);
      case 15:
        appDownloadApplyRequestParams = (AppDownloadApplyRequestParams)this.c;
        i = this.a.appDownloadApply(appDownloadApplyRequestParams, this.d);
      case 17:
        appDeleteRequestParams = (AppDeleteRequestParams)this.c;
        i = this.a.appDelete(appDeleteRequestParams, this.d, this.e);
      case 11:
        getSMSAuthCodeRequestParams = (GetSMSAuthCodeRequestParams)this.c;
        i = this.a.getSMSAuthCode(getSMSAuthCodeRequestParams, this.d);
      case 4:
        getAppDetailRequestParams = (GetAppDetailRequestParams)this.c;
        i = this.a.getAppDetail(getAppDetailRequestParams, this.d);
      case 9:
        getTransElementsRequestParams = (GetTransElementsRequestParams)this.c;
        i = this.a.getTransElements(getTransElementsRequestParams, this.d);
      case 16:
        appDownloadRequestParams = (AppDownloadRequestParams)this.c;
        i = this.a.appDownload(appDownloadRequestParams, this.d, this.e);
      case 18:
        appDataUpdateRequestParams = (AppDataUpdateRequestParams)this.c;
        i = this.a.appDataUpdate(appDataUpdateRequestParams, this.d, this.e);
      case 19:
        eCashTopUpRequestParams = (ECashTopUpRequestParams)this.c;
        i = this.a.eCashTopUp(eCashTopUpRequestParams, this.d);
      case 10:
        getTransRecordRequestParams = (GetTransRecordRequestParams)this.c;
        i = this.a.getTransRecord(getTransRecordRequestParams, this.d);
      case 7:
        getAccountInfoRequestParams = (GetAccountInfoRequestParams)this.c;
        i = this.a.getAccountInfo(getAccountInfoRequestParams, this.d);
      case 8:
        getAccountBalanceRequestParams = (GetAccountBalanceRequestParams)this.c;
        i = this.a.getAccountBalance(getAccountBalanceRequestParams, this.d);
      case 6:
        getCardInfoRequestParams = (GetCardInfoRequestParams)this.c;
        i = this.a.getCardInfo(getCardInfoRequestParams, this.d);
      case 14:
        setDefaultCardRequestParams = (SetDefaultCardRequestParams)this.c;
        i = this.a.setDefaultCard(setDefaultCardRequestParams, this.d);
      case 20:
        openChannelRequestParams = (OpenChannelRequestParams)this.c;
        i = this.a.openChannel(openChannelRequestParams, this.d);
      case 22:
        sendApduRequestParams = (SendApduRequestParams)this.c;
        i = this.a.sendApdu(sendApduRequestParams, this.d);
      case 21:
        closeChannelRequestParams = (CloseChannelRequestParams)this.c;
        i = this.a.closeChannel(closeChannelRequestParams, this.d);
      case 24:
        hideAppApplyRequestParams = (HideAppApplyRequestParams)this.c;
        i = this.a.hideAppApply(hideAppApplyRequestParams, this.d);
      case 12:
        getSeIdRequestParams = (GetSeIdRequestParams)this.c;
        i = this.a.getSeId(getSeIdRequestParams, this.d);
      case 13:
        getDefaultCardRequestParams = (GetDefaultCardRequestParams)this.c;
        i = this.a.getDefaultCard(getDefaultCardRequestParams, this.d);
      case 3:
        getSeAppListRequestParams = (GetSeAppListRequestParams)this.c;
        i = this.a.getSEAppList(getSeAppListRequestParams, this.d);
      case 2:
        getAppListRequestParams = (GetAppListRequestParams)this.c;
        i = this.a.getAppList(getAppListRequestParams, this.d);
      case 5:
        getAppStatusRequestParams = (GetAppStatusRequestParams)this.c;
        i = this.a.getAppStatus(getAppStatusRequestParams, this.d);
      case 26:
        appLockRequestParams = (AppLockRequestParams)this.c;
        i = this.a.appLock(appLockRequestParams, this.d);
      case 27:
        appUnlockRequestParams = (AppUnlockRequestParams)this.c;
        i = this.a.appUnlock(appUnlockRequestParams, this.d);
      case 23:
        encryptDataRequestParams = (EncryptDataRequestParams)this.c;
        i = this.a.encryptData(encryptDataRequestParams, this.d);
      case 25:
        executeCmdRequestParams = (ExecuteCmdRequestParams)this.c;
        i = this.a.executeCmd(executeCmdRequestParams, this.d, this.e);
      case 28:
        getCardInfoBySpayRequestParams = (GetCardInfoBySpayRequestParams)this.c;
        i = this.a.getCardInfoBySamsungPay(getCardInfoBySpayRequestParams, this.d);
      case 29:
        checkSSamsungPayRequestParams = (CheckSSamsungPayRequestParams)this.c;
        i = this.a.checkSSamsungPay(checkSSamsungPayRequestParams, this.d);
      case 30:
        setSamsungDefWalletRequestParams = (SetSamsungDefWalletRequestParams)this.c;
        i = this.a.setSamsungDefaultWallet(setSamsungDefWalletRequestParams, this.d);
      case 32:
        safetyKeyboardRequestParams = (SafetyKeyboardRequestParams)this.c;
        i = this.a.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
      case 1000:
        safetyKeyboardRequestParams = (SafetyKeyboardRequestParams)this.c;
        i = this.a.showSafetyKeyboard(safetyKeyboardRequestParams, this.i, this.g, this.h);
      case 33:
        i = this.a.clearEncryptData(this.i);
      case 31:
        getEncryptDataRequestParams = (GetEncryptDataRequestParams)this.c;
        i = this.a.getEncryptData(getEncryptDataRequestParams, this.d);
      case 34:
        i = this.a.hideKeyboard();
      case 35:
        cardListStatusChangedRequestParams = (CardListStatusChangedRequestParams)this.c;
        i = this.a.cardListStatusChanged(cardListStatusChangedRequestParams, this.d);
      case 36:
        getVendorPayStatusRequestParams = (GetVendorPayStatusRequestParams)this.c;
        i = this.a.getVendorPayStatus(getVendorPayStatusRequestParams, this.d);
      case 37:
        activateVendorPayRequestParams = (ActivateVendorPayRequestParams)this.c;
        i = this.a.activateVendorPay(activateVendorPayRequestParams, this.d);
      case 38:
        addCardToVendorPayRequestParams = (AddCardToVendorPayRequestParams)this.c;
        i = this.a.addCardToVendorPay(addCardToVendorPayRequestParams, this.d, this.e);
      case 39:
        onlinePaymentVerifyRequestParams = (OnlinePaymentVerifyRequestParams)this.c;
        i = this.a.onlinePaymentVerify(onlinePaymentVerifyRequestParams, this.d);
      case 40:
        preDownloadRequestParams = (PreDownloadRequestParams)this.c;
        i = this.a.preDownload(preDownloadRequestParams, this.d, this.e);
      case 41:
        break;
    } 
    QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams = (QueryVendorPayStatusRequestParams)this.c;
    i = this.a.queryVendorPayStatus(queryVendorPayStatusRequestParams, this.d);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\SessionKeyReExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
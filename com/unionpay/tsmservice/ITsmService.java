package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
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
import com.unionpay.tsmservice.request.CheckSupportCardApplyRequestParams;
import com.unionpay.tsmservice.request.ClearEncryptDataRequestParams;
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
import com.unionpay.tsmservice.request.GetCurrentWalletClientRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.HideSafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.request.StartCardApplyRequestParams;

public interface ITsmService extends IInterface {
  int activateVendorPay(ActivateVendorPayRequestParams paramActivateVendorPayRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int addCardToVendorPay(AddCardToVendorPayRequestParams paramAddCardToVendorPayRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException;
  
  int appDataUpdate(AppDataUpdateRequestParams paramAppDataUpdateRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException;
  
  int appDelete(AppDeleteRequestParams paramAppDeleteRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException;
  
  int appDownload(AppDownloadRequestParams paramAppDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException;
  
  int appDownloadApply(AppDownloadApplyRequestParams paramAppDownloadApplyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int appLock(AppLockRequestParams paramAppLockRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int appUnlock(AppUnlockRequestParams paramAppUnlockRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int cardListStatusChanged(CardListStatusChangedRequestParams paramCardListStatusChangedRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int checkSSamsungPay(CheckSSamsungPayRequestParams paramCheckSSamsungPayRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int checkSupportCardApply(CheckSupportCardApplyRequestParams paramCheckSupportCardApplyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int clearEncryptData(int paramInt) throws RemoteException;
  
  int clearKeyboardEncryptData(ClearEncryptDataRequestParams paramClearEncryptDataRequestParams, int paramInt) throws RemoteException;
  
  int closeChannel(CloseChannelRequestParams paramCloseChannelRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int eCashTopUp(ECashTopUpRequestParams paramECashTopUpRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int encryptData(EncryptDataRequestParams paramEncryptDataRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int exchangeKey(String paramString, String[] paramArrayOfString) throws RemoteException;
  
  int executeCmd(ExecuteCmdRequestParams paramExecuteCmdRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException;
  
  int getAccountBalance(GetAccountBalanceRequestParams paramGetAccountBalanceRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getAccountInfo(GetAccountInfoRequestParams paramGetAccountInfoRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getAppDetail(GetAppDetailRequestParams paramGetAppDetailRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getAppList(GetAppListRequestParams paramGetAppListRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getAppStatus(GetAppStatusRequestParams paramGetAppStatusRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getAssociatedApp(GetAssociatedAppRequestParams paramGetAssociatedAppRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getCardInfo(GetCardInfoRequestParams paramGetCardInfoRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams paramGetCardInfoBySpayRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getCurrentWalletClient(GetCurrentWalletClientRequestParams paramGetCurrentWalletClientRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getDefaultCard(GetDefaultCardRequestParams paramGetDefaultCardRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getEncryptData(GetEncryptDataRequestParams paramGetEncryptDataRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getPubKey(int paramInt, String[] paramArrayOfString) throws RemoteException;
  
  int getSEAppList(GetSeAppListRequestParams paramGetSeAppListRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getSEId(GetSeIdRequestParams paramGetSeIdRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getSMSAuthCode(GetSMSAuthCodeRequestParams paramGetSMSAuthCodeRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getTransElements(GetTransElementsRequestParams paramGetTransElementsRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getTransRecord(GetTransRecordRequestParams paramGetTransRecordRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int getVendorPayStatus(GetVendorPayStatusRequestParams paramGetVendorPayStatusRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int hideAppApply(HideAppApplyRequestParams paramHideAppApplyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int hideKeyboard() throws RemoteException;
  
  int hideSafetyKeyboard(HideSafetyKeyboardRequestParams paramHideSafetyKeyboardRequestParams) throws RemoteException;
  
  int init(InitRequestParams paramInitRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int onlinePaymentVerify(OnlinePaymentVerifyRequestParams paramOnlinePaymentVerifyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int openChannel(OpenChannelRequestParams paramOpenChannelRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int preDownload(PreDownloadRequestParams paramPreDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback) throws RemoteException;
  
  int queryVendorPayStatus(QueryVendorPayStatusRequestParams paramQueryVendorPayStatusRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int sendApdu(SendApduRequestParams paramSendApduRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int setDefaultCard(SetDefaultCardRequestParams paramSetDefaultCardRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams) throws RemoteException;
  
  int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams paramSetSamsungDefWalletRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  int showSafetyKeyboard(SafetyKeyboardRequestParams paramSafetyKeyboardRequestParams, int paramInt, OnSafetyKeyboardCallback paramOnSafetyKeyboardCallback, ITsmActivityCallback paramITsmActivityCallback) throws RemoteException;
  
  int startCardApply(StartCardApplyRequestParams paramStartCardApplyRequestParams, ITsmCallback paramITsmCallback) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ITsmService {
    public Stub() {
      attachInterface(this, "com.unionpay.tsmservice.ITsmService");
    }
    
    public static ITsmService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmService");
      return (iInterface != null && iInterface instanceof ITsmService) ? (ITsmService)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String[] arrayOfString;
      EncryptDataRequestParams encryptDataRequestParams1;
      GetSeIdRequestParams getSeIdRequestParams1;
      GetAssociatedAppRequestParams getAssociatedAppRequestParams1;
      GetSeAppListRequestParams getSeAppListRequestParams1;
      GetAppListRequestParams getAppListRequestParams1;
      GetAppStatusRequestParams getAppStatusRequestParams1;
      GetAppDetailRequestParams getAppDetailRequestParams1;
      GetTransElementsRequestParams getTransElementsRequestParams1;
      AppDownloadApplyRequestParams appDownloadApplyRequestParams1;
      AppDownloadRequestParams appDownloadRequestParams1;
      AppDeleteRequestParams appDeleteRequestParams1;
      AppDataUpdateRequestParams appDataUpdateRequestParams1;
      AppLockRequestParams appLockRequestParams1;
      AppUnlockRequestParams appUnlockRequestParams1;
      GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams1;
      ECashTopUpRequestParams eCashTopUpRequestParams1;
      GetTransRecordRequestParams getTransRecordRequestParams1;
      GetAccountInfoRequestParams getAccountInfoRequestParams1;
      GetAccountBalanceRequestParams getAccountBalanceRequestParams1;
      GetCardInfoRequestParams getCardInfoRequestParams1;
      SetDefaultCardRequestParams setDefaultCardRequestParams1;
      GetDefaultCardRequestParams getDefaultCardRequestParams1;
      OpenChannelRequestParams openChannelRequestParams1;
      SendApduRequestParams sendApduRequestParams1;
      CloseChannelRequestParams closeChannelRequestParams1;
      HideAppApplyRequestParams hideAppApplyRequestParams1;
      ExecuteCmdRequestParams executeCmdRequestParams1;
      GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams1;
      CheckSSamsungPayRequestParams checkSSamsungPayRequestParams1;
      SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams1;
      SafetyKeyboardRequestParams safetyKeyboardRequestParams1;
      GetEncryptDataRequestParams getEncryptDataRequestParams1;
      CheckSupportCardApplyRequestParams checkSupportCardApplyRequestParams1;
      StartCardApplyRequestParams startCardApplyRequestParams1;
      GetCurrentWalletClientRequestParams getCurrentWalletClientRequestParams1;
      CardListStatusChangedRequestParams cardListStatusChangedRequestParams1;
      GetVendorPayStatusRequestParams getVendorPayStatusRequestParams1;
      ActivateVendorPayRequestParams activateVendorPayRequestParams1;
      AddCardToVendorPayRequestParams addCardToVendorPayRequestParams1;
      OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams1;
      ClearEncryptDataRequestParams clearEncryptDataRequestParams1;
      HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams1;
      QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams;
      String str;
      Parcel parcel = null;
      InitRequestParams initRequestParams1 = null;
      InitRequestParams initRequestParams2 = null;
      EncryptDataRequestParams encryptDataRequestParams2 = null;
      GetSeIdRequestParams getSeIdRequestParams2 = null;
      GetAssociatedAppRequestParams getAssociatedAppRequestParams2 = null;
      GetSeAppListRequestParams getSeAppListRequestParams2 = null;
      GetAppListRequestParams getAppListRequestParams2 = null;
      GetAppStatusRequestParams getAppStatusRequestParams2 = null;
      GetAppDetailRequestParams getAppDetailRequestParams2 = null;
      GetTransElementsRequestParams getTransElementsRequestParams2 = null;
      AppDownloadApplyRequestParams appDownloadApplyRequestParams2 = null;
      AppDownloadRequestParams appDownloadRequestParams2 = null;
      AppDeleteRequestParams appDeleteRequestParams2 = null;
      AppDataUpdateRequestParams appDataUpdateRequestParams2 = null;
      AppLockRequestParams appLockRequestParams2 = null;
      AppUnlockRequestParams appUnlockRequestParams2 = null;
      GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams2 = null;
      ECashTopUpRequestParams eCashTopUpRequestParams2 = null;
      GetTransRecordRequestParams getTransRecordRequestParams2 = null;
      GetAccountInfoRequestParams getAccountInfoRequestParams2 = null;
      GetAccountBalanceRequestParams getAccountBalanceRequestParams2 = null;
      GetCardInfoRequestParams getCardInfoRequestParams2 = null;
      SetDefaultCardRequestParams setDefaultCardRequestParams2 = null;
      GetDefaultCardRequestParams getDefaultCardRequestParams2 = null;
      OpenChannelRequestParams openChannelRequestParams2 = null;
      SendApduRequestParams sendApduRequestParams2 = null;
      CloseChannelRequestParams closeChannelRequestParams2 = null;
      HideAppApplyRequestParams hideAppApplyRequestParams2 = null;
      ExecuteCmdRequestParams executeCmdRequestParams2 = null;
      GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams2 = null;
      CheckSSamsungPayRequestParams checkSSamsungPayRequestParams2 = null;
      SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams2 = null;
      SafetyKeyboardRequestParams safetyKeyboardRequestParams2 = null;
      SafetyKeyboardRequestParams safetyKeyboardRequestParams3 = null;
      GetEncryptDataRequestParams getEncryptDataRequestParams2 = null;
      CheckSupportCardApplyRequestParams checkSupportCardApplyRequestParams2 = null;
      StartCardApplyRequestParams startCardApplyRequestParams2 = null;
      GetCurrentWalletClientRequestParams getCurrentWalletClientRequestParams2 = null;
      CardListStatusChangedRequestParams cardListStatusChangedRequestParams2 = null;
      GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = null;
      ActivateVendorPayRequestParams activateVendorPayRequestParams2 = null;
      AddCardToVendorPayRequestParams addCardToVendorPayRequestParams2 = null;
      OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams2 = null;
      ClearEncryptDataRequestParams clearEncryptDataRequestParams2 = null;
      HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams2 = null;
      PreDownloadRequestParams preDownloadRequestParams2 = null;
      InitRequestParams initRequestParams3 = null;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.tsmservice.ITsmService");
          return true;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
          initRequestParams1 = initRequestParams3;
          if (param1Parcel1.readInt() != 0)
            initRequestParams1 = (InitRequestParams)InitRequestParams.CREATOR.createFromParcel(param1Parcel1); 
          param1Int1 = init(initRequestParams1, ITsmCallback.Stub.asInterface(param1Parcel1.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 2:
          param1Parcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
          param1Int1 = param1Parcel1.readInt();
          param1Int2 = param1Parcel1.readInt();
          if (param1Int2 < 0) {
            param1Parcel1 = parcel;
          } else {
            arrayOfString = new String[param1Int2];
          } 
          param1Int1 = getPubKey(param1Int1, arrayOfString);
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          param1Parcel2.writeStringArray(arrayOfString);
          return true;
        case 3:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          str = arrayOfString.readString();
          param1Int1 = arrayOfString.readInt();
          if (param1Int1 < 0) {
            InitRequestParams initRequestParams = initRequestParams1;
          } else {
            arrayOfString = new String[param1Int1];
          } 
          param1Int1 = exchangeKey(str, arrayOfString);
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          param1Parcel2.writeStringArray(arrayOfString);
          return true;
        case 4:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          initRequestParams1 = initRequestParams2;
          if (arrayOfString.readInt() != 0)
            encryptDataRequestParams1 = (EncryptDataRequestParams)EncryptDataRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = encryptData(encryptDataRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 5:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          encryptDataRequestParams1 = encryptDataRequestParams2;
          if (arrayOfString.readInt() != 0)
            getSeIdRequestParams1 = (GetSeIdRequestParams)GetSeIdRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getSEId(getSeIdRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 6:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getSeIdRequestParams1 = getSeIdRequestParams2;
          if (arrayOfString.readInt() != 0)
            getAssociatedAppRequestParams1 = (GetAssociatedAppRequestParams)GetAssociatedAppRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getAssociatedApp(getAssociatedAppRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 7:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getAssociatedAppRequestParams1 = getAssociatedAppRequestParams2;
          if (arrayOfString.readInt() != 0)
            getSeAppListRequestParams1 = (GetSeAppListRequestParams)GetSeAppListRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getSEAppList(getSeAppListRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 8:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getSeAppListRequestParams1 = getSeAppListRequestParams2;
          if (arrayOfString.readInt() != 0)
            getAppListRequestParams1 = (GetAppListRequestParams)GetAppListRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getAppList(getAppListRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 9:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getAppListRequestParams1 = getAppListRequestParams2;
          if (arrayOfString.readInt() != 0)
            getAppStatusRequestParams1 = (GetAppStatusRequestParams)GetAppStatusRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getAppStatus(getAppStatusRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 10:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getAppStatusRequestParams1 = getAppStatusRequestParams2;
          if (arrayOfString.readInt() != 0)
            getAppDetailRequestParams1 = (GetAppDetailRequestParams)GetAppDetailRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getAppDetail(getAppDetailRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 11:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getAppDetailRequestParams1 = getAppDetailRequestParams2;
          if (arrayOfString.readInt() != 0)
            getTransElementsRequestParams1 = (GetTransElementsRequestParams)GetTransElementsRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getTransElements(getTransElementsRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 12:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getTransElementsRequestParams1 = getTransElementsRequestParams2;
          if (arrayOfString.readInt() != 0)
            appDownloadApplyRequestParams1 = (AppDownloadApplyRequestParams)AppDownloadApplyRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = appDownloadApply(appDownloadApplyRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 13:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          appDownloadApplyRequestParams1 = appDownloadApplyRequestParams2;
          if (arrayOfString.readInt() != 0)
            appDownloadRequestParams1 = (AppDownloadRequestParams)AppDownloadRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = appDownload(appDownloadRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 14:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          appDownloadRequestParams1 = appDownloadRequestParams2;
          if (arrayOfString.readInt() != 0)
            appDeleteRequestParams1 = (AppDeleteRequestParams)AppDeleteRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = appDelete(appDeleteRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 15:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          appDeleteRequestParams1 = appDeleteRequestParams2;
          if (arrayOfString.readInt() != 0)
            appDataUpdateRequestParams1 = (AppDataUpdateRequestParams)AppDataUpdateRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = appDataUpdate(appDataUpdateRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 16:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          appDataUpdateRequestParams1 = appDataUpdateRequestParams2;
          if (arrayOfString.readInt() != 0)
            appLockRequestParams1 = (AppLockRequestParams)AppLockRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = appLock(appLockRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 17:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          appLockRequestParams1 = appLockRequestParams2;
          if (arrayOfString.readInt() != 0)
            appUnlockRequestParams1 = (AppUnlockRequestParams)AppUnlockRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = appUnlock(appUnlockRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 18:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          appUnlockRequestParams1 = appUnlockRequestParams2;
          if (arrayOfString.readInt() != 0)
            getSMSAuthCodeRequestParams1 = (GetSMSAuthCodeRequestParams)GetSMSAuthCodeRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getSMSAuthCode(getSMSAuthCodeRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 19:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getSMSAuthCodeRequestParams1 = getSMSAuthCodeRequestParams2;
          if (arrayOfString.readInt() != 0)
            eCashTopUpRequestParams1 = (ECashTopUpRequestParams)ECashTopUpRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = eCashTopUp(eCashTopUpRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 20:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          eCashTopUpRequestParams1 = eCashTopUpRequestParams2;
          if (arrayOfString.readInt() != 0)
            getTransRecordRequestParams1 = (GetTransRecordRequestParams)GetTransRecordRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getTransRecord(getTransRecordRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 21:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getTransRecordRequestParams1 = getTransRecordRequestParams2;
          if (arrayOfString.readInt() != 0)
            getAccountInfoRequestParams1 = (GetAccountInfoRequestParams)GetAccountInfoRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getAccountInfo(getAccountInfoRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 22:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getAccountInfoRequestParams1 = getAccountInfoRequestParams2;
          if (arrayOfString.readInt() != 0)
            getAccountBalanceRequestParams1 = (GetAccountBalanceRequestParams)GetAccountBalanceRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getAccountBalance(getAccountBalanceRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 23:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getAccountBalanceRequestParams1 = getAccountBalanceRequestParams2;
          if (arrayOfString.readInt() != 0)
            getCardInfoRequestParams1 = (GetCardInfoRequestParams)GetCardInfoRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getCardInfo(getCardInfoRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 24:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getCardInfoRequestParams1 = getCardInfoRequestParams2;
          if (arrayOfString.readInt() != 0)
            setDefaultCardRequestParams1 = (SetDefaultCardRequestParams)SetDefaultCardRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = setDefaultCard(setDefaultCardRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 25:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          setDefaultCardRequestParams1 = setDefaultCardRequestParams2;
          if (arrayOfString.readInt() != 0)
            getDefaultCardRequestParams1 = (GetDefaultCardRequestParams)GetDefaultCardRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getDefaultCard(getDefaultCardRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 26:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getDefaultCardRequestParams1 = getDefaultCardRequestParams2;
          if (arrayOfString.readInt() != 0)
            openChannelRequestParams1 = (OpenChannelRequestParams)OpenChannelRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = openChannel(openChannelRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 27:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          openChannelRequestParams1 = openChannelRequestParams2;
          if (arrayOfString.readInt() != 0)
            sendApduRequestParams1 = (SendApduRequestParams)SendApduRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = sendApdu(sendApduRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 28:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          sendApduRequestParams1 = sendApduRequestParams2;
          if (arrayOfString.readInt() != 0)
            closeChannelRequestParams1 = (CloseChannelRequestParams)CloseChannelRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = closeChannel(closeChannelRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 29:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          closeChannelRequestParams1 = closeChannelRequestParams2;
          if (arrayOfString.readInt() != 0)
            hideAppApplyRequestParams1 = (HideAppApplyRequestParams)HideAppApplyRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = hideAppApply(hideAppApplyRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 30:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          hideAppApplyRequestParams1 = hideAppApplyRequestParams2;
          if (arrayOfString.readInt() != 0)
            executeCmdRequestParams1 = (ExecuteCmdRequestParams)ExecuteCmdRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = executeCmd(executeCmdRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 31:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          executeCmdRequestParams1 = executeCmdRequestParams2;
          if (arrayOfString.readInt() != 0)
            getCardInfoBySpayRequestParams1 = (GetCardInfoBySpayRequestParams)GetCardInfoBySpayRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getCardInfoBySamsungPay(getCardInfoBySpayRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 32:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getCardInfoBySpayRequestParams1 = getCardInfoBySpayRequestParams2;
          if (arrayOfString.readInt() != 0)
            checkSSamsungPayRequestParams1 = (CheckSSamsungPayRequestParams)CheckSSamsungPayRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = checkSSamsungPay(checkSSamsungPayRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 33:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          checkSSamsungPayRequestParams1 = checkSSamsungPayRequestParams2;
          if (arrayOfString.readInt() != 0)
            setSamsungDefWalletRequestParams1 = (SetSamsungDefWalletRequestParams)SetSamsungDefWalletRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = setSamsungDefaultWallet(setSamsungDefWalletRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 34:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          setSamsungDefWalletRequestParams1 = setSamsungDefWalletRequestParams2;
          if (arrayOfString.readInt() != 0)
            safetyKeyboardRequestParams1 = (SafetyKeyboardRequestParams)SafetyKeyboardRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = showSafetyKeyboard(safetyKeyboardRequestParams1, arrayOfString.readInt(), OnSafetyKeyboardCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmActivityCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 35:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          safetyKeyboardRequestParams1 = safetyKeyboardRequestParams2;
          if (arrayOfString.readInt() != 0)
            safetyKeyboardRequestParams1 = (SafetyKeyboardRequestParams)SafetyKeyboardRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = setSafetyKeyboardBitmap(safetyKeyboardRequestParams1);
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 36:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          safetyKeyboardRequestParams1 = safetyKeyboardRequestParams3;
          if (arrayOfString.readInt() != 0)
            getEncryptDataRequestParams1 = (GetEncryptDataRequestParams)GetEncryptDataRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getEncryptData(getEncryptDataRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 37:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          param1Int1 = clearEncryptData(arrayOfString.readInt());
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 38:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          param1Int1 = hideKeyboard();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 39:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getEncryptDataRequestParams1 = getEncryptDataRequestParams2;
          if (arrayOfString.readInt() != 0)
            checkSupportCardApplyRequestParams1 = (CheckSupportCardApplyRequestParams)CheckSupportCardApplyRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = checkSupportCardApply(checkSupportCardApplyRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 40:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          checkSupportCardApplyRequestParams1 = checkSupportCardApplyRequestParams2;
          if (arrayOfString.readInt() != 0)
            startCardApplyRequestParams1 = (StartCardApplyRequestParams)StartCardApplyRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = startCardApply(startCardApplyRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 41:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          startCardApplyRequestParams1 = startCardApplyRequestParams2;
          if (arrayOfString.readInt() != 0)
            getCurrentWalletClientRequestParams1 = (GetCurrentWalletClientRequestParams)GetCurrentWalletClientRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getCurrentWalletClient(getCurrentWalletClientRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 42:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getCurrentWalletClientRequestParams1 = getCurrentWalletClientRequestParams2;
          if (arrayOfString.readInt() != 0)
            cardListStatusChangedRequestParams1 = (CardListStatusChangedRequestParams)CardListStatusChangedRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = cardListStatusChanged(cardListStatusChangedRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 43:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          cardListStatusChangedRequestParams1 = cardListStatusChangedRequestParams2;
          if (arrayOfString.readInt() != 0)
            getVendorPayStatusRequestParams1 = (GetVendorPayStatusRequestParams)GetVendorPayStatusRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = getVendorPayStatus(getVendorPayStatusRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 44:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          getVendorPayStatusRequestParams1 = getVendorPayStatusRequestParams2;
          if (arrayOfString.readInt() != 0)
            activateVendorPayRequestParams1 = (ActivateVendorPayRequestParams)ActivateVendorPayRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = activateVendorPay(activateVendorPayRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 45:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          activateVendorPayRequestParams1 = activateVendorPayRequestParams2;
          if (arrayOfString.readInt() != 0)
            addCardToVendorPayRequestParams1 = (AddCardToVendorPayRequestParams)AddCardToVendorPayRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = addCardToVendorPay(addCardToVendorPayRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 46:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          addCardToVendorPayRequestParams1 = addCardToVendorPayRequestParams2;
          if (arrayOfString.readInt() != 0)
            onlinePaymentVerifyRequestParams1 = (OnlinePaymentVerifyRequestParams)OnlinePaymentVerifyRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = onlinePaymentVerify(onlinePaymentVerifyRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 47:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          onlinePaymentVerifyRequestParams1 = onlinePaymentVerifyRequestParams2;
          if (arrayOfString.readInt() != 0)
            clearEncryptDataRequestParams1 = (ClearEncryptDataRequestParams)ClearEncryptDataRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = clearKeyboardEncryptData(clearEncryptDataRequestParams1, arrayOfString.readInt());
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 48:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          clearEncryptDataRequestParams1 = clearEncryptDataRequestParams2;
          if (arrayOfString.readInt() != 0)
            hideSafetyKeyboardRequestParams1 = (HideSafetyKeyboardRequestParams)HideSafetyKeyboardRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = hideSafetyKeyboard(hideSafetyKeyboardRequestParams1);
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 49:
          arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
          hideSafetyKeyboardRequestParams1 = hideSafetyKeyboardRequestParams2;
          if (arrayOfString.readInt() != 0)
            preDownloadRequestParams1 = (PreDownloadRequestParams)PreDownloadRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
          param1Int1 = preDownload(preDownloadRequestParams1, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 50:
          break;
      } 
      arrayOfString.enforceInterface("com.unionpay.tsmservice.ITsmService");
      PreDownloadRequestParams preDownloadRequestParams1 = preDownloadRequestParams2;
      if (arrayOfString.readInt() != 0)
        queryVendorPayStatusRequestParams = (QueryVendorPayStatusRequestParams)QueryVendorPayStatusRequestParams.CREATOR.createFromParcel((Parcel)arrayOfString); 
      param1Int1 = queryVendorPayStatus(queryVendorPayStatusRequestParams, ITsmCallback.Stub.asInterface(arrayOfString.readStrongBinder()));
      param1Parcel2.writeNoException();
      param1Parcel2.writeInt(param1Int1);
      return true;
    }
    
    private static final class a implements ITsmService {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final int activateVendorPay(ActivateVendorPayRequestParams param2ActivateVendorPayRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2ActivateVendorPayRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2ActivateVendorPayRequestParams);
        this.a.transact(44, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int addCardToVendorPay(AddCardToVendorPayRequestParams param2AddCardToVendorPayRequestParams, ITsmCallback param2ITsmCallback, ITsmProgressCallback param2ITsmProgressCallback) throws RemoteException {
        AddCardToVendorPayRequestParams addCardToVendorPayRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2AddCardToVendorPayRequestParams != null) {
            parcel1.writeInt(1);
            param2AddCardToVendorPayRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ITsmCallback != null) {
            iBinder = param2ITsmCallback.asBinder();
          } else {
            param2AddCardToVendorPayRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2AddCardToVendorPayRequestParams);
          param2AddCardToVendorPayRequestParams = addCardToVendorPayRequestParams;
          if (param2ITsmProgressCallback != null)
            iBinder = param2ITsmProgressCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(45, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int appDataUpdate(AppDataUpdateRequestParams param2AppDataUpdateRequestParams, ITsmCallback param2ITsmCallback, ITsmProgressCallback param2ITsmProgressCallback) throws RemoteException {
        AppDataUpdateRequestParams appDataUpdateRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2AppDataUpdateRequestParams != null) {
            parcel1.writeInt(1);
            param2AppDataUpdateRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ITsmCallback != null) {
            iBinder = param2ITsmCallback.asBinder();
          } else {
            param2AppDataUpdateRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2AppDataUpdateRequestParams);
          param2AppDataUpdateRequestParams = appDataUpdateRequestParams;
          if (param2ITsmProgressCallback != null)
            iBinder = param2ITsmProgressCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(15, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int appDelete(AppDeleteRequestParams param2AppDeleteRequestParams, ITsmCallback param2ITsmCallback, ITsmProgressCallback param2ITsmProgressCallback) throws RemoteException {
        AppDeleteRequestParams appDeleteRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2AppDeleteRequestParams != null) {
            parcel1.writeInt(1);
            param2AppDeleteRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ITsmCallback != null) {
            iBinder = param2ITsmCallback.asBinder();
          } else {
            param2AppDeleteRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2AppDeleteRequestParams);
          param2AppDeleteRequestParams = appDeleteRequestParams;
          if (param2ITsmProgressCallback != null)
            iBinder = param2ITsmProgressCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(14, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int appDownload(AppDownloadRequestParams param2AppDownloadRequestParams, ITsmCallback param2ITsmCallback, ITsmProgressCallback param2ITsmProgressCallback) throws RemoteException {
        AppDownloadRequestParams appDownloadRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2AppDownloadRequestParams != null) {
            parcel1.writeInt(1);
            param2AppDownloadRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ITsmCallback != null) {
            iBinder = param2ITsmCallback.asBinder();
          } else {
            param2AppDownloadRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2AppDownloadRequestParams);
          param2AppDownloadRequestParams = appDownloadRequestParams;
          if (param2ITsmProgressCallback != null)
            iBinder = param2ITsmProgressCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(13, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int appDownloadApply(AppDownloadApplyRequestParams param2AppDownloadApplyRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2AppDownloadApplyRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2AppDownloadApplyRequestParams);
        this.a.transact(12, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int appLock(AppLockRequestParams param2AppLockRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2AppLockRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2AppLockRequestParams);
        this.a.transact(16, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int appUnlock(AppUnlockRequestParams param2AppUnlockRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2AppUnlockRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2AppUnlockRequestParams);
        this.a.transact(17, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final int cardListStatusChanged(CardListStatusChangedRequestParams param2CardListStatusChangedRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2CardListStatusChangedRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2CardListStatusChangedRequestParams);
        this.a.transact(42, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int checkSSamsungPay(CheckSSamsungPayRequestParams param2CheckSSamsungPayRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2CheckSSamsungPayRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2CheckSSamsungPayRequestParams);
        this.a.transact(32, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int checkSupportCardApply(CheckSupportCardApplyRequestParams param2CheckSupportCardApplyRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2CheckSupportCardApplyRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2CheckSupportCardApplyRequestParams);
        this.a.transact(39, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int clearEncryptData(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          parcel1.writeInt(param2Int);
          this.a.transact(37, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int clearKeyboardEncryptData(ClearEncryptDataRequestParams param2ClearEncryptDataRequestParams, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2ClearEncryptDataRequestParams != null) {
            parcel1.writeInt(1);
            param2ClearEncryptDataRequestParams.writeToParcel(parcel1, 0);
            parcel1.writeInt(param2Int);
            this.a.transact(47, parcel1, parcel2, 0);
            parcel2.readException();
            param2Int = parcel2.readInt();
            return param2Int;
          } 
          parcel1.writeInt(0);
          parcel1.writeInt(param2Int);
          this.a.transact(47, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int closeChannel(CloseChannelRequestParams param2CloseChannelRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2CloseChannelRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2CloseChannelRequestParams);
        this.a.transact(28, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int eCashTopUp(ECashTopUpRequestParams param2ECashTopUpRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2ECashTopUpRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2ECashTopUpRequestParams);
        this.a.transact(19, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int encryptData(EncryptDataRequestParams param2EncryptDataRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2EncryptDataRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2EncryptDataRequestParams);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int exchangeKey(String param2String, String[] param2ArrayOfString) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          parcel1.writeString(param2String);
          if (param2ArrayOfString == null) {
            parcel1.writeInt(-1);
            this.a.transact(3, parcel1, parcel2, 0);
            parcel2.readException();
            int j = parcel2.readInt();
            parcel2.readStringArray(param2ArrayOfString);
            return j;
          } 
          parcel1.writeInt(param2ArrayOfString.length);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          parcel2.readStringArray(param2ArrayOfString);
          return i;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int executeCmd(ExecuteCmdRequestParams param2ExecuteCmdRequestParams, ITsmCallback param2ITsmCallback, ITsmProgressCallback param2ITsmProgressCallback) throws RemoteException {
        ExecuteCmdRequestParams executeCmdRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2ExecuteCmdRequestParams != null) {
            parcel1.writeInt(1);
            param2ExecuteCmdRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ITsmCallback != null) {
            iBinder = param2ITsmCallback.asBinder();
          } else {
            param2ExecuteCmdRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ExecuteCmdRequestParams);
          param2ExecuteCmdRequestParams = executeCmdRequestParams;
          if (param2ITsmProgressCallback != null)
            iBinder = param2ITsmProgressCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(30, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int getAccountBalance(GetAccountBalanceRequestParams param2GetAccountBalanceRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetAccountBalanceRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetAccountBalanceRequestParams);
        this.a.transact(22, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getAccountInfo(GetAccountInfoRequestParams param2GetAccountInfoRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetAccountInfoRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetAccountInfoRequestParams);
        this.a.transact(21, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getAppDetail(GetAppDetailRequestParams param2GetAppDetailRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetAppDetailRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetAppDetailRequestParams);
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getAppList(GetAppListRequestParams param2GetAppListRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetAppListRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetAppListRequestParams);
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getAppStatus(GetAppStatusRequestParams param2GetAppStatusRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetAppStatusRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetAppStatusRequestParams);
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getAssociatedApp(GetAssociatedAppRequestParams param2GetAssociatedAppRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetAssociatedAppRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetAssociatedAppRequestParams);
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getCardInfo(GetCardInfoRequestParams param2GetCardInfoRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetCardInfoRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetCardInfoRequestParams);
        this.a.transact(23, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams param2GetCardInfoBySpayRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetCardInfoBySpayRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetCardInfoBySpayRequestParams);
        this.a.transact(31, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getCurrentWalletClient(GetCurrentWalletClientRequestParams param2GetCurrentWalletClientRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetCurrentWalletClientRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetCurrentWalletClientRequestParams);
        this.a.transact(41, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getDefaultCard(GetDefaultCardRequestParams param2GetDefaultCardRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetDefaultCardRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetDefaultCardRequestParams);
        this.a.transact(25, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getEncryptData(GetEncryptDataRequestParams param2GetEncryptDataRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetEncryptDataRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetEncryptDataRequestParams);
        this.a.transact(36, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getPubKey(int param2Int, String[] param2ArrayOfString) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          parcel1.writeInt(param2Int);
          if (param2ArrayOfString == null) {
            parcel1.writeInt(-1);
            this.a.transact(2, parcel1, parcel2, 0);
            parcel2.readException();
            param2Int = parcel2.readInt();
            parcel2.readStringArray(param2ArrayOfString);
            return param2Int;
          } 
          parcel1.writeInt(param2ArrayOfString.length);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          parcel2.readStringArray(param2ArrayOfString);
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int getSEAppList(GetSeAppListRequestParams param2GetSeAppListRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetSeAppListRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetSeAppListRequestParams);
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getSEId(GetSeIdRequestParams param2GetSeIdRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetSeIdRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetSeIdRequestParams);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getSMSAuthCode(GetSMSAuthCodeRequestParams param2GetSMSAuthCodeRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetSMSAuthCodeRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetSMSAuthCodeRequestParams);
        this.a.transact(18, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getTransElements(GetTransElementsRequestParams param2GetTransElementsRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetTransElementsRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetTransElementsRequestParams);
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getTransRecord(GetTransRecordRequestParams param2GetTransRecordRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetTransRecordRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetTransRecordRequestParams);
        this.a.transact(20, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int getVendorPayStatus(GetVendorPayStatusRequestParams param2GetVendorPayStatusRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2GetVendorPayStatusRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2GetVendorPayStatusRequestParams);
        this.a.transact(43, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int hideAppApply(HideAppApplyRequestParams param2HideAppApplyRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2HideAppApplyRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2HideAppApplyRequestParams);
        this.a.transact(29, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int hideKeyboard() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          this.a.transact(38, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int hideSafetyKeyboard(HideSafetyKeyboardRequestParams param2HideSafetyKeyboardRequestParams) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2HideSafetyKeyboardRequestParams != null) {
            parcel1.writeInt(1);
            param2HideSafetyKeyboardRequestParams.writeToParcel(parcel1, 0);
            this.a.transact(48, parcel1, parcel2, 0);
            parcel2.readException();
            return parcel2.readInt();
          } 
          parcel1.writeInt(0);
          this.a.transact(48, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int init(InitRequestParams param2InitRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2InitRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2InitRequestParams);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int onlinePaymentVerify(OnlinePaymentVerifyRequestParams param2OnlinePaymentVerifyRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2OnlinePaymentVerifyRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2OnlinePaymentVerifyRequestParams);
        this.a.transact(46, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int openChannel(OpenChannelRequestParams param2OpenChannelRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2OpenChannelRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2OpenChannelRequestParams);
        this.a.transact(26, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int preDownload(PreDownloadRequestParams param2PreDownloadRequestParams, ITsmCallback param2ITsmCallback, ITsmProgressCallback param2ITsmProgressCallback) throws RemoteException {
        PreDownloadRequestParams preDownloadRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2PreDownloadRequestParams != null) {
            parcel1.writeInt(1);
            param2PreDownloadRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ITsmCallback != null) {
            iBinder = param2ITsmCallback.asBinder();
          } else {
            param2PreDownloadRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2PreDownloadRequestParams);
          param2PreDownloadRequestParams = preDownloadRequestParams;
          if (param2ITsmProgressCallback != null)
            iBinder = param2ITsmProgressCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(49, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int queryVendorPayStatus(QueryVendorPayStatusRequestParams param2QueryVendorPayStatusRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2QueryVendorPayStatusRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2QueryVendorPayStatusRequestParams);
        this.a.transact(50, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int sendApdu(SendApduRequestParams param2SendApduRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2SendApduRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2SendApduRequestParams);
        this.a.transact(27, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int setDefaultCard(SetDefaultCardRequestParams param2SetDefaultCardRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2SetDefaultCardRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2SetDefaultCardRequestParams);
        this.a.transact(24, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams param2SafetyKeyboardRequestParams) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2SafetyKeyboardRequestParams != null) {
            parcel1.writeInt(1);
            param2SafetyKeyboardRequestParams.writeToParcel(parcel1, 0);
            this.a.transact(35, parcel1, parcel2, 0);
            parcel2.readException();
            return parcel2.readInt();
          } 
          parcel1.writeInt(0);
          this.a.transact(35, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams param2SetSamsungDefWalletRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2SetSamsungDefWalletRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2SetSamsungDefWalletRequestParams);
        this.a.transact(33, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
      
      public final int showSafetyKeyboard(SafetyKeyboardRequestParams param2SafetyKeyboardRequestParams, int param2Int, OnSafetyKeyboardCallback param2OnSafetyKeyboardCallback, ITsmActivityCallback param2ITsmActivityCallback) throws RemoteException {
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = null;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
          if (param2SafetyKeyboardRequestParams != null) {
            parcel1.writeInt(1);
            param2SafetyKeyboardRequestParams.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeInt(param2Int);
          if (param2OnSafetyKeyboardCallback != null) {
            iBinder = param2OnSafetyKeyboardCallback.asBinder();
          } else {
            param2SafetyKeyboardRequestParams = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2SafetyKeyboardRequestParams);
          param2SafetyKeyboardRequestParams = safetyKeyboardRequestParams;
          if (param2ITsmActivityCallback != null)
            iBinder = param2ITsmActivityCallback.asBinder(); 
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(34, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final int startCardApply(StartCardApplyRequestParams param2StartCardApplyRequestParams, ITsmCallback param2ITsmCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        param2StartCardApplyRequestParams = null;
        parcel1.writeStrongBinder((IBinder)param2StartCardApplyRequestParams);
        this.a.transact(40, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.recycle();
        parcel1.recycle();
        return i;
      }
    }
  }
  
  private static final class a implements ITsmService {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final int activateVendorPay(ActivateVendorPayRequestParams param1ActivateVendorPayRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1ActivateVendorPayRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1ActivateVendorPayRequestParams);
      this.a.transact(44, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int addCardToVendorPay(AddCardToVendorPayRequestParams param1AddCardToVendorPayRequestParams, ITsmCallback param1ITsmCallback, ITsmProgressCallback param1ITsmProgressCallback) throws RemoteException {
      AddCardToVendorPayRequestParams addCardToVendorPayRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1AddCardToVendorPayRequestParams != null) {
          parcel1.writeInt(1);
          param1AddCardToVendorPayRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ITsmCallback != null) {
          iBinder = param1ITsmCallback.asBinder();
        } else {
          param1AddCardToVendorPayRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1AddCardToVendorPayRequestParams);
        param1AddCardToVendorPayRequestParams = addCardToVendorPayRequestParams;
        if (param1ITsmProgressCallback != null)
          iBinder = param1ITsmProgressCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(45, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int appDataUpdate(AppDataUpdateRequestParams param1AppDataUpdateRequestParams, ITsmCallback param1ITsmCallback, ITsmProgressCallback param1ITsmProgressCallback) throws RemoteException {
      AppDataUpdateRequestParams appDataUpdateRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1AppDataUpdateRequestParams != null) {
          parcel1.writeInt(1);
          param1AppDataUpdateRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ITsmCallback != null) {
          iBinder = param1ITsmCallback.asBinder();
        } else {
          param1AppDataUpdateRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1AppDataUpdateRequestParams);
        param1AppDataUpdateRequestParams = appDataUpdateRequestParams;
        if (param1ITsmProgressCallback != null)
          iBinder = param1ITsmProgressCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(15, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int appDelete(AppDeleteRequestParams param1AppDeleteRequestParams, ITsmCallback param1ITsmCallback, ITsmProgressCallback param1ITsmProgressCallback) throws RemoteException {
      AppDeleteRequestParams appDeleteRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1AppDeleteRequestParams != null) {
          parcel1.writeInt(1);
          param1AppDeleteRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ITsmCallback != null) {
          iBinder = param1ITsmCallback.asBinder();
        } else {
          param1AppDeleteRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1AppDeleteRequestParams);
        param1AppDeleteRequestParams = appDeleteRequestParams;
        if (param1ITsmProgressCallback != null)
          iBinder = param1ITsmProgressCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(14, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int appDownload(AppDownloadRequestParams param1AppDownloadRequestParams, ITsmCallback param1ITsmCallback, ITsmProgressCallback param1ITsmProgressCallback) throws RemoteException {
      AppDownloadRequestParams appDownloadRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1AppDownloadRequestParams != null) {
          parcel1.writeInt(1);
          param1AppDownloadRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ITsmCallback != null) {
          iBinder = param1ITsmCallback.asBinder();
        } else {
          param1AppDownloadRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1AppDownloadRequestParams);
        param1AppDownloadRequestParams = appDownloadRequestParams;
        if (param1ITsmProgressCallback != null)
          iBinder = param1ITsmProgressCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(13, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int appDownloadApply(AppDownloadApplyRequestParams param1AppDownloadApplyRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1AppDownloadApplyRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1AppDownloadApplyRequestParams);
      this.a.transact(12, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int appLock(AppLockRequestParams param1AppLockRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1AppLockRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1AppLockRequestParams);
      this.a.transact(16, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int appUnlock(AppUnlockRequestParams param1AppUnlockRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1AppUnlockRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1AppUnlockRequestParams);
      this.a.transact(17, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final int cardListStatusChanged(CardListStatusChangedRequestParams param1CardListStatusChangedRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1CardListStatusChangedRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1CardListStatusChangedRequestParams);
      this.a.transact(42, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int checkSSamsungPay(CheckSSamsungPayRequestParams param1CheckSSamsungPayRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1CheckSSamsungPayRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1CheckSSamsungPayRequestParams);
      this.a.transact(32, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int checkSupportCardApply(CheckSupportCardApplyRequestParams param1CheckSupportCardApplyRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1CheckSupportCardApplyRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1CheckSupportCardApplyRequestParams);
      this.a.transact(39, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int clearEncryptData(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        parcel1.writeInt(param1Int);
        this.a.transact(37, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int clearKeyboardEncryptData(ClearEncryptDataRequestParams param1ClearEncryptDataRequestParams, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1ClearEncryptDataRequestParams != null) {
          parcel1.writeInt(1);
          param1ClearEncryptDataRequestParams.writeToParcel(parcel1, 0);
          parcel1.writeInt(param1Int);
          this.a.transact(47, parcel1, parcel2, 0);
          parcel2.readException();
          param1Int = parcel2.readInt();
          return param1Int;
        } 
        parcel1.writeInt(0);
        parcel1.writeInt(param1Int);
        this.a.transact(47, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int closeChannel(CloseChannelRequestParams param1CloseChannelRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1CloseChannelRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1CloseChannelRequestParams);
      this.a.transact(28, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int eCashTopUp(ECashTopUpRequestParams param1ECashTopUpRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1ECashTopUpRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1ECashTopUpRequestParams);
      this.a.transact(19, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int encryptData(EncryptDataRequestParams param1EncryptDataRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1EncryptDataRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1EncryptDataRequestParams);
      this.a.transact(4, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int exchangeKey(String param1String, String[] param1ArrayOfString) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        parcel1.writeString(param1String);
        if (param1ArrayOfString == null) {
          parcel1.writeInt(-1);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          int j = parcel2.readInt();
          parcel2.readStringArray(param1ArrayOfString);
          return j;
        } 
        parcel1.writeInt(param1ArrayOfString.length);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        parcel2.readStringArray(param1ArrayOfString);
        return i;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int executeCmd(ExecuteCmdRequestParams param1ExecuteCmdRequestParams, ITsmCallback param1ITsmCallback, ITsmProgressCallback param1ITsmProgressCallback) throws RemoteException {
      ExecuteCmdRequestParams executeCmdRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1ExecuteCmdRequestParams != null) {
          parcel1.writeInt(1);
          param1ExecuteCmdRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ITsmCallback != null) {
          iBinder = param1ITsmCallback.asBinder();
        } else {
          param1ExecuteCmdRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ExecuteCmdRequestParams);
        param1ExecuteCmdRequestParams = executeCmdRequestParams;
        if (param1ITsmProgressCallback != null)
          iBinder = param1ITsmProgressCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(30, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int getAccountBalance(GetAccountBalanceRequestParams param1GetAccountBalanceRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetAccountBalanceRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetAccountBalanceRequestParams);
      this.a.transact(22, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getAccountInfo(GetAccountInfoRequestParams param1GetAccountInfoRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetAccountInfoRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetAccountInfoRequestParams);
      this.a.transact(21, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getAppDetail(GetAppDetailRequestParams param1GetAppDetailRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetAppDetailRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetAppDetailRequestParams);
      this.a.transact(10, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getAppList(GetAppListRequestParams param1GetAppListRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetAppListRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetAppListRequestParams);
      this.a.transact(8, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getAppStatus(GetAppStatusRequestParams param1GetAppStatusRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetAppStatusRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetAppStatusRequestParams);
      this.a.transact(9, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getAssociatedApp(GetAssociatedAppRequestParams param1GetAssociatedAppRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetAssociatedAppRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetAssociatedAppRequestParams);
      this.a.transact(6, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getCardInfo(GetCardInfoRequestParams param1GetCardInfoRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetCardInfoRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetCardInfoRequestParams);
      this.a.transact(23, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams param1GetCardInfoBySpayRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetCardInfoBySpayRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetCardInfoBySpayRequestParams);
      this.a.transact(31, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getCurrentWalletClient(GetCurrentWalletClientRequestParams param1GetCurrentWalletClientRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetCurrentWalletClientRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetCurrentWalletClientRequestParams);
      this.a.transact(41, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getDefaultCard(GetDefaultCardRequestParams param1GetDefaultCardRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetDefaultCardRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetDefaultCardRequestParams);
      this.a.transact(25, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getEncryptData(GetEncryptDataRequestParams param1GetEncryptDataRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetEncryptDataRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetEncryptDataRequestParams);
      this.a.transact(36, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getPubKey(int param1Int, String[] param1ArrayOfString) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        parcel1.writeInt(param1Int);
        if (param1ArrayOfString == null) {
          parcel1.writeInt(-1);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          param1Int = parcel2.readInt();
          parcel2.readStringArray(param1ArrayOfString);
          return param1Int;
        } 
        parcel1.writeInt(param1ArrayOfString.length);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        parcel2.readStringArray(param1ArrayOfString);
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int getSEAppList(GetSeAppListRequestParams param1GetSeAppListRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetSeAppListRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetSeAppListRequestParams);
      this.a.transact(7, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getSEId(GetSeIdRequestParams param1GetSeIdRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetSeIdRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetSeIdRequestParams);
      this.a.transact(5, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getSMSAuthCode(GetSMSAuthCodeRequestParams param1GetSMSAuthCodeRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetSMSAuthCodeRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetSMSAuthCodeRequestParams);
      this.a.transact(18, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getTransElements(GetTransElementsRequestParams param1GetTransElementsRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetTransElementsRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetTransElementsRequestParams);
      this.a.transact(11, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getTransRecord(GetTransRecordRequestParams param1GetTransRecordRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetTransRecordRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetTransRecordRequestParams);
      this.a.transact(20, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int getVendorPayStatus(GetVendorPayStatusRequestParams param1GetVendorPayStatusRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1GetVendorPayStatusRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1GetVendorPayStatusRequestParams);
      this.a.transact(43, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int hideAppApply(HideAppApplyRequestParams param1HideAppApplyRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1HideAppApplyRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1HideAppApplyRequestParams);
      this.a.transact(29, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int hideKeyboard() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        this.a.transact(38, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int hideSafetyKeyboard(HideSafetyKeyboardRequestParams param1HideSafetyKeyboardRequestParams) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1HideSafetyKeyboardRequestParams != null) {
          parcel1.writeInt(1);
          param1HideSafetyKeyboardRequestParams.writeToParcel(parcel1, 0);
          this.a.transact(48, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } 
        parcel1.writeInt(0);
        this.a.transact(48, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int init(InitRequestParams param1InitRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1InitRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1InitRequestParams);
      this.a.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int onlinePaymentVerify(OnlinePaymentVerifyRequestParams param1OnlinePaymentVerifyRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1OnlinePaymentVerifyRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1OnlinePaymentVerifyRequestParams);
      this.a.transact(46, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int openChannel(OpenChannelRequestParams param1OpenChannelRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1OpenChannelRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1OpenChannelRequestParams);
      this.a.transact(26, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int preDownload(PreDownloadRequestParams param1PreDownloadRequestParams, ITsmCallback param1ITsmCallback, ITsmProgressCallback param1ITsmProgressCallback) throws RemoteException {
      PreDownloadRequestParams preDownloadRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1PreDownloadRequestParams != null) {
          parcel1.writeInt(1);
          param1PreDownloadRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ITsmCallback != null) {
          iBinder = param1ITsmCallback.asBinder();
        } else {
          param1PreDownloadRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1PreDownloadRequestParams);
        param1PreDownloadRequestParams = preDownloadRequestParams;
        if (param1ITsmProgressCallback != null)
          iBinder = param1ITsmProgressCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(49, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int queryVendorPayStatus(QueryVendorPayStatusRequestParams param1QueryVendorPayStatusRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1QueryVendorPayStatusRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1QueryVendorPayStatusRequestParams);
      this.a.transact(50, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int sendApdu(SendApduRequestParams param1SendApduRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1SendApduRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1SendApduRequestParams);
      this.a.transact(27, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int setDefaultCard(SetDefaultCardRequestParams param1SetDefaultCardRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1SetDefaultCardRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1SetDefaultCardRequestParams);
      this.a.transact(24, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams param1SafetyKeyboardRequestParams) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1SafetyKeyboardRequestParams != null) {
          parcel1.writeInt(1);
          param1SafetyKeyboardRequestParams.writeToParcel(parcel1, 0);
          this.a.transact(35, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } 
        parcel1.writeInt(0);
        this.a.transact(35, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams param1SetSamsungDefWalletRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1SetSamsungDefWalletRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1SetSamsungDefWalletRequestParams);
      this.a.transact(33, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
    
    public final int showSafetyKeyboard(SafetyKeyboardRequestParams param1SafetyKeyboardRequestParams, int param1Int, OnSafetyKeyboardCallback param1OnSafetyKeyboardCallback, ITsmActivityCallback param1ITsmActivityCallback) throws RemoteException {
      SafetyKeyboardRequestParams safetyKeyboardRequestParams = null;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
        if (param1SafetyKeyboardRequestParams != null) {
          parcel1.writeInt(1);
          param1SafetyKeyboardRequestParams.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeInt(param1Int);
        if (param1OnSafetyKeyboardCallback != null) {
          iBinder = param1OnSafetyKeyboardCallback.asBinder();
        } else {
          param1SafetyKeyboardRequestParams = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1SafetyKeyboardRequestParams);
        param1SafetyKeyboardRequestParams = safetyKeyboardRequestParams;
        if (param1ITsmActivityCallback != null)
          iBinder = param1ITsmActivityCallback.asBinder(); 
        parcel1.writeStrongBinder(iBinder);
        this.a.transact(34, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final int startCardApply(StartCardApplyRequestParams param1StartCardApplyRequestParams, ITsmCallback param1ITsmCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      param1StartCardApplyRequestParams = null;
      parcel1.writeStrongBinder((IBinder)param1StartCardApplyRequestParams);
      this.a.transact(40, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      parcel2.recycle();
      parcel1.recycle();
      return i;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\ITsmService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
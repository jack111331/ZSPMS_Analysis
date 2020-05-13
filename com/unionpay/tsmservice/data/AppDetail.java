package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

public class AppDetail implements Parcelable {
  public static final Parcelable.Creator<AppDetail> CREATOR = new AppDetail$1();
  
  private String mApkDownloadUrl = "";
  
  private String mApkIcon = "";
  
  private String mApkName = "";
  
  private String mApkPackageName = "";
  
  private String mApkSign = "";
  
  private String mAppApplyId;
  
  private String mAppDesc = "";
  
  private AppID mAppID;
  
  private String mAppIcon = "";
  
  private String mAppName = "";
  
  private String mAppProviderAgreement = "";
  
  private String mAppProviderLogo = "";
  
  private String mAppProviderName = "";
  
  private String mApplyMode = "";
  
  private String mCallCenterNumber = "";
  
  private String mCardType = "";
  
  private long mDownloadTimes = 0L;
  
  private String mEmail = "";
  
  private String mIssuerName = "";
  
  private String mLastDigits = "";
  
  private String mMpan = "";
  
  private String mMpanId = "";
  
  private String mMpanStatus = "";
  
  private String mOpStatus = "";
  
  private String mPublishData = "";
  
  private String mPublishStatus = "";
  
  private String mQuota = "";
  
  private String mRechargeLowerLimit = "";
  
  private String mRechargeMode = "";
  
  private String mServicePhone = "";
  
  private AppStatus mStatus;
  
  private String mUpAgreement = "";
  
  private String mWebsite = "";
  
  public AppDetail() {}
  
  public AppDetail(Parcel paramParcel) {
    this.mAppID = (AppID)paramParcel.readParcelable(AppID.class.getClassLoader());
    this.mAppName = paramParcel.readString();
    this.mAppIcon = paramParcel.readString();
    this.mAppDesc = paramParcel.readString();
    this.mAppProviderLogo = paramParcel.readString();
    this.mAppProviderName = paramParcel.readString();
    this.mAppProviderAgreement = paramParcel.readString();
    this.mUpAgreement = paramParcel.readString();
    this.mApplyMode = paramParcel.readString();
    this.mServicePhone = paramParcel.readString();
    this.mDownloadTimes = paramParcel.readLong();
    this.mPublishData = paramParcel.readString();
    this.mPublishStatus = paramParcel.readString();
    this.mRechargeMode = paramParcel.readString();
    this.mRechargeLowerLimit = paramParcel.readString();
    this.mAppApplyId = paramParcel.readString();
    this.mStatus = (AppStatus)paramParcel.readParcelable(AppStatus.class.getClassLoader());
    this.mMpanId = paramParcel.readString();
    this.mMpan = paramParcel.readString();
    this.mCardType = paramParcel.readString();
    this.mIssuerName = paramParcel.readString();
    this.mLastDigits = paramParcel.readString();
    this.mMpanStatus = paramParcel.readString();
    this.mOpStatus = paramParcel.readString();
    this.mQuota = paramParcel.readString();
    this.mCallCenterNumber = paramParcel.readString();
    this.mEmail = paramParcel.readString();
    this.mWebsite = paramParcel.readString();
    this.mApkIcon = paramParcel.readString();
    this.mApkName = paramParcel.readString();
    this.mApkPackageName = paramParcel.readString();
    this.mApkDownloadUrl = paramParcel.readString();
    this.mApkSign = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getApkDownloadUrl() {
    return this.mApkDownloadUrl;
  }
  
  public String getApkIcon() {
    return this.mApkIcon;
  }
  
  public String getApkName() {
    return this.mApkName;
  }
  
  public String getApkPackageName() {
    return this.mApkPackageName;
  }
  
  public String getApkSign() {
    return this.mApkSign;
  }
  
  public String getAppApplyId() {
    return this.mAppApplyId;
  }
  
  public String getAppDesc() {
    return this.mAppDesc;
  }
  
  public AppID getAppID() {
    return this.mAppID;
  }
  
  public String getAppIcon() {
    return this.mAppIcon;
  }
  
  public String getAppName() {
    return this.mAppName;
  }
  
  public String getAppProviderAgreement() {
    return this.mAppProviderAgreement;
  }
  
  public String getAppProviderLogo() {
    return this.mAppProviderLogo;
  }
  
  public String getAppProviderName() {
    return this.mAppProviderName;
  }
  
  public String getApplyMode() {
    return this.mApplyMode;
  }
  
  public String getCallCenterNumber() {
    return this.mCallCenterNumber;
  }
  
  public String getCardType() {
    return this.mCardType;
  }
  
  public long getDownloadTimes() {
    return this.mDownloadTimes;
  }
  
  public String getEmail() {
    return this.mEmail;
  }
  
  public String getIssuerName() {
    return this.mIssuerName;
  }
  
  public String getLastDigits() {
    return this.mLastDigits;
  }
  
  public String getMpan() {
    return this.mMpan;
  }
  
  public String getMpanId() {
    return this.mMpanId;
  }
  
  public String getMpanStatus() {
    return this.mMpanStatus;
  }
  
  public String getOpStatus() {
    return this.mOpStatus;
  }
  
  public String getPublishData() {
    return this.mPublishData;
  }
  
  public String getPublishStatus() {
    return this.mPublishStatus;
  }
  
  public String getQuota() {
    return this.mQuota;
  }
  
  public String getRechargeLowerLimit() {
    return this.mRechargeLowerLimit;
  }
  
  public String getRechargeMode() {
    return this.mRechargeMode;
  }
  
  public String getServicePhone() {
    return this.mServicePhone;
  }
  
  public AppStatus getStatus() {
    return this.mStatus;
  }
  
  public String getUpAgreement() {
    return this.mUpAgreement;
  }
  
  public String getWebsite() {
    return this.mWebsite;
  }
  
  public void setApkDownloadUrl(String paramString) {
    this.mApkDownloadUrl = paramString;
  }
  
  public void setApkIcon(String paramString) {
    this.mApkIcon = paramString;
  }
  
  public void setApkName(String paramString) {
    this.mApkName = paramString;
  }
  
  public void setApkPackageName(String paramString) {
    this.mApkPackageName = paramString;
  }
  
  public void setApkSign(String paramString) {
    this.mApkSign = paramString;
  }
  
  public void setAppApplyId(String paramString) {
    this.mAppApplyId = paramString;
  }
  
  public void setAppDesc(String paramString) {
    this.mAppDesc = paramString;
  }
  
  public void setAppID(AppID paramAppID) {
    this.mAppID = paramAppID;
  }
  
  public void setAppIcon(String paramString) {
    this.mAppIcon = paramString;
  }
  
  public void setAppName(String paramString) {
    this.mAppName = paramString;
  }
  
  public void setAppProviderAgreement(String paramString) {
    this.mAppProviderAgreement = paramString;
  }
  
  public void setAppProviderLogo(String paramString) {
    this.mAppProviderLogo = paramString;
  }
  
  public void setAppProviderName(String paramString) {
    this.mAppProviderName = paramString;
  }
  
  public void setApplyMode(String paramString) {
    this.mApplyMode = paramString;
  }
  
  public void setCallCenterNumber(String paramString) {
    this.mCallCenterNumber = paramString;
  }
  
  public void setCardType(String paramString) {
    this.mCardType = paramString;
  }
  
  public void setDownloadTimes(long paramLong) {
    this.mDownloadTimes = paramLong;
  }
  
  public void setEmail(String paramString) {
    this.mEmail = paramString;
  }
  
  public void setIssuerName(String paramString) {
    this.mIssuerName = paramString;
  }
  
  public void setLastDigits(String paramString) {
    this.mLastDigits = paramString;
  }
  
  public void setMpan(String paramString) {
    this.mMpan = paramString;
  }
  
  public void setMpanId(String paramString) {
    this.mMpanId = paramString;
  }
  
  public void setMpanStatus(String paramString) {
    this.mMpanStatus = paramString;
  }
  
  public void setOpStatus(String paramString) {
    this.mOpStatus = paramString;
  }
  
  public void setPublishData(String paramString) {
    this.mPublishData = paramString;
  }
  
  public void setPublishStatus(String paramString) {
    this.mPublishStatus = paramString;
  }
  
  public void setQuota(String paramString) {
    this.mQuota = paramString;
  }
  
  public void setRechargeLowerLimit(String paramString) {
    this.mRechargeLowerLimit = paramString;
  }
  
  public void setRechargeMode(String paramString) {
    this.mRechargeMode = paramString;
  }
  
  public void setServicePhone(String paramString) {
    this.mServicePhone = paramString;
  }
  
  public void setStatus(AppStatus paramAppStatus) {
    this.mStatus = paramAppStatus;
  }
  
  public void setUpAgreement(String paramString) {
    this.mUpAgreement = paramString;
  }
  
  public void setWebsite(String paramString) {
    this.mWebsite = paramString;
  }
  
  public String toString() {
    return "AppDetail [mAppID=" + this.mAppID + ", mAppName=" + this.mAppName + ", mAppIcon=" + this.mAppIcon + ", mAppDesc=" + this.mAppDesc + ", mAppProviderLogo=" + this.mAppProviderLogo + ", mAppProviderName=" + this.mAppProviderName + ", mAppProviderAgreement=" + this.mAppProviderAgreement + ", mUpAgreement=" + this.mUpAgreement + ", mApplyMode=" + this.mApplyMode + ", mServicePhone=" + this.mServicePhone + ", mDownloadTimes=" + this.mDownloadTimes + ", mPublishData=" + this.mPublishData + ", mPublishStatus=" + this.mPublishStatus + ", mRechargeMode=" + this.mRechargeMode + ", mRechargeLowerLimit=" + this.mRechargeLowerLimit + ", mStatus=" + this.mStatus + ", mAppApplyId=" + this.mAppApplyId + ", mMpanId=" + this.mMpanId + ", mMpan=" + this.mMpan + ", mCardType=" + this.mCardType + ", mIssuerName=" + this.mIssuerName + ", mLastDigits=" + this.mLastDigits + ", mMpanStatus=" + this.mMpanStatus + ", mOpStatus=" + this.mOpStatus + ", mQuota=" + this.mQuota + ", mCallCenterNumber=" + this.mCallCenterNumber + ", mEmail=" + this.mEmail + ", mWebsite=" + this.mWebsite + ", mApkIcon=" + this.mApkIcon + ", mApkName=" + this.mApkName + ", mApkPackageName=" + this.mApkPackageName + ", mApkDownloadUrl=" + this.mApkDownloadUrl + ", mApkSign=" + this.mApkSign + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.mAppID, paramInt);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.mAppIcon);
    paramParcel.writeString(this.mAppDesc);
    paramParcel.writeString(this.mAppProviderLogo);
    paramParcel.writeString(this.mAppProviderName);
    paramParcel.writeString(this.mAppProviderAgreement);
    paramParcel.writeString(this.mUpAgreement);
    paramParcel.writeString(this.mApplyMode);
    paramParcel.writeString(this.mServicePhone);
    paramParcel.writeLong(this.mDownloadTimes);
    paramParcel.writeString(this.mPublishData);
    paramParcel.writeString(this.mPublishStatus);
    paramParcel.writeString(this.mRechargeMode);
    paramParcel.writeString(this.mRechargeLowerLimit);
    paramParcel.writeString(this.mAppApplyId);
    paramParcel.writeParcelable(this.mStatus, paramInt);
    paramParcel.writeString(this.mMpanId);
    paramParcel.writeString(this.mMpan);
    paramParcel.writeString(this.mCardType);
    paramParcel.writeString(this.mIssuerName);
    paramParcel.writeString(this.mLastDigits);
    paramParcel.writeString(this.mMpanStatus);
    paramParcel.writeString(this.mOpStatus);
    paramParcel.writeString(this.mQuota);
    paramParcel.writeString(this.mCallCenterNumber);
    paramParcel.writeString(this.mEmail);
    paramParcel.writeString(this.mWebsite);
    paramParcel.writeString(this.mApkIcon);
    paramParcel.writeString(this.mApkName);
    paramParcel.writeString(this.mApkPackageName);
    paramParcel.writeString(this.mApkDownloadUrl);
    paramParcel.writeString(this.mApkSign);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\AppDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
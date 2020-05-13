package com.unionpay.tsmservice.request;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.NinePatchInfo;
import java.util.ArrayList;

public class SafetyKeyboardRequestParams extends RequestParams {
  public static final Parcelable.Creator<SafetyKeyboardRequestParams> CREATOR = new SafetyKeyboardRequestParams$1();
  
  private int mConfirmBtnHeight;
  
  private int mConfirmBtnOutPaddingRight;
  
  private int mConfirmBtnWidth;
  
  private Bitmap mDelBgBitmap;
  
  private int mDelBgColor;
  
  private Bitmap mDelForeBitmap;
  
  private Bitmap mDoneBgBitmap;
  
  private int mDoneBgColor;
  
  private Bitmap mDoneForeBitmap;
  
  private int mDoneRight;
  
  private boolean mEnableLightStatusBar;
  
  private int mEnableOKBtn;
  
  private int mInnerPaddingBottom;
  
  private int mInnerPaddingLeft;
  
  private int mInnerPaddingRight;
  
  private int mInnerPaddingTop;
  
  private int mIsAudio;
  
  private int mIsDefaultPosition;
  
  private int mIsVibrate;
  
  private Bitmap mKeyboardBgBitmap;
  
  private int mKeyboardBgColor;
  
  private int mKeyboardHeight;
  
  private int mKeyboardWidth;
  
  private int mMarginCol;
  
  private int mMarginRow;
  
  private NinePatchInfo mNinePatchBackground;
  
  private NinePatchInfo mNinePatchDelKeyBg;
  
  private NinePatchInfo mNinePatchDoneKeyBg;
  
  private NinePatchInfo mNinePatchNumKeyBg;
  
  private NinePatchInfo mNinePatchTitleBg;
  
  private Bitmap mNumBgBitmap;
  
  private int mNumBgColor;
  
  private ArrayList<Bitmap> mNumForeBitmaps;
  
  private int mNumSize;
  
  private int mNumberKeyColor;
  
  private int mOutPaddingBottom;
  
  private int mOutPaddingLeft;
  
  private int mOutPaddingRight;
  
  private int mOutPaddingTop;
  
  private int mSecureHeight;
  
  private int mSecureWidth;
  
  private int mStartX;
  
  private int mStartY;
  
  private String mTitle;
  
  private Bitmap mTitleBgBitmap;
  
  private int mTitleBgColor;
  
  private int mTitleColor;
  
  private int mTitleDrawablePadding;
  
  private Bitmap mTitleDropBitmap;
  
  private int mTitleFont;
  
  private int mTitleHeight;
  
  private Bitmap mTitleIconBitmap;
  
  private int mTitleSize;
  
  public SafetyKeyboardRequestParams() {
    this.mKeyboardWidth = -1;
    this.mKeyboardHeight = -1;
    this.mTitleHeight = -1;
    this.mMarginRow = -1;
    this.mMarginCol = -1;
    this.mOutPaddingLeft = -1;
    this.mOutPaddingTop = -1;
    this.mOutPaddingRight = -1;
    this.mOutPaddingBottom = -1;
    this.mInnerPaddingLeft = -1;
    this.mInnerPaddingTop = -1;
    this.mInnerPaddingRight = -1;
    this.mInnerPaddingBottom = -1;
    this.mConfirmBtnOutPaddingRight = -1;
    this.mConfirmBtnWidth = -1;
    this.mConfirmBtnHeight = -1;
    this.mStartX = 0;
    this.mStartY = 0;
    this.mIsDefaultPosition = 1;
    this.mNumSize = -1;
    this.mKeyboardBgColor = -1;
    this.mTitleBgColor = -1;
    this.mDoneBgColor = -1;
    this.mDelBgColor = -1;
    this.mNumBgColor = -1;
    this.mIsAudio = 0;
    this.mEnableOKBtn = 1;
    this.mDoneRight = 0;
    this.mIsVibrate = 0;
    this.mSecureWidth = -1;
    this.mSecureHeight = -1;
    this.mTitleDrawablePadding = -1;
    this.mTitleColor = -1;
    this.mTitleSize = -1;
    this.mNumberKeyColor = -16777216;
    this.mEnableLightStatusBar = false;
  }
  
  public SafetyKeyboardRequestParams(Parcel paramParcel) {
    super(paramParcel);
    boolean bool;
    this.mKeyboardWidth = -1;
    this.mKeyboardHeight = -1;
    this.mTitleHeight = -1;
    this.mMarginRow = -1;
    this.mMarginCol = -1;
    this.mOutPaddingLeft = -1;
    this.mOutPaddingTop = -1;
    this.mOutPaddingRight = -1;
    this.mOutPaddingBottom = -1;
    this.mInnerPaddingLeft = -1;
    this.mInnerPaddingTop = -1;
    this.mInnerPaddingRight = -1;
    this.mInnerPaddingBottom = -1;
    this.mConfirmBtnOutPaddingRight = -1;
    this.mConfirmBtnWidth = -1;
    this.mConfirmBtnHeight = -1;
    this.mStartX = 0;
    this.mStartY = 0;
    this.mIsDefaultPosition = 1;
    this.mNumSize = -1;
    this.mKeyboardBgColor = -1;
    this.mTitleBgColor = -1;
    this.mDoneBgColor = -1;
    this.mDelBgColor = -1;
    this.mNumBgColor = -1;
    this.mIsAudio = 0;
    this.mEnableOKBtn = 1;
    this.mDoneRight = 0;
    this.mIsVibrate = 0;
    this.mSecureWidth = -1;
    this.mSecureHeight = -1;
    this.mTitleDrawablePadding = -1;
    this.mTitleColor = -1;
    this.mTitleSize = -1;
    this.mNumberKeyColor = -16777216;
    this.mEnableLightStatusBar = false;
    this.mTitle = paramParcel.readString();
    this.mKeyboardWidth = paramParcel.readInt();
    this.mKeyboardHeight = paramParcel.readInt();
    this.mTitleHeight = paramParcel.readInt();
    this.mMarginRow = paramParcel.readInt();
    this.mMarginCol = paramParcel.readInt();
    this.mOutPaddingLeft = paramParcel.readInt();
    this.mOutPaddingTop = paramParcel.readInt();
    this.mOutPaddingRight = paramParcel.readInt();
    this.mOutPaddingBottom = paramParcel.readInt();
    this.mInnerPaddingLeft = paramParcel.readInt();
    this.mInnerPaddingTop = paramParcel.readInt();
    this.mInnerPaddingRight = paramParcel.readInt();
    this.mInnerPaddingBottom = paramParcel.readInt();
    this.mConfirmBtnOutPaddingRight = paramParcel.readInt();
    this.mConfirmBtnWidth = paramParcel.readInt();
    this.mConfirmBtnHeight = paramParcel.readInt();
    this.mStartX = paramParcel.readInt();
    this.mStartY = paramParcel.readInt();
    this.mIsDefaultPosition = paramParcel.readInt();
    this.mNumSize = paramParcel.readInt();
    this.mKeyboardBgBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mTitleBgBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mTitleIconBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mTitleDropBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mDoneForeBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mDoneBgBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mDelForeBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mDelBgBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mNumBgBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mNumForeBitmaps = paramParcel.readArrayList(ArrayList.class.getClassLoader());
    this.mKeyboardBgColor = paramParcel.readInt();
    this.mTitleBgColor = paramParcel.readInt();
    this.mDoneBgColor = paramParcel.readInt();
    this.mDelBgColor = paramParcel.readInt();
    this.mNumBgColor = paramParcel.readInt();
    this.mIsAudio = paramParcel.readInt();
    this.mEnableOKBtn = paramParcel.readInt();
    this.mDoneRight = paramParcel.readInt();
    this.mIsVibrate = paramParcel.readInt();
    this.mSecureWidth = paramParcel.readInt();
    this.mSecureHeight = paramParcel.readInt();
    this.mTitleDrawablePadding = paramParcel.readInt();
    this.mTitleColor = paramParcel.readInt();
    this.mTitleSize = paramParcel.readInt();
    this.mNumberKeyColor = paramParcel.readInt();
    this.mNinePatchBackground = (NinePatchInfo)paramParcel.readParcelable(NinePatchInfo.class.getClassLoader());
    this.mNinePatchDelKeyBg = (NinePatchInfo)paramParcel.readParcelable(NinePatchInfo.class.getClassLoader());
    this.mNinePatchDoneKeyBg = (NinePatchInfo)paramParcel.readParcelable(NinePatchInfo.class.getClassLoader());
    this.mNinePatchNumKeyBg = (NinePatchInfo)paramParcel.readParcelable(NinePatchInfo.class.getClassLoader());
    this.mNinePatchTitleBg = (NinePatchInfo)paramParcel.readParcelable(NinePatchInfo.class.getClassLoader());
    if (paramParcel.readInt() == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mEnableLightStatusBar = bool;
  }
  
  public int getConfirmBtnHeight() {
    return this.mConfirmBtnHeight;
  }
  
  public int getConfirmBtnOutPaddingRight() {
    return this.mConfirmBtnOutPaddingRight;
  }
  
  public int getConfirmBtnWidth() {
    return this.mConfirmBtnWidth;
  }
  
  public int getDefaultPosition() {
    return this.mIsDefaultPosition;
  }
  
  public Bitmap getDelBgBitmap() {
    return this.mDelBgBitmap;
  }
  
  public int getDelBgColor() {
    return this.mDelBgColor;
  }
  
  public Bitmap getDelForeBitmap() {
    return this.mDelForeBitmap;
  }
  
  public NinePatchInfo getDelKeyBgNinePatch() {
    return this.mNinePatchDelKeyBg;
  }
  
  public Bitmap getDoneBgBitmap() {
    return this.mDoneBgBitmap;
  }
  
  public int getDoneBgColor() {
    return this.mDoneBgColor;
  }
  
  public Bitmap getDoneForeBitmap() {
    return this.mDoneForeBitmap;
  }
  
  public NinePatchInfo getDoneKeyBgNinePatch() {
    return this.mNinePatchDoneKeyBg;
  }
  
  public int getDoneRight() {
    return this.mDoneRight;
  }
  
  public int getEnableOKBtn() {
    return this.mEnableOKBtn;
  }
  
  public int getInnerPaddingBottom() {
    return this.mInnerPaddingBottom;
  }
  
  public int getInnerPaddingLeft() {
    return this.mInnerPaddingLeft;
  }
  
  public int getInnerPaddingRight() {
    return this.mInnerPaddingRight;
  }
  
  public int getInnerPaddingTop() {
    return this.mInnerPaddingTop;
  }
  
  public int getIsAudio() {
    return this.mIsAudio;
  }
  
  public int getIsVibrate() {
    return this.mIsVibrate;
  }
  
  public Bitmap getKeyboardBgBitmap() {
    return this.mKeyboardBgBitmap;
  }
  
  public int getKeyboardBgColor() {
    return this.mKeyboardBgColor;
  }
  
  public NinePatchInfo getKeyboardBgNinePatch() {
    return this.mNinePatchBackground;
  }
  
  public int getKeyboardHeight() {
    return this.mKeyboardHeight;
  }
  
  public int getKeyboardWidth() {
    return this.mKeyboardWidth;
  }
  
  public int getMarginCol() {
    return this.mMarginCol;
  }
  
  public int getMarginRow() {
    return this.mMarginRow;
  }
  
  public Bitmap getNumBgBitmap() {
    return this.mNumBgBitmap;
  }
  
  public int getNumBgColor() {
    return this.mNumBgColor;
  }
  
  public ArrayList<Bitmap> getNumForeBitmaps() {
    return this.mNumForeBitmaps;
  }
  
  public NinePatchInfo getNumKeyBgNinePatch() {
    return this.mNinePatchNumKeyBg;
  }
  
  public int getNumSize() {
    return this.mNumSize;
  }
  
  public int getNumberKeyColor() {
    return this.mNumberKeyColor;
  }
  
  public int getOutPaddingBottom() {
    return this.mOutPaddingBottom;
  }
  
  public int getOutPaddingLeft() {
    return this.mOutPaddingLeft;
  }
  
  public int getOutPaddingRight() {
    return this.mOutPaddingRight;
  }
  
  public int getOutPaddingTop() {
    return this.mOutPaddingTop;
  }
  
  public int getSecureHeight() {
    return this.mSecureHeight;
  }
  
  public int getSecureWidth() {
    return this.mSecureWidth;
  }
  
  public int getStartX() {
    return this.mStartX;
  }
  
  public int getStartY() {
    return this.mStartY;
  }
  
  public String getTitle() {
    return this.mTitle;
  }
  
  public Bitmap getTitleBgBitmap() {
    return this.mTitleBgBitmap;
  }
  
  public int getTitleBgColor() {
    return this.mTitleBgColor;
  }
  
  public NinePatchInfo getTitleBgNinePatch() {
    return this.mNinePatchTitleBg;
  }
  
  public int getTitleColor() {
    return this.mTitleColor;
  }
  
  public int getTitleDrawablePadding() {
    return this.mTitleDrawablePadding;
  }
  
  public Bitmap getTitleDropBitmap() {
    return this.mTitleDropBitmap;
  }
  
  public int getTitleFont() {
    return this.mTitleFont;
  }
  
  public int getTitleHeight() {
    return this.mTitleHeight;
  }
  
  public Bitmap getTitleIconBitmap() {
    return this.mTitleIconBitmap;
  }
  
  public int getTitleSize() {
    return this.mTitleSize;
  }
  
  public boolean isEnableLightStatusBar() {
    return this.mEnableLightStatusBar;
  }
  
  public void setConfirmBtnHeight(int paramInt) {
    this.mConfirmBtnHeight = paramInt;
  }
  
  public void setConfirmBtnOutPaddingRight(int paramInt) {
    this.mConfirmBtnOutPaddingRight = paramInt;
  }
  
  public void setConfirmBtnWidth(int paramInt) {
    this.mConfirmBtnWidth = paramInt;
  }
  
  public void setDefaultPosition(int paramInt) {
    this.mIsDefaultPosition = paramInt;
  }
  
  public void setDelBgBitmap(Bitmap paramBitmap) {
    this.mDelBgBitmap = paramBitmap;
  }
  
  public void setDelBgColor(int paramInt) {
    this.mDelBgColor = paramInt;
  }
  
  public void setDelForeBitmap(Bitmap paramBitmap) {
    this.mDelForeBitmap = paramBitmap;
  }
  
  public void setDelKeyBgNinePatch(NinePatchInfo paramNinePatchInfo) {
    this.mNinePatchDelKeyBg = paramNinePatchInfo;
  }
  
  public void setDoneBgBitmap(Bitmap paramBitmap) {
    this.mDoneBgBitmap = paramBitmap;
  }
  
  public void setDoneBgColor(int paramInt) {
    this.mDoneBgColor = paramInt;
  }
  
  public void setDoneForeBitmap(Bitmap paramBitmap) {
    this.mDoneForeBitmap = paramBitmap;
  }
  
  public void setDoneKeyBgNinePatch(NinePatchInfo paramNinePatchInfo) {
    this.mNinePatchDoneKeyBg = paramNinePatchInfo;
  }
  
  public void setDoneRight(int paramInt) {
    this.mDoneRight = paramInt;
  }
  
  public void setEnableLightStatusBar(boolean paramBoolean) {
    this.mEnableLightStatusBar = paramBoolean;
  }
  
  public void setEnableOKBtn(int paramInt) {
    this.mEnableOKBtn = paramInt;
  }
  
  public void setInnerPaddingBottom(int paramInt) {
    this.mInnerPaddingBottom = paramInt;
  }
  
  public void setInnerPaddingLeft(int paramInt) {
    this.mInnerPaddingLeft = paramInt;
  }
  
  public void setInnerPaddingRight(int paramInt) {
    this.mInnerPaddingRight = paramInt;
  }
  
  public void setInnerPaddingTop(int paramInt) {
    this.mInnerPaddingTop = paramInt;
  }
  
  public void setIsAudio(int paramInt) {
    this.mIsAudio = paramInt;
  }
  
  public void setIsVibrate(int paramInt) {
    this.mIsVibrate = paramInt;
  }
  
  public void setKeyboardBgBitmap(Bitmap paramBitmap) {
    this.mKeyboardBgBitmap = paramBitmap;
  }
  
  public void setKeyboardBgColor(int paramInt) {
    this.mKeyboardBgColor = paramInt;
  }
  
  public void setKeyboardBgNinePatch(NinePatchInfo paramNinePatchInfo) {
    this.mNinePatchBackground = paramNinePatchInfo;
  }
  
  public void setKeyboardHeight(int paramInt) {
    this.mKeyboardHeight = paramInt;
  }
  
  public void setKeyboardWidth(int paramInt) {
    this.mKeyboardWidth = paramInt;
  }
  
  public void setMarginCol(int paramInt) {
    this.mMarginCol = paramInt;
  }
  
  public void setMarginRow(int paramInt) {
    this.mMarginRow = paramInt;
  }
  
  public void setNumBgBitmap(Bitmap paramBitmap) {
    this.mNumBgBitmap = paramBitmap;
  }
  
  public void setNumBgColor(int paramInt) {
    this.mNumBgColor = paramInt;
  }
  
  public void setNumForeBitmaps(ArrayList<Bitmap> paramArrayList) {
    this.mNumForeBitmaps = paramArrayList;
  }
  
  public void setNumKeyBgNinePatch(NinePatchInfo paramNinePatchInfo) {
    this.mNinePatchNumKeyBg = paramNinePatchInfo;
  }
  
  public void setNumSize(int paramInt) {
    this.mNumSize = paramInt;
  }
  
  public void setNumberKeyColor(int paramInt) {
    this.mNumberKeyColor = paramInt;
  }
  
  public void setOutPaddingBottom(int paramInt) {
    this.mOutPaddingBottom = paramInt;
  }
  
  public void setOutPaddingLeft(int paramInt) {
    this.mOutPaddingLeft = paramInt;
  }
  
  public void setOutPaddingRight(int paramInt) {
    this.mOutPaddingRight = paramInt;
  }
  
  public void setOutPaddingTop(int paramInt) {
    this.mOutPaddingTop = paramInt;
  }
  
  public void setSecureHeight(int paramInt) {
    this.mSecureHeight = paramInt;
  }
  
  public void setSecureWidth(int paramInt) {
    this.mSecureWidth = paramInt;
  }
  
  public void setStartX(int paramInt) {
    this.mStartX = paramInt;
  }
  
  public void setStartY(int paramInt) {
    this.mStartY = paramInt;
  }
  
  public void setTitle(String paramString) {
    this.mTitle = paramString;
  }
  
  public void setTitleBgBitmap(Bitmap paramBitmap) {
    this.mTitleBgBitmap = paramBitmap;
  }
  
  public void setTitleBgColor(int paramInt) {
    this.mTitleBgColor = paramInt;
  }
  
  public void setTitleBgNinePatch(NinePatchInfo paramNinePatchInfo) {
    this.mNinePatchTitleBg = paramNinePatchInfo;
  }
  
  public void setTitleColor(int paramInt) {
    this.mTitleColor = paramInt;
  }
  
  public void setTitleDrawablePadding(int paramInt) {
    this.mTitleDrawablePadding = paramInt;
  }
  
  public void setTitleDropBitmap(Bitmap paramBitmap) {
    this.mTitleDropBitmap = paramBitmap;
  }
  
  public void setTitleFont(int paramInt) {
    this.mTitleFont = paramInt;
  }
  
  public void setTitleHeight(int paramInt) {
    this.mTitleHeight = paramInt;
  }
  
  public void setTitleIconBitmap(Bitmap paramBitmap) {
    this.mTitleIconBitmap = paramBitmap;
  }
  
  public void setTitleSize(int paramInt) {
    this.mTitleSize = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    boolean bool = true;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mKeyboardWidth);
    paramParcel.writeInt(this.mKeyboardHeight);
    paramParcel.writeInt(this.mTitleHeight);
    paramParcel.writeInt(this.mMarginRow);
    paramParcel.writeInt(this.mMarginCol);
    paramParcel.writeInt(this.mOutPaddingLeft);
    paramParcel.writeInt(this.mOutPaddingTop);
    paramParcel.writeInt(this.mOutPaddingRight);
    paramParcel.writeInt(this.mOutPaddingBottom);
    paramParcel.writeInt(this.mInnerPaddingLeft);
    paramParcel.writeInt(this.mInnerPaddingTop);
    paramParcel.writeInt(this.mInnerPaddingRight);
    paramParcel.writeInt(this.mInnerPaddingBottom);
    paramParcel.writeInt(this.mConfirmBtnOutPaddingRight);
    paramParcel.writeInt(this.mConfirmBtnWidth);
    paramParcel.writeInt(this.mConfirmBtnHeight);
    paramParcel.writeInt(this.mStartX);
    paramParcel.writeInt(this.mStartY);
    paramParcel.writeInt(this.mIsDefaultPosition);
    paramParcel.writeInt(this.mNumSize);
    paramParcel.writeParcelable((Parcelable)this.mKeyboardBgBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mTitleBgBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mTitleIconBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mTitleDropBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mDoneForeBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mDoneBgBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mDelForeBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mDelBgBitmap, 0);
    paramParcel.writeParcelable((Parcelable)this.mNumBgBitmap, 0);
    paramParcel.writeList(this.mNumForeBitmaps);
    paramParcel.writeInt(this.mKeyboardBgColor);
    paramParcel.writeInt(this.mTitleBgColor);
    paramParcel.writeInt(this.mDoneBgColor);
    paramParcel.writeInt(this.mDelBgColor);
    paramParcel.writeInt(this.mNumBgColor);
    paramParcel.writeInt(this.mIsAudio);
    paramParcel.writeInt(this.mEnableOKBtn);
    paramParcel.writeInt(this.mDoneRight);
    paramParcel.writeInt(this.mIsVibrate);
    paramParcel.writeInt(this.mSecureWidth);
    paramParcel.writeInt(this.mSecureHeight);
    paramParcel.writeInt(this.mTitleDrawablePadding);
    paramParcel.writeInt(this.mTitleColor);
    paramParcel.writeInt(this.mTitleSize);
    paramParcel.writeInt(this.mNumberKeyColor);
    paramParcel.writeParcelable((Parcelable)this.mNinePatchBackground, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mNinePatchDelKeyBg, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mNinePatchDoneKeyBg, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mNinePatchNumKeyBg, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mNinePatchTitleBg, paramInt);
    if (this.mEnableLightStatusBar == true) {
      paramInt = bool;
    } else {
      paramInt = 0;
    } 
    paramParcel.writeInt(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\SafetyKeyboardRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
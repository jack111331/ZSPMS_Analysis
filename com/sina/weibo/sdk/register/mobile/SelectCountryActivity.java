package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SelectCountryActivity extends Activity implements LetterIndexBar.OnIndexChangeListener {
  private static final String CHINA_CN = "中国";
  
  private static final String CHINA_EN = "China";
  
  private static final String CHINA_TW = "中國";
  
  public static final String EXTRA_COUNTRY_CODE = "code";
  
  public static final String EXTRA_COUNTRY_NAME = "name";
  
  private static final String INFO_CN = "常用";
  
  private static final String INFO_EN = "Common";
  
  private static final String INFO_TW = "常用";
  
  private static final String SELECT_COUNTRY_EN = "Region";
  
  private static final String SELECT_COUNTRY_ZH_CN = "选择国家";
  
  private static final String SELECT_COUNTRY_ZH_TW = "選擇國家";
  
  private List<Country>[] arrSubCountry;
  
  String countryStr = "";
  
  private List<IndexCountry> indexCountries = new ArrayList<IndexCountry>();
  
  private CountryAdapter mAdapter;
  
  private List<Country> mCountries;
  
  private FrameLayout mFrameLayout;
  
  private LetterIndexBar mLetterIndexBar;
  
  private ListView mListView;
  
  private RelativeLayout mMainLayout;
  
  private CountryList result;
  
  private List<IndexCountry> compose(List<Country>[] paramArrayOfList) {
    ArrayList<IndexCountry> arrayList = new ArrayList();
    if (paramArrayOfList != null)
      for (byte b = 0; b < paramArrayOfList.length; b++) {
        List<Country> list = paramArrayOfList[b];
        if (list != null && list.size() > 0)
          for (byte b1 = 0; b1 < list.size(); b1++) {
            if (b1 == 0)
              arrayList.add(new IndexCountry(b, -1)); 
            arrayList.add(new IndexCountry(b, b1));
          }  
      }  
    return arrayList;
  }
  
  private void initView() {
    this.mMainLayout = new RelativeLayout((Context)this);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    this.mMainLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    TitleBar titleBar = new TitleBar((Context)this);
    titleBar.setId(1);
    titleBar.setLeftBtnBg((Drawable)ResourceManager.createStateListDrawable((Context)this, "weibosdk_navigationbar_back.png", "weibosdk_navigationbar_back_highlighted.png"));
    titleBar.setTitleBarText(ResourceManager.getString((Context)this, "Region", "选择国家", "選擇國家"));
    titleBar.setTitleBarClickListener(new TitleBar.ListenerOnTitleBtnClicked() {
          public void onLeftBtnClicked() {
            SelectCountryActivity.this.setResult(0);
            SelectCountryActivity.this.finish();
          }
        });
    this.mMainLayout.addView((View)titleBar);
    this.mFrameLayout = new FrameLayout((Context)this);
    layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams2.addRule(3, titleBar.getId());
    this.mFrameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.mMainLayout.addView((View)this.mFrameLayout);
    this.mListView = new ListView((Context)this);
    AbsListView.LayoutParams layoutParams1 = new AbsListView.LayoutParams(-1, -1);
    this.mListView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.mListView.setFadingEdgeLength(0);
    this.mListView.setSelector((Drawable)new ColorDrawable(0));
    this.mListView.setDividerHeight(ResourceManager.dp2px((Context)this, 1));
    this.mListView.setCacheColorHint(0);
    this.mListView.setDrawSelectorOnTop(false);
    this.mListView.setScrollingCacheEnabled(false);
    this.mListView.setScrollbarFadingEnabled(false);
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            Country country = (Country)SelectCountryActivity.this.mAdapter.getItem(param1Int);
            if (country == null)
              return; 
            Intent intent = new Intent();
            intent.putExtra("code", country.getCode());
            intent.putExtra("name", country.getName());
            SelectCountryActivity.this.setResult(-1, intent);
            SelectCountryActivity.this.finish();
          }
        });
    this.mFrameLayout.addView((View)this.mListView);
    this.mAdapter = new CountryAdapter(null);
    this.mListView.setAdapter((ListAdapter)this.mAdapter);
    this.mLetterIndexBar = new LetterIndexBar((Context)this);
    this.mLetterIndexBar.setIndexChangeListener(this);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
    layoutParams.gravity = 5;
    this.mLetterIndexBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.mFrameLayout.addView(this.mLetterIndexBar);
    PinyinUtils.getInstance((Context)this);
    Locale locale = ResourceManager.getLanguage();
    if (Locale.SIMPLIFIED_CHINESE.equals(locale)) {
      this.countryStr = ResourceManager.readCountryFromAsset((Context)this, "countryCode.txt");
    } else if (Locale.TRADITIONAL_CHINESE.equals(locale)) {
      this.countryStr = ResourceManager.readCountryFromAsset((Context)this, "countryCodeTw.txt");
    } else {
      this.countryStr = ResourceManager.readCountryFromAsset((Context)this, "countryCodeEn.txt");
    } 
    this.result = new CountryList(this.countryStr);
    this.mCountries = this.result.countries;
    this.arrSubCountry = subCountries(this.mCountries);
    this.indexCountries = compose(this.arrSubCountry);
    this.mAdapter.notifyDataSetChanged();
    setContentView((View)this.mMainLayout);
  }
  
  private List<Country>[] subCountries(List<Country> paramList) {
    ArrayList[] arrayOfArrayList = new ArrayList[27];
    Country country = new Country();
    country.setCode("0086");
    country.setName(ResourceManager.getString((Context)this, "China", "中国", "中國"));
    arrayOfArrayList[0] = new ArrayList();
    arrayOfArrayList[0].add(country);
    for (byte b = 0;; b++) {
      if (b >= paramList.size())
        return (List<Country>[])arrayOfArrayList; 
      country = paramList.get(b);
      if (country.getCode().equals("00852") || country.getCode().equals("00853") || country.getCode().equals("00886")) {
        arrayOfArrayList[0].add(country);
      } else {
        int i = country.getPinyin().charAt(0) - 97 + 1;
        if (arrayOfArrayList[i] == null)
          arrayOfArrayList[i] = new ArrayList(); 
        arrayOfArrayList[i].add(country);
      } 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onDestroy() {
    super.onDestroy();
  }
  
  public void onIndexChange(int paramInt) {
    if (this.arrSubCountry != null && paramInt < this.arrSubCountry.length && this.arrSubCountry[paramInt] != null)
      this.mListView.setSelection(this.indexCountries.indexOf(new IndexCountry(paramInt, -1))); 
  }
  
  protected void onPause() {
    super.onPause();
  }
  
  private class CountryAdapter extends BaseAdapter {
    private CountryAdapter() {}
    
    private SelectCountryTitleView createTitleView(int param1Int) {
      SelectCountryTitleView selectCountryTitleView = new SelectCountryTitleView(SelectCountryActivity.this.getApplicationContext());
      if (param1Int == 0) {
        selectCountryTitleView.setTitle(ResourceManager.getString((Context)SelectCountryActivity.this, "Common", "常用", "常用"));
      } else {
        selectCountryTitleView.setTitle(String.valueOf((char)(param1Int + 65 - 1)));
      } 
      return selectCountryTitleView;
    }
    
    public int getCount() {
      return (SelectCountryActivity.this.indexCountries != null) ? SelectCountryActivity.this.indexCountries.size() : 0;
    }
    
    public Object getItem(int param1Int) {
      if (SelectCountryActivity.this.indexCountries == null || SelectCountryActivity.this.indexCountries.isEmpty())
        return null; 
      if (param1Int == SelectCountryActivity.this.indexCountries.size())
        return null; 
      SelectCountryActivity.IndexCountry indexCountry = SelectCountryActivity.this.indexCountries.get(param1Int);
      return (indexCountry.indexInList == -1) ? null : SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
    }
    
    public long getItemId(int param1Int) {
      return 0L;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      SelectCountryItemView selectCountryItemView;
      SelectCountryActivity.IndexCountry indexCountry = SelectCountryActivity.this.indexCountries.get(param1Int);
      if (param1View == null) {
        if (indexCountry.indexInList == -1) {
          SelectCountryTitleView selectCountryTitleView = createTitleView(indexCountry.indexInListArray);
        } else {
          Country country = SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
          selectCountryItemView = new SelectCountryItemView((Context)SelectCountryActivity.this, country.getName(), country.getCode());
        } 
      } else {
        SelectCountryTitleView selectCountryTitleView;
        if (indexCountry.indexInList == -1) {
          if (selectCountryItemView instanceof SelectCountryTitleView) {
            if (indexCountry.indexInListArray == 0) {
              ((SelectCountryTitleView)selectCountryItemView).update(ResourceManager.getString((Context)SelectCountryActivity.this, "Common", "常用", "常用"));
            } else {
              selectCountryTitleView = createTitleView(indexCountry.indexInListArray);
            } 
          } else {
            selectCountryTitleView = createTitleView(indexCountry.indexInListArray);
          } 
        } else {
          Country country = SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
          if (selectCountryTitleView instanceof SelectCountryTitleView) {
            selectCountryItemView = new SelectCountryItemView((Context)SelectCountryActivity.this, country.getName(), country.getCode());
          } else {
            selectCountryItemView.updateContent(country.getName(), country.getCode());
          } 
        } 
      } 
      return (View)selectCountryItemView;
    }
  }
  
  private class IndexCountry {
    int indexInList;
    
    int indexInListArray;
    
    IndexCountry(int param1Int1, int param1Int2) {
      this.indexInListArray = param1Int1;
      this.indexInList = param1Int2;
    }
    
    public boolean equals(Object param1Object) {
      if (!(param1Object instanceof IndexCountry))
        return false; 
      if (this.indexInList != -1)
        return false; 
      param1Object = param1Object;
      return (this.indexInListArray == ((IndexCountry)param1Object).indexInListArray && this.indexInList == ((IndexCountry)param1Object).indexInList);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\SelectCountryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
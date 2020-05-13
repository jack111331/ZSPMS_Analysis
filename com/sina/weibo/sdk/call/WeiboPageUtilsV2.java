package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public final class WeiboPageUtilsV2 {
  public static void displayInWeiboMap(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      String str1 = "";
      String str2 = "";
      String str3 = "";
      if (paramHashMap != null) {
        str1 = paramHashMap.get("longitude");
        str2 = paramHashMap.get("latitude");
        str3 = paramHashMap.get("offset");
      } 
      String str4 = null;
      String str5 = str4;
      if (paramHashMap != null) {
        str5 = str4;
        if (!TextUtils.isEmpty(paramHashMap.get("packagename")))
          str5 = paramHashMap.get("packagename"); 
      } 
      if (paramHashMap != null)
        openInWeiboBrowser(paramContext, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", new Object[] { str1, str2, str3 }), "default", paramHashMap.get("extparam"), str5); 
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void openInWeiboBrowser(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (TextUtils.isEmpty(paramString2) || "topnav".equals(paramString2) || "default".equals(paramString2) || "fullscreen".equals(paramString2)) {
          StringBuilder stringBuilder = new StringBuilder("sinaweibo://browser");
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("url", paramString1);
          hashMap.put("sinainternalbrowser", paramString2);
          hashMap.put("extparam", paramString3);
          stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
          if (!TextUtils.isEmpty(paramString4)) {
            (new StringBuilder("sinaweibo://browser")).append(CommonUtils.buildUriQuery((HashMap)hashMap));
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramString4);
          } else {
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
          } 
          return;
        } 
        throw new WeiboIllegalParameterException("sinainternalbrowser不合法");
      } 
      throw new WeiboIllegalParameterException("url不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void openQrcodeScanner(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://qrcode");
      if (paramHashMap != null)
        stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
      if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
        StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://qrcode");
        if (paramHashMap != null)
          stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
      } else {
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
      } 
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void postNewWeibo(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://sendweibo");
      if (paramHashMap != null)
        stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
      if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
        StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://sendweibo");
        if (paramHashMap != null)
          stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
      } else {
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
      } 
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewNearbyPeople(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://nearbypeople");
      if (paramHashMap != null)
        stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
      if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
        StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://nearbypeople");
        if (paramHashMap != null)
          stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
      } else {
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
      } 
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewNearbyWeibo(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://nearbyweibo");
      if (paramHashMap != null)
        stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
      if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
        StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://nearbyweibo");
        if (paramHashMap != null)
          stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
      } else {
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
      } 
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageDetailInfo(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null) {
        if (!TextUtils.isEmpty(paramHashMap.get("pageid"))) {
          if (!TextUtils.isEmpty(paramHashMap.get("cardid"))) {
            StringBuilder stringBuilder = new StringBuilder("sinaweibo://pagedetailinfo");
            if (paramHashMap != null)
              stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
            if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
              StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://pagedetailinfo");
              if (paramHashMap != null)
                stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
              CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
            } else {
              CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
            } 
            return;
          } 
          throw new WeiboIllegalParameterException("cardId不能为空");
        } 
        throw new WeiboIllegalParameterException("pageId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageInfo(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("pageid"))) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageinfo");
        if (paramHashMap != null)
          stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
        if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
          StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://pageinfo");
          if (paramHashMap != null)
            stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
        } else {
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
        } 
        return;
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPagePhotoList(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null) {
        if (!TextUtils.isEmpty(paramHashMap.get("pageid"))) {
          if (!TextUtils.isEmpty(paramHashMap.get("cardid"))) {
            byte b;
            try {
              b = Integer.parseInt(paramHashMap.get("count"));
            } catch (NumberFormatException numberFormatException) {
              b = -1;
            } 
            if (b >= 0) {
              StringBuilder stringBuilder = new StringBuilder("sinaweibo://pagephotolist");
              if (paramHashMap != null)
                stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
              if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
                StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://pagephotolist");
                if (paramHashMap != null)
                  stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
              } else {
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
              } 
              return;
            } 
            throw new WeiboIllegalParameterException("count不能为负数");
          } 
          throw new WeiboIllegalParameterException("cardId不能为空");
        } 
        throw new WeiboIllegalParameterException("pageId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageProductList(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null) {
        if (!TextUtils.isEmpty(paramHashMap.get("pageid"))) {
          if (!TextUtils.isEmpty(paramHashMap.get("cardid"))) {
            byte b;
            try {
              b = Integer.parseInt(paramHashMap.get("count"));
            } catch (NumberFormatException numberFormatException) {
              b = -1;
            } 
            if (b >= 0) {
              StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageproductlist");
              if (paramHashMap != null)
                stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
              if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
                StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://pageproductlist");
                if (paramHashMap != null)
                  stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
              } else {
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
              } 
              return;
            } 
            throw new WeiboIllegalParameterException("count不能为负数");
          } 
          throw new WeiboIllegalParameterException("cardId不能为空");
        } 
        throw new WeiboIllegalParameterException("pageId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageUserList(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null) {
        if (!TextUtils.isEmpty(paramHashMap.get("pageid"))) {
          if (!TextUtils.isEmpty(paramHashMap.get("cardid"))) {
            byte b;
            try {
              b = Integer.parseInt(paramHashMap.get("count"));
            } catch (NumberFormatException numberFormatException) {
              b = -1;
            } 
            if (b >= 0) {
              StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageuserlist");
              if (paramHashMap != null)
                stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
              if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
                StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://pageuserlist");
                if (paramHashMap != null)
                  stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
              } else {
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
              } 
              return;
            } 
            throw new WeiboIllegalParameterException("count不能为负数");
          } 
          throw new WeiboIllegalParameterException("cardId不能为空");
        } 
        throw new WeiboIllegalParameterException("pageId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageWeiboList(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null) {
        if (!TextUtils.isEmpty(paramHashMap.get("pageid"))) {
          if (!TextUtils.isEmpty(paramHashMap.get("cardid"))) {
            byte b;
            try {
              b = Integer.parseInt(paramHashMap.get("count"));
            } catch (NumberFormatException numberFormatException) {
              b = -1;
            } 
            if (b >= 0) {
              StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageweibolist");
              if (paramHashMap != null)
                stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
              if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
                StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://pageweibolist");
                if (paramHashMap != null)
                  stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
              } else {
                CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
              } 
              return;
            } 
            throw new WeiboIllegalParameterException("count不能为负数");
          } 
          throw new WeiboIllegalParameterException("cardId不能为空");
        } 
        throw new WeiboIllegalParameterException("pageId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewUserInfo(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null && (!TextUtils.isEmpty(paramHashMap.get("uid")) || !TextUtils.isEmpty(paramHashMap.get("nick")))) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://userinfo");
        if (paramHashMap != null)
          stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
        if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
          StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://userinfo");
          if (paramHashMap != null)
            stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
        } else {
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
        } 
        return;
      } 
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewUsertrends(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("uid"))) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://usertrends");
        if (paramHashMap != null)
          stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
        if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
          StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://usertrends");
          if (paramHashMap != null)
            stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
        } else {
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
        } 
        return;
      } 
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void weiboDetail(Context paramContext, HashMap<String, String> paramHashMap) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (paramHashMap != null) {
        if (!TextUtils.isEmpty(paramHashMap.get("mblogid"))) {
          StringBuilder stringBuilder = new StringBuilder("sinaweibo://detail");
          if (paramHashMap != null)
            stringBuilder.append(CommonUtils.buildUriQuery(paramHashMap)); 
          if (paramHashMap != null && !TextUtils.isEmpty(paramHashMap.get("packagename"))) {
            StringBuilder stringBuilder1 = new StringBuilder("sinaweibo://detail");
            if (paramHashMap != null)
              stringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap)); 
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), paramHashMap.get("packagename"));
          } else {
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString(), null);
          } 
          return;
        } 
        throw new WeiboIllegalParameterException("mblogId(微博id)不能为空");
      } 
      throw new WeiboIllegalParameterException("mblogId(微博id)不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\call\WeiboPageUtilsV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
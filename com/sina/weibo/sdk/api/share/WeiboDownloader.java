package com.sina.weibo.sdk.api.share;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sina.weibo.sdk.utils.Utility;

public class WeiboDownloader {
  private static final String CANCEL_CHINESS = "以后再说";
  
  private static final String CANCEL_ENGLISH = "Download Later";
  
  private static final String OK_CHINESS = "现在下载";
  
  private static final String OK_ENGLISH = "Download Now";
  
  private static final String PROMPT_CHINESS = "未安装微博客户端，是否现在去下载？";
  
  private static final String PROMPT_ENGLISH = "Sina Weibo client is not installed, download now?";
  
  private static final String TITLE_CHINESS = "提示";
  
  private static final String TITLE_ENGLISH = "Notice";
  
  public static Dialog createDownloadConfirmDialog(final Context context, final IWeiboDownloadListener listener) {
    String str1 = "提示";
    String str2 = "未安装微博客户端，是否现在去下载？";
    String str3 = "现在下载";
    String str4 = "以后再说";
    if (!Utility.isChineseLocale(context.getApplicationContext())) {
      str1 = "Notice";
      str2 = "Sina Weibo client is not installed, download now?";
      str3 = "Download Now";
      str4 = "Download Later";
    } 
    return (Dialog)(new AlertDialog.Builder(context)).setMessage(str2).setTitle(str1).setPositiveButton(str3, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            WeiboDownloader.downloadWeibo(context);
          }
        }).setNegativeButton(str4, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (listener != null)
              listener.onCancel(); 
          }
        }).create();
  }
  
  private static void downloadWeibo(Context paramContext) {
    Intent intent = new Intent();
    intent.setAction("android.intent.action.VIEW");
    intent.setFlags(268435456);
    intent.setData(Uri.parse("http://app.sina.cn/appdetail.php?appID=84560"));
    try {
      paramContext.startActivity(intent);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\share\WeiboDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
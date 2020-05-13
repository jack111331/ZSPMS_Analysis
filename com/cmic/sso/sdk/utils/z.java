package com.cmic.sso.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.widget.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class z {
  private static ArrayList<WeakReference<Activity>> a = null;
  
  public static int a(Context paramContext, float paramFloat) {
    int i;
    try {
      float f = (paramContext.getResources().getDisplayMetrics()).density;
      i = (int)(f * paramFloat + 0.5F);
    } catch (Exception exception) {
      i = (int)paramFloat;
    } 
    return i;
  }
  
  public static SpannableString a(Context paramContext, String paramString, a parama1, a parama2, a parama3) {
    String str1;
    ClickableSpan clickableSpan1;
    String str2;
    String str3;
    String str4;
    Object object;
    a a1 = null;
    SpannableString spannableString = new SpannableString(paramString);
    ClickableSpan clickableSpan2 = new ClickableSpan(paramContext, parama1) {
        public void onClick(View param1View) {
          if (this.b != null && !this.b.isShowing())
            this.b.show(); 
        }
        
        public void updateDrawState(TextPaint param1TextPaint) {
          super.updateDrawState(param1TextPaint);
          param1TextPaint.setUnderlineText(false);
          try {
            param1TextPaint.setColor(AuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
          } catch (Exception exception) {
            param1TextPaint.setColor(-16007674);
          } 
        }
      };
    if (parama2 != null) {
      object = new ClickableSpan(paramContext, parama2) {
          public void onClick(View param1View) {
            if (this.b != null && !this.b.isShowing())
              this.b.show(); 
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            super.updateDrawState(param1TextPaint);
            param1TextPaint.setUnderlineText(false);
            try {
              param1TextPaint.setColor(AuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (Exception exception) {
              param1TextPaint.setColor(-16007674);
            } 
          }
        };
    } else {
      object = null;
    } 
    parama1 = a1;
    if (parama3 != null)
      clickableSpan1 = new ClickableSpan(paramContext, parama3) {
          public void onClick(View param1View) {
            if (this.b != null && !this.b.isShowing())
              this.b.show(); 
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            super.updateDrawState(param1TextPaint);
            param1TextPaint.setUnderlineText(false);
            try {
              param1TextPaint.setColor(AuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (Exception exception) {
              param1TextPaint.setColor(-16007674);
            } 
          }
        }; 
    spannableString.setSpan(clickableSpan2, 5, 15, 34);
    if (parama2 != null && parama3 != null) {
      str4 = AuthnHelper.getInstance(paramContext).getAuthThemeConfig().getClauseName();
      str3 = str4.substring(0, 1);
      str4 = str4.substring(str4.length() - 1, str4.length());
      spannableString.setSpan(object, paramString.indexOf(str3, 15), paramString.indexOf(str4, 15) + 1, 34);
      int i = paramString.indexOf(str4, 15);
      str3 = AuthnHelper.getInstance(paramContext).getAuthThemeConfig().getClauseNameTwo();
      str1 = str3.substring(0, 1);
      str3 = str3.substring(str3.length() - 1, str3.length());
      spannableString.setSpan(clickableSpan1, paramString.indexOf(str1, i), paramString.indexOf(str3, i + 1) + 1, 34);
      return spannableString;
    } 
    if (str3 != null) {
      str2 = AuthnHelper.getInstance((Context)str1).getAuthThemeConfig().getClauseName();
      str1 = str2.substring(0, 1);
      str2 = str2.substring(str2.length() - 1, str2.length());
      spannableString.setSpan(object, paramString.indexOf(str1, 15), paramString.indexOf(str2, 15) + 1, 34);
      return spannableString;
    } 
    if (str4 != null) {
      str3 = AuthnHelper.getInstance((Context)str1).getAuthThemeConfig().getClauseNameTwo();
      str1 = str3.substring(0, 1);
      str3 = str3.substring(str3.length() - 1, str3.length());
      spannableString.setSpan(str2, paramString.indexOf(str1, 15), paramString.indexOf(str3, 15) + 1, 34);
    } 
    return spannableString;
  }
  
  public static RelativeLayout a(Context paramContext, int paramInt1, int paramInt2, String paramString, View.OnClickListener paramOnClickListener) {
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, a(paramContext, 49.0F));
    layoutParams1.addRule(10, -1);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    relativeLayout.setId(paramInt1);
    ImageButton imageButton = new ImageButton(paramContext);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(9, -1);
    layoutParams2.addRule(15, -1);
    layoutParams2.setMargins(a(paramContext, 12.0F), 0, 0, 0);
    imageButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    imageButton.setId(paramInt2);
    imageButton.setOnClickListener(paramOnClickListener);
    imageButton.setBackgroundColor(0);
    TextView textView = new TextView(paramContext);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13, -1);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    textView.setTextColor(-1);
    textView.setTextSize(2, 17.0F);
    relativeLayout.addView((View)imageButton);
    relativeLayout.addView((View)textView);
    try {
      relativeLayout.setBackgroundColor(AuthnHelper.getInstance(paramContext).getAuthThemeConfig().getNavColor());
    } catch (Exception exception) {
      relativeLayout.setBackgroundColor(-16742704);
    } 
    textView.setText(paramString);
    textView.setTextColor(AuthnHelper.getInstance(paramContext).getAuthThemeConfig().getNavTextColor());
    try {
      imageButton.setImageResource(p.a(paramContext, AuthnHelper.getInstance(paramContext).getAuthThemeConfig().getNavReturnImgPath()));
    } catch (Exception exception) {
      imageButton.setImageResource(p.a(paramContext, "umcsdk_return_bg"));
    } 
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    layoutParams.setMargins(paramInt2, paramInt1, paramInt3, paramInt4);
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
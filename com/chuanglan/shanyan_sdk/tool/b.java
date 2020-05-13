package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chuanglan.shanyan_sdk.utils.AbScreenUtils;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity;

public class b extends ClickableSpan {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private int g;
  
  private Context h;
  
  private int i;
  
  private String j;
  
  private b(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7) {
    this.h = paramContext;
    this.i = paramInt1;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramInt2;
    this.j = paramString7;
  }
  
  private static int a(Context paramContext, float paramFloat) {
    return (int)((paramContext.getResources().getDisplayMetrics()).density * paramFloat + 0.5F);
  }
  
  private static void a(Context paramContext, View paramView, float paramFloat1, float paramFloat2, float paramFloat3) {
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    layoutParams1.width = -2;
    layoutParams1.height = -2;
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams1);
    int i = a(paramContext, paramFloat1);
    int j = a(paramContext, paramFloat2);
    int k = a(paramContext, paramFloat3);
    if (paramFloat3 == -1.0D && paramFloat1 == -1.0D) {
      marginLayoutParams.setMargins(0, 0, 0, j);
    } else if (paramFloat3 != -1.0D && paramFloat1 == -1.0D) {
      marginLayoutParams.setMargins(k, 0, 0, j);
    } else if (paramFloat3 == -1.0D && paramFloat1 != -1.0D) {
      marginLayoutParams.setMargins(0, i, 0, 0);
    } else if (paramFloat3 != -1.0D && paramFloat1 != -1.0D) {
      marginLayoutParams.setMargins(k, i, 0, 0);
    } 
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginLayoutParams);
    if (paramFloat3 == -1.0D && paramFloat1 == -1.0D) {
      layoutParams.leftMargin = AbScreenUtils.dp2px(paramContext, 40.0F);
      layoutParams.rightMargin = AbScreenUtils.dp2px(paramContext, 60.0F);
      layoutParams.addRule(12);
      layoutParams.addRule(14);
    } else if (paramFloat3 != -1.0D && paramFloat1 == -1.0D) {
      layoutParams.leftMargin = AbScreenUtils.dp2px(paramContext, paramFloat3);
      layoutParams.rightMargin = AbScreenUtils.dp2px(paramContext, paramFloat3);
      layoutParams.addRule(12);
      layoutParams.addRule(9);
    } else if (paramFloat3 == -1.0D && paramFloat1 != -1.0D) {
      layoutParams.leftMargin = AbScreenUtils.dp2px(paramContext, 40.0F);
      layoutParams.rightMargin = AbScreenUtils.dp2px(paramContext, 60.0F);
      layoutParams.addRule(10);
      layoutParams.addRule(14);
    } else if (paramFloat3 != -1.0D && paramFloat1 != -1.0D) {
      layoutParams.leftMargin = AbScreenUtils.dp2px(paramContext, paramFloat3);
      layoutParams.rightMargin = AbScreenUtils.dp2px(paramContext, paramFloat3);
      layoutParams.addRule(10);
      layoutParams.addRule(9);
    } 
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5, String paramString7) {
    String str1 = AppSysMgr.getAppName(paramContext);
    String str2 = "";
    String str3 = "";
    ShanYanUIConfig shanYanUIConfig = l.a(paramContext).a();
    if (AppStringUtils.isEmpty(shanYanUIConfig.getPrivacyTextHead()) && AppStringUtils.isEmpty(shanYanUIConfig.getPrivacyTextMidOne()) && AppStringUtils.isEmpty(shanYanUIConfig.getPrivacyTextMidTwo()) && AppStringUtils.isEmpty(shanYanUIConfig.getPrivacyTextEnd())) {
      if (AppStringUtils.isNotEmpty(paramString2))
        str2 = "和《" + paramString2 + "》"; 
      String str = str3;
      if (AppStringUtils.isNotEmpty(paramString2)) {
        str = str3;
        if (AppStringUtils.isNotEmpty(paramString3))
          str = "、《" + paramString3 + "》"; 
      } 
      str3 = "同意《" + paramString1 + "》" + str2 + str + "并授权" + str1 + "获取本机号码";
    } else {
      if (AppStringUtils.isNotEmpty(paramString2))
        str2 = shanYanUIConfig.getPrivacyTextMidOne() + "《" + paramString2 + "》"; 
      String str = str3;
      if (AppStringUtils.isNotEmpty(paramString2)) {
        str = str3;
        if (AppStringUtils.isNotEmpty(paramString3))
          str = shanYanUIConfig.getPrivacyTextMidTwo() + "《" + paramString3 + "》"; 
      } 
      str3 = shanYanUIConfig.getPrivacyTextHead() + "《" + paramString1 + "》" + str2 + str + shanYanUIConfig.getPrivacyTextEnd();
    } 
    if (!str3.contains("《")) {
      paramTextView.setText(str3);
      return;
    } 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
    int i = 0;
    for (byte b1 = 0; str3.indexOf("《", i) != -1; b1++) {
      int j = str3.indexOf("《", i);
      i = str3.indexOf("》", j) + 1;
      if (i < j)
        continue; 
      spannableStringBuilder.setSpan(new b(paramContext, j, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramString7), j, i, 17);
    } 
    a(paramContext, paramView, paramInt3, paramInt4, paramInt5);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setTextColor(paramInt2);
    paramTextView.setHighlightColor(0);
    if (shanYanUIConfig.isPrivacyOffsetGravityLeft()) {
      paramTextView.setGravity(3);
    } else {
      paramTextView.setGravity(17);
    } 
    paramTextView.setText((CharSequence)spannableStringBuilder);
  }
  
  public void onClick(View paramView) {
    Intent intent;
    if (paramView instanceof TextView) {
      String str = ((TextView)paramView).getText().toString();
      int i = str.indexOf("》", this.i);
      str = str.substring(this.i + 1, i);
      if (str.equals(this.a)) {
        if (com.chuanglan.shanyan_sdk.b.R != null)
          com.chuanglan.shanyan_sdk.b.R.getOnClickPrivacyStatus(0, "" + this.a, this.j); 
        intent = new Intent(this.h, CTCCPrivacyProtocolActivity.class);
        intent.putExtra("url", this.d);
        intent.putExtra("title", this.a);
        intent.setFlags(268435456);
        this.h.startActivity(intent);
        return;
      } 
    } else {
      return;
    } 
    if (intent.equals(this.b)) {
      if (com.chuanglan.shanyan_sdk.b.R != null)
        com.chuanglan.shanyan_sdk.b.R.getOnClickPrivacyStatus(1, "" + this.b, this.j); 
      intent = new Intent(this.h, CTCCPrivacyProtocolActivity.class);
      intent.putExtra("url", this.e);
      intent.putExtra("title", this.b);
      intent.setFlags(268435456);
      this.h.startActivity(intent);
      return;
    } 
    if (intent.equals(this.c)) {
      if (com.chuanglan.shanyan_sdk.b.R != null)
        com.chuanglan.shanyan_sdk.b.R.getOnClickPrivacyStatus(2, "" + this.c, this.j); 
      intent = new Intent(this.h, CTCCPrivacyProtocolActivity.class);
      intent.putExtra("url", this.f);
      intent.putExtra("title", this.c);
      intent.setFlags(268435456);
      this.h.startActivity(intent);
    } 
  }
  
  public void updateDrawState(TextPaint paramTextPaint) {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.g);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
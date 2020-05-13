package com.zz.sdk.i;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig;
import com.chuanglan.shanyan_sdk.utils.AbScreenUtils;
import com.zz.sdk.a.bs;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.bx;
import com.zz.sdk.a.ds;
import com.zz.sdk.a.fc;
import com.zz.sdk.a.ht;
import com.zz.sdk.a.iz;
import com.zz.sdk.a.w;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ab;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.d.b;
import com.zz.sdk.e.hb;
import com.zz.sdk.lib.widget.EditTextWithDel;
import com.zz.sdk.lib.widget.a;
import com.zz.sdk.third.a.a;
import com.zz.sdk.third.b.c;
import com.zz.sdk.third.c;
import com.zz.sdk.third.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class h {
  private static fc a;
  
  private static ab b;
  
  private static int c = 0;
  
  private static long d = 0L;
  
  private static long e = 0L;
  
  public static ContentObserver a(Context paramContext, TextView paramTextView1, TextView paramTextView2) {
    try {
      cl cl2 = new cl();
      Handler handler = new Handler();
      m m = new m();
      this(paramTextView2);
      this(m);
      this(paramContext, handler);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, cl2);
      cl cl1 = cl2;
    } catch (Exception exception) {
      paramContext = null;
      exception.printStackTrace();
    } 
    return (ContentObserver)paramContext;
  }
  
  public static ShanYanUIConfig a(Context paramContext) {
    Button button = new Button(paramContext);
    button.setBackgroundResource(ci.a(paramContext, 2130837599));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.setMargins(AbScreenUtils.dp2px(paramContext, 19.0F), AbScreenUtils.dp2px(paramContext, 15.0F), 0, 0);
    layoutParams.width = AbScreenUtils.dp2px(paramContext, 11.0F);
    layoutParams.height = AbScreenUtils.dp2px(paramContext, 21.0F);
    layoutParams.addRule(9);
    button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    return (new ShanYanUIConfig.Builder()).setDialogTheme(true, 309, 272, 0, 0, false).setAuthNavHidden(true).setAuthBGImgPath(paramContext.getResources().getDrawable(ci.a(paramContext, 2130837656))).setLogoImgPath(paramContext.getResources().getDrawable(ci.a(paramContext, 2130837635))).setLogoWidth(160).setLogoHeight(41).setLogoOffsetY(20).setLogoHidden(false).setNumberColor(paramContext.getResources().getColor(ci.a(paramContext, 2131034273))).setNumFieldOffsetY(75).setNumberSize(20).setLogBtnText(paramContext.getString(ci.a(paramContext, 2131165269))).setLogBtnTextColor(paramContext.getResources().getColor(ci.a(paramContext, 2131034272))).setLogBtnImgPath(paramContext.getResources().getDrawable(ci.a(paramContext, 2130837657))).setLogBtnOffsetY(120).setLogBtnTextSize(17).setLogBtnHeight(40).setLogBtnWidth(250).setAppPrivacyOne("库洛游戏隐私政策", "file:////android_asset/zz_res/agreement.html").setAppPrivacyColor(paramContext.getResources().getColor(ci.a(paramContext, 2131034303)), paramContext.getResources().getColor(ci.a(paramContext, 2131034304))).setPrivacyOffsetBottomY(30).setCheckBoxHidden(true).setSloganHidden(true).addCustomView((View)button, true, false, null).build();
  }
  
  public static String a(v paramv) {
    if (paramv == null)
      return ""; 
    switch (paramv.h) {
      default:
        return paramv.b;
      case 1:
        return cv.q(paramv.b);
      case 2:
      case 3:
      case 4:
        break;
    } 
    String str2 = paramv.c().i();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = paramv.b; 
    return str1;
  }
  
  private static String a(Map paramMap) {
    ArrayList<Comparable> arrayList = new ArrayList(paramMap.keySet());
    JSONObject jSONObject = new JSONObject();
    Collections.sort(arrayList);
    for (Map.Entry entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      if (str == null)
        throw new NullPointerException("key == null"); 
      jSONObject.put(str, entry.getValue());
    } 
    String str1 = jSONObject.toString();
    bp.a("markDataFlag and json is " + str1);
    String str2 = Base64.encodeToString(str1.getBytes("UTF-8"), 2);
    bp.a("markDataFlag and json to base64 is " + str2);
    str1 = str2;
    if (str2.length() >= 51) {
      str1 = new String(a(str2.toCharArray(), new int[] { 1, 33, 10, 42, 18, 50, 19, 51 }));
      bp.a("markDataFlag and final data is " + str1);
    } 
    return str1;
  }
  
  private static String a(Map paramMap, boolean paramBoolean) {
    ArrayList<Comparable> arrayList = new ArrayList(paramMap.keySet());
    arrayList.remove("sign");
    Collections.sort(arrayList);
    StringBuilder stringBuilder = new StringBuilder(200);
    for (byte b = 0; b < arrayList.size(); b++) {
      String str1 = (String)arrayList.get(b);
      String str2 = (String)paramMap.get(str1);
      if (str1 != null && str1.length() > 0)
        stringBuilder.append(str1).append("=").append(str2).append('&'); 
    } 
    stringBuilder.append("512ad9adb653921086a4e753eb63c70f3");
    String str = stringBuilder.toString();
    bp.a("md5 before is " + str);
    return cn.a("MD5", new Object[] { str });
  }
  
  public static String a(boolean paramBoolean, String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (byte b = 1; b < paramVarArgs.length; b += 2) {
      if (paramVarArgs[b] != null && paramVarArgs[b - 1] != null)
        hashMap.put(paramVarArgs[b - 1], paramVarArgs[b]); 
    } 
    return a(hashMap, paramBoolean);
  }
  
  public static String a(Object... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (byte b = 1; b < paramVarArgs.length; b += 2) {
      if (paramVarArgs[b] != null && paramVarArgs[b - 1] != null)
        hashMap.put(paramVarArgs[b - 1] + "", paramVarArgs[b]); 
    } 
    return a(hashMap);
  }
  
  public static void a() {
    b = null;
  }
  
  public static void a(Activity paramActivity, String paramString) {
    if (a.a());
    hb hb = new hb((Context)paramActivity, paramString);
    bv.a(paramActivity, ht.class, (Map)bv.a().a("key_title", paramString).a("key_old_view", hb).a("key_overlay", Boolean.valueOf(false)));
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean) {
    cv.a(new q(paramContext, paramInt, paramBoolean));
  }
  
  public static void a(Context paramContext, ImageView paramImageView, boolean paramBoolean, Drawable paramDrawable1, Drawable paramDrawable2, View paramView) {
    if (paramBoolean) {
      if (paramImageView != null)
        paramImageView.setImageDrawable(paramDrawable1); 
      if (paramView != null)
        paramView.setBackgroundColor(paramContext.getResources().getColor(ci.a(paramContext, 2131034275))); 
      return;
    } 
    if (paramImageView != null)
      paramImageView.setImageDrawable(paramDrawable2); 
    if (paramView != null)
      paramView.setBackgroundColor(paramContext.getResources().getColor(ci.a(paramContext, 2131034288))); 
  }
  
  public static void a(Context paramContext, a parama, DialogInterface.OnClickListener paramOnClickListener) {
    if (parama != null && parama.e()) {
      if (paramContext instanceof Activity) {
        b b = bv.a((Activity)paramContext);
        if (b != null && !b.getClass().getName().equals(ds.class.getName())) {
          (new a(paramContext)).a(parama.f()).b(paramContext.getString(ci.a(paramContext, 2131165251)), paramOnClickListener).show();
          return;
        } 
      } 
      Toast.makeText(paramContext, parama.f(), 1).show();
      return;
    } 
    Toast.makeText(paramContext, ci.a(paramContext, 2131165246), 1).show();
  }
  
  public static void a(Context paramContext, a parama, v paramv, bx parambx, c paramc, w paramw) {
    if (parama != null && !parama.c() && parama.d() == 20001) {
      paramw.p();
      switch (paramv.h) {
        default:
          return;
        case 1:
          bv.a((Activity)paramContext, iz.class, (Map)parambx.a("phone", paramv.b));
          paramw.r();
        case 2:
          d.a((Activity)paramContext, c.a, paramc);
        case 3:
          d.a((Activity)paramContext, c.b, paramc);
        case 4:
          break;
      } 
      d.a((Activity)paramContext, c.c, paramc);
    } 
  }
  
  public static void a(Context paramContext, cq paramcq, a parama, w paramw) {
    a.a().a(paramContext, parama, new n(paramContext, paramw));
    paramw.b(null, true);
  }
  
  public static void a(Context paramContext, String paramString) {
    if (!bx.c(paramContext)) {
      try {
        if (paramContext instanceof Activity)
          bx.c((Activity)paramContext); 
      } catch (Exception exception) {
        bp.a(exception.toString());
      } 
      return;
    } 
    try {
      (bs.a((Context)exception)).p = paramString;
      Intent intent = new Intent();
      this();
      intent.setAction("android.intent.action.DIAL");
      StringBuilder stringBuilder = new StringBuilder();
      this();
      intent.setData(Uri.parse(stringBuilder.append("tel:").append(paramString).toString()));
      exception.startActivity(intent);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    cv.a(new p(paramContext, paramBoolean));
  }
  
  public static void a(View paramView) {
    if (paramView != null)
      paramView.setOnClickListener(new l(paramView)); 
  }
  
  public static void a(ImageView paramImageView) {
    if (a.a()) {
      paramImageView.setImageResource(ci.a(paramImageView.getContext(), 2130837636));
    } else {
      paramImageView.setImageResource(ci.a(paramImageView.getContext(), 2130837635));
    } 
    a((View)paramImageView);
  }
  
  public static void a(ImageView paramImageView, int paramInt) {
    Context context = paramImageView.getContext();
    switch (paramInt) {
      default:
        if (a.a()) {
          paramImageView.setImageResource(ci.a(context, 2130837663));
          return;
        } 
        break;
      case 1:
        paramImageView.setImageResource(ci.a(context, 2130837658));
        return;
      case 2:
        paramImageView.setImageResource(ci.a(context, 2130837661));
        return;
      case 3:
        paramImageView.setImageResource(ci.a(context, 2130837664));
        return;
      case 4:
        paramImageView.setImageResource(ci.a(context, 2130837627));
        return;
    } 
    paramImageView.setImageResource(ci.a(context, 2130837660));
  }
  
  public static void a(ImageView paramImageView, v paramv) {
    if (paramv != null) {
      Context context = paramImageView.getContext();
      if (paramv.h == 1) {
        paramImageView.setImageResource(ci.a(context, 2130837658));
        return;
      } 
      switch (paramv.i) {
        default:
          if (a.a()) {
            paramImageView.setImageResource(ci.a(context, 2130837663));
            return;
          } 
          break;
        case 1:
          paramImageView.setImageResource(ci.a(context, 2130837658));
          return;
        case 3:
          paramImageView.setImageResource(ci.a(context, 2130837663));
          return;
        case 5:
          paramImageView.setImageResource(ci.a(context, 2130837661));
          return;
        case 6:
          paramImageView.setImageResource(ci.a(context, 2130837664));
          return;
        case 7:
          paramImageView.setImageResource(ci.a(context, 2130837627));
          return;
      } 
      paramImageView.setImageResource(ci.a(context, 2130837660));
    } 
  }
  
  public static void a(TextView paramTextView) {
    if (paramTextView != null) {
      Context context = paramTextView.getContext();
      if (a.a()) {
        paramTextView.setText((CharSequence)Html.fromHtml(context.getString(ci.a(context, 2131165227))));
      } else {
        paramTextView.setText((CharSequence)Html.fromHtml(context.getString(ci.a(context, 2131165184))));
      } 
      paramTextView.setOnClickListener(new k());
    } 
  }
  
  public static void a(TextView paramTextView, int paramInt) {
    Context context = paramTextView.getContext();
    switch (paramInt) {
      default:
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(ci.a(context, 2130837628), 0, 0, 0);
        return;
      case 1:
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(ci.a(context, 2130837625), 0, 0, 0);
        return;
      case 2:
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(ci.a(context, 2130837626), 0, 0, 0);
        return;
      case 3:
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(ci.a(context, 2130837629), 0, 0, 0);
        return;
      case 4:
        break;
    } 
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(ci.a(context, 2130837627), 0, 0, 0);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {
    a(paramTextView1, true, paramTextView2, paramTextView3, paramLinearLayout1, paramLinearLayout2, paramLinearLayout3);
  }
  
  public static void a(TextView paramTextView, v paramv) {
    paramTextView.setText(a(paramv));
  }
  
  private static void a(TextView paramTextView, String paramString, LinearLayout paramLinearLayout) {
    if (paramTextView != null && paramLinearLayout != null && !TextUtils.isEmpty(paramString)) {
      paramLinearLayout.setVisibility(0);
      paramTextView.setText(paramString);
    } 
  }
  
  public static void a(TextView paramTextView1, boolean paramBoolean, TextView paramTextView2, TextView paramTextView3, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {
    Context context = paramTextView1.getContext();
    Handler handler = new Handler(context.getMainLooper());
    a((View)paramTextView2);
    if (b != null && b.c()) {
      b(paramTextView1, paramTextView2, paramTextView3, b, paramLinearLayout1, paramLinearLayout2, paramLinearLayout3);
      return;
    } 
    if (a.a()) {
      paramTextView1.setText(String.valueOf("028-69605988"));
      paramTextView2.setText(String.valueOf("ServiceGame@163.com"));
    } else {
      paramTextView1.setText("4009925888");
      paramTextView2.setText("kf@yingxiong.com");
    } 
    (new i(context, handler, paramTextView1, paramTextView2, paramTextView3, paramLinearLayout1, paramLinearLayout2, paramLinearLayout3)).start();
  }
  
  public static void a(ab paramab) {
    b = paramab;
  }
  
  public static boolean a(String paramString) {
    return a(paramString, "^((11)|(12)|(13)|(14)|(15)|(16)|(17)|(18)|(19))\\d{9}$");
  }
  
  public static boolean a(String paramString1, String paramString2) {
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString1))
      return false; 
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString2))
      try {
        bool2 = Pattern.compile(paramString2).matcher(paramString1).matches();
      } catch (Exception exception) {
        bool2 = bool1;
      }  
    return bool2;
  }
  
  public static boolean a(boolean paramBoolean, Context paramContext, EditTextWithDel paramEditTextWithDel, ImageView paramImageView) {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramBoolean) {
      try {
        PasswordTransformationMethod passwordTransformationMethod = new PasswordTransformationMethod();
        this();
        paramEditTextWithDel.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
        paramImageView.setImageDrawable(ca.cM.a(paramContext));
        paramBoolean = bool2;
        if (!TextUtils.isEmpty(paramEditTextWithDel.getText().toString().trim())) {
          paramEditTextWithDel.setSelection(paramEditTextWithDel.getText().toString().trim().length());
          paramBoolean = bool2;
        } 
        return paramBoolean;
      } catch (Throwable null) {
        paramBoolean = bool1;
      } 
    } else {
      paramEditTextWithDel.setTransformationMethod(null);
      paramImageView.setImageDrawable(ca.cL.a((Context)throwable));
      try {
        if (!TextUtils.isEmpty(paramEditTextWithDel.getText().toString().trim()))
          paramEditTextWithDel.setSelection(paramEditTextWithDel.getText().toString().trim().length()); 
        paramBoolean = true;
      } catch (Throwable throwable) {
        paramBoolean = true;
      } 
      return paramBoolean;
    } 
    throwable.printStackTrace();
    return paramBoolean;
  }
  
  public static boolean a(boolean paramBoolean, ImageView paramImageView) {
    if (paramImageView != null) {
      if (paramBoolean) {
        paramBoolean = true;
        paramImageView.setVisibility(0);
        return paramBoolean;
      } 
      paramImageView.setVisibility(8);
    } 
    return false;
  }
  
  public static char[] a(char[] paramArrayOfchar, int... paramVarArgs) {
    for (byte b = 1; b < paramVarArgs.length; b += 2) {
      int i = paramVarArgs[b - 1];
      int j = paramVarArgs[b];
      char c = paramArrayOfchar[i];
      paramArrayOfchar[i] = (char)paramArrayOfchar[j];
      paramArrayOfchar[j] = (char)c;
    } 
    return paramArrayOfchar;
  }
  
  public static ab b() {
    return b;
  }
  
  public static String b(Context paramContext) {
    Locale locale2 = (paramContext.getResources().getConfiguration()).locale;
    Locale locale1 = locale2;
    if (locale2 == null)
      locale1 = Locale.getDefault(); 
    String str = locale1.getLanguage();
    null = locale1.getCountry();
    return !TextUtils.isEmpty(null) ? (str + "_" + null) : str;
  }
  
  public static String b(Context paramContext, String paramString) {
    if (!a(paramString)) {
      Toast.makeText(paramContext, ci.a(paramContext, 2131165248), 1).show();
      paramString = null;
    } 
    return paramString;
  }
  
  public static String b(TextView paramTextView) {
    Context context = paramTextView.getContext();
    String str = paramTextView.getText() + "";
    if (!a(str)) {
      Toast.makeText(context, ci.a(context, 2131165248), 1).show();
      str = null;
    } 
    return str;
  }
  
  public static String b(v paramv) {
    if (paramv == null)
      return ""; 
    if (paramv.h == 1)
      return cv.q(paramv.b); 
    switch (paramv.i) {
      default:
        return paramv.b;
      case 1:
        return cv.q(paramv.b);
      case 5:
      case 6:
      case 7:
        break;
    } 
    String str2 = paramv.c().i();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = paramv.b; 
    return str1;
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, ab paramab, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {
    if (a.a()) {
      a(paramTextView1, paramab.k(), paramLinearLayout1);
      a(paramTextView3, paramab.h(), paramLinearLayout3);
      return;
    } 
    a(paramTextView1, paramab.m(), paramLinearLayout1);
    a(paramTextView3, paramab.i(), paramLinearLayout3);
  }
  
  public static void b(TextView paramTextView, v paramv) {
    if (paramTextView != null)
      paramTextView.setText(b(paramv)); 
  }
  
  public static boolean b(String paramString) {
    boolean bool;
    try {
      bool = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$").matcher(paramString).matches();
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean b(boolean paramBoolean, Context paramContext, EditTextWithDel paramEditTextWithDel, ImageView paramImageView) {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramBoolean) {
      try {
        PasswordTransformationMethod passwordTransformationMethod = new PasswordTransformationMethod();
        this();
        paramEditTextWithDel.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
        paramImageView.setImageResource(ci.a(paramContext, 2130837608));
        paramBoolean = bool2;
        if (!TextUtils.isEmpty(paramEditTextWithDel.getText().toString().trim())) {
          paramEditTextWithDel.setSelection(paramEditTextWithDel.getText().toString().trim().length());
          paramBoolean = bool2;
        } 
        return paramBoolean;
      } catch (Throwable null) {
        paramBoolean = bool1;
      } 
    } else {
      paramEditTextWithDel.setTransformationMethod(null);
      paramImageView.setImageResource(ci.a((Context)throwable, 2130837639));
      try {
        if (!TextUtils.isEmpty(paramEditTextWithDel.getText().toString().trim()))
          paramEditTextWithDel.setSelection(paramEditTextWithDel.getText().toString().trim().length()); 
        paramBoolean = true;
      } catch (Throwable throwable) {
        paramBoolean = true;
      } 
      return paramBoolean;
    } 
    throwable.printStackTrace();
    return paramBoolean;
  }
  
  public static String c(TextView paramTextView) {
    Context context = paramTextView.getContext();
    String str = paramTextView.getText() + "";
    if (!b(str)) {
      Toast.makeText(context, ci.a(context, 2131165334), 1).show();
      str = null;
    } 
    return str;
  }
  
  public static void c() {
    cv.a(new r());
  }
  
  public static void c(Context paramContext, String paramString) {
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
    Toast.makeText(paramContext, paramContext.getString(ci.a(paramContext, 2131165310)), 1).show();
  }
  
  public static boolean c(Context paramContext) {
    return (System.currentTimeMillis() - cm.c(paramContext) > v.A);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
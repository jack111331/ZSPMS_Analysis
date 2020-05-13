package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.bean.e;
import com.herosdk.d.az;
import com.herosdk.d.bb;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IPayListener;
import org.json.JSONObject;

class z implements Runnable {
  z(a parama, Context paramContext, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString, IPayListener paramIPayListener) {}
  
  public void run() {
    try {
      String str;
      UserInfo userInfo = x.a().h();
      ar ar = a.a(this.f).a(this.a, userInfo.getUid(), userInfo.getUsername(), userInfo.getChannelToken(), this.b, this.c, this.d);
      if (ar != null && ar.b()) {
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0) {
          i = jSONObject.optInt("idStat", 0);
          x.a().c(i);
          String str1 = a.b();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          Log.d(str1, stringBuilder.append("rp is:").append(i).toString());
          str1 = jSONObject.optString("order");
          this.b.setSdkOrderId(str1);
          String str2 = jSONObject.optString("goodsId");
          if (!TextUtils.isEmpty(str2))
            this.b.setGoodsId(str2); 
          this.b.setAmount(jSONObject.optDouble("amount"));
          this.b.setPrice(jSONObject.optDouble("price"));
          this.b.setCount(jSONObject.optInt("goodsNum"));
          this.b.setGoodsName(jSONObject.optString("goodsName"));
          this.b.setGoodsDesc(jSONObject.optString("goodsDesc"));
          this.b.setCallbackUrl(jSONObject.optString("callbackUrl"));
          this.b.setServerMessage(jSONObject.optString("serverMsg"));
          this.b.setExtraParams(jSONObject.optString("customMsg"));
          if (jSONObject.optInt("paySwitch", -1) == 1) {
            x x = x.a();
            e e = new e();
            this(Boolean.valueOf(true), jSONObject.optString("paySwitchUrl"));
            x.e(e);
          } else {
            x x = x.a();
            e e = new e();
            this(Boolean.valueOf(false), jSONObject.optString("paySwitchUrl"));
            x.e(e);
          } 
          jSONObject.put("cpOrderId", this.b.getCpOrderId());
          x.a().e(jSONObject.toString());
          Log.d(a.b(), "rp success...notify success");
          this.e.onSuccess(str1, this.b.getCpOrderId(), this.b.getExtraParams());
        } else if (i == 1001) {
          Log.d(a.b(), "rp rak");
          this.f.a(this.a);
        } else if (i == 1002) {
          Log.d(a.b(), "rp ate");
          x.a().Q();
        } else if (i == 1004) {
          Log.d(a.b(), "rp nk");
          if (!az.b.booleanValue()) {
            Log.d(a.b(), "rp nk...if");
            x.a().g(true);
            str = jSONObject.optString("msg");
            if (HeroSdk.getInstance().getChannelAccountOffLineListener() != null)
              HeroSdk.getInstance().getChannelAccountOffLineListener().onKick(0, str); 
            if (HeroSdk.getInstance().getKickListener() != null)
              HeroSdk.getInstance().getKickListener().onKick(0, str); 
          } 
        } else if (i == 1005) {
          Log.d(a.b(), "rp np");
          str = str.optString("msg");
          if (!TextUtils.isEmpty(str)) {
            aa aa = new aa();
            this(this, str, i);
            bb.a(aa);
          } else {
            Log.d(a.b(), "rp np...else msg is empty");
            IPayListener iPayListener = this.e;
            String str1 = this.b.getCpOrderId();
            StringBuilder stringBuilder = new StringBuilder();
            this();
            iPayListener.onFailed(str1, stringBuilder.append("code:").append(i).append(",msg:").append(str).toString());
          } 
        } else {
          str = str.optString("msg");
          IPayListener iPayListener = this.e;
          String str1 = this.b.getCpOrderId();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          iPayListener.onFailed(str1, stringBuilder.append("code:").append(i).append(",msg:").append(str).toString());
          str1 = a.b();
          stringBuilder = new StringBuilder();
          this();
          Log.d(str1, stringBuilder.append("rp failed code:").append(i).append(",msg:").append(str).toString());
        } 
      } else {
        String str1 = a.b();
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        Log.e(str1, stringBuilder2.append("do rp but error:").append(str.a()).toString());
        IPayListener iPayListener = this.e;
        String str2 = this.b.getCpOrderId();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        iPayListener.onFailed(str2, stringBuilder1.append("code:").append(str.a()).toString());
      } 
      return;
    } catch (Exception exception) {
      Log.d(a.b(), "rp ex");
      ErrorUtils.printExceptionInfo(exception);
      IPayListener iPayListener = this.e;
      String str = this.b.getCpOrderId();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      iPayListener.onFailed(str, stringBuilder.append("code:-100,msg:").append(exception.getMessage()).toString());
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
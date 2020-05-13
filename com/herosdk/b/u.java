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

class u implements Runnable {
  u(a parama, IPayListener paramIPayListener, OrderInfo paramOrderInfo, Context paramContext, RoleInfo paramRoleInfo, String paramString) {}
  
  public void run() {
    try {
      String str1;
      if (this.a == null) {
        Log.e(a.b(), "p listener is null");
        return;
      } 
      UserInfo userInfo = x.a().h();
      if (userInfo == null) {
        Log.e(a.b(), "用户未登录");
        this.a.onFailed(this.b.getCpOrderId(), "用户未登录");
        return;
      } 
      String str2 = a.b();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d(str2, stringBuilder.append("p cp gId:").append(this.b.getGoodsId()).toString());
      ar ar = a.a(this.f).a(this.c, userInfo.getUid(), userInfo.getUsername(), userInfo.getChannelToken(), this.b, this.d, this.e);
      if (ar != null && ar.b()) {
        w w;
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0 || i == 1003) {
          int j = jSONObject.optInt("idStat", 0);
          x.a().c(j);
          String str = a.b();
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          Log.d(str, stringBuilder1.append("p is:").append(j).toString());
          if (j == 0) {
            str = jSONObject.optString("order");
            this.b.setSdkOrderId(str);
            String str3 = jSONObject.optString("goodsId");
            if (!TextUtils.isEmpty(str3))
              this.b.setGoodsId(str3); 
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
            this.a.onSuccess(str, this.b.getCpOrderId(), this.b.getExtraParams());
          } else {
            int k = jSONObject.optInt("cIdStat", 0);
            str = a.b();
            stringBuilder1 = new StringBuilder();
            this();
            Log.d(str, stringBuilder1.append("p cis:").append(k).toString());
            if (k == 1) {
              str1 = jSONObject.optString("idStatMsg", "");
              String str3 = a.b();
              StringBuilder stringBuilder2 = new StringBuilder();
              this();
              Log.d(str3, stringBuilder2.append("p c isMsg:").append(str1).toString());
              if (HeroSdk.getInstance().getIdentifyPayListener() != null) {
                Log.d(a.b(), "p c onResult");
                HeroSdk.getInstance().getIdentifyPayListener().onResult(this.a, this.b, this.d, this.e, j, str1);
              } else {
                Log.d(a.b(), "p c onFailed");
                IPayListener iPayListener = this.a;
                String str4 = this.b.getCpOrderId();
                StringBuilder stringBuilder3 = new StringBuilder();
                this();
                iPayListener.onFailed(str4, stringBuilder3.append("code:").append(i).append(",msg:").append(str1).toString());
                if (!TextUtils.isEmpty(str1)) {
                  v v = new v();
                  this(this, str1);
                  bb.a(v);
                } 
              } 
            } else if (!az.a.booleanValue()) {
              w = new w();
              this(this);
              bb.a(j, w);
            } 
          } 
        } else if (i == 1001) {
          Log.d(a.b(), "p rak");
          this.f.a(this.c);
        } else if (i == 1002) {
          Log.d(a.b(), "p ate");
          x.a().Q();
        } else if (i == 1004) {
          Log.d(a.b(), "p nk");
          if (!az.b.booleanValue()) {
            Log.d(a.b(), "p nk...if");
            x.a().g(true);
            str1 = w.optString("msg");
            if (HeroSdk.getInstance().getChannelAccountOffLineListener() != null)
              HeroSdk.getInstance().getChannelAccountOffLineListener().onKick(0, str1); 
            if (HeroSdk.getInstance().getKickListener() != null)
              HeroSdk.getInstance().getKickListener().onKick(0, str1); 
          } 
        } else if (i == 1005) {
          Log.d(a.b(), "p np");
          str1 = str1.optString("msg");
          if (!TextUtils.isEmpty(str1)) {
            x x = new x();
            this(this, str1, i);
            bb.a(x);
          } else {
            Log.d(a.b(), "p np...else msg is empty");
            IPayListener iPayListener = this.a;
            String str = this.b.getCpOrderId();
            stringBuilder = new StringBuilder();
            this();
            iPayListener.onFailed(str, stringBuilder.append("code:").append(i).append(",msg:").append(str1).toString());
          } 
        } else {
          str1 = str1.optString("msg");
          IPayListener iPayListener = this.a;
          str2 = this.b.getCpOrderId();
          stringBuilder = new StringBuilder();
          this();
          iPayListener.onFailed(str2, stringBuilder.append("code:").append(i).append(",msg:").append(str1).toString());
          str2 = a.b();
          stringBuilder = new StringBuilder();
          this();
          Log.d(str2, stringBuilder.append("p failed code:").append(i).append(",msg:").append(str1).toString());
        } 
      } else {
        str2 = a.b();
        stringBuilder = new StringBuilder();
        this();
        Log.e(str2, stringBuilder.append("do p but error:").append(str1.a()).toString());
        IPayListener iPayListener = this.a;
        String str = this.b.getCpOrderId();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        iPayListener.onFailed(str, stringBuilder1.append("code:").append(str1.a()).toString());
      } 
      return;
    } catch (Exception exception) {
      Log.d(a.b(), "p ex");
      ErrorUtils.printExceptionInfo(exception);
      IPayListener iPayListener = this.a;
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
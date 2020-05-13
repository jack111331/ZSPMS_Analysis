package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage {
  private static final String TAG = "MicroMsg.AddCardToWXCardPackage";
  
  public static class Req extends BaseReq {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public boolean checkArgs() {
      if (this.cardArrary == null || this.cardArrary.size() == 0 || this.cardArrary.size() > 40)
        return false; 
      for (AddCardToWXCardPackage.WXCardItem wXCardItem : this.cardArrary) {
        if (wXCardItem == null || wXCardItem.cardId == null || wXCardItem.cardId.length() > 1024 || (wXCardItem.cardExtMsg != null && wXCardItem.cardExtMsg.length() > 1024))
          return false; 
      } 
      return true;
    }
    
    public int getType() {
      return 9;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      JSONStringer jSONStringer = new JSONStringer();
      try {
        jSONStringer.object();
        jSONStringer.key("card_list");
        jSONStringer.array();
        for (AddCardToWXCardPackage.WXCardItem wXCardItem : this.cardArrary) {
          String str;
          jSONStringer.object();
          jSONStringer.key("card_id");
          jSONStringer.value(wXCardItem.cardId);
          jSONStringer.key("card_ext");
          if (wXCardItem.cardExtMsg == null) {
            str = "";
          } else {
            str = ((AddCardToWXCardPackage.WXCardItem)str).cardExtMsg;
          } 
          jSONStringer.value(str);
          jSONStringer.endObject();
        } 
        jSONStringer.endArray();
        jSONStringer.endObject();
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Req.toBundle exception:");
        stringBuilder.append(exception.getMessage());
        Log.e("MicroMsg.AddCardToWXCardPackage", stringBuilder.toString());
      } 
      param1Bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
    }
  }
  
  public static class Resp extends BaseResp {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public Resp() {}
    
    public Resp(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      return !(this.cardArrary == null || this.cardArrary.size() == 0);
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      if (this.cardArrary == null)
        this.cardArrary = new LinkedList<AddCardToWXCardPackage.WXCardItem>(); 
      String str = param1Bundle.getString("_wxapi_add_card_to_wx_card_list");
      if (str != null && str.length() > 0)
        try {
          JSONTokener jSONTokener = new JSONTokener();
          this(str);
          JSONArray jSONArray = ((JSONObject)jSONTokener.nextValue()).getJSONArray("card_list");
          for (byte b = 0; b < jSONArray.length(); b++) {
            JSONObject jSONObject = jSONArray.getJSONObject(b);
            AddCardToWXCardPackage.WXCardItem wXCardItem = new AddCardToWXCardPackage.WXCardItem();
            this();
            wXCardItem.cardId = jSONObject.optString("card_id");
            wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
            wXCardItem.cardState = jSONObject.optInt("is_succ");
            this.cardArrary.add(wXCardItem);
          } 
        } catch (Exception exception) {} 
    }
    
    public int getType() {
      return 9;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      JSONStringer jSONStringer = new JSONStringer();
      try {
        jSONStringer.object();
        jSONStringer.key("card_list");
        jSONStringer.array();
        for (AddCardToWXCardPackage.WXCardItem wXCardItem : this.cardArrary) {
          String str;
          jSONStringer.object();
          jSONStringer.key("card_id");
          jSONStringer.value(wXCardItem.cardId);
          jSONStringer.key("card_ext");
          if (wXCardItem.cardExtMsg == null) {
            str = "";
          } else {
            str = wXCardItem.cardExtMsg;
          } 
          jSONStringer.value(str);
          jSONStringer.key("is_succ");
          jSONStringer.value(wXCardItem.cardState);
          jSONStringer.endObject();
        } 
        jSONStringer.endArray();
        jSONStringer.endObject();
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Resp.toBundle exception:");
        stringBuilder.append(exception.getMessage());
        Log.e("MicroMsg.AddCardToWXCardPackage", stringBuilder.toString());
      } 
      param1Bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
    }
  }
  
  public static final class WXCardItem {
    public String cardExtMsg;
    
    public String cardId;
    
    public int cardState;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelbiz\AddCardToWXCardPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage {
  public static class Req extends BaseReq {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public boolean checkArgs() {
      // Byte code:
      //   0: aload_0
      //   1: getfield cardArrary : Ljava/util/List;
      //   4: ifnull -> 33
      //   7: aload_0
      //   8: getfield cardArrary : Ljava/util/List;
      //   11: invokeinterface size : ()I
      //   16: ifeq -> 33
      //   19: aload_0
      //   20: getfield cardArrary : Ljava/util/List;
      //   23: invokeinterface size : ()I
      //   28: bipush #40
      //   30: if_icmple -> 37
      //   33: iconst_0
      //   34: istore_1
      //   35: iload_1
      //   36: ireturn
      //   37: aload_0
      //   38: getfield cardArrary : Ljava/util/List;
      //   41: invokeinterface iterator : ()Ljava/util/Iterator;
      //   46: astore_2
      //   47: aload_2
      //   48: invokeinterface hasNext : ()Z
      //   53: ifeq -> 115
      //   56: aload_2
      //   57: invokeinterface next : ()Ljava/lang/Object;
      //   62: checkcast com/tencent/mm/sdk/modelbiz/AddCardToWXCardPackage$WXCardItem
      //   65: astore_3
      //   66: aload_3
      //   67: ifnull -> 110
      //   70: aload_3
      //   71: getfield cardId : Ljava/lang/String;
      //   74: ifnull -> 110
      //   77: aload_3
      //   78: getfield cardId : Ljava/lang/String;
      //   81: invokevirtual length : ()I
      //   84: sipush #1024
      //   87: if_icmpgt -> 110
      //   90: aload_3
      //   91: getfield cardExtMsg : Ljava/lang/String;
      //   94: ifnull -> 47
      //   97: aload_3
      //   98: getfield cardExtMsg : Ljava/lang/String;
      //   101: invokevirtual length : ()I
      //   104: sipush #1024
      //   107: if_icmple -> 47
      //   110: iconst_0
      //   111: istore_1
      //   112: goto -> 35
      //   115: iconst_1
      //   116: istore_1
      //   117: goto -> 35
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
      } catch (Exception exception) {
        exception.printStackTrace();
        param1Bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        return;
      } 
      jSONStringer.endArray();
      jSONStringer.endObject();
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
      } catch (Exception exception) {
        exception.printStackTrace();
        param1Bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        return;
      } 
      jSONStringer.endArray();
      jSONStringer.endObject();
      param1Bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
    }
  }
  
  public static final class WXCardItem {
    public String cardExtMsg;
    
    public String cardId;
    
    public int cardState;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelbiz\AddCardToWXCardPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
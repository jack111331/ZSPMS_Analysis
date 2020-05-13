package com.tencent.mm.opensdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.a.a.b;
import com.tencent.mm.opensdk.b.d;

public final class a {
  public static boolean a(Context paramContext, a parama) {
    StringBuilder stringBuilder1;
    if (paramContext == null) {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return false;
    } 
    if (d.a(parama.a)) {
      stringBuilder1 = new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ");
      stringBuilder1.append(parama.a);
      Log.e("MicroMsg.SDK.MMessageAct", stringBuilder1.toString());
      return false;
    } 
    if (d.a(parama.b)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(parama.a);
      stringBuilder.append(".wxapi.WXEntryActivity");
      parama.b = stringBuilder.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder("send, targetPkgName = ");
    stringBuilder2.append(parama.a);
    stringBuilder2.append(", targetClassName = ");
    stringBuilder2.append(parama.b);
    Log.d("MicroMsg.SDK.MMessageAct", stringBuilder2.toString());
    Intent intent = new Intent();
    intent.setClassName(parama.a, parama.b);
    if (parama.d != null)
      intent.putExtras(parama.d); 
    String str = stringBuilder1.getPackageName();
    intent.putExtra("_mmessage_sdkVersion", 603979778);
    intent.putExtra("_mmessage_appPackage", str);
    intent.putExtra("_mmessage_content", parama.c);
    intent.putExtra("_mmessage_checksum", b.a(parama.c, 603979778, str));
    if (parama.flags == -1) {
      intent.addFlags(268435456).addFlags(134217728);
    } else {
      intent.setFlags(parama.flags);
    } 
    try {
      stringBuilder1.startActivity(intent);
      stringBuilder1 = new StringBuilder("send mm message, intent=");
      stringBuilder1.append(intent);
      Log.d("MicroMsg.SDK.MMessageAct", stringBuilder1.toString());
      return true;
    } catch (Exception exception) {
      stringBuilder1 = new StringBuilder("send fail, ex = ");
      stringBuilder1.append(exception.getMessage());
      Log.e("MicroMsg.SDK.MMessageAct", stringBuilder1.toString());
      return false;
    } 
  }
  
  public static final class a {
    public String a;
    
    public String b;
    
    public String c;
    
    public Bundle d;
    
    public int flags = -1;
    
    public final String toString() {
      StringBuilder stringBuilder = new StringBuilder("targetPkgName:");
      stringBuilder.append(this.a);
      stringBuilder.append(", targetClassName:");
      stringBuilder.append(this.b);
      stringBuilder.append(", content:");
      stringBuilder.append(this.c);
      stringBuilder.append(", flags:");
      stringBuilder.append(this.flags);
      stringBuilder.append(", bundle:");
      stringBuilder.append(this.d);
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
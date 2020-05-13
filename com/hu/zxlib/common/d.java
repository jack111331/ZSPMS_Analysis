package com.hu.zxlib.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.hu.scan.permission.a;
import java.util.List;

class d implements a {
  d(c paramc) {}
  
  public void a(List<String> paramList) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("package:");
      stringBuilder.append(this.a.a.getPackageName());
      Uri uri = Uri.parse(stringBuilder.toString());
      Intent intent = new Intent();
      this("android.settings.APPLICATION_DETAILS_SETTINGS", uri);
      intent.addFlags(268435456);
      this.a.a.startActivity(intent);
      Toast.makeText((Context)this.a.a, "没有权限无法扫描", 1).show();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\common\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
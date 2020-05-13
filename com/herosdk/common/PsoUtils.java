package com.herosdk.common;

import android.app.Activity;
import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageStats;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.bean.a;
import com.herosdk.d.m;
import com.herosdk.d.x;

public class PsoUtils extends IPackageStatsObserver.Stub {
  private static final String a = "frameLib.pso";
  
  public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean) {
    try {
      Activity activity = x.a().x();
      int i;
      for (i = 0; i < m.a((Context)activity).t().size(); i++) {
        if (((a)m.a((Context)activity).t().get(i)).b().equals(paramPackageStats.packageName))
          ((a)m.a((Context)activity).t().get(i)).a(paramPackageStats.codeSize / 1024L); 
      } 
      i = m.a((Context)activity).u();
      m.a((Context)activity).a(i + 1);
      if (m.a((Context)activity).t().size() > 0 && m.a((Context)activity).u() < m.a((Context)activity).t().size()) {
        a a = m.a((Context)activity).t().get(m.a((Context)activity).u());
        if (!TextUtils.isEmpty(a.b()))
          m.a((Context)activity).a((Context)activity, a.b()); 
      } 
      if (m.a((Context)activity).u() >= m.a((Context)activity).t().size()) {
        m.a((Context)activity).a(0);
        if (m.a((Context)activity).v() != null)
          m.a((Context)activity).v().a(); 
      } 
    } catch (Exception exception) {
      Log.d("frameLib.pso", "=>oGSC...e");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\common\PsoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
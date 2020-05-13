package com.hu.scan.permission.a;

import android.content.Context;
import android.support.a.aa;
import java.util.List;

public final class k implements n {
  private static final n a = new w();
  
  private static final n b = new z();
  
  public boolean a(@aa Context paramContext, @aa List<String> paramList) {
    boolean bool;
    if (a.a(paramContext, paramList) && b.a(paramContext, paramList)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean a(@aa Context paramContext, @aa String... paramVarArgs) {
    boolean bool;
    if (a.a(paramContext, paramVarArgs) && b.a(paramContext, paramVarArgs)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
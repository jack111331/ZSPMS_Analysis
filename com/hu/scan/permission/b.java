package com.hu.scan.permission;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.support.a.aa;
import com.hu.scan.permission.b.a;
import com.hu.scan.permission.c.a;
import com.hu.scan.permission.c.b;
import com.hu.scan.permission.c.d;
import com.hu.scan.permission.c.e;
import java.util.Iterator;
import java.util.List;

public class b {
  private static final f a;
  
  static {
    d d;
    if (Build.VERSION.SDK_INT >= 23) {
      e e = new e(null);
    } else {
      d = new d(null);
    } 
    a = d;
  }
  
  @aa
  public static p a(@aa Activity paramActivity) {
    return (p)new a((d)new a(paramActivity));
  }
  
  @aa
  public static p a(@aa Fragment paramFragment) {
    return (p)new a((d)new e(paramFragment));
  }
  
  @aa
  public static p a(@aa Context paramContext) {
    return (p)new a((d)new b(paramContext));
  }
  
  public static boolean a(@aa Activity paramActivity, @aa List<String> paramList) {
    return a((d)new a(paramActivity), paramList);
  }
  
  public static boolean a(@aa Activity paramActivity, @aa String... paramVarArgs) {
    return a((d)new a(paramActivity), paramVarArgs);
  }
  
  public static boolean a(@aa Fragment paramFragment, @aa List<String> paramList) {
    return a((d)new e(paramFragment), paramList);
  }
  
  public static boolean a(@aa Fragment paramFragment, @aa String... paramVarArgs) {
    return a((d)new e(paramFragment), paramVarArgs);
  }
  
  public static boolean a(@aa Context paramContext, @aa List<String> paramList) {
    return a((d)new b(paramContext), paramList);
  }
  
  public static boolean a(@aa Context paramContext, @aa String... paramVarArgs) {
    return a((d)new b(paramContext), paramVarArgs);
  }
  
  private static boolean a(@aa d paramd, @aa List<String> paramList) {
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (!paramd.a(iterator.next()))
        return true; 
    } 
    return false;
  }
  
  private static boolean a(@aa d paramd, @aa String... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b1 = 0; b1 < i; b1++) {
      if (!paramd.a(paramVarArgs[b1]))
        return true; 
    } 
    return false;
  }
  
  @aa
  public static n b(@aa Activity paramActivity) {
    return a.a((d)new a(paramActivity));
  }
  
  @aa
  public static n b(@aa Fragment paramFragment) {
    return a.a((d)new e(paramFragment));
  }
  
  @aa
  public static n b(@aa Context paramContext) {
    return a.a((d)new b(paramContext));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
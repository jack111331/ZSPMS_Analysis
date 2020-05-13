package com.hu.scan.permission.a;

import android.content.Context;
import android.os.Build;
import android.support.a.aa;
import android.support.a.af;
import java.util.Iterator;
import java.util.List;

public final class z implements n {
  private static boolean a() {
    return (new r()).a();
  }
  
  private static boolean a(Context paramContext) {
    return (new b(paramContext)).a();
  }
  
  @af(b = 19)
  private boolean a(Context paramContext, String paramString) {
    byte b = -1;
    try {
      switch (paramString.hashCode()) {
        case 2133799037:
          if (paramString.equals("com.android.voicemail.permission.ADD_VOICEMAIL"))
            b = 13; 
          break;
        case 1977429404:
          if (paramString.equals("android.permission.READ_CONTACTS"))
            b = 3; 
          break;
        case 1831139720:
          if (paramString.equals("android.permission.RECORD_AUDIO"))
            b = 8; 
          break;
        case 1365911975:
          if (paramString.equals("android.permission.WRITE_EXTERNAL_STORAGE"))
            b = 23; 
          break;
        case 1271781903:
          if (paramString.equals("android.permission.GET_ACCOUNTS"))
            b = 5; 
          break;
        case 952819282:
          if (paramString.equals("android.permission.PROCESS_OUTGOING_CALLS"))
            b = 15; 
          break;
        case 784519842:
          if (paramString.equals("android.permission.USE_SIP"))
            b = 14; 
          break;
        case 610633091:
          if (paramString.equals("android.permission.WRITE_CALL_LOG"))
            b = 12; 
          break;
        case 603653886:
          if (paramString.equals("android.permission.WRITE_CALENDAR"))
            b = 1; 
          break;
        case 463403621:
          if (paramString.equals("android.permission.CAMERA"))
            b = 2; 
          break;
        case 214526995:
          if (paramString.equals("android.permission.WRITE_CONTACTS"))
            b = 4; 
          break;
        case 112197485:
          if (paramString.equals("android.permission.CALL_PHONE"))
            b = 10; 
          break;
        case 52602690:
          if (paramString.equals("android.permission.SEND_SMS"))
            b = 17; 
          break;
        case -5573545:
          if (paramString.equals("android.permission.READ_PHONE_STATE"))
            b = 9; 
          break;
        case -63024214:
          if (paramString.equals("android.permission.ACCESS_COARSE_LOCATION"))
            b = 6; 
          break;
        case -406040016:
          if (paramString.equals("android.permission.READ_EXTERNAL_STORAGE"))
            b = 22; 
          break;
        case -895673731:
          if (paramString.equals("android.permission.RECEIVE_SMS"))
            b = 21; 
          break;
        case -895679497:
          if (paramString.equals("android.permission.RECEIVE_MMS"))
            b = 18; 
          break;
        case -1238066820:
          if (paramString.equals("android.permission.BODY_SENSORS"))
            b = 16; 
          break;
        case -1479758289:
          if (paramString.equals("android.permission.RECEIVE_WAP_PUSH"))
            b = 20; 
          break;
        case -1888586689:
          if (paramString.equals("android.permission.ACCESS_FINE_LOCATION"))
            b = 7; 
          break;
        case -1921431796:
          if (paramString.equals("android.permission.READ_CALL_LOG"))
            b = 11; 
          break;
        case -1928411001:
          if (paramString.equals("android.permission.READ_CALENDAR"))
            b = 0; 
          break;
        case -2062386608:
          if (paramString.equals("android.permission.READ_SMS"))
            b = 19; 
          break;
      } 
      switch (b) {
        default:
          return true;
        case 23:
          return c();
        case 22:
          return b();
        case 20:
        case 21:
          return true;
        case 19:
          return m(paramContext);
        case 17:
        case 18:
          return true;
        case 16:
          return l(paramContext);
        case 15:
          return true;
        case 14:
          return k(paramContext);
        case 13:
          return j(paramContext);
        case 12:
          return i(paramContext);
        case 11:
          return h(paramContext);
        case 10:
          return true;
        case 9:
          return g(paramContext);
        case 8:
          return a();
        case 6:
        case 7:
          return f(paramContext);
        case 5:
          return true;
        case 4:
          return e(paramContext);
        case 3:
          return d(paramContext);
        case 2:
          return c(paramContext);
        case 1:
          return b(paramContext);
        case 0:
          break;
      } 
      return a(paramContext);
    } catch (Throwable throwable) {
      return false;
    } 
  }
  
  private static boolean b() {
    return (new x()).a();
  }
  
  private static boolean b(Context paramContext) {
    return (new c(paramContext)).a();
  }
  
  private static boolean c() {
    return (new y()).a();
  }
  
  private static boolean c(Context paramContext) {
    return (new f(paramContext)).a();
  }
  
  private static boolean d(Context paramContext) {
    return (new i(paramContext)).a();
  }
  
  private static boolean e(Context paramContext) {
    return (new j(paramContext.getContentResolver())).a();
  }
  
  private static boolean f(Context paramContext) {
    return (new l(paramContext)).a();
  }
  
  private static boolean g(Context paramContext) {
    return (new q(paramContext)).a();
  }
  
  private static boolean h(Context paramContext) {
    return (new d(paramContext)).a();
  }
  
  private static boolean i(Context paramContext) {
    return (new e(paramContext)).a();
  }
  
  private static boolean j(Context paramContext) {
    return (new a(paramContext)).a();
  }
  
  private static boolean k(Context paramContext) {
    return (new u(paramContext)).a();
  }
  
  private static boolean l(Context paramContext) {
    return (new s(paramContext)).a();
  }
  
  private static boolean m(Context paramContext) {
    return (new v(paramContext)).a();
  }
  
  public boolean a(@aa Context paramContext, @aa List<String> paramList) {
    if (Build.VERSION.SDK_INT < 21)
      return true; 
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (!a(paramContext, iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public boolean a(@aa Context paramContext, @aa String... paramVarArgs) {
    if (Build.VERSION.SDK_INT < 21)
      return true; 
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      if (!a(paramContext, paramVarArgs[b]))
        return false; 
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
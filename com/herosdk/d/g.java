package com.herosdk.d;

import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.bean.b;
import com.herosdk.error.ErrorUtils;
import java.util.List;

public class g {
  private static final String a = "frameLib.cus";
  
  private static volatile g b;
  
  private static String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private g() {
    try {
      this.g = o.b("UCaYge3prL9xtZ0uF/qGjg==", o.b());
      StringBuilder stringBuilder = new StringBuilder();
      this();
      this.d = stringBuilder.append(x.a().y()).append(o.b("ODnSVaoDr0wLq2zlsr2Xdw==", o.b())).append(k.a().d()).append(o.b("dA3C12cQWy0s1pDUpEq1RQ==", o.b())).toString();
      stringBuilder = new StringBuilder();
      this();
      this.f = stringBuilder.append(x.a().y()).append(o.b("QvzHfxgnzKdPD2vS0b8XBQ==", o.b())).append(k.a().d()).append(o.b("dA3C12cQWy0s1pDUpEq1RQ==", o.b())).toString();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static g a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/g.b : Lcom/herosdk/d/g;
    //   3: ifnonnull -> 68
    //   6: ldc com/herosdk/d/g
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/g.b : Lcom/herosdk/d/g;
    //   12: ifnonnull -> 65
    //   15: new com/herosdk/d/g
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/g.b : Lcom/herosdk/d/g;
    //   27: new java/lang/StringBuilder
    //   30: astore_0
    //   31: aload_0
    //   32: invokespecial <init> : ()V
    //   35: aload_0
    //   36: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   39: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: getstatic java/io/File.separator : Ljava/lang/String;
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 'vtLFG4aTIQUi6VkqQrwe1w=='
    //   50: invokestatic b : ()Ljava/lang/String;
    //   53: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: putstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   65: ldc com/herosdk/d/g
    //   67: monitorexit
    //   68: getstatic com/herosdk/d/g.b : Lcom/herosdk/d/g;
    //   71: areturn
    //   72: astore_0
    //   73: ldc ''
    //   75: putstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   78: goto -> 65
    //   81: astore_0
    //   82: ldc com/herosdk/d/g
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	81	finally
    //   27	65	72	java/lang/Exception
    //   27	65	81	finally
    //   65	68	81	finally
    //   73	78	81	finally
    //   82	85	81	finally
  }
  
  public void a(RoleInfo paramRoleInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/herosdk/d/ba;
    //   5: astore_2
    //   6: new com/herosdk/d/h
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial <init> : (Lcom/herosdk/d/g;Lcom/herosdk/bean/RoleInfo;)V
    //   16: aload_2
    //   17: aload_3
    //   18: invokevirtual a : (Ljava/lang/Runnable;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  public void a(Boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual booleanValue : ()Z
    //   6: ifeq -> 47
    //   9: ldc 'true'
    //   11: astore_1
    //   12: invokestatic a : ()Lcom/herosdk/d/p;
    //   15: getstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   18: aload_0
    //   19: getfield f : Ljava/lang/String;
    //   22: aload_0
    //   23: getfield g : Ljava/lang/String;
    //   26: aload_1
    //   27: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokestatic a : ()Lcom/herosdk/d/x;
    //   33: invokevirtual x : ()Landroid/app/Activity;
    //   36: aload_0
    //   37: getfield g : Ljava/lang/String;
    //   40: aload_1
    //   41: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: ldc ''
    //   49: astore_1
    //   50: goto -> 12
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	53	finally
    //   12	44	53	finally
  }
  
  public void a(String paramString1, String paramString2, UserInfo paramUserInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/herosdk/d/ba;
    //   5: astore #4
    //   7: new com/herosdk/d/i
    //   10: astore #5
    //   12: aload #5
    //   14: aload_0
    //   15: aload_1
    //   16: aload_3
    //   17: aload_2
    //   18: invokespecial <init> : (Lcom/herosdk/d/g;Ljava/lang/String;Lcom/herosdk/bean/UserInfo;Ljava/lang/String;)V
    //   21: aload #4
    //   23: aload #5
    //   25: invokevirtual a : (Ljava/lang/Runnable;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	31	finally
  }
  
  public void a(List<b> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.cus'
    //   4: ldc 'scl'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: new org/json/JSONArray
    //   13: astore_2
    //   14: aload_2
    //   15: invokespecial <init> : ()V
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: aload_1
    //   22: invokeinterface size : ()I
    //   27: if_icmpge -> 272
    //   30: aload_1
    //   31: iload_3
    //   32: invokeinterface get : (I)Ljava/lang/Object;
    //   37: checkcast com/herosdk/bean/b
    //   40: astore #4
    //   42: aload #4
    //   44: invokevirtual b : ()Lcom/herosdk/bean/UserInfo;
    //   47: astore #5
    //   49: aload #4
    //   51: invokevirtual c : ()Lcom/herosdk/bean/RoleInfo;
    //   54: astore #6
    //   56: new org/json/JSONObject
    //   59: astore #7
    //   61: aload #7
    //   63: invokespecial <init> : ()V
    //   66: aload #7
    //   68: ldc 'isLatestUser'
    //   70: aload #4
    //   72: invokevirtual a : ()Ljava/lang/String;
    //   75: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload #5
    //   81: ifnull -> 149
    //   84: aload #7
    //   86: ldc 'uid'
    //   88: aload #5
    //   90: invokevirtual getUid : ()Ljava/lang/String;
    //   93: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload #7
    //   99: ldc 'username'
    //   101: aload #5
    //   103: invokevirtual getUsername : ()Ljava/lang/String;
    //   106: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload #7
    //   112: ldc 'accessToken'
    //   114: aload #5
    //   116: invokevirtual getToken : ()Ljava/lang/String;
    //   119: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload #7
    //   125: ldc 'cToken'
    //   127: aload #5
    //   129: invokevirtual getChannelToken : ()Ljava/lang/String;
    //   132: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload #7
    //   138: ldc 'serverMsg'
    //   140: aload #5
    //   142: invokevirtual getServerMessage : ()Ljava/lang/String;
    //   145: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload #6
    //   151: ifnull -> 259
    //   154: aload #7
    //   156: ldc 'roleId'
    //   158: aload #6
    //   160: invokevirtual getRoleId : ()Ljava/lang/String;
    //   163: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload #7
    //   169: ldc 'roleName'
    //   171: aload #6
    //   173: invokevirtual getRoleName : ()Ljava/lang/String;
    //   176: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload #7
    //   182: ldc 'serverId'
    //   184: aload #6
    //   186: invokevirtual getServerId : ()Ljava/lang/String;
    //   189: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: aload #7
    //   195: ldc 'serverName'
    //   197: aload #6
    //   199: invokevirtual getServerName : ()Ljava/lang/String;
    //   202: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload #7
    //   208: ldc 'roleLevel'
    //   210: aload #6
    //   212: invokevirtual getRoleLevel : ()Ljava/lang/String;
    //   215: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   218: pop
    //   219: aload #7
    //   221: ldc 'vipLevel'
    //   223: aload #6
    //   225: invokevirtual getVipLevel : ()Ljava/lang/String;
    //   228: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload #7
    //   234: ldc 'roleBalance'
    //   236: aload #6
    //   238: invokevirtual getRoleBalance : ()Ljava/lang/String;
    //   241: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload #7
    //   247: ldc_w 'partyName'
    //   250: aload #6
    //   252: invokevirtual getPartyName : ()Ljava/lang/String;
    //   255: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload_2
    //   260: aload #7
    //   262: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   265: pop
    //   266: iinc #3, 1
    //   269: goto -> 20
    //   272: aload_2
    //   273: invokevirtual toString : ()Ljava/lang/String;
    //   276: astore_1
    //   277: aload_1
    //   278: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   281: ifne -> 311
    //   284: invokestatic a : ()Lcom/herosdk/d/p;
    //   287: getstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   290: aload_0
    //   291: getfield d : Ljava/lang/String;
    //   294: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   297: invokestatic a : ()Lcom/herosdk/d/p;
    //   300: getstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   303: aload_0
    //   304: getfield d : Ljava/lang/String;
    //   307: aload_1
    //   308: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_0
    //   312: monitorexit
    //   313: return
    //   314: astore_1
    //   315: aload_0
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    //   319: astore_1
    //   320: goto -> 311
    // Exception table:
    //   from	to	target	type
    //   2	18	319	java/lang/Exception
    //   2	18	314	finally
    //   20	79	319	java/lang/Exception
    //   20	79	314	finally
    //   84	149	319	java/lang/Exception
    //   84	149	314	finally
    //   154	259	319	java/lang/Exception
    //   154	259	314	finally
    //   259	266	319	java/lang/Exception
    //   259	266	314	finally
    //   272	311	319	java/lang/Exception
    //   272	311	314	finally
  }
  
  public String b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/herosdk/d/p;
    //   5: getstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   8: aload_0
    //   9: getfield d : Ljava/lang/String;
    //   12: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
  }
  
  public List<b> c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.cus'
    //   4: ldc_w 'gcl'
    //   7: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: new java/util/ArrayList
    //   14: astore_1
    //   15: aload_1
    //   16: invokespecial <init> : ()V
    //   19: aload_0
    //   20: aload_0
    //   21: invokevirtual b : ()Ljava/lang/String;
    //   24: putfield e : Ljava/lang/String;
    //   27: aload_0
    //   28: getfield e : Ljava/lang/String;
    //   31: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   34: ifeq -> 52
    //   37: ldc 'frameLib.cus'
    //   39: ldc_w 'gcl...return null'
    //   42: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_1
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: areturn
    //   52: new org/json/JSONArray
    //   55: astore_3
    //   56: aload_3
    //   57: aload_0
    //   58: getfield e : Ljava/lang/String;
    //   61: invokespecial <init> : (Ljava/lang/String;)V
    //   64: iconst_0
    //   65: istore #4
    //   67: aload_1
    //   68: astore_2
    //   69: iload #4
    //   71: aload_3
    //   72: invokevirtual length : ()I
    //   75: if_icmpge -> 48
    //   78: aload_3
    //   79: iload #4
    //   81: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   84: astore_2
    //   85: new com/herosdk/bean/b
    //   88: astore #5
    //   90: aload #5
    //   92: invokespecial <init> : ()V
    //   95: aload #5
    //   97: aload_2
    //   98: ldc 'isLatestUser'
    //   100: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   103: invokevirtual a : (Ljava/lang/String;)V
    //   106: new com/herosdk/bean/UserInfo
    //   109: astore #6
    //   111: aload #6
    //   113: invokespecial <init> : ()V
    //   116: aload #6
    //   118: aload_2
    //   119: ldc 'uid'
    //   121: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   124: invokevirtual setUid : (Ljava/lang/String;)V
    //   127: aload #6
    //   129: aload_2
    //   130: ldc 'username'
    //   132: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual setUsername : (Ljava/lang/String;)V
    //   138: aload #6
    //   140: aload_2
    //   141: ldc 'accessToken'
    //   143: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   146: invokevirtual setToken : (Ljava/lang/String;)V
    //   149: aload #6
    //   151: aload_2
    //   152: ldc 'cToken'
    //   154: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual setChannelToken : (Ljava/lang/String;)V
    //   160: aload #6
    //   162: aload_2
    //   163: ldc 'serverMsg'
    //   165: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   168: invokevirtual setServerMessage : (Ljava/lang/String;)V
    //   171: new com/herosdk/bean/RoleInfo
    //   174: astore #7
    //   176: aload #7
    //   178: invokespecial <init> : ()V
    //   181: aload #7
    //   183: aload_2
    //   184: ldc 'roleId'
    //   186: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual setRoleId : (Ljava/lang/String;)V
    //   192: aload #7
    //   194: aload_2
    //   195: ldc 'roleName'
    //   197: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   200: invokevirtual setRoleName : (Ljava/lang/String;)V
    //   203: aload #7
    //   205: aload_2
    //   206: ldc 'serverId'
    //   208: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   211: invokevirtual setServerId : (Ljava/lang/String;)V
    //   214: aload #7
    //   216: aload_2
    //   217: ldc 'serverName'
    //   219: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   222: invokevirtual setServerName : (Ljava/lang/String;)V
    //   225: aload #7
    //   227: aload_2
    //   228: ldc 'roleLevel'
    //   230: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   233: invokevirtual setRoleLevel : (Ljava/lang/String;)V
    //   236: aload #7
    //   238: aload_2
    //   239: ldc 'vipLevel'
    //   241: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   244: invokevirtual setVipLevel : (Ljava/lang/String;)V
    //   247: aload #7
    //   249: aload_2
    //   250: ldc 'roleBalance'
    //   252: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   255: invokevirtual setRoleBalance : (Ljava/lang/String;)V
    //   258: aload #7
    //   260: aload_2
    //   261: ldc_w 'partyName'
    //   264: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   267: invokevirtual setPartyName : (Ljava/lang/String;)V
    //   270: aload #5
    //   272: aload #6
    //   274: invokevirtual a : (Lcom/herosdk/bean/UserInfo;)V
    //   277: aload #5
    //   279: aload #7
    //   281: invokevirtual a : (Lcom/herosdk/bean/RoleInfo;)V
    //   284: aload_1
    //   285: aload #5
    //   287: invokeinterface add : (Ljava/lang/Object;)Z
    //   292: pop
    //   293: iinc #4, 1
    //   296: goto -> 67
    //   299: astore_2
    //   300: aconst_null
    //   301: astore_2
    //   302: goto -> 48
    //   305: astore_2
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_2
    //   309: athrow
    // Exception table:
    //   from	to	target	type
    //   2	46	299	java/lang/Exception
    //   2	46	305	finally
    //   52	64	299	java/lang/Exception
    //   52	64	305	finally
    //   69	293	299	java/lang/Exception
    //   69	293	305	finally
  }
  
  public Boolean d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/herosdk/d/p;
    //   5: getstatic com/herosdk/d/g.c : Ljava/lang/String;
    //   8: aload_0
    //   9: getfield f : Ljava/lang/String;
    //   12: aload_0
    //   13: getfield g : Ljava/lang/String;
    //   16: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   24: ifne -> 53
    //   27: aload_1
    //   28: ldc 'true'
    //   30: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   33: ifeq -> 45
    //   36: iconst_1
    //   37: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: iconst_0
    //   46: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   49: astore_1
    //   50: goto -> 41
    //   53: invokestatic a : ()Lcom/herosdk/d/x;
    //   56: invokevirtual x : ()Landroid/app/Activity;
    //   59: aload_0
    //   60: getfield g : Ljava/lang/String;
    //   63: ldc ''
    //   65: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast java/lang/String
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifne -> 96
    //   79: aload_1
    //   80: ldc 'true'
    //   82: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   85: ifeq -> 96
    //   88: iconst_1
    //   89: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   92: astore_1
    //   93: goto -> 41
    //   96: iconst_0
    //   97: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   100: astore_1
    //   101: goto -> 41
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	104	finally
    //   45	50	104	finally
    //   53	93	104	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
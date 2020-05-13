package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements c {
  private String A = "";
  
  private String B = "";
  
  private GetVendorPayStatusRequestParams C;
  
  private long D = 8000L;
  
  private boolean E = false;
  
  private final Handler.Callback F = new g(this);
  
  private final Handler G = new Handler(this.F);
  
  private InitRequestParams H;
  
  private SendApduRequestParams I;
  
  private final UPTsmAddon.UPTsmConnectionListener J = new h(this);
  
  String a = "19999741583305435775450371903957622252895007857586703985696530069777024392884287211670048223494223356836139331264745305488035196420545843046674853984852305228918004888414759300445308845681087472809487791392726663269247999482633231304479943902981311338709709401000108625221857486530967716878328228310703650408575058288784573884262229674701501842066793928002725038356122707147929560460157457327696696471785787505023643000687928051333648369477362945785046976181683285277919023274376124429148429078602516462345014971452220809120399264066736558357572250447243744965533695780751271768398207631002867947152625578881506566297";
  
  String b = "65537";
  
  String c = "5929703506495688276130676968213384164609348882017291684789802337394713840702726472221198819456433069055388915357817202968369194525956730949539025096963015440180443916974948318765778051794088998339276397676916425744003507605582286608745438301704836361482343765671805403004194772735755889141443700570750608527755694790475628670051863813384800013641474007746161600969180035295709344887092512089121125289090881005234379649440422346798246278284328310221953743757037875834557694749810951089453346522229122216198442376081589767583019062954875861469699069474707285206935898628020341168773624455554331118138151051364372906861";
  
  String d = "UnionPay";
  
  String e = "";
  
  boolean f = false;
  
  boolean g = false;
  
  boolean h = false;
  
  private final String i = "A0000003334355502D4D4F42494C45";
  
  private final int j = 10000;
  
  private Context k;
  
  private b l;
  
  private a m;
  
  private UPTsmAddon n;
  
  private Handler o = null;
  
  private int p = 0;
  
  private final int q = 8;
  
  private boolean r = false;
  
  private String s = "-1";
  
  private String t = "";
  
  private boolean u = false;
  
  private String v = null;
  
  private boolean w = false;
  
  private String x = "";
  
  private String y = "-1";
  
  private String z = "-1";
  
  public f(a parama) {
    this.m = parama;
  }
  
  private void a(String paramString1, String paramString2) {
    this.I = new SendApduRequestParams();
    this.I.setChannel(paramString2);
    this.I.setHexApdu(paramString1);
    if (this.f)
      this.I.setReserve(g()); 
  }
  
  private void a(boolean paramBoolean) {
    if (this.l != null) {
      if (paramBoolean) {
        this.l.a();
        return;
      } 
    } else {
      return;
    } 
    this.l.b();
  }
  
  private void f() {
    if (this.H == null) {
      this.H = new InitRequestParams();
      if (this.f) {
        this.H.setSignature(g());
        this.H.setReserve(g());
      } 
    } 
    try {
      UPTsmAddon uPTsmAddon = this.n;
      InitRequestParams initRequestParams = this.H;
      e e = new e();
      this(1000, this.G);
      int i = uPTsmAddon.init(initRequestParams, (ITsmCallback)e);
      if (i != 0) {
        this.G.sendMessage(Message.obtain(this.G, 1, 1000, 0, ""));
      } else {
        this.G.sendMessageDelayed(Message.obtain(this.G, 4, 1000, 0, ""), this.D);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this("ret = ");
      k.c("uppay", stringBuilder.append(i).toString());
    } catch (RemoteException remoteException) {
      a(false);
      remoteException.printStackTrace();
    } 
  }
  
  private String g() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("signature", this.e);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
  
  public final String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    this.t = "";
    this.r = false;
    try {
      OpenChannelRequestParams openChannelRequestParams = new OpenChannelRequestParams();
      this();
      openChannelRequestParams.setAppAID(paramString);
      if (this.f)
        openChannelRequestParams.setReserve(g()); 
      UPTsmAddon uPTsmAddon = this.n;
      e e = new e();
      this(1011, this.G);
      if (uPTsmAddon.openChannel(openChannelRequestParams, (ITsmCallback)e) != 0)
        this.G.sendMessage(Message.obtain(this.G, 1, 1011, 0, "")); 
      do {
      
      } while (TextUtils.isEmpty(this.t) && !this.r);
      if ("A0000003334355502D4D4F42494C45".equals(paramString)) {
        this.y = this.s;
      } else {
        this.z = this.s;
      } 
      this.r = false;
      paramString = this.t;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return paramString;
  }
  
  public final ArrayList<c> a(d paramd) {
    if (this.n != null) {
      try {
        if (b.aB && b.aA && b.bo) {
          GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams = new GetCardInfoBySpayRequestParams();
          this();
          Amount amount = new Amount();
          this();
          amount.setProductPrice(this.A);
          String str = e.e(this.B);
          if (!TextUtils.isEmpty(str))
            amount.setCurrencyType(str); 
          getCardInfoBySpayRequestParams.setAmount(amount);
          if (this.f)
            getCardInfoBySpayRequestParams.setReserve(g()); 
          UPTsmAddon uPTsmAddon = this.n;
          e e = new e();
          this(1015, this.G);
          int i = uPTsmAddon.getCardInfoBySamsungPay(getCardInfoBySpayRequestParams, (ITsmCallback)e);
          if (i != 0) {
            this.G.sendMessage(Message.obtain(this.G, 1, 1015, 0, ""));
          } else {
            this.G.sendMessageDelayed(Message.obtain(this.G, 4, 1015, 0, ""), 8000L);
          } 
          StringBuilder stringBuilder = new StringBuilder();
          this("readList: ");
          k.c("uppay", stringBuilder.append(i).toString());
        } else {
          GetSeAppListRequestParams getSeAppListRequestParams = new GetSeAppListRequestParams();
          this();
          if (this.f)
            getSeAppListRequestParams.setReserve(g()); 
          UPTsmAddon uPTsmAddon = this.n;
          e e = new e();
          this(1014, this.G);
          if (uPTsmAddon.getSEAppList(getSeAppListRequestParams, (ITsmCallback)e) != 0) {
            this.G.sendMessage(Message.obtain(this.G, 1, 1014, 0, ""));
          } else {
            this.G.sendMessageDelayed(Message.obtain(this.G, 4, 1014, 0, ""), this.D);
          } 
        } 
      } catch (RemoteException remoteException) {
        a(false);
        remoteException.printStackTrace();
      } catch (Exception exception) {
        a(false);
        exception.printStackTrace();
      } 
      k.c("uppay", "readList");
    } 
    return null;
  }
  
  public final void a() {
    if (this.n != null) {
      this.n.removeConnectionListener(this.J);
      this.n.unbind();
    } 
  }
  
  public final void a(Handler paramHandler) {
    this.o = paramHandler;
  }
  
  public final void a(b paramb, Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield l : Lcom/unionpay/mobile/android/pboctransaction/b;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield k : Landroid/content/Context;
    //   10: aload_0
    //   11: getfield a : Ljava/lang/String;
    //   14: astore_3
    //   15: aload_0
    //   16: getfield c : Ljava/lang/String;
    //   19: astore #4
    //   21: new java/math/BigInteger
    //   24: astore_1
    //   25: aload_1
    //   26: aload_3
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: new java/math/BigInteger
    //   33: astore_3
    //   34: aload_3
    //   35: aload #4
    //   37: invokespecial <init> : (Ljava/lang/String;)V
    //   40: new java/security/spec/RSAPrivateKeySpec
    //   43: astore #4
    //   45: aload #4
    //   47: aload_1
    //   48: aload_3
    //   49: invokespecial <init> : (Ljava/math/BigInteger;Ljava/math/BigInteger;)V
    //   52: aload_0
    //   53: ldc_w 'RSA'
    //   56: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyFactory;
    //   59: aload #4
    //   61: invokevirtual generatePrivate : (Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   64: aload_0
    //   65: getfield d : Ljava/lang/String;
    //   68: invokestatic a : (Ljava/security/PrivateKey;Ljava/lang/String;)Ljava/lang/String;
    //   71: putfield e : Ljava/lang/String;
    //   74: getstatic com/unionpay/mobile/android/model/b.bm : Z
    //   77: ifeq -> 87
    //   80: aload_0
    //   81: ldc2_w 60000
    //   84: putfield D : J
    //   87: ldc_w 'com.unionpay.uppay'
    //   90: aload_0
    //   91: getfield k : Landroid/content/Context;
    //   94: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   97: invokevirtual equals : (Ljava/lang/Object;)Z
    //   100: ifne -> 210
    //   103: iconst_1
    //   104: istore #5
    //   106: aload_0
    //   107: iload #5
    //   109: putfield f : Z
    //   112: aload_0
    //   113: aload_2
    //   114: invokestatic getInstance : (Landroid/content/Context;)Lcom/unionpay/tsmservice/UPTsmAddon;
    //   117: putfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   120: aload_0
    //   121: getfield g : Z
    //   124: ifne -> 143
    //   127: aload_0
    //   128: getfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   131: aload_0
    //   132: getfield J : Lcom/unionpay/tsmservice/UPTsmAddon$UPTsmConnectionListener;
    //   135: invokevirtual addConnectionListener : (Lcom/unionpay/tsmservice/UPTsmAddon$UPTsmConnectionListener;)V
    //   138: aload_0
    //   139: iconst_1
    //   140: putfield g : Z
    //   143: ldc 'uppay-spay'
    //   145: ldc_w 'type se  bind service'
    //   148: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   151: pop
    //   152: aload_0
    //   153: getfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   156: ifnull -> 216
    //   159: aload_0
    //   160: getfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   163: invokevirtual isConnected : ()Z
    //   166: ifne -> 216
    //   169: ldc 'uppay'
    //   171: ldc_w 'bind service'
    //   174: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: aload_0
    //   179: getfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   182: invokevirtual bind : ()Z
    //   185: ifne -> 193
    //   188: aload_0
    //   189: iconst_0
    //   190: invokespecial a : (Z)V
    //   193: return
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual printStackTrace : ()V
    //   199: goto -> 74
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual printStackTrace : ()V
    //   207: goto -> 74
    //   210: iconst_0
    //   211: istore #5
    //   213: goto -> 106
    //   216: aload_0
    //   217: getfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   220: ifnull -> 193
    //   223: aload_0
    //   224: getfield n : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   227: invokevirtual isConnected : ()Z
    //   230: ifeq -> 193
    //   233: ldc 'uppay'
    //   235: ldc_w 'tem service already connected'
    //   238: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: aload_0
    //   243: getfield h : Z
    //   246: ifne -> 256
    //   249: aload_0
    //   250: invokespecial f : ()V
    //   253: goto -> 193
    //   256: aload_0
    //   257: iconst_1
    //   258: invokespecial a : (Z)V
    //   261: goto -> 193
    // Exception table:
    //   from	to	target	type
    //   10	74	194	java/security/NoSuchAlgorithmException
    //   10	74	202	java/security/spec/InvalidKeySpecException
  }
  
  public final byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    byte[] arrayOfByte = null;
    this.v = null;
    this.u = false;
    k.a("uppay", "--->" + e.a(paramArrayOfbyte));
    if (paramInt == 0) {
      a(e.a(paramArrayOfbyte), this.z);
    } else if (paramInt == 1) {
      a(e.a(paramArrayOfbyte), this.y);
    } 
    try {
      UPTsmAddon uPTsmAddon = this.n;
      SendApduRequestParams sendApduRequestParams = this.I;
      e e = new e();
      this(1012, this.G);
      if (uPTsmAddon.sendApdu(sendApduRequestParams, (ITsmCallback)e) != 0)
        this.G.sendMessage(Message.obtain(this.G, 1, 1012, 0, "")); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    this.G.sendMessageDelayed(Message.obtain(this.G, 3), 10000L);
    do {
    
    } while (TextUtils.isEmpty(this.v) && !this.u);
    k.a("uppay", "mApduResult: " + this.v + ",mApduReturn:" + this.u);
    paramArrayOfbyte = arrayOfByte;
    if (this.v != null) {
      paramArrayOfbyte = e.a(this.v);
      k.a("uppay", "ret1 <---" + paramArrayOfbyte);
    } 
    k.a("uppay", "<---" + this.v);
    this.u = false;
    k.a("uppay", "ret2 <---" + paramArrayOfbyte);
    return paramArrayOfbyte;
  }
  
  public final void b() {}
  
  public final void b(String paramString) {
    this.A = paramString;
  }
  
  public final void c() {
    if (this.y != null && !"-1".equals(this.y)) {
      this.x = "";
      this.w = false;
      try {
        CloseChannelRequestParams closeChannelRequestParams = new CloseChannelRequestParams();
        this();
        closeChannelRequestParams.setChannel(this.y);
        if (this.f)
          closeChannelRequestParams.setReserve(g()); 
        UPTsmAddon uPTsmAddon = this.n;
        e e = new e();
        this(1013, this.G);
        if (uPTsmAddon.closeChannel(closeChannelRequestParams, (ITsmCallback)e) != 0)
          this.G.sendMessage(Message.obtain(this.G, 1, 1013, 0, "")); 
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } 
      do {
      
      } while (TextUtils.isEmpty(this.x) && !this.w);
      this.y = "-1";
      this.w = false;
    } 
    if (this.z != null && !"-1".equals(this.z)) {
      this.x = "";
      this.w = false;
      try {
        CloseChannelRequestParams closeChannelRequestParams = new CloseChannelRequestParams();
        this();
        closeChannelRequestParams.setChannel(this.z);
        if (this.f)
          closeChannelRequestParams.setReserve(g()); 
        UPTsmAddon uPTsmAddon = this.n;
        e e = new e();
        this(1013, this.G);
        if (uPTsmAddon.closeChannel(closeChannelRequestParams, (ITsmCallback)e) != 0)
          this.G.sendMessage(Message.obtain(this.G, 1, 1013, 0, "")); 
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } 
      do {
      
      } while (TextUtils.isEmpty(this.x) && !this.w);
      this.z = "-1";
      this.w = false;
    } 
  }
  
  public final void c(String paramString) {
    this.B = paramString;
  }
  
  public final void d() {}
  
  public final boolean e() {
    null = false;
    try {
      k.c("uppay", "getVendorPayStatus()");
      if (this.C == null) {
        GetVendorPayStatusRequestParams getVendorPayStatusRequestParams1 = new GetVendorPayStatusRequestParams();
        this();
        this.C = getVendorPayStatusRequestParams1;
        if (this.f)
          this.C.setReserve(g()); 
      } 
      UPTsmAddon uPTsmAddon = this.n;
      GetVendorPayStatusRequestParams getVendorPayStatusRequestParams = this.C;
      e e = new e();
      this(1018, this.G);
      if (uPTsmAddon.getVendorPayStatus(getVendorPayStatusRequestParams, (ITsmCallback)e) != 0) {
        this.G.sendMessage(Message.obtain(this.G, 1, 1018, 0, ""));
        return null;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
    return true;
  }
  
  public static interface a {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
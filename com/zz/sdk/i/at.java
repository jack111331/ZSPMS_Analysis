package com.zz.sdk.i;

public enum at implements aj {
  A,
  B,
  C,
  D,
  E,
  F,
  G,
  H,
  I,
  J,
  K,
  L,
  M,
  N,
  O,
  P,
  Q,
  R,
  S,
  T,
  U,
  V,
  W,
  X,
  Y,
  Z,
  a(au.e, "sys/conf.lg"),
  aa(au.e, "sys/conf.lg"),
  ab(au.e, "sys/conf.lg"),
  ac(au.e, "sys/conf.lg"),
  ad(au.e, "sys/conf.lg"),
  ae(au.e, "sys/conf.lg"),
  af(au.e, "sys/conf.lg"),
  ag(au.e, "sys/conf.lg"),
  ah(au.e, "sys/conf.lg"),
  ai(au.e, "sys/conf.lg"),
  aj(au.e, "sys/conf.lg"),
  ak(au.e, "sys/conf.lg"),
  al(au.e, "sys/conf.lg"),
  am(au.e, "sys/conf.lg"),
  b(au.d, "lgn.lg"),
  c(au.b, "getToken.lg"),
  d(au.b, "getUserInfo.lg"),
  e(au.a, "dreg.lg"),
  f(au.a, "vcm.lg"),
  g(au.d, "reg/code.lg"),
  h(au.d, "reg2.lg"),
  i(au.d, "alg.lg"),
  j(au.a, "cpd.do"),
  k(au.d, "third/login.lg"),
  l(au.d, "login/getSmsCode.lg"),
  m(au.d, "phone/login.lg"),
  n(au.d, "phone/qkLogin.lg"),
  o(au.d, "phone/autoLogin.lg"),
  p(au.d, "reg/tel.lg"),
  q(au.d, "reg/tel/verify.lg"),
  r(au.e, "user/alias.lg"),
  s(au.e, "user/id/getSmsCode.lg"),
  t(au.e, "user/id/verify.lg"),
  u(au.e, "cert/getStatus.lg"),
  v(au.e, "cert/myStatus.lg"),
  w(au.e, "buoy/getStatus.lg"),
  x(au.e, "/phone/voiceCode.lg"),
  y(au.e, "user/id/verify.lg"),
  z(au.e, "phone/bind.lg");
  
  private String an;
  
  private au ao;
  
  static {
    A = new at("BINDPHONE_NEW", 26, au.e, "phone/bind/verify.lg");
    B = new at("REBINDPHONE_GET_CODE", 27, au.e, "phone/bind/caCode.lg");
    C = new at("REBINDPHONE_ACCOUNT", 28, au.e, "phone/bind/caVerify.lg");
    D = new at("ROLE_POST", 29, au.e, "user/role.lg");
    E = new at("BINDPHONE_GVC", 30, au.a, "gbvc.bp");
    F = new at("BINDPHONE_BP", 31, au.a, "bp.bp");
    G = new at("FINDPWDGFVC", 32, au.a, "gfvc.bp");
    H = new at("FINDPWDFPV", 33, au.a, "fpv.bp");
    I = new at("UPDATEPWD", 34, au.a, "fpr.bp");
    J = new at("GETHELPINFO", 35, au.a, "hd.lg");
    K = new at("BIND_EMAIL", 36, au.a, "bind_email/sendBindEmail.lg");
    L = new at("RECENT_GAME", 37, au.a, "center/recentGame.lg");
    M = new at("GET_PHONE_CODE", 38, au.a, "gainc.lg");
    N = new at("VERIFY_PHONE_CODE", 39, au.a, "verifyOldC.lg");
    O = new at("CHANGE_PHONE", 40, au.a, "rebindP.lg");
    P = new at("EMAIL_SEND_CODE", 41, au.f, "sendCode.lg");
    Q = new at("EMAIL_VERIFY_CODE", 42, au.f, "verifyCode.lg");
    R = new at("EMAIL_MODIFY_PWD", 43, au.f, "modifyPwd.lg");
    S = new at("GIFT_LIST", 44, au.g, "list2.lg");
    T = new at("GIFT_RECEIVED_LIST", 45, au.g, "receivedList.lg");
    U = new at("GIFT_RECEIVE", 46, au.g, "receive.lg");
    V = new at("UPLOAD_CONTACT", 47, au.e, "user/contacts.lg");
    W = new at("UPDATE_IS_SHOW_CONTACT", 48, au.e, "user/updateShowInContact.lg");
    X = new at("GET_CONTACT", 49, au.e, "user/contactsUserRoles.lg");
    Y = new at("GET_AVAILABLE_GIFT_COUNT", 50, au.g, "count.lg");
    Z = new at("IS_GET_GIFT", 51, au.g, "status.lg");
    aa = new at("TOURIST_STATUS_CHECK", 52, au.h, "statusCheck.lg");
    ab = new at("KICK_OFF_RPT", 53, au.h, "kickOffRpt.lg");
    ac = new at("GPL_REQ", 54, au.c, "gpl.do");
    ad = new at("GPRO_REQ", 55, au.c, "gpro.do");
    ae = new at("GPM_QO", 56, au.c, "qo.do");
    af = new at("NPM_REQ", 57, au.c, "npm.do");
    ag = new at("ZYCOIN_NT", 58, au.c, "nzy.lg");
    ah = new at("LOG_REQ", 59, au.a, "log.lg");
    ai = new at("GPM_REQ", 60, au.a, "gpm.do");
    aj = new at("DSYN_REQ", 61, au.a, "dsyn.do");
    ak = new at("GBL_REQ", 62, au.c, "gbl.do");
    al = new at("BURIAL_POINT", 63, au.a, "api/count.lg");
    am = new at("__MAX__", 64);
    ap = new at[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x, y, z, A, B, C, D, 
        E, F, G, H, I, J, K, L, M, N, 
        O, P, Q, R, S, T, U, V, W, X, 
        Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
        ai, aj, ak, al, am };
  }
  
  at(au paramau, String paramString1) {
    this.ao = paramau;
    this.an = paramString1;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder) {
    return paramStringBuilder;
  }
  
  public static void b() {}
  
  public String a() {
    return (this.ao != null) ? (this.ao.a() + this.an) : this.an;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
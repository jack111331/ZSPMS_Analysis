package com.zz.sdk.i;

public enum cg {
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
  a("##.##"),
  aA("##.##"),
  aB("##.##"),
  aC("##.##"),
  aD("##.##"),
  aE("##.##"),
  aF("##.##"),
  aG("##.##"),
  aH("##.##"),
  aI("##.##"),
  aJ("##.##"),
  aK("##.##"),
  aL("##.##"),
  aM("##.##"),
  aN("##.##"),
  aO("##.##"),
  aP("##.##"),
  aQ("##.##"),
  aR("##.##"),
  aS("##.##"),
  aT("##.##"),
  aU("##.##"),
  aV("##.##"),
  aW("##.##"),
  aX("##.##"),
  aY("##.##"),
  aZ("##.##"),
  aa("##.##"),
  ab("##.##"),
  ac("##.##"),
  ad("##.##"),
  ae("##.##"),
  af("##.##"),
  ag("##.##"),
  ah("##.##"),
  ai("##.##"),
  aj("##.##"),
  ak("##.##"),
  al("##.##"),
  am("##.##"),
  an("##.##"),
  ao("##.##"),
  ap("##.##"),
  aq("##.##"),
  ar("##.##"),
  as("##.##"),
  at("##.##"),
  au("##.##"),
  av("##.##"),
  aw("##.##"),
  ax("##.##"),
  ay("##.##"),
  az("##.##"),
  b("游戏币"),
  bA("游戏币"),
  bB("游戏币"),
  bC("游戏币"),
  bD("游戏币"),
  bE("游戏币"),
  bF("游戏币"),
  bG("游戏币"),
  bH("游戏币"),
  bI("游戏币"),
  bJ("游戏币"),
  bK("游戏币"),
  bL("游戏币"),
  bM("游戏币"),
  bN("游戏币"),
  bO("游戏币"),
  bP("游戏币"),
  bQ("游戏币"),
  ba("游戏币"),
  bb("游戏币"),
  bc("游戏币"),
  bd("游戏币"),
  be("游戏币"),
  bf("游戏币"),
  bg("游戏币"),
  bh("游戏币"),
  bi("游戏币"),
  bj("游戏币"),
  bk("游戏币"),
  bl("游戏币"),
  bm("游戏币"),
  bn("游戏币"),
  bo("游戏币"),
  bp("游戏币"),
  bq("游戏币"),
  br("游戏币"),
  bs("游戏币"),
  bt("游戏币"),
  bu("游戏币"),
  bv("游戏币"),
  bw("游戏币"),
  bx("游戏币"),
  by("游戏币"),
  bz("游戏币"),
  c("游戏币"),
  d("余额："),
  e("余额: "),
  f("道具:"),
  g("<font color='#FF0000'>%s</font>游戏币"),
  h("提示"),
  i("防沉迷认证"),
  j("验证账号"),
  k("请输入账号"),
  l("账号密码"),
  m("请输入密码"),
  n("防沉迷验证"),
  o("已成年"),
  p("未成年"),
  q("进行验证"),
  r("以后再说"),
  s("<b>保护未成年人身心健康，<font color='#F17040'>未满18周岁的用户</font>将受到防沉迷系统的限制：<br> １．游戏过程,会提示您的累计在线时间;<br>２．累计游戏时间超过3小时,游戏收益(经验,金钱)减半;<br>３．累计游戏时间超过5小时,游戏收益为0;<br>４．如遇问题,请在游戏中与游戏客服联系;"),
  t("验证失败!"),
  u(""),
  v("如有疑问请联系客服，<br /><b>客服热线</b>： <a>4007555999</a><br><b>客服邮箱</b>：87686529@qq.com。"),
  w("充值中心"),
  x("充值中心"),
  y("%s - %s"),
  z("充值数量");
  
  private String bR;
  
  static {
    A = new cg("CC_RECHARGE_PROP_DESC", 26, "道具: %s");
    B = new cg("CC_RECHARGE_PROP_DESC_2", 27, "道具");
    C = new cg("CC_RECHARGE_PROP_LABEL", 28, "道具：");
    D = new cg("CC_RECHARGE_PROP_NAME_RECHARGE", 29, "%s %s");
    E = new cg("CC_RECHARGE_PROP_NAME_PAY", 30, "%s 元");
    F = new cg("CC_RECHARGE_PRICE_DESC", 31, "价格: %s %s");
    G = new cg("CC_RECHARGE_PRICE_LABEL", 32, "价格: ");
    H = new cg("CC_RECHARGE_PRICE_LABEL_2", 33, "价格");
    I = new cg("CC_RECHARGE_AMOUNT", 34, "充值金额");
    J = new cg("CC_RECHARGE_AMOUNT_HINE", 35, "请输入金额");
    K = new cg("CC_RECHARGE_UNIT_YUAN", 36, "元");
    L = new cg("CC_RECHARGE_COUNT_ZZ", 37, "使用余额支付: <font color='#FF0000'>%s</font>%s");
    M = new cg("CC_RECHARGE_COUNT_ZZ_BALANCE", 38, "还需支付: <font color='#FF0000'>%s</font>元");
    N = new cg("CC_RECHARGE_COUNT_ZZ_BALANCE_2", 39, "实付金额: <font color='#FF0000'>%s</font>元");
    O = new cg("CC_RECHARGE_COUNT_ZZ_BALANCE_ENOUGH", 40, "您的余额足够，可直接用于支付！");
    P = new cg("CC_RECHARGE_COUNT_TITLE_PRICE", 41, "道具价格");
    Q = new cg("CC_RECHARGE_COUNT", 42, "充值数量");
    R = new cg("CC_RECHARGE_COUNT_HINT", 43, "请选择金额");
    S = new cg("CC_RECHARGE_COUNT_CHECK_FAILED", 44, "请输入正确的充值数量");
    T = new cg("CC_RECHARGE_COUNT_CHECK_LARGE", 45, "充值数量大于充值卡最大面额，请选择其它支付方式！");
    U = new cg("CC_RECHARGE_COUNT_DESC", 46, "游戏币");
    V = new cg("CC_RECHARGE_COUNT_DESC_COMM", 47, "游戏币");
    W = new cg("CC_RECHAGRE_COST_DESC", 48, "应付金额：");
    X = new cg("CC_RECHAGRE_COST_UNIT", 49, "%s元");
    Y = new cg("CC_RECHAGRE_COST_UNIT_ZYCOIN", 50, "<font color='#FF0000'>%s</font>%s");
    Z = new cg("CC_RECHARGE_COST_SUMMARY", 51, "支付金额大于1000元，建议使用大额支付。");
    aa = new cg("CC_RECHAGRE_CANDIDATE_UNIT", 52, "%s");
    ab = new cg("CC_RECHAGRE_BALANCE", 53, "%s，您当前拥有 %s %s。");
    ac = new cg("CC_RECHAGRE_BALANCE_2", 54, "您当前拥有 %s %s。");
    ad = new cg("CC_RECHAGRE_BALANCE_3", 55, "您当前拥有");
    ae = new cg("CC_RECHAGRE_ACCOUNT", 56, "账号：%s");
    af = new cg("CC_RECHAGRE_ACCOUNT_2", 57, "账号：");
    ag = new cg("CC_RECHARGE_PAYMENT_AMOUNT", 58, "支付金额: %s元");
    ah = new cg("CC_RECHARGE_PAY_MONEY", 59, "付款金额: <font color='#FF0000'>%s</font>元");
    ai = new cg("CC_RECHAGRE_ROLE_ID", 60, "角色ID：");
    aj = new cg("CC_TRY_CONNECT_SERVER", 61, "正在与服务器通信...");
    ak = new cg("CC_TRY_CONNECT_SERVER_CANCELD", 62, "连接被取消！");
    al = new cg("CC_TRY_CONNECT_SERVER_FAILED", 63, "网络繁忙，请稍候重试！");
    am = new cg("CC_TRY_CONNECT_SERVER_FAILED2", 64, "网络连接失败，请确认您的网络是否正常后再尝试，如需帮助请联系客服。");
    an = new cg("CC_TRY_CONNECT_SERVER_TIMEOUT", 65, "网络连接超时，请继续等待或稍候重试！");
    ao = new cg("CC_TRY_CHARGE_FAILED", 66, "暂时不能使用，请尝试其它支付方式！\n如有疑问请与客服联系！");
    ap = new cg("CC_EXIT_LOCKED_TIP", 67, "如需中止操作，请立即再次按下[返回]");
    aq = new cg("CC_RECHARGE_WEB_TIP_ABORT", 68, "交易尚未完成，是否要结束交易？");
    ar = new cg("CC_RECHARGE_WAIT_RESULT", 69, "等待充值结果……");
    as = new cg("CC_RECHARGE_RESULT_SUCCESS", 70, "充值正在进行中，请稍后在游戏中查看，一般1-10分钟到账，如未到账，请联系客服。祝您游戏愉快！");
    at = new cg("CC_RECHARGE_RESULT_SUCCESS_ZYCOIN", 71, "充值正在进行中，请稍候刷新余额，一般1-10分钟到账，如未到账，请联系客服。祝您游戏愉快！");
    au = new cg("CC_RECHARGE_RESULT_CANCEL", 72, "充值操作被取消！");
    av = new cg("CC_RECHARGE_RESULT_FAILED", 73, "充值未到账！请立即联系客服解决问题。祝您游戏愉快！");
    aw = new cg("CC_RECHARGE_RESULT_FAILED_CARD", 74, "您填写的卡号和密码不匹配，请重新输入");
    ax = new cg("CC_RECHARGE_NOT_ADULT", 75, "抱歉，由于您的年龄未满18岁，根据国家相关要求不能购买游戏道具。");
    ay = new cg("CC_TRY_SMS_NO_IMSI", 76, "对不起，手机没有插入SIM卡，无法使用话费支付，请选择其它支付方式，如需帮助请联系客服!");
    az = new cg("CC_TRY_SMS_NO_CHANNEL", 77, "获取不到支付通道，请选择其他方式!");
    aA = new cg("CC_TRY_SMS_NO_MATCH", 78, "该充值方式，没有您选择的商品金额，请选择其他方式！");
    aB = new cg("CC_TRY_SMS_FAILED", 79, "对不起，话费支付失败！请确认您的卡是否已欠费或已失效，如需帮助请联系客服!");
    aC = new cg("CC_TRY_SMS_CHOOSE_TITILE", 80, "请选择充值金额：");
    aD = new cg("CC_TRY_SMS_OTHER_MODE", 81, "其他支付方式");
    aE = new cg("CC_TRY_SMS_CHOOSE_PREFIX", 82, "充值");
    aF = new cg("CC_TRY_SMS_CHOOSE_CONTENT", 83, "%s元");
    aG = new cg("CC_TRY_SMS_PROMPT_HTML", 84, "您将使用<font color='#F17040'>%s</font>公司提供的<font color='#F17040'>%s</font>业务进行代支付,资费是<font color='#F17040'> %s </font>元，您将收到相关的短信提示，请注意查收！");
    aH = new cg("CC_SMS_TIP_WAIT_PLEASE", 85, "请耐心等待!");
    aI = new cg("CC_SMS_TIP_WAIT_SENDMSG", 86, "正在为您充值……");
    aJ = new cg("CC_SMS_TIP_PAYING", 87, "正在充值！");
    aK = new cg("CC_SMS_TIP_WAIT_SENDMSG_TIMEOUT", 88, "短信发送超时，请稍候重试或继续等待！");
    aL = new cg("CC_SMS_TIP_WAIT_RESULT", 89, "正在等待充值结果……");
    aM = new cg("CC_SMS_TIP_WAIT_RESULT_TIMEOUT_HTML", 90, "等待充值结果超时，请<a>联系客服</a>或<a>继续等待</a>！");
    aN = new cg("CC_SMS_TIP_WAIT_SEEDBACK", 91, "正在通知服务器，请保持网络畅通并耐心等待……");
    aO = new cg("CC_SMS_TIP_WAIT_SEEDBACK_TIMEOUT_HTML", 92, "等待超时，请<a>联系客服</a>或<a>继续等待</a>！");
    aP = new cg("CC_SMS_TIP_SEEDBACK_FAILED", 93, "网络繁忙，请联系客服或重试！");
    aQ = new cg("CC_SMS_TIP_WAIT_INIT", 94, "正在初始化……");
    aR = new cg("CC_SMS_ERR_INIT", 95, "初始化失败！错误号[%d]");
    aS = new cg("CC_SMS_TIP_WAIT_BILLING", 96, "正在交易，请耐心等待并保持网络通畅……");
    aT = new cg("CC_SMS_ERR_BILLING", 97, "支付失败！错误号[%d]");
    aU = new cg("CC_SMS_CANCEL_BILLING", 98, "支付被取消！");
    aV = new cg("CC_SMS_TIP_ORDER_DETAIL", 99, "订单详情");
    aW = new cg("CC_SMS_TIP_ORDER_COPY", 100, "复制");
    aX = new cg("CC_SMS_TIP_ORDER_COPY_OK", 101, "复制成功，请与客服联系！\n祝您游戏愉快！");
    aY = new cg("CC_HINT_LOADING", 102, "拼命加载中...");
    aZ = new cg("CC_PAUCHANNEL_TITLE_CHOOSE", 103, "选择支付方式：");
    ba = new cg("CC_PAYCHANNEL_TITLE", 104, "支付方式");
    bb = new cg("CC_CARDNUM_DESC", 105, "请输入卡号");
    bc = new cg("CC_CARDNUM_CHECK_FAILED", 106, "请输入完整的充值卡卡号");
    bd = new cg("CC_PASSWD_DESC", 107, "请输入密码");
    be = new cg("CC_PASSWD_CHECK_FAILED", 108, "请输入完整的充值卡密码");
    bf = new cg("CC_CARDNUM_HINT", 109, "请输入卡号（%d位）");
    bg = new cg("CC_PASSWD_HINT", 110, "请输入卡密（%d位）");
    bh = new cg("CC_PAYTYPE_DESC", 111, "请点击确认充值，进入到%s充值界面");
    bi = new cg("CC_PAYTYPE_DESC_DISABLED", 112, "暂不可使用%s充值，请使用其他方式");
    bj = new cg("CC_PAYTYPE_COIN_DESC", 113, "确认后，将扣除%s%s，您的余额为%s");
    bk = new cg("CC_PAYTYPE_COIN_DESC_POOR", 114, "%s余额不足，请更换其他方式进行支付");
    bl = new cg("CC_COMMIT_RECHARGE", 115, "立即支付");
    bm = new cg("CC_COMMIT_RECHARGE_SM", 116, "确认支付");
    bn = new cg("CC_NEXT_RECHARGE", 117, "下一步");
    bo = new cg("CC_COMMIT_RECHARGE_SMS", 118, "确认提交");
    bp = new cg("CC_COMMIT_BUY", 119, "确认购买");
    bq = new cg("CC_COMMIT_EXCHANGE", 120, "确认兑换");
    br = new cg("CC_COMMIT_RESULT", 121, "确认");
    bs = new cg("CC_PAYCHANNEL_ERROR", 122, "很抱歉！未能获取到可用的支付通道。");
    bt = new cg("CC_PAYCHANNEL_NOCHOOSE", 123, "必须选择一个可用的支付通道！");
    bu = new cg("CC_HELP_TITLE", 124, "充值说明");
    bv = new cg("CC_HELP_TEL", 125, "客服电话: 4007555999");
    bw = new cg("CC_RECHARGE_LIST_NONE", 126, "不能显示候选列表");
    bx = new cg("CC_EXCHANGE_TITLE", 127, "道具兑换");
    by = new cg("CC_EXCHANGE_DETAIL_TITLE", 128, "兑换——%s");
    bz = new cg("CC_EXCHANGE_DETAIL_PRICE_DESC", 129, "价格：%s游戏币");
    bA = new cg("CC_EXCHANGE_DETAIL_BALANCE_DESC", 130, "本次消费%s，您的余额还有%s");
    bB = new cg("XLISTVIEW_HEADER_HINT_NORMAL", 131, "下拉刷新");
    bC = new cg("XLISTVIEW_HEADER_HINT_READY", 132, "松开刷新数据");
    bD = new cg("XLISTVIEW_HEADER_HINT_LOADING", 133, "正在加载...");
    bE = new cg("XLISTVIEW_HEADER_LAST_TIME", 134, "上次更新时间：");
    bF = new cg("XLISTVIEW_FOOTER_HINT_NORMAL", 135, "查看更多");
    bG = new cg("XLISTVIEW_FOOTER_HINT_READY", 136, "松开载入更多");
    bH = new cg("XLISTVIEW_FOOTER_HINT_LOADING", 137, "正在加载更多...");
    bI = new cg("BITMAP_FUN_BADNETWORK", 138, "请检查网络连接！");
    bJ = new cg("YB_TEXT_VALUE", 139, "请选择面额(<font color='#e7b376'>与充值卡实际面额保持一致</font>)");
    bK = new cg("YB_ERR_NEED_CHOOSE", 140, "请选择充值卡类型和面额!");
    bL = new cg("YB_ERR_NEED_CHOOSE_CARD", 141, "请选择充值卡类型!");
    bM = new cg("YB_DECE_NUMBER", 142, "充值卡号");
    bN = new cg("YB_DECE_PWD", 143, "充值密码");
    bO = new cg("YB_DECE_SERVICE", 144, "%d元充值卡充值成%d个游戏币");
    bP = new cg("YB_DECE_SERVICE_COMM", 145, "%d元充值卡充值成%d个游戏币");
    bQ = new cg("YB_PAY_COUNT", 146, "待支付金额: <font color='#FF0000'>%s元</font>");
    bS = new cg[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x, y, z, A, B, C, D, 
        E, F, G, H, I, J, K, L, M, N, 
        O, P, Q, R, S, T, U, V, W, X, 
        Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
        ai, aj, ak, al, am, an, ao, ap, aq, ar, 
        as, at, au, av, aw, ax, ay, az, aA, aB, 
        aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, 
        aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, 
        aW, aX, aY, aZ, ba, bb, bc, bd, be, bf, 
        bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, 
        bq, br, bs, bt, bu, bv, bw, bx, by, bz, 
        bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, 
        bK, bL, bM, bN, bO, bP, bQ };
  }
  
  cg(String paramString1) {
    this.bR = paramString1;
  }
  
  public String a() {
    return this.bR;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.zz.sdk.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.io.File;

public enum ca {
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
  a("fubiao_close_normal.png"),
  aA("fubiao_close_normal.png"),
  aB("fubiao_close_normal.png"),
  aC("fubiao_close_normal.png"),
  aD("fubiao_close_normal.png"),
  aE("fubiao_close_normal.png"),
  aF("fubiao_close_normal.png"),
  aG("fubiao_close_normal.png"),
  aH("fubiao_close_normal.png"),
  aI("fubiao_close_normal.png"),
  aJ("fubiao_close_normal.png"),
  aK("fubiao_close_normal.png"),
  aL("fubiao_close_normal.png"),
  aM("fubiao_close_normal.png"),
  aN("fubiao_close_normal.png"),
  aO("fubiao_close_normal.png"),
  aP("fubiao_close_normal.png"),
  aQ("fubiao_close_normal.png"),
  aR("fubiao_close_normal.png"),
  aS("fubiao_close_normal.png"),
  aT("fubiao_close_normal.png"),
  aU("fubiao_close_normal.png"),
  aV("fubiao_close_normal.png"),
  aW("fubiao_close_normal.png"),
  aX("fubiao_close_normal.png"),
  aY("fubiao_close_normal.png"),
  aZ("fubiao_close_normal.png"),
  aa("fubiao_close_normal.png"),
  ab("fubiao_close_normal.png"),
  ac("fubiao_close_normal.png"),
  ad("fubiao_close_normal.png"),
  ae("fubiao_close_normal.png"),
  af("fubiao_close_normal.png"),
  ag("fubiao_close_normal.png"),
  ah("fubiao_close_normal.png"),
  ai("fubiao_close_normal.png"),
  aj("fubiao_close_normal.png"),
  ak("fubiao_close_normal.png"),
  al("fubiao_close_normal.png"),
  am("fubiao_close_normal.png"),
  an("fubiao_close_normal.png"),
  ao("fubiao_close_normal.png"),
  ap("fubiao_close_normal.png"),
  aq("fubiao_close_normal.png"),
  ar("fubiao_close_normal.png"),
  as("fubiao_close_normal.png"),
  at("fubiao_close_normal.png"),
  au("fubiao_close_normal.png"),
  av("fubiao_close_normal.png"),
  aw("fubiao_close_normal.png"),
  ax("fubiao_close_normal.png"),
  ay("fubiao_close_normal.png"),
  az("fubiao_close_normal.png"),
  b("fubiao_close_pressed.png"),
  bA("fubiao_close_pressed.png"),
  bB("fubiao_close_pressed.png"),
  bC("fubiao_close_pressed.png"),
  bD("fubiao_close_pressed.png"),
  bE("fubiao_close_pressed.png"),
  bF("fubiao_close_pressed.png"),
  bG("fubiao_close_pressed.png"),
  bH("fubiao_close_pressed.png"),
  bI("fubiao_close_pressed.png"),
  bJ("fubiao_close_pressed.png"),
  bK("fubiao_close_pressed.png"),
  bL("fubiao_close_pressed.png"),
  bM("fubiao_close_pressed.png"),
  bN("fubiao_close_pressed.png"),
  bO("fubiao_close_pressed.png"),
  bP("fubiao_close_pressed.png"),
  bQ("fubiao_close_pressed.png"),
  bR("fubiao_close_pressed.png"),
  bS("fubiao_close_pressed.png"),
  bT("fubiao_close_pressed.png"),
  bU("fubiao_close_pressed.png"),
  bV("fubiao_close_pressed.png"),
  bW("fubiao_close_pressed.png"),
  bX("fubiao_close_pressed.png"),
  bY("fubiao_close_pressed.png"),
  bZ("fubiao_close_pressed.png"),
  ba("fubiao_close_pressed.png"),
  bb("fubiao_close_pressed.png"),
  bc("fubiao_close_pressed.png"),
  bd("fubiao_close_pressed.png"),
  be("fubiao_close_pressed.png"),
  bf("fubiao_close_pressed.png"),
  bg("fubiao_close_pressed.png"),
  bh("fubiao_close_pressed.png"),
  bi("fubiao_close_pressed.png"),
  bj("fubiao_close_pressed.png"),
  bk("fubiao_close_pressed.png"),
  bl("fubiao_close_pressed.png"),
  bm("fubiao_close_pressed.png"),
  bn("fubiao_close_pressed.png"),
  bo("fubiao_close_pressed.png"),
  bp("fubiao_close_pressed.png"),
  bq("fubiao_close_pressed.png"),
  br("fubiao_close_pressed.png"),
  bs("fubiao_close_pressed.png"),
  bt("fubiao_close_pressed.png"),
  bu("fubiao_close_pressed.png"),
  bv("fubiao_close_pressed.png"),
  bw("fubiao_close_pressed.png"),
  bx("fubiao_close_pressed.png"),
  by("fubiao_close_pressed.png"),
  bz("fubiao_close_pressed.png"),
  c("fubiao_logo_news.png"),
  cA("fubiao_logo_news.png"),
  cB("fubiao_logo_news.png"),
  cC("fubiao_logo_news.png"),
  cD("fubiao_logo_news.png"),
  cE("fubiao_logo_news.png"),
  cF("fubiao_logo_news.png"),
  cG("fubiao_logo_news.png"),
  cH("fubiao_logo_news.png"),
  cI("fubiao_logo_news.png"),
  cJ("fubiao_logo_news.png"),
  cK("fubiao_logo_news.png"),
  cL("fubiao_logo_news.png"),
  cM("fubiao_logo_news.png"),
  cN("fubiao_logo_news.png"),
  cO("fubiao_logo_news.png"),
  cP("fubiao_logo_news.png"),
  cQ("fubiao_logo_news.png"),
  cR("fubiao_logo_news.png"),
  cS("fubiao_logo_news.png"),
  cT("fubiao_logo_news.png"),
  cU("fubiao_logo_news.png"),
  cV("fubiao_logo_news.png"),
  cW("fubiao_logo_news.png"),
  cX("fubiao_logo_news.png"),
  cY("fubiao_logo_news.png"),
  cZ("fubiao_logo_news.png"),
  ca("fubiao_logo_news.png"),
  cb("fubiao_logo_news.png"),
  cc("fubiao_logo_news.png"),
  cd("fubiao_logo_news.png"),
  ce("fubiao_logo_news.png"),
  cf("fubiao_logo_news.png"),
  cg("fubiao_logo_news.png"),
  ch("fubiao_logo_news.png"),
  ci("fubiao_logo_news.png"),
  cj("fubiao_logo_news.png"),
  ck("fubiao_logo_news.png"),
  cl("fubiao_logo_news.png"),
  cm("fubiao_logo_news.png"),
  cn("fubiao_logo_news.png"),
  co("fubiao_logo_news.png"),
  cp("fubiao_logo_news.png"),
  cq("fubiao_logo_news.png"),
  cr("fubiao_logo_news.png"),
  cs("fubiao_logo_news.png"),
  ct("fubiao_logo_news.png"),
  cu("fubiao_logo_news.png"),
  cv("fubiao_logo_news.png"),
  cw("fubiao_logo_news.png"),
  cx("fubiao_logo_news.png"),
  cy("fubiao_logo_news.png"),
  cz("fubiao_logo_news.png"),
  d("fubiao_logo.png"),
  da("fubiao_logo.png"),
  db("fubiao_logo.png"),
  dc("fubiao_logo.png"),
  dd("fubiao_logo.png"),
  de("fubiao_logo.png"),
  df("fubiao_logo.png"),
  dg("fubiao_logo.png"),
  dh("fubiao_logo.png"),
  e("fubiao_logo_red_dot.png"),
  f("fubiao_service.png"),
  g("fubiao_safe.png"),
  h("fubiao_line.png"),
  i("fubiao_bg.png"),
  j("fubiao_close.png"),
  k("fubiao_news.png"),
  l("fubiao_ret_normal.png"),
  m("fubiao_ret_pressed.png"),
  n("fubiao_share_normal.png"),
  o("fubiao_share_pressed.png"),
  p("fubiao_jar_share.png"),
  q("fubiao_jar_refresh.png"),
  r("user_info_icon.png"),
  s("text_cursor_holo_light.9.png"),
  t("cc_background.9.png"),
  u("cc_background.png"),
  v("cc_button.9.png"),
  w("cc_button_click.9.png"),
  x("cc_buy_button.9.png"),
  y("cc_buy_button_click.9.png"),
  z("cc_charge_pull.png");
  
  private static final String dj = "drawable";
  
  private static final String dk = "logo";
  
  private String di;
  
  static {
    A = new ca("CHARGE_PULL_CLICK", 26, "cc_charge_pull_click.png");
    B = new ca("CHARGE_PULL_CANDIDATE_SEL", 27, "cc_cand_sel.9.png");
    C = new ca("EX_BUTTON", 28, "cc_ex_button.9.png");
    D = new ca("EX_BUTTON_CLICK", 29, "cc_ex_button_click.9.png");
    E = new ca("EX_RIGHT", 30, "cc_ex_Right.png");
    F = new ca("EX_RIGHT_CLICK", 31, "cc_ex_Right_click.png");
    G = new ca("HELP", 32, "cc_help.png");
    H = new ca("MONEY", 33, "cc_money.png");
    I = new ca("PAYMENT_INPUT", 34, "cc_payment_input.9.png");
    J = new ca("RECHARGE_BAN", 35, "cc_recharge_ban.9.png");
    K = new ca("RECHARGE_INPUT", 36, "cc_recharge_input.9.png");
    L = new ca("RECHARGE_INPUT_BG", 37, "cc_input_bg.9.png");
    M = new ca("TUP_CFT", 38, "cc_tup_cft.png");
    N = new ca("TUP_DX", 39, "cc_tup_dx.png");
    O = new ca("TUP_LT", 40, "cc_tup_lt.png");
    P = new ca("TUP_SJDX", 41, "cc_tup_sjdx.png");
    Q = new ca("TUP_YD", 42, "cc_tup_yd.png");
    R = new ca("TUP_YL", 43, "cc_tup_yl.png");
    S = new ca("TUP_ZFB", 44, "cc_tup_zfb.png");
    T = new ca("TUP_ZFB_PLUG", 45, "cc_tup_msp.png");
    U = new ca("TUP_ZYB", 46, "cc_tup_zyb.png");
    V = new ca("TUP_DEZF", 47, "cc_tup_dezf.png");
    W = new ca("TUP_SINA", 48, "cc_tup_sina.png");
    X = new ca("TUP_MO9", 49, "cc_tup_mo9.png");
    Y = new ca("TUP_WEIXIN", 50, "cc_tup_weixin.png");
    Z = new ca("TUP_SNDA", 51, "cc_tup_snda.png");
    aa = new ca("TUP_JUNKA", 52, "cc_tup_jk.png");
    ab = new ca("ZF_WXZ", 53, "cc_zf_wxz.9.png");
    ac = new ca("ZF_XZ", 54, "cc_zf_xz.9.png");
    ad = new ca("TUP_PAYCARDS", 55, "cc_tup_paycard.png");
    ae = new ca("TUP_JOYPAY", 56, "jpay_icon.png");
    af = new ca("TUP_JDPAY", 57, "cc_tup_jd.png");
    ag = new ca("TITLE_BACKGROUND", 58, "cc_title_bg.9.png");
    ah = new ca("TITLE_BACK_DEFAULT", 59, "dl_btn_return_normal.png");
    ai = new ca("TITLE_BACK_PRESSED", 60, "dl_btn_return_pressed.png");
    aj = new ca("TITLE_DETAILS", 61, "details.png");
    ak = new ca("PANEL_BACKGROUND", 62, "cc_panel.9.png");
    al = new ca("PAYLIST_SELECTED", 63, "cc_cand_sel.9.png");
    am = new ca("PAYLIST_NORMAL", 64, "cc_paylist_nor.9.png");
    an = new ca("PAYLIST_SELECTED2", 65, "cc_cand_sel2.png");
    ao = new ca("PAYLIST_NORMAL2", 66, "cc_paylist_nor2.png");
    ap = new ca("PAYLIST_CLOSE", 67, "cc_simplify_close.png");
    aq = new ca("PAYLIST_WHITE", 68, "white.9.png");
    ar = new ca("PAYLIST_LINE", 69, "line.9.png");
    as = new ca("PAYLIST_CHECK", 70, "check.png");
    at = new ca("PAYLIST_CHECK_2", 71, "check_2.png");
    au = new ca("PAYLIST_CHECK_3", 72, "check_3.png");
    av = new ca("PAYLIST_CHECKED", 73, "checked.png");
    aw = new ca("PAYLIST_CHECKED_2", 74, "checked_2.png");
    ax = new ca("PAYLIST_CHECKED_3", 75, "checked_3.png");
    ay = new ca("PAYLIST_INPUT", 76, "input.9.png");
    az = new ca("PAYLIST_SELECT", 77, "select_icon_hover.png");
    aA = new ca("PAYLIST_LABA", 78, "game_laba_icon.png");
    aB = new ca("PAY_BTN_NORMAL", 79, "pay_btn_normal.png");
    aC = new ca("PAY_BTN_PRESSED", 80, "pay_btn_pressed.png");
    aD = new ca("PAY_BTN_SELECT_NUM", 81, "pay_btn_select_num.png");
    aE = new ca("PAY_HOT", 82, "pay_hot.png");
    aF = new ca("PAY_WX_BTN_DONE_NORMAL", 83, "pay_wx_btn_done_normal.png");
    aG = new ca("PAY_WX_BTN_DONE_PRESSED", 84, "pay_wx_btn_done_pressed.png");
    aH = new ca("PAY_WX_BTN_CANCEL_NORMAL", 85, "pay_wx_btn_cancel_normal.png");
    aI = new ca("PAY_WX_BTN_CANCEL_PRESSED", 86, "pay_wx_btn_cancel_pressed.png");
    aJ = new ca("PAY_STATUS_REFRESH", 87, "pay_refresh.png");
    aK = new ca("PAY_HELP_CLOSE", 88, "help_close.png");
    aL = new ca("RECORDE_BT_YELLOW", 89, "btn_yellow.9.png");
    aM = new ca("RECORDE_BT_LEFT_SELECTED", 90, "recorde_bt_left_selected.png");
    aN = new ca("RECORDE_BT_LEFT_NORMAL", 91, "recorde_bt_left_normal.png");
    aO = new ca("RECORDE_BT_MIDDLE_SELECTED", 92, "recorde_bt_middle_selected.png");
    aP = new ca("RECORDE_BT_MIDDLE_NORMAL", 93, "recorde_bt_middle_normal.png");
    aQ = new ca("RECORDE_BT_RIGHT_SELECTED", 94, "recorde_bt_right_selected.png");
    aR = new ca("RECORDE_BT_RIGHT_NORMAL", 95, "recorde_bt_right_normal.png");
    aS = new ca("RECORDE_PACK_UP", 96, "pack_up.png");
    aT = new ca("RECORDE_PACK_OUT", 97, "pack_out.png");
    aU = new ca("XLISTVIEW_ARROW", 98, "xlistview_arrow.png");
    aV = new ca("EMPTY_PHOTO", 99, "empty_photo.png");
    aW = new ca("SPINNER_BACK", 100, "spinner.png");
    aX = new ca("SPINNER_TXT_DEFAULT", 101, "spinnertxt_default.png");
    aY = new ca("SPINNER_TXT_CLICK", 102, "spinnertxt_press.png");
    aZ = new ca("LOGIN_BUTTON_LV_CLICK", 103, "login_button_lv_click.9.png");
    ba = new ca("LOGIN_BUTTON_LV", 104, "login_button_lv.9.png");
    bb = new ca("LOGIN_BUTTON_LAN_CLICK", 105, "login_button_lan_click.9.png");
    bc = new ca("LOGIN_BUTTON_LAN", 106, "login_button_lan.9.png");
    bd = new ca("LOGIN_BUTTON_HUI_CLICK", 107, "login_button_hui_click.9.png");
    be = new ca("LOGIN_BUTTON_HUI", 108, "login_button_hui.9.png");
    bf = new ca("LOGIN_BUTTON_HUANG_CLICK", 109, "login_button_huang_click.9.png");
    bg = new ca("LOGIN_BUTTON_HUANG", 110, "login_button_huang.9.png");
    bh = new ca("LOGIN_BUTTON_KUAI", 111, "login_button_kuai.png");
    bi = new ca("LOGIN_BUTTON_KUAI_ANXIA", 112, "login_button_kuai_anxia.png");
    bj = new ca("LOGIN_BUTTON", 113, "btn_login_default.9.png");
    bk = new ca("LOGIN_BUTTON_PRESSED", 114, "btn_login_pressed.9.png");
    bl = new ca("LOGIN_EDIT", 115, "login_edit_press.9.png");
    bm = new ca("LOGIN_RADIO", 116, "btn_radio_off.png");
    bn = new ca("LOGIN_RADIO_PRESSED", 117, "btn_radio_pressed.png");
    bo = new ca("LOGIN_LABE_LAN", 118, "labe_lan.9.png");
    bp = new ca("LOGIN_LABE_HUI", 119, "labe_hui.9.png");
    bq = new ca("LOGIN_COUNT", 120, "count.png");
    br = new ca("LOGIN_PWD", 121, "pwd.png");
    bs = new ca("LOGIN_LINEAR", 122, "login_edit.9.png");
    bt = new ca("LOGIN_BACK", 123, "land.9.png");
    bu = new ca("LOGIN_LOGO", 124, "logo.png");
    bv = new ca("LOGIN_LOGO2", 125, "logo2.png");
    bw = new ca("LOGIN_SDK_BACK", 126, "sdk_back.png");
    bx = new ca("LOGIN_TEXT_BACK_PRESS", 127, "login_text_bg_pressed.9.png");
    by = new ca("LOGIN_TEXT_BACK_DEFAULT", 128, "login_text_bg_default.9.png");
    bz = new ca("LOGIN_UNDER_LINE", 129, "underline.png");
    bA = new ca("LOGIN_DELETE", 130, "remove_hover.png");
    bB = new ca("LOGIN_DELETE_CLICK", 131, "remove_link.png");
    bC = new ca("AUTO_BD", 132, "auto_login_bg.9.png");
    bD = new ca("AUTO_CANCLE", 133, "cancel.9.png");
    bE = new ca("AUTO_CANCLE_CLICK", 134, "cancel_click.9.png");
    bF = new ca("USER_ICON", 135, "user_icon.png");
    bG = new ca("PWD_ICON", 136, "pwd_icon.png");
    bH = new ca("CIRCLE", 137, "circle_image.png");
    bI = new ca("ANTIADDICTION_TIP", 138, "antiaddiction_tip.png");
    bJ = new ca("ANTIADDICTION_DOTLINE", 139, "antiaddiction_dotline.png");
    bK = new ca("ANTIADDICTION_RADIO_SEL", 140, "antiaddiction_radio_sel.png");
    bL = new ca("ANTIADDICTION_RADIO_NOR", 141, "antiaddiction_radio_nor.png");
    bM = new ca("ANTIADDICTION_COMMIT_LINK", 142, "antiaddiction_commit_link.9.png");
    bN = new ca("ANTIADDICTION_COMMIT_HOVER", 143, "antiaddiction_commit_hover.9.png");
    bO = new ca("ANTIADDICTION_CANCEL_LINK", 144, "antiaddiction_cancel_link.9.png");
    bP = new ca("ANTIADDICTION_CANCEL_HOVER", 145, "antiaddiction_cancel_hover.9.png");
    bQ = new ca("ANTIADDICTION_LOGO", 146, "antiaddiction_logo.png");
    bR = new ca("PWD_PROMPT", 147, "f_info_icon.png");
    bS = new ca("PWD_PHONE", 148, "f_tel_icon.png");
    bT = new ca("PWD_EMAIL", 149, "f_email_icon.png");
    bU = new ca("PWD_BACKPWD", 150, "f_lock_bg.png");
    bV = new ca("YB_BACKDEFAULT", 151, "yb_back_default.9.png");
    bW = new ca("YB_BACKPRESS", 152, "yb_back_pressed.9.png");
    bX = new ca("YB_BACK_UNPRESS", 153, "uncheck.9.png");
    bY = new ca("YX_DL_BG", 154, "yx_dl_bg.png");
    bZ = new ca("YX_DL_FAST_BTN_PRESSED", 155, "yx_dl_fast_btn_pressed.png");
    ca = new ca("YX_DL_FAST_BTN_DEFAULT", 156, "yx_dl_fast_btn_default.png");
    cb = new ca("YX_DL_FAST_BTN_FOCUSED", 157, "tv_dl_fast_btn_pressed.png");
    cc = new ca("YX_DL_REG_BTN_PRESSED", 158, "yx_dl_reg_btn_pressed.png");
    cd = new ca("YX_DL_REG_BTN_DEFAULT", 159, "yx_dl_reg_btn_default.png");
    ce = new ca("YX_DL_REG_BTN_FOCUSED", 160, "tv_dl_reg_btn_pressed.png");
    cf = new ca("YX_DL_BTN_PRESSED", 161, "yx_dl_btn_pressed.png");
    cg = new ca("YX_DL_BTN_DEFAULT", 162, "yx_dl_btn_default.png");
    ch = new ca("YX_DL_BTN_FOCUSED", 163, "tv_dl_btn_pressed.png");
    ci = new ca("YX_DL_LINE_SELECTED", 164, "yx_dl_line_selected.png");
    cj = new ca("YX_DL_LINE_DEFAULT", 165, "yx_dl_line_default.png");
    ck = new ca("YX_DL_USER_SELECTED", 166, "yx_dl_user_selected.png");
    cl = new ca("YX_DL_USER_DEFAULT", 167, "yx_dl_user_default.png");
    cm = new ca("YX_DL_LOCK_SELECTED", 168, "yx_dl_lock_selected.png");
    cn = new ca("YX_DL_LOCK_DEFAULT", 169, "yx_dl_lock_default.png");
    co = new ca("YX_DL_YZM_RIGHT_PRESSED", 170, "yx_dl_yzm_right_pressed.png");
    cp = new ca("YX_DL_YZM_RIGHT_DEFAULT", 171, "yx_dl_yzm_right_default.png");
    cq = new ca("YX_DL_YZM_RIGHT_FOCUSED", 172, "tv_dl_yzm_right_pressed.png");
    cr = new ca("YX_DL_BTN_LATER_PRESSED", 173, "yx_dl_btn_later_pressed.png");
    cs = new ca("YX_DL_BTN_LATER_DEFAULT", 174, "yx_dl_btn_later_default.png");
    ct = new ca("YX_DL_PHONE_SELECTED", 175, "yx_dl_phone_selected.png");
    cu = new ca("YX_DL_PHONE_NORMAL", 176, "yx_dl_phone_normal.png");
    cv = new ca("YX_DL_CODE_SELECTED", 177, "yx_dl_code_selected.png");
    cw = new ca("YX_DL_CODE_NORMAL", 178, "yx_dl_code_normal.png");
    cx = new ca("YX_DL_TEXT_FOCUSED", 179, "tv_dl_text_pressed.png");
    cy = new ca("DL_BTN_RETURN_NORMAL", 180, "dl_btn_return_normal.png");
    cz = new ca("DL_BTN_RETURN_PRESSED", 181, "dl_btn_return_pressed.png");
    cA = new ca("DL_BTN_RETURN_FOCUSED", 182, "dl_btn_return_focused.png");
    cB = new ca("DL_DIALOG_LINE_BG", 183, "dl_dialog_line_bg.png");
    cC = new ca("DL_EMAIL_ICON", 184, "dl_email_icon.png");
    cD = new ca("DL_FAST_BTN_DEFAULT", 185, "dl_fast_btn_default.9.png");
    cE = new ca("DL_FAST_BTN_SELECTED", 186, "dl_fast_btn_selected.9.png");
    cF = new ca("DL_INFO_ICON", 187, "dl_info_icon.png");
    cG = new ca("DL_INPUT_DEFAULT", 188, "dl_input_default.9.png");
    cH = new ca("DL_INPUT_SELECTED", 189, "dl_input_selected.9.png");
    cI = new ca("DL_LOCK_ICON", 190, "dl_lock_icon.png");
    cJ = new ca("DL_LOGIN_BTN_DEFAULT", 191, "dl_login_btn_default.9.png");
    cK = new ca("DL_LOGIN_BTN_SELECTED", 192, "dl_login_btn_selected.9.png");
    cL = new ca("DL_LOGIN_OBSERVE_BTN_NORMAL", 193, "dl_login_observe_btn_normal.png");
    cM = new ca("DL_LOGIN_DISOBSERVE_BTN_NORMAL", 194, "dl_login_disobserve_btn_nromal.png");
    cN = new ca("DL_LOGO", 195, "logo.png");
    cO = new ca("DL_REG_BTN_DEFAULT", 196, "dl_reg_btn_default.9.png");
    cP = new ca("DL_REG_BTN_SELECTED", 197, "dl_reg_btn_selected.9.png");
    cQ = new ca("DL_SELECT_DEFAULT", 198, "dl_select_default.png");
    cR = new ca("DL_TC_BG", 199, "dl_tc_bg.9.png");
    cS = new ca("DL_TEL_ICON", 200, "dl_tel_icon.png");
    cT = new ca("DL_USER_ICON", 201, "dl_user_icon.png");
    cU = new ca("DL_Y_LOGIN_BTN_DEFAULT", 202, "dl_y_login_btn_default.9.png");
    cV = new ca("DL_Y_LOGIN_BTN_SELECTED", 203, "dl_y_login_btn_selected.9.png");
    cW = new ca("DL_YZM_INPUT_LEFT_DEFAULT", 204, "dl_yzm_input_left_default.9.png");
    cX = new ca("DL_YZM_INPUT_LEFT_SELECTED", 205, "dl_yzm_input_left_selected.9.png");
    cY = new ca("DL_SAFE_GUIDE_BTN_CLOSE_NORMAL", 206, "dl_safe_guide_btn_close_normal.png");
    cZ = new ca("DL_SAFE_GUIDE_BTN_CLOSE_PRESSED", 207, "dl_safe_guide_btn_close_pressed.png");
    da = new ca("DL_DEL_DEFAULT", 208, "dl_del_default.png");
    db = new ca("DL_REALNAME_BTN_NORMAL", 209, "dl_realname_btn_normal.png");
    dc = new ca("DL_REALNAME_BTN_PRESSED", 210, "dl_realname_btn_pressed.png");
    dd = new ca("DL_CLOSE_BTN_NORMAL", 211, "dl_close_btn_normal.png");
    de = new ca("DL_CLOSE_BTN_PRESSED", 212, "dl_close_btn_pressed.png");
    df = new ca("PUBLIC_LOGO", 213, "public_logo.png");
    dg = new ca("MORE_PAY", 214, "more_pay.png");
    dh = new ca("RETRACT_PAY", 215, "retract_pay.png");
    dl = new ca[] { 
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
        bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, 
        bU, bV, bW, bX, bY, bZ, ca, cb, cc, cd, 
        ce, cf, cg, ch, ci, cj, ck, cl, cm, cn, 
        co, cp, cq, cr, cs, ct, cu, cv, cw, cx, 
        cy, cz, cA, cB, cC, cD, cE, cF, cG, cH, 
        cI, cJ, cK, cL, cM, cN, cO, cP, cQ, cR, 
        cS, cT, cU, cV, cW, cX, cY, cZ, da, db, 
        dc, dd, de, df, dg, dh };
  }
  
  ca(String paramString1) {
    this.di = paramString1;
  }
  
  public static StateListDrawable a(Context paramContext, ca paramca1, ca paramca2) {
    return a(paramContext, paramca1, paramca2, null);
  }
  
  public static StateListDrawable a(Context paramContext, ca paramca1, ca paramca2, ca paramca3) {
    Drawable drawable1;
    Drawable drawable2;
    ca ca1 = null;
    if (paramca1 == null) {
      paramca1 = null;
    } else {
      drawable1 = paramca1.a(paramContext);
    } 
    if (paramca2 == null) {
      paramca2 = null;
    } else {
      drawable2 = paramca2.a(paramContext);
    } 
    if (paramca3 == null) {
      paramca3 = ca1;
      return d.a(paramContext, drawable2, drawable1, (Drawable)paramca3);
    } 
    Drawable drawable3 = paramca3.a(paramContext);
    return d.a(paramContext, drawable2, drawable1, drawable3);
  }
  
  public static ca a(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 0:
        return T;
      case 5:
        return P;
      case 2:
        return M;
      case 1:
        return R;
      case 15:
      case 81:
        return Y;
      case 100:
        return V;
      case 3:
        return O;
      case 4:
        return Q;
      case 6:
        return N;
      case 7:
        return U;
      case 9:
        return W;
      case 10:
        return X;
      case 78:
        return Z;
      case 79:
        return aa;
      case 101:
        return ad;
      case 17:
        return ae;
      case 80:
        break;
    } 
    return af;
  }
  
  private String a() {
    return this.di;
  }
  
  public static StateListDrawable b(Context paramContext, ca paramca1, ca paramca2) {
    Drawable drawable1;
    ca ca1 = null;
    if (paramca1 == null) {
      paramca1 = null;
    } else {
      drawable1 = paramca1.a(paramContext);
    } 
    if (paramca2 == null) {
      paramca2 = ca1;
      return d.a(paramContext, (Drawable)paramca2, drawable1);
    } 
    Drawable drawable2 = paramca2.a(paramContext);
    return d.a(paramContext, drawable2, drawable1);
  }
  
  public Drawable a(Context paramContext) {
    String str = "zz_res/drawable" + File.separator + this.di;
    return (Drawable)(this.di.endsWith(".9.png") ? d.c(paramContext, str) : d.b(paramContext, str));
  }
  
  public Bitmap b(Context paramContext) {
    return d.a(paramContext, "zz_res/drawable" + File.separator + this.di);
  }
  
  public String toString() {
    return this.di;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
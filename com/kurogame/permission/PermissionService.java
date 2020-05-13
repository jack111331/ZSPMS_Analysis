package com.kurogame.permission;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PermissionService extends Fragment {
  private static final int HARU_PERMISSION_REQUEST_CODE = 19332;
  
  private static final String HARU_TAG = "HaruPermission";
  
  private static Map<PermissionEnum, String> ReasonMap = new HashMap<PermissionEnum, String>();
  
  private static String UnityCallbackMethod;
  
  private static String UnityGameObject;
  
  private void ShowDialog(String paramString) {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)getActivity());
    builder.setTitle("权限申请");
    builder.setMessage(paramString);
    builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", PermissionService.this.getActivity().getPackageName(), null));
            PermissionService.this.startActivityForResult(intent, 19332);
          }
        });
    builder.setNegativeButton("取消", null);
    builder.show();
  }
  
  private PermissionEnum getPermissionEnum(String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 2133799037:
        if (paramString.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
          b = 16;
          break;
        } 
      case 1977429404:
        if (paramString.equals("android.permission.READ_CONTACTS")) {
          b = 6;
          break;
        } 
      case 1831139720:
        if (paramString.equals("android.permission.RECORD_AUDIO")) {
          b = 11;
          break;
        } 
      case 1365911975:
        if (paramString.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
          b = 25;
          break;
        } 
      case 1271781903:
        if (paramString.equals("android.permission.GET_ACCOUNTS")) {
          b = 8;
          break;
        } 
      case 952819282:
        if (paramString.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
          b = 4;
          break;
        } 
      case 784519842:
        if (paramString.equals("android.permission.USE_SIP")) {
          b = 17;
          break;
        } 
      case 610633091:
        if (paramString.equals("android.permission.WRITE_CALL_LOG")) {
          b = 3;
          break;
        } 
      case 603653886:
        if (paramString.equals("android.permission.WRITE_CALENDAR")) {
          b = 1;
          break;
        } 
      case 463403621:
        if (paramString.equals("android.permission.CAMERA")) {
          b = 5;
          break;
        } 
      case 214526995:
        if (paramString.equals("android.permission.WRITE_CONTACTS")) {
          b = 7;
          break;
        } 
      case 112197485:
        if (paramString.equals("android.permission.CALL_PHONE")) {
          b = 14;
          break;
        } 
      case 52602690:
        if (paramString.equals("android.permission.SEND_SMS")) {
          b = 19;
          break;
        } 
      case -5573545:
        if (paramString.equals("android.permission.READ_PHONE_STATE")) {
          b = 12;
          break;
        } 
      case -63024214:
        if (paramString.equals("android.permission.ACCESS_COARSE_LOCATION")) {
          b = 10;
          break;
        } 
      case -406040016:
        if (paramString.equals("android.permission.READ_EXTERNAL_STORAGE")) {
          b = 24;
          break;
        } 
      case -895673731:
        if (paramString.equals("android.permission.RECEIVE_SMS")) {
          b = 20;
          break;
        } 
      case -895679497:
        if (paramString.equals("android.permission.RECEIVE_MMS")) {
          b = 23;
          break;
        } 
      case -1164582768:
        if (paramString.equals("android.permission.READ_PHONE_NUMBERS")) {
          b = 13;
          break;
        } 
      case -1238066820:
        if (paramString.equals("android.permission.BODY_SENSORS")) {
          b = 18;
          break;
        } 
      case -1479758289:
        if (paramString.equals("android.permission.RECEIVE_WAP_PUSH")) {
          b = 22;
          break;
        } 
      case -1674700861:
        if (paramString.equals("android.permission.ANSWER_PHONE_CALLS")) {
          b = 15;
          break;
        } 
      case -1888586689:
        if (paramString.equals("android.permission.ACCESS_FINE_LOCATION")) {
          b = 9;
          break;
        } 
      case -1921431796:
        if (paramString.equals("android.permission.READ_CALL_LOG")) {
          b = 2;
          break;
        } 
      case -1928411001:
        if (paramString.equals("android.permission.READ_CALENDAR")) {
          b = 0;
          break;
        } 
      case -2062386608:
        if (paramString.equals("android.permission.READ_SMS")) {
          b = 21;
          break;
        } 
    } 
    switch (b) {
      default:
        return PermissionEnum.UNKNOWN;
      case 25:
        return PermissionEnum.WRITE_EXTERNAL_STORAGE;
      case 24:
        return PermissionEnum.READ_EXTERNAL_STORAGE;
      case 23:
        return PermissionEnum.RECEIVE_MMS;
      case 22:
        return PermissionEnum.RECEIVE_WAP_PUSH;
      case 21:
        return PermissionEnum.READ_SMS;
      case 20:
        return PermissionEnum.RECEIVE_SMS;
      case 18:
        if (Build.VERSION.SDK_INT >= 20)
          return PermissionEnum.BODY_SENSORS; 
      case 19:
        return PermissionEnum.SEND_SMS;
      case 17:
        return PermissionEnum.USE_SIP;
      case 15:
        if (Build.VERSION.SDK_INT >= 26)
          return PermissionEnum.ANSWER_PHONE_CALLS; 
      case 16:
        return PermissionEnum.ADD_VOICEMAIL;
      case 13:
        if (Build.VERSION.SDK_INT >= 26)
          return PermissionEnum.READ_PHONE_NUMBERS; 
      case 14:
        return PermissionEnum.CALL_PHONE;
      case 12:
        return PermissionEnum.READ_PHONE_STATE;
      case 11:
        return PermissionEnum.RECORD_AUDIO;
      case 10:
        return PermissionEnum.ACCESS_COARSE_LOCATION;
      case 9:
        return PermissionEnum.ACCESS_FINE_LOCATION;
      case 8:
        return PermissionEnum.GET_ACCOUNTS;
      case 7:
        return PermissionEnum.WRITE_CONTACTS;
      case 6:
        return PermissionEnum.READ_CONTACTS;
      case 5:
        return PermissionEnum.CAMERA;
      case 4:
        return PermissionEnum.PROCESS_OUTGOING_CALLS;
      case 3:
        return PermissionEnum.WRITE_CALL_LOG;
      case 2:
        return PermissionEnum.READ_CALL_LOG;
      case 1:
        return PermissionEnum.WRITE_CALENDAR;
      case 0:
        break;
    } 
    return PermissionEnum.READ_CALENDAR;
  }
  
  private static String getPermissionString(int paramInt) {
    PermissionEnum permissionEnum = PermissionEnum.values()[paramInt];
    switch (permissionEnum) {
      default:
        return null;
      case WRITE_EXTERNAL_STORAGE:
        return "android.permission.WRITE_EXTERNAL_STORAGE";
      case READ_EXTERNAL_STORAGE:
        return "android.permission.READ_EXTERNAL_STORAGE";
      case RECEIVE_MMS:
        return "android.permission.RECEIVE_MMS";
      case RECEIVE_WAP_PUSH:
        return "android.permission.RECEIVE_WAP_PUSH";
      case READ_SMS:
        return "android.permission.READ_SMS";
      case RECEIVE_SMS:
        return "android.permission.RECEIVE_SMS";
      case BODY_SENSORS:
        if (Build.VERSION.SDK_INT >= 20)
          return "android.permission.BODY_SENSORS"; 
      case SEND_SMS:
        return "android.permission.SEND_SMS";
      case USE_SIP:
        return "android.permission.USE_SIP";
      case ANSWER_PHONE_CALLS:
        if (Build.VERSION.SDK_INT >= 26)
          return "android.permission.ANSWER_PHONE_CALLS"; 
      case ADD_VOICEMAIL:
        return "com.android.voicemail.permission.ADD_VOICEMAIL";
      case READ_PHONE_NUMBERS:
        if (Build.VERSION.SDK_INT >= 26)
          return "android.permission.READ_PHONE_NUMBERS"; 
      case CALL_PHONE:
        return "android.permission.CALL_PHONE";
      case READ_PHONE_STATE:
        return "android.permission.READ_PHONE_STATE";
      case RECORD_AUDIO:
        return "android.permission.RECORD_AUDIO";
      case ACCESS_COARSE_LOCATION:
        return "android.permission.ACCESS_COARSE_LOCATION";
      case ACCESS_FINE_LOCATION:
        return "android.permission.ACCESS_FINE_LOCATION";
      case GET_ACCOUNTS:
        return "android.permission.GET_ACCOUNTS";
      case WRITE_CONTACTS:
        return "android.permission.WRITE_CONTACTS";
      case READ_CONTACTS:
        return "android.permission.READ_CONTACTS";
      case CAMERA:
        return "android.permission.CAMERA";
      case PROCESS_OUTGOING_CALLS:
        return "android.permission.PROCESS_OUTGOING_CALLS";
      case WRITE_CALL_LOG:
        return "android.permission.WRITE_CALL_LOG";
      case READ_CALL_LOG:
        return "android.permission.READ_CALL_LOG";
      case WRITE_CALENDAR:
        return "android.permission.WRITE_CALENDAR";
      case READ_CALENDAR:
        break;
    } 
    return "android.permission.READ_CALENDAR";
  }
  
  public static void init(final PermissionService fragment, String paramString1, String paramString2) {
    UnityGameObject = paramString1;
    UnityCallbackMethod = paramString2;
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            UnityPlayer.currentActivity.getFragmentManager().beginTransaction().add(fragment, PermissionService.class.getCanonicalName()).commit();
          }
        });
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfint) {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    if (paramInt != 19332)
      return; 
    for (paramInt = 0; paramInt < paramArrayOfint.length; paramInt++) {
      boolean bool = ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), paramArrayOfString[paramInt]);
      if (paramArrayOfint[paramInt] != 0) {
        if (bool) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramArrayOfString[paramInt]);
          stringBuilder.append("权限，没有彻底禁止弹出权限请求");
          Log.d("HaruPermission", stringBuilder.toString());
          JSONObject jSONObject = new JSONObject();
          try {
            jSONObject.put("PermissionType", getPermissionEnum(paramArrayOfString[paramInt]).ordinal());
            jSONObject.put("IsSuccess", false);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
          } 
          UnityPlayer.UnitySendMessage(UnityGameObject, UnityCallbackMethod, jSONObject.toString());
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramArrayOfString[paramInt]);
          stringBuilder.append("权限，彻底禁止弹出权限请求，提示去设置开启");
          Log.d("HaruPermission", stringBuilder.toString());
          ShowDialog(ReasonMap.get(getPermissionEnum(paramArrayOfString[paramInt])));
          JSONObject jSONObject = new JSONObject();
          try {
            jSONObject.put("PermissionType", getPermissionEnum(paramArrayOfString[paramInt]).ordinal());
            jSONObject.put("IsSuccess", false);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
          } 
          UnityPlayer.UnitySendMessage(UnityGameObject, UnityCallbackMethod, jSONObject.toString());
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramArrayOfString[paramInt]);
        stringBuilder.append("权限申请成功");
        Log.d("HaruPermission", stringBuilder.toString());
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("PermissionType", getPermissionEnum(paramArrayOfString[paramInt]).ordinal());
          jSONObject.put("IsSuccess", true);
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        UnityPlayer.UnitySendMessage(UnityGameObject, UnityCallbackMethod, jSONObject.toString());
      } 
    } 
  }
  
  public boolean requestPermission(int paramInt, String paramString) {
    JSONObject jSONObject;
    String str = getPermissionString(paramInt);
    if (str == null || str.isEmpty()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("为未知类型权限！");
      Log.w("HaruPermission", stringBuilder1.toString());
      jSONObject = new JSONObject();
      try {
        jSONObject.put("PermissionType", paramInt);
        jSONObject.put("IsSuccess", false);
        jSONObject.put("Msg", "unknown");
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      UnityPlayer.UnitySendMessage(UnityGameObject, UnityCallbackMethod, jSONObject.toString());
      return false;
    } 
    ReasonMap.put(PermissionEnum.values()[paramInt], jSONObject);
    if (ActivityCompat.checkSelfPermission((Context)UnityPlayer.currentActivity, (String)jSONException) != 0) {
      if (Build.VERSION.SDK_INT >= 23)
        requestPermissions(new String[] { (String)jSONException }, 19332); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((String)jSONException);
      stringBuilder1.append("权限未开启");
      Log.d("HaruPermission", stringBuilder1.toString());
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((String)jSONException);
    stringBuilder.append("权限已开启");
    Log.d("HaruPermission", stringBuilder.toString());
    return true;
  }
  
  enum PermissionEnum {
    ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION, ADD_VOICEMAIL, ANSWER_PHONE_CALLS, BODY_SENSORS, CALL_PHONE, CAMERA, GET_ACCOUNTS, PROCESS_OUTGOING_CALLS, READ_CALENDAR, READ_CALL_LOG, READ_CONTACTS, READ_EXTERNAL_STORAGE, READ_PHONE_NUMBERS, READ_PHONE_STATE, READ_SMS, RECEIVE_MMS, RECEIVE_SMS, RECEIVE_WAP_PUSH, RECORD_AUDIO, SEND_SMS, UNKNOWN, USE_SIP, WRITE_CALENDAR, WRITE_CALL_LOG, WRITE_CONTACTS, WRITE_EXTERNAL_STORAGE;
    
    static {
      READ_CALL_LOG = new PermissionEnum("READ_CALL_LOG", 3);
      WRITE_CALL_LOG = new PermissionEnum("WRITE_CALL_LOG", 4);
      PROCESS_OUTGOING_CALLS = new PermissionEnum("PROCESS_OUTGOING_CALLS", 5);
      CAMERA = new PermissionEnum("CAMERA", 6);
      READ_CONTACTS = new PermissionEnum("READ_CONTACTS", 7);
      WRITE_CONTACTS = new PermissionEnum("WRITE_CONTACTS", 8);
      GET_ACCOUNTS = new PermissionEnum("GET_ACCOUNTS", 9);
      ACCESS_FINE_LOCATION = new PermissionEnum("ACCESS_FINE_LOCATION", 10);
      ACCESS_COARSE_LOCATION = new PermissionEnum("ACCESS_COARSE_LOCATION", 11);
      RECORD_AUDIO = new PermissionEnum("RECORD_AUDIO", 12);
      READ_PHONE_STATE = new PermissionEnum("READ_PHONE_STATE", 13);
      READ_PHONE_NUMBERS = new PermissionEnum("READ_PHONE_NUMBERS", 14);
      CALL_PHONE = new PermissionEnum("CALL_PHONE", 15);
      ANSWER_PHONE_CALLS = new PermissionEnum("ANSWER_PHONE_CALLS", 16);
      ADD_VOICEMAIL = new PermissionEnum("ADD_VOICEMAIL", 17);
      USE_SIP = new PermissionEnum("USE_SIP", 18);
      BODY_SENSORS = new PermissionEnum("BODY_SENSORS", 19);
      SEND_SMS = new PermissionEnum("SEND_SMS", 20);
      RECEIVE_SMS = new PermissionEnum("RECEIVE_SMS", 21);
      READ_SMS = new PermissionEnum("READ_SMS", 22);
      RECEIVE_WAP_PUSH = new PermissionEnum("RECEIVE_WAP_PUSH", 23);
      RECEIVE_MMS = new PermissionEnum("RECEIVE_MMS", 24);
      READ_EXTERNAL_STORAGE = new PermissionEnum("READ_EXTERNAL_STORAGE", 25);
      WRITE_EXTERNAL_STORAGE = new PermissionEnum("WRITE_EXTERNAL_STORAGE", 26);
      $VALUES = new PermissionEnum[] { 
          UNKNOWN, READ_CALENDAR, WRITE_CALENDAR, READ_CALL_LOG, WRITE_CALL_LOG, PROCESS_OUTGOING_CALLS, CAMERA, READ_CONTACTS, WRITE_CONTACTS, GET_ACCOUNTS, 
          ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, RECORD_AUDIO, READ_PHONE_STATE, READ_PHONE_NUMBERS, CALL_PHONE, ANSWER_PHONE_CALLS, ADD_VOICEMAIL, USE_SIP, BODY_SENSORS, 
          SEND_SMS, RECEIVE_SMS, READ_SMS, RECEIVE_WAP_PUSH, RECEIVE_MMS, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\permission\PermissionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
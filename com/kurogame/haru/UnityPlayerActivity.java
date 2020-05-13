package com.kurogame.haru;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.unity3d.player.UnityPlayer;

public class UnityPlayerActivity extends Activity {
  protected UnityPlayer mUnityPlayer;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (paramKeyEvent.getAction() == 2) ? this.mUnityPlayer.injectEvent((InputEvent)paramKeyEvent) : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.mUnityPlayer.configurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    String str = updateUnityCommandLineArguments(getIntent().getStringExtra("unity"));
    getIntent().putExtra("unity", str);
    this.mUnityPlayer = new UnityPlayer((Context)this);
    setContentView((View)this.mUnityPlayer);
    this.mUnityPlayer.requestFocus();
  }
  
  protected void onDestroy() {
    this.mUnityPlayer.destroy();
    super.onDestroy();
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return this.mUnityPlayer.injectEvent((InputEvent)paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return this.mUnityPlayer.injectEvent((InputEvent)paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return this.mUnityPlayer.injectEvent((InputEvent)paramKeyEvent);
  }
  
  public void onLowMemory() {
    super.onLowMemory();
    this.mUnityPlayer.lowMemory();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    setIntent(paramIntent);
  }
  
  protected void onPause() {
    super.onPause();
    this.mUnityPlayer.pause();
  }
  
  protected void onResume() {
    super.onResume();
    this.mUnityPlayer.resume();
  }
  
  protected void onStart() {
    super.onStart();
    this.mUnityPlayer.start();
  }
  
  protected void onStop() {
    super.onStop();
    this.mUnityPlayer.stop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.mUnityPlayer.injectEvent((InputEvent)paramMotionEvent);
  }
  
  public void onTrimMemory(int paramInt) {
    super.onTrimMemory(paramInt);
    if (paramInt == 15)
      this.mUnityPlayer.lowMemory(); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    this.mUnityPlayer.windowFocusChanged(paramBoolean);
  }
  
  protected String updateUnityCommandLineArguments(String paramString) {
    return paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\haru\UnityPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
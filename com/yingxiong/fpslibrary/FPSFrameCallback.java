package com.yingxiong.fpslibrary;

import android.view.Choreographer;
import java.util.ArrayList;
import java.util.List;

public class FPSFrameCallback implements Choreographer.FrameCallback {
  private List<Long> dataSet;
  
  private boolean enabled = true;
  
  private FPSConfig fpsConfig;
  
  private long startSampleTimeInNs = 0L;
  
  private TinyCoach tinyCoach;
  
  public FPSFrameCallback(FPSConfig paramFPSConfig, TinyCoach paramTinyCoach) {
    this.fpsConfig = paramFPSConfig;
    this.tinyCoach = paramTinyCoach;
    this.dataSet = new ArrayList<Long>();
  }
  
  private void collectSampleAndSend(long paramLong) {
    ArrayList<Long> arrayList = new ArrayList();
    arrayList.addAll(this.dataSet);
    this.tinyCoach.showData(this.fpsConfig, arrayList);
    this.dataSet.clear();
    this.startSampleTimeInNs = paramLong;
  }
  
  private void destroy() {
    this.dataSet.clear();
    this.fpsConfig = null;
    this.tinyCoach = null;
  }
  
  private boolean isFinishedWithSample(long paramLong) {
    boolean bool;
    if (paramLong - this.startSampleTimeInNs > this.fpsConfig.getSampleTimeInNs()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void doFrame(long paramLong) {
    if (!this.enabled) {
      destroy();
      return;
    } 
    if (this.startSampleTimeInNs == 0L) {
      this.startSampleTimeInNs = paramLong;
    } else if (this.fpsConfig.frameDataCallback != null) {
      long l = ((Long)this.dataSet.get(this.dataSet.size() - 1)).longValue();
      int i = Calculation.droppedCount(l, paramLong, this.fpsConfig.deviceRefreshRateInMs);
      this.fpsConfig.frameDataCallback.doFrame(l, paramLong, i);
    } 
    if (isFinishedWithSample(paramLong))
      collectSampleAndSend(paramLong); 
    this.dataSet.add(Long.valueOf(paramLong));
    Choreographer.getInstance().postFrameCallback(this);
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.enabled = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\fpslibrary\FPSFrameCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
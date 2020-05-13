package com.yingxiong.fpslibrary;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class FPSConfig implements Serializable {
  public static int DEFAULT_GRAVITY = 8388659;
  
  public float deviceRefreshRateInMs = 16.6F;
  
  public FrameDataCallback frameDataCallback = null;
  
  public boolean gravitySpecified = false;
  
  public float redFlagPercentage = 0.2F;
  
  public float refreshRate = 60.0F;
  
  public final long sampleTimeInMs = 1000L;
  
  public int startingGravity = DEFAULT_GRAVITY;
  
  public int startingXPosition = 200;
  
  public int startingYPosition = 600;
  
  public boolean xOrYSpecified = false;
  
  public float yellowFlagPercentage = 0.05F;
  
  public long getSampleTimeInNs() {
    return TimeUnit.NANOSECONDS.convert(1000L, TimeUnit.MILLISECONDS);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\fpslibrary\FPSConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
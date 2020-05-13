package com.yingxiong.fpslibrary;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calculation {
  public static AbstractMap.SimpleEntry<Metric, Long> calculateMetric(FPSConfig paramFPSConfig, List<Long> paramList, List<Integer> paramList1) {
    long l = ((Long)paramList.get(paramList.size() - 1)).longValue();
    int i = 0;
    l = getNumberOfFramesInSet(l - ((Long)paramList.get(0)).longValue(), paramFPSConfig);
    Iterator<Integer> iterator = paramList1.iterator();
    int j = 0;
    while (iterator.hasNext()) {
      Integer integer = iterator.next();
      int k = i + integer.intValue();
      i = k;
      if (integer.intValue() >= 2) {
        j += integer.intValue();
        i = k;
      } 
    } 
    float f1 = paramFPSConfig.refreshRate;
    float f2 = (float)l;
    l = Math.round(f1 / f2 * (float)(l - i));
    f2 = j / f2;
    Metric metric = Metric.GOOD;
    if (f2 >= paramFPSConfig.redFlagPercentage) {
      metric = Metric.BAD;
    } else if (f2 >= paramFPSConfig.yellowFlagPercentage) {
      metric = Metric.MEDIUM;
    } 
    return new AbstractMap.SimpleEntry<Metric, Long>(metric, Long.valueOf(l));
  }
  
  public static int droppedCount(long paramLong1, long paramLong2, float paramFloat) {
    boolean bool;
    paramLong2 = TimeUnit.MILLISECONDS.convert(paramLong2 - paramLong1, TimeUnit.NANOSECONDS);
    paramLong1 = Math.round(paramFloat);
    if (paramLong2 > paramLong1) {
      bool = (int)(paramLong2 / paramLong1);
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static List<Integer> getDroppedSet(FPSConfig paramFPSConfig, List<Long> paramList) {
    ArrayList<Integer> arrayList = new ArrayList();
    Iterator<Long> iterator = paramList.iterator();
    for (long l = -1L; iterator.hasNext(); l = long_.longValue()) {
      Long long_ = iterator.next();
      if (l == -1L) {
        l = long_.longValue();
        continue;
      } 
      int i = droppedCount(l, long_.longValue(), paramFPSConfig.deviceRefreshRateInMs);
      if (i > 0)
        arrayList.add(Integer.valueOf(i)); 
    } 
    return arrayList;
  }
  
  protected static long getNumberOfFramesInSet(long paramLong, FPSConfig paramFPSConfig) {
    return Math.round((float)TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) / paramFPSConfig.deviceRefreshRateInMs);
  }
  
  public enum Metric {
    BAD, GOOD, MEDIUM;
    
    static {
      $VALUES = new Metric[] { GOOD, BAD, MEDIUM };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\fpslibrary\Calculation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
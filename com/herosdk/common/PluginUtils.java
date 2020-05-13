package com.herosdk.common;

import android.content.Context;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IPluginListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PluginUtils {
  private static PluginUtils a = null;
  
  private List<String> b = new ArrayList<String>();
  
  private HashMap<PluginNode, ArrayList<IPluginListener>> c = new HashMap<PluginNode, ArrayList<IPluginListener>>();
  
  private void a() {
    for (byte b = 0; b < this.b.size(); b++) {
      String str = this.b.get(b);
      try {
        Class<?> clazz = Class.forName(str);
        Object object = clazz.newInstance();
        clazz.getDeclaredMethod("registerPlugins", new Class[] { PluginUtils.class }).invoke(object, new Object[] { getInstance() });
      } catch (ClassNotFoundException classNotFoundException) {
        Log.d("frameLib", "registerPlugins...class " + str + " not found");
      } catch (InstantiationException instantiationException) {
        Log.d("frameLib", "registerPlugins...InstantiationException");
      } catch (IllegalAccessException illegalAccessException) {
        Log.d("frameLib", "registerPlugins...IllegalAccessException");
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.d("frameLib", "registerPlugins...NoSuchMethodException");
      } catch (InvocationTargetException invocationTargetException) {
        Log.d("frameLib", "registerPlugins...InvocationTargetException");
      } 
    } 
  }
  
  private void a(Context paramContext) {
    try {
      for (String str : paramContext.getAssets().list("")) {
        if (str.startsWith("com.hu.plugin"))
          this.b.add(str); 
      } 
      if (this.b.isEmpty() && HeroSdk.getInstance().getChannelId() == 0)
        this.b.add("com.hu.plugin.bloc.PluginManager"); 
    } catch (IOException iOException) {
      this.b = new ArrayList<String>();
      ErrorUtils.printExceptionInfo(iOException);
    } 
  }
  
  public static PluginUtils getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/common/PluginUtils.a : Lcom/herosdk/common/PluginUtils;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/common/PluginUtils
    //   8: monitorenter
    //   9: getstatic com/herosdk/common/PluginUtils.a : Lcom/herosdk/common/PluginUtils;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/common/PluginUtils
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/common/PluginUtils.a : Lcom/herosdk/common/PluginUtils;
    //   27: ldc com/herosdk/common/PluginUtils
    //   29: monitorexit
    //   30: getstatic com/herosdk/common/PluginUtils.a : Lcom/herosdk/common/PluginUtils;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/common/PluginUtils
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void addPlugin(PluginNode paramPluginNode, IPluginListener paramIPluginListener) {
    try {
      if (!this.c.containsKey(paramPluginNode)) {
        HashMap<PluginNode, ArrayList<IPluginListener>> hashMap = this.c;
        ArrayList<IPluginListener> arrayList = new ArrayList();
        this();
        hashMap.put(paramPluginNode, arrayList);
      } 
      ((ArrayList<IPluginListener>)this.c.get(paramPluginNode)).add(paramIPluginListener);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public List<String> getPluginList() {
    return this.b;
  }
  
  public void initPlugin(Context paramContext) {
    if (paramContext != null) {
      a(paramContext);
      a();
    } 
  }
  
  public void invokePlugin(PluginNode paramPluginNode, Object... paramVarArgs) {
    try {
      ArrayList arrayList = this.c.get(paramPluginNode);
      if (arrayList != null && arrayList.size() > 0) {
        Iterator<IPluginListener> iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((IPluginListener)iterator.next()).invokePlugin(paramVarArgs); 
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\common\PluginUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
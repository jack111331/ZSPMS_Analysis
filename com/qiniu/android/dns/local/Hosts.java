package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.NetworkInfo;
import java.util.ArrayList;
import java.util.Hashtable;

public final class Hosts {
  private final Hashtable<String, ArrayList<Value>> hosts = new Hashtable<String, ArrayList<Value>>();
  
  private ArrayList<Value> filter(ArrayList<Value> paramArrayList, NetworkInfo paramNetworkInfo) {
    ArrayList<Value> arrayList1 = new ArrayList();
    ArrayList<Value> arrayList2 = new ArrayList();
    for (Value value : paramArrayList) {
      if (value.provider == 0)
        arrayList1.add(value); 
      if (paramNetworkInfo.provider != 0 && value.provider == paramNetworkInfo.provider)
        arrayList2.add(value); 
    } 
    return (arrayList2.size() != 0) ? arrayList2 : arrayList1;
  }
  
  public Hosts put(String paramString, Value paramValue) {
    ArrayList<Value> arrayList1 = this.hosts.get(paramString);
    ArrayList<Value> arrayList2 = arrayList1;
    if (arrayList1 == null)
      arrayList2 = new ArrayList(); 
    arrayList2.add(paramValue);
    this.hosts.put(paramString, arrayList2);
    return this;
  }
  
  public Hosts put(String paramString1, String paramString2) {
    put(paramString1, new Value(paramString2));
    return this;
  }
  
  public String[] query(Domain paramDomain, NetworkInfo paramNetworkInfo) {
    ArrayList<Value> arrayList = this.hosts.get(paramDomain.domain);
    if (arrayList == null || arrayList.isEmpty())
      return null; 
    if (arrayList.size() > 1) {
      Value value = arrayList.get(0);
      arrayList.remove(0);
      arrayList.add(value);
    } 
    return toIps(filter(arrayList, paramNetworkInfo));
  }
  
  public String[] toIps(ArrayList<Value> paramArrayList) {
    int i = paramArrayList.size();
    String[] arrayOfString = new String[i];
    for (byte b = 0; b < i; b++)
      arrayOfString[b] = ((Value)paramArrayList.get(b)).ip; 
    return arrayOfString;
  }
  
  public static class Value {
    public final String ip;
    
    public final int provider;
    
    public Value(String param1String) {
      this(param1String, 0);
    }
    
    public Value(String param1String, int param1Int) {
      this.ip = param1String;
      this.provider = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = true;
      if (this == param1Object)
        return true; 
      if (param1Object == null || !(param1Object instanceof Value))
        return false; 
      param1Object = param1Object;
      if (!this.ip.equals(((Value)param1Object).ip) || this.provider != ((Value)param1Object).provider)
        bool = false; 
      return bool;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\local\Hosts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
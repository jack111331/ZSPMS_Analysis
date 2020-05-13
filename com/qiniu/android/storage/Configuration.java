package com.qiniu.android.storage;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.common.Zone;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.local.AndroidDnsServer;
import com.qiniu.android.dns.local.Resolver;
import com.qiniu.android.http.Dns;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.UrlConverter;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Configuration {
  public static final int BLOCK_SIZE = 4194304;
  
  public final int chunkSize;
  
  public final int connectTimeout;
  
  public Dns dns;
  
  public final KeyGenerator keyGen;
  
  public final ProxyConfiguration proxy;
  
  public final int putThreshold;
  
  public final Recorder recorder;
  
  public final int responseTimeout;
  
  public final int retryMax;
  
  public UrlConverter urlConverter;
  
  public boolean useHttps;
  
  public Zone zone;
  
  private Configuration(Builder paramBuilder) {
    Zone zone;
    this.useHttps = paramBuilder.useHttps;
    this.chunkSize = paramBuilder.chunkSize;
    this.putThreshold = paramBuilder.putThreshold;
    this.connectTimeout = paramBuilder.connectTimeout;
    this.responseTimeout = paramBuilder.responseTimeout;
    this.recorder = paramBuilder.recorder;
    this.keyGen = getKeyGen(paramBuilder.keyGen);
    this.retryMax = paramBuilder.retryMax;
    this.proxy = paramBuilder.proxy;
    this.urlConverter = paramBuilder.urlConverter;
    if (paramBuilder.zone == null) {
      AutoZone autoZone = AutoZone.autoZone;
    } else {
      zone = paramBuilder.zone;
    } 
    this.zone = zone;
    this.dns = paramBuilder.dns;
  }
  
  private KeyGenerator getKeyGen(KeyGenerator paramKeyGenerator) {
    KeyGenerator keyGenerator = paramKeyGenerator;
    if (paramKeyGenerator == null)
      keyGenerator = new KeyGenerator() {
          public String gen(String param1String, File param1File) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1String);
            stringBuilder.append("_._");
            stringBuilder.append((new StringBuffer(param1File.getAbsolutePath())).reverse());
            return stringBuilder.toString();
          }
        }; 
    return keyGenerator;
  }
  
  public static class Builder {
    private int chunkSize = 2097152;
    
    private int connectTimeout = 10;
    
    private Dns dns = null;
    
    private KeyGenerator keyGen = null;
    
    private ProxyConfiguration proxy = null;
    
    private int putThreshold = 4194304;
    
    private Recorder recorder = null;
    
    private int responseTimeout = 60;
    
    private int retryMax = 3;
    
    private UrlConverter urlConverter = null;
    
    private boolean useHttps = false;
    
    private Zone zone = null;
    
    public Builder() {
      buildDefaultDns();
    }
    
    private void buildDefaultDns() {
      IResolver iResolver = AndroidDnsServer.defaultResolver();
      try {
        Resolver resolver = new Resolver();
        this(InetAddress.getByName("119.29.29.29"));
      } catch (IOException iOException) {
        iOException.printStackTrace();
        iOException = null;
      } 
      this.dns = new Dns() {
          public List<InetAddress> lookup(String param2String) throws UnknownHostException {
            try {
              ArrayList<? super InetAddress> arrayList;
              DnsManager dnsManager = happlyDns;
              Domain domain = new Domain();
              this(param2String);
              InetAddress[] arrayOfInetAddress = dnsManager.queryInetAdress(domain);
              if (arrayOfInetAddress != null) {
                arrayList = new ArrayList();
                Collections.addAll(arrayList, arrayOfInetAddress);
                return (List)arrayList;
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append((String)arrayList);
              stringBuilder.append(" resolve failed.");
              throw new UnknownHostException(stringBuilder.toString());
            } catch (IOException iOException) {
              iOException.printStackTrace();
              throw new UnknownHostException(iOException.getMessage());
            } 
          }
        };
    }
    
    public Configuration build() {
      return new Configuration(this);
    }
    
    public Builder chunkSize(int param1Int) {
      this.chunkSize = param1Int;
      return this;
    }
    
    public Builder connectTimeout(int param1Int) {
      this.connectTimeout = param1Int;
      return this;
    }
    
    public Builder dns(Dns param1Dns) {
      this.dns = param1Dns;
      return this;
    }
    
    public Builder proxy(ProxyConfiguration param1ProxyConfiguration) {
      this.proxy = param1ProxyConfiguration;
      return this;
    }
    
    public Builder putThreshhold(int param1Int) {
      this.putThreshold = param1Int;
      return this;
    }
    
    public Builder recorder(Recorder param1Recorder) {
      this.recorder = param1Recorder;
      return this;
    }
    
    public Builder recorder(Recorder param1Recorder, KeyGenerator param1KeyGenerator) {
      this.recorder = param1Recorder;
      this.keyGen = param1KeyGenerator;
      return this;
    }
    
    public Builder responseTimeout(int param1Int) {
      this.responseTimeout = param1Int;
      return this;
    }
    
    public Builder retryMax(int param1Int) {
      this.retryMax = param1Int;
      return this;
    }
    
    public Builder urlConverter(UrlConverter param1UrlConverter) {
      this.urlConverter = param1UrlConverter;
      return this;
    }
    
    public Builder useHttps(boolean param1Boolean) {
      this.useHttps = param1Boolean;
      return this;
    }
    
    public Builder zone(Zone param1Zone) {
      this.zone = param1Zone;
      return this;
    }
  }
  
  class null implements Dns {
    public List<InetAddress> lookup(String param1String) throws UnknownHostException {
      try {
        ArrayList<? super InetAddress> arrayList;
        DnsManager dnsManager = happlyDns;
        Domain domain = new Domain();
        this(param1String);
        InetAddress[] arrayOfInetAddress = dnsManager.queryInetAdress(domain);
        if (arrayOfInetAddress != null) {
          arrayList = new ArrayList();
          Collections.addAll(arrayList, arrayOfInetAddress);
          return (List)arrayList;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)arrayList);
        stringBuilder.append(" resolve failed.");
        throw new UnknownHostException(stringBuilder.toString());
      } catch (IOException iOException) {
        iOException.printStackTrace();
        throw new UnknownHostException(iOException.getMessage());
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\storage\Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
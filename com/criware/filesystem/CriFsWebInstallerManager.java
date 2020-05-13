package com.criware.filesystem;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.X509TrustManager;

public class CriFsWebInstallerManager {
  public boolean allow_insecure_ssl;
  
  public boolean crc_enabled;
  
  public int inactive_timeout_sec;
  
  public ConcurrentLinkedQueue<CriFsWebInstaller> installer_list;
  
  public boolean is_initialized;
  
  public int num_installers;
  
  private int num_installers_max;
  
  public String proxy_host = "";
  
  public short proxy_port = (short)-1;
  
  public RequestHeaders request_headers;
  
  public String user_agent;
  
  public CriFsWebInstaller CreateInstaller() {
    if (this.num_installers >= this.num_installers_max) {
      CriFsWebInstaller.ErrorEntry(3);
      return null;
    } 
    CriFsWebInstaller criFsWebInstaller = new CriFsWebInstaller();
    if (this.installer_list.add(criFsWebInstaller))
      this.num_installers++; 
    return criFsWebInstaller;
  }
  
  public void ExecuteMain() {
    Iterator<CriFsWebInstaller> iterator = this.installer_list.iterator();
    while (iterator.hasNext())
      ((CriFsWebInstaller)iterator.next()).Update(); 
  }
  
  public void Manager_Finalize() {
    if (!this.is_initialized)
      return; 
    for (CriFsWebInstaller criFsWebInstaller : this.installer_list) {
      criFsWebInstaller.is_stop_required = true;
      this.installer_list.remove(criFsWebInstaller);
    } 
    this.is_initialized = false;
  }
  
  public void Manager_Initialize(CriFsWebInstaller.Config paramConfig) {
    if (this.is_initialized)
      return; 
    this.num_installers = paramConfig.num_installers;
    this.allow_insecure_ssl = paramConfig.allow_insecure_ssl;
    this.inactive_timeout_sec = paramConfig.inactive_timeout_sec;
    this.proxy_host = paramConfig.proxy_host;
    this.proxy_port = (short)paramConfig.proxy_port;
    this.user_agent = paramConfig.user_agent;
    this.crc_enabled = paramConfig.crc_enabled;
    this.num_installers_max = this.num_installers;
    this.num_installers = 0;
    this.installer_list = new ConcurrentLinkedQueue<CriFsWebInstaller>();
    this.request_headers = new RequestHeaders(paramConfig.max_request_fields);
    this.is_initialized = true;
  }
  
  public static class LooseTrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
    
    public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
    
    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }
  }
  
  public final class RequestHeaders {
    private List<String> fieldAndValues = null;
    
    public RequestHeaders(int param1Int) {
      this.fieldAndValues = new ArrayList<String>(param1Int * 2);
    }
    
    private void add(String param1String1, String param1String2) {
      this.fieldAndValues.add(param1String1);
      this.fieldAndValues.add(param1String2);
    }
    
    private void removeAll(String param1String) {
      for (byte b = 0; b < this.fieldAndValues.size(); b += 2) {
        if (param1String.equalsIgnoreCase(this.fieldAndValues.get(b))) {
          this.fieldAndValues.remove(b);
          this.fieldAndValues.remove(b);
        } 
      } 
    }
    
    public String getFieldName(int param1Int) {
      param1Int *= 2;
      return (param1Int < 0 || param1Int >= this.fieldAndValues.size()) ? null : this.fieldAndValues.get(param1Int);
    }
    
    public String getValue(int param1Int) {
      param1Int = param1Int * 2 + 1;
      return (param1Int < 0 || param1Int >= this.fieldAndValues.size()) ? null : this.fieldAndValues.get(param1Int);
    }
    
    public int length() {
      return this.fieldAndValues.size() / 2;
    }
    
    public void set(String param1String1, String param1String2) {
      removeAll(param1String1);
      if (param1String2 != null)
        add(param1String1, param1String2); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\criware\filesystem\CriFsWebInstallerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
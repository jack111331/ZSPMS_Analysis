package com.jdpaysdk.author.protocol;

import com.jdpaysdk.author.c.d;
import com.jdpaysdk.author.c.f;
import com.jdpaysdk.author.d;
import java.io.Serializable;

public abstract class BaseRequest extends RequestParam implements Serializable {
  public String channelInfo = "android market";
  
  public String clientVersion = d.d();
  
  public String deviceId = d.a();
  
  public String deviceType = d.g;
  
  public String identifier = d.c();
  
  public String localIP = d.a;
  
  public String macAddress = d.f;
  
  public String networkType = d.a(d.b);
  
  public String osPlatform = "android";
  
  public String osVersion = d.b();
  
  public String protocalVersion = "1.0.0";
  
  public String resolution = d.c + "*" + d.d;
  
  public String sdkVersion = d.b.getResources().getString(f.b("sdk_version"));
  
  protected void onEncrypt() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\protocol\BaseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
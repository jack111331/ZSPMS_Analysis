package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;

public final class HijackingDetectWrapper implements IResolver {
  private final Resolver resolver;
  
  public HijackingDetectWrapper(Resolver paramResolver) {
    this.resolver = paramResolver;
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    Record[] arrayOfRecord = this.resolver.resolve(paramDomain, paramNetworkInfo);
    boolean bool = paramDomain.hasCname;
    byte b = 0;
    if (bool) {
      int i = arrayOfRecord.length;
      byte b1 = 0;
      while (true) {
        if (b1 < i) {
          if (arrayOfRecord[b1].isCname()) {
            b1 = 1;
            break;
          } 
          b1++;
          continue;
        } 
        b1 = 0;
        break;
      } 
      if (b1 == 0)
        throw new DnshijackingException(paramDomain.domain, this.resolver.address.getHostAddress()); 
    } 
    if (paramDomain.maxTtl != 0) {
      int i = arrayOfRecord.length;
      byte b1 = b;
      while (b1 < i) {
        Record record = arrayOfRecord[b1];
        if (record.isCname() || record.ttl <= paramDomain.maxTtl) {
          b1++;
          continue;
        } 
        throw new DnshijackingException(paramDomain.domain, this.resolver.address.getHostAddress(), record.ttl);
      } 
    } 
    return arrayOfRecord;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\local\HijackingDetectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
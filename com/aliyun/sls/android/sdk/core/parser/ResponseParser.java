package com.aliyun.sls.android.sdk.core.parser;

import java.io.IOException;
import okhttp3.Response;

public interface ResponseParser<T extends com.aliyun.sls.android.sdk.core.Result> {
  T parse(Response paramResponse) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\parser\ResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
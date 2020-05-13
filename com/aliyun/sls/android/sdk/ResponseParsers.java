package com.aliyun.sls.android.sdk;

import com.aliyun.sls.android.sdk.core.Result;
import com.aliyun.sls.android.sdk.core.parser.AbstractResponseParser;
import com.aliyun.sls.android.sdk.result.PostLogResult;
import okhttp3.Response;

public final class ResponseParsers {
  public static class PostLogResponseParser extends AbstractResponseParser<PostLogResult> {
    public PostLogResult parseData(Response param1Response, PostLogResult param1PostLogResult) throws Exception {
      return param1PostLogResult;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\ResponseParsers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
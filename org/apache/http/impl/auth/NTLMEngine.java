package org.apache.http.impl.auth;

@Deprecated
public interface NTLMEngine {
  String generateType1Msg(String paramString1, String paramString2) throws NTLMEngineException;
  
  String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws NTLMEngineException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\auth\NTLMEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
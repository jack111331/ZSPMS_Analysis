package org.jar.mvchelper.task;

public enum Code {
  CANCEL, EXCEPTION, SUCCESS;
  
  static {
    EXCEPTION = new Code("EXCEPTION", 1);
    CANCEL = new Code("CANCEL", 2);
    $VALUES = new Code[] { SUCCESS, EXCEPTION, CANCEL };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\Code.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.ta.utdid2.a.a;

public class e {
  private static a a(String paramString) {
    a a1 = null;
    byte b = 0;
    a a2 = a1;
    if (paramString != null) {
      a2 = new a(null);
      int i;
      for (i = 0; i < 256; i++)
        a2.state[i] = i; 
      a2.x = 0;
      a2.y = 0;
      int j = 0;
      i = 0;
      while (true) {
        if (b < 'Ā')
          try {
            j = (j + paramString.charAt(i) + a2.state[b]) % 256;
            int k = a2.state[b];
            a2.state[b] = a2.state[j];
            a2.state[j] = k;
            i = (i + 1) % paramString.length();
            b++;
            continue;
          } catch (Exception exception) {
            a2 = a1;
          }  
        return a2;
      } 
    } 
    return a2;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      a a = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
      if (a != null)
        return a(paramArrayOfbyte, a); 
    } 
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, a parama) {
    if (paramArrayOfbyte != null && parama != null) {
      int i = parama.x;
      int j = parama.y;
      for (byte b = 0; b < paramArrayOfbyte.length; b++) {
        i = (i + 1) % 256;
        j = (j + parama.state[i]) % 256;
        int k = parama.state[i];
        parama.state[i] = parama.state[j];
        parama.state[j] = k;
        int m = parama.state[i];
        k = parama.state[j];
        byte b1 = paramArrayOfbyte[b];
        paramArrayOfbyte[b] = (byte)(byte)(parama.state[(m + k) % 256] ^ b1);
      } 
      parama.x = i;
      parama.y = j;
      return paramArrayOfbyte;
    } 
    return null;
  }
  
  private static class a {
    public int[] state = new int[256];
    
    public int x;
    
    public int y;
    
    private a() {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.tencent.a.a.a.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class a {
  static File a(String paramString) {
    File file = new File(paramString);
    if (!file.exists()) {
      if (!file.getParentFile().exists())
        a(file.getParentFile().getAbsolutePath()); 
      file.mkdir();
    } 
    return file;
  }
  
  static List<String> a(File paramFile) {
    FileReader fileReader = new FileReader(paramFile);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    ArrayList<String> arrayList = new ArrayList();
    while (true) {
      String str = bufferedReader.readLine();
      if (str != null) {
        arrayList.add(str.trim());
        continue;
      } 
      fileReader.close();
      bufferedReader.close();
      return arrayList;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package org.jar.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.jar.photo.activity.FolderListActivity;
import org.jar.photo.bean.b;

public class a {
  public static void a(Activity paramActivity, int paramInt) {
    try {
      Intent intent = new Intent();
      this((Context)paramActivity, FolderListActivity.class);
      intent.putExtra("single", true);
      paramActivity.startActivityForResult(intent, paramInt);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<b> paramArrayList, int paramInt2) {
    try {
      Intent intent = new Intent();
      this((Context)paramActivity, FolderListActivity.class);
      intent.putExtra("list", paramArrayList);
      intent.putExtra("max_num", paramInt2);
      paramActivity.startActivityForResult(intent, paramInt1);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
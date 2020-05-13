package android.support.v4.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

@TargetApi(9)
@RequiresApi(9)
abstract class BaseFragmentActivityGingerbread extends SupportActivity {
  boolean mStartedIntentSenderFromFragment;
  
  static void checkForValidRequestCode(int paramInt) {
    if ((0xFFFF0000 & paramInt) != 0)
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode"); 
  }
  
  abstract View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  protected void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT < 11 && getLayoutInflater().getFactory() == null)
      getLayoutInflater().setFactory((LayoutInflater.Factory)this); 
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    View view1 = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    View view2 = view1;
    if (view1 == null)
      view2 = super.onCreateView(paramString, paramContext, paramAttributeSet); 
    return view2;
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.mStartedIntentSenderFromFragment && paramInt1 != -1)
      checkForValidRequestCode(paramInt1); 
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\BaseFragmentActivityGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;

@TargetApi(21)
@RequiresApi(21)
class LayoutInflaterCompatLollipop {
  static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory) {
    if (paramLayoutInflaterFactory != null) {
      LayoutInflaterCompatHC.FactoryWrapperHC factoryWrapperHC = new LayoutInflaterCompatHC.FactoryWrapperHC(paramLayoutInflaterFactory);
    } else {
      paramLayoutInflaterFactory = null;
    } 
    paramLayoutInflater.setFactory2((LayoutInflater.Factory2)paramLayoutInflaterFactory);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\LayoutInflaterCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
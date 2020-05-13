package android.support.v4.app;

import java.util.List;

public class FragmentManagerNonConfig {
  private final List<FragmentManagerNonConfig> mChildNonConfigs;
  
  private final List<Fragment> mFragments;
  
  FragmentManagerNonConfig(List<Fragment> paramList, List<FragmentManagerNonConfig> paramList1) {
    this.mFragments = paramList;
    this.mChildNonConfigs = paramList1;
  }
  
  List<FragmentManagerNonConfig> getChildNonConfigs() {
    return this.mChildNonConfigs;
  }
  
  List<Fragment> getFragments() {
    return this.mFragments;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\FragmentManagerNonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
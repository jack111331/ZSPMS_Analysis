package com.unity3d.player;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class i extends Fragment {
  public final void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestPermissions(new String[] { getArguments().getString("PermissionNames") }, 96489);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (paramInt != 96489)
      return; 
    if (paramArrayOfString.length == 0) {
      requestPermissions(new String[] { getArguments().getString("PermissionNames") }, 96489);
      return;
    } 
    FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
    fragmentTransaction.remove(this);
    fragmentTransaction.commit();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
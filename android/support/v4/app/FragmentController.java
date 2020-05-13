package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
  private final FragmentHostCallback<?> mHost;
  
  private FragmentController(FragmentHostCallback<?> paramFragmentHostCallback) {
    this.mHost = paramFragmentHostCallback;
  }
  
  public static final FragmentController createController(FragmentHostCallback<?> paramFragmentHostCallback) {
    return new FragmentController(paramFragmentHostCallback);
  }
  
  public void attachHost(Fragment paramFragment) {
    this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, paramFragment);
  }
  
  public void dispatchActivityCreated() {
    this.mHost.mFragmentManager.dispatchActivityCreated();
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {
    this.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    return this.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void dispatchCreate() {
    this.mHost.mFragmentManager.dispatchCreate();
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public void dispatchDestroy() {
    this.mHost.mFragmentManager.dispatchDestroy();
  }
  
  public void dispatchDestroyView() {
    this.mHost.mFragmentManager.dispatchDestroyView();
  }
  
  public void dispatchLowMemory() {
    this.mHost.mFragmentManager.dispatchLowMemory();
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    return this.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu) {
    this.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
  }
  
  public void dispatchPause() {
    this.mHost.mFragmentManager.dispatchPause();
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
  }
  
  public void dispatchReallyStop() {
    this.mHost.mFragmentManager.dispatchReallyStop();
  }
  
  public void dispatchResume() {
    this.mHost.mFragmentManager.dispatchResume();
  }
  
  public void dispatchStart() {
    this.mHost.mFragmentManager.dispatchStart();
  }
  
  public void dispatchStop() {
    this.mHost.mFragmentManager.dispatchStop();
  }
  
  public void doLoaderDestroy() {
    this.mHost.doLoaderDestroy();
  }
  
  public void doLoaderRetain() {
    this.mHost.doLoaderRetain();
  }
  
  public void doLoaderStart() {
    this.mHost.doLoaderStart();
  }
  
  public void doLoaderStop(boolean paramBoolean) {
    this.mHost.doLoaderStop(paramBoolean);
  }
  
  public void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    this.mHost.dumpLoaders(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public boolean execPendingActions() {
    return this.mHost.mFragmentManager.execPendingActions();
  }
  
  @Nullable
  public Fragment findFragmentByWho(String paramString) {
    return this.mHost.mFragmentManager.findFragmentByWho(paramString);
  }
  
  public List<Fragment> getActiveFragments(List<Fragment> paramList) {
    if (this.mHost.mFragmentManager.mActive == null)
      return null; 
    List<Fragment> list = paramList;
    if (paramList == null)
      list = new ArrayList<Fragment>(getActiveFragmentsCount()); 
    list.addAll(this.mHost.mFragmentManager.mActive);
    return list;
  }
  
  public int getActiveFragmentsCount() {
    ArrayList<Fragment> arrayList = this.mHost.mFragmentManager.mActive;
    return (arrayList == null) ? 0 : arrayList.size();
  }
  
  public FragmentManager getSupportFragmentManager() {
    return this.mHost.getFragmentManagerImpl();
  }
  
  public LoaderManager getSupportLoaderManager() {
    return this.mHost.getLoaderManagerImpl();
  }
  
  public void noteStateNotSaved() {
    this.mHost.mFragmentManager.noteStateNotSaved();
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return this.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void reportLoaderStart() {
    this.mHost.reportLoaderStart();
  }
  
  public void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    this.mHost.mFragmentManager.restoreAllState(paramParcelable, paramFragmentManagerNonConfig);
  }
  
  @Deprecated
  public void restoreAllState(Parcelable paramParcelable, List<Fragment> paramList) {
    this.mHost.mFragmentManager.restoreAllState(paramParcelable, new FragmentManagerNonConfig(paramList, null));
  }
  
  public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap) {
    this.mHost.restoreLoaderNonConfig(paramSimpleArrayMap);
  }
  
  public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
    return this.mHost.retainLoaderNonConfig();
  }
  
  public FragmentManagerNonConfig retainNestedNonConfig() {
    return this.mHost.mFragmentManager.retainNonConfig();
  }
  
  @Deprecated
  public List<Fragment> retainNonConfig() {
    null = this.mHost.mFragmentManager.retainNonConfig();
    return (null != null) ? null.getFragments() : null;
  }
  
  public Parcelable saveAllState() {
    return this.mHost.mFragmentManager.saveAllState();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\FragmentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
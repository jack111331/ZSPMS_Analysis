package org.jar.photo.activity;

import org.jar.support.v4.view.ViewPager;

class a implements ViewPager.OnPageChangeListener {
  a(PreviewImageActivity paramPreviewImageActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt + 1);
    stringBuilder.append("/");
    stringBuilder.append(PreviewImageActivity.a(this.a).size());
    stringBuilder.toString();
    PreviewImageActivity.c(this.a).setEnabled(PreviewImageActivity.b(this.a).contains(PreviewImageActivity.a(this.a).get(paramInt)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
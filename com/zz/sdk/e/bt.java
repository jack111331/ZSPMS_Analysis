package com.zz.sdk.e;

import android.widget.Filter;
import com.zz.sdk.b.v;
import java.util.ArrayList;

class bt extends Filter {
  private bt(br parambr) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence) {
    Filter.FilterResults filterResults = new Filter.FilterResults();
    if (br.c(this.a) >= 0) {
      if (paramCharSequence == null || paramCharSequence.length() == 0) {
        object = br.d(this.a);
        /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
        try {
          ArrayList arrayList1 = new ArrayList();
          this(br.b(this.a));
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
          filterResults.values = arrayList1;
          filterResults.count = arrayList1.size();
        } finally {}
        return filterResults;
      } 
      Object object = object.toString().toLowerCase();
      ArrayList<v> arrayList = new ArrayList();
      for (v v : br.b(this.a)) {
        String str = v.toString().toLowerCase();
        if (str.startsWith((String)object)) {
          arrayList.add(v);
          continue;
        } 
        String[] arrayOfString = str.split(" ");
        int i = arrayOfString.length;
        for (byte b = 0; b < i; b++) {
          if (arrayOfString[b].startsWith((String)object)) {
            arrayList.add(v);
            break;
          } 
        } 
      } 
      filterResults.values = arrayList;
      filterResults.count = arrayList.size();
    } 
    return filterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults) {
    if (paramFilterResults.count > 0) {
      this.a.notifyDataSetChanged();
      return;
    } 
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package org.jar.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jar.support.annotation.NonNull;
import org.jar.support.v4.animation.AnimatorCompatHelper;
import org.jar.support.v4.view.ViewCompat;
import org.jar.support.v4.view.ViewPropertyAnimatorCompat;
import org.jar.support.v4.view.ViewPropertyAnimatorListener;

public class DefaultItemAnimator extends SimpleItemAnimator {
  private static final boolean DEBUG = false;
  
  private ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<ArrayList<RecyclerView.ViewHolder>>();
  
  private ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<ArrayList<ChangeInfo>>();
  
  private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<ArrayList<MoveInfo>>();
  
  private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<ChangeInfo>();
  
  private ArrayList<MoveInfo> mPendingMoves = new ArrayList<MoveInfo>();
  
  private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<RecyclerView.ViewHolder>();
  
  private void animateAddImpl(final RecyclerView.ViewHolder holder) {
    final ViewPropertyAnimatorCompat animation = ViewCompat.animate(holder.itemView);
    this.mAddAnimations.add(holder);
    viewPropertyAnimatorCompat.alpha(1.0F).setDuration(getAddDuration()).setListener(new VpaListenerAdapter() {
          public void onAnimationCancel(View param1View) {
            ViewCompat.setAlpha(param1View, 1.0F);
          }
          
          public void onAnimationEnd(View param1View) {
            animation.setListener(null);
            DefaultItemAnimator.this.dispatchAddFinished(holder);
            DefaultItemAnimator.this.mAddAnimations.remove(holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
          }
          
          public void onAnimationStart(View param1View) {
            DefaultItemAnimator.this.dispatchAddStarting(holder);
          }
        }).start();
  }
  
  private void animateChangeImpl(final ChangeInfo changeInfo) {
    View view1;
    RecyclerView.ViewHolder viewHolder1 = changeInfo.oldHolder;
    final View newView = null;
    if (viewHolder1 == null) {
      viewHolder1 = null;
    } else {
      view1 = viewHolder1.itemView;
    } 
    RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
    if (viewHolder2 != null)
      view2 = viewHolder2.itemView; 
    if (view1 != null) {
      final ViewPropertyAnimatorCompat newViewAnimation = ViewCompat.animate(view1).setDuration(getChangeDuration());
      this.mChangeAnimations.add(changeInfo.oldHolder);
      viewPropertyAnimatorCompat.translationX((changeInfo.toX - changeInfo.fromX));
      viewPropertyAnimatorCompat.translationY((changeInfo.toY - changeInfo.fromY));
      viewPropertyAnimatorCompat.alpha(0.0F).setListener(new VpaListenerAdapter() {
            public void onAnimationEnd(View param1View) {
              oldViewAnim.setListener(null);
              ViewCompat.setAlpha(param1View, 1.0F);
              ViewCompat.setTranslationX(param1View, 0.0F);
              ViewCompat.setTranslationY(param1View, 0.0F);
              DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
              DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
              DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }
            
            public void onAnimationStart(View param1View) {
              DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
            }
          }).start();
    } 
    if (view2 != null) {
      final ViewPropertyAnimatorCompat newViewAnimation = ViewCompat.animate(view2);
      this.mChangeAnimations.add(changeInfo.newHolder);
      viewPropertyAnimatorCompat.translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new VpaListenerAdapter() {
            public void onAnimationEnd(View param1View) {
              newViewAnimation.setListener(null);
              ViewCompat.setAlpha(newView, 1.0F);
              ViewCompat.setTranslationX(newView, 0.0F);
              ViewCompat.setTranslationY(newView, 0.0F);
              DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
              DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
              DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }
            
            public void onAnimationStart(View param1View) {
              DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
            }
          }).start();
    } 
  }
  
  private void animateMoveImpl(final RecyclerView.ViewHolder holder, final int deltaX, final int deltaY, int paramInt3, int paramInt4) {
    View view = holder.itemView;
    deltaX = paramInt3 - deltaX;
    deltaY = paramInt4 - deltaY;
    if (deltaX != 0)
      ViewCompat.animate(view).translationX(0.0F); 
    if (deltaY != 0)
      ViewCompat.animate(view).translationY(0.0F); 
    final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);
    this.mMoveAnimations.add(holder);
    viewPropertyAnimatorCompat.setDuration(getMoveDuration()).setListener(new VpaListenerAdapter() {
          public void onAnimationCancel(View param1View) {
            if (deltaX != 0)
              ViewCompat.setTranslationX(param1View, 0.0F); 
            if (deltaY != 0)
              ViewCompat.setTranslationY(param1View, 0.0F); 
          }
          
          public void onAnimationEnd(View param1View) {
            animation.setListener(null);
            DefaultItemAnimator.this.dispatchMoveFinished(holder);
            DefaultItemAnimator.this.mMoveAnimations.remove(holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
          }
          
          public void onAnimationStart(View param1View) {
            DefaultItemAnimator.this.dispatchMoveStarting(holder);
          }
        }).start();
  }
  
  private void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
    final ViewPropertyAnimatorCompat animation = ViewCompat.animate(holder.itemView);
    this.mRemoveAnimations.add(holder);
    viewPropertyAnimatorCompat.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new VpaListenerAdapter() {
          public void onAnimationEnd(View param1View) {
            animation.setListener(null);
            ViewCompat.setAlpha(param1View, 1.0F);
            DefaultItemAnimator.this.dispatchRemoveFinished(holder);
            DefaultItemAnimator.this.mRemoveAnimations.remove(holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
          }
          
          public void onAnimationStart(View param1View) {
            DefaultItemAnimator.this.dispatchRemoveStarting(holder);
          }
        }).start();
  }
  
  private void dispatchFinishedWhenDone() {
    if (!isRunning())
      dispatchAnimationsFinished(); 
  }
  
  private void endChangeAnimation(List<ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder) {
    for (int i = paramList.size() - 1; i >= 0; i--) {
      ChangeInfo changeInfo = paramList.get(i);
      if (endChangeAnimationIfNecessary(changeInfo, paramViewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null)
        paramList.remove(changeInfo); 
    } 
  }
  
  private void endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo) {
    if (paramChangeInfo.oldHolder != null)
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.oldHolder); 
    if (paramChangeInfo.newHolder != null)
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.newHolder); 
  }
  
  private boolean endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder) {
    RecyclerView.ViewHolder viewHolder = paramChangeInfo.newHolder;
    boolean bool = false;
    if (viewHolder == paramViewHolder) {
      paramChangeInfo.newHolder = null;
    } else {
      if (paramChangeInfo.oldHolder == paramViewHolder) {
        paramChangeInfo.oldHolder = null;
        bool = true;
        ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
        ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
        ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
        dispatchChangeFinished(paramViewHolder, bool);
        return true;
      } 
      return false;
    } 
    ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
    ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
    ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
    dispatchChangeFinished(paramViewHolder, bool);
    return true;
  }
  
  private void resetAnimation(RecyclerView.ViewHolder paramViewHolder) {
    AnimatorCompatHelper.clearInterpolator(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder) {
    resetAnimation(paramViewHolder);
    ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
    this.mPendingAdditions.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramViewHolder1 == paramViewHolder2)
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4); 
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    resetAnimation(paramViewHolder1);
    int i = (int)((paramInt3 - paramInt1) - f1);
    int j = (int)((paramInt4 - paramInt2) - f2);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if (paramViewHolder2 != null) {
      resetAnimation(paramViewHolder2);
      ViewCompat.setTranslationX(paramViewHolder2.itemView, -i);
      ViewCompat.setTranslationY(paramViewHolder2.itemView, -j);
      ViewCompat.setAlpha(paramViewHolder2.itemView, 0.0F);
    } 
    this.mPendingChanges.add(new ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    View view = paramViewHolder.itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    int i = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    resetAnimation(paramViewHolder);
    int j = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - i;
    if (j == 0 && paramInt2 == 0) {
      dispatchMoveFinished(paramViewHolder);
      return false;
    } 
    if (j != 0)
      ViewCompat.setTranslationX(view, -j); 
    if (paramInt2 != 0)
      ViewCompat.setTranslationY(view, -paramInt2); 
    this.mPendingMoves.add(new MoveInfo(paramViewHolder, paramInt1, i, paramInt3, paramInt4));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder) {
    resetAnimation(paramViewHolder);
    this.mPendingRemovals.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList) {
    return (!paramList.isEmpty() || super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  void cancelAll(List<RecyclerView.ViewHolder> paramList) {
    for (int i = paramList.size() - 1; i >= 0; i--)
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(i)).itemView).cancel(); 
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder) {
    View view = paramViewHolder.itemView;
    ViewCompat.animate(view).cancel();
    int i;
    for (i = this.mPendingMoves.size() - 1; i >= 0; i--) {
      if (((MoveInfo)this.mPendingMoves.get(i)).holder == paramViewHolder) {
        ViewCompat.setTranslationY(view, 0.0F);
        ViewCompat.setTranslationX(view, 0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.mPendingMoves.remove(i);
      } 
    } 
    endChangeAnimation(this.mPendingChanges, paramViewHolder);
    if (this.mPendingRemovals.remove(paramViewHolder)) {
      ViewCompat.setAlpha(view, 1.0F);
      dispatchRemoveFinished(paramViewHolder);
    } 
    if (this.mPendingAdditions.remove(paramViewHolder)) {
      ViewCompat.setAlpha(view, 1.0F);
      dispatchAddFinished(paramViewHolder);
    } 
    for (i = this.mChangesList.size() - 1; i >= 0; i--) {
      ArrayList<ChangeInfo> arrayList = this.mChangesList.get(i);
      endChangeAnimation(arrayList, paramViewHolder);
      if (arrayList.isEmpty())
        this.mChangesList.remove(i); 
    } 
    for (i = this.mMovesList.size() - 1; i >= 0; i--) {
      ArrayList arrayList = this.mMovesList.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        if (((MoveInfo)arrayList.get(j)).holder == paramViewHolder) {
          ViewCompat.setTranslationY(view, 0.0F);
          ViewCompat.setTranslationX(view, 0.0F);
          dispatchMoveFinished(paramViewHolder);
          arrayList.remove(j);
          if (arrayList.isEmpty())
            this.mMovesList.remove(i); 
          break;
        } 
      } 
    } 
    for (i = this.mAdditionsList.size() - 1; i >= 0; i--) {
      ArrayList arrayList = this.mAdditionsList.get(i);
      if (arrayList.remove(paramViewHolder)) {
        ViewCompat.setAlpha(view, 1.0F);
        dispatchAddFinished(paramViewHolder);
        if (arrayList.isEmpty())
          this.mAdditionsList.remove(i); 
      } 
    } 
    this.mRemoveAnimations.remove(paramViewHolder);
    this.mAddAnimations.remove(paramViewHolder);
    this.mChangeAnimations.remove(paramViewHolder);
    this.mMoveAnimations.remove(paramViewHolder);
    dispatchFinishedWhenDone();
  }
  
  public void endAnimations() {
    int i;
    for (i = this.mPendingMoves.size() - 1; i >= 0; i--) {
      MoveInfo moveInfo = this.mPendingMoves.get(i);
      View view = moveInfo.holder.itemView;
      ViewCompat.setTranslationY(view, 0.0F);
      ViewCompat.setTranslationX(view, 0.0F);
      dispatchMoveFinished(moveInfo.holder);
      this.mPendingMoves.remove(i);
    } 
    for (i = this.mPendingRemovals.size() - 1; i >= 0; i--) {
      dispatchRemoveFinished(this.mPendingRemovals.get(i));
      this.mPendingRemovals.remove(i);
    } 
    for (i = this.mPendingAdditions.size() - 1; i >= 0; i--) {
      RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(i);
      ViewCompat.setAlpha(viewHolder.itemView, 1.0F);
      dispatchAddFinished(viewHolder);
      this.mPendingAdditions.remove(i);
    } 
    for (i = this.mPendingChanges.size() - 1; i >= 0; i--)
      endChangeAnimationIfNecessary(this.mPendingChanges.get(i)); 
    this.mPendingChanges.clear();
    if (!isRunning())
      return; 
    for (i = this.mMovesList.size() - 1; i >= 0; i--) {
      ArrayList<MoveInfo> arrayList = this.mMovesList.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        MoveInfo moveInfo = arrayList.get(j);
        View view = moveInfo.holder.itemView;
        ViewCompat.setTranslationY(view, 0.0F);
        ViewCompat.setTranslationX(view, 0.0F);
        dispatchMoveFinished(moveInfo.holder);
        arrayList.remove(j);
        if (arrayList.isEmpty())
          this.mMovesList.remove(arrayList); 
      } 
    } 
    for (i = this.mAdditionsList.size() - 1; i >= 0; i--) {
      ArrayList<RecyclerView.ViewHolder> arrayList = this.mAdditionsList.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        RecyclerView.ViewHolder viewHolder = arrayList.get(j);
        ViewCompat.setAlpha(viewHolder.itemView, 1.0F);
        dispatchAddFinished(viewHolder);
        arrayList.remove(j);
        if (arrayList.isEmpty())
          this.mAdditionsList.remove(arrayList); 
      } 
    } 
    for (i = this.mChangesList.size() - 1; i >= 0; i--) {
      ArrayList<ChangeInfo> arrayList = this.mChangesList.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        endChangeAnimationIfNecessary(arrayList.get(j));
        if (arrayList.isEmpty())
          this.mChangesList.remove(arrayList); 
      } 
    } 
    cancelAll(this.mRemoveAnimations);
    cancelAll(this.mMoveAnimations);
    cancelAll(this.mAddAnimations);
    cancelAll(this.mChangeAnimations);
    dispatchAnimationsFinished();
  }
  
  public boolean isRunning() {
    return (!this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty());
  }
  
  public void runPendingAnimations() {
    int i = this.mPendingRemovals.isEmpty() ^ true;
    int j = this.mPendingMoves.isEmpty() ^ true;
    int k = this.mPendingChanges.isEmpty() ^ true;
    int m = this.mPendingAdditions.isEmpty() ^ true;
    if (i == 0 && j == 0 && m == 0 && k == 0)
      return; 
    Iterator<RecyclerView.ViewHolder> iterator = this.mPendingRemovals.iterator();
    while (iterator.hasNext())
      animateRemoveImpl(iterator.next()); 
    this.mPendingRemovals.clear();
    if (j != 0) {
      final ArrayList<MoveInfo> additions = new ArrayList();
      arrayList.addAll(this.mPendingMoves);
      this.mMovesList.add(arrayList);
      this.mPendingMoves.clear();
      Runnable runnable = new Runnable() {
          public void run() {
            for (DefaultItemAnimator.MoveInfo moveInfo : moves)
              DefaultItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY); 
            moves.clear();
            DefaultItemAnimator.this.mMovesList.remove(moves);
          }
        };
      if (i != 0) {
        ViewCompat.postOnAnimationDelayed(((MoveInfo)arrayList.get(0)).holder.itemView, runnable, getRemoveDuration());
      } else {
        runnable.run();
      } 
    } 
    if (k != 0) {
      final ArrayList<ChangeInfo> additions = new ArrayList();
      arrayList.addAll(this.mPendingChanges);
      this.mChangesList.add(arrayList);
      this.mPendingChanges.clear();
      Runnable runnable = new Runnable() {
          public void run() {
            for (DefaultItemAnimator.ChangeInfo changeInfo : changes)
              DefaultItemAnimator.this.animateChangeImpl(changeInfo); 
            changes.clear();
            DefaultItemAnimator.this.mChangesList.remove(changes);
          }
        };
      if (i != 0) {
        ViewCompat.postOnAnimationDelayed(((ChangeInfo)arrayList.get(0)).oldHolder.itemView, runnable, getRemoveDuration());
      } else {
        runnable.run();
      } 
    } 
    if (m != 0) {
      final ArrayList<RecyclerView.ViewHolder> additions = new ArrayList();
      arrayList.addAll(this.mPendingAdditions);
      this.mAdditionsList.add(arrayList);
      this.mPendingAdditions.clear();
      Runnable runnable = new Runnable() {
          public void run() {
            for (RecyclerView.ViewHolder viewHolder : additions)
              DefaultItemAnimator.this.animateAddImpl(viewHolder); 
            additions.clear();
            DefaultItemAnimator.this.mAdditionsList.remove(additions);
          }
        };
      if (i != 0 || j != 0 || k != 0) {
        long l2;
        long l1 = 0L;
        if (i != 0) {
          l2 = getRemoveDuration();
        } else {
          l2 = 0L;
        } 
        if (j != 0) {
          l3 = getMoveDuration();
        } else {
          l3 = 0L;
        } 
        if (k != 0)
          l1 = getChangeDuration(); 
        long l3 = Math.max(l3, l1);
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)arrayList.get(0)).itemView, runnable, l2 + l3);
        return;
      } 
      runnable.run();
    } 
  }
  
  private static class ChangeInfo {
    public int fromX;
    
    public int fromY;
    
    public RecyclerView.ViewHolder newHolder;
    
    public RecyclerView.ViewHolder oldHolder;
    
    public int toX;
    
    public int toY;
    
    private ChangeInfo(RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2) {
      this.oldHolder = param1ViewHolder1;
      this.newHolder = param1ViewHolder2;
    }
    
    private ChangeInfo(RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this(param1ViewHolder1, param1ViewHolder2);
      this.fromX = param1Int1;
      this.fromY = param1Int2;
      this.toX = param1Int3;
      this.toY = param1Int4;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ChangeInfo{oldHolder=");
      stringBuilder.append(this.oldHolder);
      stringBuilder.append(", newHolder=");
      stringBuilder.append(this.newHolder);
      stringBuilder.append(", fromX=");
      stringBuilder.append(this.fromX);
      stringBuilder.append(", fromY=");
      stringBuilder.append(this.fromY);
      stringBuilder.append(", toX=");
      stringBuilder.append(this.toX);
      stringBuilder.append(", toY=");
      stringBuilder.append(this.toY);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  private static class MoveInfo {
    public int fromX;
    
    public int fromY;
    
    public RecyclerView.ViewHolder holder;
    
    public int toX;
    
    public int toY;
    
    private MoveInfo(RecyclerView.ViewHolder param1ViewHolder, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.holder = param1ViewHolder;
      this.fromX = param1Int1;
      this.fromY = param1Int2;
      this.toX = param1Int3;
      this.toY = param1Int4;
    }
  }
  
  private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
    private VpaListenerAdapter() {}
    
    public void onAnimationCancel(View param1View) {}
    
    public void onAnimationEnd(View param1View) {}
    
    public void onAnimationStart(View param1View) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\DefaultItemAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
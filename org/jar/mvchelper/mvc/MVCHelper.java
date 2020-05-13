package org.jar.mvchelper.mvc;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.mvchelper.mvc.imp.DefaultLoadViewFactory;
import org.jar.mvchelper.mvc.viewhandler.ListViewHandler;
import org.jar.mvchelper.mvc.viewhandler.RecyclerViewHandler;
import org.jar.mvchelper.mvc.viewhandler.ViewHandler;
import org.jar.mvchelper.task.Code;
import org.jar.mvchelper.task.IAsyncTask;
import org.jar.mvchelper.task.ICallback;
import org.jar.mvchelper.task.ISuperTask;
import org.jar.mvchelper.task.ITask;
import org.jar.mvchelper.task.TaskHelper;
import org.jar.mvchelper.task.imp.SimpleCallback;
import org.jar.mvchelper.utils.NetworkUtils;

public class MVCHelper<DATA> {
  public static ILoadViewFactory loadViewFactory = (ILoadViewFactory)new DefaultLoadViewFactory();
  
  private boolean autoLoadMore = true;
  
  private View contentView;
  
  private Context context;
  
  private IDataAdapter<DATA> dataAdapter;
  
  private ISuperTask<DATA> dataSource;
  
  private Handler handler;
  
  private boolean hasInitLoadMoreView = false;
  
  private boolean hasMoreData = true;
  
  private ListViewHandler listViewHandler = new ListViewHandler();
  
  private long loadDataTime = -1L;
  
  private SimpleCallback<DATA> loadMoreCallback = new SimpleCallback<DATA>() {
      public void onPostExecute(Object param1Object, Code param1Code, Exception param1Exception, DATA param1DATA) {
        // Byte code:
        //   0: aload_2
        //   1: astore #5
        //   3: aload_2
        //   4: getstatic org/jar/mvchelper/task/Code.SUCCESS : Lorg/jar/mvchelper/task/Code;
        //   7: if_acmpne -> 23
        //   10: aload_2
        //   11: astore #5
        //   13: aload #4
        //   15: ifnonnull -> 23
        //   18: getstatic org/jar/mvchelper/task/Code.EXCEPTION : Lorg/jar/mvchelper/task/Code;
        //   21: astore #5
        //   23: getstatic org/jar/mvchelper/mvc/MVCHelper$7.$SwitchMap$org$jar$mvchelper$task$Code : [I
        //   26: aload #5
        //   28: invokevirtual ordinal : ()I
        //   31: iaload
        //   32: tableswitch default -> 56, 1 -> 117, 2 -> 59
        //   56: goto -> 256
        //   59: aload_0
        //   60: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   63: aconst_null
        //   64: invokestatic access$802 : (Lorg/jar/mvchelper/mvc/MVCHelper;Lorg/jar/mvchelper/mvc/RequestHandle;)Lorg/jar/mvchelper/mvc/RequestHandle;
        //   67: pop
        //   68: aload_0
        //   69: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   72: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   75: aload_3
        //   76: invokeinterface tipFail : (Ljava/lang/Exception;)V
        //   81: aload_0
        //   82: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   85: invokestatic access$100 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Z
        //   88: ifeq -> 256
        //   91: aload_0
        //   92: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   95: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   98: ifnull -> 256
        //   101: aload_0
        //   102: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   105: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   108: aload_3
        //   109: invokeinterface showFail : (Ljava/lang/Exception;)V
        //   114: goto -> 256
        //   117: aload_0
        //   118: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   121: aconst_null
        //   122: invokestatic access$802 : (Lorg/jar/mvchelper/mvc/MVCHelper;Lorg/jar/mvchelper/mvc/RequestHandle;)Lorg/jar/mvchelper/mvc/RequestHandle;
        //   125: pop
        //   126: aload_0
        //   127: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   130: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   133: aload #4
        //   135: iconst_0
        //   136: invokeinterface notifyDataChanged : (Ljava/lang/Object;Z)V
        //   141: aload_0
        //   142: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   145: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   148: invokeinterface isEmpty : ()Z
        //   153: ifeq -> 171
        //   156: aload_0
        //   157: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   160: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   163: invokeinterface showEmpty : ()V
        //   168: goto -> 183
        //   171: aload_0
        //   172: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   175: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   178: invokeinterface restore : ()V
        //   183: aload_0
        //   184: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   187: aload_0
        //   188: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   191: aload_1
        //   192: invokestatic access$1100 : (Lorg/jar/mvchelper/mvc/MVCHelper;Ljava/lang/Object;)Z
        //   195: invokestatic access$1002 : (Lorg/jar/mvchelper/mvc/MVCHelper;Z)Z
        //   198: pop
        //   199: aload_0
        //   200: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   203: invokestatic access$100 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Z
        //   206: ifeq -> 256
        //   209: aload_0
        //   210: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   213: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   216: ifnull -> 256
        //   219: aload_0
        //   220: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   223: invokestatic access$1000 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Z
        //   226: ifeq -> 244
        //   229: aload_0
        //   230: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   233: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   236: invokeinterface showNormal : ()V
        //   241: goto -> 256
        //   244: aload_0
        //   245: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   248: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   251: invokeinterface showNomore : ()V
        //   256: aload_0
        //   257: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   260: invokestatic access$700 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/MVCHelper$MOnStateChangeListener;
        //   263: ifnull -> 285
        //   266: aload_0
        //   267: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   270: invokestatic access$700 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/MVCHelper$MOnStateChangeListener;
        //   273: aload_0
        //   274: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   277: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   280: aload #4
        //   282: invokevirtual onEndLoadMore : (Lorg/jar/mvchelper/mvc/IDataAdapter;Ljava/lang/Object;)V
        //   285: return
      }
      
      public void onPreExecute(Object param1Object) {
        super.onPreExecute(param1Object);
        if (MVCHelper.this.onStateChangeListener != null)
          MVCHelper.this.onStateChangeListener.onStartLoadMore(MVCHelper.this.dataAdapter); 
        if (MVCHelper.this.hasInitLoadMoreView && MVCHelper.this.mLoadMoreView != null)
          MVCHelper.this.mLoadMoreView.showLoading(); 
      }
    };
  
  private ILoadViewFactory.ILoadMoreView mLoadMoreView;
  
  private ILoadViewFactory.ILoadView mLoadView;
  
  private boolean needCheckNetwork = true;
  
  private View.OnClickListener onClickLoadMoreListener = new View.OnClickListener() {
      public void onClick(View param1View) {
        MVCHelper.this.loadMore();
      }
    };
  
  private View.OnClickListener onClickRefresListener = new View.OnClickListener() {
      public void onClick(View param1View) {
        MVCHelper.this.refresh();
      }
    };
  
  private IRefreshView.OnRefreshListener onRefreshListener = new IRefreshView.OnRefreshListener() {
      public void onRefresh() {
        MVCHelper.this.refresh();
      }
    };
  
  private OnScrollBottomListener onScrollBottomListener = new OnScrollBottomListener() {
      public void onScorllBootom() {
        if (MVCHelper.this.autoLoadMore && MVCHelper.this.hasMoreData && !MVCHelper.this.isLoading())
          if (MVCHelper.this.needCheckNetwork && !NetworkUtils.hasNetwork(MVCHelper.this.context)) {
            MVCHelper.this.mLoadMoreView.showFail(new Exception(MVCHelper.this.context.getString(ResUtils.id(MVCHelper.this.context, R.string.bloc_tip_network_unavailable))));
          } else {
            MVCHelper.this.loadMore();
          }  
      }
    };
  
  private MOnStateChangeListener<DATA> onStateChangeListener = new MOnStateChangeListener<DATA>();
  
  private RecyclerViewHandler recyclerViewHandler = new RecyclerViewHandler();
  
  private SimpleCallback<DATA> refreshCallback = new SimpleCallback<DATA>() {
      public Runnable showRefreshing;
      
      public void onPostExecute(Object param1Object, Code param1Code, Exception param1Exception, DATA param1DATA) {
        // Byte code:
        //   0: aload_0
        //   1: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   4: invokestatic access$600 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Landroid/os/Handler;
        //   7: aload_0
        //   8: getfield showRefreshing : Ljava/lang/Runnable;
        //   11: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
        //   14: aload_0
        //   15: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   18: invokestatic access$500 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IRefreshView;
        //   21: invokeinterface showRefreshComplete : ()V
        //   26: aload_2
        //   27: astore #5
        //   29: aload_2
        //   30: getstatic org/jar/mvchelper/task/Code.SUCCESS : Lorg/jar/mvchelper/task/Code;
        //   33: if_acmpne -> 49
        //   36: aload_2
        //   37: astore #5
        //   39: aload #4
        //   41: ifnonnull -> 49
        //   44: getstatic org/jar/mvchelper/task/Code.EXCEPTION : Lorg/jar/mvchelper/task/Code;
        //   47: astore #5
        //   49: getstatic org/jar/mvchelper/mvc/MVCHelper$7.$SwitchMap$org$jar$mvchelper$task$Code : [I
        //   52: aload #5
        //   54: invokevirtual ordinal : ()I
        //   57: iaload
        //   58: tableswitch default -> 80, 1 -> 139, 2 -> 83
        //   80: goto -> 289
        //   83: aload_0
        //   84: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   87: aconst_null
        //   88: invokestatic access$802 : (Lorg/jar/mvchelper/mvc/MVCHelper;Lorg/jar/mvchelper/mvc/RequestHandle;)Lorg/jar/mvchelper/mvc/RequestHandle;
        //   91: pop
        //   92: aload_0
        //   93: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   96: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   99: invokeinterface isEmpty : ()Z
        //   104: ifeq -> 123
        //   107: aload_0
        //   108: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   111: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   114: aload_3
        //   115: invokeinterface showFail : (Ljava/lang/Exception;)V
        //   120: goto -> 289
        //   123: aload_0
        //   124: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   127: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   130: aload_3
        //   131: invokeinterface tipFail : (Ljava/lang/Exception;)V
        //   136: goto -> 289
        //   139: aload_0
        //   140: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   143: aconst_null
        //   144: invokestatic access$802 : (Lorg/jar/mvchelper/mvc/MVCHelper;Lorg/jar/mvchelper/mvc/RequestHandle;)Lorg/jar/mvchelper/mvc/RequestHandle;
        //   147: pop
        //   148: aload_0
        //   149: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   152: invokestatic currentTimeMillis : ()J
        //   155: invokestatic access$902 : (Lorg/jar/mvchelper/mvc/MVCHelper;J)J
        //   158: pop2
        //   159: aload_0
        //   160: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   163: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   166: aload #4
        //   168: iconst_1
        //   169: invokeinterface notifyDataChanged : (Ljava/lang/Object;Z)V
        //   174: aload_0
        //   175: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   178: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   181: invokeinterface isEmpty : ()Z
        //   186: ifeq -> 204
        //   189: aload_0
        //   190: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   193: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   196: invokeinterface showEmpty : ()V
        //   201: goto -> 216
        //   204: aload_0
        //   205: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   208: invokestatic access$400 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadView;
        //   211: invokeinterface restore : ()V
        //   216: aload_0
        //   217: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   220: aload_0
        //   221: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   224: aload_1
        //   225: invokestatic access$1100 : (Lorg/jar/mvchelper/mvc/MVCHelper;Ljava/lang/Object;)Z
        //   228: invokestatic access$1002 : (Lorg/jar/mvchelper/mvc/MVCHelper;Z)Z
        //   231: pop
        //   232: aload_0
        //   233: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   236: invokestatic access$100 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Z
        //   239: ifeq -> 289
        //   242: aload_0
        //   243: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   246: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   249: ifnull -> 289
        //   252: aload_0
        //   253: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   256: invokestatic access$1000 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Z
        //   259: ifeq -> 277
        //   262: aload_0
        //   263: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   266: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   269: invokeinterface showNormal : ()V
        //   274: goto -> 289
        //   277: aload_0
        //   278: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   281: invokestatic access$200 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/ILoadViewFactory$ILoadMoreView;
        //   284: invokeinterface showNomore : ()V
        //   289: aload_0
        //   290: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   293: invokestatic access$700 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/MVCHelper$MOnStateChangeListener;
        //   296: ifnull -> 318
        //   299: aload_0
        //   300: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   303: invokestatic access$700 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/MVCHelper$MOnStateChangeListener;
        //   306: aload_0
        //   307: getfield this$0 : Lorg/jar/mvchelper/mvc/MVCHelper;
        //   310: invokestatic access$300 : (Lorg/jar/mvchelper/mvc/MVCHelper;)Lorg/jar/mvchelper/mvc/IDataAdapter;
        //   313: aload #4
        //   315: invokevirtual onEndRefresh : (Lorg/jar/mvchelper/mvc/IDataAdapter;Ljava/lang/Object;)V
        //   318: return
      }
      
      public void onPreExecute(Object param1Object) {
        if (MVCHelper.this.hasInitLoadMoreView && MVCHelper.this.mLoadMoreView != null)
          MVCHelper.this.mLoadMoreView.showNormal(); 
        if (param1Object instanceof IDataCacheLoader) {
          param1Object = ((IDataCacheLoader)param1Object).loadCache(MVCHelper.this.dataAdapter.isEmpty());
          if (param1Object != null)
            MVCHelper.this.dataAdapter.notifyDataChanged(param1Object, true); 
        } 
        if (MVCHelper.this.dataAdapter.isEmpty()) {
          MVCHelper.this.mLoadView.showLoading();
        } else {
          MVCHelper.this.mLoadView.restore();
        } 
        Handler handler = MVCHelper.this.handler;
        param1Object = new Runnable() {
            public void run() {
              if (MVCHelper.this.dataAdapter.isEmpty()) {
                MVCHelper.this.refreshView.showRefreshComplete();
              } else {
                MVCHelper.this.refreshView.showRefreshing();
              } 
            }
          };
        this.showRefreshing = (Runnable)param1Object;
        handler.post((Runnable)param1Object);
        if (MVCHelper.this.onStateChangeListener != null)
          MVCHelper.this.onStateChangeListener.onStartRefresh(MVCHelper.this.dataAdapter); 
      }
    };
  
  private IRefreshView refreshView;
  
  private RequestHandle requestHandle;
  
  private TaskHelper<DATA> taskHelper;
  
  public MVCHelper(IRefreshView paramIRefreshView) {
    this(paramIRefreshView, loadViewFactory.madeLoadView(), loadViewFactory.madeLoadMoreView());
  }
  
  public MVCHelper(IRefreshView paramIRefreshView, ILoadViewFactory.ILoadView paramILoadView) {
    this(paramIRefreshView, paramILoadView, null);
  }
  
  public MVCHelper(IRefreshView paramIRefreshView, ILoadViewFactory.ILoadView paramILoadView, ILoadViewFactory.ILoadMoreView paramILoadMoreView) {
    this.context = paramIRefreshView.getContentView().getContext().getApplicationContext();
    this.autoLoadMore = true;
    this.refreshView = paramIRefreshView;
    this.contentView = paramIRefreshView.getContentView();
    this.contentView.setOverScrollMode(2);
    paramIRefreshView.setOnRefreshListener(this.onRefreshListener);
    this.mLoadView = paramILoadView;
    this.mLoadMoreView = paramILoadMoreView;
    this.taskHelper = new TaskHelper();
    this.mLoadView.init(paramIRefreshView.getSwitchView(), this.onClickRefresListener);
    this.handler = new Handler();
  }
  
  private boolean hasMore(Object paramObject) {
    return (paramObject instanceof IAsyncDataSource) ? ((IAsyncDataSource)paramObject).hasMore() : ((paramObject instanceof IDataSource) ? ((IDataSource)paramObject).hasMore() : false);
  }
  
  public static void setLoadViewFractory(ILoadViewFactory paramILoadViewFactory) {
    loadViewFactory = paramILoadViewFactory;
  }
  
  public void destory() {
    if (this.requestHandle != null) {
      this.requestHandle.cancle();
      this.requestHandle = null;
    } 
    this.taskHelper.destroy();
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public IDataAdapter<DATA> getAdapter() {
    return this.dataAdapter;
  }
  
  public <T extends View> T getContentView() {
    return (T)this.refreshView.getContentView();
  }
  
  public ISuperTask<DATA> getDataSource() {
    return this.dataSource;
  }
  
  public long getLoadDataTime() {
    return this.loadDataTime;
  }
  
  public ILoadViewFactory.ILoadMoreView getLoadMoreView() {
    return this.mLoadMoreView;
  }
  
  public ILoadViewFactory.ILoadView getLoadView() {
    return this.mLoadView;
  }
  
  protected IRefreshView getRefreshView() {
    return this.refreshView;
  }
  
  public boolean isAutoLoadMore() {
    return this.autoLoadMore;
  }
  
  public boolean isLoading() {
    boolean bool;
    if (this.requestHandle != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void loadMore() {
    if (isLoading())
      return; 
    if (this.dataAdapter.isEmpty()) {
      refresh();
      return;
    } 
    if (this.dataAdapter == null || this.dataSource == null) {
      if (this.refreshView != null)
        this.refreshView.showRefreshComplete(); 
      return;
    } 
    if (this.requestHandle != null) {
      this.requestHandle.cancle();
      this.requestHandle = null;
    } 
    if (this.dataSource instanceof IDataSource) {
      this.requestHandle = TaskHelper.createExecutor((IDataSource)this.dataSource, false, (ICallback)this.loadMoreCallback).execute();
    } else if (this.dataSource instanceof IAsyncDataSource) {
      this.requestHandle = TaskHelper.createExecutor((IAsyncDataSource)this.dataSource, false, (ICallback)this.loadMoreCallback).execute();
    } 
  }
  
  public void refresh() {
    if (this.dataAdapter == null || this.dataSource == null) {
      if (this.refreshView != null)
        this.refreshView.showRefreshComplete(); 
      return;
    } 
    if (this.requestHandle != null) {
      this.requestHandle.cancle();
      this.requestHandle = null;
    } 
    if (this.dataSource instanceof IDataSource) {
      this.requestHandle = TaskHelper.createExecutor((IDataSource)this.dataSource, true, (ICallback)this.refreshCallback).execute();
    } else if (this.dataSource instanceof IAsyncDataSource) {
      this.requestHandle = TaskHelper.createExecutor((IAsyncDataSource)this.dataSource, true, (ICallback)this.refreshCallback).execute();
    } else if (this.dataSource instanceof ITask) {
      this.requestHandle = TaskHelper.createExecutor((ITask)this.dataSource, (ICallback)this.refreshCallback).execute();
    } else {
      this.requestHandle = TaskHelper.createExecutor((IAsyncTask)this.dataSource, (ICallback)this.refreshCallback).execute();
    } 
  }
  
  public void setAdapter(IDataAdapter<DATA> paramIDataAdapter) {
    setAdapter2(paramIDataAdapter, paramIDataAdapter);
  }
  
  public void setAdapter(IDataAdapter<DATA> paramIDataAdapter, ViewHandler paramViewHandler) {
    setAdapter2(paramIDataAdapter, paramIDataAdapter, paramViewHandler);
  }
  
  public void setAdapter2(Object paramObject, IDataAdapter<DATA> paramIDataAdapter) {
    if (this.contentView instanceof android.widget.ListView) {
      setAdapter2(paramObject, paramIDataAdapter, (ViewHandler)this.listViewHandler);
    } else if (this.contentView instanceof org.jar.support.v7.widget.RecyclerView) {
      setAdapter2(paramObject, paramIDataAdapter, (ViewHandler)this.recyclerViewHandler);
    } else {
      setAdapter2(paramObject, paramIDataAdapter, null);
    } 
  }
  
  public void setAdapter2(Object paramObject, IDataAdapter<DATA> paramIDataAdapter, ViewHandler paramViewHandler) {
    this.hasInitLoadMoreView = false;
    if (paramViewHandler != null) {
      View view = (View)getContentView();
      this.hasInitLoadMoreView = paramViewHandler.handleSetAdapter(view, (IDataAdapter)paramObject, this.mLoadMoreView, this.onClickLoadMoreListener);
      paramViewHandler.setOnScrollBottomListener(view, this.onScrollBottomListener);
    } 
    this.dataAdapter = paramIDataAdapter;
  }
  
  public void setAutoLoadMore(boolean paramBoolean) {
    this.autoLoadMore = paramBoolean;
  }
  
  public void setDataSource(IAsyncDataSource<DATA> paramIAsyncDataSource) {
    this.dataSource = paramIAsyncDataSource;
  }
  
  public void setDataSource(IDataSource<DATA> paramIDataSource) {
    this.dataSource = paramIDataSource;
  }
  
  public void setDataSource(IAsyncTask<DATA> paramIAsyncTask) {
    this.dataSource = (ISuperTask<DATA>)paramIAsyncTask;
  }
  
  public void setDataSource(ITask<DATA> paramITask) {
    this.dataSource = (ISuperTask<DATA>)paramITask;
  }
  
  public void setNeedCheckNetwork(boolean paramBoolean) {
    this.needCheckNetwork = paramBoolean;
  }
  
  public void setOnStateChangeListener(OnLoadMoreStateChangeListener<DATA> paramOnLoadMoreStateChangeListener) {
    this.onStateChangeListener.setOnLoadMoreStateChangeListener(paramOnLoadMoreStateChangeListener);
  }
  
  public void setOnStateChangeListener(OnRefreshStateChangeListener<DATA> paramOnRefreshStateChangeListener) {
    this.onStateChangeListener.setOnRefreshStateChangeListener(paramOnRefreshStateChangeListener);
  }
  
  public void setOnStateChangeListener(OnStateChangeListener<DATA> paramOnStateChangeListener) {
    this.onStateChangeListener.setOnStateChangeListener(paramOnStateChangeListener);
  }
  
  private static class MOnStateChangeListener<DATA> implements OnStateChangeListener<DATA> {
    private OnLoadMoreStateChangeListener<DATA> onLoadMoreStateChangeListener;
    
    private OnRefreshStateChangeListener<DATA> onRefreshStateChangeListener;
    
    private OnStateChangeListener<DATA> onStateChangeListener;
    
    private MOnStateChangeListener() {}
    
    public void onEndLoadMore(IDataAdapter<DATA> param1IDataAdapter, DATA param1DATA) {
      if (this.onStateChangeListener != null) {
        this.onStateChangeListener.onEndLoadMore(param1IDataAdapter, param1DATA);
      } else if (this.onLoadMoreStateChangeListener != null) {
        this.onLoadMoreStateChangeListener.onEndLoadMore(param1IDataAdapter, param1DATA);
      } 
    }
    
    public void onEndRefresh(IDataAdapter<DATA> param1IDataAdapter, DATA param1DATA) {
      if (this.onStateChangeListener != null) {
        this.onStateChangeListener.onEndRefresh(param1IDataAdapter, param1DATA);
      } else if (this.onRefreshStateChangeListener != null) {
        this.onRefreshStateChangeListener.onEndRefresh(param1IDataAdapter, param1DATA);
      } 
    }
    
    public void onStartLoadMore(IDataAdapter<DATA> param1IDataAdapter) {
      if (this.onStateChangeListener != null) {
        this.onStateChangeListener.onStartLoadMore(param1IDataAdapter);
      } else if (this.onLoadMoreStateChangeListener != null) {
        this.onLoadMoreStateChangeListener.onStartLoadMore(param1IDataAdapter);
      } 
    }
    
    public void onStartRefresh(IDataAdapter<DATA> param1IDataAdapter) {
      if (this.onStateChangeListener != null) {
        this.onStateChangeListener.onStartRefresh(param1IDataAdapter);
      } else if (this.onRefreshStateChangeListener != null) {
        this.onRefreshStateChangeListener.onStartRefresh(param1IDataAdapter);
      } 
    }
    
    public void setOnLoadMoreStateChangeListener(OnLoadMoreStateChangeListener<DATA> param1OnLoadMoreStateChangeListener) {
      this.onLoadMoreStateChangeListener = param1OnLoadMoreStateChangeListener;
    }
    
    public void setOnRefreshStateChangeListener(OnRefreshStateChangeListener<DATA> param1OnRefreshStateChangeListener) {
      this.onRefreshStateChangeListener = param1OnRefreshStateChangeListener;
    }
    
    public void setOnStateChangeListener(OnStateChangeListener<DATA> param1OnStateChangeListener) {
      this.onStateChangeListener = param1OnStateChangeListener;
    }
  }
  
  public static interface OnScrollBottomListener {
    void onScorllBootom();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\MVCHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
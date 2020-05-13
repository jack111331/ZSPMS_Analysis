package com.litesuits.orm.db.assit;

import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.log.OrmLog;

public class Transaction {
  private static final String TAG = "Transaction";
  
  public static <T> T execute(SQLiteDatabase paramSQLiteDatabase, Worker<T> paramWorker) {
    paramSQLiteDatabase.beginTransaction();
    OrmLog.i(TAG, "----> BeginTransaction");
    try {
      paramWorker = (Worker<T>)paramWorker.doTransaction(paramSQLiteDatabase);
      try {
        paramSQLiteDatabase.setTransactionSuccessful();
        Worker<T> worker1 = paramWorker;
        if (OrmLog.isPrint) {
          OrmLog.i(TAG, "----> Transaction Successful");
          worker1 = paramWorker;
        } 
      } catch (Exception null) {}
    } catch (Exception exception) {
      paramWorker = null;
    } finally {}
    exception.printStackTrace();
    Worker<T> worker = paramWorker;
  }
  
  public static interface Worker<T> {
    T doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\Transaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
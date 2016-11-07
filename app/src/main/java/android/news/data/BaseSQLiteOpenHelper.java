package android.news.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yue10017 on 2016/10/26.
 * 数据库建设类
 */

public class BaseSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hello_db";
    private static final int DATABASE_VERSION = 1;
    private static final String DB_CREATE = "create table " + DATABASE_NAME + "if not exist";

    private SQLiteDatabase db;


    public BaseSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void open(){
        if (db == null || db.isOpen()){
            db = getReadableDatabase();
        }
    }

    public void close(){
        if (db != null){
            db.close();
            db = null;
        }
    }
}

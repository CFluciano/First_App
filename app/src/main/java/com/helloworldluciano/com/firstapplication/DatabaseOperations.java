package com.helloworldluciano.com.firstapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.helloworldluciano.com.firstapplication.TableData.TableInfo;

import java.awt.font.TextAttribute;
import java.io.File;

public class DatabaseOperations extends SQLiteOpenHelper{

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ TableData.TableInfo.TABLE_NAME + "("+ TableData.TableInfo.ID_NEWS_PK+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ TableData.TableInfo.NEWS+" TEXT);";
    public String DROP_TABLE_1 = "DROP TABLE "+ TableData.TableInfo.TABLE_NAME;

    public DatabaseOperations (Context context) {

        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("databaseOperations", "Database created");
    }

    public void onCreate (SQLiteDatabase sdb)
    {
        sdb.execSQL(CREATE_QUERY);
        Log.d("databaseOperations", "Table created");
    }

    public void onUpgrade (SQLiteDatabase arg0, int arg1, int arg2)
    {
    }

    public void putInformation(DatabaseOperations dop,String news)
    {
        SQLiteDatabase SQ = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put (TableInfo.ID_NEWS_PK,key_news);
        cv.put(TableInfo.NEWS, news);
        long k = SQ.insert(TableInfo.TABLE_NAME,null,cv);
        Log.d("databaseOperations", "One row insert");
    }

    public Cursor getAllData () {
        SQLiteDatabase SQ = this.getWritableDatabase();
        Cursor C = SQ.rawQuery("select * from " + TableInfo.TABLE_NAME,null);
        return C;
    }
}

package com.helloworldluciano.com.firstapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class NewsListActivity extends ActionBarActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseOperations databaseOperations;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list_layout);
        listView = (ListView)findViewById(R.id.news_list);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        databaseOperations = new DatabaseOperations(getApplicationContext());
        sqLiteDatabase = databaseOperations.getReadableDatabase();
        cursor = databaseOperations.getNews(sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            do {
                String id_news,date_news,news;
                id_news = cursor.getString(0);
                date_news = cursor.getString(1);
                news = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(id_news,date_news,news);
                listDataAdapter.add(dataProvider);
            }while (cursor.moveToNext());
        }
    }


}

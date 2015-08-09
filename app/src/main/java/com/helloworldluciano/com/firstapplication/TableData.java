package com.helloworldluciano.com.firstapplication;

import android.provider.BaseColumns;

/**
 * Created by pappa on 04/08/2015.
 */
public class TableData {

    public TableData()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String ID_NEWS_PK = "id_news_pk";
        public static final String NEWS = "news";
        public static final String DATABASE_NAME = "cf_news";
        public static final String TABLE_NAME = "news_list";
    }
}

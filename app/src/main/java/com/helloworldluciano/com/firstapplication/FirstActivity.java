package com.helloworldluciano.com.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FirstActivity extends ActionBarActivity {
    EditText KEY_NEWS,NEWS;
    String key_news,news;
    Button REG;
    Button OUT;
    Button DEL;
    Button LISTE_ALLES;
    Context ctx = this;

    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getBaseContext(), "On create ", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        //KEY_NEWS = (EditText) findViewById(R.id.key_news);
        NEWS = (EditText) findViewById(R.id.news);
        //LISTE_ALLES = (Button) findViewById(R.id.list);
        REG = (Button) findViewById(R.id.insert);
        OUT = (Button) findViewById(R.id.out);
        //DEL = (Button) findViewById(R.id.del);
        addData();
        //viewAll();
        endApp();
    }
    public void addData() {
        REG.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
               //key_news = KEY_NEWS.getText().toString();
               news = NEWS.getText().toString();
                   if (news == null){
                       Toast.makeText(getBaseContext(), "Nicht ", Toast.LENGTH_LONG).show();
                   }
                   else {
                       //if (!(Integer.parseInt(key_news)))
                       //
                       //   Toast.makeText(getBaseContext(),"nicht richtich",Toast.LENGTH_LONG).show();
                       //   KEY_NEWS.setText("");
                       //
                       //else
                       //{
                       DatabaseOperations DB = new DatabaseOperations(ctx);
                       DB.putInformation(DB, news);
                       Toast.makeText(getBaseContext(), "OK!! ", Toast.LENGTH_LONG).show();
                       //KEY_NEWS.setText("");
                       NEWS.setText("");
                   }
               }
           }
        );
    }

    public void viewAll() {
        LISTE_ALLES.setOnClickListener(new View.OnClickListener() {

               public DatabaseOperations DB = new DatabaseOperations(ctx);
               public void onClick(View v) {
                   Cursor C = DB.getAllData();
                   if (C.getCount() == 0) {
                       showMessage("Error", "leere Tabelle");
                   } else {
                       StringBuffer buffer = new StringBuffer();
                       while (C.moveToNext()) {
                           buffer.append("Id: " + C.getString(0));
                           buffer.append("cat_news: " + C.getString(1) + "\n");
                           buffer.append("date_news: " + C.getString(2) + "\n");
                           buffer.append("news_title: " + C.getString(3) + "\n");
                           buffer.append("news: " + C.getString(4) + "\n");
                           buffer.append("flag_read: " + C.getString(5) + "\n");
                           buffer.append("flag_delete: " + C.getString(6) + "\n");
                           buffer.append("flag_remember: " + C.getString(7) + "\n");
                           buffer.append("mark: " + C.getString(8) + "\n\n");
                       }
                       showMessage("Data", buffer.toString());
                   }
               }
           }
        );
    }

    public void showMessage(String id, String news) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(id);
        builder.setMessage(news);
        builder.show();
    }
    public void endApp () {
        OUT.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       finish();
                                   }
                               }
        );
    }
    public void viewNews (View view){
        Toast.makeText(getBaseContext(), "View News ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,NewsListActivity.class);
        startActivity(intent);

    }
}
/*      message_text = (EditText) findViewById(R.id.typing_message);
        String message = message_text.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MESSAGE_KEY,message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

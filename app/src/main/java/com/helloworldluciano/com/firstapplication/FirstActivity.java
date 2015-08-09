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


public class FirstActivity extends ActionBarActivity {
    EditText KEY_NEWS,NEWS;
    String key_news,news;
    Button REG;
    Button OUT;
    Button LISTE_ALLES;
    Context ctx = this;
//    public final static String MESSAGE_KEY="com.helloworldluciano.com.firstapplication.message_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        //KEY_NEWS = (EditText) findViewById(R.id.key_news);
        NEWS = (EditText) findViewById(R.id.news);
        LISTE_ALLES = (Button) findViewById(R.id.list);
        REG = (Button) findViewById(R.id.insert);
        OUT = (Button) findViewById(R.id.out);
        addData();
        viewAll();
        endApp();
    }
    public String DROP_TABLE_1 = "DROP TABLE "+ TableData.TableInfo.TABLE_NAME;
    public void addData() {
        REG.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //key_news = KEY_NEWS.getText().toString();
               news = NEWS.getText().toString();
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
               //}
           }
       }
        );
    }
    public void endApp () {
        OUT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        }
        );
    }

    public void viewAll() {
        LISTE_ALLES.setOnClickListener(new View.OnClickListener() {

               DatabaseOperations DB = new DatabaseOperations(ctx);
               public void onClick(View v) {
                   Cursor C = DB.getAllData();
                   if (C.getCount() == 0) {
                       showMessage("Error", "leere Tabelle");
                   } else {
                       StringBuffer buffer = new StringBuffer();
                       while (C.moveToNext()) {
                           buffer.append("Id: " + C.getString(0) + "\n");
                           buffer.append("News: " + C.getString(1) + "\n\n");
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

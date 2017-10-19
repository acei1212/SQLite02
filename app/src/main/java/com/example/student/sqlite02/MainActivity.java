package com.example.student.sqlite02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    Phone[] p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        PhoneDAO dao = new PhoneDAODBImpl(MainActivity.this);
        p = dao.getList();
        String str[] = new String[p.length];
        for (int i=0;i<p.length;i++)
        {
            str[i] = p[i].name + "," + p[i].tel + "," + p[i].addr;
        }
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, str);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int id = p[position].id;
                Intent it = new Intent(MainActivity.this, DetialActivity.class);
                it.putExtra("id", id);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(MainActivity.this, AddActivity.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }

//    public void click1(View v)
//    {
//        Phone p = new Phone();
//        p.name = "BBB";
//        p.tel = "123";
//        p.addr = "aabb";
//        add(p);
//        Phone p1 = getOne(1);
//
//
//    }

//    public void add(Phone p) {
//        MyHelper helper = new MyHelper(MainActivity.this);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("name", p.name);
//        cv.put("tel", p.tel);
//        cv.put("addr", p.addr);
//        db.insert("phone", null, cv);
//        db.close();
//    }
//
//    public Phone getOne(int id)
//    {
//        Phone p = new Phone();
//        MyHelper helper = new MyHelper(MainActivity.this);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        Cursor c = db.query("phone", new String[]{"id", "name", "tel", "addr"},
//                "id=?", new String[]{String.valueOf(id)}, null, null, null);
//        c.moveToFirst();
//        p.id = c.getInt(0);
//        p.name = c.getString(1);
//        p.tel = c.getString(2);
//        p.addr = c.getString(3);
//        db.close();
//        return p;
//
//    }


}

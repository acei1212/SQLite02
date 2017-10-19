package com.example.student.sqlite02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by student on 2017/10/18.
 */

public class PhoneDAODBImpl implements PhoneDAO {
    MyHelper helper;

    public PhoneDAODBImpl(Context context) {
        helper = new MyHelper(context);

    }

    @Override
    public void clearAll() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from phone");
        db.close();
    }

    @Override
    public Phone[] getList(){
        SQLiteDatabase db = helper.getWritableDatabase();
        ArrayList<Phone> mylist = new ArrayList();
        Cursor c = db.query("phone", new String[] {"id","name","tel","addr"}, null, null, null, null, null);
        if (c.moveToFirst()){
            do {
                Phone p = new Phone();
                p.id = c.getInt(0);
                p.name = c.getString(1);
                p.tel = c.getString(2);
                p.addr = c.getString(3);
                mylist.add(p);
            }while(c.moveToNext());
        }
        Phone rValue[] = mylist.toArray(new Phone[mylist.size()] );
        return rValue;
    }


    @Override
    public void addOne(Phone p) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", p.name);
        cv.put("tel", p.tel);
        cv.put("addr", p.addr);

        db.insert("phone", null, cv);
        db.close();
    }

    @Override
    public Phone getOne(int id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Phone p = new Phone();
        Cursor c = db.query("phone", new String[] {"id","name","tel","addr"}, "id=?", new String[] {String.valueOf(id)}, null, null, null);
        c.moveToFirst();
        p.id = c.getInt(0);
        p.name = c.getString(1);
        p.tel = c.getString(2);
        p.addr = c.getString(3);
        db.close();
        return p;

    }

    @Override
    public void delete(Phone p) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("phone", "id=?", new String[] {String.valueOf(p.id)});
        db.close();
    }

    @Override
    public void update(Phone p)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", p.name);
        cv.put("tel", p.tel);
        cv.put("addr", p.addr);
        db.update("phone", cv, "id=?",new String[] {String.valueOf(p.id)});
        db.close();
    }
}

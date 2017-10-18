package com.example.student.sqlite02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void click1(View v)
    {
        PhoneDAO dao = new PhoneDAODBImpl(AddActivity.this);
        Phone p = new Phone();
        EditText ed1, ed2, ed3;
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        p.name = ed1.getText().toString();
        p.tel = ed2.getText().toString();
        p.addr = ed3.getText().toString();
        dao.addOne(p);
        finish();
    }
}

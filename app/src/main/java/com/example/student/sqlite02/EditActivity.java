package com.example.student.sqlite02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    Phone p;
    EditText ed1,ed2,ed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ed1 = (EditText)findViewById(R.id.editText4);
        ed2 = (EditText)findViewById(R.id.editText5);
        ed3 = (EditText)findViewById(R.id.editText6);
        Intent it = getIntent();
        int id = it.getIntExtra("id", 0);
        PhoneDAO dao = new PhoneDAODBImpl(EditActivity.this);
        p = dao.getOne(id);

        ed1.setText(p.name);
        ed2.setText(p.tel);
        ed3.setText(p.addr);
    }

    public void clickUpdate(View v)
    {
        PhoneDAO dao = new PhoneDAODBImpl(EditActivity.this);
        p.name = ed1.getText().toString();
        p.tel = ed2.getText().toString();
        p.addr = ed3.getText().toString();
        dao.update(p);
        finish();
    }
    public void clickBack(View v)
    {
        finish();
    }
}

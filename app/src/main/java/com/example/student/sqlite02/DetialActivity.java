package com.example.student.sqlite02;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetialActivity extends AppCompatActivity {
    Phone p;
    TextView tvId,tvName,tvTel,tvAddr;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);
        tvId = (TextView) findViewById(R.id.textView);
        tvName = (TextView) findViewById(R.id.textView2);
        tvTel = (TextView) findViewById(R.id.textView3);
        tvAddr = (TextView) findViewById(R.id.textView4);

        Intent it = getIntent();
        id = it.getIntExtra("id",0);


    }

    @Override
    protected void onResume() {
        super.onResume();
        PhoneDAO dao = new PhoneDAODBImpl(DetialActivity.this);
        p = dao.getOne(id);
        tvId.setText(String.valueOf(p.id));
        tvName.setText(p.name);
        tvTel.setText(p.tel);
        tvAddr.setText(p.addr);
    }
    public void clickBack(View v)
    {
        finish();
    }

    public void clickEdit(View v)
    {
        Intent it = new Intent(DetialActivity.this, EditActivity.class);
        it.putExtra("id", p.id);
        startActivity(it);
    }
    public void clickDelete(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetialActivity.this);
        builder.setTitle("確認刪除");
        builder.setMessage("請確認是否刪除本筆資料?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PhoneDAO dao = new PhoneDAODBImpl(DetialActivity.this);
                dao.delete(p);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

}

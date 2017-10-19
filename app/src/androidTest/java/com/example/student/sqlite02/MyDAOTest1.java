package com.example.student.sqlite02;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by student on 2017/10/18.
 */
@RunWith(AndroidJUnit4.class)
public class MyDAOTest1 {
    @Test
    public void addOneDataAndGetTest()
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        PhoneDAODBImpl dao = new PhoneDAODBImpl(appContext);
        Phone p = new Phone();
        p.name = "BBB";
        p.tel = "123";
        p.addr = "aabb";
        dao.addOne(p);

       Phone pArray[] = dao.getList();
        assertEquals("BBB",pArray[0].name);
    }
    @Test
    public void testDelete(){ //測試刪除
        Context appContext = InstrumentationRegistry.getTargetContext();
        PhoneDAODBImpl dao = new PhoneDAODBImpl(appContext);
        Phone p1 = new Phone("CCC","333","CC33");
        Phone p2 = new Phone("DDD","444","DD44");

        dao.clearAll(); //清空全部
        dao.addOne(p1); //新增p1
        dao.addOne(p2); //新增p2
        Phone pArray[] = dao.getList(); //取得清單
        p1.id = pArray[0].id;
        dao.delete(p1); //刪除第0項id
        Phone pArray2[] = dao.getList(); //重新取得清單
        assertEquals("DDD",pArray2[0].name); //確認DDD是否第0項的名字
    }
    @Test
    public void testUpdate() //測試更新
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        PhoneDAODBImpl dao = new PhoneDAODBImpl(appContext);
        Phone p1 = new Phone("CCC", "333", "CC33");

        dao.clearAll(); //清空全部
        dao.addOne(p1); //新增p1
        Phone pArray[] = dao.getList(); //取得清單
        p1.id = pArray[0].id;
        p1.name = "CDE";
        dao.update(p1); //更新p1 name為"CDE"
        Phone pArray2[] = dao.getList(); //重新取得清單
        assertEquals("CDE", pArray2[0].name); //確認第0號name是否為 "CDE"
    }
}

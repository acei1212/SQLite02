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
}

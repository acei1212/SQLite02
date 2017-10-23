package com.example.student.sqlite02;

import java.util.ArrayList;

/**
 * Created by student on 2017/10/23.
 */

public class PhoneDAOMemoryImpl implements PhoneDAO {
    ArrayList<Phone> dataList  = new ArrayList();
    int id =1;



    @Override
    public void clearAll() {
    dataList.clear();
    }

    @Override
    public Phone[] getList() {
        return dataList.toArray(new Phone[dataList.size()]);
    }

    @Override
    public void addOne(Phone p) {
        p.id = this.id;
        this.id++;
        dataList.add(p);
    }

    @Override
    public Phone getOne(int id) {
        Phone rtValue = null;
        for(Phone tmp : dataList)
        {
            if(tmp.id == id)
            {
                rtValue = tmp;
                break;
            }

        }

        return rtValue;
    }

    @Override
    public void delete(Phone p) {
    dataList.remove(p);
    }

    @Override
    public void update(Phone p) {
    for (Phone tmp : dataList)
    {
        if (tmp.id == p.id)
        {
            tmp.name = p.name;
            tmp.tel = p.tel;
            tmp.addr = p.addr;
            break;
        }
    }
    }
}

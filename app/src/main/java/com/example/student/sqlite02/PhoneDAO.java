package com.example.student.sqlite02;

/**
 * Created by student on 2017/10/18.
 */

public interface PhoneDAO {
    public void clearAll();
    public Phone[] getList();
    public void addOne(Phone p);
    public Phone getOne(int id);
    public void delete(Phone p);
    public void update(Phone p);
}

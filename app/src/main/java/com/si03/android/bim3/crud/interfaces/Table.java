package com.si03.android.bim3.crud.interfaces;

public interface Table {
    public boolean save();
    public Table get(int id);
    public boolean delete(int id);
    public boolean update(Table entity);
    public boolean recordExists(int id);
}

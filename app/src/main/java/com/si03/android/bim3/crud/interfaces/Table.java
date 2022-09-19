package com.si03.android.bim3.crud.interfaces;

public interface Table {
    public boolean create();
    public Table get(int id);
    public boolean delete(int id);
    public boolean update(Table entity);
    public boolean recordExists(int id);
}

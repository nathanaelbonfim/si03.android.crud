package com.si03.android.bim3.crud.entities;

import com.si03.android.bim3.crud.interfaces.Table;
import com.si03.android.bim3.crud.libs.Database;

public class Product implements Table {
    private final String TABLE_NAME = "products";
    public Database db;

    public int id;
    public String barcode;
    public String name;
    public int stock;
    public int supplier_id;

    public Product(Database db) {
        this.db = db;
    }

    @Override
    public boolean save() {
        String sql = "";

        return false;
    }

    @Override
    public Table get(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Table table) {
        return false;
    }

    @Override
    public boolean recordExists(int id) {
        String sql = String.format("SELECT id FROM %s WHERE id = %i", TABLE_NAME, id);

        return false;
    }
}
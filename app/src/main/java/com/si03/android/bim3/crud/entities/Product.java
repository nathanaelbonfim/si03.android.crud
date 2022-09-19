package com.si03.android.bim3.crud.entities;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.Log;

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
    public boolean create() {
        String sql = "";

        String safeBarcode = DatabaseUtils.sqlEscapeString(barcode);
        String safeName = DatabaseUtils.sqlEscapeString(name);

        sql.concat(String.format(
            "INSERT INTO %s (name, barcode, stock, supplier_id) VALUES (%s, %s, %i, %i)",
                TABLE_NAME, safeName, safeBarcode, stock, supplier_id
        ));

        Cursor result = db.query(sql);

        Log.d("teste", result.toString());
        return false;
    }

    @Override
    public Table get(int id) {
        String sql = "";

        sql.concat(String.format(
                "SELECT * FROM %s WHERE id = %i",
                TABLE_NAME, id
        ));

        Cursor result = db.query(sql);

        Log.d("Teste", result.toString());

        return null;
    }

    public ArrayList<Product> getAll() {
        ArrayList<Product> products = null;

        String sql = "";

        sql.concat(String.format(
                "SELECT * FROM %s",
                TABLE_NAME
        ));


        Cursor cursor = db.query(sql);
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Product product = new Product(null);

            product.id = cursor.getInt(0);
            product.barcode = cursor.getString(1);
            product.name = cursor.getString(2);
            product.stock = cursor.getInt(3);
            product.supplier_id = cursor.getInt(4);

            products.add(product);
        }

        return products;
    }

    @Override
    public boolean delete(int id) {
        String sql = "";

        sql.concat(String.format(
                "DELETE FROM %s WHERE id = %i",
                TABLE_NAME, id
        ));

        Cursor result = db.query(sql);

        Log.d("teste", result.toString());

        return false;
    }

    @Override
    public boolean update(Table table) {
        String sql = "";

        String safeBarcode = DatabaseUtils.sqlEscapeString(barcode);
        String safeName = DatabaseUtils.sqlEscapeString(name);

        sql.concat(String.format(
                "UPDATE %s SET (name = %s, barcode = %s, stock = %i, supplier_id = %i) WHERE id = %i",
                TABLE_NAME, safeName, safeBarcode, stock, supplier_id, id
        ));

        Cursor result = db.query(sql);

        Log.d("teste", result.toString());

        return false;
    }

    @Override
    public boolean recordExists(int id) {
        String sql = String.format("SELECT id FROM %s WHERE id = %i", TABLE_NAME, id);

        Cursor result = db.query(sql);
        Log.d("teste", result.toString());

        return false;
    }
}
package com.si03.android.bim3.crud.entities;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.Log;

import com.si03.android.bim3.crud.interfaces.Table;
import com.si03.android.bim3.crud.libs.Database;

import java.util.ArrayList;

public class Supplier implements Table {
    private final String TABLE_NAME = "suppliers";
    public Database db;

    public int id;
    public String name;
    public String cnpj;
    public int whatsapp;

    public Supplier(Database db) {
        this.db = db;
    }

    @Override
    public boolean create() {
        String sql = "";

        String safeName = DatabaseUtils.sqlEscapeString(name);
        String safeCnpj = DatabaseUtils.sqlEscapeString(cnpj);

        sql = String.format(
                "INSERT INTO %s (name, cnpj, whatsapp) VALUES (%s, %s, %d)",
                TABLE_NAME, safeName, safeCnpj, whatsapp
        );

        Log.e("query: ", sql);

        return db.execSQL(sql);
    }

    @Override
    public Table get(int id) {
        String sql = "";

        sql.concat(String.format(
                "SELECT * FROM %s WHERE id = %d",
                TABLE_NAME, id
        ));

        Cursor result = db.query(sql);

        Log.d("Teste", result.toString());

        return null;
    }

    public ArrayList<Supplier> getAll() {
        ArrayList<Supplier> suppliers = null;

        String sql = "";

        sql.concat(String.format(
                "SELECT * FROM %s",
                TABLE_NAME
        ));

        Cursor cursor = db.query(sql);
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Supplier supplier = new Supplier(null);

            supplier.id = cursor.getInt(0);
            supplier.name = cursor.getString(1);
            supplier.cnpj = cursor.getString(2);
            supplier.whatsapp = cursor.getInt(3);

            suppliers.add(supplier);
        }

        return suppliers;
    }

    @Override
    public boolean delete(int id) {
        String sql = "";

        sql.concat(String.format(
                "DELETE FROM %s WHERE id = %d",
                TABLE_NAME, id
        ));

//        Cursor result = db.query(sql);

        return db.execSQL(sql);

    }

    @Override
    public boolean update(Table table) {
        String sql = "";

        String safeName = DatabaseUtils.sqlEscapeString(name);
        String safeCnpj = DatabaseUtils.sqlEscapeString(cnpj);

        sql.concat(String.format(
                "UPDATE %s SET (name = %s, cnpj = %s, whatsapp = %d) WHERE id = %d",
                TABLE_NAME, safeName, safeCnpj, whatsapp, id
        ));

        return db.execSQL(sql);

    }

    @Override
    public boolean recordExists(int id) {
        String sql = String.format("SELECT id FROM %s WHERE id = %d", TABLE_NAME, id);

        return false;
    }
}
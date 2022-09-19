package com.si03.android.bim3.crud.entities;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.Log;

import com.si03.android.bim3.crud.interfaces.Table;
import com.si03.android.bim3.crud.libs.Database;

public class Supplier implements Table {
    private final String TABLE_NAME = "supplier";
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

        sql.concat(String.format(
                "INSERT INTO %s (name, cnpj, whatsapp) VALUES (%s, %s, %i)",
                TABLE_NAME, safeName, safeCnpj
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

        String safeName = DatabaseUtils.sqlEscapeString(name);
        String safeCnpj = DatabaseUtils.sqlEscapeString(cnpj);

        sql.concat(String.format(
                "UPDATE %s SET (name = %s, cnpj = %s, whatsapp = %i) WHERE id = %i",
                TABLE_NAME, safeName, safeCnpj, whatsapp, id
        ));

        Cursor result = db.query(sql);

        Log.d("teste", result.toString());

        return false;
    }

    @Override
    public boolean recordExists(int id) {
        String sql = String.format("SELECT id FROM %s WHERE id = %i", TABLE_NAME, id);

        return false;
    }
}
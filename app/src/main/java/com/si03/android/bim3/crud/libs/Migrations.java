package com.si03.android.bim3.crud.libs;

public class Migrations {
    public static String initial() {
        return "CREATE TABLE suppliers (\n" +
                "              id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "              name varchar(255) NOT NULL,\n" +
                "              cnpj varchar(14) UNIQUE NOT NULL,\n" +
                "              whatsapp int(14) NOT NULL\n" +
                "            );\n" +
                "\n" +
                "            CREATE TABLE products (\n" +
                "              id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "              barcode varchar(255) NOT NULL,\n" +
                "              name varchar(255) NOT NULL,\n" +
                "              stock int NOT NULL,\n" +
                "              supplier_id integer NOT NULL,\n" +
                "\n" +
                "              FOREIGN KEY (supplyer_id)\n" +
                "              REFERENCES suppliers (id)\n" +
                "                ON UPDATE CASCADE\n" +
                "                ON DELETE CASCADE\n" +
                "            );";
    }
}

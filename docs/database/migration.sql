CREATE TABLE suppliers (
  id integer PRIMARY KEY AUTOINCREMENT,
  name varchar(255) NOT NULL,
  cnpj varchar(14) UNIQUE NOT NULL,
  whatsapp int(14) NOT NULL
);

CREATE TABLE products (
  id integer PRIMARY KEY AUTOINCREMENT,
  barcode varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  stock int NOT NULL,
  supplier_id integer NOT NULL,

  FOREIGN KEY (supplyer_id)
  REFERENCES suppliers (id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

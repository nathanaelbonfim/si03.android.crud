package com.si03.android.bim3.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.si03.android.bim3.crud.entities.Supplier;
import com.si03.android.bim3.crud.libs.Database;

public class ProviderForm extends AppCompatActivity {
    private Database db;
    private Supplier supplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new Database(getApplicationContext());
        supplier = new Supplier(db);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_form);

        Button button = (Button) findViewById(R.id.provider_button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputLayout name = (TextInputLayout) findViewById(R.id.provider_name);
                supplier.name = name.getEditText().getText().toString();

                TextInputLayout cnpj = (TextInputLayout) findViewById(R.id.cnpj);
                supplier.cnpj = cnpj.getEditText().getText().toString();

                TextInputLayout telefone = (TextInputLayout) findViewById(R.id.tel_number);
                supplier.whatsapp = Integer.parseInt((telefone.getEditText().getText().toString()));

                if(supplier.create()){
                    Intent intent = new Intent(getApplicationContext(), Providers.class);
                    startActivity(intent);
                }
            }
        });
    }

}
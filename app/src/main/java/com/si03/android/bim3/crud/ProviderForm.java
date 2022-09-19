package com.si03.android.bim3.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProviderForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_form);
    }
    public void cadastroFornecedor(View view){

        Intent intent = new Intent(this, Providers.class);
        startActivity(intent);
    }
}
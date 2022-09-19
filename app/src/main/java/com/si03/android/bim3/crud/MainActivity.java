package com.si03.android.bim3.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void cadastraFornecedor(View view){

        Intent intent = new Intent(this, ProviderForm.class);
        startActivity(intent);
    }
    public void cadastraProduto(View view){

        Intent intent = new Intent(this, Products.class);
        startActivity(intent);
    }
}
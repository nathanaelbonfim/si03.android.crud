package com.si03.android.bim3.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
    }
    public void cadastrarProduto(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
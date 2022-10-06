package com.example.firstaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstaplication.controller.ProdutoController;
import com.example.firstaplication.dao.ConexaoSQLite;
import com.example.firstaplication.model.Produto;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQLite.getInstancia(this);


        this.btnCadastrarProdutos = (Button) findViewById(R.id.btnCadastrarProdutos);

        this.btnCadastrarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.firstaplication.ActivityProduto.class);
                startActivity(intent);
            }
        });
    }
}
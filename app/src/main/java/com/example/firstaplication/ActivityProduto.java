package com.example.firstaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstaplication.R;
import com.example.firstaplication.controller.ProdutoController;
import com.example.firstaplication.dao.ConexaoSQLite;
import com.example.firstaplication.model.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtIdProduto;
    private EditText edtNomeDoProduto;
    private EditText edtPreco;
    private EditText edtQuantidade;
    private Button btnSalvar;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        edtNomeDoProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtPreco = (EditText) findViewById(R.id.edtPreco);
        edtQuantidade = (EditText) findViewById(R.id.edtQuantidadeProduto);
        btnSalvar = (Button) findViewById(R.id.btnSalvarProduto);

        this.clickNoBotao();
    }

    private void clickNoBotao(){
        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produto = getDadosDoFormulario();

                if(produto != null){

                    ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityProduto.this));
                    long idProduto = produtoController.salvarProduto(produto);

                    if(idProduto > 0){
                        Toast.makeText(ActivityProduto.this, "Produto salvo com sucesso", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ActivityProduto.this, "Erro ao salvar produto", Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(ActivityProduto.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private Produto getDadosDoFormulario(){
        this.produto = null;
        if(!this.edtIdProduto.getText().toString().isEmpty() && !this.edtNomeDoProduto.getText().toString().isEmpty() && !this.edtPreco.getText().toString().isEmpty()
        && !this.edtQuantidade.getText().toString().isEmpty()){
            this.produto = new Produto();
            this.produto.setId(Long.parseLong(edtIdProduto.getText().toString()));
            this.produto.setNome(this.edtNomeDoProduto.getText().toString());
            this.produto.setPreco(Double.parseDouble(this.edtPreco.getText().toString()));
            this.produto.setQuantidade(Integer.parseInt(this.edtQuantidade.getText().toString()));
            return produto;
        }

        return produto;
    }
}
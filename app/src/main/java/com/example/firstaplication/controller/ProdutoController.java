package com.example.firstaplication.controller;

import com.example.firstaplication.dao.ConexaoSQLite;
import com.example.firstaplication.dao.ProdutoDAO;
import com.example.firstaplication.model.Produto;

public class ProdutoController {

    private final ProdutoDAO produtoDAO;


    public ProdutoController(ConexaoSQLite conexaoSQLite) {
        this.produtoDAO = new ProdutoDAO(conexaoSQLite);
    }

    public long salvarProduto(Produto produto){
        return this.produtoDAO.salvar(produto);
    }
}

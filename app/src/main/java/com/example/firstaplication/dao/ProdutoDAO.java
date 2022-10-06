package com.example.firstaplication.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.firstaplication.model.Produto;

public class ProdutoDAO {

    private final ConexaoSQLite conexaoSQLite;


    public ProdutoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvar(Produto produto){
        long id = 0;

        SQLiteDatabase sqLiteDatabase = conexaoSQLite.getWritableDatabase();
        try {


            ContentValues contentValues = new ContentValues();
            contentValues.put("id", produto.getId());
            contentValues.put("nome", produto.getNome());
            contentValues.put("quantidade", produto.getQuantidade());
            contentValues.put("preco", produto.getPreco());

            id = sqLiteDatabase.insert("produto", null, contentValues);
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }
}

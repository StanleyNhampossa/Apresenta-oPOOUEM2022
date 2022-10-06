package com.example.firstaplication.model;

import java.util.Date;

public class Venda {

    private long id;

    private Produto produto;

    private Date data;

    private String cliente;

    public Venda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", produto=" + produto.toString() +
                ", data=" + data +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}

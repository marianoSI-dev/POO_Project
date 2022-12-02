package com.mycompany.tp_poo;


public class Produto {
    private String nomeProduto;
    private String ingredientes;
    private String descricaoProduto;
    private float preco;

    public Produto( String nomeProduto, String ingredientes, String descricaoProduto, float preco) {
        this.nomeProduto = nomeProduto;
        this.ingredientes = ingredientes;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
    }
    
    public Produto(){
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nProduto{" + "\nnomeProduto=" + nomeProduto + ", \ningredientes=" + ingredientes + ", \ndescricaoProduto=" + descricaoProduto + ", \npreco=" + preco + '}';
    }
    
    
}

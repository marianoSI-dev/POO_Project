
package com.mycompany.tp_poo;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private ArrayList<Pedido> ultimosPedidos = new ArrayList();

    public Cliente(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    
    
    public Cliente(){
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpfc() {
        return cpf;
    }

    public void setCpf(String clientId) {
        this.cpf = clientId;
    }

    public ArrayList<Pedido> getUltimosPedidos() {
        return ultimosPedidos;
    }

    public void setUltimosPedidos(ArrayList<Pedido> ultimosPedidos) {
        this.ultimosPedidos = ultimosPedidos;
    } 

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", cpf=" + cpf + ", ultimosPedidos=" + ultimosPedidos + '}';
    }
    
    
    
}

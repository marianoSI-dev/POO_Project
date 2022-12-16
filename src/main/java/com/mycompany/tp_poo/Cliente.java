
package com.mycompany.tp_poo;


public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    
    //questao 10a
    private static int numClientes = 0;
    
    public  Cliente() {
        numClientes++;
    }
    public static int getNumClientes(){
        return numClientes;
    }

    public Cliente(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "\n----------------------------------------------"
             + "\nNOME = " + nome + ""
             + "\nTELEFONE = " + telefone + ""
             + "\nENDEREÇO = " + endereco + ""
             + "\nCPF = " + cpf + '\n'+
               "----------------------------------------------";
    }

    

    
    
    
    
}

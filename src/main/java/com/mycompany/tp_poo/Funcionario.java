
package com.mycompany.tp_poo;


public class Funcionario {
    private String nome;
    private String telefone;
    private String endereco;
    private String cfp;
    private String login;
    private String senha;

    public Funcionario(String nome, String telefone, String endereco, String cfp, String login, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cfp = cfp;
        this.login = login;
        this.senha = senha;
    }
    public Funcionario(){
    
    }
    
    public void alterarLogin(String login){
        this.setLogin(login);
    }
    public void alterarSenha(String login){
        this.setLogin(login);
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

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}

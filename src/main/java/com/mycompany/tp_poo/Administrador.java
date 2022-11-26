package com.mycompany.tp_poo;

public class Administrador extends Funcionario {
    private boolean isAdmin;

    public Administrador(boolean isAdmin, String nome, String telefone, String endereco, String cfp, String login, String senha) {
        super(nome, telefone, endereco, cfp, login, senha);
        this.isAdmin = isAdmin;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
}

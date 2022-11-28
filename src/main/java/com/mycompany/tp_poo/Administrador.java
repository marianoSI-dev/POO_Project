package com.mycompany.tp_poo;

public class Administrador extends Funcionario {
    private boolean isAdmin;

    public Administrador(String nome, String telefone, String endereco, String cfp, String senha, boolean admin) {
        super(nome, telefone, endereco, cfp, senha);
        this.setIsAdmin(admin);
    }

    public Administrador() {
    }

    

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
}

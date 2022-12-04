package com.mycompany.tp_poo;

public class Administrador extends Funcionario {
    private boolean isAdmin;

    public Administrador(String nome, String telefone, String endereco, String cfp, String senha) {
        super(nome, telefone, endereco, cfp, senha);
        this.setIsAdmin(true);
    }

    public Administrador() {
        this.setIsAdmin(true);
    }

    

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Override
    public String toString() {
        return "\nAdmistrador\n{" + "\nnome=" + this.getNome() + ",\ntelefone=" + this.getTelefone() + ",\nendereco=" + this.getEndereco() + ",\ncfp=" + this.getCfp() + ",\nsenha=" + this.getSenha() + ",\nadmin=" + this.isIsAdmin()+'\n' + '}';
    }
    
}

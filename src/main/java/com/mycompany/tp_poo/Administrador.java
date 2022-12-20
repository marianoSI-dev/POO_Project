package com.mycompany.tp_poo;
/**
 * A classe <b>Administrador</b> define um tipo de dado abstrato para a criação da estrutura de classes de contas bancárias.
 * @author mathe
 */
public class Administrador extends Funcionario {
    private boolean isAdmin;
    
    /**
     * Construtor sobrecarregado da classe <b>Administrador</b>.
     * @param nome String que identifica o nome do funcionário.
     * @param telefone String que identifica o telefone do funcionário.
     * @param endereco String que identifica o endereço do funcionário.
     * @param cfp String que identifica o CPF do funcionário.
     * @param senha String que identifica a senha do funcionário.
     */
    public Administrador(String nome, String telefone, String endereco, String cfp, String senha) {
        //Q4
        super(nome, telefone, endereco, cfp, senha);
        this.setIsAdmin(true);
    }
    
    /**
     * Construtor padrão da classe <b>Administrador</b>.
     */
    public Administrador() {
        this.setIsAdmin(true);
    }

    /**
     * Método que acesa o valor contido em isAdmin
     * @return Retorna O valor do atributo isAdmin.
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }
    /**
     * Método que vai definir o valor de isAdmin.
     * @param isAdmin novo valor a ser atribuido.
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    //Q3
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------"+""
             + "\nNOME = " + this.getNome() + ""
             + "\nTELEFONE = " + this.getTelefone() + ""
             + "\nENDEREÇO = " + this.getEndereco() + ""
             + "\nCPF = " + this.getCfp() + ""
             + "\nSENHA = " + this.getSenha() + ""
             + "\nADMINSTRADOR = " + this.isIsAdmin()+'\n' + '\n'+
                "------------------------------------------------------------------------";
    }
    
}

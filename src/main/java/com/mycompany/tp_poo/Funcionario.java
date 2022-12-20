
package com.mycompany.tp_poo;

/**
 * A classe <b>Funcionario</b> define um tipo de dado abstrato para a criação da estrutura de classes de contas bancárias.
 * @author mathe
 */
public class Funcionario {
    private String nome;
    private String telefone;
    private String endereco;
    private String cfp;
    private String senha;

    /**
     * Construtor sobrecarregado da classe <b>Funcionario</b>
     * @param nome String que identifica o nome do funcionario
     * @param telefone String que identifica o telefone do funcionario
     * @param endereco String que identifica o endereco do funcionario
     * @param cfp String que identifica o cpf do funcionario
     * @param senha String que identifica o cpf do funcionario
     */
    public Funcionario(String nome, String telefone, String endereco, String cfp, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cfp = cfp;
        this.senha = senha;
    }
    /**
     * Construtor padrão da classe <b>Funcionario</b>
     */
    public Funcionario(){
    
    }
    
    /**
     * Método que altera o atributo senha do funcionario
     * @param senha nova senha a ser atribuida ao funcionario
     */
    public void alterarSenha(String senha){
        this.setSenha(senha);
    }
    
    /**
     * Método para acessar o nome do funcionário
     * @return retorna a String com o nome do funcionario
     */
    public String getNome() {
        return nome;
    }
    /**
     Método que altera o atributo nome do funcionário.
     * @param nome Novo nome que será atribuido ao Funcionário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Método que irá acessar o telefone do funcionário.
     * @return Retornará a String com o telefone do funcionário.
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Método que altera o atributo telefone do funcionário.
     * @param telefone Novo telefone que será atribuido ao Funcionário.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Método que irá acessar o endereço do funcionário.
     * @return Retornará a String com o endereço do funcionário.
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Método que altera o atributo endereço do funcionário.
     * @param endereco Novo endereço que será atribuido ao Funcionário.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**
     * Método que irá acessar o CPF do funcionário.
     * @return Retornará a String com o CPF do funcionário.
     */
    public String getCfp() {
        return cfp;
    }
    
    /**
     * Método que altera o atributo endereço do funcionário.
     * @param cpf Novo CPF que será atribuido ao Funcionário.
     */ 
    public void setCfp(String cpf) {
        this.cfp = cpf;
    }

    /**
     * Método que irá acessar a senha do funcionário.
     * @return Retornará a String com a senha do funcionário.
     */
    public String getSenha() {
        return senha;
    }
    /**
     * Método que altera o atributo senha do funcionário.
     * @param senha Nova senha que será atribuida ao Funcionário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Q3
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------"
              +"\nNOME = " + nome + ","
             + "\nTELEFONE = " + telefone + ""
             + "\nENDEREÇO = " + endereco + ""
             + "\nCPF = " + cfp + ""
             + "\nSENHA=" + senha +'\n' + '\n'+
            "------------------------------------------------------------------------";
    }

    
    
    
}

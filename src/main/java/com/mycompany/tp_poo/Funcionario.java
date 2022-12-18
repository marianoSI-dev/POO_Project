
package com.mycompany.tp_poo;


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

  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------"
              +"\nNOME = " + nome + ","
             + "\nTELEFONE = " + telefone + ""
             + "\nENDEREÇO = " + endereco + ""
             + "\nCPF = " + cfp + ""
             + "\nSENHA=" + senha +'\n' + '\n'+
            "----------------------------------------------";
    }

    
    
    
}

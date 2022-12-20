
package com.mycompany.tp_poo;

/**
 * A classe <b>Cliente</b> define um tipo de dado abstrato para a criação da estrutura de classes de contas bancárias.
 * @author mathe
 */
public class Cliente{
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    
    //Q10 a - vantagem segurança e encasulamento
    private static int numClientes = 0;
    //Q10 b - vantagem acesso direto e permanencia nos filhos
    protected static int numClientes2 = 0;
    
    /**
     * Construtor padrão da classe <b>Cliente</b>. Ele tem um contador de instancias em sua estrutura.
     */
    public  Cliente() {
        numClientes++;
    }
    
    /**
     * Método que retorna o valor da variavél de classe numClientes.
     * @return Retornará o número de clientes.
     */
    public static int getNumClientes(){
        return numClientes;
    }
    
    /**
     * Construtor sobrecarregado da classe <b>Cliente</b>.
     * @param nome String que identifica o nome do cliente.
     * @param telefone String que identifica o telefone do cliente.
     * @param endereco String que identifica o endereço do cliente.
     * @param cpf String que identifica o CPF do cliente.
     */
    public Cliente(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    
   /**
    * Método para acessar o nome do cliente.
    * @return Retorna nome do cliente.
    */
    public String getNome() {
        return nome;
    }
    /**
     * Método para definir o nome do cliente.
     * @param nome Será repassado String com o nome do cliente a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
    * Método para acessar o telefone do cliente.
    * @return Retorna telefone do cliente.
    */
    public String getTelefone() {
        return telefone;
    }
     /**
     * Método para definir o telefone do cliente
     * @param telefone Será repassado String com o telefone do cliente a ser definido.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Método para acessar o endereço do cliente.
     * @return Retornará o endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Método para definir o endereço do cliente.
     * @param endereco Será repassada string com o endereço do cliente a ser definido.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**
     * Método para acessar o CPF do cliente.
     * @return Retornará o CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * Método para modificar o valor contido em cpf.
     * @param cpf novo valor a ser atribuido à variável.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Q3
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------"
             + "\nNOME = " + nome + ""
             + "\nTELEFONE = " + telefone + ""
             + "\nENDEREÇO = " + endereco + ""
             + "\nCPF = " + cpf + '\n'+
               "------------------------------------------------------------------------";
    }
  
}

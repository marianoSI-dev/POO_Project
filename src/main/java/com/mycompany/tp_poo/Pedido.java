package com.mycompany.tp_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * A classe <b>Pedido</b> define um tipo de dado abstrato para a criação da estrutura de classes de contas bancárias.
 * @author mathe
 */
public class Pedido {
    private static int contador = TP_POO.getMeusPedidos().size();
    private int id;
    private static String[] estadosDoPedido = {"Pedido em preparo", "Pedido a caminho", "Pedido entregue"};
    private String clienteCpf;
    private String dataPedido;
    private String horarioPedido;
    private String estadoDoPedido;
    private String horarioEntrega;
    private String descricaoDetalhada;
    private float valorTotal;
    private ArrayList<Produto> itensDoPedido = new ArrayList();
    
    
    /**
     * Construtor sobrecarregado da classe <b>Pedido</b>.
     * @param cpf String que identifica o CPF do cliente que realizou o pedido.
     * @param estadoDoPedido String que identifica o Estado do Pedido.
     * @param horarioEntrega Identifica o horário de entrega do Pedido.
     * @param descricaoDetalhada String que passa a descrição do pedido.
     * @param valorTotal Variável float que passa o valor total do pedido.
     */
    public Pedido(String cpf, String estadoDoPedido, LocalTime horarioEntrega, String descricaoDetalhada, float valorTotal) {  
        this.clienteCpf = cpf;
        this.dataPedido =  LocalDate.now().toString();
        this.horarioPedido = LocalTime.now().toString();
        this.estadoDoPedido = this.estadosDoPedido[0];
        this.horarioEntrega = LocalTime.now().plusHours(2).toString();
        this.descricaoDetalhada = descricaoDetalhada;
        this.valorTotal = valorTotal;
    }
    /**
     * Construtor padrão da classe <b>Pedido</b>. Ele tem um contador que é incrementado à cada nova instanciação da classe.
     */
    public Pedido(){
       contador++;
    }
    /**
     * Método que irá acessar o valor do contador.
     * @return Retorna o inteiro com valor da váriavel contador.
     */
    public static int getContador() {
        return contador;
    }
    /**
     * Método que irá atribuir valor do contador.
     * @param contador Novo valor a ser atribuido a variável contador.
     */
    public static void setContador(int contador) {
        Pedido.contador = contador;
    }
     /**
     * Método que irá acessar o ID do Pedido.
     * @return Retornará a inteira da variável id.
     */
    public int getId() {
        return id;
    }
    /**
     * Método que altera o atributo id do pedido.
     * @param id Novo id que será atribuido ao pedido.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Método que acessa o atributo de classe que contem os estados possíveis para os pedidos
     * @return Retorna os estados do Pedido.
     */
    public static String[] getEstadosDoPedido() {
        return estadosDoPedido;
    }
    /**
     * Método que irá alterar os Estados possíveis para o Pedido.
     * @param estadosDoPedido Novo estado a ser atribuido ao Pedido.
     */
    public static void setEstadosDoPedido(String[] estadosDoPedido) {
        Pedido.estadosDoPedido = estadosDoPedido;
    }

    /**
     * Método que irá acessar o CPF do Cliente.
     * @return Retornará a String com o CPF do Cliente.
     */
    public String getClienteCpf() {
        return clienteCpf;
    }
    /**
     * Método que altera o atributo endereço do Cliente.
     * @param clienteCpf Seta o CPF do cliente no Pedido.
     */
    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }
    /**
     * Método que irá acessar a Data do Pedido.
     * @return Retornará a String com a data que o pedido foi realizado.
     */
    public String getDataPedido() {
        return dataPedido;
    }
    /**
     * Altera o valor da variável data de cada pedido.
     * @param dataPedido Data em que pedido foi realizado.
     */
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }
    /**
     * Método que irá acessar o horário do pedido.
     * @return Retorna o horário em que o pedido foi realizado.
     */
    public String getHorarioPedido() {
        return horarioPedido;
    }
    /**
     * Método que altera valor da variavel horarioPedido de cada instancia dessa classe.
     * @param horarioPedido Horário em que pedido foi realizado.
     */
    public void setHorarioPedido(String horarioPedido) {
        this.horarioPedido = horarioPedido;
    }
    /**
     * Método que acessa o estado do pedido.
     * @return Estado do pedido.
     */
    public String getEstadoDoPedido() {
        return estadoDoPedido;
    }
    /**
     * Método que define o estado do pedido.
     * @param estadoDoPedido Será repassado o novo Estado do Pedido a ser definido. 
     */
    public void setEstadoDoPedido(String estadoDoPedido) {
        this.estadoDoPedido = estadoDoPedido;
    }
    /**
     * Método que acessa o horário de entrega do pedido.
     * @return Horário de entrega do pedido.
     */
    public String getHorarioEntrega() {
        return horarioEntrega;
    }
    /**
     * Método que define o horário de entrega do pedido.
     * @param horarioEntrega Será repassado o horário de entrega do pedido a ser definido.
     */
    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }
    /**
     * Método que acessa a string de descrição detalhada do pedido.
     * @return A string de descrição detalhada do pedido.
     */
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }
    /**
     * Método que define a descrição detalhada do pedido.
     * @param descricaoDetalhada Repassa a descrição detalhada a ser definida no pedido.
     */
    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }
    /**
     * Método que acessa o valor total do pedido.
     * @return Retorna variável float com o valor total do pedido.
     */
    public float getValorTotal() {
        return valorTotal;
    }
    /**
     * Método que altera o valor total do pedido.
     * @param valorTotal Repassa a variável float com o valor total do pedido a ser definido.
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    /**
     * Método que acessa o valor da variavel itensDoPedido em cada instancia dessa classe.
     * @return 
     */
    public ArrayList<Produto> getItensDoPedido() {
        return itensDoPedido;
    }
    /**
     * Método que altera os itens contidos em cada pedido.
     * @param itensDoPedido 
     */
    public void setItensDoPedido(ArrayList<Produto> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }

    
    //Q3
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------"+""
             + "\nCPF DO CLIENTE = " + clienteCpf + ""
             + "\nID DO PEDIDO = " + id +""
             + "\nDATA DO PEDIDO = " + dataPedido + ""
             + "\nHORA DO PEDIDO = " + horarioPedido + ""
             + "\nESTADO DO PEDIDO = " + estadoDoPedido + ""
             + "\nHORARIO DA ENTREGA = " + horarioEntrega + ""
             + "\nDESCRIÇÃO DETALHADA=" + descricaoDetalhada + ""
             + "\nVALOR TOTAL DO PEDIDO = " + valorTotal + ""
             + "\nITENS DO PEDIDO = " + itensDoPedido +'\n'+ '\n'+
                "------------------------------------------------------------------------";
    }
       
}

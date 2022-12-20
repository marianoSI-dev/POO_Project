package com.mycompany.tp_poo;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import Comparators.ClienteComparator;
import Comparators.PedidoComparator;

/**
 * @author Mariano Carlos Silva 
 */
public class TP_POO {
    
    //Q5
    private static Funcionario funcionariosCadastrados[] = new Funcionario[15];
    //Q8
    private static ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    private static ArrayList<Administrador> administradoresCadastrados = new ArrayList<>();
    //Q8 e Q9
    private static ArrayList<Pedido> meusPedidos = new ArrayList<>();
    private static ArrayList<Produto> meusProdutos = new ArrayList<>();

    
    public static void main(String[] args) throws Exception {
        HandlerJson.openAndReadJson();
        Collections.sort(clientesCadastrados, new ClienteComparator());
        Collections.sort(meusPedidos, new PedidoComparator());
       /*
        EXEMPLO DE LOGINs PRÉ CADASTRADOS:
        
        ADMINSTRADOR:
        CFP: 9999999999
        SENHA: admin
        
        FUNCIONARIO:
        CPF: 1111111111
        SENHA: mariano
        */
       Sistema.login();
    }   
    

    //Q11 
    public static int numClientesEncapsulamento(){
        return Cliente.getNumClientes();
    }
    public static int numClientesProtected(){
        return Cliente.numClientes2;
    }
    
    /**
     * Método para listar todas as intancias da classe <b>Cliente</b> presentes no sistema.
     * @return Retorna o valor contido no arraylist.
     */
    public static ArrayList<Cliente> getClientesCadastrados(){
        return clientesCadastrados;
    }
    
    /**
     * Método para listar todas as intancias da classe <b>Pedido</b> presentes no sistema.
     * @return Retorna o valor contido no arraylist.
     */
    public static ArrayList<Pedido> getMeusPedidos(){
        return meusPedidos;
    }
    
    /**
     * Método para listar todas as intancias da classe <b>Funcionario</b> presentes no sistema.
     * @return Retorna o valor contido no vetor.
     */
    public static Funcionario[] getFuncionariosCadastrados(){
        return funcionariosCadastrados;
    }
    
    /**
     * Método para listar todas as intancias da classe <b>Produto</b> presentes no sistema.
     * @return Retorna o valor contido no arraylist.
     */
    public static ArrayList<Produto> getMeusProdutos(){
        return meusProdutos;
    }
    
    /**
     * Método para listar todas as intancias da classe <b>Administrador</b> presentes no sistema.
     * @return Retorna o valor contido no arraylist.
     */
    public static ArrayList<Administrador> getAdministradoresCadastrados(){
        return administradoresCadastrados;
    }
    
    /**
     * Método para redefinir o valor do arraylist de administradores.
     * @param administradoresCadastrados é o novo conteúdo do arraylist.
     */
    public static void setAdministradoresCadastrados(ArrayList<Administrador> administradoresCadastrados) {
        TP_POO.administradoresCadastrados = administradoresCadastrados;
    }
    /**
     * Método para redefinir o valor do vetor de funcionários.
     * @param funcionariosCadastrados é o novo conteúdo do vetor.
     */
    public static void setFuncionariosCadastrados(Funcionario[] funcionariosCadastrados) {
        TP_POO.funcionariosCadastrados = funcionariosCadastrados;
    }
    /**
     * Método para redefinir o valor do vetor de clientes.
     * @param clientesCadastrados é o novo conteúdo do arraylist.
     */
    public static void setClientesCadastrados(ArrayList<Cliente> clientesCadastrados) {
        TP_POO.clientesCadastrados = clientesCadastrados;
    }
    /**
     * Método para redefinir o valor do vetor de pedidos.
     * @param meusPedidos é o novo conteúdo do arraylist.
     */
    public static void setMeusPedidos(ArrayList<Pedido> meusPedidos) {
        TP_POO.meusPedidos = meusPedidos;
    }
    /**
     * Método para redefinir o valor do vetor de produtos.
     * @param meusProdutos é o novo conteúdo do arraylist.
     */
    public static void setMeusProdutos(ArrayList<Produto> meusProdutos) {
        TP_POO.meusProdutos = meusProdutos;
    }
    
    
}

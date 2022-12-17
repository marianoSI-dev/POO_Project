package com.mycompany.tp_poo;

import java.util.ArrayList;

import com.google.gson.*;
import java.util.Arrays;
import java.util.Collections;


public class TP_POO {
    
    private static Funcionario funcionariosCadastrados[] = new Funcionario[15];
    private static ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    private static ArrayList<Administrador> administradoresCadastrados = new ArrayList<>();
    private static ArrayList<Pedido> meusPedidos = new ArrayList<>();
    private static ArrayList<Produto> meusProdutos = new ArrayList<>();

    
    public static void main(String[] args) throws Exception {
        HandlerJson.openAndReadJson();
        
       //Sistema.deletarFuncionario();
        //Sistema.criarFuncionario();
        //Sistema.criarAdministrador();
        //Sistema.editarEstadoDoPedido();
        //Sistema.login();
        //Sistema.menuFuncionario();
        //questão 12
        Collections.sort(clientesCadastrados);
        Collections.sort(meusPedidos);
        //Sistema.criarFuncionario();
        //Sistema.criarFuncionario();
        //Sistema.criarFuncionario();
        //area de testes
        //Sistema.login();
        //Sistema.estatisticasDoSistema();
        
        //Sistema.menuAdmin();
        Sistema.login(); //JA INCLUI CHAMADAS AO SISTEMA
        //System.out.println(numClientes());
       //Sistema.exibirClientes();
       //Sistema.criarCliente();
       //System.out.println(numClientes());
        //System.out.println("TESTE 1");
        //System.out.println(Arrays.toString(getFuncionariosCadastrados()));
        //System.out.println(getAdministradoresCadastrados());
        //System.out.println("TESTE 2");
        //Sistema.criarAdmistrador();
        //Sistema.exitAndSaveToJSON();
        //Sistema.openAndReadJson();
        //System.out.println(getAdministradoresCadastrados());
        
        
        //Sistema.criarAdmistrador();
        //Sistema.exitAndSaveToJSON();
        //Sistema.exibirClientes();
        //Sistema.editarCliente();
        //Sistema.exibirClientes();
        //Sistema.exibirFuncionarios();
        //Sistema.editarFuncionario();
        //Sistema.exibirFuncionarios();
        //System.out.println(Pedido.getEstadosDoPedido()[2]);
        //Sistema.criarPedido();
        //Sistema.criarPedido();
        //System.out.println(getMeusPedidos());
        //Sistema.editarPedido();
        //Sistema.deletarPedido();
        //System.out.println(getMeusPedidos());
        //Sistema.criarAdmistrador();
        //Sistema.exibirAdminsitradores();
        //Sistema.editarAdmistrador();
        //Sistema.exibirAdminsitradores();
        //Sistema.menuFuncionario();
        //System.out.println(Arrays.toString(funcionariosCadastrados));
        //Sistema.editarFuncionario();
        //System.out.println(Arrays.toString(funcionariosCadastrados));
        //Sistema.criarCliente();
        //Sistema.criarPedido();
        //Sistema.criarPedido();
        //Sistema.criarPedido();
        //Sistema.criarPedido();
        //System.out.println(getClientesCadastrados());
        //System.out.println(getMeusPedidos());
        //System.out.println(getMeusPedidos());
        //System.out.println(getAdministradoresCadastrados());
        //Sistema.criarAdmistrador();
        //Sistema.criarAdmistrador();
        //Sistema.deletarAdministrador();
        //System.out.println(getAdministradoresCadastrados());
        //Sistema.criarProduto();
        
        //Sistema.criarPedido();
        //Sistema.criarPedido();
        //System.out.println(getMeusPedidos());
        //Sistema.editarPedido();
        
        //Sistema.criarPedido();
        //System.out.println(getMeusPedidos());
        //Sistema.editarPedido();
        //System.out.println(getMeusPedidos());
        //System.out.println(getMeusProdutos());
        //Sistema.criarProduto();
        //System.out.println(getMeusProdutos());
        //Sistema.criarPedido();

        //System.out.println(getClientesCadastrados());
        //Sistema.deletarCliente();
        //System.out.println(getClientesCadastrados());

        //Sistema.editarCliente();
        
       // Sistema.criarProduto();
        //Sistema.exibirProdutos();
        
        //Sistema.criarCliente();
        //System.out.println(Arrays.toString(getFuncionariosCadastrados()));
       
    }   
    
    //numero de clientes instanciados
    //QUESTÃO 11
    public static int numClientesEncapsulamento(){
        return Cliente.getNumClientes();
    }
    public static int numClientesProtected(){
        return Cliente.numClientes2;
    }
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public static ArrayList<Pedido> getMeusPedidos() {
        return meusPedidos;
    }

    public static Funcionario[] getFuncionariosCadastrados() {
        return funcionariosCadastrados;
    }

    public static ArrayList<Produto> getMeusProdutos() {
        return meusProdutos;
    }

    public static ArrayList<Administrador> getAdministradoresCadastrados() {
        return administradoresCadastrados;
    }

    public static void setAdministradoresCadastrados(ArrayList<Administrador> administradoresCadastrados) {
        TP_POO.administradoresCadastrados = administradoresCadastrados;
    }

    public static void setFuncionariosCadastrados(Funcionario[] funcionariosCadastrados) {
        TP_POO.funcionariosCadastrados = funcionariosCadastrados;
    }

    public static void setClientesCadastrados(ArrayList<Cliente> clientesCadastrados) {
        TP_POO.clientesCadastrados = clientesCadastrados;
    }

    public static void setMeusPedidos(ArrayList<Pedido> meusPedidos) {
        TP_POO.meusPedidos = meusPedidos;
    }

    public static void setMeusProdutos(ArrayList<Produto> meusProdutos) {
        TP_POO.meusProdutos = meusProdutos;
    }
    
    
}

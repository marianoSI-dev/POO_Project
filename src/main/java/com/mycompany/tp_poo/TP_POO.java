package com.mycompany.tp_poo;

import java.util.ArrayList;

import com.google.gson.*;
import java.util.Arrays;


public class TP_POO {

    private static Funcionario funcionariosCadastrados[] = new Funcionario[15];
    private static ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    private static ArrayList<Administrador> administradoresCadastrados = new ArrayList<>();
    private static ArrayList<Pedido> meusPedidos = new ArrayList<>();
    private static ArrayList<Produto> meusProdutos = new ArrayList<>();
    private static ArrayList<Ids> productsIds = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        

        
        meusProdutos.add(new Produto(0,"Cachorro Quente", "Pão, Salcicha, Batata-palha","Delicioso cachorro quente", (float) 12.00));
        meusProdutos.add(new Produto(1,"Beirute", "Pão Sírio, Bacon, Filé Mignon, Presunto, Requeijão Cremoso, Queijo prato, Tomate, Alface, Maionese","Receita árabe, batata-palha opcional", (float) 25.00));
        meusProdutos.add(new Produto(2,"Esfiha aberta de carne", "Carne moída, Tomate, Cebola, Pimenta","Receita árabe, pimenta opcional", (float) 7.50));
        meusProdutos.add(new Produto(3,"Mini Pizza", "Calabresa, Mussarela, Orégano, Tomate","Ketchup e maionese como acompanhamento", (float) 6.00));
        meusProdutos.add(new Produto(4,"Hambúrguer", "Bife, Alface, Tomate, Queijo, Batata palha, Presunto","Ketchup e maionese como acompanhamento", (float) 10.00));
        meusProdutos.add(new Produto(5, "Esfiha aberta de queijo", "Queijo parmesão, orégano tomate","Receita árabe, tomate é opcional", (float) 7.00));
        meusProdutos.add(new Produto(6,"Esfiha aberta de carne", "Carne moída, queijo parmesão, orégano, tomate","Receita árabe, tomate é opcional", (float) 9.00));
        meusProdutos.add(new Produto(7,"Refrigerante lata", "Item industrializado","Coca-cola 350ml", (float) 3.50));
        meusProdutos.add(new Produto(8,"Refrigerante 2 litros", "Item industrializado","Fanta 2 litros", (float) 10.00));
        
        clientesCadastrados.add(new Cliente("Mariano","88539207","Avenida do Contorno", "13904696629"));
        clientesCadastrados.add(new Cliente("Rubenns","123123412","Avenida do blabla", "23151212412121"));
        clientesCadastrados.add(new Cliente("Joaquim","123345678","Avenida do kkkkkkk", "435234534"));
        
        //area de testes

        //Sistema.login(); //JA INCLUI CHAMADAS AO SISTEMA
        //Sistema.menuAdmin();
        System.out.println(Sistema.createId());
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
    public static int numClientes(){
        return Cliente.getNumClientes();
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

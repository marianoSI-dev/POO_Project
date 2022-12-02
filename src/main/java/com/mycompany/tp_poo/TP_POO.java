package com.mycompany.tp_poo;

import java.util.ArrayList;
import java.util.Arrays;


public class TP_POO {

    private static final Funcionario funcionariosCadastrados[] = new Funcionario[15];
    private static final ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    private static final ArrayList<Administrador> administradoresCadastrados = new ArrayList<>();
    private static final ArrayList<Pedido> meusPedidos = new ArrayList<>();
    private static final ArrayList<Produto> meusProdutos = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        funcionariosCadastrados[0] = new Funcionario("Ana Malu Lorena Nunes","(38) 98383-9442","Rua Do Amparo, 710, Centro","190.880.226-07","bCp4xWgsdu");
        funcionariosCadastrados[1] = new Funcionario("Cláudia Brenda Figueiredo","(38) 99828-1917","Rua Da Glória, 210, Centro","679.717.286-11","QIjscSsm3U");

        
        meusProdutos.add(new Produto("Cachorro Quente", "Pão, Salcicha, Batata-palha","Delicioso cachorro quente", (float) 12.00));
        meusProdutos.add(new Produto("Beirute", "Pão Sírio, Bacon, Filé Mignon, Presunto, Requeijão Cremoso, Queijo prato, Tomate, Alface, Maionese","Receita árabe, batata-palha opcional", (float) 25.00));
        meusProdutos.add(new Produto("Esfiha aberta de carne", "Carne moída, Tomate, Cebola, Pimenta","Receita árabe, pimenta opcional", (float) 7.50));
        meusProdutos.add(new Produto("Mini Pizza", "Calabresa, Mussarela, Orégano, Tomate","Ketchup e maionese como acompanhamento", (float) 6.00));
        meusProdutos.add(new Produto("Hambúrguer", "Bife, Alface, Tomate, Queijo, Batata palha, Presunto","Ketchup e maionese como acompanhamento", (float) 10.00));
        meusProdutos.add(new Produto("Esfiha aberta de queijo", "Queijo parmesão, orégano tomate","Receita árabe, tomate é opcional", (float) 7.00));
        meusProdutos.add(new Produto("Esfiha aberta de carne", "Carne moída, queijo parmesão, orégano, tomate","Receita árabe, tomate é opcional", (float) 9.00));
        meusProdutos.add(new Produto("Refrigerante lata", "Item industrializado","Coca-cola 350ml", (float) 3.50));
        meusProdutos.add(new Produto("Refrigerante 2 litros", "Item industrializado","Fanta 2 litros", (float) 10.00));
        
        //clientesCadastrados.add(new Cliente("Mariano","88539207","Avenida do Contorno", "13904696629"));
        //clientesCadastrados.add(new Cliente("Rubenns","123123412","Avenida do blabla", "23151212412121"));
        //clientesCadastrados.add(new Cliente("Joaquim","123345678","Avenida do kkkkkkk", "435234534"));
        
        //area de testes
        
        //System.out.println(Arrays.toString(funcionariosCadastrados));
        //Sistema.editarFuncionario();
        //System.out.println(Arrays.toString(funcionariosCadastrados));
        //Sistema.criarCliente();
        //Sistema.criarPedido();
        Sistema.criarPedido();
        Sistema.criarPedido();
        //System.out.println(getClientesCadastrados());
        System.out.println(getMeusPedidos());
        //System.out.println(getAdministradoresCadastrados());
        //Sistema.criarAdmistrador();
        //Sistema.criarAdmistrador();
        //Sistema.deletarAdministrador();
        //System.out.println(getAdministradoresCadastrados());
        
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
    
    
    
}

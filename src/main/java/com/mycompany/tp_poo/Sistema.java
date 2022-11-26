package com.mycompany.tp_poo;

import java.util.Scanner;

public class Sistema {

    public Sistema() {
    }
    
    
    public static Cliente criarCliente(){
        Scanner scan = new Scanner(System.in);
        
        Cliente novoCliente = new Cliente();
        System.out.println("Nome completo: ");
        novoCliente.setNome(scan.nextLine());
        System.out.println("Telefone: ");
        novoCliente.setTelefone(scan.nextLine());
        System.out.println("Endereco: ");
        novoCliente.setEndereco(scan.nextLine());
        System.out.println("CPF: ");
        novoCliente.setCpf(scan.nextLine());
        TP_POO.getClientesCadastrados().add(novoCliente);
        return novoCliente;
    }
    
    public static void exibirClientes(){
        System.out.println(TP_POO.getClientesCadastrados());
    }
    
    public static Pedido criarPedido(){
        Pedido novoPedido = new Pedido();
        return novoPedido;
    }
    public static Produto criarProduto(){
        Produto novoProduto = new Produto();
        return novoProduto;
    }
    
    public static Funcionario criarFuncionario(){
        Funcionario novoFuncionario = new Funcionario();
        return novoFuncionario;
    }
   
}

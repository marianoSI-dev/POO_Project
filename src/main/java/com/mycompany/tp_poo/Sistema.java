package com.mycompany.tp_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class Sistema {

    public Sistema() {
    }
    
    //CRUD CLIENTE
    public static void criarCliente(){
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
    }
    
    public static void exibirClientes(){
        System.out.println(TP_POO.getClientesCadastrados());
    }
    public static void editarCliente(){
        Scanner scan = new Scanner(System.in);
        String nome;
        
        System.out.println("Informe o CPF do cliente que deseja editar:");
        nome = (scan.nextLine());
        
        try {
            for(Cliente cliente : TP_POO.getClientesCadastrados()){
                if(cliente.getCpf().equals(nome)){
                    String alteracao;
                    System.out.println("""
                                       O que voce deseja alterar?
                                       1 - Nome
                                       2 - Telefone
                                       3 - Endereco
                                       4 - Cpf:""");
                    alteracao =(scan.nextLine());
                    switch (alteracao) {
                        case "1" -> {
                            String novoNome;
                            System.out.println("Insira o novo nome: ");
                            novoNome = (scan.nextLine());
                            cliente.setNome(novoNome);
                        }
                        case "2" -> {
                            String novoTelefone;
                            System.out.println("Insira o novo telefone: ");
                            novoTelefone = (scan.nextLine());
                            cliente.setTelefone(novoTelefone);
                        }
                        case "3" -> {
                            String novoEndereco;
                            System.out.println("Insira o novo endereço: ");
                            novoEndereco = (scan.nextLine());
                            cliente.setEndereco(novoEndereco);
                        }
                        case "4" -> {
                            String novoCpf;
                            System.out.println("Insira o novo cpf: ");
                            novoCpf = (scan.nextLine());
                            cliente.setCpf(novoCpf);
                        }
                    }
                }
            }
        }
        catch(RuntimeException e) {
            e.getMessage();
        }
        
    }
    public static void deletarCliente(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do cliente que deseja excluir:");
        cpf = (scan.nextLine());
        try{
            for(Cliente cliente : TP_POO.getClientesCadastrados()){
                if(cliente.getCpf().equals(cpf)){
                    TP_POO.getClientesCadastrados().remove(cliente);
                    System.out.println("Cliente removido com sucesso");
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
    } 
    
    //CRUD FUNCIONARIO
    public static void criarFuncionario(){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 15; i++){
            try{
                Funcionario novoFuncionario = new Funcionario();
                System.out.println("Insira o nome do funcionário: ");
                novoFuncionario.setNome((scan.nextLine()));
                System.out.println("Telefone: ");
                novoFuncionario.setTelefone((scan.nextLine()));
                System.out.println("Endereço do novo funcionário:");
                novoFuncionario.setEndereco((scan.nextLine()));
                System.out.println("Cpf: ");
                novoFuncionario.setCfp((scan.nextLine()));
                System.out.println("Senha:");
                novoFuncionario.setSenha((scan.nextLine()));
                TP_POO.getFuncionariosCadastrados()[i]= novoFuncionario;
            }catch (Exception excpt){
                excpt.getMessage();
            }
        }
    }
    
    
    
    
    
    
    
    public static Pedido criarPedido(){
        Scanner scan = new Scanner(System.in);
        Pedido novoPedido = new Pedido();
        
        
        System.out.println("ID do pedido: ");
        novoPedido.setIdPedido(scan.nextLine());
        novoPedido.setDataPedido(LocalDate.now());
        novoPedido.setHorarioPedido(LocalTime.now());
        novoPedido.setEstadoDoPedido("Em preparo");
        novoPedido.setHorarioEntrega(LocalTime.now().plusHours(2));
        System.out.println("Descrição Detalhada: ");
        novoPedido.setDescricaoDetalhada(scan.nextLine());
        System.out.println("Valor total: ");
        novoPedido.setValorTotal(scan.nextFloat());
        TP_POO.getMeusPedidos().add(novoPedido);
        
        return novoPedido;
    }
    public static void exibirPedidos(){
        System.out.println(TP_POO.getMeusPedidos());
    }
    
    
    public static Produto criarProduto(){
        Scanner scan = new Scanner(System.in);
        Produto novoProduto = new Produto();
        
        
        System.out.println("Nome do produto: ");
        novoProduto.setNomeProduto(scan.nextLine());
        System.out.println("Ingredientes: ");
        novoProduto.setIngredientes(scan.nextLine());
        System.out.println("Descrição do produto: ");
        novoProduto.setDescricaoProduto(scan.nextLine());
        System.out.println("Preço do produto: ");
        novoProduto.setPreco(scan.nextFloat());
        TP_POO.getMeusProdutos().add(novoProduto);
        
        return novoProduto;
    }
    public static void exibirProdutos(){
        System.out.println(TP_POO.getMeusProdutos());
    }
    
    
   
}

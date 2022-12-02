package com.mycompany.tp_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
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
        System.out.println("PEDIDO");
        novoCliente.setPedido(criarPedido());
        TP_POO.getClientesCadastrados().add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso");  
    }
    
    public static void exibirClientes(){
        System.out.println(TP_POO.getClientesCadastrados());
    }
    public static void editarCliente(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do cliente que deseja editar:");
        cpf = (scan.nextLine());
        
        try {
            for(Cliente cliente : TP_POO.getClientesCadastrados()){
                if(cliente.getCpf().equals(cpf)){
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
        
        //conta quantas casas estão livres em meu array estatico
        int contador = 0;
        for(int i = 0; i < TP_POO.getFuncionariosCadastrados().length; i++){       
            if(TP_POO.getFuncionariosCadastrados()[i] == null){
                contador++;
            }
        }
        
        if(contador>0){
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
            for(int i = 0; i < TP_POO.getFuncionariosCadastrados().length; i++){
            if(TP_POO.getFuncionariosCadastrados()[i]== null)
            {   
                TP_POO.getFuncionariosCadastrados()[i]= novoFuncionario;
                break;
            } 
        }}else{
            System.out.println("Número máximo de funcionarios cadsatrados atingido. Tente remover algum antes de tentar novamente.");
        }   
    }
    
    public static void exibirFuncionarios(){
        System.out.println(Arrays.toString(TP_POO.getFuncionariosCadastrados()));
    }
    public static void deletarFuncionario(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do funcionário que deseja remover: ");
        cpf = (scan.nextLine());
      
        for(int i = 0; i < TP_POO.getFuncionariosCadastrados().length; i++){
            if(TP_POO.getFuncionariosCadastrados()[i].getCfp().equals(cpf)){   
                TP_POO.getFuncionariosCadastrados()[i] = null;
                System.out.println("Funcionário removido com sucesso!");
                break;
            }
        }
    }
    public static void editarFuncionario(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do funcionário que deseja editar:");
        cpf = (scan.nextLine());
        
        try {
            for(Funcionario funcionario : TP_POO.getFuncionariosCadastrados()){
                if(funcionario.getCfp().equals(cpf)){
                    String alteracao;
                    System.out.println("""
                                       O que voce deseja alterar?
                                       1 - Nome
                                       2 - Telefone
                                       3 - Endereco
                                       4 - Cpf:
                                       5 - Senha""");
                    alteracao =(scan.nextLine());
                    switch (alteracao) {
                        case "1" -> {
                            String novoNome;
                            System.out.println("Insira o novo nome: ");
                            novoNome = (scan.nextLine());
                            funcionario.setNome(novoNome);
                        }
                        case "2" -> {
                            String novoTelefone;
                            System.out.println("Insira o novo telefone: ");
                            novoTelefone = (scan.nextLine());
                            funcionario.setTelefone(novoTelefone);
                        }
                        case "3" -> {
                            String novoEndereco;
                            System.out.println("Insira o novo endereço: ");
                            novoEndereco = (scan.nextLine());
                            funcionario.setEndereco(novoEndereco);
                        }
                        case "4" -> {
                            String novoCpf;
                            System.out.println("Insira o novo cpf: ");
                            novoCpf = (scan.nextLine());
                            funcionario.setCfp(novoCpf);
                        }
                        case "5" -> {
                            String novaSenha;
                            System.out.println("Insira a nova senha: ");
                            novaSenha = (scan.nextLine());
                            funcionario.setSenha(novaSenha);
                        }
                    }
                }
            }
        }
        catch(RuntimeException e) {
            e.getMessage();
        }  
    }
    
    //CRUD Adminstrador:
    public static void criarAdmistrador(){
        Scanner scan = new Scanner(System.in);
        
        Administrador novoAdmin = new Administrador();
        System.out.println("Nome completo: ");
        novoAdmin.setNome(scan.nextLine());
        System.out.println("Telefone: ");
        novoAdmin.setTelefone(scan.nextLine());
        System.out.println("Endereco: ");
        novoAdmin.setEndereco(scan.nextLine());
        System.out.println("CPF: ");
        novoAdmin.setCfp(scan.nextLine());
        System.out.println("Senha: ");
        novoAdmin.setSenha(scan.nextLine());
        TP_POO.getAdministradoresCadastrados().add(novoAdmin);
        System.out.println("Novo Administrador cadastrado com sucesso");   
    }
    
    public static void exbirAdminsitradores(){
        System.out.println(TP_POO.getAdministradoresCadastrados());
    }
    public static void editarAdmistrador(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do admistrador que deseja editar:");
        cpf = (scan.nextLine());
        
        try {
            for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
                if(admin.getCfp().equals(cpf)){
                    String alteracao;
                    System.out.println("""
                                       O que voce deseja alterar?
                                       1 - Nome
                                       2 - Telefone
                                       3 - Endereco
                                       4 - Cpf:
                                       5 - Senha: """);
                    alteracao =(scan.nextLine());
                    switch (alteracao) {
                        case "1" -> {
                            String novoNome;
                            System.out.println("Insira o novo nome: ");
                            novoNome = (scan.nextLine());
                            admin.setNome(novoNome);
                        }
                        case "2" -> {
                            String novoTelefone;
                            System.out.println("Insira o novo telefone: ");
                            novoTelefone = (scan.nextLine());
                            admin.setTelefone(novoTelefone);
                        }
                        case "3" -> {
                            String novoEndereco;
                            System.out.println("Insira o novo endereço: ");
                            novoEndereco = (scan.nextLine());
                            admin.setEndereco(novoEndereco);
                        }
                        case "4" -> {
                            String novoCpf;
                            System.out.println("Insira o novo cpf: ");
                            novoCpf = (scan.nextLine());
                            admin.setCfp(novoCpf);
                        }
                        case "5" -> {
                            String novaSenha;
                            System.out.println("Insira a nova senha: ");
                            novaSenha = (scan.nextLine());
                            admin.setCfp(novaSenha);
                        }
                    }
                }
            }
        }
        catch(RuntimeException e) {
            e.getMessage();
        }
        
    }
    public static void deletarAdministrador(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do administrador que deseja remover:");
        cpf = (scan.nextLine());
        try{
            for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
                if(admin.getCfp().equals(cpf)){
                    TP_POO.getAdministradoresCadastrados().remove(admin);
                    System.out.println("Adminstrador removido com sucesso.");
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
    } 
    
    public static Pedido criarPedido(){
        Scanner scan = new Scanner(System.in);
        Pedido novoPedido = new Pedido();
        float valorTotal = 0;
        boolean controlador = true;
        
        //novoPedido.setId();
        novoPedido.setDataPedido(LocalDate.now());
        novoPedido.setHorarioPedido(LocalTime.now());
        novoPedido.setEstadoDoPedido("Em preparo");
        novoPedido.setHorarioEntrega(LocalTime.now().plusHours(2));
        System.out.println("Descrição Detalhada: ");
        novoPedido.setDescricaoDetalhada(scan.nextLine());
        
        while(controlador){
            Integer produto;
            
            System.out.println("Adicionar produtos ao pedido:\n "
                + "\n1 - Cachorro Quente"
                + "                 2 - Beirute"
                + "\n3 - Esfiha aberta de carne"
                + "          4 - Mini Pizza"
                + "\n5 - Hambúrguer"
                + "                      6 - Esfiha aberta de queijo"
                + "\n7 - Esfiha aberta de carne"
                + "          8 - Refrigerante lata"
                + "\n9 - Refrigerante 2 litros"
                + "\n10 - ENCERRAR PEDIDO");
            produto =(scan.nextInt());
            switch(produto){
                case 1 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(0)); 
                    valorTotal +=TP_POO.getMeusProdutos().get(0).getPreco();
                }
                case 2 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(1));
                    valorTotal +=TP_POO.getMeusProdutos().get(1).getPreco();
                }
                case 3 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(2));
                    valorTotal +=TP_POO.getMeusProdutos().get(2).getPreco();
                }
                case 4 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(3));
                    valorTotal +=TP_POO.getMeusProdutos().get(3).getPreco();
                }
                case 5 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(4));
                    valorTotal +=TP_POO.getMeusProdutos().get(4).getPreco();
                }
                case 6 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(5));
                    valorTotal +=TP_POO.getMeusProdutos().get(5).getPreco();
                }
                case 7 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(6));
                    valorTotal +=TP_POO.getMeusProdutos().get(6).getPreco();
                }
                case 8 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(7));
                    valorTotal +=TP_POO.getMeusProdutos().get(7).getPreco();
                }
                case 9 -> {
                    novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(8));
                    valorTotal +=TP_POO.getMeusProdutos().get(8).getPreco();
                }
                case 10 -> {
                    controlador = false;
                    break;   
                }
                default ->{
                    System.out.println("Produto inexistente");   
                }
            }
        }
        
        novoPedido.setValorTotal(valorTotal);
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

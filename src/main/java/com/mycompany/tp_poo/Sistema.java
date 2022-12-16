package com.mycompany.tp_poo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;



public class Sistema {

    public Sistema() {
    }
    
    //CRUD CLIENTE
    public static void criarCliente(){
        Scanner scan = new Scanner(System.in);        
        System.out.println("----------CADASTRAR CLIENTE----------");
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
        System.out.println("Cliente cadastrado com sucesso");  
        HandlerJson.saveToJSON();
    }
    
    public static void exibirClientes(){
        System.out.println("----------CLIENTES CADASTRADOS----------");
        System.out.println("Quantidade total: "+ TP_POO.getClientesCadastrados().size()+ " clientes cadastrados no sistema.");
        System.out.println(TP_POO.getClientesCadastrados());
    }
    public static void editarCliente(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        String resposta;
        
        System.out.println("Informe o CPF do cliente que deseja editar:");
        cpf = (scan.nextLine());
        
        try {
            for(Cliente cliente : TP_POO.getClientesCadastrados()){
                if(cliente.getCpf().equals(cpf)){
                    boolean controlador = true;
                    while(controlador){
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
                                HandlerJson.saveToJSON();
                                System.out.println("Nome alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no perfil do cliente? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "2" -> {
                                String novoTelefone;
                                System.out.println("Insira o novo telefone: ");
                                novoTelefone = (scan.nextLine());
                                cliente.setTelefone(novoTelefone);
                                HandlerJson.saveToJSON();
                                System.out.println("Telefone alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no perfil do cliente? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "3" -> {
                                String novoEndereco;
                                System.out.println("Insira o novo endereço: ");
                                novoEndereco = (scan.nextLine());
                                cliente.setEndereco(novoEndereco);
                                HandlerJson.saveToJSON();
                                System.out.println("Endereço alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no perfil do cliente? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "4" -> {
                                String novoCpf;
                                System.out.println("Insira o novo cpf: ");
                                novoCpf = (scan.nextLine());
                                cliente.setCpf(novoCpf);
                                HandlerJson.saveToJSON();
                                System.out.println("Senha alterada com sucesso!\n"
                                    + "Deseja fazer mais alterações no perfil do cliente? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
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
                    HandlerJson.saveToJSON();
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
        HandlerJson.saveToJSON();
    } 
    
    //CRUD FUNCIONARIO
    public static void criarFuncionario(){
        Scanner scan = new Scanner(System.in);
        System.out.println("----------CADASTRAR FUNCIONÁRIO----------");
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
                HandlerJson.saveToJSON();
                break;
            } 
        }}else{
            System.out.println("Número máximo de funcionarios cadsatrados atingido. Tente remover algum antes de tentar novamente.");
        }
        HandlerJson.saveToJSON();
    }
    
    public static void exibirFuncionarios(){
        System.out.println("----------FUNCIONÁRIOS CADASTRADOS----------");
        System.out.println(Arrays.toString(TP_POO.getFuncionariosCadastrados()));
    }
    public static void deletarFuncionario(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        
        System.out.println("Informe o CPF do funcionário que deseja remover: ");
        cpf = (scan.nextLine());
      
        for(int i = 0; i < TP_POO.getFuncionariosCadastrados().length; i++){
            
            if(TP_POO.getFuncionariosCadastrados()[i] != null){
                if(  TP_POO.getFuncionariosCadastrados()[i].getCfp().equals(cpf)){   
                    TP_POO.getFuncionariosCadastrados()[i] = null;
                    System.out.println("Funcionário removido com sucesso!");
                    HandlerJson.saveToJSON();
                break;
                }
            }
        }
        HandlerJson.saveToJSON();
    }
    public static void editarFuncionario(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        String resposta;
        
        System.out.println("Informe o CPF do funcionário que deseja editar:");
        cpf = (scan.nextLine());
        
        try {
            for(Funcionario funcionario : TP_POO.getFuncionariosCadastrados()){
                if(funcionario.getCfp().equals(cpf)){
                    boolean controlador = true;
                    while(controlador){
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
                                HandlerJson.saveToJSON();
                                System.out.println("Nome alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no cadastro do funcionario? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "2" -> {
                                String novoTelefone;
                                System.out.println("Insira o novo telefone: ");
                                novoTelefone = (scan.nextLine());
                                funcionario.setTelefone(novoTelefone);
                                HandlerJson.saveToJSON();
                                System.out.println("Telefone alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no cadastro do funcionario? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "3" -> {
                                String novoEndereco;
                                System.out.println("Insira o novo endereço: ");
                                novoEndereco = (scan.nextLine());
                                funcionario.setEndereco(novoEndereco);
                                HandlerJson.saveToJSON();
                                System.out.println("Endereço alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no cadastro do funcionario? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "4" -> {
                                String novoCpf;
                                System.out.println("Insira o novo cpf: ");
                                novoCpf = (scan.nextLine());
                                funcionario.setCfp(novoCpf);
                                HandlerJson.saveToJSON();
                                System.out.println("CPF alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no cadastro do funcionario? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "5" -> {
                                String novaSenha;
                                System.out.println("Insira a nova senha: ");
                                novaSenha = (scan.nextLine());
                                funcionario.setSenha(novaSenha);
                                HandlerJson.saveToJSON();
                                System.out.println("Senha alterada com sucesso!\n"
                                    + "Deseja fazer mais alterações no cadastro do funcionario? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
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
    public static void criarAdministrador(){
        System.out.println("----------CADASTRAR ADMINISTRADOR----------");
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
        HandlerJson.saveToJSON();
        System.out.println("Novo Administrador cadastrado com sucesso");   
    }
    
    public static void exibirAdministradores(){
        System.out.println("----------ADMISTRADORES CADASTRADOS----------");
        System.out.println("Atualmente o sistema conta com : "+ TP_POO.getAdministradoresCadastrados().size()+ " administradores.");
        System.out.println(TP_POO.getAdministradoresCadastrados());
    }
    public static void editarAdministrador(){
        Scanner scan = new Scanner(System.in);
        String cpf;
        String resposta;
        
        System.out.println("Informe o CPF do administrador que deseja editar:");
        cpf = (scan.nextLine());
        
        try {
            for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
                if(admin.getCfp().equals(cpf)){
                    boolean controlador = true;
                    while(controlador){
                       String alteracao;
                        System.out.println("""
                                           O que voce deseja alterar?
                                           1 - Nome
                                           2 - Telefone
                                           3 - Endereco
                                           4 - Cpf:
                                           5 - Senha: """);
                        System.out.println("Digite a opção: ");
                        alteracao =(scan.nextLine());
                        switch (alteracao) {
                            case "1" -> {
                                String novoNome;
                                System.out.println("Insira o novo nome: ");
                                novoNome = (scan.nextLine());
                                admin.setNome(novoNome);
                                HandlerJson.saveToJSON();
                                System.out.println("Nome alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "2" -> {
                                String novoTelefone;
                                System.out.println("Insira o novo telefone: ");
                                novoTelefone = (scan.nextLine());
                                admin.setTelefone(novoTelefone);
                                HandlerJson.saveToJSON();
                                System.out.println("Telefone alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "3" -> {
                                String novoEndereco;
                                System.out.println("Insira o novo endereço: ");
                                novoEndereco = (scan.nextLine());
                                admin.setEndereco(novoEndereco);
                                HandlerJson.saveToJSON();
                                System.out.println("Endereço alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "4" -> {
                                String novoCpf;
                                System.out.println("Insira o novo cpf: ");
                                novoCpf = (scan.nextLine());
                                admin.setCfp(novoCpf);
                                HandlerJson.saveToJSON();
                                System.out.println("CPF alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            case "5" -> {
                                String novaSenha;
                                System.out.println("Insira a nova senha: ");
                                novaSenha = (scan.nextLine());
                                admin.setSenha(novaSenha);
                                HandlerJson.saveToJSON();
                                System.out.println("Senha alterada com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                                resposta = (scan.nextLine());
                                if(resposta.equals("S")||resposta.equals("s")){
                                    controlador = true;
                                }else if(resposta.equals("N")||resposta.equals("n")){
                                    controlador = false;
                                }else{
                                    System.out.println("Opção inválida");
                                    controlador = false;
                                }
                            }
                            default->{
                                System.out.println("Opção não encontrada");
                            }
                        }
                    }              
                }
            }
        }
        catch(RuntimeException e) {
            e.getMessage();
        }
        HandlerJson.saveToJSON();
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
                    HandlerJson.saveToJSON();
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
        HandlerJson.saveToJSON();
    } 
    
    public static void criarPedido(){
        Scanner scan = new Scanner(System.in);
        float valorTotal = 0;
        boolean controlador = true;
        String cpfPedido;
        Pedido novoPedido = new Pedido();
        
        
        System.out.println("----------CADASTRAR PEDIDO----------");
        System.out.println("Insira o cpf do titular do pedido: ");
        cpfPedido = scan.nextLine();
        for(Cliente cliente : TP_POO.getClientesCadastrados()){
            if(cliente.getCpf().equals(cpfPedido)){
                novoPedido.setClienteCpf(cpfPedido);
                novoPedido.setId(Pedido.getContador());
                novoPedido.setDataPedido(LocalDate.now().toString());
                novoPedido.setHorarioPedido(LocalTime.now().toString());
                novoPedido.setEstadoDoPedido("Em preparo");
                novoPedido.setHorarioEntrega(LocalTime.now().plusHours(2).toString());
                System.out.println("Descrição Detalhada: ");
                novoPedido.setDescricaoDetalhada(scan.nextLine());

                while(controlador){
                    Integer produto;
                    System.out.println("Adicionar produtos ao pedido:\n ");
                    for(Produto produtos : TP_POO.getMeusProdutos()){
                        System.out.println(produtos.getId() +" - "+ produtos.getNomeProduto());
                    }
                    System.out.println("Insira o código do produto que será adicionado ao pedido:");
                    produto =(scan.nextInt());
                    scan.nextLine();
                    for(Produto produtoEscolhido : TP_POO.getMeusProdutos()){
                        String opcao;
                        
                        if(produtoEscolhido.getId() == produto){
                            novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(produto)); 
                            valorTotal +=TP_POO.getMeusProdutos().get(produto).getPreco();
                            HandlerJson.saveToJSON();
                            System.out.println("Item adicionado com sucesso! Deseja adicionar mais itens? [S/N]");
                            opcao = scan.nextLine();
                            if(opcao.equals("S") || opcao.equals("s")){
                                controlador = true;
                            }else if(opcao.equals("N") || opcao.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida. encerrando pedido...");
                                controlador = false;
                                
                            }
                        }
                    }
                }        
                novoPedido.setValorTotal(valorTotal);
                TP_POO.getMeusPedidos().add(novoPedido);
                //break;
            }else if(TP_POO.getClientesCadastrados().indexOf(cliente) == ( TP_POO.getClientesCadastrados().size()-1)){
                System.out.println("Não existe cliente vínculado à esse cpf");
            }
        }
        HandlerJson.saveToJSON();
    }
    public static void exibirPedidos(){
        System.out.println("----------PEDIDOS FEITOS----------");
        System.out.println(TP_POO.getMeusPedidos());
    }
    
    public static void editarPedido(){
        Scanner scan = new Scanner(System.in);
        
        int id;
        String cpf;
        String novaDescricao;
        int opcao;
        String opcao2;
        String resposta;
        
        System.out.println("Informe o id do pedido que deseja alterar: ");
        id = (scan.nextInt());

        
        for(Pedido pedido : TP_POO.getMeusPedidos()){
            if(pedido.getId() == id){
                boolean controlador = true;
                while(controlador){
                    System.out.println("O que você deseja editar no pedido:\n"
                        + "1 - Descrição detalhada\n"
                        + "2 - Atualizar estado do pedido do pedido");
                    opcao = (scan.nextInt());
                    scan.nextLine();
                    switch (opcao) {
                        case 1 -> {

                            System.out.println("Insira a nova descrição: ");
                            novaDescricao = (scan.nextLine());
                            pedido.setDescricaoDetalhada(novaDescricao);
                            System.out.println("Descrição alterada com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                            resposta = (scan.nextLine());
                            if(resposta.equals("S")||resposta.equals("s")){
                                controlador = true;
                            }else if(resposta.equals("N")||resposta.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida");
                                controlador = false;
                            }
                        }
                        case 2 -> {
                            System.out.println("Escolha o novo estado do pedido:\n"
                                    + "1 - Pedido a caminho\n"
                                    + "2 - Pedido entregue ");
                            opcao2 = scan.nextLine();
                            switch(opcao2){
                                case "1" ->{
                                    pedido.setEstadoDoPedido(Pedido.getEstadosDoPedido()[1]);
                                }
                                case "2" ->{
                                    pedido.setEstadoDoPedido(Pedido.getEstadosDoPedido()[2]);
                                }
                                default ->{
                                    System.out.println("Opção inválida.");   
                                }
                            }
                            System.out.println("Descrição alterada com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                            resposta = (scan.nextLine());
                            if(resposta.equals("S")||resposta.equals("s")){
                                controlador = true;
                            }else if(resposta.equals("N")||resposta.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida");
                                controlador = false;
                            }
                        }
                    }
                }
            } 
        }      
    }
    
    public static void deletarPedido(){
        Scanner scan = new Scanner(System.in);
        int id;
        
        System.out.println("Informe o id do pedido que deseja excluir:");
        id = (scan.nextInt());
        try{
            for(Pedido pedido : TP_POO.getMeusPedidos()){
                if(pedido.getId()==id){
                    TP_POO.getMeusPedidos().remove(pedido);
                    System.out.println("Pedido removido com sucesso.");
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
    } 
    
    
    public static void criarId() throws IOException{
        HandlerJson.openAndReadJson();
        Random random = new Random();
        
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i=0; i<TP_POO.getMeusProdutos().size(); i++){
            lista.add(TP_POO.getMeusProdutos().get(i).getId());
        }
        Integer numero = random.nextInt(15);
        while(lista.contains(numero)){
            numero = random.nextInt(15);
        }
        
        System.out.println(lista);
        System.out.println(numero);
    }
    public static Produto criarProduto(){
        Scanner scan = new Scanner(System.in);
        Produto novoProduto = new Produto();
        
        novoProduto.setId(Produto.getContador());
        System.out.println("Nome do produto: ");
        novoProduto.setNomeProduto(scan.nextLine());
        System.out.println("Ingredientes: ");
        novoProduto.setIngredientes(scan.nextLine());
        System.out.println("Descrição do produto: ");
        novoProduto.setDescricaoProduto(scan.nextLine());
        System.out.println("Preço do produto: ");
        novoProduto.setPreco(scan.nextFloat());
        TP_POO.getMeusProdutos().add(novoProduto);
        HandlerJson.saveToJSON();
        
        return novoProduto;
    }
    public static void exibirProdutos(){
        System.out.println("--------------PRODUTOS DISPONÍVEIS HOJE--------------");
        System.out.println("Nosso cardápio conta com um total de : "+ TP_POO.getMeusProdutos().size()+ " produtos.");
        System.out.println(TP_POO.getMeusProdutos());
    }  
    
    public static void editarProduto(){
        Scanner scan = new Scanner(System.in);
        int opcao;
        int id;
        String resposta;
        
        System.out.println("Informe o id do produto que deseja alterar: ");
        id = (scan.nextInt());

        
        for(Produto produto : TP_POO.getMeusProdutos()){
            if(produto.getId() == id){
                boolean controlador = true;
                while(controlador){
                    System.out.println("O que você deseja editar no produto:\n"
                        + "1 - Editar nome do produto\n"
                        + "2 - Editar ingredientes do produto\n"
                        + "3 - Editar descrição detalhada\n"
                        + "4 - Editar preço do produto");
                    System.out.println("Digite a opção desejada: ");
                    opcao = (scan.nextInt());
                    scan.nextLine();
                    switch (opcao){
                        
                        case 1 -> {
                            String novoNome;
                            System.out.println("Insira o novo nome do produto: ");
                            novoNome = (scan.nextLine());
                            produto.setNomeProduto(novoNome);
                            HandlerJson.saveToJSON();
                            System.out.println("Nome alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                            resposta = (scan.nextLine());
                            if(resposta.equals("S")||resposta.equals("s")){
                                controlador = true;
                            }else if(resposta.equals("N")||resposta.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida");
                                controlador = false;
                            }
                        }
                        case 2 -> {
                            String novosIngredientes;
                            System.out.println("Insira os novos ingredientes do produto: ");
                            novosIngredientes = (scan.nextLine());
                            produto.setIngredientes(novosIngredientes);
                            HandlerJson.saveToJSON();
                            System.out.println("Ingredientes alterados com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                            resposta = (scan.nextLine());
                            if(resposta.equals("S")||resposta.equals("s")){
                                controlador = true;
                            }else if(resposta.equals("N")||resposta.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida");
                                controlador = false;
                            }
                        }
                        case 3 -> {
                            String novaDescricao;
                            System.out.println("Insira a nova descrição do produto: ");
                            novaDescricao = (scan.nextLine());
                            produto.setDescricaoProduto(novaDescricao);
                            HandlerJson.saveToJSON();
                            System.out.println("Descrição alterada com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                            resposta = (scan.nextLine());
                            if(resposta.equals("S")||resposta.equals("s")){
                                controlador = true;
                            }else if(resposta.equals("N")||resposta.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida");
                                controlador = false;
                            }
                        }
                        case 4 -> {
                            float novoPreco;
                            System.out.println("Insira o novo preço do produto: ");
                            novoPreco = (scan.nextFloat());
                            produto.setPreco(novoPreco);
                            HandlerJson.saveToJSON();
                            System.out.println("Preço alterado com sucesso!\n"
                                    + "Deseja fazer mais alterações no produto? [S/N]:");
                            scan.nextLine();
                            resposta = (scan.nextLine());
                            if(resposta.equals("S")||resposta.equals("s")){
                                controlador = true;
                            }else if(resposta.equals("N")||resposta.equals("n")){
                                controlador = false;
                            }else{
                                System.out.println("Opção inválida");
                                controlador = false;
                            }
                        } 
                        default ->{
                            System.out.println("Não foi encontrada a opção");
                        }
                    }
                }     
            }
        }
        HandlerJson.saveToJSON();
    }
    
    public static void deletarProduto(){
        Scanner scan = new Scanner(System.in);
        int id;
        
        System.out.println("Informe o id do produto que deseja excluir:");
        id = (scan.nextInt());
        try{
            for(Produto produto : TP_POO.getMeusProdutos()){
                if(produto.getId()==id){
                    TP_POO.getMeusProdutos().remove(produto);
                    System.out.println("Produto removido com sucesso.");
                    HandlerJson.saveToJSON();
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
        HandlerJson.saveToJSON();
    }
    
    public static void login() throws IOException{

        Scanner scan = new Scanner(System.in);
        String cpf;
        String senha;
        String opcao;
        
        System.out.println("\n---------- SEJA BEM VINDO ----------\n");
        System.out.println("Logar como\n"
                + "Adminstrador -> Digite 1\n"
                + "Funcionário  -> Digite 2");
        System.out.println("Opção: ");
        opcao = scan.nextLine();
        
        switch(opcao){
            case "1" -> {
                System.out.println("\n---------- Login como Administrador ----------\n");
                System.out.println("CPF: ");
                cpf = scan.nextLine();
                for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
                    if(admin.getCfp().equals(cpf)){
                        System.out.println("Olá "+ admin.getNome());
                        System.out.println("Digite sua senha: ");
                        senha = scan.nextLine();
                        if(admin.getSenha().equals(senha)){
                            menuAdmin();
                        }else{
                            System.out.println("Senha incorreta.");
                            login();
                            break;
                        }                
                    }else{
                        System.out.println("O CPF informado não foi localizado em nossa base de dados");
                        login();
                    }
                    break;
                }
                
            }
            case "2" -> {
                System.out.println("\n---------- Login como Funcionário ----------\n");
                System.out.println("CPF: ");
                cpf = scan.nextLine();
                for(Funcionario funcionario : TP_POO.getFuncionariosCadastrados()){
                    if(funcionario != null && funcionario.getCfp().equals(cpf) ){
                        System.out.println("Olá "+ funcionario.getNome());
                        System.out.println("Digite sua senha: ");
                        senha = scan.nextLine();
                        if(funcionario.getSenha().equals(senha)){
                            menuFuncionario();
                        }else{
                            System.out.println("Senha incorreta.");
                            login();
                        }
                        //break;
                    }else{
                        System.out.println("O CPF informado não foi localizado em nossa base de dados");
                        login();
                    }
                    break;                  
                }

            }
            default ->{
                System.out.println("Não foi encontrada a opção");
                login();
            }
        }          
    }
    
    
    public static void menuAdmin() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        String opcaoDoSistema;
        String escolha = null;
        System.out.println("\n---------- Logado como: Administrador ----------\n");
        System.out.println("OPÇÕES"
                +"\nREFERENTES AOS CLIENTES: "
                + "\n1 -  Cadastrar novo cliente"
                + "\n2 -  Remover cliente"
                + "\n3 -  Listar clientes"
                + "\n4 -  Editar cliente"
                +"\n"
                +"\nREFERENTES AOS FUNCIONARIOS: "
                + "\n5 -  Cadastrar novo funcionário"
                + "\n6 -  Remover funcionário"
                + "\n7 -  Listar funcionários"
                + "\n8 -  Editar funcionário"
                +"\n"
                +"\nREFERENTES AOS PEDIDOS: "
                + "\n9 -  Cadastrar novo pedido"
                + "\n10 - Remover pedido"
                + "\n11 - Listar produtos pedidos"
                + "\n12 - Editar pedido"
                +"\n"
                +"\nREFERENTES AOS PRODUTOS DA LANCHONETE: "
                + "\n13 - Cadastrar novo produto"
                + "\n14 - Remover produto"
                + "\n15 - Listar produtos disponíveis"
                + "\n16 - Editar produto"
                +"\n"
                +"\nREFERENTES AO PERFIL DE ADMINISTRADOR: "
                +"\n17 - Cadastrar novo Adminstrador"
                +"\n18 - Editar meu perfil de Administrador"
                +"\n19 - Listar todos os Administradores"
                +"\n20 - Remover Administrador"
                + "\n"
                + "\n21 - Encerrar");
                
        System.out.println("Digite a opção desejada: ");
        opcaoDoSistema = scan.nextLine();
        switch(opcaoDoSistema){
            case "1" ->{
                criarCliente();
                continuarNoSistema();               
            }
            case "2"->{
                deletarCliente();
                continuarNoSistema();          
            }
            case "3" ->{
                exibirClientes();
                continuarNoSistema();
            }
            case "4"->{
                editarCliente();
                continuarNoSistema();
            }
            case "5"->{
                criarFuncionario();
                continuarNoSistema();
            }
            case "6"->{
                deletarFuncionario();
                continuarNoSistema();
            }
            case "7"->{
                exibirFuncionarios();
                continuarNoSistema();
            }
            case "8" ->{
                editarFuncionario();
                continuarNoSistema();
            }
            case "9"->{

            }
            case "10"->{
            }
            case "11"->{
            
            }
            case "12"->{
            
            }
            case "13" ->{
                criarProduto();
                continuarNoSistema();
            }
            case "14"->{
                deletarProduto();
                continuarNoSistema();
            }
            case "15"->{
                exibirProdutos();
                continuarNoSistema();
            }
            case "16"->{
                editarProduto();
                continuarNoSistema();
            }
            case "17"->{
                criarAdministrador();
                continuarNoSistema();
            }
            case "18" ->{
                editarAdministrador();
                continuarNoSistema();
            }
            case "19"->{
                exibirAdministradores();
                continuarNoSistema();
            }
            case "20"->{
                deletarAdministrador();
                continuarNoSistema();
            }
            
        }
    }
    public static void continuarNoSistema() throws IOException{
        Scanner scan = new Scanner(System.in);
        String escolha = null;
        System.out.println("""
                           ----------------------------------------------
                                   SUCESSO AO REALIZAR OPERAÇÃO
                                   Permanecer no sistema?
                                   1 - Permancer
                                   2 - Sair do sistema""");
                System.out.println("Digite sua escolha:");
                escolha = scan.nextLine();
                switch(escolha){
                    case "1"->{
                        menuAdmin();
                    }
                    case "2"->{
                        System.out.println("Encerrando o sistema...");
                        HandlerJson.saveToJSON();
                    }
                    default->{
                        System.out.println("Opção inválida, retornando ao sistema...");
                        menuAdmin();
                    }
                }
    }
    public static void menuFuncionario(){
        Scanner scan = new Scanner(System.in);
        String opcao = scan.nextLine();
        System.out.println("\n---------- Logado como: Funcionário ----------\n");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Cadastrar novo Cliente"
                + "\n2 - Remover Cliente"
                + "\n3 - Cadastrar novo funcionário"
                + "\n4 - Remover funcionário"
                + "\n5 - Cadastrar novo lanche"
                + "\n6 - Remover Pedidos"
                + "\n7 - Remover lanche"
                + "\n8 - Listar Clientes"
                + "\n9 - Encerrar Sistema\n"
        );
        System.out.println("Digite a opção desejada: blablabla ");
        opcao = scan.nextLine();
        System.out.println("Vocee escolheu a opcao " + opcao);
    }
}

package com.mycompany.tp_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        System.out.println("PEDIDO");
        TP_POO.getClientesCadastrados().add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso");  
    }
    
    public static void exibirClientes(){
        System.out.println("----------CLIENTE CADASTRADOS----------");
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
                                cliente.setTelefone(novoTelefone);
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
                                cliente.setEndereco(novoEndereco);
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
                                cliente.setCpf(novoCpf);
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
                break;
            } 
        }}else{
            System.out.println("Número máximo de funcionarios cadsatrados atingido. Tente remover algum antes de tentar novamente.");
        }   
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
                                funcionario.setTelefone(novoTelefone);
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
                                funcionario.setEndereco(novoEndereco);
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
                                funcionario.setCfp(novoCpf);
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
                                funcionario.setSenha(novaSenha);
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
        System.out.println("Novo Administrador cadastrado com sucesso");   
    }
    
    public static void exibirAdminsitradores(){
        System.out.println("----------ADMISTRADORES CADASTRADOS----------");
        System.out.println(TP_POO.getAdministradoresCadastrados());
    }
    public static void editarAdmistrador(){
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
                        alteracao =(scan.nextLine());
                        switch (alteracao) {
                            case "1" -> {
                                String novoNome;
                                System.out.println("Insira o novo nome: ");
                                novoNome = (scan.nextLine());
                                admin.setNome(novoNome);
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
                novoPedido.setDataPedido(LocalDate.now());
                novoPedido.setHorarioPedido(LocalTime.now());
                novoPedido.setEstadoDoPedido("Em preparo");
                novoPedido.setHorarioEntrega(LocalTime.now().plusHours(2));
                System.out.println("Descrição Detalhada: ");
                novoPedido.setDescricaoDetalhada(scan.nextLine());

                while(controlador){
                    Integer produto;
                    System.out.println("Adicionar produtos ao pedido:\n ");
                    for(Produto produtos : TP_POO.getMeusProdutos()){
                        System.out.println(produtos.getId() +" - "+ produtos.getNomeProduto());
                    }                   
                    produto =(scan.nextInt());
                    scan.nextLine();
                    for(Produto produtoEscolhido : TP_POO.getMeusProdutos()){
                        String opcao;
                        
                        if(produtoEscolhido.getId() == produto){
                            novoPedido.getItensDoPedido().add(TP_POO.getMeusProdutos().get(produto)); 
                            valorTotal +=TP_POO.getMeusProdutos().get(produto).getPreco();
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
        
        return novoProduto;
    }
    public static void exibirProdutos(){
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
                    opcao = (scan.nextInt());
                    scan.nextLine();
                    switch (opcao){
                        
                        case 1 -> {
                            String novoNome;
                            System.out.println("Insira o novo nome do produto: ");
                            novoNome = (scan.nextLine());
                            produto.setNomeProduto(novoNome);
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
                    System.out.println("Pedido removido com sucesso.");
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
    }
        
    public static void menuFuncionario(){
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Cadastrar Clientes");
        Scanner scan = new Scanner(System.in);
        String opc = scan.nextLine();

        switch (opc) {
            case "1":
                Sistema.criarCliente();
                Sistema.menuFuncionario();
                break;
            default:
                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                Sistema.menuFuncionario();
        }
    }
}

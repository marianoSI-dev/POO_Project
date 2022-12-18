package com.mycompany.tp_poo;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


/**
 * A classe <b>Sistema</b> é a classe responsável por agrupar todas as funcionalidades disponíveis no sistema da lanchonete até o momento. 
 * 
 */
public class Sistema {
    
    /**
     * Construtor padrão da classe <b>Sistema</b>
     */
    public Sistema() {
    }
    public static String cpfLogado;
    public static boolean adminLogado = false;
    public static boolean funcionarioLogado = false;

    
    /**
     * Método para a criação de instancias da classe <b>Cliente</b>.
     */
    public static void criarCliente(){
        
        boolean cpfExiste = false;
        Scanner scan = new Scanner(System.in);        
        System.out.println("----------CADASTRAR CLIENTE----------");
        Cliente novoCliente = new Cliente();
        System.out.printf("Nome completo: ");
        novoCliente.setNome(scan.nextLine());
        System.out.printf("Telefone: ");
        novoCliente.setTelefone(scan.nextLine());
        System.out.printf("Endereco: ");
        novoCliente.setEndereco(scan.nextLine());
        System.out.printf("CPF: ");
        novoCliente.setCpf(scan.nextLine());
        
        for(Cliente cliente : TP_POO.getClientesCadastrados()){
            if(cliente.getCpf().equals(novoCliente.getCpf())){
                cpfExiste = true;
                break;
            }
        }
        
        if(cpfExiste){
            System.out.println("Esse cpf já faz parte de nossa base de dados. Favor verificar.");
            return;
        }
        
        TP_POO.getClientesCadastrados().add(novoCliente);      
        System.out.println("Cliente cadastrado com sucesso");  
        HandlerJson.saveToJSON();
    }
    
    /**
     * Método para listar todas as instancias da classe <b>Cliente</b> armazenadas na base de dados.
     */
    public static void exibirClientes(){
        System.out.println("----------CLIENTES CADASTRADOS----------");
        System.out.println("Quantidade total: "+ TP_POO.getClientesCadastrados().size()+ " clientes cadastrados no sistema.");
        System.out.println(TP_POO.getClientesCadastrados());
    }
    /**
     * Método para editar uma as instancia da classe <b>Cliente</b> deve ser informado o identificador da instancia e, além disso há algumas verificações para validar sua existência.
     */
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
    /**
     * Método para deletar uma as instancia da classe <b>Cliente</b>.Deve ser informado o identificador da instancia para que haja algumas verificações para validar sua existência antes da exclusão.
     */
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
    
    /**
     * Método para a criação de instancias da classe <b>Funcionario</b>.
     */
    public static void criarFuncionario() throws IOException{
        HandlerJson.openAndReadJson();
        
        
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
            boolean cpfExiste = false;
            
            Funcionario novoFuncionario = new Funcionario();
            System.out.printf("Insira o nome do funcionário: ");
            novoFuncionario.setNome((scan.nextLine()));
            System.out.printf("Telefone: ");
            novoFuncionario.setTelefone((scan.nextLine()));
            System.out.printf("Endereço do novo funcionário: ");
            novoFuncionario.setEndereco((scan.nextLine()));
            System.out.printf("Cpf: ");
            novoFuncionario.setCfp((scan.nextLine()));
            for(Funcionario funcionario : TP_POO.getFuncionariosCadastrados()){
                if( funcionario != null && funcionario.getCfp().equals(novoFuncionario.getCfp())){
                    cpfExiste = true;
                    break;
                }
            }
        
            if(cpfExiste){
                System.out.println("Esse cpf já faz parte de nossa base de dados. Favor verificar.");
                return;
            }
            
            System.out.printf("Senha: ");
            novoFuncionario.setSenha((scan.nextLine()));
            for(int i = 0; i < TP_POO.getFuncionariosCadastrados().length; i++){
            if(TP_POO.getFuncionariosCadastrados()[i]== null)
            {   
                TP_POO.getFuncionariosCadastrados()[i]= novoFuncionario;
                HandlerJson.saveToJSON();
                break;
            } 
        }}else{
            System.out.println("Número máximo de funcionarios cadastrados atingido. Tente remover algum antes de tentar novamente.");
        }
        HandlerJson.saveToJSON();
    }
    /**
     * Método para listar todas as instancias da classe <b>Funcionario</b> armazenadas na base de dados.
     */
    public static void exibirFuncionarios(){
        System.out.println("----------FUNCIONÁRIOS CADASTRADOS----------");
        System.out.println(Arrays.toString(TP_POO.getFuncionariosCadastrados()));
    }
    
    /**
     * Método para deletar uma as instancia da classe <b>Funcionario</b>.Deve ser informado o identificador da instancia para que haja algumas verificações que validem sua existência antes da exclusão.
     */
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
    
    /**
     * Método para editar uma as instancia da classe <b>Funcionario</b> deve ser informado o identificador da instancia para que haja algumas verificações que validem sua existência antes da edição.
     */
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
                            default->{
                                System.out.println("Opção inválida");
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
    
    /**
     * Método para a criação de instancias da classe <b>Funcionario</b>.
     */
    public static void criarAdministrador(){
        System.out.println("----------CADASTRAR ADMINISTRADOR----------");
        Scanner scan = new Scanner(System.in);
        boolean cpfExiste = false;
        
        Administrador novoAdmin = new Administrador();
        System.out.printf("Nome completo: ");
        novoAdmin.setNome(scan.nextLine());
        System.out.printf("Telefone: ");
        novoAdmin.setTelefone(scan.nextLine());
        System.out.printf("Endereco: ");
        novoAdmin.setEndereco(scan.nextLine());
        System.out.printf("CPF: ");
        novoAdmin.setCfp(scan.nextLine());
        for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
            if(admin.getCfp().equals(novoAdmin.getCfp())){
                cpfExiste = true;
                break;
            }
        }
        
        if(cpfExiste){
            System.out.println("Esse cpf já faz parte de nossa base de dados. Favor verificar.");
            return;
        }
        System.out.printf("Senha: ");
        novoAdmin.setSenha(scan.nextLine());
        TP_POO.getAdministradoresCadastrados().add(novoAdmin);
        HandlerJson.saveToJSON();
        System.out.printf("Novo Administrador cadastrado com sucesso");   
    }
    
    /**
     * Método para listar todas as instancias da classe <b>Administrador</b> armazenadas na base de dados.
     */
    public static void exibirAdministradores(){
        System.out.println("----------ADMISTRADORES CADASTRADOS----------");
        System.out.println("Atualmente o sistema conta com : "+ TP_POO.getAdministradoresCadastrados().size()+ " administradores.");
        System.out.println(TP_POO.getAdministradoresCadastrados());
    }
    
    /**
     * Método para editar uma as instancia da classe <b>Administrador</b>.Deve ser informado o identificador da instancia para que haja algumas verificações para validar sua existência antes da edição.
     */
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
    
    /**
     * Método para deletar uma instancia da classe <b>Administrador</b>.Deve ser informado o identificador da instancia para que haja algumas verificações que validem sua existência antes da exclusão.
     */
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
    
    /**
     * Método para a criação de instancias da classe <b>Pedido</b>.
     */ 
    public static void criarPedido() throws IOException{
        Scanner scan = new Scanner(System.in);
        float valorTotal = 0;
        boolean controlador = true;
        String cpfPedido;
        Pedido novoPedido = new Pedido();
        

        
        System.out.println("----------CADASTRAR PEDIDO----------");
        System.out.println("Insira o cpf do cliente titular do pedido: ");
        cpfPedido = scan.nextLine();
        
        
        boolean clienteExiste = false;
        for(Cliente cliente : TP_POO.getClientesCadastrados()){
            if(cliente.getCpf().equals(cpfPedido)  ){
                clienteExiste = true;
                break;
            }            
        }
        if(clienteExiste == false){
            System.out.println("Esse cliente não existe em nossa base de dados.");
        }else{
            System.out.println("");
        }
        for(Cliente cliente : TP_POO.getClientesCadastrados()){
            if(cliente.getCpf().equals(cpfPedido)){
                novoPedido.setClienteCpf(cpfPedido);
                novoPedido.setId(criarIdPedido());
                novoPedido.setDataPedido(LocalDate.now().toString());
                novoPedido.setHorarioPedido(LocalTime.now().toString());
                novoPedido.setEstadoDoPedido("Em preparo");
                novoPedido.setHorarioEntrega(LocalTime.now().plusHours(2).toString());
                System.out.println("Descrição Detalhada: ");
                novoPedido.setDescricaoDetalhada(scan.nextLine());

                while(controlador){
                    int produto;
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
                  
                            Produto produtoDoPedido = null;
                            
                            for(int i = 0; i<TP_POO.getMeusProdutos().size();i++){
                                if(TP_POO.getMeusProdutos().get(i).getId() == produtoEscolhido.getId()){
                                    produtoDoPedido = TP_POO.getMeusProdutos().get(i);
                                }
                            }
                            novoPedido.getItensDoPedido().add(produtoDoPedido); 
                            
  
                            valorTotal +=produtoDoPedido.getPreco();
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
                System.out.println(novoPedido);
                TP_POO.getMeusPedidos().add(novoPedido);
                HandlerJson.saveToJSON();
                //break;
            }
        }
        HandlerJson.saveToJSON();
    }
    
    /**
     * Método para listar todas as instancias da classe <b>Pedido</b> armazenadas na base de dados. Esses são os extratos dos pedidos.
     */
    public static void exibirPedidos(){
        System.out.println("----------PEDIDOS FEITOS----------");
        System.out.println(TP_POO.getMeusPedidos());
    }
    
    /**
     * Método para editar uma instancia da classe <b>Pedido</b>.Deve ser informado o identificador da instancia para que haja algumas verificações para validar sua existência antes da edição.
     */
    public static void editarPedido() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        
        int id;
        String cpf;
        String novaDescricao;
        int opcao;
        String opcao2;
        String resposta;

        
        System.out.println("Informe o id do pedido que deseja alterar: ");
        id = (scan.nextInt());
        
        boolean pedidoExiste = false;
        for(Pedido pedido : TP_POO.getMeusPedidos()){
            if(pedido.getId()==id){
                pedidoExiste = true;
                break;
            }            
        }
        if(pedidoExiste == false){
            System.out.println("Não foi localizado no sistema um pedido com o ID informado, favor conferir.");
        }else{
            System.out.println("");
        }

        for(Pedido pedido : TP_POO.getMeusPedidos()){
            if(pedido.getId() == id){
                boolean controlador = true;
                while(controlador){
                    System.out.println("O que você deseja editar no pedido:\n"
                        + "1 - Descrição detalhada\n"
                        + "2 - Atualizar estado do pedido do pedido"
                    );
                    opcao = (scan.nextInt());
                    scan.nextLine();
                    switch (opcao) {
                        case 1 -> {

                            System.out.println("Insira a nova descrição: ");
                            novaDescricao = (scan.nextLine());
                            pedido.setDescricaoDetalhada(novaDescricao);
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
                        case 2 -> {
                            System.out.println("Escolha o novo estado do pedido:\n"
                                    + "1 - Pedido a caminho\n"
                                    + "2 - Pedido entregue ");
                            opcao2 = scan.nextLine();
                            switch(opcao2){
                                case "1" ->{
                                    pedido.setEstadoDoPedido(Pedido.getEstadosDoPedido()[1]);
                                    HandlerJson.saveToJSON();
                                }
                                case "2" ->{
                                    pedido.setEstadoDoPedido(Pedido.getEstadosDoPedido()[2]);
                                    HandlerJson.saveToJSON();
                                }
                                default ->{
                                    System.out.println("Opção inválida.");   
                                }
                            }
                            HandlerJson.openAndReadJson();
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
    
    /**
     * Método para deletar uma instancia da classe <b>Pedido</b>.Deve ser informado o identificador da instancia para que haja algumas verificações que validem sua existência antes da exclusão.
     */
    public static void deletarPedido(){
        Scanner scan = new Scanner(System.in);
        int id;
        
        
        System.out.println("Informe o id do pedido que deseja excluir:");
        id = (scan.nextInt());
        
        boolean pedidoExiste = false;
        for(Pedido pedido : TP_POO.getMeusPedidos()){
            if(pedido.getId()==id){
                pedidoExiste = true;
                break;
            }            
        }
        if(pedidoExiste == false){
            System.out.println("Não foi localizado no sistema um pedido com o ID informado, favor conferir.");
        }else{
            System.out.println("");
        }
        try{
            for(Pedido pedido : TP_POO.getMeusPedidos()){
                if(pedido.getId()==id){
                    TP_POO.getMeusPedidos().remove(pedido);
                    HandlerJson.saveToJSON();
                    System.out.println("Pedido removido com sucesso.");
                }
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
    }
    /**
     * Método para alterar apenas o estado de uma instancia da classe <b>Pedido</b>. O método conta com verificações sobre a existencia do pedido e também para que o estado não possa ser alterado quando o estado for "Entregue".
     * @throws IOException 
     */
    public static void editarEstadoDoPedido() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        
        int id; 
        String opcao2;
        Pedido pedidoModificar = null; 
        
        System.out.println("Informe o id do pedido que deseja alterar o estado: ");
        id = (scan.nextInt());
        scan.nextLine();
        
        boolean pedidoExiste = false;
        for(Pedido pedido : TP_POO.getMeusPedidos()){
            if(pedido.getId()==id){
                pedidoExiste = true;
                pedidoModificar = pedido;
                break;
            }            
        }
        if(pedidoExiste == false){
            System.out.println("Não foi localizado no sistema um pedido com o ID informado, favor conferir.");
            return;
        }else{
            System.out.println("");
        }
        System.out.println("Escolha o novo estado do pedido:\n"
                                    + "1 - Pedido a caminho\n"
                                    + "2 - Pedido entregue ");
        opcao2 = scan.nextLine();
        switch(opcao2){
            case "1" ->{
                if(pedidoModificar.getEstadoDoPedido().equals(Pedido.getEstadosDoPedido()[2])){
                    System.out.println("O pedido em questão já foi entregue");
                    return;
                }
                pedidoModificar.setEstadoDoPedido(Pedido.getEstadosDoPedido()[1]);
                HandlerJson.saveToJSON();
            }
            case "2" ->{
                pedidoModificar.setEstadoDoPedido(Pedido.getEstadosDoPedido()[2]);
                HandlerJson.saveToJSON();
            }
            default ->{
                System.out.println("Opção inválida.");   
            }
        }
    }
    
    /**
     * Método para criação de IDs para instancias de <b>Produto</b> baseado em numeros aleatorios. OBS: O método conta com verificações para que nao haja instancias com mesmo id.
     * @return retorna um numero inteiro que não tenha sido definido com id de outra instancia da mesma classe.
     * @throws IOException 
     */
    public static int criarIdProduto() throws IOException{
        HandlerJson.openAndReadJson();
        Random random = new Random();
        
        ArrayList<Integer> lista = new ArrayList<>();
        for(int i=0; i<TP_POO.getMeusProdutos().size(); i++){
            lista.add(TP_POO.getMeusProdutos().get(i).getId());
        }
        Integer numero = random.nextInt(50);
        while(lista.contains(numero)){
            numero = random.nextInt(50);
        }
        
        return numero;
    }
    /**
     * Método para criação de IDs para instancias de <b>Pedido</b> baseado em numeros aleatorios. OBS: O método conta com verificações para que nao haja instancias com mesmo id.
     * @return retorna um numero inteiro que não tenha sido definido com id de outra instancia da mesma classe.
     * @throws IOException 
     */
    public static int criarIdPedido() throws IOException{
        HandlerJson.openAndReadJson();
        Random random = new Random();
        
        ArrayList<Integer> lista = new ArrayList<>();
        for(int i=0; i<TP_POO.getMeusPedidos().size(); i++){
            lista.add(TP_POO.getMeusPedidos().get(i).getId());
        }
        Integer numero = random.nextInt(50);
        while(lista.contains(numero)){
            numero = random.nextInt(50);
        }
        
        return numero;
    }
    
    /**
     * Método para a criação de instancias da classe <b>Produto</b>.
     * @return o novo produto desde que esteja no formato correto, algo que é verificado.
     * @throws IOException 
     */
    public static Produto criarProduto() throws IOException{
        Scanner scan = new Scanner(System.in);
        Produto novoProduto = new Produto();
        
        novoProduto.setId(criarIdProduto());
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
    /**
     * Método para listar todas as instancias da classe <b>Produto</b> armazenadas na base de dados.
     */
    public static void exibirProdutos(){
        System.out.println("--------------PRODUTOS DISPONÍVEIS HOJE--------------");
        System.out.println("Nosso cardápio conta com um total de : "+ TP_POO.getMeusProdutos().size()+ " produtos.");
        System.out.println(TP_POO.getMeusProdutos());
    }  
    
    /**
     * Método para editar uma as instancia da classe <b>Produto</b>.Deve ser informado o identificador da instancia para que haja algumas verificações para validar sua existência antes da edição.
     */
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
    
    /**
     * Método para deletar uma instancia da classe <b>Produto</b>.Deve ser informado o identificador da instancia para que haja algumas verificações que validem sua existência antes da exclusão.
     */
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
    
    /**
     * Método para que seja possivel entrar no sistema. Deve ser informado o tipo de usuario qu tentará acessar o sistema, após isso é feita uma verificação de credenciais na base de dados caso exista, o menu correspondente ao usuário será invocado e algumas variaveis do sistema serão setadas para que funcione corretamente.
     * @throws IOException 
     */
    public static void login() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        String cpf;
        String senha;
        String opcao;
        
        System.out.println("\n---------- SEJA BEM VINDO ----------\n");
        System.out.println("Logar como\n"
                + "Adminstrador -> Digite 1\n"
                + "Funcionário  -> Digite 2");
        System.out.printf("Opção: ");
        opcao = scan.nextLine();
        
        switch(opcao){
            case "1" -> {
                System.out.println("\n---------- Login como Administrador ----------\n");
                System.out.printf("CPF: ");
                cpf = scan.nextLine();
                boolean adminExiste = false;
                for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
                    if(admin.getCfp().equals(cpf)  ){
                        adminExiste = true;
                        adminLogado = true;
                        break;
                    }            
                }
                if(adminExiste == false){
                    System.out.println("Não existe um administrador com esse cpf em nossa base de dados.");
                    System.out.println("Tente novamente...");
                    login();
                }else{
                    System.out.println("");
                }
                
                for(Administrador admin : TP_POO.getAdministradoresCadastrados()){
                    if(admin.getCfp().equals(cpf)){
                        System.out.println("Olá "+ admin.getNome());
                        System.out.printf("Digite sua senha: ");
                        senha = scan.nextLine();
                        if(admin.getSenha().equals(senha)){
                            cpfLogado = cpf;
                            menuAdmin();
                        }else{
                            System.out.println("Senha incorreta.");
                            login();
                            break;
                        }                
                    }
                    break;
                }
                
            }
            case "2" -> {
                System.out.println("\n---------- Login como Funcionário ----------\n");
                System.out.println("CPF: ");
                cpf = scan.nextLine();
                boolean funcionarioExiste = false;
                for(Funcionario func : TP_POO.getFuncionariosCadastrados()){
                    if(func != null && func.getCfp().equals(cpf)  ){
                        funcionarioExiste = true;
                        break;
                    }            
                }
                if(funcionarioExiste == false){
                    System.out.println("Não existe um funcionário com esse cpf em nossa base de dados.");
                    System.out.println("Tente novamente...");
                    login();
                }else{
                    System.out.println("");
                }
                for(Funcionario funcionario : TP_POO.getFuncionariosCadastrados()){
                    if(funcionario != null && funcionario.getCfp().equals(cpf) ){
                        System.out.println("Olá "+ funcionario.getNome());
                        System.out.printf("Digite sua senha: ");
                        senha = scan.nextLine();
                        if(funcionario.getSenha().equals(senha)){
                            cpfLogado = cpf;
                            funcionarioLogado = true;
                            menuFuncionario();
                        }else{
                            System.out.println("Senha incorreta.");
                            login();
                        }
                    }             
                }
            }
            default ->{
                System.out.println("Não foi encontrada a opção");
                login();
            }
        }  
        return;
    }
    /**
     * Método para que o funcionario consiga editar suas credenciais. No momento que o funcionario esta logado, ao chamar esse método ele conseguirá manipular apenas as suas credenciais.
     * @throws IOException 
     */
    public static void editarCredenciais() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        String resposta;
        

           boolean controlador = true;
           Funcionario funcionario = null;
           for(Funcionario func : TP_POO.getFuncionariosCadastrados()){
               if( func != null && func.getCfp().equals(cpfLogado)){
                   funcionario = func;
                   break;
               }
           }
           while(controlador){
               String alteracao;
               System.out.println("""
                                  O que voce deseja alterar?
                                  1 - Nome
                                  2 - Senha""");
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
                   default->{
                       System.out.println("Opção inválida");
                   }
               }
           }    
    }
    /**
     * Método para exibir as estatísticas de vendas do estabelecimento, ele conta com o valor total arrecadado com as vendas, o número de pedidos realizados e o valor médio dos pedidos.
     * @throws IOException 
     */
    public static void estatisticasDoSistema() throws IOException{
        HandlerJson.openAndReadJson();
        DecimalFormat df = new DecimalFormat("#,###.00");
        
        System.out.println("--------------ESTATÍSTICAS DA LANCHONETE--------------");
        System.out.println("------------------------------------------------------");
        double totalArrecadado = 0;
        int pedidosRealizados = TP_POO.getMeusPedidos().size();
        double valorMedio;
        
        for(Pedido pedido : TP_POO.getMeusPedidos()){
            totalArrecadado += pedido.getValorTotal();
        }
        valorMedio = (totalArrecadado/pedidosRealizados);
        String valorMedioFormatado = df.format(valorMedio);
        
        System.out.println("O TOTAL ARRECADADO COM AS VENDA NO ESTABELECIMENTO FOI DE R$ " + totalArrecadado);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("FORAM REALIZADOS " + pedidosRealizados + " PEDIDOS");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("O VALOR MÉDIO DOS PEDIDOS FEITOS NO ESTABELECIMENTO FOI R$ " + valorMedioFormatado);
        
    }
    /**
     * Método que invoca o menu do administrador do sistema. OBS: Só é acessado após login.
     * @throws IOException 
     */
    public static void menuAdmin() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        String opcaoDoSistema;
        String escolha = null;
        System.out.println("\n------------- LOGADO COMO: Administrador -------------\n");
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
                + "\n11 - Listar pedidos (EXTRATOS)"
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
                +"\n"
                +"\nREFERENTES À ESTATÍSTICAS E INFORMAÇÕES SOBRE VENDAS: "
                +"\n21 - Estatísticas sobre vendas"
                +"\n22 - Buscar pedidos por intervalo"
                +"\n"
                + "\n23 - Encerrar");
                
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
                criarPedido();
                continuarNoSistema();
            }
            case "10"->{
                deletarPedido();
                continuarNoSistema();
            }
            case "11"->{
                exibirPedidos();
                continuarNoSistema();
            }
            case "12"->{
                editarPedido();
                continuarNoSistema();
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
                editarCredenciais();
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
            case "21"->{
                estatisticasDoSistema();
                continuarNoSistema();
            }
            case "22"->{
                
            }
            case "23"->{

            } 
        }
    }
    
    /**
     * Método que invoca o menu do funcionario. OBS: Só é acessado após login.
     * @throws IOException 
     */
    public static void menuFuncionario() throws IOException{
        HandlerJson.openAndReadJson();
        Scanner scan = new Scanner(System.in);
        String opcaoDoSistema;
        System.out.println("\n---------- LOGADO COMO: Funcionário ----------\n");
        System.out.println("OPÇÕES"
                +"\nREFERENTES AOS FUNCIONARIOS: "
                + "\n1 -  Editar minhas credenciais"
                +"\n"
                +"\nREFERENTES AOS PEDIDOS: "
                + "\n2 - Cadastrar novo pedido"
                + "\n3 - Editar estado de um pedido"
                + "\n4 - Remover pedido"
                + "\n5 - Listar pedidos (EXTRATOS)"
                + "\n6 - Editar pedido"
                +"\n"
                +"\nREFERENTES À ESTATÍSTICAS E INFORMAÇÕES SOBRE VENDAS: "
                +"\n7 - Estatísticas sobre vendas"
                +"\n8 - Buscar pedidos por intervalo"
                +"\n"
               + "\n9 - Encerrar");
        System.out.println("Digite a opção desejada: ");
        opcaoDoSistema = scan.nextLine();
        
        switch(opcaoDoSistema){
            case"1"->{
                editarCredenciais();
                continuarNoSistema();
            }
            case"2"->{
                criarPedido();
                continuarNoSistema();
            }
            case"3"->{
                editarEstadoDoPedido();
                continuarNoSistema();
            }
            case"4"->{
                deletarPedido();
                continuarNoSistema();
            }
            case"5"->{
                exibirPedidos();
                continuarNoSistema();
            }
            case"6"->{
                editarPedido();
                continuarNoSistema();
            }
            case"7"->{
                estatisticasDoSistema();
                continuarNoSistema();
            }
            case"8"->{

                continuarNoSistema();
            }
            case"9"->{
                HandlerJson.saveToJSON();
                System.out.println("Saindo do sistema...");
            }
        }
    }
    /**
     * Método que verifica se o usuário, após realizar uma ação deseja permanecer no sistma ou sair dele.
     * @throws IOException 
     */
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
                if(adminLogado){
                    menuAdmin();
                }else if(funcionarioLogado){
                    menuFuncionario();
                }

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
}

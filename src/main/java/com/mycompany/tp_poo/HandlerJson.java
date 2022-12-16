package com.mycompany.tp_poo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HandlerJson {
    
        public static void saveToJSON(){
        Gson gson = new Gson();
        
        
        String admins = gson.toJson(TP_POO.getAdministradoresCadastrados());
        try{
            FileWriter escrever = new FileWriter("src\\main\\java\\Json Archives\\Administradores.json");
            escrever.write(admins);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String funcionarios = gson.toJson(TP_POO.getFuncionariosCadastrados());
        try{
            FileWriter escrever = new FileWriter("src\\main\\java\\Json Archives\\Funcionarios.json");
            escrever.write(funcionarios);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String clientes = gson.toJson(TP_POO.getClientesCadastrados());
        try{
            FileWriter escrever = new FileWriter("src\\main\\java\\Json Archives\\Clientes.json");
            escrever.write(clientes);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String pedidos = gson.toJson(TP_POO.getMeusPedidos());
        try{
            FileWriter escrever = new FileWriter("src\\main\\java\\Json Archives\\Pedidos.json");
            escrever.write(pedidos);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String produtos = gson.toJson(TP_POO.getMeusProdutos());
        try{
            FileWriter escrever = new FileWriter("src\\main\\java\\Json Archives\\Produtos.json");
            escrever.write(produtos);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public static void openAndReadJson() throws IOException{
        Gson gson = new Gson();
                
        File admin = new File("src\\main\\java\\Json Archives\\Administradores.json");
        String admData = new String(Files.readAllBytes(Paths.get(admin.toURI())));
        ArrayList<Administrador> administradores = gson.fromJson(admData, new TypeToken<ArrayList<Administrador>>(){}.getType());
        TP_POO.setAdministradoresCadastrados(administradores);
        
        File funcionario = new File("src\\main\\java\\Json Archives\\Funcionarios.json");
        String funcionarioData = new String(Files.readAllBytes(Paths.get(funcionario.toURI())));
        Funcionario[] funcionarios = gson.fromJson(funcionarioData, new TypeToken<Funcionario[]>(){}.getType());
        TP_POO.setFuncionariosCadastrados(funcionarios);
        
        File cliente = new File("src\\main\\java\\Json Archives\\Clientes.json");
        String clientesData = new String(Files.readAllBytes(Paths.get(cliente.toURI())));
        ArrayList<Cliente> clientes = gson.fromJson(clientesData, new TypeToken<ArrayList<Cliente>>(){}.getType());
        TP_POO.setClientesCadastrados(clientes);
        
        File pedido = new File("src\\main\\java\\Json Archives\\Pedidos.json");
        String pedidosData = new String(Files.readAllBytes(Paths.get(pedido.toURI())));
        ArrayList<Pedido> pedidos = gson.fromJson(pedidosData, new TypeToken<ArrayList<Pedido>>(){}.getType());
        TP_POO.setMeusPedidos(pedidos);
        
        File produto = new File("src\\main\\java\\Json Archives\\Produtos.json");
        String produtosData = new String(Files.readAllBytes(Paths.get(produto.toURI())));
        ArrayList<Produto> produtos = gson.fromJson(produtosData, new TypeToken<ArrayList<Produto>>(){}.getType());
        TP_POO.setMeusProdutos(produtos);      
    }
}

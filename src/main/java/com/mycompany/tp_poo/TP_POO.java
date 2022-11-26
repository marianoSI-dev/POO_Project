

package com.mycompany.tp_poo;

import java.util.ArrayList;


public class TP_POO {

    private static final ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    private static final ArrayList<Pedido> meusPedidos = new ArrayList<>();
    
    public static void main(String[] args) {
        clientesCadastrados.add(new Cliente("Mariano","88539207","Avenida do Contorno", "13904696629"));
        clientesCadastrados.add(new Cliente("Rubenns","123123412","Avenida do blabla", "23151212412121"));
        clientesCadastrados.add(new Cliente("Joaquim","123345678","Avenida do kkkkkkk", "435234534"));
        
        Sistema.criarCliente();
        Sistema.exibirClientes();
    }   

    public static ArrayList<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }
    
}

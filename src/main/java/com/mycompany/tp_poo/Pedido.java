package com.mycompany.tp_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pedido {
    private static int contador;
    private int id;
    private static String[] estadosDoPedido = {"Pedido em preparo", "Pedido a caminho", "Pedido entregue"};
    private String clienteCpf;
    private String dataPedido;
    private String horarioPedido;
    private String estadoDoPedido;
    private String horarioEntrega;
    private String descricaoDetalhada;
    private float valorTotal;
    private ArrayList<Produto> itensDoPedido = new ArrayList();

    public Pedido(String cpf, String estadoDoPedido, LocalTime horarioEntrega, String descricaoDetalhada, float valorTotal) {  
        this.clienteCpf = cpf;
        this.dataPedido =  LocalDate.now().toString();
        this.horarioPedido = LocalTime.now().toString();
        this.estadoDoPedido = this.estadosDoPedido[0];
        this.horarioEntrega = LocalTime.now().plusHours(2).toString();
        this.descricaoDetalhada = descricaoDetalhada;
        this.valorTotal = valorTotal;
    }
    public Pedido(){
       contador++;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pedido.contador = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String[] getEstadosDoPedido() {
        return estadosDoPedido;
    }

    public static void setEstadosDoPedido(String[] estadosDoPedido) {
        Pedido.estadosDoPedido = estadosDoPedido;
    }

    
    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalTime getHorarioPedido() {
        return horarioPedido;
    }

    public void setHorarioPedido(LocalTime horarioPedido) {
        this.horarioPedido = horarioPedido;
    }

    public String getEstadoDoPedido() {
        return estadoDoPedido;
    }

    public void setEstadoDoPedido(String estadoDoPedido) {
        this.estadoDoPedido = estadoDoPedido;
    }

    public LocalTime getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(LocalTime horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Produto> getItensDoPedido() {
        return itensDoPedido;
    }

    public void setItensDoPedido(ArrayList<Produto> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }

    

    @Override
    public String toString() {
        return "\nPedido{"+"\nCPF do cliente =" + clienteCpf + "\nidPedido=" + id +"\ndataPedido=" + dataPedido + ", \nhorarioPedido=" + horarioPedido + ", \nestadoDoPedido=" + estadoDoPedido + ", \nhorarioEntrega=" + horarioEntrega + ", \ndescricaoDetalhada=" + descricaoDetalhada + ", \nvalorTotal=" + valorTotal + ", \nitensDoPedido=" + itensDoPedido +'\n'+ '}';
    }
    
}

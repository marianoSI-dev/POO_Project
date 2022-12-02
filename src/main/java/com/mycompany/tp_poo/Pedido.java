package com.mycompany.tp_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pedido {

    private int id;
    private LocalDate dataPedido;
    private LocalTime horarioPedido;
    private String estadoDoPedido;
    private LocalTime horarioEntrega;
    private String descricaoDetalhada;
    private float valorTotal;
    private ArrayList<Produto> itensDoPedido = new ArrayList();

    public Pedido(String estadoDoPedido, LocalTime horarioEntrega, String descricaoDetalhada, float valorTotal) {      
        this.dataPedido =  LocalDate.now();
        this.horarioPedido = LocalTime.now();
        this.estadoDoPedido = "Em preparo";
        this.horarioEntrega = LocalTime.now().plusHours(2);
        this.descricaoDetalhada = descricaoDetalhada;
        this.valorTotal = valorTotal;
    }
    public Pedido(){
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "\nPedido{"+ "\nidPedido=" + id +"\ndataPedido=" + dataPedido + ", \nhorarioPedido=" + horarioPedido + ", \nestadoDoPedido=" + estadoDoPedido + ", \nhorarioEntrega=" + horarioEntrega + ", \ndescricaoDetalhada=" + descricaoDetalhada + ", \nvalorTotal=" + valorTotal + ", \nitensDoPedido=" + itensDoPedido +'\n'+ '}';
    }

    
    
    
}

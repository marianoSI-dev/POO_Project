/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparators;
import com.mycompany.tp_poo.Pedido;
import java.util.Comparator;

public class PedidoComparator implements Comparator<Pedido>{
    public int compare(Pedido p1, Pedido p2){
        return (int) (p1.getValorTotal() - p2.getValorTotal());
    }
}

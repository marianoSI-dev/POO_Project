
package Comparators;
import com.mycompany.tp_poo.Pedido;
import java.util.Comparator;
//Q12
public class PedidoComparator implements Comparator<Pedido>{
    
    public int compare(Pedido p1, Pedido p2){
        return (int) (p1.getValorTotal() - p2.getValorTotal());
    }
}

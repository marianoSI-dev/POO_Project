
package Comparators;
import com.mycompany.tp_poo.Cliente;
import java.util.Comparator;
//Q12
public class ClienteComparator implements Comparator<Cliente>{
    @Override
    public int compare(Cliente c1, Cliente c2){
        return c1.getCpf().compareTo(c2.getCpf());
    }
}

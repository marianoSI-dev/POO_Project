/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparators;
import com.mycompany.tp_poo.Cliente;
import java.util.Comparator;
public class ClienteComparator implements Comparator<Cliente>{
    @Override
    public int compare(Cliente c1, Cliente c2){
        return c1.getCpf().compareTo(c2.getCpf());
    }
}

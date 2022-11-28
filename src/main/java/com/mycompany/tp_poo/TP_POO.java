package com.mycompany.tp_poo;

import java.util.ArrayList;
import java.util.Arrays;


public class TP_POO {

    private static final Funcionario funcionariosCadastrados[] = new Funcionario[15];
    private static final ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    private static final ArrayList<Pedido> meusPedidos = new ArrayList<>();
    private static final ArrayList<Produto> meusProdutos = new ArrayList<>();
    
    public static void main(String[] args) {
        funcionariosCadastrados[0] = new Funcionario("Ana Malu Lorena Nunes","(38) 98383-9442","Rua Do Amparo, 710, Centro","190.880.226-07","bCp4xWgsdu");
        funcionariosCadastrados[1] = new Funcionario("Cláudia Brenda Figueiredo","(38) 99828-1917","Rua Da Glória, 210, Centro","679.717.286-11","QIjscSsm3U");
        funcionariosCadastrados[2] = new Funcionario("Daniela Tânia Campos","(38) 98218-4861","Rua Paula Vieira, 776, Presidente","596.240.456-40","7TUKtkbOBJ");
        funcionariosCadastrados[3] = new Funcionario("Sabrina Rebeca Viana","(38) 98439-9915","Rua Teófilo Otoni, 30, Centro","035.300.376-05","hXDtlcLcHa");
        funcionariosCadastrados[4] = new Funcionario("Débora Isabela Patrícia Lima","(38) 98768-3153","Praça Vicente de Paula Fonseca, 86, Centro ","802.375.036-46","PG069nQQ5U");
        funcionariosCadastrados[5] = new Funcionario("Mariane Tânia Baptista","(38) 99383-8949","Avenida do Contorno, 102, Bela Vista","641.058.116-57","TBcY1NcdB8");
        funcionariosCadastrados[6] = new Funcionario("Juliana Simone Benedita Oliveira","(38) 99437-5019","Rua Macau do Meio, 32, Centro","635.920.446-05","2oPAHMEpQQ");
        funcionariosCadastrados[7] = new Funcionario("Eloá Vanessa Sophia Duarte","(38) 98894-7732","Rua Macau de Baixo, 33, Centro","863.927.196-87","0r1ULOlUqr");
        funcionariosCadastrados[8] = new Funcionario("Laís Luzia Araújo","(38) 98498-1140","Rua Macau de Cima, 34, Centro","029.495.666-26","leSa6hX37G");
        funcionariosCadastrados[9] = new Funcionario("Pietra Raquel Brito","(38) 99699-7144","Praça Conselheiro Matta, 56, Centro","709.182.366-49","J5O8sc6ufz");
        funcionariosCadastrados[10] = new Funcionario("Juan Tomás Gael da Silva","(38) 99276-8059","Beco da Tecla, 31, Centro","696.116.146-40","GOGkyA2bAS");
        funcionariosCadastrados[11] = new Funcionario("Giovanna Andreia Barros","(38) 99968-0975","Rua Abílio Barreto, 24, Rio Grande","413.736.686-10","F1C0oITY6h");
        funcionariosCadastrados[12] = new Funcionario("Levi Kevin Mateus Corte Real","(38) 99224-8069","Rua Imperatriz, 21, Jardim Imperial","162.900.786-23","j8uyx3mcQ3");
        funcionariosCadastrados[13] = new Funcionario("Alana Evelyn Alessandra Silveira","(38) 99134-6024","Rua Flávia, 650, Pedra Grande","922.588.406-00","DmaBiaMco8");
        funcionariosCadastrados[14] = new Funcionario("Daniela Sophia Eliane da Paz","(38) 99909-4465","Rua Antonio das Graças Nascimento, 54, Bela Vista","005.326.736-20","28rGyXjHbC");
        
        
        meusProdutos.add(new Produto("Cachorro Quente", "Pão, Salcicha, Batata-palha","Delicioso cachorro quente", (float) 12.00));
        meusProdutos.add(new Produto("Beirute", "Pão Sírio, Bacon, Filé Mignon, Presunto, Requeijão Cremoso, Queijo prato, Tomate, Alface, Maionese","Receita árabe, batata-palha opcional", (float) 25.00));
        meusProdutos.add(new Produto("Esfiha aberta de carne", "Carne moída, Tomate, Cebola, Pimenta","Receita árabe, pimenta opcional", (float) 7.50));
        meusProdutos.add(new Produto("Mini Pizza", "Calabresa, Mussarela, Orégano, Tomate","Ketchup e maionese como acompanhamento", (float) 6.00));
        meusProdutos.add(new Produto("Hambúrguer", "Bife, Alface, Tomate, Queijo, Batata palha, Presunto","Ketchup e maionese como acompanhamento", (float) 10.00));
        meusProdutos.add(new Produto("Esfiha aberta de queijo", "Queijo parmesão, orégano tomate","Receita árabe, tomate é opcional", (float) 7.00));

        clientesCadastrados.add(new Cliente("Mariano","88539207","Avenida do Contorno", "13904696629"));
        clientesCadastrados.add(new Cliente("Rubenns","123123412","Avenida do blabla", "23151212412121"));
        clientesCadastrados.add(new Cliente("Joaquim","123345678","Avenida do kkkkkkk", "435234534"));
        
        //area de testes
        
        System.out.println(Arrays.toString(funcionariosCadastrados));
        Sistema.criarFuncionario();
        System.out.println(Arrays.toString(funcionariosCadastrados));
        
        
        
        
        //System.out.println(getClientesCadastrados());
        //Sistema.deletarCliente();
        //System.out.println(getClientesCadastrados());
        
        
        
        //Sistema.editarCliente();
        
       // Sistema.criarProduto();
        //Sistema.exibirProdutos();
        
        //Sistema.criarCliente();
        //System.out.println(Arrays.toString(getFuncionariosCadastrados()));
       
    }   
    
    //numero de clientes instanciados
    public static int numClientes(){
        return Cliente.getNumClientes();
    }
    public static ArrayList<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public static ArrayList<Pedido> getMeusPedidos() {
        return meusPedidos;
    }

    public static Funcionario[] getFuncionariosCadastrados() {
        return funcionariosCadastrados;
    }

    public static ArrayList<Produto> getMeusProdutos() {
        return meusProdutos;
    }
    
    
    
}

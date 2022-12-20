package com.mycompany.tp_poo;

/**
 * A classe <b>Produto</b> define um tipo de dado abstrato para a criação da estrutura de classes de contas bancárias.
 * @author mathe
 */
public class Produto {
    private static int contador = TP_POO.getMeusProdutos().size();
    private int id;
    private String nomeProduto;
    private String ingredientes;
    private String descricaoProduto;
    private float preco;
    
    /**
     * Construtor sobrecarregado da classe <b>Produto</b>.
     * @param id Inteira que identifica o ID do Produto.
     * @param nomeProduto String que identifica o nome do Produto.
     * @param ingredientes String que identifica os ingradientes do Produto.
     * @param descricaoProduto String que identifica a descrição detalhada do Produto.
     * @param preco Variável do tipo float que identifica o preço do Produto.
     */
    public Produto( int id, String nomeProduto, String ingredientes, String descricaoProduto, float preco) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.ingredientes = ingredientes;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
    }
    /**
     * Construtor padrão da classe <b>Produto</b>. Ele tem um contador de instancias em sua estrutura.
     */
    public Produto(){
        contador++;
    }
    /**
     * Método que irá acessar o valor do contador.
     * @return Retorna o inteiro com valor da váriavel contador.
     */
    public static int getContador() {
        return contador;
    }
    /**
     * Método que irá atribuir valor do contador.
     * @param contador Novo valor a ser atribuido a variável contador.
     */
    public static void setContador(int contador) {
        Produto.contador = contador;
    }
    /**
     * Método que irá acessar o valor do ID do produto.
     * @return Retornará o ID deste procuto.
     */
    public int getId() {
        return id;
    }
    /**
     * Método que irá definir o ID do produto.
     * @param id Será repassado o ID do produto a ser definido.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Método que irá acessar o nome do produto.
     * @return Retornará o nome deste procuto.
     */
    public String getNomeProduto() {
        return nomeProduto;
    }
    /**
     * Método que irá definir o nome do produto.
     * @param nomeProduto Será repassado o nome do produto a ser definido.
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    /**
     * Método que irá acessar os ingradientes do produto.
     * @return Retornará os ingradientes deste procuto.
     */ 
    public String getIngredientes() {
        return ingredientes;
    }
    /**
     * Método que irá definir os ingredientes do produto.
     * @param ingredientes Serão repassados os ingradientes a serem definidos.
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    /**
     * Método que irá acessar a descrição do produto.
     * @return Retornará a descrição deste procuto.
     */ 
    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    /**
     * Método que irá definir a descrição do produto.
     * @param descricaoProduto Será repassado a descrição do produto a ser definida.
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    /**
     * Método que irá acessar o preço do produto.
     * @return Retornará o preço desse produto.
     */
    public float getPreco() {
        return preco;
    }
    /**
     * Método que irá definir o preço do produto.
     * @param preco Será repassado uma variável float com o valor do produto.
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    //Q3
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------" + ""
             + "\nID DO PRODUTO = " + id +""
             + "\nNOME DO PRODUTO = " + nomeProduto + ""
             + "\nINGREDIENTES = " + ingredientes + ""
             + "\nDESCRIÇÃO DO PRODUTO = " + descricaoProduto + ""
             + "\nPREÇO = " + preco + '\n'+
                "------------------------------------------------------------------------";
    }
    
    
}

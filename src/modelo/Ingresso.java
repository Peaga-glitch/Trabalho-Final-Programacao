package modelo;

/**
 * Classe abstrata conceitual que estabelece a base para os bilhetes vendidos.
 * Fornece a base polimórfica para cálculo de valores e relatórios.
 * * @author Teu Nome
 * @version 1.0
 */
public abstract class Ingresso {
    /** Identificador único do ingresso. */
    public int id;
    /** Cliente titular que realizou a aquisição. */
    public Cliente cliente;
    /** Sessão à qual este bilhete concede acesso. */
    public Sessao sessao;
    /** Custo financeiro original extraído das regras da sessão. */
    public double valorBase;

    /**
     * Construtor básico da estrutura abstrata Ingresso.
     * * @param id Código sequencial identificador do bilhete.
     * @param cliente Instância do comprador associado.
     * @param sessao Instância da sessão desejada.
     * @param valorBase Preço padrão cobrado pela sessão.
     */
    public Ingresso(int id, Cliente cliente, Sessao sessao, double valorBase) {
        this.id = id;
        this.cliente = cliente;
        this.sessao = sessao;
        this.valorBase = valorBase;
    }

    /**
     * Contrato polimórfico abstrato para apurar o custo líquido final do ingresso.
     * * @return O preço líquido calculado final da entrada.
     */
    public abstract double calcularValor();

    /**
     * Método abstrato utilizado para imprimir a síntese legível do bilhete no terminal.
     */
    public abstract void exibirResumo();
}
package modelo;

/**
 * Tipo específico de Ingresso que concede o benefício legal de desconto de metade do preço.
 * Modificado para exibir corretamente o título do filme associado à sessão.
 * * @see Ingresso
 * @author Seu Nome
 * @version 1.1
 */
public class IngressoMeia extends Ingresso {
    
    /**
     * Construtor do Ingresso de categoria meia-entrada. Encaminha as propriedades para a classe mãe.
     * * @param id Código identificador do bilhete.
     * @param cliente Instância do comprador.
     * @param sessao Instância da sessão do filme.
     * @param valorBase Valor padrão utilizado para calcular a fração do desconto.
     */
    public IngressoMeia(int id, Cliente cliente, Sessao sessao, double valorBase) {
        super(id, cliente, sessao, valorBase);
    }

    /**
     * Aplica o desconto de 50% sobre a precificação base de referência da sessão.
     * * @return O valor base multiplicado por 0.5 (metade).
     */
    @Override
    public double calcularValor() { 
        return valorBase * 0.5; 
    }

    /**
     * Exibe no terminal as informações básicas informando que se trata de uma entrada do tipo MEIA.
     * Corrigido de .nome para .titulo para corresponder aos atributos da classe Filme.
     */
    @Override
    public void exibirResumo() {
        System.out.println("Ingresso MEIA - Filme: " + sessao.filme.titulo + " | Valor: R$ " + calcularValor());
    }
}
package modelo;

/**
 * Tipo específico de Ingresso que cobra o valor integral de tabela.
 * Modificado para exibir corretamente o título do filme associado à sessão.
 * * @see Ingresso
 * @author Seu Nome
 * @version 1.1
 */
public class IngressoInteira extends Ingresso {
    
    /**
     * Construtor do Ingresso de categoria inteira. Encaminha as propriedades para a classe mãe.
     * * @param id Código identificador do bilhete.
     * @param cliente Instância do comprador.
     * @param sessao Instância da sessão do filme.
     * @param valorBase Valor padrão cobrado sem descontos.
     */
    public IngressoInteira(int id, Cliente cliente, Sessao sessao, double valorBase) {
        super(id, cliente, sessao, valorBase);
    }

    /**
     * Retorna o valor original cobrado na sessão, sem reduções.
     * * @return O valor base do ingresso integral.
     */
    @Override
    public double calcularValor() { 
        return valorBase; 
    }

    /**
     * Exibe no terminal as informações básicas informando que se trata de uma entrada do tipo INTEIRA.
     * Corrigido de .nome para .titulo para corresponder aos atributos da classe Filme.
     */
    @Override
    public void exibirResumo() {
        System.out.println("Ingresso INTEIRA - Filme: " + sessao.filme.titulo + " | Valor: R$ " + calcularValor());
    }
}
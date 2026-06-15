package modelo;

/**
 * Representa uma sessão de exibição de um filme em uma sala e horário específicos.
 * Controla os assentos disponíveis e o preço base dos ingressos.
 * * @author Seu Nome
 * @version 1.0
 */
public class Sessao {

    /** Identificador único da sessão. */
    public int id;
    
    /** Filme vinculado que será exibido nesta sessão. */
    public Filme filme;
    
    /** Número da sala de exibição. */
    public int sala;
    
    /** Horário agendado para o início da sessão. */
    public String horario;
    
    /** Capacidade máxima de assentos suportada pela sala. */
    public int capacidadeMaxima;
    
    /** Quantidade de assentos que ainda não foram vendidos. */
    public int assentosDisponiveis;
    
    /** Preço base cobrado pelo ingresso nesta sessão. */
    public double valorBase;

    /**
     * Construtor completo da classe Sessao.
     * Define inicialmente os assentos disponíveis igualando-os à capacidade máxima da sala.
     * * @param id Identificador único.
     * @param filme Instância do Filme.
     * @param sala Número da sala.
     * @param horario String contendo o horário.
     * @param capacidadeMaxima Total de assentos suportados.
     * @param valorBase Preço padrão do bilhete.
     */
    public Sessao(int id, Filme filme, int sala, String horario, int capacidadeMaxima, double valorBase) {
        this.id = id;
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.assentosDisponiveis = capacidadeMaxima;
        this.valorBase = valorBase;
    }
}
package modelo;

/**
 * Representa um filme disponível no catálogo do cinema.
 * Fornece os detalhes de categorização, tempo de duração e classificação etária.
 * * @author Teu Nome
 * @version 1.0
 */
public class Filme {

    /** Identificador único do filme. */
    public int id;
    
    /** Título oficial da obra cinematográfica. */
    public String titulo;
    
    /** Gênero do filme basea	do no enumerador Genero. */
    public Genero genero;
    
    /** Classificação indicativa baseada no enumerador Classificacao. */
    public Classificacao classificao;
    
    /** Duração total da obra calculada em minutos. */
    public int duracaoMinutos;
    
    /** Breve sinopse ou descrição do enredo do filme. */
    public String descricao;
	
    /**
     * Construtor completo para instanciar um Filme no catálogo.
     * * @param id Identificador numérico único.
     * @param titulo Nome/Título oficial da obra.
     * @param genero Categoria/Gênero do filme.
     * @param classificao Faixa etária recomendada.
     * @param duracaoMinutos Tempo de projeção em minutos.
     * @param descricao Sinopse descritiva.
     */
    public Filme(int id, String titulo, Genero genero, Classificacao classificao, int duracaoMinutos, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.classificao = classificao;
        this.duracaoMinutos = duracaoMinutos;
        this.descricao = descricao;
    }
}
package modelo;

/**
 * Enumeração que define as faixas etárias de classificação indicativa para os filmes.
 * Utilizado para garantir o cumprimento das normas de exibição pública.
 * * @author Teu Nome
 * @version 1.0
 */
public enum Classificacao {
    /** Exibição permitida para todas as idades (Livre). */
    LIVRE, 
    /** Recomendado para maiores de 10 anos. */
    DEZ, 
    /** Recomendado para maiores de 12 anos. */
    DOZE, 
    /** Recomendado para maiores de 14 anos. */
    QUATORZE, 
    /** Recomendado para maiores de 16 anos. */
    DEZESSEIS, 
    /** Proibido para menores de 18 anos. */
    DEZOITO;
}
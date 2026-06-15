package servico;

import java.util.ArrayList;
import java.util.List;
import modelo.*;

/**
 * Classe de serviço que atua como repositório de dados em memória para o cinema.
 * Controla os sequenciadores de ID e gerencia as coleções de entidades do sistema.
 * Todos os atributos são públicos para permitir acesso direto a partir do pacote principal.
 * * @author Teu Nome
 * @version 1.0
 */
public class CinemaServico {
    /** Lista pública que armazena os clientes cadastrados. */
    public List<Cliente> listaClientes = new ArrayList<>();
    
    /** Lista pública que armazena os filmes cadastrados. */
    public List<Filme> listaFilmes = new ArrayList<>();
    
    /** Lista pública que armazena as sessões ativas do cinema. */
    public List<Sessao> listaSessoes = new ArrayList<>();
    
    /** Lista pública que armazena o histórico de vendas efetuadas. */
    public List<Venda> listaVendas = new ArrayList<>();

    /** Gerador incremental público de ID para Clientes. */
    public int idCli = 1;
    
    /** Gerador incremental público de ID para Filmes. */
    public int idFil = 1;
    
    /** Gerador incremental público de ID para Sessões. */
    public int idSes = 1;
    
    /** Gerador incremental público de ID para Vendas. */
    public int idVen = 1;
}
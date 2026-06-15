package modelo;

/**
 * Classe de modelo que representa um Cliente no sistema do cinema.
 * Aplica automaticamente máscaras de formatação para CPF e Telefone no momento do cadastro.
 * * @author Seu Nome
 * @version 1.1
 */
public class Cliente {

    /** Identificador único do cliente no sistema. */
    public int id;
    
    /** Nome completo do cliente. */
    public String nome;
    
    /** Cadastro de Pessoa Física (CPF) armazenado automaticamente no formato ###.###.###-##. */
    public String cpf;
    
    /** Endereço de e-mail do cliente. */
    public String email;
    
    /** Número de telefone armazenado automaticamente no formato (##) #####-#### ou (##) ####-####. */
    public String telefone;
	
    /**
     * Construtor completo da classe Cliente.
     * Os parâmetros de CPF e Telefone passam por um tratamento automático de formatação antes de serem salvos.
     * * @param id Identificador numérico exclusivo.
     * @param nome Nome completo do cliente.
     * @param cpf CPF (aceita apenas números ou já com pontos/traço).
     * @param email Endereço de correio eletrônico.
     * @param telefone Número de telefone (aceita apenas números ou com caracteres).
     */
    public Cliente(int id, String nome, String cpf, String email, String telefone) {
    	this.id = id;
    	this.nome = nome;
    	this.cpf = tratarCPF(cpf);
    	this.email = email;
    	this.telefone = tratarTelefone(telefone);
    }

    /**
     * Método privado que remove caracteres especiais e formata o CPF no padrão correto.
     * Se o usuário digitar 11 números limpos (ex: 12345678901), transforma em 123.456.789-01.
     * * @param cpfEntrada Texto bruto enviado para o CPF.
     * @return O CPF formatado ou o texto original caso não possua os 11 dígitos.
     */
    private String tratarCPF(String cpfEntrada) {
        if (cpfEntrada == null) return "";
        // Remove tudo o que não for número
        String apenasNumeros = cpfEntrada.replaceAll("[^0-9]", "");
        
        // Se tiver o tamanho exato de um CPF, aplica a máscara
        if (apenasNumeros.length() == 11) {
            return apenasNumeros.substring(0, 3) + "." + 
                   apenasNumeros.substring(3, 6) + "." + 
                   apenasNumeros.substring(6, 9) + "-" + 
                   apenasNumeros.substring(9);
        }
        return cpfEntrada; // Se já estava formatado errado ou incompleto, mantém o que foi digitado
    }

    /**
     * Método privado que remove caracteres especiais e formata o Telefone no padrão correto.
     * Suporta celulares com 9 dígitos (##) #####-#### ou fixos com 8 dígitos (##) ####-####.
     * * @param telEntrada Texto bruto enviado para o Telefone.
     * @return O telefone formatado ou o texto original caso o tamanho não seja compatível.
     */
    private String tratarTelefone(String telEntrada) {
        if (telEntrada == null) return "";
        // Remove tudo o que não for número
        String apenasNumeros = telEntrada.replaceAll("[^0-9]", "");
        
        // Celular com DDD (Ex: 11999998888 -> (11) 99999-8888)
        if (apenasNumeros.length() == 11) {
            return "(" + apenasNumeros.substring(0, 2) + ") " + 
                   apenasNumeros.substring(2, 7) + "-" + 
                   apenasNumeros.substring(7);
        } 
        // Telefone Fixo com DDD (Ex: 1133334444 -> (11) 3333-4444)
        else if (apenasNumeros.length() == 10) {
            return "(" + apenasNumeros.substring(0, 2) + ") " + 
                   apenasNumeros.substring(2, 6) + "-" + 
                   apenasNumeros.substring(6);
        }
        return telEntrada; // Retorna o texto original se não bater com o tamanho padrão
    }
}
package main;

import java.util.Scanner;
import modelo.*;
import servico.CinemaServico;

/**
 * Classe principal responsável por gerenciar a interface de linha de comando (CLI).
 * Contém o menu interativo e processa diretamente as operações de CRUD do cinema.
 * * @author Teu Nome
 * @version 1.0
 */
public class Main {
    /**
     * Método de entrada do sistema. Controla o fluxo principal e submenus do cinema.
     * * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        CinemaServico servico = new CinemaServico();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========= CINEMA =========");
            System.out.println("1 - Gerenciar Clientes\n2 - Gerenciar Filmes\n3 - Gerenciar Sessões\n4 - Venda de Ingressos\n5 - Relatórios\n0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                // GERENCIAR CLIENTES
                if (opcao == 1) {
                    System.out.println("\n====== CLIENTES ======\n1 - Cadastrar Cliente\n2 - Listar Clientes\n3 - Buscar Cliente\n4 - Atualizar Cliente\n5 - Remover Cliente\n0 - Voltar");
                    System.out.print("\nEscolha uma opção: ");
                    int op = Integer.parseInt(scanner.nextLine());

                    if (op == 1) {
                        System.out.print("Nome: "); String n = scanner.nextLine();
                        System.out.print("CPF (apenas números ou formatado): "); String c = scanner.nextLine();
                        System.out.print("Telefone (apenas números ou formatado): "); String t = scanner.nextLine();
                        System.out.print("Email: "); String e = scanner.nextLine();
                        
                        // Aplica a formatação automática antes de instanciar o objeto
                        String cpfFormatado = formatarCPF(c);
                        String telefoneFormatado = formatarTelefone(t);
                        
                        servico.listaClientes.add(new Cliente(servico.idCli++, n, cpfFormatado, e, telefoneFormatado));
                        System.out.println("Cliente cadastrado!");
                    } else if (op == 2) {
                        for (int i = 0; i < servico.listaClientes.size(); i++) {
                            System.out.println("ID: " + servico.listaClientes.get(i).id + " | Nome: " + servico.listaClientes.get(i).nome + " | CPF: " + servico.listaClientes.get(i).cpf + " | Tel: " + servico.listaClientes.get(i).telefone);
                        }
                    } else if (op == 3) {
                        System.out.print("ID do Cliente: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaClientes.size(); i++) {
                            if (servico.listaClientes.get(i).id == id) {
                                System.out.println("Nome: " + servico.listaClientes.get(i).nome + " | Tel: " + servico.listaClientes.get(i).telefone);
                            }
                        }
                    } else if (op == 4) {
                        System.out.print("ID do Cliente: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaClientes.size(); i++) {
                            if (servico.listaClientes.get(i).id == id) {
                                System.out.print("Novo Nome: "); servico.listaClientes.get(i).nome = scanner.nextLine();
                                System.out.print("Novo Telefone: "); servico.listaClientes.get(i).telefone = formatarTelefone(scanner.nextLine());
                                System.out.println("Atualizado!");
                            }
                        }
                    } else if (op == 5) {
                        System.out.print("ID do Cliente: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaClientes.size(); i++) {
                            if (servico.listaClientes.get(i).id == id) { servico.listaClientes.remove(i); System.out.println("Removido!"); break; }
                        }
                    }
                }
                
                // GERENCIAR FILMES
                else if (opcao == 2) {
                    System.out.println("\n====== FILMES ======\n1 - Cadastrar Filme\n2 - Listar Filmes\n3 - Buscar Filme\n4 - Atualizar Filme\n5 - Remover Filme\n0 - Voltar");
                    System.out.print("\nEscolha uma opção: ");
                    int op = Integer.parseInt(scanner.nextLine());

                    if (op == 1) {
                        System.out.print("Título: "); String t = scanner.nextLine();
                        System.out.print("Gênero (ACAO, TERROR, FICCAO_CIENTIFICA, etc): "); Genero g = Genero.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("Classificação (LIVRE, QUATORZE, DEZOITO, etc): "); Classificacao cl = Classificacao.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("Duração (min): "); int dur = Integer.parseInt(scanner.nextLine());
                        System.out.print("Descrição: "); String desc = scanner.nextLine();
                        servico.listaFilmes.add(new Filme(servico.idFil++, t, g, cl, dur, desc));
                        System.out.println("Filme cadastrado!");
                    } else if (op == 2) {
                        for (int i = 0; i < servico.listaFilmes.size(); i++) {
                            System.out.println("ID: " + servico.listaFilmes.get(i).id + " | Filme: " + servico.listaFilmes.get(i).titulo);
                        }
                    } else if (op == 3) {
                        System.out.print("ID do Filme: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaFilmes.size(); i++) {
                            if (servico.listaFilmes.get(i).id == id) System.out.println("Filme: " + servico.listaFilmes.get(i).titulo);
                        }
                    } else if (op == 4) {
                        System.out.print("ID do Filme: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaFilmes.size(); i++) {
                            if (servico.listaFilmes.get(i).id == id) {
                                System.out.print("Novo Título: "); servico.listaFilmes.get(i).titulo = scanner.nextLine();
                                System.out.println("Atualizado!");
                            }
                        }
                    } else if (op == 5) {
                        System.out.print("ID do Filme: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaFilmes.size(); i++) {
                            if (servico.listaFilmes.get(i).id == id) { servico.listaFilmes.remove(i); System.out.println("Removido!"); break; }
                        }
                    }
                }

                // GERENCIAR SESSÕES
                else if (opcao == 3) {
                    System.out.println("\n====== SESSÕES ======\n1 - Cadastrar Sessão\n2 - Listar Sessões\n3 - Buscar Sessão\n4 - Atualizar Sessão\n5 - Remover Sessão\n0 - Voltar");
                    System.out.print("\nEscolha uma opção: ");
                    int op = Integer.parseInt(scanner.nextLine());

                    if (op == 1) {
                        System.out.print("ID do Filme: "); int idF = Integer.parseInt(scanner.nextLine());
                        Filme fSel = null;
                        for (int i = 0; i < servico.listaFilmes.size(); i++) {
                            if (servico.listaFilmes.get(i).id == idF) fSel = servico.listaFilmes.get(i);
                        }
                        if (fSel != null) {
                            System.out.print("Sala: "); int sala = Integer.parseInt(scanner.nextLine());
                            System.out.print("Horário: "); String hor = scanner.nextLine();
                            servico.listaSessoes.add(new Sessao(servico.idSes++, fSel, sala, hor, 10, 30.0));
                            System.out.println("Sessão cadastrada!");
                        }
                    } else if (op == 2) {
                        for (int i = 0; i < servico.listaSessoes.size(); i++) {
                            Sessao s = servico.listaSessoes.get(i);
                            System.out.println("ID: " + s.id + " | Filme: " + s.filme.titulo + " | Livres: " + s.assentosDisponiveis);
                        }
                    } else if (op == 3) {
                        System.out.print("ID Sessão: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaSessoes.size(); i++) {
                            if (servico.listaSessoes.get(i).id == id) System.out.println("Filme: " + servico.listaSessoes.get(i).filme.titulo);
                        }
                    } else if (op == 4) {
                        System.out.print("ID Sessão: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaSessoes.size(); i++) {
                            if (servico.listaSessoes.get(i).id == id) {
                                System.out.print("Novo Horário: "); servico.listaSessoes.get(i).horario = scanner.nextLine();
                                System.out.println("Atualizado!");
                            }
                        }
                    } else if (op == 5) {
                        System.out.print("ID Sessão: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaSessoes.size(); i++) {
                            if (servico.listaSessoes.get(i).id == id) { servico.listaSessoes.remove(i); System.out.println("Removida!"); break; }
                        }
                    }
                }

                //VENDA DE INGRESSOS
                else if (opcao == 4) {
                    System.out.println("\n====== INGRESSOS ======\n1 - Vender Ingresso Inteira\n2 - Vender Ingresso Meia\n3 - Listar Ingressos\n4 - Buscar Ingresso\n5 - Cancelar Venda\n0 - Voltar");
                    System.out.print("\nEscolha uma opção: ");
                    int op = Integer.parseInt(scanner.nextLine());

                    if (op == 1 || op == 2) {
                        System.out.print("ID Cliente: "); int idC = Integer.parseInt(scanner.nextLine());
                        System.out.print("ID Sessão: "); int idS = Integer.parseInt(scanner.nextLine());
                        
                        Cliente cli = null; Sessao ses = null;
                        for (int i = 0; i < servico.listaClientes.size(); i++) {
                            if (servico.listaClientes.get(i).id == idC) cli = servico.listaClientes.get(i);
                        }
                        for (int i = 0; i < servico.listaSessoes.size(); i++) {
                            if (servico.listaSessoes.get(i).id == idS) ses = servico.listaSessoes.get(i);
                        }

                        if (cli != null && ses != null && ses.assentosDisponiveis > 0) {
                            Ingresso ing = (op == 1) ? new IngressoInteira(servico.idVen, cli, ses, ses.valorBase) : new IngressoMeia(servico.idVen, cli, ses, ses.valorBase);
                            ses.assentosDisponiveis--;
                            servico.listaVendas.add(new Venda(servico.idVen++, cli, ing, "Hoje"));
                            System.out.println("Sucesso!");
                            ing.exibirResumo();
                        } else {
                            System.out.println("Erro: Dados inválidos ou sessão cheia.");
                        }
                    } else if (op == 3) {
                        for (int i = 0; i < servico.listaVendas.size(); i++) {
                            System.out.println("ID Venda: " + servico.listaVendas.get(i).id + " | Cliente: " + servico.listaVendas.get(i).cliente.nome);
                        }
                    } else if (op == 4) {
                        System.out.print("ID Venda: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaVendas.size(); i++) {
                            if (servico.listaVendas.get(i).id == id) servico.listaVendas.get(i).ingresso.exibirResumo();
                        }
                    } else if (op == 5) {
                        System.out.print("ID Venda para cancelar: "); int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < servico.listaVendas.size(); i++) {
                            if (servico.listaVendas.get(i).id == id) {
                                servico.listaVendas.get(i).ingresso.sessao.assentosDisponiveis++;
                                servico.listaVendas.remove(i);
                                System.out.println("Venda cancelada!");
                                break;
                            }
                        }
                    }
                }

                // RELATÓRIOS
                else if (opcao == 5) {
                    System.out.print("ID da Sessão: ");
                    int idS = Integer.parseInt(scanner.nextLine());
                    System.out.println("\n--- Ingressos vendidos para a Sessão " + idS + " ---");
                    for (int i = 0; i < servico.listaVendas.size(); i++) {
                        if (servico.listaVendas.get(i).ingresso.sessao.id == idS) servico.listaVendas.get(i).ingresso.exibirResumo();
                    }
                }
            } catch (Exception e) {
                System.out.println("Entrada incorreta. Tente novamente.");
            }
        }
        System.out.println("Sistema Encerrado.");
    }

    /**
     * Formata uma String numérica de CPF aplicando a máscara padrão brasileira.
     * * @param cpf String crua inserida pelo utilizador.
     * @return String formatada como ###.###.###-## se contiver 11 dígitos.
     */
    private static String formatarCPF(String cpf) {
        String limpo = cpf.replaceAll("[^0-9]", "");
        if (limpo.length() == 11) {
            return limpo.substring(0, 3) + "." + limpo.substring(3, 6) + "." + limpo.substring(6, 9) + "-" + limpo.substring(9);
        }
        return cpf;
    }

    /**
     * Formata uma String de telefone celular adicionando parênteses e hífen.
     * * @param telefone String crua inserida pelo utilizador.
     * @return String formatada como (##) #####-#### se contiver 11 dígitos.
     */
    private static String formatarTelefone(String telefone) {
        String limpo = telefone.replaceAll("[^0-9]", "");
        if (limpo.length() == 11) {
            return "(" + limpo.substring(0, 2) + ") " + limpo.substring(2, 7) + "-" + limpo.substring(7);
        }
        return telefone;
    }
}
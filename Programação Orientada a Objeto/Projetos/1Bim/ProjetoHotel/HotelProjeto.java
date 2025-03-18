/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelprojeto;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
/*public class HotelProjeto {

    private String[] hospedes = new String[100]; // Vetor para armazenar os nomes dos hóspedes
    private boolean[] statusQuartos = new boolean[100]; // Vetor 
   
    
    
    public static void main(String[] args) {
        HotelProjeto sistema = new HotelProjeto();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Hotel ---");
            System.out.println("1. Reservar Quarto");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("4. Consultar Hóspede");
            System.out.println("5. Editar Hóspede");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    sistema.reservarQuarto(scanner);
                    break;
                case 2:
                    sistema.cancelarReserva(scanner);
                    break;
                case 3:
                    sistema.listarReservas();
                    break;
                case 4:
                    sistema.consultarHospede(scanner);
                    break;
                case 5:
                    sistema.editarHospede(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void reservarQuarto(Scanner scanner) {
        System.out.print("Digite o número do quarto (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (statusQuartos[numeroQuarto - 1]) {
            System.out.println("Quarto já está ocupado.");
        } else {
            System.out.print("Digite o nome do hóspede: ");
            String nomeHospede = scanner.nextLine();
            hospedes[numeroQuarto - 1] = nomeHospede;
            statusQuartos[numeroQuarto - 1] = true;
            System.out.println("Reserva realizada com sucesso.");
        }
    }

    private void cancelarReserva(Scanner scanner) {
        System.out.print("Digite o número do quarto para cancelar a reserva (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (!statusQuartos[numeroQuarto - 1]) {
            System.out.println("Quarto já está disponível.");
        } else {
            hospedes[numeroQuarto - 1] = null;
            statusQuartos[numeroQuarto - 1] = false;
            System.out.println("Reserva cancelada com sucesso.");
        }
    }

    private void listarReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (int i = 0; i < 100; i++) {
            if (statusQuartos[i]) {
                System.out.println("Quarto " + (i + 1) + ": " + hospedes[i]);
            }
        }
    }

    private void consultarHospede(Scanner scanner) {
        System.out.print("Digite o número do quarto para consultar o hóspede (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (statusQuartos[numeroQuarto - 1]) {
            System.out.println("Hóspede do quarto " + numeroQuarto + ": " + hospedes[numeroQuarto - 1]);
        } else {
            System.out.println("Quarto está disponível.");
        }
    }

    private void editarHospede(Scanner scanner) {
        System.out.print("Digite o número do quarto para editar o hóspede (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (statusQuartos[numeroQuarto - 1]) {
            System.out.print("Digite o novo nome do hóspede: ");
            String novoNome = scanner.nextLine();
            hospedes[numeroQuarto - 1] = novoNome;
            System.out.println("Hóspede editado com sucesso.");
        } else {
            System.out.println("Quarto está disponível. Nenhum hóspede para editar.");
        }
    }
    }
    
*/

import java.util.Scanner;

public class HotelProjeto {
    // Variáveis globais para armazenar os dados do sistema
    private static String[] hospedes = new String[100]; // Armazena os nomes dos hóspedes
    private static boolean[] statusQuartos = new boolean[100]; // Armazena o status dos quartos (true = ocupado, false = disponível)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Menu do sistema
            System.out.println("\n--- Sistema de Gerenciamento de Hotel ---");
            System.out.println("1. Reservar Quarto");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("4. Consultar Hóspede");
            System.out.println("5. Editar Hóspede");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Executa a operação escolhida
            switch (opcao) {
                case 1:
                    reservarQuarto(scanner);
                    break;
                case 2:
                    cancelarReserva(scanner);
                    break;
                case 3:
                    listarReservas();
                    break;
                case 4:
                    consultarHospede(scanner);
                    break;
                case 5:
                    editarHospede(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Função para reservar um quarto
    private static void reservarQuarto(Scanner scanner) {
        System.out.print("Digite o número do quarto (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (statusQuartos[numeroQuarto - 1]) {
            System.out.println("Quarto já está ocupado.");
        } else {
            System.out.print("Digite o nome do hóspede: ");
            String nomeHospede = scanner.nextLine();
            hospedes[numeroQuarto - 1] = nomeHospede;
            statusQuartos[numeroQuarto - 1] = true;
            System.out.println("Reserva realizada com sucesso.");
        }
    }

    // Função para cancelar uma reserva
    private static void cancelarReserva(Scanner scanner) {
        System.out.print("Digite o número do quarto para cancelar a reserva (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (!statusQuartos[numeroQuarto - 1]) {
            System.out.println("Quarto já está disponível.");
        } else {
            hospedes[numeroQuarto - 1] = null;
            statusQuartos[numeroQuarto - 1] = false;
            System.out.println("Reserva cancelada com sucesso.");
        }
    }

    // Função para listar todas as reservas
    private static void listarReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (int i = 0; i < 100; i++) {
            if (statusQuartos[i]) {
                System.out.println("Quarto " + (i + 1) + ": " + hospedes[i]);
            }
        }
    }

    // Função para consultar um hóspede pelo número do quarto
    private static void consultarHospede(Scanner scanner) {
        System.out.print("Digite o número do quarto para consultar o hóspede (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (statusQuartos[numeroQuarto - 1]) {
            System.out.println("Hóspede do quarto " + numeroQuarto + ": " + hospedes[numeroQuarto - 1]);
        } else {
            System.out.println("Quarto está disponível.");
        }
    }

    // Função para editar o nome de um hóspede
    private static void editarHospede(Scanner scanner) {
        System.out.print("Digite o número do quarto para editar o hóspede (1-100): ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroQuarto < 1 || numeroQuarto > 100) {
            System.out.println("Número de quarto inválido.");
            return;
        }

        if (statusQuartos[numeroQuarto - 1]) {
            System.out.print("Digite o novo nome do hóspede: ");
            String novoNome = scanner.nextLine();
            hospedes[numeroQuarto - 1] = novoNome;
            System.out.println("Hóspede editado com sucesso.");
        } else {
            System.out.println("Quarto está disponível. Nenhum hóspede para editar.");
        }
    }
}

package Hotel;
import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        String[] hospedes = new String[100]; 
        boolean[] statusQuartos = new boolean[100];
        int operacao = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n--- Sistema de Gerenciamento de Hotel ---");
            System.out.println("1. Reservar Quarto");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("4. Consultar Hóspede");
            System.out.println("5. Editar Hóspede");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            operacao = scanner.nextInt();
            scanner.nextLine(); 
            switch (operacao) {
                case 1:
                    System.out.print("Digite o número do quarto (1-100): ");
                    int numeroQuartoReserva = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroQuartoReserva < 1 || numeroQuartoReserva > 100) {
                        System.out.println("Número de quarto inválido.");
                    } else if (statusQuartos[numeroQuartoReserva - 1]) {
                        System.out.println("Quarto já está ocupado.");
                    } else {
                        System.out.print("Digite o nome do hóspede: ");
                        String nomeHospede = scanner.nextLine();
                        hospedes[numeroQuartoReserva - 1] = nomeHospede;
                        statusQuartos[numeroQuartoReserva - 1] = true;
                        System.out.println("Reserva realizada do(a) " + nomeHospede + ", no quarto: " + numeroQuartoReserva);
                    }
                            
                    break;
                case 2:
                    System.out.print("Digite o número do quarto para cancelar a reserva (1-100): ");
                    int numeroQuartoCancelar = scanner.nextInt();
                   scanner.nextLine();

                    if (numeroQuartoCancelar < 1 || numeroQuartoCancelar > 100) {
                        System.out.println("Número de quarto inválido.");
                    } else if (!statusQuartos[numeroQuartoCancelar - 1]) {
                        System.out.println("Quarto já está disponível.");
                    } else {
                         hospedes[numeroQuartoCancelar - 1] = null;
                        statusQuartos[numeroQuartoCancelar - 1] = false;
                        System.out.println("Reserva cancelada com sucesso.");
                        /*System.out.println("Tem ccerteza que deseja cancelar a reserva do(a) " +  hospedes[numeroQuartoCancelar - 1] + " s/n");
                        String resposta = scanner.nextLine();
                        if (resposta == "s"){
                        
                        hospedes[numeroQuartoCancelar - 1] = null;
                        statusQuartos[numeroQuartoCancelar - 1] = false;
                        System.out.println("Reserva cancelada com sucesso.");
                        }else{
                            System.out.println("Operação cancelada!!!");
                        }*/
                    }
                    break;
                case 3:
                     // Listar Reservas
                    System.out.println("\n--- Lista de Reservas ---");
                    for (int i = 0; i < 100; i++) {
                        if (statusQuartos[i]) {
                            System.out.println("Quarto " + (i + 1) + ": " + hospedes[i]);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite o número do quarto para Consulta (1-100): ");
                    int numeroQuartoConsulta = scanner.nextInt();


                    if (numeroQuartoConsulta < 1 || numeroQuartoConsulta > 100) {
                        System.out.println("Número de quarto inválido.");
                    } else {
                        
                        if(statusQuartos[numeroQuartoConsulta - 1]){
                            System.out.print("\nNome do Hóspede: " + hospedes[numeroQuartoConsulta - 1]);
                            System.out.print("\nQuarto ocupado");
                        }else{ 
                            System.out.print("\nQuarto disponível");
                            
                        }
                        
                    }
                    break;
                case 5:
                   System.out.print("Digite o número do quarto para editar(1-100): ");
                    int numeroQuartoEditar = scanner.nextInt();
                    scanner.nextLine();
                    if (numeroQuartoEditar < 1 || numeroQuartoEditar > 100) {
                        System.out.println("Número de quarto inválido.");
                    } else {
                        System.out.print("Digite o nome do novo hóspede: ");
                        String nomeHospede = scanner.nextLine();
                        hospedes[numeroQuartoEditar - 1] = nomeHospede;
                        statusQuartos[numeroQuartoEditar - 1] = true;
                        System.out.println("Edição realizada com sucesso...\n Novo nome: " + nomeHospede);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (operacao != 0 && operacao > 0 && operacao <6);

        scanner.close();
    }
}

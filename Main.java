import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Telefonia telefonia = new Telefonia();
        int opcao;

        do {
            System.out.println("\nSistema de Gestão de Telefonia");
            System.out.println("1. Cadastrar Assinante");
            System.out.println("2. Listar Assinantes");
            System.out.println("3. Fazer Chamada");
            System.out.println("4. Fazer Recarga");
            System.out.println("5. Imprimir Faturas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("É pré-pago? (true/false): ");
                    boolean isPrePago = scanner.nextBoolean();
                    System.out.print("CPF: ");
                    long cpf = scanner.nextLong();
                    scanner.nextLine();  // Consumir quebra de linha
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    if (isPrePago) {
                        telefonia.cadastrarAssinante(true, cpf, nome, numero, 0);
                    } else {
                        System.out.print("Valor da assinatura: ");
                        float assinatura = scanner.nextFloat();
                        telefonia.cadastrarAssinante(false, cpf, nome, numero, assinatura);
                    }
                    System.out.println("Assinante cadastrado com sucesso!");
                    break;

                case 2:
                    telefonia.listarAssinantes();
                    break;

                case 3:
                    System.out.print("É pré-pago? (true/false): ");
                    boolean chamadaPrePago = scanner.nextBoolean();
                    System.out.print("CPF do assinante: ");
                    long cpfChamada = scanner.nextLong();
                    System.out.print("Duração da chamada (em minutos): ");
                    int duracao = scanner.nextInt();
                    telefonia.fazerChamada(chamadaPrePago, cpfChamada, new Date(), duracao);
                    break;

                case 4:
                    System.out.print("CPF do assinante: ");
                    long cpfRecarga = scanner.nextLong();
                    System.out.print("Valor da recarga: ");
                    float valorRecarga = scanner.nextFloat();
                    telefonia.fazerRecarga(cpfRecarga, new Date(), valorRecarga);
                    break;

                case 5:
                    System.out.print("Digite o mês (1-12): ");
                    int mes = scanner.nextInt();
                    telefonia.imprimirFaturas(mes);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}






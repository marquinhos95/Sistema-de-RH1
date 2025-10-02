import java.util.Scanner;

public class SistemadeRH {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE RH =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Buscar funcionário por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scanner);
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionario(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Simulação de banco de dados em memória
    static String[] nomes = new String[10];
    static int[] ids = new int[10];
    static int contador = 0;

    // Cadastrar funcionário
    public static void cadastrarFuncionario(Scanner scanner) {
        if (contador >= nomes.length) {
            System.out.println("Limite de funcionários atingido!");
            return;
        }

        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        ids[contador] = id;
        nomes[contador] = nome;
        contador++;

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Listar todos funcionários
    public static void listarFuncionarios() {
        if (contador == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Funcionários ---");
        for (int i = 0; i < contador; i++) {
            System.out.println("ID: " + ids[i] + " | Nome: " + nomes[i]);
        }
    }

    // Buscar funcionário pelo ID
    public static void buscarFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário que deseja buscar: ");
        int idBusca = scanner.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (ids[i] == idBusca) {
                System.out.println("Funcionário encontrado: " + nomes[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado!");
        }
    }
}

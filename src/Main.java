import java.util.Scanner;

public class Main {
    static void main() {
        boolean programaEncerrado = false;
        int totalCadastrados = 0;
        Scanner scan = new Scanner(System.in);

        String[] descricoes = new String[5];
        String[] categorias = new String[5];
        double[] valores = new double[5];

        while (!programaEncerrado) {
            System.out.println("==============================");
            System.out.println("  CONTROLE DE DESPESAS (" + totalCadastrados + "/5)");
            System.out.println("==============================");
            System.out.println("1. Cadastrar despesa");
            System.out.println("2. Exibir relatorio geral");
            System.out.println("3. Filtrar por categoria");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int input = Integer.valueOf(scan.nextLine());

            switch (input) {
                case 1:
                    if(totalCadastrados >= 5) {
                        System.out.println("Você atingiu o limite de cadastros de despesas. Não é possível realizar novos cadastros");
                    } else {
                        cadastroDespesa(descricoes, categorias, valores, totalCadastrados, scan);
                        if (!(descricoes[totalCadastrados] == null)) {
                            totalCadastrados++;
                        }
                        break;
                    }
                case 2:
                    exibirRelatorioGeral(descricoes, categorias, valores, totalCadastrados);
                    break;
                case 3:
                    filtrarPorCategoria(descricoes, categorias, valores, totalCadastrados, scan);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    programaEncerrado = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    static void cadastroDespesa(String[] descricoes, String[] categorias, double[] valores, int cadastrados, Scanner scan) {
        System.out.println("--- Nova Despesa ---");
        System.out.print("Descrição: ");
        String descricao = scan.nextLine();

        System.out.print("Categoria: ");
        String categoria = scan.nextLine();
        if(categoria.length() < 3) {
            System.out.println("Erro: O nome da categoria deve possuir mais de 3 letras");
        } else {
            System.out.print("Valor: ");
            double valor = Double.valueOf(scan.nextLine());
            if (valor < 0) {
                System.out.println("Erro: o valor deve ser maior que zero.");
            } else {
                descricoes[cadastrados] = descricao;
                categorias[cadastrados] = categoria;
                valores[cadastrados] = valor;
                System.out.println("Despesa cadastrada com sucesso!");
            }
        }
    }

    static void exibirRelatorioGeral(String[] descricoes, String[] categorias, double[] valores, int cadastrados) {
        if (cadastrados == 0) {
            System.out.println("Nenhuma despesa cadastrada");
        } else {
            System.out.println("=== RELATORIO GERAL DE DESPESAS ===");
            for (int i = 0; i < cadastrados; i++) {
                String sigla = formatarSiglaCategoria(categorias[i]);
                System.out.printf("%d. [%s] %s - R$ %.2f\n", (i + 1), sigla, descricoes[i], valores[i]);
            }

            double valorTotal = calcularTotal(valores, cadastrados);
            double mediaLancamento = calcularMediaLancamento(valores, cadastrados);
            int indiceMaiorDespesa = encontrarIndiceMaiorDespesa(valores, cadastrados);
            String orcamento = obterStatusOrcamento(valorTotal);

            System.out.println("-----------------------------------");
            System.out.printf("Total gasto: R$ %.2f\n", valorTotal);
            System.out.printf("Media por lancamento: R$ %.2f\n", mediaLancamento);
            System.out.printf("Maior despesa: %s (R$ %.2f)\n", descricoes[indiceMaiorDespesa], valores[indiceMaiorDespesa]);
            System.out.printf("Status - %s \n", orcamento);
            System.out.println("Vagas restantes na memória: " + (5 - cadastrados));
        }
    }

    static double calcularTotal(double[] valores, int cadastrados) {
        double soma = 0.0;
        for (int i = 0; i < cadastrados; i++) {
            soma += valores[i];
        }
        return soma;
    }

    static double calcularMediaLancamento(double[] valores, int cadastrados) {
        double valorTotal = calcularTotal(valores, cadastrados);
        return valorTotal / cadastrados;
    }

    static int encontrarIndiceMaiorDespesa (double[] valores, int cadastrados) {
        int indiceDespesa = 0;
        double maiorDespesa = 0.0;

        for (int i = 0; i < cadastrados; i++) {
            if (valores[i] > maiorDespesa) {
                maiorDespesa = valores[i];
                indiceDespesa = i;
            }
        }
        return indiceDespesa;
    }

    static String obterStatusOrcamento (double totalGasto) {
        if (totalGasto < 500) {
            return "Você está dentro do orçamento";
        } else if (totalGasto > 500 && totalGasto < 1500) {
            return "Atenção: gaste moderadamente";
        } else {
            return "Alerta: orçamento estourado";
        }
    }

    static String formatarSiglaCategoria (String categoria) {
        return categoria.substring(0, 3).toUpperCase();
    }

    static void filtrarPorCategoria (String[] descricoes, String[] categorias, double[] valores, int cadastrados, Scanner scan) {
        double subtotal = 0.0;
        double porcentagem = 0.0;
        double valorTotal = calcularTotal(valores, cadastrados);

        System.out.print("Digite a categoria para filtrar: ");
        String filtro = scan.nextLine().toLowerCase();

        System.out.printf("=== FILTRO: %s ===\n", filtro.toUpperCase());
        for (int i = 0; i < cadastrados; i++) {
            if(filtro.equals(categorias[i].toLowerCase())) {
                System.out.printf("- %s: R$ %.2f\n", descricoes[i], valores[i]);
                subtotal += valores[i];
            }
        }

        porcentagem = (subtotal / valorTotal) * 100;
        if (subtotal > 0) {
            System.out.printf("Subtotal da categoria: R$ %.2f (%.2f%% do total)\n", subtotal, porcentagem);
        } else {
            System.out.println("Nenhum registro foi encontrado.");
        }
    }
}

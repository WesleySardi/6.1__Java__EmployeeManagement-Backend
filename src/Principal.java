import Controllers.FuncionarioController;
import Data.FuncionarioSeed;
import Entities.Funcionario;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Principal {
    private final FuncionarioController controller = new FuncionarioController();
    private final FuncionarioSeed seed = new FuncionarioSeed();

    public void executar() {
        System.out.println("\n 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima. \n");
        List<Funcionario> funcionarios = seed.gerarFuncionarios();

        System.out.println("\n 3.2 – Remover o funcionário “João” da lista. \n");
        controller.removerFuncionario(funcionarios, "João");

        System.out.println("3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:");
        System.out.println("\n • informação de data deve ser exibido no formato dd/mm/aaaa;");
        System.out.println("\n • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula. \n");
        controller.imprimirFuncionarios(funcionarios);

        System.out.println("\n 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor. \n");
        controller.aplicarAumento(funcionarios, new BigDecimal("0.10"));

        System.out.println("\n 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”. \n");
        Map<String, List<Funcionario>> agrupadosPorFuncao = controller.agruparPorFuncao(funcionarios);

        System.out.println("\n 3.6 – Imprimir os funcionários, agrupados por função. \n");
        controller.imprimirAgrupados(agrupadosPorFuncao);

        System.out.println("\n 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12. \n");
        controller.imprimirAniversariantes(funcionarios);

        System.out.println("\n 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade. \n");
        controller.imprimirMaisVelho(funcionarios);

        System.out.println("\n 3.10 – Imprimir a lista de funcionários por ordem alfabética. \n");
        controller.imprimirOrdemAlfabetica(funcionarios);

        System.out.println("\n 3.11 – Imprimir o total dos salários dos funcionários. \n");
        controller.imprimirTotalSalarios(funcionarios);

        System.out.println("\n 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00. \n");
        controller.imprimirSalariosMinimos(funcionarios);
    }
}

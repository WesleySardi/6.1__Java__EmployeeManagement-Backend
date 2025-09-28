package Services;

import Entities.Funcionario;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
    private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
    private final DecimalFormat formatoSalario = new DecimalFormat("#,##0.00", symbols);

    private final BigDecimal salarioMinimo = new BigDecimal("1212.00");

    public void imprimirTitulo(String titulo) {
        System.out.println("--- " + titulo + " ---\n");
    }

    public void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        imprimirTitulo("Remove funcionário " + nome);
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            String dataFormatada = f.getDataNascimento().format(formatoData);
            String salarioFormatado = formatoSalario.format(f.getSalario());
            System.out.println(f.getNome() + " | " + dataFormatada + " | R$ " + salarioFormatado + " | " + f.getFuncao());
        }
    }

    public void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentual) {
        imprimirTitulo("Aplica aumento");
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(BigDecimal.ONE.add(percentual))));

        imprimirFuncionarios(funcionarios);
    }

    public void imprimirAgrupados(Map<String, List<Funcionario>> agrupados) {
        agrupados.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        var agrupados = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        imprimirTitulo("Agrupa por função");
        imprimirAgrupados(agrupados);

        return agrupados;
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        imprimirTitulo("Aniversariantes (outubro e dezembro)");
        Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
        funcionarios.stream()
                .filter(f -> mesesSet.contains(f.getDataNascimento().getMonthValue()))
                .collect(Collectors.toList()).forEach(f -> System.out.println(f.getNome()));
    }

    public void imprimirMaisVelho(List<Funcionario> funcionarios) {
        imprimirTitulo("Mais velho");
        var maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        int idade = java.time.Period.between(maisVelho.getDataNascimento(), java.time.LocalDate.now()).getYears();

        System.out.println(maisVelho.getNome() + " - " + idade + " anos");
    }

    public void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        imprimirTitulo("Ordem alfabética");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList()).forEach(f -> System.out.println(f.getNome()));
    }

    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        imprimirTitulo("Total salários");
        System.out.println(funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        imprimirTitulo("Salários mínimos");
        for (Funcionario f : funcionarios) {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos");
        }
    }
}

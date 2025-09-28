package Controllers;

import Entities.Funcionario;
import Services.FuncionarioService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FuncionarioController {
    private final FuncionarioService service = new FuncionarioService();

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return service.agruparPorFuncao(funcionarios);
    }

    public void imprimirAgrupados(Map<String, List<Funcionario>> agrupados) {
        service.imprimirAgrupados(agrupados);
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios) {
        service.imprimirAniversariantes(funcionarios, 10, 12);
    }

    public void imprimirMaisVelho(List<Funcionario> funcionarios) {
        service.imprimirMaisVelho(funcionarios);
    }

    public void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        service.imprimirOrdemAlfabetica(funcionarios);
    }

    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        service.imprimirTotalSalarios(funcionarios);
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        service.imprimirSalariosMinimos(funcionarios);
    }

    public void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        service.removerFuncionario(funcionarios, nome);
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        service.imprimirFuncionarios(funcionarios);
    }

    public void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentual) {
        service.aplicarAumento(funcionarios, percentual);
    }
}

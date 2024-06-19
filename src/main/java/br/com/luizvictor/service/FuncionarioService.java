package br.com.luizvictor.service;

import br.com.luizvictor.entities.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuncionarioService {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void adicionar(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            adicionar(funcionario);
        }
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }

    public void remover(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void ajustarSalario() {
        funcionarios.forEach(funcionario -> {
            BigDecimal ajuste = funcionario.getSalario().multiply(BigDecimal.valueOf(1.1));
            funcionario.ajustarSalario(ajuste);
        });
    }

    private Map<String, List<Funcionario>> agrupar() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void exibirAgrupadosPorFuncao(DateTimeFormatter formatter) {
        System.out.println("|---------------------------------|");
        System.out.println("| Exibindo funcionários agrupados |");
        System.out.println("|---------------------------------|");
        Map<String, List<Funcionario>> map = agrupar();
        for (Map.Entry<String, List<Funcionario>> entry : map.entrySet()) {
            System.out.println("Função: " + entry.getKey());

            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("  Nome: " + funcionario.getNome());
                System.out.println("  Data de Nascimento: " + funcionario.getDataNascimento().format(formatter));
                System.out.println("  Salário: " + String.format("%,.2f", funcionario.getSalario()));
                System.out.println();
            }
        }
    }

    public List<Funcionario> aniversariantes10e12() {
        return funcionarios.stream().filter(funcionario -> {
            Month mesAniversario = funcionario.getDataNascimento().getMonth();
            return mesAniversario == Month.OCTOBER || mesAniversario == Month.DECEMBER;
        }).toList();
    }

    public void maiorIdade() {
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (maisVelho != null) {
            Period idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now());
            System.out.println("|-------------------------------|");
            System.out.println("| Funcionário com a maior idade |");
            System.out.println("|-------------------------------|");
            System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade.getYears() + " anos");
            System.out.println();
        }
    }

    public List<Funcionario> exibirPorOrdemAlfabetica() {
        return funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).toList();
    }

    public void totalSalario() {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        System.out.println("|--------------------|");
        System.out.println("| Total dos salários |");
        System.out.println("|--------------------|");
        System.out.println("Total: " + String.format("%,.2f", totalSalarios));
        System.out.println();
    }
}

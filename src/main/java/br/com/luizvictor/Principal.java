package br.com.luizvictor;

import br.com.luizvictor.entities.Funcionario;
import br.com.luizvictor.service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Principal {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista");
        Funcionario heitor = new Funcionario("Heítor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente");
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.94), "Gerente");

        FuncionarioService service = new FuncionarioService();
        service.adicionar(Arrays.asList(maria, joao, caio, miguel, alice, heitor, arthur, laura, heloisa, helena));

        service.remover(joao);

        System.out.println("|-----------------------|");
        System.out.println("| Listando funcionários |");
        System.out.println("|-----------------------|");
        exibir(service.listar());

        service.ajustarSalario();
        System.out.println("|---------------------------|");
        System.out.println("| Salário com ajuste de 10% |");
        System.out.println("|---------------------------|");
        exibir(service.listar());

        service.exibirAgrupadosPorFuncao(formatter);

        System.out.println("|---------------------------------------------------|");
        System.out.println("| Funcionários que fazem aniversário no mês 10 e 12 |");
        System.out.println("|---------------------------------------------------|");
        exibir(service.aniversariantes10e12());

        service.maiorIdade();

        System.out.println("|-----------------------------------|");
        System.out.println("| Funcionários por ordem alfabética |");
        System.out.println("|-----------------------------------|");
        exibir(service.exibirPorOrdemAlfabetica());

        service.totalSalario();
    }

    public static void exibir(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(formatter));
            System.out.println("Salario: " + String.format("%, .2f", funcionario.getSalario()));
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println();
        }
    }
    

}
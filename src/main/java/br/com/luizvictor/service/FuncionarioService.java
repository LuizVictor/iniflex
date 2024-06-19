package br.com.luizvictor.service;

import br.com.luizvictor.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;

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
}

package service;

import model.AlunoModel;
import model.PessoaModel;
import repository.PessoaRepository;

import java.util.Objects;

public class PessoaService {

    private PessoaRepository repository;

    public PessoaService() {
        this.repository = new PessoaRepository();
    }

    public void armazenarDados(PessoaModel pessoaModel, String notaFinal) {
        if (!notaFinal.isBlank()) {
            AlunoModel alunoModel = new AlunoModel(pessoaModel, Double.parseDouble(notaFinal));
            repository.armazenarPessoa(alunoModel);
        } else {
            repository.armazenarPessoa(pessoaModel);
        }
    }

    public PessoaModel[] retornarDados() {
        return repository.retornarArray();
    }
}

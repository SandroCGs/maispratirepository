package service;

import model.AlunoModel;
import model.PessoaModel;
import repository.PessoaRepository;

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

    public void modificarDados(PessoaModel pessoaNova, String notaFinal, int id) {
        if (!notaFinal.isBlank()) {
            AlunoModel alunoModel = new AlunoModel(pessoaNova, Double.parseDouble(notaFinal));
            alunoModel.setDataCadastro(repository.getDataCadastro(id));
            repository.alterarPessoa(alunoModel, id);
        } else {
            pessoaNova.setDataCadastro(repository.getDataCadastro(id));
            repository.alterarPessoa(pessoaNova, id);
        }
    }

    public void deletarDados(int id) {
        repository.deletarCadastro(id);
    }
}
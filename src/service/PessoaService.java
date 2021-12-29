package service;

import model.AlunoModel;
import model.PessoaModel;

import java.util.Objects;

public class PessoaService {

    public PessoaService() {
    }

    public void armazenarPessoa(PessoaModel pessoaModel, Double notaFinal) {
        if (Objects.nonNull(notaFinal)){
            AlunoModel alunoModel = new AlunoModel(pessoaModel, notaFinal);
//            TODO: chamar repositório mandando aluno
        } else {
//            TODO: chamar repositório mandano pessoa
        }
    }
}

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
//            TODO: chamar reposit�rio mandando aluno
        } else {
//            TODO: chamar reposit�rio mandano pessoa
        }
    }
}

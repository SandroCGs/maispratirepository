package repository;

import exception.RegraNegocioException;
import model.PessoaModel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class PessoaRepository {

    private PessoaModel[] arrayBase;

    public PessoaRepository() {
        arrayBase = new PessoaModel[2];
    }

    public void armazenarPessoa(PessoaModel pessoaModel) {
        for (int i = 0; i < arrayBase.length; i++) {
            if (arrayBase[i] == null) {
                arrayBase[i] = pessoaModel;
                break;
            } else if (arrayBase[(arrayBase.length - 1)] != null) {
                ampliarArray();
            }
        }
    }

    public void alterarPessoa(PessoaModel pessoaNova, int id) {
        PessoaModel pessoaModel = arrayBase[id];
        if (Objects.nonNull(pessoaModel)) {
            arrayBase[id] = pessoaNova;
        } else {
            throw new RegraNegocioException("Pessoa não encontrada!");
        }
    }

    public LocalDate getDataCadastro(int id) {
        return arrayBase[id].getDataCadastro();
    }

    private void ampliarArray() {
        PessoaModel[] novoArray = Arrays.copyOf(this.arrayBase, this.arrayBase.length * 2);
        this.arrayBase = novoArray;
    }

    public PessoaModel[] retornarArray() {
        return arrayBase.clone();
    }

    public void deletarCadastro(int id) {
        arrayBase[id] = null;
    }
}
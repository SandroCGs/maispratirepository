package repository;

import model.PessoaModel;

import java.util.Arrays;

public class PessoaRepository {

    PessoaModel [] arrayBase;

    public PessoaRepository(){
        PessoaModel [] arrayBase = new PessoaModel[1];
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

    private void ampliarArray() {
        PessoaModel[] novoArray = Arrays.copyOf(this.arrayBase, this.arrayBase.length * 2);
        this.arrayBase = novoArray;
    }
}
package model;

public class AlunoModel extends PessoaModel {

    private double notaFinal;

    public AlunoModel(PessoaModel pessoaModel, double notaFinal) {
        super(pessoaModel);
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return " * Aluno * || " +
                super.toString() +
                " || Nota Final: " + notaFinal;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }
}

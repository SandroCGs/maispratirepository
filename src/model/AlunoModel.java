package model;

public class AlunoModel extends PessoaModel {

	private double notaFinal;

	public AlunoModel(PessoaModel pessoaModel, double notaFinal) {
		super(pessoaModel);
		this.notaFinal = notaFinal;
	}
	
	public Double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}
}

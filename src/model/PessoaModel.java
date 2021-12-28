package model;

import view.PessoaView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaModel {

		private String nome;
		private String telefone;
		private LocalDate dataNascimento;
		private LocalDate dataCadastro;
		private LocalDateTime ultimaAlteracao;
		
		public PessoaModel() {
		}

		public PessoaModel(String nome, String telefone, LocalDate dataNascimento, LocalDate dataCadastro,
						   LocalDateTime ultimaAlteracao) {
			this.nome = nome;
			this.telefone = telefone;
			this.dataNascimento = dataNascimento;
			this.dataCadastro = dataCadastro;
			this.ultimaAlteracao = ultimaAlteracao;
		}

		public PessoaModel(PessoaModel pessoaModel){
			this.nome = pessoaModel.getNome();
			this.telefone = pessoaModel.getTelefone();
			this.dataCadastro = pessoaModel.getDataCadastro();
			this.dataNascimento = pessoaModel.getDataNascimento();
			this.ultimaAlteracao = pessoaModel.getUltimaAlteracao();
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public LocalDate getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public LocalDate getDataCadastro() {
			return dataCadastro;
		}
		public void setDataCadastro(LocalDate dataCadastro) {
			this.dataCadastro = dataCadastro;
		}
		public LocalDateTime getUltimaAlteracao() {
			return ultimaAlteracao;
		}
		public void setUltimaAlteracao(LocalDateTime ultimaAlteracao) {
			this.ultimaAlteracao = ultimaAlteracao;
		}
}
package view;

import model.PessoaModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PessoaView {

	Scanner scanner;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public PessoaView() {
		this.scanner = new Scanner(System.in);
	}

	public void menuStart (){
		int func = 1;
		while (func != 0) {
			System.out.print("1 - Criar cadastro.\n2 - Mostrar todos cadastros.\n3 - Atualizar dado cadastrado.\n3 - Deletar Cadastro.\n4 - Encerrar aplicação.\n Digite a função que você deseja executar: ");
			func = scanner.nextInt();
			if (func == 1) {
				cadastroPessoa ();

			}
			else if (func == 2) {

			}
			else if (func == 3) {
				atualizarPessoa();

			}
			else if (func == 0) {
				System.out.println("Encerrar aplicação");
				scanner.close();

			}
			else {
				System.out.println("Digito inválido\n");
			}
		}
	}

	private void atualizarPessoa() {
		PessoaModel pessoaNova = getPessoa();
//	TODO: chamar metódo responsável por atualizar
	}

	private void cadastroPessoa () {
		PessoaModel pessoa = getPessoa();
		pessoa.setDataCadastro(LocalDate.now());

		System.out.println("Digite a nota final caso haja uma, ou somente aperte enter: ");
		Double notaFinal = scanner.nextDouble();
//		TODO: chamar método responsável por armazenar
	}

	private PessoaModel getPessoa() {
		PessoaModel pessoaModel = new PessoaModel();

		System.out.println("Digite o nome: ");
		String nome = scanner.nextLine();
		pessoaModel.setNome(nome);

		System.out.println("Digite o telefone: ");
		String telefone = scanner.nextLine();
		pessoaModel.setTelefone(telefone);

		System.out.println("Digite a data de nascimento: ");
		String dataNascimentoS = scanner.nextLine();
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoS, format);
		pessoaModel.setDataNascimento(dataNascimento);

		LocalDateTime ultimaAlteracao = LocalDateTime.now();
		pessoaModel.setUltimaAlteracao(ultimaAlteracao);

		return pessoaModel;
	}
}
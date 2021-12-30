package view;

import model.PessoaModel;
import service.PessoaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PessoaView {

    private Scanner scanner;
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private PessoaService pessoaService;

    public PessoaView() {
        this.scanner = new Scanner(System.in);
        this.pessoaService = new PessoaService();
    }

    public void menuStart() {
        int func = 1;
        while (func != 0) {

            System.out.print("1 - Criar cadastro.\n2 - Mostrar todos cadastros.\n3 - Atualizar dado cadastrado.\n3 - Deletar Cadastro.\n4 - Encerrar aplicação.\n Digite a função que você deseja executar: ");
            func = scanner.nextInt();
            scanner.nextLine();

            if (func == 1) {
                cadastrarPessoa();
            } else if (func == 2) {
            } else if (func == 3) {
                atualizarPessoa();
            } else if (func == 0) {
                System.out.println("Encerrar aplicação");
                scanner.close();
            } else {
                System.out.println("Digito inválido\n");
            }
        }
    }

    private void atualizarPessoa() {
        PessoaModel pessoaNova = getPessoa();

//	TODO: chamar metódo responsável por atualizar
    }

    private void cadastrarPessoa() {
        PessoaModel pessoa = getPessoa();
        pessoa.setDataCadastro(LocalDate.now());

        String notaFinal = perguntarNota();

        pessoaService.armazenarDados(pessoa, notaFinal);
    }

    private String perguntarNota() {
        System.out.println("Digite a nota final caso haja uma, ou somente aperte enter: ");
        return scanner.nextLine();
    }

    private PessoaModel getPessoa() {
        PessoaModel pessoaModel = new PessoaModel();

        System.out.println("\nDigite o nome: ");
        String nome = scanner.nextLine();
        pessoaModel.setNome(nome);

        System.out.println("Digite o telefone (modelo (51)33077964 ou (51)993077964): ");
        String telefone = scanner.nextLine();
        pessoaModel.setTelefone(telefone);

        System.out.println("Digite a data de nascimento (modelo 23/05/1995): ");
        String nascimentoInput = scanner.nextLine();

        LocalDate dataNascimento = LocalDate.parse(nascimentoInput, FORMAT);
        pessoaModel.setDataNascimento(dataNascimento);

        LocalDateTime ultimaAlteracao = LocalDateTime.now();
        pessoaModel.setUltimaAlteracao(ultimaAlteracao);

        return pessoaModel;
    }
}
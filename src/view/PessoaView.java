package view;

import exception.RegraNegocioException;
import model.PessoaModel;
import service.PessoaService;
import validation.InputValidation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
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
            System.out.print("1 - Criar cadastro.\n2 - Mostrar todos cadastros.\n3 - Atualizar dado cadastrado.\n4 - Deletar Cadastro.\n0 - Encerrar aplicação.\n Digite a função que você deseja executar: ");
            try {
                func = scanner.nextInt();
                scanner.nextLine();
                if (func == 1) {
                    cadastrarPessoa();
                } else if (func == 2) {
                    mostrarPessoas();
                } else if (func == 3) {
                    atualizarPessoa();
                } else if (func == 4) {
                    deletarPessoa();
                } else if (func == 0) {
                    System.out.println("\nEncerrando aplicação. Até logo!");
                    scanner.close();
                } else {
                    System.out.println("\nDigito inválido!");
                }
                System.out.println("");
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException ex) {
                scanner.nextLine();
                System.out.println("\nOpção inválida!\n");
            }
        }
    }

    private void mostrarPessoas() {
        System.out.println("");
        PessoaModel[] pessoaModels = pessoaService.retornarDados();
        for (int i = 0; i < pessoaModels.length; i++) {
            PessoaModel pessoaModel = pessoaModels[i];
            if (pessoaModel != null) {
                descreverPessoa(pessoaModel, i);
            }
        }
    }

    private void descreverPessoa(PessoaModel pessoaModel, int id) {
        System.out.println(String.format("id = %d || %s", id, pessoaModel));
    }

    private void atualizarPessoa() {
        System.out.println("\nQual o ID cadastrado você pretende modificar? ");
        int id = scanner.nextInt();
        scanner.nextLine();

        PessoaModel pessoa = getPessoa();
        pessoa.setDataCadastro(LocalDate.now());
        String notaFinal = perguntarNota();
        try {
            pessoaService.modificarDados(pessoa, notaFinal, id);
            System.out.println("Registro atualizado com sucesso!");
        } catch (RegraNegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String perguntarNota() {
        System.out.println("Digite a nota final caso haja uma, ou somente aperte enter: ");
        return scanner.nextLine();
    }

    private void cadastrarPessoa() {
        try {
            PessoaModel pessoa = getPessoa();
            pessoa.setDataCadastro(LocalDate.now());

            String notaFinal = perguntarNota();
            InputValidation.validaNota(notaFinal);

            pessoaService.armazenarDados(pessoa, notaFinal);
        } catch (RegraNegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private PessoaModel getPessoa() {
        PessoaModel pessoaModel = new PessoaModel();

        System.out.println("\nDigite o nome: ");
        String nome = scanner.nextLine();
        pessoaModel.setNome(nome);

        System.out.println("Digite o telefone (modelo (51)33077964 ou (51)993077964): ");
        String telefone = scanner.nextLine();
        InputValidation.validaTelefone(telefone);
        pessoaModel.setTelefone(telefone);

        System.out.println("Digite a data de nascimento (modelo 23/05/1995): ");
        String nascimentoInput = scanner.nextLine();

        LocalDate dataNascimento = InputValidation.validaData(nascimentoInput);
        pessoaModel.setDataNascimento(dataNascimento);

        LocalDateTime ultimaAlteracao = LocalDateTime.now();
        pessoaModel.setUltimaAlteracao(ultimaAlteracao);

        return pessoaModel;
    }

    private void deletarPessoa() {
        int id;
        System.out.println("\nQual o ID cadastrado você pretende deletar? ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Tem certeza que quer deletar esse registro? Digite s para confirmar: ");
        String confirm = scanner.next();
        if ("s".equalsIgnoreCase(confirm)) {
            pessoaService.deletarDados(id);
            System.out.println("\nRegistro deletado com sucesso!");
        } else {
            System.out.println("\nOperação cancelada!");
        }
    }
}
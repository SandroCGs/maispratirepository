package menu;
import java.util.Scanner;

public class Main {

		public static void main (String [] args) {
			
			Scanner input = new Scanner(System.in);
			int func = 1;
			
			while (func != 0) {
				System.out.print("1 - Criar cadastro.\n2 - Mostrar todos cadastros.\n3 - Atualizar dado cadastrado.\n3 - Deletar Cadastro.\n4 - Encerrar aplicação.\n Digite a função que você deseja executar:");
				func = Integer.parseInt(input.nextLine());
				System.out.println("");
				if (func == 1) {
					System.out.println("Função 1");	
				}
				else if (func == 2) {
					System.out.println("Função 2");
					
				}
				else if (func == 3) {
					System.out.println("Função 3");
					
				}
				else if (func == 0) {
					System.out.println("Encerrar aplicação");
					input.close();
				}
				else {
					System.out.println("Digito inválido\n");	
				}	
			}
		}
	
}

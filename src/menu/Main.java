package menu;
import java.util.Scanner;

public class Main {

		public static void main (String [] args) {
			
			Scanner input = new Scanner(System.in);
			int func = 1;
			
			while (func != 0) {
				System.out.print("1 - Criar cadastro.\n2 - Mostrar todos cadastros.\n3 - Atualizar dado cadastrado.\n3 - Deletar Cadastro.\n4 - Encerrar aplica��o.\n Digite a fun��o que voc� deseja executar:");
				func = Integer.parseInt(input.nextLine());
				System.out.println("");
				if (func == 1) {
					System.out.println("Fun��o 1");	
				}
				else if (func == 2) {
					System.out.println("Fun��o 2");
					
				}
				else if (func == 3) {
					System.out.println("Fun��o 3");
					
				}
				else if (func == 0) {
					System.out.println("Encerrar aplica��o");
					input.close();
				}
				else {
					System.out.println("Digito inv�lido\n");	
				}	
			}
		}
	
}

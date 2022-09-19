
package Main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//TODO arrumar a baixa do estoque para quando nao tiver estoque o suficiente (bug) 
//TODO ao escolher uma opção no menu, não sendo int o sistema quebra (bug)
//TODO ao escolher um produto, digitar a quantidade, se tiver mais que o suficiente no estoque, ele diz " Não tem quantidade o suficiente", mas embora
// ele dá uma mensagem que foi adicionado na lista de compras.(bug)
//TODO criar metodo para receber o valor pago e calcular o troco (funcionalidade)
//TODO criar metodo que defina a menor quantidade de notas possivel para o troco (funcionalidade dificil)
//      Notas possiveis = 100,50,20,10,5,2,1,0.5,0.25,0.1,0.05 e 0.01;
        Menu.controleMenu();
    
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
    
      double conta, pago;
      int moeda;
      
    try { 
    	System.out.printf("Infome o Valor da Conta: ");
    	conta = sc.nextDouble();
    	
    	System.out.printf("Informe o Valor Pago....: ");
    	pago = sc.nextDouble();
    	
    	System.out.printf("%s", calculaTroco(conta, pago));
    }
     catch (Exception e) {
    	 System.err.printf("\nerro: dados informados inválidos !\n");
    	 
     }
   
    }

	private static Object calculaTroco(double conta, double pago) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}


	

	
	

	
	

	
	

	
	

	

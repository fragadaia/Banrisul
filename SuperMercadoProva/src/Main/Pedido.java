package Main;

import Utils.Inputs;
import java.util.ArrayList;
import java.lang.invoke.*;

public class Pedido {

    private static ArrayList<Item> listaDeItens = new ArrayList<Item>();
    private static double valorTotalDoPedido = 0;
	private static double pago;

    public static void calculaValorTotal() {
        double subTotal = 0;
        for (Item item : listaDeItens) {
            subTotal += item.getValorDoItem();
        }
        valorTotalDoPedido = subTotal;
		
    }
    private static String CalculaTroco(double conta) {
    
    	if(pago < conta)
    		return("\nPagamento insuficiente, Falta R$" + (conta - pago) + "\n");
    	else {
    		int moeda[] = {100,50,20,10,5,2,1};
    		double centavos[] = {0.5,0.25,0.1,0.05,0.01};
    		
    		String result;
    		double troco;
    		int i;
			double vlr;
    		double ct;
    		double pago = 0;
    		
    		troco = pago - conta;
    		result = "\nTroco = R$" + (troco) +"\n\n";
    	
    		 vlr = (int)troco;
    	      i = 0;
    	      while (vlr != 0) {
    	        double[] nota = null;
				ct = vlr / nota[i]; 
    	        if (ct != 0) {
    	           result = result + (ct +"nota(s) de R$"+ nota[i] +"\n");
    	           vlr = vlr % nota[i]; 
    	        }
    	        i = i + 1;  
    	      }

    	      result = result +"\n";
    	      vlr = (int)Math.round((troco - (int)troco) * 100);
    	      i = 0;
    	      while (vlr != 0) {
    	        ct = vlr / centavos[i]; 
    	        if (ct != 0) {
    	           result = result + (ct +"moeda(s) de"+ centavos[i] +
    	           "centavo(s)\n");
    	           vlr = vlr % centavos[i];
    	        }
    	        i = i + 1; 
    	      }

    	      return(result);
    	    }
    	  }
    
 
    public static boolean adicionaItemNaLista(Produto produto, int quantidade) {
    	boolean deuBaixa = false;
    	for (Item item : listaDeItens) {
            if (item.getProduto().getNome().equalsIgnoreCase(produto.getNome())) {
                deuBaixa = Estoque.darBaixaEmEstoque(item.getProduto().getId(), quantidade);
                if (deuBaixa) {
                	item.setQuantidade(item.getQuantidade() + quantidade);
                    item.defineValorTotal();
                    System.out.println("Foi adicionada a quantidade ao item já existente.");
                    return false;
                } 
                return false;
            }
        }
       
        deuBaixa = Estoque.darBaixaEmEstoque(produto.getId(), quantidade);
        if (deuBaixa) {
        	listaDeItens.add(new Item(produto, quantidade));
        	 System.out.println("Foi adicionado o produto na lista de compras.");
             return true;
        }
		return deuBaixa;
    }

    public static void imprimePedido() {
        System.out.println("                              NOTA FISCAL");
        System.out.printf("ID       |NOME            |PRECO UN           |QUANTIDADE   |PRECO ITEM \n");
        for (Item item : listaDeItens) {
            System.out.printf("%-8d | %-14s | R$%-15.2f | %-10d  | R$%.2f\n"
                    , item.getProduto().getId(), item.getProduto().getNome(), item.getProduto().getPreco(), item.getQuantidade(), item.getValorDoItem());
        }
        imprimeValorTotal();
    }

    private static void imprimeValorTotal() {
        System.out.println();
        System.out.printf("Total: R$%.2f", valorTotalDoPedido);
        System.out.println("________________________________________________________________________");
        System.out.println();
        System.out.println();
    }

    public static void adicionaItem(){
        String nome = recebeNomeDoTeclado();
        int quantidade = recebeQuantidadeDoTeclado();
        Produto produto = Estoque.encontraProduto(nome);
        if(produto != null){
            adicionaItemNaLista(produto,quantidade);
            calculaValorTotal();
        } else {
            System.out.println("Produto nao encontrado");
        }

    }

    public static String recebeNomeDoTeclado(){
        System.out.print("Digite o nome: ");
        return Inputs.inputString();
    }


    public static int recebeQuantidadeDoTeclado(){
        System.out.print("Digite a quantidade: ");
        return Inputs.inputInt();
    }

    public void limparCarrinho() {
        listaDeItens.clear();
    }

    public static ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        Pedido.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        Pedido.valorTotalDoPedido = valorTotalDoPedido;
    }
      
    public static String calculaTroco() {
		return Pedido.calculaTroco();
		
	}
	 
		
	}
	
		
	
      
	
	
		
	


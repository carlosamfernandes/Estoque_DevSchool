import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws DivergenciaException {
		
		ArrayList<Produto> produtos = new ArrayList<Produto>(); 
		
		int opcao = 0;
		//abertura try catch
		try {
			do {
				
				if(opcao > 7) {
					throw new DivergenciaException("A opção digitada é inválida!");
				}
				System.out.println("### Menu ###");
				System.out.println("1 - Cadastrar produto");
				System.out.println("2 - Listar produtos");
				System.out.println("3 - Alterar nome do produto");
				System.out.println("4 - Excluir produto");
				System.out.println("5 - Compra (aumentar a quantidade)");
				System.out.println("6 - Venda (diminuir a quantidade)");
				System.out.println("7 - Sair\n");
						
				Scanner ler = new Scanner(System.in);
				opcao = ler.nextInt();
					
				switch (opcao) {
				//Adicionar produtos
				case 1:
					System.out.println("Inserir nome do produto: ");
					String nomeProduto = ler.next();
					System.out.println("Inserir quantidade do produto: ");
					int quantidadeProduto = ler.nextInt();
					System.out.println("Inserir preço do produto (com vírgula): ");
					double precoProduto = ler.nextDouble();
					
					Produto produto = new Produto(nomeProduto, quantidadeProduto, precoProduto);
					//System.out.println("O produto foi cadastrado!\n");
					
					produtos.add(produto);
					
					break;
				
				//Listar produtos
				case 2:
					int n = produtos.size();
					for (int i = 0; i < n; i++) {
						System.out.println("Id e nome: " + i + " - " + produtos.get(i).getNomeProduto());
						System.out.println("Quantidade: " + produtos.get(i).getQuantidadeProduto());
						System.out.println("Preço: " + produtos.get(i).getPrecoProduto() + "\n");
					}
					break;
				
				//Alterar nome do produto
				case 3:
					System.out.println("Inserir o id do produto que deseja alterar o nome: ");
					int idProdutoAlterar = ler.nextInt();
					System.out.println("Inserir o novo nome: ");
					String nomeProdutoAlterar = ler.next();
					produtos.get(idProdutoAlterar).setNomeProduto(nomeProdutoAlterar);
					
					System.out.println("Nome alterado!\n");
					System.out.println("Id e nome: " + idProdutoAlterar + " - " + produtos.get(idProdutoAlterar).getNomeProduto());
					System.out.println("Quantidade: " + produtos.get(idProdutoAlterar).getQuantidadeProduto());
					System.out.println("Preço: " + produtos.get(idProdutoAlterar).getPrecoProduto() + "\n\n");
					break;
				
				//Excluir produto
				case 4:
					System.out.println("Inserir o id do produto que deseja excluir: ");
					int idProdutoRemover = ler.nextInt();
					produtos.remove(idProdutoRemover);
					System.out.println("Produto excluído!\n");
					//break;
				
				//Compra - aumentar estoque	
				case 5:
					System.out.println("Inserir o id do produto que deseja alterar o estoque: ");
					int idProdutoAddEstoque = ler.nextInt();
					System.out.println("Quantidade atual: " + produtos.get(idProdutoAddEstoque).getQuantidadeProduto());
					
					System.out.println("Inserir a quantidade que deseja adicionar: ");
					int quantidadeProdutoAdd = ler.nextInt();
					try {
						produtos.get(idProdutoAddEstoque).adicionaProduto(quantidadeProdutoAdd);
						
						System.out.println("Compra efetuada - Estoque aumentado!\n");
						System.out.println("Id e nome: " + idProdutoAddEstoque + " - " + produtos.get(idProdutoAddEstoque).getNomeProduto());
						System.out.println("Nova quantidade: " + produtos.get(idProdutoAddEstoque).getQuantidadeProduto() + "\n");
					} catch (DivergenciaException ex) {
						System.out.println(ex.getMessage());
					}
					
					break;
					
				//Venda - diminuir estoque	
				case 6:
					System.out.println("Inserir o id do produto que deseja alterar o estoque: ");
					int idProdutoRemoveEstoque = ler.nextInt();
					System.out.println("Quantidade atual: " + produtos.get(idProdutoRemoveEstoque).getQuantidadeProduto());
					
					System.out.println("Inserir a quantidade que deseja remover: ");
					int quantidadeProdutoRemover = ler.nextInt();
					
					try {
						produtos.get(idProdutoRemoveEstoque).removeQuantidadeProduto(quantidadeProdutoRemover);
						
						System.out.println("Venda efetuada - Estoque diminuído!\n");
						System.out.println("Id e nome: " + idProdutoRemoveEstoque + " - " + produtos.get(idProdutoRemoveEstoque).getNomeProduto());
						System.out.println("Nova quantidade: " + produtos.get(idProdutoRemoveEstoque).getQuantidadeProduto() + "\n");
						} catch (DivergenciaException ex) {
							System.out.println(ex.getMessage());
						}
					break;
					
				//Sair
				case 7:
					break;
		
				default:
					break;
				}
				
			} while (opcao !=7);
			
			//fechamento do try catch
		} catch (DivergenciaException ex) {
			System.out.println(ex.getMessage());
		}
	}



}

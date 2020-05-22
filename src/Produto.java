import java.util.ArrayList;
import java.util.Scanner;

public class Produto {

	private int quantidadeProduto;
	private String nomeProduto;
	private double precoProduto; 
	
	//Construtor do produto 
	public Produto(String nomeProduto, int quantidadeProduto, double precoProduto) {
		this.nomeProduto = nomeProduto;
		if(quantidadeProduto <= 0) {
			System.out.println("Não é permitido estoque negativo!\n");
			return;
		}else {
			this.quantidadeProduto = quantidadeProduto;
		}
		if (precoProduto <= 0) {
			System.out.println("Não é permitido preço negativo!\n");
			return;
		}else {
			this.precoProduto = precoProduto;
			System.out.println("O produto foi cadastrado!\n");
		}	
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	//Adicionar e Remover produtos com tratamento 
	
	public void adicionaProduto(int quantidadeProduto) throws DivergenciaException{
	this.quantidadeProduto += quantidadeProduto;
	}
	
	public void removeQuantidadeProduto(int quantidadeRemovida) throws DivergenciaException{
	if (this.quantidadeProduto < quantidadeRemovida) {
		throw new DivergenciaException("Quantidade insuficiente! Deseja remover: " + quantidadeRemovida + " Estoque: " + this.quantidadeProduto + "\n");
	}
	this.quantidadeProduto -= quantidadeRemovida;
	}
	
	
}
	



	


	
	

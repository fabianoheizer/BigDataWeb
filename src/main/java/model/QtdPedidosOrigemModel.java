package model;

import java.util.ArrayList;
import java.util.List;

import entities.QtdPedidosOrigem;
import util.LeitorArquivoCSVQtdPedidosOrigem;

public class QtdPedidosOrigemModel {

	public List<QtdPedidosOrigem> findAll(){
		List<QtdPedidosOrigem> produtosOrigem = new ArrayList<QtdPedidosOrigem>();
		
		LeitorArquivoCSVQtdPedidosOrigem leitorArq = new LeitorArquivoCSVQtdPedidosOrigem();
		produtosOrigem = leitorArq.lerArquivoQtdPedidosOrigem();
		
		return produtosOrigem;
	}
	
}

package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.QtdPedidosOrigem;

public class LeitorArquivoCSVQtdPedidosOrigem 
{
	
	public List<QtdPedidosOrigem> lerArquivoQtdPedidosOrigem()
	{
		List<QtdPedidosOrigem> pedidosOrigem = new ArrayList<QtdPedidosOrigem>();
		BufferedReader br = null;
		
		String pathResource = "Arquivos/qtd_pedidos_origem/";
		String nomeArquivoCSV = "qtd_pedidos_origem.csv";
		
		String arquivo = getClass().getClassLoader().getResource( pathResource + nomeArquivoCSV ).getFile();
		
	    try {
	    		String linha = "";
		    String csvDivisor = ",";
		    
		    br = new BufferedReader(new FileReader( arquivo ));
		    
		    while ((linha = br.readLine()) != null) 
		    {
		    		QtdPedidosOrigem qtdPedidosOrigem = new QtdPedidosOrigem();
	            String[] conteudoArq = linha.split(csvDivisor);
	            
	            if( "12".equals(conteudoArq[0]) ) {
	            		qtdPedidosOrigem.setOrigem("Web");
	            		qtdPedidosOrigem.setQuantidade_pedidos( Integer.parseInt(conteudoArq[1]) );
	            		pedidosOrigem.add(qtdPedidosOrigem);
	            }
	            
	            if( "14".equals(conteudoArq[0]) ) {
	            		qtdPedidosOrigem.setOrigem("Mobile");
	            		qtdPedidosOrigem.setQuantidade_pedidos( Integer.parseInt(conteudoArq[1]) );
	            		pedidosOrigem.add(qtdPedidosOrigem);
	            }
	        }

	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    } 
	    finally {
	        if (br != null) {
	            try {
	                br.close();
	            } 
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		return pedidosOrigem;
	}
	
}

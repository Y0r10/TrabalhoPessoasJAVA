package br.ifpr.execucao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;


public class ExcluirPessoa {

	public static void main(String[] args) throws IOException, NumberFormatException, SQLException {
		//1- Ler o ID da pessoa que será excluída
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("Informe o ID da pessoa a ser excluída: ");
		String id = reader.readLine();
		Integer idInt = Integer.parseInt(id);
		
		//2- Verificar se o ID produto existe
		PessoaDAO pesDao = new PessoaDAO();
		Pessoa pes = pesDao.buscar(idInt);
		
		if(pes != null) { //Produto existe na base de dados
			//Preciso excluir o produto
			pesDao.excluir(idInt);
			System.out.println("A pessoa de ID = " + id +
					" foi excluída com sucesso.");
			
		} else { //Produto NULL = não existe
			System.out.println("A pessoa de ID = " + id + 
					" não foi encontrada.");
		}

	}

}

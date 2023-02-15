package br.ifpr.execucao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;

public class BuscarPessoa {

	public static void main(String[] args) 
			throws IOException, NumberFormatException, SQLException {
		//1- Ler um ID de uma pessoa que será buscada
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("Informe o ID do produto a ser buscado: ");
		String id = reader.readLine();
				
		//2- Chamar o metódo que retona a Pessoa (PessoaDAO)
		PessoaDAO pesDao = new PessoaDAO();
		Pessoa pes = pesDao.buscar(Integer.parseInt(id));
		
		//3- Imprmir a pessoa (verificar se está nulo)
		if(pes != null)
			System.out.println(pes.retornaDadosPes());
		else //Produto NULL
			System.out.println("A Pessoa de ID = " + id + " não foi encontrada.");

	}

}

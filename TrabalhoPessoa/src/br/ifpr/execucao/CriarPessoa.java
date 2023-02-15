package br.ifpr.execucao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;

public class CriarPessoa {

	public static void main(String[] args) throws IOException, SQLException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		Pessoa pes = new Pessoa();
		

		System.out.println("Informe o NOME do Cliente: ");
		String resp = reader.readLine();
		pes.setNome(resp);
		
		System.out.println("Informe o EMAIL do Cliente: ");
		resp = reader.readLine();
		pes.setEmail(resp);
		
		System.out.println("Informe o TELEFONE do Cliente: ");
		resp = reader.readLine();
		pes.setTel(resp);
		
		System.out.println("Informe a ALTURA do Cliente: ");
		resp = reader.readLine();
		pes.setAltura(Float.parseFloat(resp));
		
		System.out.println("Informe o PESO do Cliente: ");
		resp = reader.readLine();
		pes.setPeso(Float.parseFloat(resp));
		
		PessoaDAO pesDAO = new PessoaDAO();
		pesDAO.inserirCliente(pes);
		
	}

}

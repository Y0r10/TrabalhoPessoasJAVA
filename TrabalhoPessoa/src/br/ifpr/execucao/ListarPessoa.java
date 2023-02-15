package br.ifpr.execucao;

import java.sql.SQLException;
import java.util.List;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;


public class ListarPessoa {

	public static void main(String[] args) throws SQLException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> lista = pessoaDAO.listar();
		
		System.out.println("Existe "+lista.size()+" pessoa(s) na lista:\n");
		
		for(int i=0; i<lista.size(); i++) {
			Pessoa pessoa = lista.get(i);
			System.out.println(pessoa.retornaDadosPes());
		}
	}

}

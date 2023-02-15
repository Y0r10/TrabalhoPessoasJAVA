package br.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifpr.modelo.Pessoa;
import br.ifpr.util.Conexao;

public class PessoaDAO {
	
	public void inserirCliente(Pessoa pessoa) throws SQLException {
		String sql = "Insert INTO pessoa"+
		" (nome,telefone,email,peso,altura)"+
				"VALUES(?,?,?,?,?)";
		
		Connection conn = Conexao.getConexao();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getTel());
		ps.setString(3, pessoa.getEmail());
		ps.setFloat(4, pessoa.getPeso());
		ps.setFloat(5, pessoa.getAltura());

		ps.executeUpdate();
	}
		public List<Pessoa> listar() throws SQLException {
			String sql = 
				"SELECT id_pessoa, nome,telefone,email,peso,altura" +
				" FROM pessoa";
			
			Connection conn = Conexao.getConexao();
			
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Pessoa> lista = new ArrayList<>();
			
			while(rs.next()) {
				Pessoa pes = new Pessoa();
				pes.setIdPessoa(rs.getInt("id_pessoa"));
				pes.setNome(rs.getString("nome"));
				pes.setTel(rs.getString("telefone"));
				pes.setEmail(rs.getString("email"));
				pes.setPeso(rs.getFloat("peso"));
				pes.setAltura(rs.getFloat("altura"));

				
				lista.add(pes);
			}
			
			conn.close();
			
			return lista;		
		}
		
		public Pessoa buscar(Integer id) throws SQLException {
			Pessoa pes = null;
			
			String sql = 
					"SELECT id_pessoa, nome, email, telefone, altura, peso" +
					" FROM pessoa WHERE id_pessoa = ?";
			
			Connection conn = Conexao.getConexao();
			
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			//Verificar se encontrou algum registro (pessoa)
			if(rs.next()) {
				//Criar e retornar uma pessoa
				pes = new Pessoa();
				pes.setIdPessoa(rs.getInt("id_pessoa"));
				pes.setNome(rs.getString("nome"));
				pes.setEmail(rs.getString("email"));
				pes.setTel(rs.getString("telefone"));
				pes.setAltura(rs.getFloat("altura"));
				pes.setPeso(rs.getFloat("peso"));
				
			} 
			
			conn.close();
			
			return pes; //Se não encontrado, prod sera null	
		}
		
		public void excluir(Integer idPessoa) throws SQLException {
			String sql = "DELETE FROM pessoa WHERE id_pessoa = ?";
			
			Connection conn = Conexao.getConexao();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idPessoa);
			
			ps.executeUpdate(); //Executa o SQL na base de dados
			
			conn.close();
		}

	}


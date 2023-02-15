package br.ifpr.modelo;

public class Pessoa {
	
	private Integer idPessoa;
	private String nome;
	private String email;
	private String tel;
	private float altura;
	private Float peso;
	
	public String retornaDadosPes() {
		String pes = "ID = " + idPessoa;
		pes += " | Nome = " + nome;
		pes += " | Email = " + email;
		pes += " | Telefone = " + tel;
		pes += " | Altura = " + altura;
		pes += " | Peso = " + peso;
		
		return pes;
	}
	
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	
	

}

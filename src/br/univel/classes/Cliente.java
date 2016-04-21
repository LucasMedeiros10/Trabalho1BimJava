package br.univel.classes;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;
import br.univel.enums.EstadoCivil;

@Tabela("clientes")
public class Cliente {

	@Coluna(nome="cli_codigo", pk=true)
	private int id;
	
	@Coluna(nome="cli_nome", tamanho=60)
	private String nome;
	
	@Coluna(nome="cli_endereco", tamanho=60)
	private String endereco;
	
	@Coluna(nome="cli_fone", tamanho=20)
	private String telefone;
	
	@Coluna(nome="cli_estcivil")
	private EstadoCivil estadoCivil;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Cliente(){
		
	}
}

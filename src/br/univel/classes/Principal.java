package br.univel.classes;

import br.univel.enums.EstadoCivil;

public class Principal {

	
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		c1.setId(1);
		c1.setNome("Lucas");
		c1.setTelefone("4599078134");
		c1.setEstadoCivil(EstadoCivil.SOLTEIRO);
		c1.setEndereco("Rua Epit�cio Pessoa, 200");
		
		Cliente c2 = new Cliente();
		c2.setId(2);
		c2.setNome("Matheus");
		c2.setTelefone("4599888234");
		c2.setEstadoCivil(EstadoCivil.CASADO);
		c2.setEndereco("Rua ABC, 123");

		Cliente c3 = new Cliente();
		c3.setId(3);
		c3.setNome("Nicholas");
		c3.setTelefone("4599563232");
		c3.setEstadoCivil(EstadoCivil.SOLTEIRO);
		c3.setEndereco("Rua das Araras, 56");
		
		
		
		System.out.println("apagarTabela");
		System.out.println("criarTabela");
		System.out.println("inserir objeto 1");
		System.out.println("inserir objeto 2");
		System.out.println("inserir objeto 3");
		System.out.println("listarTodos");
		System.out.println("buscar objeto 1");
		System.out.println("alterar objeto 2");
		System.out.println("excluir objeto 3");
		System.out.println("listarTodos");
		
	}
}

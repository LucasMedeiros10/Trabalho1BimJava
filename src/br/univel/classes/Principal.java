package br.univel.classes;

import br.univel.enums.EstadoCivil;

public class Principal {

	public Principal(){
		//instancia dos clientes
		Cliente c1 = new Cliente();
		c1.setId(1);
		c1.setNome("Lucas");
		c1.setTelefone("4599078134");
		c1.setEstadoCivil(EstadoCivil.SOLTEIRO);
		c1.setEndereco("Rua Epitácio Pessoa, 200");
		
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
		
		//instancia Dao
		DaoImpl d = new DaoImpl();
		
		
		//chamar métodos
		System.out.println("apagarTabela");
		d.apagarTabela(c1);
		
		System.out.println("criarTabela");
		d.criarTabela(c1);
		
		System.out.println("inserir objeto 1");
		d.salvar(c1);
		
		System.out.println("inserir objeto 2");
		d.salvar(c2);
		
		System.out.println("inserir objeto 3");
		d.salvar(c3);
		
		System.out.println("listarTodos");
		d.listarTodos();
		
		System.out.println("buscar objeto 1");
		d.buscar(c1.getId());
		
		System.out.println("alterar objeto 2");
		d.atualizar(c2);
		
		System.out.println("excluir objeto 3");
		d.excluir(c3.getId());
		
		System.out.println("listarTodos");
		d.listarTodos();		
		
	}
	
	
	public static void main(String[] args) {
		new Principal();
	}
}

package br.univel.classes;

import java.sql.SQLException;

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
		c2.setEstadoCivil(EstadoCivil.SOLTEIRO);
		c2.setEndereco("Rua ABC, 123");

		Cliente c3 = new Cliente();
		c3.setId(3);
		c3.setNome("Nicholas");
		c3.setTelefone("4599563232");
		c3.setEstadoCivil(EstadoCivil.SOLTEIRO);
		c3.setEndereco("Rua das Araras, 56");
		
		//instancia Dao
		DaoImpl d = new DaoImpl();
		try {
			d.abrirConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Falha ao conectar no banco de dados.");
			e.printStackTrace();
		}
		
		
		
		//chamar métodos
		System.out.println("apagarTabela\n");
		d.apagarTabela(c1);
		
		System.out.println("criarTabela\n");
		d.criarTabela(c1);
		
		System.out.println("inserir objeto 1\n");
		d.salvar(c1);
		
		System.out.println("inserir objeto 2\n");
		d.salvar(c2);
		
		System.out.println("inserir objeto 3\n");
		d.salvar(c3);
		
		System.out.println("listarTodos");
		for(Cliente c : d.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + 
							   c.getTelefone() + " - " + c.getEstadoCivil().toString());			
		}
		
		
		System.out.println("\nbuscar objeto 1");
		Cliente c4 = new Cliente();
		c4 = d.buscar(c1.getId());		
		System.out.println(c4.getId() + " - " + c4.getNome() + " - " + c4.getEndereco() + " - " + 
						   c4.getTelefone() + " - " + c4.getEstadoCivil().toString());			

		
		System.out.println("\nalterar objeto 2\n");
		c2.setEstadoCivil(EstadoCivil.CASADO);
		d.atualizar(c2);
		
		System.out.println("excluir objeto 3\n");
		d.excluir(c3.getId());
		
		System.out.println("listarTodos");		
		for(Cliente c : d.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + 
							   c.getTelefone() + " - " + c.getEstadoCivil().toString());			
		}
		
		
		//fecha a conexão
		try {
			d.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new Principal();
	}
}

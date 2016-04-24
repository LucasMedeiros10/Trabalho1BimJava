package br.univel.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.univel.interfaceseClassesAbstratas.Dao;

public class DaoImpl implements Dao<Cliente, Integer> {


	Connection con = new Conexao();
	
	@Override
	public void salvar(Cliente t) {
		SqlGenImpl gerador = new SqlGenImpl();
		
		try {

			PreparedStatement ps = gerador.getSqlInsert(con, t);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getNome());
			ps.setString(3, t.getEndereco());
			ps.setString(4, t.getTelefone());
			ps.setInt(5, t.getEstadoCivil().ordinal());
			
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			
	}

	@Override
	public Cliente buscar(Integer k) {
		SqlGenImpl gerador = new SqlGenImpl();
		gerador.getSqlSelectById(con, new Cliente());
		return null;
	}

	@Override
	public void atualizar(Cliente t) {
		SqlGenImpl gerador = new SqlGenImpl();
			
		try {

			PreparedStatement ps = gerador.getSqlUpdateById(con, t);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getEndereco());
			ps.setString(3, t.getTelefone());
			ps.setInt(4, t.getEstadoCivil().ordinal());
			ps.setInt(5, t.getId());
			
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}		
	}

	@Override
	public void excluir(Integer k) {
		SqlGenImpl gerador = new SqlGenImpl();
				
		try {

			PreparedStatement ps = gerador.getSqlDeleteById(con, new Cliente());
			ps.setInt(1, k);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}		
	}

	@Override
	public List<Cliente> listarTodos() {
		SqlGenImpl gerador = new SqlGenImpl();
		gerador.getSqlSelectAll(con, new Cliente());
		return null;
	}

	public void criarTabela(Cliente t){
		SqlGenImpl gerador = new SqlGenImpl();
		gerador.getCreateTable(con, t);
		
	}
	
	public void apagarTabela(Cliente t){
		SqlGenImpl gerador = new SqlGenImpl();
		gerador.getDropTable(con, t);		
		
	}	
}

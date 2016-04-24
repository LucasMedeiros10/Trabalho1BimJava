package br.univel.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.enums.EstadoCivil;
import br.univel.interfaceseClassesAbstratas.Dao;

public class DaoImpl implements Dao<Cliente, Integer> {


	private Connection con = null;
	
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

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
		Cliente c = new Cliente();
				
		try {

			PreparedStatement ps = gerador.getSqlSelectById(con, new Cliente());
			ps.setInt(1, k);
			ResultSet resultados = ps.executeQuery();
			
			while (resultados.next()) {
				c.setId(resultados.getInt("cli_codigo"));
				c.setNome(resultados.getString("cli_nome"));
				c.setEndereco(resultados.getString("cli_endereco"));
				c.setTelefone(resultados.getString("cli_fone"));
				c.setEstadoCivil(EstadoCivil.getPorCodigo(resultados.getInt("cli_estcivil")));
			}			
			
			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return c;
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
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		try {

			PreparedStatement ps = gerador.getSqlSelectAll(con, new Cliente());
			ResultSet resultados = ps.executeQuery();
			
			while (resultados.next()) {
				
				Cliente c = new Cliente();
				c.setId(resultados.getInt("cli_codigo"));
				c.setNome(resultados.getString("cli_nome"));
				c.setEndereco(resultados.getString("cli_endereco"));
				c.setTelefone(resultados.getString("cli_fone"));
				c.setEstadoCivil(EstadoCivil.getPorCodigo(resultados.getInt("cli_estcivil")));
				
				listaCliente.add(c);
			}			
			
			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return listaCliente;		
	}

	public void criarTabela(Cliente t){
		SqlGenImpl gerador = new SqlGenImpl();
		
		try {
			String sql = gerador.getCreateTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			
		
	}
	
	public void apagarTabela(Cliente t){
		SqlGenImpl gerador = new SqlGenImpl();
				
		try {
			String sql = gerador.getDropTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			
		
	}	
	
	
}

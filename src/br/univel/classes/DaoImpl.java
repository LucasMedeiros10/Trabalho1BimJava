package br.univel.classes;

import java.sql.Connection;
import java.util.List;

import br.univel.interfaceseClassesAbstratas.Dao;

public class DaoImpl implements Dao<Cliente, Integer> {


	Connection con = new Conexao();
	
	@Override
	public void salvar(Cliente t) {
		SqlGenImpl gerador = new SqlGenImpl();
		gerador.getSqlInsert(con, t);
		
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
		gerador.getSqlUpdateById(con, t);	
	}

	@Override
	public void excluir(Integer k) {
		SqlGenImpl gerador = new SqlGenImpl();
		gerador.getSqlDeleteById(con, new Cliente());
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

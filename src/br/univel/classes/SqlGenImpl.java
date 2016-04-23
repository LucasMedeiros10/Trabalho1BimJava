package br.univel.classes;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.management.RuntimeErrorException;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;
import br.univel.enums.EstadoCivil;
import br.univel.interfaceseClassesAbstratas.SqlGen;

public class SqlGenImpl extends SqlGen {
	

	@Override
	protected String getCreateTable(Connection con, Object obj) {

		try {

			StringBuilder sb = new StringBuilder();

			// Declaração da tabela.
			{
				String nomeTabela;
				if (obj.getClass().isAnnotationPresent(Tabela.class)) {

					Tabela anotacaoTabela = obj.getClass().getAnnotation(Tabela.class);
					nomeTabela = anotacaoTabela.value();

				} else {
					nomeTabela = obj.getClass().getSimpleName().toUpperCase();

				}
				sb.append("CREATE TABLE ").append(nomeTabela).append(" (");
			}
			
			Field[] atributos = obj.getClass().getDeclaredFields();
			
			String ChavePrimaria = "";

			// Declaração das colunas
			{
				for (int i = 0; i < atributos.length; i++) {

					Field field = atributos[i];

					String nomeColuna;
					String tipoColuna;
					int    tamanhoColuna = 0;

					//nome coluna
					if (field.isAnnotationPresent(Coluna.class)) {
						Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

						if (anotacaoColuna.nome().isEmpty()) {
							nomeColuna = field.getName().toUpperCase();
							tamanhoColuna = 0;
						} else {
							nomeColuna = anotacaoColuna.nome();
							tamanhoColuna = anotacaoColuna.tamanho();
							
							//verifica se é chave primária
							if(anotacaoColuna.pk()){
								if (ChavePrimaria.equalsIgnoreCase("")){
									ChavePrimaria = anotacaoColuna.nome();
								}else{
									ChavePrimaria = ChavePrimaria + ", " + anotacaoColuna.nome();
								}
								
							}
						}

					} else {
						nomeColuna = field.getName().toUpperCase();
					}

					//tipo coluna
					Class<?> tipoParametro = field.getType();

					if (tipoParametro.equals(String.class)) {
						tipoColuna = "VARCHAR("  + tamanhoColuna + ")";

					} else if (tipoParametro.equals(int.class)) {
						tipoColuna = "INT";
					} else if (tipoParametro.equals(EstadoCivil.class)) {
						tipoColuna = "INT";
					} else {
						tipoColuna = "DESCONHECIDO";
					}							
					
					if (i > 0) {
						sb.append(",");
					}										

					sb.append("\n\t").append(nomeColuna).append(' ').append(tipoColuna);
				}
			}			

			if (ChavePrimaria != ""){
				sb.append(",\n\t PRIMARY KEY(" + ChavePrimaria + ")");
			}
			
			sb.append("\n);");
			return sb.toString();

		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected String getDropTable(Connection con, Object obj) {
		try{

			StringBuilder sb = new StringBuilder();
			
			// Declaração da tabela.
			String nomeTabela;
			if (obj.getClass().isAnnotationPresent(Tabela.class)) {

				Tabela anotacaoTabela = obj.getClass().getAnnotation(Tabela.class);
				nomeTabela = anotacaoTabela.value();

			} else {
				nomeTabela = obj.getClass().getSimpleName().toUpperCase();

			}
			sb.append("DROP TABLE ").append(nomeTabela).append(";");

			return sb.toString();
		}catch(SecurityException e){
			throw new RuntimeException(e);
		}
	}

	@Override
	protected PreparedStatement getSqlInsert(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlSelectAll(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlSelectById(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlUpdateById(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlDeleteById(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

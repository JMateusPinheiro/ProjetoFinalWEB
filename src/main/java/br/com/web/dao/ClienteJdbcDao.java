package br.com.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.web.model.Cliente;

@Repository
public class ClienteJdbcDao implements ClienteDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Cliente> rowMapper = new RowMapper<Cliente>()	{	
		@Override
		public Cliente mapRow(ResultSet rs,	int rowNum)	throws SQLException	{	
			Cliente	cliente	= new Cliente();	
			cliente.setCpf(rs.getString("cpf"));	
			cliente.setNome(rs.getString("nome"));	
			cliente.setEmail(rs.getString("email"));	
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setSenha(rs.getString("senha"));
			return cliente;	
		}	
	};

	@Override
	@Transactional(readOnly=true)	
	public List<Cliente> getLista()	{	
		String	sql	=	"select	* from clientes";	
		return jdbcTemplate.query(sql,	rowMapper);	
	}

	@Override
	@Transactional
	public void adiciona(Cliente cliente) {
		String sql = "insert into clientes " + "(nome,endereco,cpf,email,telefone,senha)" + " values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { cliente.getNome(), cliente.getEndereco(),
				cliente.getCpf(),  cliente.getEmail(),cliente.getTelefone(), cliente.getSenha()});

	}

	@Override
	@Transactional(readOnly=true)
	public Cliente getCliente(String cpf){
		String sql = "select * from clientes where cpf=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {cpf}, rowMapper);

	}

	@Override
	@Transactional
	public void altera(Cliente cliente) {
		String sql = "update clientes set nome=?, endereco=?, email=?, telefone=?, senha=?"
				+ "where cpf=?";
		jdbcTemplate.update(sql, new Object[] { cliente.getNome(), cliente.getEmail(), 
				cliente.getEndereco(), cliente.getCpf(), cliente.getTelefone(), cliente.getSenha()});
	}

	public void remove(String cpf) {
		String sql = "delete from clientes where cpf=?";
		jdbcTemplate.update(sql, new Object[] {cpf});
	}

}

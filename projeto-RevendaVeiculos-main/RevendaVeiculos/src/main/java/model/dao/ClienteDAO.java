package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ClienteVO;

public class ClienteDAO {

	public boolean verificarCliente(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idcliente FROM cliente WHERE cpf = '" + cpf + "'";

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query que realiza consulta por CPF");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO cliente (nome, cpf, telefone) values ('" + clienteVO.getNome() + "','"
				+ clienteVO.getCpf() + "','" + clienteVO.getTelefone() + "')";
		try {
			resultado = stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro ao executar query de cadastro de cliente!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;

	}

	public boolean verificarClientePorId(int idcliente) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idcliente FROM cliente WHERE idcliente = " + idcliente;

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query que realiza consulta por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "DELETE FROM cliente WHERE idcliente = " + clienteVO.getIdcliente();
		int resultado = 0;

		try {
			resultado = stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro ao executar query que realiza exclusão!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE cliente SET nome = '" + clienteVO.getNome() + "', cpf= '" + clienteVO.getCpf()
				+ "', telefone= '" + clienteVO.getTelefone() + "' WHERE idcliente = " + clienteVO.getIdcliente();
		try {
			resultado = stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro ao executar query de atualização de cliente!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public ArrayList<ClienteVO> consultarTodosClientesDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVO> listaClientes = new ArrayList<>();
		String query = "SELECT * FROM cliente ";

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdcliente(resultado.getInt("idcliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setTelefone(resultado.getString("telefone"));

				listaClientes.add(cliente);

			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de todas vendas! ");
		}
		Banco.closeStatement(stmt);
		Banco.closeResultSet(resultado);
		Banco.closeConnection(conn);

		return listaClientes;
	}

	public ClienteVO consultarUmCliente(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVO cliente = new ClienteVO();

		String query = "SELECT * FROM cliente WHERE idcliente = " + clienteVO.getIdcliente();

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				cliente.setIdcliente(resultado.getInt("idcliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setTelefone(resultado.getString("telefone"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de cliente!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
		}
		return cliente;
	}

}

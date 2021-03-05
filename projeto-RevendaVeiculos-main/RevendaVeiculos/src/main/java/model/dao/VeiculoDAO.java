package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class VeiculoDAO {

	public boolean verificarVeiculoPorPlaca(String placa) {	
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idveiculo FROM veiculo WHERE placa = '"+placa+"'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {				
				return true;
			}			
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar a query que consulta veículo por placa!");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return false;
	}

	public int cadastrarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "INSERT INTO veiculo (modelo, tipo, fabricante, ano, cor, placa) values ('"
				+ veiculoVO.getModelo()+"','"
				+ veiculoVO.getTipo()+"','"
				+ veiculoVO.getFabricante()+"',"
				+ veiculoVO.getAno()+",'"
				+ veiculoVO.getCor()+"','"
				+ veiculoVO.getPlaca()+"')";		
		try {			
			
			resultado = stmt.executeUpdate(query);			
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar a query que consulta veículo por placa!");
			
		} finally {			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	public boolean verificarVeiculoPorId(int idveiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		String query = "SELECT idveiculo FROM veiculo WHERE idveiculo = "+idveiculo;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {				
				return true;
			}			
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar a query que consulta veículo por ID!");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return false;
	}

	public int excluirVeiculo(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM veiculo WHERE idveiculo = "+veiculoVO.getIdveiculo()+";";
		
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Erro ao executar a query de exclusão de veículos");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		
		return resultado;
	}

	public int atualizarVeiculo(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE veiculo SET modelo = '"+veiculoVO.getModelo()
				+"', tipo =  '"+veiculoVO.getTipo()
				+"', fabricante =  '"+veiculoVO.getFabricante()
				+"', ano =  '"+veiculoVO.getAno()
				+"', cor =  '"+veiculoVO.getCor()
				+"', placa =  '"+veiculoVO.getPlaca()
				+"' WHERE 	idveiculo = "+veiculoVO.getIdveiculo();		
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Erro ao executar a query de alteração de veículos");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		
		return resultado;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String queryConsulta = "SELECT * FROM veiculo";	
		ArrayList<VeiculoVO> lista = null;
				
		try {
			resultado = stmt.executeQuery(queryConsulta);
			lista = new ArrayList<VeiculoVO>();
			while (resultado.next()) {
				VeiculoVO veiculo = new VeiculoVO();
				veiculo.setIdveiculo(Integer.parseInt(resultado.getString("idveiculo")));
				veiculo.setModelo(resultado.getString("modelo"));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString("tipo")));
				veiculo.setFabricante(resultado.getString("fabricante"));
				veiculo.setAno(resultado.getInt("ano"));
				veiculo.setModelo(resultado.getString("modelo"));
				veiculo.setCor(resultado.getString("cor"));
				veiculo.setPlaca(resultado.getString("placa"));
				lista.add(veiculo);			
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Consulta de todos veículos não realizada!");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return lista;		
		
	}


	public VeiculoVO consultarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String queryConsulta = "SELECT * FROM veiculo WHERE idveiculo = "+veiculoVO.getIdveiculo();	
		
		VeiculoVO veiculo = new VeiculoVO();
		
		try {
			resultado = stmt.executeQuery(queryConsulta);
			
			while (resultado.next()) {				
				veiculo.setIdveiculo(resultado.getInt("idveiculo"));
				veiculo.setModelo(resultado.getString("modelo"));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString("tipo")));
				veiculo.setFabricante(resultado.getString("fabricante"));
				veiculo.setAno(resultado.getInt("ano"));
				veiculo.setModelo(resultado.getString("modelo"));
				veiculo.setCor(resultado.getString("cor"));
				veiculo.setPlaca(resultado.getString("placa"));					
			}
			return veiculo;
			
		}catch (SQLException e) {
			System.out.println("Consulta de veículo não realizada!");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return veiculo;
	}
}

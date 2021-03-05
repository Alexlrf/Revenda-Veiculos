package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dto.FaturamentoDTO;
import model.dto.VendasDTO;
import model.vo.VendaVO;

public class VendaDAO {

	public int cadastrarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int retorno = 0;
		String query = "INSERT INTO venda (idcliente, idveiculo, valorVenda, dataVenda) values" + "("
				+ vendaVO.getIdcliente() + ", " + vendaVO.getIdveiculo() + ", " + vendaVO.getValorVenda() + ", '"
				+ vendaVO.getDataVenda() + "')";
		try {
			retorno = stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro na query de cadastramento de venda!");
			return retorno;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean consultarIdVenda(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idvenda FROM venda WHERE idvenda = " + vendaVO.getIdvenda();

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar a query que consulta venda por ID!");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "DELETE FROM venda WHERE idvenda = " + vendaVO.getIdvenda();
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

	public int atualizarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE venda SET idcliente = " + vendaVO.getIdcliente() + ", idveiculo= "
				+ vendaVO.getIdveiculo() + ", valorVenda= " + vendaVO.getValorVenda() + ", DataVenda= '"
				+ vendaVO.getDataVenda() + "' WHERE idvenda = " + vendaVO.getIdvenda();
		try {
			resultado = stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro ao executar query de atualização de venda!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public VendaVO consultarUmaVenda(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VendaVO venda = new VendaVO();

		String query = "SELECT * FROM venda WHERE idvenda = " + vendaVO.getIdvenda();

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				venda.setIdvenda(resultado.getInt("idvenda"));
				venda.setIdcliente(resultado.getInt("idcliente"));
				venda.setIdveiculo(resultado.getInt("idveiculo"));
				venda.setValorVenda(resultado.getDouble("valorVenda"));
				venda.setDataVenda(LocalDate.parse(resultado.getString("dataVenda")));
			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de venda!");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return venda;
	}

	public List<VendaVO> consultarTodasVendas() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaVO> listaVendas = new ArrayList<>();
		String query = "SELECT * FROM venda ";

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				VendaVO venda = new VendaVO();
				venda.setIdvenda(resultado.getInt("idvenda"));
				venda.setIdcliente(resultado.getInt("idcliente"));
				venda.setIdveiculo(resultado.getInt("idveiculo"));
				venda.setValorVenda(resultado.getDouble("valorVenda"));
				venda.setDataVenda(LocalDate.parse(resultado.getString("dataVenda")));
				listaVendas.add(venda);

			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de todas vendas! ");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaVendas;
	}

	public List<FaturamentoDTO> exibirRelatorioFaturamentoDAO() {

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		List<FaturamentoDTO> relatorioFaturamento = new ArrayList<>();

		String queryFaturamento = "SELECT month(dataVenda) as MES, year(dataVenda) as ANO, sum(valorVenda) as SOMA FROM venda GROUP BY month(dataVenda), year(dataVenda) ORDER BY month(dataVenda), year(dataVenda)";

		try {
			resultado = stmt.executeQuery(queryFaturamento);
			while (resultado.next()) {
				FaturamentoDTO faturamento = new FaturamentoDTO();
				faturamento.setMes(resultado.getInt("MES"));
				faturamento.setAno(resultado.getInt("ANO"));
				faturamento.setTotalVendas(resultado.getDouble("SOMA"));

				relatorioFaturamento.add(faturamento);
			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de faturamento!");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return relatorioFaturamento;
	}

	public List<VendasDTO> exibirRelatorioVendas() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		List<VendasDTO> vendas = new ArrayList<>();
		String query = "SELECT" + "	cliente.nome as nome, cliente.cpf as cpf, cliente.telefone as telefone"
				+ "    , veiculo.placa as placa, venda.dataVenda as dt_venda, venda.valorVenda as valor " + "FROM"
				+ "	cliente" + "    INNER JOIN venda on" + "		cliente.idcliente = venda.idcliente"
				+ "    INNER JOIN veiculo on" + "		veiculo.idveiculo = venda.idveiculo " + "ORDER BY"
				+ "	dt_venda";
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				VendasDTO venda = new VendasDTO();
				venda.setNome(rs.getString("nome"));
				venda.setCpf(rs.getString("cpf"));
				venda.setTelefone(rs.getString("telefone"));
				venda.setPlaca(rs.getString("placa"));
				venda.setDataVenda(LocalDate.parse(rs.getString("dt_venda")));
				venda.setValorVenda(rs.getDouble("valor"));
				vendas.add(venda);
			}

		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de faturamento!");
		}
		Banco.closeStatement(stmt);
		Banco.closeResultSet(rs);
		Banco.closeConnection(conn);

		return vendas;
	}

}

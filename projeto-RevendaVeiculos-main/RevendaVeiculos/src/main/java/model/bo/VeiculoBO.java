package model.bo;

import java.util.ArrayList;

import model.dao.VeiculoDAO;
import model.vo.VeiculoVO;

public class VeiculoBO {

	public String cadastrarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if (veiculoDAO.verificarVeiculoPorPlaca(veiculoVO.getPlaca())) {
			retorno = "\n Veículo já cadastrado no banco!";
		}else {
			int resultado = veiculoDAO.cadastrarVeiculoDAO(veiculoVO);
			if (resultado == 1) {
				retorno = "\n Veículo cadastrado com sucesso!";
			}else {
				retorno = "\n Não foi possível cadastrar o veículo!";
			}
		}
		return retorno;
	}

	public String excluirVeiculoBO(VeiculoVO veiculoVO) {
		String retorno =null;
		VeiculoDAO veiculoDAO = new VeiculoDAO();		
		if (veiculoDAO.verificarVeiculoPorId(veiculoVO.getIdveiculo())) {
			int resultado = veiculoDAO.excluirVeiculo(veiculoVO); 
			if (resultado == 1) {
				retorno = "\n Veículo excluído";
				
			} else {
				retorno = "\n Não foi possível excluir veículo";
			}
		}else{
			retorno = "\n Veículo não encontrado no banco";
		}
		
		return retorno;
	}

	public String atualizarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();		
		if (veiculoDAO.verificarVeiculoPorId(veiculoVO.getIdveiculo())) {
			int resultado = veiculoDAO.atualizarVeiculo(veiculoVO); 
			if (resultado == 1) {
				retorno = "\n Veículo atualizado!";
				
			} else {
				retorno = "\n Não foi possível atualizar veículo";
			}
		}else{
			retorno = "\n Veículo não está registrado no banco";
		}
		
		return retorno;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosBO() {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		return veiculoDAO.consultarTodosVeiculosDAO();
	}

	public VeiculoVO consultarVeiculoBO(VeiculoVO veiculoVO) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		return veiculoDAO.consultarVeiculoDAO(veiculoVO);
	}

}

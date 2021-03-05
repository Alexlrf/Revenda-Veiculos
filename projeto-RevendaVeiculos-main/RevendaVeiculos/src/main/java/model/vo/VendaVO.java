package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class VendaVO {
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	private int idvenda;
	private int idcliente;
	private int idveiculo;
	private double valorVenda;
	private LocalDate dataVenda;
	
	public VendaVO(int idvenda, int idcliente, int idveiculo, double valorVenda, LocalDate dataVenda) {
		super();
		this.idvenda = idvenda;
		this.idcliente = idcliente;
		this.idveiculo = idveiculo;
		this.valorVenda = valorVenda;
		this.dataVenda = dataVenda;
	}

	public VendaVO() {
		super();
	}

	public int getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdveiculo() {
		return idveiculo;
	}

	public void setIdveiculo(int idveiculo) {
		this.idveiculo = idveiculo;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void imprimirVenda() {
		System.out.printf("%3d   %-15d   %-15d   %-11s   %-13s \n",
				this.getIdvenda()
				, this.getIdcliente()
				, this.getIdveiculo()
				, df.format(this.getValorVenda())
				, this.getDataVenda());
		
	}
	
	
}

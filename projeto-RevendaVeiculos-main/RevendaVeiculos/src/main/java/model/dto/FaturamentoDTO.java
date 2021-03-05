package model.dto;

import java.text.DecimalFormat;

public class FaturamentoDTO {
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	private int mes;
	private int ano;
	private double totalVendas;
	
	public FaturamentoDTO(DecimalFormat df, int mes, int ano, double totalVendas) {
		super();
		this.df = df;
		this.mes = mes;
		this.ano = ano;
		this.totalVendas = totalVendas;
	}
	
	public FaturamentoDTO() {
		super();
	}

	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	public void imprimir() {
		System.out.printf("%3d    %-9s  %9s   \n",
				this.getMes()
				, this.getAno()
				,df.format(this.getTotalVendas()));
				
	}
	
		

}

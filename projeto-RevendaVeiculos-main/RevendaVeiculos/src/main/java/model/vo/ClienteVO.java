package model.vo;

public class ClienteVO {
	
	private int idcliente;
	private String nome;
	private String cpf;
	private String telefone;
	
	public ClienteVO(int idcliente, String nome, String cpf, String telefone) {
		super();
		this.idcliente = idcliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public ClienteVO() {
		super();
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void imprimirCliente() {
		System.out.printf("%3d   %-8s   %-6s   %-10s \n",
				 this.getIdcliente()
				, this.getNome()
				, this.getCpf()
				, this.getTelefone());				
		
	}
	
	
}

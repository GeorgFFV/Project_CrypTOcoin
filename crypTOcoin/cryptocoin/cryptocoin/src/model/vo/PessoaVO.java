package model.vo;

public abstract class PessoaVO {
	private String nome;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome.equals("") || nome.length() < 2){
			
		}else {
				this.nome = nome;
		}
	}
		
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf == null || cpf.equals("") || cpf.length() < 2){
			
		}else {
				this.cpf = cpf;
		}
	}
}

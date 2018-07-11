package Domain;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CPF;




@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	
	
	
	public PessoaFisica() {}
	
	
	public PessoaFisica(String cpf, String rg, LocalDate dataNascimento, Sexo sexo) {
		super();
		Cpf = cpf;
		Rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	@CPF
	private String Cpf;
	
	private String Rg;
	

	private LocalDate dataNascimento;
	
	private Sexo sexo;

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getRg() {
		return Rg;
	}

	public void setRg(String rg) {
		Rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	

	
	
}

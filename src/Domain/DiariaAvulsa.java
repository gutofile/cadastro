package Domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("avulsa")
public class DiariaAvulsa extends Diaria implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal valor;
	private Pessoa cliente;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@ManyToOne
	@JoinColumn(name = "cod_pessoa")
	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

}

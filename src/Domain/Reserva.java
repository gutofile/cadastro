package Domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa cliente;

	@OneToMany(mappedBy = "reserva", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<DiariaReservada> diarias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Reserva() {
	}

	public Reserva(Integer id, LocalDate data, Pessoa cliente) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
	}

	public Collection<DiariaReservada> getDiarias() {
		return diarias;
	}

	public void setDiarias(Collection<DiariaReservada> diarias) {
		this.diarias = diarias;
	}

}

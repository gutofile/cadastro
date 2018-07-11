package Domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(name="tipo")
public class Diaria implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	public Diaria() {
		
	}
 
	private LocalDate data;


	private Collection<PessoaFisica> hospedes;

	
	
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

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

	
	
	@ManyToMany
	@JoinTable(name = "hospedagem",
	joinColumns = @JoinColumn(name = "id_diaria"),
	inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	public Collection<PessoaFisica> getHospedes() {
		return hospedes;
	}

	public void setHospedes(Collection<PessoaFisica> hospedes) {
		this.hospedes = hospedes;
	}

	public Diaria(Integer id, LocalDate data, Quarto quarto, Collection<PessoaFisica> hospedes) {
		super();
		this.id = id;
		this.data = data;
		this.hospedes = hospedes;
		this.quarto = quarto;
	}
	
	public Diaria(Integer id, LocalDate data, Collection<PessoaFisica> hospedes) {
		super();
		this.id = id;
		this.data = data;
		this.hospedes = hospedes;
	}
	@ManyToOne
	@JoinColumn(name = "quarto")
	private Quarto quarto;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diaria other = (Diaria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}

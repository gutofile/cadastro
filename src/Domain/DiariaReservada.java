package Domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("reservada")
public class DiariaReservada extends Diaria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Reserva reserva;

	@ManyToOne
	@JoinColumn(name="cod_reserva")
	public Reserva getReserva() {
		return reserva;
	}
		
}

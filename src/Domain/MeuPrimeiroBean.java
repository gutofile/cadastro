package Domain;

import javax.faces.bean.ManagedBean;

@ManagedBean (name="MeuPrimeiroBean")
public class MeuPrimeiroBean {
	private String ola = "<b>Olá amigos!</b>";
	private boolean exibir = true;
	
	public String getOla() {
		return ola;
	}
	public void setOla(String ola) {
		this.ola = ola;
	}
	public boolean isExibir() {
		return exibir;
	}
	public void setExibir(boolean exibir) {
		this.exibir = exibir;
	}
	


}

package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class GeralBean {
	private Locale locale;
	private List<Locale> localesDisponiveis;
	
	public GeralBean() {
		localesDisponiveis = new ArrayList<Locale>();
		
		Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		
		while (it.hasNext()) {
			localesDisponiveis.add(it.next());
		}
		
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}
	
	public void atualizarLocale(ActionEvent e) {
		
		
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public List<Locale> getLocalesDisponiveis() {
		return localesDisponiveis;
	}
	public void setLocalesDisponiveis(List<Locale> localesDisponiveis) {
		this.localesDisponiveis = localesDisponiveis;
	}

	@Override
	public String toString() {
		return "GeralBean [locale=" + locale + ", localesDisponiveis="
				+ localesDisponiveis + "]";
	}
}


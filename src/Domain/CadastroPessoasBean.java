package Domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;






@ManagedBean
@SessionScoped // bean que ficara na sessao do usuario,a primeira vez que o usuario fizer requisicao ele é criado, a informacao ficara até o usuario fechar a sessao
public class CadastroPessoasBean {
	
	
	
	private Pessoa pessoaSelecionada;
	private Collection<Pessoa> lista;
	private String tipoNovaPessoa;
	private Locale locale;


	public CadastroPessoasBean(){	
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		pessoaSelecionada = new PessoaFisica();
		lista = new ArrayList<Pessoa>();
		
		
		for(int x=0;x<10;x++){
			Pessoa p = (x%2==0) ? new PessoaFisica() : new PessoaJuridica();
			p.setNome(String.format("Fulano %02d", x));
			p.setEmail(String.format("fulano%02d@fmail.com", x));
			p.setTelefone(String.format("(65) 99999.87%02d", x));
			lista.add(p);
			
		}
		
	}
	
	public void salvar(){
		if (!lista.contains(pessoaSelecionada)){
		lista.add(pessoaSelecionada);
		}
	}
	
	public String cancelar(){
		pessoaSelecionada=null;
		tipoNovaPessoa = null;
		return "inicio";
	}
	
	public void excluir(){
		
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = null;
		String mensagem = ResourceBundle.getBundle("bundles.mensagens",locale).getString("excluida");
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,"detalhes"));
		
	}
	
	public Sexo[] getSexos(){
		return Sexo.values();
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	public Collection<Pessoa> getLista() {
		return lista;
	}
	public void setLista(Collection<Pessoa> lista) {
		this.lista = lista;
	}
	
	public String getTipoNovaPessoa() {
		return tipoNovaPessoa;
	}

	public void setTipoNovaPessoa(String tipoNovaPessoa) {
		this.tipoNovaPessoa = tipoNovaPessoa;
	}
	
	public void criar(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		if (tipoNovaPessoa== null){
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Voce deve especificar o tipo",""));
			return;
		 }
		if (tipoNovaPessoa.equals("PF")){
			pessoaSelecionada = new PessoaFisica();
		}else if (tipoNovaPessoa.equals("PJ")){
			pessoaSelecionada = new PessoaJuridica();
		}
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Pessoa criada com sucesso",""));

	}
	
	public boolean isPessoaFisicaSelecionada(){
		return pessoaSelecionada instanceof PessoaFisica;
	}
	
	public boolean isPessoaJuridicaSelecionada(){
		return pessoaSelecionada instanceof PessoaJuridica;
	}

}
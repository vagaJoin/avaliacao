package br.com.avaliacao.manegedbaen;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractMB {

	
	public void menssagemSucesso(String msg){
		FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_INFO,msg, ""));
	}
	
	public void menssagemErro(String msg){
		FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_ERROR,msg, ""));
	}
	
	public void menssagemAlerta(String msg){
		FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN,msg, ""));
	}

}

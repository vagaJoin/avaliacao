package br.com.avaliacao.manegedbaen;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.avaliacao.facade.PessoaFacede;
import br.com.avaliacao.model.Pessoa;



@ManagedBean(name="pessoaMB")
@ViewScoped
public class PessoaMB extends AbstractMB implements Serializable {
	
	private static final long serialVersionUID = 997175845574648758L;
	
	
	@Inject
	private PessoaFacede pessoaFacede;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoaList = new ArrayList<>();
	
	
	
	@PostConstruct
	public void ini() {
		pessoaList = pessoaFacede.findAll();
	}



	public PessoaFacede getPessoaFacede() {
		return pessoaFacede;
	}



	public void setPessoaFacede(PessoaFacede pessoaFacede) {
		this.pessoaFacede = pessoaFacede;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}



	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}


	

	
	
}

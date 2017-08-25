package br.com.avaliacao.dao;



import javax.ejb.Stateless;

import br.com.avaliacao.model.Endereco;





@Stateless
public class EnderecoDAO extends GenericDAO<Endereco,Long> {
	
	public EnderecoDAO() {
		super(Endereco.class);
	}
	 
}
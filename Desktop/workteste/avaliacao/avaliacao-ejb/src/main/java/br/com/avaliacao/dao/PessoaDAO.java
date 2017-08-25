package br.com.avaliacao.dao;
import javax.ejb.Stateless;
import br.com.avaliacao.model.Pessoa;


@Stateless
public class PessoaDAO extends GenericDAO<Pessoa,Long> {
	
	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	
	 
}
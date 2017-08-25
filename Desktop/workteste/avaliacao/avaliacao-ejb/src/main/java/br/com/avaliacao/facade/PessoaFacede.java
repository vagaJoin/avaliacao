package br.com.avaliacao.facade;


import java.util.List;

import javax.ejb.Local;

import br.com.avaliacao.model.Pessoa;




/**
 * 
 * @author francisco.alves
 *
 */
@Local
public interface PessoaFacede {
	
	/**
	 * save
	 * @param Pessoa
	 */
	public void save(Pessoa Pessoa); 
	
	/**
	 * update
	 * @param Pessoa
	 * @return Pessoa
	 */
	public  Pessoa update(Pessoa Pessoa); 
	/**
	 * delete
	 * @param Pessoa
	 */
	public  void delete(Pessoa Pessoa); 
	/**
	 * find
	 * @param Long Pessoa
	 */
	public  Pessoa find(Long Pessoa); 
	/**
	 * findAll
	 * @return List<Pessoa>
	 */
	public  List<Pessoa> findAll(); 
	
}

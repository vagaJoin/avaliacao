package br.com.avaliacao.facade;


import java.util.List;

import javax.ejb.Local;

import br.com.avaliacao.exception.AvaliacaoException;
import br.com.avaliacao.model.Pessoa;




/**
 * 
 * @author francisco.alves
 *
 */
@Local
public interface PessoaFacede {
	
	/**
	 * salvar
	 * @param Pessoa
	 */
	public void salvar(Pessoa pessoa) throws AvaliacaoException; 
	
	/**
	 * update
	 * @param Pessoa
	 * @return Pessoa
	 */
	public  Pessoa atualizar (Pessoa pessoa) throws AvaliacaoException; 
	/**
	 * remover
	 * @param Pessoa
	 */
	public  void remover(Long id) throws AvaliacaoException; 
	/**
	 * encontrar
	 * @param Long Pessoa
	 */
	public  Pessoa encontrar(Long id) throws AvaliacaoException; 
	/**
	 * getList
	 * @return List<Pessoa>
	 */
	public  List<Pessoa> getList() throws AvaliacaoException;

		
}

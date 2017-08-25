package br.com.avaliacao.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.avaliacao.dao.EnderecoDAO;
import br.com.avaliacao.dao.PessoaDAO;
import br.com.avaliacao.facade.PessoaFacede;
import br.com.avaliacao.model.Pessoa;


@Stateless
public class PessoaFacadeImpl implements PessoaFacede {


	@EJB
	private PessoaDAO pessoaDAO;
	@EJB
	private EnderecoDAO enderecoDAO;
	
	@Override
	public void save(Pessoa Pessoa) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Pessoa update(Pessoa Pessoa) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Pessoa Pessoa) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Pessoa find(Long Pessoa) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Pessoa> findAll() {
		return pessoaDAO.getList();
	}

	
}

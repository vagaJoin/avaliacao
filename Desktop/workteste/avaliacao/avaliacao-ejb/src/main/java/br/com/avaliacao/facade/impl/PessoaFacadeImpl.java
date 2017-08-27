package br.com.avaliacao.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.avaliacao.dao.EnderecoDAO;
import br.com.avaliacao.dao.PessoaDAO;
import br.com.avaliacao.exception.AvaliacaoAcessoADadosException;
import br.com.avaliacao.exception.AvaliacaoException;
import br.com.avaliacao.exception.AvaliacaoFacadeException;
import br.com.avaliacao.exception.RgJaCadastradoException;
import br.com.avaliacao.facade.PessoaFacede;
import br.com.avaliacao.model.Endereco;
import br.com.avaliacao.model.Pessoa;

@Stateless
public class PessoaFacadeImpl implements PessoaFacede {

	static final Logger logger = LogManager.getLogger(PessoaFacadeImpl.class);

	@EJB
	private PessoaDAO pessoaDAO;
	@EJB
	private EnderecoDAO enderecoDAO;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Pessoa pessoa) throws AvaliacaoException {
		try {
			this.verificaRgJaCadastrado(pessoa);
			enderecoDAO.salvar(pessoa.getEndereco());
			pessoaDAO.salvar(pessoa);
		} catch (AvaliacaoAcessoADadosException e) {
			throw new AvaliacaoAcessoADadosException();
		} catch (RgJaCadastradoException e) {
			throw new RgJaCadastradoException();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new AvaliacaoFacadeException();
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Pessoa atualizar(Pessoa pessoa) throws AvaliacaoException {
		try {
			Pessoa pessoaSalva = encontrar(pessoa.getPessoaId());
			if (pessoaSalva.getRg() != null && !pessoaSalva.getRg().equals(pessoa.getRg()))
				verificaRgJaCadastrado(pessoa);
			this.atualizarEndereco(pessoa.getEndereco());
			BeanUtils.copyProperties(pessoaSalva, pessoa);
			if (pessoa.getTipoPessoa().equals("J")) pessoa.setRg(null);
			return pessoaDAO.atualizar(pessoa);
		} catch (AvaliacaoAcessoADadosException e) {
			throw new AvaliacaoAcessoADadosException();
		} catch (RgJaCadastradoException e) {
			throw new RgJaCadastradoException();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new AvaliacaoFacadeException();
		}

	}

	private void atualizarEndereco(Endereco endereco) throws AvaliacaoException {
		try {
			Endereco enderecoSalvo = enderecoDAO.encontrar(endereco.getIdEndereco());
			BeanUtils.copyProperties(enderecoSalvo, endereco);
			enderecoDAO.atualizar(endereco);
		} catch (AvaliacaoAcessoADadosException e) {
			throw new AvaliacaoAcessoADadosException();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoFacadeException();
		}

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Long id) throws AvaliacaoException {
		try {
			pessoaDAO.remover(id);
		} catch (AvaliacaoAcessoADadosException e) {
			throw new AvaliacaoAcessoADadosException();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoFacadeException();
		}
	}

	@Override
	public Pessoa encontrar(Long id) throws AvaliacaoException {
		try {
			return pessoaDAO.encontrar(id);
		} catch (AvaliacaoAcessoADadosException e) {
			throw new AvaliacaoAcessoADadosException();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoFacadeException();
		}
	}

	@Override
	public List<Pessoa> getList() throws AvaliacaoException {
		try {
			return pessoaDAO.getList();
		} catch (AvaliacaoAcessoADadosException e) {
			throw new AvaliacaoAcessoADadosException();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoFacadeException();
		}
	}
	
	private void verificaRgJaCadastrado(Pessoa pessoa) throws AvaliacaoException {
		pessoaDAO.verificaRgJaCadastrado(pessoa);
	}

}

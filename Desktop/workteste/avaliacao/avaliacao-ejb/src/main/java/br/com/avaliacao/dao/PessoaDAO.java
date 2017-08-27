package br.com.avaliacao.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.avaliacao.exception.AvaliacaoException;
import br.com.avaliacao.exception.RgJaCadastradoException;
import br.com.avaliacao.model.Pessoa;


@Stateless
public class PessoaDAO extends GenericDAO<Pessoa,Long> {
	
	public PessoaDAO() {
		super(Pessoa.class);
	}

	public void verificaRgJaCadastrado(Pessoa pessoa) throws AvaliacaoException{
		Map<String, Object> parametersMap = new HashMap<>();
		parametersMap.put("rg", pessoa.getRg());
		List<Pessoa> pessoasList = super.executeNamedQuery(Pessoa.FIND_BY_RG, parametersMap);
		if (pessoasList != null && !pessoasList.isEmpty()) throw new RgJaCadastradoException();
	}
}
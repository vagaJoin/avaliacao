package br.com.avaliacao.manegedbaen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.com.avaliacao.exception.AvaliacaoException;
import br.com.avaliacao.facade.PessoaFacede;
import br.com.avaliacao.model.Endereco;
import br.com.avaliacao.model.Pessoa;
import br.com.avaliacao.util.UfUtil;

@ManagedBean(name = "pessoaMB")
@ViewScoped
public class PessoaMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_PF = "F";
	private static final String MSG_EXC_SUECESSO = "Pessoa Excluida com Sucesso";
	private static final String MSG_ATL_SUCESSO = "Pessoa Atualizada com Sucesso";
	private static final String MSG_CAD_SUCESSO = "Pessoa Cadastrada com Sucesso";

	@Inject
	private PessoaFacede pessoaFacede;

	private Pessoa pessoa;
	private List<Pessoa> pessoasList = new ArrayList<>();
	private List<SelectItem> ufList;
	private boolean alteracao;
	private String rgString;

	@PostConstruct
	public void ini() {
		try {
			this.pessoa = new Pessoa();
			this.pessoa.setEndereco(new Endereco());
			this.pessoa.setTipoPessoa(DEFAULT_PF);
			this.ufList = UfUtil.getUfList();
			this.pessoasList = pessoaFacede.getList();
			alteracao = false;
			rgString = "";
		} catch (AvaliacaoException e) {
			menssagemErro(e.getMessage());
		}

	}

	public void cadastrar() {
		try {
			setRgPessoaFisica();
			this.pessoaFacede.salvar(pessoa);
		} catch (AvaliacaoException e) {
			menssagemErro(e.getMessage());
			return;
		}
		super.menssagemSucesso(MSG_CAD_SUCESSO);
		this.ini();
	}

	private void setRgPessoaFisica() {
		if (pessoa.getTipoPessoa().equals("F") && rgString != null && !rgString.equals("")) {
			pessoa.setRg(new Integer(rgString.replaceAll("[^0-9]", "")));
		}
	}

	public void alterar() {
		try {
			this.pessoaFacede.atualizar(pessoa);
		} catch (AvaliacaoException e) {
			menssagemErro(e.getMessage());
			return;
		}
		super.menssagemSucesso(MSG_ATL_SUCESSO);
		this.ini();
	}

	public void excluir(Pessoa pessoa) {
		try {
			this.pessoaFacede.remover(pessoa.getPessoaId());
		} catch (AvaliacaoException e) {
			menssagemErro(e.getMessage());
			return;
		}
		super.menssagemSucesso(MSG_EXC_SUECESSO);
		this.ini();
	}

	public void editar(Long id) {
		try {
			this.alteracao = true;
			this.pessoa = pessoaFacede.encontrar(id);
			this.rgString = pessoa.getRg() != null ? pessoa.getRg().toString() : null;
		} catch (AvaliacaoException e) {
			menssagemErro(e.getMessage());
			return;
		}
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

	public List<Pessoa> getPessoasList() {
		return pessoasList;
	}

	public void setPessoasList(List<Pessoa> pessoasList) {
		this.pessoasList = pessoasList;
	}

	public List<SelectItem> getUfList() {
		return ufList;
	}

	public void setUfList(List<SelectItem> ufList) {
		this.ufList = ufList;
	}

	public boolean isAlteracao() {
		return alteracao;
	}

	public void setAlteracao(boolean alteracao) {
		this.alteracao = alteracao;
	}

	public String getRgString() {
		return rgString;
	}

	public void setRgString(String rgString) {
		this.rgString = rgString;
	}

}

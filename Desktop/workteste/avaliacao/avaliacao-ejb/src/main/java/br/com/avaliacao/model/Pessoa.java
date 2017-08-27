package br.com.avaliacao.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 *  mapeamento da tabela pessoa
 * 
 * @author francisco.alves
 *
 */

@NamedQuery(name="pessoa.FIND_BY_RG",query="select p from pessoa p where p.rg =:rg ")

@Entity(name="pessoa")
public class Pessoa implements Serializable {
	
	public static final String FIND_BY_RG = "pessoa.FIND_BY_RG";
	
	private static final long serialVersionUID = -8445304740109741899L;

	@Id
	@Column(name="pessoa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pessoaId;
	
	@Column(name="tipo_pessoa",length=1,nullable=false)
	private String tipoPessoa;
	
	@Column(name="nome_razao",length=225,nullable=false)
	private String nomeRazao;
	
	@Column(name="dt_nasc_fundacao",nullable=false)
	private Date dtNascFundacao;
	
	@Column(name="rg",nullable=true)
	private Integer rg;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNomeRazao() {
		return nomeRazao;
	}

	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}

	public Date getDtNascFundacao() {
		return dtNascFundacao;
	}

	public void setDtNascFundacao(Date dtNascFundacao) {
		this.dtNascFundacao = dtNascFundacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtNascFundacao == null) ? 0 : dtNascFundacao.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nomeRazao == null) ? 0 : nomeRazao.hashCode());
		result = prime * result + ((pessoaId == null) ? 0 : pessoaId.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (dtNascFundacao == null) {
			if (other.dtNascFundacao != null)
				return false;
		} else if (!dtNascFundacao.equals(other.dtNascFundacao))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nomeRazao == null) {
			if (other.nomeRazao != null)
				return false;
		} else if (!nomeRazao.equals(other.nomeRazao))
			return false;
		if (pessoaId == null) {
			if (other.pessoaId != null)
				return false;
		} else if (!pessoaId.equals(other.pessoaId))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (tipoPessoa == null) {
			if (other.tipoPessoa != null)
				return false;
		} else if (!tipoPessoa.equals(other.tipoPessoa))
			return false;
		return true;
	}

	
	
	
	
	

}